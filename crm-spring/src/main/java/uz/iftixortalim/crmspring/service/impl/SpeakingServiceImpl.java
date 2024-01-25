package uz.iftixortalim.crmspring.service.impl;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import uz.iftixortalim.crmspring.dto.SpeakingDTO;
import uz.iftixortalim.crmspring.dto.response.ApiResponse;
import uz.iftixortalim.crmspring.dto.response.Response;
import uz.iftixortalim.crmspring.dto.response.ResponseFile;
import uz.iftixortalim.crmspring.exception.NotFoundException;
import uz.iftixortalim.crmspring.mapper.SpeakingMapper;
import uz.iftixortalim.crmspring.model.Speaking;
import uz.iftixortalim.crmspring.model.User;
import uz.iftixortalim.crmspring.repository.SpeakingRepository;
import uz.iftixortalim.crmspring.repository.TopicRepository;
import uz.iftixortalim.crmspring.service.SpeakingService;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpeakingServiceImpl implements SpeakingService {
    private final TopicRepository topicRepository;
    private final SpeakingRepository speakingRepository;
    private final SpeakingMapper speakingMapper;

    @Override
    public ResponseEntity<ApiResponse> save(MultipartFile file, Long topicId) {
        Response response = uploadFile(file);
        Speaking speaking = new Speaking();
        speaking.setTopic(topicRepository.findById(topicId).orElseThrow(() -> new NotFoundException("Savol topilmadi")));
        speaking.setLikes(0L);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        speaking.setSpeaker(user);
        speaking.setAudioPath(response.getFileUrl());
        speakingRepository.save(speaking);
        return ResponseEntity.ok(ApiResponse.builder().message(speaking.getAudioPath()).status(201).success(true).build());
    }

    @Override
    public ResponseEntity<List<SpeakingDTO>> getPopular() {
        List<SpeakingDTO> list =
//                speakingRepository.findAllByLikesGreaterThan(0L)
                speakingRepository.findAll()
                .stream().map(speakingMapper::toDto).toList();
        return ResponseEntity.ok(list);
    }



    private Response uploadFile(MultipartFile file){
        String apiUrl = "https://api.bytescale.com/v2/accounts/FW25bs8/uploads/form_data";

        WebClient webClient = WebClient.create();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("Authorization", "Bearer secret_FW25bs889d2QWwK9NwqCV5Gpc8MG");

        byte[] fileContent;
        try {
            fileContent = file.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayResource fileResource = new ByteArrayResource(fileContent) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }
        };

        String response = webClient.post()
                .uri(apiUrl)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .body(BodyInserters.fromMultipartData("file", fileResource))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        Gson gson = new Gson();
        ResponseFile responseFile = gson.fromJson(response, ResponseFile.class);
        return responseFile.getFiles().get(responseFile.getFiles().size()-1);
    }
}

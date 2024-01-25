package uz.iftixortalim.crmspring.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import uz.iftixortalim.crmspring.dto.SpeakingDTO;
import uz.iftixortalim.crmspring.dto.response.ApiResponse;
import uz.iftixortalim.crmspring.model.Topic;

import java.util.List;

public interface SpeakingService {
    ResponseEntity<ApiResponse> save(MultipartFile file, Long topicId);

    ResponseEntity<List<SpeakingDTO>> getPopular();
}

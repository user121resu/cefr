package uz.iftixortalim.crmspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.iftixortalim.crmspring.dto.SpeakingDTO;
import uz.iftixortalim.crmspring.dto.response.ApiResponse;
import uz.iftixortalim.crmspring.model.Speaking;
import uz.iftixortalim.crmspring.model.Topic;
import uz.iftixortalim.crmspring.service.SpeakingService;
import uz.iftixortalim.crmspring.service.TopicService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speaking")
@RequiredArgsConstructor
public class SpeakingController {
    private final SpeakingService speakingService;

    @PostMapping("/save/{topicId}")
    public ResponseEntity<ApiResponse> saveSpeaking(@RequestPart("file") MultipartFile file, @PathVariable Long topicId){
        return speakingService.save(file,topicId);
    }

    @GetMapping("/get-popular")
    public ResponseEntity<List<SpeakingDTO>> getPopular(){
        return speakingService.getPopular();
    }
}

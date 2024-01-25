package uz.iftixortalim.crmspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.iftixortalim.crmspring.model.Topic;
import uz.iftixortalim.crmspring.service.TopicService;

@RestController
@RequestMapping("/api/v1/topic")
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @GetMapping("/random")
    public ResponseEntity<Topic> getRandomTopic(){
        return topicService.getRandomTopic();
    }
}

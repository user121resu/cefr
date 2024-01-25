package uz.iftixortalim.crmspring.service;

import org.springframework.http.ResponseEntity;
import uz.iftixortalim.crmspring.model.Topic;

public interface TopicService {
    ResponseEntity<Topic> getRandomTopic();
}

package uz.iftixortalim.crmspring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.iftixortalim.crmspring.exception.NotFoundException;
import uz.iftixortalim.crmspring.model.Topic;
import uz.iftixortalim.crmspring.repository.TopicRepository;
import uz.iftixortalim.crmspring.service.TopicService;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;

    @Override
    public ResponseEntity<Topic> getRandomTopic() {
        Random random = new Random();
        long rand = random.nextLong(topicRepository.count())+1;
        System.out.println(rand);
        Topic topic = topicRepository.findById(rand).orElseThrow(() -> new NotFoundException("Savol topilmadi"));
        return ResponseEntity.ok(topic);
    }
}

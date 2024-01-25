package uz.iftixortalim.crmspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.iftixortalim.crmspring.model.Speaking;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpeakingRepository extends JpaRepository<Speaking,Long> {
    Optional<Speaking> findBySpeakerId(Long id);
    List<Speaking> findByTopicId(Long id);
    List<Speaking> findAllByLikesGreaterThan(Long likesCount);

}

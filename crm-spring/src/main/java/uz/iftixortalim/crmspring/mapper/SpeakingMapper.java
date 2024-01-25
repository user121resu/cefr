package uz.iftixortalim.crmspring.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.iftixortalim.crmspring.dto.SpeakingDTO;
import uz.iftixortalim.crmspring.model.Speaking;

@Service
@RequiredArgsConstructor
public class SpeakingMapper {
    private final UserMapper userMapper;

    public SpeakingDTO toDto(Speaking speaking){
        if (speaking == null) return null;
        return new SpeakingDTO(
                speaking.getId(),
                speaking.getTopic() == null ? null : speaking.getTopic().getTopic(),
                userMapper.toDto(speaking.getSpeaker()),
                speaking.getAudioPath(),
                speaking.getLikes()
        );
    }
}

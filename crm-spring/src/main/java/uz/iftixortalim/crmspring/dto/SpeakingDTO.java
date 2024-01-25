package uz.iftixortalim.crmspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpeakingDTO {
    private Long id;
    private String topic;
    private UserDTO speaker;
    private String audioPath;
    private Long likes;
}

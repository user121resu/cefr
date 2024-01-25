package uz.iftixortalim.crmspring.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.iftixortalim.crmspring.dto.UserDTO;
import uz.iftixortalim.crmspring.model.User;

@Service
@RequiredArgsConstructor
public class UserMapper {
    public UserDTO toDto(User user){
        return user == null ? null : new UserDTO(
                user.getId(),
                user.getUsername(),
                "",
                user.getFullName(),
                user.getCreatedAt(),
                user.getRole()
        );
    }
}

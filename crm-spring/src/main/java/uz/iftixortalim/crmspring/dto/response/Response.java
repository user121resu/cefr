package uz.iftixortalim.crmspring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String formDataFieldName;
    private String accountId;
    private String filePath;
    private String fileUrl;
}

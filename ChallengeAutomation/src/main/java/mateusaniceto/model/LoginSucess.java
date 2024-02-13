package mateusaniceto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginSucess {
    private Integer id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String image;
    private String token;
}

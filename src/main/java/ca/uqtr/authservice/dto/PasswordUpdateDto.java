package ca.uqtr.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordUpdateDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String email;
    private String password;
    private Boolean accountEnabled;
    private Boolean emailExist;
    private Boolean passwordUpdated;
    private String errorMessage;
}

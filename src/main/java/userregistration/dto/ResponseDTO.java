package userregistration.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import userregistration.model.User;

@Setter
@Getter
@ToString
public class ResponseDTO {
    String message;
    User object;

    public ResponseDTO(String message, User object) {
        this.message = message;
        this.object = object;
    }
}

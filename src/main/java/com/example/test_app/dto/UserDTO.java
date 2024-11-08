package com.example.test_app.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private  Long id;
    private String name;
    private String email;
    private boolean active;
}

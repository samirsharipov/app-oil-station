package com.sigma.appoilstation.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String firstname;

    private String lastname;

    private Integer age;

    private boolean active = false;
}

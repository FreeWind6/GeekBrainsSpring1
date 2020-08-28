package ru.geekbrains.sample.dto.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.sample.persistence.enums.Role;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopuserDTO {
    private String login;
    private String password;
    private String firstName;
    @Enumerated(EnumType.STRING)
    private Role role;
}
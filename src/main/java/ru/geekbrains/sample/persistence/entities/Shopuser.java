package ru.geekbrains.sample.persistence.entities;

import lombok.*;

import ru.geekbrains.sample.persistence.enums.Role;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Shopuser extends AbstractPersistableEntity {

    private String login;

    private String password;

    private String firstName;

    @Enumerated(EnumType.STRING)
    private Role role;

}

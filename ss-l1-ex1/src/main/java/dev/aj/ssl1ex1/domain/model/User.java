package dev.aj.ssl1ex1.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    @Column(name = "email", nullable = false, unique = true)
    private String email;

}

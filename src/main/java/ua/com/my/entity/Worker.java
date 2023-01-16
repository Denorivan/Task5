package ua.com.my.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "workers")
@Data
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "The name field must not be empty")
    private String name;

    @Column(name = "lastname")
    @NotEmpty(message = "The lastname field must not be empty")
    private String lastname;

    @Column(name = "phone")
    @NotEmpty(message = "The phone field must not be empty")
    private String phone;

    @Column(name = "email")
    @NotEmpty(message = "The email field must not be empty")
    private String email;

    @ManyToOne(cascade = { CascadeType.MERGE,CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "branch_id")
    private Branch branch;
}

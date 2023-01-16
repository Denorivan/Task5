package ua.com.my.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name= "Branches")
@Data
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "The name field must not be empty")
    private String name;

    @Column(name = "location")
    @NotEmpty(message = "The location field must not be empty")
    private String location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Branch")
    private Set<Worker> workers;
}

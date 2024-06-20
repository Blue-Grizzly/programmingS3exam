package grizzly.programmings3exam.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String resultType;
    @OneToMany(mappedBy = "discipline")
    @JsonIgnore
    private List<Result> results;
    @ManyToMany
    @JsonIgnore
    private List<Athlete> athletes;
}
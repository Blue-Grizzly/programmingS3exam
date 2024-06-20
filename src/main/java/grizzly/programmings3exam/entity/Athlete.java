package grizzly.programmings3exam.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String gender;
    private Date birthDate;
    private String club;

    @ManyToMany
    private List<Discipline> disciplines;


    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonBackReference
    private List<Result> results;

    public void addResult(Result result) {
        results.add(result);
        result.setAthlete(this);
    }

    public void removeResult(Result result) {
        results.remove(result);
        result.setAthlete(null);
    }

    public void addDiscipline(Discipline discipline) {
        disciplines.add(discipline);
    }

    public void removeDiscipline(Discipline discipline) {
        disciplines.remove(discipline);
        discipline.getAthletes().remove(this);
    }
}
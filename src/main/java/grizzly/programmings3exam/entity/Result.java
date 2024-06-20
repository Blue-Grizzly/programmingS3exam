package grizzly.programmings3exam.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String resultType;
    private String resultValue;
    private String date;
    @ManyToOne
    @JoinColumn(name = "athlete_id", referencedColumnName = "id")
    private Athlete athlete;
    @ManyToOne
    private Discipline discipline;
}
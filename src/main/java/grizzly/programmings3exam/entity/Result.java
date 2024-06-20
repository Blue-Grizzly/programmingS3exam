package grizzly.programmings3exam.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    public void setAthlete(Athlete athlete) {
        if (this.athlete != null) {
            this.athlete.getResults().remove(this);
        }
        this.athlete = athlete;
        if (athlete != null) {
            athlete.getResults().add(this);
        }
    }
}
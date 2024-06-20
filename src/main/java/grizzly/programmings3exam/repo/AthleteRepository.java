package grizzly.programmings3exam.repo;

import grizzly.programmings3exam.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
}

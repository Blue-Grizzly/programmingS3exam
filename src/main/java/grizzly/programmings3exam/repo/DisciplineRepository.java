package grizzly.programmings3exam.repo;

import grizzly.programmings3exam.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {
}

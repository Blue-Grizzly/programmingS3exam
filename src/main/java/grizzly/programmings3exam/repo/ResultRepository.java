package grizzly.programmings3exam.repo;

import grizzly.programmings3exam.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResultRepository extends JpaRepository<Result, Integer> {
}

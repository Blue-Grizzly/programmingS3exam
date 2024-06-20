package grizzly.programmings3exam.service;

import grizzly.programmings3exam.Dto.ResultDto;
import grizzly.programmings3exam.entity.Athlete;
import grizzly.programmings3exam.entity.Result;
import grizzly.programmings3exam.repo.AthleteRepository;
import grizzly.programmings3exam.repo.DisciplineRepository;
import grizzly.programmings3exam.repo.ResultRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ResultService {
final ResultRepository resultRepository;
final AthleteRepository athleteRepository;
final DisciplineRepository disciplineRepository;

    public ResultService(ResultRepository resultRepository, AthleteRepository athleteRepository, DisciplineRepository disciplineRepository) {
        this.resultRepository = resultRepository;
        this.athleteRepository = athleteRepository;
        this.disciplineRepository = disciplineRepository;
    }

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    public Result getResultById(int id) {
        return resultRepository.findById(id).orElseThrow(()->new RuntimeException("No result found with provided id"));
    }


@Transactional
    public Result addResult(ResultDto result) {
        Result newResult = new Result();
        Athlete athlete = athleteRepository.findById(result.getAthleteId()).orElseThrow(()->new RuntimeException("No athlete found with provided id"));
        athlete.addResult(newResult);
        newResult.setAthlete(athlete); // Set the Athlete in the Result
        changeResult(newResult, result);
        return resultRepository.save(newResult);
    }
    public void changeResult(Result original, ResultDto result) {
        original.setDiscipline(disciplineRepository.findById(result.getDisciplineId()).orElseThrow(()->new RuntimeException("No discipline found with provided id")));
        original.setResultType(result.getResultType());
        original.setResultValue(result.getResultValue());
        original.setDate(result.getDate());
    }

    public Result updateResult(ResultDto result, int id) {
        Result existingResult = resultRepository.findById(id).orElseThrow(()->new RuntimeException("No result found with provided id"));
        changeResult(existingResult, result);
        return resultRepository.save(existingResult);
    }

    public void deleteResult(int id) {
        resultRepository.findById(id).orElseThrow(()->new RuntimeException("No result found with provided id"));
        resultRepository.deleteById(id);
    }

}


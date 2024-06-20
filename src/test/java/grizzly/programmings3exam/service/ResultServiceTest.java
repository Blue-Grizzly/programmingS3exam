package grizzly.programmings3exam.service;

import grizzly.programmings3exam.Dto.ResultDto;
import grizzly.programmings3exam.entity.Athlete;
import grizzly.programmings3exam.entity.Discipline;
import grizzly.programmings3exam.entity.Result;
import grizzly.programmings3exam.repo.AthleteRepository;
import grizzly.programmings3exam.repo.DisciplineRepository;
import grizzly.programmings3exam.repo.ResultRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ResultServiceTest {

    @InjectMocks
    ResultService resultService;

    @Mock
    ResultRepository resultRepository;

    @Mock
    AthleteRepository athleteRepository;

    @Mock
    DisciplineRepository disciplineRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllResults() {
        Result result1 = new Result();
        Result result2 = new Result();
        when(resultRepository.findAll()).thenReturn(Arrays.asList(result1, result2));

        assertEquals(2, resultService.getAllResults().size());
    }

    @Test
    void getResultById() {
        Result result = new Result();
        when(resultRepository.findById(1)).thenReturn(Optional.of(result));

        assertEquals(result, resultService.getResultById(1));
    }

    @Test
    void addResult() {
        ResultDto resultDto = new ResultDto();
        Result result = new Result();
        Athlete athlete = new Athlete();
        athlete.setDisciplines(new ArrayList<>());
        athlete.setResults(new ArrayList<>());
        Discipline discipline = new Discipline();
        when(athleteRepository.findById(anyInt())).thenReturn(Optional.of(athlete));
        when(disciplineRepository.findById(anyInt())).thenReturn(Optional.of(discipline));
        when(resultRepository.save(any(Result.class))).thenReturn(result);

        assertEquals(result, resultService.addResult(resultDto));
    }

    @Test
    void updateResult() {
        ResultDto resultDto = new ResultDto();
        resultDto.setDisciplineId(1);
        resultDto.setAthleteId(1);
        Result result = new Result();
        when(resultRepository.findById(1)).thenReturn(Optional.of(result));
        when(disciplineRepository.findById(1)).thenReturn(Optional.of(new Discipline()));
        when(athleteRepository.findById(1)).thenReturn(Optional.of(new Athlete()));
        when(resultRepository.save(any(Result.class))).thenReturn(result);

        assertEquals(result, resultService.updateResult(resultDto, 1));
    }

    @Test
    void deleteResult() {
        Result result = new Result();
        when(resultRepository.findById(1)).thenReturn(Optional.of(result));

        resultService.deleteResult(1);

        verify(resultRepository, times(1)).deleteById(1);
    }

    @Test
    void getResultByIdNotFound() {
        when(resultRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> resultService.getResultById(1));
    }

    @Test
    void addResultAthleteNotFound() {
        ResultDto resultDto = new ResultDto();
        when(athleteRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> resultService.addResult(resultDto));
    }

    @Test
    void addResultDisciplineNotFound() {
        ResultDto resultDto = new ResultDto();
        Athlete athlete = new Athlete();
        when(athleteRepository.findById(anyInt())).thenReturn(Optional.of(athlete));
        when(disciplineRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> resultService.addResult(resultDto));
    }

    @Test
    void updateResultNotFound() {
        ResultDto resultDto = new ResultDto();
        when(resultRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> resultService.updateResult(resultDto, 1));
    }

    @Test
    void deleteResultNotFound() {
        when(resultRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> resultService.deleteResult(1));
    }
}
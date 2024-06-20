package grizzly.programmings3exam.service;

import grizzly.programmings3exam.entity.Athlete;
import grizzly.programmings3exam.repo.AthleteRepository;
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

class AthleteServiceTest {

    @InjectMocks
    AthleteService athleteService;

    @Mock
    AthleteRepository athleteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllAthletes() {
        Athlete athlete1 = new Athlete();
        Athlete athlete2 = new Athlete();
        when(athleteRepository.findAll()).thenReturn(Arrays.asList(athlete1, athlete2));

        assertEquals(2, athleteService.getAllAthletes().size());
    }

    @Test
    void getAthleteById() {
        Athlete athlete = new Athlete();
        when(athleteRepository.findById(1)).thenReturn(Optional.of(athlete));

        assertEquals(athlete, athleteService.getAthleteById(1));
    }

    @Test
    void addAthlete() {
        Athlete athlete = new Athlete();
        athlete.setDisciplines(new ArrayList<>());
        when(athleteRepository.save(any(Athlete.class))).thenReturn(athlete);

        assertEquals(athlete, athleteService.addAthlete(athlete));
    }

    @Test
    void updateAthlete() {
        Athlete athlete = new Athlete();
        athlete.setDisciplines(new ArrayList<>());
        when(athleteRepository.findById(1)).thenReturn(Optional.of(athlete));
        when(athleteRepository.save(any(Athlete.class))).thenReturn(athlete);

        assertEquals(athlete, athleteService.updateAthlete(athlete, 1));
    }

    @Test
    void deleteAthlete() {
        Athlete athlete = new Athlete();
        when(athleteRepository.findById(1)).thenReturn(Optional.of(athlete));

        athleteService.deleteAthlete(1);

        verify(athleteRepository, times(1)).deleteById(1);
    }

    @Test
    void getAthleteByIdNotFound() {
        when(athleteRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> athleteService.getAthleteById(1));
    }

    @Test
    void addAthleteNull() {
        Athlete athlete = null;

        assertThrows(RuntimeException.class, () -> athleteService.addAthlete(athlete));
    }

    @Test
    void updateAthleteNotFound() {
        Athlete athlete = new Athlete();
        when(athleteRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> athleteService.updateAthlete(athlete, 1));
    }

    @Test
    void deleteAthleteNotFound() {
        when(athleteRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> athleteService.deleteAthlete(1));
    }
}
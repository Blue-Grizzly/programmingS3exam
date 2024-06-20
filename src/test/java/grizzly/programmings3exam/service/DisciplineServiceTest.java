package grizzly.programmings3exam.service;

import grizzly.programmings3exam.entity.Discipline;
import grizzly.programmings3exam.repo.DisciplineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class DisciplineServiceTest {

    @InjectMocks
    DisciplineService disciplineService;

    @Mock
    DisciplineRepository disciplineRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllDisciplines() {
        Discipline discipline1 = new Discipline();
        Discipline discipline2 = new Discipline();
        when(disciplineRepository.findAll()).thenReturn(Arrays.asList(discipline1, discipline2));

        assertEquals(2, disciplineService.getAllDisciplines().size());
    }

    @Test
    void getDisciplineById() {
        Discipline discipline = new Discipline();
        when(disciplineRepository.findById(1)).thenReturn(Optional.of(discipline));

        assertEquals(discipline, disciplineService.getDisciplineById(1));
    }

    @Test
    void addDiscipline() {
        Discipline discipline = new Discipline();
        when(disciplineRepository.save(any(Discipline.class))).thenReturn(discipline);

        assertEquals(discipline, disciplineService.addDiscipline(discipline));
    }

    @Test
    void updateDiscipline() {
        Discipline discipline = new Discipline();
        when(disciplineRepository.findById(1)).thenReturn(Optional.of(discipline));
        when(disciplineRepository.save(any(Discipline.class))).thenReturn(discipline);

        assertEquals(discipline, disciplineService.updateDiscipline(discipline, 1));
    }

    @Test
    void deleteDiscipline() {
        Discipline discipline = new Discipline();
        when(disciplineRepository.findById(1)).thenReturn(Optional.of(discipline));

        disciplineService.deleteDiscipline(1);

        verify(disciplineRepository, times(1)).deleteById(1);
    }

    @Test
    void getDisciplineByIdNotFound() {
        when(disciplineRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> disciplineService.getDisciplineById(1));
    }

    @Test
    void addDisciplineNull() {
        Discipline discipline = null;

        assertThrows(RuntimeException.class, () -> disciplineService.addDiscipline(discipline));
    }

    @Test
    void updateDisciplineNotFound() {
        Discipline discipline = new Discipline();
        when(disciplineRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> disciplineService.updateDiscipline(discipline, 1));
    }

    @Test
    void deleteDisciplineNotFound() {
        when(disciplineRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> disciplineService.deleteDiscipline(1));
    }
}
package grizzly.programmings3exam.service;

import grizzly.programmings3exam.entity.Discipline;
import grizzly.programmings3exam.repo.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {
    final DisciplineRepository disciplineRepository;

    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAll();
    }

    public Discipline getDisciplineById(int id) {
        return disciplineRepository.findById(id).orElseThrow(()->new RuntimeException("No discipline found with provided id"));
    }

    public Discipline addDiscipline(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    public Discipline updateDiscipline(Discipline discipline, int id) {
        Discipline existingDiscipline = disciplineRepository.findById(id).orElseThrow(()->new RuntimeException("No discipline found with provided id"));
        existingDiscipline.setName(discipline.getName());
        existingDiscipline.setResultType(discipline.getResultType());
        return disciplineRepository.save(existingDiscipline);
    }

    public void deleteDiscipline(int id) {
        disciplineRepository.findById(id).orElseThrow(()->new RuntimeException("No discipline found with provided id"));
        disciplineRepository.deleteById(id);
    }

}

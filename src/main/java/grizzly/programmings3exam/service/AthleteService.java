package grizzly.programmings3exam.service;

import grizzly.programmings3exam.entity.Athlete;
import grizzly.programmings3exam.entity.Discipline;
import grizzly.programmings3exam.repo.AthleteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AthleteService {
    final AthleteRepository athleteRepository;

    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }

    public Athlete getAthleteById(int id) {
        return athleteRepository.findById(id).orElseThrow(()->new RuntimeException("No athlete found with provided id"));
    }

    public Athlete addAthlete(Athlete athlete) {
        Athlete newAthlete = new Athlete();
        List<Discipline> list = new ArrayList();
        newAthlete.setDisciplines(list);
        changeAthlete(newAthlete, athlete);
        return athleteRepository.save(newAthlete);
    }

    private void changeAthlete(Athlete original, Athlete athlete) {
        if(original.getDisciplines() != null && !original.getDisciplines().isEmpty()){
            for (int i = 0; i < original.getDisciplines().size(); i++) {
                original.removeDiscipline(original.getDisciplines().get(i));
            }
        }
        original.setName(athlete.getName());
        original.setGender(athlete.getGender());
        original.setBirthDate(athlete.getBirthDate());
        original.setClub(athlete.getClub());
        for (int i = 0; i < athlete.getDisciplines().size(); i++) {
         original.addDiscipline(athlete.getDisciplines().get(i));
        }
    }


    public Athlete updateAthlete(Athlete athlete, int id) {
        Athlete existingAthlete = athleteRepository.findById(id).orElseThrow(()->new RuntimeException("No athlete found with provided id"));
        changeAthlete(existingAthlete, athlete);
        return athleteRepository.save(existingAthlete);
    }

    public void deleteAthlete(int id) {
        athleteRepository.findById(id).orElseThrow(()->new RuntimeException("No athlete found with provided id"));
        athleteRepository.deleteById(id);
    }


}

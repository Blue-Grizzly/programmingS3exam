package grizzly.programmings3exam.controller;

import grizzly.programmings3exam.entity.Athlete;
import grizzly.programmings3exam.service.AthleteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/athletes")
public class AthleteController {
    final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping
    public ResponseEntity getAllAthletes() {
        try {
            return new ResponseEntity<>(athleteService.getAllAthletes(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getAthleteById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(athleteService.getAthleteById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity addAthlete(@RequestBody Athlete athlete) {
        try {
            return new ResponseEntity<>(athleteService.addAthlete(athlete), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateAthlete(@PathVariable int id, @RequestBody Athlete athlete) {
        try {
            return new ResponseEntity<>(athleteService.updateAthlete(athlete, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteAthlete(@PathVariable int id) {
        try {
            athleteService.deleteAthlete(id);
            return new ResponseEntity<>("Success!",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}

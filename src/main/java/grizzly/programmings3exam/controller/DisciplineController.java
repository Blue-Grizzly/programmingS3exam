package grizzly.programmings3exam.controller;

import grizzly.programmings3exam.entity.Discipline;
import grizzly.programmings3exam.service.DisciplineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {
    final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public ResponseEntity getAllDisciplines() {
        try {
            return new ResponseEntity<>(disciplineService.getAllDisciplines(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getDisciplineById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(disciplineService.getDisciplineById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity addDiscipline(@RequestBody Discipline discipline) {
        try {
            return new ResponseEntity<>(disciplineService.addDiscipline(discipline), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateDiscipline(@PathVariable int id, @RequestBody Discipline discipline) {
        try {
            return new ResponseEntity<>(disciplineService.updateDiscipline(discipline, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteDiscipline(@PathVariable int id) {
        try {
            disciplineService.deleteDiscipline(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}

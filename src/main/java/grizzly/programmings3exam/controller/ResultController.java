package grizzly.programmings3exam.controller;

import grizzly.programmings3exam.Dto.ResultDto;
import grizzly.programmings3exam.service.ResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/results")
public class ResultController {
    final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public ResponseEntity getAllResults() {
        try {
            return new ResponseEntity<>(resultService.getAllResults(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getResultById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(resultService.getResultById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateResult(@PathVariable int id, @RequestBody ResultDto result) {
        try {
            return new ResponseEntity<>(resultService.updateResult(result, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity addResult(@RequestBody ResultDto result) {
        try {
            return new ResponseEntity<>(resultService.addResult(result), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteResult(@PathVariable int id) {
        try {
            resultService.deleteResult(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}

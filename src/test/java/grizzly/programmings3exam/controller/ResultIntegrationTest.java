package grizzly.programmings3exam.controller;

import grizzly.programmings3exam.Dto.ResultDto;
import grizzly.programmings3exam.entity.Athlete;
import grizzly.programmings3exam.entity.Discipline;
import grizzly.programmings3exam.entity.Result;
import grizzly.programmings3exam.service.AthleteService;
import grizzly.programmings3exam.service.DisciplineService;
import grizzly.programmings3exam.service.ResultService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ResultIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ResultService resultService;

    @Autowired
    private AthleteService athleteService;

    @Autowired
    private DisciplineService disciplineService;

    @Test
    public void getAllResults() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/results")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void getResultById() throws Exception {
        Result result = new Result();
        result.setId(1);
        result.setResultType("Time");
        result.setResultValue("10.0");
        result.setDate("2021-01-01");

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/results/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    @Test
    public void addResult() throws Exception {
        Athlete athlete = new Athlete();
        athlete.setId(1);
        athlete.setName("John Doe");
        athlete.setClub("Club");
        athlete.setBirthDate(new Date());
        athlete.setGender("Male");
        athleteService.addAthlete(athlete);

        Discipline discipline = new Discipline();
        discipline.setId(1);
        discipline.setName("Discipline");
        discipline.setResultType("Time");
        disciplineService.addDiscipline(discipline);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/results")
                        .content("{\"disciplineId\":1,\"athleteId\":1,\"resultType\":\"Time\",\"resultValue\":\"10.0\",\"date\":\"2021-01-01\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated());
    }

    @Test
    public void updateResult() throws Exception {
        ResultDto result = new ResultDto();
        result.setId(1);
        result.setResultType("Time");
        result.setResultValue("10.0");
        result.setDate("2021-01-01");

        Athlete athlete = new Athlete();
        athlete.setId(1);
        athlete.setName("John Doe");
        athlete.setClub("Club");
        athlete.setBirthDate(new Date());
        athlete.setGender("Male");
        athleteService.addAthlete(athlete);

        Discipline discipline = new Discipline();
        discipline.setId(1);
        discipline.setName("Discipline");
        discipline.setResultType("Time");
        disciplineService.addDiscipline(discipline);

        result.setAthleteId(athlete.getId());
        result.setDisciplineId(discipline.getId());

        resultService.addResult(result);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/results/{id}", result.getId())
                        .content("{\"disciplineId\":1,\"athleteId\":1,\"resultType\":\"Time\",\"resultValue\":\"10.0\",\"date\":\"2021-01-01\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    @Test
    public void deleteResult() throws Exception {
        ResultDto result = new ResultDto();
        result.setId(1);
        result.setResultType("Time");
        result.setResultValue("10.0");
        result.setDate("2021-01-01");

        Athlete athlete = new Athlete();
        athlete.setId(1);
        athlete.setName("John Doe");
        athlete.setClub("Club");
        athlete.setBirthDate(new Date());
        athlete.setGender("Male");
        athleteService.addAthlete(athlete);

        Discipline discipline = new Discipline();
        discipline.setId(1);
        discipline.setName("Discipline");
        discipline.setResultType("Time");
        disciplineService.addDiscipline(discipline);

        result.setAthleteId(athlete.getId());
        result.setDisciplineId(discipline.getId());

        resultService.addResult(result);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/results/{id}", result.getId())
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }


}

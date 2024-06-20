package grizzly.programmings3exam.controller;

import grizzly.programmings3exam.entity.Athlete;
import grizzly.programmings3exam.service.AthleteService;
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
public class AthleteIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AthleteService athleteService;

    @Test
    public void getAllAthletes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/athletes")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAthleteById() throws Exception {
        Athlete athlete = new Athlete();
        athlete.setName("John Doe");
        athlete.setClub("Club");
        athlete.setBirthDate(new Date());
        athlete.setGender("Male");
        athlete.setId(1);

        athleteService.addAthlete(athlete);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/athletes/{id}", athlete.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void addAthlete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/athletes")
                        .content("{\"name\":\"John Doe\",\"club\":\"Club\",\"birthDate\":\"2000-01-01\",\"gender\":\"Male\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated());
    }

    @Test void updateAthlete() throws Exception {
        Athlete athlete = new Athlete();
        athlete.setName("John Doe");
        athlete.setClub("Club");
        athlete.setBirthDate(new Date());
        athlete.setGender("Male");
        athlete.setId(2);

        athleteService.addAthlete(athlete);
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/athletes/{id}", athlete.getId())
                        .content("{\"name\":\"John Doe\",\"club\":\"Club\",\"birthDate\":\"2000-01-01\",\"gender\":\"Male\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    @Test
    public void deleteAthlete() throws Exception {
        Athlete athlete = new Athlete();
        athlete.setName("John Doe");
        athlete.setClub("Club");
        athlete.setBirthDate(new Date());
        athlete.setGender("Male");
        athlete.setId(1);
        athleteService.addAthlete(athlete);
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/athletes/{id}", athlete.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
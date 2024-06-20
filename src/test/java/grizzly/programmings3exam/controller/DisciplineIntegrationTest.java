package grizzly.programmings3exam.controller;


import grizzly.programmings3exam.entity.Discipline;
import grizzly.programmings3exam.service.DisciplineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DisciplineIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DisciplineService disciplineService;

    @Test
    public void getAllDisciplines() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/disciplines")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getDisciplineById() throws Exception {
        Discipline discipline = new Discipline();
        discipline.setName("Discipline");
        discipline.setResultType("Time");
        discipline.setId(1);

        disciplineService.addDiscipline(discipline);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/disciplines/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void addDiscipline() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/disciplines")
                        .content("{\"name\":\"Discipline\",\"resultType\":\"Time\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated());
    }

    @Test
    public void updateDiscipline() throws Exception {
        Discipline discipline = new Discipline();
        discipline.setName("Discipline");
        discipline.setResultType("Time");
        discipline.setId(1);

        disciplineService.addDiscipline(discipline);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/disciplines/{id}", 1)
                        .content("{\"name\":\"Discipline\",\"resultType\":\"Time\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    @Test
    public void deleteDiscipline() throws Exception {
        Discipline discipline = new Discipline();
        discipline.setName("Discipline");
        discipline.setResultType("Time");
        discipline.setId(2);

        disciplineService.addDiscipline(discipline);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/disciplines/{id}", discipline.getId())
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

}

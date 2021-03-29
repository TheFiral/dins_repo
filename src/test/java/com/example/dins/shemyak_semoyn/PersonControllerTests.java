package com.example.dins.shemyak_semoyn;

import com.example.dins.shemyak_semoyn.component.ListPerson;
import com.example.dins.shemyak_semoyn.pojo.Person;
import com.example.dins.shemyak_semoyn.servis.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTests {

    @Autowired
    private ListPerson listPerson;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testingPostPerson() throws Exception {
        Person person = new Person("Kat");

        mockMvc.perform(post("/person")
                .content(objectMapper.writeValueAsString(person))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Kat"));
    }

    @Test
    public void testingGetPerson() throws Exception {
        int id = 0;
        Person person = listPerson.getList().get(id);

        mockMvc.perform(get("/person/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(person.getName()));
    }

    @Test
    public void testingPutPerson() throws Exception {
        Person person = createPerson("Night");
        int id = listPerson.getList().indexOf(person);

        mockMvc.perform(put("/person/{id}", id)
                .content(objectMapper.writeValueAsString(createPerson("New Person")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("New Person"));
    }

    @Test
    public void testingDeletePerson() throws Exception {
        Person person = createPerson("Max");
        int id = listPerson.getList().indexOf(person);

        mockMvc.perform(delete("/person/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testingGetAllPerson() throws Exception {
        mockMvc.perform(get("/person"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(listPerson.getList())));
    }

    @Test
    public void testingGetPersonByName() throws Exception {
        String name = "em";
        mockMvc.perform(get("/person/name/{name}", name))
                .andExpect(status().isOk());
    }

    private Person createPerson(String name) {
        Person person = new Person(name, listPerson.createListNumber());
        listPerson.getList().add(person);
        return person;
    }
}

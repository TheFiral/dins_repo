package com.example.dins.shemyak_semoyn;

import com.example.dins.shemyak_semoyn.component.ListPerson;
import com.example.dins.shemyak_semoyn.pojo.Person;
import com.example.dins.shemyak_semoyn.pojo.Phone;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PhoneControllerTests {

    @Autowired
    private ListPerson listPerson;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testingPostPhone() throws Exception {
        int id = listPerson.getList().size() - 1;
        Phone phone = new Phone();

        mockMvc.perform(post("/phone/{id}", id)
                .content(objectMapper.writeValueAsString(phone))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(phone.getNumber()));
    }

    @Test
    public void testingGetPhone() throws Exception {
        int id = listPerson.getList().size() - 1;
        Person person = listPerson.getList().get(id);
        int number = person.getBook().size() - 1;
        Phone phone = person.getBook().get(number);

        mockMvc.perform(get("/phone/{id}/{number}", id, number))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(phone.getNumber()));
    }

    @Test
    public void testingPutPerson() throws Exception {
        int id = listPerson.getList().size() - 1;
        Person person = listPerson.getList().get(id);
        int number = person.getBook().size() - 1;
        Phone phone = new Phone();

        mockMvc.perform(put("/phone/{id}/{number}", id, number)
                .content(objectMapper.writeValueAsString(phone))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(phone.getNumber()));
    }

    @Test
    public void testingDeletePerson() throws Exception {
        int id = listPerson.getList().size() - 1;
        int number = listPerson.getList().get(id).getBook().size() - 1;

        mockMvc.perform(delete("/phone/{id}/{number}", id, number))
                .andExpect(status().isOk());
    }

    @Test
    public void testingGetAllPhone() throws Exception {
        int id = listPerson.getList().size() - 1;

        mockMvc.perform(get("/phone/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(
                        listPerson.getList().get(id).getBook()
                )));
    }

    @Test
    public void testingGetPhoneByNumber() throws Exception {
        Phone phone = new Phone();

        mockMvc.perform(get("/phone//number/{number}", phone.getNumber()))
                .andExpect(status().isOk());
    }
}

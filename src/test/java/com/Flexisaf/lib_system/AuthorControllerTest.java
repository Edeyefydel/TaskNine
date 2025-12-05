package com.Flexisaf.lib_system;

import com.Flexisaf.lib_system.models.Author;
import com.Flexisaf.lib_system.repository.AuthorRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthorRepo authorRepo;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup(){
        authorRepo.deleteAll();
    }

    @Test
    public void TestCreateAuthors() throws Exception{
        Author author = new Author();
        author.setFirst_name("Chinua");
        author.setLast_name("China");

        mockMvc.perform(post("/api/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(author)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Chinua China"));

    }
    @Test
    void testGetAuthors() throws Exception {
        Author author = new Author();
        author.setFirst_name("Chinua");
        author.setLast_name("Achebe");
        authorRepo.save(author);

        mockMvc.perform(get("/api/authors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].first_name").value("Chinua"))
                .andExpect(jsonPath("$[0].last_name").value("Achebe"));
    }

    @Test
    public void TestDeleteAuthors() throws Exception{
        Author author = new Author();
        author.setFirst_name("Chinua");
        author.setLast_name("China");
        Author savedAuthor = authorRepo.save(author);

        mockMvc.perform(delete("/api/authors" + savedAuthor.getAuthor_id()))
                .andExpect(status().isOk());
    }
}

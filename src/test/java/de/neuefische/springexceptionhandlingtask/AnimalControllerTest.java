package de.neuefische.springexceptionhandlingtask;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AnimalControllerTest {

    private final static String BASE_URI = "/api/animals";

    @Autowired
    private MockMvc mockMvc; // Um HTTP-Requests zu simulieren
    @Autowired
    private ObjectMapper objectMapper; // Wandelt JSON in Java Objekte um und umgekehrt

    @Test
    public void testHandleAnimalNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/animals/invalid"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().json("{\"message\":\"Only 'dog' is allowed\"}"));
    }

}

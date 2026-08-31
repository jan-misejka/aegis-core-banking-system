package cz.aegis.corebanking.controller;

import cz.aegis.corebanking.TestDatabaseReset;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ClientControllerTest extends TestDatabaseReset {

    @Autowired
    private MockMvc mockMvc;

    //test na endpoint GET
    @Test
    void shouldReturn404WhenClientDoesNotExist() throws Exception {

        mockMvc.perform(get("/clients/999999"))
                .andExpect(status().isNotFound());
    }

    //test na endpoint PUT
    @Test
    void shouldReturn404WhenUpdatingNonExistingClient() throws Exception {

        mockMvc.perform(put("/clients/999999")
                    .contentType(APPLICATION_JSON)
                    .content("""
                        {
                            "firstName": "Damiano",
                            "lastName": "Annoni",
                            "email": "d.annone@gmail.com",
                            "phoneNumber": "777310612"
                        }
                        """))
                .andExpect(status().isNotFound());
    }

    //test na endpoint DELETE
    @Test
    void shouldReturn404WhenDeletingNonExistingClient() throws Exception {

        mockMvc.perform(delete("/clients/999999"))
                .andExpect(status().isNotFound());
    }

    //test na invalid input data pro POST endpoint
    @Test
    void shouldReturn400WhenCreatingClientWithInvalidData() throws Exception {

        mockMvc.perform(post("/clients")
                        .contentType(APPLICATION_JSON)
                        .content("""
                    {
                        "firstName": "",
                        "lastName": "Test",
                        "email": "invalid-email",
                        "phoneNumber": "123456789"
                    }
                    """))
                .andExpect(status().isBadRequest());
    }

    //test na invalid input data pro PUT endpoint
    @Test
    void shouldReturn400WhenUpdatingClientWithInvalidData() throws Exception {

        mockMvc.perform(put("/clients/999999")
                        .contentType(APPLICATION_JSON)
                        .content("""
                    {
                        "firstName": "",
                        "lastName": "Test",
                        "email": "invalid-email",
                        "phoneNumber": "123456789"
                    }
                    """))
                .andExpect(status().isBadRequest());
    }
}
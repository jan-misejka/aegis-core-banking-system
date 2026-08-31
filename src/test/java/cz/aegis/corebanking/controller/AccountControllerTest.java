package cz.aegis.corebanking.controller;

import cz.aegis.corebanking.TestDatabaseReset;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class AccountControllerTest extends TestDatabaseReset {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldDepositMoneySuccessfully() throws Exception {

        mockMvc.perform(post("/accounts/1/deposit")
                .contentType(APPLICATION_JSON)
                .content("""
                        {
                            "amount": 500.00
                        }
                        """))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn400WhenDepositingZeroAmount() throws Exception {

        mockMvc.perform(post("/accounts/1/deposit")
                .contentType(APPLICATION_JSON)
                .content("""
                        {
                            "amount": 0
                        }
                        """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400WhenDepositingNegativeAmount() throws Exception {

        mockMvc.perform(post("/accounts/1/deposit")
                        .contentType(APPLICATION_JSON)
                        .content("""
                            {
                                "amount": -100
                            }
                            """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn404WhenDepositingToNonExistingAccount() throws Exception {

        mockMvc.perform(post("/accounts/999999/deposit")
                    .contentType(APPLICATION_JSON)
                    .content("""
                        {
                            "amount": 500.00
                        }
                        """))
                .andExpect(status().isNotFound());
    }
}
package cz.aegis.corebanking.repository;

import cz.aegis.corebanking.entity.Card;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CardRepositoryTest {

    @Autowired
    private CardRepository cardRepository;

    @Test
    void shouldLoadAllCards() {

        List<Card> cards = cardRepository.findAll();

        assertEquals(12, cards.size());
    }

    @Test
    void shouldLoadCardWithAccountAndClient() {

        Card card = cardRepository.findById(1L).orElseThrow();

        assertNotNull(card.getAccount());

        assertNotNull(card.getAccount().getClient());

        assertEquals(
                "Honza",
                card.getAccount()
                        .getClient()
                        .getFirstName()
        );
    }
}
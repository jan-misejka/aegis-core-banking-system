package cz.aegis.corebanking;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@ActiveProfiles("test")
@Sql(
        scripts = "/test_reset.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
public abstract class TestDatabaseReset {
}
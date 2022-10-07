package example9.test;

import example8.main.IssuedInvoices;
import example9.main.DatabaseConnection;
import example9.main.IDatabase;
import example9.main.TeamScoreUpdate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamScoreUpdateTeste {
    private TeamScoreUpdate scores;
    private DatabaseConnection database;

    @BeforeEach
    public void open() {
        database = new DatabaseConnection();
        scores = new TeamScoreUpdate(database);
        database.resetDatabase();
    }

    @AfterEach
    public void close() {
        if (database != null) {
            database.close();
        }
    }

    @Test
    void testTeamScoreUpdate(){

    }


}

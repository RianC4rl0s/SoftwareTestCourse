package example9.test;

import example9.main.DatabaseException;
import example9.main.IDatabase;
import example9.main.TeamScoreUpdate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;
import static org.mockito.Mockito.*;

public class TeamScoreUpdateTeste_Rian_Rigoberto {
    private IDatabase database = mock(IDatabase.class);
    private TeamScoreUpdate teamScoreUpdate = new TeamScoreUpdate(database);

    @Test
    public void exceptionTest() {

        String teamId = "0";
        int errorArray = 1;

        doThrow(new DatabaseException()).when(database).updateScores(teamId, errorArray);
    }

    @ParameterizedTest
    @MethodSource("arrayValuesGen")
    public void arrayTest(String teamId, int[] score, int sum) {

        teamScoreUpdate.calculateTotalAndStore(teamId, score);
        verify(database).updateScores(teamId, sum);

        verify(database, times(1)).updateScores(any(String.class), any(Integer.class));
    }
    static Stream<Arguments> arrayValuesGen() {

        int[] empty = new int[0];
        int[] One = {1};
        int[] moreThanOne = {1,2,3};
        int resultEmpty = 0;
        int resultOne = 1;
        int resultThanOne = 6;

        return Stream.of(
                of("0", empty, resultEmpty),
                of("0", One, resultOne
                ),
                of("0", moreThanOne, resultThanOne)
        );
    }
}
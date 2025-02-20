package com.bridgelabz.practice_problem_2.ipl_and_censor_analyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IPLCensorAnalyzerTest {

    private List<IPLMatch> sampleMatches;
    private List<String[]> sampleCsvData;

    @BeforeEach
    void setUp() {
        sampleMatches = new ArrayList<>();
        IPLMatch match1 = new IPLMatch();
        match1.match_id = 1;
        match1.team1 = "Mumbai Indians";
        match1.team2 = "Chennai Super Kings";
        match1.score = new HashMap<>();
        match1.score.put("Mumbai Indians", 180);
        match1.score.put("Chennai Super Kings", 175);
        match1.winner = "Mumbai Indians";
        match1.player_of_match = "Rohit Sharma";

        IPLMatch match2 = new IPLMatch();
        match2.match_id = 2;
        match2.team1 = "Delhi Capitals";
        match2.team2 = "Kolkata Knight Riders";
        match2.score = new HashMap<>();
        match2.score.put("Delhi Capitals", 200);
        match2.score.put("Kolkata Knight Riders", 190);
        match2.winner = "Delhi Capitals";
        match2.player_of_match = "Shreyas Iyer";

        sampleMatches.add(match1);
        sampleMatches.add(match2);

        sampleCsvData = new ArrayList<>();
        sampleCsvData.add(new String[]{"Match ID", "Team1", "Team2", "Score1", "Score2", "Winner", "Player of Match"});
        sampleCsvData.add(new String[]{"1", "Mumbai Indians", "Chennai Super Kings", "180", "175", "Mumbai Indians", "Rohit Sharma"});
        sampleCsvData.add(new String[]{"2", "Delhi Capitals", "Kolkata Knight Riders", "200", "190", "Delhi Capitals", "Shreyas Iyer"});
    }

    @Test
    void testCensorData() {
        List<IPLMatch> censoredMatches = IPLCensorAnalyzer.censorData(sampleMatches);

        assertEquals("Mumbai ***", censoredMatches.get(0).team1);
        assertEquals("Chennai ***", censoredMatches.get(0).team2);
        assertEquals("Mumbai ***", censoredMatches.get(0).winner);
        assertEquals("REDACTED", censoredMatches.get(0).player_of_match);

        assertEquals("Delhi ***", censoredMatches.get(1).team1);
        assertEquals("Kolkata ***", censoredMatches.get(1).team2);
        assertEquals("Delhi ***", censoredMatches.get(1).winner);
        assertEquals("REDACTED", censoredMatches.get(1).player_of_match);
    }

    @Test
    void testCensorCsvData() {
        List<String[]> censoredCsvData = IPLCensorAnalyzer.censorCsvData(sampleCsvData);

        assertEquals("Mumbai ***", censoredCsvData.get(1)[1]); // Team1
        assertEquals("Chennai ***", censoredCsvData.get(1)[2]); // Team2
        assertEquals("Mumbai ***", censoredCsvData.get(1)[5]); // Winner
        assertEquals("REDACTED", censoredCsvData.get(1)[6]); // Player of Match

        assertEquals("Delhi ***", censoredCsvData.get(2)[1]);
        assertEquals("Kolkata ***", censoredCsvData.get(2)[2]);
        assertEquals("Delhi ***", censoredCsvData.get(2)[5]);
        assertEquals("REDACTED", censoredCsvData.get(2)[6]);
    }

    @Test
    void testCensorTeamName() {
        assertEquals("Mumbai ***", IPLCensorAnalyzer.censorTeamName("Mumbai Indians"));
        assertEquals("Delhi ***", IPLCensorAnalyzer.censorTeamName("Delhi Capitals"));
        assertEquals("SRH", IPLCensorAnalyzer.censorTeamName("SRH")); // No space in team name, should remain unchanged
    }
}

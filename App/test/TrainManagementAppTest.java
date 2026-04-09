import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        Map<String, List<Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 70));

        Map<String, List<Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        Map<String, List<Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(3, result.size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        Map<String, List<Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 75));

        Map<String, List<Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(1, result.keySet().size());
        assertTrue(result.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        Map<String, List<Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertFalse(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));

        bogies.stream().collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(1, bogies.size());
        assertEquals("Sleeper", bogies.get(0).getName());
    }
}
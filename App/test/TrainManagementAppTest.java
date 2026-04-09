import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        List<Bogie> result = bogies.stream().filter(b -> b.getCapacity() > 60).collect(Collectors.toList());
        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).getName());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Threshold Bogie", 60));
        List<Bogie> result = bogies.stream().filter(b -> b.getCapacity() > 60).collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 24));
        List<Bogie> result = bogies.stream().filter(b -> b.getCapacity() > 60).collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("General", 90));
        List<Bogie> result = bogies.stream().filter(b -> b.getCapacity() > 60).collect(Collectors.toList());
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("AC", 56));
        List<Bogie> result = bogies.stream().filter(b -> b.getCapacity() > 60).collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("High1", 80));
        bogies.add(new Bogie("High2", 100));
        List<Bogie> result = bogies.stream().filter(b -> b.getCapacity() > 60).collect(Collectors.toList());
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        List<Bogie> result = bogies.stream().filter(b -> b.getCapacity() > 60).collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC", 56));
        bogies.stream().filter(b -> b.getCapacity() > 60).collect(Collectors.toList());
        assertEquals(2, bogies.size());
    }
}
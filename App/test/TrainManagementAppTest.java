import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC", 50));

        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(122, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("A", 10));
        bogies.add(new Bogie("B", 20));
        bogies.add(new Bogie("C", 30));

        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(60, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Single", 72));

        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        Bogie b = new Bogie("Test", 50);
        List<Bogie> bogies = List.of(b);

        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(b.getCapacity(), total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = new ArrayList<>();
        for(int i = 0; i < 5; i++) bogies.add(new Bogie("B", 10));

        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(50, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));

        bogies.stream().map(Bogie::getCapacity).reduce(0, Integer::sum);

        assertEquals(1, bogies.size());
        assertEquals("Sleeper", bogies.get(0).getName());
    }
}
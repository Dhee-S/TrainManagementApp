import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Comparator;
import java.util.stream.Collectors;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return name + " -> " + capacity;
    }
}

class TrainConsist {
    private List<String> passengerBogies = new ArrayList<>();
    private Set<String> bogieIds = new HashSet<>();
    private LinkedList<String> orderedConsist = new LinkedList<>();
    private Set<String> orderedFormation = new LinkedHashSet<>();
    private Map<String, Integer> bogieCapacities = new HashMap<>();
    private List<Bogie> bogieObjects = new ArrayList<>();

    public void addBogie(String type) { passengerBogies.add(type); }
    public void removeBogie(String type) { passengerBogies.remove(type); }
    public boolean hasBogie(String type) { return passengerBogies.contains(type); }
    public List<String> getPassengerBogies() { return passengerBogies; }
    public void addBogieId(String id) { bogieIds.add(id); }
    public Set<String> getBogieIds() { return bogieIds; }
    public void addToOrderedConsist(String bogie) { orderedConsist.add(bogie); }
    public void addAtPosition(int index, String bogie) { orderedConsist.add(index, bogie); }
    public void removeFirstAndLast() {
        if (!orderedConsist.isEmpty()) {
            orderedConsist.removeFirst();
            orderedConsist.removeLast();
        }
    }
    public LinkedList<String> getOrderedConsist() { return orderedConsist; }
    public void addToFormation(String bogie) { orderedFormation.add(bogie); }
    public Set<String> getOrderedFormation() { return orderedFormation; }
    public void mapCapacity(String bogie, int capacity) { bogieCapacities.put(bogie, capacity); }
    public Map<String, Integer> getBogieCapacities() { return bogieCapacities; }
    public void addBogieObject(Bogie bogie) { bogieObjects.add(bogie); }
    public List<Bogie> getBogieObjects() { return bogieObjects; }
    public int getBogieCount() { return passengerBogies.size(); }
}

class TrainService {
    public void displaySummary(TrainConsist consist) {
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count : " + consist.getBogieCount());
        System.out.println("Current Train Consist : " + consist.getPassengerBogies());
    }

    public void countTotalSeats(TrainConsist consist) {
        System.out.println("\n****************************************");
        System.out.println("* UC10 - Count Total Seats in Train *");
        System.out.println("****************************************\n");

        consist.getBogieObjects().clear();
        consist.addBogieObject(new Bogie("Sleeper", 72));
        consist.addBogieObject(new Bogie("AC Chair", 56));
        consist.addBogieObject(new Bogie("First Class", 24));
        consist.addBogieObject(new Bogie("Sleeper", 70));

        System.out.println("Bogies in Train:");
        consist.getBogieObjects().forEach(System.out::println);

        // Functional Aggregation using map and reduce
        int totalSeats = consist.getBogieObjects().stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);
        System.out.println("UC10 aggregation completed...");
    }
}

public class trainmanagement {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        TrainConsist consist = new TrainConsist();
        TrainService service = new TrainService();
        service.displaySummary(consist);
        service.countTotalSeats(consist);
        System.out.println("\nSystem ready for operations...");
    }
}
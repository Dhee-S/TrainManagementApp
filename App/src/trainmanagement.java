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

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " -> " + capacity;
    }
}

class TrainConsist {
    private List<String> passengerBogies;
    private Set<String> bogieIds;
    private LinkedList<String> orderedConsist;
    private Set<String> orderedFormation;
    private Map<String, Integer> bogieCapacities;
    private List<Bogie> bogieObjects;

    public TrainConsist() {
        this.passengerBogies = new ArrayList<>();
        this.bogieIds = new HashSet<>();
        this.orderedConsist = new LinkedList<>();
        this.orderedFormation = new LinkedHashSet<>();
        this.bogieCapacities = new HashMap<>();
        this.bogieObjects = new ArrayList<>();
    }

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

    public void processPassengerOperations(TrainConsist consist) {
        System.out.println("\n****************************************");
        System.out.println("* UC2 - Add Passenger Bogies to Train *");
        System.out.println("****************************************\n");
        consist.addBogie("Sleeper");
        consist.addBogie("AC Chair");
        consist.addBogie("First Class");
        System.out.println("After Adding Bogies: " + consist.getPassengerBogies());
        consist.removeBogie("AC Chair");
        System.out.println("After Removing 'AC Chair': " + consist.getPassengerBogies());
        System.out.println("Contains Sleeper? : " + consist.hasBogie("Sleeper"));
        System.out.println("Final Train Passenger Consist: " + consist.getPassengerBogies());
    }

    public void trackUniqueBogieIds(TrainConsist consist) {
        System.out.println("\n****************************************");
        System.out.println("* UC3 - Track Unique Bogie IDs *");
        System.out.println("****************************************\n");
        consist.addBogieId("BG101");
        consist.addBogieId("BG102");
        consist.addBogieId("BG103");
        consist.addBogieId("BG104");
        consist.addBogieId("BG101");
        System.out.println("Bogie IDs After Insertion: " + consist.getBogieIds());
        System.out.println("Note: Duplicates are automatically ignored by HashSet.");
    }

    public void maintainOrderedConsist(TrainConsist consist) {
        System.out.println("\n****************************************");
        System.out.println("* UC4 - Maintain Ordered Bogie Consist *");
        System.out.println("****************************************\n");
        consist.addToOrderedConsist("Engine");
        consist.addToOrderedConsist("Sleeper");
        consist.addToOrderedConsist("AC");
        consist.addToOrderedConsist("Cargo");
        consist.addToOrderedConsist("Guard");
        System.out.println("Initial Train Consist: " + consist.getOrderedConsist());
        consist.addAtPosition(2, "Pantry Car");
        System.out.println("After Inserting 'Pantry Car' at position 2: " + consist.getOrderedConsist());
        consist.removeFirstAndLast();
        System.out.println("After Removing First and Last Bogie: " + consist.getOrderedConsist());
    }

    public void preserveInsertionOrder(TrainConsist consist) {
        System.out.println("\n****************************************");
        System.out.println("* UC5 - Preserve Insertion Order of Bogies *");
        System.out.println("****************************************\n");
        consist.addToFormation("Engine");
        consist.addToFormation("Sleeper");
        consist.addToFormation("Cargo");
        consist.addToFormation("Guard");
        consist.addToFormation("Sleeper");
        System.out.println("Final Train Formation: " + consist.getOrderedFormation());
        System.out.println("Note: LinkedHashSet preserves insertion order and removes duplicates.");
    }

    public void mapBogieCapacity(TrainConsist consist) {
        System.out.println("\n****************************************");
        System.out.println("* UC6 - Map Bogie to Capacity (HashMap) *");
        System.out.println("****************************************\n");
        consist.mapCapacity("Sleeper", 72);
        consist.mapCapacity("AC Chair", 56);
        consist.mapCapacity("First Class", 24);
        consist.mapCapacity("Cargo", 120);
        System.out.println("Bogie Capacity Details:");
        consist.getBogieCapacities().forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    public void sortBogiesByCapacity(TrainConsist consist) {
        System.out.println("\n****************************************");
        System.out.println("* UC7 - Sort Bogies by Capacity (Comparator) *");
        System.out.println("****************************************\n");
        consist.getBogieObjects().clear();
        consist.addBogieObject(new Bogie("Sleeper", 72));
        consist.addBogieObject(new Bogie("AC Chair", 56));
        consist.addBogieObject(new Bogie("First Class", 24));
        consist.addBogieObject(new Bogie("General", 90));
        System.out.println("Before Sorting:");
        consist.getBogieObjects().forEach(System.out::println);
        consist.getBogieObjects().sort(Comparator.comparingInt(Bogie::getCapacity));
        System.out.println("\nAfter Sorting by Capacity:");
        consist.getBogieObjects().forEach(System.out::println);
    }

    public void filterBogiesUsingStreams(TrainConsist consist) {
        System.out.println("\n****************************************");
        System.out.println("* UC8 - Filter Passenger Bogies Using Streams *");
        System.out.println("****************************************\n");
        System.out.println("All Bogies:");
        consist.getBogieObjects().forEach(System.out::println);
        List<Bogie> filtered = consist.getBogieObjects().stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filtered.forEach(System.out::println);
        System.out.println("\nUC8 filtering completed...");
    }
}

public class trainmanagement {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        TrainConsist consist = new TrainConsist();
        TrainService service = new TrainService();
        service.displaySummary(consist);
        service.processPassengerOperations(consist);
        service.trackUniqueBogieIds(consist);
        service.maintainOrderedConsist(consist);
        service.preserveInsertionOrder(consist);
        service.mapBogieCapacity(consist);
        service.sortBogiesByCapacity(consist);
        service.filterBogiesUsingStreams(consist);
        System.out.println("\nSystem ready for operations...");
    }
}
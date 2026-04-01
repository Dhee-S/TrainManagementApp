import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TrainConsist {
    private List<String> passengerBogies;
    private Set<String> bogieIds;

    public TrainConsist() {
        this.passengerBogies = new ArrayList<>();
        this.bogieIds = new HashSet<>();
    }

    public void addBogie(String type) {
        passengerBogies.add(type);
    }

    public void removeBogie(String type) {
        passengerBogies.remove(type);
    }

    public boolean hasBogie(String type) {
        return passengerBogies.contains(type);
    }

    public List<String> getPassengerBogies() {
        return passengerBogies;
    }

    public void addBogieId(String id) {
        bogieIds.add(id);
    }

    public Set<String> getBogieIds() {
        return bogieIds;
    }

    public int getBogieCount() {
        return passengerBogies.size();
    }
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

        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies: " + consist.getPassengerBogies());

        consist.removeBogie("AC Chair");

        System.out.println("\nAfter Removing 'AC Chair':");
        System.out.println("Passenger Bogies : " + consist.getPassengerBogies());

        System.out.println("\nChecking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? : " + consist.hasBogie("Sleeper"));

        System.out.println("\nFinal Train Passenger Consist:");
        System.out.println(consist.getPassengerBogies());

        System.out.println("\nUC2 operations completed successfully...");
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
        consist.addBogieId("BG102");

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(consist.getBogieIds());

        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");
        System.out.println("UC3 uniqueness validation completed...");
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

        System.out.println("\nSystem ready for operations...");
    }
}
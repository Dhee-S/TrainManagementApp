import java.util.ArrayList;
import java.util.List;

class TrainConsist {
    private List<String> passengerBogies;

    public TrainConsist() {
        this.passengerBogies = new ArrayList<>();
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

    public void runUC2(TrainConsist consist) {
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
}

public class trainmanagement {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        TrainConsist consist = new TrainConsist();
        TrainService service = new TrainService();

        service.displaySummary(consist);
        service.runUC2(consist);

        System.out.println("System ready for operations...");
    }
}
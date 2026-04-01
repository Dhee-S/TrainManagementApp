import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TrainConsist {
    private List<String> bogies;

    public TrainConsist() {
        this.bogies = new ArrayList<>();
    }

    public int getBogieCount() {
        return bogies.size();
    }

    public List<String> getBogies() {
        return bogies;
    }
}

class TrainService {
    public void displaySummary(TrainConsist consist) {
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count : " + consist.getBogieCount());
        System.out.println("Current Train Consist : " + consist.getBogies());
    }
}

public class trainmanagement {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        TrainConsist consist = new TrainConsist();
        TrainService service = new TrainService();

        service.displaySummary(consist);

        System.out.println("System ready for operations...");
    }
}
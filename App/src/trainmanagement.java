import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public String toString() { return name + " -> " + capacity; }
}

class TrainConsist {
    private List<Bogie> bogieObjects = new ArrayList<>();

    public void addBogieObject(Bogie bogie) { bogieObjects.add(bogie); }
    public List<Bogie> getBogieObjects() { return bogieObjects; }
}

class TrainService {
    public void validateTrainData() {
        System.out.println("\n****************************************");
        System.out.println("* UC11 - Validate Train ID and Cargo Code *");
        System.out.println("****************************************\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainIdInput = sc.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCodeInput = sc.nextLine();

        String trainIdRegex = "TRN-\\d{4}";
        String cargoCodeRegex = "PET-[A-Z]{2}";

        Pattern trainIdPattern = Pattern.compile(trainIdRegex);
        Matcher trainIdMatcher = trainIdPattern.matcher(trainIdInput);

        Pattern cargoCodePattern = Pattern.compile(cargoCodeRegex);
        Matcher cargoCodeMatcher = cargoCodePattern.matcher(cargoCodeInput);

        boolean isTrainIdValid = trainIdMatcher.matches();
        boolean isCargoCodeValid = cargoCodeMatcher.matches();

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainIdValid);
        System.out.println("Cargo Code Valid: " + isCargoCodeValid);

        System.out.println("\nUC11 validation completed...");
    }
}

public class trainmanagement {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        TrainConsist consist = new TrainConsist();
        TrainService service = new TrainService();

        service.validateTrainData();

        System.out.println("\nSystem ready for operations...");
    }
}
import java.util.*;
import java.util.stream.Collectors;

class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() { return type; }
    public String getCargo() { return cargo; }

    @Override
    public String toString() {
        return type + " -> " + cargo;
    }
}

class TrainConsist {
    private List<GoodsBogie> goodsBogies = new ArrayList<>();

    public void addGoodsBogie(GoodsBogie bogie) { goodsBogies.add(bogie); }
    public List<GoodsBogie> getGoodsBogies() { return goodsBogies; }
}

class TrainService {
    public void checkSafetyCompliance(TrainConsist consist) {
        System.out.println("\n****************************************");
        System.out.println("* UC12 - Safety Compliance Check for Goods Bogies *");
        System.out.println("****************************************\n");

        // Prepare test data as per the UC requirements
        consist.getGoodsBogies().clear();
        consist.addGoodsBogie(new GoodsBogie("Cylindrical", "Petroleum"));
        consist.addGoodsBogie(new GoodsBogie("Open", "Coal"));
        consist.addGoodsBogie(new GoodsBogie("Box", "Grain"));
        consist.addGoodsBogie(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("Goods Bogies in Train:");
        consist.getGoodsBogies().forEach(System.out::println);

        // Safety Rule: If type is Cylindrical, cargo must be Petroleum
        boolean isSafe = consist.getGoodsBogies().stream()
                .allMatch(b -> {
                    if (b.getType().equalsIgnoreCase("Cylindrical")) {
                        return b.getCargo().equalsIgnoreCase("Petroleum");
                    }
                    return true;
                });

        System.out.println("\nSafety Compliance Status: " + isSafe);

        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}

public class trainmanagement {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        TrainConsist consist = new TrainConsist();
        TrainService service = new TrainService();

        service.checkSafetyCompliance(consist);

        System.out.println("\nSystem ready for operations...");
    }
}
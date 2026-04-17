// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// Goods Bogie Class
class GoodsBogie {
    String shape;
    String cargo;

    GoodsBogie(String shape) {
        this.shape = shape;
        this.cargo = "Not Assigned";
    }

    public void assignCargo(String cargo) {
        try {
            // Unsafe rule: Petroleum cannot go in Rectangular bogie
            if (shape.equalsIgnoreCase("Rectangular") &&
                cargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo assignment: Petroleum cannot be assigned to a Rectangular bogie.");
            }

            this.cargo = cargo;
            System.out.println("Cargo assigned successfully: " + cargo + " -> " + shape + " bogie");

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Cargo assignment process completed for " + shape + " bogie.");
        }
    }

    @Override
    public String toString() {
        return shape + " Bogie carrying " + cargo;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        // Safe assignment
        b1.assignCargo("Petroleum");

        System.out.println();

        // Unsafe assignment
        b2.assignCargo("Petroleum");

        System.out.println();

        // Program continues safely
        System.out.println("Final Bogie Status:");
        System.out.println(b1);
        System.out.println(b2);

        System.out.println("\nProgram continues safely...");
    }
}

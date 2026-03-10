import java.util.HashMap;
import java.util.Map;

class RoomInventory {
    private Map<String, Integer> inventory;
    public RoomInventory() {
        inventory = new HashMap<>();
        // Initialize with default room types and availability
        inventory.put("Deluxe", 10);
        inventory.put("Suite", 5);
        inventory.put("Family", 3);
    }
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
    public boolean updateAvailability(String roomType, int count) {
        if (inventory.containsKey(roomType)) {
            int current = inventory.get(roomType);
            if (current + count >= 0) {
                inventory.put(roomType, current + count);
                return true;
            }
        }
        return false;
    }
    public void displayInventory() {
        System.out.println("Current Inventory: " + inventory);
    }
}

public class UseCase3InventorySetup {
    public static void main(String[] args) {
        RoomInventory manager = new RoomInventory();
        System.out.println("Initial State:");
        manager.displayInventory();
        System.out.println("\nBooking 2 Deluxe rooms...");
        manager.updateAvailability("Deluxe", -2);
        manager.displayInventory();
        System.out.println("\nAdding 1 Suite room...");
        manager.updateAvailability("Suite", 1);
        manager.displayInventory();
    }
}
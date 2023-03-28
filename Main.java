import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
    private String name;
    private String serialNumber;
    private int value;

    public Inventory(String name, String serialNumber, int value) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return name + "," + serialNumber + "," + value;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Inventory> inventory = new ArrayList<Inventory>();
        boolean quit = false;
        int choice;

        while (!quit) {
            System.out.println("Press 1 to add an item.");
            System.out.println("Press 2 to delete an item.");
            System.out.println("Press 3 to update an item.");
            System.out.println("Press 4 to show all the items.");
            System.out.println("Press 5 to quit the program.");

            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name:");
                    String name = scan.nextLine();

                    System.out.println("Enter the serial number:");
                    String serialNumber = scan.nextLine();

                    System.out.println("Enter the value in dollars (whole number):");
                    int value = scan.nextInt();
                    scan.nextLine();

                    Inventory item = new Inventory(name, serialNumber, value);
                    inventory.add(item);
                    break;

                case 2:
                    System.out.println("Enter the serial number of the item to delete:");
                    String deleteSerialNumber = scan.nextLine();

                    for (int i = 0; i < inventory.size(); i++) {
                        if (inventory.get(i).getSerialNumber().equals(deleteSerialNumber)) {
                            inventory.remove(i);
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter the serial number of the item to change:");
                    String updateSerialNumber = scan.nextLine();

                    for (int i = 0; i < inventory.size(); i++) {
                        if (inventory.get(i).getSerialNumber().equals(updateSerialNumber)) {
                            System.out.println("Enter the new name:");
                            String newName = scan.nextLine();
                            inventory.get(i).setName(newName);

                            System.out.println("Enter the new value in dollars (whole number):");
                            int newValue = scan.nextInt();
                            scan.nextLine();
                            inventory.get(i).setValue(newValue);

                            break;
                        }
                    }
                    break;

                case 4:
                    for (int i = 0; i < inventory.size(); i++) {
                        System.out.println(inventory.get(i).toString());
                    }
                    break;

                case 5:
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scan.close();
    }
}

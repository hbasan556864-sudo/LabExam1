package main_file;

import java.util.ArrayDeque;
import java.util.Scanner;

public class main_coding {
	    private static ArrayDeque<warehouse> warehouseStack = new ArrayDeque<>();
	    private static ArrayDeque<Truck> TruckQueue = new ArrayDeque<>();
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        while (true) {
	            printMenu();
	            String option = scanner.nextLine().trim();

	            switch (option) {
	                case "1":
	                    storeItem();
	                    break;
	                case "2":
	                    viewWarehouseStack();
	                    break;
	                case "3":
	                    registerTruck();
	                    break;
	                case "4":
	                    viewTruckQueue();
	                    break;
	                case "5":
	                    loadNextTruck();
	                    break;
	                case "0":
	                    System.out.println("Exiting Warehouse Loading System. Goodbye!");
	                    return;
	                default:
	                    System.out.println("Invalid option. Please enter a valid menu choice.");
	            }
	            System.out.println();
	        }
	    }

	    private static void printMenu() {
	        System.out.println("=== Warehouse Loading System Menu ===");
	        System.out.println("[1] Store item");
	        System.out.println("[2] View warehouse stack");
	        System.out.println("[3] Register arriving truck");
	        System.out.println("[4] View waiting trucks");
	        System.out.println("[5] Load next truck");
	        System.out.println("[0] Exit");
	        System.out.print("Choose an option: ");
	    }

	    private static void storeItem() {
	        System.out.print("Enter item code: ");
	        String code = scanner.nextLine().trim();
	        System.out.print("Enter item name: ");
	        String name = scanner.nextLine().trim();
	        System.out.print("Enter item quantity: ");
	        int quantity = Integer.parseInt(scanner.nextLine().trim());

	        warehouse item = new warehouse(code, name, quantity);
	        warehouseStack.push(item);
	        System.out.println("Item stored successfully!");
	    }

	    private static void viewWarehouseStack() {
	        if (warehouseStack.isEmpty()) {
	            System.out.println("Warehouse stack is empty.");
	            return;
	        }
	        System.out.println("Items in warehouse (top to bottom):");
	        for (warehouse item : warehouseStack) {
	            System.out.println(item);
	        }
	    }

	    private static void registerTruck() {
	        System.out.print("Enter truck plate: ");
	        String plate = scanner.nextLine().trim();
	        System.out.print("Enter driver name: ");
	        String driver = scanner.nextLine().trim();

	        Truck truck = new Truck(plate, driver);
	        TruckQueue.offer(truck);
	        System.out.println("Truck registered successfully!");
	    }

	    private static void viewTruckQueue() {
	        if (truckQueue.isEmpty()) {
	            System.out.println("No waiting trucks.");
	            return;
	        }
	        System.out.println("Waiting trucks (front to rear):");
	        for (Truck truck : truckQueue) {
	            System.out.println(truck);
	        }
	    }

	    private static void loadNextTruck() {
	        if (warehouseStack.isEmpty()) {
	            System.out.println("No items in warehouse to load.");
	            return;
	        }
	        if (TruckQueue.isEmpty()) {
	            System.out.println("No trucks waiting to be loaded.");
	            return;
	        }
	        warehouse item = warehouseStack.pop();
	        Truck truck = TruckQueue.poll();
	        System.out.println("=== Loading Result ===");
	        System.out.println("Loaded " + item);
	        System.out.println("To " + truck);
	        System.out.println("Loading complete!");
	    }
	}


	
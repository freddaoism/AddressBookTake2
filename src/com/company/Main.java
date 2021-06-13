package com.company;
import java.util.Scanner;
import java.util.List;
import java.util.Map;


public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        boolean quit = false;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    addEntry(addressBook);
                    break;
                case 2:
                    String email = askForInput("email");
                    addressBook.removeEntry(email);
                    break;
                case 3:
                    searchForSpecificEntry(addressBook);;
                    break;
                case 4:
                    addressBook.printAddressBook();
                    break;
                case 5:
                    addressBook.deleteAddressBook();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options. ");
        System.out.println("\t 1 - To add an contact to the list. ");
        System.out.println("\t 2 - To remove a contact on the list. ");
        System.out.println("\t 3 - To search for a specific contact. ");
        System.out.println("\t 4 - To print contact list. ");
        System.out.println("\t 5 - To delete contact list");
        System.out.println("\t 6 - To quit the application.");
    }

    public static String askForInput(String inputName) {
        System.out.println("Please enter " + inputName + ": ");
        return scanner.nextLine();
    }

    public static int getIntInput() {
        String ip = scanner.nextLine();
        while (ip.length() == 0) {
            ip = scanner.nextLine();
        }
        return Integer.parseInt(ip);
    }

    public static void addEntry(AddressBook addressBook) {
        System.out.print("First name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Phone number: ");
        String phone = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.next().strip();

        Entry entry = new Entry(firstName, lastName, phone, email);
        addressBook.addEntry(entry);
    }


    public static void searchForSpecificEntry(AddressBook addressBook) {
        System.out.println("Select an option");
        System.out.println("1. Search By First Name");
        System.out.println("2. Search By Last Name");
        System.out.println("3. Search By Phone");
        System.out.println("4. Search By Email");

        int input = getIntInput();

        Map<Integer, String> searchMapping =
                Map.of(1, "firstName", 2, "lastName", 3, "phone", 4, "email");
        if (input < 0 || input > 4) {
            System.out.println("Invalid input! Try again");
        } else {
            System.out.print("Enter your search query: ");
            String searchQuery = scanner.nextLine();
            List<Entry> entries = addressBook.entrySearch(searchMapping.get(input), searchQuery);
            System.out.println("Here are your search results:");
            for (Entry entry : entries) {
                System.out.println(entry);
            }
        }
        System.out.println();
    }
}
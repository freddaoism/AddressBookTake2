package com.company;
import java.util.Scanner;
import java.util.List;
import java.util.Map;


public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        //We are creating a new instance of addressBook here
        AddressBook addressBook = new AddressBook();

        //this boolean shows us that the quit value starts off at false
        boolean quit = false;

        //The program starts off by printing the instructions onto the screen
        printInstructions();

        //Here is a switch statement that allows us to choose between our seven options
        while (!quit) {
            System.out.println("Enter your choice: ");

            //this uses the scanner class to take user input in as the choice integer value
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                //Here we have a function used to print the instructions onto the console
                case 0:
                    printInstructions();
                    break;
                    //this choice adds a contact
                case 1:
                    addContact(addressBook);
                    break;
                    //this choice removes the contact
                case 2:
                    String email = askForInput("email");
                    addressBook.removeContact(email);
                    break;
                    //this choice lets us search for specific contacts
                case 3:
                    searchForSpecificEntry(addressBook);;
                    break;
                    //this choice is prints the contacts
                case 4:
                    addressBook.printContactList();
                    break;
                    //this deletes the address book
                case 5:
                    addressBook.deleteAddressBook();
                    break;
                    //and this quits our program
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    //print instructions
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

    //asking for user input
    public static String askForInput(String inputName) {
        System.out.println("Please enter " + inputName + ": ");
        return scanner.nextLine();
    }

    //also asking for user input
    public static int getIntInput() {
        String ip = scanner.nextLine();
        while (ip.length() == 0) {
            ip = scanner.nextLine();
        }
        return Integer.parseInt(ip);
    }

    //creating entry
    public static void addContact(AddressBook addressBook) {
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

    //specific search query
    public static void searchForSpecificEntry(AddressBook addressBook) {
        System.out.println("Options:");
        System.out.println("1. Search By First Name");
        System.out.println("2. Search By Last Name");
        System.out.println("3. Search By Phone");
        System.out.println("4. Search By Email");

        int input = getIntInput();

        Map<Integer, String> searchMapping =
                Map.of(1, "firstName", 2, "lastName", 3, "phone", 4, "email");
        if (input < 0 || input > 4) {
            System.out.println("That's not gonna work! Try again...");
        } else {
            System.out.print("Enter your search query: ");
            String searchQuery = scanner.nextLine();
            List<Entry> entries = addressBook.entrySearch(searchMapping.get(input), searchQuery);
            System.out.println("Search results:");
            for (Entry entry : entries) {
                System.out.println(entry);
            }
        }
        System.out.println();
    }
}
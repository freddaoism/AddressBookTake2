package com.company;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ContactList contactList = new ContactList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    contactList.printContactList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add an contact to the list.");
        System.out.println("\t 3 - To modify an contact in the list.");
        System.out.println("\t 4 - To remove an contact from the list.");
        System.out.println("\t 5 - To search for an contact in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addItem() {
        System.out.print("Please enter first name: ");
        contactList.addContactItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Current first name: ");
        String itemNo = scanner.nextLine();
        System.out.print("Enter replacement first name: ");
        String newItem = scanner.nextLine();
        contactList.modifyContactItem(itemNo, newItem);
    }

    public static void removeItem() {
        System.out.print("Enter contact name: ");
        String itemNo = scanner.nextLine();
        contactList.removeContactItem(itemNo);

    }

    public static void searchForItem() {
        System.out.print("Contact to search for: ");
        String searchItem = scanner.nextLine();
        if (contactList.onFile(searchItem)) {
            System.out.println("Found " + searchItem + " in our contact list");
        } else {
            System.out.println(searchItem + " is not in our contact list");
        }
    }

    public static void processArrayList() {
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(contactList.getContactList())
    }
}

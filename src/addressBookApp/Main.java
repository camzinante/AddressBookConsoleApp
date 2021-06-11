package addressBookApp;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    private static int menu() {
        System.out.println(
                        "1. Add an entry\n" +
                        "2. Remove an entry\n" +
                        "3. Search for a specific entry\n" +
                        "4. Print the contents of the address book\n" +
                        "5. Delete the contents of the address book\n" +
                        "6. Quit the program");
        return getInput("Choose what you'd like to do with the database:", 6);
    }

    public static void addEntry(AddressBookApp addressBookApp) {
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Email Address: ");
        String email = scanner.next();

        Entry entry = new Entry(firstName, lastName, phone, email);
        System.out.println(addressBookApp.addEntry(entry));
    }

    public static String removeEntry() {
        System.out.print("Enter an entry's email to remove: ");
        return scanner.nextLine();
    }

    public static void searchMenu(AddressBookApp addressBookApp) {
        int input;

        System.out.println(
                "1. First Name\n" +
                        "2. Last Name\n" +
                        "3. Phone Number\n" +
                        "4. Email Address\n");
        input = getInput("Choose a search type: ", 4);
        if (input == 5)
            return;

        System.out.print("Enter your search: ");
        String searchQuery = scanner.nextLine();
        List<Entry> searchResults = null;
        switch (input) {
            case 1:
                searchResults = addressBookApp.searchEntry("first", searchQuery);
                break;
            case 2:
                searchResults = addressBookApp.searchEntry("last", searchQuery);
                break;
            case 3:
                searchResults = addressBookApp.searchEntry("phone", searchQuery);
                break;
            case 4:
                searchResults = addressBookApp.searchEntry("email", searchQuery);
                break;
        }
        for (Entry entry : searchResults) {
            System.out.println(entry);
        }
    }

    public static int getInput(String message, int maxOptions) {
        boolean invalid;
        int input = 0;
        do {
            try {
                System.out.print(message);
                invalid = false;
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
                invalid = true;
                System.out.println("Invalid search option. Pick a number 1-6.");
            }
        } while (invalid || (input < 1 || input > maxOptions));
        scanner.nextLine();
        return input;
    }

    public static void main(String[] args) {
        AddressBookApp addressBookApp = new AddressBookApp();
        scanner = new Scanner(System.in);
        int input = 0;

        while (input != 6) {
            input = menu();
            switch (input) {
                case 1:
                    addEntry(addressBookApp);
                    break;
                case 2:
                    String email = removeEntry();
                    addressBookApp.removeEntry(email);
                    break;
                case 3:
                    searchMenu(addressBookApp);
                    break;
                case 4:
                    addressBookApp.printBook();
                    break;
                case 5:
                    addressBookApp.deleteBook();
                    break;
                case 6:
                    System.out.println("Program has been successfully quit");
                    break;
            }
        }
    }
}
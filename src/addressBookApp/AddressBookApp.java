package addressBookApp;

import java.util.ArrayList;
import java.util.List;

public class AddressBookApp {
    private final List<Entry> addressBookApp;

    public AddressBookApp(){
        this.addressBookApp = new ArrayList<>();
    }

    public String addEntry(Entry entry){
        if (this.addressBookApp.contains(entry)){
            return "Entry already entered!";
        }
        this.addressBookApp.add(entry);
        return entry.toString() + "\nAdded new entry!\n";
    }

    public void removeEntry(String email){
        for (int i = 0; i < this.addressBookApp.size(); i++) {
            if (this.addressBookApp.get(i).getEmailAddress().equals(email)) {
                System.out.println("Deleted the following entry:\n" + this.addressBookApp.get(i).toString());
                addressBookApp.remove(i);
                return;
            }
        }
        System.out.println("Entry not found!\n");
    }

    public List<Entry> searchEntry(String searchType, String searchQuery){
        List<Entry> result = new ArrayList<>();

        switch (searchType){
            case "first":
                for (Entry entry : this.addressBookApp){
                    if (entry.getFirstName().contains(searchQuery)){
                        result.add(entry);
                    }
                }
                break;
            case "last":
                for (Entry entry : this.addressBookApp){
                    if (entry.getLastName().contains(searchQuery)){
                        result.add(entry);
                    }
                }
                break;
            case "phone":
                for (Entry entry : this.addressBookApp){
                    if (entry.getPhoneNumber().contains(searchQuery)){
                        result.add(entry);
                    }
                }
                break;
            case "email":
                for (Entry entry : this.addressBookApp){
                    if (entry.getEmailAddress().contains(searchQuery)){
                        result.add(entry);
                    }
                }
                break;
            default:
                System.out.println("Invalid search option!");
        }
        if (result.isEmpty())
            System.out.println("No results found!");
        return result;
    }

    public void printBook() {
        if (this.addressBookApp.isEmpty()){
            System.out.println("Address book is empty at the moment!");
            return;
        }
        for (Entry entry : this.addressBookApp) {
            System.out.println(entry.toString());
        }
    }

    public void deleteBook(){
        this.addressBookApp.clear();
        System.out.println("Address book cleared!");
    }
}


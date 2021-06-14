package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class AddressBook {


    private List<Entry>entries;

    public AddressBook(){
        this.entries = new ArrayList<>();
    }

    //here we are adding an entry
    public boolean addEntry(Entry entry){
        if(this.entries.contains(entry)){
            System.out.println("There is another contact already present with same email address\n");
            return false;
        }
        this.entries.add(entry);
        System.out.println("Contact added successfully\n");
        return true;
    }
    //this removes the contact
    public boolean removeContact(String email) {
        int index = getEntryIndexByEmail(email);

    //this if statement gives us the two outcomes of this method
        if (index == -1) {
            System.out.println("Contact was not found");
            return false;
        }

        this.entries.remove(index);
        System.out.println("Contact deleted successfully\n");
        return true;
    }

    //Here we have a method that allows us to search for a contact
    public List<Entry> entrySearch(String searchType, String searchQuery){
        searchQuery = searchQuery.strip();
        if (searchType.equals("firstName")) {
            return lookByFirstName(searchQuery);
        } else if (searchType.equals("lastName")){
            return lookByLastName(searchQuery);
        } else if (searchType.equals("phone")){
            return lookByPhone(searchQuery);
        } else {
            return lookByEmail(searchQuery);
        }

    }

    //We can get find the index of the entry here by using their e-mail
    public  int getEntryIndexByEmail(String email){
        for (int i = 0; i < this.entries.size(); i++){
            if(this.entries.get(i).getEmail().equals(email)){
                return i ;
            }
        }
        return -1;
    }

    //we can look a contact up by their first name using this
    private List<Entry> lookByFirstName(String firstName){
        List<Entry> ans = new ArrayList<>();
        for (Entry entry : this.entries) {
            if(entry.getFirstName().contains(firstName)){
                ans.add(entry);
            }
        }
        return ans;
    }

    //this allows us to look a contact up by their first name
    private List<Entry> lookByLastName(String lastName) {
        List<Entry> ans = new ArrayList<>();
        for (Entry entry : this.entries) {
            if (entry.getLastName().contains(lastName)) {
                ans.add(entry);
            }
        }
        return ans;
    }

    //This allow us to look a contact up by their phone number
    private List<Entry> lookByPhone(String phone){
        List<Entry> ans = new ArrayList<>();
        for (Entry entry : this.entries) {
            if(entry.getPhone().contains(phone)){
                ans.add(entry);
            }
        }
        return ans;
    }

    //This allows us to look a subject up by their email
    private List<Entry> lookByEmail(String email){
        List<Entry> ans = new ArrayList<>();
        for (Entry entry : this.entries) {
            if(entry.getEmail().equals(email)){
                ans.add(entry);
            }
        }
        return new ArrayList<>();
    }

    //here we can print our whole contact list onto the console along with other possible outcomes
    public void printContactList() {
        if (this.entries.size() == 0) System.out.println("The contact list is empty");
        else{
            System.out.println("Printing the contact list...");
            System.out.println(this.toString());
        }
        System.out.println();
    }

    //this deletes the addressbook
    public void deleteAddressBook(){
        this.entries.clear();
        System.out.println("Deleted contact list. (You are now free to start over in a new city!) !\n");
    }

    @Override
    public String toString(){
        StringJoiner sj = new StringJoiner("\n");
        for (Entry entry : this.entries){
            sj.add(entry.toString());
        }
        return sj.toString();
    }


}

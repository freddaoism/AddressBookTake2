package com.company;
import java.util.ArrayList;


public class ContactList {
    private ArrayList<String> contactList = new ArrayList<String>();

    public ArrayList<String> getContactList() {
        return contactList;
    }

    public void addContactItem(String item) {
        contactList.add(item);
    }

    public void printContactList() {
        System.out.println("You have " + contactList.size() + " items in your grocery list");
        for(int i=0; i< contactList.size(); i++) {
            System.out.println((i+1) + ". " + contactList.get(i));
        }
    }

    public void modifyContactItem(String currentItem, String newItem) {
        int position = findItem(currentItem);
        if (position >= 0) {
            modifyContactItem(position, newItem);
        }
    }

   private void modifyContactItem(int position, String newItem) {
        contactList.set(position, newItem);
        System.out.println("Contact item " + (position+1) + " has been modified.");
    }

    public void removeContactItem(String item) {
        int position = findItem(item);
        if (position >= 0) {
            removeContactItem(position);
        }
    }
    private void removeContactItem(int position) {
            contactList.remove(position);
        }



    private int findItem(String searchItem) {
        return contactList.indexOf(searchItem);
        }


        public boolean onFile(String searchItem){
            int position = findItem(searchItem);
            if (position >= 0) {
                return true;
            }

            return false;
        }
    }


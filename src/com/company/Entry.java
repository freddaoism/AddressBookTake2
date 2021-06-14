package com.company;

import java.util.Objects;

//getters/setters and all that good stuff
//Here we can see encapsulation in action, we are bundling a lot of data into a single unit (that unit being the Entry class)

public class Entry {
    //only this class has access to the private variables
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    //This is our constructor that we will use to create Entry objects
    public Entry(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    //Something that I still find cool is that you can right click and automatically generate setters and getters...I've seen everybody here do it automatically before
    //but this project was actually my first time doing it
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone() {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }
//here we have a few override annotations that indicate when the child class method is over-writing its base class method.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entry entry = (Entry) o;
        return Objects.equals(getEmail(), entry.getEmail());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }

    @Override
    public String toString() {
        return  "|First Name: "
                + firstName

                + " | Last Name: "
                + lastName

                + " | Phone Number: "
                + phone

                + " | E-Mail: "
                + email

                + '|';
    }

}

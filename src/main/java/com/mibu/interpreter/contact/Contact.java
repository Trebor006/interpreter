package com.mibu.interpreter.contact;

public class Contact {

    private String firstName;
    private String lastName;
    private String title;
    private String organization;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String title, String organization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.organization = organization;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String newOrganization) {
        this.organization = newOrganization;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

package com.example.restapiodnowa;

import java.util.ArrayList;

public class Person {
    private String name;
    private String age;
    private String address;
    private String email;
    private String gender;
    private String picture;

    public Person(String name, String age, String address, String email, String gender, String picture) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.picture = picture;
    }

    public Person(){

    }

//    public static ArrayList<Person> createPerson(Person person) {
//        ArrayList<Person> contacts = new ArrayList<Person>();
//
//        contacts.add(new Person(person.getName(), person.getAge(), person.getAddress(), person.getEmail(), person.getGender(), person.getPicture()));
//
//        return contacts;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}

package org.example.springbootproject01.Pojo;

import java.util.Arrays;

public class User {
    private String name;
    private int age;
    private String[] hobby;

    public User(String name, int age, String[] hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }
    public User(){

    }
    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }
}

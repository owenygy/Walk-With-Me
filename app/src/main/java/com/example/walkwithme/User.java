package com.example.walkwithme;

public class User {
    Integer id;
    String userEmail;
    String password;
    String userName;
    String dateOfRegistration;
    String gender;
    Integer age;
    String major;
    Integer rating;
    String description;

    public User(Integer id, String userEmail, String password, String email, String dateOfRegistration,
                String gender, Integer age, String major, Integer rating, String description) {
        this.id = id;
        this.userEmail = userEmail;
        this.password = password;
        this.userName = email;
        this.dateOfRegistration = dateOfRegistration;
        this.gender = gender;
        this.age = age;
        this.major = major;
        this.rating = rating;
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                ", email='" + userName + '\'' +
                ", dateOfRegistration='" + dateOfRegistration + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}

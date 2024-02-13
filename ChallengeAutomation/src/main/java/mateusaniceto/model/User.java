package mateusaniceto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String maidenName;
    private Integer age;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String birthDate;
    private String image;
    private String bloodGroup;
    private Integer height;
    private Double weight;
    private String eyeColor;
    private Hair hair;
    private String domain;
    private String ip;
    private Address address;
    private String macAddress;
    private String university;
    private Bank bank;
    private Company company;
    private String ein;
    private String ssn;
    private String userAgent;
}

@AllArgsConstructor
@Data
@NoArgsConstructor
class Hair {
    private String color;
    private String type;
}

@AllArgsConstructor
@Data
@NoArgsConstructor
class Address {
    private String address;
    private String city;
    private Coordinates coordinates;
    private String postalCode;
    private String state;
}

@AllArgsConstructor
@Data
@NoArgsConstructor
class Coordinates {
    private double lat;
    private double lng;
}

@AllArgsConstructor
@Data
@NoArgsConstructor
class Bank {
    private String cardExpire;
    private String cardNumber;
    private String cardType;
    private String currency;
    private String iban;
}

@AllArgsConstructor
@Data
@NoArgsConstructor
class Company {
    private Address address;
    private String department;
    private String name;
    private String title;
}


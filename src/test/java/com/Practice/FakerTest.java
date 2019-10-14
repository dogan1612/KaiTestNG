package com.Practice;

import com.github.javafaker.Faker;

public class FakerTest {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String fact = faker.chuckNorris().fact();
        System.out.println(fact);
        System.out.println(faker.artist().name());

        System.out.println("Email: " + faker.internet().emailAddress());
        System.out.println("Address: " + faker.address());
        System.out.println("Ancient: " + faker.ancient());
        System.out.println("Pokeman: " + faker.pokemon().name());
        System.out.println("GoT-Dragon: " + faker.gameOfThrones().dragon());
        System.out.println("GoT-Character: " + faker.gameOfThrones().character());
        System.out.println("Weather: " + faker.weather().temperatureFahrenheit());
        System.out.println("Zelda: " + faker.zelda().game());
        System.out.println("Superhero Power: " + faker.superhero().power());
        System.out.println("CellNumber: " + faker.phoneNumber().cellPhone());
        System.out.println("Avatar Image: " + faker.avatar().image());
        System.out.println("Color: " + faker.color().name());
        System.out.println("Marital Status: " + faker.demographic().maritalStatus());
        System.out.println("Password: " + faker.internet().password());
        System.out.println("Password: " + faker.internet().password(7,15));
        System.out.println("Password: " + faker.internet().password(7,8,true, true,true));


        String pass = faker.internet().password();
        String uname = faker.gameOfThrones().character();

    }
}

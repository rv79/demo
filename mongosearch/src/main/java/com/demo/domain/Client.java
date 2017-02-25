package com.demo.domain;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by Herve on 22/02/2017.
 */

@Getter
@Setter
@Document(collection = "clients")
public class Client {
    @Id
    private String id;

    @Field("first_name")
    private String firstName;
    @Field("last_name")
    private String lastName;
    @Field("name")
    private String name;
    @Field("email")
    private String email;
    @Field("gender")
    private String gender;

    // default constructor
    @SuppressWarnings("unused")
    public Client () {}

    public void fake () {
        Faker faker = new Faker();

        this.firstName = faker.name().firstName(); // Emory
        this.lastName = faker.name().lastName(); // Barton
        this.name = this.firstName + " " + this.lastName;
    }

    public void reset () {
        this.id = null;
        this.firstName = null;
        this.lastName = null;
        this.name = null;
        this.email = null;
        this.gender = null;
    }
}

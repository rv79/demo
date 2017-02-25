package com.demo.repository;

import com.demo.domain.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Herve on 22/02/2017.
 */

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    List<Client> findByLastNameOrFirstNameAllIgnoreCase (String lastName, String firstName);

}

package com.masai.question1.repositories;

import com.masai.question1.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.KeyStore;
import java.util.Optional;

@Repository
public interface EntryRepo extends JpaRepository<KeyStore.Entry, Integer> {

    Optional<KeyStore.Entry> findByApi(String Api);

}
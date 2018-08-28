package com.library.domain.dao;

import com.library.domain.entities.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntryDao extends CrudRepository<Entry, Integer> {

    Optional<Entry> findByBookId(int bookId);
}

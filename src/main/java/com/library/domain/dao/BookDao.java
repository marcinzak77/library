package com.library.domain.dao;

import com.library.domain.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookDao extends CrudRepository<Book, Integer> {
    @Override
    Optional<Book> findById(Integer integer);
}

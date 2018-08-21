package com.library.domain.dao;

import com.library.domain.BookCopies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCopiesDao extends CrudRepository<BookCopies, Integer> {
}

package com.library.domain.dao;

import com.library.domain.BookHire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookHireDao extends CrudRepository<BookHire, Integer> {
}

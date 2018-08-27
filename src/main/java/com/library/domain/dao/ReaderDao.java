package com.library.domain.dao;

import com.library.domain.entities.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderDao extends CrudRepository<Reader, Integer> {
}

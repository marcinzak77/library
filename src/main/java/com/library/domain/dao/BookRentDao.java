package com.library.domain.dao;

import com.library.domain.entities.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRentDao extends CrudRepository<Entry, Integer> {
}
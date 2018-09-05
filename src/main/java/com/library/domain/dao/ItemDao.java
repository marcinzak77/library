package com.library.domain.dao;

import com.library.domain.entities.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDao extends CrudRepository<Item, Integer> {
    @Override
    List<Item> findAll();
}

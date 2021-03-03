package com.multiconnect.books.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface BookDao extends CrudRepository {

    List findByCreatedBy(Long userId);

}
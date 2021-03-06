package com.javatechie.multiple.ds.api.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.multiple.ds.api.model.book.Book;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    @Override
    Optional<Book> findById(Integer integer);
}

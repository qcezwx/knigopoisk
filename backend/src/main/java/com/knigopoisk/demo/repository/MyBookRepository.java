package com.knigopoisk.demo.repository;

import com.knigopoisk.demo.model.MyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBook, Long> {
}

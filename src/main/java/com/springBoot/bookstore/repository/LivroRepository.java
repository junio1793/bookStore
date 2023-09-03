package com.springBoot.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.bookstore.dominio.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
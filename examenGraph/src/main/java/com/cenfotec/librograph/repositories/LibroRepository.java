package com.cenfotec.librograph.repositories;

import com.cenfotec.librograph.entites.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

}


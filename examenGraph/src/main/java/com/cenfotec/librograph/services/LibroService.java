package com.cenfotec.librograph.services;

import com.cenfotec.librograph.entites.Libro;
import com.cenfotec.librograph.repositories.LibroRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    LibroRepository libroRepo;
    public List<Libro> getAllLibros(int count) {
        return
                this.libroRepo.findAll().stream().limit(count).collect(Collectors.toList());
    }
    public Optional<Libro> getLibro(int id) {
        return this.libroRepo.findById(id);
    }

    public Libro createLibro(String nombre, String descripcion, Integer hijo) {

        Libro libro = new Libro();
        libro.setNombre(nombre);
        libro.setDescripcion(descripcion);
        libro.setHijo(hijo);
        return this.libroRepo.save(libro);
    }
    public void updateLibro(Libro libroToUpdate) {
        this.libroRepo.save(libroToUpdate);
    }

}

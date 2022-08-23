package com.cenfotec.librograph.mutation;

import com.cenfotec.librograph.entites.Libro;
import com.cenfotec.librograph.services.LibroService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LibroMutation implements GraphQLMutationResolver {

    @Autowired
    private LibroService libroService;

    public Libro createLibro(String nombre, String descripcion, Integer hijo) {
        return this.libroService.createLibro( nombre, descripcion, hijo);
    }

    public Libro updateLibro(Integer id,String nombre, String descripcion, Integer hijo){
        Optional<Libro> libro = libroService.getLibro(id);
        if (libro.isPresent()){
            Libro libroToUpdate = libro.get();
            libroToUpdate.setNombre(nombre);
            libroToUpdate.setDescripcion(descripcion);
            libroToUpdate.setHijo(hijo);
            libroService.updateLibro(libroToUpdate);
            return libroToUpdate;
        }
        return null;

    }

}


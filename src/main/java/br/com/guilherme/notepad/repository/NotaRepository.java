package br.com.guilherme.notepad.repository;

import br.com.guilherme.notepad.model.Nota;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends MongoRepository<Nota, String> {
    Nota findByTitulo(String titulo);
}

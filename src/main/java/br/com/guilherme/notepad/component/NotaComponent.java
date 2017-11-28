package br.com.guilherme.notepad.component;

import br.com.guilherme.notepad.model.Nota;
import br.com.guilherme.notepad.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotaComponent {

    @Autowired
    NotaRepository notaRepository;

    public void salvar(Nota nota) {
        Nota notaS = notaRepository.findByTitulo(nota.getTitulo());
        if(notaS != null) {
            nota.setId(notaS.getId());
        }
        notaRepository.save(nota);
    }

    public Nota buscarNota(String titulo) {
        Nota nota = notaRepository.findByTitulo(titulo);

        if(nota != null) {
            return nota;
        }

        return new Nota();
    }

    public List<Nota> buscarTodos() {
        return notaRepository.findAll();
    }

    public void apagar(String titulo) {
        Nota nota = notaRepository.findByTitulo(titulo);
        if(nota != null) {
            notaRepository.delete(nota);
        }
    }

    public void apagarTodos() {
        notaRepository.deleteAll();
    }
}

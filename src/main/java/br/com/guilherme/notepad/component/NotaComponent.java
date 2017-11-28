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
        List<Nota>  notas = notaRepository.findByTitulo(nota.getTitulo());
        if(!notas.isEmpty()) {
            nota.setId(notas.get(0).getId());
        }
        notaRepository.save(nota);
    }

    public Nota buscarNota(String titulo) {
        Nota nota;
        List<Nota> notas = notaRepository.findByTitulo(titulo);
        if(notas.isEmpty()) {
            return new Nota();
        }
        else {
            return notas.get(0);
        }
    }

    public List<Nota> buscarTodos() {
        return notaRepository.findAll();
    }

    public void apagar(String titulo) {
        Nota nota;
        List<Nota> notas = notaRepository.findByTitulo(titulo);
        if(!notas.isEmpty()) {
            notaRepository.delete(notas.get(0));
        }
    }

    public void apagarTodos() {
        notaRepository.deleteAll();
    }
}

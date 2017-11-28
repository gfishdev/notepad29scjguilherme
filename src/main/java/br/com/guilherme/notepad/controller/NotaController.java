package br.com.guilherme.notepad.controller;

import br.com.guilherme.notepad.component.NotaComponent;
import br.com.guilherme.notepad.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "nota")
public class NotaController {

    @Autowired
    public NotaComponent notaComponent;


    @GetMapping("/titulo/{titulo}")
    public Nota buscarNota(@PathVariable(value = "titulo") String titulo) {
        return notaComponent.buscarNota(titulo);
    }

    @GetMapping()
    public List<Nota> buscarTodos() {
        return notaComponent.buscarTodos();
    }

    @DeleteMapping("/titulo/{titulo}")
    public void apagar(@PathVariable(value = "titulo") String titulo) {
        notaComponent.apagar(titulo);
    }

    @DeleteMapping()
    public void apagarTodos() {
        notaComponent.apagarTodos();
    }

    @PostMapping
    public void salvar(@RequestBody Nota nota) {
        notaComponent.salvar(nota);
    }
}

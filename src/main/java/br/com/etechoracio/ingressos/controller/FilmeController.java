package br.com.etechoracio.ingressos.controller;

import br.com.etechoracio.ingressos.entity.Filme;
import br.com.etechoracio.ingressos.enums.ClassificacaoIndicativaEnum;
import br.com.etechoracio.ingressos.enums.SimNaoEnum;
import br.com.etechoracio.ingressos.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    List<Long> idsExistentes = List.of(1L, 2L,3L);
    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public List<Filme> listar(){
        return filmeRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id){
        var filme = filmeRepository.findById(id);
        if(filme.isPresent())
            return ResponseEntity.ok(filme.get());
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Filme> cadastrar(@RequestBody Filme filme){
        filme = filmeRepository.save(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(filme);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if(idsExistentes.contains(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public Filme atualizar(@PathVariable Long id,
                           @RequestBody Filme novoFilme){
        var filme = filmeRepository.findById(id);
        if(filme.isPresent()) {
            novoFilme.setId(filme.get().getId());
            novoFilme = filmeRepository.save(novoFilme);
        }
        return novoFilme;
    }

}

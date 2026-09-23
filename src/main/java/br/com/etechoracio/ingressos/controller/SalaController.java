package br.com.etechoracio.ingressos.controller;

import br.com.etechoracio.ingressos.entity.Filme;
import br.com.etechoracio.ingressos.entity.Sala;
import br.com.etechoracio.ingressos.repository.FilmeRepository;
import br.com.etechoracio.ingressos.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@RequestMapping ("/salas")
@RestController
@CrossOrigin("*")
public class SalaController {
    @Autowired
    private SalaRepository salaRepository;


    @GetMapping
    public List<Sala> listar(){
        return salaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> buscarPorId(@PathVariable Long id) {
        var sala = salaRepository.findById(id);
        if(sala.isPresent())
            return ResponseEntity.ok(sala.get());
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<Sala> cadastrar(@RequestBody Sala sala){
        sala = salaRepository.save(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(sala);
    }








}

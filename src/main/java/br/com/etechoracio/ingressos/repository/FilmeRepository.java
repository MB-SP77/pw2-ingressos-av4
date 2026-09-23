package br.com.etechoracio.ingressos.repository;

import br.com.etechoracio.ingressos.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeRepository extends JpaRepository  <Filme, Long > {


}

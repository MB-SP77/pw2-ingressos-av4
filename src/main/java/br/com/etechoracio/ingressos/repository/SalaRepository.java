package br.com.etechoracio.ingressos.repository;


import br.com.etechoracio.ingressos.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long > {
}

package com.algaworks.algatransito.domain.repository;

import com.algaworks.algatransito.domain.model.Cnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CnhRepository extends JpaRepository<Cnh, Long> {

    public Cnh findByNumeroRegistro(String numeroRegistro);

}

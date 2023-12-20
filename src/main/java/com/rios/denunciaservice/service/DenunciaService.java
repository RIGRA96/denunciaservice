package com.rios.denunciaservice.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.rios.denunciaservice.entity.Denuncia;

public interface DenunciaService {
	List<Denuncia> findAll(Pageable page);
    List<Denuncia> findByTitulo(String titulo, Pageable page);
    Denuncia findById(int id);
    Denuncia save(Denuncia denuncia);
    Denuncia update(Denuncia denuncia);
    void delete(int id);
}

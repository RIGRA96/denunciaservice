package com.rios.denunciaservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rios.denunciaservice.entity.Denuncia;
import com.rios.denunciaservice.repository.DenunciaRepository;
import com.rios.denunciaservice.service.DenunciaService;

import jakarta.transaction.Transactional;

@Service
public class DenunciaServiceImpl implements DenunciaService{
	@Autowired
    private DenunciaRepository repository;

    @Override
    @Transactional
    public List<Denuncia> findAll(Pageable page) {
        try {
            return repository.findAll(page).toList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public List<Denuncia> findByTitulo(String titulo, Pageable page) {
        try {
            return repository.findByTituloContaining(titulo, page);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public Denuncia findById(int id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public Denuncia save(Denuncia denuncia) {
        try {
            denuncia.setActivo(true);
            return repository.save(denuncia);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public Denuncia update(Denuncia denuncia) {
        try {
            Denuncia registro = repository.findById(denuncia.getId()).orElseThrow();
            registro.setDni(denuncia.getDni());
            registro.setFecha(denuncia.getFecha());
            registro.setTitulo(denuncia.getTitulo());
            registro.setDireccion(denuncia.getDireccion());
            registro.setDescripcion(denuncia.getDescripcion());
            repository.save(registro);
            return registro;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            // Manejar la excepción, por ejemplo, lanzar una propia o loggearla.
        }
    }
}

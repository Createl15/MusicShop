package com.example.zlatik.service;

import com.example.zlatik.entity.ContainsBand;
import com.example.zlatik.repository.ContainsBandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContainsBandService {

    @Autowired
    private ContainsBandRepository containsBandRepository;
    @Async
    public List<ContainsBand> getAll() {
        return containsBandRepository.findAll();
    }
    @Async
    public ContainsBand getById(Long id_containsband) {
        return containsBandRepository.findById(id_containsband).orElse(null);
    }
    @Async
    public void create(ContainsBand containsBand) {
        containsBandRepository.save(containsBand);
    }
    @Async
    public void delete(Long id_containsband) {
        containsBandRepository.deleteById(id_containsband);
    }
    @Async
    public void update(ContainsBand containsBand) {
        ContainsBand containsBand1 = getById(containsBand.getId());
        containsBand1.setAlbum(containsBand.getAlbum());
        containsBand1.setBand(containsBand.getBand());
        containsBandRepository.save(containsBand1);
    }
}
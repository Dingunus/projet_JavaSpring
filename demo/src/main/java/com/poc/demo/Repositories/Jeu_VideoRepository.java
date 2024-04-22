package com.poc.demo.Repositories;

import com.poc.demo.Entities.*;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface Jeu_VideoRepository extends JpaRepository<Jeu_Video, Long>{
    
}

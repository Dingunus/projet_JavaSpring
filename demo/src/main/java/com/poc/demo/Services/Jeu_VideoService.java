package com.poc.demo.Services;

import com.poc.demo.Repositories.Jeu_VideoRepository;
import com.poc.demo.Entities.Jeu_Video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Jeu_VideoService {
    @Autowired
    private Jeu_VideoRepository jeu_VideoRepository;

   
     


    public List<Jeu_Video> getAllJeu_Video(){
        return jeu_VideoRepository.findAll();
    }

    public Jeu_Video getJeu_VideoById(Long id) {
        return jeu_VideoRepository.findById(id).orElse(new Jeu_Video());
    }

    public Jeu_Video addJeu_Video(Jeu_Video Jeu_Video) {
        return jeu_VideoRepository.save(Jeu_Video);
    }

    public Jeu_Video updateJeu_Video(Long id, Jeu_Video Jeu_VideoDetails) {
        Jeu_Video Jeu_Video = jeu_VideoRepository.findById(id).orElse(null);
        if (Jeu_Video != null) {
            Jeu_Video.setTitre(Jeu_VideoDetails.getTitre());
            Jeu_Video.setEditeur(Jeu_VideoDetails.getEditeur());
            Jeu_Video.setGenre(Jeu_VideoDetails.getGenre());
            Jeu_Video.setPrix(Jeu_VideoDetails.getPrix());
            Jeu_Video.setDescription(Jeu_VideoDetails.getDescription());
            return jeu_VideoRepository.save(Jeu_Video);
        }
        return null;
    }

    public void deleteJeu_Video(Long id) {
        jeu_VideoRepository.deleteById(id);
    }
}

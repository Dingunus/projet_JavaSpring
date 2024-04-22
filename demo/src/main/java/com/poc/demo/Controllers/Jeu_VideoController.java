package com.poc.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.poc.demo.Entities.Jeu_Video;
import com.poc.demo.Services.Jeu_VideoService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class Jeu_VideoController {

    private final Jeu_VideoService service;

    public Jeu_VideoController(Jeu_VideoService service){ this.service = service; }
    
    @GetMapping("/rest/games")
    public List<Jeu_Video> getJeu_Videos() {
        return service.getAllJeu_Video();
    }


    @GetMapping("/rest/games/{id}")
    public Jeu_Video getJeu_Video(@PathVariable Long id) {
        return service.getJeu_VideoById(id);
    }
    
    @PostMapping("/rest/games")
    public Jeu_Video addJeu_Video(@RequestBody Jeu_Video newJeu_Video) {
        return service.addJeu_Video(newJeu_Video);
    }
    
    @PutMapping("/rest/games/{id}")
    public Jeu_Video updateJeu_Video(@PathVariable Long id, @RequestBody Jeu_Video newJeu_Video) {
        return service.updateJeu_Video(id, newJeu_Video);
    }

    @DeleteMapping("/rest/games/{id}")
    public void delPersonne(@PathVariable Long id){
        service.deleteJeu_Video(id);
    }
}

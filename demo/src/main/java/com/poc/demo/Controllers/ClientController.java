package com.poc.demo.Controllers;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.poc.demo.Entities.Jeu_Video;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class ClientController {
    private RestTemplate template;

    @GetMapping("/")
    public String index(Model model){
        this.template = new RestTemplate();
        String url = "http://localhost:8080/rest/games";
        ResponseEntity<List<Jeu_Video>> response = template.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Jeu_Video>>() { });
        List<Jeu_Video> jeu_Videos = response.getBody();
        model.addAttribute("games", jeu_Videos);
        return "index";
    }

    @GetMapping("/games/{id}")
    public String getJeuDetail(Model model, @PathVariable long id) {
        this.template = new RestTemplate();
        String url = "http://localhost:8080/rest/games/{id}";
        ResponseEntity<Jeu_Video> response = template.getForEntity(
            url,
            Jeu_Video.class,
            id);
        Jeu_Video jeu = response.getBody();
        model.addAttribute("game", jeu);
        return "detail";
    }
    


    @GetMapping("/form/add")
    public String formPersonne(Model model){    
        Jeu_Video jeu = new Jeu_Video();
        model.addAttribute("games", jeu);
        return "form";
    }

    @GetMapping("/maj/{id}")
    public String majPersonne(Model model, @PathVariable long id){
        this.template = new RestTemplate();
        String url = "http://localhost:8080/rest/games/{id}";
        ResponseEntity<Jeu_Video> response = template.getForEntity(
            url,
            Jeu_Video.class,
            id);
        Jeu_Video jeu = response.getBody();
        model.addAttribute("games", jeu);
        return "form";
    }

    @PostMapping("/form/add")
    public String addJeu_Video(@ModelAttribute("games") Jeu_Video jeu) {
        this.template = new RestTemplate();
        String url = "http://localhost:8080/rest/games";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Jeu_Video> request = new HttpEntity<>(jeu, headers);
        ResponseEntity<Jeu_Video> response = template.postForEntity(
            url,
            request, 
            Jeu_Video.class);
        
        return "redirect:/";
    }

    @PostMapping("/maj/{id}")
    public String majJeu_Video(@ModelAttribute("games") Jeu_Video jeu, @PathVariable long id) {
        this.template = new RestTemplate();
        String url = "http://localhost:8080/rest/games/{id}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Jeu_Video> request = new HttpEntity<>(jeu, headers);
        ResponseEntity<Jeu_Video> response = template.exchange(
            url,
            HttpMethod.PUT, 
            request,
            Jeu_Video.class,
            id);
        
        return "redirect:/";
    }
    
    @GetMapping("/del/{id}")
    public String delJeu_Video(@ModelAttribute("games") Jeu_Video jeu, @PathVariable long id) {
        
        this.template = new RestTemplate();
        String url = "http://localhost:8080/rest/games/{id}";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Jeu_Video> request = new HttpEntity<>(jeu, headers);
        template.delete(url,id);
        return "redirect:/";
    }
    

}

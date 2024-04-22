package com.poc.demo.ApplicationRunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.poc.demo.Entities.Jeu_Video;
import com.poc.demo.Repositories.Jeu_VideoRepository;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final Jeu_VideoRepository jeu_VideoRepository;

    public DatabaseLoader(Jeu_VideoRepository jeu_VideoRepository) {
        this.jeu_VideoRepository = jeu_VideoRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Jeu_Video CS = new Jeu_Video();
        CS.setEditeur("Valve");
        CS.setGenre("FPS");
        CS.setTitre("Counter Strike 2");
        CS.setPrix(0d);
        CS.setDescription("Counter-Strike, c'est l'expérience compétitive par excellence qui réunit "+
                          "des millions de personnes depuis plus de vingt ans. L\'heure est venue d\'écrire "+
                          "le prochain chapitre de l\'histoire de Counter-Strike. "+
                          "Faites place à Counter-Strike 2.");
        jeu_VideoRepository.save(CS);

        Jeu_Video Celeste = new Jeu_Video();
        Celeste.setEditeur("Maddy Makes Games");
        Celeste.setGenre("Platformer");
        Celeste.setTitre("Celeste");
        Celeste.setPrix(15.99d);
        Celeste.setDescription("Aidez Madeline à survivre à ses démons intérieurs au mont Celeste, dans ce jeu de plateformes ultra relevé, réalisé par les créateurs du classique TowerFall. Relevez des centaines de défis faits à la main, découvrez tous les secrets et dévoilez le mystère de la montagne.");
        jeu_VideoRepository.save(Celeste);

        Jeu_Video Kh = new Jeu_Video();
        Kh.setEditeur("Square Enix");
        Kh.setGenre("RPG");
        Kh.setTitre("Kingdom Hearts");
        Kh.setPrix(49.99d);
        Kh.setDescription("L'île du Destin est un refuge paradisiaque où résonnent les rires des enfants. Dans cet endroit sans adultes, Sora, Riku et Kairi rêvent de rejoindre les territoires inconnus qui entourent sans doute leur île. Comme beaucoup d'adolescents, ils se posent des questions sur le monde extérieur, et sur eux-mêmes.");
        jeu_VideoRepository.save(Kh);
        //throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
    
}

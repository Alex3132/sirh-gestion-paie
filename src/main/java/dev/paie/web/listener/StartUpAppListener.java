package dev.paie.web.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.ROLES;
import dev.paie.repository.UtilisateurRepository;


@Component
public class StartUpAppListener {

	@Autowired UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        // capture du démarrage de l'application
        // à un moment où le contexte Spring est complètement créé
 
    
 
        // TODO insérer des utilisateurs en base de données
    Utilisateur u = new Utilisateur();
    u.setNomUtilisateur("Alex");
    u.setMotDePasse(passwordEncoder.encode("password"));
    u.setRole(ROLES.ROLE_UTILISATEUR);
    u.setEstActif(true);
    utilisateurRepository.save(u);
    }
}
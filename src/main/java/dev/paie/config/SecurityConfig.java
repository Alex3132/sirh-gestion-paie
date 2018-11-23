package dev.paie.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true) 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// injection du bean de hashage de mot de passage
	@Autowired
	private PasswordEncoder passwordEncoder;

	// injection du bean de source de données
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		  auth.jdbcAuthentication() 

          // configuration de la source de données
          .dataSource(dataSource)

          // configuration de l'algorithme de hashage des mots de passe
          .passwordEncoder(passwordEncoder)

          // requête pour obtenir les informations d'un utilisateur en fonction du nom d'utilisateur
          .usersByUsernameQuery("select nom_utilisateur, mot_de_passe, est_actif from utilisateur where nom_utilisateur=?")

          // requête pour obtenir les rôles d'un utilisateur
          .authoritiesByUsernameQuery("select nom_utilisateur,role from utilisateur where nom_utilisateur = ?"); 
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/mvc/connexion").permitAll();
	}

}
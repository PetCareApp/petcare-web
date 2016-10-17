package br.cap7.petcare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.cap7.petcare.model.Papel.NomePapel;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/**").hasAuthority(NomePapel.ADMINISTRACAO.toString())
			.antMatchers("/proprietario/**").hasAuthority(NomePapel.PROPRIETARIO.toString())
			.antMatchers("/css/**").permitAll().antMatchers("/js/**").permitAll()
			.antMatchers("/fonts/**").permitAll().antMatchers("/img/**").permitAll()
			.antMatchers("/rest/**").permitAll()
			.anyRequest().fullyAuthenticated()    
			.and().formLogin().loginProcessingUrl("/login").loginPage("/login").permitAll()
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

}

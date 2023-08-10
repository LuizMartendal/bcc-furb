package br.furb.restapifurb.configurations;

import br.furb.restapifurb.security.JwtTokenFilter;
import br.furb.restapifurb.security.JwtTokenProvider;
import br.furb.restapifurb.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UsuarioService usuarioService;

    private static final String[] PUBLIC_MATCHER = {"/swagger-ui/**", "/swagger-ui.html", "/v3/**"};
    private static final String[] PUBLIC_MATCHER_POST = {"/login", "/usuario", "swagger-ui/index.html"};
    private static final String[] PUBLIC_MATCHER_GET = {"/produto", "/*.js", "/*.js.map", "/*.html", "/", "/*.css", "/*.json",
            "/*.woff2", "/*.woff", //
            "/*.png", "/assets/**", "/svg/**", "/actuator/**"};

    private static final String[] PRIVATE_MATCHER_POST_ADMIN = {"/produto"};
    private static final String[] PRIVATE_MATCHER_PUT_ADMIN = {"/produto/**"};
    private static final String[] PRIVATE_MATCHER_DELETE_ADMIN = {"/produto/**"};
    private static final String[] PRIVATE_MATCHER_GET_ADMIN = {"/usuario", "/comanda"};

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeRequests(
                        authorizeRequests -> authorizeRequests
                                .antMatchers(HttpMethod.POST, PUBLIC_MATCHER_POST).permitAll()
                                .antMatchers(HttpMethod.GET, PUBLIC_MATCHER_GET).permitAll()
                                .antMatchers(HttpMethod.POST, PRIVATE_MATCHER_POST_ADMIN).hasRole("ADMIN")
                                .antMatchers(HttpMethod.PUT, PRIVATE_MATCHER_PUT_ADMIN).hasRole("ADMIN")
                                .antMatchers(HttpMethod.DELETE, PRIVATE_MATCHER_DELETE_ADMIN).hasRole("ADMIN")
                                .antMatchers(HttpMethod.GET, PRIVATE_MATCHER_GET_ADMIN).hasRole("ADMIN")
                                .antMatchers(PUBLIC_MATCHER).permitAll()
                                .anyRequest().authenticated()
                )
                .headers().frameOptions().disable()
                .and()
                .addFilterBefore(new JwtTokenFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
    }

    @Bean
    AuthenticationManager getAuthenticationManager() throws Exception {
        return authenticationManager();
    }

}

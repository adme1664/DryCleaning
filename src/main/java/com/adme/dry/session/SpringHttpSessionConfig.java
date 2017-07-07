package com.adme.dry.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.web.http.SessionRepositoryFilter;

/**
 * Created by Adme System on 7/4/2017.
 */
@EnableSpringHttpSession
@Configuration
public class SpringHttpSessionConfig {
    @Bean
    public MapSessionRepository sessionRepository(){
        return new MapSessionRepository();
    }
}

package com.natWest.app;

import com.natWest.app.config.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

@SpringBootApplication
public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(App.class);
        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
        defaultToDevProfile(application, source);

        Environment env = application.run(args).getEnvironment();
        log.info("Running at Port {}", env.getProperty("server.port"));
    }

    /**
     * If no profile has been configured, set by default the "dev" profile.
     */
    private static void defaultToDevProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
        if (!source.containsProperty("spring.profiles.active") &&
                !System.getenv().containsKey("SPRING_PROFILES_ACTIVE")) {
            app.setAdditionalProfiles(Constant.SPRING_PROFILE_DEVELOPMENT);
        }
    }
}

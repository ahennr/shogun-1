package de.terrestris.shogun.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ShogunConfigServer {

    public static void main(String[] args) {
        SpringApplication.run(ShogunConfigServer.class, args);
    }

}

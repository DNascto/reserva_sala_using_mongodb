package com.dnascto.ionic.practicing.config.property;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConfigurationProperties("reservas")
public class ReservasApiProperty {

    private String allowedOrigin = "http://localhost:8100";
//    private String allowedOrigin = new String[]{"https://dry-journey-31622.herokuapp.com", "http://localhost:8100"};

    private final Security security = new Security();

    private final Mail mail = new Mail();

    @Getter
    public static class Security {
        private boolean enableHttps;
    }

    @Data
    public static class Mail {
        private String host;
        private Integer port;
        private String username;
        private String password;
    }
}

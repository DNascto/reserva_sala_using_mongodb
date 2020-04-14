package com.dnascto.ionic.practicing.config;

import com.dnascto.ionic.practicing.config.property.ReservasApiProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Autowired
    private ReservasApiProperty reservasApiProperty;

    @Bean
    public JavaMailSender javaMailSender() {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.oauth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.connectiontimeout", 10000);

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setJavaMailProperties(properties);
        mailSender.setHost(reservasApiProperty.getMail().getHost());
        mailSender.setPort(reservasApiProperty.getMail().getPort());
        mailSender.setUsername(reservasApiProperty.getMail().getUsername());
        mailSender.setPassword(reservasApiProperty.getMail().getPassword());

        return mailSender;
    }

}

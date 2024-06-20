package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("principal")
public class InfoPortServerImpl {


    @Value("${server.port}")
    private Integer port;


    public Integer getPort() {
        return port;
    }







}

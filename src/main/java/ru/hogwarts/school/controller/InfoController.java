package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.service.InfoPortServerImpl;

@RestController
public class InfoController {

    private final InfoPortServerImpl infoPortServer;

    public InfoController(InfoPortServerImpl infoPortServer) {
        this.infoPortServer = infoPortServer;
    }

    @GetMapping("/port")
    public Integer getPort1() {
        return infoPortServer.getPort();
    }

    @GetMapping("calculate")
    public void calculate() {
        infoPortServer.calculate();
    }
}



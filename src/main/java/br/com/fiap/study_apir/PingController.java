package br.com.fiap.study_apir;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    public String ping(){
        return "pong";
    }
}

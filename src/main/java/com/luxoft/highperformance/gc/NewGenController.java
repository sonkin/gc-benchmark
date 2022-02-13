package com.luxoft.highperformance.gc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewGenController {

    @GetMapping("new")
    public int allocateNew() {
        byte[] b = new byte[10_000];
        return b.length;
    }

    @GetMapping("big")
    public int allocateBig() {
        byte[] b = new byte[1000_000];
        return b.length;
    }

    @GetMapping("simple")
    public String simple() {
        return "I'm very simple";
    }

}

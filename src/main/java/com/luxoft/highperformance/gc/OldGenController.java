package com.luxoft.highperformance.gc;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class OldGenController {

    Set<byte[]> cache = new HashSet<>();

    @GetMapping("old")
    public int allocateArray() {
        byte[] b = new byte[1000];
        cache.add(b);
        return b.length;
    }

    @Scheduled(fixedRate = 10000)
    public void clearCache() {
        cache.clear();
    }

}

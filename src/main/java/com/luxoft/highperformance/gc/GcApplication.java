package com.luxoft.highperformance.gc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// New gen, Java 11
// GC algorithm                 avg     median      95%     99%         max     throughput
// G1                           25      26          41      113
// -XX:+UseParallelGC           27      26          40      181
// -XX:+UseShenandoahGC         37      35          89      155

// Old gen GC, Java 11
// GC algorithm                 avg     median      95%     99%         max     throughput
// G1                           51      31          226      470        2462        7700
// -XX:+UseParallelGC           91      34          273      1111       2600        5700
// -XX:+UseShenandoahGC         70      63          172      266        1030        6500

// Old gen GC, Java 17
// GC algorithm                 avg      median      95%     99%         max     throughput
// -XX:+UseShenandoahGC         120      99          290      476        2535        4100
// G1                           111      85          294      504        2165        4300
// -XX:+UseParallelGC           94       75          271      494        1848        4800

// Allocate 1Mb, Java 11
// GC algorithm                 avg      median      95%     99%         max     throughput
// G1                           75       68          163      255        727         6400
// -XX:+UseShenandoahGC         208      181         275      866        3380        2400
// -XX:+UseParallelGC           43       42          106      186        533         9600

// -Xmx128m -Xlog:gc
// -XX:+UsePerfData -XX:+UnlockExperimentalVMOptions -XX:+ShenandoahRegionSampling
@SpringBootApplication
@EnableScheduling
public class GcApplication {

    public static void main(String[] args) {
        SpringApplication.run(GcApplication.class, args);
    }

}

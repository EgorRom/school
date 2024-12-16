package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.stream.LongStream;
import java.util.stream.Stream;

@Service
public class InfoPortServerImpl {
    private final Logger logger = LoggerFactory.getLogger(InfoPortServerImpl.class);


    @Value("${server.port}")
    private Integer port;
    private static final Long limit = 1_000_000L;


    public Integer getPort() {
        return port;
    }

    public void calculate() {
        // 3,4,5,= время 0 сек, самые быстрые варианты, убрал первые 2, 3 вариант замедлился с 0 сек до 6,
        // при удалении 3 варината: 4-2 сек, 5-0 сек;
        //Вывод: 5 вариант с использованием подсчёта арифметической последовательности самый быстрый в данном примере
        //calculate1();
        // calculate2();
        // calculate3();
        // calculate4();
        calculate5();
        logger.info("------------------------");

    }


//    public void calculate1() {
//        long start = System.currentTimeMillis();
//
//        long sum = Stream.iterate(1L, a -> a + 1)
//                .limit(limit)
//                .reduce(0L, (a, b) -> a + b);
//
//        long end = System.currentTimeMillis();
//
//        logger.info("Time 1: " + (end - start) + ", result: " + sum);
//    }
//
//    private void calculate2() {
//        long start = System.currentTimeMillis();
//
//        long sum = Stream.iterate(1L, a -> a + 1)
//                .limit(limit)
//                .parallel()
//                .reduce(0L, (a, b) -> a + b);
//
//        long end = System.currentTimeMillis();
//
//        logger.info("Time 2: " + (end - start) + ", result: " + sum);
//    }

//    public void calculate3() {
//        long start = System.currentTimeMillis();
//
//        long sum = LongStream.rangeClosed(1, limit)
//                .reduce(0L, Long::sum);
//
//        long end = System.currentTimeMillis();
//
//        logger.info("Time 3: " + (end - start) + ", result: " + sum);
//    }

//    private void calculate4() {
//        long start = System.currentTimeMillis();
//
//        long sum = 0;
//        for (int i = 1; i <= limit; i++) {
//            sum += i;
//
//        }
//
//        long end = System.currentTimeMillis();
//
//        logger.info("Time 4: " + (end - start) + ", result: " + sum);
//    }

    private void calculate5() {
        long start = System.currentTimeMillis();

        long sum = (limit / 2) * (1 + limit);


        long end = System.currentTimeMillis();

        logger.info("Time 5: " + (end - start) + ", result: " + sum);
    }


}

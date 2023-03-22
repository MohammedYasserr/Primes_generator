package com.natWest.app.domain.primesgenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

class ParallelStreamPrimesGenerator implements PrimesGenerator {

    private final Long upperLimit;
    private final Long lowerLimit;

    @Override
    public Long getUpperLimit() {
        return this.upperLimit;
    }

    ParallelStreamPrimesGenerator(Long upperLimit) {
        this(2L, upperLimit);
    }

    private ParallelStreamPrimesGenerator(Long lowerLimit, Long upperLimit) {
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
    }

    @Override
    public List<Long> generatePrimes() {
        return LongStream
                .rangeClosed(lowerLimit, upperLimit)
                .parallel()
                .filter(i -> isPrime(i))
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean isPrime(long x) {
        return LongStream
                .rangeClosed(2L, (long) (Math.sqrt(x)))
                .parallel()
                .allMatch(n -> x % n != 0);
    }
}

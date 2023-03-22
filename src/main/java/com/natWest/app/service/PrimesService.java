package com.natWest.app.service;

import com.natWest.app.domain.PrimesResult;
import com.natWest.app.domain.primesgenerator.PrimesGenerator;

import java.util.List;
import java.util.Optional;

public interface PrimesService {
    List<PrimesResult> getPrimesResults();

    Optional<PrimesResult> getPrimesResult(String resultId);

    PrimesResult generatePrime(Long upperLimit, Optional<PrimesGenerator.PrimesStrategy> algorithm);

    void pruneCacheOlderThanInterval(long intervalInMinutes);
}

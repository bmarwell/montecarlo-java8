package de.bmarwell.java.montecarlo.mmillerrabintest;

import de.bmarwell.java.montecarlo.java8.millerrabintest.MillerRabinTest;
import de.bmarwell.java.montecarlo.java8.millerrabintest.PrimeResult;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class TestProbablePrime {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void test() {
    Set<PrimeResult> probablePrime = MillerRabinTest.getProbablePrime(10, 20, 100);
    probablePrime.stream().sorted((one, next) -> Long.compare(one.getPrime(), next.getPrime()))
        .forEach(r -> System.out.println("The number " + r.getPrime() + " is to " + r.getProbability() + " prime."));
  }

}

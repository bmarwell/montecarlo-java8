/**
 *
 */
package de.bmarwell.java.montecarlo.java8.millerrabintest;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 *
 */
public class MillerRabinTest {

  public static void main(String[] args) {
    long min = Long.parseLong(args[0]);
    long max = Long.parseLong(args[1]);
    long iterations = Long.parseLong(args[2]);

    Set<PrimeResult> probablePrime = getProbablePrime(min, max, iterations);

    probablePrime.stream().sorted()
        .forEach(r -> System.out.println("The number " + r.getPrime() + " is to " + r.getProbability() + " prime."));
  }

  public static Set<PrimeResult> getProbablePrime(long min, long max, long iterations) {
    if (min % 2 == 0) {
      min++;
    }

    return LongStream.iterate(min, n -> n + 2).limit(max / 2)
        .parallel()
        .mapToObj(n -> new PrimeResult(n, MillerRabinTest.probabilityPrime(n, iterations)))
        .collect(Collectors.toSet());
  }

  public static double probabilityPrime(long numberToTest, long iterations) {
    return 0.0;
  }

}

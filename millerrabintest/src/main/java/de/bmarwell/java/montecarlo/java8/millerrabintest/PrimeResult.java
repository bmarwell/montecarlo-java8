package de.bmarwell.java.montecarlo.java8.millerrabintest;

public class PrimeResult {

  private long prime;
  private double probability;

  public PrimeResult(long prime, double probability) {
    this.prime = prime;
    this.probability = probability;
  }

  public long getPrime() {
    return prime;
  }

  public double getProbability() {
    return probability;
  }

  @Override
  public String toString() {
    return "PrimeResult [getPrime()=" + getPrime() + ", getProbability()=" + getProbability() + "]";
  }

}

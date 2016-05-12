/**
 *
 */
package de.bmarwell.java.montecarlo.java8.pi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.stream.LongStream;

/**
 * @author bmarwell
 *
 */
public class PiMonteCarlo {

  /**
   * Logger…
   */
  private static final Logger LOG = LoggerFactory.getLogger(PiMonteCarlo.class);

  /**
   * Start pi calculation.
   *
   * @param args
   *          the first arg is how many tries we use.
   */
  public static void main(String[] args) {
    if (args.length == 0) {
      LOG.error("Parameter: number of tries missing");

      throw new IllegalArgumentException("Paramter: number of tries missing.");
    }

    long tries = Long.parseLong(args[0]);
    Random random = new Random();
    random.setSeed(System.currentTimeMillis());

    /*
     * The parallel is important, as we want to use all cores. In a professional environment, we
     * would inject an ExecutorService instead.
     *
     * Also, we need to declare the num, but we just don't use it.
     *
     * Then, we just count the number of hits.
     */
    long hits = LongStream.range(0, tries)
        .parallel()
        .filter(num -> PiMonteCarlo.isHit(random))
        .count();

    LOG.info("Pi is about [{}].", hits * 4.0 / tries);
  }

  /**
   * MonteCarlo-Algorithm: If dot is on a quarter circle, we count it.
   *
   * @param random
   *          a random instance.
   * @return true, if hit.
   */
  public static boolean isHit(Random random) {
    double x = random.nextDouble();
    double y = random.nextDouble();

    return Math.hypot(x, y) <= 1;
  }

}

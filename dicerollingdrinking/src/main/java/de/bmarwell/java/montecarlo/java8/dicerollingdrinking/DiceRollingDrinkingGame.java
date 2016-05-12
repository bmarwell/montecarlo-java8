/**
 *
 */
package de.bmarwell.java.montecarlo.java8.dicerollingdrinking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.stream.LongStream;

/**
 * @author bmarwell
 *
 */
public class DiceRollingDrinkingGame {

  /**
   * Logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(DiceRollingDrinkingGame.class);

  private static final int GLASSES_FULL = 0b111111;

  private static final int GLASSES_EMPTY = 0b000000;

  private static final int RIGHT_GLASS_SWITCH = 0b000001;

  /**
   * @param args
   */
  public static void main(String[] args) {
    if (args.length == 0) {
      LOG.error("Parameter: number of iterations missing");

      throw new IllegalArgumentException("Paramter: number of iterations missing.");
    }

    long iterations = Long.parseLong(args[0]);

    Random random = new Random();
    random.setSeed(System.currentTimeMillis());

    double average = LongStream.range(0, iterations)
      .parallel()
        .map(num -> DiceRollingDrinkingGame.tryGame(random))
        .average().getAsDouble();

    LOG.info("By average used [{}] tries.", average);
  }

  public static long tryGame(Random random) {
    int glasses = GLASSES_EMPTY;
    long tries = 0;

    while (glasses != GLASSES_FULL) {
      glasses = glasses ^ (RIGHT_GLASS_SWITCH << random.nextInt(6));
      LOG.trace("Glasses: [{}].", String.format("%6s", Integer.toBinaryString(glasses)));
      tries++;
    }

    return tries;
  }

}

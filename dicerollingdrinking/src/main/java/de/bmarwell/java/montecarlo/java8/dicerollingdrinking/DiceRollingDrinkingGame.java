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

  private static final short GLASSES_FULL = 0b111111;

  private static final short GLASSES_EMPTY = 0b000000;

  private static final short RIGHT_GLASS_SWITCH = 0b000001;

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

    /*
     * Again, parallel is important to use all cores.
     *
     * .map() will collect the results (longs). .average() will get the average result.
     */
    double average = LongStream.range(0, iterations)
        .parallel()
        .map(num -> DiceRollingDrinkingGame.tryGame(random))
        .average().getAsDouble();

    LOG.info("By average used [{}] tries.", average);
  }

  /**
   * Tries to solve one game using a given random provider.
   *
   * <p>
   * Note that we use right shifting for performance reasons. Each glass is a single bit. If we
   * throw 0, we swap the rightmost glass. If we throw more, we shift the rightmost bit to the left
   * by the number of thrown positions and change that bit.
   * </p>
   *
   * @param random
   *          a random instance.
   * @return the number of tries used.
   */
  public static long tryGame(Random random) {
    short glasses = GLASSES_EMPTY;
    long tries = 0;

    while (glasses != GLASSES_FULL) {
      glasses = (short) (glasses ^ (RIGHT_GLASS_SWITCH << random.nextInt(6)));
      LOG.trace("Glasses: [{}].", String.format("%6s", Integer.toBinaryString(glasses)));
      tries++;
    }

    return tries;
  }

}

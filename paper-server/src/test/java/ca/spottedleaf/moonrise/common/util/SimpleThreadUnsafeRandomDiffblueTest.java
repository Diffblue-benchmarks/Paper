package ca.spottedleaf.moonrise.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.moonrise.common.util.SimpleThreadUnsafeRandom.SimpleRandomPositionalFactory;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimpleThreadUnsafeRandomDiffblueTest {
  /**
   * Test {@link SimpleThreadUnsafeRandom#SimpleThreadUnsafeRandom(long)}.
   *
   * <p>Method under test: {@link SimpleThreadUnsafeRandom#SimpleThreadUnsafeRandom(long)}
   */
  @Test
  @DisplayName("Test new SimpleThreadUnsafeRandom(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleThreadUnsafeRandom.<init>(long)"})
  void testNewSimpleThreadUnsafeRandom() {
    // Arrange and Act
    SimpleThreadUnsafeRandom actualSimpleThreadUnsafeRandom = new SimpleThreadUnsafeRandom(42L);

    // Assert
    assertTrue(actualSimpleThreadUnsafeRandom.fork() instanceof SimpleThreadUnsafeRandom);
    assertTrue(
        actualSimpleThreadUnsafeRandom.forkPositional() instanceof SimpleRandomPositionalFactory);
  }

  /**
   * Test {@link SimpleThreadUnsafeRandom#next(int)}.
   *
   * <p>Method under test: {@link SimpleThreadUnsafeRandom#next(int)}
   */
  @Test
  @DisplayName("Test next(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleThreadUnsafeRandom.next(int)"})
  void testNext() {
    // Arrange, Act and Assert
    assertEquals(1, new SimpleThreadUnsafeRandom(42L).next(1));
  }

  /**
   * Test {@link SimpleThreadUnsafeRandom#nextInt()}.
   *
   * <p>Method under test: {@link SimpleThreadUnsafeRandom#nextInt()}
   */
  @Test
  @DisplayName("Test nextInt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleThreadUnsafeRandom.nextInt()"})
  void testNextInt() {
    // Arrange, Act and Assert
    assertEquals(-1170105035, new SimpleThreadUnsafeRandom(42L).nextInt());
  }

  /**
   * Test {@link SimpleThreadUnsafeRandom#nextInt(int)} with {@code bound}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SimpleThreadUnsafeRandom#nextInt(int)}
   */
  @Test
  @DisplayName("Test nextInt(int) with 'bound'; when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleThreadUnsafeRandom.nextInt(int)"})
  void testNextIntWithBound_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new SimpleThreadUnsafeRandom(42L).nextInt(1));
  }

  /**
   * Test {@link SimpleThreadUnsafeRandom#nextInt(int)} with {@code bound}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleThreadUnsafeRandom#nextInt(int)}
   */
  @Test
  @DisplayName("Test nextInt(int) with 'bound'; when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleThreadUnsafeRandom.nextInt(int)"})
  void testNextIntWithBound_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new SimpleThreadUnsafeRandom(42L).nextInt(0));
  }

  /**
   * Test {@link SimpleThreadUnsafeRandom#nextGaussian()}.
   *
   * <ul>
   *   <li>Given {@link SimpleThreadUnsafeRandom#SimpleThreadUnsafeRandom(long)} with seed is
   *       forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleThreadUnsafeRandom#nextGaussian()}
   */
  @Test
  @DisplayName("Test nextGaussian(); given SimpleThreadUnsafeRandom(long) with seed is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimpleThreadUnsafeRandom.nextGaussian()"})
  void testNextGaussian_givenSimpleThreadUnsafeRandomWithSeedIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(1.1419052490389525d, new SimpleThreadUnsafeRandom(42L).nextGaussian());
  }

  /**
   * Test {@link SimpleThreadUnsafeRandom#nextGaussian()}.
   *
   * <ul>
   *   <li>Given {@link SimpleThreadUnsafeRandom#SimpleThreadUnsafeRandom(long)} with seed is
   *       forty-two Seed is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleThreadUnsafeRandom#nextGaussian()}
   */
  @Test
  @DisplayName(
      "Test nextGaussian(); given SimpleThreadUnsafeRandom(long) with seed is forty-two Seed is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimpleThreadUnsafeRandom.nextGaussian()"})
  void testNextGaussian_givenSimpleThreadUnsafeRandomWithSeedIsFortyTwoSeedIsFortyTwo() {
    // Arrange
    SimpleThreadUnsafeRandom simpleThreadUnsafeRandom = new SimpleThreadUnsafeRandom(42L);
    simpleThreadUnsafeRandom.setSeed(42L);

    // Act and Assert
    assertEquals(1.1419052490389525d, simpleThreadUnsafeRandom.nextGaussian());
  }

  /**
   * Test {@link SimpleThreadUnsafeRandom#nextGaussian()}.
   *
   * <ul>
   *   <li>Then return {@code 1.785331448791184}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleThreadUnsafeRandom#nextGaussian()}
   */
  @Test
  @DisplayName("Test nextGaussian(); then return '1.785331448791184'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimpleThreadUnsafeRandom.nextGaussian()"})
  void testNextGaussian_thenReturn1785331448791184() {
    // Arrange
    SimpleThreadUnsafeRandom simpleThreadUnsafeRandom = new SimpleThreadUnsafeRandom(42L);
    simpleThreadUnsafeRandom.setSeed(-1L);

    // Act and Assert
    assertEquals(1.785331448791184d, simpleThreadUnsafeRandom.nextGaussian());
  }

  /**
   * Test {@link SimpleThreadUnsafeRandom#fork()}.
   *
   * <p>Method under test: {@link SimpleThreadUnsafeRandom#fork()}
   */
  @Test
  @DisplayName("Test fork()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomSource SimpleThreadUnsafeRandom.fork()"})
  void testFork() {
    // Arrange and Act
    RandomSource actualForkResult = new SimpleThreadUnsafeRandom(42L).fork();

    // Assert
    assertTrue(actualForkResult instanceof SimpleThreadUnsafeRandom);
    assertTrue(actualForkResult.forkPositional() instanceof SimpleRandomPositionalFactory);
    assertFalse(actualForkResult.nextBoolean());
  }

  /**
   * Test {@link SimpleThreadUnsafeRandom#forkPositional()}.
   *
   * <p>Method under test: {@link SimpleThreadUnsafeRandom#forkPositional()}
   */
  @Test
  @DisplayName("Test forkPositional()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PositionalRandomFactory SimpleThreadUnsafeRandom.forkPositional()"})
  void testForkPositional() {
    // Arrange and Act
    PositionalRandomFactory actualForkPositionalResult =
        new SimpleThreadUnsafeRandom(42L).forkPositional();

    // Assert
    assertTrue(actualForkPositionalResult instanceof SimpleRandomPositionalFactory);
    assertEquals(
        -5025562857975149833L,
        ((SimpleRandomPositionalFactory) actualForkPositionalResult).getSeed());
  }

  /**
   * Test SimpleRandomPositionalFactory {@link SimpleRandomPositionalFactory#at(int, int, int)} with
   * {@code x}, {@code y}, {@code z}.
   *
   * <p>Method under test: {@link SimpleRandomPositionalFactory#at(int, int, int)}
   */
  @Test
  @DisplayName("Test SimpleRandomPositionalFactory at(int, int, int) with 'x', 'y', 'z'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomSource SimpleRandomPositionalFactory.at(int, int, int)"})
  void testSimpleRandomPositionalFactoryAtWithXYZ() {
    // Arrange and Act
    RandomSource actualAtResult = new SimpleRandomPositionalFactory(42L).at(2, 3, 1);

    // Assert
    assertTrue(actualAtResult instanceof SimpleThreadUnsafeRandom);
    assertTrue(actualAtResult.fork() instanceof SimpleThreadUnsafeRandom);
    assertTrue(actualAtResult.forkPositional() instanceof SimpleRandomPositionalFactory);
  }

  /**
   * Test SimpleRandomPositionalFactory {@link SimpleRandomPositionalFactory#fromHashOf(String)}
   * with {@code string}.
   *
   * <p>Method under test: {@link SimpleRandomPositionalFactory#fromHashOf(String)}
   */
  @Test
  @DisplayName("Test SimpleRandomPositionalFactory fromHashOf(String) with 'string'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomSource SimpleRandomPositionalFactory.fromHashOf(String)"})
  void testSimpleRandomPositionalFactoryFromHashOfWithString() {
    // Arrange and Act
    RandomSource actualFromHashOfResult =
        new SimpleRandomPositionalFactory(42L).fromHashOf("String");

    // Assert
    assertTrue(actualFromHashOfResult instanceof SimpleThreadUnsafeRandom);
    assertTrue(actualFromHashOfResult.fork() instanceof SimpleThreadUnsafeRandom);
    assertTrue(actualFromHashOfResult.forkPositional() instanceof SimpleRandomPositionalFactory);
  }

  /**
   * Test SimpleRandomPositionalFactory {@link SimpleRandomPositionalFactory#fromSeed(long)}.
   *
   * <p>Method under test: {@link SimpleRandomPositionalFactory#fromSeed(long)}
   */
  @Test
  @DisplayName("Test SimpleRandomPositionalFactory fromSeed(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomSource SimpleRandomPositionalFactory.fromSeed(long)"})
  void testSimpleRandomPositionalFactoryFromSeed() {
    // Arrange and Act
    RandomSource actualFromSeedResult = new SimpleRandomPositionalFactory(42L).fromSeed(42L);

    // Assert
    assertTrue(actualFromSeedResult instanceof SimpleThreadUnsafeRandom);
    assertTrue(actualFromSeedResult.fork() instanceof SimpleThreadUnsafeRandom);
    assertTrue(actualFromSeedResult.forkPositional() instanceof SimpleRandomPositionalFactory);
  }

  /**
   * Test SimpleRandomPositionalFactory getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleRandomPositionalFactory#SimpleRandomPositionalFactory(long)}
   *   <li>{@link SimpleRandomPositionalFactory#getSeed()}
   * </ul>
   */
  @Test
  @DisplayName("Test SimpleRandomPositionalFactory getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleRandomPositionalFactory.<init>(long)",
    "long SimpleRandomPositionalFactory.getSeed()"
  })
  void testSimpleRandomPositionalFactoryGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(42L, new SimpleRandomPositionalFactory(42L).getSeed());
  }

  /**
   * Test SimpleRandomPositionalFactory {@link
   * SimpleRandomPositionalFactory#parityConfigString(StringBuilder)}.
   *
   * <p>Method under test: {@link SimpleRandomPositionalFactory#parityConfigString(StringBuilder)}
   */
  @Test
  @DisplayName("Test SimpleRandomPositionalFactory parityConfigString(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleRandomPositionalFactory.parityConfigString(StringBuilder)"})
  void testSimpleRandomPositionalFactoryParityConfigString() {
    // Arrange
    SimpleRandomPositionalFactory simpleRandomPositionalFactory =
        new SimpleRandomPositionalFactory(42L);
    StringBuilder stringBuilder = new StringBuilder("Str");

    // Act
    simpleRandomPositionalFactory.parityConfigString(stringBuilder);

    // Assert
    assertEquals("StrSimpleRandomPositionalFactory{42}", stringBuilder.toString());
  }
}

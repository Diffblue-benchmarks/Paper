package ca.spottedleaf.moonrise.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.moonrise.common.util.ThreadUnsafeRandom.ThreadUnsafeRandomPositionalFactory;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ThreadUnsafeRandomDiffblueTest {
  /**
   * Test {@link ThreadUnsafeRandom#ThreadUnsafeRandom(long)}.
   *
   * <p>Method under test: {@link ThreadUnsafeRandom#ThreadUnsafeRandom(long)}
   */
  @Test
  @DisplayName("Test new ThreadUnsafeRandom(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThreadUnsafeRandom.<init>(long)"})
  void testNewThreadUnsafeRandom() {
    // Arrange and Act
    ThreadUnsafeRandom actualThreadUnsafeRandom = new ThreadUnsafeRandom(42L);

    // Assert
    assertTrue(actualThreadUnsafeRandom.fork() instanceof ThreadUnsafeRandom);
    assertTrue(
        actualThreadUnsafeRandom.forkPositional() instanceof ThreadUnsafeRandomPositionalFactory);
  }

  /**
   * Test {@link ThreadUnsafeRandom#next(int)}.
   *
   * <p>Method under test: {@link ThreadUnsafeRandom#next(int)}
   */
  @Test
  @DisplayName("Test next(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ThreadUnsafeRandom.next(int)"})
  void testNext() {
    // Arrange, Act and Assert
    assertEquals(1, new ThreadUnsafeRandom(42L).next(1));
  }

  /**
   * Test {@link ThreadUnsafeRandom#nextInt()}.
   *
   * <p>Method under test: {@link ThreadUnsafeRandom#nextInt()}
   */
  @Test
  @DisplayName("Test nextInt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ThreadUnsafeRandom.nextInt()"})
  void testNextInt() {
    // Arrange, Act and Assert
    assertEquals(-1170105035, new ThreadUnsafeRandom(42L).nextInt());
  }

  /**
   * Test {@link ThreadUnsafeRandom#nextGaussian()}.
   *
   * <ul>
   *   <li>Then return {@code 1.785331448791184}.
   * </ul>
   *
   * <p>Method under test: {@link ThreadUnsafeRandom#nextGaussian()}
   */
  @Test
  @DisplayName("Test nextGaussian(); then return '1.785331448791184'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double ThreadUnsafeRandom.nextGaussian()"})
  void testNextGaussian_thenReturn1785331448791184() {
    // Arrange, Act and Assert
    assertEquals(1.785331448791184d, new ThreadUnsafeRandom(-1L).nextGaussian());
  }

  /**
   * Test {@link ThreadUnsafeRandom#nextGaussian()}.
   *
   * <ul>
   *   <li>Then return {@code 1.1419052490389525}.
   * </ul>
   *
   * <p>Method under test: {@link ThreadUnsafeRandom#nextGaussian()}
   */
  @Test
  @DisplayName("Test nextGaussian(); then return '1.1419052490389525'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double ThreadUnsafeRandom.nextGaussian()"})
  void testNextGaussian_thenReturn11419052490389525() {
    // Arrange, Act and Assert
    assertEquals(1.1419052490389525d, new ThreadUnsafeRandom(42L).nextGaussian());
  }

  /**
   * Test {@link ThreadUnsafeRandom#fork()}.
   *
   * <p>Method under test: {@link ThreadUnsafeRandom#fork()}
   */
  @Test
  @DisplayName("Test fork()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomSource ThreadUnsafeRandom.fork()"})
  void testFork() {
    // Arrange and Act
    RandomSource actualForkResult = new ThreadUnsafeRandom(42L).fork();

    // Assert
    assertTrue(actualForkResult instanceof ThreadUnsafeRandom);
    assertTrue(actualForkResult.forkPositional() instanceof ThreadUnsafeRandomPositionalFactory);
    assertFalse(actualForkResult.nextBoolean());
  }

  /**
   * Test {@link ThreadUnsafeRandom#forkPositional()}.
   *
   * <p>Method under test: {@link ThreadUnsafeRandom#forkPositional()}
   */
  @Test
  @DisplayName("Test forkPositional()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PositionalRandomFactory ThreadUnsafeRandom.forkPositional()"})
  void testForkPositional() {
    // Arrange and Act
    PositionalRandomFactory actualForkPositionalResult =
        new ThreadUnsafeRandom(42L).forkPositional();

    // Assert
    assertTrue(actualForkPositionalResult instanceof ThreadUnsafeRandomPositionalFactory);
    assertEquals(
        -5025562857975149833L,
        ((ThreadUnsafeRandomPositionalFactory) actualForkPositionalResult).getSeed());
  }

  /**
   * Test ThreadUnsafeRandomPositionalFactory {@link ThreadUnsafeRandomPositionalFactory#at(int,
   * int, int)} with {@code x}, {@code y}, {@code z}.
   *
   * <p>Method under test: {@link ThreadUnsafeRandomPositionalFactory#at(int, int, int)}
   */
  @Test
  @DisplayName("Test ThreadUnsafeRandomPositionalFactory at(int, int, int) with 'x', 'y', 'z'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomSource ThreadUnsafeRandomPositionalFactory.at(int, int, int)"})
  void testThreadUnsafeRandomPositionalFactoryAtWithXYZ() {
    // Arrange and Act
    RandomSource actualAtResult = new ThreadUnsafeRandomPositionalFactory(42L).at(2, 3, 1);

    // Assert
    assertTrue(actualAtResult instanceof ThreadUnsafeRandom);
    assertTrue(actualAtResult.fork() instanceof ThreadUnsafeRandom);
    assertTrue(actualAtResult.forkPositional() instanceof ThreadUnsafeRandomPositionalFactory);
  }

  /**
   * Test ThreadUnsafeRandomPositionalFactory {@link
   * ThreadUnsafeRandomPositionalFactory#fromHashOf(String)} with {@code string}.
   *
   * <p>Method under test: {@link ThreadUnsafeRandomPositionalFactory#fromHashOf(String)}
   */
  @Test
  @DisplayName("Test ThreadUnsafeRandomPositionalFactory fromHashOf(String) with 'string'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomSource ThreadUnsafeRandomPositionalFactory.fromHashOf(String)"})
  void testThreadUnsafeRandomPositionalFactoryFromHashOfWithString() {
    // Arrange and Act
    RandomSource actualFromHashOfResult =
        new ThreadUnsafeRandomPositionalFactory(42L).fromHashOf("String");

    // Assert
    assertTrue(actualFromHashOfResult instanceof ThreadUnsafeRandom);
    assertTrue(actualFromHashOfResult.fork() instanceof ThreadUnsafeRandom);
    assertTrue(
        actualFromHashOfResult.forkPositional() instanceof ThreadUnsafeRandomPositionalFactory);
  }

  /**
   * Test ThreadUnsafeRandomPositionalFactory {@link
   * ThreadUnsafeRandomPositionalFactory#fromSeed(long)}.
   *
   * <p>Method under test: {@link ThreadUnsafeRandomPositionalFactory#fromSeed(long)}
   */
  @Test
  @DisplayName("Test ThreadUnsafeRandomPositionalFactory fromSeed(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomSource ThreadUnsafeRandomPositionalFactory.fromSeed(long)"})
  void testThreadUnsafeRandomPositionalFactoryFromSeed() {
    // Arrange and Act
    RandomSource actualFromSeedResult = new ThreadUnsafeRandomPositionalFactory(42L).fromSeed(42L);

    // Assert
    assertTrue(actualFromSeedResult instanceof ThreadUnsafeRandom);
    assertTrue(actualFromSeedResult.fork() instanceof ThreadUnsafeRandom);
    assertTrue(
        actualFromSeedResult.forkPositional() instanceof ThreadUnsafeRandomPositionalFactory);
  }

  /**
   * Test ThreadUnsafeRandomPositionalFactory getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ThreadUnsafeRandomPositionalFactory#ThreadUnsafeRandomPositionalFactory(long)}
   *   <li>{@link ThreadUnsafeRandomPositionalFactory#getSeed()}
   * </ul>
   */
  @Test
  @DisplayName("Test ThreadUnsafeRandomPositionalFactory getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThreadUnsafeRandomPositionalFactory.<init>(long)",
    "long ThreadUnsafeRandomPositionalFactory.getSeed()"
  })
  void testThreadUnsafeRandomPositionalFactoryGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(42L, new ThreadUnsafeRandomPositionalFactory(42L).getSeed());
  }

  /**
   * Test ThreadUnsafeRandomPositionalFactory {@link
   * ThreadUnsafeRandomPositionalFactory#parityConfigString(StringBuilder)}.
   *
   * <p>Method under test: {@link
   * ThreadUnsafeRandomPositionalFactory#parityConfigString(StringBuilder)}
   */
  @Test
  @DisplayName("Test ThreadUnsafeRandomPositionalFactory parityConfigString(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThreadUnsafeRandomPositionalFactory.parityConfigString(StringBuilder)"})
  void testThreadUnsafeRandomPositionalFactoryParityConfigString() {
    // Arrange
    ThreadUnsafeRandomPositionalFactory threadUnsafeRandomPositionalFactory =
        new ThreadUnsafeRandomPositionalFactory(42L);
    StringBuilder stringBuilder = new StringBuilder("foo");

    // Act
    threadUnsafeRandomPositionalFactory.parityConfigString(stringBuilder);

    // Assert
    assertEquals("fooThreadUnsafeRandomPositionalFactory{42}", stringBuilder.toString());
  }
}

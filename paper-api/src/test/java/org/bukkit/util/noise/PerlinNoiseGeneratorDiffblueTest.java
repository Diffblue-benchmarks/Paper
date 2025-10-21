package org.bukkit.util.noise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Random;
import org.bukkit.World;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PerlinNoiseGeneratorDiffblueTest {
  /**
   * Test {@link PerlinNoiseGenerator#PerlinNoiseGenerator()}.
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#PerlinNoiseGenerator()}
   */
  @Test
  @DisplayName("Test new PerlinNoiseGenerator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PerlinNoiseGenerator.<init>()"})
  void testNewPerlinNoiseGenerator() {
    // Arrange and Act
    PerlinNoiseGenerator actualPerlinNoiseGenerator = new PerlinNoiseGenerator();

    // Assert
    assertEquals(0.0d, actualPerlinNoiseGenerator.offsetX);
    assertEquals(0.0d, actualPerlinNoiseGenerator.offsetY);
    assertEquals(0.0d, actualPerlinNoiseGenerator.offsetZ);
    assertEquals(512, actualPerlinNoiseGenerator.perm.length);
  }

  /**
   * Test {@link PerlinNoiseGenerator#PerlinNoiseGenerator(long)}.
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#PerlinNoiseGenerator(long)}
   */
  @Test
  @DisplayName("Test new PerlinNoiseGenerator(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PerlinNoiseGenerator.<init>(long)"})
  void testNewPerlinNoiseGenerator2() {
    // Arrange and Act
    PerlinNoiseGenerator actualPerlinNoiseGenerator = new PerlinNoiseGenerator(42L);

    // Assert
    assertEquals(174.90520877052043d, actualPerlinNoiseGenerator.offsetY);
    assertEquals(186.25630208841423d, actualPerlinNoiseGenerator.offsetX);
    assertEquals(512, actualPerlinNoiseGenerator.perm.length);
    assertEquals(79.0321805651609d, actualPerlinNoiseGenerator.offsetZ);
  }

  /**
   * Test {@link PerlinNoiseGenerator#PerlinNoiseGenerator(Random)}.
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#PerlinNoiseGenerator(Random)}
   */
  @Test
  @DisplayName("Test new PerlinNoiseGenerator(Random)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PerlinNoiseGenerator.<init>(Random)"})
  void testNewPerlinNoiseGenerator3() {
    // Arrange, Act and Assert
    assertEquals(512, new PerlinNoiseGenerator(new Random()).perm.length);
  }

  /**
   * Test {@link PerlinNoiseGenerator#PerlinNoiseGenerator(World)}.
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#PerlinNoiseGenerator(World)}
   */
  @Test
  @DisplayName("Test new PerlinNoiseGenerator(World)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PerlinNoiseGenerator.<init>(World)"})
  void testNewPerlinNoiseGenerator4() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);

    // Act
    PerlinNoiseGenerator actualPerlinNoiseGenerator = new PerlinNoiseGenerator(world);

    // Assert
    verify(world).getSeed();
    assertEquals(174.90520877052043d, actualPerlinNoiseGenerator.offsetY);
    assertEquals(186.25630208841423d, actualPerlinNoiseGenerator.offsetX);
    assertEquals(512, actualPerlinNoiseGenerator.perm.length);
    assertEquals(79.0321805651609d, actualPerlinNoiseGenerator.offsetZ);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, int, double, double)} with {@code x}, {@code
   * octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, int, double, double) with 'x', 'octaves', 'frequency', 'amplitude'; when '-0.5'; then return '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, int, double, double)"})
  void testGetNoiseWithXOctavesFrequencyAmplitude_when05_thenReturn05() {
    // Arrange and Act
    double actualNoise = PerlinNoiseGenerator.getNoise(-0.5d, 3, 10.0d, 10.0d);

    // Assert
    assertEquals(-0.5d, actualNoise);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, int, double, double)} with {@code x}, {@code
   * octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When fifteen.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, int, double, double) with 'x', 'octaves', 'frequency', 'amplitude'; when fifteen; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, int, double, double)"})
  void testGetNoiseWithXOctavesFrequencyAmplitude_whenFifteen_thenReturnZero() {
    // Arrange and Act
    double actualNoise = PerlinNoiseGenerator.getNoise(15.0d, 3, 10.0d, 10.0d);

    // Assert
    assertEquals(0.0d, actualNoise);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, int, double, double)} with {@code x}, {@code
   * octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, int, double, double) with 'x', 'octaves', 'frequency', 'amplitude'; when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, int, double, double)"})
  void testGetNoiseWithXOctavesFrequencyAmplitude_whenOne_thenReturnZero() {
    // Arrange and Act
    double actualNoise = PerlinNoiseGenerator.getNoise(1.0d, 3, 10.0d, 10.0d);

    // Assert
    assertEquals(0.0d, actualNoise);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, int, double, double)} with {@code x}, {@code
   * octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, int, double, double) with 'x', 'octaves', 'frequency', 'amplitude'; when six; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, int, double, double)"})
  void testGetNoiseWithXOctavesFrequencyAmplitude_whenSix_thenReturnZero() {
    // Arrange and Act
    double actualNoise = PerlinNoiseGenerator.getNoise(6.0d, 3, 10.0d, 10.0d);

    // Assert
    assertEquals(0.0d, actualNoise);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, int, double, double)} with {@code x}, {@code
   * octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, int, double, double) with 'x', 'octaves', 'frequency', 'amplitude'; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, int, double, double)"})
  void testGetNoiseWithXOctavesFrequencyAmplitude_whenTwo_thenReturnZero() {
    // Arrange and Act
    double actualNoise = PerlinNoiseGenerator.getNoise(2.0d, 3, 10.0d, 10.0d);

    // Assert
    assertEquals(0.0d, actualNoise);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double, int, double, double)} with {@code x},
   * {@code y}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double, int, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, int, double, double) with 'x', 'y', 'octaves', 'frequency', 'amplitude'; when '-0.5'; then return '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, double, int, double, double)"})
  void testGetNoiseWithXYOctavesFrequencyAmplitude_when05_thenReturn05() {
    // Arrange and Act
    double actualNoise = PerlinNoiseGenerator.getNoise(-0.5d, 3.0d, 3, 10.0d, 10.0d);

    // Assert
    assertEquals(0.5d, actualNoise);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double, int, double, double)} with {@code x},
   * {@code y}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double, int, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, int, double, double) with 'x', 'y', 'octaves', 'frequency', 'amplitude'; when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, double, int, double, double)"})
  void testGetNoiseWithXYOctavesFrequencyAmplitude_whenOne_thenReturnZero() {
    // Arrange and Act
    double actualNoise = PerlinNoiseGenerator.getNoise(1.0d, 3.0d, 3, 10.0d, 10.0d);

    // Assert
    assertEquals(0.0d, actualNoise);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double, int, double, double)} with {@code x},
   * {@code y}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double, int, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, int, double, double) with 'x', 'y', 'octaves', 'frequency', 'amplitude'; when six; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, double, int, double, double)"})
  void testGetNoiseWithXYOctavesFrequencyAmplitude_whenSix_thenReturnZero() {
    // Arrange and Act
    double actualNoise = PerlinNoiseGenerator.getNoise(6.0d, 3.0d, 3, 10.0d, 10.0d);

    // Assert
    assertEquals(0.0d, actualNoise);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double, int, double, double)} with {@code x},
   * {@code y}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double, int, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, int, double, double) with 'x', 'y', 'octaves', 'frequency', 'amplitude'; when three; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, double, int, double, double)"})
  void testGetNoiseWithXYOctavesFrequencyAmplitude_whenThree_thenReturnZero() {
    // Arrange and Act
    double actualNoise = PerlinNoiseGenerator.getNoise(3.0d, 3.0d, 3, 10.0d, 10.0d);

    // Assert
    assertEquals(0.0d, actualNoise);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double, int, double, double)} with {@code x},
   * {@code y}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double, int, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, int, double, double) with 'x', 'y', 'octaves', 'frequency', 'amplitude'; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, double, int, double, double)"})
  void testGetNoiseWithXYOctavesFrequencyAmplitude_whenTwo_thenReturnZero() {
    // Arrange and Act
    double actualNoise = PerlinNoiseGenerator.getNoise(2.0d, 3.0d, 3, 10.0d, 10.0d);

    // Assert
    assertEquals(0.0d, actualNoise);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double, double, int, double, double)} with
   * {@code x}, {@code y}, {@code z}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double, double, int, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double, int, double, double) with 'x', 'y', 'z', 'octaves', 'frequency', 'amplitude'; when '-0.5'; then return '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double PerlinNoiseGenerator.getNoise(double, double, double, int, double, double)"
  })
  void testGetNoiseWithXYZOctavesFrequencyAmplitude_when05_thenReturn05() {
    // Arrange and Act
    double actualNoise = PerlinNoiseGenerator.getNoise(-0.5d, 3.0d, 10.0d, 3, 10.0d, 10.0d);

    // Assert
    assertEquals(0.5d, actualNoise);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double, double, int, double, double)} with
   * {@code x}, {@code y}, {@code z}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double, double, int, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double, int, double, double) with 'x', 'y', 'z', 'octaves', 'frequency', 'amplitude'; when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double PerlinNoiseGenerator.getNoise(double, double, double, int, double, double)"
  })
  void testGetNoiseWithXYZOctavesFrequencyAmplitude_whenOne_thenReturnZero() {
    // Arrange and Act
    double actualNoise = PerlinNoiseGenerator.getNoise(1.0d, 3.0d, 10.0d, 3, 10.0d, 10.0d);

    // Assert
    assertEquals(0.0d, actualNoise);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double, double, int, double, double)} with
   * {@code x}, {@code y}, {@code z}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double, double, int, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double, int, double, double) with 'x', 'y', 'z', 'octaves', 'frequency', 'amplitude'; when six; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double PerlinNoiseGenerator.getNoise(double, double, double, int, double, double)"
  })
  void testGetNoiseWithXYZOctavesFrequencyAmplitude_whenSix_thenReturnZero() {
    // Arrange and Act
    double actualNoise = PerlinNoiseGenerator.getNoise(6.0d, 3.0d, 10.0d, 3, 10.0d, 10.0d);

    // Assert
    assertEquals(0.0d, actualNoise);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double, double, int, double, double)} with
   * {@code x}, {@code y}, {@code z}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double, double, int, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double, int, double, double) with 'x', 'y', 'z', 'octaves', 'frequency', 'amplitude'; when three; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double PerlinNoiseGenerator.getNoise(double, double, double, int, double, double)"
  })
  void testGetNoiseWithXYZOctavesFrequencyAmplitude_whenThree_thenReturnZero() {
    // Arrange and Act
    double actualNoise = PerlinNoiseGenerator.getNoise(3.0d, 3.0d, 10.0d, 3, 10.0d, 10.0d);

    // Assert
    assertEquals(0.0d, actualNoise);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double, double, int, double, double)} with
   * {@code x}, {@code y}, {@code z}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double, double, int, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double, int, double, double) with 'x', 'y', 'z', 'octaves', 'frequency', 'amplitude'; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double PerlinNoiseGenerator.getNoise(double, double, double, int, double, double)"
  })
  void testGetNoiseWithXYZOctavesFrequencyAmplitude_whenTwo_thenReturnZero() {
    // Arrange and Act
    double actualNoise = PerlinNoiseGenerator.getNoise(2.0d, 3.0d, 10.0d, 3, 10.0d, 10.0d);

    // Assert
    assertEquals(0.0d, actualNoise);
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double, double)} with {@code x}, {@code y},
   * {@code z}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double) with 'x', 'y', 'z'; when '-0.5'; then return '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, double, double)"})
  void testGetNoiseWithXYZ_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(0.5d, PerlinNoiseGenerator.getNoise(-0.5d, 3.0d, 10.0d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double, double)} with {@code x}, {@code y},
   * {@code z}.
   *
   * <ul>
   *   <li>When fifteen.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double) with 'x', 'y', 'z'; when fifteen; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, double, double)"})
  void testGetNoiseWithXYZ_whenFifteen_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getNoise(15.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double, double)} with {@code x}, {@code y},
   * {@code z}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double) with 'x', 'y', 'z'; when six; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, double, double)"})
  void testGetNoiseWithXYZ_whenSix_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getNoise(6.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double, double)} with {@code x}, {@code y},
   * {@code z}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double) with 'x', 'y', 'z'; when three; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, double, double)"})
  void testGetNoiseWithXYZ_whenThree_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getNoise(3.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double, double)} with {@code x}, {@code y},
   * {@code z}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double) with 'x', 'y', 'z'; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, double, double)"})
  void testGetNoiseWithXYZ_whenTwo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getNoise(2.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double)} with {@code x}, {@code y}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double)}
   */
  @Test
  @DisplayName("Test getNoise(double, double) with 'x', 'y'; when '-0.5'; then return '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, double)"})
  void testGetNoiseWithXY_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(0.5d, PerlinNoiseGenerator.getNoise(-0.5d, 3.0d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double)} with {@code x}, {@code y}.
   *
   * <ul>
   *   <li>When fifteen.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double)}
   */
  @Test
  @DisplayName("Test getNoise(double, double) with 'x', 'y'; when fifteen; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, double)"})
  void testGetNoiseWithXY_whenFifteen_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getNoise(15.0d, 3.0d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double)} with {@code x}, {@code y}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double)}
   */
  @Test
  @DisplayName("Test getNoise(double, double) with 'x', 'y'; when six; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, double)"})
  void testGetNoiseWithXY_whenSix_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getNoise(6.0d, 3.0d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double)} with {@code x}, {@code y}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double)}
   */
  @Test
  @DisplayName("Test getNoise(double, double) with 'x', 'y'; when three; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, double)"})
  void testGetNoiseWithXY_whenThree_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getNoise(3.0d, 3.0d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double, double)} with {@code x}, {@code y}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double, double)}
   */
  @Test
  @DisplayName("Test getNoise(double, double) with 'x', 'y'; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double, double)"})
  void testGetNoiseWithXY_whenTwo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getNoise(2.0d, 3.0d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double)} with {@code x}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double)}
   */
  @Test
  @DisplayName("Test getNoise(double) with 'x'; when '-0.5'; then return '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double)"})
  void testGetNoiseWithX_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(-0.5d, PerlinNoiseGenerator.getNoise(-0.5d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#getNoise(double)} with {@code x}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getNoise(double)}
   */
  @Test
  @DisplayName("Test getNoise(double) with 'x'; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.getNoise(double)"})
  void testGetNoiseWithX_whenTwo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getNoise(2.0d));
  }

  /**
   * Test getters and setters.
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#getInstance()}
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PerlinNoiseGenerator PerlinNoiseGenerator.getInstance()"})
  void testGettersAndSetters() {
    // Arrange and Act
    PerlinNoiseGenerator actualInstance = PerlinNoiseGenerator.getInstance();
    PerlinNoiseGenerator actualInstance2 = actualInstance.getInstance();

    // Assert
    assertSame(actualInstance, actualInstance2);
  }

  /**
   * Test {@link PerlinNoiseGenerator#noise(double, double, double)} with {@code x}, {@code y},
   * {@code z}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'x', 'y', 'z'; when '-0.5'; then return '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXYZ_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(0.5d, PerlinNoiseGenerator.getInstance().noise(-0.5d, 3.0d, 10.0d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#noise(double, double, double)} with {@code x}, {@code y},
   * {@code z}.
   *
   * <ul>
   *   <li>When fifteen.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'x', 'y', 'z'; when fifteen; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXYZ_whenFifteen_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(15.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#noise(double, double, double)} with {@code x}, {@code y},
   * {@code z}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName("Test noise(double, double, double) with 'x', 'y', 'z'; when six; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXYZ_whenSix_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(6.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#noise(double, double, double)} with {@code x}, {@code y},
   * {@code z}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'x', 'y', 'z'; when three; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXYZ_whenThree_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(3.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#noise(double, double, double)} with {@code x}, {@code y},
   * {@code z}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName("Test noise(double, double, double) with 'x', 'y', 'z'; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXYZ_whenTwo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link PerlinNoiseGenerator#noise(double, double, double)} with {@code x}, {@code y},
   * {@code z}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PerlinNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName("Test noise(double, double, double) with 'x', 'y', 'z'; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PerlinNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXYZ_whenTwo_thenReturnZero2() {
    // Arrange, Act and Assert
    assertEquals(0.0d, SimplexNoiseGenerator.getInstance().noise(2.0d, 3.0d, 10.0d));
  }
}

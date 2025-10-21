package org.bukkit.util.noise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NoiseGeneratorDiffblueTest {
  /**
   * Test {@link NoiseGenerator#floor(double)}.
   *
   * <ul>
   *   <li>When {@code -1.0E-10}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#floor(double)}
   */
  @Test
  @DisplayName("Test floor(double); when '-1.0E-10'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NoiseGenerator.floor(double)"})
  void testFloor_when10e10_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, NoiseGenerator.floor(-1.0E-10d));
  }

  /**
   * Test {@link NoiseGenerator#floor(double)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#floor(double)}
   */
  @Test
  @DisplayName("Test floor(double); when two; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NoiseGenerator.floor(double)"})
  void testFloor_whenTwo_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, NoiseGenerator.floor(2.0d));
  }

  /**
   * Test {@link NoiseGenerator#fade(double)}.
   *
   * <p>Method under test: {@link NoiseGenerator#fade(double)}
   */
  @Test
  @DisplayName("Test fade(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.fade(double)"})
  void testFade() {
    // Arrange, Act and Assert
    assertEquals(32.0d, NoiseGenerator.fade(2.0d));
  }

  /**
   * Test {@link NoiseGenerator#lerp(double, double, double)}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then return {@code 6.5}.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#lerp(double, double, double)}
   */
  @Test
  @DisplayName("Test lerp(double, double, double); when '0.5'; then return '6.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.lerp(double, double, double)"})
  void testLerp_when05_thenReturn65() {
    // Arrange, Act and Assert
    assertEquals(6.5d, NoiseGenerator.lerp(0.5d, 3.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#lerp(double, double, double)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#lerp(double, double, double)}
   */
  @Test
  @DisplayName("Test lerp(double, double, double); when one; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.lerp(double, double, double)"})
  void testLerp_whenOne_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0d, NoiseGenerator.lerp(1.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#lerp(double, double, double)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return seventy-three.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#lerp(double, double, double)}
   */
  @Test
  @DisplayName("Test lerp(double, double, double); when three; then return seventy-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.lerp(double, double, double)"})
  void testLerp_whenThree_thenReturnSeventyThree() {
    // Arrange, Act and Assert
    assertEquals(73.0d, NoiseGenerator.lerp(10.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#lerp(double, double, double)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return seventeen.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#lerp(double, double, double)}
   */
  @Test
  @DisplayName("Test lerp(double, double, double); when two; then return seventeen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.lerp(double, double, double)"})
  void testLerp_whenTwo_thenReturnSeventeen() {
    // Arrange, Act and Assert
    assertEquals(17.0d, NoiseGenerator.lerp(2.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#grad(int, double, double, double)}.
   *
   * <ul>
   *   <li>When {@code 19088743}.
   *   <li>Then return minus twelve.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#grad(int, double, double, double)}
   */
  @Test
  @DisplayName("Test grad(int, double, double, double); when '19088743'; then return minus twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.grad(int, double, double, double)"})
  void testGrad_when19088743_thenReturnMinusTwelve() {
    // Arrange and Act
    double actualGradResult = NoiseGenerator.grad(19088743, 2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(-12.0d, actualGradResult);
  }

  /**
   * Test {@link NoiseGenerator#grad(int, double, double, double)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return thirteen.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#grad(int, double, double, double)}
   */
  @Test
  @DisplayName("Test grad(int, double, double, double); when eight; then return thirteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.grad(int, double, double, double)"})
  void testGrad_whenEight_thenReturnThirteen() {
    // Arrange and Act
    double actualGradResult = NoiseGenerator.grad(8, 2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(13.0d, actualGradResult);
  }

  /**
   * Test {@link NoiseGenerator#grad(int, double, double, double)}.
   *
   * <ul>
   *   <li>When fifteen.
   *   <li>Then return minus thirteen.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#grad(int, double, double, double)}
   */
  @Test
  @DisplayName("Test grad(int, double, double, double); when fifteen; then return minus thirteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.grad(int, double, double, double)"})
  void testGrad_whenFifteen_thenReturnMinusThirteen() {
    // Arrange and Act
    double actualGradResult = NoiseGenerator.grad(15, 2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(-13.0d, actualGradResult);
  }

  /**
   * Test {@link NoiseGenerator#grad(int, double, double, double)}.
   *
   * <ul>
   *   <li>When fourteen.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#grad(int, double, double, double)}
   */
  @Test
  @DisplayName("Test grad(int, double, double, double); when fourteen; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.grad(int, double, double, double)"})
  void testGrad_whenFourteen_thenReturnOne() {
    // Arrange and Act
    double actualGradResult = NoiseGenerator.grad(14, 2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(1.0d, actualGradResult);
  }

  /**
   * Test {@link NoiseGenerator#grad(int, double, double, double)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return minus twelve.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#grad(int, double, double, double)}
   */
  @Test
  @DisplayName("Test grad(int, double, double, double); when seven; then return minus twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.grad(int, double, double, double)"})
  void testGrad_whenSeven_thenReturnMinusTwelve() {
    // Arrange and Act
    double actualGradResult = NoiseGenerator.grad(7, 2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(-12.0d, actualGradResult);
  }

  /**
   * Test {@link NoiseGenerator#grad(int, double, double, double)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return minus five.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#grad(int, double, double, double)}
   */
  @Test
  @DisplayName("Test grad(int, double, double, double); when three; then return minus five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.grad(int, double, double, double)"})
  void testGrad_whenThree_thenReturnMinusFive() {
    // Arrange and Act
    double actualGradResult = NoiseGenerator.grad(3, 2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(-5.0d, actualGradResult);
  }

  /**
   * Test {@link NoiseGenerator#grad(int, double, double, double)}.
   *
   * <ul>
   *   <li>When twelve.
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#grad(int, double, double, double)}
   */
  @Test
  @DisplayName("Test grad(int, double, double, double); when twelve; then return five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.grad(int, double, double, double)"})
  void testGrad_whenTwelve_thenReturnFive() {
    // Arrange and Act
    double actualGradResult = NoiseGenerator.grad(12, 2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(5.0d, actualGradResult);
  }

  /**
   * Test {@link NoiseGenerator#noise(double, int, double, double, boolean)} with {@code x}, {@code
   * octaves}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, int, double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, int, double, double, boolean) with 'x', 'octaves', 'frequency', 'amplitude', 'normalized'; when '-0.5'; then return '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, int, double, double, boolean)"})
  void testNoiseWithXOctavesFrequencyAmplitudeNormalized_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(-0.5d, PerlinNoiseGenerator.getInstance().noise(-0.5d, 1, 10.0d, 10.0d, true));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, int, double, double, boolean)} with {@code x}, {@code
   * octaves}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, int, double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, int, double, double, boolean) with 'x', 'octaves', 'frequency', 'amplitude', 'normalized'; when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, int, double, double, boolean)"})
  void testNoiseWithXOctavesFrequencyAmplitudeNormalized_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 1, 10.0d, 10.0d, true));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, int, double, double, boolean)} with {@code x}, {@code
   * octaves}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, int, double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, int, double, double, boolean) with 'x', 'octaves', 'frequency', 'amplitude', 'normalized'; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, int, double, double, boolean)"})
  void testNoiseWithXOctavesFrequencyAmplitudeNormalized_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 0, 10.0d, 10.0d, false));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, int, double, double)} with {@code x}, {@code octaves},
   * {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, int, double, double) with 'x', 'octaves', 'frequency', 'amplitude'; when '-0.5'; then return '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, int, double, double)"})
  void testNoiseWithXOctavesFrequencyAmplitude_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(-0.5d, PerlinNoiseGenerator.getInstance().noise(-0.5d, 3, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, int, double, double)} with {@code x}, {@code octaves},
   * {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, int, double, double) with 'x', 'octaves', 'frequency', 'amplitude'; when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, int, double, double)"})
  void testNoiseWithXOctavesFrequencyAmplitude_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 1, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, int, double, double)} with {@code x}, {@code octaves},
   * {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, int, double, double) with 'x', 'octaves', 'frequency', 'amplitude'; when three; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, int, double, double)"})
  void testNoiseWithXOctavesFrequencyAmplitude_whenThree_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, int, double, double)} with {@code x}, {@code octaves},
   * {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, int, double, double) with 'x', 'octaves', 'frequency', 'amplitude'; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, int, double, double)"})
  void testNoiseWithXOctavesFrequencyAmplitude_whenTwo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 2, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, int, double, double)} with {@code x}, {@code octaves},
   * {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, int, double, double) with 'x', 'octaves', 'frequency', 'amplitude'; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, int, double, double)"})
  void testNoiseWithXOctavesFrequencyAmplitude_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 0, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, int, double, double, boolean)} with {@code x},
   * {@code y}, {@code octaves}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, int, double, double,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, int, double, double, boolean) with 'x', 'y', 'octaves', 'frequency', 'amplitude', 'normalized'; when '-0.5'; then return '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, int, double, double, boolean)"})
  void testNoiseWithXYOctavesFrequencyAmplitudeNormalized_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(
        0.5d, PerlinNoiseGenerator.getInstance().noise(-0.5d, 3.0d, 1, 10.0d, 10.0d, true));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, int, double, double, boolean)} with {@code x},
   * {@code y}, {@code octaves}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, int, double, double,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, int, double, double, boolean) with 'x', 'y', 'octaves', 'frequency', 'amplitude', 'normalized'; when 'false'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, int, double, double, boolean)"})
  void testNoiseWithXYOctavesFrequencyAmplitudeNormalized_whenFalse_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 2, 10.0d, 10.0d, false));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, int, double, double, boolean)} with {@code x},
   * {@code y}, {@code octaves}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, int, double, double,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, int, double, double, boolean) with 'x', 'y', 'octaves', 'frequency', 'amplitude', 'normalized'; when 'false'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, int, double, double, boolean)"})
  void testNoiseWithXYOctavesFrequencyAmplitudeNormalized_whenFalse_thenReturnZero2() {
    // Arrange, Act and Assert
    assertEquals(
        0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 3, 10.0d, 10.0d, false));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, int, double, double, boolean)} with {@code x},
   * {@code y}, {@code octaves}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, int, double, double,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, int, double, double, boolean) with 'x', 'y', 'octaves', 'frequency', 'amplitude', 'normalized'; when four; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, int, double, double, boolean)"})
  void testNoiseWithXYOctavesFrequencyAmplitudeNormalized_whenFour_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 4, 10.0d, 10.0d, false));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, int, double, double, boolean)} with {@code x},
   * {@code y}, {@code octaves}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, int, double, double,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, int, double, double, boolean) with 'x', 'y', 'octaves', 'frequency', 'amplitude', 'normalized'; when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, int, double, double, boolean)"})
  void testNoiseWithXYOctavesFrequencyAmplitudeNormalized_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 1, 10.0d, 10.0d, true));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, int, double, double, boolean)} with {@code x},
   * {@code y}, {@code octaves}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, int, double, double,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, int, double, double, boolean) with 'x', 'y', 'octaves', 'frequency', 'amplitude', 'normalized'; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, int, double, double, boolean)"})
  void testNoiseWithXYOctavesFrequencyAmplitudeNormalized_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 0, 10.0d, 10.0d, false));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, int, double, double)} with {@code x}, {@code
   * y}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, int, double, double) with 'x', 'y', 'octaves', 'frequency', 'amplitude'; when '-0.5'; then return '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, int, double, double)"})
  void testNoiseWithXYOctavesFrequencyAmplitude_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(0.5d, PerlinNoiseGenerator.getInstance().noise(-0.5d, 3.0d, 3, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, int, double, double)} with {@code x}, {@code
   * y}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, int, double, double) with 'x', 'y', 'octaves', 'frequency', 'amplitude'; when four; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, int, double, double)"})
  void testNoiseWithXYOctavesFrequencyAmplitude_whenFour_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 4, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, int, double, double)} with {@code x}, {@code
   * y}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, int, double, double) with 'x', 'y', 'octaves', 'frequency', 'amplitude'; when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, int, double, double)"})
  void testNoiseWithXYOctavesFrequencyAmplitude_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 1, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, int, double, double)} with {@code x}, {@code
   * y}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, int, double, double) with 'x', 'y', 'octaves', 'frequency', 'amplitude'; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, int, double, double)"})
  void testNoiseWithXYOctavesFrequencyAmplitude_whenTwo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 3, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, int, double, double)} with {@code x}, {@code
   * y}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, int, double, double) with 'x', 'y', 'octaves', 'frequency', 'amplitude'; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, int, double, double)"})
  void testNoiseWithXYOctavesFrequencyAmplitude_whenTwo_thenReturnZero2() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 2, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, int, double, double)} with {@code x}, {@code
   * y}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, int, double, double) with 'x', 'y', 'octaves', 'frequency', 'amplitude'; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, int, double, double)"})
  void testNoiseWithXYOctavesFrequencyAmplitude_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 0, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, double, int, double, double, boolean)} with
   * {@code x}, {@code y}, {@code z}, {@code octaves}, {@code frequency}, {@code amplitude}, {@code
   * normalized}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, double, int, double, double,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, int, double, double, boolean) with 'x', 'y', 'z', 'octaves', 'frequency', 'amplitude', 'normalized'; when '-0.5'; then return '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double NoiseGenerator.noise(double, double, double, int, double, double, boolean)"
  })
  void testNoiseWithXYZOctavesFrequencyAmplitudeNormalized_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(
        0.5d, PerlinNoiseGenerator.getInstance().noise(-0.5d, 3.0d, 10.0d, 1, 10.0d, 10.0d, true));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, double, int, double, double, boolean)} with
   * {@code x}, {@code y}, {@code z}, {@code octaves}, {@code frequency}, {@code amplitude}, {@code
   * normalized}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, double, int, double, double,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, int, double, double, boolean) with 'x', 'y', 'z', 'octaves', 'frequency', 'amplitude', 'normalized'; when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double NoiseGenerator.noise(double, double, double, int, double, double, boolean)"
  })
  void testNoiseWithXYZOctavesFrequencyAmplitudeNormalized_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 10.0d, 1, 10.0d, 10.0d, true));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, double, int, double, double, boolean)} with
   * {@code x}, {@code y}, {@code z}, {@code octaves}, {@code frequency}, {@code amplitude}, {@code
   * normalized}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, double, int, double, double,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, int, double, double, boolean) with 'x', 'y', 'z', 'octaves', 'frequency', 'amplitude', 'normalized'; when seven; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double NoiseGenerator.noise(double, double, double, int, double, double, boolean)"
  })
  void testNoiseWithXYZOctavesFrequencyAmplitudeNormalized_whenSeven_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 10.0d, 7, 10.0d, 10.0d, false));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, double, int, double, double, boolean)} with
   * {@code x}, {@code y}, {@code z}, {@code octaves}, {@code frequency}, {@code amplitude}, {@code
   * normalized}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, double, int, double, double,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, int, double, double, boolean) with 'x', 'y', 'z', 'octaves', 'frequency', 'amplitude', 'normalized'; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double NoiseGenerator.noise(double, double, double, int, double, double, boolean)"
  })
  void testNoiseWithXYZOctavesFrequencyAmplitudeNormalized_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 10.0d, 0, 10.0d, 10.0d, false));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, double, int, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, int, double, double) with 'x', 'y', 'z', 'octaves', 'frequency', 'amplitude'; when '-0.5'; then return '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, double, int, double, double)"})
  void testNoiseWithXYZOctavesFrequencyAmplitude_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(
        0.5d, PerlinNoiseGenerator.getInstance().noise(-0.5d, 3.0d, 10.0d, 3, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, double, int, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, int, double, double) with 'x', 'y', 'z', 'octaves', 'frequency', 'amplitude'; when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, double, int, double, double)"})
  void testNoiseWithXYZOctavesFrequencyAmplitude_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 10.0d, 1, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, double, int, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, int, double, double) with 'x', 'y', 'z', 'octaves', 'frequency', 'amplitude'; when seven; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, double, int, double, double)"})
  void testNoiseWithXYZOctavesFrequencyAmplitude_whenSeven_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 10.0d, 7, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, double, int, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, int, double, double) with 'x', 'y', 'z', 'octaves', 'frequency', 'amplitude'; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, double, int, double, double)"})
  void testNoiseWithXYZOctavesFrequencyAmplitude_whenTwo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 10.0d, 3, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, double, int, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, int, double, double) with 'x', 'y', 'z', 'octaves', 'frequency', 'amplitude'; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, double, int, double, double)"})
  void testNoiseWithXYZOctavesFrequencyAmplitude_whenTwo_thenReturnZero2() {
    // Arrange, Act and Assert
    assertEquals(
        0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 10.0d, 2, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double, double, int, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code octaves}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double, double, int, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, int, double, double) with 'x', 'y', 'z', 'octaves', 'frequency', 'amplitude'; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double, double, int, double, double)"})
  void testNoiseWithXYZOctavesFrequencyAmplitude_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d, 10.0d, 0, 10.0d, 10.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double)} with {@code x}, {@code y}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double) with 'x', 'y'; given Instance; when '-0.5'; then return '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double)"})
  void testNoiseWithXY_givenInstance_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(0.5d, PerlinNoiseGenerator.getInstance().noise(-0.5d, 3.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double)} with {@code x}, {@code y}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When fifteen.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double) with 'x', 'y'; given Instance; when fifteen; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double)"})
  void testNoiseWithXY_givenInstance_whenFifteen_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(15.0d, 3.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double)} with {@code x}, {@code y}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When six.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double) with 'x', 'y'; given Instance; when six; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double)"})
  void testNoiseWithXY_givenInstance_whenSix_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(6.0d, 3.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double)} with {@code x}, {@code y}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When three.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double) with 'x', 'y'; given Instance; when three; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double)"})
  void testNoiseWithXY_givenInstance_whenThree_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(3.0d, 3.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double)} with {@code x}, {@code y}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When two.
   *   <li>Then return {@code -0.36666949990342584}.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double) with 'x', 'y'; given Instance; when two; then return '-0.36666949990342584'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double)"})
  void testNoiseWithXY_givenInstance_whenTwo_thenReturn036666949990342584() {
    // Arrange, Act and Assert
    assertEquals(-0.36666949990342584d, SimplexNoiseGenerator.getInstance().noise(2.0d, 3.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double)} with {@code x}, {@code y}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double) with 'x', 'y'; given Instance; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double)"})
  void testNoiseWithXY_givenInstance_whenTwo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d, 3.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double, double)} with {@code x}, {@code y}.
   *
   * <ul>
   *   <li>Then return {@code 0.057925842721085044}.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double, double)}
   */
  @Test
  @DisplayName("Test noise(double, double) with 'x', 'y'; then return '0.057925842721085044'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double, double)"})
  void testNoiseWithXY_thenReturn0057925842721085044() {
    // Arrange, Act and Assert
    assertEquals(0.057925842721085044d, new PerlinNoiseGenerator(42L).noise(2.0d, 3.0d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double)} with {@code x}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double)}
   */
  @Test
  @DisplayName("Test noise(double) with 'x'; when '-0.5'; then return '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double)"})
  void testNoiseWithX_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(-0.5d, PerlinNoiseGenerator.getInstance().noise(-0.5d));
  }

  /**
   * Test {@link NoiseGenerator#noise(double)} with {@code x}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NoiseGenerator#noise(double)}
   */
  @Test
  @DisplayName("Test noise(double) with 'x'; when two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NoiseGenerator.noise(double)"})
  void testNoiseWithX_whenTwo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PerlinNoiseGenerator.getInstance().noise(2.0d));
  }
}

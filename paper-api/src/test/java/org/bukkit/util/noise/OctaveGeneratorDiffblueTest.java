package org.bukkit.util.noise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class OctaveGeneratorDiffblueTest {
  /**
   * Test {@link OctaveGenerator#setScale(double)}.
   *
   * <p>Method under test: {@link OctaveGenerator#setScale(double)}
   */
  @Test
  @DisplayName("Test setScale(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OctaveGenerator.setScale(double)"})
  void testSetScale() {
    // Arrange
    PerlinOctaveGenerator perlinOctaveGenerator = new PerlinOctaveGenerator(42L, 1);

    // Act
    perlinOctaveGenerator.setScale(10.0d);

    // Assert
    assertEquals(10.0d, perlinOctaveGenerator.getXScale());
    assertEquals(10.0d, perlinOctaveGenerator.getYScale());
    assertEquals(10.0d, perlinOctaveGenerator.getZScale());
  }

  /**
   * Test {@link OctaveGenerator#getXScale()}.
   *
   * <p>Method under test: {@link OctaveGenerator#getXScale()}
   */
  @Test
  @DisplayName("Test getXScale()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.getXScale()"})
  void testGetXScale() {
    // Arrange, Act and Assert
    assertEquals(1.0d, new PerlinOctaveGenerator(42L, 1).getXScale());
  }

  /**
   * Test {@link OctaveGenerator#setXScale(double)}.
   *
   * <p>Method under test: {@link OctaveGenerator#setXScale(double)}
   */
  @Test
  @DisplayName("Test setXScale(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OctaveGenerator.setXScale(double)"})
  void testSetXScale() {
    // Arrange
    PerlinOctaveGenerator perlinOctaveGenerator = new PerlinOctaveGenerator(42L, 1);

    // Act
    perlinOctaveGenerator.setXScale(10.0d);

    // Assert
    assertEquals(10.0d, perlinOctaveGenerator.getXScale());
  }

  /**
   * Test {@link OctaveGenerator#getYScale()}.
   *
   * <p>Method under test: {@link OctaveGenerator#getYScale()}
   */
  @Test
  @DisplayName("Test getYScale()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.getYScale()"})
  void testGetYScale() {
    // Arrange, Act and Assert
    assertEquals(1.0d, new PerlinOctaveGenerator(42L, 1).getYScale());
  }

  /**
   * Test {@link OctaveGenerator#setYScale(double)}.
   *
   * <p>Method under test: {@link OctaveGenerator#setYScale(double)}
   */
  @Test
  @DisplayName("Test setYScale(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OctaveGenerator.setYScale(double)"})
  void testSetYScale() {
    // Arrange
    PerlinOctaveGenerator perlinOctaveGenerator = new PerlinOctaveGenerator(42L, 1);

    // Act
    perlinOctaveGenerator.setYScale(10.0d);

    // Assert
    assertEquals(10.0d, perlinOctaveGenerator.getYScale());
  }

  /**
   * Test {@link OctaveGenerator#getZScale()}.
   *
   * <p>Method under test: {@link OctaveGenerator#getZScale()}
   */
  @Test
  @DisplayName("Test getZScale()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.getZScale()"})
  void testGetZScale() {
    // Arrange, Act and Assert
    assertEquals(1.0d, new PerlinOctaveGenerator(42L, 1).getZScale());
  }

  /**
   * Test {@link OctaveGenerator#setZScale(double)}.
   *
   * <p>Method under test: {@link OctaveGenerator#setZScale(double)}
   */
  @Test
  @DisplayName("Test setZScale(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OctaveGenerator.setZScale(double)"})
  void testSetZScale() {
    // Arrange
    PerlinOctaveGenerator perlinOctaveGenerator = new PerlinOctaveGenerator(42L, 1);

    // Act
    perlinOctaveGenerator.setZScale(10.0d);

    // Assert
    assertEquals(10.0d, perlinOctaveGenerator.getZScale());
  }

  /**
   * Test {@link OctaveGenerator#getOctaves()}.
   *
   * <p>Method under test: {@link OctaveGenerator#getOctaves()}
   */
  @Test
  @DisplayName("Test getOctaves()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NoiseGenerator[] OctaveGenerator.getOctaves()"})
  void testGetOctaves() {
    // Arrange and Act
    NoiseGenerator[] actualOctaves = new PerlinOctaveGenerator(42L, 1).getOctaves();

    // Assert
    NoiseGenerator noiseGenerator = actualOctaves[0];
    assertTrue(noiseGenerator instanceof PerlinNoiseGenerator);
    assertEquals(1, actualOctaves.length);
    assertEquals(174.90520877052043d, ((PerlinNoiseGenerator) noiseGenerator).offsetY);
    assertEquals(186.25630208841423d, ((PerlinNoiseGenerator) noiseGenerator).offsetX);
    assertEquals(512, ((PerlinNoiseGenerator) noiseGenerator).perm.length);
    assertEquals(79.0321805651609d, ((PerlinNoiseGenerator) noiseGenerator).offsetZ);
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, boolean)} with {@code x}, {@code
   * frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, boolean) with 'x', 'frequency', 'amplitude', 'normalized'; when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, boolean)"})
  void testNoiseWithXFrequencyAmplitudeNormalized_whenFalse() {
    // Arrange, Act and Assert
    assertEquals(
        -0.06382352349349803d, new PerlinOctaveGenerator(42L, 1).noise(2.0d, 10.0d, 10.0d, false));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, boolean)} with {@code x}, {@code
   * frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, boolean) with 'x', 'frequency', 'amplitude', 'normalized'; when NaN; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, boolean)"})
  void testNoiseWithXFrequencyAmplitudeNormalized_whenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(
        Double.NaN, new PerlinOctaveGenerator(42L, 1).noise(Double.NaN, 10.0d, 10.0d, true));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, boolean)} with {@code x}, {@code
   * frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code -0.06382352349349803}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, boolean) with 'x', 'frequency', 'amplitude', 'normalized'; when two; then return '-0.06382352349349803'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, boolean)"})
  void testNoiseWithXFrequencyAmplitudeNormalized_whenTwo_thenReturn006382352349349803() {
    // Arrange, Act and Assert
    assertEquals(
        -0.06382352349349803d, new PerlinOctaveGenerator(42L, 1).noise(2.0d, 10.0d, 10.0d, true));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double)} with {@code x}, {@code frequency},
   * {@code amplitude}.
   *
   * <ul>
   *   <li>Then return {@code 39.85164068290676}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'x', 'frequency', 'amplitude'; then return '39.85164068290676'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double)"})
  void testNoiseWithXFrequencyAmplitude_thenReturn3985164068290676() {
    // Arrange, Act and Assert
    assertEquals(
        39.85164068290676d,
        new PerlinOctaveGenerator(42L, 3).noise(188.25630208841423d, 10.0d, 10.0d));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double)} with {@code x}, {@code frequency},
   * {@code amplitude}.
   *
   * <ul>
   *   <li>Then return {@code -0.8707816567138504}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'x', 'frequency', 'amplitude'; then return '-0.8707816567138504'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double)"})
  void testNoiseWithXFrequencyAmplitude_thenReturn08707816567138504() {
    // Arrange, Act and Assert
    assertEquals(
        -0.8707816567138504d,
        new PerlinOctaveGenerator(42L, 3).noise(174.90520877052043d, 10.0d, 10.0d));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double)} with {@code x}, {@code frequency},
   * {@code amplitude}.
   *
   * <ul>
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'x', 'frequency', 'amplitude'; when NaN; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double)"})
  void testNoiseWithXFrequencyAmplitude_whenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, new PerlinOctaveGenerator(42L, 3).noise(Double.NaN, 10.0d, 10.0d));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double)} with {@code x}, {@code frequency},
   * {@code amplitude}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code -10.624231819653428}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'x', 'frequency', 'amplitude'; when one; then return '-10.624231819653428'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double)"})
  void testNoiseWithXFrequencyAmplitude_whenOne_thenReturn10624231819653428() {
    // Arrange, Act and Assert
    assertEquals(-10.624231819653428d, new PerlinOctaveGenerator(42L, 3).noise(1.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double)} with {@code x}, {@code frequency},
   * {@code amplitude}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code -19.314578254261395}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'x', 'frequency', 'amplitude'; when two; then return '-19.314578254261395'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double)"})
  void testNoiseWithXFrequencyAmplitude_whenTwo_thenReturn19314578254261395() {
    // Arrange, Act and Assert
    assertEquals(-19.314578254261395d, new PerlinOctaveGenerator(42L, 3).noise(2.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double)} with {@code x}, {@code y},
   * {@code frequency}, {@code amplitude}.
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double)}
   */
  @Test
  @DisplayName("Test noise(double, double, double, double) with 'x', 'y', 'frequency', 'amplitude'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, double)"})
  void testNoiseWithXYFrequencyAmplitude() {
    // Arrange
    PerlinOctaveGenerator perlinOctaveGenerator = new PerlinOctaveGenerator(new Random(), 3);

    // Act
    perlinOctaveGenerator.noise(2.0d, 3.0d, 10.0d, 10.0d);

    // Assert
    NoiseGenerator[] octaves = perlinOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof PerlinNoiseGenerator);
    assertEquals(3, octaves.length);
    assertEquals(512, ((PerlinNoiseGenerator) noiseGenerator).perm.length);
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double, boolean)} with {@code x},
   * {@code y}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>Then return {@code 0.267778600061201}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, boolean) with 'x', 'y', 'frequency', 'amplitude', 'normalized'; then return '0.267778600061201'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, double, boolean)"})
  void testNoiseWithXYFrequencyAmplitudeNormalized_thenReturn0267778600061201() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);

    PerlinOctaveGenerator perlinOctaveGenerator = new PerlinOctaveGenerator(world, 1);
    perlinOctaveGenerator.setXScale(10.0d);

    // Act
    double actualNoiseResult = perlinOctaveGenerator.noise(2.0d, 3.0d, 10.0d, 10.0d, true);

    // Assert
    verify(world).getSeed();
    assertEquals(0.267778600061201d, actualNoiseResult);
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double, boolean)} with {@code x},
   * {@code y}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>Then return {@code 0.057925842721085044}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, boolean) with 'x', 'y', 'frequency', 'amplitude', 'normalized'; then return '0.057925842721085044'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, double, boolean)"})
  void testNoiseWithXYFrequencyAmplitudeNormalized_thenReturn0057925842721085044() {
    // Arrange, Act and Assert
    assertEquals(
        0.057925842721085044d,
        new PerlinOctaveGenerator(42L, 1).noise(2.0d, 3.0d, 10.0d, 10.0d, true));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double, boolean)} with {@code x},
   * {@code y}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, boolean) with 'x', 'y', 'frequency', 'amplitude', 'normalized'; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, double, boolean)"})
  void testNoiseWithXYFrequencyAmplitudeNormalized_thenReturnNaN() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);

    // Act
    double actualNoiseResult =
        new PerlinOctaveGenerator(world, 1).noise(Double.NaN, 3.0d, 10.0d, 10.0d, true);

    // Assert
    verify(world).getSeed();
    assertEquals(Double.NaN, actualNoiseResult);
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double, boolean)} with {@code x},
   * {@code y}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, boolean) with 'x', 'y', 'frequency', 'amplitude', 'normalized'; when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, double, boolean)"})
  void testNoiseWithXYFrequencyAmplitudeNormalized_whenFalse() {
    // Arrange, Act and Assert
    assertEquals(
        0.057925842721085044d,
        new PerlinOctaveGenerator(42L, 1).noise(2.0d, 3.0d, 10.0d, 10.0d, false));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double)} with {@code x}, {@code y},
   * {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>Then return {@code 32.54764142901676}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double) with 'x', 'y', 'frequency', 'amplitude'; then return '32.54764142901676'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, double)"})
  void testNoiseWithXYFrequencyAmplitude_thenReturn3254764142901676() {
    // Arrange
    PerlinOctaveGenerator perlinOctaveGenerator = new PerlinOctaveGenerator(42L, 3);

    // Act
    double actualNoiseResult = perlinOctaveGenerator.noise(177.90520877052043d, 3.0d, 10.0d, 10.0d);

    // Assert
    NoiseGenerator[] octaves = perlinOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof PerlinNoiseGenerator);
    int[] intArray = ((PerlinNoiseGenerator) noiseGenerator).perm;
    assertEquals(152, intArray[20]);
    assertEquals(3, octaves.length);
    assertEquals(32.54764142901676d, actualNoiseResult);
    assertEquals(512, intArray.length);
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double)} with {@code x}, {@code y},
   * {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>Then return {@code -16.507448045677112}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double) with 'x', 'y', 'frequency', 'amplitude'; then return '-16.507448045677112'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, double)"})
  void testNoiseWithXYFrequencyAmplitude_thenReturn16507448045677112() {
    // Arrange
    PerlinOctaveGenerator perlinOctaveGenerator = new PerlinOctaveGenerator(42L, 3);

    // Act
    double actualNoiseResult = perlinOctaveGenerator.noise(188.25630208841423d, 3.0d, 10.0d, 10.0d);

    // Assert
    NoiseGenerator[] octaves = perlinOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof PerlinNoiseGenerator);
    assertEquals(-16.507448045677112d, actualNoiseResult);
    int[] intArray = ((PerlinNoiseGenerator) noiseGenerator).perm;
    assertEquals(152, intArray[20]);
    assertEquals(3, octaves.length);
    assertEquals(512, intArray.length);
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double)} with {@code x}, {@code y},
   * {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double) with 'x', 'y', 'frequency', 'amplitude'; when NaN; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, double)"})
  void testNoiseWithXYFrequencyAmplitude_whenNaN_thenReturnNaN() {
    // Arrange
    PerlinOctaveGenerator perlinOctaveGenerator = new PerlinOctaveGenerator(42L, 3);

    // Act
    double actualNoiseResult = perlinOctaveGenerator.noise(Double.NaN, 3.0d, 10.0d, 10.0d);

    // Assert
    NoiseGenerator[] octaves = perlinOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof PerlinNoiseGenerator);
    int[] intArray = ((PerlinNoiseGenerator) noiseGenerator).perm;
    assertEquals(152, intArray[20]);
    assertEquals(3, octaves.length);
    assertEquals(512, intArray.length);
    assertEquals(Double.NaN, actualNoiseResult);
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double)} with {@code x}, {@code y},
   * {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 7.088682170287367}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double) with 'x', 'y', 'frequency', 'amplitude'; when one; then return '7.088682170287367'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, double)"})
  void testNoiseWithXYFrequencyAmplitude_whenOne_thenReturn7088682170287367() {
    // Arrange
    PerlinOctaveGenerator perlinOctaveGenerator = new PerlinOctaveGenerator(42L, 3);

    // Act
    double actualNoiseResult = perlinOctaveGenerator.noise(1.0d, 3.0d, 10.0d, 10.0d);

    // Assert
    NoiseGenerator[] octaves = perlinOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof PerlinNoiseGenerator);
    int[] intArray = ((PerlinNoiseGenerator) noiseGenerator).perm;
    assertEquals(152, intArray[20]);
    assertEquals(3, octaves.length);
    assertEquals(512, intArray.length);
    assertEquals(7.088682170287367d, actualNoiseResult);
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double)} with {@code x}, {@code y},
   * {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code 17.816943060632276}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double) with 'x', 'y', 'frequency', 'amplitude'; when two; then return '17.816943060632276'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, double)"})
  void testNoiseWithXYFrequencyAmplitude_whenTwo_thenReturn17816943060632276() {
    // Arrange
    PerlinOctaveGenerator perlinOctaveGenerator = new PerlinOctaveGenerator(42L, 3);

    // Act
    double actualNoiseResult = perlinOctaveGenerator.noise(2.0d, 3.0d, 10.0d, 10.0d);

    // Assert
    NoiseGenerator[] octaves = perlinOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof PerlinNoiseGenerator);
    int[] intArray = ((PerlinNoiseGenerator) noiseGenerator).perm;
    assertEquals(152, intArray[20]);
    assertEquals(17.816943060632276d, actualNoiseResult);
    assertEquals(3, octaves.length);
    assertEquals(512, intArray.length);
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double, double, boolean)} with {@code
   * x}, {@code y}, {@code z}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>Then return {@code -0.06667707500532585}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double, double,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, boolean) with 'x', 'y', 'z', 'frequency', 'amplitude', 'normalized'; then return '-0.06667707500532585'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double OctaveGenerator.noise(double, double, double, double, double, boolean)"
  })
  void testNoiseWithXYZFrequencyAmplitudeNormalized_thenReturn006667707500532585() {
    // Arrange, Act and Assert
    assertEquals(
        -0.06667707500532585d,
        new PerlinOctaveGenerator(42L, 1).noise(2.0d, 3.0d, 10.0d, 10.0d, 10.0d, true));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double, double, boolean)} with {@code
   * x}, {@code y}, {@code z}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double, double,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, boolean) with 'x', 'y', 'z', 'frequency', 'amplitude', 'normalized'; when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double OctaveGenerator.noise(double, double, double, double, double, boolean)"
  })
  void testNoiseWithXYZFrequencyAmplitudeNormalized_whenFalse() {
    // Arrange, Act and Assert
    assertEquals(
        -0.06667707500532585d,
        new PerlinOctaveGenerator(42L, 1).noise(2.0d, 3.0d, 10.0d, 10.0d, 10.0d, false));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double, double, boolean)} with {@code
   * x}, {@code y}, {@code z}, {@code frequency}, {@code amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double, double,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, boolean) with 'x', 'y', 'z', 'frequency', 'amplitude', 'normalized'; when NaN; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double OctaveGenerator.noise(double, double, double, double, double, boolean)"
  })
  void testNoiseWithXYZFrequencyAmplitudeNormalized_whenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(
        Double.NaN,
        new PerlinOctaveGenerator(42L, 1).noise(Double.NaN, 3.0d, 10.0d, 10.0d, 10.0d, true));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>Then return {@code -52.09981268043738}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double) with 'x', 'y', 'z', 'frequency', 'amplitude'; then return '-52.09981268043738'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, double, double)"})
  void testNoiseWithXYZFrequencyAmplitude_thenReturn5209981268043738() {
    // Arrange, Act and Assert
    assertEquals(
        -52.09981268043738d,
        new PerlinOctaveGenerator(42L, 3).noise(177.90520877052043d, 3.0d, 10.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>Then return {@code 3.7939633736302993}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double) with 'x', 'y', 'z', 'frequency', 'amplitude'; then return '3.7939633736302993'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, double, double)"})
  void testNoiseWithXYZFrequencyAmplitude_thenReturn37939633736302993() {
    // Arrange, Act and Assert
    assertEquals(
        3.7939633736302993d,
        new PerlinOctaveGenerator(42L, 3).noise(188.25630208841423d, 3.0d, 10.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double) with 'x', 'y', 'z', 'frequency', 'amplitude'; when NaN; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, double, double)"})
  void testNoiseWithXYZFrequencyAmplitude_whenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(
        Double.NaN, new PerlinOctaveGenerator(42L, 3).noise(Double.NaN, 3.0d, 10.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code -0.5646938405114099}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double) with 'x', 'y', 'z', 'frequency', 'amplitude'; when one; then return '-0.5646938405114099'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, double, double)"})
  void testNoiseWithXYZFrequencyAmplitude_whenOne_thenReturn05646938405114099() {
    // Arrange, Act and Assert
    assertEquals(
        -0.5646938405114099d,
        new PerlinOctaveGenerator(42L, 3).noise(1.0d, 3.0d, 10.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link OctaveGenerator#noise(double, double, double, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code -9.683948251227484}.
   * </ul>
   *
   * <p>Method under test: {@link OctaveGenerator#noise(double, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double) with 'x', 'y', 'z', 'frequency', 'amplitude'; when two; then return '-9.683948251227484'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OctaveGenerator.noise(double, double, double, double, double)"})
  void testNoiseWithXYZFrequencyAmplitude_whenTwo_thenReturn9683948251227484() {
    // Arrange, Act and Assert
    assertEquals(
        -9.683948251227484d,
        new PerlinOctaveGenerator(42L, 3).noise(2.0d, 3.0d, 10.0d, 10.0d, 10.0d));
  }
}

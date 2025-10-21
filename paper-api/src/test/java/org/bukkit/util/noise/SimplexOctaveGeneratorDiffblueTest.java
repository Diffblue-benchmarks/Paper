package org.bukkit.util.noise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
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

class SimplexOctaveGeneratorDiffblueTest {
  /**
   * Test {@link SimplexOctaveGenerator#SimplexOctaveGenerator(long, int)}.
   *
   * <ul>
   *   <li>Then first element return {@link SimplexNoiseGenerator}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#SimplexOctaveGenerator(long, int)}
   */
  @Test
  @DisplayName(
      "Test new SimplexOctaveGenerator(long, int); then first element return SimplexNoiseGenerator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplexOctaveGenerator.<init>(long, int)"})
  void testNewSimplexOctaveGenerator_thenFirstElementReturnSimplexNoiseGenerator() {
    // Arrange and Act
    SimplexOctaveGenerator actualSimplexOctaveGenerator = new SimplexOctaveGenerator(42L, 1);

    // Assert
    NoiseGenerator[] octaves = actualSimplexOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof SimplexNoiseGenerator);
    assertEquals(1, octaves.length);
    NoiseGenerator[] noiseGeneratorArray = actualSimplexOctaveGenerator.octaves;
    assertEquals(1, noiseGeneratorArray.length);
    assertEquals(1.0d, actualSimplexOctaveGenerator.getXScale());
    assertEquals(1.0d, actualSimplexOctaveGenerator.getYScale());
    assertEquals(1.0d, actualSimplexOctaveGenerator.getZScale());
    assertEquals(1.0d, actualSimplexOctaveGenerator.getWScale());
    assertEquals(174.90520877052043d, ((SimplexNoiseGenerator) noiseGenerator).offsetY);
    assertEquals(186.25630208841423d, ((SimplexNoiseGenerator) noiseGenerator).offsetX);
    assertEquals(512, ((SimplexNoiseGenerator) noiseGenerator).perm.length);
    assertEquals(74.30495038659771d, ((SimplexNoiseGenerator) noiseGenerator).offsetW);
    assertEquals(79.0321805651609d, ((SimplexNoiseGenerator) noiseGenerator).offsetZ);
    assertSame(noiseGenerator, noiseGeneratorArray[0]);
  }

  /**
   * Test {@link SimplexOctaveGenerator#SimplexOctaveGenerator(Random, int)}.
   *
   * <ul>
   *   <li>Then first element return {@link SimplexNoiseGenerator}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#SimplexOctaveGenerator(Random, int)}
   */
  @Test
  @DisplayName(
      "Test new SimplexOctaveGenerator(Random, int); then first element return SimplexNoiseGenerator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplexOctaveGenerator.<init>(Random, int)"})
  void testNewSimplexOctaveGenerator_thenFirstElementReturnSimplexNoiseGenerator2() {
    // Arrange and Act
    SimplexOctaveGenerator actualSimplexOctaveGenerator =
        new SimplexOctaveGenerator(new Random(), 1);

    // Assert
    NoiseGenerator[] octaves = actualSimplexOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof SimplexNoiseGenerator);
    assertEquals(1, octaves.length);
    NoiseGenerator[] noiseGeneratorArray = actualSimplexOctaveGenerator.octaves;
    assertEquals(1, noiseGeneratorArray.length);
    assertEquals(1.0d, actualSimplexOctaveGenerator.getXScale());
    assertEquals(1.0d, actualSimplexOctaveGenerator.getYScale());
    assertEquals(1.0d, actualSimplexOctaveGenerator.getZScale());
    assertEquals(1.0d, actualSimplexOctaveGenerator.getWScale());
    assertEquals(512, ((SimplexNoiseGenerator) noiseGenerator).perm.length);
    assertSame(noiseGenerator, noiseGeneratorArray[0]);
  }

  /**
   * Test {@link SimplexOctaveGenerator#SimplexOctaveGenerator(World, int)}.
   *
   * <ul>
   *   <li>Then first element return {@link SimplexNoiseGenerator}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#SimplexOctaveGenerator(World, int)}
   */
  @Test
  @DisplayName(
      "Test new SimplexOctaveGenerator(World, int); then first element return SimplexNoiseGenerator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplexOctaveGenerator.<init>(World, int)"})
  void testNewSimplexOctaveGenerator_thenFirstElementReturnSimplexNoiseGenerator3() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);

    // Act
    SimplexOctaveGenerator actualSimplexOctaveGenerator = new SimplexOctaveGenerator(world, 1);

    // Assert
    verify(world).getSeed();
    NoiseGenerator[] octaves = actualSimplexOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof SimplexNoiseGenerator);
    assertEquals(1, octaves.length);
    NoiseGenerator[] noiseGeneratorArray = actualSimplexOctaveGenerator.octaves;
    assertEquals(1, noiseGeneratorArray.length);
    assertEquals(1.0d, actualSimplexOctaveGenerator.getXScale());
    assertEquals(1.0d, actualSimplexOctaveGenerator.getYScale());
    assertEquals(1.0d, actualSimplexOctaveGenerator.getZScale());
    assertEquals(1.0d, actualSimplexOctaveGenerator.getWScale());
    assertEquals(174.90520877052043d, ((SimplexNoiseGenerator) noiseGenerator).offsetY);
    assertEquals(186.25630208841423d, ((SimplexNoiseGenerator) noiseGenerator).offsetX);
    assertEquals(512, ((SimplexNoiseGenerator) noiseGenerator).perm.length);
    assertEquals(74.30495038659771d, ((SimplexNoiseGenerator) noiseGenerator).offsetW);
    assertEquals(79.0321805651609d, ((SimplexNoiseGenerator) noiseGenerator).offsetZ);
    assertSame(noiseGenerator, noiseGeneratorArray[0]);
  }

  /**
   * Test {@link SimplexOctaveGenerator#setScale(double)}.
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#setScale(double)}
   */
  @Test
  @DisplayName("Test setScale(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplexOctaveGenerator.setScale(double)"})
  void testSetScale() {
    // Arrange
    SimplexOctaveGenerator simplexOctaveGenerator = new SimplexOctaveGenerator(42L, 1);

    // Act
    simplexOctaveGenerator.setScale(10.0d);

    // Assert
    assertEquals(10.0d, simplexOctaveGenerator.getXScale());
    assertEquals(10.0d, simplexOctaveGenerator.getYScale());
    assertEquals(10.0d, simplexOctaveGenerator.getZScale());
    assertEquals(10.0d, simplexOctaveGenerator.getWScale());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimplexOctaveGenerator#setWScale(double)}
   *   <li>{@link SimplexOctaveGenerator#getWScale()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double SimplexOctaveGenerator.getWScale()",
    "void SimplexOctaveGenerator.setWScale(double)"
  })
  void testGettersAndSetters() {
    // Arrange
    SimplexOctaveGenerator simplexOctaveGenerator = new SimplexOctaveGenerator(42L, 1);

    // Act
    simplexOctaveGenerator.setWScale(10.0d);

    // Assert
    assertEquals(10.0d, simplexOctaveGenerator.getWScale());
  }

  /**
   * Test {@link SimplexOctaveGenerator#noise(double, double, double, double, double, double,
   * boolean)} with {@code x}, {@code y}, {@code z}, {@code w}, {@code frequency}, {@code
   * amplitude}, {@code normalized}.
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#noise(double, double, double, double,
   * double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, double, boolean) with 'x', 'y', 'z', 'w', 'frequency', 'amplitude', 'normalized'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double SimplexOctaveGenerator.noise(double, double, double, double, double, double, boolean)"
  })
  void testNoiseWithXYZWFrequencyAmplitudeNormalized() {
    // Arrange
    SimplexOctaveGenerator simplexOctaveGenerator = new SimplexOctaveGenerator(42L, 1);

    // Act
    double actualNoiseResult =
        simplexOctaveGenerator.noise(2.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d, true);

    // Assert
    NoiseGenerator[] octaves = simplexOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof SimplexNoiseGenerator);
    assertEquals(0.46341559385533015d, actualNoiseResult);
    assertEquals(1, octaves.length);
    int[] intArray = ((SimplexNoiseGenerator) noiseGenerator).perm;
    assertEquals(177, intArray[497]);
    assertEquals(512, intArray.length);
    assertEquals(77, intArray[503]);
  }

  /**
   * Test {@link SimplexOctaveGenerator#noise(double, double, double, double, double, double,
   * boolean)} with {@code x}, {@code y}, {@code z}, {@code w}, {@code frequency}, {@code
   * amplitude}, {@code normalized}.
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#noise(double, double, double, double,
   * double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, double, boolean) with 'x', 'y', 'z', 'w', 'frequency', 'amplitude', 'normalized'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double SimplexOctaveGenerator.noise(double, double, double, double, double, double, boolean)"
  })
  void testNoiseWithXYZWFrequencyAmplitudeNormalized2() {
    // Arrange
    SimplexOctaveGenerator simplexOctaveGenerator = new SimplexOctaveGenerator(new Random(), 1);

    // Act
    simplexOctaveGenerator.noise(2.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d, true);

    // Assert
    NoiseGenerator[] octaves = simplexOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof SimplexNoiseGenerator);
    assertEquals(1, octaves.length);
    assertEquals(512, ((SimplexNoiseGenerator) noiseGenerator).perm.length);
  }

  /**
   * Test {@link SimplexOctaveGenerator#noise(double, double, double, double, double, double,
   * boolean)} with {@code x}, {@code y}, {@code z}, {@code w}, {@code frequency}, {@code
   * amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>Then return {@code -0.004146027530305793}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#noise(double, double, double, double,
   * double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, double, boolean) with 'x', 'y', 'z', 'w', 'frequency', 'amplitude', 'normalized'; then return '-0.004146027530305793'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double SimplexOctaveGenerator.noise(double, double, double, double, double, double, boolean)"
  })
  void testNoiseWithXYZWFrequencyAmplitudeNormalized_thenReturn0004146027530305793() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);
    SimplexOctaveGenerator simplexOctaveGenerator = new SimplexOctaveGenerator(world, 9);

    // Act
    double actualNoiseResult =
        simplexOctaveGenerator.noise(2.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d, true);

    // Assert
    verify(world).getSeed();
    NoiseGenerator[] octaves = simplexOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof SimplexNoiseGenerator);
    assertEquals(-0.004146027530305793d, actualNoiseResult);
    int[] intArray = ((SimplexNoiseGenerator) noiseGenerator).perm;
    assertEquals(177, intArray[497]);
    assertEquals(512, intArray.length);
    assertEquals(77, intArray[503]);
    assertEquals(9, octaves.length);
  }

  /**
   * Test {@link SimplexOctaveGenerator#noise(double, double, double, double, double, double,
   * boolean)} with {@code x}, {@code y}, {@code z}, {@code w}, {@code frequency}, {@code
   * amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>Then return {@code -0.04146027567620041}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#noise(double, double, double, double,
   * double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, double, boolean) with 'x', 'y', 'z', 'w', 'frequency', 'amplitude', 'normalized'; then return '-0.04146027567620041'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double SimplexOctaveGenerator.noise(double, double, double, double, double, double, boolean)"
  })
  void testNoiseWithXYZWFrequencyAmplitudeNormalized_thenReturn004146027567620041() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);
    SimplexOctaveGenerator simplexOctaveGenerator = new SimplexOctaveGenerator(world, 8);

    // Act
    double actualNoiseResult =
        simplexOctaveGenerator.noise(2.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d, true);

    // Assert
    verify(world).getSeed();
    NoiseGenerator[] octaves = simplexOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof SimplexNoiseGenerator);
    assertEquals(-0.04146027567620041d, actualNoiseResult);
    int[] intArray = ((SimplexNoiseGenerator) noiseGenerator).perm;
    assertEquals(177, intArray[497]);
    assertEquals(512, intArray.length);
    assertEquals(77, intArray[503]);
    assertEquals(8, octaves.length);
  }

  /**
   * Test {@link SimplexOctaveGenerator#noise(double, double, double, double, double, double,
   * boolean)} with {@code x}, {@code y}, {@code z}, {@code w}, {@code frequency}, {@code
   * amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>Then return {@code 0.09871247921214558}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#noise(double, double, double, double,
   * double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, double, boolean) with 'x', 'y', 'z', 'w', 'frequency', 'amplitude', 'normalized'; then return '0.09871247921214558'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double SimplexOctaveGenerator.noise(double, double, double, double, double, double, boolean)"
  })
  void testNoiseWithXYZWFrequencyAmplitudeNormalized_thenReturn009871247921214558() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);

    SimplexOctaveGenerator simplexOctaveGenerator = new SimplexOctaveGenerator(world, 1);
    simplexOctaveGenerator.setWScale(10.0d);

    // Act
    double actualNoiseResult =
        simplexOctaveGenerator.noise(2.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d, true);

    // Assert
    verify(world).getSeed();
    NoiseGenerator[] octaves = simplexOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof SimplexNoiseGenerator);
    assertEquals(0.09871247921214558d, actualNoiseResult);
    assertEquals(1, octaves.length);
    int[] intArray = ((SimplexNoiseGenerator) noiseGenerator).perm;
    assertEquals(177, intArray[497]);
    assertEquals(512, intArray.length);
    assertEquals(77, intArray[503]);
  }

  /**
   * Test {@link SimplexOctaveGenerator#noise(double, double, double, double, double, double,
   * boolean)} with {@code x}, {@code y}, {@code z}, {@code w}, {@code frequency}, {@code
   * amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>Then return {@code 0.19064100532611875}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#noise(double, double, double, double,
   * double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, double, boolean) with 'x', 'y', 'z', 'w', 'frequency', 'amplitude', 'normalized'; then return '0.19064100532611875'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double SimplexOctaveGenerator.noise(double, double, double, double, double, double, boolean)"
  })
  void testNoiseWithXYZWFrequencyAmplitudeNormalized_thenReturn019064100532611875() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(1L);
    SimplexOctaveGenerator simplexOctaveGenerator = new SimplexOctaveGenerator(world, 1);

    // Act
    double actualNoiseResult =
        simplexOctaveGenerator.noise(2.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d, true);

    // Assert
    verify(world).getSeed();
    NoiseGenerator[] octaves = simplexOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof SimplexNoiseGenerator);
    assertEquals(0.19064100532611875d, actualNoiseResult);
    assertEquals(1, octaves.length);
    int[] intArray = ((SimplexNoiseGenerator) noiseGenerator).perm;
    assertEquals(11, intArray[503]);
    assertEquals(133, intArray[497]);
    assertEquals(512, intArray.length);
  }

  /**
   * Test {@link SimplexOctaveGenerator#noise(double, double, double, double, double, double,
   * boolean)} with {@code x}, {@code y}, {@code z}, {@code w}, {@code frequency}, {@code
   * amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#noise(double, double, double, double,
   * double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, double, boolean) with 'x', 'y', 'z', 'w', 'frequency', 'amplitude', 'normalized'; when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double SimplexOctaveGenerator.noise(double, double, double, double, double, double, boolean)"
  })
  void testNoiseWithXYZWFrequencyAmplitudeNormalized_whenFalse() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);
    SimplexOctaveGenerator simplexOctaveGenerator = new SimplexOctaveGenerator(world, 1);

    // Act
    double actualNoiseResult =
        simplexOctaveGenerator.noise(2.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d, false);

    // Assert
    verify(world).getSeed();
    NoiseGenerator[] octaves = simplexOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof SimplexNoiseGenerator);
    assertEquals(0.46341559385533015d, actualNoiseResult);
    assertEquals(1, octaves.length);
    int[] intArray = ((SimplexNoiseGenerator) noiseGenerator).perm;
    assertEquals(177, intArray[497]);
    assertEquals(512, intArray.length);
    assertEquals(77, intArray[503]);
  }

  /**
   * Test {@link SimplexOctaveGenerator#noise(double, double, double, double, double, double,
   * boolean)} with {@code x}, {@code y}, {@code z}, {@code w}, {@code frequency}, {@code
   * amplitude}, {@code normalized}.
   *
   * <ul>
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#noise(double, double, double, double,
   * double, double, boolean)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, double, boolean) with 'x', 'y', 'z', 'w', 'frequency', 'amplitude', 'normalized'; when NaN; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double SimplexOctaveGenerator.noise(double, double, double, double, double, double, boolean)"
  })
  void testNoiseWithXYZWFrequencyAmplitudeNormalized_whenNaN_thenReturnNaN() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);
    SimplexOctaveGenerator simplexOctaveGenerator = new SimplexOctaveGenerator(world, 1);

    // Act
    double actualNoiseResult =
        simplexOctaveGenerator.noise(Double.NaN, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d, true);

    // Assert
    verify(world).getSeed();
    NoiseGenerator[] octaves = simplexOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof SimplexNoiseGenerator);
    assertEquals(1, octaves.length);
    int[] intArray = ((SimplexNoiseGenerator) noiseGenerator).perm;
    assertEquals(177, intArray[497]);
    assertEquals(512, intArray.length);
    assertEquals(77, intArray[503]);
    assertEquals(Double.NaN, actualNoiseResult);
  }

  /**
   * Test {@link SimplexOctaveGenerator#noise(double, double, double, double, double, double)} with
   * {@code x}, {@code y}, {@code z}, {@code w}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>Then return {@code -78.93111114904558}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#noise(double, double, double, double,
   * double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, double) with 'x', 'y', 'z', 'w', 'frequency', 'amplitude'; then return '-78.93111114904558'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double SimplexOctaveGenerator.noise(double, double, double, double, double, double)"
  })
  void testNoiseWithXYZWFrequencyAmplitude_thenReturn7893111114904558() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);

    SimplexOctaveGenerator simplexOctaveGenerator = new SimplexOctaveGenerator(world, 3);
    simplexOctaveGenerator.setWScale(10.0d);

    // Act
    double actualNoiseResult = simplexOctaveGenerator.noise(2.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    verify(world).getSeed();
    assertEquals(-78.93111114904558d, actualNoiseResult);
  }

  /**
   * Test {@link SimplexOctaveGenerator#noise(double, double, double, double, double, double)} with
   * {@code x}, {@code y}, {@code z}, {@code w}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>Then return {@code -11.834531842437137}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#noise(double, double, double, double,
   * double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, double) with 'x', 'y', 'z', 'w', 'frequency', 'amplitude'; then return '-11.834531842437137'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double SimplexOctaveGenerator.noise(double, double, double, double, double, double)"
  })
  void testNoiseWithXYZWFrequencyAmplitude_thenReturn11834531842437137() {
    // Arrange, Act and Assert
    assertEquals(
        -11.834531842437137d,
        new SimplexOctaveGenerator(42L, 3).noise(2.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexOctaveGenerator#noise(double, double, double, double, double, double)} with
   * {@code x}, {@code y}, {@code z}, {@code w}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>Then return {@code -27.727412285796376}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#noise(double, double, double, double,
   * double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, double) with 'x', 'y', 'z', 'w', 'frequency', 'amplitude'; then return '-27.727412285796376'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double SimplexOctaveGenerator.noise(double, double, double, double, double, double)"
  })
  void testNoiseWithXYZWFrequencyAmplitude_thenReturn27727412285796376() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);

    // Act
    double actualNoiseResult =
        new SimplexOctaveGenerator(world, 3).noise(10.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    verify(world).getSeed();
    assertEquals(-27.727412285796376d, actualNoiseResult);
  }

  /**
   * Test {@link SimplexOctaveGenerator#noise(double, double, double, double, double, double)} with
   * {@code x}, {@code y}, {@code z}, {@code w}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then return {@code 28.35696767248966}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#noise(double, double, double, double,
   * double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, double) with 'x', 'y', 'z', 'w', 'frequency', 'amplitude'; when '0.5'; then return '28.35696767248966'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double SimplexOctaveGenerator.noise(double, double, double, double, double, double)"
  })
  void testNoiseWithXYZWFrequencyAmplitude_when05_thenReturn2835696767248966() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);

    // Act
    double actualNoiseResult =
        new SimplexOctaveGenerator(world, 3).noise(0.5d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    verify(world).getSeed();
    assertEquals(28.35696767248966d, actualNoiseResult);
  }

  /**
   * Test {@link SimplexOctaveGenerator#noise(double, double, double, double, double, double)} with
   * {@code x}, {@code y}, {@code z}, {@code w}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code -12.887084661849313}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#noise(double, double, double, double,
   * double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, double) with 'x', 'y', 'z', 'w', 'frequency', 'amplitude'; when '-0.5'; then return '-12.887084661849313'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double SimplexOctaveGenerator.noise(double, double, double, double, double, double)"
  })
  void testNoiseWithXYZWFrequencyAmplitude_when05_thenReturn12887084661849313() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);

    // Act
    double actualNoiseResult =
        new SimplexOctaveGenerator(world, 3).noise(-0.5d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    verify(world).getSeed();
    assertEquals(-12.887084661849313d, actualNoiseResult);
  }

  /**
   * Test {@link SimplexOctaveGenerator#noise(double, double, double, double, double, double)} with
   * {@code x}, {@code y}, {@code z}, {@code w}, {@code frequency}, {@code amplitude}.
   *
   * <ul>
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexOctaveGenerator#noise(double, double, double, double,
   * double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double, double, double) with 'x', 'y', 'z', 'w', 'frequency', 'amplitude'; when NaN; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double SimplexOctaveGenerator.noise(double, double, double, double, double, double)"
  })
  void testNoiseWithXYZWFrequencyAmplitude_whenNaN_thenReturnNaN() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);

    // Act
    double actualNoiseResult =
        new SimplexOctaveGenerator(world, 3).noise(Double.NaN, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    verify(world).getSeed();
    assertEquals(Double.NaN, actualNoiseResult);
  }
}

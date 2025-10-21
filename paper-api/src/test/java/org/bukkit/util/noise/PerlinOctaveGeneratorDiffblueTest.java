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

class PerlinOctaveGeneratorDiffblueTest {
  /**
   * Test {@link PerlinOctaveGenerator#PerlinOctaveGenerator(long, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then first element return {@link PerlinNoiseGenerator}.
   * </ul>
   *
   * <p>Method under test: {@link PerlinOctaveGenerator#PerlinOctaveGenerator(long, int)}
   */
  @Test
  @DisplayName(
      "Test new PerlinOctaveGenerator(long, int); when one; then first element return PerlinNoiseGenerator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PerlinOctaveGenerator.<init>(long, int)"})
  void testNewPerlinOctaveGenerator_whenOne_thenFirstElementReturnPerlinNoiseGenerator() {
    // Arrange and Act
    PerlinOctaveGenerator actualPerlinOctaveGenerator = new PerlinOctaveGenerator(42L, 1);

    // Assert
    NoiseGenerator[] octaves = actualPerlinOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof PerlinNoiseGenerator);
    assertEquals(1, octaves.length);
    NoiseGenerator[] noiseGeneratorArray = actualPerlinOctaveGenerator.octaves;
    assertEquals(1, noiseGeneratorArray.length);
    assertEquals(1.0d, actualPerlinOctaveGenerator.getXScale());
    assertEquals(1.0d, actualPerlinOctaveGenerator.getYScale());
    assertEquals(1.0d, actualPerlinOctaveGenerator.getZScale());
    assertEquals(174.90520877052043d, ((PerlinNoiseGenerator) noiseGenerator).offsetY);
    assertEquals(186.25630208841423d, ((PerlinNoiseGenerator) noiseGenerator).offsetX);
    assertEquals(512, ((PerlinNoiseGenerator) noiseGenerator).perm.length);
    assertEquals(79.0321805651609d, ((PerlinNoiseGenerator) noiseGenerator).offsetZ);
    assertSame(noiseGenerator, noiseGeneratorArray[0]);
  }

  /**
   * Test {@link PerlinOctaveGenerator#PerlinOctaveGenerator(Random, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then first element return {@link PerlinNoiseGenerator}.
   * </ul>
   *
   * <p>Method under test: {@link PerlinOctaveGenerator#PerlinOctaveGenerator(Random, int)}
   */
  @Test
  @DisplayName(
      "Test new PerlinOctaveGenerator(Random, int); when one; then first element return PerlinNoiseGenerator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PerlinOctaveGenerator.<init>(Random, int)"})
  void testNewPerlinOctaveGenerator_whenOne_thenFirstElementReturnPerlinNoiseGenerator2() {
    // Arrange and Act
    PerlinOctaveGenerator actualPerlinOctaveGenerator = new PerlinOctaveGenerator(new Random(), 1);

    // Assert
    NoiseGenerator[] octaves = actualPerlinOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof PerlinNoiseGenerator);
    assertEquals(1, octaves.length);
    NoiseGenerator[] noiseGeneratorArray = actualPerlinOctaveGenerator.octaves;
    assertEquals(1, noiseGeneratorArray.length);
    assertEquals(1.0d, actualPerlinOctaveGenerator.getXScale());
    assertEquals(1.0d, actualPerlinOctaveGenerator.getYScale());
    assertEquals(1.0d, actualPerlinOctaveGenerator.getZScale());
    assertEquals(512, ((PerlinNoiseGenerator) noiseGenerator).perm.length);
    assertSame(noiseGenerator, noiseGeneratorArray[0]);
  }

  /**
   * Test {@link PerlinOctaveGenerator#PerlinOctaveGenerator(World, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then first element return {@link PerlinNoiseGenerator}.
   * </ul>
   *
   * <p>Method under test: {@link PerlinOctaveGenerator#PerlinOctaveGenerator(World, int)}
   */
  @Test
  @DisplayName(
      "Test new PerlinOctaveGenerator(World, int); when one; then first element return PerlinNoiseGenerator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PerlinOctaveGenerator.<init>(World, int)"})
  void testNewPerlinOctaveGenerator_whenOne_thenFirstElementReturnPerlinNoiseGenerator3() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);

    // Act
    PerlinOctaveGenerator actualPerlinOctaveGenerator = new PerlinOctaveGenerator(world, 1);

    // Assert
    verify(world).getSeed();
    NoiseGenerator[] octaves = actualPerlinOctaveGenerator.getOctaves();
    NoiseGenerator noiseGenerator = octaves[0];
    assertTrue(noiseGenerator instanceof PerlinNoiseGenerator);
    assertEquals(1, octaves.length);
    NoiseGenerator[] noiseGeneratorArray = actualPerlinOctaveGenerator.octaves;
    assertEquals(1, noiseGeneratorArray.length);
    assertEquals(1.0d, actualPerlinOctaveGenerator.getXScale());
    assertEquals(1.0d, actualPerlinOctaveGenerator.getYScale());
    assertEquals(1.0d, actualPerlinOctaveGenerator.getZScale());
    assertEquals(174.90520877052043d, ((PerlinNoiseGenerator) noiseGenerator).offsetY);
    assertEquals(186.25630208841423d, ((PerlinNoiseGenerator) noiseGenerator).offsetX);
    assertEquals(512, ((PerlinNoiseGenerator) noiseGenerator).perm.length);
    assertEquals(79.0321805651609d, ((PerlinNoiseGenerator) noiseGenerator).offsetZ);
    assertSame(noiseGenerator, noiseGeneratorArray[0]);
  }
}

package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.destroystokyo.paper.ParticleBuilder;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.bukkit.Particle.DustOptions;
import org.bukkit.Particle.DustTransition;
import org.bukkit.Particle.Trail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ParticleDiffblueTest {
  /**
   * Test {@link Particle#builder()}.
   *
   * <p>Method under test: {@link Particle#builder()}
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder Particle.builder()"})
  void testBuilder() {
    // Arrange and Act
    ParticleBuilder actualBuilderResult = Particle.POOF.builder();

    // Assert
    assertNull(actualBuilderResult.receivers());
    assertNull(actualBuilderResult.location());
    assertNull(actualBuilderResult.source());
    assertEquals(0.0d, actualBuilderResult.offsetX());
    assertEquals(0.0d, actualBuilderResult.offsetY());
    assertEquals(0.0d, actualBuilderResult.offsetZ());
    assertEquals(1, actualBuilderResult.count());
    assertEquals(1.0d, actualBuilderResult.extra());
    assertEquals(Particle.POOF, actualBuilderResult.particle());
    assertFalse(actualBuilderResult.hasReceivers());
    assertTrue(actualBuilderResult.force());
  }

  /**
   * Test DustOptions getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DustOptions#getColor()}
   *   <li>{@link DustOptions#getSize()}
   * </ul>
   */
  @Test
  @DisplayName("Test DustOptions getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color DustOptions.getColor()", "float DustOptions.getSize()"})
  void testDustOptionsGettersAndSetters() {
    // Arrange
    DustOptions dustOptions = new DustOptions(Color.AQUA, 10.0f);

    // Act
    Color actualColor = dustOptions.getColor();

    // Assert
    assertEquals(10.0f, dustOptions.getSize());
    assertSame(Color.AQUA, actualColor);
  }

  /**
   * Test DustOptions {@link DustOptions#DustOptions(Color, float)}.
   *
   * <ul>
   *   <li>When {@link Color#AQUA}.
   *   <li>Then return Size is ten.
   * </ul>
   *
   * <p>Method under test: {@link DustOptions#DustOptions(Color, float)}
   */
  @Test
  @DisplayName("Test DustOptions new DustOptions(Color, float); when AQUA; then return Size is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DustOptions.<init>(Color, float)"})
  void testDustOptionsNewDustOptions_whenAqua_thenReturnSizeIsTen() {
    // Arrange and Act
    DustOptions actualDustOptions = new DustOptions(Color.AQUA, 10.0f);

    // Assert
    assertEquals(10.0f, actualDustOptions.getSize());
    assertSame(Color.AQUA, actualDustOptions.getColor());
  }

  /**
   * Test DustTransition {@link DustTransition#getToColor()}.
   *
   * <p>Method under test: {@link DustTransition#getToColor()}
   */
  @Test
  @DisplayName("Test DustTransition getToColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color DustTransition.getToColor()"})
  void testDustTransitionGetToColor() {
    // Arrange
    DustTransition dustTransition = new DustTransition(Color.AQUA, Color.AQUA, 10.0f);

    // Act and Assert
    assertSame(Color.AQUA, dustTransition.getToColor());
  }

  /**
   * Test DustTransition {@link DustTransition#DustTransition(Color, Color, float)}.
   *
   * <ul>
   *   <li>When {@link Color#AQUA}.
   *   <li>Then return Size is ten.
   * </ul>
   *
   * <p>Method under test: {@link DustTransition#DustTransition(Color, Color, float)}
   */
  @Test
  @DisplayName(
      "Test DustTransition new DustTransition(Color, Color, float); when AQUA; then return Size is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DustTransition.<init>(Color, Color, float)"})
  void testDustTransitionNewDustTransition_whenAqua_thenReturnSizeIsTen() {
    // Arrange and Act
    DustTransition actualDustTransition = new DustTransition(Color.AQUA, Color.AQUA, 10.0f);

    // Assert
    assertEquals(10.0f, actualDustTransition.getSize());
    Color color = Color.AQUA;
    assertSame(color, actualDustTransition.getColor());
    assertSame(color, actualDustTransition.getToColor());
  }

  /**
   * Test Trail getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Trail#Trail(Location, Color, int)}
   *   <li>{@link Trail#getColor()}
   *   <li>{@link Trail#getDuration()}
   *   <li>{@link Trail#getTarget()}
   * </ul>
   */
  @Test
  @DisplayName("Test Trail getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Trail.<init>(Location, Color, int)",
    "Color Trail.getColor()",
    "int Trail.getDuration()",
    "Location Trail.getTarget()"
  })
  void testTrailGettersAndSetters() {
    // Arrange
    Location target = Location.deserialize(new HashMap<>());

    // Act
    Trail actualTrail = new Trail(target, Color.AQUA, 1);
    Color actualColor = actualTrail.getColor();
    int actualDuration = actualTrail.getDuration();

    // Assert
    assertEquals(1, actualDuration);
    assertSame(target, actualTrail.getTarget());
    assertSame(Color.AQUA, actualColor);
  }
}

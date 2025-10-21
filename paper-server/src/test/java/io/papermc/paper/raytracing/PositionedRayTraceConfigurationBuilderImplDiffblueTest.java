package io.papermc.paper.raytracing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.FluidCollisionMode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PositionedRayTraceConfigurationBuilderImplDiffblueTest {
  /**
   * Test {@link PositionedRayTraceConfigurationBuilderImpl#ignorePassableBlocks(boolean)}.
   *
   * <p>Method under test: {@link
   * PositionedRayTraceConfigurationBuilderImpl#ignorePassableBlocks(boolean)}
   */
  @Test
  @DisplayName("Test ignorePassableBlocks(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PositionedRayTraceConfigurationBuilder PositionedRayTraceConfigurationBuilderImpl.ignorePassableBlocks(boolean)"
  })
  void testIgnorePassableBlocks() {
    // Arrange
    PositionedRayTraceConfigurationBuilderImpl positionedRayTraceConfigurationBuilderImpl =
        new PositionedRayTraceConfigurationBuilderImpl();

    // Act
    PositionedRayTraceConfigurationBuilder actualIgnorePassableBlocksResult =
        positionedRayTraceConfigurationBuilderImpl.ignorePassableBlocks(true);

    // Assert
    assertSame(positionedRayTraceConfigurationBuilderImpl, actualIgnorePassableBlocksResult);
  }

  /**
   * Test new {@link PositionedRayTraceConfigurationBuilderImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * PositionedRayTraceConfigurationBuilderImpl}
   */
  @Test
  @DisplayName("Test new PositionedRayTraceConfigurationBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PositionedRayTraceConfigurationBuilderImpl.<init>()"})
  void testNewPositionedRayTraceConfigurationBuilderImpl() {
    // Arrange and Act
    PositionedRayTraceConfigurationBuilderImpl actualPositionedRayTraceConfigurationBuilderImpl =
        new PositionedRayTraceConfigurationBuilderImpl();

    // Assert
    assertNull(actualPositionedRayTraceConfigurationBuilderImpl.blockFilter);
    assertNull(actualPositionedRayTraceConfigurationBuilderImpl.entityFilter);
    assertNull(actualPositionedRayTraceConfigurationBuilderImpl.start);
    assertNull(actualPositionedRayTraceConfigurationBuilderImpl.direction);
    assertEquals(0.0d, actualPositionedRayTraceConfigurationBuilderImpl.raySize);
    assertEquals(
        FluidCollisionMode.NEVER,
        actualPositionedRayTraceConfigurationBuilderImpl.fluidCollisionMode);
    assertFalse(actualPositionedRayTraceConfigurationBuilderImpl.maxDistance.isPresent());
    assertFalse(actualPositionedRayTraceConfigurationBuilderImpl.ignorePassableBlocks);
    assertTrue(actualPositionedRayTraceConfigurationBuilderImpl.targets.isEmpty());
  }
}

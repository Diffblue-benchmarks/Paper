package io.papermc.paper.event.world.border;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WorldBorderEventDiffblueTest {
  /**
   * Test {@link WorldBorderEvent#getWorldBorder()}.
   *
   * <p>Method under test: {@link WorldBorderEvent#getWorldBorder()}
   */
  @Test
  @DisplayName("Test getWorldBorder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorldBorder WorldBorderEvent.getWorldBorder()"})
  void testGetWorldBorder() {
    // Arrange
    WorldBorderBoundsChangeFinishEvent worldBorderBoundsChangeFinishEvent =
        new WorldBorderBoundsChangeFinishEvent(
            mock(World.class), mock(WorldBorder.class), 10.0d, 10.0d, 10.0d);

    // Act
    WorldBorder actualWorldBorder = worldBorderBoundsChangeFinishEvent.getWorldBorder();

    // Assert
    assertSame(worldBorderBoundsChangeFinishEvent.worldBorder, actualWorldBorder);
  }
}

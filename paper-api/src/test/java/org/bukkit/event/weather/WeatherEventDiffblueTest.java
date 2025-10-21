package org.bukkit.event.weather;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.World;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WeatherEventDiffblueTest {
  /**
   * Test {@link WeatherEvent#getWorld()}.
   *
   * <p>Method under test: {@link WeatherEvent#getWorld()}
   */
  @Test
  @DisplayName("Test getWorld()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"World WeatherEvent.getWorld()"})
  void testGetWorld() {
    // Arrange
    ThunderChangeEvent thunderChangeEvent = new ThunderChangeEvent(mock(World.class), true);

    // Act
    World actualWorld = thunderChangeEvent.getWorld();

    // Assert
    assertSame(thunderChangeEvent.world, actualWorld);
  }
}

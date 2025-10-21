package org.bukkit.event.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.World;
import org.bukkit.entity.LightningStrike;
import org.bukkit.event.HandlerList;
import org.bukkit.event.weather.LightningStrikeEvent.Cause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LightningStrikeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LightningStrikeEvent#LightningStrikeEvent(World, LightningStrike, Cause)}
   *   <li>{@link LightningStrikeEvent#setCancelled(boolean)}
   *   <li>{@link LightningStrikeEvent#getHandlerList()}
   *   <li>{@link LightningStrikeEvent#getCause()}
   *   <li>{@link LightningStrikeEvent#getHandlers()}
   *   <li>{@link LightningStrikeEvent#getLightning()}
   *   <li>{@link LightningStrikeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LightningStrikeEvent.<init>(World, LightningStrike, Cause)",
    "Cause LightningStrikeEvent.getCause()",
    "HandlerList LightningStrikeEvent.getHandlerList()",
    "HandlerList LightningStrikeEvent.getHandlers()",
    "LightningStrike LightningStrikeEvent.getLightning()",
    "boolean LightningStrikeEvent.isCancelled()",
    "void LightningStrikeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    World world = mock(World.class);
    LightningStrike bolt = mock(LightningStrike.class);

    // Act
    LightningStrikeEvent actualLightningStrikeEvent =
        new LightningStrikeEvent(world, bolt, Cause.COMMAND);
    actualLightningStrikeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualLightningStrikeEvent.getHandlerList();
    Cause actualCause = actualLightningStrikeEvent.getCause();
    HandlerList actualHandlers = actualLightningStrikeEvent.getHandlers();
    LightningStrike actualLightning = actualLightningStrikeEvent.getLightning();
    boolean actualIsCancelledResult = actualLightningStrikeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Cause.COMMAND, actualCause);
    assertFalse(actualLightningStrikeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(world, actualLightningStrikeEvent.getWorld());
    assertSame(bolt, actualLightning);
  }

  /**
   * Test {@link LightningStrikeEvent#LightningStrikeEvent(World, LightningStrike)}.
   *
   * <p>Method under test: {@link LightningStrikeEvent#LightningStrikeEvent(World, LightningStrike)}
   */
  @Test
  @DisplayName("Test new LightningStrikeEvent(World, LightningStrike)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LightningStrikeEvent.<init>(World, LightningStrike)"})
  void testNewLightningStrikeEvent() {
    // Arrange
    World world = mock(World.class);
    LightningStrike bolt = mock(LightningStrike.class);

    // Act
    LightningStrikeEvent actualLightningStrikeEvent = new LightningStrikeEvent(world, bolt);

    // Assert
    assertEquals("LightningStrikeEvent", actualLightningStrikeEvent.getEventName());
    assertEquals(0, actualLightningStrikeEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Cause.UNKNOWN, actualLightningStrikeEvent.getCause());
    assertFalse(actualLightningStrikeEvent.isAsynchronous());
    assertFalse(actualLightningStrikeEvent.isCancelled());
    assertSame(world, actualLightningStrikeEvent.getWorld());
    assertSame(bolt, actualLightningStrikeEvent.getLightning());
  }
}

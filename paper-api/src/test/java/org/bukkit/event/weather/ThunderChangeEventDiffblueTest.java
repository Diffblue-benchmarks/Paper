package org.bukkit.event.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.World;
import org.bukkit.event.HandlerList;
import org.bukkit.event.weather.ThunderChangeEvent.Cause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ThunderChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ThunderChangeEvent#ThunderChangeEvent(World, boolean, Cause)}
   *   <li>{@link ThunderChangeEvent#setCancelled(boolean)}
   *   <li>{@link ThunderChangeEvent#getHandlerList()}
   *   <li>{@link ThunderChangeEvent#getCause()}
   *   <li>{@link ThunderChangeEvent#getHandlers()}
   *   <li>{@link ThunderChangeEvent#isCancelled()}
   *   <li>{@link ThunderChangeEvent#toThunderState()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThunderChangeEvent.<init>(World, boolean, Cause)",
    "Cause ThunderChangeEvent.getCause()",
    "HandlerList ThunderChangeEvent.getHandlerList()",
    "HandlerList ThunderChangeEvent.getHandlers()",
    "boolean ThunderChangeEvent.isCancelled()",
    "void ThunderChangeEvent.setCancelled(boolean)",
    "boolean ThunderChangeEvent.toThunderState()"
  })
  void testGettersAndSetters() {
    // Arrange
    World world = mock(World.class);

    // Act
    ThunderChangeEvent actualThunderChangeEvent =
        new ThunderChangeEvent(world, true, Cause.COMMAND);
    actualThunderChangeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualThunderChangeEvent.getHandlerList();
    Cause actualCause = actualThunderChangeEvent.getCause();
    HandlerList actualHandlers = actualThunderChangeEvent.getHandlers();
    boolean actualIsCancelledResult = actualThunderChangeEvent.isCancelled();
    boolean actualToThunderStateResult = actualThunderChangeEvent.toThunderState();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Cause.COMMAND, actualCause);
    assertFalse(actualThunderChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualToThunderStateResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(world, actualThunderChangeEvent.getWorld());
  }

  /**
   * Test {@link ThunderChangeEvent#ThunderChangeEvent(World, boolean)}.
   *
   * <p>Method under test: {@link ThunderChangeEvent#ThunderChangeEvent(World, boolean)}
   */
  @Test
  @DisplayName("Test new ThunderChangeEvent(World, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThunderChangeEvent.<init>(World, boolean)"})
  void testNewThunderChangeEvent() {
    // Arrange
    World world = mock(World.class);

    // Act
    ThunderChangeEvent actualThunderChangeEvent = new ThunderChangeEvent(world, true);

    // Assert
    assertEquals("ThunderChangeEvent", actualThunderChangeEvent.getEventName());
    assertEquals(0, actualThunderChangeEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Cause.UNKNOWN, actualThunderChangeEvent.getCause());
    assertFalse(actualThunderChangeEvent.isAsynchronous());
    assertFalse(actualThunderChangeEvent.isCancelled());
    assertTrue(actualThunderChangeEvent.toThunderState());
    assertSame(world, actualThunderChangeEvent.getWorld());
  }
}

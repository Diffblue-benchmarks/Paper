package com.destroystokyo.paper.event.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerTickEndEventDiffblueTest {
  /**
   * Test {@link ServerTickEndEvent#ServerTickEndEvent(int, double, long)}.
   *
   * <p>Method under test: {@link ServerTickEndEvent#ServerTickEndEvent(int, double, long)}
   */
  @Test
  @DisplayName("Test new ServerTickEndEvent(int, double, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServerTickEndEvent.<init>(int, double, long)"})
  void testNewServerTickEndEvent() {
    // Arrange and Act
    ServerTickEndEvent actualServerTickEndEvent = new ServerTickEndEvent(10, 10.0d, 10L);

    // Assert
    assertEquals("ServerTickEndEvent", actualServerTickEndEvent.getEventName());
    assertEquals(0, actualServerTickEndEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(10, actualServerTickEndEvent.getTickNumber());
    assertEquals(10.0d, actualServerTickEndEvent.getTickDuration());
    assertFalse(actualServerTickEndEvent.isAsynchronous());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ServerTickEndEvent#getHandlerList()}
   *   <li>{@link ServerTickEndEvent#getHandlers()}
   *   <li>{@link ServerTickEndEvent#getTickDuration()}
   *   <li>{@link ServerTickEndEvent#getTickNumber()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HandlerList ServerTickEndEvent.getHandlerList()",
    "HandlerList ServerTickEndEvent.getHandlers()",
    "double ServerTickEndEvent.getTickDuration()",
    "int ServerTickEndEvent.getTickNumber()"
  })
  void testGettersAndSetters() {
    // Arrange
    ServerTickEndEvent serverTickEndEvent = new ServerTickEndEvent(10, 10.0d, 10L);

    // Act
    HandlerList actualHandlerList = serverTickEndEvent.getHandlerList();
    HandlerList actualHandlers = serverTickEndEvent.getHandlers();
    double actualTickDuration = serverTickEndEvent.getTickDuration();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10, serverTickEndEvent.getTickNumber());
    assertEquals(10.0d, actualTickDuration);
    assertSame(actualHandlerList, actualHandlers);
  }
}

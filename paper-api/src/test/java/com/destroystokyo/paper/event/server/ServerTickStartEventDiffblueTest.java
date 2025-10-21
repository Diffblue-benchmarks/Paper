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

class ServerTickStartEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ServerTickStartEvent#ServerTickStartEvent(int)}
   *   <li>{@link ServerTickStartEvent#getHandlerList()}
   *   <li>{@link ServerTickStartEvent#getHandlers()}
   *   <li>{@link ServerTickStartEvent#getTickNumber()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerTickStartEvent.<init>(int)",
    "HandlerList ServerTickStartEvent.getHandlerList()",
    "HandlerList ServerTickStartEvent.getHandlers()",
    "int ServerTickStartEvent.getTickNumber()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ServerTickStartEvent actualServerTickStartEvent = new ServerTickStartEvent(10);
    HandlerList actualHandlerList = actualServerTickStartEvent.getHandlerList();
    HandlerList actualHandlers = actualServerTickStartEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10, actualServerTickStartEvent.getTickNumber());
    assertFalse(actualServerTickStartEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
  }
}

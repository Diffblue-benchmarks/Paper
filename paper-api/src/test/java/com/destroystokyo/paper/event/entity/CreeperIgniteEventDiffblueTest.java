package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Creeper;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CreeperIgniteEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreeperIgniteEvent#CreeperIgniteEvent(Creeper, boolean)}
   *   <li>{@link CreeperIgniteEvent#setCancelled(boolean)}
   *   <li>{@link CreeperIgniteEvent#setIgnited(boolean)}
   *   <li>{@link CreeperIgniteEvent#getHandlerList()}
   *   <li>{@link CreeperIgniteEvent#getHandlers()}
   *   <li>{@link CreeperIgniteEvent#isCancelled()}
   *   <li>{@link CreeperIgniteEvent#isIgnited()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CreeperIgniteEvent.<init>(Creeper, boolean)",
    "HandlerList CreeperIgniteEvent.getHandlerList()",
    "HandlerList CreeperIgniteEvent.getHandlers()",
    "boolean CreeperIgniteEvent.isCancelled()",
    "boolean CreeperIgniteEvent.isIgnited()",
    "void CreeperIgniteEvent.setCancelled(boolean)",
    "void CreeperIgniteEvent.setIgnited(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Creeper creeper = mock(Creeper.class);

    // Act
    CreeperIgniteEvent actualCreeperIgniteEvent = new CreeperIgniteEvent(creeper, true);
    actualCreeperIgniteEvent.setCancelled(true);
    actualCreeperIgniteEvent.setIgnited(true);
    HandlerList actualHandlerList = actualCreeperIgniteEvent.getHandlerList();
    HandlerList actualHandlers = actualCreeperIgniteEvent.getHandlers();
    boolean actualIsCancelledResult = actualCreeperIgniteEvent.isCancelled();
    boolean actualIsIgnitedResult = actualCreeperIgniteEvent.isIgnited();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualCreeperIgniteEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsIgnitedResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(creeper, actualCreeperIgniteEvent.getEntity());
  }
}

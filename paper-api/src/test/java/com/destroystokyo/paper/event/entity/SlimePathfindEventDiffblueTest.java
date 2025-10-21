package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Slime;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SlimePathfindEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlimePathfindEvent#SlimePathfindEvent(Slime)}
   *   <li>{@link SlimePathfindEvent#setCancelled(boolean)}
   *   <li>{@link SlimePathfindEvent#getHandlerList()}
   *   <li>{@link SlimePathfindEvent#getHandlers()}
   *   <li>{@link SlimePathfindEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SlimePathfindEvent.<init>(Slime)",
    "HandlerList SlimePathfindEvent.getHandlerList()",
    "HandlerList SlimePathfindEvent.getHandlers()",
    "boolean SlimePathfindEvent.isCancelled()",
    "void SlimePathfindEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Slime slime = mock(Slime.class);

    // Act
    SlimePathfindEvent actualSlimePathfindEvent = new SlimePathfindEvent(slime);
    actualSlimePathfindEvent.setCancelled(true);
    HandlerList actualHandlerList = actualSlimePathfindEvent.getHandlerList();
    HandlerList actualHandlers = actualSlimePathfindEvent.getHandlers();
    boolean actualIsCancelledResult = actualSlimePathfindEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualSlimePathfindEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(slime, actualSlimePathfindEvent.getEntity());
  }
}

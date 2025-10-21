package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Warden;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WardenAngerChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WardenAngerChangeEvent#WardenAngerChangeEvent(Warden, Entity, int, int)}
   *   <li>{@link WardenAngerChangeEvent#setCancelled(boolean)}
   *   <li>{@link WardenAngerChangeEvent#getHandlerList()}
   *   <li>{@link WardenAngerChangeEvent#getHandlers()}
   *   <li>{@link WardenAngerChangeEvent#getNewAnger()}
   *   <li>{@link WardenAngerChangeEvent#getOldAnger()}
   *   <li>{@link WardenAngerChangeEvent#getTarget()}
   *   <li>{@link WardenAngerChangeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WardenAngerChangeEvent.<init>(Warden, Entity, int, int)",
    "HandlerList WardenAngerChangeEvent.getHandlerList()",
    "HandlerList WardenAngerChangeEvent.getHandlers()",
    "int WardenAngerChangeEvent.getNewAnger()",
    "int WardenAngerChangeEvent.getOldAnger()",
    "Entity WardenAngerChangeEvent.getTarget()",
    "boolean WardenAngerChangeEvent.isCancelled()",
    "void WardenAngerChangeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Warden warden = mock(Warden.class);
    Entity target = mock(Entity.class);

    // Act
    WardenAngerChangeEvent actualWardenAngerChangeEvent =
        new WardenAngerChangeEvent(warden, target, 1, 1);
    actualWardenAngerChangeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualWardenAngerChangeEvent.getHandlerList();
    HandlerList actualHandlers = actualWardenAngerChangeEvent.getHandlers();
    int actualNewAnger = actualWardenAngerChangeEvent.getNewAnger();
    int actualOldAnger = actualWardenAngerChangeEvent.getOldAnger();
    Entity actualTarget = actualWardenAngerChangeEvent.getTarget();
    boolean actualIsCancelledResult = actualWardenAngerChangeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualNewAnger);
    assertEquals(1, actualOldAnger);
    assertFalse(actualWardenAngerChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(target, actualTarget);
    assertSame(warden, actualWardenAngerChangeEvent.getEntity());
  }
}

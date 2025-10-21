package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityTargetEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityTargetEvent#EntityTargetEvent(Entity, Entity, TargetReason)}
   *   <li>{@link EntityTargetEvent#setCancelled(boolean)}
   *   <li>{@link EntityTargetEvent#setTarget(Entity)}
   *   <li>{@link EntityTargetEvent#getHandlerList()}
   *   <li>{@link EntityTargetEvent#getHandlers()}
   *   <li>{@link EntityTargetEvent#getReason()}
   *   <li>{@link EntityTargetEvent#getTarget()}
   *   <li>{@link EntityTargetEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityTargetEvent.<init>(Entity, Entity, TargetReason)",
    "HandlerList EntityTargetEvent.getHandlerList()",
    "HandlerList EntityTargetEvent.getHandlers()",
    "TargetReason EntityTargetEvent.getReason()",
    "Entity EntityTargetEvent.getTarget()",
    "boolean EntityTargetEvent.isCancelled()",
    "void EntityTargetEvent.setCancelled(boolean)",
    "void EntityTargetEvent.setTarget(Entity)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);

    // Act
    EntityTargetEvent actualEntityTargetEvent =
        new EntityTargetEvent(entity, mock(Entity.class), TargetReason.TARGET_DIED);
    actualEntityTargetEvent.setCancelled(true);
    Entity target = mock(Entity.class);
    actualEntityTargetEvent.setTarget(target);
    HandlerList actualHandlerList = actualEntityTargetEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityTargetEvent.getHandlers();
    TargetReason actualReason = actualEntityTargetEvent.getReason();
    Entity actualTarget = actualEntityTargetEvent.getTarget();
    boolean actualIsCancelledResult = actualEntityTargetEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(TargetReason.TARGET_DIED, actualReason);
    assertFalse(actualEntityTargetEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityTargetEvent.getEntity());
    assertSame(target, actualTarget);
  }
}

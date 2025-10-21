package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityJumpEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityJumpEvent#EntityJumpEvent(LivingEntity)}
   *   <li>{@link EntityJumpEvent#setCancelled(boolean)}
   *   <li>{@link EntityJumpEvent#getHandlerList()}
   *   <li>{@link EntityJumpEvent#getHandlers()}
   *   <li>{@link EntityJumpEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityJumpEvent.<init>(LivingEntity)",
    "HandlerList EntityJumpEvent.getHandlerList()",
    "HandlerList EntityJumpEvent.getHandlers()",
    "boolean EntityJumpEvent.isCancelled()",
    "void EntityJumpEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);

    // Act
    EntityJumpEvent actualEntityJumpEvent = new EntityJumpEvent(entity);
    actualEntityJumpEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityJumpEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityJumpEvent.getHandlers();
    boolean actualIsCancelledResult = actualEntityJumpEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityJumpEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityJumpEvent.getEntity());
  }
}

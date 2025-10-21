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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityAirChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAirChangeEvent#EntityAirChangeEvent(Entity, int)}
   *   <li>{@link EntityAirChangeEvent#setAmount(int)}
   *   <li>{@link EntityAirChangeEvent#setCancelled(boolean)}
   *   <li>{@link EntityAirChangeEvent#getHandlerList()}
   *   <li>{@link EntityAirChangeEvent#getAmount()}
   *   <li>{@link EntityAirChangeEvent#getHandlers()}
   *   <li>{@link EntityAirChangeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityAirChangeEvent.<init>(Entity, int)",
    "int EntityAirChangeEvent.getAmount()",
    "HandlerList EntityAirChangeEvent.getHandlerList()",
    "HandlerList EntityAirChangeEvent.getHandlers()",
    "boolean EntityAirChangeEvent.isCancelled()",
    "void EntityAirChangeEvent.setAmount(int)",
    "void EntityAirChangeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);

    // Act
    EntityAirChangeEvent actualEntityAirChangeEvent = new EntityAirChangeEvent(entity, 10);
    actualEntityAirChangeEvent.setAmount(10);
    actualEntityAirChangeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityAirChangeEvent.getHandlerList();
    int actualAmount = actualEntityAirChangeEvent.getAmount();
    HandlerList actualHandlers = actualEntityAirChangeEvent.getHandlers();
    boolean actualIsCancelledResult = actualEntityAirChangeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10, actualAmount);
    assertFalse(actualEntityAirChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityAirChangeEvent.getEntity());
  }
}

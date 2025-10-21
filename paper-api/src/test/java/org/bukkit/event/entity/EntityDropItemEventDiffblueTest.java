package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityDropItemEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDropItemEvent#EntityDropItemEvent(Entity, Item)}
   *   <li>{@link EntityDropItemEvent#setCancelled(boolean)}
   *   <li>{@link EntityDropItemEvent#getHandlerList()}
   *   <li>{@link EntityDropItemEvent#getHandlers()}
   *   <li>{@link EntityDropItemEvent#getItemDrop()}
   *   <li>{@link EntityDropItemEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDropItemEvent.<init>(Entity, Item)",
    "HandlerList EntityDropItemEvent.getHandlerList()",
    "HandlerList EntityDropItemEvent.getHandlers()",
    "Item EntityDropItemEvent.getItemDrop()",
    "boolean EntityDropItemEvent.isCancelled()",
    "void EntityDropItemEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Item drop = mock(Item.class);

    // Act
    EntityDropItemEvent actualEntityDropItemEvent = new EntityDropItemEvent(entity, drop);
    actualEntityDropItemEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityDropItemEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityDropItemEvent.getHandlers();
    Item actualItemDrop = actualEntityDropItemEvent.getItemDrop();
    boolean actualIsCancelledResult = actualEntityDropItemEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityDropItemEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityDropItemEvent.getEntity());
    assertSame(drop, actualItemDrop);
  }
}

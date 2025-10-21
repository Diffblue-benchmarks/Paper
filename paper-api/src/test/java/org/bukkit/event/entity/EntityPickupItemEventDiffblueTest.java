package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityPickupItemEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityPickupItemEvent#EntityPickupItemEvent(LivingEntity, Item, int)}
   *   <li>{@link EntityPickupItemEvent#setCancelled(boolean)}
   *   <li>{@link EntityPickupItemEvent#getHandlerList()}
   *   <li>{@link EntityPickupItemEvent#getHandlers()}
   *   <li>{@link EntityPickupItemEvent#getItem()}
   *   <li>{@link EntityPickupItemEvent#getRemaining()}
   *   <li>{@link EntityPickupItemEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityPickupItemEvent.<init>(LivingEntity, Item, int)",
    "HandlerList EntityPickupItemEvent.getHandlerList()",
    "HandlerList EntityPickupItemEvent.getHandlers()",
    "Item EntityPickupItemEvent.getItem()",
    "int EntityPickupItemEvent.getRemaining()",
    "boolean EntityPickupItemEvent.isCancelled()",
    "void EntityPickupItemEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Item item = mock(Item.class);

    // Act
    EntityPickupItemEvent actualEntityPickupItemEvent = new EntityPickupItemEvent(entity, item, 1);
    actualEntityPickupItemEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityPickupItemEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityPickupItemEvent.getHandlers();
    Item actualItem = actualEntityPickupItemEvent.getItem();
    int actualRemaining = actualEntityPickupItemEvent.getRemaining();
    boolean actualIsCancelledResult = actualEntityPickupItemEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualRemaining);
    assertFalse(actualEntityPickupItemEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(item, actualItem);
    assertSame(entity, actualEntityPickupItemEvent.getEntity());
  }

  /**
   * Test {@link EntityPickupItemEvent#getEntity()}.
   *
   * <p>Method under test: {@link EntityPickupItemEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LivingEntity EntityPickupItemEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    EntityPickupItemEvent entityPickupItemEvent =
        new EntityPickupItemEvent(mock(LivingEntity.class), mock(Item.class), 1);

    // Act
    LivingEntity actualEntity = entityPickupItemEvent.getEntity();

    // Assert
    assertSame(entityPickupItemEvent.entity, actualEntity);
  }
}

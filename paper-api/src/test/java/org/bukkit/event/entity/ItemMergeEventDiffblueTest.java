package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Item;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ItemMergeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ItemMergeEvent#ItemMergeEvent(Item, Item)}
   *   <li>{@link ItemMergeEvent#setCancelled(boolean)}
   *   <li>{@link ItemMergeEvent#getHandlerList()}
   *   <li>{@link ItemMergeEvent#getHandlers()}
   *   <li>{@link ItemMergeEvent#getTarget()}
   *   <li>{@link ItemMergeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ItemMergeEvent.<init>(Item, Item)",
    "HandlerList ItemMergeEvent.getHandlerList()",
    "HandlerList ItemMergeEvent.getHandlers()",
    "Item ItemMergeEvent.getTarget()",
    "boolean ItemMergeEvent.isCancelled()",
    "void ItemMergeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Item item = mock(Item.class);
    Item target = mock(Item.class);

    // Act
    ItemMergeEvent actualItemMergeEvent = new ItemMergeEvent(item, target);
    actualItemMergeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualItemMergeEvent.getHandlerList();
    HandlerList actualHandlers = actualItemMergeEvent.getHandlers();
    Item actualTarget = actualItemMergeEvent.getTarget();
    boolean actualIsCancelledResult = actualItemMergeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualItemMergeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(item, actualItemMergeEvent.getEntity());
    assertSame(target, actualTarget);
  }

  /**
   * Test {@link ItemMergeEvent#getEntity()}.
   *
   * <p>Method under test: {@link ItemMergeEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Item ItemMergeEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    ItemMergeEvent itemMergeEvent = new ItemMergeEvent(mock(Item.class), mock(Item.class));

    // Act
    Item actualEntity = itemMergeEvent.getEntity();

    // Assert
    assertSame(itemMergeEvent.entity, actualEntity);
  }
}

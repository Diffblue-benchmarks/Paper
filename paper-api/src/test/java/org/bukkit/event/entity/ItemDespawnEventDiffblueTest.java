package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ItemDespawnEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ItemDespawnEvent#ItemDespawnEvent(Item, Location)}
   *   <li>{@link ItemDespawnEvent#setCancelled(boolean)}
   *   <li>{@link ItemDespawnEvent#getHandlerList()}
   *   <li>{@link ItemDespawnEvent#getHandlers()}
   *   <li>{@link ItemDespawnEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ItemDespawnEvent.<init>(Item, Location)",
    "HandlerList ItemDespawnEvent.getHandlerList()",
    "HandlerList ItemDespawnEvent.getHandlers()",
    "boolean ItemDespawnEvent.isCancelled()",
    "void ItemDespawnEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Item despawnee = mock(Item.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    ItemDespawnEvent actualItemDespawnEvent = new ItemDespawnEvent(despawnee, location);
    actualItemDespawnEvent.setCancelled(true);
    HandlerList actualHandlerList = actualItemDespawnEvent.getHandlerList();
    HandlerList actualHandlers = actualItemDespawnEvent.getHandlers();
    boolean actualIsCancelledResult = actualItemDespawnEvent.isCancelled();

    // Assert
    assertFalse(actualItemDespawnEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(despawnee, actualItemDespawnEvent.getEntity());
  }

  /**
   * Test {@link ItemDespawnEvent#getEntity()}.
   *
   * <p>Method under test: {@link ItemDespawnEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Item ItemDespawnEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    Item despawnee = mock(Item.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    ItemDespawnEvent itemDespawnEvent = new ItemDespawnEvent(despawnee, location);

    // Act
    Item actualEntity = itemDespawnEvent.getEntity();

    // Assert
    assertSame(itemDespawnEvent.entity, actualEntity);
  }

  /**
   * Test {@link ItemDespawnEvent#getLocation()}.
   *
   * <p>Method under test: {@link ItemDespawnEvent#getLocation()}
   */
  @Test
  @DisplayName("Test getLocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location ItemDespawnEvent.getLocation()"})
  void testGetLocation() {
    // Arrange
    Item despawnee = mock(Item.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    ItemDespawnEvent itemDespawnEvent = new ItemDespawnEvent(despawnee, location);

    // Act and Assert
    assertEquals(location, itemDespawnEvent.getLocation());
  }
}

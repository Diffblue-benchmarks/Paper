package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ItemSpawnEventDiffblueTest {
  /**
   * Test {@link ItemSpawnEvent#ItemSpawnEvent(Item)}.
   *
   * <ul>
   *   <li>When {@link Item}.
   * </ul>
   *
   * <p>Method under test: {@link ItemSpawnEvent#ItemSpawnEvent(Item)}
   */
  @Test
  @DisplayName("Test new ItemSpawnEvent(Item); when Item")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ItemSpawnEvent.<init>(Item)",
    "void ItemSpawnEvent.<init>(Item, Location)"
  })
  void testNewItemSpawnEvent_whenItem() {
    // Arrange
    Item spawnee = mock(Item.class);

    // Act
    ItemSpawnEvent actualItemSpawnEvent = new ItemSpawnEvent(spawnee);

    // Assert
    assertFalse(actualItemSpawnEvent.isAsynchronous());
    assertFalse(actualItemSpawnEvent.isCancelled());
    assertSame(spawnee, actualItemSpawnEvent.getEntity());
  }

  /**
   * Test {@link ItemSpawnEvent#ItemSpawnEvent(Item, Location)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link ItemSpawnEvent#ItemSpawnEvent(Item, Location)}
   */
  @Test
  @DisplayName(
      "Test new ItemSpawnEvent(Item, Location); when Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ItemSpawnEvent.<init>(Item)",
    "void ItemSpawnEvent.<init>(Item, Location)"
  })
  void testNewItemSpawnEvent_whenLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    Item spawnee = mock(Item.class);
    Location loc = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    ItemSpawnEvent actualItemSpawnEvent = new ItemSpawnEvent(spawnee, loc);

    // Assert
    assertFalse(actualItemSpawnEvent.isAsynchronous());
    assertFalse(actualItemSpawnEvent.isCancelled());
    assertSame(spawnee, actualItemSpawnEvent.getEntity());
  }

  /**
   * Test {@link ItemSpawnEvent#getEntity()}.
   *
   * <p>Method under test: {@link ItemSpawnEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Item ItemSpawnEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    ItemSpawnEvent itemSpawnEvent = new ItemSpawnEvent(mock(Item.class));

    // Act
    Item actualEntity = itemSpawnEvent.getEntity();

    // Assert
    assertSame(itemSpawnEvent.entity, actualEntity);
  }
}

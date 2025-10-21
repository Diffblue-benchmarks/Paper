package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PreSpawnerSpawnEventDiffblueTest {
  /**
   * Test {@link PreSpawnerSpawnEvent#PreSpawnerSpawnEvent(Location, EntityType, Location)}.
   *
   * <p>Method under test: {@link PreSpawnerSpawnEvent#PreSpawnerSpawnEvent(Location, EntityType,
   * Location)}
   */
  @Test
  @DisplayName("Test new PreSpawnerSpawnEvent(Location, EntityType, Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PreSpawnerSpawnEvent.<init>(Location, EntityType, Location)"})
  void testNewPreSpawnerSpawnEvent() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location spawnerLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PreSpawnerSpawnEvent actualPreSpawnerSpawnEvent =
        new PreSpawnerSpawnEvent(location, EntityType.ACACIA_BOAT, spawnerLocation);

    // Assert
    assertEquals("PreSpawnerSpawnEvent", actualPreSpawnerSpawnEvent.getEventName());
    assertEquals(EntityType.ACACIA_BOAT, actualPreSpawnerSpawnEvent.getType());
    assertEquals(SpawnReason.SPAWNER, actualPreSpawnerSpawnEvent.getReason());
    assertFalse(actualPreSpawnerSpawnEvent.isCancelled());
    assertFalse(actualPreSpawnerSpawnEvent.shouldAbortSpawn());
    assertFalse(actualPreSpawnerSpawnEvent.isAsynchronous());
    assertEquals(location, actualPreSpawnerSpawnEvent.getSpawnLocation());
    assertEquals(spawnerLocation, actualPreSpawnerSpawnEvent.getSpawnerLocation());
  }

  /**
   * Test {@link PreSpawnerSpawnEvent#getSpawnerLocation()}.
   *
   * <ul>
   *   <li>Then return {@link Location#Location(World, double, double, double)} with {@link World}
   *       and x is two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link PreSpawnerSpawnEvent#getSpawnerLocation()}
   */
  @Test
  @DisplayName(
      "Test getSpawnerLocation(); then return Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location PreSpawnerSpawnEvent.getSpawnerLocation()"})
  void testGetSpawnerLocation_thenReturnLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location spawnerLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PreSpawnerSpawnEvent preSpawnerSpawnEvent =
        new PreSpawnerSpawnEvent(location, EntityType.ACACIA_BOAT, spawnerLocation);

    // Act and Assert
    assertEquals(spawnerLocation, preSpawnerSpawnEvent.getSpawnerLocation());
  }
}

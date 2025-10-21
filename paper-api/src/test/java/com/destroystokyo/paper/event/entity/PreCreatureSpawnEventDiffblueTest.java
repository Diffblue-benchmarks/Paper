package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PreCreatureSpawnEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PreCreatureSpawnEvent#PreCreatureSpawnEvent(Location, EntityType, SpawnReason)}
   *   <li>{@link PreCreatureSpawnEvent#setCancelled(boolean)}
   *   <li>{@link PreCreatureSpawnEvent#setShouldAbortSpawn(boolean)}
   *   <li>{@link PreCreatureSpawnEvent#getHandlerList()}
   *   <li>{@link PreCreatureSpawnEvent#getHandlers()}
   *   <li>{@link PreCreatureSpawnEvent#getReason()}
   *   <li>{@link PreCreatureSpawnEvent#getType()}
   *   <li>{@link PreCreatureSpawnEvent#isCancelled()}
   *   <li>{@link PreCreatureSpawnEvent#shouldAbortSpawn()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PreCreatureSpawnEvent.<init>(Location, EntityType, SpawnReason)",
    "HandlerList PreCreatureSpawnEvent.getHandlerList()",
    "HandlerList PreCreatureSpawnEvent.getHandlers()",
    "SpawnReason PreCreatureSpawnEvent.getReason()",
    "EntityType PreCreatureSpawnEvent.getType()",
    "boolean PreCreatureSpawnEvent.isCancelled()",
    "void PreCreatureSpawnEvent.setCancelled(boolean)",
    "void PreCreatureSpawnEvent.setShouldAbortSpawn(boolean)",
    "boolean PreCreatureSpawnEvent.shouldAbortSpawn()"
  })
  void testGettersAndSetters() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PreCreatureSpawnEvent actualPreCreatureSpawnEvent =
        new PreCreatureSpawnEvent(location, EntityType.ACACIA_BOAT, SpawnReason.NATURAL);
    actualPreCreatureSpawnEvent.setCancelled(true);
    actualPreCreatureSpawnEvent.setShouldAbortSpawn(true);
    HandlerList actualHandlerList = actualPreCreatureSpawnEvent.getHandlerList();
    HandlerList actualHandlers = actualPreCreatureSpawnEvent.getHandlers();
    SpawnReason actualReason = actualPreCreatureSpawnEvent.getReason();
    EntityType actualType = actualPreCreatureSpawnEvent.getType();
    boolean actualIsCancelledResult = actualPreCreatureSpawnEvent.isCancelled();
    boolean actualShouldAbortSpawnResult = actualPreCreatureSpawnEvent.shouldAbortSpawn();

    // Assert
    assertEquals(EntityType.ACACIA_BOAT, actualType);
    assertEquals(SpawnReason.NATURAL, actualReason);
    assertFalse(actualPreCreatureSpawnEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualShouldAbortSpawnResult);
    assertSame(actualHandlerList, actualHandlers);
  }

  /**
   * Test {@link PreCreatureSpawnEvent#getSpawnLocation()}.
   *
   * <ul>
   *   <li>Then return {@link Location#Location(World, double, double, double)} with {@link World}
   *       and x is two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link PreCreatureSpawnEvent#getSpawnLocation()}
   */
  @Test
  @DisplayName(
      "Test getSpawnLocation(); then return Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location PreCreatureSpawnEvent.getSpawnLocation()"})
  void testGetSpawnLocation_thenReturnLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertEquals(
        location,
        new PreCreatureSpawnEvent(location, EntityType.ACACIA_BOAT, SpawnReason.NATURAL)
            .getSpawnLocation());
  }
}

package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PhantomPreSpawnEventDiffblueTest {
  /**
   * Test {@link PhantomPreSpawnEvent#PhantomPreSpawnEvent(Location, Entity, SpawnReason)}.
   *
   * <p>Method under test: {@link PhantomPreSpawnEvent#PhantomPreSpawnEvent(Location, Entity,
   * SpawnReason)}
   */
  @Test
  @DisplayName("Test new PhantomPreSpawnEvent(Location, Entity, SpawnReason)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhantomPreSpawnEvent.<init>(Location, Entity, SpawnReason)"})
  void testNewPhantomPreSpawnEvent() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Entity entity = mock(Entity.class);

    // Act
    PhantomPreSpawnEvent actualPhantomPreSpawnEvent =
        new PhantomPreSpawnEvent(location, entity, SpawnReason.NATURAL);

    // Assert
    assertEquals("PhantomPreSpawnEvent", actualPhantomPreSpawnEvent.getEventName());
    assertEquals(EntityType.PHANTOM, actualPhantomPreSpawnEvent.getType());
    assertEquals(SpawnReason.NATURAL, actualPhantomPreSpawnEvent.getReason());
    assertFalse(actualPhantomPreSpawnEvent.isCancelled());
    assertFalse(actualPhantomPreSpawnEvent.shouldAbortSpawn());
    assertFalse(actualPhantomPreSpawnEvent.isAsynchronous());
    assertEquals(location, actualPhantomPreSpawnEvent.getSpawnLocation());
    assertSame(entity, actualPhantomPreSpawnEvent.getSpawningEntity());
  }
}

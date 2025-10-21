package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SpawnerSpawnEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SpawnerSpawnEvent#SpawnerSpawnEvent(Entity, CreatureSpawner)}
   *   <li>{@link SpawnerSpawnEvent#getSpawner()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SpawnerSpawnEvent.<init>(Entity, CreatureSpawner)",
    "CreatureSpawner SpawnerSpawnEvent.getSpawner()"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity spawnee = mock(Entity.class);
    CreatureSpawner spawner = mock(CreatureSpawner.class);

    // Act
    SpawnerSpawnEvent actualSpawnerSpawnEvent = new SpawnerSpawnEvent(spawnee, spawner);
    CreatureSpawner actualSpawner = actualSpawnerSpawnEvent.getSpawner();

    // Assert
    assertFalse(actualSpawnerSpawnEvent.isAsynchronous());
    assertFalse(actualSpawnerSpawnEvent.isCancelled());
    assertSame(spawner, actualSpawner);
    assertSame(spawnee, actualSpawnerSpawnEvent.getEntity());
  }
}

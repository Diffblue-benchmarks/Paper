package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.TrialSpawner;
import org.bukkit.entity.Entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TrialSpawnerSpawnEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TrialSpawnerSpawnEvent#TrialSpawnerSpawnEvent(Entity, TrialSpawner)}
   *   <li>{@link TrialSpawnerSpawnEvent#getTrialSpawner()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TrialSpawnerSpawnEvent.<init>(Entity, TrialSpawner)",
    "TrialSpawner TrialSpawnerSpawnEvent.getTrialSpawner()"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity spawnee = mock(Entity.class);
    TrialSpawner spawner = mock(TrialSpawner.class);

    // Act
    TrialSpawnerSpawnEvent actualTrialSpawnerSpawnEvent =
        new TrialSpawnerSpawnEvent(spawnee, spawner);
    TrialSpawner actualTrialSpawner = actualTrialSpawnerSpawnEvent.getTrialSpawner();

    // Assert
    assertFalse(actualTrialSpawnerSpawnEvent.isAsynchronous());
    assertFalse(actualTrialSpawnerSpawnEvent.isCancelled());
    assertSame(spawner, actualTrialSpawner);
    assertSame(spawnee, actualTrialSpawnerSpawnEvent.getEntity());
  }
}

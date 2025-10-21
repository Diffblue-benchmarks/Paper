package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CreatureSpawnEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreatureSpawnEvent#CreatureSpawnEvent(LivingEntity, SpawnReason)}
   *   <li>{@link CreatureSpawnEvent#getSpawnReason()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CreatureSpawnEvent.<init>(LivingEntity, SpawnReason)",
    "SpawnReason CreatureSpawnEvent.getSpawnReason()"
  })
  void testGettersAndSetters() {
    // Arrange
    LivingEntity spawnee = mock(LivingEntity.class);

    // Act
    CreatureSpawnEvent actualCreatureSpawnEvent =
        new CreatureSpawnEvent(spawnee, SpawnReason.NATURAL);

    // Assert
    assertEquals(SpawnReason.NATURAL, actualCreatureSpawnEvent.getSpawnReason());
    assertFalse(actualCreatureSpawnEvent.isAsynchronous());
    assertFalse(actualCreatureSpawnEvent.isCancelled());
    assertSame(spawnee, actualCreatureSpawnEvent.getEntity());
  }

  /**
   * Test {@link CreatureSpawnEvent#getEntity()}.
   *
   * <p>Method under test: {@link CreatureSpawnEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LivingEntity CreatureSpawnEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    CreatureSpawnEvent creatureSpawnEvent =
        new CreatureSpawnEvent(mock(LivingEntity.class), SpawnReason.NATURAL);

    // Act
    LivingEntity actualEntity = creatureSpawnEvent.getEntity();

    // Assert
    assertSame(creatureSpawnEvent.entity, actualEntity);
  }
}

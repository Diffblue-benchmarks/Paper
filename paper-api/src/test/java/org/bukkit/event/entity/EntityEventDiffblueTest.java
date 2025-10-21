package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.destroystokyo.paper.event.entity.EntityJumpEvent;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityEventDiffblueTest {
  /**
   * Test {@link EntityEvent#getEntity()}.
   *
   * <p>Method under test: {@link EntityEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity EntityEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    EntitySpawnEvent entitySpawnEvent = new EntitySpawnEvent(mock(Entity.class));

    // Act
    Entity actualEntity = entitySpawnEvent.getEntity();

    // Assert
    assertSame(entitySpawnEvent.entity, actualEntity);
  }

  /**
   * Test {@link EntityEvent#getEntityType()}.
   *
   * <p>Method under test: {@link EntityEvent#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType EntityEvent.getEntityType()"})
  void testGetEntityType() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getType()).thenReturn(EntityType.ACACIA_BOAT);

    // Act
    EntityType actualEntityType = new EntityJumpEvent(entity).getEntityType();

    // Assert
    verify(entity).getType();
    assertEquals(EntityType.ACACIA_BOAT, actualEntityType);
  }
}

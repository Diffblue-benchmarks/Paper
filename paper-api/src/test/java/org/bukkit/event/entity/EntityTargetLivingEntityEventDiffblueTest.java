package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityTargetLivingEntityEventDiffblueTest {
  /**
   * Test {@link EntityTargetLivingEntityEvent#EntityTargetLivingEntityEvent(Entity, LivingEntity,
   * TargetReason)}.
   *
   * <p>Method under test: {@link
   * EntityTargetLivingEntityEvent#EntityTargetLivingEntityEvent(Entity, LivingEntity,
   * TargetReason)}
   */
  @Test
  @DisplayName("Test new EntityTargetLivingEntityEvent(Entity, LivingEntity, TargetReason)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityTargetLivingEntityEvent.<init>(Entity, LivingEntity, TargetReason)"
  })
  void testNewEntityTargetLivingEntityEvent() {
    // Arrange
    Entity entity = mock(Entity.class);
    LivingEntity target = mock(LivingEntity.class);

    // Act
    EntityTargetLivingEntityEvent actualEntityTargetLivingEntityEvent =
        new EntityTargetLivingEntityEvent(entity, target, TargetReason.TARGET_DIED);

    // Assert
    assertEquals(TargetReason.TARGET_DIED, actualEntityTargetLivingEntityEvent.getReason());
    assertFalse(actualEntityTargetLivingEntityEvent.isAsynchronous());
    assertFalse(actualEntityTargetLivingEntityEvent.isCancelled());
    assertSame(entity, actualEntityTargetLivingEntityEvent.getEntity());
    assertSame(target, actualEntityTargetLivingEntityEvent.getTarget());
  }

  /**
   * Test {@link EntityTargetLivingEntityEvent#setTarget(Entity)}.
   *
   * <p>Method under test: {@link EntityTargetLivingEntityEvent#setTarget(Entity)}
   */
  @Test
  @DisplayName("Test setTarget(Entity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityTargetLivingEntityEvent.setTarget(Entity)"})
  void testSetTarget() {
    // Arrange
    EntityTargetLivingEntityEvent entityTargetLivingEntityEvent =
        new EntityTargetLivingEntityEvent(
            mock(Entity.class), mock(LivingEntity.class), TargetReason.TARGET_DIED);

    // Act
    entityTargetLivingEntityEvent.setTarget(null);

    // Assert
    assertNull(entityTargetLivingEntityEvent.getTarget());
  }
}

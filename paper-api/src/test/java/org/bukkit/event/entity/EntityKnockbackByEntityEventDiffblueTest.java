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
import org.bukkit.event.entity.EntityKnockbackEvent.KnockbackCause;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityKnockbackByEntityEventDiffblueTest {
  /**
   * Test {@link EntityKnockbackByEntityEvent#EntityKnockbackByEntityEvent(LivingEntity, Entity,
   * KnockbackCause, double, Vector, Vector)}.
   *
   * <p>Method under test: {@link
   * EntityKnockbackByEntityEvent#EntityKnockbackByEntityEvent(LivingEntity, Entity, KnockbackCause,
   * double, Vector, Vector)}
   */
  @Test
  @DisplayName(
      "Test new EntityKnockbackByEntityEvent(LivingEntity, Entity, KnockbackCause, double, Vector, Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityKnockbackByEntityEvent.<init>(LivingEntity, Entity, KnockbackCause, double, Vector, Vector)"
  })
  void testNewEntityKnockbackByEntityEvent() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Entity source = mock(Entity.class);
    Vector rawKnockback = Vector.getRandom();
    Vector knockback = Vector.getRandom();

    // Act
    EntityKnockbackByEntityEvent actualEntityKnockbackByEntityEvent =
        new EntityKnockbackByEntityEvent(
            entity, source, KnockbackCause.DAMAGE, 10.0d, rawKnockback, knockback);

    // Assert
    assertEquals("EntityKnockbackByEntityEvent", actualEntityKnockbackByEntityEvent.getEventName());
    assertNull(actualEntityKnockbackByEntityEvent.getEntityType());
    assertEquals(10.0d, actualEntityKnockbackByEntityEvent.getForce());
    assertEquals(KnockbackCause.DAMAGE, actualEntityKnockbackByEntityEvent.getCause());
    assertFalse(actualEntityKnockbackByEntityEvent.isAsynchronous());
    assertFalse(actualEntityKnockbackByEntityEvent.isCancelled());
    assertEquals(knockback, actualEntityKnockbackByEntityEvent.getFinalKnockback());
    assertEquals(rawKnockback, actualEntityKnockbackByEntityEvent.getKnockback());
    assertSame(source, actualEntityKnockbackByEntityEvent.getSourceEntity());
    assertSame(entity, actualEntityKnockbackByEntityEvent.getEntity());
  }
}

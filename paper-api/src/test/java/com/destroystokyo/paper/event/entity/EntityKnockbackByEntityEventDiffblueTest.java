package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.event.entity.EntityKnockbackEvent;
import io.papermc.paper.event.entity.EntityKnockbackEvent.Cause;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityKnockbackByEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityKnockbackByEntityEvent#EntityKnockbackByEntityEvent(LivingEntity, Entity,
   *       EntityKnockbackEvent.Cause, float, Vector)}
   *   <li>{@link EntityKnockbackByEntityEvent#getKnockbackStrength()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityKnockbackByEntityEvent.<init>(LivingEntity, Entity, EntityKnockbackEvent.Cause, float, Vector)",
    "float EntityKnockbackByEntityEvent.getKnockbackStrength()"
  })
  void testGettersAndSetters() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Entity hitBy = mock(Entity.class);
    Vector knockback = Vector.getRandom();

    // Act
    EntityKnockbackByEntityEvent actualEntityKnockbackByEntityEvent =
        new EntityKnockbackByEntityEvent(entity, hitBy, Cause.DAMAGE, 10.0f, knockback);

    // Assert
    assertEquals(10.0f, actualEntityKnockbackByEntityEvent.getKnockbackStrength());
    assertEquals(Cause.DAMAGE, actualEntityKnockbackByEntityEvent.getCause());
    assertFalse(actualEntityKnockbackByEntityEvent.isCancelled());
    assertFalse(actualEntityKnockbackByEntityEvent.isAsynchronous());
    assertSame(knockback, actualEntityKnockbackByEntityEvent.getAcceleration());
    assertSame(hitBy, actualEntityKnockbackByEntityEvent.getPushedBy());
    assertSame(entity, actualEntityKnockbackByEntityEvent.getEntity());
  }
}

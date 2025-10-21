package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.base.Function;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDamageEvent.DamageModifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityDamageByEntityEventDiffblueTest {
  /**
   * Test {@link EntityDamageByEntityEvent#EntityDamageByEntityEvent(Entity, Entity, DamageCause,
   * DamageSource, double)}.
   *
   * <p>Method under test: {@link EntityDamageByEntityEvent#EntityDamageByEntityEvent(Entity,
   * Entity, DamageCause, DamageSource, double)}
   */
  @Test
  @DisplayName(
      "Test new EntityDamageByEntityEvent(Entity, Entity, DamageCause, DamageSource, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDamageByEntityEvent.<init>(Entity, Entity, DamageCause, DamageSource, double)"
  })
  void testNewEntityDamageByEntityEvent() {
    // Arrange
    Entity damager = mock(Entity.class);
    Entity damagee = mock(Entity.class);
    DamageSource damageSource = mock(DamageSource.class);

    // Act
    EntityDamageByEntityEvent actualEntityDamageByEntityEvent =
        new EntityDamageByEntityEvent(damager, damagee, DamageCause.KILL, damageSource, 10.0d);

    // Assert
    assertEquals("EntityDamageByEntityEvent", actualEntityDamageByEntityEvent.getEventName());
    assertNull(actualEntityDamageByEntityEvent.getEntityType());
    assertEquals(0, actualEntityDamageByEntityEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(10.0d, actualEntityDamageByEntityEvent.getDamage());
    assertEquals(10.0d, actualEntityDamageByEntityEvent.getFinalDamage());
    assertEquals(DamageCause.KILL, actualEntityDamageByEntityEvent.getCause());
    assertFalse(actualEntityDamageByEntityEvent.isAsynchronous());
    assertFalse(actualEntityDamageByEntityEvent.isCritical());
    assertFalse(actualEntityDamageByEntityEvent.isCancelled());
    assertSame(damageSource, actualEntityDamageByEntityEvent.getDamageSource());
    assertSame(damager, actualEntityDamageByEntityEvent.getDamager());
    assertSame(damagee, actualEntityDamageByEntityEvent.getEntity());
  }

  /**
   * Test {@link EntityDamageByEntityEvent#EntityDamageByEntityEvent(Entity, Entity, DamageCause,
   * DamageSource, Map, Map)}.
   *
   * <ul>
   *   <li>Then return EventName is {@code EntityDamageByEntityEvent}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDamageByEntityEvent#EntityDamageByEntityEvent(Entity,
   * Entity, DamageCause, DamageSource, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test new EntityDamageByEntityEvent(Entity, Entity, DamageCause, DamageSource, Map, Map); then return EventName is 'EntityDamageByEntityEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDamageByEntityEvent.<init>(Entity, Entity, DamageCause, DamageSource, Map, Map)"
  })
  void testNewEntityDamageByEntityEvent_thenReturnEventNameIsEntityDamageByEntityEvent() {
    // Arrange
    Entity damager = mock(Entity.class);
    Entity damagee = mock(Entity.class);
    DamageSource damageSource = mock(DamageSource.class);

    HashMap<DamageModifier, Double> modifiers = new HashMap<>();
    modifiers.put(DamageModifier.BASE, 10.0d);

    HashMap<DamageModifier, Function<? super Double, Double>> modifierFunctions = new HashMap<>();
    modifierFunctions.put(DamageModifier.BASE, mock(Function.class));

    // Act
    EntityDamageByEntityEvent actualEntityDamageByEntityEvent =
        new EntityDamageByEntityEvent(
            damager, damagee, DamageCause.KILL, damageSource, modifiers, modifierFunctions);

    // Assert
    assertEquals("EntityDamageByEntityEvent", actualEntityDamageByEntityEvent.getEventName());
    assertNull(actualEntityDamageByEntityEvent.getEntityType());
    assertEquals(0, actualEntityDamageByEntityEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(10.0d, actualEntityDamageByEntityEvent.getDamage());
    assertEquals(10.0d, actualEntityDamageByEntityEvent.getFinalDamage());
    assertEquals(DamageCause.KILL, actualEntityDamageByEntityEvent.getCause());
    assertFalse(actualEntityDamageByEntityEvent.isAsynchronous());
    assertFalse(actualEntityDamageByEntityEvent.isCritical());
    assertFalse(actualEntityDamageByEntityEvent.isCancelled());
    assertSame(damageSource, actualEntityDamageByEntityEvent.getDamageSource());
    assertSame(damager, actualEntityDamageByEntityEvent.getDamager());
    assertSame(damagee, actualEntityDamageByEntityEvent.getEntity());
  }

  /**
   * Test {@link EntityDamageByEntityEvent#EntityDamageByEntityEvent(Entity, Entity, DamageCause,
   * DamageSource, Map, Map, boolean)}.
   *
   * <ul>
   *   <li>Then return EventName is {@code EntityDamageByEntityEvent}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDamageByEntityEvent#EntityDamageByEntityEvent(Entity,
   * Entity, DamageCause, DamageSource, Map, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test new EntityDamageByEntityEvent(Entity, Entity, DamageCause, DamageSource, Map, Map, boolean); then return EventName is 'EntityDamageByEntityEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDamageByEntityEvent.<init>(Entity, Entity, DamageCause, DamageSource, Map, Map, boolean)"
  })
  void testNewEntityDamageByEntityEvent_thenReturnEventNameIsEntityDamageByEntityEvent2() {
    // Arrange
    Entity damager = mock(Entity.class);
    Entity damagee = mock(Entity.class);
    DamageSource damageSource = mock(DamageSource.class);

    HashMap<DamageModifier, Double> modifiers = new HashMap<>();
    modifiers.put(DamageModifier.BASE, 10.0d);

    HashMap<DamageModifier, Function<? super Double, Double>> modifierFunctions = new HashMap<>();
    modifierFunctions.put(DamageModifier.BASE, mock(Function.class));

    // Act
    EntityDamageByEntityEvent actualEntityDamageByEntityEvent =
        new EntityDamageByEntityEvent(
            damager, damagee, DamageCause.KILL, damageSource, modifiers, modifierFunctions, true);

    // Assert
    assertEquals("EntityDamageByEntityEvent", actualEntityDamageByEntityEvent.getEventName());
    assertNull(actualEntityDamageByEntityEvent.getEntityType());
    assertEquals(0, actualEntityDamageByEntityEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(10.0d, actualEntityDamageByEntityEvent.getDamage());
    assertEquals(10.0d, actualEntityDamageByEntityEvent.getFinalDamage());
    assertEquals(DamageCause.KILL, actualEntityDamageByEntityEvent.getCause());
    assertFalse(actualEntityDamageByEntityEvent.isAsynchronous());
    assertFalse(actualEntityDamageByEntityEvent.isCancelled());
    assertTrue(actualEntityDamageByEntityEvent.isCritical());
    assertSame(damageSource, actualEntityDamageByEntityEvent.getDamageSource());
    assertSame(damager, actualEntityDamageByEntityEvent.getDamager());
    assertSame(damagee, actualEntityDamageByEntityEvent.getEntity());
  }
}

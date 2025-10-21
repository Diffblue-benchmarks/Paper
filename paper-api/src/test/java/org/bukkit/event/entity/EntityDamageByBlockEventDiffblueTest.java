package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.base.Function;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDamageEvent.DamageModifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityDamageByBlockEventDiffblueTest {
  /**
   * Test {@link EntityDamageByBlockEvent#EntityDamageByBlockEvent(Block, BlockState, Entity,
   * DamageCause, DamageSource, double)}.
   *
   * <p>Method under test: {@link EntityDamageByBlockEvent#EntityDamageByBlockEvent(Block,
   * BlockState, Entity, DamageCause, DamageSource, double)}
   */
  @Test
  @DisplayName(
      "Test new EntityDamageByBlockEvent(Block, BlockState, Entity, DamageCause, DamageSource, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDamageByBlockEvent.<init>(Block, BlockState, Entity, DamageCause, DamageSource, double)"
  })
  void testNewEntityDamageByBlockEvent() {
    // Arrange
    Block damager = mock(Block.class);
    BlockState damagerState = mock(BlockState.class);
    Entity damagee = mock(Entity.class);
    DamageSource damageSource = mock(DamageSource.class);

    // Act
    EntityDamageByBlockEvent actualEntityDamageByBlockEvent =
        new EntityDamageByBlockEvent(
            damager, damagerState, damagee, DamageCause.KILL, damageSource, 10.0d);

    // Assert
    assertEquals("EntityDamageByBlockEvent", actualEntityDamageByBlockEvent.getEventName());
    assertNull(actualEntityDamageByBlockEvent.getEntityType());
    assertEquals(0, actualEntityDamageByBlockEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(10.0d, actualEntityDamageByBlockEvent.getDamage());
    assertEquals(10.0d, actualEntityDamageByBlockEvent.getFinalDamage());
    assertEquals(DamageCause.KILL, actualEntityDamageByBlockEvent.getCause());
    assertFalse(actualEntityDamageByBlockEvent.isAsynchronous());
    assertFalse(actualEntityDamageByBlockEvent.isCancelled());
    assertSame(damager, actualEntityDamageByBlockEvent.getDamager());
    assertSame(damagerState, actualEntityDamageByBlockEvent.getDamagerBlockState());
    assertSame(damageSource, actualEntityDamageByBlockEvent.getDamageSource());
    assertSame(damagee, actualEntityDamageByBlockEvent.getEntity());
  }

  /**
   * Test {@link EntityDamageByBlockEvent#EntityDamageByBlockEvent(Block, BlockState, Entity,
   * DamageCause, DamageSource, Map, Map)}.
   *
   * <ul>
   *   <li>Then return EventName is {@code EntityDamageByBlockEvent}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDamageByBlockEvent#EntityDamageByBlockEvent(Block,
   * BlockState, Entity, DamageCause, DamageSource, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test new EntityDamageByBlockEvent(Block, BlockState, Entity, DamageCause, DamageSource, Map, Map); then return EventName is 'EntityDamageByBlockEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDamageByBlockEvent.<init>(Block, BlockState, Entity, DamageCause, DamageSource, Map, Map)"
  })
  void testNewEntityDamageByBlockEvent_thenReturnEventNameIsEntityDamageByBlockEvent() {
    // Arrange
    Block damager = mock(Block.class);
    BlockState damagerState = mock(BlockState.class);
    Entity damagee = mock(Entity.class);
    DamageSource damageSource = mock(DamageSource.class);

    HashMap<DamageModifier, Double> modifiers = new HashMap<>();
    modifiers.put(DamageModifier.BASE, 10.0d);

    HashMap<DamageModifier, Function<? super Double, Double>> modifierFunctions = new HashMap<>();
    modifierFunctions.put(DamageModifier.BASE, mock(Function.class));

    // Act
    EntityDamageByBlockEvent actualEntityDamageByBlockEvent =
        new EntityDamageByBlockEvent(
            damager,
            damagerState,
            damagee,
            DamageCause.KILL,
            damageSource,
            modifiers,
            modifierFunctions);

    // Assert
    assertEquals("EntityDamageByBlockEvent", actualEntityDamageByBlockEvent.getEventName());
    assertNull(actualEntityDamageByBlockEvent.getEntityType());
    assertEquals(0, actualEntityDamageByBlockEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(10.0d, actualEntityDamageByBlockEvent.getDamage());
    assertEquals(10.0d, actualEntityDamageByBlockEvent.getFinalDamage());
    assertEquals(DamageCause.KILL, actualEntityDamageByBlockEvent.getCause());
    assertFalse(actualEntityDamageByBlockEvent.isAsynchronous());
    assertFalse(actualEntityDamageByBlockEvent.isCancelled());
    assertSame(damager, actualEntityDamageByBlockEvent.getDamager());
    assertSame(damagerState, actualEntityDamageByBlockEvent.getDamagerBlockState());
    assertSame(damageSource, actualEntityDamageByBlockEvent.getDamageSource());
    assertSame(damagee, actualEntityDamageByBlockEvent.getEntity());
  }
}

package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class EntityDamageEventDiffblueTest {
  /**
   * Test {@link EntityDamageEvent#EntityDamageEvent(Entity, DamageCause, DamageSource, double)}.
   *
   * <p>Method under test: {@link EntityDamageEvent#EntityDamageEvent(Entity, DamageCause,
   * DamageSource, double)}
   */
  @Test
  @DisplayName("Test new EntityDamageEvent(Entity, DamageCause, DamageSource, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityDamageEvent.<init>(Entity, DamageCause, DamageSource, double)"})
  void testNewEntityDamageEvent() {
    // Arrange
    Entity damagee = mock(Entity.class);
    DamageSource damageSource = mock(DamageSource.class);

    // Act
    EntityDamageEvent actualEntityDamageEvent =
        new EntityDamageEvent(damagee, DamageCause.KILL, damageSource, 10.0d);

    // Assert
    assertEquals("EntityDamageEvent", actualEntityDamageEvent.getEventName());
    assertNull(actualEntityDamageEvent.getEntityType());
    assertEquals(0, actualEntityDamageEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(10.0d, actualEntityDamageEvent.getDamage());
    assertEquals(10.0d, actualEntityDamageEvent.getFinalDamage());
    assertEquals(DamageCause.KILL, actualEntityDamageEvent.getCause());
    assertFalse(actualEntityDamageEvent.isAsynchronous());
    assertFalse(actualEntityDamageEvent.isCancelled());
    assertSame(damageSource, actualEntityDamageEvent.getDamageSource());
    assertSame(damagee, actualEntityDamageEvent.getEntity());
  }

  /**
   * Test {@link EntityDamageEvent#EntityDamageEvent(Entity, DamageCause, DamageSource, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link Function}.
   *   <li>Then return EventName is {@code EntityDamageEvent}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDamageEvent#EntityDamageEvent(Entity, DamageCause,
   * DamageSource, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test new EntityDamageEvent(Entity, DamageCause, DamageSource, Map, Map); given Function; then return EventName is 'EntityDamageEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityDamageEvent.<init>(Entity, DamageCause, DamageSource, Map, Map)"})
  void testNewEntityDamageEvent_givenFunction_thenReturnEventNameIsEntityDamageEvent() {
    // Arrange
    Entity damagee = mock(Entity.class);
    DamageSource damageSource = mock(DamageSource.class);

    HashMap<DamageModifier, Double> modifiers = new HashMap<>();
    modifiers.put(DamageModifier.BASE, 10.0d);

    HashMap<DamageModifier, Function<? super Double, Double>> modifierFunctions = new HashMap<>();
    modifierFunctions.put(DamageModifier.BASE, mock(Function.class));

    // Act
    EntityDamageEvent actualEntityDamageEvent =
        new EntityDamageEvent(
            damagee, DamageCause.KILL, damageSource, modifiers, modifierFunctions);

    // Assert
    assertEquals("EntityDamageEvent", actualEntityDamageEvent.getEventName());
    assertNull(actualEntityDamageEvent.getEntityType());
    assertEquals(0, actualEntityDamageEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(10.0d, actualEntityDamageEvent.getDamage());
    assertEquals(10.0d, actualEntityDamageEvent.getFinalDamage());
    assertEquals(DamageCause.KILL, actualEntityDamageEvent.getCause());
    assertFalse(actualEntityDamageEvent.isAsynchronous());
    assertFalse(actualEntityDamageEvent.isCancelled());
    assertSame(damageSource, actualEntityDamageEvent.getDamageSource());
    assertSame(damagee, actualEntityDamageEvent.getEntity());
  }

  /**
   * Test {@link EntityDamageEvent#getOriginalDamage(DamageModifier)}.
   *
   * <ul>
   *   <li>When {@code BASE}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityDamageEvent#getOriginalDamage(DamageModifier)}
   */
  @Test
  @DisplayName("Test getOriginalDamage(DamageModifier); when 'BASE'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double EntityDamageEvent.getOriginalDamage(DamageModifier)"})
  void testGetOriginalDamage_whenBase_thenReturnTen() throws IllegalArgumentException {
    // Arrange
    EntityDamageByBlockEvent entityDamageByBlockEvent =
        new EntityDamageByBlockEvent(
            mock(Block.class),
            mock(BlockState.class),
            mock(Entity.class),
            DamageCause.KILL,
            mock(DamageSource.class),
            10.0d);

    // Act and Assert
    assertEquals(10.0d, entityDamageByBlockEvent.getOriginalDamage(DamageModifier.BASE));
  }

  /**
   * Test {@link EntityDamageEvent#getOriginalDamage(DamageModifier)}.
   *
   * <ul>
   *   <li>When {@code INVULNERABILITY_REDUCTION}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link EntityDamageEvent#getOriginalDamage(DamageModifier)}
   */
  @Test
  @DisplayName(
      "Test getOriginalDamage(DamageModifier); when 'INVULNERABILITY_REDUCTION'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double EntityDamageEvent.getOriginalDamage(DamageModifier)"})
  void testGetOriginalDamage_whenInvulnerabilityReduction_thenReturnZero()
      throws IllegalArgumentException {
    // Arrange
    EntityDamageByBlockEvent entityDamageByBlockEvent =
        new EntityDamageByBlockEvent(
            mock(Block.class),
            mock(BlockState.class),
            mock(Entity.class),
            DamageCause.KILL,
            mock(DamageSource.class),
            10.0d);

    // Act and Assert
    assertEquals(
        0.0d, entityDamageByBlockEvent.getOriginalDamage(DamageModifier.INVULNERABILITY_REDUCTION));
  }

  /**
   * Test {@link EntityDamageEvent#setDamage(double)} with {@code damage}.
   *
   * <p>Method under test: {@link EntityDamageEvent#setDamage(double)}
   */
  @Test
  @DisplayName("Test setDamage(double) with 'damage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityDamageEvent.setDamage(double)"})
  void testSetDamageWithDamage() {
    // Arrange
    EntityDamageByBlockEvent entityDamageByBlockEvent =
        new EntityDamageByBlockEvent(
            mock(Block.class),
            mock(BlockState.class),
            mock(Entity.class),
            DamageCause.KILL,
            mock(DamageSource.class),
            10.0d);

    // Act
    entityDamageByBlockEvent.setDamage(10.0d);

    // Assert that nothing has changed
    assertEquals(10.0d, entityDamageByBlockEvent.getDamage());
    assertEquals(10.0d, entityDamageByBlockEvent.getFinalDamage());
  }

  /**
   * Test {@link EntityDamageEvent#setDamage(double)} with {@code damage}.
   *
   * <p>Method under test: {@link EntityDamageEvent#setDamage(double)}
   */
  @Test
  @DisplayName("Test setDamage(double) with 'damage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityDamageEvent.setDamage(double)"})
  void testSetDamageWithDamage2() {
    // Arrange
    EntityDamageByBlockEvent entityDamageByBlockEvent =
        new EntityDamageByBlockEvent(
            mock(Block.class),
            mock(BlockState.class),
            mock(Entity.class),
            DamageCause.KILL,
            mock(DamageSource.class),
            0.0d);

    // Act
    entityDamageByBlockEvent.setDamage(10.0d);

    // Assert
    assertEquals(10.0d, entityDamageByBlockEvent.getDamage());
    assertEquals(10.0d, entityDamageByBlockEvent.getFinalDamage());
  }

  /**
   * Test {@link EntityDamageEvent#setDamage(DamageModifier, double)} with {@code type}, {@code
   * damage}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDamageEvent#setDamage(DamageModifier, double)}
   */
  @Test
  @DisplayName(
      "Test setDamage(DamageModifier, double) with 'type', 'damage'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityDamageEvent.setDamage(DamageModifier, double)"})
  void testSetDamageWithTypeDamage_thenThrowUnsupportedOperationException()
      throws IllegalArgumentException, UnsupportedOperationException {
    // Arrange
    EntityDamageByBlockEvent entityDamageByBlockEvent =
        new EntityDamageByBlockEvent(
            mock(Block.class),
            mock(BlockState.class),
            mock(Entity.class),
            DamageCause.KILL,
            mock(DamageSource.class),
            10.0d);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> entityDamageByBlockEvent.setDamage(DamageModifier.INVULNERABILITY_REDUCTION, 10.0d));
  }

  /**
   * Test {@link EntityDamageEvent#getDamage(DamageModifier)} with {@code DamageModifier}.
   *
   * <ul>
   *   <li>When {@code BASE}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityDamageEvent#getDamage(DamageModifier)}
   */
  @Test
  @DisplayName("Test getDamage(DamageModifier) with 'DamageModifier'; when 'BASE'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double EntityDamageEvent.getDamage(DamageModifier)"})
  void testGetDamageWithDamageModifier_whenBase_thenReturnTen() throws IllegalArgumentException {
    // Arrange
    EntityDamageByBlockEvent entityDamageByBlockEvent =
        new EntityDamageByBlockEvent(
            mock(Block.class),
            mock(BlockState.class),
            mock(Entity.class),
            DamageCause.KILL,
            mock(DamageSource.class),
            10.0d);

    // Act and Assert
    assertEquals(10.0d, entityDamageByBlockEvent.getDamage(DamageModifier.BASE));
  }

  /**
   * Test {@link EntityDamageEvent#getDamage(DamageModifier)} with {@code DamageModifier}.
   *
   * <ul>
   *   <li>When {@code INVULNERABILITY_REDUCTION}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link EntityDamageEvent#getDamage(DamageModifier)}
   */
  @Test
  @DisplayName(
      "Test getDamage(DamageModifier) with 'DamageModifier'; when 'INVULNERABILITY_REDUCTION'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double EntityDamageEvent.getDamage(DamageModifier)"})
  void testGetDamageWithDamageModifier_whenInvulnerabilityReduction_thenReturnZero()
      throws IllegalArgumentException {
    // Arrange
    EntityDamageByBlockEvent entityDamageByBlockEvent =
        new EntityDamageByBlockEvent(
            mock(Block.class),
            mock(BlockState.class),
            mock(Entity.class),
            DamageCause.KILL,
            mock(DamageSource.class),
            10.0d);

    // Act and Assert
    assertEquals(
        0.0d, entityDamageByBlockEvent.getDamage(DamageModifier.INVULNERABILITY_REDUCTION));
  }

  /**
   * Test {@link EntityDamageEvent#getDamage()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityDamageEvent#getDamage()}
   */
  @Test
  @DisplayName("Test getDamage(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double EntityDamageEvent.getDamage()"})
  void testGetDamage_thenReturnTen() {
    // Arrange
    EntityDamageByBlockEvent entityDamageByBlockEvent =
        new EntityDamageByBlockEvent(
            mock(Block.class),
            mock(BlockState.class),
            mock(Entity.class),
            DamageCause.KILL,
            mock(DamageSource.class),
            10.0d);

    // Act and Assert
    assertEquals(10.0d, entityDamageByBlockEvent.getDamage());
  }

  /**
   * Test {@link EntityDamageEvent#isApplicable(DamageModifier)}.
   *
   * <ul>
   *   <li>When {@code BASE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDamageEvent#isApplicable(DamageModifier)}
   */
  @Test
  @DisplayName("Test isApplicable(DamageModifier); when 'BASE'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityDamageEvent.isApplicable(DamageModifier)"})
  void testIsApplicable_whenBase_thenReturnTrue() throws IllegalArgumentException {
    // Arrange
    EntityDamageByBlockEvent entityDamageByBlockEvent =
        new EntityDamageByBlockEvent(
            mock(Block.class),
            mock(BlockState.class),
            mock(Entity.class),
            DamageCause.KILL,
            mock(DamageSource.class),
            10.0d);

    // Act and Assert
    assertTrue(entityDamageByBlockEvent.isApplicable(DamageModifier.BASE));
  }

  /**
   * Test {@link EntityDamageEvent#isApplicable(DamageModifier)}.
   *
   * <ul>
   *   <li>When {@code INVULNERABILITY_REDUCTION}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDamageEvent#isApplicable(DamageModifier)}
   */
  @Test
  @DisplayName(
      "Test isApplicable(DamageModifier); when 'INVULNERABILITY_REDUCTION'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityDamageEvent.isApplicable(DamageModifier)"})
  void testIsApplicable_whenInvulnerabilityReduction_thenReturnFalse()
      throws IllegalArgumentException {
    // Arrange
    EntityDamageByBlockEvent entityDamageByBlockEvent =
        new EntityDamageByBlockEvent(
            mock(Block.class),
            mock(BlockState.class),
            mock(Entity.class),
            DamageCause.KILL,
            mock(DamageSource.class),
            10.0d);

    // Act and Assert
    assertFalse(entityDamageByBlockEvent.isApplicable(DamageModifier.INVULNERABILITY_REDUCTION));
  }

  /**
   * Test {@link EntityDamageEvent#getFinalDamage()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityDamageEvent#getFinalDamage()}
   */
  @Test
  @DisplayName("Test getFinalDamage(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double EntityDamageEvent.getFinalDamage()"})
  void testGetFinalDamage_thenReturnTen() {
    // Arrange
    EntityDamageByBlockEvent entityDamageByBlockEvent =
        new EntityDamageByBlockEvent(
            mock(Block.class),
            mock(BlockState.class),
            mock(Entity.class),
            DamageCause.KILL,
            mock(DamageSource.class),
            10.0d);

    // Act and Assert
    assertEquals(10.0d, entityDamageByBlockEvent.getFinalDamage());
  }
}

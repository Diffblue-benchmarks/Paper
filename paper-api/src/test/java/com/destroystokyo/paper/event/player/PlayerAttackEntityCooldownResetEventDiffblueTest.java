package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerAttackEntityCooldownResetEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerAttackEntityCooldownResetEvent#PlayerAttackEntityCooldownResetEvent(Player,
   *       Entity, float)}
   *   <li>{@link PlayerAttackEntityCooldownResetEvent#setCancelled(boolean)}
   *   <li>{@link PlayerAttackEntityCooldownResetEvent#getHandlerList()}
   *   <li>{@link PlayerAttackEntityCooldownResetEvent#getAttackedEntity()}
   *   <li>{@link PlayerAttackEntityCooldownResetEvent#getCooledAttackStrength()}
   *   <li>{@link PlayerAttackEntityCooldownResetEvent#getHandlers()}
   *   <li>{@link PlayerAttackEntityCooldownResetEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerAttackEntityCooldownResetEvent.<init>(Player, Entity, float)",
    "Entity PlayerAttackEntityCooldownResetEvent.getAttackedEntity()",
    "float PlayerAttackEntityCooldownResetEvent.getCooledAttackStrength()",
    "HandlerList PlayerAttackEntityCooldownResetEvent.getHandlerList()",
    "HandlerList PlayerAttackEntityCooldownResetEvent.getHandlers()",
    "boolean PlayerAttackEntityCooldownResetEvent.isCancelled()",
    "void PlayerAttackEntityCooldownResetEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Entity attackedEntity = mock(Entity.class);

    // Act
    PlayerAttackEntityCooldownResetEvent actualPlayerAttackEntityCooldownResetEvent =
        new PlayerAttackEntityCooldownResetEvent(player, attackedEntity, 10.0f);
    actualPlayerAttackEntityCooldownResetEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerAttackEntityCooldownResetEvent.getHandlerList();
    Entity actualAttackedEntity = actualPlayerAttackEntityCooldownResetEvent.getAttackedEntity();
    float actualCooledAttackStrength =
        actualPlayerAttackEntityCooldownResetEvent.getCooledAttackStrength();
    HandlerList actualHandlers = actualPlayerAttackEntityCooldownResetEvent.getHandlers();
    boolean actualIsCancelledResult = actualPlayerAttackEntityCooldownResetEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10.0f, actualCooledAttackStrength);
    assertFalse(actualPlayerAttackEntityCooldownResetEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(attackedEntity, actualAttackedEntity);
    assertSame(player, actualPlayerAttackEntityCooldownResetEvent.getPlayer());
  }
}

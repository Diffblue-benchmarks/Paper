package io.papermc.paper.event.player;

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

class PlayerShieldDisableEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerShieldDisableEvent#PlayerShieldDisableEvent(Player, Entity, int)}
   *   <li>{@link PlayerShieldDisableEvent#setCancelled(boolean)}
   *   <li>{@link PlayerShieldDisableEvent#getHandlerList()}
   *   <li>{@link PlayerShieldDisableEvent#getCooldown()}
   *   <li>{@link PlayerShieldDisableEvent#getDamager()}
   *   <li>{@link PlayerShieldDisableEvent#getHandlers()}
   *   <li>{@link PlayerShieldDisableEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerShieldDisableEvent.<init>(Player, Entity, int)",
    "int PlayerShieldDisableEvent.getCooldown()",
    "Entity PlayerShieldDisableEvent.getDamager()",
    "HandlerList PlayerShieldDisableEvent.getHandlerList()",
    "HandlerList PlayerShieldDisableEvent.getHandlers()",
    "boolean PlayerShieldDisableEvent.isCancelled()",
    "void PlayerShieldDisableEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Entity damager = mock(Entity.class);

    // Act
    PlayerShieldDisableEvent actualPlayerShieldDisableEvent =
        new PlayerShieldDisableEvent(player, damager, 1);
    actualPlayerShieldDisableEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerShieldDisableEvent.getHandlerList();
    int actualCooldown = actualPlayerShieldDisableEvent.getCooldown();
    Entity actualDamager = actualPlayerShieldDisableEvent.getDamager();
    HandlerList actualHandlers = actualPlayerShieldDisableEvent.getHandlers();
    boolean actualIsCancelledResult = actualPlayerShieldDisableEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualCooldown);
    assertFalse(actualPlayerShieldDisableEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(damager, actualDamager);
    assertSame(player, actualPlayerShieldDisableEvent.getPlayer());
  }
}

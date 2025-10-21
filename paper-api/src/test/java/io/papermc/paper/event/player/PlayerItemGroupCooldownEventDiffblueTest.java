package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerItemGroupCooldownEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerItemGroupCooldownEvent#PlayerItemGroupCooldownEvent(Player, NamespacedKey,
   *       int)}
   *   <li>{@link PlayerItemGroupCooldownEvent#setCancelled(boolean)}
   *   <li>{@link PlayerItemGroupCooldownEvent#getHandlerList()}
   *   <li>{@link PlayerItemGroupCooldownEvent#getCooldown()}
   *   <li>{@link PlayerItemGroupCooldownEvent#getCooldownGroup()}
   *   <li>{@link PlayerItemGroupCooldownEvent#getHandlers()}
   *   <li>{@link PlayerItemGroupCooldownEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerItemGroupCooldownEvent.<init>(Player, NamespacedKey, int)",
    "int PlayerItemGroupCooldownEvent.getCooldown()",
    "NamespacedKey PlayerItemGroupCooldownEvent.getCooldownGroup()",
    "HandlerList PlayerItemGroupCooldownEvent.getHandlerList()",
    "HandlerList PlayerItemGroupCooldownEvent.getHandlers()",
    "boolean PlayerItemGroupCooldownEvent.isCancelled()",
    "void PlayerItemGroupCooldownEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    NamespacedKey cooldownGroup = NamespacedKey.randomKey();

    // Act
    PlayerItemGroupCooldownEvent actualPlayerItemGroupCooldownEvent =
        new PlayerItemGroupCooldownEvent(player, cooldownGroup, 1);
    actualPlayerItemGroupCooldownEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerItemGroupCooldownEvent.getHandlerList();
    int actualCooldown = actualPlayerItemGroupCooldownEvent.getCooldown();
    NamespacedKey actualCooldownGroup = actualPlayerItemGroupCooldownEvent.getCooldownGroup();
    HandlerList actualHandlers = actualPlayerItemGroupCooldownEvent.getHandlers();
    boolean actualIsCancelledResult = actualPlayerItemGroupCooldownEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualCooldown);
    assertFalse(actualPlayerItemGroupCooldownEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(cooldownGroup, actualCooldownGroup);
    assertSame(player, actualPlayerItemGroupCooldownEvent.getPlayer());
  }
}

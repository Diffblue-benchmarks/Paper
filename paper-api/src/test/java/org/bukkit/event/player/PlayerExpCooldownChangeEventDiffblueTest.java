package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerExpCooldownChangeEvent.ChangeReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerExpCooldownChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerExpCooldownChangeEvent#PlayerExpCooldownChangeEvent(Player, int,
   *       ChangeReason)}
   *   <li>{@link PlayerExpCooldownChangeEvent#setNewCooldown(int)}
   *   <li>{@link PlayerExpCooldownChangeEvent#getHandlerList()}
   *   <li>{@link PlayerExpCooldownChangeEvent#getHandlers()}
   *   <li>{@link PlayerExpCooldownChangeEvent#getNewCooldown()}
   *   <li>{@link PlayerExpCooldownChangeEvent#getReason()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerExpCooldownChangeEvent.<init>(Player, int, ChangeReason)",
    "HandlerList PlayerExpCooldownChangeEvent.getHandlerList()",
    "HandlerList PlayerExpCooldownChangeEvent.getHandlers()",
    "int PlayerExpCooldownChangeEvent.getNewCooldown()",
    "ChangeReason PlayerExpCooldownChangeEvent.getReason()",
    "void PlayerExpCooldownChangeEvent.setNewCooldown(int)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerExpCooldownChangeEvent actualPlayerExpCooldownChangeEvent =
        new PlayerExpCooldownChangeEvent(player, 1, ChangeReason.PICKUP_ORB);
    actualPlayerExpCooldownChangeEvent.setNewCooldown(1);
    HandlerList actualHandlerList = actualPlayerExpCooldownChangeEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerExpCooldownChangeEvent.getHandlers();
    int actualNewCooldown = actualPlayerExpCooldownChangeEvent.getNewCooldown();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualNewCooldown);
    assertEquals(ChangeReason.PICKUP_ORB, actualPlayerExpCooldownChangeEvent.getReason());
    assertFalse(actualPlayerExpCooldownChangeEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerExpCooldownChangeEvent.getPlayer());
  }
}

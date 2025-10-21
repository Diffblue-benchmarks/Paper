package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerAnimationEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerAnimationEvent#PlayerAnimationEvent(Player, PlayerAnimationType)}
   *   <li>{@link PlayerAnimationEvent#setCancelled(boolean)}
   *   <li>{@link PlayerAnimationEvent#getHandlerList()}
   *   <li>{@link PlayerAnimationEvent#getAnimationType()}
   *   <li>{@link PlayerAnimationEvent#getHandlers()}
   *   <li>{@link PlayerAnimationEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerAnimationEvent.<init>(Player, PlayerAnimationType)",
    "PlayerAnimationType PlayerAnimationEvent.getAnimationType()",
    "HandlerList PlayerAnimationEvent.getHandlerList()",
    "HandlerList PlayerAnimationEvent.getHandlers()",
    "boolean PlayerAnimationEvent.isCancelled()",
    "void PlayerAnimationEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerAnimationEvent actualPlayerAnimationEvent =
        new PlayerAnimationEvent(player, PlayerAnimationType.ARM_SWING);
    actualPlayerAnimationEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerAnimationEvent.getHandlerList();
    PlayerAnimationType actualAnimationType = actualPlayerAnimationEvent.getAnimationType();
    HandlerList actualHandlers = actualPlayerAnimationEvent.getHandlers();
    boolean actualIsCancelledResult = actualPlayerAnimationEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(PlayerAnimationType.ARM_SWING, actualAnimationType);
    assertFalse(actualPlayerAnimationEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerAnimationEvent.getPlayer());
  }

  /**
   * Test {@link PlayerAnimationEvent#PlayerAnimationEvent(Player)}.
   *
   * <p>Method under test: {@link PlayerAnimationEvent#PlayerAnimationEvent(Player)}
   */
  @Test
  @DisplayName("Test new PlayerAnimationEvent(Player)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerAnimationEvent.<init>(Player)"})
  void testNewPlayerAnimationEvent() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerAnimationEvent actualPlayerAnimationEvent = new PlayerAnimationEvent(player);

    // Assert
    assertEquals("PlayerAnimationEvent", actualPlayerAnimationEvent.getEventName());
    assertEquals(0, actualPlayerAnimationEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(PlayerAnimationType.ARM_SWING, actualPlayerAnimationEvent.getAnimationType());
    assertFalse(actualPlayerAnimationEvent.isAsynchronous());
    assertFalse(actualPlayerAnimationEvent.isCancelled());
    assertSame(player, actualPlayerAnimationEvent.getPlayer());
  }
}

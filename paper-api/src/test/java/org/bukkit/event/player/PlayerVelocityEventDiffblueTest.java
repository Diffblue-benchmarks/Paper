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
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerVelocityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerVelocityEvent#PlayerVelocityEvent(Player, Vector)}
   *   <li>{@link PlayerVelocityEvent#setCancelled(boolean)}
   *   <li>{@link PlayerVelocityEvent#getHandlerList()}
   *   <li>{@link PlayerVelocityEvent#getHandlers()}
   *   <li>{@link PlayerVelocityEvent#getVelocity()}
   *   <li>{@link PlayerVelocityEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerVelocityEvent.<init>(Player, Vector)",
    "HandlerList PlayerVelocityEvent.getHandlerList()",
    "HandlerList PlayerVelocityEvent.getHandlers()",
    "Vector PlayerVelocityEvent.getVelocity()",
    "boolean PlayerVelocityEvent.isCancelled()",
    "void PlayerVelocityEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Vector velocity = Vector.getRandom();

    // Act
    PlayerVelocityEvent actualPlayerVelocityEvent = new PlayerVelocityEvent(player, velocity);
    actualPlayerVelocityEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerVelocityEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerVelocityEvent.getHandlers();
    Vector actualVelocity = actualPlayerVelocityEvent.getVelocity();
    boolean actualIsCancelledResult = actualPlayerVelocityEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerVelocityEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(velocity, actualVelocity);
    assertSame(player, actualPlayerVelocityEvent.getPlayer());
  }

  /**
   * Test {@link PlayerVelocityEvent#setVelocity(Vector)}.
   *
   * <p>Method under test: {@link PlayerVelocityEvent#setVelocity(Vector)}
   */
  @Test
  @DisplayName("Test setVelocity(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerVelocityEvent.setVelocity(Vector)"})
  void testSetVelocity() {
    // Arrange
    PlayerVelocityEvent playerVelocityEvent =
        new PlayerVelocityEvent(mock(Player.class), Vector.getRandom());
    Vector velocity = Vector.getRandom();

    // Act
    playerVelocityEvent.setVelocity(velocity);

    // Assert
    assertEquals(velocity, playerVelocityEvent.getVelocity());
  }

  /**
   * Test {@link PlayerVelocityEvent#setVelocity(Vector)}.
   *
   * <p>Method under test: {@link PlayerVelocityEvent#setVelocity(Vector)}
   */
  @Test
  @DisplayName("Test setVelocity(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerVelocityEvent.setVelocity(Vector)"})
  void testSetVelocity2() {
    // Arrange
    PlayerVelocityEvent playerVelocityEvent =
        new PlayerVelocityEvent(mock(Player.class), Vector.getRandom());
    BlockVector velocity = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act
    playerVelocityEvent.setVelocity(velocity);

    // Assert
    Vector velocity2 = playerVelocityEvent.getVelocity();
    assertTrue(velocity2 instanceof BlockVector);
    assertEquals(velocity, velocity2);
  }
}

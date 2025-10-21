package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.MainHand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerChangedMainHandEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerChangedMainHandEvent#PlayerChangedMainHandEvent(Player, MainHand)}
   *   <li>{@link PlayerChangedMainHandEvent#getHandlerList()}
   *   <li>{@link PlayerChangedMainHandEvent#getHandlers()}
   *   <li>{@link PlayerChangedMainHandEvent#getNewMainHand()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerChangedMainHandEvent.<init>(Player, MainHand)",
    "HandlerList PlayerChangedMainHandEvent.getHandlerList()",
    "HandlerList PlayerChangedMainHandEvent.getHandlers()",
    "MainHand PlayerChangedMainHandEvent.getNewMainHand()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerChangedMainHandEvent actualPlayerChangedMainHandEvent =
        new PlayerChangedMainHandEvent(player, MainHand.LEFT);
    HandlerList actualHandlerList = actualPlayerChangedMainHandEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerChangedMainHandEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(MainHand.LEFT, actualPlayerChangedMainHandEvent.getNewMainHand());
    assertFalse(actualPlayerChangedMainHandEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerChangedMainHandEvent.getPlayer());
  }

  /**
   * Test {@link PlayerChangedMainHandEvent#getMainHand()}.
   *
   * <ul>
   *   <li>Then return {@code LEFT}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerChangedMainHandEvent#getMainHand()}
   */
  @Test
  @DisplayName("Test getMainHand(); then return 'LEFT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MainHand PlayerChangedMainHandEvent.getMainHand()"})
  void testGetMainHand_thenReturnLeft() {
    // Arrange, Act and Assert
    assertEquals(
        MainHand.LEFT,
        new PlayerChangedMainHandEvent(mock(Player.class), MainHand.RIGHT).getMainHand());
  }

  /**
   * Test {@link PlayerChangedMainHandEvent#getMainHand()}.
   *
   * <ul>
   *   <li>Then return {@code RIGHT}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerChangedMainHandEvent#getMainHand()}
   */
  @Test
  @DisplayName("Test getMainHand(); then return 'RIGHT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MainHand PlayerChangedMainHandEvent.getMainHand()"})
  void testGetMainHand_thenReturnRight() {
    // Arrange, Act and Assert
    assertEquals(
        MainHand.RIGHT,
        new PlayerChangedMainHandEvent(mock(Player.class), MainHand.LEFT).getMainHand());
  }
}

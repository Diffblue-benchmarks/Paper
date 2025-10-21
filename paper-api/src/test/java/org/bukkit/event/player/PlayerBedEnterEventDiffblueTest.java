package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Result;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerBedEnterEventDiffblueTest {
  /**
   * Test {@link PlayerBedEnterEvent#PlayerBedEnterEvent(Player, Block)}.
   *
   * <p>Method under test: {@link PlayerBedEnterEvent#PlayerBedEnterEvent(Player, Block)}
   */
  @Test
  @DisplayName("Test new PlayerBedEnterEvent(Player, Block)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerBedEnterEvent.<init>(Player, Block)"})
  void testNewPlayerBedEnterEvent() {
    // Arrange
    Player player = mock(Player.class);
    Block bed = mock(Block.class);

    // Act
    PlayerBedEnterEvent actualPlayerBedEnterEvent = new PlayerBedEnterEvent(player, bed);

    // Assert
    assertEquals("PlayerBedEnterEvent", actualPlayerBedEnterEvent.getEventName());
    assertEquals(0, actualPlayerBedEnterEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Result.DEFAULT, actualPlayerBedEnterEvent.useBed());
    assertEquals(BedEnterResult.OK, actualPlayerBedEnterEvent.getBedEnterResult());
    assertFalse(actualPlayerBedEnterEvent.isAsynchronous());
    assertFalse(actualPlayerBedEnterEvent.isCancelled());
    assertSame(bed, actualPlayerBedEnterEvent.getBed());
    assertSame(player, actualPlayerBedEnterEvent.getPlayer());
  }

  /**
   * Test {@link PlayerBedEnterEvent#PlayerBedEnterEvent(Player, Block, BedEnterResult)}.
   *
   * <p>Method under test: {@link PlayerBedEnterEvent#PlayerBedEnterEvent(Player, Block,
   * BedEnterResult)}
   */
  @Test
  @DisplayName("Test new PlayerBedEnterEvent(Player, Block, BedEnterResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerBedEnterEvent.<init>(Player, Block, BedEnterResult)"})
  void testNewPlayerBedEnterEvent2() {
    // Arrange
    Player player = mock(Player.class);
    Block bed = mock(Block.class);

    // Act
    PlayerBedEnterEvent actualPlayerBedEnterEvent =
        new PlayerBedEnterEvent(player, bed, BedEnterResult.OK);

    // Assert
    assertEquals("PlayerBedEnterEvent", actualPlayerBedEnterEvent.getEventName());
    assertEquals(0, actualPlayerBedEnterEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Result.DEFAULT, actualPlayerBedEnterEvent.useBed());
    assertEquals(BedEnterResult.OK, actualPlayerBedEnterEvent.getBedEnterResult());
    assertFalse(actualPlayerBedEnterEvent.isAsynchronous());
    assertFalse(actualPlayerBedEnterEvent.isCancelled());
    assertSame(bed, actualPlayerBedEnterEvent.getBed());
    assertSame(player, actualPlayerBedEnterEvent.getPlayer());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerBedEnterEvent#setUseBed(Result)}
   *   <li>{@link PlayerBedEnterEvent#getHandlerList()}
   *   <li>{@link PlayerBedEnterEvent#getBed()}
   *   <li>{@link PlayerBedEnterEvent#getBedEnterResult()}
   *   <li>{@link PlayerBedEnterEvent#getHandlers()}
   *   <li>{@link PlayerBedEnterEvent#useBed()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Block PlayerBedEnterEvent.getBed()",
    "BedEnterResult PlayerBedEnterEvent.getBedEnterResult()",
    "HandlerList PlayerBedEnterEvent.getHandlerList()",
    "HandlerList PlayerBedEnterEvent.getHandlers()",
    "void PlayerBedEnterEvent.setUseBed(Result)",
    "Result PlayerBedEnterEvent.useBed()"
  })
  void testGettersAndSetters() {
    // Arrange
    PlayerBedEnterEvent playerBedEnterEvent =
        new PlayerBedEnterEvent(mock(Player.class), mock(Block.class));

    // Act
    playerBedEnterEvent.setUseBed(Result.DENY);
    HandlerList actualHandlerList = playerBedEnterEvent.getHandlerList();
    playerBedEnterEvent.getBed();
    BedEnterResult actualBedEnterResult = playerBedEnterEvent.getBedEnterResult();
    HandlerList actualHandlers = playerBedEnterEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Result.DENY, playerBedEnterEvent.useBed());
    assertEquals(BedEnterResult.OK, actualBedEnterResult);
    assertSame(actualHandlerList, actualHandlers);
  }

  /**
   * Test {@link PlayerBedEnterEvent#isCancelled()}.
   *
   * <p>Method under test: {@link PlayerBedEnterEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerBedEnterEvent.isCancelled()"})
  void testIsCancelled() {
    // Arrange
    PlayerBedEnterEvent playerBedEnterEvent =
        new PlayerBedEnterEvent(
            mock(Player.class), mock(Block.class), BedEnterResult.NOT_POSSIBLE_HERE);

    // Act and Assert
    assertTrue(playerBedEnterEvent.isCancelled());
  }

  /**
   * Test {@link PlayerBedEnterEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Given {@link PlayerBedEnterEvent#PlayerBedEnterEvent(Player, Block)} with {@link Player}
   *       and bed is {@link Block} UseBed is {@code ALLOW}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBedEnterEvent#isCancelled()}
   */
  @Test
  @DisplayName(
      "Test isCancelled(); given PlayerBedEnterEvent(Player, Block) with Player and bed is Block UseBed is 'ALLOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerBedEnterEvent.isCancelled()"})
  void testIsCancelled_givenPlayerBedEnterEventWithPlayerAndBedIsBlockUseBedIsAllow() {
    // Arrange
    PlayerBedEnterEvent playerBedEnterEvent =
        new PlayerBedEnterEvent(mock(Player.class), mock(Block.class));
    playerBedEnterEvent.setUseBed(Result.ALLOW);

    // Act and Assert
    assertFalse(playerBedEnterEvent.isCancelled());
  }

  /**
   * Test {@link PlayerBedEnterEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Given {@link PlayerBedEnterEvent#PlayerBedEnterEvent(Player, Block)} with {@link Player}
   *       and bed is {@link Block} UseBed is {@code DENY}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBedEnterEvent#isCancelled()}
   */
  @Test
  @DisplayName(
      "Test isCancelled(); given PlayerBedEnterEvent(Player, Block) with Player and bed is Block UseBed is 'DENY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerBedEnterEvent.isCancelled()"})
  void testIsCancelled_givenPlayerBedEnterEventWithPlayerAndBedIsBlockUseBedIsDeny() {
    // Arrange
    PlayerBedEnterEvent playerBedEnterEvent =
        new PlayerBedEnterEvent(mock(Player.class), mock(Block.class));
    playerBedEnterEvent.setUseBed(Result.DENY);

    // Act and Assert
    assertTrue(playerBedEnterEvent.isCancelled());
  }

  /**
   * Test {@link PlayerBedEnterEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Given {@link PlayerBedEnterEvent#PlayerBedEnterEvent(Player, Block)} with {@link Player}
   *       and bed is {@link Block}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBedEnterEvent#isCancelled()}
   */
  @Test
  @DisplayName(
      "Test isCancelled(); given PlayerBedEnterEvent(Player, Block) with Player and bed is Block; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerBedEnterEvent.isCancelled()"})
  void testIsCancelled_givenPlayerBedEnterEventWithPlayerAndBedIsBlock_thenReturnFalse() {
    // Arrange
    PlayerBedEnterEvent playerBedEnterEvent =
        new PlayerBedEnterEvent(mock(Player.class), mock(Block.class));

    // Act and Assert
    assertFalse(playerBedEnterEvent.isCancelled());
  }

  /**
   * Test {@link PlayerBedEnterEvent#setCancelled(boolean)}.
   *
   * <ul>
   *   <li>Given {@link PlayerBedEnterEvent#PlayerBedEnterEvent(Player, Block)} with {@link Player}
   *       and bed is {@link Block} UseBed is {@code DEFAULT}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBedEnterEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName(
      "Test setCancelled(boolean); given PlayerBedEnterEvent(Player, Block) with Player and bed is Block UseBed is 'DEFAULT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerBedEnterEvent.setCancelled(boolean)"})
  void testSetCancelled_givenPlayerBedEnterEventWithPlayerAndBedIsBlockUseBedIsDefault() {
    // Arrange
    PlayerBedEnterEvent playerBedEnterEvent =
        new PlayerBedEnterEvent(mock(Player.class), mock(Block.class));
    playerBedEnterEvent.setUseBed(Result.DEFAULT);

    // Act
    playerBedEnterEvent.setCancelled(false);

    // Assert that nothing has changed
    assertEquals(Result.DEFAULT, playerBedEnterEvent.useBed());
    assertFalse(playerBedEnterEvent.isCancelled());
  }

  /**
   * Test {@link PlayerBedEnterEvent#setCancelled(boolean)}.
   *
   * <ul>
   *   <li>Given {@link PlayerBedEnterEvent#PlayerBedEnterEvent(Player, Block)} with {@link Player}
   *       and bed is {@link Block} UseBed is {@link Result#DENY}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBedEnterEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName(
      "Test setCancelled(boolean); given PlayerBedEnterEvent(Player, Block) with Player and bed is Block UseBed is DENY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerBedEnterEvent.setCancelled(boolean)"})
  void testSetCancelled_givenPlayerBedEnterEventWithPlayerAndBedIsBlockUseBedIsDeny() {
    // Arrange
    PlayerBedEnterEvent playerBedEnterEvent =
        new PlayerBedEnterEvent(mock(Player.class), mock(Block.class));
    playerBedEnterEvent.setUseBed(Result.DENY);

    // Act
    playerBedEnterEvent.setCancelled(false);

    // Assert
    assertEquals(Result.DEFAULT, playerBedEnterEvent.useBed());
    assertFalse(playerBedEnterEvent.isCancelled());
  }

  /**
   * Test {@link PlayerBedEnterEvent#setCancelled(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PlayerBedEnterEvent#PlayerBedEnterEvent(Player, Block)} with {@link Player}
   *       and bed is {@link Block} useBed is {@code DENY}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBedEnterEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName(
      "Test setCancelled(boolean); then PlayerBedEnterEvent(Player, Block) with Player and bed is Block useBed is 'DENY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerBedEnterEvent.setCancelled(boolean)"})
  void testSetCancelled_thenPlayerBedEnterEventWithPlayerAndBedIsBlockUseBedIsDeny() {
    // Arrange
    PlayerBedEnterEvent playerBedEnterEvent =
        new PlayerBedEnterEvent(mock(Player.class), mock(Block.class));

    // Act
    playerBedEnterEvent.setCancelled(true);

    // Assert
    assertEquals(Result.DENY, playerBedEnterEvent.useBed());
    assertTrue(playerBedEnterEvent.isCancelled());
  }
}

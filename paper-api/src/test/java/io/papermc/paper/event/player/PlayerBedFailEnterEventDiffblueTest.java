package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.event.player.PlayerBedFailEnterEvent.FailReason;
import net.kyori.adventure.text.Component;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerBedFailEnterEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerBedFailEnterEvent#PlayerBedFailEnterEvent(Player, FailReason, Block,
   *       boolean, Component)}
   *   <li>{@link PlayerBedFailEnterEvent#setCancelled(boolean)}
   *   <li>{@link PlayerBedFailEnterEvent#setMessage(Component)}
   *   <li>{@link PlayerBedFailEnterEvent#setWillExplode(boolean)}
   *   <li>{@link PlayerBedFailEnterEvent#getHandlerList()}
   *   <li>{@link PlayerBedFailEnterEvent#getBed()}
   *   <li>{@link PlayerBedFailEnterEvent#getFailReason()}
   *   <li>{@link PlayerBedFailEnterEvent#getHandlers()}
   *   <li>{@link PlayerBedFailEnterEvent#getMessage()}
   *   <li>{@link PlayerBedFailEnterEvent#getWillExplode()}
   *   <li>{@link PlayerBedFailEnterEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerBedFailEnterEvent.<init>(Player, FailReason, Block, boolean, Component)",
    "Block PlayerBedFailEnterEvent.getBed()",
    "FailReason PlayerBedFailEnterEvent.getFailReason()",
    "HandlerList PlayerBedFailEnterEvent.getHandlerList()",
    "HandlerList PlayerBedFailEnterEvent.getHandlers()",
    "Component PlayerBedFailEnterEvent.getMessage()",
    "boolean PlayerBedFailEnterEvent.getWillExplode()",
    "boolean PlayerBedFailEnterEvent.isCancelled()",
    "void PlayerBedFailEnterEvent.setCancelled(boolean)",
    "void PlayerBedFailEnterEvent.setMessage(Component)",
    "void PlayerBedFailEnterEvent.setWillExplode(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Block bed = mock(Block.class);

    // Act
    PlayerBedFailEnterEvent actualPlayerBedFailEnterEvent =
        new PlayerBedFailEnterEvent(
            player, FailReason.NOT_POSSIBLE_HERE, bed, true, mock(Component.class));
    actualPlayerBedFailEnterEvent.setCancelled(true);
    Component message = mock(Component.class);
    actualPlayerBedFailEnterEvent.setMessage(message);
    actualPlayerBedFailEnterEvent.setWillExplode(true);
    HandlerList actualHandlerList = actualPlayerBedFailEnterEvent.getHandlerList();
    Block actualBed = actualPlayerBedFailEnterEvent.getBed();
    FailReason actualFailReason = actualPlayerBedFailEnterEvent.getFailReason();
    HandlerList actualHandlers = actualPlayerBedFailEnterEvent.getHandlers();
    Component actualMessage = actualPlayerBedFailEnterEvent.getMessage();
    boolean actualWillExplode = actualPlayerBedFailEnterEvent.getWillExplode();
    boolean actualIsCancelledResult = actualPlayerBedFailEnterEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(FailReason.NOT_POSSIBLE_HERE, actualFailReason);
    assertFalse(actualPlayerBedFailEnterEvent.isAsynchronous());
    assertTrue(actualWillExplode);
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(message, actualMessage);
    assertSame(bed, actualBed);
    assertSame(player, actualPlayerBedFailEnterEvent.getPlayer());
  }
}

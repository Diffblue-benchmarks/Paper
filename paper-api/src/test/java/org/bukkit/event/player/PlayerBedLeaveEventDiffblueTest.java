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
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerBedLeaveEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerBedLeaveEvent#PlayerBedLeaveEvent(Player, Block, boolean)}
   *   <li>{@link PlayerBedLeaveEvent#setCancelled(boolean)}
   *   <li>{@link PlayerBedLeaveEvent#setSpawnLocation(boolean)}
   *   <li>{@link PlayerBedLeaveEvent#getHandlerList()}
   *   <li>{@link PlayerBedLeaveEvent#getBed()}
   *   <li>{@link PlayerBedLeaveEvent#getHandlers()}
   *   <li>{@link PlayerBedLeaveEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerBedLeaveEvent.<init>(Player, Block, boolean)",
    "Block PlayerBedLeaveEvent.getBed()",
    "HandlerList PlayerBedLeaveEvent.getHandlerList()",
    "HandlerList PlayerBedLeaveEvent.getHandlers()",
    "boolean PlayerBedLeaveEvent.isCancelled()",
    "void PlayerBedLeaveEvent.setCancelled(boolean)",
    "void PlayerBedLeaveEvent.setSpawnLocation(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Block bed = mock(Block.class);

    // Act
    PlayerBedLeaveEvent actualPlayerBedLeaveEvent = new PlayerBedLeaveEvent(player, bed, true);
    actualPlayerBedLeaveEvent.setCancelled(true);
    actualPlayerBedLeaveEvent.setSpawnLocation(true);
    HandlerList actualHandlerList = actualPlayerBedLeaveEvent.getHandlerList();
    Block actualBed = actualPlayerBedLeaveEvent.getBed();
    HandlerList actualHandlers = actualPlayerBedLeaveEvent.getHandlers();
    boolean actualIsCancelledResult = actualPlayerBedLeaveEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerBedLeaveEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(bed, actualBed);
    assertSame(player, actualPlayerBedLeaveEvent.getPlayer());
  }

  /**
   * Test {@link PlayerBedLeaveEvent#shouldSetSpawnLocation()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBedLeaveEvent#shouldSetSpawnLocation()}
   */
  @Test
  @DisplayName("Test shouldSetSpawnLocation(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerBedLeaveEvent.shouldSetSpawnLocation()"})
  void testShouldSetSpawnLocation_thenReturnFalse() {
    // Arrange
    PlayerBedLeaveEvent playerBedLeaveEvent =
        new PlayerBedLeaveEvent(mock(Player.class), mock(Block.class), false);

    // Act and Assert
    assertFalse(playerBedLeaveEvent.shouldSetSpawnLocation());
  }

  /**
   * Test {@link PlayerBedLeaveEvent#shouldSetSpawnLocation()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerBedLeaveEvent#shouldSetSpawnLocation()}
   */
  @Test
  @DisplayName("Test shouldSetSpawnLocation(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerBedLeaveEvent.shouldSetSpawnLocation()"})
  void testShouldSetSpawnLocation_thenReturnTrue() {
    // Arrange
    PlayerBedLeaveEvent playerBedLeaveEvent =
        new PlayerBedLeaveEvent(mock(Player.class), mock(Block.class), true);

    // Act and Assert
    assertTrue(playerBedLeaveEvent.shouldSetSpawnLocation());
  }
}

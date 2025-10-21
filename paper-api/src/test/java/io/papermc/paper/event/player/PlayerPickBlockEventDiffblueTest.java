package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerPickBlockEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerPickBlockEvent#PlayerPickBlockEvent(Player, Block, boolean, int, int)}
   *   <li>{@link PlayerPickBlockEvent#getBlock()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerPickBlockEvent.<init>(Player, Block, boolean, int, int)",
    "Block PlayerPickBlockEvent.getBlock()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Block block = mock(Block.class);

    // Act
    PlayerPickBlockEvent actualPlayerPickBlockEvent =
        new PlayerPickBlockEvent(player, block, true, 1, 1);
    Block actualBlock = actualPlayerPickBlockEvent.getBlock();

    // Assert
    assertEquals(1, actualPlayerPickBlockEvent.getSourceSlot());
    assertEquals(1, actualPlayerPickBlockEvent.getTargetSlot());
    assertFalse(actualPlayerPickBlockEvent.isCancelled());
    assertFalse(actualPlayerPickBlockEvent.isAsynchronous());
    assertTrue(actualPlayerPickBlockEvent.isIncludeData());
    assertSame(block, actualBlock);
    assertSame(player, actualPlayerPickBlockEvent.getPlayer());
  }
}

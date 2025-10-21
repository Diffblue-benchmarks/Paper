package org.bukkit.event.block;

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

class BlockBreakEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockBreakEvent#BlockBreakEvent(Block, Player)}
   *   <li>{@link BlockBreakEvent#setCancelled(boolean)}
   *   <li>{@link BlockBreakEvent#setDropItems(boolean)}
   *   <li>{@link BlockBreakEvent#getPlayer()}
   *   <li>{@link BlockBreakEvent#isCancelled()}
   *   <li>{@link BlockBreakEvent#isDropItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockBreakEvent.<init>(Block, Player)",
    "Player BlockBreakEvent.getPlayer()",
    "boolean BlockBreakEvent.isCancelled()",
    "boolean BlockBreakEvent.isDropItems()",
    "void BlockBreakEvent.setCancelled(boolean)",
    "void BlockBreakEvent.setDropItems(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    Player player = mock(Player.class);

    // Act
    BlockBreakEvent actualBlockBreakEvent = new BlockBreakEvent(block, player);
    actualBlockBreakEvent.setCancelled(true);
    actualBlockBreakEvent.setDropItems(true);
    Player actualPlayer = actualBlockBreakEvent.getPlayer();
    boolean actualIsCancelledResult = actualBlockBreakEvent.isCancelled();
    boolean actualIsDropItemsResult = actualBlockBreakEvent.isDropItems();

    // Assert
    assertEquals(0, actualBlockBreakEvent.getExpToDrop());
    assertFalse(actualBlockBreakEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsDropItemsResult);
    assertSame(block, actualBlockBreakEvent.getBlock());
    assertSame(player, actualPlayer);
  }
}

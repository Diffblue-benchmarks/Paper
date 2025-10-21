package io.papermc.paper.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockBreakBlockEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockBreakBlockEvent#BlockBreakBlockEvent(Block, Block, List)}
   *   <li>{@link BlockBreakBlockEvent#getHandlerList()}
   *   <li>{@link BlockBreakBlockEvent#getDrops()}
   *   <li>{@link BlockBreakBlockEvent#getHandlers()}
   *   <li>{@link BlockBreakBlockEvent#getSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockBreakBlockEvent.<init>(Block, Block, List)",
    "List BlockBreakBlockEvent.getDrops()",
    "HandlerList BlockBreakBlockEvent.getHandlerList()",
    "HandlerList BlockBreakBlockEvent.getHandlers()",
    "Block BlockBreakBlockEvent.getSource()"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    Block source = mock(Block.class);
    ArrayList<ItemStack> drops = new ArrayList<>();

    // Act
    BlockBreakBlockEvent actualBlockBreakBlockEvent =
        new BlockBreakBlockEvent(block, source, drops);
    HandlerList actualHandlerList = actualBlockBreakBlockEvent.getHandlerList();
    List<ItemStack> actualDrops = actualBlockBreakBlockEvent.getDrops();
    HandlerList actualHandlers = actualBlockBreakBlockEvent.getHandlers();
    Block actualSource = actualBlockBreakBlockEvent.getSource();

    // Assert
    assertEquals(0, actualBlockBreakBlockEvent.getExpToDrop());
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBlockBreakBlockEvent.isAsynchronous());
    assertTrue(actualDrops.isEmpty());
    assertSame(drops, actualDrops);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(source, actualSource);
    assertSame(block, actualBlockBreakBlockEvent.getBlock());
  }
}

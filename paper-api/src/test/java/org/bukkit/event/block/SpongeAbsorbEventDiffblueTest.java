package org.bukkit.event.block;

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
import org.bukkit.block.BlockState;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SpongeAbsorbEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SpongeAbsorbEvent#SpongeAbsorbEvent(Block, List)}
   *   <li>{@link SpongeAbsorbEvent#setCancelled(boolean)}
   *   <li>{@link SpongeAbsorbEvent#getHandlerList()}
   *   <li>{@link SpongeAbsorbEvent#getBlocks()}
   *   <li>{@link SpongeAbsorbEvent#getHandlers()}
   *   <li>{@link SpongeAbsorbEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SpongeAbsorbEvent.<init>(Block, List)",
    "List SpongeAbsorbEvent.getBlocks()",
    "HandlerList SpongeAbsorbEvent.getHandlerList()",
    "HandlerList SpongeAbsorbEvent.getHandlers()",
    "boolean SpongeAbsorbEvent.isCancelled()",
    "void SpongeAbsorbEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    ArrayList<BlockState> waterblocks = new ArrayList<>();

    // Act
    SpongeAbsorbEvent actualSpongeAbsorbEvent = new SpongeAbsorbEvent(block, waterblocks);
    actualSpongeAbsorbEvent.setCancelled(true);
    HandlerList actualHandlerList = actualSpongeAbsorbEvent.getHandlerList();
    List<BlockState> actualBlocks = actualSpongeAbsorbEvent.getBlocks();
    HandlerList actualHandlers = actualSpongeAbsorbEvent.getHandlers();
    boolean actualIsCancelledResult = actualSpongeAbsorbEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualSpongeAbsorbEvent.isAsynchronous());
    assertTrue(actualBlocks.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(waterblocks, actualBlocks);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualSpongeAbsorbEvent.getBlock());
  }
}

package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockRedstoneEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockRedstoneEvent#BlockRedstoneEvent(Block, int, int)}
   *   <li>{@link BlockRedstoneEvent#setNewCurrent(int)}
   *   <li>{@link BlockRedstoneEvent#getHandlerList()}
   *   <li>{@link BlockRedstoneEvent#getHandlers()}
   *   <li>{@link BlockRedstoneEvent#getNewCurrent()}
   *   <li>{@link BlockRedstoneEvent#getOldCurrent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockRedstoneEvent.<init>(Block, int, int)",
    "HandlerList BlockRedstoneEvent.getHandlerList()",
    "HandlerList BlockRedstoneEvent.getHandlers()",
    "int BlockRedstoneEvent.getNewCurrent()",
    "int BlockRedstoneEvent.getOldCurrent()",
    "void BlockRedstoneEvent.setNewCurrent(int)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);

    // Act
    BlockRedstoneEvent actualBlockRedstoneEvent = new BlockRedstoneEvent(block, 1, 1);
    actualBlockRedstoneEvent.setNewCurrent(1);
    HandlerList actualHandlerList = actualBlockRedstoneEvent.getHandlerList();
    HandlerList actualHandlers = actualBlockRedstoneEvent.getHandlers();
    int actualNewCurrent = actualBlockRedstoneEvent.getNewCurrent();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualNewCurrent);
    assertEquals(1, actualBlockRedstoneEvent.getOldCurrent());
    assertFalse(actualBlockRedstoneEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockRedstoneEvent.getBlock());
  }
}

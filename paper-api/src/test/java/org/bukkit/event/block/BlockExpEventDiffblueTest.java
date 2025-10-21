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

class BlockExpEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockExpEvent#BlockExpEvent(Block, int)}
   *   <li>{@link BlockExpEvent#setExpToDrop(int)}
   *   <li>{@link BlockExpEvent#getHandlerList()}
   *   <li>{@link BlockExpEvent#getExpToDrop()}
   *   <li>{@link BlockExpEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockExpEvent.<init>(Block, int)",
    "int BlockExpEvent.getExpToDrop()",
    "HandlerList BlockExpEvent.getHandlerList()",
    "HandlerList BlockExpEvent.getHandlers()",
    "void BlockExpEvent.setExpToDrop(int)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);

    // Act
    BlockExpEvent actualBlockExpEvent = new BlockExpEvent(block, 1);
    actualBlockExpEvent.setExpToDrop(1);
    HandlerList actualHandlerList = actualBlockExpEvent.getHandlerList();
    int actualExpToDrop = actualBlockExpEvent.getExpToDrop();
    HandlerList actualHandlers = actualBlockExpEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualExpToDrop);
    assertFalse(actualBlockExpEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockExpEvent.getBlock());
  }
}

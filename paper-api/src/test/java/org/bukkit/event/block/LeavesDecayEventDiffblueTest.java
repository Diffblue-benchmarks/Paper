package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LeavesDecayEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LeavesDecayEvent#LeavesDecayEvent(Block)}
   *   <li>{@link LeavesDecayEvent#setCancelled(boolean)}
   *   <li>{@link LeavesDecayEvent#getHandlerList()}
   *   <li>{@link LeavesDecayEvent#getHandlers()}
   *   <li>{@link LeavesDecayEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LeavesDecayEvent.<init>(Block)",
    "HandlerList LeavesDecayEvent.getHandlerList()",
    "HandlerList LeavesDecayEvent.getHandlers()",
    "boolean LeavesDecayEvent.isCancelled()",
    "void LeavesDecayEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);

    // Act
    LeavesDecayEvent actualLeavesDecayEvent = new LeavesDecayEvent(block);
    actualLeavesDecayEvent.setCancelled(true);
    HandlerList actualHandlerList = actualLeavesDecayEvent.getHandlerList();
    HandlerList actualHandlers = actualLeavesDecayEvent.getHandlers();
    boolean actualIsCancelledResult = actualLeavesDecayEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualLeavesDecayEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualLeavesDecayEvent.getBlock());
  }
}

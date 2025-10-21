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

class SculkBloomEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SculkBloomEvent#SculkBloomEvent(Block, int)}
   *   <li>{@link SculkBloomEvent#setCancelled(boolean)}
   *   <li>{@link SculkBloomEvent#getHandlerList()}
   *   <li>{@link SculkBloomEvent#getCharge()}
   *   <li>{@link SculkBloomEvent#getHandlers()}
   *   <li>{@link SculkBloomEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SculkBloomEvent.<init>(Block, int)",
    "int SculkBloomEvent.getCharge()",
    "HandlerList SculkBloomEvent.getHandlerList()",
    "HandlerList SculkBloomEvent.getHandlers()",
    "boolean SculkBloomEvent.isCancelled()",
    "void SculkBloomEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);

    // Act
    SculkBloomEvent actualSculkBloomEvent = new SculkBloomEvent(block, 1);
    actualSculkBloomEvent.setCancelled(true);
    HandlerList actualHandlerList = actualSculkBloomEvent.getHandlerList();
    int actualCharge = actualSculkBloomEvent.getCharge();
    HandlerList actualHandlers = actualSculkBloomEvent.getHandlers();
    boolean actualIsCancelledResult = actualSculkBloomEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualCharge);
    assertFalse(actualSculkBloomEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualSculkBloomEvent.getBlock());
  }
}

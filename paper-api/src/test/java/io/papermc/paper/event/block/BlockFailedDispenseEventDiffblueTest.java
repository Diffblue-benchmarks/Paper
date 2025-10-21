package io.papermc.paper.event.block;

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

class BlockFailedDispenseEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockFailedDispenseEvent#BlockFailedDispenseEvent(Block)}
   *   <li>{@link BlockFailedDispenseEvent#shouldPlayEffect(boolean)}
   *   <li>{@link BlockFailedDispenseEvent#getHandlerList()}
   *   <li>{@link BlockFailedDispenseEvent#getHandlers()}
   *   <li>{@link BlockFailedDispenseEvent#shouldPlayEffect()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockFailedDispenseEvent.<init>(Block)",
    "HandlerList BlockFailedDispenseEvent.getHandlerList()",
    "HandlerList BlockFailedDispenseEvent.getHandlers()",
    "boolean BlockFailedDispenseEvent.shouldPlayEffect()",
    "void BlockFailedDispenseEvent.shouldPlayEffect(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);

    // Act
    BlockFailedDispenseEvent actualBlockFailedDispenseEvent = new BlockFailedDispenseEvent(block);
    actualBlockFailedDispenseEvent.shouldPlayEffect(true);
    HandlerList actualHandlerList = actualBlockFailedDispenseEvent.getHandlerList();
    HandlerList actualHandlers = actualBlockFailedDispenseEvent.getHandlers();
    boolean actualShouldPlayEffectResult = actualBlockFailedDispenseEvent.shouldPlayEffect();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBlockFailedDispenseEvent.isAsynchronous());
    assertTrue(actualShouldPlayEffectResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockFailedDispenseEvent.getBlock());
  }
}

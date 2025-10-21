package io.papermc.paper.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockBreakProgressUpdateEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockBreakProgressUpdateEvent#BlockBreakProgressUpdateEvent(Block, float, Entity)}
   *   <li>{@link BlockBreakProgressUpdateEvent#getHandlerList()}
   *   <li>{@link BlockBreakProgressUpdateEvent#getEntity()}
   *   <li>{@link BlockBreakProgressUpdateEvent#getHandlers()}
   *   <li>{@link BlockBreakProgressUpdateEvent#getProgress()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockBreakProgressUpdateEvent.<init>(Block, float, Entity)",
    "Entity BlockBreakProgressUpdateEvent.getEntity()",
    "HandlerList BlockBreakProgressUpdateEvent.getHandlerList()",
    "HandlerList BlockBreakProgressUpdateEvent.getHandlers()",
    "float BlockBreakProgressUpdateEvent.getProgress()"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    Entity entity = mock(Entity.class);

    // Act
    BlockBreakProgressUpdateEvent actualBlockBreakProgressUpdateEvent =
        new BlockBreakProgressUpdateEvent(block, 10.0f, entity);
    HandlerList actualHandlerList = actualBlockBreakProgressUpdateEvent.getHandlerList();
    Entity actualEntity = actualBlockBreakProgressUpdateEvent.getEntity();
    HandlerList actualHandlers = actualBlockBreakProgressUpdateEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10.0f, actualBlockBreakProgressUpdateEvent.getProgress());
    assertFalse(actualBlockBreakProgressUpdateEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockBreakProgressUpdateEvent.getBlock());
    assertSame(entity, actualEntity);
  }
}

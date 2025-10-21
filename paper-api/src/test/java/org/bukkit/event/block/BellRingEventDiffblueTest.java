package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BellRingEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BellRingEvent#BellRingEvent(Block, BlockFace, Entity)}
   *   <li>{@link BellRingEvent#setCancelled(boolean)}
   *   <li>{@link BellRingEvent#getHandlerList()}
   *   <li>{@link BellRingEvent#getDirection()}
   *   <li>{@link BellRingEvent#getEntity()}
   *   <li>{@link BellRingEvent#getHandlers()}
   *   <li>{@link BellRingEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BellRingEvent.<init>(Block, BlockFace, Entity)",
    "BlockFace BellRingEvent.getDirection()",
    "Entity BellRingEvent.getEntity()",
    "HandlerList BellRingEvent.getHandlerList()",
    "HandlerList BellRingEvent.getHandlers()",
    "boolean BellRingEvent.isCancelled()",
    "void BellRingEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    Entity entity = mock(Entity.class);

    // Act
    BellRingEvent actualBellRingEvent = new BellRingEvent(block, BlockFace.NORTH, entity);
    actualBellRingEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBellRingEvent.getHandlerList();
    BlockFace actualDirection = actualBellRingEvent.getDirection();
    Entity actualEntity = actualBellRingEvent.getEntity();
    HandlerList actualHandlers = actualBellRingEvent.getHandlers();
    boolean actualIsCancelledResult = actualBellRingEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(BlockFace.NORTH, actualDirection);
    assertFalse(actualBellRingEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBellRingEvent.getBlock());
    assertSame(entity, actualEntity);
  }
}

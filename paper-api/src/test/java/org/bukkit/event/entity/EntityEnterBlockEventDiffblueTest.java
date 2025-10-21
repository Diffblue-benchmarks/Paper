package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityEnterBlockEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityEnterBlockEvent#EntityEnterBlockEvent(Entity, Block)}
   *   <li>{@link EntityEnterBlockEvent#setCancelled(boolean)}
   *   <li>{@link EntityEnterBlockEvent#getHandlerList()}
   *   <li>{@link EntityEnterBlockEvent#getBlock()}
   *   <li>{@link EntityEnterBlockEvent#getHandlers()}
   *   <li>{@link EntityEnterBlockEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityEnterBlockEvent.<init>(Entity, Block)",
    "Block EntityEnterBlockEvent.getBlock()",
    "HandlerList EntityEnterBlockEvent.getHandlerList()",
    "HandlerList EntityEnterBlockEvent.getHandlers()",
    "boolean EntityEnterBlockEvent.isCancelled()",
    "void EntityEnterBlockEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Block block = mock(Block.class);

    // Act
    EntityEnterBlockEvent actualEntityEnterBlockEvent = new EntityEnterBlockEvent(entity, block);
    actualEntityEnterBlockEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityEnterBlockEvent.getHandlerList();
    Block actualBlock = actualEntityEnterBlockEvent.getBlock();
    HandlerList actualHandlers = actualEntityEnterBlockEvent.getHandlers();
    boolean actualIsCancelledResult = actualEntityEnterBlockEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityEnterBlockEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlock);
    assertSame(entity, actualEntityEnterBlockEvent.getEntity());
  }
}

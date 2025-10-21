package io.papermc.paper.event.entity;

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

class EntityInsideBlockEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityInsideBlockEvent#EntityInsideBlockEvent(Entity, Block)}
   *   <li>{@link EntityInsideBlockEvent#setCancelled(boolean)}
   *   <li>{@link EntityInsideBlockEvent#getHandlerList()}
   *   <li>{@link EntityInsideBlockEvent#getBlock()}
   *   <li>{@link EntityInsideBlockEvent#getHandlers()}
   *   <li>{@link EntityInsideBlockEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityInsideBlockEvent.<init>(Entity, Block)",
    "Block EntityInsideBlockEvent.getBlock()",
    "HandlerList EntityInsideBlockEvent.getHandlerList()",
    "HandlerList EntityInsideBlockEvent.getHandlers()",
    "boolean EntityInsideBlockEvent.isCancelled()",
    "void EntityInsideBlockEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Block block = mock(Block.class);

    // Act
    EntityInsideBlockEvent actualEntityInsideBlockEvent = new EntityInsideBlockEvent(entity, block);
    actualEntityInsideBlockEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityInsideBlockEvent.getHandlerList();
    Block actualBlock = actualEntityInsideBlockEvent.getBlock();
    HandlerList actualHandlers = actualEntityInsideBlockEvent.getHandlers();
    boolean actualIsCancelledResult = actualEntityInsideBlockEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityInsideBlockEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlock);
    assertSame(entity, actualEntityInsideBlockEvent.getEntity());
  }
}

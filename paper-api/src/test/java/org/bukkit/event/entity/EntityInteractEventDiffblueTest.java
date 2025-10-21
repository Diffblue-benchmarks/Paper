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

class EntityInteractEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityInteractEvent#EntityInteractEvent(Entity, Block)}
   *   <li>{@link EntityInteractEvent#setCancelled(boolean)}
   *   <li>{@link EntityInteractEvent#getHandlerList()}
   *   <li>{@link EntityInteractEvent#getBlock()}
   *   <li>{@link EntityInteractEvent#getHandlers()}
   *   <li>{@link EntityInteractEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityInteractEvent.<init>(Entity, Block)",
    "Block EntityInteractEvent.getBlock()",
    "HandlerList EntityInteractEvent.getHandlerList()",
    "HandlerList EntityInteractEvent.getHandlers()",
    "boolean EntityInteractEvent.isCancelled()",
    "void EntityInteractEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Block block = mock(Block.class);

    // Act
    EntityInteractEvent actualEntityInteractEvent = new EntityInteractEvent(entity, block);
    actualEntityInteractEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityInteractEvent.getHandlerList();
    Block actualBlock = actualEntityInteractEvent.getBlock();
    HandlerList actualHandlers = actualEntityInteractEvent.getHandlers();
    boolean actualIsCancelledResult = actualEntityInteractEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityInteractEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlock);
    assertSame(entity, actualEntityInteractEvent.getEntity());
  }
}

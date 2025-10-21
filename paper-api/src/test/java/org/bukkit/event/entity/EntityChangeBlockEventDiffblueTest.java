package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityChangeBlockEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityChangeBlockEvent#EntityChangeBlockEvent(Entity, Block, BlockData)}
   *   <li>{@link EntityChangeBlockEvent#setCancelled(boolean)}
   *   <li>{@link EntityChangeBlockEvent#getHandlerList()}
   *   <li>{@link EntityChangeBlockEvent#getBlock()}
   *   <li>{@link EntityChangeBlockEvent#getHandlers()}
   *   <li>{@link EntityChangeBlockEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityChangeBlockEvent.<init>(Entity, Block, BlockData)",
    "Block EntityChangeBlockEvent.getBlock()",
    "HandlerList EntityChangeBlockEvent.getHandlerList()",
    "HandlerList EntityChangeBlockEvent.getHandlers()",
    "boolean EntityChangeBlockEvent.isCancelled()",
    "void EntityChangeBlockEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Block block = mock(Block.class);

    // Act
    EntityChangeBlockEvent actualEntityChangeBlockEvent =
        new EntityChangeBlockEvent(entity, block, mock(BlockData.class));
    actualEntityChangeBlockEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityChangeBlockEvent.getHandlerList();
    Block actualBlock = actualEntityChangeBlockEvent.getBlock();
    HandlerList actualHandlers = actualEntityChangeBlockEvent.getHandlers();
    boolean actualIsCancelledResult = actualEntityChangeBlockEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityChangeBlockEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlock);
    assertSame(entity, actualEntityChangeBlockEvent.getEntity());
  }

  /**
   * Test {@link EntityChangeBlockEvent#getTo()}.
   *
   * <p>Method under test: {@link EntityChangeBlockEvent#getTo()}
   */
  @Test
  @DisplayName("Test getTo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Material EntityChangeBlockEvent.getTo()"})
  void testGetTo() {
    // Arrange
    BlockData resultTo = mock(BlockData.class);
    when(resultTo.getMaterial()).thenReturn(Material.ACACIA_BOAT);
    EntityChangeBlockEvent entityChangeBlockEvent =
        new EntityChangeBlockEvent(mock(Entity.class), mock(Block.class), resultTo);

    // Act
    Material actualTo = entityChangeBlockEvent.getTo();

    // Assert
    verify(resultTo).getMaterial();
    assertEquals(Material.ACACIA_BOAT, actualTo);
  }

  /**
   * Test {@link EntityChangeBlockEvent#getBlockData()}.
   *
   * <p>Method under test: {@link EntityChangeBlockEvent#getBlockData()}
   */
  @Test
  @DisplayName("Test getBlockData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockData EntityChangeBlockEvent.getBlockData()"})
  void testGetBlockData() {
    // Arrange
    EntityChangeBlockEvent entityChangeBlockEvent =
        new EntityChangeBlockEvent(mock(Entity.class), mock(Block.class), mock(BlockData.class));

    // Act and Assert
    assertNull(entityChangeBlockEvent.getBlockData());
  }
}

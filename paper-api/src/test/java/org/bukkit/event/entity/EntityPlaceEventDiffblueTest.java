package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityPlaceEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityPlaceEvent#EntityPlaceEvent(Entity, Player, Block, BlockFace,
   *       EquipmentSlot)}
   *   <li>{@link EntityPlaceEvent#setCancelled(boolean)}
   *   <li>{@link EntityPlaceEvent#getHandlerList()}
   *   <li>{@link EntityPlaceEvent#getBlock()}
   *   <li>{@link EntityPlaceEvent#getBlockFace()}
   *   <li>{@link EntityPlaceEvent#getHand()}
   *   <li>{@link EntityPlaceEvent#getHandlers()}
   *   <li>{@link EntityPlaceEvent#getPlayer()}
   *   <li>{@link EntityPlaceEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityPlaceEvent.<init>(Entity, Player, Block, BlockFace, EquipmentSlot)",
    "Block EntityPlaceEvent.getBlock()",
    "BlockFace EntityPlaceEvent.getBlockFace()",
    "EquipmentSlot EntityPlaceEvent.getHand()",
    "HandlerList EntityPlaceEvent.getHandlerList()",
    "HandlerList EntityPlaceEvent.getHandlers()",
    "Player EntityPlaceEvent.getPlayer()",
    "boolean EntityPlaceEvent.isCancelled()",
    "void EntityPlaceEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Player player = mock(Player.class);
    Block block = mock(Block.class);

    // Act
    EntityPlaceEvent actualEntityPlaceEvent =
        new EntityPlaceEvent(entity, player, block, BlockFace.NORTH, EquipmentSlot.HAND);
    actualEntityPlaceEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityPlaceEvent.getHandlerList();
    Block actualBlock = actualEntityPlaceEvent.getBlock();
    BlockFace actualBlockFace = actualEntityPlaceEvent.getBlockFace();
    EquipmentSlot actualHand = actualEntityPlaceEvent.getHand();
    HandlerList actualHandlers = actualEntityPlaceEvent.getHandlers();
    Player actualPlayer = actualEntityPlaceEvent.getPlayer();
    boolean actualIsCancelledResult = actualEntityPlaceEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(BlockFace.NORTH, actualBlockFace);
    assertEquals(EquipmentSlot.HAND, actualHand);
    assertFalse(actualEntityPlaceEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlock);
    assertSame(entity, actualEntityPlaceEvent.getEntity());
    assertSame(player, actualPlayer);
  }

  /**
   * Test {@link EntityPlaceEvent#EntityPlaceEvent(Entity, Player, Block, BlockFace)}.
   *
   * <p>Method under test: {@link EntityPlaceEvent#EntityPlaceEvent(Entity, Player, Block,
   * BlockFace)}
   */
  @Test
  @DisplayName("Test new EntityPlaceEvent(Entity, Player, Block, BlockFace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityPlaceEvent.<init>(Entity, Player, Block, BlockFace)"})
  void testNewEntityPlaceEvent() {
    // Arrange
    Entity entity = mock(Entity.class);
    Player player = mock(Player.class);
    Block block = mock(Block.class);

    // Act
    EntityPlaceEvent actualEntityPlaceEvent =
        new EntityPlaceEvent(entity, player, block, BlockFace.NORTH);

    // Assert
    assertEquals("EntityPlaceEvent", actualEntityPlaceEvent.getEventName());
    assertNull(actualEntityPlaceEvent.getEntityType());
    assertEquals(0, actualEntityPlaceEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(BlockFace.NORTH, actualEntityPlaceEvent.getBlockFace());
    assertEquals(EquipmentSlot.HAND, actualEntityPlaceEvent.getHand());
    assertFalse(actualEntityPlaceEvent.isAsynchronous());
    assertFalse(actualEntityPlaceEvent.isCancelled());
    assertSame(block, actualEntityPlaceEvent.getBlock());
    assertSame(entity, actualEntityPlaceEvent.getEntity());
    assertSame(player, actualEntityPlaceEvent.getPlayer());
  }
}

package org.bukkit.event.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.HopperInventorySearchEvent.ContainerType;
import org.bukkit.inventory.Inventory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HopperInventorySearchEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HopperInventorySearchEvent#HopperInventorySearchEvent(Inventory, ContainerType,
   *       Block, Block)}
   *   <li>{@link HopperInventorySearchEvent#setInventory(Inventory)}
   *   <li>{@link HopperInventorySearchEvent#getHandlerList()}
   *   <li>{@link HopperInventorySearchEvent#getContainerType()}
   *   <li>{@link HopperInventorySearchEvent#getHandlers()}
   *   <li>{@link HopperInventorySearchEvent#getInventory()}
   *   <li>{@link HopperInventorySearchEvent#getSearchBlock()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HopperInventorySearchEvent.<init>(Inventory, ContainerType, Block, Block)",
    "ContainerType HopperInventorySearchEvent.getContainerType()",
    "HandlerList HopperInventorySearchEvent.getHandlerList()",
    "HandlerList HopperInventorySearchEvent.getHandlers()",
    "Inventory HopperInventorySearchEvent.getInventory()",
    "Block HopperInventorySearchEvent.getSearchBlock()",
    "void HopperInventorySearchEvent.setInventory(Inventory)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block hopper = mock(Block.class);
    Block searchBlock = mock(Block.class);

    // Act
    HopperInventorySearchEvent actualHopperInventorySearchEvent =
        new HopperInventorySearchEvent(
            mock(Inventory.class), ContainerType.SOURCE, hopper, searchBlock);
    Inventory inventory = mock(Inventory.class);
    actualHopperInventorySearchEvent.setInventory(inventory);
    HandlerList actualHandlerList = actualHopperInventorySearchEvent.getHandlerList();
    ContainerType actualContainerType = actualHopperInventorySearchEvent.getContainerType();
    HandlerList actualHandlers = actualHopperInventorySearchEvent.getHandlers();
    Inventory actualInventory = actualHopperInventorySearchEvent.getInventory();
    Block actualSearchBlock = actualHopperInventorySearchEvent.getSearchBlock();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(ContainerType.SOURCE, actualContainerType);
    assertFalse(actualHopperInventorySearchEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(hopper, actualHopperInventorySearchEvent.getBlock());
    assertSame(searchBlock, actualSearchBlock);
    assertSame(inventory, actualInventory);
  }
}

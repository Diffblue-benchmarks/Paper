package org.bukkit.event.block;

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
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FluidLevelChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FluidLevelChangeEvent#FluidLevelChangeEvent(Block, BlockData)}
   *   <li>{@link FluidLevelChangeEvent#setCancelled(boolean)}
   *   <li>{@link FluidLevelChangeEvent#getHandlerList()}
   *   <li>{@link FluidLevelChangeEvent#getHandlers()}
   *   <li>{@link FluidLevelChangeEvent#getNewData()}
   *   <li>{@link FluidLevelChangeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FluidLevelChangeEvent.<init>(Block, BlockData)",
    "HandlerList FluidLevelChangeEvent.getHandlerList()",
    "HandlerList FluidLevelChangeEvent.getHandlers()",
    "BlockData FluidLevelChangeEvent.getNewData()",
    "boolean FluidLevelChangeEvent.isCancelled()",
    "void FluidLevelChangeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block fluid = mock(Block.class);
    BlockData newData = mock(BlockData.class);

    // Act
    FluidLevelChangeEvent actualFluidLevelChangeEvent = new FluidLevelChangeEvent(fluid, newData);
    actualFluidLevelChangeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualFluidLevelChangeEvent.getHandlerList();
    HandlerList actualHandlers = actualFluidLevelChangeEvent.getHandlers();
    BlockData actualNewData = actualFluidLevelChangeEvent.getNewData();
    boolean actualIsCancelledResult = actualFluidLevelChangeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualFluidLevelChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(fluid, actualFluidLevelChangeEvent.getBlock());
    assertSame(newData, actualNewData);
  }

  /**
   * Test {@link FluidLevelChangeEvent#setNewData(BlockData)}.
   *
   * <p>Method under test: {@link FluidLevelChangeEvent#setNewData(BlockData)}
   */
  @Test
  @DisplayName("Test setNewData(BlockData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FluidLevelChangeEvent.setNewData(BlockData)"})
  void testSetNewData() {
    // Arrange
    BlockData newData = mock(BlockData.class);
    when(newData.getMaterial()).thenReturn(Material.ACACIA_BOAT);
    FluidLevelChangeEvent fluidLevelChangeEvent =
        new FluidLevelChangeEvent(mock(Block.class), newData);

    BlockData newData2 = mock(BlockData.class);
    when(newData2.getMaterial()).thenReturn(Material.ACACIA_BOAT);

    // Act
    fluidLevelChangeEvent.setNewData(newData2);

    // Assert
    verify(newData).getMaterial();
    verify(newData2).getMaterial();
    assertNull(fluidLevelChangeEvent.getNewData());
  }
}

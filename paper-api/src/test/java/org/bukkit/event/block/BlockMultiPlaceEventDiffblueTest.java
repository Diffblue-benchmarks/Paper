package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockMultiPlaceEventDiffblueTest {
  /**
   * Test {@link BlockMultiPlaceEvent#BlockMultiPlaceEvent(List, Block, ItemStack, Player,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return ReplacedBlockStates is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockMultiPlaceEvent#BlockMultiPlaceEvent(List, Block, ItemStack,
   * Player, boolean)}
   */
  @Test
  @DisplayName(
      "Test new BlockMultiPlaceEvent(List, Block, ItemStack, Player, boolean); then return ReplacedBlockStates is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockMultiPlaceEvent.<init>(List, Block, ItemStack, Player, boolean)"})
  void testNewBlockMultiPlaceEvent_thenReturnReplacedBlockStatesIsArrayList() {
    // Arrange
    BlockState blockState = mock(BlockState.class);
    when(blockState.getBlock()).thenReturn(mock(Block.class));

    ArrayList<BlockState> states = new ArrayList<>();
    states.add(blockState);
    states.add(mock(BlockState.class));
    Block clicked = mock(Block.class);
    ItemStack itemInHand = mock(ItemStack.class);
    Player thePlayer = mock(Player.class);

    // Act
    BlockMultiPlaceEvent actualBlockMultiPlaceEvent =
        new BlockMultiPlaceEvent(states, clicked, itemInHand, thePlayer, true);

    // Assert
    verify(blockState).getBlock();
    assertEquals("BlockMultiPlaceEvent", actualBlockMultiPlaceEvent.getEventName());
    assertEquals(EquipmentSlot.HAND, actualBlockMultiPlaceEvent.getHand());
    assertFalse(actualBlockMultiPlaceEvent.isAsynchronous());
    assertFalse(actualBlockMultiPlaceEvent.isCancelled());
    assertTrue(actualBlockMultiPlaceEvent.canBuild());
    assertTrue(actualBlockMultiPlaceEvent.canBuild);
    assertEquals(states, actualBlockMultiPlaceEvent.getReplacedBlockStates());
    assertSame(clicked, actualBlockMultiPlaceEvent.getBlockAgainst());
    assertSame(thePlayer, actualBlockMultiPlaceEvent.getPlayer());
    assertSame(itemInHand, actualBlockMultiPlaceEvent.getItemInHand());
  }

  /**
   * Test {@link BlockMultiPlaceEvent#BlockMultiPlaceEvent(List, Block, ItemStack, Player, boolean,
   * EquipmentSlot)}.
   *
   * <ul>
   *   <li>Then return ReplacedBlockStates is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockMultiPlaceEvent#BlockMultiPlaceEvent(List, Block, ItemStack,
   * Player, boolean, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new BlockMultiPlaceEvent(List, Block, ItemStack, Player, boolean, EquipmentSlot); then return ReplacedBlockStates is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockMultiPlaceEvent.<init>(List, Block, ItemStack, Player, boolean, EquipmentSlot)"
  })
  void testNewBlockMultiPlaceEvent_thenReturnReplacedBlockStatesIsArrayList2() {
    // Arrange
    BlockState blockState = mock(BlockState.class);
    when(blockState.getBlock()).thenReturn(mock(Block.class));

    ArrayList<BlockState> states = new ArrayList<>();
    states.add(blockState);
    states.add(mock(BlockState.class));
    Block clicked = mock(Block.class);
    ItemStack itemInHand = mock(ItemStack.class);
    Player thePlayer = mock(Player.class);

    // Act
    BlockMultiPlaceEvent actualBlockMultiPlaceEvent =
        new BlockMultiPlaceEvent(states, clicked, itemInHand, thePlayer, true, EquipmentSlot.HAND);

    // Assert
    verify(blockState).getBlock();
    assertEquals("BlockMultiPlaceEvent", actualBlockMultiPlaceEvent.getEventName());
    assertEquals(EquipmentSlot.HAND, actualBlockMultiPlaceEvent.getHand());
    assertFalse(actualBlockMultiPlaceEvent.isAsynchronous());
    assertFalse(actualBlockMultiPlaceEvent.isCancelled());
    assertTrue(actualBlockMultiPlaceEvent.canBuild());
    assertTrue(actualBlockMultiPlaceEvent.canBuild);
    assertEquals(states, actualBlockMultiPlaceEvent.getReplacedBlockStates());
    assertSame(clicked, actualBlockMultiPlaceEvent.getBlockAgainst());
    assertSame(thePlayer, actualBlockMultiPlaceEvent.getPlayer());
    assertSame(itemInHand, actualBlockMultiPlaceEvent.getItemInHand());
  }

  /**
   * Test {@link BlockMultiPlaceEvent#BlockMultiPlaceEvent(List, Block, ItemStack, Player,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return ReplacedBlockStates size is one.
   * </ul>
   *
   * <p>Method under test: {@link BlockMultiPlaceEvent#BlockMultiPlaceEvent(List, Block, ItemStack,
   * Player, boolean)}
   */
  @Test
  @DisplayName(
      "Test new BlockMultiPlaceEvent(List, Block, ItemStack, Player, boolean); then return ReplacedBlockStates size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockMultiPlaceEvent.<init>(List, Block, ItemStack, Player, boolean)"})
  void testNewBlockMultiPlaceEvent_thenReturnReplacedBlockStatesSizeIsOne() {
    // Arrange
    BlockState blockState = mock(BlockState.class);
    when(blockState.getBlock()).thenReturn(mock(Block.class));

    ArrayList<BlockState> states = new ArrayList<>();
    states.add(blockState);
    Block clicked = mock(Block.class);
    ItemStack itemInHand = mock(ItemStack.class);
    Player thePlayer = mock(Player.class);

    // Act
    BlockMultiPlaceEvent actualBlockMultiPlaceEvent =
        new BlockMultiPlaceEvent(states, clicked, itemInHand, thePlayer, true);

    // Assert
    verify(blockState).getBlock();
    assertEquals("BlockMultiPlaceEvent", actualBlockMultiPlaceEvent.getEventName());
    assertEquals(1, actualBlockMultiPlaceEvent.getReplacedBlockStates().size());
    assertEquals(EquipmentSlot.HAND, actualBlockMultiPlaceEvent.getHand());
    assertFalse(actualBlockMultiPlaceEvent.isAsynchronous());
    assertFalse(actualBlockMultiPlaceEvent.isCancelled());
    assertTrue(actualBlockMultiPlaceEvent.canBuild());
    assertTrue(actualBlockMultiPlaceEvent.canBuild);
    assertSame(clicked, actualBlockMultiPlaceEvent.getBlockAgainst());
    assertSame(thePlayer, actualBlockMultiPlaceEvent.getPlayer());
    assertSame(itemInHand, actualBlockMultiPlaceEvent.getItemInHand());
  }

  /**
   * Test {@link BlockMultiPlaceEvent#BlockMultiPlaceEvent(List, Block, ItemStack, Player, boolean,
   * EquipmentSlot)}.
   *
   * <ul>
   *   <li>Then return ReplacedBlockStates size is one.
   * </ul>
   *
   * <p>Method under test: {@link BlockMultiPlaceEvent#BlockMultiPlaceEvent(List, Block, ItemStack,
   * Player, boolean, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new BlockMultiPlaceEvent(List, Block, ItemStack, Player, boolean, EquipmentSlot); then return ReplacedBlockStates size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockMultiPlaceEvent.<init>(List, Block, ItemStack, Player, boolean, EquipmentSlot)"
  })
  void testNewBlockMultiPlaceEvent_thenReturnReplacedBlockStatesSizeIsOne2() {
    // Arrange
    BlockState blockState = mock(BlockState.class);
    when(blockState.getBlock()).thenReturn(mock(Block.class));

    ArrayList<BlockState> states = new ArrayList<>();
    states.add(blockState);
    Block clicked = mock(Block.class);
    ItemStack itemInHand = mock(ItemStack.class);
    Player thePlayer = mock(Player.class);

    // Act
    BlockMultiPlaceEvent actualBlockMultiPlaceEvent =
        new BlockMultiPlaceEvent(states, clicked, itemInHand, thePlayer, true, EquipmentSlot.HAND);

    // Assert
    verify(blockState).getBlock();
    assertEquals("BlockMultiPlaceEvent", actualBlockMultiPlaceEvent.getEventName());
    assertEquals(1, actualBlockMultiPlaceEvent.getReplacedBlockStates().size());
    assertEquals(EquipmentSlot.HAND, actualBlockMultiPlaceEvent.getHand());
    assertFalse(actualBlockMultiPlaceEvent.isAsynchronous());
    assertFalse(actualBlockMultiPlaceEvent.isCancelled());
    assertTrue(actualBlockMultiPlaceEvent.canBuild());
    assertTrue(actualBlockMultiPlaceEvent.canBuild);
    assertSame(clicked, actualBlockMultiPlaceEvent.getBlockAgainst());
    assertSame(thePlayer, actualBlockMultiPlaceEvent.getPlayer());
    assertSame(itemInHand, actualBlockMultiPlaceEvent.getItemInHand());
  }
}

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
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockCanBuildEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockCanBuildEvent#BlockCanBuildEvent(Block, Player, BlockData, boolean,
   *       EquipmentSlot)}
   *   <li>{@link BlockCanBuildEvent#setBuildable(boolean)}
   *   <li>{@link BlockCanBuildEvent#getHandlerList()}
   *   <li>{@link BlockCanBuildEvent#getHand()}
   *   <li>{@link BlockCanBuildEvent#getHandlers()}
   *   <li>{@link BlockCanBuildEvent#getPlayer()}
   *   <li>{@link BlockCanBuildEvent#isBuildable()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockCanBuildEvent.<init>(Block, Player, BlockData, boolean, EquipmentSlot)",
    "EquipmentSlot BlockCanBuildEvent.getHand()",
    "HandlerList BlockCanBuildEvent.getHandlerList()",
    "HandlerList BlockCanBuildEvent.getHandlers()",
    "Player BlockCanBuildEvent.getPlayer()",
    "boolean BlockCanBuildEvent.isBuildable()",
    "void BlockCanBuildEvent.setBuildable(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    Player player = mock(Player.class);

    // Act
    BlockCanBuildEvent actualBlockCanBuildEvent =
        new BlockCanBuildEvent(block, player, mock(BlockData.class), true, EquipmentSlot.HAND);
    actualBlockCanBuildEvent.setBuildable(true);
    HandlerList actualHandlerList = actualBlockCanBuildEvent.getHandlerList();
    EquipmentSlot actualHand = actualBlockCanBuildEvent.getHand();
    HandlerList actualHandlers = actualBlockCanBuildEvent.getHandlers();
    Player actualPlayer = actualBlockCanBuildEvent.getPlayer();
    boolean actualIsBuildableResult = actualBlockCanBuildEvent.isBuildable();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(EquipmentSlot.HAND, actualHand);
    assertFalse(actualBlockCanBuildEvent.isAsynchronous());
    assertTrue(actualIsBuildableResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockCanBuildEvent.getBlock());
    assertSame(player, actualPlayer);
  }

  /**
   * Test {@link BlockCanBuildEvent#BlockCanBuildEvent(Block, BlockData, boolean)}.
   *
   * <p>Method under test: {@link BlockCanBuildEvent#BlockCanBuildEvent(Block, BlockData, boolean)}
   */
  @Test
  @DisplayName("Test new BlockCanBuildEvent(Block, BlockData, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCanBuildEvent.<init>(Block, BlockData, boolean)"})
  void testNewBlockCanBuildEvent() {
    // Arrange
    Block block = mock(Block.class);

    // Act
    BlockCanBuildEvent actualBlockCanBuildEvent =
        new BlockCanBuildEvent(block, mock(BlockData.class), true);

    // Assert
    assertEquals("BlockCanBuildEvent", actualBlockCanBuildEvent.getEventName());
    assertNull(actualBlockCanBuildEvent.getMaterial());
    assertNull(actualBlockCanBuildEvent.getBlockData());
    assertNull(actualBlockCanBuildEvent.getPlayer());
    assertEquals(0, actualBlockCanBuildEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(EquipmentSlot.HAND, actualBlockCanBuildEvent.getHand());
    assertFalse(actualBlockCanBuildEvent.isAsynchronous());
    assertTrue(actualBlockCanBuildEvent.isBuildable());
    assertSame(block, actualBlockCanBuildEvent.getBlock());
  }

  /**
   * Test {@link BlockCanBuildEvent#BlockCanBuildEvent(Block, Player, BlockData, boolean)}.
   *
   * <p>Method under test: {@link BlockCanBuildEvent#BlockCanBuildEvent(Block, Player, BlockData,
   * boolean)}
   */
  @Test
  @DisplayName("Test new BlockCanBuildEvent(Block, Player, BlockData, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCanBuildEvent.<init>(Block, Player, BlockData, boolean)"})
  void testNewBlockCanBuildEvent2() {
    // Arrange
    Block block = mock(Block.class);
    Player player = mock(Player.class);

    // Act
    BlockCanBuildEvent actualBlockCanBuildEvent =
        new BlockCanBuildEvent(block, player, mock(BlockData.class), true);

    // Assert
    assertEquals("BlockCanBuildEvent", actualBlockCanBuildEvent.getEventName());
    assertNull(actualBlockCanBuildEvent.getMaterial());
    assertNull(actualBlockCanBuildEvent.getBlockData());
    assertEquals(0, actualBlockCanBuildEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(EquipmentSlot.HAND, actualBlockCanBuildEvent.getHand());
    assertFalse(actualBlockCanBuildEvent.isAsynchronous());
    assertTrue(actualBlockCanBuildEvent.isBuildable());
    assertSame(block, actualBlockCanBuildEvent.getBlock());
    assertSame(player, actualBlockCanBuildEvent.getPlayer());
  }

  /**
   * Test {@link BlockCanBuildEvent#getMaterial()}.
   *
   * <p>Method under test: {@link BlockCanBuildEvent#getMaterial()}
   */
  @Test
  @DisplayName("Test getMaterial()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Material BlockCanBuildEvent.getMaterial()"})
  void testGetMaterial() {
    // Arrange
    BlockData type = mock(BlockData.class);
    when(type.getMaterial()).thenReturn(Material.ACACIA_BOAT);
    BlockCanBuildEvent blockCanBuildEvent = new BlockCanBuildEvent(mock(Block.class), type, true);

    // Act
    Material actualMaterial = blockCanBuildEvent.getMaterial();

    // Assert
    verify(type).getMaterial();
    assertEquals(Material.ACACIA_BOAT, actualMaterial);
  }

  /**
   * Test {@link BlockCanBuildEvent#getBlockData()}.
   *
   * <p>Method under test: {@link BlockCanBuildEvent#getBlockData()}
   */
  @Test
  @DisplayName("Test getBlockData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockData BlockCanBuildEvent.getBlockData()"})
  void testGetBlockData() {
    // Arrange
    BlockCanBuildEvent blockCanBuildEvent =
        new BlockCanBuildEvent(mock(Block.class), mock(BlockData.class), true);

    // Act and Assert
    assertNull(blockCanBuildEvent.getBlockData());
  }
}

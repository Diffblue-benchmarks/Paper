package org.bukkit.event.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FurnaceExtractEventDiffblueTest {
  /**
   * Test {@link FurnaceExtractEvent#FurnaceExtractEvent(Player, Block, Material, int, int)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return ItemType is {@code ACACIA_BOAT}.
   * </ul>
   *
   * <p>Method under test: {@link FurnaceExtractEvent#FurnaceExtractEvent(Player, Block, Material,
   * int, int)}
   */
  @Test
  @DisplayName(
      "Test new FurnaceExtractEvent(Player, Block, Material, int, int); when 'ACACIA_BOAT'; then return ItemType is 'ACACIA_BOAT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FurnaceExtractEvent.<init>(Player, Block, Material, int, int)"})
  void testNewFurnaceExtractEvent_whenAcaciaBoat_thenReturnItemTypeIsAcaciaBoat() {
    // Arrange
    Player player = mock(Player.class);
    Block block = mock(Block.class);

    // Act
    FurnaceExtractEvent actualFurnaceExtractEvent =
        new FurnaceExtractEvent(player, block, Material.ACACIA_BOAT, 42, 1);

    // Assert
    assertEquals("FurnaceExtractEvent", actualFurnaceExtractEvent.getEventName());
    assertEquals(0, actualFurnaceExtractEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(1, actualFurnaceExtractEvent.getExpToDrop());
    assertEquals(42, actualFurnaceExtractEvent.getItemAmount());
    assertEquals(Material.ACACIA_BOAT, actualFurnaceExtractEvent.getItemType());
    assertFalse(actualFurnaceExtractEvent.isAsynchronous());
    assertSame(block, actualFurnaceExtractEvent.getBlock());
    assertSame(player, actualFurnaceExtractEvent.getPlayer());
  }

  /**
   * Test {@link FurnaceExtractEvent#FurnaceExtractEvent(Player, Block, Material, int, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ItemType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FurnaceExtractEvent#FurnaceExtractEvent(Player, Block, Material,
   * int, int)}
   */
  @Test
  @DisplayName(
      "Test new FurnaceExtractEvent(Player, Block, Material, int, int); when 'null'; then return ItemType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FurnaceExtractEvent.<init>(Player, Block, Material, int, int)"})
  void testNewFurnaceExtractEvent_whenNull_thenReturnItemTypeIsNull() {
    // Arrange
    Player player = mock(Player.class);
    Block block = mock(Block.class);

    // Act
    FurnaceExtractEvent actualFurnaceExtractEvent =
        new FurnaceExtractEvent(player, block, null, 42, 1);

    // Assert
    assertEquals("FurnaceExtractEvent", actualFurnaceExtractEvent.getEventName());
    assertNull(actualFurnaceExtractEvent.getItemType());
    assertEquals(0, actualFurnaceExtractEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(1, actualFurnaceExtractEvent.getExpToDrop());
    assertEquals(42, actualFurnaceExtractEvent.getItemAmount());
    assertFalse(actualFurnaceExtractEvent.isAsynchronous());
    assertSame(block, actualFurnaceExtractEvent.getBlock());
    assertSame(player, actualFurnaceExtractEvent.getPlayer());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FurnaceExtractEvent#getItemAmount()}
   *   <li>{@link FurnaceExtractEvent#getItemType()}
   *   <li>{@link FurnaceExtractEvent#getPlayer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FurnaceExtractEvent.getItemAmount()",
    "Material FurnaceExtractEvent.getItemType()",
    "Player FurnaceExtractEvent.getPlayer()"
  })
  void testGettersAndSetters() {
    // Arrange
    FurnaceExtractEvent furnaceExtractEvent =
        new FurnaceExtractEvent(mock(Player.class), mock(Block.class), Material.ACACIA_BOAT, 42, 1);

    // Act
    int actualItemAmount = furnaceExtractEvent.getItemAmount();
    Material actualItemType = furnaceExtractEvent.getItemType();
    furnaceExtractEvent.getPlayer();

    // Assert
    assertEquals(42, actualItemAmount);
    assertEquals(Material.ACACIA_BOAT, actualItemType);
  }
}

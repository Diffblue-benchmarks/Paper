package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerHarvestBlockEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerHarvestBlockEvent#PlayerHarvestBlockEvent(Player, Block, EquipmentSlot,
   *       List)}
   *   <li>{@link PlayerHarvestBlockEvent#setCancelled(boolean)}
   *   <li>{@link PlayerHarvestBlockEvent#getHandlerList()}
   *   <li>{@link PlayerHarvestBlockEvent#getHand()}
   *   <li>{@link PlayerHarvestBlockEvent#getHandlers()}
   *   <li>{@link PlayerHarvestBlockEvent#getHarvestedBlock()}
   *   <li>{@link PlayerHarvestBlockEvent#getItemsHarvested()}
   *   <li>{@link PlayerHarvestBlockEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerHarvestBlockEvent.<init>(Player, Block, EquipmentSlot, List)",
    "EquipmentSlot PlayerHarvestBlockEvent.getHand()",
    "HandlerList PlayerHarvestBlockEvent.getHandlerList()",
    "HandlerList PlayerHarvestBlockEvent.getHandlers()",
    "Block PlayerHarvestBlockEvent.getHarvestedBlock()",
    "List PlayerHarvestBlockEvent.getItemsHarvested()",
    "boolean PlayerHarvestBlockEvent.isCancelled()",
    "void PlayerHarvestBlockEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Block harvestedBlock = mock(Block.class);
    ArrayList<ItemStack> itemsHarvested = new ArrayList<>();

    // Act
    PlayerHarvestBlockEvent actualPlayerHarvestBlockEvent =
        new PlayerHarvestBlockEvent(player, harvestedBlock, EquipmentSlot.HAND, itemsHarvested);
    actualPlayerHarvestBlockEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerHarvestBlockEvent.getHandlerList();
    EquipmentSlot actualHand = actualPlayerHarvestBlockEvent.getHand();
    HandlerList actualHandlers = actualPlayerHarvestBlockEvent.getHandlers();
    Block actualHarvestedBlock = actualPlayerHarvestBlockEvent.getHarvestedBlock();
    List<ItemStack> actualItemsHarvested = actualPlayerHarvestBlockEvent.getItemsHarvested();
    boolean actualIsCancelledResult = actualPlayerHarvestBlockEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(EquipmentSlot.HAND, actualHand);
    assertFalse(actualPlayerHarvestBlockEvent.isAsynchronous());
    assertTrue(actualItemsHarvested.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(itemsHarvested, actualItemsHarvested);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(harvestedBlock, actualHarvestedBlock);
    assertSame(player, actualPlayerHarvestBlockEvent.getPlayer());
  }

  /**
   * Test {@link PlayerHarvestBlockEvent#PlayerHarvestBlockEvent(Player, Block, List)}.
   *
   * <p>Method under test: {@link PlayerHarvestBlockEvent#PlayerHarvestBlockEvent(Player, Block,
   * List)}
   */
  @Test
  @DisplayName("Test new PlayerHarvestBlockEvent(Player, Block, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerHarvestBlockEvent.<init>(Player, Block, List)"})
  void testNewPlayerHarvestBlockEvent() {
    // Arrange
    Player player = mock(Player.class);
    Block harvestedBlock = mock(Block.class);

    // Act
    PlayerHarvestBlockEvent actualPlayerHarvestBlockEvent =
        new PlayerHarvestBlockEvent(player, harvestedBlock, new ArrayList<>());

    // Assert
    assertEquals("PlayerHarvestBlockEvent", actualPlayerHarvestBlockEvent.getEventName());
    assertEquals(0, actualPlayerHarvestBlockEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(EquipmentSlot.HAND, actualPlayerHarvestBlockEvent.getHand());
    assertFalse(actualPlayerHarvestBlockEvent.isAsynchronous());
    assertFalse(actualPlayerHarvestBlockEvent.isCancelled());
    assertTrue(actualPlayerHarvestBlockEvent.getItemsHarvested().isEmpty());
    assertSame(harvestedBlock, actualPlayerHarvestBlockEvent.getHarvestedBlock());
    assertSame(player, actualPlayerHarvestBlockEvent.getPlayer());
  }
}

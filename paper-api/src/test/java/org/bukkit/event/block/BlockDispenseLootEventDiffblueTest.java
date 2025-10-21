package org.bukkit.event.block;

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
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockDispenseLootEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockDispenseLootEvent#BlockDispenseLootEvent(Player, Block, List, LootTable)}
   *   <li>{@link BlockDispenseLootEvent#setCancelled(boolean)}
   *   <li>{@link BlockDispenseLootEvent#getHandlerList()}
   *   <li>{@link BlockDispenseLootEvent#getDispensedLoot()}
   *   <li>{@link BlockDispenseLootEvent#getHandlers()}
   *   <li>{@link BlockDispenseLootEvent#getLootTable()}
   *   <li>{@link BlockDispenseLootEvent#getPlayer()}
   *   <li>{@link BlockDispenseLootEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockDispenseLootEvent.<init>(Player, Block, List, LootTable)",
    "List BlockDispenseLootEvent.getDispensedLoot()",
    "HandlerList BlockDispenseLootEvent.getHandlerList()",
    "HandlerList BlockDispenseLootEvent.getHandlers()",
    "LootTable BlockDispenseLootEvent.getLootTable()",
    "Player BlockDispenseLootEvent.getPlayer()",
    "boolean BlockDispenseLootEvent.isCancelled()",
    "void BlockDispenseLootEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Block block = mock(Block.class);
    ArrayList<ItemStack> dispensedLoot = new ArrayList<>();
    LootTable lootTable = mock(LootTable.class);

    // Act
    BlockDispenseLootEvent actualBlockDispenseLootEvent =
        new BlockDispenseLootEvent(player, block, dispensedLoot, lootTable);
    actualBlockDispenseLootEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBlockDispenseLootEvent.getHandlerList();
    List<ItemStack> actualDispensedLoot = actualBlockDispenseLootEvent.getDispensedLoot();
    HandlerList actualHandlers = actualBlockDispenseLootEvent.getHandlers();
    LootTable actualLootTable = actualBlockDispenseLootEvent.getLootTable();
    Player actualPlayer = actualBlockDispenseLootEvent.getPlayer();
    boolean actualIsCancelledResult = actualBlockDispenseLootEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBlockDispenseLootEvent.isAsynchronous());
    assertTrue(actualDispensedLoot.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(dispensedLoot, actualDispensedLoot);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockDispenseLootEvent.getBlock());
    assertSame(player, actualPlayer);
    assertSame(lootTable, actualLootTable);
  }
}

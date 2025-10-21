package org.bukkit.event.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootContext.Builder;
import org.bukkit.loot.LootTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LootGenerateEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LootGenerateEvent#LootGenerateEvent(World, Entity, InventoryHolder, LootTable,
   *       LootContext, List, boolean)}
   *   <li>{@link LootGenerateEvent#setCancelled(boolean)}
   *   <li>{@link LootGenerateEvent#getHandlerList()}
   *   <li>{@link LootGenerateEvent#getEntity()}
   *   <li>{@link LootGenerateEvent#getHandlers()}
   *   <li>{@link LootGenerateEvent#getInventoryHolder()}
   *   <li>{@link LootGenerateEvent#getLoot()}
   *   <li>{@link LootGenerateEvent#getLootContext()}
   *   <li>{@link LootGenerateEvent#getLootTable()}
   *   <li>{@link LootGenerateEvent#isCancelled()}
   *   <li>{@link LootGenerateEvent#isPlugin()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LootGenerateEvent.<init>(World, Entity, InventoryHolder, LootTable, LootContext, List, boolean)",
    "Entity LootGenerateEvent.getEntity()",
    "HandlerList LootGenerateEvent.getHandlerList()",
    "HandlerList LootGenerateEvent.getHandlers()",
    "InventoryHolder LootGenerateEvent.getInventoryHolder()",
    "List LootGenerateEvent.getLoot()",
    "LootContext LootGenerateEvent.getLootContext()",
    "LootTable LootGenerateEvent.getLootTable()",
    "boolean LootGenerateEvent.isCancelled()",
    "boolean LootGenerateEvent.isPlugin()",
    "void LootGenerateEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    World world = mock(World.class);
    Entity entity = mock(Entity.class);
    InventoryHolder inventoryHolder = mock(InventoryHolder.class);
    LootTable lootTable = mock(LootTable.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    LootContext lootContext =
        new Builder(location)
            .killer(mock(HumanEntity.class))
            .lootedEntity(mock(Entity.class))
            .lootingModifier(1)
            .luck(10.0f)
            .build();
    ArrayList<ItemStack> items = new ArrayList<>();

    // Act
    LootGenerateEvent actualLootGenerateEvent =
        new LootGenerateEvent(world, entity, inventoryHolder, lootTable, lootContext, items, true);
    actualLootGenerateEvent.setCancelled(true);
    HandlerList actualHandlerList = actualLootGenerateEvent.getHandlerList();
    Entity actualEntity = actualLootGenerateEvent.getEntity();
    HandlerList actualHandlers = actualLootGenerateEvent.getHandlers();
    InventoryHolder actualInventoryHolder = actualLootGenerateEvent.getInventoryHolder();
    List<ItemStack> actualLoot = actualLootGenerateEvent.getLoot();
    LootContext actualLootContext = actualLootGenerateEvent.getLootContext();
    LootTable actualLootTable = actualLootGenerateEvent.getLootTable();
    boolean actualIsCancelledResult = actualLootGenerateEvent.isCancelled();
    boolean actualIsPluginResult = actualLootGenerateEvent.isPlugin();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualLootGenerateEvent.isAsynchronous());
    assertTrue(actualLoot.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsPluginResult);
    assertSame(items, actualLoot);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(lootContext, actualLootContext);
    assertSame(world, actualLootGenerateEvent.getWorld());
    assertSame(entity, actualEntity);
    assertSame(inventoryHolder, actualInventoryHolder);
    assertSame(lootTable, actualLootTable);
  }
}

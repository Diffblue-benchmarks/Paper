package org.bukkit.event.inventory;

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
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BrewEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BrewEvent#BrewEvent(Block, BrewerInventory, List, int)}
   *   <li>{@link BrewEvent#setCancelled(boolean)}
   *   <li>{@link BrewEvent#getHandlerList()}
   *   <li>{@link BrewEvent#getContents()}
   *   <li>{@link BrewEvent#getFuelLevel()}
   *   <li>{@link BrewEvent#getHandlers()}
   *   <li>{@link BrewEvent#getResults()}
   *   <li>{@link BrewEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BrewEvent.<init>(Block, BrewerInventory, List, int)",
    "BrewerInventory BrewEvent.getContents()",
    "int BrewEvent.getFuelLevel()",
    "HandlerList BrewEvent.getHandlerList()",
    "HandlerList BrewEvent.getHandlers()",
    "List BrewEvent.getResults()",
    "boolean BrewEvent.isCancelled()",
    "void BrewEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block brewer = mock(Block.class);
    BrewerInventory contents = mock(BrewerInventory.class);
    ArrayList<ItemStack> results = new ArrayList<>();

    // Act
    BrewEvent actualBrewEvent = new BrewEvent(brewer, contents, results, 1);
    actualBrewEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBrewEvent.getHandlerList();
    BrewerInventory actualContents = actualBrewEvent.getContents();
    int actualFuelLevel = actualBrewEvent.getFuelLevel();
    HandlerList actualHandlers = actualBrewEvent.getHandlers();
    List<ItemStack> actualResults = actualBrewEvent.getResults();
    boolean actualIsCancelledResult = actualBrewEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualFuelLevel);
    assertFalse(actualBrewEvent.isAsynchronous());
    assertTrue(actualResults.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(results, actualResults);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(brewer, actualBrewEvent.getBlock());
    assertSame(contents, actualContents);
  }
}

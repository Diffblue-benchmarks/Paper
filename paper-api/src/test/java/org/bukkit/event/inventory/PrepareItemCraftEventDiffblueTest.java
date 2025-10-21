package org.bukkit.event.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.Recipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PrepareItemCraftEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PrepareItemCraftEvent#PrepareItemCraftEvent(CraftingInventory, InventoryView,
   *       boolean)}
   *   <li>{@link PrepareItemCraftEvent#getHandlerList()}
   *   <li>{@link PrepareItemCraftEvent#getHandlers()}
   *   <li>{@link PrepareItemCraftEvent#isRepair()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PrepareItemCraftEvent.<init>(CraftingInventory, InventoryView, boolean)",
    "HandlerList PrepareItemCraftEvent.getHandlerList()",
    "HandlerList PrepareItemCraftEvent.getHandlers()",
    "boolean PrepareItemCraftEvent.isRepair()"
  })
  void testGettersAndSetters() {
    // Arrange
    CraftingInventory matrix = mock(CraftingInventory.class);
    InventoryView view = mock(InventoryView.class);

    // Act
    PrepareItemCraftEvent actualPrepareItemCraftEvent =
        new PrepareItemCraftEvent(matrix, view, true);
    HandlerList actualHandlerList = actualPrepareItemCraftEvent.getHandlerList();
    HandlerList actualHandlers = actualPrepareItemCraftEvent.getHandlers();
    boolean actualIsRepairResult = actualPrepareItemCraftEvent.isRepair();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPrepareItemCraftEvent.isAsynchronous());
    assertTrue(actualIsRepairResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(matrix, actualPrepareItemCraftEvent.getInventory());
    assertSame(view, actualPrepareItemCraftEvent.getView());
  }

  /**
   * Test {@link PrepareItemCraftEvent#getRecipe()}.
   *
   * <p>Method under test: {@link PrepareItemCraftEvent#getRecipe()}
   */
  @Test
  @DisplayName("Test getRecipe()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Recipe PrepareItemCraftEvent.getRecipe()"})
  void testGetRecipe() {
    // Arrange
    CraftingInventory matrix = mock(CraftingInventory.class);
    when(matrix.getRecipe()).thenReturn(mock(Recipe.class));
    PrepareItemCraftEvent prepareItemCraftEvent =
        new PrepareItemCraftEvent(matrix, mock(InventoryView.class), true);

    // Act
    prepareItemCraftEvent.getRecipe();

    // Assert
    verify(matrix).getRecipe();
  }
}

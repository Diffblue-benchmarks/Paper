package com.destroystokyo.paper.event.inventory;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.inventory.InventoryView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PrepareResultEventDiffblueTest {
  /**
   * Test {@link PrepareResultEvent#getResult()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PrepareResultEvent#getResult()}
   */
  @Test
  @DisplayName("Test getResult(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.inventory.ItemStack PrepareResultEvent.getResult()"})
  void testGetResult_thenReturnNull() {
    // Arrange
    PrepareResultEvent prepareResultEvent = new PrepareResultEvent(mock(InventoryView.class), null);

    // Act and Assert
    assertNull(prepareResultEvent.getResult());
  }
}

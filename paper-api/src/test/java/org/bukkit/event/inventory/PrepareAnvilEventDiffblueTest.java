package org.bukkit.event.inventory;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.view.AnvilView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PrepareAnvilEventDiffblueTest {
  /**
   * Test {@link PrepareAnvilEvent#getInventory()}.
   *
   * <ul>
   *   <li>Then calls {@link AnvilView#getTopInventory()}.
   * </ul>
   *
   * <p>Method under test: {@link PrepareAnvilEvent#getInventory()}
   */
  @Test
  @DisplayName("Test getInventory(); then calls getTopInventory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AnvilInventory PrepareAnvilEvent.getInventory()"})
  void testGetInventory_thenCallsGetTopInventory() {
    // Arrange
    AnvilView inventory = mock(AnvilView.class);
    when(inventory.getTopInventory()).thenReturn(mock(AnvilInventory.class));
    PrepareAnvilEvent prepareAnvilEvent = new PrepareAnvilEvent(inventory, null);

    // Act
    prepareAnvilEvent.getInventory();

    // Assert
    verify(inventory).getTopInventory();
  }

  /**
   * Test {@link PrepareAnvilEvent#getView()}.
   *
   * <p>Method under test: {@link PrepareAnvilEvent#getView()}
   */
  @Test
  @DisplayName("Test getView()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AnvilView PrepareAnvilEvent.getView()"})
  void testGetView() {
    // Arrange
    PrepareAnvilEvent prepareAnvilEvent = new PrepareAnvilEvent(mock(AnvilView.class), null);

    // Act
    AnvilView actualView = prepareAnvilEvent.getView();

    // Assert
    assertSame(prepareAnvilEvent.transaction, actualView);
  }
}

package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.set.RegistryKeySet;
import java.util.ArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Repairable;
import org.bukkit.inventory.ItemType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperRepairableDiffblueTest {
  /**
   * Test {@link PaperRepairable#getHandle()}.
   *
   * <p>Method under test: {@link PaperRepairable#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Repairable PaperRepairable.getHandle()"})
  void testGetHandle() {
    // Arrange
    Repairable impl = new Repairable(mock(HolderSet.class));

    // Act and Assert
    assertSame(impl, new PaperRepairable(impl).getHandle());
  }

  /**
   * Test {@link PaperRepairable#types()}.
   *
   * <ul>
   *   <li>Given {@link HolderSet} {@link HolderSet#iterator()} return {@link ArrayList#ArrayList()}
   *       iterator.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperRepairable#types()}
   */
  @Test
  @DisplayName(
      "Test types(); given HolderSet iterator() return ArrayList() iterator; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryKeySet PaperRepairable.types()"})
  void testTypes_givenHolderSetIteratorReturnArrayListIterator_thenReturnSizeIsZero() {
    // Arrange
    HolderSet<Item> items = mock(HolderSet.class);

    ArrayList<Holder<Item>> holderList = new ArrayList<>();
    when(items.iterator()).thenReturn(holderList.iterator());
    Repairable impl = new Repairable(items);

    // Act
    RegistryKeySet<ItemType> actualTypesResult = new PaperRepairable(impl).types();

    // Assert
    verify(items).iterator();
    assertEquals(0, actualTypesResult.size());
    assertTrue(actualTypesResult.isEmpty());
  }
}

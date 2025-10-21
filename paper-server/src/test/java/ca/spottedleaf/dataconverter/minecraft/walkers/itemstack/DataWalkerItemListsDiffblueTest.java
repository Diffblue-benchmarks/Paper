package ca.spottedleaf.dataconverter.minecraft.walkers.itemstack;

import static org.junit.jupiter.api.Assertions.assertNull;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataWalkerItemListsDiffblueTest {
  /**
   * Test {@link DataWalkerItemLists#DataWalkerItemLists(String[])}.
   *
   * <p>Method under test: {@link DataWalkerItemLists#DataWalkerItemLists(String[])}
   */
  @Test
  @DisplayName("Test new DataWalkerItemLists(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataWalkerItemLists.<init>(String[])"})
  void testNewDataWalkerItemLists() {
    // Arrange and Act
    DataWalkerItemLists actualDataWalkerItemLists = new DataWalkerItemLists("Paths");

    // Assert
    assertNull(actualDataWalkerItemLists.walk(new NBTMapType(), 1L, 1L));
  }
}

package ca.spottedleaf.dataconverter.minecraft.walkers.itemstack;

import static org.junit.jupiter.api.Assertions.assertNull;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataWalkerItemsDiffblueTest {
  /**
   * Test {@link DataWalkerItems#DataWalkerItems(String[])}.
   *
   * <p>Method under test: {@link DataWalkerItems#DataWalkerItems(String[])}
   */
  @Test
  @DisplayName("Test new DataWalkerItems(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataWalkerItems.<init>(String[])"})
  void testNewDataWalkerItems() {
    // Arrange and Act
    DataWalkerItems actualDataWalkerItems = new DataWalkerItems("Paths");

    // Assert
    assertNull(actualDataWalkerItems.walk(new NBTMapType(), 1L, 1L));
  }
}

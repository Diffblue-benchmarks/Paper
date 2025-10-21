package ca.spottedleaf.dataconverter.minecraft.walkers.item_name;

import static org.junit.jupiter.api.Assertions.assertNull;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataWalkerItemNamesDiffblueTest {
  /**
   * Test {@link DataWalkerItemNames#DataWalkerItemNames(String[])}.
   *
   * <p>Method under test: {@link DataWalkerItemNames#DataWalkerItemNames(String[])}
   */
  @Test
  @DisplayName("Test new DataWalkerItemNames(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataWalkerItemNames.<init>(String[])"})
  void testNewDataWalkerItemNames() {
    // Arrange and Act
    DataWalkerItemNames actualDataWalkerItemNames = new DataWalkerItemNames("Paths");

    // Assert
    assertNull(actualDataWalkerItemNames.walk(new NBTMapType(), 1L, 1L));
  }
}

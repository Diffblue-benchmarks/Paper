package ca.spottedleaf.dataconverter.minecraft.walkers.block_name;

import static org.junit.jupiter.api.Assertions.assertNull;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataWalkerBlockNamesDiffblueTest {
  /**
   * Test {@link DataWalkerBlockNames#DataWalkerBlockNames(String[])}.
   *
   * <p>Method under test: {@link DataWalkerBlockNames#DataWalkerBlockNames(String[])}
   */
  @Test
  @DisplayName("Test new DataWalkerBlockNames(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataWalkerBlockNames.<init>(String[])"})
  void testNewDataWalkerBlockNames() {
    // Arrange and Act
    DataWalkerBlockNames actualDataWalkerBlockNames = new DataWalkerBlockNames("Paths");

    // Assert
    assertNull(actualDataWalkerBlockNames.walk(new NBTMapType(), 1L, 1L));
  }
}

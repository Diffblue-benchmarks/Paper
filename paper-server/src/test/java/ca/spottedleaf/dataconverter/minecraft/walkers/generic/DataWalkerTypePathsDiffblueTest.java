package ca.spottedleaf.dataconverter.minecraft.walkers.generic;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.converters.datatypes.DataType;
import ca.spottedleaf.dataconverter.minecraft.datatypes.MCTypeRegistry;
import ca.spottedleaf.dataconverter.minecraft.datatypes.MCValueType;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataWalkerTypePathsDiffblueTest {
  /**
   * Test {@link DataWalkerTypePaths#DataWalkerTypePaths(DataType, String[])}.
   *
   * <p>Method under test: {@link DataWalkerTypePaths#DataWalkerTypePaths(DataType, String[])}
   */
  @Test
  @DisplayName("Test new DataWalkerTypePaths(DataType, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataWalkerTypePaths.<init>(DataType, String[])"})
  void testNewDataWalkerTypePaths() {
    // Arrange and Act
    DataWalkerTypePaths<Object, Object> actualDataWalkerTypePaths =
        new DataWalkerTypePaths<>(MCTypeRegistry.BIOME, "Paths");

    // Assert
    DataType<Object, Object> dataType = actualDataWalkerTypePaths.type;
    assertTrue(dataType instanceof MCValueType);
    assertEquals("Biome", ((MCValueType) dataType).name);
    assertArrayEquals(new String[] {"Paths"}, actualDataWalkerTypePaths.paths);
  }

  /**
   * Test {@link DataWalkerTypePaths#walk(MapType, long, long)} with {@code data}, {@code
   * fromVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataWalkerTypePaths#walk(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test walk(MapType, long, long) with 'data', 'fromVersion', 'toVersion'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType DataWalkerTypePaths.walk(MapType, long, long)"})
  void testWalkWithDataFromVersionToVersion_thenReturnNull() {
    // Arrange
    DataWalkerTypePaths<Object, Object> dataWalkerTypePaths =
        new DataWalkerTypePaths<>(MCTypeRegistry.BIOME, "Paths");

    // Act and Assert
    assertNull(dataWalkerTypePaths.walk(new NBTMapType(), 1L, 1L));
  }
}

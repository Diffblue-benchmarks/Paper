package ca.spottedleaf.dataconverter.minecraft.converters.itemstack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConverterFlattenItemStackDiffblueTest {
  /**
   * Test new {@link ConverterFlattenItemStack} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ConverterFlattenItemStack}
   */
  @Test
  @DisplayName("Test new ConverterFlattenItemStack (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConverterFlattenItemStack.<init>()"})
  void testNewConverterFlattenItemStack() {
    // Arrange and Act
    ConverterFlattenItemStack actualConverterFlattenItemStack = new ConverterFlattenItemStack();

    // Assert
    assertEquals(1451, actualConverterFlattenItemStack.getToVersion());
    assertEquals(4, actualConverterFlattenItemStack.getVersionStep());
  }

  /**
   * Test {@link ConverterFlattenItemStack#flattenItem(String, int)}.
   *
   * <p>Method under test: {@link ConverterFlattenItemStack#flattenItem(String, int)}
   */
  @Test
  @DisplayName("Test flattenItem(String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConverterFlattenItemStack.flattenItem(String, int)"})
  void testFlattenItem() {
    // Arrange, Act and Assert
    assertNull(ConverterFlattenItemStack.flattenItem("Old Name", 1));
  }

  /**
   * Test {@link ConverterFlattenItemStack#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenItemStack#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; when JsonMapType(boolean) with compressed is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterFlattenItemStack.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_whenJsonMapTypeWithCompressedIsTrue() {
    // Arrange
    ConverterFlattenItemStack converterFlattenItemStack = new ConverterFlattenItemStack();

    // Act and Assert
    assertNull(converterFlattenItemStack.convert(new JsonMapType(true), 1L, 1L));
  }

  /**
   * Test {@link ConverterFlattenItemStack#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenItemStack#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; when NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterFlattenItemStack.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_whenNBTMapType_thenReturnNull() {
    // Arrange
    ConverterFlattenItemStack converterFlattenItemStack = new ConverterFlattenItemStack();

    // Act and Assert
    assertNull(converterFlattenItemStack.convert(new NBTMapType(), 1L, 1L));
  }
}

package ca.spottedleaf.dataconverter.minecraft.converters.itemstack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConverterFlattenSpawnEggDiffblueTest {
  /**
   * Test {@link ConverterFlattenSpawnEgg#ConverterFlattenSpawnEgg(int, int)}.
   *
   * <p>Method under test: {@link ConverterFlattenSpawnEgg#ConverterFlattenSpawnEgg(int, int)}
   */
  @Test
  @DisplayName("Test new ConverterFlattenSpawnEgg(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConverterFlattenSpawnEgg.<init>(int, int)"})
  void testNewConverterFlattenSpawnEgg() {
    // Arrange and Act
    ConverterFlattenSpawnEgg actualConverterFlattenSpawnEgg = new ConverterFlattenSpawnEgg(1, 1);

    // Assert
    assertEquals(1, actualConverterFlattenSpawnEgg.getToVersion());
    assertEquals(1, actualConverterFlattenSpawnEgg.getVersionStep());
  }

  /**
   * Test {@link ConverterFlattenSpawnEgg#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterFlattenSpawnEgg#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; when NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterFlattenSpawnEgg.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_whenNBTMapType_thenReturnNull() {
    // Arrange
    ConverterFlattenSpawnEgg converterFlattenSpawnEgg = new ConverterFlattenSpawnEgg(1, 1);

    // Act and Assert
    assertNull(converterFlattenSpawnEgg.convert(new NBTMapType(), 1L, 1L));
  }
}

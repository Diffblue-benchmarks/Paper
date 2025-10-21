package ca.spottedleaf.dataconverter.minecraft.converters.itemstack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConverterEnchantmentsRenameDiffblueTest {
  /**
   * Test {@link ConverterEnchantmentsRename#ConverterEnchantmentsRename(int, int, Function)}.
   *
   * <p>Method under test: {@link ConverterEnchantmentsRename#ConverterEnchantmentsRename(int, int,
   * Function)}
   */
  @Test
  @DisplayName("Test new ConverterEnchantmentsRename(int, int, Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConverterEnchantmentsRename.<init>(int, int, Function)"})
  void testNewConverterEnchantmentsRename() {
    // Arrange and Act
    ConverterEnchantmentsRename actualConverterEnchantmentsRename =
        new ConverterEnchantmentsRename(1, 1, mock(Function.class));

    // Assert
    assertEquals(1, actualConverterEnchantmentsRename.getToVersion());
    assertEquals(1, actualConverterEnchantmentsRename.getVersionStep());
    assertEquals(4294967297L, actualConverterEnchantmentsRename.getEncodedVersion());
  }

  /**
   * Test {@link ConverterEnchantmentsRename#ConverterEnchantmentsRename(int, Function)}.
   *
   * <p>Method under test: {@link ConverterEnchantmentsRename#ConverterEnchantmentsRename(int,
   * Function)}
   */
  @Test
  @DisplayName("Test new ConverterEnchantmentsRename(int, Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConverterEnchantmentsRename.<init>(int, Function)"})
  void testNewConverterEnchantmentsRename2() {
    // Arrange and Act
    ConverterEnchantmentsRename actualConverterEnchantmentsRename =
        new ConverterEnchantmentsRename(1, mock(Function.class));

    // Assert
    assertEquals(0, actualConverterEnchantmentsRename.getVersionStep());
    assertEquals(1, actualConverterEnchantmentsRename.getToVersion());
    assertEquals(4294967296L, actualConverterEnchantmentsRename.getEncodedVersion());
  }

  /**
   * Test {@link ConverterEnchantmentsRename#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterEnchantmentsRename#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; when NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterEnchantmentsRename.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_whenNBTMapType_thenReturnNull() {
    // Arrange
    ConverterEnchantmentsRename converterEnchantmentsRename =
        new ConverterEnchantmentsRename(1, mock(Function.class));

    // Act and Assert
    assertNull(converterEnchantmentsRename.convert(new NBTMapType(), 1L, 1L));
  }
}

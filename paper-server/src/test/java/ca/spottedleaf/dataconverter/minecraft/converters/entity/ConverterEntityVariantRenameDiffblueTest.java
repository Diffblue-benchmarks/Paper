package ca.spottedleaf.dataconverter.minecraft.converters.entity;

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

class ConverterEntityVariantRenameDiffblueTest {
  /**
   * Test {@link ConverterEntityVariantRename#ConverterEntityVariantRename(int, int, Function)}.
   *
   * <ul>
   *   <li>Then return VersionStep is one.
   * </ul>
   *
   * <p>Method under test: {@link ConverterEntityVariantRename#ConverterEntityVariantRename(int,
   * int, Function)}
   */
  @Test
  @DisplayName(
      "Test new ConverterEntityVariantRename(int, int, Function); then return VersionStep is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterEntityVariantRename.<init>(int, int, Function)",
    "void ConverterEntityVariantRename.<init>(int, Function)"
  })
  void testNewConverterEntityVariantRename_thenReturnVersionStepIsOne() {
    // Arrange and Act
    ConverterEntityVariantRename actualConverterEntityVariantRename =
        new ConverterEntityVariantRename(1, 1, mock(Function.class));

    // Assert
    assertEquals(1, actualConverterEntityVariantRename.getToVersion());
    assertEquals(1, actualConverterEntityVariantRename.getVersionStep());
  }

  /**
   * Test {@link ConverterEntityVariantRename#ConverterEntityVariantRename(int, Function)}.
   *
   * <ul>
   *   <li>Then return VersionStep is zero.
   * </ul>
   *
   * <p>Method under test: {@link ConverterEntityVariantRename#ConverterEntityVariantRename(int,
   * Function)}
   */
  @Test
  @DisplayName(
      "Test new ConverterEntityVariantRename(int, Function); then return VersionStep is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterEntityVariantRename.<init>(int, int, Function)",
    "void ConverterEntityVariantRename.<init>(int, Function)"
  })
  void testNewConverterEntityVariantRename_thenReturnVersionStepIsZero() {
    // Arrange and Act
    ConverterEntityVariantRename actualConverterEntityVariantRename =
        new ConverterEntityVariantRename(1, mock(Function.class));

    // Assert
    assertEquals(0, actualConverterEntityVariantRename.getVersionStep());
    assertEquals(1, actualConverterEntityVariantRename.getToVersion());
  }

  /**
   * Test {@link ConverterEntityVariantRename#convert(MapType, long, long)} with {@code data},
   * {@code sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterEntityVariantRename#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; when NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterEntityVariantRename.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_whenNBTMapType_thenReturnNull() {
    // Arrange
    ConverterEntityVariantRename converterEntityVariantRename =
        new ConverterEntityVariantRename(1, mock(Function.class));

    // Act and Assert
    assertNull(converterEntityVariantRename.convert(new NBTMapType(), 1L, 1L));
  }
}

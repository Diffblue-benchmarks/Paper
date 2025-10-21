package ca.spottedleaf.dataconverter.minecraft.converters.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.IntFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConverterEntityToVariantDiffblueTest {
  /**
   * Test {@link ConverterEntityToVariant#ConverterEntityToVariant(int, int, String, IntFunction)}.
   *
   * <ul>
   *   <li>Then return VersionStep is one.
   * </ul>
   *
   * <p>Method under test: {@link ConverterEntityToVariant#ConverterEntityToVariant(int, int,
   * String, IntFunction)}
   */
  @Test
  @DisplayName(
      "Test new ConverterEntityToVariant(int, int, String, IntFunction); then return VersionStep is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterEntityToVariant.<init>(int, int, String, IntFunction)",
    "void ConverterEntityToVariant.<init>(int, String, IntFunction)"
  })
  void testNewConverterEntityToVariant_thenReturnVersionStepIsOne() {
    // Arrange and Act
    ConverterEntityToVariant actualConverterEntityToVariant =
        new ConverterEntityToVariant(1, 1, "Path", mock(IntFunction.class));

    // Assert
    assertEquals(1, actualConverterEntityToVariant.getToVersion());
    assertEquals(1, actualConverterEntityToVariant.getVersionStep());
  }

  /**
   * Test {@link ConverterEntityToVariant#ConverterEntityToVariant(int, String, IntFunction)}.
   *
   * <ul>
   *   <li>Then return VersionStep is zero.
   * </ul>
   *
   * <p>Method under test: {@link ConverterEntityToVariant#ConverterEntityToVariant(int, String,
   * IntFunction)}
   */
  @Test
  @DisplayName(
      "Test new ConverterEntityToVariant(int, String, IntFunction); then return VersionStep is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterEntityToVariant.<init>(int, int, String, IntFunction)",
    "void ConverterEntityToVariant.<init>(int, String, IntFunction)"
  })
  void testNewConverterEntityToVariant_thenReturnVersionStepIsZero() {
    // Arrange and Act
    ConverterEntityToVariant actualConverterEntityToVariant =
        new ConverterEntityToVariant(1, "Path", mock(IntFunction.class));

    // Assert
    assertEquals(0, actualConverterEntityToVariant.getVersionStep());
    assertEquals(1, actualConverterEntityToVariant.getToVersion());
  }

  /**
   * Test {@link ConverterEntityToVariant#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterEntityToVariant#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; when NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterEntityToVariant.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_whenNBTMapType_thenReturnNull() {
    // Arrange
    ConverterEntityToVariant converterEntityToVariant =
        new ConverterEntityToVariant(1, "Path", mock(IntFunction.class));

    // Act and Assert
    assertNull(converterEntityToVariant.convert(new NBTMapType(), 1L, 1L));
  }
}

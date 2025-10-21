package ca.spottedleaf.dataconverter.minecraft.converters.attributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.DoubleUnaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConverterEntityAttributesBaseValueUpdaterDiffblueTest {
  /**
   * Test {@link
   * ConverterEntityAttributesBaseValueUpdater#ConverterEntityAttributesBaseValueUpdater(int, int,
   * String, DoubleUnaryOperator)}.
   *
   * <ul>
   *   <li>Then return VersionStep is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConverterEntityAttributesBaseValueUpdater#ConverterEntityAttributesBaseValueUpdater(int, int,
   * String, DoubleUnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test new ConverterEntityAttributesBaseValueUpdater(int, int, String, DoubleUnaryOperator); then return VersionStep is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterEntityAttributesBaseValueUpdater.<init>(int, int, String, DoubleUnaryOperator)",
    "void ConverterEntityAttributesBaseValueUpdater.<init>(int, String, DoubleUnaryOperator)"
  })
  void testNewConverterEntityAttributesBaseValueUpdater_thenReturnVersionStepIsOne() {
    // Arrange and Act
    ConverterEntityAttributesBaseValueUpdater actualConverterEntityAttributesBaseValueUpdater =
        new ConverterEntityAttributesBaseValueUpdater(1, 1, "42", mock(DoubleUnaryOperator.class));

    // Assert
    assertEquals(1, actualConverterEntityAttributesBaseValueUpdater.getToVersion());
    assertEquals(1, actualConverterEntityAttributesBaseValueUpdater.getVersionStep());
  }

  /**
   * Test {@link
   * ConverterEntityAttributesBaseValueUpdater#ConverterEntityAttributesBaseValueUpdater(int,
   * String, DoubleUnaryOperator)}.
   *
   * <ul>
   *   <li>Then return VersionStep is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConverterEntityAttributesBaseValueUpdater#ConverterEntityAttributesBaseValueUpdater(int,
   * String, DoubleUnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test new ConverterEntityAttributesBaseValueUpdater(int, String, DoubleUnaryOperator); then return VersionStep is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterEntityAttributesBaseValueUpdater.<init>(int, int, String, DoubleUnaryOperator)",
    "void ConverterEntityAttributesBaseValueUpdater.<init>(int, String, DoubleUnaryOperator)"
  })
  void testNewConverterEntityAttributesBaseValueUpdater_thenReturnVersionStepIsZero() {
    // Arrange and Act
    ConverterEntityAttributesBaseValueUpdater actualConverterEntityAttributesBaseValueUpdater =
        new ConverterEntityAttributesBaseValueUpdater(1, "42", mock(DoubleUnaryOperator.class));

    // Assert
    assertEquals(0, actualConverterEntityAttributesBaseValueUpdater.getVersionStep());
    assertEquals(1, actualConverterEntityAttributesBaseValueUpdater.getToVersion());
  }

  /**
   * Test {@link ConverterEntityAttributesBaseValueUpdater#convert(MapType, long, long)} with {@code
   * data}, {@code sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterEntityAttributesBaseValueUpdater#convert(MapType, long,
   * long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; when NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MapType ConverterEntityAttributesBaseValueUpdater.convert(MapType, long, long)"
  })
  void testConvertWithDataSourceVersionToVersion_whenNBTMapType_thenReturnNull() {
    // Arrange
    ConverterEntityAttributesBaseValueUpdater converterEntityAttributesBaseValueUpdater =
        new ConverterEntityAttributesBaseValueUpdater(1, "42", mock(DoubleUnaryOperator.class));

    // Act and Assert
    assertNull(converterEntityAttributesBaseValueUpdater.convert(new NBTMapType(), 1L, 1L));
  }
}

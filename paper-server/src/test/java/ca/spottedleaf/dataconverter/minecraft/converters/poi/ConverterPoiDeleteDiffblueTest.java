package ca.spottedleaf.dataconverter.minecraft.converters.poi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConverterPoiDeleteDiffblueTest {
  /**
   * Test {@link ConverterPoiDelete#ConverterPoiDelete(int, int, Predicate)}.
   *
   * <ul>
   *   <li>Then return VersionStep is one.
   * </ul>
   *
   * <p>Method under test: {@link ConverterPoiDelete#ConverterPoiDelete(int, int, Predicate)}
   */
  @Test
  @DisplayName("Test new ConverterPoiDelete(int, int, Predicate); then return VersionStep is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterPoiDelete.<init>(int, int, Predicate)",
    "void ConverterPoiDelete.<init>(int, Predicate)"
  })
  void testNewConverterPoiDelete_thenReturnVersionStepIsOne() {
    // Arrange and Act
    ConverterPoiDelete actualConverterPoiDelete =
        new ConverterPoiDelete(1, 1, mock(Predicate.class));

    // Assert
    assertEquals(1, actualConverterPoiDelete.getToVersion());
    assertEquals(1, actualConverterPoiDelete.getVersionStep());
  }

  /**
   * Test {@link ConverterPoiDelete#ConverterPoiDelete(int, Predicate)}.
   *
   * <ul>
   *   <li>Then return VersionStep is zero.
   * </ul>
   *
   * <p>Method under test: {@link ConverterPoiDelete#ConverterPoiDelete(int, Predicate)}
   */
  @Test
  @DisplayName("Test new ConverterPoiDelete(int, Predicate); then return VersionStep is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterPoiDelete.<init>(int, int, Predicate)",
    "void ConverterPoiDelete.<init>(int, Predicate)"
  })
  void testNewConverterPoiDelete_thenReturnVersionStepIsZero() {
    // Arrange and Act
    ConverterPoiDelete actualConverterPoiDelete = new ConverterPoiDelete(1, mock(Predicate.class));

    // Assert
    assertEquals(0, actualConverterPoiDelete.getVersionStep());
    assertEquals(1, actualConverterPoiDelete.getToVersion());
  }

  /**
   * Test {@link ConverterPoiDelete#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterPoiDelete#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterPoiDelete.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_thenReturnNull() {
    // Arrange
    ConverterPoiDelete converterPoiDelete = new ConverterPoiDelete(0, mock(Predicate.class));

    // Act and Assert
    assertNull(converterPoiDelete.convert(new NBTMapType(), 1L, 1L));
  }
}

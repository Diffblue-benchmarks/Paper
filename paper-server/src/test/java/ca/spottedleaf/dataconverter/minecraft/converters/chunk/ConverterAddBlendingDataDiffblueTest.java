package ca.spottedleaf.dataconverter.minecraft.converters.chunk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConverterAddBlendingDataDiffblueTest {
  /**
   * Test {@link ConverterAddBlendingData#ConverterAddBlendingData(int, int)}.
   *
   * <ul>
   *   <li>Then return VersionStep is one.
   * </ul>
   *
   * <p>Method under test: {@link ConverterAddBlendingData#ConverterAddBlendingData(int, int)}
   */
  @Test
  @DisplayName("Test new ConverterAddBlendingData(int, int); then return VersionStep is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterAddBlendingData.<init>(int)",
    "void ConverterAddBlendingData.<init>(int, int)"
  })
  void testNewConverterAddBlendingData_thenReturnVersionStepIsOne() {
    // Arrange and Act
    ConverterAddBlendingData actualConverterAddBlendingData = new ConverterAddBlendingData(1, 1);

    // Assert
    assertEquals(1, actualConverterAddBlendingData.getToVersion());
    assertEquals(1, actualConverterAddBlendingData.getVersionStep());
  }

  /**
   * Test {@link ConverterAddBlendingData#ConverterAddBlendingData(int)}.
   *
   * <ul>
   *   <li>Then return VersionStep is zero.
   * </ul>
   *
   * <p>Method under test: {@link ConverterAddBlendingData#ConverterAddBlendingData(int)}
   */
  @Test
  @DisplayName("Test new ConverterAddBlendingData(int); then return VersionStep is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterAddBlendingData.<init>(int)",
    "void ConverterAddBlendingData.<init>(int, int)"
  })
  void testNewConverterAddBlendingData_thenReturnVersionStepIsZero() {
    // Arrange and Act
    ConverterAddBlendingData actualConverterAddBlendingData = new ConverterAddBlendingData(1);

    // Assert
    assertEquals(0, actualConverterAddBlendingData.getVersionStep());
    assertEquals(1, actualConverterAddBlendingData.getToVersion());
  }

  /**
   * Test {@link ConverterAddBlendingData#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link ConverterFlattenChunk#AIR}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterAddBlendingData#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; when AIR; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterAddBlendingData.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_whenAir_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ConverterAddBlendingData(1).convert(ConverterFlattenChunk.AIR, 1L, 1L));
  }

  /**
   * Test {@link ConverterAddBlendingData#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterAddBlendingData#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; when JsonMapType(boolean) with compressed is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterAddBlendingData.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_whenJsonMapTypeWithCompressedIsTrue() {
    // Arrange
    ConverterAddBlendingData converterAddBlendingData = new ConverterAddBlendingData(1);

    // Act and Assert
    assertNull(converterAddBlendingData.convert(new JsonMapType(true), 1L, 1L));
  }
}

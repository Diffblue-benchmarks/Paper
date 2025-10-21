package ca.spottedleaf.dataconverter.minecraft.converters.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import ca.spottedleaf.dataconverter.converters.DataConverter;
import ca.spottedleaf.dataconverter.types.MapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConverterFlattenStatsDiffblueTest {
  /**
   * Test {@link ConverterFlattenStats#makeStatsConverter()}.
   *
   * <p>Method under test: {@link ConverterFlattenStats#makeStatsConverter()}
   */
  @Test
  @DisplayName("Test makeStatsConverter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataConverter ConverterFlattenStats.makeStatsConverter()"})
  void testMakeStatsConverter() {
    // Arrange and Act
    DataConverter<MapType, MapType> actualMakeStatsConverterResult =
        ConverterFlattenStats.makeStatsConverter();

    // Assert
    assertEquals(1451, actualMakeStatsConverterResult.getToVersion());
    assertEquals(6, actualMakeStatsConverterResult.getVersionStep());
    assertEquals(6231997546502L, actualMakeStatsConverterResult.getEncodedVersion());
  }

  /**
   * Test {@link ConverterFlattenStats#makeObjectiveConverter()}.
   *
   * <p>Method under test: {@link ConverterFlattenStats#makeObjectiveConverter()}
   */
  @Test
  @DisplayName("Test makeObjectiveConverter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataConverter ConverterFlattenStats.makeObjectiveConverter()"})
  void testMakeObjectiveConverter() {
    // Arrange and Act
    DataConverter<MapType, MapType> actualMakeObjectiveConverterResult =
        ConverterFlattenStats.makeObjectiveConverter();

    // Assert
    assertEquals(1451, actualMakeObjectiveConverterResult.getToVersion());
    assertEquals(6, actualMakeObjectiveConverterResult.getVersionStep());
    assertEquals(6231997546502L, actualMakeObjectiveConverterResult.getEncodedVersion());
  }
}

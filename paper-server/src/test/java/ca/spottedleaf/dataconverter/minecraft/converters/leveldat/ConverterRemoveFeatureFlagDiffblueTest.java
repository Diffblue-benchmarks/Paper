package ca.spottedleaf.dataconverter.minecraft.converters.leveldat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConverterRemoveFeatureFlagDiffblueTest {
  /**
   * Test {@link ConverterRemoveFeatureFlag#ConverterRemoveFeatureFlag(int, int, Set)}.
   *
   * <ul>
   *   <li>Then return VersionStep is one.
   * </ul>
   *
   * <p>Method under test: {@link ConverterRemoveFeatureFlag#ConverterRemoveFeatureFlag(int, int,
   * Set)}
   */
  @Test
  @DisplayName("Test new ConverterRemoveFeatureFlag(int, int, Set); then return VersionStep is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterRemoveFeatureFlag.<init>(int, int, Set)",
    "void ConverterRemoveFeatureFlag.<init>(int, Set)"
  })
  void testNewConverterRemoveFeatureFlag_thenReturnVersionStepIsOne() {
    // Arrange and Act
    ConverterRemoveFeatureFlag actualConverterRemoveFeatureFlag =
        new ConverterRemoveFeatureFlag(1, 1, new HashSet<>());

    // Assert
    assertEquals(1, actualConverterRemoveFeatureFlag.getToVersion());
    assertEquals(1, actualConverterRemoveFeatureFlag.getVersionStep());
  }

  /**
   * Test {@link ConverterRemoveFeatureFlag#ConverterRemoveFeatureFlag(int, Set)}.
   *
   * <ul>
   *   <li>Then return VersionStep is zero.
   * </ul>
   *
   * <p>Method under test: {@link ConverterRemoveFeatureFlag#ConverterRemoveFeatureFlag(int, Set)}
   */
  @Test
  @DisplayName("Test new ConverterRemoveFeatureFlag(int, Set); then return VersionStep is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterRemoveFeatureFlag.<init>(int, int, Set)",
    "void ConverterRemoveFeatureFlag.<init>(int, Set)"
  })
  void testNewConverterRemoveFeatureFlag_thenReturnVersionStepIsZero() {
    // Arrange and Act
    ConverterRemoveFeatureFlag actualConverterRemoveFeatureFlag =
        new ConverterRemoveFeatureFlag(1, new HashSet<>());

    // Assert
    assertEquals(0, actualConverterRemoveFeatureFlag.getVersionStep());
    assertEquals(1, actualConverterRemoveFeatureFlag.getToVersion());
  }

  /**
   * Test {@link ConverterRemoveFeatureFlag#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterRemoveFeatureFlag#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; when NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterRemoveFeatureFlag.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_whenNBTMapType_thenReturnNull() {
    // Arrange
    ConverterRemoveFeatureFlag converterRemoveFeatureFlag =
        new ConverterRemoveFeatureFlag(1, new HashSet<>());

    // Act and Assert
    assertNull(converterRemoveFeatureFlag.convert(new NBTMapType(), 1L, 1L));
  }
}

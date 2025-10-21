package ca.spottedleaf.dataconverter.minecraft.converters.advancements;

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

class ConverterCriteriaRenameDiffblueTest {
  /**
   * Test {@link ConverterCriteriaRename#ConverterCriteriaRename(int, int, String, Function)}.
   *
   * <ul>
   *   <li>Then return VersionStep is one.
   * </ul>
   *
   * <p>Method under test: {@link ConverterCriteriaRename#ConverterCriteriaRename(int, int, String,
   * Function)}
   */
  @Test
  @DisplayName(
      "Test new ConverterCriteriaRename(int, int, String, Function); then return VersionStep is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterCriteriaRename.<init>(int, int, String, Function)",
    "void ConverterCriteriaRename.<init>(int, String, Function)"
  })
  void testNewConverterCriteriaRename_thenReturnVersionStepIsOne() {
    // Arrange and Act
    ConverterCriteriaRename actualConverterCriteriaRename =
        new ConverterCriteriaRename(1, 1, "Path", mock(Function.class));

    // Assert
    assertEquals(1, actualConverterCriteriaRename.getToVersion());
    assertEquals(1, actualConverterCriteriaRename.getVersionStep());
  }

  /**
   * Test {@link ConverterCriteriaRename#ConverterCriteriaRename(int, String, Function)}.
   *
   * <ul>
   *   <li>Then return VersionStep is zero.
   * </ul>
   *
   * <p>Method under test: {@link ConverterCriteriaRename#ConverterCriteriaRename(int, String,
   * Function)}
   */
  @Test
  @DisplayName(
      "Test new ConverterCriteriaRename(int, String, Function); then return VersionStep is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterCriteriaRename.<init>(int, int, String, Function)",
    "void ConverterCriteriaRename.<init>(int, String, Function)"
  })
  void testNewConverterCriteriaRename_thenReturnVersionStepIsZero() {
    // Arrange and Act
    ConverterCriteriaRename actualConverterCriteriaRename =
        new ConverterCriteriaRename(1, "Path", mock(Function.class));

    // Assert
    assertEquals(0, actualConverterCriteriaRename.getVersionStep());
    assertEquals(1, actualConverterCriteriaRename.getToVersion());
  }

  /**
   * Test {@link ConverterCriteriaRename#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterCriteriaRename#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; when NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterCriteriaRename.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_whenNBTMapType_thenReturnNull() {
    // Arrange
    ConverterCriteriaRename converterCriteriaRename =
        new ConverterCriteriaRename(1, "Path", mock(Function.class));

    // Act and Assert
    assertNull(converterCriteriaRename.convert(new NBTMapType(), 1L, 1L));
  }
}

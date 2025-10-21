package ca.spottedleaf.dataconverter.minecraft.converters.chunk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import ca.spottedleaf.dataconverter.types.MapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConverterRenameStatusDiffblueTest {
  /**
   * Test {@link ConverterRenameStatus#ConverterRenameStatus(int, int, Function)}.
   *
   * <ul>
   *   <li>Then return VersionStep is one.
   * </ul>
   *
   * <p>Method under test: {@link ConverterRenameStatus#ConverterRenameStatus(int, int, Function)}
   */
  @Test
  @DisplayName("Test new ConverterRenameStatus(int, int, Function); then return VersionStep is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterRenameStatus.<init>(int, int, Function)",
    "void ConverterRenameStatus.<init>(int, Function)"
  })
  void testNewConverterRenameStatus_thenReturnVersionStepIsOne() {
    // Arrange and Act
    ConverterRenameStatus actualConverterRenameStatus =
        new ConverterRenameStatus(1, 1, mock(Function.class));

    // Assert
    assertEquals(1, actualConverterRenameStatus.getToVersion());
    assertEquals(1, actualConverterRenameStatus.getVersionStep());
  }

  /**
   * Test {@link ConverterRenameStatus#ConverterRenameStatus(int, Function)}.
   *
   * <ul>
   *   <li>Then return VersionStep is zero.
   * </ul>
   *
   * <p>Method under test: {@link ConverterRenameStatus#ConverterRenameStatus(int, Function)}
   */
  @Test
  @DisplayName("Test new ConverterRenameStatus(int, Function); then return VersionStep is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterRenameStatus.<init>(int, int, Function)",
    "void ConverterRenameStatus.<init>(int, Function)"
  })
  void testNewConverterRenameStatus_thenReturnVersionStepIsZero() {
    // Arrange and Act
    ConverterRenameStatus actualConverterRenameStatus =
        new ConverterRenameStatus(1, mock(Function.class));

    // Assert
    assertEquals(0, actualConverterRenameStatus.getVersionStep());
    assertEquals(1, actualConverterRenameStatus.getToVersion());
  }

  /**
   * Test {@link ConverterRenameStatus#convert(MapType, long, long)} with {@code data}, {@code
   * sourceVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link ConverterFlattenChunk#AIR}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterRenameStatus#convert(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(MapType, long, long) with 'data', 'sourceVersion', 'toVersion'; when AIR; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType ConverterRenameStatus.convert(MapType, long, long)"})
  void testConvertWithDataSourceVersionToVersion_whenAir_thenReturnNull() {
    // Arrange
    ConverterRenameStatus converterRenameStatus =
        new ConverterRenameStatus(1, mock(Function.class));

    // Act and Assert
    assertNull(converterRenameStatus.convert(ConverterFlattenChunk.AIR, 1L, 1L));
  }
}

package ca.spottedleaf.dataconverter.converters.datatypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.minecraft.datatypes.MCTypeRegistry;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class DataTypeDiffblueTest {
  /**
   * Test {@link DataType#convertOrOriginal(Object, long, long)}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#TEXT_COMPONENT}.
   *   <li>When {@code true}.
   *   <li>Then return {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link DataType#convertOrOriginal(Object, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertOrOriginal(Object, long, long); given TEXT_COMPONENT; when 'true'; then return TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataType.convertOrOriginal(Object, long, long)"})
  void testConvertOrOriginal_givenText_component_whenTrue_thenReturnTrueToString() {
    // Arrange, Act and Assert
    assertEquals(
        Boolean.TRUE.toString(),
        MCTypeRegistry.TEXT_COMPONENT.convertOrOriginal(true, 1L, Long.MAX_VALUE));
  }

  /**
   * Test {@link DataType#convertOrOriginal(Object, long, long)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataType#convertOrOriginal(Object, long, long)}
   */
  @Test
  @DisplayName("Test convertOrOriginal(Object, long, long); when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataType.convertOrOriginal(Object, long, long)"})
  void testConvertOrOriginal_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (Boolean)
            MCTypeRegistry.DATACONVERTER_CUSTOM_TYPE_COMMAND.convertOrOriginal(
                false, 1L, Long.MAX_VALUE));
  }

  /**
   * Test {@link DataType#convertOrOriginal(Object, long, long)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataType#convertOrOriginal(Object, long, long)}
   */
  @Test
  @DisplayName("Test convertOrOriginal(Object, long, long); when 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataType.convertOrOriginal(Object, long, long)"})
  void testConvertOrOriginal_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (Boolean)
            MCTypeRegistry.DATACONVERTER_CUSTOM_TYPE_COMMAND.convertOrOriginal(
                true, 1L, Long.MAX_VALUE));
  }

  /**
   * Test {@link DataType#convertOrOriginal(Object, long, long)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link DataType#convertOrOriginal(Object, long, long)}
   */
  @Test
  @DisplayName(
      "Test convertOrOriginal(Object, long, long); when WILDCARD_OBJECT; then return WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataType.convertOrOriginal(Object, long, long)"})
  void testConvertOrOriginal_whenWildcard_object_thenReturnWildcard_object() {
    // Arrange
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Object actualConvertOrOriginalResult =
        MCTypeRegistry.DATACONVERTER_CUSTOM_TYPE_COMMAND.convertOrOriginal(object, 1L, 1L);

    // Assert
    assertSame(object, actualConvertOrOriginalResult);
  }
}

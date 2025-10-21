package ca.spottedleaf.dataconverter.minecraft.converters.helpers;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import ca.spottedleaf.dataconverter.converters.DataConverter;
import ca.spottedleaf.dataconverter.minecraft.datatypes.MCValueType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConverterAbstractStringValueTypeRenameDiffblueTest {
  /**
   * Test {@link ConverterAbstractStringValueTypeRename#register(int, int, MCValueType, Function)}
   * with {@code version}, {@code subVersion}, {@code type}, {@code renamer}.
   *
   * <ul>
   *   <li>Then calls {@link MCValueType#addConverter(DataConverter)}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterAbstractStringValueTypeRename#register(int, int,
   * MCValueType, Function)}
   */
  @Test
  @DisplayName(
      "Test register(int, int, MCValueType, Function) with 'version', 'subVersion', 'type', 'renamer'; then calls addConverter(DataConverter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterAbstractStringValueTypeRename.register(int, int, MCValueType, Function)"
  })
  void testRegisterWithVersionSubVersionTypeRenamer_thenCallsAddConverter() {
    // Arrange
    MCValueType type = mock(MCValueType.class);
    doNothing().when(type).addConverter(Mockito.<DataConverter<Object, Object>>any());

    // Act
    ConverterAbstractStringValueTypeRename.register(
        1, 1, type, HelperBlockFlatteningV1450::getNewBlockName);

    // Assert
    verify(type).addConverter(isA(DataConverter.class));
  }

  /**
   * Test {@link ConverterAbstractStringValueTypeRename#register(int, MCValueType, Function)} with
   * {@code version}, {@code type}, {@code renamer}.
   *
   * <ul>
   *   <li>Then calls {@link MCValueType#addConverter(DataConverter)}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterAbstractStringValueTypeRename#register(int, MCValueType,
   * Function)}
   */
  @Test
  @DisplayName(
      "Test register(int, MCValueType, Function) with 'version', 'type', 'renamer'; then calls addConverter(DataConverter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterAbstractStringValueTypeRename.register(int, MCValueType, Function)"
  })
  void testRegisterWithVersionTypeRenamer_thenCallsAddConverter() {
    // Arrange
    MCValueType type = mock(MCValueType.class);
    doNothing().when(type).addConverter(Mockito.<DataConverter<Object, Object>>any());

    // Act
    ConverterAbstractStringValueTypeRename.register(
        1, type, HelperBlockFlatteningV1450::getNewBlockName);

    // Assert
    verify(type).addConverter(isA(DataConverter.class));
  }
}

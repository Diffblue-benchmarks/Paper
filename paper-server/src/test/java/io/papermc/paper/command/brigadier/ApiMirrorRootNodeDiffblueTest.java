package io.papermc.paper.command.brigadier;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.brigadier.arguments.ArgumentType;
import io.papermc.paper.command.brigadier.argument.VanillaArgumentProviderImpl;
import io.papermc.paper.command.brigadier.argument.VanillaArgumentProviderImpl.NativeWrapperArgumentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ApiMirrorRootNodeDiffblueTest {
  /**
   * Test {@link ApiMirrorRootNode#validatePrimitiveType(ArgumentType)}.
   *
   * <ul>
   *   <li>Given {@link ArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link ApiMirrorRootNode#validatePrimitiveType(ArgumentType)}
   */
  @Test
  @DisplayName("Test validatePrimitiveType(ArgumentType); given ArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiMirrorRootNode.validatePrimitiveType(ArgumentType)"})
  void testValidatePrimitiveType_givenArgumentType() {
    // Arrange
    NativeWrapperArgumentType<Object, ?> type = mock(NativeWrapperArgumentType.class);
    when(type.nativeNmsArgumentType()).thenReturn(mock(ArgumentType.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> ApiMirrorRootNode.validatePrimitiveType(type));
    verify(type).nativeNmsArgumentType();
  }

  /**
   * Test {@link ApiMirrorRootNode#validatePrimitiveType(ArgumentType)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiMirrorRootNode#validatePrimitiveType(ArgumentType)}
   */
  @Test
  @DisplayName("Test validatePrimitiveType(ArgumentType); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiMirrorRootNode.validatePrimitiveType(ArgumentType)"})
  void testValidatePrimitiveType_givenIllegalArgumentException() {
    // Arrange
    NativeWrapperArgumentType<Object, ?> type = mock(NativeWrapperArgumentType.class);
    when(type.nativeNmsArgumentType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> ApiMirrorRootNode.validatePrimitiveType(type));
    verify(type).nativeNmsArgumentType();
  }

  /**
   * Test {@link ApiMirrorRootNode#validatePrimitiveType(ArgumentType)}.
   *
   * <ul>
   *   <li>When {@link ArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link ApiMirrorRootNode#validatePrimitiveType(ArgumentType)}
   */
  @Test
  @DisplayName("Test validatePrimitiveType(ArgumentType); when ArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiMirrorRootNode.validatePrimitiveType(ArgumentType)"})
  void testValidatePrimitiveType_whenArgumentType() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ApiMirrorRootNode.validatePrimitiveType(mock(ArgumentType.class)));
  }
}

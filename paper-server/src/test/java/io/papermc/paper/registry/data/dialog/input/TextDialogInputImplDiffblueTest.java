package io.papermc.paper.registry.data.dialog.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.data.dialog.input.TextDialogInput.Builder;
import io.papermc.paper.registry.data.dialog.input.TextDialogInputImpl.BuilderImpl;
import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TextDialogInputImplDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#build()}.
   *
   * <p>Method under test: {@link BuilderImpl#build()}
   */
  @Test
  @DisplayName("Test BuilderImpl build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TextDialogInput BuilderImpl.build()",
    "Builder BuilderImpl.initial(String)",
    "Builder BuilderImpl.labelVisible(boolean)",
    "Builder BuilderImpl.multiline(TextDialogInput.MultilineOptions)"
  })
  void testBuilderImplBuild() {
    // Arrange and Act
    BuilderImpl actualBuilderImpl = new BuilderImpl("Key", mock(Component.class));
    TextDialogInput actualTextDialogInput = actualBuilderImpl.build();

    // Assert
    assertTrue(actualTextDialogInput instanceof TextDialogInputImpl);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#maxLength(int)}.
   *
   * <p>Method under test: {@link BuilderImpl#maxLength(int)}
   */
  @Test
  @DisplayName("Test BuilderImpl maxLength(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.maxLength(int)"})
  void testBuilderImplMaxLength() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl("Key", mock(Component.class));

    // Act
    Builder actualMaxLengthResult = builderImpl.maxLength(3);

    // Assert
    TextDialogInput textDialogInput = builderImpl.build();
    assertTrue(textDialogInput instanceof TextDialogInputImpl);
    assertEquals(3, textDialogInput.maxLength());
    assertSame(builderImpl, actualMaxLengthResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#BuilderImpl(String, Component)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then build return {@link TextDialogInputImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#BuilderImpl(String, Component)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl new BuilderImpl(String, Component); when 'Key'; then build return TextDialogInputImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuilderImpl.<init>(String, Component)"})
  void testBuilderImplNewBuilderImpl_whenKey_thenBuildReturnTextDialogInputImpl() {
    // Arrange
    Component label = mock(Component.class);

    // Act
    BuilderImpl actualBuilderImpl = new BuilderImpl("Key", label);

    // Assert
    TextDialogInput textDialogInput = actualBuilderImpl.build();
    assertTrue(textDialogInput instanceof TextDialogInputImpl);
    assertEquals("", textDialogInput.initial());
    assertEquals("Key", textDialogInput.key());
    assertNull(textDialogInput.multiline());
    assertEquals(200, textDialogInput.width());
    assertTrue(textDialogInput.labelVisible());
    assertEquals(Integer.SIZE, textDialogInput.maxLength());
    assertSame(label, textDialogInput.label());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#width(int)}.
   *
   * <p>Method under test: {@link BuilderImpl#width(int)}
   */
  @Test
  @DisplayName("Test BuilderImpl width(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.width(int)"})
  void testBuilderImplWidth() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl("Key", mock(Component.class));

    // Act
    Builder actualWidthResult = builderImpl.width(1);

    // Assert
    TextDialogInput textDialogInput = builderImpl.build();
    assertTrue(textDialogInput instanceof TextDialogInputImpl);
    assertEquals(1, textDialogInput.width());
    assertSame(builderImpl, actualWidthResult);
  }
}

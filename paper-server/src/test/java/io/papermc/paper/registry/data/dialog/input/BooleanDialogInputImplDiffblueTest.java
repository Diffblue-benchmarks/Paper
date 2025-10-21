package io.papermc.paper.registry.data.dialog.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.data.dialog.input.BooleanDialogInputImpl.BuilderImpl;
import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BooleanDialogInputImplDiffblueTest {
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
    "BooleanDialogInput BuilderImpl.build()",
    "BooleanDialogInput.Builder BuilderImpl.initial(boolean)",
    "BooleanDialogInput.Builder BuilderImpl.onFalse(String)",
    "BooleanDialogInput.Builder BuilderImpl.onTrue(String)"
  })
  void testBuilderImplBuild() {
    // Arrange and Act
    BuilderImpl actualBuilderImpl = new BuilderImpl("Key", mock(Component.class));
    BooleanDialogInput actualBooleanDialogInput = actualBuilderImpl.build();

    // Assert
    assertTrue(actualBooleanDialogInput instanceof BooleanDialogInputImpl);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#BuilderImpl(String, Component)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then build return {@link BooleanDialogInputImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#BuilderImpl(String, Component)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl new BuilderImpl(String, Component); when 'Key'; then build return BooleanDialogInputImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuilderImpl.<init>(String, Component)"})
  void testBuilderImplNewBuilderImpl_whenKey_thenBuildReturnBooleanDialogInputImpl() {
    // Arrange
    Component label = mock(Component.class);

    // Act
    BuilderImpl actualBuilderImpl = new BuilderImpl("Key", label);

    // Assert
    BooleanDialogInput booleanDialogInput = actualBuilderImpl.build();
    assertTrue(booleanDialogInput instanceof BooleanDialogInputImpl);
    assertEquals("Key", booleanDialogInput.key());
    assertFalse(booleanDialogInput.initial());
    String expectedOnFalseResult = Boolean.FALSE.toString();
    assertEquals(expectedOnFalseResult, booleanDialogInput.onFalse());
    String expectedOnTrueResult = Boolean.TRUE.toString();
    assertEquals(expectedOnTrueResult, booleanDialogInput.onTrue());
    assertSame(label, booleanDialogInput.label());
  }
}

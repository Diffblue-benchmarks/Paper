package io.papermc.paper.registry.data.dialog.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.data.dialog.input.NumberRangeDialogInputImpl.BuilderImpl;
import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NumberRangeDialogInputImplDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#build()}.
   *
   * <p>Method under test: {@link BuilderImpl#build()}
   */
  @Test
  @DisplayName("Test BuilderImpl build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NumberRangeDialogInput BuilderImpl.build()"})
  void testBuilderImplBuild() {
    // Arrange and Act
    BuilderImpl actualBuilderImpl = new BuilderImpl("Key", mock(Component.class), 10.0f, 10.0f);
    NumberRangeDialogInput actualNumberRangeDialogInput =
        actualBuilderImpl.initial(10.0f).labelFormat("Label Format").step(10.0f).width(1).build();

    // Assert
    assertTrue(actualNumberRangeDialogInput instanceof NumberRangeDialogInputImpl);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#initial(Float)}.
   *
   * <p>Method under test: {@link BuilderImpl#initial(Float)}
   */
  @Test
  @DisplayName("Test BuilderImpl initial(Float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderImpl BuilderImpl.initial(Float)"})
  void testBuilderImplInitial() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl("Key", mock(Component.class), 10.0f, 10.0f);

    // Act
    BuilderImpl actualInitialResult = builderImpl.initial(10.0f);

    // Assert
    NumberRangeDialogInput numberRangeDialogInput = builderImpl.build();
    assertTrue(numberRangeDialogInput instanceof NumberRangeDialogInputImpl);
    assertEquals(10.0f, numberRangeDialogInput.initial().floatValue());
    assertSame(builderImpl, actualInitialResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#initial(Float)}.
   *
   * <p>Method under test: {@link BuilderImpl#initial(Float)}
   */
  @Test
  @DisplayName("Test BuilderImpl initial(Float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderImpl BuilderImpl.initial(Float)"})
  void testBuilderImplInitial2() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl("Key", mock(Component.class), 10.0f, 10.0f);

    // Act
    BuilderImpl actualInitialResult = builderImpl.initial(null);

    // Assert
    NumberRangeDialogInput numberRangeDialogInput = builderImpl.build();
    assertTrue(numberRangeDialogInput instanceof NumberRangeDialogInputImpl);
    assertNull(numberRangeDialogInput.initial());
    assertSame(builderImpl, actualInitialResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#labelFormat(String)}.
   *
   * <p>Method under test: {@link BuilderImpl#labelFormat(String)}
   */
  @Test
  @DisplayName("Test BuilderImpl labelFormat(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderImpl BuilderImpl.labelFormat(String)"})
  void testBuilderImplLabelFormat() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl("Key", mock(Component.class), 10.0f, 10.0f);

    // Act
    BuilderImpl actualLabelFormatResult = builderImpl.labelFormat("Label Format");

    // Assert
    NumberRangeDialogInput numberRangeDialogInput = builderImpl.build();
    assertTrue(numberRangeDialogInput instanceof NumberRangeDialogInputImpl);
    assertEquals("Label Format", numberRangeDialogInput.labelFormat());
    assertSame(builderImpl, actualLabelFormatResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#BuilderImpl(String, Component, float, float)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then build return {@link NumberRangeDialogInputImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#BuilderImpl(String, Component, float, float)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl new BuilderImpl(String, Component, float, float); when 'Key'; then build return NumberRangeDialogInputImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuilderImpl.<init>(String, Component, float, float)"})
  void testBuilderImplNewBuilderImpl_whenKey_thenBuildReturnNumberRangeDialogInputImpl() {
    // Arrange
    Component label = mock(Component.class);

    // Act
    BuilderImpl actualBuilderImpl = new BuilderImpl("Key", label, 10.0f, 10.0f);

    // Assert
    NumberRangeDialogInput numberRangeDialogInput = actualBuilderImpl.build();
    assertTrue(numberRangeDialogInput instanceof NumberRangeDialogInputImpl);
    assertEquals("Key", numberRangeDialogInput.key());
    assertEquals("options.generic_value", numberRangeDialogInput.labelFormat());
    assertNull(numberRangeDialogInput.initial());
    assertNull(numberRangeDialogInput.step());
    assertEquals(10.0f, numberRangeDialogInput.end());
    assertEquals(10.0f, numberRangeDialogInput.start());
    assertEquals(200, numberRangeDialogInput.width());
    assertSame(label, numberRangeDialogInput.label());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#step(Float)}.
   *
   * <p>Method under test: {@link BuilderImpl#step(Float)}
   */
  @Test
  @DisplayName("Test BuilderImpl step(Float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderImpl BuilderImpl.step(Float)"})
  void testBuilderImplStep() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl("Key", mock(Component.class), 10.0f, 10.0f);

    // Act
    BuilderImpl actualStepResult = builderImpl.step(10.0f);

    // Assert
    NumberRangeDialogInput numberRangeDialogInput = builderImpl.build();
    assertTrue(numberRangeDialogInput instanceof NumberRangeDialogInputImpl);
    assertEquals(10.0f, numberRangeDialogInput.step().floatValue());
    assertSame(builderImpl, actualStepResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#step(Float)}.
   *
   * <p>Method under test: {@link BuilderImpl#step(Float)}
   */
  @Test
  @DisplayName("Test BuilderImpl step(Float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderImpl BuilderImpl.step(Float)"})
  void testBuilderImplStep2() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl("Key", mock(Component.class), 10.0f, 10.0f);

    // Act
    BuilderImpl actualStepResult = builderImpl.step(null);

    // Assert
    NumberRangeDialogInput numberRangeDialogInput = builderImpl.build();
    assertTrue(numberRangeDialogInput instanceof NumberRangeDialogInputImpl);
    assertNull(numberRangeDialogInput.step());
    assertSame(builderImpl, actualStepResult);
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
  @MethodsUnderTest({"BuilderImpl BuilderImpl.width(int)"})
  void testBuilderImplWidth() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl("Key", mock(Component.class), 10.0f, 10.0f);

    // Act
    BuilderImpl actualWidthResult = builderImpl.width(1);

    // Assert
    NumberRangeDialogInput numberRangeDialogInput = builderImpl.build();
    assertTrue(numberRangeDialogInput instanceof NumberRangeDialogInputImpl);
    assertEquals(1, numberRangeDialogInput.width());
    assertSame(builderImpl, actualWidthResult);
  }
}

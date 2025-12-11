package io.papermc.paper.registry.data.dialog.input;

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
    BuilderImpl actualInitialResult = builderImpl.initial(null);

    // Assert
    NumberRangeDialogInput numberRangeDialogInput = builderImpl.build();
    assertTrue(numberRangeDialogInput instanceof NumberRangeDialogInputImpl);
    assertNull(numberRangeDialogInput.initial());
    assertSame(builderImpl, actualInitialResult);
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
    BuilderImpl actualStepResult = builderImpl.step(null);

    // Assert
    NumberRangeDialogInput numberRangeDialogInput = builderImpl.build();
    assertTrue(numberRangeDialogInput instanceof NumberRangeDialogInputImpl);
    assertNull(numberRangeDialogInput.step());
    assertSame(builderImpl, actualStepResult);
  }
}

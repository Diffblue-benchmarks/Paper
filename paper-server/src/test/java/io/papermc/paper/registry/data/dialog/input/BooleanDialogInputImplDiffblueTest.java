package io.papermc.paper.registry.data.dialog.input;

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
    "BooleanDialogInput.Builder BuilderImpl.onFalse(java.lang.String)",
    "BooleanDialogInput.Builder BuilderImpl.onTrue(java.lang.String)"
  })
  void testBuilderImplBuild() {
    // Arrange and Act
    BuilderImpl actualBuilderImpl = new BuilderImpl("Key", mock(Component.class));
    BooleanDialogInput actualBooleanDialogInput = actualBuilderImpl.build();

    // Assert
    assertTrue(actualBooleanDialogInput instanceof BooleanDialogInputImpl);
  }
}

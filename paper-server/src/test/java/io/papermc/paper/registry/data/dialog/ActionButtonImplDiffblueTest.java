package io.papermc.paper.registry.data.dialog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.data.dialog.ActionButton.Builder;
import io.papermc.paper.registry.data.dialog.ActionButtonImpl.BuilderImpl;
import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ActionButtonImplDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BuilderImpl#build()}
   *   <li>{@link BuilderImpl#BuilderImpl(Component)}
   * </ul>
   */
  @Test
  @DisplayName("Test BuilderImpl build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BuilderImpl.<init>(Component)",
    "Builder BuilderImpl.action(io.papermc.paper.registry.data.dialog.action.DialogAction)",
    "ActionButton BuilderImpl.build()",
    "Builder BuilderImpl.tooltip(Component)"
  })
  void testBuilderImplBuild() {
    // Arrange and Act
    ActionButton actualActionButton = new BuilderImpl(mock(Component.class)).build();

    // Assert
    assertTrue(actualActionButton instanceof ActionButtonImpl);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#width(int)}.
   *
   * <ul>
   *   <li>Then {@link BuilderImpl#BuilderImpl(Component)} with label is {@link Component} build
   *       {@link ActionButtonImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#width(int)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl width(int); then BuilderImpl(Component) with label is Component build ActionButtonImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.width(int)"})
  void testBuilderImplWidth_thenBuilderImplWithLabelIsComponentBuildActionButtonImpl() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl(mock(Component.class));

    // Act
    Builder actualWidthResult = builderImpl.width(1);

    // Assert
    ActionButton actionButton = builderImpl.build();
    assertTrue(actionButton instanceof ActionButtonImpl);
    assertEquals(1, actionButton.width());
    assertSame(builderImpl, actualWidthResult);
  }
}

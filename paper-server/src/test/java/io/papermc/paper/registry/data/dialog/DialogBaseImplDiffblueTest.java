package io.papermc.paper.registry.data.dialog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.data.dialog.DialogBase.DialogAfterAction;
import io.papermc.paper.registry.data.dialog.DialogBaseImpl.BuilderImpl;
import io.papermc.paper.registry.data.dialog.body.DialogBody;
import io.papermc.paper.registry.data.dialog.body.PlainMessageBodyImpl;
import io.papermc.paper.registry.data.dialog.input.BooleanDialogInputImpl;
import io.papermc.paper.registry.data.dialog.input.DialogInput;
import java.util.ArrayList;
import java.util.List;
import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DialogBaseImplDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#body(List)}.
   *
   * <ul>
   *   <li>Then return build body size is two.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#body(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl body(List); then return build body size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderImpl BuilderImpl.body(List)"})
  void testBuilderImplBody_thenReturnBuildBodySizeIsTwo() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl(mock(Component.class));

    ArrayList<DialogBody> body = new ArrayList<>();
    body.add(new PlainMessageBodyImpl(mock(Component.class)));
    PlainMessageBodyImpl plainMessageBodyImpl = new PlainMessageBodyImpl(mock(Component.class));
    body.add(plainMessageBodyImpl);

    // Act and Assert
    DialogBase dialogBase = builderImpl.body(body).build();
    assertTrue(dialogBase instanceof DialogBaseImpl);
    List<DialogBody> bodyResult = dialogBase.body();
    assertEquals(2, bodyResult.size());
    DialogBody getResult = bodyResult.get(1);
    assertTrue(getResult instanceof PlainMessageBodyImpl);
    assertEquals(200, ((PlainMessageBodyImpl) getResult).width());
    assertSame(plainMessageBodyImpl, getResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#body(List)}.
   *
   * <ul>
   *   <li>Then return build inputs Empty.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#body(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl body(List); then return build inputs Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderImpl BuilderImpl.body(List)"})
  void testBuilderImplBody_thenReturnBuildInputsEmpty() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl(mock(Component.class));

    ArrayList<DialogBody> body = new ArrayList<>();
    body.add(new PlainMessageBodyImpl(mock(Component.class)));

    // Act and Assert
    DialogBase dialogBase = builderImpl.body(body).build();
    assertTrue(dialogBase instanceof DialogBaseImpl);
    assertTrue(dialogBase.inputs().isEmpty());
    assertEquals(body, dialogBase.body());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#body(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link BuilderImpl#BuilderImpl(Component)} with title is {@link Component}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#body(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl body(List); when ArrayList(); then return BuilderImpl(Component) with title is Component")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderImpl BuilderImpl.body(List)"})
  void testBuilderImplBody_whenArrayList_thenReturnBuilderImplWithTitleIsComponent() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl(mock(Component.class));

    // Act
    BuilderImpl actualBodyResult = builderImpl.body(new ArrayList<>());

    // Assert
    assertSame(builderImpl, actualBodyResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#build()}.
   *
   * <p>Method under test: {@link BuilderImpl#build()}
   */
  @Test
  @DisplayName("Test BuilderImpl build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DialogBase BuilderImpl.build()"})
  void testBuilderImplBuild() {
    // Arrange and Act
    BuilderImpl actualAfterActionResult =
        new BuilderImpl(mock(Component.class)).afterAction(DialogAfterAction.CLOSE);
    BuilderImpl actualExternalTitleResult =
        actualAfterActionResult
            .body(new ArrayList<>())
            .canCloseWithEscape(true)
            .externalTitle(mock(Component.class));
    DialogBase actualDialogBase =
        actualExternalTitleResult.inputs(new ArrayList<>()).pause(true).build();

    // Assert
    assertTrue(actualDialogBase instanceof DialogBaseImpl);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#inputs(List)}.
   *
   * <ul>
   *   <li>Then return build inputs is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#inputs(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl inputs(List); then return build inputs is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderImpl BuilderImpl.inputs(List)"})
  void testBuilderImplInputs_thenReturnBuildInputsIsArrayList() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl(mock(Component.class));

    ArrayList<DialogInput> inputs = new ArrayList<>();
    BooleanDialogInputImpl booleanDialogInputImpl =
        new BooleanDialogInputImpl("Key", mock(Component.class), true, "On True", "On False");
    inputs.add(booleanDialogInputImpl);

    // Act and Assert
    DialogBase dialogBase = builderImpl.inputs(inputs).build();
    assertTrue(dialogBase instanceof DialogBaseImpl);
    assertEquals(inputs, dialogBase.inputs());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#inputs(List)}.
   *
   * <ul>
   *   <li>Then return build inputs size is two.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#inputs(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl inputs(List); then return build inputs size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderImpl BuilderImpl.inputs(List)"})
  void testBuilderImplInputs_thenReturnBuildInputsSizeIsTwo() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl(mock(Component.class));

    ArrayList<DialogInput> inputs = new ArrayList<>();
    BooleanDialogInputImpl booleanDialogInputImpl =
        new BooleanDialogInputImpl("Key", mock(Component.class), true, "On True", "On False");
    inputs.add(booleanDialogInputImpl);
    BooleanDialogInputImpl booleanDialogInputImpl2 =
        new BooleanDialogInputImpl("Key", mock(Component.class), true, "On True", "On False");
    inputs.add(booleanDialogInputImpl2);

    // Act and Assert
    DialogBase dialogBase = builderImpl.inputs(inputs).build();
    assertTrue(dialogBase instanceof DialogBaseImpl);
    List<DialogInput> inputsResult = dialogBase.inputs();
    assertEquals(2, inputsResult.size());
    assertSame(booleanDialogInputImpl2, inputsResult.get(1));
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#inputs(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link BuilderImpl#BuilderImpl(Component)} with title is {@link Component}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#inputs(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl inputs(List); when ArrayList(); then return BuilderImpl(Component) with title is Component")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderImpl BuilderImpl.inputs(List)"})
  void testBuilderImplInputs_whenArrayList_thenReturnBuilderImplWithTitleIsComponent() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl(mock(Component.class));

    // Act
    BuilderImpl actualInputsResult = builderImpl.inputs(new ArrayList<>());

    // Assert
    assertSame(builderImpl, actualInputsResult);
  }
}

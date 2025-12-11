package io.papermc.paper.registry.data.dialog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.ServerBuildInfo;
import io.papermc.paper.dialog.Dialog;
import io.papermc.paper.registry.data.dialog.DialogBase.DialogAfterAction;
import io.papermc.paper.registry.data.dialog.action.CustomClickActionImpl;
import io.papermc.paper.registry.data.dialog.action.DialogAction;
import io.papermc.paper.registry.data.dialog.action.DialogAction.CustomClickAction;
import io.papermc.paper.registry.data.dialog.action.DialogAction.StaticAction;
import io.papermc.paper.registry.data.dialog.action.DialogActionCallback;
import io.papermc.paper.registry.data.dialog.action.StaticActionImpl;
import io.papermc.paper.registry.data.dialog.body.DialogBody;
import io.papermc.paper.registry.data.dialog.body.PlainMessageBodyImpl;
import io.papermc.paper.registry.data.dialog.body.PlainMessageDialogBody;
import io.papermc.paper.registry.data.dialog.input.BooleanDialogInput;
import io.papermc.paper.registry.data.dialog.input.BooleanDialogInputImpl;
import io.papermc.paper.registry.data.dialog.input.NumberRangeDialogInput;
import io.papermc.paper.registry.data.dialog.input.NumberRangeDialogInputImpl;
import io.papermc.paper.registry.data.dialog.input.SingleOptionDialogInput;
import io.papermc.paper.registry.data.dialog.input.SingleOptionDialogInput.OptionEntry;
import io.papermc.paper.registry.data.dialog.input.SingleOptionDialogInputImpl;
import io.papermc.paper.registry.data.dialog.input.SingleOptionDialogInputImpl.SingleOptionEntryImpl;
import io.papermc.paper.registry.data.dialog.input.TextDialogInput;
import io.papermc.paper.registry.data.dialog.input.TextDialogInput.MultilineOptions;
import io.papermc.paper.registry.data.dialog.input.TextDialogInputImpl;
import io.papermc.paper.registry.data.dialog.input.TextDialogInputImpl.MultilineOptionsImpl;
import io.papermc.paper.registry.data.dialog.type.ConfirmationType;
import io.papermc.paper.registry.data.dialog.type.ConfirmationTypeImpl;
import io.papermc.paper.registry.data.dialog.type.DialogListType;
import io.papermc.paper.registry.data.dialog.type.DialogListTypeImpl;
import io.papermc.paper.registry.data.dialog.type.MultiActionType;
import io.papermc.paper.registry.data.dialog.type.MultiActionType.Builder;
import io.papermc.paper.registry.data.dialog.type.MultiActionTypeImpl;
import io.papermc.paper.registry.data.dialog.type.MultiActionTypeImpl.BuilderImpl;
import io.papermc.paper.registry.data.dialog.type.NoticeType;
import io.papermc.paper.registry.data.dialog.type.NoticeTypeImpl;
import io.papermc.paper.registry.data.dialog.type.ServerLinksType;
import io.papermc.paper.registry.data.dialog.type.ServerLinksTypeImpl;
import io.papermc.paper.registry.set.NamedRegistryKeySetImpl;
import io.papermc.paper.registry.set.RegistrySet;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.nbt.api.BinaryTagHolder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickCallback;
import net.kyori.adventure.text.event.ClickCallback.Options;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.ClickEvent.Action;
import net.minecraft.core.HolderSet;
import net.minecraft.core.HolderSet.Named;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperDialogInstancesProviderDiffblueTest {
  /**
   * Test {@link PaperDialogInstancesProvider#dialogBaseBuilder(Component)}.
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#dialogBaseBuilder(Component)}
   */
  @Test
  @DisplayName("Test dialogBaseBuilder(Component)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DialogBase.Builder PaperDialogInstancesProvider.dialogBaseBuilder(Component)"
  })
  void testDialogBaseBuilder() {
    // Arrange
    Component title = mock(Component.class);

    // Act
    DialogBase.Builder actualDialogBaseBuilderResult =
        new PaperDialogInstancesProvider().dialogBaseBuilder(title);

    // Assert
    DialogBase dialogBase = actualDialogBaseBuilderResult.build();
    assertTrue(dialogBase instanceof DialogBaseImpl);
    assertTrue(actualDialogBaseBuilderResult instanceof DialogBaseImpl.BuilderImpl);
    assertNull(dialogBase.externalTitle());
    assertEquals(DialogAfterAction.CLOSE, dialogBase.afterAction());
    assertTrue(dialogBase.canCloseWithEscape());
    assertTrue(dialogBase.pause());
    List<DialogBody> bodyResult = dialogBase.body();
    assertTrue(bodyResult.isEmpty());
    assertSame(bodyResult, dialogBase.inputs());
    assertSame(title, dialogBase.title());
  }

  /**
   * Test {@link PaperDialogInstancesProvider#actionButtonBuilder(Component)}.
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#actionButtonBuilder(Component)}
   */
  @Test
  @DisplayName("Test actionButtonBuilder(Component)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ActionButton.Builder PaperDialogInstancesProvider.actionButtonBuilder(Component)"
  })
  void testActionButtonBuilder() {
    // Arrange
    Component label = mock(Component.class);

    // Act
    ActionButton.Builder actualActionButtonBuilderResult =
        new PaperDialogInstancesProvider().actionButtonBuilder(label);

    // Assert
    ActionButton actionButton = actualActionButtonBuilderResult.build();
    assertTrue(actionButton instanceof ActionButtonImpl);
    assertTrue(actualActionButtonBuilderResult instanceof ActionButtonImpl.BuilderImpl);
    assertNull(actionButton.action());
    assertNull(actionButton.tooltip());
    assertEquals(150, actionButton.width());
    assertSame(label, actionButton.label());
  }

  /**
   * Test {@link PaperDialogInstancesProvider#register(DialogActionCallback, Options)}.
   *
   * <ul>
   *   <li>Given ofSeconds one.
   *   <li>Then return {@link CustomClickActionImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#register(DialogActionCallback,
   * Options)}
   */
  @Test
  @DisplayName(
      "Test register(DialogActionCallback, Options); given ofSeconds one; then return CustomClickActionImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DialogAction.CustomClickAction PaperDialogInstancesProvider.register(DialogActionCallback, Options)"
  })
  void testRegister_givenOfSecondsOne_thenReturnCustomClickActionImpl() {
    // Arrange
    PaperDialogInstancesProvider paperDialogInstancesProvider = new PaperDialogInstancesProvider();
    DialogActionCallback callback = mock(DialogActionCallback.class);

    Options options = mock(Options.class);
    when(options.uses()).thenReturn(1);
    when(options.lifetime()).thenReturn(Duration.ofSeconds(1L));

    // Act
    CustomClickAction actualRegisterResult =
        paperDialogInstancesProvider.register(callback, options);

    // Assert
    verify(options).lifetime();
    verify(options).uses();
    assertTrue(actualRegisterResult instanceof CustomClickActionImpl);
  }

  /**
   * Test {@link PaperDialogInstancesProvider#staticAction(ClickEvent)}.
   *
   * <ul>
   *   <li>When changePage one.
   *   <li>Then return {@link StaticActionImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#staticAction(ClickEvent)}
   */
  @Test
  @DisplayName("Test staticAction(ClickEvent); when changePage one; then return StaticActionImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DialogAction.StaticAction PaperDialogInstancesProvider.staticAction(ClickEvent)"
  })
  void testStaticAction_whenChangePageOne_thenReturnStaticActionImpl() {
    // Arrange
    PaperDialogInstancesProvider paperDialogInstancesProvider = new PaperDialogInstancesProvider();
    ClickEvent value = ClickEvent.changePage(1);

    // Act
    StaticAction actualStaticActionResult = paperDialogInstancesProvider.staticAction(value);
    ClickEvent actualValueResult = actualStaticActionResult.value();

    // Assert
    assertTrue(actualStaticActionResult instanceof StaticActionImpl);
    ClickEvent valueResult = actualStaticActionResult.value();
    assertEquals(Action.CHANGE_PAGE, valueResult.action());
    assertSame(value, valueResult);
    assertSame(value, actualValueResult);
  }

  /**
   * Test {@link PaperDialogInstancesProvider#customClick(Key, BinaryTagHolder)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return additions is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#customClick(Key, BinaryTagHolder)}
   */
  @Test
  @DisplayName(
      "Test customClick(Key, BinaryTagHolder); when 'null'; then return additions is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DialogAction.CustomClickAction PaperDialogInstancesProvider.customClick(Key, BinaryTagHolder)"
  })
  void testCustomClick_whenNull_thenReturnAdditionsIsNull() {
    // Arrange
    Key id = ServerBuildInfo.BRAND_PAPER_ID;

    // Act
    CustomClickAction actualCustomClickResult =
        new PaperDialogInstancesProvider().customClick(id, null);

    // Assert
    assertTrue(actualCustomClickResult instanceof CustomClickActionImpl);
    assertNull(actualCustomClickResult.additions());
    assertSame(id, actualCustomClickResult.id());
  }

  /**
   * Test {@link PaperDialogInstancesProvider#plainMessageDialogBody(Component)} with {@code
   * component}.
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#plainMessageDialogBody(Component)}
   */
  @Test
  @DisplayName("Test plainMessageDialogBody(Component) with 'component'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PlainMessageDialogBody PaperDialogInstancesProvider.plainMessageDialogBody(Component)"
  })
  void testPlainMessageDialogBodyWithComponent() {
    // Arrange
    Component component = mock(Component.class);

    // Act
    PlainMessageDialogBody actualPlainMessageDialogBodyResult =
        new PaperDialogInstancesProvider().plainMessageDialogBody(component);

    // Assert
    assertTrue(actualPlainMessageDialogBodyResult instanceof PlainMessageBodyImpl);
    assertEquals(200, actualPlainMessageDialogBodyResult.width());
    assertSame(component, actualPlainMessageDialogBodyResult.contents());
  }

  /**
   * Test {@link PaperDialogInstancesProvider#plainMessageDialogBody(Component, int)} with {@code
   * component}, {@code width}.
   *
   * <ul>
   *   <li>Then return {@link PlainMessageBodyImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#plainMessageDialogBody(Component,
   * int)}
   */
  @Test
  @DisplayName(
      "Test plainMessageDialogBody(Component, int) with 'component', 'width'; then return PlainMessageBodyImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PlainMessageDialogBody PaperDialogInstancesProvider.plainMessageDialogBody(Component, int)"
  })
  void testPlainMessageDialogBodyWithComponentWidth_thenReturnPlainMessageBodyImpl() {
    // Arrange
    Component component = mock(Component.class);

    // Act
    PlainMessageDialogBody actualPlainMessageDialogBodyResult =
        new PaperDialogInstancesProvider().plainMessageDialogBody(component, 1);

    // Assert
    assertTrue(actualPlainMessageDialogBodyResult instanceof PlainMessageBodyImpl);
    assertEquals(1, actualPlainMessageDialogBodyResult.width());
    assertSame(component, actualPlainMessageDialogBodyResult.contents());
  }

  /**
   * Test {@link PaperDialogInstancesProvider#booleanBuilder(String, Component)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then build return {@link BooleanDialogInputImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#booleanBuilder(String, Component)}
   */
  @Test
  @DisplayName(
      "Test booleanBuilder(String, Component); when 'Key'; then build return BooleanDialogInputImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BooleanDialogInput.Builder PaperDialogInstancesProvider.booleanBuilder(String, Component)"
  })
  void testBooleanBuilder_whenKey_thenBuildReturnBooleanDialogInputImpl() {
    // Arrange
    Component label = mock(Component.class);

    // Act
    BooleanDialogInput.Builder actualBooleanBuilderResult =
        new PaperDialogInstancesProvider().booleanBuilder("Key", label);

    // Assert
    BooleanDialogInput booleanDialogInput = actualBooleanBuilderResult.build();
    assertTrue(booleanDialogInput instanceof BooleanDialogInputImpl);
    assertTrue(actualBooleanBuilderResult instanceof BooleanDialogInputImpl.BuilderImpl);
    assertEquals("Key", booleanDialogInput.key());
    assertFalse(booleanDialogInput.initial());
    String expectedOnFalseResult = Boolean.FALSE.toString();
    assertEquals(expectedOnFalseResult, booleanDialogInput.onFalse());
    String expectedOnTrueResult = Boolean.TRUE.toString();
    assertEquals(expectedOnTrueResult, booleanDialogInput.onTrue());
    assertSame(label, booleanDialogInput.label());
  }

  /**
   * Test {@link PaperDialogInstancesProvider#numberRangeBuilder(String, Component, float, float)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then build return {@link NumberRangeDialogInputImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#numberRangeBuilder(String, Component,
   * float, float)}
   */
  @Test
  @DisplayName(
      "Test numberRangeBuilder(String, Component, float, float); when 'Key'; then build return NumberRangeDialogInputImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NumberRangeDialogInput.Builder PaperDialogInstancesProvider.numberRangeBuilder(String, Component, float, float)"
  })
  void testNumberRangeBuilder_whenKey_thenBuildReturnNumberRangeDialogInputImpl() {
    // Arrange
    Component label = mock(Component.class);

    // Act
    NumberRangeDialogInput.Builder actualNumberRangeBuilderResult =
        new PaperDialogInstancesProvider().numberRangeBuilder("Key", label, 10.0f, 10.0f);

    // Assert
    NumberRangeDialogInput numberRangeDialogInput = actualNumberRangeBuilderResult.build();
    assertTrue(numberRangeDialogInput instanceof NumberRangeDialogInputImpl);
    assertTrue(actualNumberRangeBuilderResult instanceof NumberRangeDialogInputImpl.BuilderImpl);
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
   * Test {@link PaperDialogInstancesProvider#singleOptionBuilder(String, Component, List)}.
   *
   * <ul>
   *   <li>Then build return {@link SingleOptionDialogInputImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#singleOptionBuilder(String,
   * Component, List)}
   */
  @Test
  @DisplayName(
      "Test singleOptionBuilder(String, Component, List); then build return SingleOptionDialogInputImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SingleOptionDialogInput.Builder PaperDialogInstancesProvider.singleOptionBuilder(String, Component, List)"
  })
  void testSingleOptionBuilder_thenBuildReturnSingleOptionDialogInputImpl() {
    // Arrange
    PaperDialogInstancesProvider paperDialogInstancesProvider = new PaperDialogInstancesProvider();
    Component label = mock(Component.class);

    ArrayList<OptionEntry> entries = new ArrayList<>();
    SingleOptionEntryImpl singleOptionEntryImpl =
        new SingleOptionEntryImpl("42", mock(Component.class), true);
    entries.add(singleOptionEntryImpl);

    // Act
    SingleOptionDialogInput.Builder actualSingleOptionBuilderResult =
        paperDialogInstancesProvider.singleOptionBuilder("Key", label, entries);

    // Assert
    SingleOptionDialogInput singleOptionDialogInput = actualSingleOptionBuilderResult.build();
    assertTrue(singleOptionDialogInput instanceof SingleOptionDialogInputImpl);
    assertTrue(actualSingleOptionBuilderResult instanceof SingleOptionDialogInputImpl.BuilderImpl);
    assertEquals("Key", singleOptionDialogInput.key());
    assertEquals(200, singleOptionDialogInput.width());
    assertTrue(singleOptionDialogInput.labelVisible());
    assertEquals(entries, singleOptionDialogInput.entries());
    assertSame(label, singleOptionDialogInput.label());
  }

  /**
   * Test {@link PaperDialogInstancesProvider#singleOptionEntry(String, Component, boolean)}.
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#singleOptionEntry(String, Component,
   * boolean)}
   */
  @Test
  @DisplayName("Test singleOptionEntry(String, Component, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SingleOptionDialogInput.OptionEntry PaperDialogInstancesProvider.singleOptionEntry(String, Component, boolean)"
  })
  void testSingleOptionEntry() {
    // Arrange
    Component display = mock(Component.class);

    // Act
    OptionEntry actualSingleOptionEntryResult =
        new PaperDialogInstancesProvider().singleOptionEntry("42", display, true);

    // Assert
    assertTrue(actualSingleOptionEntryResult instanceof SingleOptionEntryImpl);
    assertEquals("42", actualSingleOptionEntryResult.id());
    assertTrue(actualSingleOptionEntryResult.initial());
    assertSame(display, actualSingleOptionEntryResult.display());
  }

  /**
   * Test {@link PaperDialogInstancesProvider#textBuilder(String, Component)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then build return {@link TextDialogInputImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#textBuilder(String, Component)}
   */
  @Test
  @DisplayName(
      "Test textBuilder(String, Component); when 'Key'; then build return TextDialogInputImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TextDialogInput.Builder PaperDialogInstancesProvider.textBuilder(String, Component)"
  })
  void testTextBuilder_whenKey_thenBuildReturnTextDialogInputImpl() {
    // Arrange
    Component label = mock(Component.class);

    // Act
    TextDialogInput.Builder actualTextBuilderResult =
        new PaperDialogInstancesProvider().textBuilder("Key", label);

    // Assert
    TextDialogInput textDialogInput = actualTextBuilderResult.build();
    assertTrue(textDialogInput instanceof TextDialogInputImpl);
    assertTrue(actualTextBuilderResult instanceof TextDialogInputImpl.BuilderImpl);
    assertEquals("", textDialogInput.initial());
    assertEquals("Key", textDialogInput.key());
    assertNull(textDialogInput.multiline());
    assertEquals(200, textDialogInput.width());
    assertTrue(textDialogInput.labelVisible());
    assertEquals(Integer.SIZE, textDialogInput.maxLength());
    assertSame(label, textDialogInput.label());
  }

  /**
   * Test {@link PaperDialogInstancesProvider#multilineOptions(Integer, Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return height is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#multilineOptions(Integer, Integer)}
   */
  @Test
  @DisplayName("Test multilineOptions(Integer, Integer); when 'null'; then return height is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TextDialogInput.MultilineOptions PaperDialogInstancesProvider.multilineOptions(Integer, Integer)"
  })
  void testMultilineOptions_whenNull_thenReturnHeightIsNull() {
    // Arrange and Act
    MultilineOptions actualMultilineOptionsResult =
        new PaperDialogInstancesProvider().multilineOptions(1, null);

    // Assert
    assertTrue(actualMultilineOptionsResult instanceof MultilineOptionsImpl);
    assertNull(actualMultilineOptionsResult.height());
    assertEquals(1, actualMultilineOptionsResult.maxLines().intValue());
  }

  /**
   * Test {@link PaperDialogInstancesProvider#multilineOptions(Integer, Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return maxLines is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#multilineOptions(Integer, Integer)}
   */
  @Test
  @DisplayName(
      "Test multilineOptions(Integer, Integer); when 'null'; then return maxLines is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TextDialogInput.MultilineOptions PaperDialogInstancesProvider.multilineOptions(Integer, Integer)"
  })
  void testMultilineOptions_whenNull_thenReturnMaxLinesIsNull() {
    // Arrange and Act
    MultilineOptions actualMultilineOptionsResult =
        new PaperDialogInstancesProvider().multilineOptions(null, 1);

    // Assert
    assertTrue(actualMultilineOptionsResult instanceof MultilineOptionsImpl);
    assertNull(actualMultilineOptionsResult.maxLines());
    assertEquals(1, actualMultilineOptionsResult.height().intValue());
  }

  /**
   * Test {@link PaperDialogInstancesProvider#multilineOptions(Integer, Integer)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return maxLines intValue is two.
   * </ul>
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#multilineOptions(Integer, Integer)}
   */
  @Test
  @DisplayName(
      "Test multilineOptions(Integer, Integer); when two; then return maxLines intValue is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TextDialogInput.MultilineOptions PaperDialogInstancesProvider.multilineOptions(Integer, Integer)"
  })
  void testMultilineOptions_whenTwo_thenReturnMaxLinesIntValueIsTwo() {
    // Arrange and Act
    MultilineOptions actualMultilineOptionsResult =
        new PaperDialogInstancesProvider().multilineOptions(2, 1);

    // Assert
    assertTrue(actualMultilineOptionsResult instanceof MultilineOptionsImpl);
    assertEquals(1, actualMultilineOptionsResult.height().intValue());
    assertEquals(2, actualMultilineOptionsResult.maxLines().intValue());
  }

  /**
   * Test {@link PaperDialogInstancesProvider#confirmation(ActionButton, ActionButton)}.
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#confirmation(ActionButton,
   * ActionButton)}
   */
  @Test
  @DisplayName("Test confirmation(ActionButton, ActionButton)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConfirmationType PaperDialogInstancesProvider.confirmation(ActionButton, ActionButton)"
  })
  void testConfirmation() {
    // Arrange
    ActionButton noButton = NoticeTypeImpl.DEFAULT_ACTION;

    // Act
    ConfirmationType actualConfirmationResult =
        new PaperDialogInstancesProvider().confirmation(NoticeTypeImpl.DEFAULT_ACTION, noButton);

    // Assert
    assertTrue(actualConfirmationResult instanceof ConfirmationTypeImpl);
    assertSame(noButton, actualConfirmationResult.noButton());
    assertSame(noButton, actualConfirmationResult.yesButton());
  }

  /**
   * Test {@link PaperDialogInstancesProvider#dialogList(RegistrySet)}.
   *
   * <ul>
   *   <li>Then build return {@link DialogListTypeImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#dialogList(RegistrySet)}
   */
  @Test
  @DisplayName("Test dialogList(RegistrySet); then build return DialogListTypeImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DialogListType.Builder PaperDialogInstancesProvider.dialogList(RegistrySet)"})
  void testDialogList_thenBuildReturnDialogListTypeImpl() {
    // Arrange
    PaperDialogInstancesProvider paperDialogInstancesProvider = new PaperDialogInstancesProvider();
    NamedRegistryKeySetImpl<Dialog, Object> dialogs =
        new NamedRegistryKeySetImpl<>(null, mock(Named.class));

    // Act
    DialogListType.Builder actualDialogListResult =
        paperDialogInstancesProvider.dialogList(dialogs);

    // Assert
    DialogListType dialogListType = actualDialogListResult.build();
    assertTrue(dialogListType instanceof DialogListTypeImpl);
    assertTrue(actualDialogListResult instanceof DialogListTypeImpl.BuilderImpl);
    RegistrySet<Dialog> dialogsResult = dialogListType.dialogs();
    assertTrue(dialogsResult instanceof NamedRegistryKeySetImpl);
    assertNull(dialogListType.exitAction());
    assertNull(((NamedRegistryKeySetImpl<Dialog, Object>) dialogsResult).tagKey());
    assertEquals(150, dialogListType.buttonWidth());
    assertEquals(2, dialogListType.columns());
    assertSame(dialogs, dialogsResult);
  }

  /**
   * Test {@link PaperDialogInstancesProvider#multiAction(List)}.
   *
   * <ul>
   *   <li>Given {@link NoticeTypeImpl#DEFAULT_ACTION}.
   *   <li>Then build return {@link MultiActionTypeImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#multiAction(List)}
   */
  @Test
  @DisplayName(
      "Test multiAction(List); given DEFAULT_ACTION; then build return MultiActionTypeImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperDialogInstancesProvider.multiAction(List)"})
  void testMultiAction_givenDefault_action_thenBuildReturnMultiActionTypeImpl() {
    // Arrange
    PaperDialogInstancesProvider paperDialogInstancesProvider = new PaperDialogInstancesProvider();

    ArrayList<ActionButton> actions = new ArrayList<>();
    actions.add(NoticeTypeImpl.DEFAULT_ACTION);

    // Act
    Builder actualMultiActionResult = paperDialogInstancesProvider.multiAction(actions);

    // Assert
    MultiActionType multiActionType = actualMultiActionResult.build();
    assertTrue(multiActionType instanceof MultiActionTypeImpl);
    assertTrue(actualMultiActionResult instanceof BuilderImpl);
    assertNull(multiActionType.exitAction());
    assertEquals(2, multiActionType.columns());
    assertEquals(actions, multiActionType.actions());
  }

  /**
   * Test {@link PaperDialogInstancesProvider#multiAction(List)}.
   *
   * <ul>
   *   <li>Given {@link NoticeTypeImpl#DEFAULT_ACTION}.
   *   <li>Then build return {@link MultiActionTypeImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#multiAction(List)}
   */
  @Test
  @DisplayName(
      "Test multiAction(List); given DEFAULT_ACTION; then build return MultiActionTypeImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperDialogInstancesProvider.multiAction(List)"})
  void testMultiAction_givenDefault_action_thenBuildReturnMultiActionTypeImpl2() {
    // Arrange
    PaperDialogInstancesProvider paperDialogInstancesProvider = new PaperDialogInstancesProvider();

    ArrayList<ActionButton> actions = new ArrayList<>();
    actions.add(NoticeTypeImpl.DEFAULT_ACTION);
    actions.add(NoticeTypeImpl.DEFAULT_ACTION);

    // Act
    Builder actualMultiActionResult = paperDialogInstancesProvider.multiAction(actions);

    // Assert
    MultiActionType multiActionType = actualMultiActionResult.build();
    assertTrue(multiActionType instanceof MultiActionTypeImpl);
    assertTrue(actualMultiActionResult instanceof BuilderImpl);
    assertNull(multiActionType.exitAction());
    assertEquals(2, multiActionType.columns());
    assertEquals(actions, multiActionType.actions());
  }

  /**
   * Test {@link PaperDialogInstancesProvider#notice()}.
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#notice()}
   */
  @Test
  @DisplayName("Test notice()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NoticeType PaperDialogInstancesProvider.notice()"})
  void testNotice() {
    // Arrange and Act
    NoticeType actualNoticeResult = new PaperDialogInstancesProvider().notice();
    ActionButton actualActionResult = actualNoticeResult.action();

    // Assert
    assertTrue(actualNoticeResult instanceof NoticeTypeImpl);
    ActionButton actionButton = ((NoticeTypeImpl) actualNoticeResult).DEFAULT_ACTION;
    assertSame(actionButton, actualNoticeResult.action());
    assertSame(actionButton, actualActionResult);
  }

  /**
   * Test {@link PaperDialogInstancesProvider#notice(ActionButton)} with {@code ActionButton}.
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#notice(ActionButton)}
   */
  @Test
  @DisplayName("Test notice(ActionButton) with 'ActionButton'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NoticeType PaperDialogInstancesProvider.notice(ActionButton)"})
  void testNoticeWithActionButton() {
    // Arrange
    PaperDialogInstancesProvider paperDialogInstancesProvider = new PaperDialogInstancesProvider();

    // Act
    NoticeType actualNoticeResult =
        paperDialogInstancesProvider.notice(NoticeTypeImpl.DEFAULT_ACTION);
    ActionButton actualActionResult = actualNoticeResult.action();

    // Assert
    NoticeType noticeResult = paperDialogInstancesProvider.notice();
    assertTrue(noticeResult instanceof NoticeTypeImpl);
    assertTrue(actualNoticeResult instanceof NoticeTypeImpl);
    ActionButton actionButton = ((NoticeTypeImpl) actualNoticeResult).DEFAULT_ACTION;
    assertSame(actionButton, noticeResult.action());
    assertSame(actionButton, actualNoticeResult.action());
    assertSame(actionButton, actualActionResult);
  }

  /**
   * Test {@link PaperDialogInstancesProvider#serverLinks(ActionButton, int, int)}.
   *
   * <ul>
   *   <li>When {@link NoticeTypeImpl#DEFAULT_ACTION}.
   *   <li>Then return {@link ServerLinksTypeImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDialogInstancesProvider#serverLinks(ActionButton, int, int)}
   */
  @Test
  @DisplayName(
      "Test serverLinks(ActionButton, int, int); when DEFAULT_ACTION; then return ServerLinksTypeImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerLinksType PaperDialogInstancesProvider.serverLinks(ActionButton, int, int)"
  })
  void testServerLinks_whenDefault_action_thenReturnServerLinksTypeImpl() {
    // Arrange
    ActionButton exitAction = NoticeTypeImpl.DEFAULT_ACTION;

    // Act
    ServerLinksType actualServerLinksResult =
        new PaperDialogInstancesProvider().serverLinks(exitAction, 1, 1);

    // Assert
    assertTrue(actualServerLinksResult instanceof ServerLinksTypeImpl);
    assertEquals(1, actualServerLinksResult.buttonWidth());
    assertEquals(1, actualServerLinksResult.columns());
    assertSame(exitAction, actualServerLinksResult.exitAction());
  }
}

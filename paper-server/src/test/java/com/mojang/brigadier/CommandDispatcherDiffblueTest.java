package com.mojang.brigadier;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.context.CommandContextBuilder;
import com.mojang.brigadier.context.ParsedArgument;
import com.mojang.brigadier.context.ParsedCommandNode;
import com.mojang.brigadier.context.StringRange;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType.Function;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.mojang.brigadier.tree.ArgumentCommandNode;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import io.papermc.paper.brigadier.TagParseCommandSyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import net.minecraft.commands.Commands;
import net.minecraft.server.RunningOnDifferentThreadException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class CommandDispatcherDiffblueTest {
  /**
   * Test {@link CommandDispatcher#CommandDispatcher()}.
   *
   * <p>Method under test: {@link CommandDispatcher#CommandDispatcher()}
   */
  @Test
  @DisplayName("Test new CommandDispatcher()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandDispatcher.<init>()"})
  void testNewCommandDispatcher() {
    // Arrange and Act
    CommandDispatcher<Object> actualCommandDispatcher = new CommandDispatcher<>();

    // Assert
    RootCommandNode<Object> root = actualCommandDispatcher.getRoot();
    Collection<String> examples = root.getExamples();
    assertTrue(examples instanceof List);
    assertEquals("", root.getName());
    assertEquals("", root.getUsageText());
    assertNull(root.getCommand());
    assertNull(root.unwrappedCached);
    assertNull(root.wrappedCached);
    assertNull(root.getRedirect());
    assertNull(root.clientNode);
    assertNull(root.apiCommandMeta);
    assertFalse(root.isFork());
    assertTrue(root.getChildren().isEmpty());
    assertTrue(examples.isEmpty());
  }

  /**
   * Test {@link CommandDispatcher#CommandDispatcher(RootCommandNode)}.
   *
   * <p>Method under test: {@link CommandDispatcher#CommandDispatcher(RootCommandNode)}
   */
  @Test
  @DisplayName("Test new CommandDispatcher(RootCommandNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandDispatcher.<init>(RootCommandNode)"})
  void testNewCommandDispatcher2() {
    // Arrange
    RootCommandNode<Object> root = new RootCommandNode<>();

    // Act
    CommandDispatcher<Object> actualCommandDispatcher = new CommandDispatcher<>(root);

    // Assert
    assertSame(root, actualCommandDispatcher.getRoot());
  }

  /**
   * Test {@link CommandDispatcher#register(LiteralArgumentBuilder)}.
   *
   * <ul>
   *   <li>Given {@link CommandDispatcher#CommandDispatcher()}.
   *   <li>Then {@link CommandDispatcher#CommandDispatcher()} Root Children size is one.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#register(LiteralArgumentBuilder)}
   */
  @Test
  @DisplayName(
      "Test register(LiteralArgumentBuilder); given CommandDispatcher(); then CommandDispatcher() Root Children size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LiteralCommandNode CommandDispatcher.register(LiteralArgumentBuilder)"})
  void testRegister_givenCommandDispatcher_thenCommandDispatcherRootChildrenSizeIsOne() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();
    LiteralArgumentBuilder<Object> command = LiteralArgumentBuilder.literal("Name");

    // Act
    LiteralCommandNode<Object> actualRegisterResult = commandDispatcher.register(command);

    // Assert
    Collection<String> examples = actualRegisterResult.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertEquals("Name", actualRegisterResult.getLiteral());
    assertEquals("Name", actualRegisterResult.getName());
    assertEquals("Name", actualRegisterResult.getUsageText());
    assertNull(actualRegisterResult.getCommand());
    assertEquals(1, commandDispatcher.getRoot().getChildren().size());
    assertTrue(examples.contains("Name"));
  }

  /**
   * Test {@link CommandDispatcher#register(LiteralArgumentBuilder)}.
   *
   * <ul>
   *   <li>Given {@link Command}.
   *   <li>When literal {@code Name} executes {@link Command}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#register(LiteralArgumentBuilder)}
   */
  @Test
  @DisplayName(
      "Test register(LiteralArgumentBuilder); given Command; when literal 'Name' executes Command")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LiteralCommandNode CommandDispatcher.register(LiteralArgumentBuilder)"})
  void testRegister_givenCommand_whenLiteralNameExecutesCommand() {
    // Arrange
    RootCommandNode<Object> root = new RootCommandNode<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    LiteralArgumentBuilder<Object> command3 = LiteralArgumentBuilder.literal("Name");
    command3.executes(mock(Command.class));

    // Act
    LiteralCommandNode<Object> actualRegisterResult = commandDispatcher.register(command3);

    // Assert
    Collection<String> examples = actualRegisterResult.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertEquals("Name", actualRegisterResult.getLiteral());
    assertEquals("Name", actualRegisterResult.getName());
    assertEquals("Name", actualRegisterResult.getUsageText());
    assertEquals(1, commandDispatcher.getRoot().getChildren().size());
    assertTrue(examples.contains("Name"));
  }

  /**
   * Test {@link CommandDispatcher#register(LiteralArgumentBuilder)}.
   *
   * <ul>
   *   <li>Then return Command is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#register(LiteralArgumentBuilder)}
   */
  @Test
  @DisplayName("Test register(LiteralArgumentBuilder); then return Command is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LiteralCommandNode CommandDispatcher.register(LiteralArgumentBuilder)"})
  void testRegister_thenReturnCommandIsNull() {
    // Arrange
    RootCommandNode<Object> root = new RootCommandNode<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);
    LiteralArgumentBuilder<Object> command3 = LiteralArgumentBuilder.literal("Name");

    // Act
    LiteralCommandNode<Object> actualRegisterResult = commandDispatcher.register(command3);

    // Assert
    Collection<String> examples = actualRegisterResult.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertEquals("Name", actualRegisterResult.getLiteral());
    assertEquals("Name", actualRegisterResult.getName());
    assertEquals("Name", actualRegisterResult.getUsageText());
    assertNull(actualRegisterResult.getCommand());
    assertEquals(1, commandDispatcher.getRoot().getChildren().size());
    assertTrue(examples.contains("Name"));
  }

  /**
   * Test {@link CommandDispatcher#register(LiteralArgumentBuilder)}.
   *
   * <ul>
   *   <li>When literal {@code minecraft:}.
   *   <li>Then return Literal is {@code minecraft:}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#register(LiteralArgumentBuilder)}
   */
  @Test
  @DisplayName(
      "Test register(LiteralArgumentBuilder); when literal 'minecraft:'; then return Literal is 'minecraft:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LiteralCommandNode CommandDispatcher.register(LiteralArgumentBuilder)"})
  void testRegister_whenLiteralMinecraft_thenReturnLiteralIsMinecraft() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();
    LiteralArgumentBuilder<Object> command = LiteralArgumentBuilder.literal("minecraft:");

    // Act
    LiteralCommandNode<Object> actualRegisterResult = commandDispatcher.register(command);

    // Assert
    Collection<String> examples = actualRegisterResult.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertEquals("minecraft:", actualRegisterResult.getLiteral());
    assertEquals("minecraft:", actualRegisterResult.getName());
    assertEquals("minecraft:", actualRegisterResult.getUsageText());
    assertTrue(examples.contains("minecraft:"));
  }

  /**
   * Test {@link CommandDispatcher#execute(ParseResults)} with {@code ParseResults}.
   *
   * <ul>
   *   <li>Given {@link Command} {@link Command#run(CommandContext)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#execute(ParseResults)}
   */
  @Test
  @DisplayName(
      "Test execute(ParseResults) with 'ParseResults'; given Command run(CommandContext) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CommandDispatcher.execute(ParseResults)"})
  void testExecuteWithParseResults_givenCommandRunReturnOne_thenReturnOne()
      throws CommandSyntaxException {
    // Arrange
    ResultConsumer<Object> consumer = mock(ResultConsumer.class);
    doNothing()
        .when(consumer)
        .onCommandComplete(Mockito.<CommandContext<Object>>any(), anyBoolean(), anyInt());

    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();
    commandDispatcher.setConsumer(consumer);

    Command<Object> command = mock(Command.class);
    when(command.run(Mockito.<CommandContext<Object>>any())).thenReturn(1);
    CommandDispatcher<Object> dispatcher = new CommandDispatcher<>();

    CommandContextBuilder<Object> context =
        new CommandContextBuilder<>(
            dispatcher, ConfigurationTransformation.WILDCARD_OBJECT, new RootCommandNode<>(), 1);
    context.withCommand(command);
    ParseResults<Object> parseResults = new ParseResults<>(context);

    UnaryOperator<Object> mapper = mock(UnaryOperator.class);
    when(mapper.apply(Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    ParseResults<Object> parse = Commands.mapSource(parseResults, mapper);

    // Act
    int actualExecuteResult = commandDispatcher.execute(parse);

    // Assert
    verify(command).run(isA(CommandContext.class));
    verify(consumer).onCommandComplete(isA(CommandContext.class), eq(true), eq(1));
    verify(mapper).apply(isA(Object.class));
    assertEquals(1, actualExecuteResult);
  }

  /**
   * Test {@link CommandDispatcher#execute(ParseResults)} with {@code ParseResults}.
   *
   * <ul>
   *   <li>Then calls {@link Message#getString()}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#execute(ParseResults)}
   */
  @Test
  @DisplayName("Test execute(ParseResults) with 'ParseResults'; then calls getString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CommandDispatcher.execute(ParseResults)"})
  void testExecuteWithParseResults_thenCallsGetString() throws CommandSyntaxException {
    // Arrange
    ResultConsumer<Object> consumer = mock(ResultConsumer.class);
    doNothing()
        .when(consumer)
        .onCommandComplete(Mockito.<CommandContext<Object>>any(), anyBoolean(), anyInt());

    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();
    commandDispatcher.setConsumer(consumer);

    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type, message);

    Command<Object> command = mock(Command.class);
    when(command.run(Mockito.<CommandContext<Object>>any())).thenReturn(1);
    CommandDispatcher<Object> dispatcher = new CommandDispatcher<>();
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command3,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> rootNode =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command2,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    CommandContextBuilder<Object> child =
        new CommandContextBuilder<>(
            dispatcher, ConfigurationTransformation.WILDCARD_OBJECT, rootNode, 1);
    child.withCommand(command);
    CommandDispatcher<Object> dispatcher2 = new CommandDispatcher<>();

    CommandContextBuilder<Object> context =
        new CommandContextBuilder<>(
            dispatcher2, ConfigurationTransformation.WILDCARD_OBJECT, new RootCommandNode<>(), 1);
    context.withChild(child);
    context.withCommand(mock(Command.class));
    ParseResults<Object> parseResults = new ParseResults<>(context);

    UnaryOperator<Object> mapper = mock(UnaryOperator.class);
    when(mapper.apply(Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    ParseResults<Object> parse = Commands.mapSource(parseResults, mapper);

    // Act
    int actualExecuteResult = commandDispatcher.execute(parse);

    // Assert
    verify(command).run(isA(CommandContext.class));
    verify(message).getString();
    verify(consumer).onCommandComplete(isA(CommandContext.class), eq(true), eq(1));
    verify(mapper).apply(isA(Object.class));
    assertEquals(1, actualExecuteResult);
  }

  /**
   * Test {@link CommandDispatcher#execute(String, Object)} with {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>Given {@link Command} {@link Command#run(CommandContext)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#execute(String, Object)}
   */
  @Test
  @DisplayName(
      "Test execute(String, Object) with 'String', 'Object'; given Command run(CommandContext) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CommandDispatcher.execute(String, Object)"})
  void testExecuteWithStringObject_givenCommandRunReturnOne_thenReturnOne()
      throws CommandSyntaxException {
    // Arrange
    ResultConsumer<Object> consumer = mock(ResultConsumer.class);
    doNothing()
        .when(consumer)
        .onCommandComplete(Mockito.<CommandContext<Object>>any(), anyBoolean(), anyInt());

    ArgumentType<Object> type = mock(ArgumentType.class);
    when(type.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Command<Object> command = mock(Command.class);
    when(command.run(Mockito.<CommandContext<Object>>any())).thenReturn(1);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node);

    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);
    commandDispatcher.setConsumer(consumer);

    // Act
    int actualExecuteResult =
        commandDispatcher.execute("", ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(command).run(isA(CommandContext.class));
    verify(consumer).onCommandComplete(isA(CommandContext.class), eq(true), eq(1));
    verify(type).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(1, actualExecuteResult);
  }

  /**
   * Test {@link CommandDispatcher#execute(StringReader, Object)} with {@code StringReader}, {@code
   * Object}.
   *
   * <p>Method under test: {@link CommandDispatcher#execute(StringReader, Object)}
   */
  @Test
  @DisplayName("Test execute(StringReader, Object) with 'StringReader', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CommandDispatcher.execute(StringReader, Object)"})
  void testExecuteWithStringReaderObject() throws CommandSyntaxException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type, message);

    Message message2 = mock(Message.class);
    when(message2.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type2 = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type2, message2);

    ResultConsumer<Object> consumer = mock(ResultConsumer.class);
    doNothing()
        .when(consumer)
        .onCommandComplete(Mockito.<CommandContext<Object>>any(), anyBoolean(), anyInt());

    ArgumentType<Object> type3 = mock(ArgumentType.class);
    when(type3.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type3,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    ArgumentType<Object> type4 = mock(ArgumentType.class);
    when(type4.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Command<Object> command3 = mock(Command.class);
    when(command3.run(Mockito.<CommandContext<Object>>any())).thenReturn(1);

    Predicate<Object> requirement3 = mock(Predicate.class);
    when(requirement3.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "42",
            type4,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node2);
    root.addChild(node);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect3 =
        new LiteralCommandNode<>(
            "Literal",
            command6,
            requirement6,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node3 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command5,
            requirement5,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node3);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command8,
            requirement8,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command7,
            requirement7,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node4);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command10,
            requirement10,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command9,
            requirement9,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node5);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command12,
            requirement12,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command11,
            requirement11,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node6);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command14,
            requirement14,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command13,
            requirement13,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node7);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command16,
            requirement16,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command15,
            requirement15,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node8);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command18,
            requirement18,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command17,
            requirement17,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node9);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command20,
            requirement20,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command19,
            requirement19,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node10);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command22,
            requirement22,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command21,
            requirement21,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node11);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command24,
            requirement24,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command23,
            requirement23,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node12);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command26,
            requirement26,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command25,
            requirement25,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node13);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command28,
            requirement28,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command27,
            requirement27,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node14);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command30,
            requirement30,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command29,
            requirement29,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node15);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command32,
            requirement32,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command31,
            requirement31,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node16);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command34,
            requirement34,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command33,
            requirement33,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node17);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command36,
            requirement36,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command35,
            requirement35,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node18);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command38,
            requirement38,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command37,
            requirement37,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node19);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command40,
            requirement40,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command39,
            requirement39,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node20);

    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);
    commandDispatcher.setConsumer(consumer);

    // Act
    int actualExecuteResult =
        commandDispatcher.execute(
            new StringReader(""), ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(command3).run(isA(CommandContext.class));
    verify(message).getString();
    verify(message2).getString();
    verify(consumer).onCommandComplete(isA(CommandContext.class), eq(true), eq(1));
    verify(type4).parse(isA(StringReader.class), isA(Object.class));
    verify(type3).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement3).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(1, actualExecuteResult);
  }

  /**
   * Test {@link CommandDispatcher#execute(StringReader, Object)} with {@code StringReader}, {@code
   * Object}.
   *
   * <p>Method under test: {@link CommandDispatcher#execute(StringReader, Object)}
   */
  @Test
  @DisplayName("Test execute(StringReader, Object) with 'StringReader', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CommandDispatcher.execute(StringReader, Object)"})
  void testExecuteWithStringReaderObject2() throws CommandSyntaxException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type, message);

    Message message2 = mock(Message.class);
    when(message2.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type2 = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type2, message2);

    ResultConsumer<Object> consumer = mock(ResultConsumer.class);
    doNothing()
        .when(consumer)
        .onCommandComplete(Mockito.<CommandContext<Object>>any(), anyBoolean(), anyInt());

    ArgumentType<Object> type3 = mock(ArgumentType.class);
    when(type3.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenThrow(RunningOnDifferentThreadException.RUNNING_ON_DIFFERENT_THREAD);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type3,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    ArgumentType<Object> type4 = mock(ArgumentType.class);
    when(type4.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Command<Object> command3 = mock(Command.class);
    when(command3.run(Mockito.<CommandContext<Object>>any())).thenReturn(1);

    Predicate<Object> requirement3 = mock(Predicate.class);
    when(requirement3.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "42",
            type4,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node2);
    root.addChild(node);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect3 =
        new LiteralCommandNode<>(
            "Literal",
            command6,
            requirement6,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node3 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command5,
            requirement5,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node3);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command8,
            requirement8,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command7,
            requirement7,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node4);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command10,
            requirement10,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command9,
            requirement9,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node5);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command12,
            requirement12,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command11,
            requirement11,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node6);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command14,
            requirement14,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command13,
            requirement13,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node7);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command16,
            requirement16,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command15,
            requirement15,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node8);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command18,
            requirement18,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command17,
            requirement17,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node9);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command20,
            requirement20,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command19,
            requirement19,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node10);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command22,
            requirement22,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command21,
            requirement21,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node11);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command24,
            requirement24,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command23,
            requirement23,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node12);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command26,
            requirement26,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command25,
            requirement25,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node13);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command28,
            requirement28,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command27,
            requirement27,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node14);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command30,
            requirement30,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command29,
            requirement29,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node15);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command32,
            requirement32,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command31,
            requirement31,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node16);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command34,
            requirement34,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command33,
            requirement33,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node17);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command36,
            requirement36,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command35,
            requirement35,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node18);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command38,
            requirement38,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command37,
            requirement37,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node19);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command40,
            requirement40,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command39,
            requirement39,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node20);

    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);
    commandDispatcher.setConsumer(consumer);

    // Act
    int actualExecuteResult =
        commandDispatcher.execute(
            new StringReader(""), ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(command3).run(isA(CommandContext.class));
    verify(message).getString();
    verify(message2).getString();
    verify(consumer).onCommandComplete(isA(CommandContext.class), eq(true), eq(1));
    verify(type4).parse(isA(StringReader.class), isA(Object.class));
    verify(type3).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement3).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(1, actualExecuteResult);
  }

  /**
   * Test {@link CommandDispatcher#execute(StringReader, Object)} with {@code StringReader}, {@code
   * Object}.
   *
   * <p>Method under test: {@link CommandDispatcher#execute(StringReader, Object)}
   */
  @Test
  @DisplayName("Test execute(StringReader, Object) with 'StringReader', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CommandDispatcher.execute(StringReader, Object)"})
  void testExecuteWithStringReaderObject3() throws CommandSyntaxException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type, message);

    Message message2 = mock(Message.class);
    when(message2.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type2 = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type2, message2);

    ResultConsumer<Object> consumer = mock(ResultConsumer.class);
    doNothing()
        .when(consumer)
        .onCommandComplete(Mockito.<CommandContext<Object>>any(), anyBoolean(), anyInt());

    Message message3 = mock(Message.class);
    when(message3.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type3 = new Dynamic2CommandExceptionType(mock(Function.class));

    CommandSyntaxException commandSyntaxException = new CommandSyntaxException(type3, message3);

    ArgumentType<Object> type4 = mock(ArgumentType.class);
    when(type4.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenThrow(commandSyntaxException);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    ArgumentType<Object> type5 = mock(ArgumentType.class);
    when(type5.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Command<Object> command3 = mock(Command.class);
    when(command3.run(Mockito.<CommandContext<Object>>any())).thenReturn(1);

    Predicate<Object> requirement3 = mock(Predicate.class);
    when(requirement3.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "42",
            type5,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node2);
    root.addChild(node);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect3 =
        new LiteralCommandNode<>(
            "Literal",
            command6,
            requirement6,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node3 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command5,
            requirement5,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node3);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command8,
            requirement8,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command7,
            requirement7,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node4);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command10,
            requirement10,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command9,
            requirement9,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node5);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command12,
            requirement12,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command11,
            requirement11,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node6);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command14,
            requirement14,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command13,
            requirement13,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node7);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command16,
            requirement16,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command15,
            requirement15,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node8);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command18,
            requirement18,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command17,
            requirement17,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node9);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command20,
            requirement20,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command19,
            requirement19,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node10);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command22,
            requirement22,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command21,
            requirement21,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node11);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command24,
            requirement24,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command23,
            requirement23,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node12);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command26,
            requirement26,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command25,
            requirement25,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node13);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command28,
            requirement28,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command27,
            requirement27,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node14);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command30,
            requirement30,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command29,
            requirement29,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node15);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command32,
            requirement32,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command31,
            requirement31,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node16);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command34,
            requirement34,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command33,
            requirement33,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node17);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command36,
            requirement36,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command35,
            requirement35,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node18);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command38,
            requirement38,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command37,
            requirement37,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node19);
    ArgumentType<Object> type23 = mock(ArgumentType.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command40,
            requirement40,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type23,
            command39,
            requirement39,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node20);

    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);
    commandDispatcher.setConsumer(consumer);

    // Act
    int actualExecuteResult =
        commandDispatcher.execute(
            new StringReader(""), ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(command3).run(isA(CommandContext.class));
    verify(message3).getString();
    verify(message).getString();
    verify(message2).getString();
    verify(consumer).onCommandComplete(isA(CommandContext.class), eq(true), eq(1));
    verify(type5).parse(isA(StringReader.class), isA(Object.class));
    verify(type4).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement3).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(1, actualExecuteResult);
  }

  /**
   * Test {@link CommandDispatcher#execute(StringReader, Object)} with {@code StringReader}, {@code
   * Object}.
   *
   * <p>Method under test: {@link CommandDispatcher#execute(StringReader, Object)}
   */
  @Test
  @DisplayName("Test execute(StringReader, Object) with 'StringReader', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CommandDispatcher.execute(StringReader, Object)"})
  void testExecuteWithStringReaderObject4() throws CommandSyntaxException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type, message);

    Message message2 = mock(Message.class);
    when(message2.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type2 = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type2, message2);

    ResultConsumer<Object> consumer = mock(ResultConsumer.class);
    doNothing()
        .when(consumer)
        .onCommandComplete(Mockito.<CommandContext<Object>>any(), anyBoolean(), anyInt());

    Message message3 = mock(Message.class);
    when(message3.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type3 = new Dynamic2CommandExceptionType(mock(Function.class));

    CommandSyntaxException commandSyntaxException = new CommandSyntaxException(type3, message3);

    ArgumentType<Object> type4 = mock(ArgumentType.class);
    when(type4.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenThrow(commandSyntaxException);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    ArgumentType<Object> type5 = mock(ArgumentType.class);
    when(type5.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Command<Object> command3 = mock(Command.class);
    when(command3.run(Mockito.<CommandContext<Object>>any())).thenReturn(1);

    Predicate<Object> requirement3 = mock(Predicate.class);
    when(requirement3.test(Mockito.<Object>any())).thenReturn(true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "42",
            type5,
            command3,
            requirement3,
            null,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node2);
    root.addChild(node);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command5,
            requirement5,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node3 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command4,
            requirement4,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node3);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect3 =
        new LiteralCommandNode<>(
            "Literal",
            command7,
            requirement7,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command6,
            requirement6,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node4);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command9,
            requirement9,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command8,
            requirement8,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node5);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command11,
            requirement11,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command10,
            requirement10,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node6);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command13,
            requirement13,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command12,
            requirement12,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node7);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command15,
            requirement15,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command14,
            requirement14,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node8);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command17,
            requirement17,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command16,
            requirement16,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node9);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command19,
            requirement19,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command18,
            requirement18,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node10);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command21,
            requirement21,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command20,
            requirement20,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node11);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command23,
            requirement23,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command22,
            requirement22,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node12);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command25,
            requirement25,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command24,
            requirement24,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node13);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command27,
            requirement27,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command26,
            requirement26,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node14);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command29,
            requirement29,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command28,
            requirement28,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node15);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command31,
            requirement31,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command30,
            requirement30,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node16);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command33,
            requirement33,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command32,
            requirement32,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node17);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command35,
            requirement35,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command34,
            requirement34,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node18);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command37,
            requirement37,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command36,
            requirement36,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node19);
    ArgumentType<Object> type23 = mock(ArgumentType.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command39,
            requirement39,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type23,
            command38,
            requirement38,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node20);

    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);
    commandDispatcher.setConsumer(consumer);

    // Act
    int actualExecuteResult =
        commandDispatcher.execute(
            new StringReader(""), ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(command3).run(isA(CommandContext.class));
    verify(message3).getString();
    verify(message).getString();
    verify(message2).getString();
    verify(consumer).onCommandComplete(isA(CommandContext.class), eq(true), eq(1));
    verify(type5).parse(isA(StringReader.class), isA(Object.class));
    verify(type4).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement3).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(1, actualExecuteResult);
  }

  /**
   * Test {@link CommandDispatcher#execute(StringReader, Object)} with {@code StringReader}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Given {@link Command} {@link Command#run(CommandContext)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#execute(StringReader, Object)}
   */
  @Test
  @DisplayName(
      "Test execute(StringReader, Object) with 'StringReader', 'Object'; given Command run(CommandContext) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CommandDispatcher.execute(StringReader, Object)"})
  void testExecuteWithStringReaderObject_givenCommandRunReturnOne_thenReturnOne()
      throws CommandSyntaxException {
    // Arrange
    ResultConsumer<Object> consumer = mock(ResultConsumer.class);
    doNothing()
        .when(consumer)
        .onCommandComplete(Mockito.<CommandContext<Object>>any(), anyBoolean(), anyInt());

    ArgumentType<Object> type = mock(ArgumentType.class);
    when(type.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Command<Object> command = mock(Command.class);
    when(command.run(Mockito.<CommandContext<Object>>any())).thenReturn(1);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node);

    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);
    commandDispatcher.setConsumer(consumer);

    // Act
    int actualExecuteResult =
        commandDispatcher.execute(
            new StringReader(""), ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(command).run(isA(CommandContext.class));
    verify(consumer).onCommandComplete(isA(CommandContext.class), eq(true), eq(1));
    verify(type).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(1, actualExecuteResult);
  }

  /**
   * Test {@link CommandDispatcher#parse(String, Object)} with {@code String}, {@code Object}.
   *
   * <p>Method under test: {@link CommandDispatcher#parse(String, Object)}
   */
  @Test
  @DisplayName("Test parse(String, Object) with 'String', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(String, Object)"})
  void testParseWithStringObject() throws CommandSyntaxException {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    when(type.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenThrow(new TagParseCommandSyntaxException("An error occurred"));

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse("Command", ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(type).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(1, actualParseResult.getExceptions().size());
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    assertSame(commandDispatcher, context.getDispatcher());
    assertSame(root, context.getRootNode());
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
  }

  /**
   * Test {@link CommandDispatcher#parse(String, Object)} with {@code String}, {@code Object}.
   *
   * <p>Method under test: {@link CommandDispatcher#parse(String, Object)}
   */
  @Test
  @DisplayName("Test parse(String, Object) with 'String', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(String, Object)"})
  void testParseWithStringObject2() throws CommandSyntaxException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    CommandSyntaxException commandSyntaxException = new CommandSyntaxException(type, message);

    ArgumentType<Object> type2 = mock(ArgumentType.class);
    when(type2.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenThrow(commandSyntaxException);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse("Command", ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(message).getString();
    verify(type2).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(1, actualParseResult.getExceptions().size());
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    assertSame(commandDispatcher, context.getDispatcher());
    assertSame(root, context.getRootNode());
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
  }

  /**
   * Test {@link CommandDispatcher#parse(String, Object)} with {@code String}, {@code Object}.
   *
   * <p>Method under test: {@link CommandDispatcher#parse(String, Object)}
   */
  @Test
  @DisplayName("Test parse(String, Object) with 'String', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(String, Object)"})
  void testParseWithStringObject3() throws CommandSyntaxException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type, message);

    ArgumentType<Object> type2 = mock(ArgumentType.class);
    when(type2.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    ArgumentType<Object> type3 = mock(ArgumentType.class);
    when(type3.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> requirement3 = mock(Predicate.class);
    when(requirement3.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command3 = mock(Command.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "42",
            type3,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node2);
    root.addChild(node);
    ArgumentType<Object> type4 = mock(ArgumentType.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect3 =
        new LiteralCommandNode<>(
            "Literal",
            command6,
            requirement6,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node3 =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command5,
            requirement5,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node3);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command8,
            requirement8,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command7,
            requirement7,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node4);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command10,
            requirement10,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command9,
            requirement9,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node5);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command12,
            requirement12,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command11,
            requirement11,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node6);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command14,
            requirement14,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command13,
            requirement13,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node7);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command16,
            requirement16,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command15,
            requirement15,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node8);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command18,
            requirement18,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command17,
            requirement17,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node9);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command20,
            requirement20,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command19,
            requirement19,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node10);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command22,
            requirement22,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command21,
            requirement21,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node11);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command24,
            requirement24,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command23,
            requirement23,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node12);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command26,
            requirement26,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command25,
            requirement25,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node13);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command28,
            requirement28,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command27,
            requirement27,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node14);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command30,
            requirement30,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command29,
            requirement29,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node15);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command32,
            requirement32,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command31,
            requirement31,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node16);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command34,
            requirement34,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command33,
            requirement33,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node17);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command36,
            requirement36,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command35,
            requirement35,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node18);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command38,
            requirement38,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command37,
            requirement37,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node19);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command40,
            requirement40,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command39,
            requirement39,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node20);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command41 = mock(Command.class);
    Predicate<Object> requirement41 = mock(Predicate.class);
    Command<Object> command42 = mock(Command.class);
    Predicate<Object> requirement42 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect21 =
        new LiteralCommandNode<>(
            "Literal",
            command42,
            requirement42,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node21 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command41,
            requirement41,
            redirect21,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node21);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse("Command", ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(message).getString();
    verify(type3).parse(isA(StringReader.class), isA(Object.class));
    verify(type2).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement3).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(2, actualParseResult.getExceptions().size());
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    assertSame(commandDispatcher, context.getDispatcher());
    assertSame(root, context.getRootNode());
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
  }

  /**
   * Test {@link CommandDispatcher#parse(String, Object)} with {@code String}, {@code Object}.
   *
   * <p>Method under test: {@link CommandDispatcher#parse(String, Object)}
   */
  @Test
  @DisplayName("Test parse(String, Object) with 'String', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(String, Object)"})
  void testParseWithStringObject4() throws CommandSyntaxException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type, message);

    ArgumentType<Object> type2 = mock(ArgumentType.class);
    when(type2.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    ArgumentType<Object> type3 = mock(ArgumentType.class);
    when(type3.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> requirement3 = mock(Predicate.class);
    when(requirement3.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command3 = mock(Command.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "42",
            type3,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            false,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node2);
    root.addChild(node);
    ArgumentType<Object> type4 = mock(ArgumentType.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect3 =
        new LiteralCommandNode<>(
            "Literal",
            command6,
            requirement6,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node3 =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command5,
            requirement5,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node3);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command8,
            requirement8,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command7,
            requirement7,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node4);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command10,
            requirement10,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command9,
            requirement9,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node5);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command12,
            requirement12,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command11,
            requirement11,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node6);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command14,
            requirement14,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command13,
            requirement13,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node7);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command16,
            requirement16,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command15,
            requirement15,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node8);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command18,
            requirement18,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command17,
            requirement17,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node9);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command20,
            requirement20,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command19,
            requirement19,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node10);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command22,
            requirement22,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command21,
            requirement21,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node11);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command24,
            requirement24,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command23,
            requirement23,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node12);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command26,
            requirement26,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command25,
            requirement25,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node13);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command28,
            requirement28,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command27,
            requirement27,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node14);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command30,
            requirement30,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command29,
            requirement29,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node15);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command32,
            requirement32,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command31,
            requirement31,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node16);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command34,
            requirement34,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command33,
            requirement33,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node17);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command36,
            requirement36,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command35,
            requirement35,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node18);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command38,
            requirement38,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command37,
            requirement37,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node19);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command40,
            requirement40,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command39,
            requirement39,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node20);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command41 = mock(Command.class);
    Predicate<Object> requirement41 = mock(Predicate.class);
    Command<Object> command42 = mock(Command.class);
    Predicate<Object> requirement42 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect21 =
        new LiteralCommandNode<>(
            "Literal",
            command42,
            requirement42,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node21 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command41,
            requirement41,
            redirect21,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node21);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse("Command", ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(message).getString();
    verify(type3).parse(isA(StringReader.class), isA(Object.class));
    verify(type2).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement3).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(2, actualParseResult.getExceptions().size());
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    assertSame(commandDispatcher, context.getDispatcher());
    assertSame(root, context.getRootNode());
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
  }

  /**
   * Test {@link CommandDispatcher#parse(String, Object)} with {@code String}, {@code Object}.
   *
   * <p>Method under test: {@link CommandDispatcher#parse(String, Object)}
   */
  @Test
  @DisplayName("Test parse(String, Object) with 'String', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(String, Object)"})
  void testParseWithStringObject5() throws CommandSyntaxException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type, message);

    ArgumentType<Object> type2 = mock(ArgumentType.class);
    when(type2.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);
    ArgumentType<Object> type3 = mock(ArgumentType.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> redirect2 =
        new ArgumentCommandNode<>(
            "Name",
            type3,
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<Object> node2 =
        new LiteralCommandNode<>(
            "Literal", command3, requirement3, redirect2, mock(RedirectModifier.class), true);
    root.addChild(node2);
    root.addChild(node);
    ArgumentType<Object> type4 = mock(ArgumentType.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect3 =
        new LiteralCommandNode<>(
            "Literal",
            command6,
            requirement6,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node3 =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command5,
            requirement5,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node3);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command8,
            requirement8,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command7,
            requirement7,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node4);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command10,
            requirement10,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command9,
            requirement9,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node5);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command12,
            requirement12,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command11,
            requirement11,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node6);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command14,
            requirement14,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command13,
            requirement13,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node7);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command16,
            requirement16,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command15,
            requirement15,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node8);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command18,
            requirement18,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command17,
            requirement17,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node9);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command20,
            requirement20,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command19,
            requirement19,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node10);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command22,
            requirement22,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command21,
            requirement21,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node11);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command24,
            requirement24,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command23,
            requirement23,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node12);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command26,
            requirement26,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command25,
            requirement25,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node13);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command28,
            requirement28,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command27,
            requirement27,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node14);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command30,
            requirement30,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command29,
            requirement29,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node15);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command32,
            requirement32,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command31,
            requirement31,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node16);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command34,
            requirement34,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command33,
            requirement33,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node17);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command36,
            requirement36,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command35,
            requirement35,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node18);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command38,
            requirement38,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command37,
            requirement37,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node19);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command40,
            requirement40,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command39,
            requirement39,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node20);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command41 = mock(Command.class);
    Predicate<Object> requirement41 = mock(Predicate.class);
    Command<Object> command42 = mock(Command.class);
    Predicate<Object> requirement42 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect21 =
        new LiteralCommandNode<>(
            "Literal",
            command42,
            requirement42,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node21 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command41,
            requirement41,
            redirect21,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node21);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse("Command", ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(message).getString();
    verify(type2).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(1, actualParseResult.getExceptions().size());
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    assertSame(commandDispatcher, context.getDispatcher());
    assertSame(root, context.getRootNode());
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
  }

  /**
   * Test {@link CommandDispatcher#parse(String, Object)} with {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>Given {@link ArgumentType} {@link ArgumentType#parse(StringReader, Object)} throw {@link
   *       RunningOnDifferentThreadException#RUNNING_ON_DIFFERENT_THREAD}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#parse(String, Object)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Object) with 'String', 'Object'; given ArgumentType parse(StringReader, Object) throw RUNNING_ON_DIFFERENT_THREAD")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(String, Object)"})
  void testParseWithStringObject_givenArgumentTypeParseThrowRunning_on_different_thread()
      throws CommandSyntaxException {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    when(type.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenThrow(RunningOnDifferentThreadException.RUNNING_ON_DIFFERENT_THREAD);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse("Command", ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(type).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(1, actualParseResult.getExceptions().size());
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    assertSame(commandDispatcher, context.getDispatcher());
    assertSame(root, context.getRootNode());
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
  }

  /**
   * Test {@link CommandDispatcher#parse(String, Object)} with {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>Then Context RootNode return {@link RootCommandNode}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#parse(String, Object)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Object) with 'String', 'Object'; then Context RootNode return RootCommandNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(String, Object)"})
  void testParseWithStringObject_thenContextRootNodeReturnRootCommandNode() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse("Command", ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    CommandNode<Object> rootNode = context.getRootNode();
    assertTrue(rootNode instanceof RootCommandNode);
    assertTrue(rootNode.getChildren().isEmpty());
    assertTrue(actualParseResult.getExceptions().isEmpty());
    CommandDispatcher<Object> dispatcher = context.getDispatcher();
    assertSame(commandDispatcher, dispatcher);
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
    assertSame(rootNode, dispatcher.getRoot());
  }

  /**
   * Test {@link CommandDispatcher#parse(String, Object)} with {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>Then return Exceptions size is one.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#parse(String, Object)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Object) with 'String', 'Object'; then return Exceptions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(String, Object)"})
  void testParseWithStringObject_thenReturnExceptionsSizeIsOne() throws CommandSyntaxException {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    when(type.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse("Command", ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(type).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(1, actualParseResult.getExceptions().size());
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    assertSame(commandDispatcher, context.getDispatcher());
    assertSame(root, context.getRootNode());
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
  }

  /**
   * Test {@link CommandDispatcher#parse(StringReader, Object)} with {@code StringReader}, {@code
   * Object}.
   *
   * <p>Method under test: {@link CommandDispatcher#parse(StringReader, Object)}
   */
  @Test
  @DisplayName("Test parse(StringReader, Object) with 'StringReader', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(StringReader, Object)"})
  void testParseWithStringReaderObject() throws CommandSyntaxException {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    when(type.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenThrow(new TagParseCommandSyntaxException("An error occurred"));

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse(
            new StringReader("String"), ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(type).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement).test(isA(Object.class));
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    CommandNode<Object> rootNode = context.getRootNode();
    assertTrue(rootNode instanceof RootCommandNode);
    assertEquals(1, rootNode.getChildren().size());
    assertEquals(1, actualParseResult.getExceptions().size());
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
    assertSame(rootNode, context.getDispatcher().getRoot());
  }

  /**
   * Test {@link CommandDispatcher#parse(StringReader, Object)} with {@code StringReader}, {@code
   * Object}.
   *
   * <p>Method under test: {@link CommandDispatcher#parse(StringReader, Object)}
   */
  @Test
  @DisplayName("Test parse(StringReader, Object) with 'StringReader', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(StringReader, Object)"})
  void testParseWithStringReaderObject2() throws CommandSyntaxException {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    when(type.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenThrow(RunningOnDifferentThreadException.RUNNING_ON_DIFFERENT_THREAD);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse(
            new StringReader("String"), ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(type).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement).test(isA(Object.class));
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    CommandNode<Object> rootNode = context.getRootNode();
    assertTrue(rootNode instanceof RootCommandNode);
    assertEquals(1, rootNode.getChildren().size());
    assertEquals(1, actualParseResult.getExceptions().size());
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
    assertSame(rootNode, context.getDispatcher().getRoot());
  }

  /**
   * Test {@link CommandDispatcher#parse(StringReader, Object)} with {@code StringReader}, {@code
   * Object}.
   *
   * <p>Method under test: {@link CommandDispatcher#parse(StringReader, Object)}
   */
  @Test
  @DisplayName("Test parse(StringReader, Object) with 'StringReader', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(StringReader, Object)"})
  void testParseWithStringReaderObject3() throws CommandSyntaxException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    CommandSyntaxException commandSyntaxException = new CommandSyntaxException(type, message);

    ArgumentType<Object> type2 = mock(ArgumentType.class);
    when(type2.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenThrow(commandSyntaxException);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse(
            new StringReader("String"), ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(message).getString();
    verify(type2).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement).test(isA(Object.class));
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    CommandNode<Object> rootNode = context.getRootNode();
    assertTrue(rootNode instanceof RootCommandNode);
    assertEquals(1, rootNode.getChildren().size());
    assertEquals(1, actualParseResult.getExceptions().size());
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
    assertSame(rootNode, context.getDispatcher().getRoot());
  }

  /**
   * Test {@link CommandDispatcher#parse(StringReader, Object)} with {@code StringReader}, {@code
   * Object}.
   *
   * <p>Method under test: {@link CommandDispatcher#parse(StringReader, Object)}
   */
  @Test
  @DisplayName("Test parse(StringReader, Object) with 'StringReader', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(StringReader, Object)"})
  void testParseWithStringReaderObject4() throws CommandSyntaxException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type, message);

    ArgumentType<Object> type2 = mock(ArgumentType.class);
    when(type2.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    ArgumentType<Object> type3 = mock(ArgumentType.class);
    when(type3.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> requirement3 = mock(Predicate.class);
    when(requirement3.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command3 = mock(Command.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "42",
            type3,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            false,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node2);
    root.addChild(node);
    ArgumentType<Object> type4 = mock(ArgumentType.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect3 =
        new LiteralCommandNode<>(
            "Literal",
            command6,
            requirement6,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node3 =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command5,
            requirement5,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node3);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command8,
            requirement8,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command7,
            requirement7,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node4);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command10,
            requirement10,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command9,
            requirement9,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node5);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command12,
            requirement12,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command11,
            requirement11,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node6);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command14,
            requirement14,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command13,
            requirement13,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node7);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command16,
            requirement16,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command15,
            requirement15,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node8);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command18,
            requirement18,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command17,
            requirement17,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node9);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command20,
            requirement20,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command19,
            requirement19,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node10);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command22,
            requirement22,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command21,
            requirement21,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node11);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command24,
            requirement24,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command23,
            requirement23,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node12);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command26,
            requirement26,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command25,
            requirement25,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node13);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command28,
            requirement28,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command27,
            requirement27,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node14);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command30,
            requirement30,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command29,
            requirement29,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node15);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command32,
            requirement32,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command31,
            requirement31,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node16);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command34,
            requirement34,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command33,
            requirement33,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node17);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command36,
            requirement36,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command35,
            requirement35,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node18);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command38,
            requirement38,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command37,
            requirement37,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node19);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command40,
            requirement40,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command39,
            requirement39,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node20);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command41 = mock(Command.class);
    Predicate<Object> requirement41 = mock(Predicate.class);
    Command<Object> command42 = mock(Command.class);
    Predicate<Object> requirement42 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect21 =
        new LiteralCommandNode<>(
            "Literal",
            command42,
            requirement42,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node21 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command41,
            requirement41,
            redirect21,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node21);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse(
            new StringReader("String"), ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(message).getString();
    verify(type3).parse(isA(StringReader.class), isA(Object.class));
    verify(type2).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement3).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    CommandNode<Object> rootNode = context.getRootNode();
    assertTrue(rootNode instanceof RootCommandNode);
    assertEquals(2, rootNode.getChildren().size());
    assertEquals(2, actualParseResult.getExceptions().size());
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
    assertSame(rootNode, context.getDispatcher().getRoot());
  }

  /**
   * Test {@link CommandDispatcher#parse(StringReader, Object)} with {@code StringReader}, {@code
   * Object}.
   *
   * <p>Method under test: {@link CommandDispatcher#parse(StringReader, Object)}
   */
  @Test
  @DisplayName("Test parse(StringReader, Object) with 'StringReader', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(StringReader, Object)"})
  void testParseWithStringReaderObject5() throws CommandSyntaxException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type, message);

    ArgumentType<Object> type2 = mock(ArgumentType.class);
    when(type2.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);
    ArgumentType<Object> type3 = mock(ArgumentType.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> redirect2 =
        new ArgumentCommandNode<>(
            "Name",
            type3,
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<Object> node2 =
        new LiteralCommandNode<>(
            "Literal", command3, requirement3, redirect2, mock(RedirectModifier.class), true);
    root.addChild(node2);
    root.addChild(node);
    ArgumentType<Object> type4 = mock(ArgumentType.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect3 =
        new LiteralCommandNode<>(
            "Literal",
            command6,
            requirement6,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node3 =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command5,
            requirement5,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node3);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command8,
            requirement8,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command7,
            requirement7,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node4);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command10,
            requirement10,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command9,
            requirement9,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node5);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command12,
            requirement12,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command11,
            requirement11,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node6);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command14,
            requirement14,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command13,
            requirement13,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node7);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command16,
            requirement16,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command15,
            requirement15,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node8);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command18,
            requirement18,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command17,
            requirement17,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node9);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command20,
            requirement20,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command19,
            requirement19,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node10);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command22,
            requirement22,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command21,
            requirement21,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node11);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command24,
            requirement24,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command23,
            requirement23,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node12);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command26,
            requirement26,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command25,
            requirement25,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node13);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command28,
            requirement28,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command27,
            requirement27,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node14);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command30,
            requirement30,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command29,
            requirement29,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node15);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command32,
            requirement32,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command31,
            requirement31,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node16);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command34,
            requirement34,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command33,
            requirement33,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node17);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command36,
            requirement36,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command35,
            requirement35,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node18);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command38,
            requirement38,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command37,
            requirement37,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node19);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command40,
            requirement40,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command39,
            requirement39,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node20);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command41 = mock(Command.class);
    Predicate<Object> requirement41 = mock(Predicate.class);
    Command<Object> command42 = mock(Command.class);
    Predicate<Object> requirement42 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect21 =
        new LiteralCommandNode<>(
            "Literal",
            command42,
            requirement42,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node21 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command41,
            requirement41,
            redirect21,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node21);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse(
            new StringReader("String"), ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(message).getString();
    verify(type2).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement).test(isA(Object.class));
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    CommandNode<Object> rootNode = context.getRootNode();
    assertTrue(rootNode instanceof RootCommandNode);
    assertEquals(1, actualParseResult.getExceptions().size());
    assertEquals(2, rootNode.getChildren().size());
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
    assertSame(rootNode, context.getDispatcher().getRoot());
  }

  /**
   * Test {@link CommandDispatcher#parse(StringReader, Object)} with {@code StringReader}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#parse(StringReader, Object)}
   */
  @Test
  @DisplayName(
      "Test parse(StringReader, Object) with 'StringReader', 'Object'; given Predicate test(Object) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(StringReader, Object)"})
  void testParseWithStringReaderObject_givenPredicateTestReturnFalse()
      throws CommandSyntaxException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type, message);

    ArgumentType<Object> type2 = mock(ArgumentType.class);
    when(type2.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(false);
    ArgumentType<Object> type3 = mock(ArgumentType.class);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "42",
            type3,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node2.requirement = predicate;

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node2);
    root.addChild(node);
    ArgumentType<Object> type4 = mock(ArgumentType.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect3 =
        new LiteralCommandNode<>(
            "Literal",
            command6,
            requirement6,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node3 =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command5,
            requirement5,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node3);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command8,
            requirement8,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command7,
            requirement7,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node4);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command10,
            requirement10,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command9,
            requirement9,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node5);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command12,
            requirement12,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command11,
            requirement11,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node6);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command14,
            requirement14,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command13,
            requirement13,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node7);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command16,
            requirement16,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command15,
            requirement15,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node8);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command18,
            requirement18,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command17,
            requirement17,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node9);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command20,
            requirement20,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command19,
            requirement19,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node10);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command22,
            requirement22,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command21,
            requirement21,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node11);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command24,
            requirement24,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command23,
            requirement23,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node12);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command26,
            requirement26,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command25,
            requirement25,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node13);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command28,
            requirement28,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command27,
            requirement27,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node14);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command30,
            requirement30,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command29,
            requirement29,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node15);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command32,
            requirement32,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command31,
            requirement31,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node16);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command34,
            requirement34,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command33,
            requirement33,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node17);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command36,
            requirement36,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command35,
            requirement35,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node18);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command38,
            requirement38,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command37,
            requirement37,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node19);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command40,
            requirement40,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command39,
            requirement39,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node20);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command41 = mock(Command.class);
    Predicate<Object> requirement41 = mock(Predicate.class);
    Command<Object> command42 = mock(Command.class);
    Predicate<Object> requirement42 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect21 =
        new LiteralCommandNode<>(
            "Literal",
            command42,
            requirement42,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node21 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command41,
            requirement41,
            redirect21,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node21);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse(
            new StringReader("String"), ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(message).getString();
    verify(type2).parse(isA(StringReader.class), isA(Object.class));
    verify(predicate).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    CommandNode<Object> rootNode = context.getRootNode();
    assertTrue(rootNode instanceof RootCommandNode);
    assertEquals(1, actualParseResult.getExceptions().size());
    assertEquals(2, rootNode.getChildren().size());
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
    assertSame(rootNode, context.getDispatcher().getRoot());
  }

  /**
   * Test {@link CommandDispatcher#parse(StringReader, Object)} with {@code StringReader}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Then Reader return {@link StringReader}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#parse(StringReader, Object)}
   */
  @Test
  @DisplayName(
      "Test parse(StringReader, Object) with 'StringReader', 'Object'; then Reader return StringReader")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(StringReader, Object)"})
  void testParseWithStringReaderObject_thenReaderReturnStringReader()
      throws CommandSyntaxException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type, message);

    ArgumentType<Object> type2 = mock(ArgumentType.class);
    when(type2.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    ArgumentType<Object> type3 = mock(ArgumentType.class);
    when(type3.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "42",
            type3,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node2.requirement = predicate;

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node2);
    root.addChild(node);
    ArgumentType<Object> type4 = mock(ArgumentType.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect3 =
        new LiteralCommandNode<>(
            "Literal",
            command6,
            requirement6,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node3 =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command5,
            requirement5,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node3);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command8,
            requirement8,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command7,
            requirement7,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node4);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command10,
            requirement10,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command9,
            requirement9,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node5);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command12,
            requirement12,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command11,
            requirement11,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node6);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command14,
            requirement14,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command13,
            requirement13,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node7);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command16,
            requirement16,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command15,
            requirement15,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node8);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command18,
            requirement18,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command17,
            requirement17,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node9);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command20,
            requirement20,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command19,
            requirement19,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node10);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command22,
            requirement22,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command21,
            requirement21,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node11);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command24,
            requirement24,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command23,
            requirement23,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node12);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command26,
            requirement26,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command25,
            requirement25,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node13);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command28,
            requirement28,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command27,
            requirement27,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node14);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command30,
            requirement30,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command29,
            requirement29,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node15);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command32,
            requirement32,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command31,
            requirement31,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node16);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command34,
            requirement34,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command33,
            requirement33,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node17);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command36,
            requirement36,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command35,
            requirement35,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node18);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command38,
            requirement38,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command37,
            requirement37,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node19);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command40,
            requirement40,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command39,
            requirement39,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node20);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command41 = mock(Command.class);
    Predicate<Object> requirement41 = mock(Predicate.class);
    Command<Object> command42 = mock(Command.class);
    Predicate<Object> requirement42 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect21 =
        new LiteralCommandNode<>(
            "Literal",
            command42,
            requirement42,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node21 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command41,
            requirement41,
            redirect21,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node21);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    ParseResults<Object> actualParseResult = commandDispatcher.parse(new StringReader(""), object);

    // Assert
    verify(message).getString();
    verify(type3).parse(isA(StringReader.class), isA(Object.class));
    verify(type2).parse(isA(StringReader.class), isA(Object.class));
    verify(predicate).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    ImmutableStringReader reader = actualParseResult.getReader();
    assertTrue(reader instanceof StringReader);
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    List<ParsedCommandNode<Object>> nodes = context.getNodes();
    assertEquals(1, nodes.size());
    ParsedCommandNode<Object> getResult = nodes.get(0);
    CommandNode<Object> node22 = getResult.getNode();
    assertTrue(node22 instanceof ArgumentCommandNode);
    assertEquals("", reader.getRemaining());
    assertEquals("", reader.getString());
    assertEquals(0, reader.getRemainingLength());
    assertEquals(0, reader.getTotalLength());
    Map<String, ParsedArgument<Object, ?>> arguments = context.getArguments();
    assertEquals(1, arguments.size());
    assertSame(node2, node22);
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
    ParsedArgument<Object, ?> getResult2 = arguments.get("42");
    assertSame(getResult2.getRange(), getResult.getRange());
    assertSame(object, getResult2.getResult());
  }

  /**
   * Test {@link CommandDispatcher#parse(StringReader, Object)} with {@code StringReader}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Then return Context RootNode Children Empty.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#parse(StringReader, Object)}
   */
  @Test
  @DisplayName(
      "Test parse(StringReader, Object) with 'StringReader', 'Object'; then return Context RootNode Children Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(StringReader, Object)"})
  void testParseWithStringReaderObject_thenReturnContextRootNodeChildrenEmpty() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    // Act and Assert
    CommandContextBuilder<Object> context =
        commandDispatcher
            .parse(new StringReader("String"), ConfigurationTransformation.WILDCARD_OBJECT)
            .getContext();
    CommandNode<Object> rootNode = context.getRootNode();
    assertTrue(rootNode instanceof RootCommandNode);
    assertTrue(rootNode.getChildren().isEmpty());
    CommandDispatcher<Object> dispatcher = context.getDispatcher();
    assertSame(commandDispatcher, dispatcher);
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
    assertSame(rootNode, dispatcher.getRoot());
  }

  /**
   * Test {@link CommandDispatcher#parse(StringReader, Object)} with {@code StringReader}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Then return Context RootNode Children size is one.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#parse(StringReader, Object)}
   */
  @Test
  @DisplayName(
      "Test parse(StringReader, Object) with 'StringReader', 'Object'; then return Context RootNode Children size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(StringReader, Object)"})
  void testParseWithStringReaderObject_thenReturnContextRootNodeChildrenSizeIsOne()
      throws CommandSyntaxException {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    when(type.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse(
            new StringReader("String"), ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(type).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement).test(isA(Object.class));
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    CommandNode<Object> rootNode = context.getRootNode();
    assertTrue(rootNode instanceof RootCommandNode);
    assertEquals(1, rootNode.getChildren().size());
    assertEquals(1, actualParseResult.getExceptions().size());
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
    assertSame(rootNode, context.getDispatcher().getRoot());
  }

  /**
   * Test {@link CommandDispatcher#parse(StringReader, Object)} with {@code StringReader}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Then return Exceptions size is two.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#parse(StringReader, Object)}
   */
  @Test
  @DisplayName(
      "Test parse(StringReader, Object) with 'StringReader', 'Object'; then return Exceptions size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParseResults CommandDispatcher.parse(StringReader, Object)"})
  void testParseWithStringReaderObject_thenReturnExceptionsSizeIsTwo()
      throws CommandSyntaxException {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    new CommandSyntaxException(type, message);

    ArgumentType<Object> type2 = mock(ArgumentType.class);
    when(type2.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    ArgumentType<Object> type3 = mock(ArgumentType.class);
    when(type3.parse(Mockito.<StringReader>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Predicate<Object> requirement3 = mock(Predicate.class);
    when(requirement3.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command3 = mock(Command.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "42",
            type3,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node2);
    root.addChild(node);
    ArgumentType<Object> type4 = mock(ArgumentType.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect3 =
        new LiteralCommandNode<>(
            "Literal",
            command6,
            requirement6,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node3 =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command5,
            requirement5,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node3);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command8,
            requirement8,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command7,
            requirement7,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node4);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command10,
            requirement10,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command9,
            requirement9,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node5);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command12,
            requirement12,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command11,
            requirement11,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node6);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command14,
            requirement14,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command13,
            requirement13,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node7);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command16,
            requirement16,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command15,
            requirement15,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node8);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command18,
            requirement18,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command17,
            requirement17,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node9);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command20,
            requirement20,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command19,
            requirement19,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node10);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command22,
            requirement22,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command21,
            requirement21,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node11);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command24,
            requirement24,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command23,
            requirement23,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node12);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command26,
            requirement26,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command25,
            requirement25,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node13);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command28,
            requirement28,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command27,
            requirement27,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node14);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command30,
            requirement30,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command29,
            requirement29,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node15);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command32,
            requirement32,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command31,
            requirement31,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node16);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command34,
            requirement34,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command33,
            requirement33,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node17);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command36,
            requirement36,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command35,
            requirement35,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node18);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command38,
            requirement38,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command37,
            requirement37,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node19);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command40,
            requirement40,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command39,
            requirement39,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node20);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command41 = mock(Command.class);
    Predicate<Object> requirement41 = mock(Predicate.class);
    Command<Object> command42 = mock(Command.class);
    Predicate<Object> requirement42 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect21 =
        new LiteralCommandNode<>(
            "Literal",
            command42,
            requirement42,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node21 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command41,
            requirement41,
            redirect21,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node21);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    ParseResults<Object> actualParseResult =
        commandDispatcher.parse(
            new StringReader("String"), ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(message).getString();
    verify(type3).parse(isA(StringReader.class), isA(Object.class));
    verify(type2).parse(isA(StringReader.class), isA(Object.class));
    verify(requirement3).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    CommandContextBuilder<Object> context = actualParseResult.getContext();
    CommandNode<Object> rootNode = context.getRootNode();
    assertTrue(rootNode instanceof RootCommandNode);
    assertEquals(2, rootNode.getChildren().size());
    assertEquals(2, actualParseResult.getExceptions().size());
    CommandContextBuilder<Object> actualLastChild = context.getLastChild();
    assertSame(context, actualLastChild);
    assertSame(rootNode, context.getDispatcher().getRoot());
  }

  /**
   * Test {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)} with {@code node},
   * {@code source}, {@code restricted}.
   *
   * <p>Method under test: {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)}
   */
  @Test
  @DisplayName("Test getAllUsage(CommandNode, Object, boolean) with 'node', 'source', 'restricted'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] CommandDispatcher.getAllUsage(CommandNode, Object, boolean)"})
  void testGetAllUsageWithNodeSourceRestricted() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act and Assert
    assertArrayEquals(
        new String[] {"", "<Name> -> Literal"},
        commandDispatcher.getAllUsage(node, ConfigurationTransformation.WILDCARD_OBJECT, false));
  }

  /**
   * Test {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)} with {@code node},
   * {@code source}, {@code restricted}.
   *
   * <p>Method under test: {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)}
   */
  @Test
  @DisplayName("Test getAllUsage(CommandNode, Object, boolean) with 'node', 'source', 'restricted'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] CommandDispatcher.getAllUsage(CommandNode, Object, boolean)"})
  void testGetAllUsageWithNodeSourceRestricted2() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command3,
            requirement3,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> redirect2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command2,
            requirement2,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act and Assert
    assertArrayEquals(
        new String[] {"", "<Name> -> <Name>"},
        commandDispatcher.getAllUsage(node, ConfigurationTransformation.WILDCARD_OBJECT, false));
  }

  /**
   * Test {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)} with {@code node},
   * {@code source}, {@code restricted}.
   *
   * <p>Method under test: {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)}
   */
  @Test
  @DisplayName("Test getAllUsage(CommandNode, Object, boolean) with 'node', 'source', 'restricted'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] CommandDispatcher.getAllUsage(CommandNode, Object, boolean)"})
  void testGetAllUsageWithNodeSourceRestricted3() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act
    String[] actualAllUsage =
        commandDispatcher.getAllUsage(node, ConfigurationTransformation.WILDCARD_OBJECT, true);

    // Assert
    verify(requirement).test(isA(Object.class));
    assertArrayEquals(new String[] {"", "<Name> -> Literal"}, actualAllUsage);
  }

  /**
   * Test {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)} with {@code node},
   * {@code source}, {@code restricted}.
   *
   * <p>Method under test: {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)}
   */
  @Test
  @DisplayName("Test getAllUsage(CommandNode, Object, boolean) with 'node', 'source', 'restricted'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] CommandDispatcher.getAllUsage(CommandNode, Object, boolean)"})
  void testGetAllUsageWithNodeSourceRestricted4() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act
    String[] actualAllUsage =
        commandDispatcher.getAllUsage(node, ConfigurationTransformation.WILDCARD_OBJECT, true);

    // Assert
    verify(requirement).test(isA(Object.class));
    assertArrayEquals(new String[] {"", "<Name> -> "}, actualAllUsage);
  }

  /**
   * Test {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)} with {@code node},
   * {@code source}, {@code restricted}.
   *
   * <p>Method under test: {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)}
   */
  @Test
  @DisplayName("Test getAllUsage(CommandNode, Object, boolean) with 'node', 'source', 'restricted'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] CommandDispatcher.getAllUsage(CommandNode, Object, boolean)"})
  void testGetAllUsageWithNodeSourceRestricted5() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<Object> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);
    node.requirement = predicate;

    // Act
    String[] actualAllUsage =
        commandDispatcher.getAllUsage(node, ConfigurationTransformation.WILDCARD_OBJECT, true);

    // Assert
    verify(predicate).test(isA(Object.class));
    assertArrayEquals(new String[] {"", "Literal -> <Name>"}, actualAllUsage);
  }

  /**
   * Test {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)} with {@code node},
   * {@code source}, {@code restricted}.
   *
   * <p>Method under test: {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)}
   */
  @Test
  @DisplayName("Test getAllUsage(CommandNode, Object, boolean) with 'node', 'source', 'restricted'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] CommandDispatcher.getAllUsage(CommandNode, Object, boolean)"})
  void testGetAllUsageWithNodeSourceRestricted6() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(true);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "<",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "<",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> node2 = new RootCommandNode<>();
    node2.addChild(node);
    node2.requirement = predicate;

    // Act
    String[] actualAllUsage =
        commandDispatcher.getAllUsage(node2, ConfigurationTransformation.WILDCARD_OBJECT, true);

    // Assert
    verify(requirement).test(isA(Object.class));
    verify(predicate).test(isA(Object.class));
    assertArrayEquals(new String[] {"<<>", "<<> -> <"}, actualAllUsage);
  }

  /**
   * Test {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)} with {@code node},
   * {@code source}, {@code restricted}.
   *
   * <p>Method under test: {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)}
   */
  @Test
  @DisplayName("Test getAllUsage(CommandNode, Object, boolean) with 'node', 'source', 'restricted'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] CommandDispatcher.getAllUsage(CommandNode, Object, boolean)"})
  void testGetAllUsageWithNodeSourceRestricted7() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(true);

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command = mock(Command.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<Object> node =
        new LiteralCommandNode<>(
            "<", command, requirement, redirect, mock(RedirectModifier.class), true);

    RootCommandNode<Object> node2 = new RootCommandNode<>();
    node2.addChild(node);
    node2.requirement = predicate;

    // Act
    String[] actualAllUsage =
        commandDispatcher.getAllUsage(node2, ConfigurationTransformation.WILDCARD_OBJECT, true);

    // Assert
    verify(requirement).test(isA(Object.class));
    verify(predicate).test(isA(Object.class));
    assertArrayEquals(new String[] {"<", "< -> <Name>"}, actualAllUsage);
  }

  /**
   * Test {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)} with {@code node},
   * {@code source}, {@code restricted}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAllUsage(CommandNode, Object, boolean) with 'node', 'source', 'restricted'; given Predicate test(Object) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] CommandDispatcher.getAllUsage(CommandNode, Object, boolean)"})
  void testGetAllUsageWithNodeSourceRestricted_givenPredicateTestReturnFalse() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(false);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node.requirement = predicate;

    // Act
    String[] actualAllUsage =
        commandDispatcher.getAllUsage(node, ConfigurationTransformation.WILDCARD_OBJECT, true);

    // Assert
    verify(predicate).test(isA(Object.class));
    assertEquals(0, actualAllUsage.length);
  }

  /**
   * Test {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)} with {@code node},
   * {@code source}, {@code restricted}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with empty string.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAllUsage(CommandNode, Object, boolean) with 'node', 'source', 'restricted'; then return array of String with empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] CommandDispatcher.getAllUsage(CommandNode, Object, boolean)"})
  void testGetAllUsageWithNodeSourceRestricted_thenReturnArrayOfStringWithEmptyString() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();
    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            mock(ArgumentType.class),
            mock(Command.class),
            mock(Predicate.class),
            null,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act and Assert
    assertArrayEquals(
        new String[] {""},
        commandDispatcher.getAllUsage(node, ConfigurationTransformation.WILDCARD_OBJECT, false));
  }

  /**
   * Test {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)} with {@code node},
   * {@code source}, {@code restricted}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code <Name> -> <Name>}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAllUsage(CommandNode, Object, boolean) with 'node', 'source', 'restricted'; then return array of String with '<Name> -> <Name>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] CommandDispatcher.getAllUsage(CommandNode, Object, boolean)"})
  void testGetAllUsageWithNodeSourceRestricted_thenReturnArrayOfStringWithNameName() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Predicate<Object> requirement = mock(Predicate.class);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement3,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> redirect2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command,
            requirement2,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            null,
            requirement,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act and Assert
    assertArrayEquals(
        new String[] {"<Name> -> <Name>"},
        commandDispatcher.getAllUsage(node, ConfigurationTransformation.WILDCARD_OBJECT, false));
  }

  /**
   * Test {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)} with {@code node},
   * {@code source}, {@code restricted}.
   *
   * <ul>
   *   <li>When {@link RootCommandNode} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#getAllUsage(CommandNode, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAllUsage(CommandNode, Object, boolean) with 'node', 'source', 'restricted'; when RootCommandNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] CommandDispatcher.getAllUsage(CommandNode, Object, boolean)"})
  void testGetAllUsageWithNodeSourceRestricted_whenRootCommandNode() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    // Act and Assert
    assertEquals(
        0,
        commandDispatcher.getAllUsage(
                new RootCommandNode<>(), ConfigurationTransformation.WILDCARD_OBJECT, true)
            .length);
  }

  /**
   * Test {@link CommandDispatcher#getSmartUsage(CommandNode, Object)} with {@code node}, {@code
   * source}.
   *
   * <p>Method under test: {@link CommandDispatcher#getSmartUsage(CommandNode, Object)}
   */
  @Test
  @DisplayName("Test getSmartUsage(CommandNode, Object) with 'node', 'source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CommandDispatcher.getSmartUsage(CommandNode, Object)"})
  void testGetSmartUsageWithNodeSource() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act and Assert
    assertTrue(
        commandDispatcher
            .getSmartUsage(node, ConfigurationTransformation.WILDCARD_OBJECT)
            .isEmpty());
  }

  /**
   * Test {@link CommandDispatcher#getSmartUsage(CommandNode, Object)} with {@code node}, {@code
   * source}.
   *
   * <p>Method under test: {@link CommandDispatcher#getSmartUsage(CommandNode, Object)}
   */
  @Test
  @DisplayName("Test getSmartUsage(CommandNode, Object) with 'node', 'source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CommandDispatcher.getSmartUsage(CommandNode, Object)"})
  void testGetSmartUsageWithNodeSource2() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            null,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act and Assert
    assertTrue(
        commandDispatcher
            .getSmartUsage(node, ConfigurationTransformation.WILDCARD_OBJECT)
            .isEmpty());
  }

  /**
   * Test {@link CommandDispatcher#getSmartUsage(CommandNode, Object)} with {@code node}, {@code
   * source}.
   *
   * <p>Method under test: {@link CommandDispatcher#getSmartUsage(CommandNode, Object)}
   */
  @Test
  @DisplayName("Test getSmartUsage(CommandNode, Object) with 'node', 'source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CommandDispatcher.getSmartUsage(CommandNode, Object)"})
  void testGetSmartUsageWithNodeSource3() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "<",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    Predicate<Object> requirement3 = mock(Predicate.class);
    when(requirement3.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command3 = mock(Command.class);
    ArgumentType<Object> type3 = mock(ArgumentType.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command5,
            requirement5,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> redirect3 =
        new ArgumentCommandNode<>(
            "Name",
            type3,
            command4,
            requirement4,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command3,
            requirement3,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    ArgumentType<Object> type4 = mock(ArgumentType.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command7,
            requirement7,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node3 =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command6,
            requirement6,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node2);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command9,
            requirement9,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command8,
            requirement8,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node4);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command11,
            requirement11,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command10,
            requirement10,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node5);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command13,
            requirement13,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command12,
            requirement12,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node6);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command15,
            requirement15,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command14,
            requirement14,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node7);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command17,
            requirement17,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command16,
            requirement16,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node8);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command19,
            requirement19,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command18,
            requirement18,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node9);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command21,
            requirement21,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command20,
            requirement20,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node10);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command23,
            requirement23,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command22,
            requirement22,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node11);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command25,
            requirement25,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command24,
            requirement24,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node12);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command27,
            requirement27,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command26,
            requirement26,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node13);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command29,
            requirement29,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command28,
            requirement28,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node14);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command31,
            requirement31,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command30,
            requirement30,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node15);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command33,
            requirement33,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command32,
            requirement32,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node16);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command35,
            requirement35,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command34,
            requirement34,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node17);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command37,
            requirement37,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command36,
            requirement36,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node18);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command39,
            requirement39,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command38,
            requirement38,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node19);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);
    Command<Object> command41 = mock(Command.class);
    Predicate<Object> requirement41 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect21 =
        new LiteralCommandNode<>(
            "Literal",
            command41,
            requirement41,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command40,
            requirement40,
            redirect21,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node20);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command42 = mock(Command.class);
    Predicate<Object> requirement42 = mock(Predicate.class);
    Command<Object> command43 = mock(Command.class);
    Predicate<Object> requirement43 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect22 =
        new LiteralCommandNode<>(
            "Literal",
            command43,
            requirement43,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node21 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command42,
            requirement42,
            redirect22,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node21);
    node3.addChild(node);
    ArgumentType<Object> type23 = mock(ArgumentType.class);
    Command<Object> command44 = mock(Command.class);
    Predicate<Object> requirement44 = mock(Predicate.class);
    Command<Object> command45 = mock(Command.class);
    Predicate<Object> requirement45 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect23 =
        new LiteralCommandNode<>(
            "Literal",
            command45,
            requirement45,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node22 =
        new ArgumentCommandNode<>(
            "Name",
            type23,
            command44,
            requirement44,
            redirect23,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node22);

    // Act
    Map<CommandNode<Object>, String> actualSmartUsage =
        commandDispatcher.getSmartUsage(node3, ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(requirement3).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(2, actualSmartUsage.size());
  }

  /**
   * Test {@link CommandDispatcher#getSmartUsage(CommandNode, Object)} with {@code node}, {@code
   * source}.
   *
   * <p>Method under test: {@link CommandDispatcher#getSmartUsage(CommandNode, Object)}
   */
  @Test
  @DisplayName("Test getSmartUsage(CommandNode, Object) with 'node', 'source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CommandDispatcher.getSmartUsage(CommandNode, Object)"})
  void testGetSmartUsageWithNodeSource4() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "<",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    Predicate<Object> requirement3 = mock(Predicate.class);
    when(requirement3.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "Name",
            mock(ArgumentType.class),
            mock(Command.class),
            requirement3,
            null,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement5,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node3 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command3,
            requirement4,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node2);
    ArgumentType<Object> type3 = mock(ArgumentType.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect3 =
        new LiteralCommandNode<>(
            "Literal",
            command6,
            requirement7,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type3,
            command5,
            requirement6,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node4);
    ArgumentType<Object> type4 = mock(ArgumentType.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command8,
            requirement9,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command7,
            requirement8,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node5);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command10,
            requirement11,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command9,
            requirement10,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node6);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command12,
            requirement13,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command11,
            requirement12,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node7);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command14,
            requirement15,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command13,
            requirement14,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node8);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command16,
            requirement17,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command15,
            requirement16,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node9);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command18,
            requirement19,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command17,
            requirement18,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node10);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command20,
            requirement21,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command19,
            requirement20,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node11);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command22,
            requirement23,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command21,
            requirement22,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node12);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command24,
            requirement25,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command23,
            requirement24,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node13);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command26,
            requirement27,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command25,
            requirement26,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node14);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command28,
            requirement29,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command27,
            requirement28,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node15);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command30,
            requirement31,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command29,
            requirement30,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node16);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command32,
            requirement33,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command31,
            requirement32,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node17);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command34,
            requirement35,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command33,
            requirement34,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node18);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command36,
            requirement37,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command35,
            requirement36,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node19);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command38,
            requirement39,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command37,
            requirement38,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node20);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement41 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command40,
            requirement41,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node21 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command39,
            requirement40,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node21);
    node3.addChild(node);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command41 = mock(Command.class);
    Predicate<Object> requirement42 = mock(Predicate.class);
    Command<Object> command42 = mock(Command.class);
    Predicate<Object> requirement43 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect21 =
        new LiteralCommandNode<>(
            "Literal",
            command42,
            requirement43,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node22 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command41,
            requirement42,
            redirect21,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node22);

    // Act
    Map<CommandNode<Object>, String> actualSmartUsage =
        commandDispatcher.getSmartUsage(node3, ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(requirement3).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(2, actualSmartUsage.size());
  }

  /**
   * Test {@link CommandDispatcher#getSmartUsage(CommandNode, Object)} with {@code node}, {@code
   * source}.
   *
   * <p>Method under test: {@link CommandDispatcher#getSmartUsage(CommandNode, Object)}
   */
  @Test
  @DisplayName("Test getSmartUsage(CommandNode, Object) with 'node', 'source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CommandDispatcher.getSmartUsage(CommandNode, Object)"})
  void testGetSmartUsageWithNodeSource5() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "<",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    Predicate<Object> requirement3 = mock(Predicate.class);
    when(requirement3.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command3 = mock(Command.class);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command3,
            requirement3,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    ArgumentType<Object> type3 = mock(ArgumentType.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command5,
            requirement5,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node3 =
        new ArgumentCommandNode<>(
            "Name",
            type3,
            command4,
            requirement4,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node2);
    ArgumentType<Object> type4 = mock(ArgumentType.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect3 =
        new LiteralCommandNode<>(
            "Literal",
            command7,
            requirement7,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command6,
            requirement6,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node4);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command9,
            requirement9,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command8,
            requirement8,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node5);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command11,
            requirement11,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command10,
            requirement10,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node6);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command13,
            requirement13,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command12,
            requirement12,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node7);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command15,
            requirement15,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command14,
            requirement14,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node8);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command17,
            requirement17,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command16,
            requirement16,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node9);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command19,
            requirement19,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command18,
            requirement18,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node10);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command21,
            requirement21,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command20,
            requirement20,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node11);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command23,
            requirement23,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command22,
            requirement22,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node12);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command25,
            requirement25,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command24,
            requirement24,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node13);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command27,
            requirement27,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command26,
            requirement26,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node14);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command29,
            requirement29,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command28,
            requirement28,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node15);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command31,
            requirement31,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command30,
            requirement30,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node16);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command33,
            requirement33,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command32,
            requirement32,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node17);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command35,
            requirement35,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command34,
            requirement34,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node18);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command37,
            requirement37,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command36,
            requirement36,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node19);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command39,
            requirement39,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command38,
            requirement38,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node20);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);
    Command<Object> command41 = mock(Command.class);
    Predicate<Object> requirement41 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command41,
            requirement41,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node21 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command40,
            requirement40,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node21);
    node3.addChild(node);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command42 = mock(Command.class);
    Predicate<Object> requirement42 = mock(Predicate.class);
    Command<Object> command43 = mock(Command.class);
    Predicate<Object> requirement43 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect21 =
        new LiteralCommandNode<>(
            "Literal",
            command43,
            requirement43,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node22 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command42,
            requirement42,
            redirect21,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node3.addChild(node22);

    // Act
    Map<CommandNode<Object>, String> actualSmartUsage =
        commandDispatcher.getSmartUsage(node3, ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(requirement3).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(2, actualSmartUsage.size());
  }

  /**
   * Test {@link CommandDispatcher#getSmartUsage(CommandNode, Object)} with {@code node}, {@code
   * source}.
   *
   * <p>Method under test: {@link CommandDispatcher#getSmartUsage(CommandNode, Object)}
   */
  @Test
  @DisplayName("Test getSmartUsage(CommandNode, Object) with 'node', 'source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CommandDispatcher.getSmartUsage(CommandNode, Object)"})
  void testGetSmartUsageWithNodeSource6() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "<",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    Predicate<Object> requirement3 = mock(Predicate.class);
    when(requirement3.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command3 = mock(Command.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    Predicate<Object> requirement5 = mock(Predicate.class);
    when(requirement5.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command5 = mock(Command.class);
    ArgumentType<Object> type3 = mock(ArgumentType.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> redirect3 =
        new ArgumentCommandNode<>(
            "Name",
            type3,
            command6,
            requirement6,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<Object> node3 =
        new LiteralCommandNode<>(
            "Literal", command5, requirement5, redirect3, mock(RedirectModifier.class), true);

    RootCommandNode<Object> node4 = new RootCommandNode<>();
    node4.addChild(node3);
    node4.addChild(node2);
    ArgumentType<Object> type4 = mock(ArgumentType.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command8,
            requirement8,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command7,
            requirement7,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node5);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command10,
            requirement10,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command9,
            requirement9,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node6);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command12,
            requirement12,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command11,
            requirement11,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node7);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command14,
            requirement14,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command13,
            requirement13,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node8);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command16,
            requirement16,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command15,
            requirement15,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node9);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command18,
            requirement18,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command17,
            requirement17,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node10);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command20,
            requirement20,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command19,
            requirement19,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node11);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command22,
            requirement22,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command21,
            requirement21,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node12);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command24,
            requirement24,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command23,
            requirement23,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node13);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command26,
            requirement26,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command25,
            requirement25,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node14);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command28,
            requirement28,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command27,
            requirement27,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node15);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command30,
            requirement30,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command29,
            requirement29,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node16);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command32,
            requirement32,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command31,
            requirement31,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node17);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command34,
            requirement34,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command33,
            requirement33,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node18);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command36,
            requirement36,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command35,
            requirement35,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node19);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command38,
            requirement38,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command37,
            requirement37,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node20);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command40,
            requirement40,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node21 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command39,
            requirement39,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node21);
    node4.addChild(node);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command41 = mock(Command.class);
    Predicate<Object> requirement41 = mock(Predicate.class);
    Command<Object> command42 = mock(Command.class);
    Predicate<Object> requirement42 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect21 =
        new LiteralCommandNode<>(
            "Literal",
            command42,
            requirement42,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node22 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command41,
            requirement41,
            redirect21,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node22);

    // Act
    Map<CommandNode<Object>, String> actualSmartUsage =
        commandDispatcher.getSmartUsage(node4, ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(requirement5).test(isA(Object.class));
    verify(requirement3).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(3, actualSmartUsage.size());
  }

  /**
   * Test {@link CommandDispatcher#getSmartUsage(CommandNode, Object)} with {@code node}, {@code
   * source}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#getSmartUsage(CommandNode, Object)}
   */
  @Test
  @DisplayName(
      "Test getSmartUsage(CommandNode, Object) with 'node', 'source'; given Predicate test(Object) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CommandDispatcher.getSmartUsage(CommandNode, Object)"})
  void testGetSmartUsageWithNodeSource_givenPredicateTestReturnFalse() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "<",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    Predicate<Object> requirement3 = mock(Predicate.class);
    when(requirement3.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command3 = mock(Command.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(false);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement5 = mock(Predicate.class);
    ArgumentType<Object> type3 = mock(ArgumentType.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> redirect3 =
        new ArgumentCommandNode<>(
            "Name",
            type3,
            command6,
            requirement6,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<Object> node3 =
        new LiteralCommandNode<>(
            "Literal", command5, requirement5, redirect3, mock(RedirectModifier.class), true);
    node3.requirement = predicate;
    ArgumentType<Object> type4 = mock(ArgumentType.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command8,
            requirement8,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command7,
            requirement7,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node3);
    node4.addChild(node2);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command10,
            requirement10,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command9,
            requirement9,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node5);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command12,
            requirement12,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command11,
            requirement11,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node6);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command14,
            requirement14,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command13,
            requirement13,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node7);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command16,
            requirement16,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command15,
            requirement15,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node8);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command18,
            requirement18,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command17,
            requirement17,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node9);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command20,
            requirement20,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command19,
            requirement19,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node10);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command22,
            requirement22,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command21,
            requirement21,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node11);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command24,
            requirement24,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command23,
            requirement23,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node12);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command26,
            requirement26,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command25,
            requirement25,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node13);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command28,
            requirement28,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command27,
            requirement27,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node14);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command30,
            requirement30,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command29,
            requirement29,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node15);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command32,
            requirement32,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command31,
            requirement31,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node16);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command34,
            requirement34,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command33,
            requirement33,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node17);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command36,
            requirement36,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command35,
            requirement35,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node18);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command38,
            requirement38,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command37,
            requirement37,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node19);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command40,
            requirement40,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command39,
            requirement39,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node20);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command41 = mock(Command.class);
    Predicate<Object> requirement41 = mock(Predicate.class);
    Command<Object> command42 = mock(Command.class);
    Predicate<Object> requirement42 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect21 =
        new LiteralCommandNode<>(
            "Literal",
            command42,
            requirement42,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node21 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command41,
            requirement41,
            redirect21,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node21);
    node4.addChild(node);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command43 = mock(Command.class);
    Predicate<Object> requirement43 = mock(Predicate.class);
    Command<Object> command44 = mock(Command.class);
    Predicate<Object> requirement44 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect22 =
        new LiteralCommandNode<>(
            "Literal",
            command44,
            requirement44,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node22 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command43,
            requirement43,
            redirect22,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node22);

    // Act
    Map<CommandNode<Object>, String> actualSmartUsage =
        commandDispatcher.getSmartUsage(node4, ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(predicate).test(isA(Object.class));
    verify(requirement3).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(2, actualSmartUsage.size());
  }

  /**
   * Test {@link CommandDispatcher#getSmartUsage(CommandNode, Object)} with {@code node}, {@code
   * source}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#getSmartUsage(CommandNode, Object)}
   */
  @Test
  @DisplayName(
      "Test getSmartUsage(CommandNode, Object) with 'node', 'source'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CommandDispatcher.getSmartUsage(CommandNode, Object)"})
  void testGetSmartUsageWithNodeSource_thenReturnSizeIsOne() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node2.addChild(node);

    // Act
    Map<CommandNode<Object>, String> actualSmartUsage =
        commandDispatcher.getSmartUsage(node2, ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(requirement).test(isA(Object.class));
    assertEquals(1, actualSmartUsage.size());
  }

  /**
   * Test {@link CommandDispatcher#getSmartUsage(CommandNode, Object)} with {@code node}, {@code
   * source}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#getSmartUsage(CommandNode, Object)}
   */
  @Test
  @DisplayName(
      "Test getSmartUsage(CommandNode, Object) with 'node', 'source'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CommandDispatcher.getSmartUsage(CommandNode, Object)"})
  void testGetSmartUsageWithNodeSource_thenReturnSizeIsOne2() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> node2 = new RootCommandNode<>();
    node2.addChild(node);

    // Act
    Map<CommandNode<Object>, String> actualSmartUsage =
        commandDispatcher.getSmartUsage(node2, ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(requirement).test(isA(Object.class));
    assertEquals(1, actualSmartUsage.size());
  }

  /**
   * Test {@link CommandDispatcher#getSmartUsage(CommandNode, Object)} with {@code node}, {@code
   * source}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#getSmartUsage(CommandNode, Object)}
   */
  @Test
  @DisplayName(
      "Test getSmartUsage(CommandNode, Object) with 'node', 'source'; then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CommandDispatcher.getSmartUsage(CommandNode, Object)"})
  void testGetSmartUsageWithNodeSource_thenReturnSizeIsThree() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "<",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    Predicate<Object> requirement3 = mock(Predicate.class);
    when(requirement3.test(Mockito.<Object>any())).thenReturn(true);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command3 = mock(Command.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    Predicate<Object> requirement5 = mock(Predicate.class);
    when(requirement5.test(Mockito.<Object>any())).thenReturn(true);
    Command<Object> command5 = mock(Command.class);
    ArgumentType<Object> type3 = mock(ArgumentType.class);
    Command<Object> command6 = mock(Command.class);
    Predicate<Object> requirement6 = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> redirect3 =
        new ArgumentCommandNode<>(
            "Name",
            type3,
            command6,
            requirement6,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<Object> node3 =
        new LiteralCommandNode<>(
            "Literal", command5, requirement5, redirect3, mock(RedirectModifier.class), true);
    ArgumentType<Object> type4 = mock(ArgumentType.class);
    Command<Object> command7 = mock(Command.class);
    Predicate<Object> requirement7 = mock(Predicate.class);
    Command<Object> command8 = mock(Command.class);
    Predicate<Object> requirement8 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect4 =
        new LiteralCommandNode<>(
            "Literal",
            command8,
            requirement8,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node4 =
        new ArgumentCommandNode<>(
            "Name",
            type4,
            command7,
            requirement7,
            redirect4,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node3);
    node4.addChild(node2);
    ArgumentType<Object> type5 = mock(ArgumentType.class);
    Command<Object> command9 = mock(Command.class);
    Predicate<Object> requirement9 = mock(Predicate.class);
    Command<Object> command10 = mock(Command.class);
    Predicate<Object> requirement10 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect5 =
        new LiteralCommandNode<>(
            "Literal",
            command10,
            requirement10,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node5 =
        new ArgumentCommandNode<>(
            "Name",
            type5,
            command9,
            requirement9,
            redirect5,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node5);
    ArgumentType<Object> type6 = mock(ArgumentType.class);
    Command<Object> command11 = mock(Command.class);
    Predicate<Object> requirement11 = mock(Predicate.class);
    Command<Object> command12 = mock(Command.class);
    Predicate<Object> requirement12 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect6 =
        new LiteralCommandNode<>(
            "Literal",
            command12,
            requirement12,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node6 =
        new ArgumentCommandNode<>(
            "Name",
            type6,
            command11,
            requirement11,
            redirect6,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node6);
    ArgumentType<Object> type7 = mock(ArgumentType.class);
    Command<Object> command13 = mock(Command.class);
    Predicate<Object> requirement13 = mock(Predicate.class);
    Command<Object> command14 = mock(Command.class);
    Predicate<Object> requirement14 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect7 =
        new LiteralCommandNode<>(
            "Literal",
            command14,
            requirement14,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node7 =
        new ArgumentCommandNode<>(
            "Name",
            type7,
            command13,
            requirement13,
            redirect7,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node7);
    ArgumentType<Object> type8 = mock(ArgumentType.class);
    Command<Object> command15 = mock(Command.class);
    Predicate<Object> requirement15 = mock(Predicate.class);
    Command<Object> command16 = mock(Command.class);
    Predicate<Object> requirement16 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect8 =
        new LiteralCommandNode<>(
            "Literal",
            command16,
            requirement16,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node8 =
        new ArgumentCommandNode<>(
            "Name",
            type8,
            command15,
            requirement15,
            redirect8,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node8);
    ArgumentType<Object> type9 = mock(ArgumentType.class);
    Command<Object> command17 = mock(Command.class);
    Predicate<Object> requirement17 = mock(Predicate.class);
    Command<Object> command18 = mock(Command.class);
    Predicate<Object> requirement18 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect9 =
        new LiteralCommandNode<>(
            "Literal",
            command18,
            requirement18,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node9 =
        new ArgumentCommandNode<>(
            "Name",
            type9,
            command17,
            requirement17,
            redirect9,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node9);
    ArgumentType<Object> type10 = mock(ArgumentType.class);
    Command<Object> command19 = mock(Command.class);
    Predicate<Object> requirement19 = mock(Predicate.class);
    Command<Object> command20 = mock(Command.class);
    Predicate<Object> requirement20 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect10 =
        new LiteralCommandNode<>(
            "Literal",
            command20,
            requirement20,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node10 =
        new ArgumentCommandNode<>(
            "Name",
            type10,
            command19,
            requirement19,
            redirect10,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node10);
    ArgumentType<Object> type11 = mock(ArgumentType.class);
    Command<Object> command21 = mock(Command.class);
    Predicate<Object> requirement21 = mock(Predicate.class);
    Command<Object> command22 = mock(Command.class);
    Predicate<Object> requirement22 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect11 =
        new LiteralCommandNode<>(
            "Literal",
            command22,
            requirement22,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node11 =
        new ArgumentCommandNode<>(
            "Name",
            type11,
            command21,
            requirement21,
            redirect11,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node11);
    ArgumentType<Object> type12 = mock(ArgumentType.class);
    Command<Object> command23 = mock(Command.class);
    Predicate<Object> requirement23 = mock(Predicate.class);
    Command<Object> command24 = mock(Command.class);
    Predicate<Object> requirement24 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect12 =
        new LiteralCommandNode<>(
            "Literal",
            command24,
            requirement24,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node12 =
        new ArgumentCommandNode<>(
            "Name",
            type12,
            command23,
            requirement23,
            redirect12,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node12);
    ArgumentType<Object> type13 = mock(ArgumentType.class);
    Command<Object> command25 = mock(Command.class);
    Predicate<Object> requirement25 = mock(Predicate.class);
    Command<Object> command26 = mock(Command.class);
    Predicate<Object> requirement26 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect13 =
        new LiteralCommandNode<>(
            "Literal",
            command26,
            requirement26,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node13 =
        new ArgumentCommandNode<>(
            "Name",
            type13,
            command25,
            requirement25,
            redirect13,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node13);
    ArgumentType<Object> type14 = mock(ArgumentType.class);
    Command<Object> command27 = mock(Command.class);
    Predicate<Object> requirement27 = mock(Predicate.class);
    Command<Object> command28 = mock(Command.class);
    Predicate<Object> requirement28 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect14 =
        new LiteralCommandNode<>(
            "Literal",
            command28,
            requirement28,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node14 =
        new ArgumentCommandNode<>(
            "Name",
            type14,
            command27,
            requirement27,
            redirect14,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node14);
    ArgumentType<Object> type15 = mock(ArgumentType.class);
    Command<Object> command29 = mock(Command.class);
    Predicate<Object> requirement29 = mock(Predicate.class);
    Command<Object> command30 = mock(Command.class);
    Predicate<Object> requirement30 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect15 =
        new LiteralCommandNode<>(
            "Literal",
            command30,
            requirement30,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node15 =
        new ArgumentCommandNode<>(
            "Name",
            type15,
            command29,
            requirement29,
            redirect15,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node15);
    ArgumentType<Object> type16 = mock(ArgumentType.class);
    Command<Object> command31 = mock(Command.class);
    Predicate<Object> requirement31 = mock(Predicate.class);
    Command<Object> command32 = mock(Command.class);
    Predicate<Object> requirement32 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect16 =
        new LiteralCommandNode<>(
            "Literal",
            command32,
            requirement32,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node16 =
        new ArgumentCommandNode<>(
            "Name",
            type16,
            command31,
            requirement31,
            redirect16,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node16);
    ArgumentType<Object> type17 = mock(ArgumentType.class);
    Command<Object> command33 = mock(Command.class);
    Predicate<Object> requirement33 = mock(Predicate.class);
    Command<Object> command34 = mock(Command.class);
    Predicate<Object> requirement34 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect17 =
        new LiteralCommandNode<>(
            "Literal",
            command34,
            requirement34,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node17 =
        new ArgumentCommandNode<>(
            "Name",
            type17,
            command33,
            requirement33,
            redirect17,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node17);
    ArgumentType<Object> type18 = mock(ArgumentType.class);
    Command<Object> command35 = mock(Command.class);
    Predicate<Object> requirement35 = mock(Predicate.class);
    Command<Object> command36 = mock(Command.class);
    Predicate<Object> requirement36 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect18 =
        new LiteralCommandNode<>(
            "Literal",
            command36,
            requirement36,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node18 =
        new ArgumentCommandNode<>(
            "Name",
            type18,
            command35,
            requirement35,
            redirect18,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node18);
    ArgumentType<Object> type19 = mock(ArgumentType.class);
    Command<Object> command37 = mock(Command.class);
    Predicate<Object> requirement37 = mock(Predicate.class);
    Command<Object> command38 = mock(Command.class);
    Predicate<Object> requirement38 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect19 =
        new LiteralCommandNode<>(
            "Literal",
            command38,
            requirement38,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node19 =
        new ArgumentCommandNode<>(
            "Name",
            type19,
            command37,
            requirement37,
            redirect19,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node19);
    ArgumentType<Object> type20 = mock(ArgumentType.class);
    Command<Object> command39 = mock(Command.class);
    Predicate<Object> requirement39 = mock(Predicate.class);
    Command<Object> command40 = mock(Command.class);
    Predicate<Object> requirement40 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect20 =
        new LiteralCommandNode<>(
            "Literal",
            command40,
            requirement40,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node20 =
        new ArgumentCommandNode<>(
            "Name",
            type20,
            command39,
            requirement39,
            redirect20,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node20);
    ArgumentType<Object> type21 = mock(ArgumentType.class);
    Command<Object> command41 = mock(Command.class);
    Predicate<Object> requirement41 = mock(Predicate.class);
    Command<Object> command42 = mock(Command.class);
    Predicate<Object> requirement42 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect21 =
        new LiteralCommandNode<>(
            "Literal",
            command42,
            requirement42,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node21 =
        new ArgumentCommandNode<>(
            "Name",
            type21,
            command41,
            requirement41,
            redirect21,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node21);
    node4.addChild(node);
    ArgumentType<Object> type22 = mock(ArgumentType.class);
    Command<Object> command43 = mock(Command.class);
    Predicate<Object> requirement43 = mock(Predicate.class);
    Command<Object> command44 = mock(Command.class);
    Predicate<Object> requirement44 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect22 =
        new LiteralCommandNode<>(
            "Literal",
            command44,
            requirement44,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node22 =
        new ArgumentCommandNode<>(
            "Name",
            type22,
            command43,
            requirement43,
            redirect22,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node4.addChild(node22);

    // Act
    Map<CommandNode<Object>, String> actualSmartUsage =
        commandDispatcher.getSmartUsage(node4, ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(requirement5).test(isA(Object.class));
    verify(requirement3).test(isA(Object.class));
    verify(requirement).test(isA(Object.class));
    assertEquals(3, actualSmartUsage.size());
  }

  /**
   * Test {@link CommandDispatcher#getCompletionSuggestions(ParseResults)} with {@code parse}.
   *
   * <p>Method under test: {@link CommandDispatcher#getCompletionSuggestions(ParseResults)}
   */
  @Test
  @DisplayName("Test getCompletionSuggestions(ParseResults) with 'parse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture CommandDispatcher.getCompletionSuggestions(ParseResults)"})
  void testGetCompletionSuggestionsWithParse() throws InterruptedException, ExecutionException {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();
    CommandDispatcher<Object> dispatcher = new CommandDispatcher<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> rootNode =
        new ArgumentCommandNode<>(
            "Can't find node before cursor",
            type,
            command,
            requirement,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    CommandContextBuilder<Object> context =
        new CommandContextBuilder<>(
            dispatcher, ConfigurationTransformation.WILDCARD_OBJECT, rootNode, 1);
    StringReader reader = new StringReader("Can't find node before cursor");

    ParseResults<Object> parse = new ParseResults<>(context, reader, new HashMap<>());

    // Act
    CompletableFuture<Suggestions> actualCompletionSuggestions =
        commandDispatcher.getCompletionSuggestions(parse);

    // Assert
    Suggestions getResult = actualCompletionSuggestions.get();
    StringRange range = getResult.getRange();
    assertEquals(0, range.getEnd());
    assertEquals(0, range.getLength());
    assertEquals(0, range.getStart());
    assertTrue(range.isEmpty());
    assertTrue(getResult.isEmpty());
    assertTrue(getResult.getList().isEmpty());
    assertTrue(actualCompletionSuggestions.isDone());
  }

  /**
   * Test {@link CommandDispatcher#getCompletionSuggestions(ParseResults)} with {@code parse}.
   *
   * <p>Method under test: {@link CommandDispatcher#getCompletionSuggestions(ParseResults)}
   */
  @Test
  @DisplayName("Test getCompletionSuggestions(ParseResults) with 'parse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture CommandDispatcher.getCompletionSuggestions(ParseResults)"})
  void testGetCompletionSuggestionsWithParse2() throws CommandSyntaxException {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    SuggestionProvider<Object> customSuggestions = mock(SuggestionProvider.class);
    when(customSuggestions.getSuggestions(
            Mockito.<CommandContext<Object>>any(), Mockito.<SuggestionsBuilder>any()))
        .thenReturn(new CompletableFuture<>());
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Can't find node before cursor",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            customSuggestions);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> rootNode =
        new ArgumentCommandNode<>(
            "Can't find node before cursor",
            type2,
            command3,
            requirement3,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    rootNode.addChild(node);
    CommandContextBuilder<Object> context =
        new CommandContextBuilder<>(
            new CommandDispatcher<>(), ConfigurationTransformation.WILDCARD_OBJECT, rootNode, 1);
    StringReader reader = new StringReader("Can't find node before cursor");

    ParseResults<Object> parse = new ParseResults<>(context, reader, new HashMap<>());

    // Act
    commandDispatcher.getCompletionSuggestions(parse);

    // Assert
    verify(customSuggestions)
        .getSuggestions(isA(CommandContext.class), isA(SuggestionsBuilder.class));
  }

  /**
   * Test {@link CommandDispatcher#getCompletionSuggestions(ParseResults)} with {@code parse}.
   *
   * <p>Method under test: {@link CommandDispatcher#getCompletionSuggestions(ParseResults)}
   */
  @Test
  @DisplayName("Test getCompletionSuggestions(ParseResults) with 'parse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture CommandDispatcher.getCompletionSuggestions(ParseResults)"})
  void testGetCompletionSuggestionsWithParse3()
      throws CommandSyntaxException, InterruptedException, ExecutionException {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    SuggestionProvider<Object> customSuggestions = mock(SuggestionProvider.class);
    when(customSuggestions.getSuggestions(
            Mockito.<CommandContext<Object>>any(), Mockito.<SuggestionsBuilder>any()))
        .thenThrow(new TagParseCommandSyntaxException("An error occurred"));
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Can't find node before cursor",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            customSuggestions);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> rootNode =
        new ArgumentCommandNode<>(
            "Can't find node before cursor",
            type2,
            command3,
            requirement3,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    rootNode.addChild(node);
    CommandContextBuilder<Object> context =
        new CommandContextBuilder<>(
            new CommandDispatcher<>(), ConfigurationTransformation.WILDCARD_OBJECT, rootNode, 1);
    StringReader reader = new StringReader("Can't find node before cursor");

    ParseResults<Object> parse = new ParseResults<>(context, reader, new HashMap<>());

    // Act
    CompletableFuture<Suggestions> actualCompletionSuggestions =
        commandDispatcher.getCompletionSuggestions(parse);

    // Assert
    verify(customSuggestions)
        .getSuggestions(isA(CommandContext.class), isA(SuggestionsBuilder.class));
    Suggestions getResult = actualCompletionSuggestions.get();
    StringRange range = getResult.getRange();
    assertEquals(0, range.getEnd());
    assertEquals(0, range.getLength());
    assertEquals(0, range.getStart());
    assertTrue(range.isEmpty());
    assertTrue(getResult.isEmpty());
    assertTrue(getResult.getList().isEmpty());
    assertTrue(actualCompletionSuggestions.isDone());
  }

  /**
   * Test {@link CommandDispatcher#getCompletionSuggestions(ParseResults, int)} with {@code parse},
   * {@code cursor}.
   *
   * <p>Method under test: {@link CommandDispatcher#getCompletionSuggestions(ParseResults, int)}
   */
  @Test
  @DisplayName("Test getCompletionSuggestions(ParseResults, int) with 'parse', 'cursor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture CommandDispatcher.getCompletionSuggestions(ParseResults, int)"
  })
  void testGetCompletionSuggestionsWithParseCursor()
      throws InterruptedException, ExecutionException {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();
    CommandDispatcher<Object> dispatcher = new CommandDispatcher<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> rootNode =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    CommandContextBuilder<Object> context =
        new CommandContextBuilder<>(
            dispatcher, ConfigurationTransformation.WILDCARD_OBJECT, rootNode, 1);
    StringReader reader = new StringReader("String");

    ParseResults<Object> parse = new ParseResults<>(context, reader, new HashMap<>());

    // Act
    CompletableFuture<Suggestions> actualCompletionSuggestions =
        commandDispatcher.getCompletionSuggestions(parse, 1);

    // Assert
    Suggestions getResult = actualCompletionSuggestions.get();
    StringRange range = getResult.getRange();
    assertEquals(0, range.getEnd());
    assertEquals(0, range.getLength());
    assertEquals(0, range.getStart());
    assertTrue(range.isEmpty());
    assertTrue(getResult.isEmpty());
    assertTrue(getResult.getList().isEmpty());
    assertTrue(actualCompletionSuggestions.isDone());
  }

  /**
   * Test {@link CommandDispatcher#getCompletionSuggestions(ParseResults, int)} with {@code parse},
   * {@code cursor}.
   *
   * <p>Method under test: {@link CommandDispatcher#getCompletionSuggestions(ParseResults, int)}
   */
  @Test
  @DisplayName("Test getCompletionSuggestions(ParseResults, int) with 'parse', 'cursor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture CommandDispatcher.getCompletionSuggestions(ParseResults, int)"
  })
  void testGetCompletionSuggestionsWithParseCursor2() throws CommandSyntaxException {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    SuggestionProvider<Object> customSuggestions = mock(SuggestionProvider.class);
    when(customSuggestions.getSuggestions(
            Mockito.<CommandContext<Object>>any(), Mockito.<SuggestionsBuilder>any()))
        .thenReturn(new CompletableFuture<>());
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            customSuggestions);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> rootNode =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command3,
            requirement3,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    rootNode.addChild(node);
    CommandContextBuilder<Object> context =
        new CommandContextBuilder<>(
            new CommandDispatcher<>(), ConfigurationTransformation.WILDCARD_OBJECT, rootNode, 1);
    StringReader reader = new StringReader("String");

    ParseResults<Object> parse = new ParseResults<>(context, reader, new HashMap<>());

    // Act
    commandDispatcher.getCompletionSuggestions(parse, 1);

    // Assert
    verify(customSuggestions)
        .getSuggestions(isA(CommandContext.class), isA(SuggestionsBuilder.class));
  }

  /**
   * Test {@link CommandDispatcher#getCompletionSuggestions(ParseResults, int)} with {@code parse},
   * {@code cursor}.
   *
   * <p>Method under test: {@link CommandDispatcher#getCompletionSuggestions(ParseResults, int)}
   */
  @Test
  @DisplayName("Test getCompletionSuggestions(ParseResults, int) with 'parse', 'cursor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture CommandDispatcher.getCompletionSuggestions(ParseResults, int)"
  })
  void testGetCompletionSuggestionsWithParseCursor3()
      throws CommandSyntaxException, InterruptedException, ExecutionException {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    SuggestionProvider<Object> customSuggestions = mock(SuggestionProvider.class);
    when(customSuggestions.getSuggestions(
            Mockito.<CommandContext<Object>>any(), Mockito.<SuggestionsBuilder>any()))
        .thenThrow(new TagParseCommandSyntaxException("An error occurred"));
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            customSuggestions);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> rootNode =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command3,
            requirement3,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    rootNode.addChild(node);
    CommandContextBuilder<Object> context =
        new CommandContextBuilder<>(
            new CommandDispatcher<>(), ConfigurationTransformation.WILDCARD_OBJECT, rootNode, 1);
    StringReader reader = new StringReader("String");

    ParseResults<Object> parse = new ParseResults<>(context, reader, new HashMap<>());

    // Act
    CompletableFuture<Suggestions> actualCompletionSuggestions =
        commandDispatcher.getCompletionSuggestions(parse, 1);

    // Assert
    verify(customSuggestions)
        .getSuggestions(isA(CommandContext.class), isA(SuggestionsBuilder.class));
    Suggestions getResult = actualCompletionSuggestions.get();
    StringRange range = getResult.getRange();
    assertEquals(0, range.getEnd());
    assertEquals(0, range.getLength());
    assertEquals(0, range.getStart());
    assertTrue(range.isEmpty());
    assertTrue(getResult.isEmpty());
    assertTrue(getResult.getList().isEmpty());
    assertTrue(actualCompletionSuggestions.isDone());
  }

  /**
   * Test {@link CommandDispatcher#getCompletionSuggestions(ParseResults)} with {@code parse}.
   *
   * <ul>
   *   <li>Then calls {@link UnaryOperator#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#getCompletionSuggestions(ParseResults)}
   */
  @Test
  @DisplayName("Test getCompletionSuggestions(ParseResults) with 'parse'; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture CommandDispatcher.getCompletionSuggestions(ParseResults)"})
  void testGetCompletionSuggestionsWithParse_thenCallsApply()
      throws InterruptedException, ExecutionException {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    UnaryOperator<Object> mapper = mock(UnaryOperator.class);
    when(mapper.apply(Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    CommandDispatcher<Object> dispatcher = new CommandDispatcher<>();
    CommandContextBuilder<Object> context =
        new CommandContextBuilder<>(
            dispatcher, ConfigurationTransformation.WILDCARD_OBJECT, new RootCommandNode<>(), 0);
    ParseResults<Object> parse = Commands.mapSource(new ParseResults<>(context), mapper);

    // Act
    CompletableFuture<Suggestions> actualCompletionSuggestions =
        commandDispatcher.getCompletionSuggestions(parse);

    // Assert
    verify(mapper).apply(isA(Object.class));
    Suggestions getResult = actualCompletionSuggestions.get();
    StringRange range = getResult.getRange();
    assertEquals(0, range.getEnd());
    assertEquals(0, range.getLength());
    assertEquals(0, range.getStart());
    assertTrue(range.isEmpty());
    assertTrue(getResult.isEmpty());
    assertTrue(getResult.getList().isEmpty());
    assertTrue(actualCompletionSuggestions.isDone());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CommandDispatcher#setConsumer(ResultConsumer)}
   *   <li>{@link CommandDispatcher#getRoot()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RootCommandNode CommandDispatcher.getRoot()",
    "void CommandDispatcher.setConsumer(ResultConsumer)"
  })
  void testGettersAndSetters() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    // Act
    commandDispatcher.setConsumer(mock(ResultConsumer.class));
    RootCommandNode<Object> actualRoot = commandDispatcher.getRoot();

    // Assert
    assertTrue(actualRoot.getExamples() instanceof List);
    assertEquals("", actualRoot.getName());
    assertEquals("", actualRoot.getUsageText());
    assertNull(actualRoot.getCommand());
    assertNull(actualRoot.unwrappedCached);
    assertNull(actualRoot.wrappedCached);
    assertNull(actualRoot.getRedirect());
    assertNull(actualRoot.clientNode);
    assertNull(actualRoot.apiCommandMeta);
    assertFalse(actualRoot.isFork());
    assertTrue(actualRoot.getChildren().isEmpty());
  }

  /**
   * Test {@link CommandDispatcher#getPath(CommandNode)}.
   *
   * <p>Method under test: {@link CommandDispatcher#getPath(CommandNode)}
   */
  @Test
  @DisplayName("Test getPath(CommandNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection CommandDispatcher.getPath(CommandNode)"})
  void testGetPath() {
    // Arrange
    RootCommandNode<Object> root = new RootCommandNode<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    root.addChild(node);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> target =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act
    Collection<String> actualPath = commandDispatcher.getPath(target);

    // Assert
    assertTrue(actualPath instanceof List);
    assertTrue(actualPath.isEmpty());
  }

  /**
   * Test {@link CommandDispatcher#getPath(CommandNode)}.
   *
   * <ul>
   *   <li>Given {@link CommandDispatcher#CommandDispatcher()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#getPath(CommandNode)}
   */
  @Test
  @DisplayName("Test getPath(CommandNode); given CommandDispatcher(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection CommandDispatcher.getPath(CommandNode)"})
  void testGetPath_givenCommandDispatcher_thenReturnList() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> target =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act
    Collection<String> actualPath = commandDispatcher.getPath(target);

    // Assert
    assertTrue(actualPath instanceof List);
    assertTrue(actualPath.isEmpty());
  }

  /**
   * Test {@link CommandDispatcher#findNode(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#findNode(Collection)}
   */
  @Test
  @DisplayName(
      "Test findNode(Collection); given '42'; when ArrayList() add '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommandNode CommandDispatcher.findNode(Collection)"})
  void testFindNode_given42_whenArrayListAdd42_thenReturnNull() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    ArrayList<String> path = new ArrayList<>();
    path.add("42");
    path.add("foo");

    // Act and Assert
    assertNull(commandDispatcher.findNode(path));
  }

  /**
   * Test {@link CommandDispatcher#findNode(Collection)}.
   *
   * <ul>
   *   <li>Given {@link CommandDispatcher#CommandDispatcher()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#findNode(Collection)}
   */
  @Test
  @DisplayName(
      "Test findNode(Collection); given CommandDispatcher(); when ArrayList() add 'foo'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommandNode CommandDispatcher.findNode(Collection)"})
  void testFindNode_givenCommandDispatcher_whenArrayListAddFoo_thenReturnNull() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();

    ArrayList<String> path = new ArrayList<>();
    path.add("foo");

    // Act and Assert
    assertNull(commandDispatcher.findNode(path));
  }

  /**
   * Test {@link CommandDispatcher#findNode(Collection)}.
   *
   * <ul>
   *   <li>Given {@link CommandDispatcher#CommandDispatcher()}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link RootCommandNode}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#findNode(Collection)}
   */
  @Test
  @DisplayName(
      "Test findNode(Collection); given CommandDispatcher(); when ArrayList(); then return RootCommandNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommandNode CommandDispatcher.findNode(Collection)"})
  void testFindNode_givenCommandDispatcher_whenArrayList_thenReturnRootCommandNode() {
    // Arrange
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>();
    ArrayList<String> path = new ArrayList<>();

    // Act
    CommandNode<Object> actualFindNodeResult = commandDispatcher.findNode(path);

    // Assert
    assertTrue(actualFindNodeResult instanceof RootCommandNode);
    assertEquals("", actualFindNodeResult.getName());
    assertEquals("", actualFindNodeResult.getUsageText());
    assertNull(actualFindNodeResult.getCommand());
    assertNull(((RootCommandNode<Object>) actualFindNodeResult).unwrappedCached);
    assertNull(((RootCommandNode<Object>) actualFindNodeResult).wrappedCached);
    assertNull(actualFindNodeResult.getRedirect());
    assertNull(((RootCommandNode<Object>) actualFindNodeResult).clientNode);
    assertNull(((RootCommandNode<Object>) actualFindNodeResult).apiCommandMeta);
    assertFalse(actualFindNodeResult.isFork());
    assertTrue(actualFindNodeResult.getChildren().isEmpty());
    assertEquals(path, actualFindNodeResult.getExamples());
  }

  /**
   * Test {@link CommandDispatcher#findAmbiguities(AmbiguityConsumer)}.
   *
   * <p>Method under test: {@link CommandDispatcher#findAmbiguities(AmbiguityConsumer)}
   */
  @Test
  @DisplayName("Test findAmbiguities(AmbiguityConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandDispatcher.findAmbiguities(AmbiguityConsumer)"})
  void testFindAmbiguities() throws CommandSyntaxException {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    when(type.parse(Mockito.<StringReader>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(type.getExamples()).thenReturn(new ArrayList<>());
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> redirect2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<Object> node2 =
        new LiteralCommandNode<>(
            "Literal", command3, requirement3, redirect2, mock(RedirectModifier.class), true);
    root.addChild(node2);
    root.addChild(node);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    commandDispatcher.findAmbiguities(mock(AmbiguityConsumer.class));

    // Assert
    verify(type).getExamples();
    verify(type).parse(isA(StringReader.class));
  }

  /**
   * Test {@link CommandDispatcher#findAmbiguities(AmbiguityConsumer)}.
   *
   * <p>Method under test: {@link CommandDispatcher#findAmbiguities(AmbiguityConsumer)}
   */
  @Test
  @DisplayName("Test findAmbiguities(AmbiguityConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandDispatcher.findAmbiguities(AmbiguityConsumer)"})
  void testFindAmbiguities2() throws CommandSyntaxException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");

    ArgumentType<Object> type = mock(ArgumentType.class);
    when(type.parse(Mockito.<StringReader>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(type.getExamples()).thenReturn(stringList);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "42",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> redirect2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<Object> node2 =
        new LiteralCommandNode<>(
            "Literal", command3, requirement3, redirect2, mock(RedirectModifier.class), true);
    root.addChild(node2);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    commandDispatcher.findAmbiguities(mock(AmbiguityConsumer.class));

    // Assert
    verify(type).getExamples();
    verify(type).parse(isA(StringReader.class));
  }

  /**
   * Test {@link CommandDispatcher#findAmbiguities(AmbiguityConsumer)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add empty string.
   *   <li>Then calls {@link AmbiguityConsumer#ambiguous(CommandNode, CommandNode, CommandNode,
   *       Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#findAmbiguities(AmbiguityConsumer)}
   */
  @Test
  @DisplayName(
      "Test findAmbiguities(AmbiguityConsumer); given ArrayList() add empty string; then calls ambiguous(CommandNode, CommandNode, CommandNode, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandDispatcher.findAmbiguities(AmbiguityConsumer)"})
  void testFindAmbiguities_givenArrayListAddEmptyString_thenCallsAmbiguous()
      throws CommandSyntaxException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("");

    ArgumentType<Object> type = mock(ArgumentType.class);
    when(type.parse(Mockito.<StringReader>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(type.getExamples()).thenReturn(stringList);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "42",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> redirect2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<Object> node2 =
        new LiteralCommandNode<>(
            "", command3, requirement3, redirect2, mock(RedirectModifier.class), true);
    root.addChild(node2);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    AmbiguityConsumer<Object> consumer = mock(AmbiguityConsumer.class);
    doNothing()
        .when(consumer)
        .ambiguous(
            Mockito.<CommandNode<Object>>any(),
            Mockito.<CommandNode<Object>>any(),
            Mockito.<CommandNode<Object>>any(),
            Mockito.<Collection<String>>any());

    // Act
    commandDispatcher.findAmbiguities(consumer);

    // Assert
    verify(consumer, atLeast(1))
        .ambiguous(
            isA(CommandNode.class),
            Mockito.<CommandNode<Object>>any(),
            Mockito.<CommandNode<Object>>any(),
            isA(Collection.class));
    verify(type).getExamples();
    verify(type).parse(isA(StringReader.class));
  }

  /**
   * Test {@link CommandDispatcher#findAmbiguities(AmbiguityConsumer)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>When {@link AmbiguityConsumer}.
   *   <li>Then calls {@link ArgumentType#parse(StringReader)}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#findAmbiguities(AmbiguityConsumer)}
   */
  @Test
  @DisplayName(
      "Test findAmbiguities(AmbiguityConsumer); given ArrayList() add 'foo'; when AmbiguityConsumer; then calls parse(StringReader)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandDispatcher.findAmbiguities(AmbiguityConsumer)"})
  void testFindAmbiguities_givenArrayListAddFoo_whenAmbiguityConsumer_thenCallsParse()
      throws CommandSyntaxException {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    when(type.parse(Mockito.<StringReader>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(type.getExamples()).thenReturn(new ArrayList<>());
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");

    ArgumentType<Object> type2 = mock(ArgumentType.class);
    when(type2.getExamples()).thenReturn(stringList);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "42",
            type2,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node2);
    root.addChild(node);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    commandDispatcher.findAmbiguities(mock(AmbiguityConsumer.class));

    // Assert
    verify(type2).getExamples();
    verify(type).getExamples();
    verify(type).parse(isA(StringReader.class));
  }

  /**
   * Test {@link CommandDispatcher#findAmbiguities(AmbiguityConsumer)}.
   *
   * <ul>
   *   <li>Then calls {@link ArgumentType#getExamples()}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#findAmbiguities(AmbiguityConsumer)}
   */
  @Test
  @DisplayName("Test findAmbiguities(AmbiguityConsumer); then calls getExamples()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandDispatcher.findAmbiguities(AmbiguityConsumer)"})
  void testFindAmbiguities_thenCallsGetExamples() {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    when(type.getExamples()).thenReturn(new ArrayList<>());
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    ArgumentType<Object> type2 = mock(ArgumentType.class);
    when(type2.getExamples()).thenReturn(new ArrayList<>());
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "42",
            type2,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node2);
    root.addChild(node);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    // Act
    commandDispatcher.findAmbiguities(mock(AmbiguityConsumer.class));

    // Assert
    verify(type2).getExamples();
    verify(type).getExamples();
  }

  /**
   * Test {@link CommandDispatcher#findAmbiguities(AmbiguityConsumer)}.
   *
   * <ul>
   *   <li>When {@link AmbiguityConsumer} {@link AmbiguityConsumer#ambiguous(CommandNode,
   *       CommandNode, CommandNode, Collection)} does nothing.
   *   <li>Then calls {@link AmbiguityConsumer#ambiguous(CommandNode, CommandNode, CommandNode,
   *       Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link CommandDispatcher#findAmbiguities(AmbiguityConsumer)}
   */
  @Test
  @DisplayName(
      "Test findAmbiguities(AmbiguityConsumer); when AmbiguityConsumer ambiguous(CommandNode, CommandNode, CommandNode, Collection) does nothing; then calls ambiguous(CommandNode, CommandNode, CommandNode, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandDispatcher.findAmbiguities(AmbiguityConsumer)"})
  void testFindAmbiguities_whenAmbiguityConsumerAmbiguousDoesNothing_thenCallsAmbiguous()
      throws CommandSyntaxException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");

    ArgumentType<Object> type = mock(ArgumentType.class);
    when(type.parse(Mockito.<StringReader>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(type.getExamples()).thenReturn(stringList);
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    Command<Object> command2 = mock(Command.class);
    Predicate<Object> requirement2 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node =
        new ArgumentCommandNode<>(
            "42",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> root = new RootCommandNode<>();
    root.addChild(node);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    ArgumentCommandNode<Object, Object> redirect2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<Object> node2 =
        new LiteralCommandNode<>(
            "", command3, requirement3, redirect2, mock(RedirectModifier.class), true);
    root.addChild(node2);
    CommandDispatcher<Object> commandDispatcher = new CommandDispatcher<>(root);

    AmbiguityConsumer<Object> consumer = mock(AmbiguityConsumer.class);
    doNothing()
        .when(consumer)
        .ambiguous(
            Mockito.<CommandNode<Object>>any(),
            Mockito.<CommandNode<Object>>any(),
            Mockito.<CommandNode<Object>>any(),
            Mockito.<Collection<String>>any());

    // Act
    commandDispatcher.findAmbiguities(consumer);

    // Assert
    verify(consumer)
        .ambiguous(
            isA(CommandNode.class),
            isA(CommandNode.class),
            isA(CommandNode.class),
            isA(Collection.class));
    verify(type).getExamples();
    verify(type).parse(isA(StringReader.class));
  }
}

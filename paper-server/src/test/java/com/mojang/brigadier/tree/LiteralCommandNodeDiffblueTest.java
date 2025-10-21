package com.mojang.brigadier.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.RedirectModifier;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.context.CommandContextBuilder;
import com.mojang.brigadier.context.ParsedArgument;
import com.mojang.brigadier.context.ParsedCommandNode;
import com.mojang.brigadier.context.StringRange;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class LiteralCommandNodeDiffblueTest {
  /**
   * Test {@link LiteralCommandNode#LiteralCommandNode(String, Command, Predicate, CommandNode,
   * RedirectModifier, boolean)}.
   *
   * <ul>
   *   <li>When {@code Literal}.
   *   <li>Then return {@code Literal}.
   * </ul>
   *
   * <p>Method under test: {@link LiteralCommandNode#LiteralCommandNode(String, Command, Predicate,
   * CommandNode, RedirectModifier, boolean)}
   */
  @Test
  @DisplayName(
      "Test new LiteralCommandNode(String, Command, Predicate, CommandNode, RedirectModifier, boolean); when 'Literal'; then return 'Literal'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LiteralCommandNode.<init>(String, Command, Predicate, CommandNode, RedirectModifier, boolean)"
  })
  void testNewLiteralCommandNode_whenLiteral_thenReturnLiteral() {
    // Arrange
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

    // Act
    LiteralCommandNode<Object> actualLiteralCommandNode =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Assert
    Collection<String> examples = actualLiteralCommandNode.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertEquals("Literal", actualLiteralCommandNode.getLiteral());
    assertEquals("Literal", actualLiteralCommandNode.getName());
    assertEquals("Literal", actualLiteralCommandNode.getSortedKey());
    assertEquals("Literal", actualLiteralCommandNode.getUsageText());
    assertTrue(examples.contains("Literal"));
    assertSame(redirect, actualLiteralCommandNode.getRedirect());
  }

  /**
   * Test {@link LiteralCommandNode#LiteralCommandNode(String, Command, Predicate, CommandNode,
   * RedirectModifier, boolean)}.
   *
   * <ul>
   *   <li>When {@code minecraft:}.
   *   <li>Then return Literal is {@code minecraft:}.
   * </ul>
   *
   * <p>Method under test: {@link LiteralCommandNode#LiteralCommandNode(String, Command, Predicate,
   * CommandNode, RedirectModifier, boolean)}
   */
  @Test
  @DisplayName(
      "Test new LiteralCommandNode(String, Command, Predicate, CommandNode, RedirectModifier, boolean); when 'minecraft:'; then return Literal is 'minecraft:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LiteralCommandNode.<init>(String, Command, Predicate, CommandNode, RedirectModifier, boolean)"
  })
  void testNewLiteralCommandNode_whenMinecraft_thenReturnLiteralIsMinecraft() {
    // Arrange
    Command<Object> command = mock(Command.class);
    Predicate<Object> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
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
            type,
            command2,
            requirement2,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act
    LiteralCommandNode<Object> actualLiteralCommandNode =
        new LiteralCommandNode<>(
            "minecraft:", command, requirement, redirect2, mock(RedirectModifier.class), true);

    // Assert
    Collection<String> examples = actualLiteralCommandNode.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertEquals("minecraft:", actualLiteralCommandNode.getLiteral());
    assertEquals("minecraft:", actualLiteralCommandNode.getName());
    assertEquals("minecraft:", actualLiteralCommandNode.getSortedKey());
    assertEquals("minecraft:", actualLiteralCommandNode.getUsageText());
    assertTrue(examples.contains("minecraft:"));
    assertSame(redirect2, actualLiteralCommandNode.getRedirect());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LiteralCommandNode#toString()}
   *   <li>{@link LiteralCommandNode#getLiteral()}
   *   <li>{@link LiteralCommandNode#getName()}
   *   <li>{@link LiteralCommandNode#getSortedKey()}
   *   <li>{@link LiteralCommandNode#getUsageText()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String LiteralCommandNode.getLiteral()",
    "String LiteralCommandNode.getName()",
    "String LiteralCommandNode.getSortedKey()",
    "String LiteralCommandNode.getUsageText()",
    "String LiteralCommandNode.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Act
    String actualToStringResult = literalCommandNode.toString();
    String actualLiteral = literalCommandNode.getLiteral();
    String actualName = literalCommandNode.getName();
    String actualSortedKey = literalCommandNode.getSortedKey();

    // Assert
    assertEquals("<literal Literal>", actualToStringResult);
    assertEquals("Literal", actualLiteral);
    assertEquals("Literal", actualName);
    assertEquals("Literal", actualSortedKey);
    assertEquals("Literal", literalCommandNode.getUsageText());
  }

  /**
   * Test {@link LiteralCommandNode#parse(StringReader, CommandContextBuilder)} with {@code reader},
   * {@code contextBuilder}.
   *
   * <p>Method under test: {@link LiteralCommandNode#parse(StringReader, CommandContextBuilder)}
   */
  @Test
  @DisplayName("Test parse(StringReader, CommandContextBuilder) with 'reader', 'contextBuilder'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LiteralCommandNode.parse(StringReader, CommandContextBuilder)"})
  void testParseWithReaderContextBuilder() throws CommandSyntaxException {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "%9$U", command, requirement, redirect, mock(RedirectModifier.class), true);
    StringReader reader = new StringReader("%9$U");
    CommandDispatcher<Object> dispatcher = new CommandDispatcher<>();
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

    ArgumentCommandNode<Object, Object> rootNode =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    CommandContextBuilder<Object> contextBuilder =
        new CommandContextBuilder<>(
            dispatcher, ConfigurationTransformation.WILDCARD_OBJECT, rootNode, 1);

    // Act
    literalCommandNode.parse(reader, contextBuilder);

    // Assert
    assertEquals("", reader.getRemaining());
    assertEquals("%9$U", reader.getRead());
    assertEquals(0, reader.getRemainingLength());
    List<ParsedCommandNode<Object>> nodes = contextBuilder.getNodes();
    assertEquals(1, nodes.size());
    assertEquals(4, reader.getCursor());
    StringRange range = contextBuilder.getRange();
    assertEquals(4, range.getEnd());
    assertEquals(4, range.getLength());
    ParsedCommandNode<Object> getResult = nodes.get(0);
    assertEquals(range, getResult.getRange());
    assertSame(literalCommandNode, getResult.getNode());
  }

  /**
   * Test {@link LiteralCommandNode#parse(StringReader, CommandContextBuilder)} with {@code reader},
   * {@code contextBuilder}.
   *
   * <p>Method under test: {@link LiteralCommandNode#parse(StringReader, CommandContextBuilder)}
   */
  @Test
  @DisplayName("Test parse(StringReader, CommandContextBuilder) with 'reader', 'contextBuilder'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LiteralCommandNode.parse(StringReader, CommandContextBuilder)"})
  void testParseWithReaderContextBuilder2() throws CommandSyntaxException {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "minecraft:", command, requirement, redirect, mock(RedirectModifier.class), true);
    StringReader reader = new StringReader("");
    CommandDispatcher<Object> dispatcher = new CommandDispatcher<>();
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

    ArgumentCommandNode<Object, Object> rootNode =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    CommandContextBuilder<Object> contextBuilder =
        new CommandContextBuilder<>(
            dispatcher, ConfigurationTransformation.WILDCARD_OBJECT, rootNode, 1);

    // Act
    literalCommandNode.parse(reader, contextBuilder);

    // Assert
    assertEquals("", reader.getRead());
    assertEquals("", reader.getRemaining());
    assertEquals(0, reader.getCursor());
    assertEquals(0, reader.getRemainingLength());
    StringRange range = contextBuilder.getRange();
    assertEquals(1, range.getEnd());
    assertEquals(1, range.getLength());
    List<ParsedCommandNode<Object>> nodes = contextBuilder.getNodes();
    assertEquals(1, nodes.size());
    assertSame(literalCommandNode, nodes.get(0).getNode());
  }

  /**
   * Test {@link LiteralCommandNode#listSuggestions(CommandContext, SuggestionsBuilder)}.
   *
   * <ul>
   *   <li>Then return {@link CompletableFuture#get()} Range End is zero.
   * </ul>
   *
   * <p>Method under test: {@link LiteralCommandNode#listSuggestions(CommandContext,
   * SuggestionsBuilder)}
   */
  @Test
  @DisplayName(
      "Test listSuggestions(CommandContext, SuggestionsBuilder); then return get() Range End is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture LiteralCommandNode.listSuggestions(CommandContext, SuggestionsBuilder)"
  })
  void testListSuggestions_thenReturnGetRangeEndIsZero()
      throws InterruptedException, ExecutionException {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);
    HashMap<String, ParsedArgument<Object, ?>> arguments = new HashMap<>();
    Command<Object> command3 = mock(Command.class);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<Object> command4 = mock(Command.class);
    Predicate<Object> requirement3 = mock(Predicate.class);
    Command<Object> command5 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command5,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> rootNode =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command4,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    ArrayList<ParsedCommandNode<Object>> nodes = new ArrayList<>();

    CommandContext<Object> context =
        new CommandContext<>(
            ConfigurationTransformation.WILDCARD_OBJECT,
            "Input",
            arguments,
            command3,
            rootNode,
            nodes,
            StringRange.at(1),
            mock(CommandContext.class),
            mock(RedirectModifier.class),
            true);

    // Act
    CompletableFuture<Suggestions> actualListSuggestionsResult =
        literalCommandNode.listSuggestions(context, new SuggestionsBuilder("Input", 1));

    // Assert
    Suggestions getResult = actualListSuggestionsResult.get();
    StringRange range = getResult.getRange();
    assertEquals(0, range.getEnd());
    assertEquals(0, range.getLength());
    assertEquals(0, range.getStart());
    assertTrue(range.isEmpty());
    assertTrue(getResult.isEmpty());
    assertTrue(getResult.getList().isEmpty());
    assertTrue(actualListSuggestionsResult.isDone());
  }

  /**
   * Test {@link LiteralCommandNode#isValidInput(String)}.
   *
   * <p>Method under test: {@link LiteralCommandNode#isValidInput(String)}
   */
  @Test
  @DisplayName("Test isValidInput(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LiteralCommandNode.isValidInput(String)"})
  void testIsValidInput() {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Act and Assert
    assertFalse(literalCommandNode.isValidInput("Input"));
  }

  /**
   * Test {@link LiteralCommandNode#isValidInput(String)}.
   *
   * <p>Method under test: {@link LiteralCommandNode#isValidInput(String)}
   */
  @Test
  @DisplayName("Test isValidInput(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LiteralCommandNode.isValidInput(String)"})
  void testIsValidInput2() {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "42", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Act and Assert
    assertFalse(literalCommandNode.isValidInput("Input"));
  }

  /**
   * Test {@link LiteralCommandNode#isValidInput(String)}.
   *
   * <p>Method under test: {@link LiteralCommandNode#isValidInput(String)}
   */
  @Test
  @DisplayName("Test isValidInput(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LiteralCommandNode.isValidInput(String)"})
  void testIsValidInput3() {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Act and Assert
    assertFalse(literalCommandNode.isValidInput("Input"));
  }

  /**
   * Test {@link LiteralCommandNode#isValidInput(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LiteralCommandNode#isValidInput(String)}
   */
  @Test
  @DisplayName("Test isValidInput(String); when '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LiteralCommandNode.isValidInput(String)"})
  void testIsValidInput_when42_thenReturnTrue() {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "42", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Act and Assert
    assertTrue(literalCommandNode.isValidInput("42"));
  }

  /**
   * Test {@link LiteralCommandNode#equals(Object)}, and {@link LiteralCommandNode#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LiteralCommandNode#equals(Object)}
   *   <li>{@link LiteralCommandNode#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LiteralCommandNode.equals(Object)",
    "int LiteralCommandNode.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Act and Assert
    assertEquals(literalCommandNode, literalCommandNode);
    int expectedHashCodeResult = literalCommandNode.hashCode();
    assertEquals(expectedHashCodeResult, literalCommandNode.hashCode());
  }

  /**
   * Test {@link LiteralCommandNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LiteralCommandNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LiteralCommandNode.equals(Object)",
    "int LiteralCommandNode.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);
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

    // Act and Assert
    assertNotEquals(
        literalCommandNode,
        new LiteralCommandNode<>(
            "Literal", command3, requirement3, redirect2, mock(RedirectModifier.class), true));
  }

  /**
   * Test {@link LiteralCommandNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LiteralCommandNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LiteralCommandNode.equals(Object)",
    "int LiteralCommandNode.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "com.mojang.brigadier.tree.LiteralCommandNode",
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true);
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

    // Act and Assert
    assertNotEquals(
        literalCommandNode,
        new LiteralCommandNode<>(
            "Literal", command3, requirement3, redirect2, mock(RedirectModifier.class), true));
  }

  /**
   * Test {@link LiteralCommandNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LiteralCommandNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LiteralCommandNode.equals(Object)",
    "int LiteralCommandNode.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Act and Assert
    assertNotEquals(literalCommandNode, null);
  }

  /**
   * Test {@link LiteralCommandNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LiteralCommandNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LiteralCommandNode.equals(Object)",
    "int LiteralCommandNode.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Act and Assert
    assertNotEquals(literalCommandNode, "Different type to LiteralCommandNode");
  }

  /**
   * Test {@link LiteralCommandNode#createBuilder()}.
   *
   * <ul>
   *   <li>Then return Command is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LiteralCommandNode#createBuilder()}
   */
  @Test
  @DisplayName("Test createBuilder(); then return Command is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LiteralArgumentBuilder LiteralCommandNode.createBuilder()"})
  void testCreateBuilder_thenReturnCommandIsNull() {
    // Arrange
    Predicate<Object> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
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
            type,
            command,
            requirement2,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "Literal", null, requirement, redirect2, mock(RedirectModifier.class), true);

    // Act
    LiteralArgumentBuilder<Object> actualCreateBuilderResult = literalCommandNode.createBuilder();

    // Assert
    assertNull(actualCreateBuilderResult.getCommand());
    assertSame(redirect2, actualCreateBuilderResult.getRedirect());
  }

  /**
   * Test {@link LiteralCommandNode#createBuilder()}.
   *
   * <ul>
   *   <li>Then return Fork.
   * </ul>
   *
   * <p>Method under test: {@link LiteralCommandNode#createBuilder()}
   */
  @Test
  @DisplayName("Test createBuilder(); then return Fork")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LiteralArgumentBuilder LiteralCommandNode.createBuilder()"})
  void testCreateBuilder_thenReturnFork() {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Act
    LiteralArgumentBuilder<Object> actualCreateBuilderResult = literalCommandNode.createBuilder();

    // Assert
    assertTrue(actualCreateBuilderResult.isFork());
    assertSame(redirect, actualCreateBuilderResult.getRedirect());
  }

  /**
   * Test {@link LiteralCommandNode#createBuilder()}.
   *
   * <ul>
   *   <li>Then return not Fork.
   * </ul>
   *
   * <p>Method under test: {@link LiteralCommandNode#createBuilder()}
   */
  @Test
  @DisplayName("Test createBuilder(); then return not Fork")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LiteralArgumentBuilder LiteralCommandNode.createBuilder()"})
  void testCreateBuilder_thenReturnNotFork() {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), false);

    // Act
    LiteralArgumentBuilder<Object> actualCreateBuilderResult = literalCommandNode.createBuilder();

    // Assert
    assertFalse(actualCreateBuilderResult.isFork());
    assertSame(redirect, actualCreateBuilderResult.getRedirect());
  }

  /**
   * Test {@link LiteralCommandNode#getExamples()}.
   *
   * <p>Method under test: {@link LiteralCommandNode#getExamples()}
   */
  @Test
  @DisplayName("Test getExamples()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LiteralCommandNode.getExamples()"})
  void testGetExamples() {
    // Arrange
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

    LiteralCommandNode<Object> literalCommandNode =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Act
    Collection<String> actualExamples = literalCommandNode.getExamples();

    // Assert
    assertTrue(actualExamples instanceof Set);
    assertEquals(1, actualExamples.size());
    assertTrue(actualExamples.contains("Literal"));
  }
}

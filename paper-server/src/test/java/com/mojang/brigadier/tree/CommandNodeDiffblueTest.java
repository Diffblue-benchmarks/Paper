package com.mojang.brigadier.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.brigadier.AmbiguityConsumer;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.RedirectModifier;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.context.ParsedArgument;
import com.mojang.brigadier.context.ParsedCommandNode;
import com.mojang.brigadier.context.StringRange;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class CommandNodeDiffblueTest {
  /**
   * Test {@link CommandNode#getCommand()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#getCommand()}
   */
  @Test
  @DisplayName("Test getCommand(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command CommandNode.getCommand()"})
  void testGetCommand_thenReturnNull() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();

    // Act and Assert
    assertNull(rootCommandNode.getCommand());
  }

  /**
   * Test {@link CommandNode#getChildren()}.
   *
   * <p>Method under test: {@link CommandNode#getChildren()}
   */
  @Test
  @DisplayName("Test getChildren()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection CommandNode.getChildren()"})
  void testGetChildren() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();

    // Act and Assert
    assertTrue(rootCommandNode.getChildren().isEmpty());
  }

  /**
   * Test {@link CommandNode#getChild(String)}.
   *
   * <p>Method under test: {@link CommandNode#getChild(String)}
   */
  @Test
  @DisplayName("Test getChild(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommandNode CommandNode.getChild(String)"})
  void testGetChild() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();

    // Act and Assert
    assertNull(rootCommandNode.getChild("Name"));
  }

  /**
   * Test {@link CommandNode#getRedirect()}.
   *
   * <p>Method under test: {@link CommandNode#getRedirect()}
   */
  @Test
  @DisplayName("Test getRedirect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommandNode CommandNode.getRedirect()"})
  void testGetRedirect() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();

    // Act and Assert
    assertNull(rootCommandNode.getRedirect());
  }

  /**
   * Test {@link CommandNode#getRedirectModifier()}.
   *
   * <p>Method under test: {@link CommandNode#getRedirectModifier()}
   */
  @Test
  @DisplayName("Test getRedirectModifier()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RedirectModifier CommandNode.getRedirectModifier()"})
  void testGetRedirectModifier() throws CommandSyntaxException {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();

    // Act
    RedirectModifier<Object> actualRedirectModifier = rootCommandNode.getRedirectModifier();
    HashMap<String, ParsedArgument<Object, ?>> arguments = new HashMap<>();
    Command<Object> command = mock(Command.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
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
            type,
            command2,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    ArrayList<ParsedCommandNode<Object>> nodes = new ArrayList<>();
    CommandContext<Object> commandContext =
        new CommandContext<>(
            ConfigurationTransformation.WILDCARD_OBJECT,
            "Input",
            arguments,
            command,
            rootNode,
            nodes,
            StringRange.at(1),
            mock(CommandContext.class),
            mock(RedirectModifier.class),
            true);
    Collection<Object> actualApplyResult = actualRedirectModifier.apply(commandContext);

    // Assert
    Collection<String> examples = rootCommandNode.getExamples();
    assertTrue(examples instanceof List);
    assertTrue(actualApplyResult instanceof Set);
    assertEquals(1, actualApplyResult.size());
    assertTrue(examples.isEmpty());
  }

  /**
   * Test {@link CommandNode#canUse(Object)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#canUse(Object)}
   */
  @Test
  @DisplayName(
      "Test canUse(Object); given Predicate test(Object) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CommandNode.canUse(Object)"})
  void testCanUse_givenPredicateTestReturnFalse_thenReturnFalse() {
    // Arrange
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

    ArgumentCommandNode<Object, Object> argumentCommandNode =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    argumentCommandNode.requirement = predicate;

    // Act
    boolean actualCanUseResult =
        argumentCommandNode.canUse(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(predicate).test(isA(Object.class));
    assertFalse(actualCanUseResult);
  }

  /**
   * Test {@link CommandNode#canUse(Object)}.
   *
   * <ul>
   *   <li>Given {@link RootCommandNode} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#canUse(Object)}
   */
  @Test
  @DisplayName(
      "Test canUse(Object); given RootCommandNode (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CommandNode.canUse(Object)"})
  void testCanUse_givenRootCommandNode_thenReturnTrue() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();

    // Act and Assert
    assertTrue(rootCommandNode.canUse(ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link CommandNode#canUse(Object)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#canUse(Object)}
   */
  @Test
  @DisplayName("Test canUse(Object); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CommandNode.canUse(Object)"})
  void testCanUse_thenThrowUnsupportedOperationException() {
    // Arrange
    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenThrow(new UnsupportedOperationException());
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

    ArgumentCommandNode<Object, Object> argumentCommandNode =
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
    assertThrows(
        UnsupportedOperationException.class,
        () -> argumentCommandNode.canUse(ConfigurationTransformation.WILDCARD_OBJECT));
    verify(requirement).test(isA(Object.class));
  }

  /**
   * Test {@link CommandNode#addChild(CommandNode)}.
   *
   * <p>Method under test: {@link CommandNode#addChild(CommandNode)}
   */
  @Test
  @DisplayName("Test addChild(CommandNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandNode.addChild(CommandNode)"})
  void testAddChild() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
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

    // Act
    rootCommandNode.addChild(node);

    // Assert
    assertEquals(1, rootCommandNode.getChildren().size());
  }

  /**
   * Test {@link CommandNode#addChild(CommandNode)}.
   *
   * <p>Method under test: {@link CommandNode#addChild(CommandNode)}
   */
  @Test
  @DisplayName("Test addChild(CommandNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandNode.addChild(CommandNode)"})
  void testAddChild2() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
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
    rootCommandNode.addChild(node);
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

    // Act
    rootCommandNode.addChild(node2);

    // Assert that nothing has changed
    assertEquals(1, rootCommandNode.getChildren().size());
  }

  /**
   * Test {@link CommandNode#addChild(CommandNode)}.
   *
   * <p>Method under test: {@link CommandNode#addChild(CommandNode)}
   */
  @Test
  @DisplayName("Test addChild(CommandNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandNode.addChild(CommandNode)"})
  void testAddChild3() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
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

    // Act
    rootCommandNode.addChild(node);

    // Assert
    assertEquals(1, rootCommandNode.getChildren().size());
  }

  /**
   * Test {@link CommandNode#addChild(CommandNode)}.
   *
   * <p>Method under test: {@link CommandNode#addChild(CommandNode)}
   */
  @Test
  @DisplayName("Test addChild(CommandNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandNode.addChild(CommandNode)"})
  void testAddChild4() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
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
    rootCommandNode.addChild(node);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Predicate<Object> requirement3 = mock(Predicate.class);
    Command<Object> command3 = mock(Command.class);
    Predicate<Object> requirement4 = mock(Predicate.class);

    LiteralCommandNode<Object> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command3,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<Object, Object> node2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            null,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act
    rootCommandNode.addChild(node2);

    // Assert that nothing has changed
    assertEquals(1, rootCommandNode.getChildren().size());
  }

  /**
   * Test {@link CommandNode#addChild(CommandNode)}.
   *
   * <p>Method under test: {@link CommandNode#addChild(CommandNode)}
   */
  @Test
  @DisplayName("Test addChild(CommandNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandNode.addChild(CommandNode)"})
  void testAddChild5() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
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
    rootCommandNode.addChild(node);
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
    ArgumentType<Object> type3 = mock(ArgumentType.class);
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
            type3,
            command5,
            requirement5,
            redirect3,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node2.addChild(node3);

    // Act
    rootCommandNode.addChild(node2);

    // Assert that nothing has changed
    assertEquals(1, rootCommandNode.getChildren().size());
  }

  /**
   * Test {@link CommandNode#addChild(CommandNode)}.
   *
   * <ul>
   *   <li>When {@link RootCommandNode} (default constructor).
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#addChild(CommandNode)}
   */
  @Test
  @DisplayName(
      "Test addChild(CommandNode); when RootCommandNode (default constructor); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandNode.addChild(CommandNode)"})
  void testAddChild_whenRootCommandNode_thenThrowUnsupportedOperationException() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> rootCommandNode.addChild(new RootCommandNode<>()));
  }

  /**
   * Test {@link CommandNode#findAmbiguities(AmbiguityConsumer)}.
   *
   * <p>Method under test: {@link CommandNode#findAmbiguities(AmbiguityConsumer)}
   */
  @Test
  @DisplayName("Test findAmbiguities(AmbiguityConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandNode.findAmbiguities(AmbiguityConsumer)"})
  void testFindAmbiguities() {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    when(type.getExamples()).thenThrow(new UnsupportedOperationException());
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
            "com.mojang.brigadier.tree.ArgumentCommandNode",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
    rootCommandNode.addChild(node);
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
    rootCommandNode.addChild(node2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> rootCommandNode.findAmbiguities(mock(AmbiguityConsumer.class)));
    verify(type).getExamples();
  }

  /**
   * Test {@link CommandNode#findAmbiguities(AmbiguityConsumer)}.
   *
   * <p>Method under test: {@link CommandNode#findAmbiguities(AmbiguityConsumer)}
   */
  @Test
  @DisplayName("Test findAmbiguities(AmbiguityConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandNode.findAmbiguities(AmbiguityConsumer)"})
  void testFindAmbiguities2() {
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
            "com.mojang.brigadier.tree.ArgumentCommandNode",
            type2,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
    rootCommandNode.addChild(node2);
    rootCommandNode.addChild(node);

    // Act
    rootCommandNode.findAmbiguities(mock(AmbiguityConsumer.class));

    // Assert
    verify(type2).getExamples();
    verify(type).getExamples();
  }

  /**
   * Test {@link CommandNode#findAmbiguities(AmbiguityConsumer)}.
   *
   * <p>Method under test: {@link CommandNode#findAmbiguities(AmbiguityConsumer)}
   */
  @Test
  @DisplayName("Test findAmbiguities(AmbiguityConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandNode.findAmbiguities(AmbiguityConsumer)"})
  void testFindAmbiguities3() throws CommandSyntaxException {
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
            "com.mojang.brigadier.tree.ArgumentCommandNode",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
    rootCommandNode.addChild(node);
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
    rootCommandNode.addChild(node2);

    // Act
    rootCommandNode.findAmbiguities(mock(AmbiguityConsumer.class));

    // Assert
    verify(type).getExamples();
    verify(type).parse(isA(StringReader.class));
  }

  /**
   * Test {@link CommandNode#findAmbiguities(AmbiguityConsumer)}.
   *
   * <p>Method under test: {@link CommandNode#findAmbiguities(AmbiguityConsumer)}
   */
  @Test
  @DisplayName("Test findAmbiguities(AmbiguityConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandNode.findAmbiguities(AmbiguityConsumer)"})
  void testFindAmbiguities4() throws CommandSyntaxException {
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
            "com.mojang.brigadier.tree.ArgumentCommandNode",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
    rootCommandNode.addChild(node);
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
            "42", command3, requirement3, redirect2, mock(RedirectModifier.class), true);
    rootCommandNode.addChild(node2);

    // Act
    rootCommandNode.findAmbiguities(mock(AmbiguityConsumer.class));

    // Assert
    verify(type).getExamples();
    verify(type).parse(isA(StringReader.class));
  }

  /**
   * Test {@link CommandNode#findAmbiguities(AmbiguityConsumer)}.
   *
   * <ul>
   *   <li>Given {@link ArgumentType} {@link ArgumentType#parse(StringReader)} return {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then calls {@link ArgumentType#parse(StringReader)}.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#findAmbiguities(AmbiguityConsumer)}
   */
  @Test
  @DisplayName(
      "Test findAmbiguities(AmbiguityConsumer); given ArgumentType parse(StringReader) return WILDCARD_OBJECT; then calls parse(StringReader)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandNode.findAmbiguities(AmbiguityConsumer)"})
  void testFindAmbiguities_givenArgumentTypeParseReturnWildcard_object_thenCallsParse()
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
            "com.mojang.brigadier.tree.ArgumentCommandNode",
            type2,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
    rootCommandNode.addChild(node2);
    rootCommandNode.addChild(node);

    // Act
    rootCommandNode.findAmbiguities(mock(AmbiguityConsumer.class));

    // Assert
    verify(type2).getExamples();
    verify(type).getExamples();
    verify(type).parse(isA(StringReader.class));
  }

  /**
   * Test {@link CommandNode#findAmbiguities(AmbiguityConsumer)}.
   *
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#findAmbiguities(AmbiguityConsumer)}
   */
  @Test
  @DisplayName("Test findAmbiguities(AmbiguityConsumer); given UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandNode.findAmbiguities(AmbiguityConsumer)"})
  void testFindAmbiguities_givenUnsupportedOperationException() throws CommandSyntaxException {
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
            "com.mojang.brigadier.tree.ArgumentCommandNode",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
    rootCommandNode.addChild(node);
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
    rootCommandNode.addChild(node2);

    AmbiguityConsumer<Object> consumer = mock(AmbiguityConsumer.class);
    doThrow(new UnsupportedOperationException())
        .when(consumer)
        .ambiguous(
            Mockito.<CommandNode<Object>>any(),
            Mockito.<CommandNode<Object>>any(),
            Mockito.<CommandNode<Object>>any(),
            Mockito.<Collection<String>>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> rootCommandNode.findAmbiguities(consumer));
    verify(consumer)
        .ambiguous(
            isA(CommandNode.class),
            isA(CommandNode.class),
            isA(CommandNode.class),
            isA(Collection.class));
    verify(type).getExamples();
    verify(type).parse(isA(StringReader.class));
  }

  /**
   * Test {@link CommandNode#findAmbiguities(AmbiguityConsumer)}.
   *
   * <ul>
   *   <li>When {@link AmbiguityConsumer} {@link AmbiguityConsumer#ambiguous(CommandNode,
   *       CommandNode, CommandNode, Collection)} does nothing.
   *   <li>Then calls {@link AmbiguityConsumer#ambiguous(CommandNode, CommandNode, CommandNode,
   *       Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#findAmbiguities(AmbiguityConsumer)}
   */
  @Test
  @DisplayName(
      "Test findAmbiguities(AmbiguityConsumer); when AmbiguityConsumer ambiguous(CommandNode, CommandNode, CommandNode, Collection) does nothing; then calls ambiguous(CommandNode, CommandNode, CommandNode, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandNode.findAmbiguities(AmbiguityConsumer)"})
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
            "com.mojang.brigadier.tree.ArgumentCommandNode",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
    rootCommandNode.addChild(node);
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
    rootCommandNode.addChild(node2);

    AmbiguityConsumer<Object> consumer = mock(AmbiguityConsumer.class);
    doNothing()
        .when(consumer)
        .ambiguous(
            Mockito.<CommandNode<Object>>any(),
            Mockito.<CommandNode<Object>>any(),
            Mockito.<CommandNode<Object>>any(),
            Mockito.<Collection<String>>any());

    // Act
    rootCommandNode.findAmbiguities(consumer);

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

  /**
   * Test {@link CommandNode#equals(Object)}, and {@link CommandNode#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CommandNode.equals(Object)"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
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

    ArgumentCommandNode<Object, Object> argumentCommandNode =
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
    assertEquals(argumentCommandNode, argumentCommandNode);
    int expectedHashCodeResult = argumentCommandNode.hashCode();
    assertEquals(expectedHashCodeResult, argumentCommandNode.hashCode());
  }

  /**
   * Test {@link CommandNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CommandNode.equals(Object)"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
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

    ArgumentCommandNode<Object, Object> argumentCommandNode =
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

    // Act and Assert
    assertNotEquals(
        argumentCommandNode,
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class)));
  }

  /**
   * Test {@link CommandNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CommandNode.equals(Object)"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
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

    ArgumentCommandNode<Object, Object> argumentCommandNode =
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
    assertNotEquals(argumentCommandNode, null);
  }

  /**
   * Test {@link CommandNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CommandNode.equals(Object)"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
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

    ArgumentCommandNode<Object, Object> argumentCommandNode =
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
    assertNotEquals(argumentCommandNode, "Different type to CommandNode");
  }

  /**
   * Test {@link CommandNode#equals(Object)}, and {@link CommandNode#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CommandNode.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual2() {
    // Arrange
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

    ArgumentCommandNode<Object, Object> argumentCommandNode =
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
    assertEquals(argumentCommandNode, argumentCommandNode);
    int expectedHashCodeResult = argumentCommandNode.hashCode();
    assertEquals(expectedHashCodeResult, argumentCommandNode.hashCode());
  }

  /**
   * Test {@link CommandNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CommandNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
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

    ArgumentCommandNode<Object, Object> argumentCommandNode =
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

    // Act and Assert
    assertNotEquals(
        argumentCommandNode,
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class)));
  }

  /**
   * Test {@link CommandNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CommandNode.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual2() {
    // Arrange
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

    ArgumentCommandNode<Object, Object> argumentCommandNode =
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
    assertNotEquals(argumentCommandNode, null);
  }

  /**
   * Test {@link CommandNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CommandNode.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual2() {
    // Arrange
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

    ArgumentCommandNode<Object, Object> argumentCommandNode =
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
    assertNotEquals(argumentCommandNode, "Different type to CommandNode");
  }

  /**
   * Test {@link CommandNode#getRequirement()}.
   *
   * <ul>
   *   <li>Given {@link RootCommandNode} (default constructor).
   *   <li>Then return test {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#getRequirement()}
   */
  @Test
  @DisplayName(
      "Test getRequirement(); given RootCommandNode (default constructor); then return test WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Predicate CommandNode.getRequirement()"})
  void testGetRequirement_givenRootCommandNode_thenReturnTestWildcard_object() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();

    // Act and Assert
    assertTrue(rootCommandNode.getRequirement().test(ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link CommandNode#getRequirement()}.
   *
   * <ul>
   *   <li>Then return not test {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#getRequirement()}
   */
  @Test
  @DisplayName("Test getRequirement(); then return not test WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Predicate CommandNode.getRequirement()"})
  void testGetRequirement_thenReturnNotTestWildcard_object() {
    // Arrange
    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(false);
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

    ArgumentCommandNode<Object, Object> argumentCommandNode =
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
    boolean actualTestResult =
        argumentCommandNode.getRequirement().test(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(requirement).test(isA(Object.class));
    assertFalse(actualTestResult);
  }

  /**
   * Test {@link CommandNode#getRelevantNodes(StringReader, Object)} with {@code input}, {@code
   * source}.
   *
   * <ul>
   *   <li>Given {@link RootCommandNode} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#getRelevantNodes(StringReader, Object)}
   */
  @Test
  @DisplayName(
      "Test getRelevantNodes(StringReader, Object) with 'input', 'source'; given RootCommandNode (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection CommandNode.getRelevantNodes(StringReader, Object)"})
  void testGetRelevantNodesWithInputSource_givenRootCommandNode_thenReturnEmpty() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();

    // Act and Assert
    assertTrue(
        rootCommandNode
            .getRelevantNodes(
                new StringReader("String"), ConfigurationTransformation.WILDCARD_OBJECT)
            .isEmpty());
  }

  /**
   * Test {@link CommandNode#getRelevantNodes(StringReader, Object)} with {@code input}, {@code
   * source}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code String}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#getRelevantNodes(StringReader, Object)}
   */
  @Test
  @DisplayName(
      "Test getRelevantNodes(StringReader, Object) with 'input', 'source'; when StringReader(String) with 'String'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection CommandNode.getRelevantNodes(StringReader, Object)"})
  void testGetRelevantNodesWithInputSource_whenStringReaderWithString_thenReturnEmpty() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
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
    rootCommandNode.addChild(node);

    // Act and Assert
    assertTrue(
        rootCommandNode
            .getRelevantNodes(
                new StringReader("String"), ConfigurationTransformation.WILDCARD_OBJECT)
            .isEmpty());
  }

  /**
   * Test {@link CommandNode#getRelevantNodes(StringReader)} with {@code input}.
   *
   * <ul>
   *   <li>Given {@link RootCommandNode} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#getRelevantNodes(StringReader)}
   */
  @Test
  @DisplayName(
      "Test getRelevantNodes(StringReader) with 'input'; given RootCommandNode (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection CommandNode.getRelevantNodes(StringReader)"})
  void testGetRelevantNodesWithInput_givenRootCommandNode_thenReturnEmpty() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();

    // Act and Assert
    assertTrue(rootCommandNode.getRelevantNodes(new StringReader("String")).isEmpty());
  }

  /**
   * Test {@link CommandNode#getRelevantNodes(StringReader)} with {@code input}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code String}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#getRelevantNodes(StringReader)}
   */
  @Test
  @DisplayName(
      "Test getRelevantNodes(StringReader) with 'input'; when StringReader(String) with 'String'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection CommandNode.getRelevantNodes(StringReader)"})
  void testGetRelevantNodesWithInput_whenStringReaderWithString_thenReturnEmpty() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
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
    rootCommandNode.addChild(node);

    // Act and Assert
    assertTrue(rootCommandNode.getRelevantNodes(new StringReader("String")).isEmpty());
  }

  /**
   * Test {@link CommandNode#compareTo(CommandNode)} with {@code o}.
   *
   * <ul>
   *   <li>Then return minus four.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#compareTo(CommandNode)}
   */
  @Test
  @DisplayName("Test compareTo(CommandNode) with 'o'; then return minus four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CommandNode.compareTo(CommandNode)"})
  void testCompareToWithO_thenReturnMinusFour() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
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

    ArgumentCommandNode<Object, Object> o =
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
    int actualCompareToResult = rootCommandNode.compareTo(o);

    // Assert
    assertEquals(-4, actualCompareToResult);
  }

  /**
   * Test {@link CommandNode#compareTo(CommandNode)} with {@code o}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#compareTo(CommandNode)}
   */
  @Test
  @DisplayName("Test compareTo(CommandNode) with 'o'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CommandNode.compareTo(CommandNode)"})
  void testCompareToWithO_thenReturnOne() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();
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

    LiteralCommandNode<Object> o =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Act
    int actualCompareToResult = rootCommandNode.compareTo(o);

    // Assert
    assertEquals(1, actualCompareToResult);
  }

  /**
   * Test {@link CommandNode#isFork()}.
   *
   * <ul>
   *   <li>Given {@link RootCommandNode} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#isFork()}
   */
  @Test
  @DisplayName("Test isFork(); given RootCommandNode (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CommandNode.isFork()"})
  void testIsFork_givenRootCommandNode_thenReturnFalse() {
    // Arrange
    RootCommandNode<Object> rootCommandNode = new RootCommandNode<>();

    // Act and Assert
    assertFalse(rootCommandNode.isFork());
  }

  /**
   * Test {@link CommandNode#isFork()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CommandNode#isFork()}
   */
  @Test
  @DisplayName("Test isFork(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CommandNode.isFork()"})
  void testIsFork_thenReturnTrue() {
    // Arrange
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

    ArgumentCommandNode<Object, Object> argumentCommandNode =
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
    assertTrue(argumentCommandNode.isFork());
  }
}

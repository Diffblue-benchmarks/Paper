package com.mojang.brigadier.builder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.RedirectModifier;
import com.mojang.brigadier.SingleRedirectModifier;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.tree.ArgumentCommandNode;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class ArgumentBuilderDiffblueTest {
  /**
   * Test {@link ArgumentBuilder#defaultRequirement()}.
   *
   * <p>Method under test: {@link ArgumentBuilder#defaultRequirement()}
   */
  @Test
  @DisplayName("Test defaultRequirement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Predicate ArgumentBuilder.defaultRequirement()"})
  void testDefaultRequirement() {
    // Arrange and Act
    Predicate<Object> actualDefaultRequirementResult = ArgumentBuilder.defaultRequirement();

    // Assert
    assertTrue(actualDefaultRequirementResult.test(ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link ArgumentBuilder#then(ArgumentBuilder)} with {@code ArgumentBuilder}.
   *
   * <ul>
   *   <li>When argument {@code minecraft:} and {@link ArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link ArgumentBuilder#then(ArgumentBuilder)}
   */
  @Test
  @DisplayName(
      "Test then(ArgumentBuilder) with 'ArgumentBuilder'; when argument 'minecraft:' and ArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentBuilder ArgumentBuilder.then(ArgumentBuilder)"})
  void testThenWithArgumentBuilder_whenArgumentMinecraftAndArgumentType() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");
    RequiredArgumentBuilder<Object, Object> argument =
        RequiredArgumentBuilder.argument("minecraft:", mock(ArgumentType.class));

    // Act
    LiteralArgumentBuilder<Object> actualThenResult = literalResult.then(argument);

    // Assert
    assertSame(literalResult, actualThenResult);
  }

  /**
   * Test {@link ArgumentBuilder#then(ArgumentBuilder)} with {@code ArgumentBuilder}.
   *
   * <ul>
   *   <li>When literal {@code Name}.
   *   <li>Then return literal {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ArgumentBuilder#then(ArgumentBuilder)}
   */
  @Test
  @DisplayName(
      "Test then(ArgumentBuilder) with 'ArgumentBuilder'; when literal 'Name'; then return literal 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentBuilder ArgumentBuilder.then(ArgumentBuilder)"})
  void testThenWithArgumentBuilder_whenLiteralName_thenReturnLiteralName() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");
    LiteralArgumentBuilder<Object> argument = LiteralArgumentBuilder.literal("Name");

    // Act
    LiteralArgumentBuilder<Object> actualThenResult = literalResult.then(argument);

    // Assert
    assertSame(literalResult, actualThenResult);
  }

  /**
   * Test {@link ArgumentBuilder#then(CommandNode)} with {@code CommandNode}.
   *
   * <p>Method under test: {@link ArgumentBuilder#then(CommandNode)}
   */
  @Test
  @DisplayName("Test then(CommandNode) with 'CommandNode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentBuilder ArgumentBuilder.then(CommandNode)"})
  void testThenWithCommandNode() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");
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

    ArgumentCommandNode<Object, Object> argument =
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
    LiteralArgumentBuilder<Object> actualThenResult = literalResult.then(argument);

    // Assert
    assertSame(literalResult, actualThenResult);
  }

  /**
   * Test {@link ArgumentBuilder#then(CommandNode)} with {@code CommandNode}.
   *
   * <p>Method under test: {@link ArgumentBuilder#then(CommandNode)}
   */
  @Test
  @DisplayName("Test then(CommandNode) with 'CommandNode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentBuilder ArgumentBuilder.then(CommandNode)"})
  void testThenWithCommandNode2() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");
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

    LiteralCommandNode<Object> argument =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Act
    LiteralArgumentBuilder<Object> actualThenResult = literalResult.then(argument);

    // Assert
    assertSame(literalResult, actualThenResult);
  }

  /**
   * Test {@link ArgumentBuilder#getArguments()}.
   *
   * <p>Method under test: {@link ArgumentBuilder#getArguments()}
   */
  @Test
  @DisplayName("Test getArguments()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection ArgumentBuilder.getArguments()"})
  void testGetArguments() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");

    // Act and Assert
    assertTrue(literalResult.getArguments().isEmpty());
  }

  /**
   * Test {@link ArgumentBuilder#executes(Command)}.
   *
   * <p>Method under test: {@link ArgumentBuilder#executes(Command)}
   */
  @Test
  @DisplayName("Test executes(Command)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentBuilder ArgumentBuilder.executes(Command)"})
  void testExecutes() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");
    Command<Object> command = mock(Command.class);

    // Act
    LiteralArgumentBuilder<Object> actualExecutesResult = literalResult.executes(command);

    // Assert
    assertSame(literalResult, actualExecutesResult);
    assertSame(command, literalResult.getCommand());
  }

  /**
   * Test {@link ArgumentBuilder#getCommand()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ArgumentBuilder#getCommand()}
   */
  @Test
  @DisplayName("Test getCommand(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command ArgumentBuilder.getCommand()"})
  void testGetCommand_thenReturnNull() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");

    // Act and Assert
    assertNull(literalResult.getCommand());
  }

  /**
   * Test {@link ArgumentBuilder#requires(Predicate)}.
   *
   * <p>Method under test: {@link ArgumentBuilder#requires(Predicate)}
   */
  @Test
  @DisplayName("Test requires(Predicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentBuilder ArgumentBuilder.requires(Predicate)"})
  void testRequires() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");
    Predicate<Object> requirement = mock(Predicate.class);

    // Act
    LiteralArgumentBuilder<Object> actualRequiresResult = literalResult.requires(requirement);

    // Assert
    assertSame(literalResult, actualRequiresResult);
    assertSame(requirement, literalResult.getRequirement());
  }

  /**
   * Test {@link ArgumentBuilder#getRequirement()}.
   *
   * <ul>
   *   <li>Given literal {@code Name}.
   *   <li>Then return test {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link ArgumentBuilder#getRequirement()}
   */
  @Test
  @DisplayName("Test getRequirement(); given literal 'Name'; then return test WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Predicate ArgumentBuilder.getRequirement()"})
  void testGetRequirement_givenLiteralName_thenReturnTestWildcard_object() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");

    // Act and Assert
    assertTrue(literalResult.getRequirement().test(ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link ArgumentBuilder#getRequirement()}.
   *
   * <ul>
   *   <li>Then return not test {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link ArgumentBuilder#getRequirement()}
   */
  @Test
  @DisplayName("Test getRequirement(); then return not test WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Predicate ArgumentBuilder.getRequirement()"})
  void testGetRequirement_thenReturnNotTestWildcard_object() {
    // Arrange
    Predicate<Object> requirement = mock(Predicate.class);
    when(requirement.test(Mockito.<Object>any())).thenReturn(false);

    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");
    literalResult.requires(requirement);

    // Act
    boolean actualTestResult =
        literalResult.getRequirement().test(ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(requirement).test(isA(Object.class));
    assertFalse(actualTestResult);
  }

  /**
   * Test {@link ArgumentBuilder#redirect(CommandNode)} with {@code target}.
   *
   * <p>Method under test: {@link ArgumentBuilder#redirect(CommandNode)}
   */
  @Test
  @DisplayName("Test redirect(CommandNode) with 'target'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentBuilder ArgumentBuilder.redirect(CommandNode)"})
  void testRedirectWithTarget() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");
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
    LiteralArgumentBuilder<Object> actualRedirectResult = literalResult.redirect(target);

    // Assert
    assertSame(target, literalResult.getRedirect());
    assertSame(literalResult, actualRedirectResult);
  }

  /**
   * Test {@link ArgumentBuilder#redirect(CommandNode, SingleRedirectModifier)} with {@code target},
   * {@code modifier}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ArgumentBuilder#redirect(CommandNode, SingleRedirectModifier)}
   */
  @Test
  @DisplayName(
      "Test redirect(CommandNode, SingleRedirectModifier) with 'target', 'modifier'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ArgumentBuilder ArgumentBuilder.redirect(CommandNode, SingleRedirectModifier)"
  })
  void testRedirectWithTargetModifier_whenNull() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");
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
    LiteralArgumentBuilder<Object> actualRedirectResult = literalResult.redirect(target, null);

    // Assert
    assertSame(target, literalResult.getRedirect());
    assertSame(literalResult, actualRedirectResult);
  }

  /**
   * Test {@link ArgumentBuilder#redirect(CommandNode, SingleRedirectModifier)} with {@code target},
   * {@code modifier}.
   *
   * <ul>
   *   <li>When {@link SingleRedirectModifier}.
   * </ul>
   *
   * <p>Method under test: {@link ArgumentBuilder#redirect(CommandNode, SingleRedirectModifier)}
   */
  @Test
  @DisplayName(
      "Test redirect(CommandNode, SingleRedirectModifier) with 'target', 'modifier'; when SingleRedirectModifier")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ArgumentBuilder ArgumentBuilder.redirect(CommandNode, SingleRedirectModifier)"
  })
  void testRedirectWithTargetModifier_whenSingleRedirectModifier() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");
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
    LiteralArgumentBuilder<Object> actualRedirectResult =
        literalResult.redirect(target, mock(SingleRedirectModifier.class));

    // Assert
    assertSame(target, literalResult.getRedirect());
    assertSame(literalResult, actualRedirectResult);
  }

  /**
   * Test {@link ArgumentBuilder#fork(CommandNode, RedirectModifier)}.
   *
   * <p>Method under test: {@link ArgumentBuilder#fork(CommandNode, RedirectModifier)}
   */
  @Test
  @DisplayName("Test fork(CommandNode, RedirectModifier)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentBuilder ArgumentBuilder.fork(CommandNode, RedirectModifier)"})
  void testFork() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");
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
    RedirectModifier<Object> modifier = mock(RedirectModifier.class);

    // Act
    LiteralArgumentBuilder<Object> actualForkResult = literalResult.fork(target, modifier);

    // Assert
    assertTrue(literalResult.isFork());
    assertSame(target, literalResult.getRedirect());
    assertSame(literalResult, actualForkResult);
    assertSame(modifier, literalResult.getRedirectModifier());
  }

  /**
   * Test {@link ArgumentBuilder#forward(CommandNode, RedirectModifier, boolean)}.
   *
   * <p>Method under test: {@link ArgumentBuilder#forward(CommandNode, RedirectModifier, boolean)}
   */
  @Test
  @DisplayName("Test forward(CommandNode, RedirectModifier, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ArgumentBuilder ArgumentBuilder.forward(CommandNode, RedirectModifier, boolean)"
  })
  void testForward() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");
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
    RedirectModifier<Object> modifier = mock(RedirectModifier.class);

    // Act
    LiteralArgumentBuilder<Object> actualForwardResult =
        literalResult.forward(target, modifier, true);

    // Assert
    assertTrue(literalResult.isFork());
    assertSame(target, literalResult.getRedirect());
    assertSame(literalResult, actualForwardResult);
    assertSame(modifier, literalResult.getRedirectModifier());
  }

  /**
   * Test {@link ArgumentBuilder#getRedirect()}.
   *
   * <p>Method under test: {@link ArgumentBuilder#getRedirect()}
   */
  @Test
  @DisplayName("Test getRedirect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommandNode ArgumentBuilder.getRedirect()"})
  void testGetRedirect() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");

    // Act and Assert
    assertNull(literalResult.getRedirect());
  }

  /**
   * Test {@link ArgumentBuilder#getRedirectModifier()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ArgumentBuilder#getRedirectModifier()}
   */
  @Test
  @DisplayName("Test getRedirectModifier(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RedirectModifier ArgumentBuilder.getRedirectModifier()"})
  void testGetRedirectModifier_thenReturnNull() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");

    // Act and Assert
    assertNull(literalResult.getRedirectModifier());
  }

  /**
   * Test {@link ArgumentBuilder#isFork()}.
   *
   * <p>Method under test: {@link ArgumentBuilder#isFork()}
   */
  @Test
  @DisplayName("Test isFork()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ArgumentBuilder.isFork()"})
  void testIsFork() {
    // Arrange
    LiteralArgumentBuilder<Object> literalResult = LiteralArgumentBuilder.literal("Name");

    // Act and Assert
    assertFalse(literalResult.isFork());
  }
}

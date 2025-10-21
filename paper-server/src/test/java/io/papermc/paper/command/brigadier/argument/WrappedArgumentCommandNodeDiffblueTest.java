package io.papermc.paper.command.brigadier.argument;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.RedirectModifier;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.tree.ArgumentCommandNode;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WrappedArgumentCommandNodeDiffblueTest {
  /**
   * Test {@link WrappedArgumentCommandNode#WrappedArgumentCommandNode(String, ArgumentType,
   * ArgumentType, Command, Predicate, CommandNode, RedirectModifier, boolean, SuggestionProvider)}.
   *
   * <p>Method under test: {@link WrappedArgumentCommandNode#WrappedArgumentCommandNode(String,
   * ArgumentType, ArgumentType, Command, Predicate, CommandNode, RedirectModifier, boolean,
   * SuggestionProvider)}
   */
  @Test
  @DisplayName(
      "Test new WrappedArgumentCommandNode(String, ArgumentType, ArgumentType, Command, Predicate, CommandNode, RedirectModifier, boolean, SuggestionProvider)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WrappedArgumentCommandNode.<init>(String, ArgumentType, ArgumentType, Command, Predicate, CommandNode, RedirectModifier, boolean, SuggestionProvider)"
  })
  void testNewWrappedArgumentCommandNode() {
    // Arrange
    ArgumentType<Object> pureArgumentType = mock(ArgumentType.class);
    ArgumentType<Object> nmsNativeType = mock(ArgumentType.class);
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);
    Command<CommandSourceStack> command3 = mock(Command.class);
    Predicate<CommandSourceStack> requirement3 = mock(Predicate.class);

    LiteralCommandNode<CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command3,
            requirement3,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<CommandSourceStack, Object> redirect2 =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new WrappedArgumentCommandNode<>(
                "Name",
                pureArgumentType,
                nmsNativeType,
                command,
                requirement,
                redirect2,
                mock(RedirectModifier.class),
                true,
                mock(SuggestionProvider.class)));
  }
}

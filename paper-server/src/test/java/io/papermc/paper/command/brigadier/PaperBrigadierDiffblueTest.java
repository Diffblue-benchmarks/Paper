package io.papermc.paper.command.brigadier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import net.minecraft.commands.CommandSourceStack;
import org.bukkit.craftbukkit.command.VanillaCommandWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperBrigadierDiffblueTest {
  /**
   * Test {@link PaperBrigadier#wrapNode(CommandNode)}.
   *
   * <ul>
   *   <li>Then return {@link VanillaCommandWrapper#vanillaCommand} Examples size is one.
   * </ul>
   *
   * <p>Method under test: {@link PaperBrigadier#wrapNode(CommandNode)}
   */
  @Test
  @DisplayName("Test wrapNode(CommandNode); then return vanillaCommand Examples size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.command.Command PaperBrigadier.wrapNode(CommandNode)"})
  void testWrapNode_thenReturnVanillaCommandExamplesSizeIsOne() {
    // Arrange
    LiteralCommandNode node =
        new LiteralCommandNode(
            "minecraft:",
            mock(Command.class),
            mock(Predicate.class),
            null,
            mock(RedirectModifier.class),
            true);

    // Act
    org.bukkit.command.Command actualWrapNodeResult = PaperBrigadier.wrapNode(node);

    // Assert
    CommandNode<CommandSourceStack> commandNode =
        ((VanillaCommandWrapper) actualWrapNodeResult).vanillaCommand;
    assertTrue(commandNode instanceof LiteralCommandNode);
    Collection<String> examples = commandNode.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertTrue(actualWrapNodeResult instanceof VanillaCommandWrapper);
    assertEquals("minecraft:", commandNode.getName());
    assertEquals("minecraft:", commandNode.getUsageText());
    assertEquals("minecraft:", ((LiteralCommandNode<CommandSourceStack>) commandNode).getLiteral());
    assertEquals("minecraft:", actualWrapNodeResult.getLabel());
    assertEquals("minecraft:", actualWrapNodeResult.getName());
    assertEquals("minecraft:", actualWrapNodeResult.getTimingName());
    assertEquals("minecraft:", actualWrapNodeResult.getUsage());
    assertNull(commandNode.getRedirect());
    assertTrue(examples.contains("minecraft:"));
  }

  /**
   * Test {@link PaperBrigadier#wrapNode(CommandNode)}.
   *
   * <ul>
   *   <li>Then {@link VanillaCommandWrapper#vanillaCommand} Redirect return {@link
   *       RootCommandNode}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBrigadier#wrapNode(CommandNode)}
   */
  @Test
  @DisplayName("Test wrapNode(CommandNode); then vanillaCommand Redirect return RootCommandNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.command.Command PaperBrigadier.wrapNode(CommandNode)"})
  void testWrapNode_thenVanillaCommandRedirectReturnRootCommandNode() {
    // Arrange
    Command command = mock(Command.class);
    Predicate requirement = mock(Predicate.class);
    RootCommandNode redirect = new RootCommandNode();

    LiteralCommandNode node =
        new LiteralCommandNode(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Act
    org.bukkit.command.Command actualWrapNodeResult = PaperBrigadier.wrapNode(node);

    // Assert
    CommandNode<CommandSourceStack> commandNode =
        ((VanillaCommandWrapper) actualWrapNodeResult).vanillaCommand;
    assertTrue(commandNode instanceof LiteralCommandNode);
    CommandNode<CommandSourceStack> redirect2 = commandNode.getRedirect();
    assertTrue(redirect2 instanceof RootCommandNode);
    assertTrue(actualWrapNodeResult instanceof VanillaCommandWrapper);
    assertEquals("Literal", commandNode.getName());
    assertEquals("Literal", commandNode.getUsageText());
    assertEquals("Literal", ((LiteralCommandNode<CommandSourceStack>) commandNode).getLiteral());
    assertEquals("Literal", actualWrapNodeResult.getLabel());
    assertEquals("Literal", actualWrapNodeResult.getName());
    assertEquals("Literal", actualWrapNodeResult.getTimingName());
    assertEquals("Literal", actualWrapNodeResult.getUsage());
    assertSame(redirect, redirect2);
  }

  /**
   * Test {@link PaperBrigadier#wrapNode(CommandNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBrigadier#wrapNode(CommandNode)}
   */
  @Test
  @DisplayName("Test wrapNode(CommandNode); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.command.Command PaperBrigadier.wrapNode(CommandNode)"})
  void testWrapNode_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PaperBrigadier.wrapNode(null));
  }

  /**
   * Test {@link PaperBrigadier#wrapNode(CommandNode)}.
   *
   * <ul>
   *   <li>When {@link RootCommandNode} (default constructor).
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBrigadier#wrapNode(CommandNode)}
   */
  @Test
  @DisplayName(
      "Test wrapNode(CommandNode); when RootCommandNode (default constructor); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.command.Command PaperBrigadier.wrapNode(CommandNode)"})
  void testWrapNode_whenRootCommandNode_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> PaperBrigadier.wrapNode(new RootCommandNode()));
  }

  /**
   * Test {@link PaperBrigadier#copyLiteral(String, LiteralCommandNode)}.
   *
   * <p>Method under test: {@link PaperBrigadier#copyLiteral(String, LiteralCommandNode)}
   */
  @Test
  @DisplayName("Test copyLiteral(String, LiteralCommandNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LiteralCommandNode PaperBrigadier.copyLiteral(String, LiteralCommandNode)"})
  void testCopyLiteral() {
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

    LiteralCommandNode<Object> source =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Act
    LiteralCommandNode<Object> actualCopyLiteralResult =
        PaperBrigadier.copyLiteral("New Literal", source);

    // Assert
    assertSame(redirect, actualCopyLiteralResult.getRedirect());
  }

  /**
   * Test {@link PaperBrigadier#copyLiteral(String, LiteralCommandNode)}.
   *
   * <p>Method under test: {@link PaperBrigadier#copyLiteral(String, LiteralCommandNode)}
   */
  @Test
  @DisplayName("Test copyLiteral(String, LiteralCommandNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LiteralCommandNode PaperBrigadier.copyLiteral(String, LiteralCommandNode)"})
  void testCopyLiteral2() {
    // Arrange
    LiteralCommandNode<Object> source =
        new LiteralCommandNode<>(
            "Literal",
            mock(Command.class),
            mock(Predicate.class),
            null,
            mock(RedirectModifier.class),
            true);
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
    source.addChild(node);

    // Act
    LiteralCommandNode<Object> actualCopyLiteralResult =
        PaperBrigadier.copyLiteral("New Literal", source);

    // Assert
    Collection<String> examples = actualCopyLiteralResult.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertEquals("New Literal", actualCopyLiteralResult.getLiteral());
    assertEquals("New Literal", actualCopyLiteralResult.getName());
    assertEquals("New Literal", actualCopyLiteralResult.getUsageText());
    assertNull(actualCopyLiteralResult.unwrappedCached);
    assertNull(actualCopyLiteralResult.wrappedCached);
    assertNull(actualCopyLiteralResult.getRedirect());
    assertNull(actualCopyLiteralResult.clientNode);
    assertNull(actualCopyLiteralResult.apiCommandMeta);
    assertEquals(1, actualCopyLiteralResult.getChildren().size());
    assertTrue(actualCopyLiteralResult.isFork());
    assertTrue(examples.contains("New Literal"));
  }

  /**
   * Test {@link PaperBrigadier#copyLiteral(String, LiteralCommandNode)}.
   *
   * <p>Method under test: {@link PaperBrigadier#copyLiteral(String, LiteralCommandNode)}
   */
  @Test
  @DisplayName("Test copyLiteral(String, LiteralCommandNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LiteralCommandNode PaperBrigadier.copyLiteral(String, LiteralCommandNode)"})
  void testCopyLiteral3() {
    // Arrange
    LiteralCommandNode<Object> source =
        new LiteralCommandNode<>(
            "Literal",
            mock(Command.class),
            mock(Predicate.class),
            null,
            mock(RedirectModifier.class),
            true);
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
    source.addChild(node);

    // Act
    LiteralCommandNode<Object> actualCopyLiteralResult =
        PaperBrigadier.copyLiteral("New Literal", source);

    // Assert
    Collection<String> examples = actualCopyLiteralResult.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertEquals("New Literal", actualCopyLiteralResult.getLiteral());
    assertEquals("New Literal", actualCopyLiteralResult.getName());
    assertEquals("New Literal", actualCopyLiteralResult.getUsageText());
    assertNull(actualCopyLiteralResult.unwrappedCached);
    assertNull(actualCopyLiteralResult.wrappedCached);
    assertNull(actualCopyLiteralResult.getRedirect());
    assertNull(actualCopyLiteralResult.clientNode);
    assertNull(actualCopyLiteralResult.apiCommandMeta);
    assertEquals(1, actualCopyLiteralResult.getChildren().size());
    assertTrue(actualCopyLiteralResult.isFork());
    assertTrue(examples.contains("New Literal"));
  }

  /**
   * Test {@link PaperBrigadier#copyLiteral(String, LiteralCommandNode)}.
   *
   * <ul>
   *   <li>Then return Command is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBrigadier#copyLiteral(String, LiteralCommandNode)}
   */
  @Test
  @DisplayName("Test copyLiteral(String, LiteralCommandNode); then return Command is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LiteralCommandNode PaperBrigadier.copyLiteral(String, LiteralCommandNode)"})
  void testCopyLiteral_thenReturnCommandIsNull() {
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

    LiteralCommandNode<Object> source =
        new LiteralCommandNode<>(
            "Literal", null, requirement, redirect2, mock(RedirectModifier.class), true);

    // Act
    LiteralCommandNode<Object> actualCopyLiteralResult =
        PaperBrigadier.copyLiteral("New Literal", source);

    // Assert
    assertNull(actualCopyLiteralResult.getCommand());
    assertSame(redirect2, actualCopyLiteralResult.getRedirect());
  }

  /**
   * Test {@link PaperBrigadier#copyLiteral(String, LiteralCommandNode)}.
   *
   * <ul>
   *   <li>Then return not Fork.
   * </ul>
   *
   * <p>Method under test: {@link PaperBrigadier#copyLiteral(String, LiteralCommandNode)}
   */
  @Test
  @DisplayName("Test copyLiteral(String, LiteralCommandNode); then return not Fork")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LiteralCommandNode PaperBrigadier.copyLiteral(String, LiteralCommandNode)"})
  void testCopyLiteral_thenReturnNotFork() {
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

    LiteralCommandNode<Object> source =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), false);

    // Act
    LiteralCommandNode<Object> actualCopyLiteralResult =
        PaperBrigadier.copyLiteral("New Literal", source);

    // Assert
    assertFalse(actualCopyLiteralResult.isFork());
    assertSame(redirect, actualCopyLiteralResult.getRedirect());
  }
}

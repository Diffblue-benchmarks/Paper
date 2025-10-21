package io.papermc.paper.command.brigadier;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ShadowBrigNodeDiffblueTest {
  /**
   * Test {@link ShadowBrigNode#ShadowBrigNode(CommandNode)}.
   *
   * <ul>
   *   <li>Then Redirect return {@link ShadowBrigNode}.
   * </ul>
   *
   * <p>Method under test: {@link ShadowBrigNode#ShadowBrigNode(CommandNode)}
   */
  @Test
  @DisplayName("Test new ShadowBrigNode(CommandNode); then Redirect return ShadowBrigNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShadowBrigNode.<init>(CommandNode)"})
  void testNewShadowBrigNode_thenRedirectReturnShadowBrigNode() {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<net.minecraft.commands.CommandSourceStack> command = mock(Command.class);
    Predicate<net.minecraft.commands.CommandSourceStack> requirement = mock(Predicate.class);
    Command<net.minecraft.commands.CommandSourceStack> command2 = mock(Command.class);
    Predicate<net.minecraft.commands.CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<net.minecraft.commands.CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<net.minecraft.commands.CommandSourceStack, Object> node =
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
    ShadowBrigNode actualShadowBrigNode = new ShadowBrigNode(node);

    // Assert
    assertTrue(actualShadowBrigNode.getRedirect() instanceof ShadowBrigNode);
    assertEquals("Name", actualShadowBrigNode.getLiteral());
    assertEquals("Name", actualShadowBrigNode.getName());
    assertEquals("Name", actualShadowBrigNode.getUsageText());
    assertSame(node, actualShadowBrigNode.getHandle());
  }

  /**
   * Test {@link ShadowBrigNode#ShadowBrigNode(CommandNode)}.
   *
   * <ul>
   *   <li>Then return Examples size is one.
   * </ul>
   *
   * <p>Method under test: {@link ShadowBrigNode#ShadowBrigNode(CommandNode)}
   */
  @Test
  @DisplayName("Test new ShadowBrigNode(CommandNode); then return Examples size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShadowBrigNode.<init>(CommandNode)"})
  void testNewShadowBrigNode_thenReturnExamplesSizeIsOne() {
    // Arrange
    ArgumentCommandNode<net.minecraft.commands.CommandSourceStack, Object> node =
        new ArgumentCommandNode<>(
            "minecraft:",
            mock(ArgumentType.class),
            mock(Command.class),
            mock(Predicate.class),
            null,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act
    ShadowBrigNode actualShadowBrigNode = new ShadowBrigNode(node);

    // Assert
    Collection<String> examples = actualShadowBrigNode.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertEquals("minecraft:", actualShadowBrigNode.getLiteral());
    assertEquals("minecraft:", actualShadowBrigNode.getName());
    assertEquals("minecraft:", actualShadowBrigNode.getUsageText());
    assertNull(actualShadowBrigNode.getRedirect());
    assertTrue(examples.contains("minecraft:"));
    assertSame(node, actualShadowBrigNode.getHandle());
  }

  /**
   * Test {@link ShadowBrigNode#getChildren()}.
   *
   * <p>Method under test: {@link ShadowBrigNode#getChildren()}
   */
  @Test
  @DisplayName("Test getChildren()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ShadowBrigNode.getChildren()"})
  void testGetChildren() {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<net.minecraft.commands.CommandSourceStack> command = mock(Command.class);
    Predicate<net.minecraft.commands.CommandSourceStack> requirement = mock(Predicate.class);
    Command<net.minecraft.commands.CommandSourceStack> command2 = mock(Command.class);
    Predicate<net.minecraft.commands.CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<net.minecraft.commands.CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<net.minecraft.commands.CommandSourceStack, Object> node =
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
    assertThrows(UnsupportedOperationException.class, () -> new ShadowBrigNode(node).getChildren());
  }

  /**
   * Test {@link ShadowBrigNode#getChild(String)}.
   *
   * <p>Method under test: {@link ShadowBrigNode#getChild(String)}
   */
  @Test
  @DisplayName("Test getChild(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommandNode ShadowBrigNode.getChild(String)"})
  void testGetChild() {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<net.minecraft.commands.CommandSourceStack> command = mock(Command.class);
    Predicate<net.minecraft.commands.CommandSourceStack> requirement = mock(Predicate.class);
    Command<net.minecraft.commands.CommandSourceStack> command2 = mock(Command.class);
    Predicate<net.minecraft.commands.CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<net.minecraft.commands.CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<net.minecraft.commands.CommandSourceStack, Object> node =
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
        UnsupportedOperationException.class, () -> new ShadowBrigNode(node).getChild("Name"));
  }

  /**
   * Test {@link ShadowBrigNode#addChild(CommandNode)}.
   *
   * <p>Method under test: {@link ShadowBrigNode#addChild(CommandNode)}
   */
  @Test
  @DisplayName("Test addChild(CommandNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShadowBrigNode.addChild(CommandNode)"})
  void testAddChild() {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<net.minecraft.commands.CommandSourceStack> command = mock(Command.class);
    Predicate<net.minecraft.commands.CommandSourceStack> requirement = mock(Predicate.class);
    Command<net.minecraft.commands.CommandSourceStack> command2 = mock(Command.class);
    Predicate<net.minecraft.commands.CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<net.minecraft.commands.CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<net.minecraft.commands.CommandSourceStack, Object> node =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    ShadowBrigNode shadowBrigNode = new ShadowBrigNode(node);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<CommandSourceStack> command3 = mock(Command.class);
    Predicate<CommandSourceStack> requirement3 = mock(Predicate.class);
    Command<CommandSourceStack> command4 = mock(Command.class);
    Predicate<CommandSourceStack> requirement4 = mock(Predicate.class);

    LiteralCommandNode<CommandSourceStack> redirect2 =
        new LiteralCommandNode<>(
            "Literal",
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<CommandSourceStack, Object> node2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command3,
            requirement3,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> shadowBrigNode.addChild(node2));
  }

  /**
   * Test {@link ShadowBrigNode#getHandle()}.
   *
   * <p>Method under test: {@link ShadowBrigNode#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommandNode ShadowBrigNode.getHandle()"})
  void testGetHandle() {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<net.minecraft.commands.CommandSourceStack> command = mock(Command.class);
    Predicate<net.minecraft.commands.CommandSourceStack> requirement = mock(Predicate.class);
    Command<net.minecraft.commands.CommandSourceStack> command2 = mock(Command.class);
    Predicate<net.minecraft.commands.CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<net.minecraft.commands.CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<net.minecraft.commands.CommandSourceStack, Object> node =
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
    assertSame(node, new ShadowBrigNode(node).getHandle());
  }
}

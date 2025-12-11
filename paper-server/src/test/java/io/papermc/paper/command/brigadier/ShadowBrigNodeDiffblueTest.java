package io.papermc.paper.command.brigadier;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
   *   <li>Then return Redirect Name is {@code Literal}.
   * </ul>
   *
   * <p>Method under test: {@link ShadowBrigNode#ShadowBrigNode(CommandNode)}
   */
  @Test
  @DisplayName("Test new ShadowBrigNode(CommandNode); then return Redirect Name is 'Literal'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShadowBrigNode.<init>(CommandNode)"})
  void testNewShadowBrigNode_thenReturnRedirectNameIsLiteral() {
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
    CommandNode<CommandSourceStack> redirect2 = actualShadowBrigNode.getRedirect();
    assertTrue(redirect2 instanceof ShadowBrigNode);
    Collection<String> examples = actualShadowBrigNode.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertEquals("Literal", redirect2.getName());
    assertEquals("Literal", redirect2.getUsageText());
    assertEquals("Literal", ((ShadowBrigNode) redirect2).getLiteral());
    assertEquals("Name", actualShadowBrigNode.getLiteral());
    assertEquals("Name", actualShadowBrigNode.getName());
    assertEquals("Name", actualShadowBrigNode.getUsageText());
    assertTrue(examples.contains("Name"));
    assertSame(node, actualShadowBrigNode.getHandle());
    assertSame(redirect, ((ShadowBrigNode) redirect2).getHandle());
  }

  /**
   * Test {@link ShadowBrigNode#ShadowBrigNode(CommandNode)}.
   *
   * <ul>
   *   <li>Then return Redirect Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ShadowBrigNode#ShadowBrigNode(CommandNode)}
   */
  @Test
  @DisplayName("Test new ShadowBrigNode(CommandNode); then return Redirect Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShadowBrigNode.<init>(CommandNode)"})
  void testNewShadowBrigNode_thenReturnRedirectNameIsName() {
    // Arrange
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<net.minecraft.commands.CommandSourceStack> command = mock(Command.class);
    Predicate<net.minecraft.commands.CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<net.minecraft.commands.CommandSourceStack> command2 = mock(Command.class);
    Predicate<net.minecraft.commands.CommandSourceStack> requirement2 = mock(Predicate.class);
    Command<net.minecraft.commands.CommandSourceStack> command3 = mock(Command.class);
    Predicate<net.minecraft.commands.CommandSourceStack> requirement3 = mock(Predicate.class);

    LiteralCommandNode<net.minecraft.commands.CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command3,
            requirement3,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<net.minecraft.commands.CommandSourceStack, Object> redirect2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command2,
            requirement2,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    ArgumentCommandNode<net.minecraft.commands.CommandSourceStack, Object> node =
        new ArgumentCommandNode<>(
            "minecraft:",
            type,
            command,
            requirement,
            redirect2,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    // Act
    ShadowBrigNode actualShadowBrigNode = new ShadowBrigNode(node);

    // Assert
    CommandNode<CommandSourceStack> redirect3 = actualShadowBrigNode.getRedirect();
    assertTrue(redirect3 instanceof ShadowBrigNode);
    Collection<String> examples = actualShadowBrigNode.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof Set);
    assertEquals("Name", redirect3.getName());
    assertEquals("Name", redirect3.getUsageText());
    assertEquals("Name", ((ShadowBrigNode) redirect3).getLiteral());
    assertEquals("minecraft:", actualShadowBrigNode.getLiteral());
    assertEquals("minecraft:", actualShadowBrigNode.getName());
    assertEquals("minecraft:", actualShadowBrigNode.getUsageText());
    assertTrue(examples.contains("minecraft:"));
    assertSame(redirect2, ((ShadowBrigNode) redirect3).getHandle());
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

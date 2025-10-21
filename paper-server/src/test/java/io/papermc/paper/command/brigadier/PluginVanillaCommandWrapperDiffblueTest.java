package io.papermc.paper.command.brigadier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import io.papermc.paper.plugin.PaperTestPlugin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.commands.CommandSourceStack;
import org.bukkit.craftbukkit.command.VanillaCommandWrapper;
import org.bukkit.plugin.Plugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginVanillaCommandWrapperDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PluginVanillaCommandWrapper#PluginVanillaCommandWrapper(String, String, String,
   *       List, CommandNode, Plugin)}
   *   <li>{@link PluginVanillaCommandWrapper#getAliases()}
   *   <li>{@link PluginVanillaCommandWrapper#getPlugin()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginVanillaCommandWrapper.<init>(String, String, String, List, CommandNode, Plugin)",
    "List PluginVanillaCommandWrapper.getAliases()",
    "Plugin PluginVanillaCommandWrapper.getPlugin()"
  })
  void testGettersAndSetters() {
    // Arrange
    ArrayList<String> aliases = new ArrayList<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<CommandSourceStack, Object> vanillaCommand =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");

    // Act
    PluginVanillaCommandWrapper actualPluginVanillaCommandWrapper =
        new PluginVanillaCommandWrapper(
            "Name",
            "The characteristics of someone or something",
            "Usage Message",
            aliases,
            vanillaCommand,
            plugin);
    List<String> actualAliases = actualPluginVanillaCommandWrapper.getAliases();
    Plugin actualPlugin = actualPluginVanillaCommandWrapper.getPlugin();

    // Assert
    assertEquals("Name", actualPluginVanillaCommandWrapper.getLabel());
    assertEquals("Name", actualPluginVanillaCommandWrapper.getName());
    assertEquals(
        "The characteristics of someone or something",
        actualPluginVanillaCommandWrapper.getDescription());
    assertEquals("Usage Message", actualPluginVanillaCommandWrapper.getUsage());
    assertNull(actualPluginVanillaCommandWrapper.getPermission());
    assertTrue(actualAliases.isEmpty());
    assertSame(plugin, actualPlugin);
    assertSame(aliases, actualAliases);
  }

  /**
   * Test {@link PluginVanillaCommandWrapper#setAliases(List)}.
   *
   * <p>Method under test: {@link PluginVanillaCommandWrapper#setAliases(List)}
   */
  @Test
  @DisplayName("Test setAliases(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.command.Command PluginVanillaCommandWrapper.setAliases(List)"})
  void testSetAliases() {
    // Arrange
    ArrayList<String> aliases = new ArrayList<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<CommandSourceStack, Object> vanillaCommand =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    PluginVanillaCommandWrapper pluginVanillaCommandWrapper =
        new PluginVanillaCommandWrapper(
            "Name",
            "The characteristics of someone or something",
            "Usage Message",
            aliases,
            vanillaCommand,
            new PaperTestPlugin("Plugin Name"));

    // Act
    org.bukkit.command.Command actualSetAliasesResult =
        pluginVanillaCommandWrapper.setAliases(new ArrayList<>());

    // Assert
    assertSame(pluginVanillaCommandWrapper, actualSetAliasesResult);
  }

  /**
   * Test {@link PluginVanillaCommandWrapper#setAliases(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PluginVanillaCommandWrapper#setAliases(List)}
   */
  @Test
  @DisplayName("Test setAliases(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.command.Command PluginVanillaCommandWrapper.setAliases(List)"})
  void testSetAliases_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> aliases = new ArrayList<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<CommandSourceStack, Object> vanillaCommand =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    PluginVanillaCommandWrapper pluginVanillaCommandWrapper =
        new PluginVanillaCommandWrapper(
            "Name",
            "The characteristics of someone or something",
            "Usage Message",
            aliases,
            vanillaCommand,
            new PaperTestPlugin("Plugin Name"));

    ArrayList<String> aliases2 = new ArrayList<>();
    aliases2.add("42");
    aliases2.add("foo");

    // Act
    org.bukkit.command.Command actualSetAliasesResult =
        pluginVanillaCommandWrapper.setAliases(aliases2);

    // Assert
    CommandNode<CommandSourceStack> commandNode =
        ((PluginVanillaCommandWrapper) actualSetAliasesResult).vanillaCommand;
    assertTrue(commandNode instanceof ArgumentCommandNode);
    CommandNode<CommandSourceStack> redirect2 = commandNode.getRedirect();
    assertTrue(redirect2 instanceof LiteralCommandNode);
    CommandNode<CommandSourceStack> redirect3 = redirect2.getRedirect();
    assertTrue(redirect3 instanceof RootCommandNode);
    assertTrue(actualSetAliasesResult instanceof PluginVanillaCommandWrapper);
    Collection<String> examples = redirect3.getExamples();
    assertTrue(examples instanceof List);
    Collection<String> examples2 = commandNode.getExamples();
    assertTrue(examples2 instanceof List);
    assertTrue(examples.isEmpty());
    assertTrue(examples2.isEmpty());
  }

  /**
   * Test {@link PluginVanillaCommandWrapper#setAliases(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then {@link VanillaCommandWrapper#vanillaCommand} return {@link ArgumentCommandNode}.
   * </ul>
   *
   * <p>Method under test: {@link PluginVanillaCommandWrapper#setAliases(List)}
   */
  @Test
  @DisplayName("Test setAliases(List); given 'foo'; then vanillaCommand return ArgumentCommandNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.command.Command PluginVanillaCommandWrapper.setAliases(List)"})
  void testSetAliases_givenFoo_thenVanillaCommandReturnArgumentCommandNode() {
    // Arrange
    ArrayList<String> aliases = new ArrayList<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<CommandSourceStack, Object> vanillaCommand =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    PluginVanillaCommandWrapper pluginVanillaCommandWrapper =
        new PluginVanillaCommandWrapper(
            "Name",
            "The characteristics of someone or something",
            "Usage Message",
            aliases,
            vanillaCommand,
            new PaperTestPlugin("Plugin Name"));

    ArrayList<String> aliases2 = new ArrayList<>();
    aliases2.add("foo");

    // Act
    org.bukkit.command.Command actualSetAliasesResult =
        pluginVanillaCommandWrapper.setAliases(aliases2);

    // Assert
    CommandNode<CommandSourceStack> commandNode =
        ((PluginVanillaCommandWrapper) actualSetAliasesResult).vanillaCommand;
    assertTrue(commandNode instanceof ArgumentCommandNode);
    CommandNode<CommandSourceStack> redirect2 = commandNode.getRedirect();
    assertTrue(redirect2 instanceof LiteralCommandNode);
    CommandNode<CommandSourceStack> redirect3 = redirect2.getRedirect();
    assertTrue(redirect3 instanceof RootCommandNode);
    assertTrue(actualSetAliasesResult instanceof PluginVanillaCommandWrapper);
    Collection<String> examples = redirect3.getExamples();
    assertTrue(examples instanceof List);
    Collection<String> examples2 = commandNode.getExamples();
    assertTrue(examples2 instanceof List);
    assertTrue(examples.isEmpty());
    assertTrue(examples2.isEmpty());
  }
}

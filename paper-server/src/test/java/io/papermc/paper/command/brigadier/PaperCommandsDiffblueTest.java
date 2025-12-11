package io.papermc.paper.command.brigadier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.RedirectModifier;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.tree.ArgumentCommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import io.papermc.paper.command.MSPTCommand;
import io.papermc.paper.command.brigadier.bukkit.BukkitCommandNode;
import io.papermc.paper.plugin.TestPluginMeta;
import io.papermc.paper.plugin.configuration.PluginMeta;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.Commands;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaperCommandsDiffblueTest {
  @Mock private CommandDispatcher<CommandSourceStack> commandDispatcher;

  @InjectMocks private PaperCommands paperCommands;

  /**
   * Test {@link PaperCommands#setDispatcher(Commands, CommandBuildContext)}.
   *
   * <p>Method under test: {@link PaperCommands#setDispatcher(Commands, CommandBuildContext)}
   */
  @Test
  @DisplayName("Test setDispatcher(Commands, CommandBuildContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperCommands.setDispatcher(Commands, CommandBuildContext)"})
  void testSetDispatcher() {
    // Arrange
    PaperCommands paperCommands = PaperCommands.INSTANCE;
    CommandBuildContext commandBuildContext = mock(CommandBuildContext.class);

    // Act
    paperCommands.setDispatcher(null, commandBuildContext);

    // Assert
    assertSame(commandBuildContext, paperCommands.getBuildContext());
  }

  /**
   * Test {@link PaperCommands#register(PluginMeta, String, String, Collection, BasicCommand)} with
   * {@code pluginMeta}, {@code label}, {@code description}, {@code aliases}, {@code basicCommand}.
   *
   * <p>Method under test: {@link PaperCommands#register(PluginMeta, String, String, Collection,
   * BasicCommand)}
   */
  @Test
  @DisplayName(
      "Test register(PluginMeta, String, String, Collection, BasicCommand) with 'pluginMeta', 'label', 'description', 'aliases', 'basicCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.register(PluginMeta, String, String, Collection, BasicCommand)"
  })
  void testRegisterWithPluginMetaLabelDescriptionAliasesBasicCommand() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");

    // Act
    Set<String> actualRegisterResult =
        paperCommands.register(
            pluginMeta,
            "Label",
            "The characteristics of someone or something",
            new ArrayList<>(),
            mock(BasicCommand.class));

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(2, actualRegisterResult.size());
    assertTrue(actualRegisterResult.contains("42:Label"));
    assertTrue(actualRegisterResult.contains("Label"));
  }

  /**
   * Test {@link PaperCommands#register(PluginMeta, String, String, Collection, BasicCommand)} with
   * {@code pluginMeta}, {@code label}, {@code description}, {@code aliases}, {@code basicCommand}.
   *
   * <p>Method under test: {@link PaperCommands#register(PluginMeta, String, String, Collection,
   * BasicCommand)}
   */
  @Test
  @DisplayName(
      "Test register(PluginMeta, String, String, Collection, BasicCommand) with 'pluginMeta', 'label', 'description', 'aliases', 'basicCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.register(PluginMeta, String, String, Collection, BasicCommand)"
  })
  void testRegisterWithPluginMetaLabelDescriptionAliasesBasicCommand2() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("args");

    // Act
    Set<String> actualRegisterResult =
        paperCommands.register(
            pluginMeta,
            "Label",
            "The characteristics of someone or something",
            aliases,
            mock(BasicCommand.class));

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(4, actualRegisterResult.size());
    assertTrue(actualRegisterResult.contains("42:Label"));
    assertTrue(actualRegisterResult.contains("42:args"));
    assertTrue(actualRegisterResult.contains("args"));
  }

  /**
   * Test {@link PaperCommands#register(PluginMeta, String, String, Collection, BasicCommand)} with
   * {@code pluginMeta}, {@code label}, {@code description}, {@code aliases}, {@code basicCommand}.
   *
   * <p>Method under test: {@link PaperCommands#register(PluginMeta, String, String, Collection,
   * BasicCommand)}
   */
  @Test
  @DisplayName(
      "Test register(PluginMeta, String, String, Collection, BasicCommand) with 'pluginMeta', 'label', 'description', 'aliases', 'basicCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.register(PluginMeta, String, String, Collection, BasicCommand)"
  })
  void testRegisterWithPluginMetaLabelDescriptionAliasesBasicCommand3() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("cannot access the dispatcher in this context");
    aliases.add("args");

    // Act
    Set<String> actualRegisterResult =
        paperCommands.register(
            pluginMeta,
            "Label",
            "The characteristics of someone or something",
            aliases,
            mock(BasicCommand.class));

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(6, actualRegisterResult.size());
    assertTrue(actualRegisterResult.contains("42:Label"));
    assertTrue(actualRegisterResult.contains("42:args"));
    assertTrue(actualRegisterResult.contains("42:cannot access the dispatcher in this context"));
    assertTrue(actualRegisterResult.contains("args"));
  }

  /**
   * Test {@link PaperCommands#register(PluginMeta, String, String, Collection, BasicCommand)} with
   * {@code pluginMeta}, {@code label}, {@code description}, {@code aliases}, {@code basicCommand}.
   *
   * <p>Method under test: {@link PaperCommands#register(PluginMeta, String, String, Collection,
   * BasicCommand)}
   */
  @Test
  @DisplayName(
      "Test register(PluginMeta, String, String, Collection, BasicCommand) with 'pluginMeta', 'label', 'description', 'aliases', 'basicCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.register(PluginMeta, String, String, Collection, BasicCommand)"
  })
  void testRegisterWithPluginMetaLabelDescriptionAliasesBasicCommand4() {
    // Arrange
    RootCommandNode<CommandSourceStack> rootCommandNode = new RootCommandNode<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "args",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<CommandSourceStack, Object> node =
        new ArgumentCommandNode<>(
            "args",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    rootCommandNode.addChild(node);
    when(commandDispatcher.getRoot()).thenReturn(rootCommandNode);
    TestPluginMeta pluginMeta = new TestPluginMeta("42");

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("args");

    // Act
    Set<String> actualRegisterResult =
        paperCommands.register(
            pluginMeta,
            "Label",
            "The characteristics of someone or something",
            aliases,
            mock(BasicCommand.class));

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(4, actualRegisterResult.size());
    assertTrue(actualRegisterResult.contains("42:Label"));
    assertTrue(actualRegisterResult.contains("42:args"));
    assertTrue(actualRegisterResult.contains("args"));
  }

  /**
   * Test {@link PaperCommands#register(PluginMeta, String, String, Collection, BasicCommand)} with
   * {@code pluginMeta}, {@code label}, {@code description}, {@code aliases}, {@code basicCommand}.
   *
   * <p>Method under test: {@link PaperCommands#register(PluginMeta, String, String, Collection,
   * BasicCommand)}
   */
  @Test
  @DisplayName(
      "Test register(PluginMeta, String, String, Collection, BasicCommand) with 'pluginMeta', 'label', 'description', 'aliases', 'basicCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.register(PluginMeta, String, String, Collection, BasicCommand)"
  })
  void testRegisterWithPluginMetaLabelDescriptionAliasesBasicCommand5() {
    // Arrange
    RootCommandNode<CommandSourceStack> rootCommandNode = new RootCommandNode<>();
    BukkitCommandNode node = BukkitCommandNode.of("args", new MSPTCommand("args"));
    rootCommandNode.addChild(node);
    when(commandDispatcher.getRoot()).thenReturn(rootCommandNode);
    TestPluginMeta pluginMeta = new TestPluginMeta("42");

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("args");

    // Act
    Set<String> actualRegisterResult =
        paperCommands.register(
            pluginMeta,
            "Label",
            "The characteristics of someone or something",
            aliases,
            mock(BasicCommand.class));

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(3, actualRegisterResult.size());
    assertTrue(actualRegisterResult.contains("42:Label"));
    assertTrue(actualRegisterResult.contains("42:args"));
    assertTrue(actualRegisterResult.contains("Label"));
  }

  /**
   * Test {@link PaperCommands#register(PluginMeta, String, String, Collection, BasicCommand)} with
   * {@code pluginMeta}, {@code label}, {@code description}, {@code aliases}, {@code basicCommand}.
   *
   * <p>Method under test: {@link PaperCommands#register(PluginMeta, String, String, Collection,
   * BasicCommand)}
   */
  @Test
  @DisplayName(
      "Test register(PluginMeta, String, String, Collection, BasicCommand) with 'pluginMeta', 'label', 'description', 'aliases', 'basicCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.register(PluginMeta, String, String, Collection, BasicCommand)"
  })
  void testRegisterWithPluginMetaLabelDescriptionAliasesBasicCommand6() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("cannot access the dispatcher in this context");
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterResult =
        paperCommands.register(
            pluginMeta,
            "Label",
            "The characteristics of someone or something",
            aliases,
            mock(BasicCommand.class));

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(4, actualRegisterResult.size());
    assertTrue(actualRegisterResult.contains("42:Label"));
    assertTrue(actualRegisterResult.contains("42:cannot access the dispatcher in this context"));
    assertTrue(actualRegisterResult.contains("cannot access the dispatcher in this context"));
  }

  /**
   * Test {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String, Collection)} with
   * {@code pluginMeta}, {@code node}, {@code description}, {@code aliases}.
   *
   * <p>Method under test: {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test register(PluginMeta, LiteralCommandNode, String, Collection) with 'pluginMeta', 'node', 'description', 'aliases'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.register(PluginMeta, LiteralCommandNode, String, Collection)"
  })
  void testRegisterWithPluginMetaNodeDescriptionAliases() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), false);

    // Act
    Set<String> actualRegisterResult =
        paperCommands.register(
            pluginMeta, node, "The characteristics of someone or something", new ArrayList<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(2, actualRegisterResult.size());
    assertTrue(actualRegisterResult.contains("42:Literal"));
    assertTrue(actualRegisterResult.contains("Literal"));
  }

  /**
   * Test {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String, Collection)} with
   * {@code pluginMeta}, {@code node}, {@code description}, {@code aliases}.
   *
   * <p>Method under test: {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test register(PluginMeta, LiteralCommandNode, String, Collection) with 'pluginMeta', 'node', 'description', 'aliases'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.register(PluginMeta, LiteralCommandNode, String, Collection)"
  })
  void testRegisterWithPluginMetaNodeDescriptionAliases2() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterResult =
        paperCommands.register(
            pluginMeta, node, "The characteristics of someone or something", aliases);

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node.apiCommandMeta.aliases();
    assertEquals(2, aliasesResult.size());
    assertEquals("42:cannot access the dispatcher in this context", aliasesResult.get(1));
    assertEquals("cannot access the dispatcher in this context", aliasesResult.get(0));
    assertEquals(4, actualRegisterResult.size());
    assertTrue(actualRegisterResult.contains("42:Literal"));
    assertTrue(actualRegisterResult.contains("Literal"));
  }

  /**
   * Test {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String, Collection)} with
   * {@code pluginMeta}, {@code node}, {@code description}, {@code aliases}.
   *
   * <p>Method under test: {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test register(PluginMeta, LiteralCommandNode, String, Collection) with 'pluginMeta', 'node', 'description', 'aliases'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.register(PluginMeta, LiteralCommandNode, String, Collection)"
  })
  void testRegisterWithPluginMetaNodeDescriptionAliases3() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("foo");
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterResult =
        paperCommands.register(
            pluginMeta, node, "The characteristics of someone or something", aliases);

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node.apiCommandMeta.aliases();
    assertEquals(4, aliasesResult.size());
    assertEquals("42:cannot access the dispatcher in this context", aliasesResult.get(3));
    assertEquals("42:foo", aliasesResult.get(1));
    assertEquals("cannot access the dispatcher in this context", aliasesResult.get(2));
    assertEquals("foo", aliasesResult.get(0));
    assertEquals(6, actualRegisterResult.size());
    assertTrue(actualRegisterResult.contains("42:Literal"));
    assertTrue(actualRegisterResult.contains("42:cannot access the dispatcher in this context"));
    assertTrue(actualRegisterResult.contains("42:foo"));
    assertTrue(actualRegisterResult.contains("Literal"));
    assertTrue(actualRegisterResult.contains("foo"));
  }

  /**
   * Test {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String, Collection)} with
   * {@code pluginMeta}, {@code node}, {@code description}, {@code aliases}.
   *
   * <p>Method under test: {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test register(PluginMeta, LiteralCommandNode, String, Collection) with 'pluginMeta', 'node', 'description', 'aliases'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.register(PluginMeta, LiteralCommandNode, String, Collection)"
  })
  void testRegisterWithPluginMetaNodeDescriptionAliases4() {
    // Arrange
    RootCommandNode<CommandSourceStack> rootCommandNode = new RootCommandNode<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "cannot access the dispatcher in this context",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<CommandSourceStack, Object> node =
        new ArgumentCommandNode<>(
            "cannot access the dispatcher in this context",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    rootCommandNode.addChild(node);
    when(commandDispatcher.getRoot()).thenReturn(rootCommandNode);
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command3 = mock(Command.class);
    Predicate<CommandSourceStack> requirement3 = mock(Predicate.class);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<CommandSourceStack> command4 = mock(Command.class);
    Predicate<CommandSourceStack> requirement4 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node2 =
        new LiteralCommandNode<>(
            "Literal", command3, requirement3, redirect2, mock(RedirectModifier.class), true);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterResult =
        paperCommands.register(
            pluginMeta, node2, "The characteristics of someone or something", aliases);

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node2.apiCommandMeta.aliases();
    assertEquals(2, aliasesResult.size());
    assertEquals("42:cannot access the dispatcher in this context", aliasesResult.get(1));
    assertEquals("cannot access the dispatcher in this context", aliasesResult.get(0));
    assertEquals(4, actualRegisterResult.size());
    assertTrue(actualRegisterResult.contains("42:Literal"));
    assertTrue(actualRegisterResult.contains("Literal"));
  }

  /**
   * Test {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String, Collection)} with
   * {@code pluginMeta}, {@code node}, {@code description}, {@code aliases}.
   *
   * <p>Method under test: {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test register(PluginMeta, LiteralCommandNode, String, Collection) with 'pluginMeta', 'node', 'description', 'aliases'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.register(PluginMeta, LiteralCommandNode, String, Collection)"
  })
  void testRegisterWithPluginMetaNodeDescriptionAliases5() {
    // Arrange
    RootCommandNode<CommandSourceStack> rootCommandNode = new RootCommandNode<>();
    BukkitCommandNode node =
        BukkitCommandNode.of(
            "cannot access the dispatcher in this context", new MSPTCommand("Name"));
    rootCommandNode.addChild(node);
    when(commandDispatcher.getRoot()).thenReturn(rootCommandNode);
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node2 =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterResult =
        paperCommands.register(
            pluginMeta, node2, "The characteristics of someone or something", aliases);

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node2.apiCommandMeta.aliases();
    assertEquals(1, aliasesResult.size());
    assertEquals("42:cannot access the dispatcher in this context", aliasesResult.get(0));
    assertEquals(3, actualRegisterResult.size());
    assertTrue(actualRegisterResult.contains("Literal"));
  }

  /**
   * Test {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String, Collection)} with
   * {@code pluginMeta}, {@code node}, {@code description}, {@code aliases}.
   *
   * <p>Method under test: {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test register(PluginMeta, LiteralCommandNode, String, Collection) with 'pluginMeta', 'node', 'description', 'aliases'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.register(PluginMeta, LiteralCommandNode, String, Collection)"
  })
  void testRegisterWithPluginMetaNodeDescriptionAliases6() {
    // Arrange
    RootCommandNode<CommandSourceStack> rootCommandNode = new RootCommandNode<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "cannot access the dispatcher in this context",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<CommandSourceStack, Object> node =
        new ArgumentCommandNode<>(
            "cannot access the dispatcher in this context",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    rootCommandNode.addChild(node);
    when(commandDispatcher.getRoot()).thenReturn(rootCommandNode);
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command3 = mock(Command.class);
    Predicate<CommandSourceStack> requirement3 = mock(Predicate.class);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<CommandSourceStack> command4 = mock(Command.class);
    Predicate<CommandSourceStack> requirement4 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node2 =
        new LiteralCommandNode<>(
            "Literal", command3, requirement3, redirect2, mock(RedirectModifier.class), true);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("cannot access the dispatcher in this context");
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterResult =
        paperCommands.register(
            pluginMeta, node2, "The characteristics of someone or something", aliases);

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node2.apiCommandMeta.aliases();
    assertEquals(2, aliasesResult.size());
    assertEquals("42:cannot access the dispatcher in this context", aliasesResult.get(1));
    assertEquals("cannot access the dispatcher in this context", aliasesResult.get(0));
    assertEquals(4, actualRegisterResult.size());
    assertTrue(actualRegisterResult.contains("42:Literal"));
    assertTrue(actualRegisterResult.contains("Literal"));
  }

  /**
   * Test {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String, Collection)} with
   * {@code pluginMeta}, {@code node}, {@code description}, {@code aliases}.
   *
   * <ul>
   *   <li>Then return contains {@code 42:Name}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test register(PluginMeta, LiteralCommandNode, String, Collection) with 'pluginMeta', 'node', 'description', 'aliases'; then return contains '42:Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.register(PluginMeta, LiteralCommandNode, String, Collection)"
  })
  void testRegisterWithPluginMetaNodeDescriptionAliases_thenReturnContains42Name() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");

    BukkitCommandNode node = BukkitCommandNode.of("Name", new MSPTCommand("Name"));
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "cannot access the dispatcher in this context",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<CommandSourceStack, Object> node2 =
        new ArgumentCommandNode<>(
            "cannot access the dispatcher in this context",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node.addChild(node2);

    // Act
    Set<String> actualRegisterResult =
        paperCommands.register(
            pluginMeta, node, "The characteristics of someone or something", new ArrayList<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(2, actualRegisterResult.size());
    assertTrue(actualRegisterResult.contains("42:Name"));
    assertTrue(actualRegisterResult.contains("Name"));
  }

  /**
   * Test {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String, Collection)} with
   * {@code pluginMeta}, {@code node}, {@code description}, {@code aliases}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommands#register(PluginMeta, LiteralCommandNode, String,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test register(PluginMeta, LiteralCommandNode, String, Collection) with 'pluginMeta', 'node', 'description', 'aliases'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.register(PluginMeta, LiteralCommandNode, String, Collection)"
  })
  void testRegisterWithPluginMetaNodeDescriptionAliases_thenReturnSizeIsTwo() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    // Act
    Set<String> actualRegisterResult =
        paperCommands.register(
            pluginMeta, node, "The characteristics of someone or something", new ArrayList<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(2, actualRegisterResult.size());
    assertTrue(actualRegisterResult.contains("42:Literal"));
    assertTrue(actualRegisterResult.contains("Literal"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection,
   * Set)}.
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode,
   * String, Collection, Set)}
   */
  @Test
  @DisplayName("Test registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlags() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), false);
    ArrayList<String> aliases = new ArrayList<>();

    // Act
    Set<String> actualRegisterWithFlagsResult =
        paperCommands.registerWithFlags(
            pluginMeta,
            node,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(2, actualRegisterWithFlagsResult.size());
    assertTrue(actualRegisterWithFlagsResult.contains("42:Literal"));
    assertTrue(actualRegisterWithFlagsResult.contains("Literal"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection,
   * Set)}.
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode,
   * String, Collection, Set)}
   */
  @Test
  @DisplayName("Test registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlags2() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterWithFlagsResult =
        paperCommands.registerWithFlags(
            pluginMeta,
            node,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node.apiCommandMeta.aliases();
    assertEquals(2, aliasesResult.size());
    assertEquals("42:cannot access the dispatcher in this context", aliasesResult.get(1));
    assertEquals("cannot access the dispatcher in this context", aliasesResult.get(0));
    assertEquals(4, actualRegisterWithFlagsResult.size());
    assertTrue(actualRegisterWithFlagsResult.contains("42:Literal"));
    assertTrue(actualRegisterWithFlagsResult.contains("Literal"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection,
   * Set)}.
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode,
   * String, Collection, Set)}
   */
  @Test
  @DisplayName("Test registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlags3() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("foo");
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterWithFlagsResult =
        paperCommands.registerWithFlags(
            pluginMeta,
            node,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node.apiCommandMeta.aliases();
    assertEquals(4, aliasesResult.size());
    assertEquals("42:cannot access the dispatcher in this context", aliasesResult.get(3));
    assertEquals("42:foo", aliasesResult.get(1));
    assertEquals("cannot access the dispatcher in this context", aliasesResult.get(2));
    assertEquals("foo", aliasesResult.get(0));
    assertEquals(6, actualRegisterWithFlagsResult.size());
    assertTrue(actualRegisterWithFlagsResult.contains("42:Literal"));
    assertTrue(
        actualRegisterWithFlagsResult.contains("42:cannot access the dispatcher in this context"));
    assertTrue(actualRegisterWithFlagsResult.contains("42:foo"));
    assertTrue(actualRegisterWithFlagsResult.contains("Literal"));
    assertTrue(actualRegisterWithFlagsResult.contains("foo"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection,
   * Set)}.
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode,
   * String, Collection, Set)}
   */
  @Test
  @DisplayName("Test registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlags4() {
    // Arrange
    RootCommandNode<CommandSourceStack> rootCommandNode = new RootCommandNode<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "cannot access the dispatcher in this context",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<CommandSourceStack, Object> node =
        new ArgumentCommandNode<>(
            "cannot access the dispatcher in this context",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    rootCommandNode.addChild(node);
    when(commandDispatcher.getRoot()).thenReturn(rootCommandNode);
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command3 = mock(Command.class);
    Predicate<CommandSourceStack> requirement3 = mock(Predicate.class);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<CommandSourceStack> command4 = mock(Command.class);
    Predicate<CommandSourceStack> requirement4 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node2 =
        new LiteralCommandNode<>(
            "Literal", command3, requirement3, redirect2, mock(RedirectModifier.class), true);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterWithFlagsResult =
        paperCommands.registerWithFlags(
            pluginMeta,
            node2,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node2.apiCommandMeta.aliases();
    assertEquals(2, aliasesResult.size());
    assertEquals("42:cannot access the dispatcher in this context", aliasesResult.get(1));
    assertEquals("cannot access the dispatcher in this context", aliasesResult.get(0));
    assertEquals(4, actualRegisterWithFlagsResult.size());
    assertTrue(actualRegisterWithFlagsResult.contains("42:Literal"));
    assertTrue(actualRegisterWithFlagsResult.contains("Literal"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection,
   * Set)}.
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode,
   * String, Collection, Set)}
   */
  @Test
  @DisplayName("Test registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlags5() {
    // Arrange
    RootCommandNode<CommandSourceStack> rootCommandNode = new RootCommandNode<>();
    BukkitCommandNode node =
        BukkitCommandNode.of(
            "cannot access the dispatcher in this context", new MSPTCommand("Name"));
    rootCommandNode.addChild(node);
    when(commandDispatcher.getRoot()).thenReturn(rootCommandNode);
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node2 =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterWithFlagsResult =
        paperCommands.registerWithFlags(
            pluginMeta,
            node2,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node2.apiCommandMeta.aliases();
    assertEquals(1, aliasesResult.size());
    assertEquals("42:cannot access the dispatcher in this context", aliasesResult.get(0));
    assertEquals(3, actualRegisterWithFlagsResult.size());
    assertTrue(actualRegisterWithFlagsResult.contains("Literal"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection,
   * Set)}.
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode,
   * String, Collection, Set)}
   */
  @Test
  @DisplayName("Test registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlags6() {
    // Arrange
    RootCommandNode<CommandSourceStack> rootCommandNode = new RootCommandNode<>();
    BukkitCommandNode node =
        BukkitCommandNode.of(
            "cannot access the dispatcher in this context", new MSPTCommand("Name"));
    rootCommandNode.addChild(node);
    when(commandDispatcher.getRoot()).thenReturn(rootCommandNode);
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node2 =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("cannot access the dispatcher in this context");
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterWithFlagsResult =
        paperCommands.registerWithFlags(
            pluginMeta,
            node2,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node2.apiCommandMeta.aliases();
    assertEquals(1, aliasesResult.size());
    assertEquals("42:cannot access the dispatcher in this context", aliasesResult.get(0));
    assertEquals(3, actualRegisterWithFlagsResult.size());
    assertTrue(actualRegisterWithFlagsResult.contains("42:Literal"));
    assertTrue(
        actualRegisterWithFlagsResult.contains("42:cannot access the dispatcher in this context"));
    assertTrue(actualRegisterWithFlagsResult.contains("Literal"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection,
   * Set)}.
   *
   * <ul>
   *   <li>Given {@code FLATTEN_ALIASES}.
   *   <li>When {@link HashSet#HashSet()} add {@code FLATTEN_ALIASES}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode,
   * String, Collection, Set)}
   */
  @Test
  @DisplayName(
      "Test registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set); given 'FLATTEN_ALIASES'; when HashSet() add 'FLATTEN_ALIASES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlags_givenFlattenAliases_whenHashSetAddFlattenAliases() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);
    ArrayList<String> aliases = new ArrayList<>();

    HashSet<CommandRegistrationFlag> flags = new HashSet<>();
    flags.add(CommandRegistrationFlag.FLATTEN_ALIASES);

    // Act
    Set<String> actualRegisterWithFlagsResult =
        paperCommands.registerWithFlags(
            pluginMeta, node, "The characteristics of someone or something", aliases, flags);

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(2, actualRegisterWithFlagsResult.size());
    assertTrue(actualRegisterWithFlagsResult.contains("42:Literal"));
    assertTrue(actualRegisterWithFlagsResult.contains("Literal"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection,
   * Set)}.
   *
   * <ul>
   *   <li>Given {@code SERVER_ONLY}.
   *   <li>When {@link HashSet#HashSet()} add {@code SERVER_ONLY}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode,
   * String, Collection, Set)}
   */
  @Test
  @DisplayName(
      "Test registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set); given 'SERVER_ONLY'; when HashSet() add 'SERVER_ONLY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlags_givenServerOnly_whenHashSetAddServerOnly() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);
    ArrayList<String> aliases = new ArrayList<>();

    HashSet<CommandRegistrationFlag> flags = new HashSet<>();
    flags.add(CommandRegistrationFlag.SERVER_ONLY);
    flags.add(CommandRegistrationFlag.FLATTEN_ALIASES);

    // Act
    Set<String> actualRegisterWithFlagsResult =
        paperCommands.registerWithFlags(
            pluginMeta, node, "The characteristics of someone or something", aliases, flags);

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(2, actualRegisterWithFlagsResult.size());
    assertTrue(actualRegisterWithFlagsResult.contains("42:Literal"));
    assertTrue(actualRegisterWithFlagsResult.contains("Literal"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection,
   * Set)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode,
   * String, Collection, Set)}
   */
  @Test
  @DisplayName(
      "Test registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set); when ArrayList(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlags_whenArrayList_thenReturnSizeIsTwo() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);
    ArrayList<String> aliases = new ArrayList<>();

    // Act
    Set<String> actualRegisterWithFlagsResult =
        paperCommands.registerWithFlags(
            pluginMeta,
            node,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(2, actualRegisterWithFlagsResult.size());
    assertTrue(actualRegisterWithFlagsResult.contains("42:Literal"));
    assertTrue(actualRegisterWithFlagsResult.contains("Literal"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection,
   * Set)}.
   *
   * <ul>
   *   <li>When {@link MSPTCommand#MSPTCommand(String)} with {@code Name}.
   *   <li>Then return contains {@code 42:Name}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlags(PluginMeta, LiteralCommandNode,
   * String, Collection, Set)}
   */
  @Test
  @DisplayName(
      "Test registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set); when MSPTCommand(String) with 'Name'; then return contains '42:Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlags(PluginMeta, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlags_whenMSPTCommandWithName_thenReturnContains42Name() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    TestPluginMeta pluginMeta = new TestPluginMeta("42");

    BukkitCommandNode node = BukkitCommandNode.of("Name", new MSPTCommand("Name"));
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "cannot access the dispatcher in this context",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<CommandSourceStack, Object> node2 =
        new ArgumentCommandNode<>(
            "cannot access the dispatcher in this context",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node.addChild(node2);
    ArrayList<String> aliases = new ArrayList<>();

    // Act
    Set<String> actualRegisterWithFlagsResult =
        paperCommands.registerWithFlags(
            pluginMeta,
            node,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(2, actualRegisterWithFlagsResult.size());
    assertTrue(actualRegisterWithFlagsResult.contains("42:Name"));
    assertTrue(actualRegisterWithFlagsResult.contains("Name"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String, String,
   * LiteralCommandNode, String, Collection, Set)}.
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String,
   * String, LiteralCommandNode, String, Collection, Set)}
   */
  @Test
  @DisplayName(
      "Test registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlagsInternal() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    PaperPluginMeta pluginMeta = new PaperPluginMeta();
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), false);
    ArrayList<String> aliases = new ArrayList<>();

    // Act
    Set<String> actualRegisterWithFlagsInternalResult =
        paperCommands.registerWithFlagsInternal(
            pluginMeta,
            "Namespace",
            "Help Namespace Override",
            node,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(2, actualRegisterWithFlagsInternalResult.size());
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Literal"));
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Namespace:Literal"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String, String,
   * LiteralCommandNode, String, Collection, Set)}.
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String,
   * String, LiteralCommandNode, String, Collection, Set)}
   */
  @Test
  @DisplayName(
      "Test registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlagsInternal2() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    PaperPluginMeta pluginMeta = new PaperPluginMeta();
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterWithFlagsInternalResult =
        paperCommands.registerWithFlagsInternal(
            pluginMeta,
            "Namespace",
            "Help Namespace Override",
            node,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node.apiCommandMeta.aliases();
    assertEquals(2, aliasesResult.size());
    assertEquals("Namespace:cannot access the dispatcher in this context", aliasesResult.get(1));
    assertEquals("cannot access the dispatcher in this context", aliasesResult.get(0));
    assertEquals(4, actualRegisterWithFlagsInternalResult.size());
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Literal"));
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Namespace:Literal"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String, String,
   * LiteralCommandNode, String, Collection, Set)}.
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String,
   * String, LiteralCommandNode, String, Collection, Set)}
   */
  @Test
  @DisplayName(
      "Test registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlagsInternal3() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    PaperPluginMeta pluginMeta = new PaperPluginMeta();
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("foo");
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterWithFlagsInternalResult =
        paperCommands.registerWithFlagsInternal(
            pluginMeta,
            "Namespace",
            "Help Namespace Override",
            node,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node.apiCommandMeta.aliases();
    assertEquals(4, aliasesResult.size());
    assertEquals("Namespace:cannot access the dispatcher in this context", aliasesResult.get(3));
    assertEquals("Namespace:foo", aliasesResult.get(1));
    assertEquals("cannot access the dispatcher in this context", aliasesResult.get(2));
    assertEquals("foo", aliasesResult.get(0));
    assertEquals(6, actualRegisterWithFlagsInternalResult.size());
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Literal"));
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Namespace:Literal"));
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Namespace:foo"));
    assertTrue(actualRegisterWithFlagsInternalResult.contains("foo"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String, String,
   * LiteralCommandNode, String, Collection, Set)}.
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String,
   * String, LiteralCommandNode, String, Collection, Set)}
   */
  @Test
  @DisplayName(
      "Test registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlagsInternal4() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    PaperPluginMeta pluginMeta = new PaperPluginMeta();
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement3 = mock(Predicate.class);

    LiteralCommandNode<CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "Literal",
            command2,
            requirement3,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<CommandSourceStack, Object> redirect2 =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command,
            requirement2,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", null, requirement, redirect2, mock(RedirectModifier.class), true);

    LinkedHashSet<String> aliases = new LinkedHashSet<>();
    aliases.add("Aliases");

    // Act
    Set<String> actualRegisterWithFlagsInternalResult =
        paperCommands.registerWithFlagsInternal(
            pluginMeta,
            "Namespace",
            "Help Namespace Override",
            node,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node.apiCommandMeta.aliases();
    assertEquals(2, aliasesResult.size());
    assertEquals("Aliases", aliasesResult.get(0));
    assertEquals("Namespace:Aliases", aliasesResult.get(1));
    assertEquals(4, actualRegisterWithFlagsInternalResult.size());
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Aliases"));
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Namespace:Aliases"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String, String,
   * LiteralCommandNode, String, Collection, Set)}.
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String,
   * String, LiteralCommandNode, String, Collection, Set)}
   */
  @Test
  @DisplayName(
      "Test registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlagsInternal5() {
    // Arrange
    RootCommandNode<CommandSourceStack> rootCommandNode = new RootCommandNode<>();
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "cannot access the dispatcher in this context",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<CommandSourceStack, Object> node =
        new ArgumentCommandNode<>(
            "cannot access the dispatcher in this context",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    rootCommandNode.addChild(node);
    when(commandDispatcher.getRoot()).thenReturn(rootCommandNode);
    PaperPluginMeta pluginMeta = new PaperPluginMeta();
    Command<CommandSourceStack> command3 = mock(Command.class);
    Predicate<CommandSourceStack> requirement3 = mock(Predicate.class);
    ArgumentType<Object> type2 = mock(ArgumentType.class);
    Command<CommandSourceStack> command4 = mock(Command.class);
    Predicate<CommandSourceStack> requirement4 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect2 =
        new ArgumentCommandNode<>(
            "Name",
            type2,
            command4,
            requirement4,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node2 =
        new LiteralCommandNode<>(
            "Literal", command3, requirement3, redirect2, mock(RedirectModifier.class), true);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterWithFlagsInternalResult =
        paperCommands.registerWithFlagsInternal(
            pluginMeta,
            "Namespace",
            "Help Namespace Override",
            node2,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node2.apiCommandMeta.aliases();
    assertEquals(2, aliasesResult.size());
    assertEquals("Namespace:cannot access the dispatcher in this context", aliasesResult.get(1));
    assertEquals("cannot access the dispatcher in this context", aliasesResult.get(0));
    assertEquals(4, actualRegisterWithFlagsInternalResult.size());
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Literal"));
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Namespace:Literal"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String, String,
   * LiteralCommandNode, String, Collection, Set)}.
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String,
   * String, LiteralCommandNode, String, Collection, Set)}
   */
  @Test
  @DisplayName(
      "Test registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlagsInternal6() {
    // Arrange
    RootCommandNode<CommandSourceStack> rootCommandNode = new RootCommandNode<>();
    BukkitCommandNode node =
        BukkitCommandNode.of(
            "cannot access the dispatcher in this context", new MSPTCommand("Name"));
    rootCommandNode.addChild(node);
    when(commandDispatcher.getRoot()).thenReturn(rootCommandNode);
    PaperPluginMeta pluginMeta = new PaperPluginMeta();
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node2 =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterWithFlagsInternalResult =
        paperCommands.registerWithFlagsInternal(
            pluginMeta,
            "Namespace",
            "Help Namespace Override",
            node2,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node2.apiCommandMeta.aliases();
    assertEquals(1, aliasesResult.size());
    assertEquals("Namespace:cannot access the dispatcher in this context", aliasesResult.get(0));
    assertEquals(3, actualRegisterWithFlagsInternalResult.size());
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Namespace:Literal"));
    assertTrue(
        actualRegisterWithFlagsInternalResult.contains(
            "Namespace:cannot access the dispatcher in this context"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String, String,
   * LiteralCommandNode, String, Collection, Set)}.
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String,
   * String, LiteralCommandNode, String, Collection, Set)}
   */
  @Test
  @DisplayName(
      "Test registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlagsInternal7() {
    // Arrange
    RootCommandNode<CommandSourceStack> rootCommandNode = new RootCommandNode<>();
    BukkitCommandNode node =
        BukkitCommandNode.of(
            "cannot access the dispatcher in this context", new MSPTCommand("Name"));
    rootCommandNode.addChild(node);
    when(commandDispatcher.getRoot()).thenReturn(rootCommandNode);
    PaperPluginMeta pluginMeta = new PaperPluginMeta();
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node2 =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("cannot access the dispatcher in this context");
    aliases.add("cannot access the dispatcher in this context");

    // Act
    Set<String> actualRegisterWithFlagsInternalResult =
        paperCommands.registerWithFlagsInternal(
            pluginMeta,
            "Namespace",
            "Help Namespace Override",
            node2,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    List<String> aliasesResult = node2.apiCommandMeta.aliases();
    assertEquals(1, aliasesResult.size());
    assertEquals("Namespace:cannot access the dispatcher in this context", aliasesResult.get(0));
    assertEquals(3, actualRegisterWithFlagsInternalResult.size());
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Namespace:Literal"));
    assertTrue(
        actualRegisterWithFlagsInternalResult.contains(
            "Namespace:cannot access the dispatcher in this context"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String, String,
   * LiteralCommandNode, String, Collection, Set)}.
   *
   * <ul>
   *   <li>Given {@code FLATTEN_ALIASES}.
   *   <li>When {@link HashSet#HashSet()} add {@code FLATTEN_ALIASES}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String,
   * String, LiteralCommandNode, String, Collection, Set)}
   */
  @Test
  @DisplayName(
      "Test registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set); given 'FLATTEN_ALIASES'; when HashSet() add 'FLATTEN_ALIASES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlagsInternal_givenFlattenAliases_whenHashSetAddFlattenAliases() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    PaperPluginMeta pluginMeta = new PaperPluginMeta();
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);
    ArrayList<String> aliases = new ArrayList<>();

    HashSet<CommandRegistrationFlag> flags = new HashSet<>();
    flags.add(CommandRegistrationFlag.FLATTEN_ALIASES);

    // Act
    Set<String> actualRegisterWithFlagsInternalResult =
        paperCommands.registerWithFlagsInternal(
            pluginMeta,
            "Namespace",
            "Help Namespace Override",
            node,
            "The characteristics of someone or something",
            aliases,
            flags);

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(2, actualRegisterWithFlagsInternalResult.size());
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Literal"));
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Namespace:Literal"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String, String,
   * LiteralCommandNode, String, Collection, Set)}.
   *
   * <ul>
   *   <li>Given {@code SERVER_ONLY}.
   *   <li>When {@link HashSet#HashSet()} add {@code SERVER_ONLY}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String,
   * String, LiteralCommandNode, String, Collection, Set)}
   */
  @Test
  @DisplayName(
      "Test registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set); given 'SERVER_ONLY'; when HashSet() add 'SERVER_ONLY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlagsInternal_givenServerOnly_whenHashSetAddServerOnly() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    PaperPluginMeta pluginMeta = new PaperPluginMeta();
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);
    ArrayList<String> aliases = new ArrayList<>();

    HashSet<CommandRegistrationFlag> flags = new HashSet<>();
    flags.add(CommandRegistrationFlag.SERVER_ONLY);
    flags.add(CommandRegistrationFlag.FLATTEN_ALIASES);

    // Act
    Set<String> actualRegisterWithFlagsInternalResult =
        paperCommands.registerWithFlagsInternal(
            pluginMeta,
            "Namespace",
            "Help Namespace Override",
            node,
            "The characteristics of someone or something",
            aliases,
            flags);

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(2, actualRegisterWithFlagsInternalResult.size());
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Literal"));
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Namespace:Literal"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String, String,
   * LiteralCommandNode, String, Collection, Set)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String,
   * String, LiteralCommandNode, String, Collection, Set)}
   */
  @Test
  @DisplayName(
      "Test registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set); when ArrayList(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlagsInternal_whenArrayList_thenReturnSizeIsTwo() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    PaperPluginMeta pluginMeta = new PaperPluginMeta();
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    ArgumentCommandNode<CommandSourceStack, Object> redirect =
        new ArgumentCommandNode<>(
            "Name",
            type,
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));

    LiteralCommandNode<CommandSourceStack> node =
        new LiteralCommandNode<>(
            "Literal", command, requirement, redirect, mock(RedirectModifier.class), true);
    ArrayList<String> aliases = new ArrayList<>();

    // Act
    Set<String> actualRegisterWithFlagsInternalResult =
        paperCommands.registerWithFlagsInternal(
            pluginMeta,
            "Namespace",
            "Help Namespace Override",
            node,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(2, actualRegisterWithFlagsInternalResult.size());
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Literal"));
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Namespace:Literal"));
  }

  /**
   * Test {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String, String,
   * LiteralCommandNode, String, Collection, Set)}.
   *
   * <ul>
   *   <li>When {@link MSPTCommand#MSPTCommand(String)} with {@code Name}.
   *   <li>Then return contains {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommands#registerWithFlagsInternal(PluginMeta, String,
   * String, LiteralCommandNode, String, Collection, Set)}
   */
  @Test
  @DisplayName(
      "Test registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set); when MSPTCommand(String) with 'Name'; then return contains 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PaperCommands.registerWithFlagsInternal(PluginMeta, String, String, LiteralCommandNode, String, Collection, Set)"
  })
  void testRegisterWithFlagsInternal_whenMSPTCommandWithName_thenReturnContainsName() {
    // Arrange
    when(commandDispatcher.getRoot()).thenReturn(new RootCommandNode<>());
    PaperPluginMeta pluginMeta = new PaperPluginMeta();

    BukkitCommandNode node = BukkitCommandNode.of("Name", new MSPTCommand("Name"));
    ArgumentType<Object> type = mock(ArgumentType.class);
    Command<CommandSourceStack> command = mock(Command.class);
    Predicate<CommandSourceStack> requirement = mock(Predicate.class);
    Command<CommandSourceStack> command2 = mock(Command.class);
    Predicate<CommandSourceStack> requirement2 = mock(Predicate.class);

    LiteralCommandNode<CommandSourceStack> redirect =
        new LiteralCommandNode<>(
            "cannot access the dispatcher in this context",
            command2,
            requirement2,
            new RootCommandNode<>(),
            mock(RedirectModifier.class),
            true);

    ArgumentCommandNode<CommandSourceStack, Object> node2 =
        new ArgumentCommandNode<>(
            "cannot access the dispatcher in this context",
            type,
            command,
            requirement,
            redirect,
            mock(RedirectModifier.class),
            true,
            mock(SuggestionProvider.class));
    node.addChild(node2);
    ArrayList<String> aliases = new ArrayList<>();

    // Act
    Set<String> actualRegisterWithFlagsInternalResult =
        paperCommands.registerWithFlagsInternal(
            pluginMeta,
            "Namespace",
            "Help Namespace Override",
            node,
            "The characteristics of someone or something",
            aliases,
            new HashSet<>());

    // Assert
    verify(commandDispatcher, atLeast(1)).getRoot();
    assertEquals(2, actualRegisterWithFlagsInternalResult.size());
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Name"));
    assertTrue(actualRegisterWithFlagsInternalResult.contains("Namespace:Name"));
  }
}

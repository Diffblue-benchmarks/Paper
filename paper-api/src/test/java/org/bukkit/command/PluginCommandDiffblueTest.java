package org.bukkit.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PluginCommandDiffblueTest {
  /**
   * Test {@link PluginCommand#PluginCommand(String, Plugin)}.
   *
   * <p>Method under test: {@link PluginCommand#PluginCommand(String, Plugin)}
   */
  @Test
  @DisplayName("Test new PluginCommand(String, Plugin)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginCommand.<init>(String, Plugin)"})
  void testNewPluginCommand() {
    // Arrange
    TestPlugin owner = new TestPlugin("Plugin Name");

    // Act
    PluginCommand actualPluginCommand = new PluginCommand("Name", owner);

    // Assert
    CommandExecutor executor = actualPluginCommand.getExecutor();
    assertTrue(executor instanceof TestPlugin);
    assertEquals("", actualPluginCommand.getDescription());
    assertEquals("", actualPluginCommand.getUsage());
    assertEquals("Name", actualPluginCommand.getLabel());
    assertEquals("Name", actualPluginCommand.getName());
    assertEquals("Name", actualPluginCommand.getTimingName());
    assertNull(actualPluginCommand.timings);
    assertNull(actualPluginCommand.getPermission());
    assertNull(actualPluginCommand.getPermissionMessage());
    assertNull(actualPluginCommand.permissionMessage());
    assertNull(actualPluginCommand.getTabCompleter());
    assertFalse(actualPluginCommand.isRegistered());
    assertTrue(actualPluginCommand.getAliases().isEmpty());
    assertSame(owner, executor);
    assertSame(owner, actualPluginCommand.getPlugin());
  }

  /**
   * Test {@link PluginCommand#execute(CommandSender, String, String[])}.
   *
   * <p>Method under test: {@link PluginCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test execute(CommandSender, String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginCommand.execute(CommandSender, String, String[])"})
  void testExecute() {
    // Arrange
    TestPlugin owner = mock(TestPlugin.class);
    when(owner.isEnabled()).thenReturn(true);

    CommandExecutor executor = mock(CommandExecutor.class);
    when(executor.onCommand(
            Mockito.<CommandSender>any(),
            Mockito.<Command>any(),
            Mockito.<String>any(),
            Mockito.<String[]>any()))
        .thenReturn(true);

    PluginCommand pluginCommand = new PluginCommand("Name", owner);
    pluginCommand.setPermission("");
    pluginCommand.setExecutor(executor);
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    boolean actualExecuteResult =
        pluginCommand.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    verify(executor)
        .onCommand(
            isA(CommandSender.class), isA(Command.class), eq("Command Label"), isA(String[].class));
    verify(owner).isEnabled();
    assertEquals("", sender.getBuffer());
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link PluginCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link CommandExecutor} {@link CommandExecutor#onCommand(CommandSender, Command,
   *       String, String[])} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given CommandExecutor onCommand(CommandSender, Command, String, String[]) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenCommandExecutorOnCommandReturnFalse_thenReturnFalse() {
    // Arrange
    TestPlugin owner = mock(TestPlugin.class);
    when(owner.isEnabled()).thenReturn(true);

    CommandExecutor executor = mock(CommandExecutor.class);
    when(executor.onCommand(
            Mockito.<CommandSender>any(),
            Mockito.<Command>any(),
            Mockito.<String>any(),
            Mockito.<String[]>any()))
        .thenReturn(false);

    PluginCommand pluginCommand = new PluginCommand("Name", owner);
    pluginCommand.setExecutor(executor);
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    boolean actualExecuteResult =
        pluginCommand.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    verify(executor)
        .onCommand(
            isA(CommandSender.class), isA(Command.class), eq("Command Label"), isA(String[].class));
    verify(owner).isEnabled();
    assertEquals("", sender.getBuffer());
    assertFalse(actualExecuteResult);
  }

  /**
   * Test {@link PluginCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link CommandSender} {@link CommandSender#hasPermission(String)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given 'false'; when CommandSender hasPermission(String) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenFalse_whenCommandSenderHasPermissionReturnFalse() {
    // Arrange
    TestPlugin owner = mock(TestPlugin.class);
    when(owner.isEnabled()).thenReturn(true);

    Component permissionMessage = mock(Component.class);
    when(permissionMessage.replaceText(Mockito.<TextReplacementConfig>any()))
        .thenReturn(mock(Component.class));

    PluginCommand pluginCommand = new PluginCommand("Name", owner);
    pluginCommand.permissionMessage(permissionMessage);
    pluginCommand.setPermission("<permission>");
    pluginCommand.setExecutor(mock(CommandExecutor.class));

    CommandSender sender = mock(CommandSender.class);
    when(sender.hasPermission(Mockito.<String>any())).thenReturn(false);
    doNothing().when(sender).sendMessage(Mockito.<Component>any());

    // Act
    boolean actualExecuteResult =
        pluginCommand.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    verify(sender).sendMessage(isA(Component.class));
    verify(permissionMessage).replaceText(isA(TextReplacementConfig.class));
    verify(sender).hasPermission("<permission>");
    verify(owner).isEnabled();
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link PluginCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link Style} {@link Style#color()} return {@link TextColor}.
   *   <li>Then {@link BufferedCommandSender} (default constructor) Buffer is lf.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given Style color() return TextColor; then BufferedCommandSender (default constructor) Buffer is lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenStyleColorReturnTextColor_thenBufferedCommandSenderBufferIsLf() {
    // Arrange
    TestPlugin owner = mock(TestPlugin.class);
    when(owner.isEnabled()).thenReturn(true);

    Style style = mock(Style.class);
    when(style.color()).thenReturn(mock(TextColor.class));
    when(style.decoration(Mockito.<TextDecoration>any())).thenReturn(State.NOT_SET);

    Component component = mock(Component.class);
    when(component.children()).thenReturn(new ArrayList<>());
    when(component.style()).thenReturn(style);

    Component permissionMessage = mock(Component.class);
    when(permissionMessage.replaceText(Mockito.<TextReplacementConfig>any())).thenReturn(component);

    PluginCommand pluginCommand = new PluginCommand("Name", owner);
    pluginCommand.permissionMessage(permissionMessage);
    pluginCommand.setPermission(";");
    pluginCommand.setExecutor(mock(CommandExecutor.class));
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    boolean actualExecuteResult =
        pluginCommand.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    verify(component).children();
    verify(permissionMessage).replaceText(isA(TextReplacementConfig.class));
    verify(component).style();
    verify(style).color();
    verify(style, atLeast(1)).decoration(Mockito.<TextDecoration>any());
    verify(owner).isEnabled();
    assertEquals("\n", sender.getBuffer());
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link PluginCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link TestPlugin} {@link TestPlugin#isEnabled()} return {@code false}.
   *   <li>Then calls {@link TestPlugin#getDescription()}.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given TestPlugin isEnabled() return 'false'; then calls getDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenTestPluginIsEnabledReturnFalse_thenCallsGetDescription() {
    // Arrange
    TestPlugin owner = mock(TestPlugin.class);
    when(owner.isEnabled()).thenReturn(false);
    PluginDescriptionFile pluginDescriptionFile =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");
    when(owner.getDescription()).thenReturn(pluginDescriptionFile);

    PluginCommand pluginCommand = new PluginCommand("Name", owner);
    pluginCommand.setExecutor(mock(CommandExecutor.class));

    // Act and Assert
    assertThrows(
        CommandException.class,
        () ->
            pluginCommand.execute(
                new BufferedCommandSender(), "Command Label", new String[] {"Args"}));
    verify(owner).getDescription();
    verify(owner).isEnabled();
  }

  /**
   * Test {@link PluginCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link TestPlugin} {@link TestPlugin#isEnabled()} throw {@link
   *       CommandException#CommandException(String)} with {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given TestPlugin isEnabled() throw CommandException(String) with 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenTestPluginIsEnabledThrowCommandExceptionWithMsg() {
    // Arrange
    TestPlugin owner = mock(TestPlugin.class);
    when(owner.isEnabled()).thenThrow(new CommandException("Msg"));
    PluginCommand pluginCommand = new PluginCommand("Name", owner);

    // Act and Assert
    assertThrows(
        CommandException.class,
        () ->
            pluginCommand.execute(
                new BufferedCommandSender(), "Command Label", new String[] {"Args"}));
    verify(owner).isEnabled();
  }

  /**
   * Test {@link PluginCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link TestPlugin} {@link TestPlugin#onCommand(CommandSender, Command, String,
   *       String[])} return {@code true}.
   *   <li>Then calls {@link TestPlugin#onCommand(CommandSender, Command, String, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given TestPlugin onCommand(CommandSender, Command, String, String[]) return 'true'; then calls onCommand(CommandSender, Command, String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenTestPluginOnCommandReturnTrue_thenCallsOnCommand() {
    // Arrange
    TestPlugin owner = mock(TestPlugin.class);
    when(owner.onCommand(
            Mockito.<CommandSender>any(),
            Mockito.<Command>any(),
            Mockito.<String>any(),
            Mockito.<String[]>any()))
        .thenReturn(true);
    when(owner.isEnabled()).thenReturn(true);
    PluginCommand pluginCommand = new PluginCommand("Name", owner);
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    boolean actualExecuteResult =
        pluginCommand.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    verify(owner).isEnabled();
    verify(owner)
        .onCommand(
            isA(CommandSender.class), isA(Command.class), eq("Command Label"), isA(String[].class));
    assertEquals("", sender.getBuffer());
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link PluginCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link TestPlugin#TestPlugin(String)} with {@code Plugin Name} Enabled is {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given TestPlugin(String) with 'Plugin Name' Enabled is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenTestPluginWithPluginNameEnabledIsFalse() {
    // Arrange
    TestPlugin owner = new TestPlugin("Plugin Name");
    owner.setEnabled(false);
    PluginCommand pluginCommand = new PluginCommand("Name", owner);

    // Act and Assert
    assertThrows(
        CommandException.class,
        () ->
            pluginCommand.execute(
                new BufferedCommandSender(), "Command Label", new String[] {"Args"}));
  }

  /**
   * Test {@link PluginCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link TestPlugin#TestPlugin(String)} with {@code Plugin Name}.
   *   <li>Then throw {@link CommandException}.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given TestPlugin(String) with 'Plugin Name'; then throw CommandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenTestPluginWithPluginName_thenThrowCommandException() {
    // Arrange
    PluginCommand pluginCommand = new PluginCommand("Name", new TestPlugin("Plugin Name"));

    // Act and Assert
    assertThrows(
        CommandException.class,
        () ->
            pluginCommand.execute(
                new BufferedCommandSender(), "Command Label", new String[] {"Args"}));
  }

  /**
   * Test {@link PluginCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link CommandSender} {@link CommandSender#hasPermission(String)} return {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given 'true'; when CommandSender hasPermission(String) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenTrue_whenCommandSenderHasPermissionReturnTrue() {
    // Arrange
    TestPlugin owner = mock(TestPlugin.class);
    when(owner.isEnabled()).thenReturn(true);

    CommandExecutor executor = mock(CommandExecutor.class);
    when(executor.onCommand(
            Mockito.<CommandSender>any(),
            Mockito.<Command>any(),
            Mockito.<String>any(),
            Mockito.<String[]>any()))
        .thenReturn(true);

    PluginCommand pluginCommand = new PluginCommand("Name", owner);
    pluginCommand.permissionMessage(mock(Component.class));
    pluginCommand.setPermission("<permission>");
    pluginCommand.setExecutor(executor);

    CommandSender sender = mock(CommandSender.class);
    when(sender.hasPermission(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualExecuteResult =
        pluginCommand.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    verify(executor)
        .onCommand(
            isA(CommandSender.class), isA(Command.class), eq("Command Label"), isA(String[].class));
    verify(sender).hasPermission("<permission>");
    verify(owner).isEnabled();
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link PluginCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Then {@link BufferedCommandSender} (default constructor) Buffer is {@code ;}.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); then BufferedCommandSender (default constructor) Buffer is ';'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginCommand.execute(CommandSender, String, String[])"})
  void testExecute_thenBufferedCommandSenderBufferIsSemicolon() {
    // Arrange
    TestPlugin owner = mock(TestPlugin.class);
    when(owner.isEnabled()).thenReturn(true);

    PluginCommand pluginCommand = new PluginCommand("Name", owner);
    pluginCommand.setPermissionMessage(";");
    pluginCommand.setPermission(";");
    pluginCommand.setExecutor(mock(CommandExecutor.class));
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    boolean actualExecuteResult =
        pluginCommand.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    verify(owner).isEnabled();
    assertEquals(";\n", sender.getBuffer());
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link PluginCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Then {@link BufferedCommandSender} (default constructor) Buffer is {@code Usage}.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); then BufferedCommandSender (default constructor) Buffer is 'Usage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginCommand.execute(CommandSender, String, String[])"})
  void testExecute_thenBufferedCommandSenderBufferIsUsage() {
    // Arrange
    TestPlugin owner = mock(TestPlugin.class);
    when(owner.isEnabled()).thenReturn(true);

    CommandExecutor executor = mock(CommandExecutor.class);
    when(executor.onCommand(
            Mockito.<CommandSender>any(),
            Mockito.<Command>any(),
            Mockito.<String>any(),
            Mockito.<String[]>any()))
        .thenReturn(false);

    PluginCommand pluginCommand = new PluginCommand("Name", owner);
    pluginCommand.setUsage("Usage");
    pluginCommand.setExecutor(executor);
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    boolean actualExecuteResult =
        pluginCommand.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    verify(executor)
        .onCommand(
            isA(CommandSender.class), isA(Command.class), eq("Command Label"), isA(String[].class));
    verify(owner).isEnabled();
    assertEquals("Usage\n", sender.getBuffer());
    assertFalse(actualExecuteResult);
  }

  /**
   * Test {@link PluginCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Then calls {@link TestPlugin#getDescription()}.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test execute(CommandSender, String, String[]); then calls getDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginCommand.execute(CommandSender, String, String[])"})
  void testExecute_thenCallsGetDescription() {
    // Arrange
    TestPlugin owner = mock(TestPlugin.class);
    when(owner.onCommand(
            Mockito.<CommandSender>any(),
            Mockito.<Command>any(),
            Mockito.<String>any(),
            Mockito.<String[]>any()))
        .thenThrow(new CommandException("Msg"));
    when(owner.isEnabled()).thenReturn(true);
    PluginDescriptionFile pluginDescriptionFile =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");
    when(owner.getDescription()).thenReturn(pluginDescriptionFile);
    PluginCommand pluginCommand = new PluginCommand("Name", owner);

    // Act and Assert
    assertThrows(
        CommandException.class,
        () ->
            pluginCommand.execute(
                new BufferedCommandSender(), "Command Label", new String[] {"Args"}));
    verify(owner).getDescription();
    verify(owner).isEnabled();
    verify(owner)
        .onCommand(
            isA(CommandSender.class), isA(Command.class), eq("Command Label"), isA(String[].class));
  }

  /**
   * Test {@link PluginCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When {@link CommandSender} {@link CommandSender#sendMessage(Component)} does nothing.
   *   <li>Then calls {@link CommandSender#sendMessage(Component)}.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when CommandSender sendMessage(Component) does nothing; then calls sendMessage(Component)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenCommandSenderSendMessageDoesNothing_thenCallsSendMessage() {
    // Arrange
    TestPlugin owner = mock(TestPlugin.class);
    when(owner.isEnabled()).thenReturn(true);

    Component permissionMessage = mock(Component.class);
    when(permissionMessage.replaceText(Mockito.<TextReplacementConfig>any()))
        .thenReturn(mock(Component.class));

    PluginCommand pluginCommand = new PluginCommand("Name", owner);
    pluginCommand.permissionMessage(permissionMessage);
    pluginCommand.setPermission(";");
    pluginCommand.setExecutor(mock(CommandExecutor.class));

    CommandSender sender = mock(CommandSender.class);
    doNothing().when(sender).sendMessage(Mockito.<Component>any());

    // Act
    boolean actualExecuteResult =
        pluginCommand.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    verify(sender).sendMessage(isA(Component.class));
    verify(permissionMessage).replaceText(isA(TextReplacementConfig.class));
    verify(owner).isEnabled();
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link PluginCommand#setExecutor(CommandExecutor)}.
   *
   * <p>Method under test: {@link PluginCommand#setExecutor(CommandExecutor)}
   */
  @Test
  @DisplayName("Test setExecutor(CommandExecutor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginCommand.setExecutor(CommandExecutor)"})
  void testSetExecutor() {
    // Arrange
    TestPlugin owner = new TestPlugin("Plugin Name");
    PluginCommand pluginCommand = new PluginCommand("Name", owner);
    CommandExecutor executor = mock(CommandExecutor.class);

    // Act
    pluginCommand.setExecutor(executor);

    // Assert
    assertSame(owner, pluginCommand.getPlugin());
    assertSame(executor, pluginCommand.getExecutor());
  }

  /**
   * Test {@link PluginCommand#setExecutor(CommandExecutor)}.
   *
   * <ul>
   *   <li>Then {@link PluginCommand#PluginCommand(String, Plugin)} with {@code Name} and owner is
   *       {@link TestPlugin#TestPlugin(String)} Executor {@link TestPlugin}.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#setExecutor(CommandExecutor)}
   */
  @Test
  @DisplayName(
      "Test setExecutor(CommandExecutor); then PluginCommand(String, Plugin) with 'Name' and owner is TestPlugin(String) Executor TestPlugin")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginCommand.setExecutor(CommandExecutor)"})
  void testSetExecutor_thenPluginCommandWithNameAndOwnerIsTestPluginExecutorTestPlugin() {
    // Arrange
    TestPlugin owner = new TestPlugin("Plugin Name");
    PluginCommand pluginCommand = new PluginCommand("Name", owner);

    // Act
    pluginCommand.setExecutor(null);

    // Assert that nothing has changed
    CommandExecutor executor = pluginCommand.getExecutor();
    assertTrue(executor instanceof TestPlugin);
    assertSame(owner, executor);
    assertSame(owner, pluginCommand.getPlugin());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PluginCommand#setTabCompleter(TabCompleter)}
   *   <li>{@link PluginCommand#toString()}
   *   <li>{@link PluginCommand#getExecutor()}
   *   <li>{@link PluginCommand#getPlugin()}
   *   <li>{@link PluginCommand#getTabCompleter()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommandExecutor PluginCommand.getExecutor()",
    "Plugin PluginCommand.getPlugin()",
    "TabCompleter PluginCommand.getTabCompleter()",
    "void PluginCommand.setTabCompleter(TabCompleter)",
    "String PluginCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TestPlugin owner = new TestPlugin("Plugin Name");
    PluginCommand pluginCommand = new PluginCommand("Name", owner);
    TabCompleter completer = mock(TabCompleter.class);

    // Act
    pluginCommand.setTabCompleter(completer);
    String actualToStringResult = pluginCommand.toString();
    CommandExecutor actualExecutor = pluginCommand.getExecutor();
    Plugin actualPlugin = pluginCommand.getPlugin();

    // Assert
    assertEquals("org.bukkit.command.PluginCommand(Name, Plugin_Name v1.0)", actualToStringResult);
    assertSame(owner, actualExecutor);
    assertSame(owner, actualPlugin);
    assertSame(completer, pluginCommand.getTabCompleter());
  }

  /**
   * Test {@link PluginCommand#tabComplete(CommandSender, String, String[])} with {@code sender},
   * {@code alias}, {@code args}.
   *
   * <p>Method under test: {@link PluginCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PluginCommand.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs() throws IllegalArgumentException, CommandException {
    // Arrange
    PluginCommand pluginCommand = new PluginCommand("Name", new TestPlugin("Plugin Name"));

    // Act and Assert
    assertThrows(
        CommandException.class,
        () ->
            pluginCommand.tabComplete(new BufferedCommandSender(), "Alias", new String[] {"Args"}));
  }

  /**
   * Test {@link PluginCommand#tabComplete(CommandSender, String, String[])} with {@code sender},
   * {@code alias}, {@code args}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PluginCommand.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs_thenReturnEmpty()
      throws IllegalArgumentException, CommandException {
    // Arrange
    TabCompleter completer = mock(TabCompleter.class);
    when(completer.onTabComplete(
            Mockito.<CommandSender>any(),
            Mockito.<Command>any(),
            Mockito.<String>any(),
            Mockito.<String[]>any()))
        .thenReturn(new ArrayList<>());

    PluginCommand pluginCommand = new PluginCommand("Name", new TestPlugin("Plugin Name"));
    pluginCommand.setTabCompleter(completer);

    // Act
    List<String> actualTabCompleteResult =
        pluginCommand.tabComplete(new BufferedCommandSender(), "Alias", new String[] {"Args"});

    // Assert
    verify(completer)
        .onTabComplete(
            isA(CommandSender.class), isA(Command.class), eq("Alias"), isA(String[].class));
    assertTrue(actualTabCompleteResult.isEmpty());
  }

  /**
   * Test {@link PluginCommand#tabComplete(CommandSender, String, String[])} with {@code sender},
   * {@code alias}, {@code args}.
   *
   * <ul>
   *   <li>Then throw {@link CommandException}.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'; then throw CommandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PluginCommand.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs_thenThrowCommandException()
      throws IllegalArgumentException, CommandException {
    // Arrange
    TabCompleter completer = mock(TabCompleter.class);
    when(completer.onTabComplete(
            Mockito.<CommandSender>any(),
            Mockito.<Command>any(),
            Mockito.<String>any(),
            Mockito.<String[]>any()))
        .thenThrow(new CommandException("Sender cannot be null"));

    PluginCommand pluginCommand = new PluginCommand("Name", new TestPlugin("Plugin Name"));
    pluginCommand.setTabCompleter(completer);

    // Act and Assert
    assertThrows(
        CommandException.class,
        () ->
            pluginCommand.tabComplete(new BufferedCommandSender(), "Alias", new String[] {"Args"}));
    verify(completer)
        .onTabComplete(
            isA(CommandSender.class), isA(Command.class), eq("Alias"), isA(String[].class));
  }
}

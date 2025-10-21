package org.bukkit.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.command.defaults.HelpCommand;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MultipleCommandAliasDiffblueTest {
  /**
   * Test {@link MultipleCommandAlias#MultipleCommandAlias(String, Command[])}.
   *
   * <p>Method under test: {@link MultipleCommandAlias#MultipleCommandAlias(String, Command[])}
   */
  @Test
  @DisplayName("Test new MultipleCommandAlias(String, Command[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultipleCommandAlias.<init>(String, Command[])"})
  void testNewMultipleCommandAlias() {
    // Arrange
    Command[] commands = new Command[] {new HelpCommand()};

    // Act
    MultipleCommandAlias actualMultipleCommandAlias = new MultipleCommandAlias("Name", commands);

    // Assert
    assertEquals("", actualMultipleCommandAlias.getDescription());
    assertEquals("/Name", actualMultipleCommandAlias.getUsage());
    assertEquals("Name", actualMultipleCommandAlias.getLabel());
    assertEquals("Name", actualMultipleCommandAlias.getName());
    assertEquals("Name", actualMultipleCommandAlias.getTimingName());
    assertNull(actualMultipleCommandAlias.timings);
    assertNull(actualMultipleCommandAlias.getPermission());
    assertNull(actualMultipleCommandAlias.getPermissionMessage());
    assertNull(actualMultipleCommandAlias.permissionMessage());
    Command[] commands2 = actualMultipleCommandAlias.getCommands();
    assertEquals(1, commands2.length);
    assertFalse(actualMultipleCommandAlias.isRegistered());
    assertTrue(actualMultipleCommandAlias.getAliases().isEmpty());
    assertSame(commands, commands2);
  }

  /**
   * Test {@link MultipleCommandAlias#getCommands()}.
   *
   * <p>Method under test: {@link MultipleCommandAlias#getCommands()}
   */
  @Test
  @DisplayName("Test getCommands()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command[] MultipleCommandAlias.getCommands()"})
  void testGetCommands() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    Command[] commands = new Command[] {helpCommand};
    MultipleCommandAlias multipleCommandAlias = new MultipleCommandAlias("Name", commands);

    // Act
    Command[] actualCommands = multipleCommandAlias.getCommands();

    // Assert
    assertEquals(1, actualCommands.length);
    assertSame(helpCommand, actualCommands[0]);
  }

  /**
   * Test {@link MultipleCommandAlias#execute(CommandSender, String, String[])}.
   *
   * <p>Method under test: {@link MultipleCommandAlias#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test execute(CommandSender, String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleCommandAlias.execute(CommandSender, String, String[])"})
  void testExecute() {
    // Arrange
    FormattedCommandAlias formattedCommandAlias = new FormattedCommandAlias(";", new String[] {});
    Command[] commands = new Command[] {formattedCommandAlias};
    MultipleCommandAlias multipleCommandAlias = new MultipleCommandAlias("Name", commands);
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    boolean actualExecuteResult =
        multipleCommandAlias.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    assertEquals("", sender.getBuffer());
    assertFalse(actualExecuteResult);
  }

  /**
   * Test {@link MultipleCommandAlias#execute(CommandSender, String, String[])}.
   *
   * <p>Method under test: {@link MultipleCommandAlias#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test execute(CommandSender, String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleCommandAlias.execute(CommandSender, String, String[])"})
  void testExecute2() {
    // Arrange
    FormattedCommandAlias formattedCommandAlias =
        new FormattedCommandAlias(";", new String[] {"$sender", "Format Strings"});
    Command[] commands = new Command[] {formattedCommandAlias};
    MultipleCommandAlias multipleCommandAlias = new MultipleCommandAlias("Name", commands);
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    boolean actualExecuteResult =
        multipleCommandAlias.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    assertEquals(
        "§cAn internal error occurred while attempting to perform this command\n",
        sender.getBuffer());
    assertFalse(actualExecuteResult);
  }

  /**
   * Test {@link MultipleCommandAlias#execute(CommandSender, String, String[])}.
   *
   * <p>Method under test: {@link MultipleCommandAlias#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test execute(CommandSender, String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleCommandAlias.execute(CommandSender, String, String[])"})
  void testExecute3() {
    // Arrange
    MultipleCommandAlias multipleCommandAlias = new MultipleCommandAlias(";", new Command[] {});
    Command[] commands = new Command[] {multipleCommandAlias};
    MultipleCommandAlias multipleCommandAlias2 = new MultipleCommandAlias("Name", commands);
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    boolean actualExecuteResult =
        multipleCommandAlias2.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    assertEquals("", sender.getBuffer());
    assertFalse(actualExecuteResult);
  }

  /**
   * Test {@link MultipleCommandAlias#execute(CommandSender, String, String[])}.
   *
   * <p>Method under test: {@link MultipleCommandAlias#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test execute(CommandSender, String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleCommandAlias.execute(CommandSender, String, String[])"})
  void testExecute4() {
    // Arrange
    CommandExecutor executor = mock(CommandExecutor.class);
    when(executor.onCommand(
            Mockito.<CommandSender>any(),
            Mockito.<Command>any(),
            Mockito.<String>any(),
            Mockito.<String[]>any()))
        .thenReturn(true);

    PluginCommand pluginCommand = new PluginCommand(";", new TestPlugin(";"));
    pluginCommand.setPermission("");
    pluginCommand.setExecutor(executor);
    Command[] commands = new Command[] {pluginCommand};
    MultipleCommandAlias multipleCommandAlias = new MultipleCommandAlias("Name", commands);
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    boolean actualExecuteResult =
        multipleCommandAlias.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    verify(executor)
        .onCommand(
            isA(CommandSender.class), isA(Command.class), eq("Command Label"), isA(String[].class));
    assertEquals("", sender.getBuffer());
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link MultipleCommandAlias#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link CommandExecutor} {@link CommandExecutor#onCommand(CommandSender, Command,
   *       String, String[])} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleCommandAlias#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given CommandExecutor onCommand(CommandSender, Command, String, String[]) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleCommandAlias.execute(CommandSender, String, String[])"})
  void testExecute_givenCommandExecutorOnCommandReturnTrue_thenReturnTrue() {
    // Arrange
    CommandExecutor executor = mock(CommandExecutor.class);
    when(executor.onCommand(
            Mockito.<CommandSender>any(),
            Mockito.<Command>any(),
            Mockito.<String>any(),
            Mockito.<String[]>any()))
        .thenReturn(true);

    PluginCommand pluginCommand = new PluginCommand(";", new TestPlugin(";"));
    pluginCommand.setExecutor(executor);
    Command[] commands = new Command[] {pluginCommand};
    MultipleCommandAlias multipleCommandAlias = new MultipleCommandAlias("Name", commands);
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    boolean actualExecuteResult =
        multipleCommandAlias.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    verify(executor)
        .onCommand(
            isA(CommandSender.class), isA(Command.class), eq("Command Label"), isA(String[].class));
    assertEquals("", sender.getBuffer());
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link MultipleCommandAlias#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link MultipleCommandAlias#MultipleCommandAlias(String, Command[])} with {@code
   *       Name} and commands is empty array of {@link Command}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleCommandAlias#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given MultipleCommandAlias(String, Command[]) with 'Name' and commands is empty array of Command")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleCommandAlias.execute(CommandSender, String, String[])"})
  void testExecute_givenMultipleCommandAliasWithNameAndCommandsIsEmptyArrayOfCommand() {
    // Arrange
    MultipleCommandAlias multipleCommandAlias = new MultipleCommandAlias("Name", new Command[] {});
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    boolean actualExecuteResult =
        multipleCommandAlias.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    assertEquals("", sender.getBuffer());
    assertFalse(actualExecuteResult);
  }
}

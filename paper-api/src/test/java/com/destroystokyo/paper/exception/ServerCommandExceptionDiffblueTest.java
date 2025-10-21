package com.destroystokyo.paper.exception;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.HelpCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerCommandExceptionDiffblueTest {
  /**
   * Test {@link ServerCommandException#ServerCommandException(String, Throwable, Command,
   * CommandSender, String[])}.
   *
   * <ul>
   *   <li>Then CommandSender return {@link BufferedCommandSender}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCommandException#ServerCommandException(String, Throwable,
   * Command, CommandSender, String[])}
   */
  @Test
  @DisplayName(
      "Test new ServerCommandException(String, Throwable, Command, CommandSender, String[]); then CommandSender return BufferedCommandSender")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCommandException.<init>(String, Throwable, Command, CommandSender, String[])"
  })
  void testNewServerCommandException_thenCommandSenderReturnBufferedCommandSender() {
    // Arrange
    Throwable cause = new Throwable();
    HelpCommand command = new HelpCommand();
    BufferedCommandSender commandSender = new BufferedCommandSender();
    String[] arguments = new String[] {"Arguments"};

    // Act
    ServerCommandException actualServerCommandException =
        new ServerCommandException("An error occurred", cause, command, commandSender, arguments);

    // Assert
    CommandSender commandSender2 = actualServerCommandException.getCommandSender();
    assertTrue(commandSender2 instanceof BufferedCommandSender);
    Command command2 = actualServerCommandException.getCommand();
    assertTrue(command2 instanceof HelpCommand);
    assertEquals("An error occurred", actualServerCommandException.getLocalizedMessage());
    assertEquals("An error occurred", actualServerCommandException.getMessage());
    assertEquals(0, actualServerCommandException.getSuppressed().length);
    assertSame(cause, actualServerCommandException.getCause());
    assertSame(commandSender, commandSender2);
    assertSame(command, command2);
    assertSame(arguments, actualServerCommandException.getArguments());
  }

  /**
   * Test {@link ServerCommandException#ServerCommandException(String, Throwable, boolean, boolean,
   * Command, CommandSender, String[])}.
   *
   * <ul>
   *   <li>Then CommandSender return {@link BufferedCommandSender}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCommandException#ServerCommandException(String, Throwable,
   * boolean, boolean, Command, CommandSender, String[])}
   */
  @Test
  @DisplayName(
      "Test new ServerCommandException(String, Throwable, boolean, boolean, Command, CommandSender, String[]); then CommandSender return BufferedCommandSender")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCommandException.<init>(String, Throwable, boolean, boolean, Command, CommandSender, String[])"
  })
  void testNewServerCommandException_thenCommandSenderReturnBufferedCommandSender2() {
    // Arrange
    Throwable cause = new Throwable();
    HelpCommand command = new HelpCommand();
    BufferedCommandSender commandSender = new BufferedCommandSender();
    String[] arguments = new String[] {"Arguments"};

    // Act
    ServerCommandException actualServerCommandException =
        new ServerCommandException(
            "An error occurred", cause, true, true, command, commandSender, arguments);

    // Assert
    CommandSender commandSender2 = actualServerCommandException.getCommandSender();
    assertTrue(commandSender2 instanceof BufferedCommandSender);
    Command command2 = actualServerCommandException.getCommand();
    assertTrue(command2 instanceof HelpCommand);
    assertEquals("An error occurred", actualServerCommandException.getLocalizedMessage());
    assertEquals("An error occurred", actualServerCommandException.getMessage());
    assertEquals(0, actualServerCommandException.getSuppressed().length);
    assertSame(cause, actualServerCommandException.getCause());
    assertSame(commandSender, commandSender2);
    assertSame(command, command2);
    assertSame(arguments, actualServerCommandException.getArguments());
  }

  /**
   * Test {@link ServerCommandException#ServerCommandException(Throwable, Command, CommandSender,
   * String[])}.
   *
   * <ul>
   *   <li>Then CommandSender return {@link BufferedCommandSender}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCommandException#ServerCommandException(Throwable, Command,
   * CommandSender, String[])}
   */
  @Test
  @DisplayName(
      "Test new ServerCommandException(Throwable, Command, CommandSender, String[]); then CommandSender return BufferedCommandSender")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCommandException.<init>(Throwable, Command, CommandSender, String[])"
  })
  void testNewServerCommandException_thenCommandSenderReturnBufferedCommandSender3() {
    // Arrange
    Throwable cause = new Throwable();
    HelpCommand command = new HelpCommand();
    BufferedCommandSender commandSender = new BufferedCommandSender();
    String[] arguments = new String[] {"Arguments"};

    // Act
    ServerCommandException actualServerCommandException =
        new ServerCommandException(cause, command, commandSender, arguments);

    // Assert
    CommandSender commandSender2 = actualServerCommandException.getCommandSender();
    assertTrue(commandSender2 instanceof BufferedCommandSender);
    Command command2 = actualServerCommandException.getCommand();
    assertTrue(command2 instanceof HelpCommand);
    assertEquals("java.lang.Throwable", actualServerCommandException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualServerCommandException.getMessage());
    assertEquals(0, actualServerCommandException.getSuppressed().length);
    assertSame(cause, actualServerCommandException.getCause());
    assertSame(commandSender, commandSender2);
    assertSame(command, command2);
    assertSame(arguments, actualServerCommandException.getArguments());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ServerCommandException#getArguments()}
   *   <li>{@link ServerCommandException#getCommand()}
   *   <li>{@link ServerCommandException#getCommandSender()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String[] ServerCommandException.getArguments()",
    "Command ServerCommandException.getCommand()",
    "CommandSender ServerCommandException.getCommandSender()"
  })
  void testGettersAndSetters() {
    // Arrange
    Throwable cause = new Throwable();
    HelpCommand command = new HelpCommand();
    BufferedCommandSender commandSender = new BufferedCommandSender();
    String[] arguments = new String[] {"Arguments"};

    ServerCommandException serverCommandException =
        new ServerCommandException(cause, command, commandSender, arguments);

    // Act
    String[] actualArguments = serverCommandException.getArguments();
    Command actualCommand = serverCommandException.getCommand();

    // Assert
    assertSame(commandSender, serverCommandException.getCommandSender());
    assertSame(command, actualCommand);
    assertArrayEquals(new String[] {"Arguments"}, actualArguments);
  }
}

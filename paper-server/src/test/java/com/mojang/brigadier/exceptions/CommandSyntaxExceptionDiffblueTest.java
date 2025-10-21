package com.mojang.brigadier.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.brigadier.Message;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CommandSyntaxExceptionDiffblueTest {
  /**
   * Test {@link CommandSyntaxException#CommandSyntaxException(CommandExceptionType, Message)}.
   *
   * <p>Method under test: {@link
   * CommandSyntaxException#CommandSyntaxException(CommandExceptionType, Message)}
   */
  @Test
  @DisplayName("Test new CommandSyntaxException(CommandExceptionType, Message)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandSyntaxException.<init>(CommandExceptionType, Message)"})
  void testNewCommandSyntaxException() {
    // Arrange
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");

    // Act
    CommandSyntaxException actualCommandSyntaxException = new CommandSyntaxException(type, message);

    // Assert
    verify(message).getString();
    CommandExceptionType type2 = actualCommandSyntaxException.getType();
    assertTrue(type2 instanceof Dynamic2CommandExceptionType);
    assertEquals("String", actualCommandSyntaxException.getMessage());
    assertEquals("String", actualCommandSyntaxException.getLocalizedMessage());
    assertNull(actualCommandSyntaxException.getContext());
    assertNull(actualCommandSyntaxException.getInput());
    assertNull(actualCommandSyntaxException.getCause());
    assertEquals(-1, actualCommandSyntaxException.getCursor());
    assertEquals(0, actualCommandSyntaxException.getSuppressed().length);
    assertSame(type, type2);
    assertSame(message, actualCommandSyntaxException.getRawMessage());
  }

  /**
   * Test {@link CommandSyntaxException#CommandSyntaxException(CommandExceptionType, Message,
   * String, int)}.
   *
   * <p>Method under test: {@link
   * CommandSyntaxException#CommandSyntaxException(CommandExceptionType, Message, String, int)}
   */
  @Test
  @DisplayName("Test new CommandSyntaxException(CommandExceptionType, Message, String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CommandSyntaxException.<init>(CommandExceptionType, Message, String, int)"
  })
  void testNewCommandSyntaxException2() {
    // Arrange
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");

    // Act
    CommandSyntaxException actualCommandSyntaxException =
        new CommandSyntaxException(type, message, "Input", 1);

    // Assert
    verify(message).getString();
    CommandExceptionType type2 = actualCommandSyntaxException.getType();
    assertTrue(type2 instanceof Dynamic2CommandExceptionType);
    assertEquals("I<--[HERE]", actualCommandSyntaxException.getContext());
    assertEquals("Input", actualCommandSyntaxException.getInput());
    assertEquals("String at position 1: I<--[HERE]", actualCommandSyntaxException.getMessage());
    assertEquals(
        "String at position 1: I<--[HERE]", actualCommandSyntaxException.getLocalizedMessage());
    assertNull(actualCommandSyntaxException.getCause());
    assertEquals(0, actualCommandSyntaxException.getSuppressed().length);
    assertEquals(1, actualCommandSyntaxException.getCursor());
    assertSame(type, type2);
    assertSame(message, actualCommandSyntaxException.getRawMessage());
  }

  /**
   * Test {@link CommandSyntaxException#getMessage()}.
   *
   * <p>Method under test: {@link CommandSyntaxException#getMessage()}
   */
  @Test
  @DisplayName("Test getMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CommandSyntaxException.getMessage()"})
  void testGetMessage() {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    CommandSyntaxException commandSyntaxException = new CommandSyntaxException(type, message);

    // Act
    String actualMessage = commandSyntaxException.getMessage();

    // Assert
    verify(message, atLeast(1)).getString();
    assertEquals("String", actualMessage);
  }

  /**
   * Test {@link CommandSyntaxException#getMessage()}.
   *
   * <p>Method under test: {@link CommandSyntaxException#getMessage()}
   */
  @Test
  @DisplayName("Test getMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CommandSyntaxException.getMessage()"})
  void testGetMessage2() {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    CommandSyntaxException commandSyntaxException =
        new CommandSyntaxException(type, message, "Input", -1);

    // Act
    String actualMessage = commandSyntaxException.getMessage();

    // Assert
    verify(message, atLeast(1)).getString();
    assertEquals("String", actualMessage);
  }

  /**
   * Test {@link CommandSyntaxException#getMessage()}.
   *
   * <ul>
   *   <li>Then return {@code String at position 1: I<--[HERE]}.
   * </ul>
   *
   * <p>Method under test: {@link CommandSyntaxException#getMessage()}
   */
  @Test
  @DisplayName("Test getMessage(); then return 'String at position 1: I<--[HERE]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CommandSyntaxException.getMessage()"})
  void testGetMessage_thenReturnStringAtPosition1IHere() {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    CommandSyntaxException commandSyntaxException =
        new CommandSyntaxException(type, message, "Input", 1);

    // Act
    String actualMessage = commandSyntaxException.getMessage();

    // Assert
    verify(message, atLeast(1)).getString();
    assertEquals("String at position 1: I<--[HERE]", actualMessage);
  }

  /**
   * Test {@link CommandSyntaxException#getContext()}.
   *
   * <p>Method under test: {@link CommandSyntaxException#getContext()}
   */
  @Test
  @DisplayName("Test getContext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CommandSyntaxException.getContext()"})
  void testGetContext() {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    CommandSyntaxException commandSyntaxException = new CommandSyntaxException(type, message);

    // Act
    String actualContext = commandSyntaxException.getContext();

    // Assert
    verify(message).getString();
    assertNull(actualContext);
  }

  /**
   * Test {@link CommandSyntaxException#getContext()}.
   *
   * <p>Method under test: {@link CommandSyntaxException#getContext()}
   */
  @Test
  @DisplayName("Test getContext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CommandSyntaxException.getContext()"})
  void testGetContext2() {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    CommandSyntaxException commandSyntaxException =
        new CommandSyntaxException(type, message, "Input", -1);

    // Act
    String actualContext = commandSyntaxException.getContext();

    // Assert
    verify(message).getString();
    assertNull(actualContext);
  }

  /**
   * Test {@link CommandSyntaxException#getContext()}.
   *
   * <ul>
   *   <li>Then return {@code I<--[HERE]}.
   * </ul>
   *
   * <p>Method under test: {@link CommandSyntaxException#getContext()}
   */
  @Test
  @DisplayName("Test getContext(); then return 'I<--[HERE]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CommandSyntaxException.getContext()"})
  void testGetContext_thenReturnIHere() {
    // Arrange
    Message message = mock(Message.class);
    when(message.getString()).thenReturn("String");
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));

    CommandSyntaxException commandSyntaxException =
        new CommandSyntaxException(type, message, "Input", 1);

    // Act
    String actualContext = commandSyntaxException.getContext();

    // Assert
    verify(message).getString();
    assertEquals("I<--[HERE]", actualContext);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CommandSyntaxException#getCursor()}
   *   <li>{@link CommandSyntaxException#getInput()}
   *   <li>{@link CommandSyntaxException#getRawMessage()}
   *   <li>{@link CommandSyntaxException#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int CommandSyntaxException.getCursor()",
    "String CommandSyntaxException.getInput()",
    "Message CommandSyntaxException.getRawMessage()",
    "CommandExceptionType CommandSyntaxException.getType()"
  })
  void testGettersAndSetters() {
    // Arrange
    Dynamic2CommandExceptionType type = new Dynamic2CommandExceptionType(mock(Function.class));
    CommandSyntaxException commandSyntaxException =
        new CommandSyntaxException(type, mock(Message.class));

    // Act
    int actualCursor = commandSyntaxException.getCursor();
    String actualInput = commandSyntaxException.getInput();
    commandSyntaxException.getRawMessage();
    CommandExceptionType actualType = commandSyntaxException.getType();

    // Assert
    assertTrue(actualType instanceof Dynamic2CommandExceptionType);
    assertNull(actualInput);
    assertEquals(-1, actualCursor);
    assertSame(type, actualType);
  }
}

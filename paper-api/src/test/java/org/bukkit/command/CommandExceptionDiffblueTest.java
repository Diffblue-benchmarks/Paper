package org.bukkit.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CommandExceptionDiffblueTest {
  /**
   * Test {@link CommandException#CommandException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CommandException#CommandException()}
   */
  @Test
  @DisplayName("Test new CommandException(); then return Message is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CommandException.<init>()",
    "void CommandException.<init>(String)",
    "void CommandException.<init>(String, Throwable)"
  })
  void testNewCommandException_thenReturnMessageIsNull() {
    // Arrange and Act
    CommandException actualCommandException = new CommandException();

    // Assert
    assertNull(actualCommandException.getMessage());
    assertNull(actualCommandException.getCause());
    assertEquals(0, actualCommandException.getSuppressed().length);
  }

  /**
   * Test {@link CommandException#CommandException(String)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   *   <li>Then return Message is {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link CommandException#CommandException(String)}
   */
  @Test
  @DisplayName("Test new CommandException(String); when 'Msg'; then return Message is 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CommandException.<init>()",
    "void CommandException.<init>(String)",
    "void CommandException.<init>(String, Throwable)"
  })
  void testNewCommandException_whenMsg_thenReturnMessageIsMsg() {
    // Arrange and Act
    CommandException actualCommandException = new CommandException("Msg");

    // Assert
    assertEquals("Msg", actualCommandException.getMessage());
    assertNull(actualCommandException.getCause());
    assertEquals(0, actualCommandException.getSuppressed().length);
  }

  /**
   * Test {@link CommandException#CommandException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link CommandException#CommandException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new CommandException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CommandException.<init>()",
    "void CommandException.<init>(String)",
    "void CommandException.<init>(String, Throwable)"
  })
  void testNewCommandException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CommandException actualCommandException = new CommandException("Msg", cause);

    // Assert
    assertEquals("Msg", actualCommandException.getMessage());
    assertEquals(0, actualCommandException.getSuppressed().length);
    assertSame(cause, actualCommandException.getCause());
  }
}

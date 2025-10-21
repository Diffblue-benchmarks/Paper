package org.bukkit.plugin.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MessageTooLargeExceptionDiffblueTest {
  /**
   * Test {@link MessageTooLargeException#MessageTooLargeException(int)}.
   *
   * <p>Method under test: {@link MessageTooLargeException#MessageTooLargeException(int)}
   */
  @Test
  @DisplayName("Test new MessageTooLargeException(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageTooLargeException.<init>(int)"})
  void testNewMessageTooLargeException() {
    // Arrange and Act
    MessageTooLargeException actualMessageTooLargeException = new MessageTooLargeException(3);

    // Assert
    assertEquals(
        "Attempted to send a plugin message that was too large. The maximum length a plugin message may be is"
            + " 1048576 bytes (tried to send one that is 3 bytes long).",
        actualMessageTooLargeException.getLocalizedMessage());
    assertEquals(
        "Attempted to send a plugin message that was too large. The maximum length a plugin message may be is"
            + " 1048576 bytes (tried to send one that is 3 bytes long).",
        actualMessageTooLargeException.getMessage());
    assertNull(actualMessageTooLargeException.getCause());
    assertEquals(0, actualMessageTooLargeException.getSuppressed().length);
  }

  /**
   * Test {@link MessageTooLargeException#MessageTooLargeException(byte[])}.
   *
   * <p>Method under test: {@link MessageTooLargeException#MessageTooLargeException(byte[])}
   */
  @Test
  @DisplayName("Test new MessageTooLargeException(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageTooLargeException.<init>(byte[])"})
  void testNewMessageTooLargeException2() throws UnsupportedEncodingException {
    // Arrange and Act
    MessageTooLargeException actualMessageTooLargeException =
        new MessageTooLargeException("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(
        "Attempted to send a plugin message that was too large. The maximum length a plugin message may be is"
            + " 1048576 bytes (tried to send one that is 8 bytes long).",
        actualMessageTooLargeException.getLocalizedMessage());
    assertEquals(
        "Attempted to send a plugin message that was too large. The maximum length a plugin message may be is"
            + " 1048576 bytes (tried to send one that is 8 bytes long).",
        actualMessageTooLargeException.getMessage());
    assertNull(actualMessageTooLargeException.getCause());
    assertEquals(0, actualMessageTooLargeException.getSuppressed().length);
  }

  /**
   * Test {@link MessageTooLargeException#MessageTooLargeException()}.
   *
   * <ul>
   *   <li>Then return Message is a string.
   * </ul>
   *
   * <p>Method under test: {@link MessageTooLargeException#MessageTooLargeException()}
   */
  @Test
  @DisplayName("Test new MessageTooLargeException(); then return Message is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MessageTooLargeException.<init>()",
    "void MessageTooLargeException.<init>(String)"
  })
  void testNewMessageTooLargeException_thenReturnMessageIsAString() {
    // Arrange and Act
    MessageTooLargeException actualMessageTooLargeException = new MessageTooLargeException();

    // Assert
    assertEquals(
        "Attempted to send a plugin message that was too large. The maximum length a plugin message may be is"
            + " 1048576 bytes.",
        actualMessageTooLargeException.getMessage());
    assertNull(actualMessageTooLargeException.getCause());
    assertEquals(0, actualMessageTooLargeException.getSuppressed().length);
  }

  /**
   * Test {@link MessageTooLargeException#MessageTooLargeException(String)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   *   <li>Then return Message is {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link MessageTooLargeException#MessageTooLargeException(String)}
   */
  @Test
  @DisplayName(
      "Test new MessageTooLargeException(String); when 'Msg'; then return Message is 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MessageTooLargeException.<init>()",
    "void MessageTooLargeException.<init>(String)"
  })
  void testNewMessageTooLargeException_whenMsg_thenReturnMessageIsMsg() {
    // Arrange and Act
    MessageTooLargeException actualMessageTooLargeException = new MessageTooLargeException("Msg");

    // Assert
    assertEquals("Msg", actualMessageTooLargeException.getMessage());
    assertNull(actualMessageTooLargeException.getCause());
    assertEquals(0, actualMessageTooLargeException.getSuppressed().length);
  }
}

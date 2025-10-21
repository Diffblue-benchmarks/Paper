package org.bukkit.plugin.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChannelNameTooLongExceptionDiffblueTest {
  /**
   * Test {@link ChannelNameTooLongException#ChannelNameTooLongException()}.
   *
   * <p>Method under test: {@link ChannelNameTooLongException#ChannelNameTooLongException()}
   */
  @Test
  @DisplayName("Test new ChannelNameTooLongException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChannelNameTooLongException.<init>()"})
  void testNewChannelNameTooLongException() {
    // Arrange and Act
    ChannelNameTooLongException actualChannelNameTooLongException =
        new ChannelNameTooLongException();

    // Assert
    assertEquals(
        "Attempted to send a Plugin Message to a channel that was too large. The maximum length a channel may"
            + " be is 32767 chars.",
        actualChannelNameTooLongException.getLocalizedMessage());
    assertEquals(
        "Attempted to send a Plugin Message to a channel that was too large. The maximum length a channel may"
            + " be is 32767 chars.",
        actualChannelNameTooLongException.getMessage());
    assertNull(actualChannelNameTooLongException.getCause());
    assertEquals(0, actualChannelNameTooLongException.getSuppressed().length);
  }

  /**
   * Test {@link ChannelNameTooLongException#ChannelNameTooLongException(int, String)}.
   *
   * <p>Method under test: {@link ChannelNameTooLongException#ChannelNameTooLongException(int,
   * String)}
   */
  @Test
  @DisplayName("Test new ChannelNameTooLongException(int, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChannelNameTooLongException.<init>(int, String)"})
  void testNewChannelNameTooLongException2() {
    // Arrange and Act
    ChannelNameTooLongException actualChannelNameTooLongException =
        new ChannelNameTooLongException(3, "Shortened Channel");

    // Assert
    assertEquals(
        "Attempted to send a Plugin Message to a channel that was too large. The maximum length a channel may"
            + " be is 32767 chars (attempted 3 - 'Shortened Channel.",
        actualChannelNameTooLongException.getLocalizedMessage());
    assertEquals(
        "Attempted to send a Plugin Message to a channel that was too large. The maximum length a channel may"
            + " be is 32767 chars (attempted 3 - 'Shortened Channel.",
        actualChannelNameTooLongException.getMessage());
    assertNull(actualChannelNameTooLongException.getCause());
    assertEquals(0, actualChannelNameTooLongException.getSuppressed().length);
  }
}

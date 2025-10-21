package org.bukkit.plugin.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChannelNotRegisteredExceptionDiffblueTest {
  /**
   * Test {@link ChannelNotRegisteredException#ChannelNotRegisteredException()}.
   *
   * <p>Method under test: {@link ChannelNotRegisteredException#ChannelNotRegisteredException()}
   */
  @Test
  @DisplayName("Test new ChannelNotRegisteredException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChannelNotRegisteredException.<init>()"})
  void testNewChannelNotRegisteredException() {
    // Arrange and Act
    ChannelNotRegisteredException actualChannelNotRegisteredException =
        new ChannelNotRegisteredException();

    // Assert
    assertEquals(
        "Attempted to send a plugin message through the unregistered channel `Attempted to send a plugin message"
            + " through an unregistered channel.'.",
        actualChannelNotRegisteredException.getLocalizedMessage());
    assertEquals(
        "Attempted to send a plugin message through the unregistered channel `Attempted to send a plugin message"
            + " through an unregistered channel.'.",
        actualChannelNotRegisteredException.getMessage());
    assertNull(actualChannelNotRegisteredException.getCause());
    assertEquals(0, actualChannelNotRegisteredException.getSuppressed().length);
  }

  /**
   * Test {@link ChannelNotRegisteredException#ChannelNotRegisteredException(String)}.
   *
   * <p>Method under test: {@link
   * ChannelNotRegisteredException#ChannelNotRegisteredException(String)}
   */
  @Test
  @DisplayName("Test new ChannelNotRegisteredException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChannelNotRegisteredException.<init>(String)"})
  void testNewChannelNotRegisteredException2() {
    // Arrange and Act
    ChannelNotRegisteredException actualChannelNotRegisteredException =
        new ChannelNotRegisteredException("Channel");

    // Assert
    assertEquals(
        "Attempted to send a plugin message through the unregistered channel `Channel'.",
        actualChannelNotRegisteredException.getLocalizedMessage());
    assertEquals(
        "Attempted to send a plugin message through the unregistered channel `Channel'.",
        actualChannelNotRegisteredException.getMessage());
    assertNull(actualChannelNotRegisteredException.getCause());
    assertEquals(0, actualChannelNotRegisteredException.getSuppressed().length);
  }
}

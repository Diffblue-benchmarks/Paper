package org.bukkit.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BufferedCommandSenderDiffblueTest {
  /**
   * Test {@link BufferedCommandSender#sendMessage(String)} with {@code String}.
   *
   * <p>Method under test: {@link BufferedCommandSender#sendMessage(String)}
   */
  @Test
  @DisplayName("Test sendMessage(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BufferedCommandSender.sendMessage(String)"})
  void testSendMessageWithString() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act
    bufferedCommandSender.sendMessage("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost\n", bufferedCommandSender.getBuffer());
  }

  /**
   * Test {@link BufferedCommandSender#getBuffer()}.
   *
   * <p>Method under test: {@link BufferedCommandSender#getBuffer()}
   */
  @Test
  @DisplayName("Test getBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BufferedCommandSender.getBuffer()"})
  void testGetBuffer() {
    // Arrange, Act and Assert
    assertEquals("", new BufferedCommandSender().getBuffer());
  }
}

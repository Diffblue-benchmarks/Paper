package org.bukkit.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FormattedCommandAliasDiffblueTest {
  /**
   * Test {@link FormattedCommandAlias#FormattedCommandAlias(String, String[])}.
   *
   * <p>Method under test: {@link FormattedCommandAlias#FormattedCommandAlias(String, String[])}
   */
  @Test
  @DisplayName("Test new FormattedCommandAlias(String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormattedCommandAlias.<init>(String, String[])"})
  void testNewFormattedCommandAlias() {
    // Arrange
    String[] formatStrings = new String[] {"Format Strings"};

    // Act
    FormattedCommandAlias actualFormattedCommandAlias =
        new FormattedCommandAlias("Alias", formatStrings);

    // Assert
    assertEquals("", actualFormattedCommandAlias.getDescription());
    assertEquals("/Alias", actualFormattedCommandAlias.getUsage());
    assertEquals("Alias", actualFormattedCommandAlias.getLabel());
    assertEquals("Alias", actualFormattedCommandAlias.getName());
    assertEquals("Command Forwarder - Alias", actualFormattedCommandAlias.getTimingName());
    assertNull(actualFormattedCommandAlias.getPermission());
    assertNull(actualFormattedCommandAlias.getPermissionMessage());
    assertNull(actualFormattedCommandAlias.permissionMessage());
    assertFalse(actualFormattedCommandAlias.isRegistered());
    assertTrue(actualFormattedCommandAlias.getAliases().isEmpty());
  }

  /**
   * Test {@link FormattedCommandAlias#execute(CommandSender, String, String[])}.
   *
   * <p>Method under test: {@link FormattedCommandAlias#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test execute(CommandSender, String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormattedCommandAlias.execute(CommandSender, String, String[])"})
  void testExecute() {
    // Arrange
    FormattedCommandAlias formattedCommandAlias =
        new FormattedCommandAlias("Alias", new String[] {"$sender", "Format Strings"});
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    boolean actualExecuteResult =
        formattedCommandAlias.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    assertEquals(
        "§cAn internal error occurred while attempting to perform this command\n",
        sender.getBuffer());
    assertFalse(actualExecuteResult);
  }

  /**
   * Test {@link FormattedCommandAlias#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Then {@link BufferedCommandSender} (default constructor) Buffer is empty string.
   * </ul>
   *
   * <p>Method under test: {@link FormattedCommandAlias#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); then BufferedCommandSender (default constructor) Buffer is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormattedCommandAlias.execute(CommandSender, String, String[])"})
  void testExecute_thenBufferedCommandSenderBufferIsEmptyString() {
    // Arrange
    FormattedCommandAlias formattedCommandAlias =
        new FormattedCommandAlias("Alias", new String[] {});
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    boolean actualExecuteResult =
        formattedCommandAlias.execute(sender, "Command Label", new String[] {"Args"});

    // Assert
    assertEquals("", sender.getBuffer());
    assertFalse(actualExecuteResult);
  }

  /**
   * Test {@link FormattedCommandAlias#getTimingName()}.
   *
   * <p>Method under test: {@link FormattedCommandAlias#getTimingName()}
   */
  @Test
  @DisplayName("Test getTimingName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormattedCommandAlias.getTimingName()"})
  void testGetTimingName() {
    // Arrange
    String[] formatStrings = new String[] {"Format Strings"};
    FormattedCommandAlias formattedCommandAlias = new FormattedCommandAlias("Alias", formatStrings);

    // Act and Assert
    assertEquals("Command Forwarder - Alias", formattedCommandAlias.getTimingName());
  }
}

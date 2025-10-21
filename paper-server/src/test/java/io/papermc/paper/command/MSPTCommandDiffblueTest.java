package io.papermc.paper.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MSPTCommandDiffblueTest {
  /**
   * Test {@link MSPTCommand#MSPTCommand(String)}.
   *
   * <p>Method under test: {@link MSPTCommand#MSPTCommand(String)}
   */
  @Test
  @DisplayName("Test new MSPTCommand(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MSPTCommand.<init>(String)"})
  void testNewMSPTCommand() {
    // Arrange and Act
    MSPTCommand actualMsptCommand = new MSPTCommand("Name");

    // Assert
    assertEquals("/mspt", actualMsptCommand.getUsage());
    assertEquals("Name", actualMsptCommand.getLabel());
    assertEquals("Name", actualMsptCommand.getName());
    assertEquals("Name", actualMsptCommand.getTimingName());
    assertEquals("View server tick times", actualMsptCommand.getDescription());
    assertEquals("bukkit.command.mspt", actualMsptCommand.getPermission());
    assertNull(actualMsptCommand.timings);
    assertNull(actualMsptCommand.getPermissionMessage());
    assertNull(actualMsptCommand.permissionMessage());
    assertFalse(actualMsptCommand.isRegistered());
    assertTrue(actualMsptCommand.getAliases().isEmpty());
  }
}

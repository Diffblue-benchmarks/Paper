package org.bukkit.command.defaults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import net.kyori.adventure.text.Component;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.CommandSender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ReloadCommandDiffblueTest {
  /**
   * Test {@link ReloadCommand#ReloadCommand(String)}.
   *
   * <p>Method under test: {@link ReloadCommand#ReloadCommand(String)}
   */
  @Test
  @DisplayName("Test new ReloadCommand(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReloadCommand.<init>(String)"})
  void testNewReloadCommand() {
    // Arrange and Act
    ReloadCommand actualReloadCommand = new ReloadCommand("Name");

    // Assert
    assertEquals("/reload [permissions|commands|confirm]", actualReloadCommand.getUsage());
    assertEquals("Name", actualReloadCommand.getLabel());
    assertEquals("Name", actualReloadCommand.getName());
    assertEquals("Name", actualReloadCommand.getTimingName());
    assertEquals(
        "Reloads the server configuration and plugins", actualReloadCommand.getDescription());
    assertEquals("bukkit.command.reload", actualReloadCommand.getPermission());
    List<String> aliases = actualReloadCommand.getAliases();
    assertEquals(1, aliases.size());
    assertEquals("rl", aliases.get(0));
    assertNull(actualReloadCommand.timings);
    assertNull(actualReloadCommand.getPermissionMessage());
    assertNull(actualReloadCommand.permissionMessage());
    assertFalse(actualReloadCommand.isRegistered());
  }

  /**
   * Test {@link ReloadCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link ReloadCommand#ReloadCommand(String)} with {@code Name} PermissionMessage is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link ReloadCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given ReloadCommand(String) with 'Name' PermissionMessage is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReloadCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenReloadCommandWithNamePermissionMessageIsEmptyString() {
    // Arrange
    ReloadCommand reloadCommand = new ReloadCommand("Name");
    reloadCommand.setPermissionMessage("");
    reloadCommand.setPermission(";");

    // Act and Assert
    assertTrue(
        reloadCommand.execute(
            mock(BlockCommandSender.class), "Current Alias", new String[] {"permissions"}));
  }

  /**
   * Test {@link ReloadCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link ReloadCommand#ReloadCommand(String)} with {@code Name} PermissionMessage is
   *       {@code <permission>}.
   * </ul>
   *
   * <p>Method under test: {@link ReloadCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given ReloadCommand(String) with 'Name' PermissionMessage is '<permission>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReloadCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenReloadCommandWithNamePermissionMessageIsPermission() {
    // Arrange
    ReloadCommand reloadCommand = new ReloadCommand("Name");
    reloadCommand.setPermissionMessage("<permission>");
    reloadCommand.setPermission(";");

    BlockCommandSender sender = mock(BlockCommandSender.class);
    doNothing().when(sender).sendMessage(Mockito.<Component>any());

    // Act
    boolean actualExecuteResult =
        reloadCommand.execute(sender, "Current Alias", new String[] {"permissions"});

    // Assert
    verify(sender).sendMessage(isA(Component.class));
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link ReloadCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link ReloadCommand#ReloadCommand(String)} with {@code Name} PermissionMessage is
   *       {@code <permission>;}.
   * </ul>
   *
   * <p>Method under test: {@link ReloadCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given ReloadCommand(String) with 'Name' PermissionMessage is '<permission>;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReloadCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenReloadCommandWithNamePermissionMessageIsPermission2() {
    // Arrange
    ReloadCommand reloadCommand = new ReloadCommand("Name");
    reloadCommand.setPermissionMessage("<permission>;");
    reloadCommand.setPermission(";");

    BlockCommandSender sender = mock(BlockCommandSender.class);
    doNothing().when(sender).sendMessage(Mockito.<Component>any());

    // Act
    boolean actualExecuteResult =
        reloadCommand.execute(sender, "Current Alias", new String[] {"permissions"});

    // Assert
    verify(sender).sendMessage(isA(Component.class));
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link ReloadCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link ReloadCommand#ReloadCommand(String)} with {@code Name} PermissionMessage is
   *       {@code ;<permission>}.
   * </ul>
   *
   * <p>Method under test: {@link ReloadCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given ReloadCommand(String) with 'Name' PermissionMessage is ';<permission>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReloadCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenReloadCommandWithNamePermissionMessageIsPermission3() {
    // Arrange
    ReloadCommand reloadCommand = new ReloadCommand("Name");
    reloadCommand.setPermissionMessage(";<permission>");
    reloadCommand.setPermission(";");

    BlockCommandSender sender = mock(BlockCommandSender.class);
    doNothing().when(sender).sendMessage(Mockito.<Component>any());

    // Act
    boolean actualExecuteResult =
        reloadCommand.execute(sender, "Current Alias", new String[] {"permissions"});

    // Assert
    verify(sender).sendMessage(isA(Component.class));
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link ReloadCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link ReloadCommand#ReloadCommand(String)} with {@code Name} PermissionMessage is
   *       {@code <permission><permission>}.
   * </ul>
   *
   * <p>Method under test: {@link ReloadCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given ReloadCommand(String) with 'Name' PermissionMessage is '<permission><permission>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReloadCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenReloadCommandWithNamePermissionMessageIsPermissionPermission() {
    // Arrange
    ReloadCommand reloadCommand = new ReloadCommand("Name");
    reloadCommand.setPermissionMessage("<permission><permission>");
    reloadCommand.setPermission(";");

    BlockCommandSender sender = mock(BlockCommandSender.class);
    doNothing().when(sender).sendMessage(Mockito.<Component>any());

    // Act
    boolean actualExecuteResult =
        reloadCommand.execute(sender, "Current Alias", new String[] {"permissions"});

    // Assert
    verify(sender).sendMessage(isA(Component.class));
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link ReloadCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link ReloadCommand#ReloadCommand(String)} with {@code Name} PermissionMessage is
   *       {@code ;}.
   * </ul>
   *
   * <p>Method under test: {@link ReloadCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given ReloadCommand(String) with 'Name' PermissionMessage is ';'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReloadCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenReloadCommandWithNamePermissionMessageIsSemicolon() {
    // Arrange
    ReloadCommand reloadCommand = new ReloadCommand("Name");
    reloadCommand.setPermissionMessage(";");
    reloadCommand.setPermission(";");

    BlockCommandSender sender = mock(BlockCommandSender.class);
    doNothing().when(sender).sendMessage(Mockito.<Component>any());

    // Act
    boolean actualExecuteResult =
        reloadCommand.execute(sender, "Current Alias", new String[] {"permissions"});

    // Assert
    verify(sender).sendMessage(isA(Component.class));
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link ReloadCommand#tabComplete(CommandSender, String, String[])} with {@code sender},
   * {@code alias}, {@code args}.
   *
   * <p>Method under test: {@link ReloadCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ReloadCommand.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs() throws IllegalArgumentException {
    // Arrange
    ReloadCommand reloadCommand = new ReloadCommand("Name");

    // Act
    List<String> actualTabCompleteResult =
        reloadCommand.tabComplete(new BufferedCommandSender(), "Alias", new String[] {"Args"});

    // Assert
    assertEquals(2, actualTabCompleteResult.size());
    assertEquals("commands", actualTabCompleteResult.get(1));
    assertEquals("permissions", actualTabCompleteResult.get(0));
  }
}

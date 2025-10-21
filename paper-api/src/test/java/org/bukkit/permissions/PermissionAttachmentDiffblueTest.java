package org.bukkit.permissions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.MessageCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PermissionAttachmentDiffblueTest {
  /**
   * Test {@link PermissionAttachment#PermissionAttachment(Plugin, Permissible)}.
   *
   * <ul>
   *   <li>Then return RemovalCallback is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionAttachment#PermissionAttachment(Plugin, Permissible)}
   */
  @Test
  @DisplayName(
      "Test new PermissionAttachment(Plugin, Permissible); then return RemovalCallback is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionAttachment.<init>(Plugin, Permissible)"})
  void testNewPermissionAttachment_thenReturnRemovalCallbackIsNull() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    BufferedCommandSender permissible = new BufferedCommandSender();

    // Act
    PermissionAttachment actualPermissionAttachment = new PermissionAttachment(plugin, permissible);

    // Assert
    assertNull(actualPermissionAttachment.getRemovalCallback());
    assertTrue(actualPermissionAttachment.getPermissions().isEmpty());
    assertSame(permissible, actualPermissionAttachment.getPermissible());
    assertSame(plugin, actualPermissionAttachment.getPlugin());
  }

  /**
   * Test {@link PermissionAttachment#PermissionAttachment(Plugin, Permissible)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionAttachment#PermissionAttachment(Plugin, Permissible)}
   */
  @Test
  @DisplayName(
      "Test new PermissionAttachment(Plugin, Permissible); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionAttachment.<init>(Plugin, Permissible)"})
  void testNewPermissionAttachment_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PermissionAttachment(null, new BufferedCommandSender()));
  }

  /**
   * Test {@link PermissionAttachment#PermissionAttachment(Plugin, Permissible)}.
   *
   * <ul>
   *   <li>When {@link TestPlugin#TestPlugin(String)} with {@code Plugin Name} Enabled is {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionAttachment#PermissionAttachment(Plugin, Permissible)}
   */
  @Test
  @DisplayName(
      "Test new PermissionAttachment(Plugin, Permissible); when TestPlugin(String) with 'Plugin Name' Enabled is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionAttachment.<init>(Plugin, Permissible)"})
  void testNewPermissionAttachment_whenTestPluginWithPluginNameEnabledIsFalse() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PermissionAttachment(plugin, new BufferedCommandSender()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PermissionAttachment#setRemovalCallback(PermissionRemovedExecutor)}
   *   <li>{@link PermissionAttachment#getPermissible()}
   *   <li>{@link PermissionAttachment#getPlugin()}
   *   <li>{@link PermissionAttachment#getRemovalCallback()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Permissible PermissionAttachment.getPermissible()",
    "Plugin PermissionAttachment.getPlugin()",
    "PermissionRemovedExecutor PermissionAttachment.getRemovalCallback()",
    "void PermissionAttachment.setRemovalCallback(PermissionRemovedExecutor)"
  })
  void testGettersAndSetters() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    BufferedCommandSender permissible = new BufferedCommandSender();

    PermissionAttachment permissionAttachment = new PermissionAttachment(plugin, permissible);
    PermissionRemovedExecutor ex = mock(PermissionRemovedExecutor.class);

    // Act
    permissionAttachment.setRemovalCallback(ex);
    Permissible actualPermissible = permissionAttachment.getPermissible();
    Plugin actualPlugin = permissionAttachment.getPlugin();

    // Assert
    assertSame(permissible, actualPermissible);
    assertSame(plugin, actualPlugin);
    assertSame(ex, permissionAttachment.getRemovalCallback());
  }

  /**
   * Test {@link PermissionAttachment#getPermissions()}.
   *
   * <p>Method under test: {@link PermissionAttachment#getPermissions()}
   */
  @Test
  @DisplayName("Test getPermissions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PermissionAttachment.getPermissions()"})
  void testGetPermissions() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());

    // Act and Assert
    assertTrue(permissionAttachment.getPermissions().isEmpty());
  }

  /**
   * Test {@link PermissionAttachment#setPermission(String, boolean)} with {@code name}, {@code
   * value}.
   *
   * <p>Method under test: {@link PermissionAttachment#setPermission(String, boolean)}
   */
  @Test
  @DisplayName("Test setPermission(String, boolean) with 'name', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionAttachment.setPermission(String, boolean)"})
  void testSetPermissionWithNameValue() {
    // Arrange
    MessageCommandSender permissible = mock(MessageCommandSender.class);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(permissible.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    doNothing().when(permissible).recalculatePermissions();
    permissible.addAttachment(new TestPlugin("Plugin Name"), "Name", true);
    PermissionAttachment permissionAttachment2 =
        new PermissionAttachment(new TestPlugin("Plugin Name"), permissible);

    // Act
    permissionAttachment2.setPermission("Name", true);

    // Assert
    verify(permissible).addAttachment(isA(Plugin.class), eq("Name"), eq(true));
    verify(permissible).recalculatePermissions();
    Map<String, Boolean> permissions = permissionAttachment2.getPermissions();
    assertEquals(1, permissions.size());
    assertTrue(permissions.get("name"));
  }

  /**
   * Test {@link PermissionAttachment#setPermission(Permission, boolean)} with {@code perm}, {@code
   * value}.
   *
   * <p>Method under test: {@link PermissionAttachment#setPermission(Permission, boolean)}
   */
  @Test
  @DisplayName("Test setPermission(Permission, boolean) with 'perm', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionAttachment.setPermission(Permission, boolean)"})
  void testSetPermissionWithPermValue() {
    // Arrange
    MessageCommandSender permissible = mock(MessageCommandSender.class);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(permissible.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    doNothing().when(permissible).recalculatePermissions();
    permissible.addAttachment(new TestPlugin("Plugin Name"), "Name", true);
    PermissionAttachment permissionAttachment2 =
        new PermissionAttachment(new TestPlugin("Plugin Name"), permissible);

    // Act
    permissionAttachment2.setPermission(new Permission("Name"), true);

    // Assert
    verify(permissible).addAttachment(isA(Plugin.class), eq("Name"), eq(true));
    verify(permissible).recalculatePermissions();
    Map<String, Boolean> permissions = permissionAttachment2.getPermissions();
    assertEquals(1, permissions.size());
    assertTrue(permissions.get("name"));
  }

  /**
   * Test {@link PermissionAttachment#unsetPermission(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then calls {@link MessageCommandSender#addAttachment(Plugin, String, boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionAttachment#unsetPermission(String)}
   */
  @Test
  @DisplayName(
      "Test unsetPermission(String) with 'name'; then calls addAttachment(Plugin, String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionAttachment.unsetPermission(String)"})
  void testUnsetPermissionWithName_thenCallsAddAttachment() {
    // Arrange
    MessageCommandSender permissible = mock(MessageCommandSender.class);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(permissible.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    doNothing().when(permissible).recalculatePermissions();
    permissible.addAttachment(new TestPlugin("Plugin Name"), "Name", true);
    PermissionAttachment permissionAttachment2 =
        new PermissionAttachment(new TestPlugin("Plugin Name"), permissible);

    // Act
    permissionAttachment2.unsetPermission("Name");

    // Assert
    verify(permissible).addAttachment(isA(Plugin.class), eq("Name"), eq(true));
    verify(permissible).recalculatePermissions();
  }

  /**
   * Test {@link PermissionAttachment#unsetPermission(Permission)} with {@code perm}.
   *
   * <ul>
   *   <li>Then calls {@link MessageCommandSender#addAttachment(Plugin, String, boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionAttachment#unsetPermission(Permission)}
   */
  @Test
  @DisplayName(
      "Test unsetPermission(Permission) with 'perm'; then calls addAttachment(Plugin, String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionAttachment.unsetPermission(Permission)"})
  void testUnsetPermissionWithPerm_thenCallsAddAttachment() {
    // Arrange
    MessageCommandSender permissible = mock(MessageCommandSender.class);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(permissible.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    doNothing().when(permissible).recalculatePermissions();
    permissible.addAttachment(new TestPlugin("Plugin Name"), "Name", true);
    PermissionAttachment permissionAttachment2 =
        new PermissionAttachment(new TestPlugin("Plugin Name"), permissible);

    // Act
    permissionAttachment2.unsetPermission(new Permission("Name"));

    // Assert
    verify(permissible).addAttachment(isA(Plugin.class), eq("Name"), eq(true));
    verify(permissible).recalculatePermissions();
  }

  /**
   * Test {@link PermissionAttachment#remove()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionAttachment#remove()}
   */
  @Test
  @DisplayName("Test remove(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionAttachment.remove()"})
  void testRemove_thenReturnTrue() {
    // Arrange
    MessageCommandSender permissible = mock(MessageCommandSender.class);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(permissible.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    doNothing().when(permissible).removeAttachment(Mockito.<PermissionAttachment>any());
    permissible.addAttachment(new TestPlugin("Plugin Name"), "Name", true);
    PermissionAttachment permissionAttachment2 =
        new PermissionAttachment(new TestPlugin("Plugin Name"), permissible);

    // Act
    boolean actualRemoveResult = permissionAttachment2.remove();

    // Assert
    verify(permissible).addAttachment(isA(Plugin.class), eq("Name"), eq(true));
    verify(permissible).removeAttachment(isA(PermissionAttachment.class));
    assertTrue(actualRemoveResult);
  }
}

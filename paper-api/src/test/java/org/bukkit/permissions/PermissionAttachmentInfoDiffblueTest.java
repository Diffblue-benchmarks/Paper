package org.bukkit.permissions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PermissionAttachmentInfoDiffblueTest {
  /**
   * Test {@link PermissionAttachmentInfo#PermissionAttachmentInfo(Permissible, String,
   * PermissionAttachment, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionAttachmentInfo#PermissionAttachmentInfo(Permissible,
   * String, PermissionAttachment, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PermissionAttachmentInfo(Permissible, String, PermissionAttachment, boolean); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PermissionAttachmentInfo.<init>(Permissible, String, PermissionAttachment, boolean)"
  })
  void testNewPermissionAttachmentInfo_thenThrowIllegalArgumentException() {
    // Arrange
    BufferedCommandSender permissible = new BufferedCommandSender();
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment attachment = new PermissionAttachment(plugin, new BufferedCommandSender());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PermissionAttachmentInfo(permissible, null, attachment, true));
  }

  /**
   * Test {@link PermissionAttachmentInfo#PermissionAttachmentInfo(Permissible, String,
   * PermissionAttachment, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionAttachmentInfo#PermissionAttachmentInfo(Permissible,
   * String, PermissionAttachment, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PermissionAttachmentInfo(Permissible, String, PermissionAttachment, boolean); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PermissionAttachmentInfo.<init>(Permissible, String, PermissionAttachment, boolean)"
  })
  void testNewPermissionAttachmentInfo_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment attachment = new PermissionAttachment(plugin, new BufferedCommandSender());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PermissionAttachmentInfo(null, null, attachment, true));
  }

  /**
   * Test {@link PermissionAttachmentInfo#PermissionAttachmentInfo(Permissible, String,
   * PermissionAttachment, boolean)}.
   *
   * <ul>
   *   <li>When {@code Permission}.
   *   <li>Then return {@code Permission}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionAttachmentInfo#PermissionAttachmentInfo(Permissible,
   * String, PermissionAttachment, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PermissionAttachmentInfo(Permissible, String, PermissionAttachment, boolean); when 'Permission'; then return 'Permission'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PermissionAttachmentInfo.<init>(Permissible, String, PermissionAttachment, boolean)"
  })
  void testNewPermissionAttachmentInfo_whenPermission_thenReturnPermission() {
    // Arrange
    BufferedCommandSender permissible = new BufferedCommandSender();
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment attachment = new PermissionAttachment(plugin, new BufferedCommandSender());

    // Act
    PermissionAttachmentInfo actualPermissionAttachmentInfo =
        new PermissionAttachmentInfo(permissible, "Permission", attachment, true);

    // Assert
    assertEquals("Permission", actualPermissionAttachmentInfo.getPermission());
    assertTrue(actualPermissionAttachmentInfo.getValue());
    assertSame(permissible, actualPermissionAttachmentInfo.getPermissible());
    assertSame(attachment, actualPermissionAttachmentInfo.getAttachment());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PermissionAttachmentInfo#getAttachment()}
   *   <li>{@link PermissionAttachmentInfo#getPermissible()}
   *   <li>{@link PermissionAttachmentInfo#getPermission()}
   *   <li>{@link PermissionAttachmentInfo#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PermissionAttachment PermissionAttachmentInfo.getAttachment()",
    "Permissible PermissionAttachmentInfo.getPermissible()",
    "String PermissionAttachmentInfo.getPermission()",
    "boolean PermissionAttachmentInfo.getValue()"
  })
  void testGettersAndSetters() {
    // Arrange
    BufferedCommandSender permissible = new BufferedCommandSender();
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment attachment = new PermissionAttachment(plugin, new BufferedCommandSender());

    PermissionAttachmentInfo permissionAttachmentInfo =
        new PermissionAttachmentInfo(permissible, "Permission", attachment, true);

    // Act
    PermissionAttachment actualAttachment = permissionAttachmentInfo.getAttachment();
    Permissible actualPermissible = permissionAttachmentInfo.getPermissible();
    String actualPermission = permissionAttachmentInfo.getPermission();

    // Assert
    assertEquals("Permission", actualPermission);
    assertTrue(permissionAttachmentInfo.getValue());
    assertSame(permissible, actualPermissible);
    assertSame(attachment, actualAttachment);
  }
}

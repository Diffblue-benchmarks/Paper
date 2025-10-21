package org.bukkit.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MessageCommandSenderDiffblueTest {
  /**
   * Test {@link MessageCommandSender#sendMessage(String[])} with {@code String[]}.
   *
   * <p>Method under test: {@link MessageCommandSender#sendMessage(String[])}
   */
  @Test
  @DisplayName("Test sendMessage(String[]) with 'String[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageCommandSender.sendMessage(String[])"})
  void testSendMessageWithString() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act
    bufferedCommandSender.sendMessage(new String[] {"Messages"});

    // Assert
    assertEquals("Messages\n", bufferedCommandSender.getBuffer());
  }

  /**
   * Test {@link MessageCommandSender#sendMessage(UUID, String)} with {@code UUID}, {@code String}.
   *
   * <p>Method under test: {@link MessageCommandSender#sendMessage(UUID, String)}
   */
  @Test
  @DisplayName("Test sendMessage(UUID, String) with 'UUID', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageCommandSender.sendMessage(UUID, String)"})
  void testSendMessageWithUuidString() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act
    bufferedCommandSender.sendMessage(UUID.randomUUID(), "Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost\n", bufferedCommandSender.getBuffer());
  }

  /**
   * Test {@link MessageCommandSender#sendMessage(UUID, String[])} with {@code UUID}, {@code
   * String[]}.
   *
   * <p>Method under test: {@link MessageCommandSender#sendMessage(UUID, String[])}
   */
  @Test
  @DisplayName("Test sendMessage(UUID, String[]) with 'UUID', 'String[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageCommandSender.sendMessage(UUID, String[])"})
  void testSendMessageWithUuidString2() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act
    bufferedCommandSender.sendMessage(UUID.randomUUID(), new String[] {"Messages"});

    // Assert
    assertEquals("Messages\n", bufferedCommandSender.getBuffer());
  }

  /**
   * Test {@link MessageCommandSender#name()}.
   *
   * <p>Method under test: {@link MessageCommandSender#name()}
   */
  @Test
  @DisplayName("Test name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.kyori.adventure.text.Component MessageCommandSender.name()"})
  void testName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new BufferedCommandSender().name());
  }

  /**
   * Test {@link MessageCommandSender#getName()}.
   *
   * <p>Method under test: {@link MessageCommandSender#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MessageCommandSender.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new BufferedCommandSender().getName());
  }

  /**
   * Test {@link MessageCommandSender#isOp()}.
   *
   * <ul>
   *   <li>Given {@link BufferedCommandSender} (default constructor).
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MessageCommandSender#isOp()}
   */
  @Test
  @DisplayName(
      "Test isOp(); given BufferedCommandSender (default constructor); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageCommandSender.isOp()"})
  void testIsOp_givenBufferedCommandSender_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new BufferedCommandSender().isOp());
  }

  /**
   * Test {@link MessageCommandSender#isOp()}.
   *
   * <ul>
   *   <li>Given {@link MessageCommandSender} {@link MessageCommandSender#isOp()} return {@code
   *       false}.
   *   <li>Then calls {@link MessageCommandSender#isOp()}.
   * </ul>
   *
   * <p>Method under test: {@link MessageCommandSender#isOp()}
   */
  @Test
  @DisplayName("Test isOp(); given MessageCommandSender isOp() return 'false'; then calls isOp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageCommandSender.isOp()"})
  void testIsOp_givenMessageCommandSenderIsOpReturnFalse_thenCallsIsOp() {
    // Arrange
    MessageCommandSender messageCommandSender = mock(MessageCommandSender.class);
    when(messageCommandSender.isOp()).thenReturn(false);

    // Act
    messageCommandSender.isOp();

    // Assert
    verify(messageCommandSender).isOp();
  }

  /**
   * Test {@link MessageCommandSender#isOp()}.
   *
   * <ul>
   *   <li>Given {@link MessageCommandSender} {@link MessageCommandSender#isOp()} return {@code
   *       true}.
   *   <li>Then calls {@link MessageCommandSender#isOp()}.
   * </ul>
   *
   * <p>Method under test: {@link MessageCommandSender#isOp()}
   */
  @Test
  @DisplayName("Test isOp(); given MessageCommandSender isOp() return 'true'; then calls isOp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageCommandSender.isOp()"})
  void testIsOp_givenMessageCommandSenderIsOpReturnTrue_thenCallsIsOp() {
    // Arrange
    MessageCommandSender messageCommandSender = mock(MessageCommandSender.class);
    when(messageCommandSender.isOp()).thenReturn(true);

    // Act
    messageCommandSender.isOp();

    // Assert
    verify(messageCommandSender).isOp();
  }

  /**
   * Test {@link MessageCommandSender#setOp(boolean)}.
   *
   * <p>Method under test: {@link MessageCommandSender#setOp(boolean)}
   */
  @Test
  @DisplayName("Test setOp(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageCommandSender.setOp(boolean)"})
  void testSetOp() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new BufferedCommandSender().setOp(true));
  }

  /**
   * Test {@link MessageCommandSender#isPermissionSet(String)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link MessageCommandSender} {@link MessageCommandSender#isPermissionSet(String)}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MessageCommandSender#isPermissionSet(String)}
   */
  @Test
  @DisplayName(
      "Test isPermissionSet(String) with 'name'; given MessageCommandSender isPermissionSet(String) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageCommandSender.isPermissionSet(String)"})
  void testIsPermissionSetWithName_givenMessageCommandSenderIsPermissionSetReturnFalse() {
    // Arrange
    MessageCommandSender messageCommandSender = mock(MessageCommandSender.class);
    when(messageCommandSender.isPermissionSet(Mockito.<String>any())).thenReturn(false);

    // Act
    messageCommandSender.isPermissionSet("Name");

    // Assert
    verify(messageCommandSender).isPermissionSet("Name");
  }

  /**
   * Test {@link MessageCommandSender#isPermissionSet(String)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link MessageCommandSender} {@link MessageCommandSender#isPermissionSet(String)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MessageCommandSender#isPermissionSet(String)}
   */
  @Test
  @DisplayName(
      "Test isPermissionSet(String) with 'name'; given MessageCommandSender isPermissionSet(String) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageCommandSender.isPermissionSet(String)"})
  void testIsPermissionSetWithName_givenMessageCommandSenderIsPermissionSetReturnTrue() {
    // Arrange
    MessageCommandSender messageCommandSender = mock(MessageCommandSender.class);
    when(messageCommandSender.isPermissionSet(Mockito.<String>any())).thenReturn(true);

    // Act
    messageCommandSender.isPermissionSet("Name");

    // Assert
    verify(messageCommandSender).isPermissionSet("Name");
  }

  /**
   * Test {@link MessageCommandSender#isPermissionSet(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MessageCommandSender#isPermissionSet(String)}
   */
  @Test
  @DisplayName("Test isPermissionSet(String) with 'name'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageCommandSender.isPermissionSet(String)"})
  void testIsPermissionSetWithName_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new BufferedCommandSender().isPermissionSet("Name"));
  }

  /**
   * Test {@link MessageCommandSender#isPermissionSet(Permission)} with {@code perm}.
   *
   * <ul>
   *   <li>Given {@link MessageCommandSender} {@link
   *       MessageCommandSender#isPermissionSet(Permission)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MessageCommandSender#isPermissionSet(Permission)}
   */
  @Test
  @DisplayName(
      "Test isPermissionSet(Permission) with 'perm'; given MessageCommandSender isPermissionSet(Permission) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageCommandSender.isPermissionSet(Permission)"})
  void testIsPermissionSetWithPerm_givenMessageCommandSenderIsPermissionSetReturnFalse() {
    // Arrange
    MessageCommandSender messageCommandSender = mock(MessageCommandSender.class);
    when(messageCommandSender.isPermissionSet(Mockito.<Permission>any())).thenReturn(false);

    // Act
    messageCommandSender.isPermissionSet(new Permission("Name"));

    // Assert
    verify(messageCommandSender).isPermissionSet(isA(Permission.class));
  }

  /**
   * Test {@link MessageCommandSender#isPermissionSet(Permission)} with {@code perm}.
   *
   * <ul>
   *   <li>Given {@link MessageCommandSender} {@link
   *       MessageCommandSender#isPermissionSet(Permission)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MessageCommandSender#isPermissionSet(Permission)}
   */
  @Test
  @DisplayName(
      "Test isPermissionSet(Permission) with 'perm'; given MessageCommandSender isPermissionSet(Permission) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageCommandSender.isPermissionSet(Permission)"})
  void testIsPermissionSetWithPerm_givenMessageCommandSenderIsPermissionSetReturnTrue() {
    // Arrange
    MessageCommandSender messageCommandSender = mock(MessageCommandSender.class);
    when(messageCommandSender.isPermissionSet(Mockito.<Permission>any())).thenReturn(true);

    // Act
    messageCommandSender.isPermissionSet(new Permission("Name"));

    // Assert
    verify(messageCommandSender).isPermissionSet(isA(Permission.class));
  }

  /**
   * Test {@link MessageCommandSender#isPermissionSet(Permission)} with {@code perm}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MessageCommandSender#isPermissionSet(Permission)}
   */
  @Test
  @DisplayName(
      "Test isPermissionSet(Permission) with 'perm'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageCommandSender.isPermissionSet(Permission)"})
  void testIsPermissionSetWithPerm_thenThrowUnsupportedOperationException() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> bufferedCommandSender.isPermissionSet(new Permission("Name")));
  }

  /**
   * Test {@link MessageCommandSender#hasPermission(String)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link MessageCommandSender} {@link MessageCommandSender#hasPermission(String)}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MessageCommandSender#hasPermission(String)}
   */
  @Test
  @DisplayName(
      "Test hasPermission(String) with 'name'; given MessageCommandSender hasPermission(String) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageCommandSender.hasPermission(String)"})
  void testHasPermissionWithName_givenMessageCommandSenderHasPermissionReturnFalse() {
    // Arrange
    MessageCommandSender messageCommandSender = mock(MessageCommandSender.class);
    when(messageCommandSender.hasPermission(Mockito.<String>any())).thenReturn(false);

    // Act
    messageCommandSender.hasPermission("Name");

    // Assert
    verify(messageCommandSender).hasPermission("Name");
  }

  /**
   * Test {@link MessageCommandSender#hasPermission(String)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link MessageCommandSender} {@link MessageCommandSender#hasPermission(String)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MessageCommandSender#hasPermission(String)}
   */
  @Test
  @DisplayName(
      "Test hasPermission(String) with 'name'; given MessageCommandSender hasPermission(String) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageCommandSender.hasPermission(String)"})
  void testHasPermissionWithName_givenMessageCommandSenderHasPermissionReturnTrue() {
    // Arrange
    MessageCommandSender messageCommandSender = mock(MessageCommandSender.class);
    when(messageCommandSender.hasPermission(Mockito.<String>any())).thenReturn(true);

    // Act
    messageCommandSender.hasPermission("Name");

    // Assert
    verify(messageCommandSender).hasPermission("Name");
  }

  /**
   * Test {@link MessageCommandSender#hasPermission(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MessageCommandSender#hasPermission(String)}
   */
  @Test
  @DisplayName("Test hasPermission(String) with 'name'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageCommandSender.hasPermission(String)"})
  void testHasPermissionWithName_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new BufferedCommandSender().hasPermission("Name"));
  }

  /**
   * Test {@link MessageCommandSender#hasPermission(Permission)} with {@code perm}.
   *
   * <ul>
   *   <li>Given {@link MessageCommandSender} {@link MessageCommandSender#hasPermission(Permission)}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MessageCommandSender#hasPermission(Permission)}
   */
  @Test
  @DisplayName(
      "Test hasPermission(Permission) with 'perm'; given MessageCommandSender hasPermission(Permission) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageCommandSender.hasPermission(Permission)"})
  void testHasPermissionWithPerm_givenMessageCommandSenderHasPermissionReturnFalse() {
    // Arrange
    MessageCommandSender messageCommandSender = mock(MessageCommandSender.class);
    when(messageCommandSender.hasPermission(Mockito.<Permission>any())).thenReturn(false);

    // Act
    messageCommandSender.hasPermission(new Permission("Name"));

    // Assert
    verify(messageCommandSender).hasPermission(isA(Permission.class));
  }

  /**
   * Test {@link MessageCommandSender#hasPermission(Permission)} with {@code perm}.
   *
   * <ul>
   *   <li>Given {@link MessageCommandSender} {@link MessageCommandSender#hasPermission(Permission)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MessageCommandSender#hasPermission(Permission)}
   */
  @Test
  @DisplayName(
      "Test hasPermission(Permission) with 'perm'; given MessageCommandSender hasPermission(Permission) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageCommandSender.hasPermission(Permission)"})
  void testHasPermissionWithPerm_givenMessageCommandSenderHasPermissionReturnTrue() {
    // Arrange
    MessageCommandSender messageCommandSender = mock(MessageCommandSender.class);
    when(messageCommandSender.hasPermission(Mockito.<Permission>any())).thenReturn(true);

    // Act
    messageCommandSender.hasPermission(new Permission("Name"));

    // Assert
    verify(messageCommandSender).hasPermission(isA(Permission.class));
  }

  /**
   * Test {@link MessageCommandSender#hasPermission(Permission)} with {@code perm}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MessageCommandSender#hasPermission(Permission)}
   */
  @Test
  @DisplayName(
      "Test hasPermission(Permission) with 'perm'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageCommandSender.hasPermission(Permission)"})
  void testHasPermissionWithPerm_thenThrowUnsupportedOperationException() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> bufferedCommandSender.hasPermission(new Permission("Name")));
  }

  /**
   * Test {@link MessageCommandSender#addAttachment(Plugin)} with {@code plugin}.
   *
   * <p>Method under test: {@link MessageCommandSender#addAttachment(Plugin)}
   */
  @Test
  @DisplayName("Test addAttachment(Plugin) with 'plugin'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionAttachment MessageCommandSender.addAttachment(Plugin)"})
  void testAddAttachmentWithPlugin() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> bufferedCommandSender.addAttachment(new TestPlugin("Plugin Name")));
  }

  /**
   * Test {@link MessageCommandSender#addAttachment(Plugin, String, boolean)} with {@code plugin},
   * {@code name}, {@code value}.
   *
   * <p>Method under test: {@link MessageCommandSender#addAttachment(Plugin, String, boolean)}
   */
  @Test
  @DisplayName("Test addAttachment(Plugin, String, boolean) with 'plugin', 'name', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PermissionAttachment MessageCommandSender.addAttachment(Plugin, String, boolean)"
  })
  void testAddAttachmentWithPluginNameValue() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> bufferedCommandSender.addAttachment(new TestPlugin("Plugin Name"), "Name", true));
  }

  /**
   * Test {@link MessageCommandSender#addAttachment(Plugin, String, boolean, int)} with {@code
   * plugin}, {@code name}, {@code value}, {@code ticks}.
   *
   * <p>Method under test: {@link MessageCommandSender#addAttachment(Plugin, String, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test addAttachment(Plugin, String, boolean, int) with 'plugin', 'name', 'value', 'ticks'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PermissionAttachment MessageCommandSender.addAttachment(Plugin, String, boolean, int)"
  })
  void testAddAttachmentWithPluginNameValueTicks() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> bufferedCommandSender.addAttachment(new TestPlugin("Plugin Name"), "Name", true, 2));
  }

  /**
   * Test {@link MessageCommandSender#addAttachment(Plugin, int)} with {@code plugin}, {@code
   * ticks}.
   *
   * <p>Method under test: {@link MessageCommandSender#addAttachment(Plugin, int)}
   */
  @Test
  @DisplayName("Test addAttachment(Plugin, int) with 'plugin', 'ticks'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionAttachment MessageCommandSender.addAttachment(Plugin, int)"})
  void testAddAttachmentWithPluginTicks() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> bufferedCommandSender.addAttachment(new TestPlugin("Plugin Name"), 2));
  }

  /**
   * Test {@link MessageCommandSender#removeAttachment(PermissionAttachment)}.
   *
   * <p>Method under test: {@link MessageCommandSender#removeAttachment(PermissionAttachment)}
   */
  @Test
  @DisplayName("Test removeAttachment(PermissionAttachment)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageCommandSender.removeAttachment(PermissionAttachment)"})
  void testRemoveAttachment() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment attachment = new PermissionAttachment(plugin, new BufferedCommandSender());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> bufferedCommandSender.removeAttachment(attachment));
  }

  /**
   * Test {@link MessageCommandSender#recalculatePermissions()}.
   *
   * <p>Method under test: {@link MessageCommandSender#recalculatePermissions()}
   */
  @Test
  @DisplayName("Test recalculatePermissions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageCommandSender.recalculatePermissions()"})
  void testRecalculatePermissions() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new BufferedCommandSender().recalculatePermissions());
  }

  /**
   * Test {@link MessageCommandSender#getEffectivePermissions()}.
   *
   * <p>Method under test: {@link MessageCommandSender#getEffectivePermissions()}
   */
  @Test
  @DisplayName("Test getEffectivePermissions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set MessageCommandSender.getEffectivePermissions()"})
  void testGetEffectivePermissions() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new BufferedCommandSender().getEffectivePermissions());
  }

  /**
   * Test {@link MessageCommandSender#spigot()}.
   *
   * <p>Method under test: {@link MessageCommandSender#spigot()}
   */
  @Test
  @DisplayName("Test spigot()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.command.CommandSender.Spigot MessageCommandSender.spigot()"})
  void testSpigot() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new BufferedCommandSender().spigot());
  }
}

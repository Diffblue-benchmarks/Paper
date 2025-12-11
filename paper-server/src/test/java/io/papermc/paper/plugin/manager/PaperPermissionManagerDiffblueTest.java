package io.papermc.paper.plugin.manager;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.brigadier.NullCommandSender;
import java.util.Map;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperPermissionManagerDiffblueTest {
  /**
   * Test {@link PaperPermissionManager#getPermission(String)}.
   *
   * <p>Method under test: {@link PaperPermissionManager#getPermission(String)}
   */
  @Test
  @DisplayName("Test getPermission(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission PaperPermissionManager.getPermission(String)"})
  void testGetPermission() {
    // Arrange, Act and Assert
    assertNull(new NormalPaperPermissionManager().getPermission("Name"));
  }

  /**
   * Test {@link PaperPermissionManager#addPermission(Permission)} with {@code perm}.
   *
   * <p>Method under test: {@link PaperPermissionManager#addPermission(Permission)}
   */
  @Test
  @DisplayName("Test addPermission(Permission) with 'perm'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPermissionManager.addPermission(Permission)"})
  void testAddPermissionWithPerm() {
    // Arrange
    NormalPaperPermissionManager normalPaperPermissionManager = new NormalPaperPermissionManager();
    Permission perm = new Permission("Name");

    // Act
    normalPaperPermissionManager.addPermission(perm);

    // Assert
    Map<String, Permission> permissionsResult = normalPaperPermissionManager.permissions();
    assertEquals(1, permissionsResult.size());
    assertEquals(1, normalPaperPermissionManager.getPermissions().size());
    assertSame(perm, permissionsResult.get("name"));
  }

  /**
   * Test {@link PaperPermissionManager#getDefaultPermissions(boolean)}.
   *
   * <ul>
   *   <li>Given {@link NormalPaperPermissionManager#NormalPaperPermissionManager()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperPermissionManager#getDefaultPermissions(boolean)}
   */
  @Test
  @DisplayName(
      "Test getDefaultPermissions(boolean); given NormalPaperPermissionManager(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PaperPermissionManager.getDefaultPermissions(boolean)"})
  void testGetDefaultPermissions_givenNormalPaperPermissionManager_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new NormalPaperPermissionManager().getDefaultPermissions(true).isEmpty());
  }

  /**
   * Test {@link PaperPermissionManager#getDefaultPermissions(boolean)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PaperPermissionManager#getDefaultPermissions(boolean)}
   */
  @Test
  @DisplayName("Test getDefaultPermissions(boolean); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PaperPermissionManager.getDefaultPermissions(boolean)"})
  void testGetDefaultPermissions_thenReturnSizeIsOne() {
    // Arrange
    NormalPaperPermissionManager normalPaperPermissionManager = new NormalPaperPermissionManager();
    normalPaperPermissionManager.addPermission(new Permission("Name"));

    // Act and Assert
    assertEquals(1, normalPaperPermissionManager.getDefaultPermissions(true).size());
  }

  /**
   * Test {@link PaperPermissionManager#removePermission(Permission)} with {@code perm}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPermissionManager#removePermission(Permission)}
   */
  @Test
  @DisplayName("Test removePermission(Permission) with 'perm'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPermissionManager.removePermission(Permission)"})
  void testRemovePermissionWithPerm_thenThrowIllegalArgumentException() {
    // Arrange
    NormalPaperPermissionManager normalPaperPermissionManager = new NormalPaperPermissionManager();

    Permission perm = mock(Permission.class);
    when(perm.getName()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> normalPaperPermissionManager.removePermission(perm));
    verify(perm).getName();
  }

  /**
   * Test {@link PaperPermissionManager#removePermission(Permission)} with {@code perm}.
   *
   * <ul>
   *   <li>When {@link Permission#Permission(String)} with {@code Name}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PaperPermissionManager#removePermission(Permission)}
   */
  @Test
  @DisplayName(
      "Test removePermission(Permission) with 'perm'; when Permission(String) with 'Name'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPermissionManager.removePermission(Permission)"})
  void testRemovePermissionWithPerm_whenPermissionWithName_thenDoesNotThrow() {
    // Arrange
    NormalPaperPermissionManager normalPaperPermissionManager = new NormalPaperPermissionManager();

    // Act and Assert
    assertDoesNotThrow(() -> normalPaperPermissionManager.removePermission(new Permission("Name")));
  }

  /**
   * Test {@link PaperPermissionManager#subscribeToPermission(String, Permissible)}.
   *
   * <p>Method under test: {@link PaperPermissionManager#subscribeToPermission(String, Permissible)}
   */
  @Test
  @DisplayName("Test subscribeToPermission(String, Permissible)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPermissionManager.subscribeToPermission(String, Permissible)"})
  void testSubscribeToPermission() {
    // Arrange
    NormalPaperPermissionManager normalPaperPermissionManager = new NormalPaperPermissionManager();

    // Act
    normalPaperPermissionManager.subscribeToPermission("Permission", NullCommandSender.INSTANCE);

    // Assert
    Map<String, Map<Permissible, Boolean>> permSubsResult = normalPaperPermissionManager.permSubs();
    assertEquals(1, permSubsResult.size());
    assertEquals(1, permSubsResult.get("permission").size());
  }

  /**
   * Test {@link PaperPermissionManager#getPermissionSubscriptions(String)}.
   *
   * <p>Method under test: {@link PaperPermissionManager#getPermissionSubscriptions(String)}
   */
  @Test
  @DisplayName("Test getPermissionSubscriptions(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PaperPermissionManager.getPermissionSubscriptions(String)"})
  void testGetPermissionSubscriptions() {
    // Arrange, Act and Assert
    assertTrue(
        new NormalPaperPermissionManager().getPermissionSubscriptions("Permission").isEmpty());
  }

  /**
   * Test {@link PaperPermissionManager#subscribeToDefaultPerms(boolean, Permissible)}.
   *
   * <p>Method under test: {@link PaperPermissionManager#subscribeToDefaultPerms(boolean,
   * Permissible)}
   */
  @Test
  @DisplayName("Test subscribeToDefaultPerms(boolean, Permissible)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPermissionManager.subscribeToDefaultPerms(boolean, Permissible)"})
  void testSubscribeToDefaultPerms() {
    // Arrange
    NormalPaperPermissionManager normalPaperPermissionManager = new NormalPaperPermissionManager();

    // Act
    normalPaperPermissionManager.subscribeToDefaultPerms(true, NullCommandSender.INSTANCE);

    // Assert
    Map<Boolean, Map<Permissible, Boolean>> defSubsResult = normalPaperPermissionManager.defSubs();
    assertEquals(1, defSubsResult.size());
    assertEquals(1, defSubsResult.get(true).size());
  }

  /**
   * Test {@link PaperPermissionManager#getDefaultPermSubscriptions(boolean)}.
   *
   * <p>Method under test: {@link PaperPermissionManager#getDefaultPermSubscriptions(boolean)}
   */
  @Test
  @DisplayName("Test getDefaultPermSubscriptions(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PaperPermissionManager.getDefaultPermSubscriptions(boolean)"})
  void testGetDefaultPermSubscriptions() {
    // Arrange, Act and Assert
    assertTrue(new NormalPaperPermissionManager().getDefaultPermSubscriptions(true).isEmpty());
  }

  /**
   * Test {@link PaperPermissionManager#getPermissions()}.
   *
   * <p>Method under test: {@link PaperPermissionManager#getPermissions()}
   */
  @Test
  @DisplayName("Test getPermissions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PaperPermissionManager.getPermissions()"})
  void testGetPermissions() {
    // Arrange, Act and Assert
    assertTrue(new NormalPaperPermissionManager().getPermissions().isEmpty());
  }
}

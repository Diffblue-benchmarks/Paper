package io.papermc.paper.plugin.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.Set;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NormalPaperPermissionManagerDiffblueTest {
  /**
   * Test {@link NormalPaperPermissionManager#NormalPaperPermissionManager()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * NormalPaperPermissionManager}
   */
  @Test
  @DisplayName("Test new NormalPaperPermissionManager()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NormalPaperPermissionManager.<init>()"})
  void testNewNormalPaperPermissionManager() {
    // Arrange and Act
    NormalPaperPermissionManager actualNormalPaperPermissionManager =
        new NormalPaperPermissionManager();

    // Assert
    Map<Boolean, Set<Permission>> defaultPermsResult =
        actualNormalPaperPermissionManager.defaultPerms();
    assertEquals(2, defaultPermsResult.size());
    assertTrue(actualNormalPaperPermissionManager.defSubs().isEmpty());
    assertTrue(actualNormalPaperPermissionManager.permSubs().isEmpty());
    assertTrue(actualNormalPaperPermissionManager.permissions().isEmpty());
    assertTrue(actualNormalPaperPermissionManager.getPermissions().isEmpty());
    assertTrue(defaultPermsResult.get(false).isEmpty());
    assertTrue(defaultPermsResult.get(true).isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NormalPaperPermissionManager#defSubs()}
   *   <li>{@link NormalPaperPermissionManager#defaultPerms()}
   *   <li>{@link NormalPaperPermissionManager#permSubs()}
   *   <li>{@link NormalPaperPermissionManager#permissions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map NormalPaperPermissionManager.defSubs()",
    "Map NormalPaperPermissionManager.defaultPerms()",
    "Map NormalPaperPermissionManager.permSubs()",
    "Map NormalPaperPermissionManager.permissions()"
  })
  void testGettersAndSetters() {
    // Arrange
    NormalPaperPermissionManager normalPaperPermissionManager = new NormalPaperPermissionManager();

    // Act
    Map<Boolean, Map<Permissible, Boolean>> actualDefSubsResult =
        normalPaperPermissionManager.defSubs();
    Map<Boolean, Set<Permission>> actualDefaultPermsResult =
        normalPaperPermissionManager.defaultPerms();
    Map<String, Map<Permissible, Boolean>> actualPermSubsResult =
        normalPaperPermissionManager.permSubs();
    Map<String, Permission> actualPermissionsResult = normalPaperPermissionManager.permissions();

    // Assert
    assertEquals(2, actualDefaultPermsResult.size());
    assertTrue(actualDefSubsResult.isEmpty());
    assertTrue(actualPermSubsResult.isEmpty());
    assertTrue(actualPermissionsResult.isEmpty());
    assertTrue(actualDefaultPermsResult.get(false).isEmpty());
    assertTrue(actualDefaultPermsResult.get(true).isEmpty());
  }
}

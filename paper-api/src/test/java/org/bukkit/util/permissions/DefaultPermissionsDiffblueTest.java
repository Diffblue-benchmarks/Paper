package org.bukkit.util.permissions;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.permissions.Permission;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DefaultPermissionsDiffblueTest {
  /**
   * Test {@link DefaultPermissions#registerPermission(Permission, Permission)} with {@code perm},
   * {@code parent}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultPermissions#registerPermission(Permission, Permission)}
   */
  @Test
  @DisplayName(
      "Test registerPermission(Permission, Permission) with 'perm', 'parent'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission DefaultPermissions.registerPermission(Permission, Permission)"})
  void testRegisterPermissionWithPermParent_thenThrowIllegalArgumentException() {
    // Arrange
    Permission perm = mock(Permission.class);
    when(perm.getName()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> DefaultPermissions.registerPermission(perm, new Permission("Name")));
    verify(perm).getName();
  }
}

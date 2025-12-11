package io.papermc.paper.plugin.manager;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.plugin.SimplePluginManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StupidSPMPermissionManagerWrapperDiffblueTest {
  /**
   * Test {@link StupidSPMPermissionManagerWrapper#permissions()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StupidSPMPermissionManagerWrapper#permissions()}
   */
  @Test
  @DisplayName("Test permissions(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map StupidSPMPermissionManagerWrapper.permissions()"})
  void testPermissions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new StupidSPMPermissionManagerWrapper(mock(SimplePluginManager.class)).permissions());
  }

  /**
   * Test {@link StupidSPMPermissionManagerWrapper#defaultPerms()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StupidSPMPermissionManagerWrapper#defaultPerms()}
   */
  @Test
  @DisplayName("Test defaultPerms(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map StupidSPMPermissionManagerWrapper.defaultPerms()"})
  void testDefaultPerms_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new StupidSPMPermissionManagerWrapper(mock(SimplePluginManager.class)).defaultPerms());
  }

  /**
   * Test {@link StupidSPMPermissionManagerWrapper#permSubs()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StupidSPMPermissionManagerWrapper#permSubs()}
   */
  @Test
  @DisplayName("Test permSubs(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map StupidSPMPermissionManagerWrapper.permSubs()"})
  void testPermSubs_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new StupidSPMPermissionManagerWrapper(mock(SimplePluginManager.class)).permSubs());
  }

  /**
   * Test {@link StupidSPMPermissionManagerWrapper#defSubs()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StupidSPMPermissionManagerWrapper#defSubs()}
   */
  @Test
  @DisplayName("Test defSubs(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map StupidSPMPermissionManagerWrapper.defSubs()"})
  void testDefSubs_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new StupidSPMPermissionManagerWrapper(mock(SimplePluginManager.class)).defSubs());
  }
}

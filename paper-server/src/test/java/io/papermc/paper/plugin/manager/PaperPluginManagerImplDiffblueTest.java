package io.papermc.paper.plugin.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.PermissionManager;
import org.bukkit.Server;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.SimplePluginManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperPluginManagerImplDiffblueTest {
  /**
   * Test {@link PaperPluginManagerImpl#PaperPluginManagerImpl(Server, CommandMap,
   * SimplePluginManager)}.
   *
   * <p>Method under test: {@link PaperPluginManagerImpl#PaperPluginManagerImpl(Server, CommandMap,
   * SimplePluginManager)}
   */
  @Test
  @DisplayName("Test new PaperPluginManagerImpl(Server, CommandMap, SimplePluginManager)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPluginManagerImpl.<init>(Server, CommandMap, SimplePluginManager)"})
  void testNewPaperPluginManagerImpl() {
    // Arrange and Act
    PaperPluginManagerImpl actualPaperPluginManagerImpl =
        new PaperPluginManagerImpl(
            mock(Server.class), mock(CommandMap.class), mock(SimplePluginManager.class));

    // Assert
    PermissionManager permissionManager = actualPaperPluginManagerImpl.permissionManager;
    assertTrue(permissionManager instanceof StupidSPMPermissionManagerWrapper);
    assertNull(((StupidSPMPermissionManagerWrapper) permissionManager).permissions());
    assertEquals(0, actualPaperPluginManagerImpl.instanceManager.getPlugins().length);
    assertEquals(0, actualPaperPluginManagerImpl.getPlugins().length);
  }
}

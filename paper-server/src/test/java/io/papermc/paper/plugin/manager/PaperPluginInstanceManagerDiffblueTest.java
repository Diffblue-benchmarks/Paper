package io.papermc.paper.plugin.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Server;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.PluginManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperPluginInstanceManagerDiffblueTest {
  /**
   * Test {@link PaperPluginInstanceManager#PaperPluginInstanceManager(PluginManager, CommandMap,
   * Server)}.
   *
   * <p>Method under test: {@link
   * PaperPluginInstanceManager#PaperPluginInstanceManager(PluginManager, CommandMap, Server)}
   */
  @Test
  @DisplayName("Test new PaperPluginInstanceManager(PluginManager, CommandMap, Server)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPluginInstanceManager.<init>(PluginManager, CommandMap, Server)"})
  void testNewPaperPluginInstanceManager() {
    // Arrange and Act
    PaperPluginInstanceManager actualPaperPluginInstanceManager =
        new PaperPluginInstanceManager(
            mock(PluginManager.class), mock(CommandMap.class), mock(Server.class));

    // Assert
    assertEquals(0, actualPaperPluginInstanceManager.getPlugins().length);
  }
}

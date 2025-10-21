package org.bukkit.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.logging.Logger;
import org.bukkit.Server;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginLoggerDiffblueTest {
  /**
   * Test {@link PluginLogger#PluginLogger(Plugin)}.
   *
   * <p>Method under test: {@link PluginLogger#PluginLogger(Plugin)}
   */
  @Test
  @DisplayName("Test new PluginLogger(Plugin)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginLogger.<init>(Plugin)"})
  void testNewPluginLogger() {
    // Arrange
    Server server = mock(Server.class);
    when(server.getLogger()).thenReturn(Logger.getGlobal());

    TestPlugin context = mock(TestPlugin.class);
    when(context.getServer()).thenReturn(server);
    PluginDescriptionFile pluginDescriptionFile =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");
    when(context.getDescription()).thenReturn(pluginDescriptionFile);

    // Act
    PluginLogger actualPluginLogger = new PluginLogger(context);

    // Assert
    verify(server).getLogger();
    verify(context, atLeast(1)).getDescription();
    verify(context).getServer();
    assertEquals("org.bukkit.plugin.TestPlugin", actualPluginLogger.getName());
    assertNull(actualPluginLogger.getResourceBundleName());
    assertNull(actualPluginLogger.getResourceBundle());
    assertNull(actualPluginLogger.getFilter());
    assertEquals(0, actualPluginLogger.getHandlers().length);
    assertTrue(actualPluginLogger.getUseParentHandlers());
    assertSame(Logger.global, actualPluginLogger.getParent());
  }

  /**
   * Test {@link PluginLogger#PluginLogger(Plugin)}.
   *
   * <ul>
   *   <li>Then calls {@link PluginDescriptionFile#getPrefix()}.
   * </ul>
   *
   * <p>Method under test: {@link PluginLogger#PluginLogger(Plugin)}
   */
  @Test
  @DisplayName("Test new PluginLogger(Plugin); then calls getPrefix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginLogger.<init>(Plugin)"})
  void testNewPluginLogger_thenCallsGetPrefix() {
    // Arrange
    PluginDescriptionFile pluginDescriptionFile = mock(PluginDescriptionFile.class);
    when(pluginDescriptionFile.getPrefix()).thenReturn("Prefix");

    Server server = mock(Server.class);
    when(server.getLogger()).thenReturn(Logger.getGlobal());

    TestPlugin context = mock(TestPlugin.class);
    when(context.getServer()).thenReturn(server);
    when(context.getDescription()).thenReturn(pluginDescriptionFile);

    // Act
    PluginLogger actualPluginLogger = new PluginLogger(context);

    // Assert
    verify(server).getLogger();
    verify(pluginDescriptionFile).getPrefix();
    verify(context).getDescription();
    verify(context).getServer();
    assertEquals("org.bukkit.plugin.TestPlugin", actualPluginLogger.getName());
    assertNull(actualPluginLogger.getResourceBundleName());
    assertNull(actualPluginLogger.getResourceBundle());
    assertNull(actualPluginLogger.getFilter());
    assertEquals(0, actualPluginLogger.getHandlers().length);
    assertTrue(actualPluginLogger.getUseParentHandlers());
    assertSame(Logger.global, actualPluginLogger.getParent());
  }
}

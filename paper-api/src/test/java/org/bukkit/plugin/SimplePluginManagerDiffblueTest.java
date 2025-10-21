package org.bukkit.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.command.defaults.HelpCommand;
import org.bukkit.permissions.Permission;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimplePluginManagerDiffblueTest {
  /**
   * Test {@link SimplePluginManager#SimplePluginManager(Server, SimpleCommandMap)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@link HelpCommand} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimplePluginManager#SimplePluginManager(Server, SimpleCommandMap)}
   */
  @Test
  @DisplayName(
      "Test new SimplePluginManager(Server, SimpleCommandMap); given 'foo'; when HashMap() 'foo' is HelpCommand (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplePluginManager.<init>(Server, SimpleCommandMap)"})
  void testNewSimplePluginManager_givenFoo_whenHashMapFooIsHelpCommand() {
    // Arrange
    Server instance = mock(Server.class);

    HashMap<String, Command> backing = new HashMap<>();
    backing.put("foo", new HelpCommand());
    SimpleCommandMap commandMap = new SimpleCommandMap(mock(Server.class), backing);

    // Act
    SimplePluginManager actualSimplePluginManager = new SimplePluginManager(instance, commandMap);

    // Assert
    assertNull(actualSimplePluginManager.paperPluginManager);
    Map<Boolean, Set<Permission>> resultBooleanSetMap = actualSimplePluginManager.defaultPerms;
    assertEquals(2, resultBooleanSetMap.size());
    assertTrue(actualSimplePluginManager.defSubs.isEmpty());
    assertTrue(actualSimplePluginManager.permSubs.isEmpty());
    assertTrue(actualSimplePluginManager.permissions.isEmpty());
    assertTrue(resultBooleanSetMap.get(false).isEmpty());
    assertTrue(resultBooleanSetMap.get(true).isEmpty());
  }

  /**
   * Test {@link SimplePluginManager#SimplePluginManager(Server, SimpleCommandMap)}.
   *
   * <ul>
   *   <li>When {@link SimpleCommandMap#SimpleCommandMap(Server, Map)} with {@link Server} and
   *       backing is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePluginManager#SimplePluginManager(Server, SimpleCommandMap)}
   */
  @Test
  @DisplayName(
      "Test new SimplePluginManager(Server, SimpleCommandMap); when SimpleCommandMap(Server, Map) with Server and backing is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplePluginManager.<init>(Server, SimpleCommandMap)"})
  void testNewSimplePluginManager_whenSimpleCommandMapWithServerAndBackingIsHashMap() {
    // Arrange
    Server instance = mock(Server.class);
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());

    // Act
    SimplePluginManager actualSimplePluginManager = new SimplePluginManager(instance, commandMap);

    // Assert
    assertNull(actualSimplePluginManager.paperPluginManager);
    Map<Boolean, Set<Permission>> resultBooleanSetMap = actualSimplePluginManager.defaultPerms;
    assertEquals(2, resultBooleanSetMap.size());
    assertTrue(actualSimplePluginManager.defSubs.isEmpty());
    assertTrue(actualSimplePluginManager.permSubs.isEmpty());
    assertTrue(actualSimplePluginManager.permissions.isEmpty());
    assertTrue(resultBooleanSetMap.get(false).isEmpty());
    assertTrue(resultBooleanSetMap.get(true).isEmpty());
  }

  /**
   * Test {@link SimplePluginManager#registerInterface(Class)}.
   *
   * <ul>
   *   <li>When {@code PluginLoader}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePluginManager#registerInterface(Class)}
   */
  @Test
  @DisplayName("Test registerInterface(Class); when 'org.bukkit.plugin.PluginLoader'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplePluginManager.registerInterface(Class)"})
  void testRegisterInterface_whenOrgBukkitPluginPluginLoader() throws IllegalArgumentException {
    // Arrange
    Server instance = mock(Server.class);
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());

    SimplePluginManager simplePluginManager = new SimplePluginManager(instance, commandMap);
    Class<PluginLoader> loader = PluginLoader.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> simplePluginManager.registerInterface(loader));
  }

  /**
   * Test {@link SimplePluginManager#loadPlugins(File[])} with {@code files}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link SimplePluginManager#loadPlugins(File[])}
   */
  @Test
  @DisplayName("Test loadPlugins(File[]) with 'files'; then return array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.plugin.Plugin[] SimplePluginManager.loadPlugins(File[])"})
  void testLoadPluginsWithFiles_thenReturnArrayLengthIsZero() {
    // Arrange
    Server instance = mock(Server.class);
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());

    SimplePluginManager simplePluginManager = new SimplePluginManager(instance, commandMap);

    // Act and Assert
    assertEquals(
        0,
        simplePluginManager.loadPlugins(
                new File[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()})
            .length);
  }

  /**
   * Test {@link SimplePluginManager#isTransitiveDepend(PluginDescriptionFile,
   * PluginDescriptionFile)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePluginManager#isTransitiveDepend(PluginDescriptionFile,
   * PluginDescriptionFile)}
   */
  @Test
  @DisplayName(
      "Test isTransitiveDepend(PluginDescriptionFile, PluginDescriptionFile); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimplePluginManager.isTransitiveDepend(PluginDescriptionFile, PluginDescriptionFile)"
  })
  void testIsTransitiveDepend_thenReturnFalse() {
    // Arrange
    Server instance = mock(Server.class);
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());

    SimplePluginManager simplePluginManager = new SimplePluginManager(instance, commandMap);
    PluginDescriptionFile plugin = new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");
    PluginDescriptionFile depend = new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");

    // Act and Assert
    assertFalse(simplePluginManager.isTransitiveDepend(plugin, depend));
  }
}

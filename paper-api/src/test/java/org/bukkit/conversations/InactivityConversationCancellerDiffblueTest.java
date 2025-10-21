package org.bukkit.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.configuration.PluginMeta;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.Server;
import org.bukkit.conversations.Conversation.ConversationState;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginAwareness;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoadOrder;
import org.bukkit.plugin.TestPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InactivityConversationCancellerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InactivityConversationCanceller#InactivityConversationCanceller(Plugin, int)}
   *   <li>{@link InactivityConversationCanceller#cancelling(Conversation)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InactivityConversationCanceller.<init>(Plugin, int)",
    "void InactivityConversationCanceller.cancelling(Conversation)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    InactivityConversationCanceller actualInactivityConversationCanceller =
        new InactivityConversationCanceller(new TestPlugin("Plugin Name"), 10);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    Conversation conversation = new Conversation(plugin, new FakeConversable(), mock(Prompt.class));
    actualInactivityConversationCanceller.cancelling(conversation);

    // Assert
    Plugin plugin2 = actualInactivityConversationCanceller.plugin;
    PluginMeta pluginMeta = plugin2.getPluginMeta();
    assertTrue(pluginMeta instanceof PluginDescriptionFile);
    assertTrue(plugin2 instanceof TestPlugin);
    assertEquals("1.0", pluginMeta.getVersion());
    PluginDescriptionFile description = plugin2.getDescription();
    assertEquals("1.0", description.getVersion());
    assertEquals("Plugin Name", description.getRawName());
    assertEquals("Plugin Name", ((PluginDescriptionFile) pluginMeta).getRawName());
    assertEquals("Plugin_Name v1.0", description.getDisplayName());
    assertEquals("Plugin_Name v1.0", pluginMeta.getDisplayName());
    assertEquals("Plugin_Name v1.0", description.getFullName());
    assertEquals("Plugin_Name v1.0", ((PluginDescriptionFile) pluginMeta).getFullName());
    assertEquals("Plugin_Name", pluginMeta.getName());
    assertEquals("Plugin_Name", plugin2.getName());
    assertEquals("Plugin_Name", description.getName());
    assertEquals("plugin_name", description.namespace());
    assertEquals("plugin_name", pluginMeta.namespace());
    assertEquals("plugin_name", plugin2.namespace());
    assertEquals("test.test", pluginMeta.getMainClass());
    assertEquals("test.test", description.getMain());
    assertEquals("test.test", ((PluginDescriptionFile) pluginMeta).getMain());
    assertEquals("test.test", description.getMainClass());
    assertNull(pluginMeta.getAPIVersion());
    assertNull(pluginMeta.getDescription());
    assertNull(pluginMeta.getLoggerPrefix());
    assertNull(pluginMeta.getWebsite());
    assertNull(description.getAPIVersion());
    assertNull(description.getClassLoaderOf());
    assertNull(((PluginDescriptionFile) pluginMeta).getClassLoaderOf());
    assertNull(description.getDescription());
    assertNull(description.getLoggerPrefix());
    assertNull(description.getPaperPluginLoader());
    assertNull(((PluginDescriptionFile) pluginMeta).getPaperPluginLoader());
    assertNull(description.getPrefix());
    assertNull(((PluginDescriptionFile) pluginMeta).getPrefix());
    assertNull(description.getWebsite());
    assertNull(pluginMeta.getAuthors());
    assertNull(pluginMeta.getContributors());
    assertNull(description.getAuthors());
    assertNull(description.getContributors());
    assertNull(actualInactivityConversationCanceller.conversation);
    assertEquals(10, actualInactivityConversationCanceller.timeoutSeconds);
    assertEquals(PermissionDefault.OP, pluginMeta.getPermissionDefault());
    assertEquals(PermissionDefault.OP, description.getPermissionDefault());
    assertEquals(PluginLoadOrder.POSTWORLD, pluginMeta.getLoadOrder());
    assertEquals(PluginLoadOrder.POSTWORLD, description.getLoad());
    assertEquals(PluginLoadOrder.POSTWORLD, ((PluginDescriptionFile) pluginMeta).getLoad());
    assertEquals(PluginLoadOrder.POSTWORLD, description.getLoadOrder());
    List<String> depend = description.getDepend();
    assertTrue(depend.isEmpty());
    Map<String, Map<String, Object>> commands = description.getCommands();
    assertTrue(commands.isEmpty());
    Set<PluginAwareness> awareness = description.getAwareness();
    assertTrue(awareness.isEmpty());
    assertTrue(plugin2.isEnabled());
    assertSame(awareness, ((PluginDescriptionFile) pluginMeta).getAwareness());
    assertSame(commands, ((PluginDescriptionFile) pluginMeta).getCommands());
    assertSame(depend, pluginMeta.getLoadBeforePlugins());
    assertSame(depend, pluginMeta.getPermissions());
    assertSame(depend, pluginMeta.getPluginDependencies());
    assertSame(depend, pluginMeta.getPluginSoftDependencies());
    assertSame(depend, pluginMeta.getProvidedPlugins());
    assertSame(depend, ((PluginDescriptionFile) pluginMeta).getDepend());
    assertSame(depend, description.getLibraries());
    assertSame(depend, ((PluginDescriptionFile) pluginMeta).getLibraries());
    assertSame(depend, description.getLoadBefore());
    assertSame(depend, ((PluginDescriptionFile) pluginMeta).getLoadBefore());
    assertSame(depend, description.getLoadBeforePlugins());
    assertSame(depend, description.getPermissions());
    assertSame(depend, description.getPluginDependencies());
    assertSame(depend, description.getPluginSoftDependencies());
    assertSame(depend, description.getProvidedPlugins());
    assertSame(depend, description.getProvides());
    assertSame(depend, ((PluginDescriptionFile) pluginMeta).getProvides());
    assertSame(depend, description.getSoftDepend());
    assertSame(depend, ((PluginDescriptionFile) pluginMeta).getSoftDepend());
  }

  /**
   * Test {@link InactivityConversationCanceller#setConversation(Conversation)}.
   *
   * <p>Method under test: {@link InactivityConversationCanceller#setConversation(Conversation)}
   */
  @Test
  @DisplayName("Test setConversation(Conversation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InactivityConversationCanceller.setConversation(Conversation)"})
  void testSetConversation() {
    // Arrange
    BukkitScheduler bukkitScheduler = mock(BukkitScheduler.class);
    when(bukkitScheduler.scheduleSyncDelayedTask(
            Mockito.<Plugin>any(), Mockito.<Runnable>any(), anyLong()))
        .thenReturn(1);

    Server server = mock(Server.class);
    when(server.getScheduler()).thenReturn(bukkitScheduler);

    TestPlugin plugin = mock(TestPlugin.class);
    when(plugin.getServer()).thenReturn(server);
    InactivityConversationCanceller inactivityConversationCanceller =
        new InactivityConversationCanceller(plugin, 10);
    TestPlugin plugin2 = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    Conversation conversation = new Conversation(plugin2, forWhom, mock(Prompt.class));

    // Act
    inactivityConversationCanceller.setConversation(conversation);

    // Assert
    verify(server).getScheduler();
    verify(plugin).getServer();
    verify(bukkitScheduler)
        .scheduleSyncDelayedTask(isA(Plugin.class), isA(Runnable.class), eq(200L));
    Conversation conversation2 = inactivityConversationCanceller.conversation;
    assertNull(conversation2.currentPrompt);
    assertEquals(ConversationState.UNSTARTED, conversation2.getState());
    assertTrue(conversation2.isLocalEchoEnabled());
    assertTrue(conversation2.isModal());
    assertSame(forWhom, conversation2.getForWhom());
    assertSame(conversation.abandonedListeners, conversation2.abandonedListeners);
  }

  /**
   * Test {@link InactivityConversationCanceller#cancelBasedOnInput(ConversationContext, String)}.
   *
   * <p>Method under test: {@link
   * InactivityConversationCanceller#cancelBasedOnInput(ConversationContext, String)}
   */
  @Test
  @DisplayName("Test cancelBasedOnInput(ConversationContext, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InactivityConversationCanceller.cancelBasedOnInput(ConversationContext, String)"
  })
  void testCancelBasedOnInput() {
    // Arrange
    BukkitScheduler bukkitScheduler = mock(BukkitScheduler.class);
    when(bukkitScheduler.scheduleSyncDelayedTask(
            Mockito.<Plugin>any(), Mockito.<Runnable>any(), anyLong()))
        .thenReturn(1);

    Server server = mock(Server.class);
    when(server.getScheduler()).thenReturn(bukkitScheduler);

    TestPlugin plugin = mock(TestPlugin.class);
    when(plugin.getServer()).thenReturn(server);
    InactivityConversationCanceller inactivityConversationCanceller =
        new InactivityConversationCanceller(plugin, 10);
    TestPlugin plugin2 = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    ConversationContext context = new ConversationContext(plugin2, forWhom, new HashMap<>());

    // Act
    boolean actualCancelBasedOnInputResult =
        inactivityConversationCanceller.cancelBasedOnInput(context, "Input");

    // Assert
    verify(server).getScheduler();
    verify(plugin).getServer();
    verify(bukkitScheduler)
        .scheduleSyncDelayedTask(isA(Plugin.class), isA(Runnable.class), eq(200L));
    assertFalse(actualCancelBasedOnInputResult);
  }

  /**
   * Test {@link InactivityConversationCanceller#cancelBasedOnInput(ConversationContext, String)}.
   *
   * <ul>
   *   <li>Then calls {@link BukkitScheduler#cancelTask(int)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InactivityConversationCanceller#cancelBasedOnInput(ConversationContext, String)}
   */
  @Test
  @DisplayName("Test cancelBasedOnInput(ConversationContext, String); then calls cancelTask(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InactivityConversationCanceller.cancelBasedOnInput(ConversationContext, String)"
  })
  void testCancelBasedOnInput_thenCallsCancelTask() {
    // Arrange
    BukkitScheduler bukkitScheduler = mock(BukkitScheduler.class);
    doNothing().when(bukkitScheduler).cancelTask(anyInt());
    when(bukkitScheduler.scheduleSyncDelayedTask(
            Mockito.<Plugin>any(), Mockito.<Runnable>any(), anyLong()))
        .thenReturn(1);

    Server server = mock(Server.class);
    when(server.getScheduler()).thenReturn(bukkitScheduler);

    TestPlugin plugin = mock(TestPlugin.class);
    when(plugin.getServer()).thenReturn(server);

    InactivityConversationCanceller inactivityConversationCanceller =
        new InactivityConversationCanceller(plugin, 10);
    TestPlugin plugin2 = new TestPlugin("Plugin Name");
    Conversation conversation =
        new Conversation(plugin2, new FakeConversable(), mock(Prompt.class));
    inactivityConversationCanceller.setConversation(conversation);
    TestPlugin plugin3 = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    ConversationContext context = new ConversationContext(plugin3, forWhom, new HashMap<>());

    // Act
    boolean actualCancelBasedOnInputResult =
        inactivityConversationCanceller.cancelBasedOnInput(context, "Input");

    // Assert
    verify(server, atLeast(1)).getScheduler();
    verify(plugin, atLeast(1)).getServer();
    verify(bukkitScheduler).cancelTask(1);
    verify(bukkitScheduler, atLeast(1))
        .scheduleSyncDelayedTask(isA(Plugin.class), Mockito.<Runnable>any(), eq(200L));
    assertFalse(actualCancelBasedOnInputResult);
  }

  /**
   * Test {@link InactivityConversationCanceller#clone()}.
   *
   * <p>Method under test: {@link InactivityConversationCanceller#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConversationCanceller InactivityConversationCanceller.clone()"})
  void testClone() {
    // Arrange and Act
    ConversationCanceller actualCloneResult =
        new InactivityConversationCanceller(new TestPlugin("Plugin Name"), 10).clone();

    // Assert
    assertTrue(actualCloneResult instanceof InactivityConversationCanceller);
    Plugin plugin = ((InactivityConversationCanceller) actualCloneResult).plugin;
    assertTrue(plugin.getPluginMeta() instanceof PluginDescriptionFile);
    assertTrue(plugin instanceof TestPlugin);
    assertEquals("Plugin_Name", plugin.getName());
    assertEquals("plugin_name", plugin.namespace());
    assertNull(((InactivityConversationCanceller) actualCloneResult).conversation);
    assertEquals(10, ((InactivityConversationCanceller) actualCloneResult).timeoutSeconds);
    assertTrue(plugin.isEnabled());
  }
}

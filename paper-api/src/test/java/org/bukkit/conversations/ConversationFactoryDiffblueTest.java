package org.bukkit.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConversationFactoryDiffblueTest {
  /**
   * Test {@link ConversationFactory#ConversationFactory(Plugin)}.
   *
   * <p>Method under test: {@link ConversationFactory#ConversationFactory(Plugin)}
   */
  @Test
  @DisplayName("Test new ConversationFactory(Plugin)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConversationFactory.<init>(Plugin)"})
  void testNewConversationFactory() {
    // Arrange and Act
    ConversationFactory actualConversationFactory =
        new ConversationFactory(new TestPlugin("Plugin Name"));

    // Assert
    assertTrue(actualConversationFactory.prefix instanceof NullConversationPrefix);
    Plugin plugin = actualConversationFactory.plugin;
    assertTrue(plugin.getPluginMeta() instanceof PluginDescriptionFile);
    assertTrue(plugin instanceof TestPlugin);
    assertEquals("Plugin_Name", plugin.getName());
    assertEquals("plugin_name", plugin.namespace());
    assertNull(actualConversationFactory.playerOnlyMessage);
    assertNull(actualConversationFactory.firstPrompt);
    assertTrue(actualConversationFactory.abandonedListeners.isEmpty());
    assertTrue(actualConversationFactory.cancellers.isEmpty());
    assertTrue(actualConversationFactory.initialSessionData.isEmpty());
    assertTrue(plugin.isEnabled());
    assertTrue(actualConversationFactory.isModal);
    assertTrue(actualConversationFactory.localEchoEnabled);
  }

  /**
   * Test {@link ConversationFactory#withTimeout(int)}.
   *
   * <p>Method under test: {@link ConversationFactory#withTimeout(int)}
   */
  @Test
  @DisplayName("Test withTimeout(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConversationFactory ConversationFactory.withTimeout(int)"})
  void testWithTimeout() {
    // Arrange
    ConversationFactory conversationFactory =
        new ConversationFactory(new TestPlugin("Plugin Name"));

    // Act
    ConversationFactory actualWithTimeoutResult = conversationFactory.withTimeout(10);

    // Assert
    assertEquals(1, conversationFactory.cancellers.size());
    assertSame(conversationFactory, actualWithTimeoutResult);
  }

  /**
   * Test {@link ConversationFactory#withEscapeSequence(String)}.
   *
   * <p>Method under test: {@link ConversationFactory#withEscapeSequence(String)}
   */
  @Test
  @DisplayName("Test withEscapeSequence(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConversationFactory ConversationFactory.withEscapeSequence(String)"})
  void testWithEscapeSequence() {
    // Arrange
    ConversationFactory conversationFactory =
        new ConversationFactory(new TestPlugin("Plugin Name"));

    // Act
    ConversationFactory actualWithEscapeSequenceResult =
        conversationFactory.withEscapeSequence("Escape Sequence");

    // Assert
    assertEquals(1, conversationFactory.cancellers.size());
    assertSame(conversationFactory, actualWithEscapeSequenceResult);
  }

  /**
   * Test {@link ConversationFactory#withConversationCanceller(ConversationCanceller)}.
   *
   * <p>Method under test: {@link
   * ConversationFactory#withConversationCanceller(ConversationCanceller)}
   */
  @Test
  @DisplayName("Test withConversationCanceller(ConversationCanceller)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConversationFactory ConversationFactory.withConversationCanceller(ConversationCanceller)"
  })
  void testWithConversationCanceller() {
    // Arrange
    ConversationFactory conversationFactory =
        new ConversationFactory(new TestPlugin("Plugin Name"));

    // Act
    ConversationFactory actualWithConversationCancellerResult =
        conversationFactory.withConversationCanceller(new ManuallyAbandonedConversationCanceller());

    // Assert
    assertEquals(1, conversationFactory.cancellers.size());
    assertSame(conversationFactory, actualWithConversationCancellerResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConversationFactory#thatExcludesNonPlayersWithMessage(String)}
   *   <li>{@link ConversationFactory#withFirstPrompt(Prompt)}
   *   <li>{@link ConversationFactory#withInitialSessionData(Map)}
   *   <li>{@link ConversationFactory#withLocalEcho(boolean)}
   *   <li>{@link ConversationFactory#withModality(boolean)}
   *   <li>{@link ConversationFactory#withPrefix(ConversationPrefix)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConversationFactory ConversationFactory.thatExcludesNonPlayersWithMessage(String)",
    "ConversationFactory ConversationFactory.withFirstPrompt(Prompt)",
    "ConversationFactory ConversationFactory.withInitialSessionData(Map)",
    "ConversationFactory ConversationFactory.withLocalEcho(boolean)",
    "ConversationFactory ConversationFactory.withModality(boolean)",
    "ConversationFactory ConversationFactory.withPrefix(ConversationPrefix)"
  })
  void testGettersAndSetters() {
    // Arrange
    ConversationFactory conversationFactory =
        new ConversationFactory(new TestPlugin("Plugin Name"));

    // Act
    ConversationFactory actualThatExcludesNonPlayersWithMessageResult =
        conversationFactory.thatExcludesNonPlayersWithMessage("Player Only Message");
    ConversationFactory actualWithFirstPromptResult =
        conversationFactory.withFirstPrompt(mock(Prompt.class));
    ConversationFactory actualWithInitialSessionDataResult =
        conversationFactory.withInitialSessionData(new HashMap<>());
    ConversationFactory actualWithLocalEchoResult = conversationFactory.withLocalEcho(true);
    ConversationFactory actualWithModalityResult = conversationFactory.withModality(true);
    ConversationFactory actualWithPrefixResult =
        conversationFactory.withPrefix(mock(ConversationPrefix.class));

    // Assert
    assertSame(conversationFactory, actualThatExcludesNonPlayersWithMessageResult);
    assertSame(conversationFactory, actualWithFirstPromptResult);
    assertSame(conversationFactory, actualWithInitialSessionDataResult);
    assertSame(conversationFactory, actualWithLocalEchoResult);
    assertSame(conversationFactory, actualWithModalityResult);
    assertSame(conversationFactory, actualWithPrefixResult);
  }

  /**
   * Test {@link
   * ConversationFactory#addConversationAbandonedListener(ConversationAbandonedListener)}.
   *
   * <p>Method under test: {@link
   * ConversationFactory#addConversationAbandonedListener(ConversationAbandonedListener)}
   */
  @Test
  @DisplayName("Test addConversationAbandonedListener(ConversationAbandonedListener)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConversationFactory ConversationFactory.addConversationAbandonedListener(ConversationAbandonedListener)"
  })
  void testAddConversationAbandonedListener() {
    // Arrange
    ConversationFactory conversationFactory =
        new ConversationFactory(new TestPlugin("Plugin Name"));

    // Act
    ConversationFactory actualAddConversationAbandonedListenerResult =
        conversationFactory.addConversationAbandonedListener(
            mock(ConversationAbandonedListener.class));

    // Assert
    assertEquals(1, conversationFactory.abandonedListeners.size());
    assertSame(conversationFactory, actualAddConversationAbandonedListenerResult);
  }

  /**
   * Test {@link ConversationFactory#buildConversation(Conversable)}.
   *
   * <ul>
   *   <li>Given {@link ConversationFactory#ConversationFactory(Plugin)} with plugin is {@link
   *       TestPlugin#TestPlugin(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ConversationFactory#buildConversation(Conversable)}
   */
  @Test
  @DisplayName(
      "Test buildConversation(Conversable); given ConversationFactory(Plugin) with plugin is TestPlugin(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Conversation ConversationFactory.buildConversation(Conversable)"})
  void testBuildConversation_givenConversationFactoryWithPluginIsTestPlugin() {
    // Arrange
    ConversationFactory conversationFactory =
        new ConversationFactory(new TestPlugin("Plugin Name"));
    FakeConversable forWhom = new FakeConversable();

    // Act
    Conversation actualBuildConversationResult = conversationFactory.buildConversation(forWhom);

    // Assert
    assertTrue(actualBuildConversationResult.abandonedListeners.isEmpty());
    assertSame(forWhom, actualBuildConversationResult.getForWhom());
    assertSame(forWhom, actualBuildConversationResult.getContext().getForWhom());
    assertSame(conversationFactory.prefix, actualBuildConversationResult.getPrefix());
  }

  /**
   * Test {@link ConversationFactory#buildConversation(Conversable)}.
   *
   * <ul>
   *   <li>Then Context Plugin PluginMeta return {@link PluginDescriptionFile}.
   * </ul>
   *
   * <p>Method under test: {@link ConversationFactory#buildConversation(Conversable)}
   */
  @Test
  @DisplayName(
      "Test buildConversation(Conversable); then Context Plugin PluginMeta return PluginDescriptionFile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Conversation ConversationFactory.buildConversation(Conversable)"})
  void testBuildConversation_thenContextPluginPluginMetaReturnPluginDescriptionFile() {
    // Arrange
    ConversationFactory conversationFactory =
        new ConversationFactory(new TestPlugin("Plugin Name"));
    conversationFactory.thatExcludesNonPlayersWithMessage("Player Only Message");
    conversationFactory.addConversationAbandonedListener(mock(ConversationAbandonedListener.class));
    Player forWhom = mock(Player.class);

    // Act
    Conversation actualBuildConversationResult = conversationFactory.buildConversation(forWhom);

    // Assert
    ConversationContext context = actualBuildConversationResult.getContext();
    Plugin plugin = context.getPlugin();
    assertTrue(plugin.getPluginMeta() instanceof PluginDescriptionFile);
    assertTrue(plugin instanceof TestPlugin);
    assertSame(forWhom, actualBuildConversationResult.getForWhom());
    assertSame(forWhom, context.getForWhom());
  }

  /**
   * Test {@link ConversationFactory#buildConversation(Conversable)}.
   *
   * <ul>
   *   <li>Then return {@link Conversation#abandonedListeners} Empty.
   * </ul>
   *
   * <p>Method under test: {@link ConversationFactory#buildConversation(Conversable)}
   */
  @Test
  @DisplayName("Test buildConversation(Conversable); then return abandonedListeners Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Conversation ConversationFactory.buildConversation(Conversable)"})
  void testBuildConversation_thenReturnAbandonedListenersEmpty() {
    // Arrange
    ConversationFactory conversationFactory =
        new ConversationFactory(new TestPlugin("Plugin Name"));
    conversationFactory.thatExcludesNonPlayersWithMessage("Player Only Message");
    conversationFactory.addConversationAbandonedListener(mock(ConversationAbandonedListener.class));
    FakeConversable forWhom = new FakeConversable();

    // Act
    Conversation actualBuildConversationResult = conversationFactory.buildConversation(forWhom);

    // Assert
    assertTrue(actualBuildConversationResult.abandonedListeners.isEmpty());
    assertSame(forWhom, actualBuildConversationResult.getForWhom());
    assertSame(forWhom, actualBuildConversationResult.getContext().getForWhom());
  }

  /**
   * Test {@link ConversationFactory#buildConversation(Conversable)}.
   *
   * <ul>
   *   <li>Then return {@link Conversation#abandonedListeners} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ConversationFactory#buildConversation(Conversable)}
   */
  @Test
  @DisplayName("Test buildConversation(Conversable); then return abandonedListeners size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Conversation ConversationFactory.buildConversation(Conversable)"})
  void testBuildConversation_thenReturnAbandonedListenersSizeIsOne() {
    // Arrange
    ConversationFactory conversationFactory =
        new ConversationFactory(new TestPlugin("Plugin Name"));
    conversationFactory.addConversationAbandonedListener(mock(ConversationAbandonedListener.class));
    FakeConversable forWhom = new FakeConversable();

    // Act
    Conversation actualBuildConversationResult = conversationFactory.buildConversation(forWhom);

    // Assert
    assertEquals(1, actualBuildConversationResult.abandonedListeners.size());
    assertSame(forWhom, actualBuildConversationResult.getForWhom());
    assertSame(forWhom, actualBuildConversationResult.getContext().getForWhom());
    assertSame(conversationFactory.prefix, actualBuildConversationResult.getPrefix());
  }
}

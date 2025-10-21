package org.bukkit.conversations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConversationAbandonedEventDiffblueTest {
  /**
   * Test {@link ConversationAbandonedEvent#ConversationAbandonedEvent(Conversation)}.
   *
   * <p>Method under test: {@link
   * ConversationAbandonedEvent#ConversationAbandonedEvent(Conversation)}
   */
  @Test
  @DisplayName("Test new ConversationAbandonedEvent(Conversation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConversationAbandonedEvent.<init>(Conversation)"})
  void testNewConversationAbandonedEvent() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    Conversation conversation = new Conversation(plugin, forWhom, mock(Prompt.class));

    // Act
    ConversationAbandonedEvent actualConversationAbandonedEvent =
        new ConversationAbandonedEvent(conversation);

    // Assert
    ConversationContext context = actualConversationAbandonedEvent.getContext();
    Conversable forWhom2 = context.getForWhom();
    assertTrue(forWhom2 instanceof FakeConversable);
    Plugin plugin2 = context.getPlugin();
    assertTrue(plugin2 instanceof TestPlugin);
    assertNull(actualConversationAbandonedEvent.getCanceller());
    assertTrue(context.getAllSessionData().isEmpty());
    assertSame(conversation, actualConversationAbandonedEvent.getSource());
    assertSame(forWhom, forWhom2);
    assertSame(plugin, plugin2);
  }

  /**
   * Test {@link ConversationAbandonedEvent#ConversationAbandonedEvent(Conversation,
   * ConversationCanceller)}.
   *
   * <p>Method under test: {@link
   * ConversationAbandonedEvent#ConversationAbandonedEvent(Conversation, ConversationCanceller)}
   */
  @Test
  @DisplayName("Test new ConversationAbandonedEvent(Conversation, ConversationCanceller)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConversationAbandonedEvent.<init>(Conversation, ConversationCanceller)"})
  void testNewConversationAbandonedEvent2() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    Conversation conversation = new Conversation(plugin, forWhom, mock(Prompt.class));
    ManuallyAbandonedConversationCanceller canceller = new ManuallyAbandonedConversationCanceller();

    // Act
    ConversationAbandonedEvent actualConversationAbandonedEvent =
        new ConversationAbandonedEvent(conversation, canceller);

    // Assert
    ConversationContext context = actualConversationAbandonedEvent.getContext();
    Conversable forWhom2 = context.getForWhom();
    assertTrue(forWhom2 instanceof FakeConversable);
    ConversationCanceller canceller2 = actualConversationAbandonedEvent.getCanceller();
    assertTrue(canceller2 instanceof ManuallyAbandonedConversationCanceller);
    Plugin plugin2 = context.getPlugin();
    assertTrue(plugin2 instanceof TestPlugin);
    assertTrue(context.getAllSessionData().isEmpty());
    assertSame(conversation, actualConversationAbandonedEvent.getSource());
    assertSame(forWhom, forWhom2);
    assertSame(canceller, canceller2);
    assertSame(plugin, plugin2);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConversationAbandonedEvent#getCanceller()}
   *   <li>{@link ConversationAbandonedEvent#getContext()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConversationCanceller ConversationAbandonedEvent.getCanceller()",
    "ConversationContext ConversationAbandonedEvent.getContext()"
  })
  void testGettersAndSetters() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    Conversation conversation = new Conversation(plugin, forWhom, mock(Prompt.class));
    ConversationAbandonedEvent conversationAbandonedEvent =
        new ConversationAbandonedEvent(conversation);

    // Act
    ConversationCanceller actualCanceller = conversationAbandonedEvent.getCanceller();
    ConversationContext actualContext = conversationAbandonedEvent.getContext();

    // Assert
    assertNull(actualCanceller);
    assertTrue(actualContext.getAllSessionData().isEmpty());
    assertSame(forWhom, actualContext.getForWhom());
    assertSame(plugin, actualContext.getPlugin());
  }

  /**
   * Test {@link ConversationAbandonedEvent#gracefulExit()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ConversationAbandonedEvent#gracefulExit()}
   */
  @Test
  @DisplayName("Test gracefulExit(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ConversationAbandonedEvent.gracefulExit()"})
  void testGracefulExit_thenReturnFalse() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    Conversation conversation = new Conversation(plugin, new FakeConversable(), mock(Prompt.class));
    ConversationAbandonedEvent conversationAbandonedEvent =
        new ConversationAbandonedEvent(conversation, new ManuallyAbandonedConversationCanceller());

    // Act and Assert
    assertFalse(conversationAbandonedEvent.gracefulExit());
  }

  /**
   * Test {@link ConversationAbandonedEvent#gracefulExit()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConversationAbandonedEvent#gracefulExit()}
   */
  @Test
  @DisplayName("Test gracefulExit(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ConversationAbandonedEvent.gracefulExit()"})
  void testGracefulExit_thenReturnTrue() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    Conversation conversation = new Conversation(plugin, new FakeConversable(), mock(Prompt.class));

    // Act and Assert
    assertTrue(new ConversationAbandonedEvent(conversation).gracefulExit());
  }
}

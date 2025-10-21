package org.bukkit.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.conversations.Conversation.ConversationState;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConversationDiffblueTest {
  /**
   * Test {@link Conversation#Conversation(Plugin, Conversable, Prompt)}.
   *
   * <p>Method under test: {@link Conversation#Conversation(Plugin, Conversable, Prompt)}
   */
  @Test
  @DisplayName("Test new Conversation(Plugin, Conversable, Prompt)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Conversation.<init>(Plugin, Conversable, Prompt)"})
  void testNewConversation() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    // Act
    Conversation actualConversation = new Conversation(plugin, forWhom, mock(Prompt.class));

    // Assert
    Conversable forWhom2 = actualConversation.getForWhom();
    assertTrue(forWhom2 instanceof FakeConversable);
    assertTrue(actualConversation.getPrefix() instanceof NullConversationPrefix);
    assertNull(actualConversation.currentPrompt);
    assertEquals(ConversationState.UNSTARTED, actualConversation.getState());
    assertTrue(actualConversation.getCancellers().isEmpty());
    assertTrue(actualConversation.abandonedListeners.isEmpty());
    assertTrue(actualConversation.isLocalEchoEnabled());
    assertTrue(actualConversation.isModal());
    assertSame(forWhom, forWhom2);
  }

  /**
   * Test {@link Conversation#Conversation(Plugin, Conversable, Prompt, Map)}.
   *
   * <p>Method under test: {@link Conversation#Conversation(Plugin, Conversable, Prompt, Map)}
   */
  @Test
  @DisplayName("Test new Conversation(Plugin, Conversable, Prompt, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Conversation.<init>(Plugin, Conversable, Prompt, Map)"})
  void testNewConversation2() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();
    Prompt firstPrompt = mock(Prompt.class);

    // Act
    Conversation actualConversation =
        new Conversation(plugin, forWhom, firstPrompt, new HashMap<>());

    // Assert
    Conversable forWhom2 = actualConversation.getForWhom();
    assertTrue(forWhom2 instanceof FakeConversable);
    assertTrue(actualConversation.getPrefix() instanceof NullConversationPrefix);
    assertNull(actualConversation.currentPrompt);
    assertEquals(ConversationState.UNSTARTED, actualConversation.getState());
    assertTrue(actualConversation.getCancellers().isEmpty());
    assertTrue(actualConversation.abandonedListeners.isEmpty());
    assertTrue(actualConversation.isLocalEchoEnabled());
    assertTrue(actualConversation.isModal());
    assertSame(forWhom, forWhom2);
  }

  /**
   * Test {@link Conversation#getForWhom()}.
   *
   * <p>Method under test: {@link Conversation#getForWhom()}
   */
  @Test
  @DisplayName("Test getForWhom()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Conversable Conversation.getForWhom()"})
  void testGetForWhom() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    Conversation conversation = new Conversation(plugin, forWhom, mock(Prompt.class));

    // Act and Assert
    assertSame(forWhom, conversation.getForWhom());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Conversation#setLocalEchoEnabled(boolean)}
   *   <li>{@link Conversation#setModal(boolean)}
   *   <li>{@link Conversation#setPrefix(ConversationPrefix)}
   *   <li>{@link Conversation#getCancellers()}
   *   <li>{@link Conversation#getContext()}
   *   <li>{@link Conversation#getPrefix()}
   *   <li>{@link Conversation#isLocalEchoEnabled()}
   *   <li>{@link Conversation#isModal()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List Conversation.getCancellers()",
    "ConversationContext Conversation.getContext()",
    "ConversationPrefix Conversation.getPrefix()",
    "boolean Conversation.isLocalEchoEnabled()",
    "boolean Conversation.isModal()",
    "void Conversation.setLocalEchoEnabled(boolean)",
    "void Conversation.setModal(boolean)",
    "void Conversation.setPrefix(ConversationPrefix)"
  })
  void testGettersAndSetters() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    Conversation conversation = new Conversation(plugin, forWhom, mock(Prompt.class));

    // Act
    conversation.setLocalEchoEnabled(true);
    conversation.setModal(true);
    ConversationPrefix prefix = mock(ConversationPrefix.class);
    conversation.setPrefix(prefix);
    List<ConversationCanceller> actualCancellers = conversation.getCancellers();
    ConversationContext actualContext = conversation.getContext();
    ConversationPrefix actualPrefix = conversation.getPrefix();
    boolean actualIsLocalEchoEnabledResult = conversation.isLocalEchoEnabled();
    boolean actualIsModalResult = conversation.isModal();

    // Assert
    assertTrue(actualCancellers.isEmpty());
    assertTrue(actualContext.getAllSessionData().isEmpty());
    assertTrue(actualIsLocalEchoEnabledResult);
    assertTrue(actualIsModalResult);
    assertSame(forWhom, actualContext.getForWhom());
    assertSame(plugin, actualContext.getPlugin());
    assertSame(prefix, actualPrefix);
  }

  /**
   * Test {@link Conversation#begin()}.
   *
   * <p>Method under test: {@link Conversation#begin()}
   */
  @Test
  @DisplayName("Test begin()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Conversation.begin()"})
  void testBegin() {
    // Arrange
    Prompt firstPrompt = mock(Prompt.class);
    when(firstPrompt.blocksForInput(Mockito.<ConversationContext>any())).thenReturn(true);
    when(firstPrompt.getPromptText(Mockito.<ConversationContext>any())).thenReturn("Prompt Text");
    TestPlugin plugin = new TestPlugin("Plugin Name");

    Conversation conversation = new Conversation(plugin, new FakeConversable(), firstPrompt);

    // Act
    conversation.begin();

    // Assert
    verify(firstPrompt).blocksForInput(isA(ConversationContext.class));
    verify(firstPrompt).getPromptText(isA(ConversationContext.class));
    Conversable forWhom = conversation.getForWhom();
    assertTrue(forWhom instanceof FakeConversable);
    assertEquals("Prompt Text", ((FakeConversable) forWhom).lastSentMessage);
    assertEquals(ConversationState.STARTED, conversation.getState());
    assertSame(conversation, ((FakeConversable) forWhom).begunConversation);
  }

  /**
   * Test {@link Conversation#begin()}.
   *
   * <p>Method under test: {@link Conversation#begin()}
   */
  @Test
  @DisplayName("Test begin()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Conversation.begin()"})
  void testBegin2() {
    // Arrange
    Prompt prompt = mock(Prompt.class);
    when(prompt.blocksForInput(Mockito.<ConversationContext>any())).thenReturn(true);
    when(prompt.getPromptText(Mockito.<ConversationContext>any())).thenReturn("Prompt Text");

    Prompt firstPrompt = mock(Prompt.class);
    when(firstPrompt.blocksForInput(Mockito.<ConversationContext>any())).thenReturn(false);
    when(firstPrompt.getPromptText(Mockito.<ConversationContext>any())).thenReturn("Prompt Text");
    when(firstPrompt.acceptInput(Mockito.<ConversationContext>any(), Mockito.<String>any()))
        .thenReturn(prompt);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    Conversation conversation = new Conversation(plugin, forWhom, firstPrompt, new HashMap<>());

    // Act
    conversation.begin();

    // Assert
    verify(firstPrompt).acceptInput(isA(ConversationContext.class), isNull());
    verify(firstPrompt).blocksForInput(isA(ConversationContext.class));
    verify(prompt).blocksForInput(isA(ConversationContext.class));
    verify(firstPrompt).getPromptText(isA(ConversationContext.class));
    verify(prompt).getPromptText(isA(ConversationContext.class));
    Conversable forWhom2 = conversation.getForWhom();
    assertTrue(forWhom2 instanceof FakeConversable);
    assertEquals("Prompt Text", ((FakeConversable) forWhom2).lastSentMessage);
    assertEquals(ConversationState.STARTED, conversation.getState());
    assertSame(conversation, ((FakeConversable) forWhom2).begunConversation);
  }

  /**
   * Test {@link Conversation#getState()}.
   *
   * <p>Method under test: {@link Conversation#getState()}
   */
  @Test
  @DisplayName("Test getState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConversationState Conversation.getState()"})
  void testGetState() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    Conversation conversation = new Conversation(plugin, new FakeConversable(), mock(Prompt.class));

    // Act and Assert
    assertEquals(ConversationState.UNSTARTED, conversation.getState());
  }

  /**
   * Test {@link Conversation#addConversationAbandonedListener(ConversationAbandonedListener)}.
   *
   * <p>Method under test: {@link
   * Conversation#addConversationAbandonedListener(ConversationAbandonedListener)}
   */
  @Test
  @DisplayName("Test addConversationAbandonedListener(ConversationAbandonedListener)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Conversation.addConversationAbandonedListener(ConversationAbandonedListener)"
  })
  void testAddConversationAbandonedListener() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    Conversation conversation = new Conversation(plugin, new FakeConversable(), mock(Prompt.class));
    ConversationAbandonedListener listener = mock(ConversationAbandonedListener.class);

    // Act
    conversation.addConversationAbandonedListener(listener);

    // Assert
    List<ConversationAbandonedListener> conversationAbandonedListenerList =
        conversation.abandonedListeners;
    assertEquals(1, conversationAbandonedListenerList.size());
    assertSame(listener, conversationAbandonedListenerList.get(0));
  }

  /**
   * Test {@link Conversation#abandon()}.
   *
   * <p>Method under test: {@link Conversation#abandon()}
   */
  @Test
  @DisplayName("Test abandon()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Conversation.abandon()"})
  void testAbandon() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    Conversation conversation = new Conversation(plugin, new FakeConversable(), mock(Prompt.class));

    // Act
    conversation.abandon();

    // Assert
    Conversable forWhom = conversation.getForWhom();
    assertTrue(forWhom instanceof FakeConversable);
    assertEquals(ConversationState.ABANDONED, conversation.getState());
    assertSame(conversation, ((FakeConversable) forWhom).abandonedConverstion);
  }

  /**
   * Test {@link Conversation#abandon(ConversationAbandonedEvent)} with {@code
   * ConversationAbandonedEvent}.
   *
   * <p>Method under test: {@link Conversation#abandon(ConversationAbandonedEvent)}
   */
  @Test
  @DisplayName("Test abandon(ConversationAbandonedEvent) with 'ConversationAbandonedEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Conversation.abandon(ConversationAbandonedEvent)"})
  void testAbandonWithConversationAbandonedEvent() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    Conversation conversation = new Conversation(plugin, new FakeConversable(), mock(Prompt.class));
    TestPlugin plugin2 = new TestPlugin("Plugin Name");
    Conversation conversation2 =
        new Conversation(plugin2, new FakeConversable(), mock(Prompt.class));

    // Act
    conversation.abandon(new ConversationAbandonedEvent(conversation2));

    // Assert
    Conversable forWhom = conversation.getForWhom();
    assertTrue(forWhom instanceof FakeConversable);
    assertEquals(ConversationState.ABANDONED, conversation.getState());
    assertSame(conversation, ((FakeConversable) forWhom).abandonedConverstion);
  }

  /**
   * Test {@link Conversation#outputNextPrompt()}.
   *
   * <p>Method under test: {@link Conversation#outputNextPrompt()}
   */
  @Test
  @DisplayName("Test outputNextPrompt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Conversation.outputNextPrompt()"})
  void testOutputNextPrompt() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    Conversation conversation = new Conversation(plugin, new FakeConversable(), mock(Prompt.class));

    // Act
    conversation.outputNextPrompt();

    // Assert
    Conversable forWhom = conversation.getForWhom();
    assertTrue(forWhom instanceof FakeConversable);
    assertEquals(ConversationState.ABANDONED, conversation.getState());
    assertSame(conversation, ((FakeConversable) forWhom).abandonedConverstion);
  }
}

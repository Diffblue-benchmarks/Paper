package org.bukkit.conversations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ManuallyAbandonedConversationCancellerDiffblueTest {
  /**
   * Test {@link ManuallyAbandonedConversationCanceller#setConversation(Conversation)}.
   *
   * <p>Method under test: {@link
   * ManuallyAbandonedConversationCanceller#setConversation(Conversation)}
   */
  @Test
  @DisplayName("Test setConversation(Conversation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ManuallyAbandonedConversationCanceller.setConversation(Conversation)"})
  void testSetConversation() {
    // Arrange
    ManuallyAbandonedConversationCanceller manuallyAbandonedConversationCanceller =
        new ManuallyAbandonedConversationCanceller();
    TestPlugin plugin = new TestPlugin("Plugin Name");
    Conversation conversation = new Conversation(plugin, new FakeConversable(), mock(Prompt.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> manuallyAbandonedConversationCanceller.setConversation(conversation));
  }

  /**
   * Test {@link ManuallyAbandonedConversationCanceller#cancelBasedOnInput(ConversationContext,
   * String)}.
   *
   * <p>Method under test: {@link
   * ManuallyAbandonedConversationCanceller#cancelBasedOnInput(ConversationContext, String)}
   */
  @Test
  @DisplayName("Test cancelBasedOnInput(ConversationContext, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ManuallyAbandonedConversationCanceller.cancelBasedOnInput(ConversationContext, String)"
  })
  void testCancelBasedOnInput() {
    // Arrange
    ManuallyAbandonedConversationCanceller manuallyAbandonedConversationCanceller =
        new ManuallyAbandonedConversationCanceller();
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    ConversationContext context = new ConversationContext(plugin, forWhom, new HashMap<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> manuallyAbandonedConversationCanceller.cancelBasedOnInput(context, "Input"));
  }

  /**
   * Test {@link ManuallyAbandonedConversationCanceller#clone()}.
   *
   * <p>Method under test: {@link ManuallyAbandonedConversationCanceller#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConversationCanceller ManuallyAbandonedConversationCanceller.clone()"})
  void testClone() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new ManuallyAbandonedConversationCanceller().clone());
  }
}

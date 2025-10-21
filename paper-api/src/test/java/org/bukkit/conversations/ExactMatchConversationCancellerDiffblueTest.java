package org.bukkit.conversations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExactMatchConversationCancellerDiffblueTest {
  /**
   * Test {@link ExactMatchConversationCanceller#cancelBasedOnInput(ConversationContext, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ExactMatchConversationCanceller#cancelBasedOnInput(ConversationContext, String)}
   */
  @Test
  @DisplayName("Test cancelBasedOnInput(ConversationContext, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ExactMatchConversationCanceller.cancelBasedOnInput(ConversationContext, String)"
  })
  void testCancelBasedOnInput_thenReturnFalse() {
    // Arrange
    ExactMatchConversationCanceller exactMatchConversationCanceller =
        new ExactMatchConversationCanceller("Escape Sequence");
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    ConversationContext context = new ConversationContext(plugin, forWhom, new HashMap<>());

    // Act and Assert
    assertFalse(exactMatchConversationCanceller.cancelBasedOnInput(context, "Input"));
  }

  /**
   * Test {@link ExactMatchConversationCanceller#cancelBasedOnInput(ConversationContext, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ExactMatchConversationCanceller#cancelBasedOnInput(ConversationContext, String)}
   */
  @Test
  @DisplayName("Test cancelBasedOnInput(ConversationContext, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ExactMatchConversationCanceller.cancelBasedOnInput(ConversationContext, String)"
  })
  void testCancelBasedOnInput_thenReturnTrue() {
    // Arrange
    ExactMatchConversationCanceller exactMatchConversationCanceller =
        new ExactMatchConversationCanceller("Input");
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    ConversationContext context = new ConversationContext(plugin, forWhom, new HashMap<>());

    // Act and Assert
    assertTrue(exactMatchConversationCanceller.cancelBasedOnInput(context, "Input"));
  }

  /**
   * Test {@link ExactMatchConversationCanceller#clone()}.
   *
   * <p>Method under test: {@link ExactMatchConversationCanceller#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.bukkit.conversations.ConversationCanceller ExactMatchConversationCanceller.clone()"
  })
  void testClone() {
    // Arrange, Act and Assert
    assertTrue(
        new ExactMatchConversationCanceller("Escape Sequence").clone()
            instanceof ExactMatchConversationCanceller);
  }
}

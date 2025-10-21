package org.bukkit.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NullConversationPrefixDiffblueTest {
  /**
   * Test {@link NullConversationPrefix#getPrefix(ConversationContext)}.
   *
   * <p>Method under test: {@link NullConversationPrefix#getPrefix(ConversationContext)}
   */
  @Test
  @DisplayName("Test getPrefix(ConversationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NullConversationPrefix.getPrefix(ConversationContext)"})
  void testGetPrefix() {
    // Arrange
    NullConversationPrefix nullConversationPrefix = new NullConversationPrefix();
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    ConversationContext context = new ConversationContext(plugin, forWhom, new HashMap<>());

    // Act
    String actualPrefix = nullConversationPrefix.getPrefix(context);

    // Assert
    assertEquals("", actualPrefix);
  }
}

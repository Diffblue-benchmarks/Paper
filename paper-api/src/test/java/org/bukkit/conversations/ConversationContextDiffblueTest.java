package org.bukkit.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConversationContextDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConversationContext#ConversationContext(Plugin, Conversable, Map)}
   *   <li>{@link ConversationContext#getAllSessionData()}
   *   <li>{@link ConversationContext#getForWhom()}
   *   <li>{@link ConversationContext#getPlugin()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConversationContext.<init>(Plugin, Conversable, Map)",
    "Map ConversationContext.getAllSessionData()",
    "Conversable ConversationContext.getForWhom()",
    "Plugin ConversationContext.getPlugin()"
  })
  void testGettersAndSetters() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();
    HashMap<Object, Object> initialSessionData = new HashMap<>();

    // Act
    ConversationContext actualConversationContext =
        new ConversationContext(plugin, forWhom, initialSessionData);
    Map<Object, Object> actualAllSessionData = actualConversationContext.getAllSessionData();
    Conversable actualForWhom = actualConversationContext.getForWhom();
    Plugin actualPlugin = actualConversationContext.getPlugin();

    // Assert
    assertTrue(actualAllSessionData.isEmpty());
    assertSame(initialSessionData, actualAllSessionData);
    assertSame(forWhom, actualForWhom);
    assertSame(plugin, actualPlugin);
  }

  /**
   * Test {@link ConversationContext#getSessionData(Object)}.
   *
   * <p>Method under test: {@link ConversationContext#getSessionData(Object)}
   */
  @Test
  @DisplayName("Test getSessionData(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ConversationContext.getSessionData(Object)"})
  void testGetSessionData() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    ConversationContext conversationContext =
        new ConversationContext(plugin, forWhom, new HashMap<>());

    // Act and Assert
    assertNull(conversationContext.getSessionData("Key"));
  }

  /**
   * Test {@link ConversationContext#setSessionData(Object, Object)}.
   *
   * <p>Method under test: {@link ConversationContext#setSessionData(Object, Object)}
   */
  @Test
  @DisplayName("Test setSessionData(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConversationContext.setSessionData(Object, Object)"})
  void testSetSessionData() {
    // Arrange
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();
    HashMap<Object, Object> initialSessionData = new HashMap<>();

    ConversationContext conversationContext =
        new ConversationContext(plugin, forWhom, initialSessionData);

    // Act
    conversationContext.setSessionData("Key", "Value");

    // Assert
    Map<Object, Object> allSessionData = conversationContext.getAllSessionData();
    assertEquals(1, allSessionData.size());
    assertEquals("Value", allSessionData.get("Key"));
    assertSame(initialSessionData, allSessionData);
  }
}

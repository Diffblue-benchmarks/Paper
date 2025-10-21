package io.papermc.paper.chat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.chat.ChatRenderer.ViewerUnaware;
import io.papermc.paper.chat.ViewerUnawareImpl.Default;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChatRendererDiffblueTest {
  /**
   * Test {@link ChatRenderer#defaultRenderer()}.
   *
   * <p>Method under test: {@link ChatRenderer#defaultRenderer()}
   */
  @Test
  @DisplayName("Test defaultRenderer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatRenderer ChatRenderer.defaultRenderer()"})
  void testDefaultRenderer() {
    // Arrange, Act and Assert
    assertTrue(ChatRenderer.defaultRenderer() instanceof Default);
  }

  /**
   * Test {@link ChatRenderer#defaultRenderer()}.
   *
   * <ul>
   *   <li>Then {@link BufferedCommandSender} (default constructor) Buffer is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ChatRenderer#defaultRenderer()}
   */
  @Test
  @DisplayName(
      "Test defaultRenderer(); then BufferedCommandSender (default constructor) Buffer is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatRenderer ChatRenderer.defaultRenderer()"})
  void testDefaultRenderer_thenBufferedCommandSenderBufferIsEmptyString() {
    // Arrange and Act
    ChatRenderer actualDefaultRendererResult = ChatRenderer.defaultRenderer();
    Player player = mock(Player.class);
    Component component = mock(Component.class);
    when(component.asComponent()).thenReturn(mock(Component.class));
    Component component2 = mock(Component.class);
    when(component2.asComponent()).thenReturn(mock(Component.class));
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();
    Component actualRenderResult =
        actualDefaultRendererResult.render(player, component, component2, bufferedCommandSender);

    // Assert
    verify(component).asComponent();
    verify(component2).asComponent();
    assertTrue(actualDefaultRendererResult instanceof Default);
    assertEquals("", bufferedCommandSender.getBuffer());
    assertNull(actualRenderResult.insertion());
    assertNull(actualRenderResult.font());
    assertNull(actualRenderResult.color());
    assertNull(bufferedCommandSender.getServer());
    Map<TextDecoration, State> decorationsResult = actualRenderResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertFalse(actualRenderResult.hasStyling());
    assertTrue(decorationsResult.containsKey(TextDecoration.BOLD));
    assertTrue(decorationsResult.containsKey(TextDecoration.ITALIC));
    assertTrue(decorationsResult.containsKey(TextDecoration.OBFUSCATED));
    assertTrue(decorationsResult.containsKey(TextDecoration.STRIKETHROUGH));
    assertTrue(decorationsResult.containsKey(TextDecoration.UNDERLINED));
    Component actualCompactResult = actualRenderResult.compact();
    assertEquals(actualRenderResult, actualCompactResult);
  }

  /**
   * Test {@link ChatRenderer#viewerUnaware(ViewerUnaware)}.
   *
   * <p>Method under test: {@link ChatRenderer#viewerUnaware(ViewerUnaware)}
   */
  @Test
  @DisplayName("Test viewerUnaware(ViewerUnaware)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatRenderer ChatRenderer.viewerUnaware(ViewerUnaware)"})
  void testViewerUnaware() {
    // Arrange, Act and Assert
    assertTrue(ChatRenderer.viewerUnaware(mock(ViewerUnaware.class)) instanceof ViewerUnawareImpl);
  }
}

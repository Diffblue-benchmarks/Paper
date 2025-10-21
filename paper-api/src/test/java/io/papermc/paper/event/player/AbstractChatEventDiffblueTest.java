package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.chat.ChatRenderer;
import java.util.HashSet;
import net.kyori.adventure.chat.SignedMessage;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractChatEventDiffblueTest {
  /**
   * Test {@link AbstractChatEvent#viewers()}.
   *
   * <p>Method under test: {@link AbstractChatEvent#viewers()}
   */
  @Test
  @DisplayName("Test viewers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AbstractChatEvent.viewers()"})
  void testViewers() {
    // Arrange
    Player player = mock(Player.class);
    ChatEvent chatEvent =
        new ChatEvent(
            player,
            new HashSet<>(),
            mock(ChatRenderer.class),
            mock(Component.class),
            mock(Component.class),
            mock(SignedMessage.class));

    // Act and Assert
    assertTrue(chatEvent.viewers().isEmpty());
  }

  /**
   * Test {@link AbstractChatEvent#renderer(ChatRenderer)} with {@code ChatRenderer}.
   *
   * <p>Method under test: {@link AbstractChatEvent#renderer(ChatRenderer)}
   */
  @Test
  @DisplayName("Test renderer(ChatRenderer) with 'ChatRenderer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractChatEvent.renderer(ChatRenderer)"})
  void testRendererWithChatRenderer() {
    // Arrange
    Player player = mock(Player.class);
    ChatEvent chatEvent =
        new ChatEvent(
            player,
            new HashSet<>(),
            mock(ChatRenderer.class),
            mock(Component.class),
            mock(Component.class),
            mock(SignedMessage.class));
    ChatRenderer renderer = mock(ChatRenderer.class);

    // Act
    chatEvent.renderer(renderer);

    // Assert
    assertSame(renderer, chatEvent.renderer());
  }

  /**
   * Test {@link AbstractChatEvent#message(Component)} with {@code Component}.
   *
   * <p>Method under test: {@link AbstractChatEvent#message(Component)}
   */
  @Test
  @DisplayName("Test message(Component) with 'Component'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractChatEvent.message(Component)"})
  void testMessageWithComponent() {
    // Arrange
    Player player = mock(Player.class);
    ChatEvent chatEvent =
        new ChatEvent(
            player,
            new HashSet<>(),
            mock(ChatRenderer.class),
            mock(Component.class),
            mock(Component.class),
            mock(SignedMessage.class));
    Component message = mock(Component.class);

    // Act
    chatEvent.message(message);

    // Assert
    assertSame(message, chatEvent.message());
  }

  /**
   * Test {@link AbstractChatEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractChatEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractChatEvent.isCancelled()"})
  void testIsCancelled_thenReturnFalse() {
    // Arrange
    Player player = mock(Player.class);
    ChatEvent chatEvent =
        new ChatEvent(
            player,
            new HashSet<>(),
            mock(ChatRenderer.class),
            mock(Component.class),
            mock(Component.class),
            mock(SignedMessage.class));

    // Act and Assert
    assertFalse(chatEvent.isCancelled());
  }

  /**
   * Test {@link AbstractChatEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractChatEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractChatEvent.isCancelled()"})
  void testIsCancelled_thenReturnTrue() {
    // Arrange
    Player player = mock(Player.class);

    ChatEvent chatEvent =
        new ChatEvent(
            player,
            new HashSet<>(),
            mock(ChatRenderer.class),
            mock(Component.class),
            mock(Component.class),
            mock(SignedMessage.class));
    chatEvent.setCancelled(true);

    // Act and Assert
    assertTrue(chatEvent.isCancelled());
  }

  /**
   * Test {@link AbstractChatEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link AbstractChatEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractChatEvent.setCancelled(boolean)"})
  void testSetCancelled() {
    // Arrange
    Player player = mock(Player.class);
    ChatEvent chatEvent =
        new ChatEvent(
            player,
            new HashSet<>(),
            mock(ChatRenderer.class),
            mock(Component.class),
            mock(Component.class),
            mock(SignedMessage.class));

    // Act
    chatEvent.setCancelled(true);

    // Assert
    assertTrue(chatEvent.isCancelled());
  }
}

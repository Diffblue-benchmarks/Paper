package io.papermc.paper.chat;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.chat.ChatRenderer.ViewerUnaware;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ViewerUnawareImplDiffblueTest {
  /**
   * Test {@link ViewerUnawareImpl#render(Player, Component, Component)} with {@code source}, {@code
   * sourceDisplayName}, {@code message}.
   *
   * <p>Method under test: {@link ViewerUnawareImpl#render(Player, Component, Component)}
   */
  @Test
  @DisplayName(
      "Test render(Player, Component, Component) with 'source', 'sourceDisplayName', 'message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component ViewerUnawareImpl.render(Player, Component, Component)"})
  void testRenderWithSourceSourceDisplayNameMessage() {
    // Arrange
    ViewerUnaware unaware = mock(ViewerUnaware.class);
    when(unaware.render(Mockito.<Player>any(), Mockito.<Component>any(), Mockito.<Component>any()))
        .thenReturn(mock(Component.class));

    // Act
    new ViewerUnawareImpl(unaware)
        .render(mock(Player.class), mock(Component.class), mock(Component.class));

    // Assert
    verify(unaware).render(isA(Player.class), isA(Component.class), isA(Component.class));
  }

  /**
   * Test {@link ViewerUnawareImpl#render(Player, Component, Component, Audience)} with {@code
   * source}, {@code sourceDisplayName}, {@code message}, {@code viewer}.
   *
   * <p>Method under test: {@link ViewerUnawareImpl#render(Player, Component, Component, Audience)}
   */
  @Test
  @DisplayName(
      "Test render(Player, Component, Component, Audience) with 'source', 'sourceDisplayName', 'message', 'viewer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component ViewerUnawareImpl.render(Player, Component, Component, Audience)"})
  void testRenderWithSourceSourceDisplayNameMessageViewer() {
    // Arrange
    ViewerUnaware unaware = mock(ViewerUnaware.class);
    when(unaware.render(Mockito.<Player>any(), Mockito.<Component>any(), Mockito.<Component>any()))
        .thenReturn(mock(Component.class));
    ViewerUnawareImpl viewerUnawareImpl = new ViewerUnawareImpl(unaware);
    Player source = mock(Player.class);
    Component sourceDisplayName = mock(Component.class);
    Component message = mock(Component.class);

    // Act
    viewerUnawareImpl.render(source, sourceDisplayName, message, new BufferedCommandSender());

    // Assert
    verify(unaware).render(isA(Player.class), isA(Component.class), isA(Component.class));
  }
}

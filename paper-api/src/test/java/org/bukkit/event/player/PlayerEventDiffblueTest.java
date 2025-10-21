package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.event.packet.ClientTickEndEvent;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerEventDiffblueTest {
  /**
   * Test {@link PlayerEvent#getPlayer()}.
   *
   * <p>Method under test: {@link PlayerEvent#getPlayer()}
   */
  @Test
  @DisplayName("Test getPlayer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Player PlayerEvent.getPlayer()"})
  void testGetPlayer() {
    // Arrange
    ClientTickEndEvent clientTickEndEvent = new ClientTickEndEvent(mock(Player.class));

    // Act
    Player actualPlayer = clientTickEndEvent.getPlayer();

    // Assert
    assertSame(clientTickEndEvent.player, actualPlayer);
  }
}

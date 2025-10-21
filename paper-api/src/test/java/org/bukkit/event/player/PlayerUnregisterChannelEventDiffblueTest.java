package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerUnregisterChannelEventDiffblueTest {
  /**
   * Test {@link PlayerUnregisterChannelEvent#PlayerUnregisterChannelEvent(Player, String)}.
   *
   * <p>Method under test: {@link PlayerUnregisterChannelEvent#PlayerUnregisterChannelEvent(Player,
   * String)}
   */
  @Test
  @DisplayName("Test new PlayerUnregisterChannelEvent(Player, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerUnregisterChannelEvent.<init>(Player, String)"})
  void testNewPlayerUnregisterChannelEvent() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerUnregisterChannelEvent actualPlayerUnregisterChannelEvent =
        new PlayerUnregisterChannelEvent(player, "Channel");

    // Assert
    assertEquals("Channel", actualPlayerUnregisterChannelEvent.getChannel());
    assertFalse(actualPlayerUnregisterChannelEvent.isAsynchronous());
    assertSame(player, actualPlayerUnregisterChannelEvent.getPlayer());
  }
}

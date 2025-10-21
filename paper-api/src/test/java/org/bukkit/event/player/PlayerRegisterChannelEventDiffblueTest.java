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

class PlayerRegisterChannelEventDiffblueTest {
  /**
   * Test {@link PlayerRegisterChannelEvent#PlayerRegisterChannelEvent(Player, String)}.
   *
   * <p>Method under test: {@link PlayerRegisterChannelEvent#PlayerRegisterChannelEvent(Player,
   * String)}
   */
  @Test
  @DisplayName("Test new PlayerRegisterChannelEvent(Player, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerRegisterChannelEvent.<init>(Player, String)"})
  void testNewPlayerRegisterChannelEvent() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerRegisterChannelEvent actualPlayerRegisterChannelEvent =
        new PlayerRegisterChannelEvent(player, "Channel");

    // Assert
    assertEquals("Channel", actualPlayerRegisterChannelEvent.getChannel());
    assertFalse(actualPlayerRegisterChannelEvent.isAsynchronous());
    assertSame(player, actualPlayerRegisterChannelEvent.getPlayer());
  }
}

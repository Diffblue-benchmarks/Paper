package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerChannelEventDiffblueTest {
  /**
   * Test {@link PlayerChannelEvent#getChannel()}.
   *
   * <p>Method under test: {@link PlayerChannelEvent#getChannel()}
   */
  @Test
  @DisplayName("Test getChannel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PlayerChannelEvent.getChannel()"})
  void testGetChannel() {
    // Arrange, Act and Assert
    assertEquals(
        "Channel", new PlayerRegisterChannelEvent(mock(Player.class), "Channel").getChannel());
  }

  /**
   * Test {@link PlayerChannelEvent#getHandlers()}.
   *
   * <p>Method under test: {@link PlayerChannelEvent#getHandlers()}
   */
  @Test
  @DisplayName("Test getHandlers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.event.HandlerList PlayerChannelEvent.getHandlers()"})
  void testGetHandlers() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new PlayerRegisterChannelEvent(mock(Player.class), "Channel")
            .getHandlers()
            .getRegisteredListeners()
            .length);
  }
}

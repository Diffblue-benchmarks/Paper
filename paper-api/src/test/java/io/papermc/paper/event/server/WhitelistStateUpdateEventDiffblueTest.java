package io.papermc.paper.event.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.destroystokyo.paper.profile.PlayerProfile;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.event.server.WhitelistStateUpdateEvent.WhitelistStatus;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WhitelistStateUpdateEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WhitelistStateUpdateEvent#WhitelistStateUpdateEvent(PlayerProfile,
   *       WhitelistStatus)}
   *   <li>{@link WhitelistStateUpdateEvent#setCancelled(boolean)}
   *   <li>{@link WhitelistStateUpdateEvent#getHandlerList()}
   *   <li>{@link WhitelistStateUpdateEvent#getHandlers()}
   *   <li>{@link WhitelistStateUpdateEvent#getPlayerProfile()}
   *   <li>{@link WhitelistStateUpdateEvent#getStatus()}
   *   <li>{@link WhitelistStateUpdateEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WhitelistStateUpdateEvent.<init>(PlayerProfile, WhitelistStatus)",
    "HandlerList WhitelistStateUpdateEvent.getHandlerList()",
    "HandlerList WhitelistStateUpdateEvent.getHandlers()",
    "PlayerProfile WhitelistStateUpdateEvent.getPlayerProfile()",
    "WhitelistStatus WhitelistStateUpdateEvent.getStatus()",
    "boolean WhitelistStateUpdateEvent.isCancelled()",
    "void WhitelistStateUpdateEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    PlayerProfile playerProfile = mock(PlayerProfile.class);

    // Act
    WhitelistStateUpdateEvent actualWhitelistStateUpdateEvent =
        new WhitelistStateUpdateEvent(playerProfile, WhitelistStatus.ADDED);
    actualWhitelistStateUpdateEvent.setCancelled(true);
    HandlerList actualHandlerList = actualWhitelistStateUpdateEvent.getHandlerList();
    HandlerList actualHandlers = actualWhitelistStateUpdateEvent.getHandlers();
    PlayerProfile actualPlayerProfile = actualWhitelistStateUpdateEvent.getPlayerProfile();
    WhitelistStatus actualStatus = actualWhitelistStateUpdateEvent.getStatus();
    boolean actualIsCancelledResult = actualWhitelistStateUpdateEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(WhitelistStatus.ADDED, actualStatus);
    assertFalse(actualWhitelistStateUpdateEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(playerProfile, actualPlayerProfile);
  }
}

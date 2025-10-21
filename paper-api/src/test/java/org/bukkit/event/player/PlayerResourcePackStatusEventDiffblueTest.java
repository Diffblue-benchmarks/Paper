package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerResourcePackStatusEvent.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerResourcePackStatusEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerResourcePackStatusEvent#PlayerResourcePackStatusEvent(Player, UUID, Status)}
   *   <li>{@link PlayerResourcePackStatusEvent#getHandlerList()}
   *   <li>{@link PlayerResourcePackStatusEvent#getHandlers()}
   *   <li>{@link PlayerResourcePackStatusEvent#getHash()}
   *   <li>{@link PlayerResourcePackStatusEvent#getID()}
   *   <li>{@link PlayerResourcePackStatusEvent#getStatus()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerResourcePackStatusEvent.<init>(Player, UUID, Status)",
    "HandlerList PlayerResourcePackStatusEvent.getHandlerList()",
    "HandlerList PlayerResourcePackStatusEvent.getHandlers()",
    "String PlayerResourcePackStatusEvent.getHash()",
    "UUID PlayerResourcePackStatusEvent.getID()",
    "Status PlayerResourcePackStatusEvent.getStatus()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    UUID id = UUID.randomUUID();

    // Act
    PlayerResourcePackStatusEvent actualPlayerResourcePackStatusEvent =
        new PlayerResourcePackStatusEvent(player, id, Status.SUCCESSFULLY_LOADED);
    HandlerList actualHandlerList = actualPlayerResourcePackStatusEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerResourcePackStatusEvent.getHandlers();
    String actualHash = actualPlayerResourcePackStatusEvent.getHash();
    UUID actualID = actualPlayerResourcePackStatusEvent.getID();

    // Assert
    assertNull(actualHash);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Status.SUCCESSFULLY_LOADED, actualPlayerResourcePackStatusEvent.getStatus());
    assertFalse(actualPlayerResourcePackStatusEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(id, actualID);
    assertSame(player, actualPlayerResourcePackStatusEvent.getPlayer());
  }
}

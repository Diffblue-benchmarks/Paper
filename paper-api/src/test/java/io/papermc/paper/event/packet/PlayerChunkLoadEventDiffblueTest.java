package io.papermc.paper.event.packet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerChunkLoadEventDiffblueTest {
  /**
   * Test {@link PlayerChunkLoadEvent#PlayerChunkLoadEvent(Chunk, Player)}.
   *
   * <p>Method under test: {@link PlayerChunkLoadEvent#PlayerChunkLoadEvent(Chunk, Player)}
   */
  @Test
  @DisplayName("Test new PlayerChunkLoadEvent(Chunk, Player)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerChunkLoadEvent.<init>(Chunk, Player)"})
  void testNewPlayerChunkLoadEvent() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    when(chunk.getWorld()).thenReturn(mock(World.class));
    Player player = mock(Player.class);

    // Act
    PlayerChunkLoadEvent actualPlayerChunkLoadEvent = new PlayerChunkLoadEvent(chunk, player);

    // Assert
    verify(chunk).getWorld();
    assertEquals("PlayerChunkLoadEvent", actualPlayerChunkLoadEvent.getEventName());
    assertEquals(0, actualPlayerChunkLoadEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualPlayerChunkLoadEvent.isAsynchronous());
    assertSame(chunk, actualPlayerChunkLoadEvent.getChunk());
    assertSame(player, actualPlayerChunkLoadEvent.getPlayer());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerChunkLoadEvent#getHandlerList()}
   *   <li>{@link PlayerChunkLoadEvent#getHandlers()}
   *   <li>{@link PlayerChunkLoadEvent#getPlayer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HandlerList PlayerChunkLoadEvent.getHandlerList()",
    "HandlerList PlayerChunkLoadEvent.getHandlers()",
    "Player PlayerChunkLoadEvent.getPlayer()"
  })
  void testGettersAndSetters() {
    // Arrange
    PlayerChunkLoadEvent playerChunkLoadEvent =
        new PlayerChunkLoadEvent(mock(Chunk.class), mock(Player.class));

    // Act
    HandlerList actualHandlerList = playerChunkLoadEvent.getHandlerList();
    HandlerList actualHandlers = playerChunkLoadEvent.getHandlers();
    playerChunkLoadEvent.getPlayer();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertSame(actualHandlerList, actualHandlers);
  }
}

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

class PlayerChunkUnloadEventDiffblueTest {
  /**
   * Test {@link PlayerChunkUnloadEvent#PlayerChunkUnloadEvent(Chunk, Player)}.
   *
   * <p>Method under test: {@link PlayerChunkUnloadEvent#PlayerChunkUnloadEvent(Chunk, Player)}
   */
  @Test
  @DisplayName("Test new PlayerChunkUnloadEvent(Chunk, Player)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerChunkUnloadEvent.<init>(Chunk, Player)"})
  void testNewPlayerChunkUnloadEvent() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    when(chunk.getWorld()).thenReturn(mock(World.class));
    Player player = mock(Player.class);

    // Act
    PlayerChunkUnloadEvent actualPlayerChunkUnloadEvent = new PlayerChunkUnloadEvent(chunk, player);

    // Assert
    verify(chunk).getWorld();
    assertEquals("PlayerChunkUnloadEvent", actualPlayerChunkUnloadEvent.getEventName());
    assertEquals(0, actualPlayerChunkUnloadEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualPlayerChunkUnloadEvent.isAsynchronous());
    assertSame(chunk, actualPlayerChunkUnloadEvent.getChunk());
    assertSame(player, actualPlayerChunkUnloadEvent.getPlayer());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerChunkUnloadEvent#getHandlerList()}
   *   <li>{@link PlayerChunkUnloadEvent#getHandlers()}
   *   <li>{@link PlayerChunkUnloadEvent#getPlayer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HandlerList PlayerChunkUnloadEvent.getHandlerList()",
    "HandlerList PlayerChunkUnloadEvent.getHandlers()",
    "Player PlayerChunkUnloadEvent.getPlayer()"
  })
  void testGettersAndSetters() {
    // Arrange
    PlayerChunkUnloadEvent playerChunkUnloadEvent =
        new PlayerChunkUnloadEvent(mock(Chunk.class), mock(Player.class));

    // Act
    HandlerList actualHandlerList = playerChunkUnloadEvent.getHandlerList();
    HandlerList actualHandlers = playerChunkUnloadEvent.getHandlers();
    playerChunkUnloadEvent.getPlayer();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertSame(actualHandlerList, actualHandlers);
  }
}

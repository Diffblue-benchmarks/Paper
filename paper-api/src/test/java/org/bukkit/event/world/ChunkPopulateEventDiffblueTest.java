package org.bukkit.event.world;

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
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChunkPopulateEventDiffblueTest {
  /**
   * Test {@link ChunkPopulateEvent#ChunkPopulateEvent(Chunk)}.
   *
   * <p>Method under test: {@link ChunkPopulateEvent#ChunkPopulateEvent(Chunk)}
   */
  @Test
  @DisplayName("Test new ChunkPopulateEvent(Chunk)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChunkPopulateEvent.<init>(Chunk)"})
  void testNewChunkPopulateEvent() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    when(chunk.getWorld()).thenReturn(mock(World.class));

    // Act
    ChunkPopulateEvent actualChunkPopulateEvent = new ChunkPopulateEvent(chunk);

    // Assert
    verify(chunk).getWorld();
    assertEquals("ChunkPopulateEvent", actualChunkPopulateEvent.getEventName());
    assertEquals(0, actualChunkPopulateEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualChunkPopulateEvent.isAsynchronous());
    assertSame(chunk, actualChunkPopulateEvent.getChunk());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ChunkPopulateEvent#getHandlerList()}
   *   <li>{@link ChunkPopulateEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HandlerList ChunkPopulateEvent.getHandlerList()",
    "HandlerList ChunkPopulateEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    ChunkPopulateEvent chunkPopulateEvent = new ChunkPopulateEvent(mock(Chunk.class));

    // Act
    HandlerList actualHandlerList = chunkPopulateEvent.getHandlerList();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertSame(actualHandlerList, chunkPopulateEvent.getHandlers());
  }
}

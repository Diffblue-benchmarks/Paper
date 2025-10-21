package org.bukkit.event.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class ChunkLoadEventDiffblueTest {
  /**
   * Test {@link ChunkLoadEvent#ChunkLoadEvent(Chunk, boolean)}.
   *
   * <p>Method under test: {@link ChunkLoadEvent#ChunkLoadEvent(Chunk, boolean)}
   */
  @Test
  @DisplayName("Test new ChunkLoadEvent(Chunk, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChunkLoadEvent.<init>(Chunk, boolean)"})
  void testNewChunkLoadEvent() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    when(chunk.getWorld()).thenReturn(mock(World.class));

    // Act
    ChunkLoadEvent actualChunkLoadEvent = new ChunkLoadEvent(chunk, true);

    // Assert
    verify(chunk).getWorld();
    assertEquals("ChunkLoadEvent", actualChunkLoadEvent.getEventName());
    assertEquals(0, actualChunkLoadEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualChunkLoadEvent.isAsynchronous());
    assertTrue(actualChunkLoadEvent.isNewChunk());
    assertSame(chunk, actualChunkLoadEvent.getChunk());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ChunkLoadEvent#getHandlerList()}
   *   <li>{@link ChunkLoadEvent#getHandlers()}
   *   <li>{@link ChunkLoadEvent#isNewChunk()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HandlerList ChunkLoadEvent.getHandlerList()",
    "HandlerList ChunkLoadEvent.getHandlers()",
    "boolean ChunkLoadEvent.isNewChunk()"
  })
  void testGettersAndSetters() {
    // Arrange
    ChunkLoadEvent chunkLoadEvent = new ChunkLoadEvent(mock(Chunk.class), true);

    // Act
    HandlerList actualHandlerList = chunkLoadEvent.getHandlerList();
    HandlerList actualHandlers = chunkLoadEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertTrue(chunkLoadEvent.isNewChunk());
    assertSame(actualHandlerList, actualHandlers);
  }
}

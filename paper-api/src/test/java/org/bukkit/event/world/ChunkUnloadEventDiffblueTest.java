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

class ChunkUnloadEventDiffblueTest {
  /**
   * Test {@link ChunkUnloadEvent#ChunkUnloadEvent(Chunk)}.
   *
   * <p>Method under test: {@link ChunkUnloadEvent#ChunkUnloadEvent(Chunk)}
   */
  @Test
  @DisplayName("Test new ChunkUnloadEvent(Chunk)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChunkUnloadEvent.<init>(Chunk)"})
  void testNewChunkUnloadEvent() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    when(chunk.getWorld()).thenReturn(mock(World.class));

    // Act
    ChunkUnloadEvent actualChunkUnloadEvent = new ChunkUnloadEvent(chunk);

    // Assert
    verify(chunk).getWorld();
    assertEquals("ChunkUnloadEvent", actualChunkUnloadEvent.getEventName());
    assertEquals(0, actualChunkUnloadEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualChunkUnloadEvent.isAsynchronous());
    assertTrue(actualChunkUnloadEvent.isSaveChunk());
    assertSame(chunk, actualChunkUnloadEvent.getChunk());
  }

  /**
   * Test {@link ChunkUnloadEvent#ChunkUnloadEvent(Chunk, boolean)}.
   *
   * <p>Method under test: {@link ChunkUnloadEvent#ChunkUnloadEvent(Chunk, boolean)}
   */
  @Test
  @DisplayName("Test new ChunkUnloadEvent(Chunk, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChunkUnloadEvent.<init>(Chunk, boolean)"})
  void testNewChunkUnloadEvent2() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    when(chunk.getWorld()).thenReturn(mock(World.class));

    // Act
    ChunkUnloadEvent actualChunkUnloadEvent = new ChunkUnloadEvent(chunk, true);

    // Assert
    verify(chunk).getWorld();
    assertEquals("ChunkUnloadEvent", actualChunkUnloadEvent.getEventName());
    assertEquals(0, actualChunkUnloadEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualChunkUnloadEvent.isAsynchronous());
    assertTrue(actualChunkUnloadEvent.isSaveChunk());
    assertSame(chunk, actualChunkUnloadEvent.getChunk());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ChunkUnloadEvent#setSaveChunk(boolean)}
   *   <li>{@link ChunkUnloadEvent#getHandlerList()}
   *   <li>{@link ChunkUnloadEvent#getHandlers()}
   *   <li>{@link ChunkUnloadEvent#isSaveChunk()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HandlerList ChunkUnloadEvent.getHandlerList()",
    "HandlerList ChunkUnloadEvent.getHandlers()",
    "boolean ChunkUnloadEvent.isSaveChunk()",
    "void ChunkUnloadEvent.setSaveChunk(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    ChunkUnloadEvent chunkUnloadEvent = new ChunkUnloadEvent(mock(Chunk.class));

    // Act
    chunkUnloadEvent.setSaveChunk(true);
    HandlerList actualHandlerList = chunkUnloadEvent.getHandlerList();
    HandlerList actualHandlers = chunkUnloadEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertTrue(chunkUnloadEvent.isSaveChunk());
    assertSame(actualHandlerList, actualHandlers);
  }
}

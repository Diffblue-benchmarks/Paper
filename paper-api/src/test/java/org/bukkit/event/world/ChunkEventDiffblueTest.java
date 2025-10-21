package org.bukkit.event.world;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChunkEventDiffblueTest {
  /**
   * Test {@link ChunkEvent#getChunk()}.
   *
   * <p>Method under test: {@link ChunkEvent#getChunk()}
   */
  @Test
  @DisplayName("Test getChunk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chunk ChunkEvent.getChunk()"})
  void testGetChunk() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    when(chunk.getWorld()).thenReturn(mock(World.class));
    ChunkPopulateEvent chunkPopulateEvent = new ChunkPopulateEvent(chunk);

    // Act
    Chunk actualChunk = chunkPopulateEvent.getChunk();

    // Assert
    verify(chunk).getWorld();
    assertSame(chunkPopulateEvent.chunk, actualChunk);
  }
}

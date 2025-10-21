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

class WorldEventDiffblueTest {
  /**
   * Test {@link WorldEvent#getWorld()}.
   *
   * <p>Method under test: {@link WorldEvent#getWorld()}
   */
  @Test
  @DisplayName("Test getWorld()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"World WorldEvent.getWorld()"})
  void testGetWorld() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    when(chunk.getWorld()).thenReturn(mock(World.class));
    ChunkPopulateEvent chunkPopulateEvent = new ChunkPopulateEvent(chunk);

    // Act
    World actualWorld = chunkPopulateEvent.getWorld();

    // Assert
    verify(chunk).getWorld();
    assertSame(chunkPopulateEvent.world, actualWorld);
  }
}

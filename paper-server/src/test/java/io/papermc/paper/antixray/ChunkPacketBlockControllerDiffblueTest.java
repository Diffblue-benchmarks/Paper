package io.papermc.paper.antixray;

import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChunkPacketBlockControllerDiffblueTest {
  /**
   * Test {@link ChunkPacketBlockController#modifyBlocks(ClientboundLevelChunkWithLightPacket,
   * ChunkPacketInfo)}.
   *
   * <p>Method under test: {@link
   * ChunkPacketBlockController#modifyBlocks(ClientboundLevelChunkWithLightPacket, ChunkPacketInfo)}
   */
  @Test
  @DisplayName("Test modifyBlocks(ClientboundLevelChunkWithLightPacket, ChunkPacketInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChunkPacketBlockController.modifyBlocks(ClientboundLevelChunkWithLightPacket, ChunkPacketInfo)"
  })
  void testModifyBlocks() {
    // Arrange
    ClientboundLevelChunkWithLightPacket chunkPacket =
        mock(ClientboundLevelChunkWithLightPacket.class);
    doNothing().when(chunkPacket).setReady(anyBoolean());

    // Act
    ChunkPacketBlockController.NO_OPERATION_INSTANCE.modifyBlocks(
        chunkPacket, mock(ChunkPacketInfo.class));

    // Assert
    verify(chunkPacket).setReady(true);
  }
}

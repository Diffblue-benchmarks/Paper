package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.event.block.BeaconActivatedEvent;
import org.bukkit.block.Block;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockEventDiffblueTest {
  /**
   * Test {@link BlockEvent#getBlock()}.
   *
   * <p>Method under test: {@link BlockEvent#getBlock()}
   */
  @Test
  @DisplayName("Test getBlock()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Block BlockEvent.getBlock()"})
  void testGetBlock() {
    // Arrange
    BeaconActivatedEvent beaconActivatedEvent = new BeaconActivatedEvent(mock(Block.class));

    // Act
    Block actualBlock = beaconActivatedEvent.getBlock();

    // Assert
    assertSame(beaconActivatedEvent.block, actualBlock);
  }
}

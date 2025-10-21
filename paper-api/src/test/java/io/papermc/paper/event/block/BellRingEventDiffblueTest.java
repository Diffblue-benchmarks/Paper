package io.papermc.paper.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BellRingEventDiffblueTest {
  /**
   * Test {@link BellRingEvent#BellRingEvent(Block, BlockFace, Entity)}.
   *
   * <p>Method under test: {@link BellRingEvent#BellRingEvent(Block, BlockFace, Entity)}
   */
  @Test
  @DisplayName("Test new BellRingEvent(Block, BlockFace, Entity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BellRingEvent.<init>(Block, BlockFace, Entity)"})
  void testNewBellRingEvent() {
    // Arrange
    Block block = mock(Block.class);
    Entity entity = mock(Entity.class);

    // Act
    BellRingEvent actualBellRingEvent = new BellRingEvent(block, BlockFace.NORTH, entity);

    // Assert
    assertEquals(BlockFace.NORTH, actualBellRingEvent.getDirection());
    assertFalse(actualBellRingEvent.isAsynchronous());
    assertFalse(actualBellRingEvent.isCancelled());
    assertSame(block, actualBellRingEvent.getBlock());
    assertSame(entity, actualBellRingEvent.getEntity());
  }
}

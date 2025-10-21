package io.papermc.paper.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Projectile;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TargetHitEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TargetHitEvent#TargetHitEvent(Projectile, Block, BlockFace, int)}
   *   <li>{@link TargetHitEvent#getHandlerList()}
   *   <li>{@link TargetHitEvent#getHandlers()}
   *   <li>{@link TargetHitEvent#getSignalStrength()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TargetHitEvent.<init>(Projectile, Block, BlockFace, int)",
    "HandlerList TargetHitEvent.getHandlerList()",
    "HandlerList TargetHitEvent.getHandlers()",
    "int TargetHitEvent.getSignalStrength()"
  })
  void testGettersAndSetters() {
    // Arrange
    Projectile projectile = mock(Projectile.class);
    Block block = mock(Block.class);

    // Act
    TargetHitEvent actualTargetHitEvent = new TargetHitEvent(projectile, block, BlockFace.NORTH, 1);
    HandlerList actualHandlerList = actualTargetHitEvent.getHandlerList();
    HandlerList actualHandlers = actualTargetHitEvent.getHandlers();
    int actualSignalStrength = actualTargetHitEvent.getSignalStrength();

    // Assert
    assertNull(actualTargetHitEvent.getHitEntity());
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualSignalStrength);
    assertEquals(BlockFace.NORTH, actualTargetHitEvent.getHitBlockFace());
    assertFalse(actualTargetHitEvent.isAsynchronous());
    assertFalse(actualTargetHitEvent.isCancelled());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualTargetHitEvent.getHitBlock());
    assertSame(projectile, actualTargetHitEvent.getEntity());
  }
}

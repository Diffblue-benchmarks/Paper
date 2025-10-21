package io.papermc.paper.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.entity.Raider;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BellRevealRaiderEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BellRevealRaiderEvent#BellRevealRaiderEvent(Block, Raider)}
   *   <li>{@link BellRevealRaiderEvent#setCancelled(boolean)}
   *   <li>{@link BellRevealRaiderEvent#getHandlerList()}
   *   <li>{@link BellRevealRaiderEvent#getEntity()}
   *   <li>{@link BellRevealRaiderEvent#getHandlers()}
   *   <li>{@link BellRevealRaiderEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BellRevealRaiderEvent.<init>(Block, Raider)",
    "Raider BellRevealRaiderEvent.getEntity()",
    "HandlerList BellRevealRaiderEvent.getHandlerList()",
    "HandlerList BellRevealRaiderEvent.getHandlers()",
    "boolean BellRevealRaiderEvent.isCancelled()",
    "void BellRevealRaiderEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block bell = mock(Block.class);
    Raider raider = mock(Raider.class);

    // Act
    BellRevealRaiderEvent actualBellRevealRaiderEvent = new BellRevealRaiderEvent(bell, raider);
    actualBellRevealRaiderEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBellRevealRaiderEvent.getHandlerList();
    Raider actualEntity = actualBellRevealRaiderEvent.getEntity();
    HandlerList actualHandlers = actualBellRevealRaiderEvent.getHandlers();
    boolean actualIsCancelledResult = actualBellRevealRaiderEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBellRevealRaiderEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(bell, actualBellRevealRaiderEvent.getBlock());
    assertSame(raider, actualEntity);
  }
}

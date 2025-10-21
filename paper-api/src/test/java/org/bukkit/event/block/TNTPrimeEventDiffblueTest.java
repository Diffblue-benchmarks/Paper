package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.TNTPrimeEvent.PrimeCause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TNTPrimeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TNTPrimeEvent#TNTPrimeEvent(Block, PrimeCause, Entity, Block)}
   *   <li>{@link TNTPrimeEvent#setCancelled(boolean)}
   *   <li>{@link TNTPrimeEvent#getHandlerList()}
   *   <li>{@link TNTPrimeEvent#getCause()}
   *   <li>{@link TNTPrimeEvent#getHandlers()}
   *   <li>{@link TNTPrimeEvent#getPrimingBlock()}
   *   <li>{@link TNTPrimeEvent#getPrimingEntity()}
   *   <li>{@link TNTPrimeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TNTPrimeEvent.<init>(Block, PrimeCause, Entity, Block)",
    "PrimeCause TNTPrimeEvent.getCause()",
    "HandlerList TNTPrimeEvent.getHandlerList()",
    "HandlerList TNTPrimeEvent.getHandlers()",
    "Block TNTPrimeEvent.getPrimingBlock()",
    "Entity TNTPrimeEvent.getPrimingEntity()",
    "boolean TNTPrimeEvent.isCancelled()",
    "void TNTPrimeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    Entity primingEntity = mock(Entity.class);
    Block primingBlock = mock(Block.class);

    // Act
    TNTPrimeEvent actualTntPrimeEvent =
        new TNTPrimeEvent(block, PrimeCause.FIRE, primingEntity, primingBlock);
    actualTntPrimeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualTntPrimeEvent.getHandlerList();
    PrimeCause actualCause = actualTntPrimeEvent.getCause();
    HandlerList actualHandlers = actualTntPrimeEvent.getHandlers();
    Block actualPrimingBlock = actualTntPrimeEvent.getPrimingBlock();
    Entity actualPrimingEntity = actualTntPrimeEvent.getPrimingEntity();
    boolean actualIsCancelledResult = actualTntPrimeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(PrimeCause.FIRE, actualCause);
    assertFalse(actualTntPrimeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualTntPrimeEvent.getBlock());
    assertSame(primingBlock, actualPrimingBlock);
    assertSame(primingEntity, actualPrimingEntity);
  }
}

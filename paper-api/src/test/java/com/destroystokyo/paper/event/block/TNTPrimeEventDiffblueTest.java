package com.destroystokyo.paper.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.destroystokyo.paper.event.block.TNTPrimeEvent.PrimeReason;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
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
   *   <li>{@link TNTPrimeEvent#TNTPrimeEvent(Block, PrimeReason, Entity)}
   *   <li>{@link TNTPrimeEvent#setCancelled(boolean)}
   *   <li>{@link TNTPrimeEvent#getHandlerList()}
   *   <li>{@link TNTPrimeEvent#getHandlers()}
   *   <li>{@link TNTPrimeEvent#getPrimerEntity()}
   *   <li>{@link TNTPrimeEvent#getReason()}
   *   <li>{@link TNTPrimeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TNTPrimeEvent.<init>(Block, PrimeReason, Entity)",
    "HandlerList TNTPrimeEvent.getHandlerList()",
    "HandlerList TNTPrimeEvent.getHandlers()",
    "Entity TNTPrimeEvent.getPrimerEntity()",
    "PrimeReason TNTPrimeEvent.getReason()",
    "boolean TNTPrimeEvent.isCancelled()",
    "void TNTPrimeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    Entity primerEntity = mock(Entity.class);

    // Act
    TNTPrimeEvent actualTntPrimeEvent =
        new TNTPrimeEvent(block, PrimeReason.EXPLOSION, primerEntity);
    actualTntPrimeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualTntPrimeEvent.getHandlerList();
    HandlerList actualHandlers = actualTntPrimeEvent.getHandlers();
    Entity actualPrimerEntity = actualTntPrimeEvent.getPrimerEntity();
    PrimeReason actualReason = actualTntPrimeEvent.getReason();
    boolean actualIsCancelledResult = actualTntPrimeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(PrimeReason.EXPLOSION, actualReason);
    assertFalse(actualTntPrimeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualTntPrimeEvent.getBlock());
    assertSame(primerEntity, actualPrimerEntity);
  }
}

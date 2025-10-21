package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.SkeletonHorse;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SkeletonHorseTrapEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkeletonHorseTrapEvent#SkeletonHorseTrapEvent(SkeletonHorse, List)}
   *   <li>{@link SkeletonHorseTrapEvent#setCancelled(boolean)}
   *   <li>{@link SkeletonHorseTrapEvent#getHandlerList()}
   *   <li>{@link SkeletonHorseTrapEvent#getEligibleHumans()}
   *   <li>{@link SkeletonHorseTrapEvent#getHandlers()}
   *   <li>{@link SkeletonHorseTrapEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkeletonHorseTrapEvent.<init>(SkeletonHorse, List)",
    "List SkeletonHorseTrapEvent.getEligibleHumans()",
    "HandlerList SkeletonHorseTrapEvent.getHandlerList()",
    "HandlerList SkeletonHorseTrapEvent.getHandlers()",
    "boolean SkeletonHorseTrapEvent.isCancelled()",
    "void SkeletonHorseTrapEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    SkeletonHorse horse = mock(SkeletonHorse.class);
    ArrayList<HumanEntity> eligibleHumans = new ArrayList<>();

    // Act
    SkeletonHorseTrapEvent actualSkeletonHorseTrapEvent =
        new SkeletonHorseTrapEvent(horse, eligibleHumans);
    actualSkeletonHorseTrapEvent.setCancelled(true);
    HandlerList actualHandlerList = actualSkeletonHorseTrapEvent.getHandlerList();
    List<HumanEntity> actualEligibleHumans = actualSkeletonHorseTrapEvent.getEligibleHumans();
    HandlerList actualHandlers = actualSkeletonHorseTrapEvent.getHandlers();
    boolean actualIsCancelledResult = actualSkeletonHorseTrapEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualSkeletonHorseTrapEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualEligibleHumans.isEmpty());
    assertSame(eligibleHumans, actualEligibleHumans);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(horse, actualSkeletonHorseTrapEvent.getEntity());
  }
}

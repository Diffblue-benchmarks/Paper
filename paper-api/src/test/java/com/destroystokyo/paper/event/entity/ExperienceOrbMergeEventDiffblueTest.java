package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExperienceOrbMergeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExperienceOrbMergeEvent#ExperienceOrbMergeEvent(ExperienceOrb, ExperienceOrb)}
   *   <li>{@link ExperienceOrbMergeEvent#setCancelled(boolean)}
   *   <li>{@link ExperienceOrbMergeEvent#getHandlerList()}
   *   <li>{@link ExperienceOrbMergeEvent#getHandlers()}
   *   <li>{@link ExperienceOrbMergeEvent#getMergeSource()}
   *   <li>{@link ExperienceOrbMergeEvent#getMergeTarget()}
   *   <li>{@link ExperienceOrbMergeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExperienceOrbMergeEvent.<init>(ExperienceOrb, ExperienceOrb)",
    "HandlerList ExperienceOrbMergeEvent.getHandlerList()",
    "HandlerList ExperienceOrbMergeEvent.getHandlers()",
    "ExperienceOrb ExperienceOrbMergeEvent.getMergeSource()",
    "ExperienceOrb ExperienceOrbMergeEvent.getMergeTarget()",
    "boolean ExperienceOrbMergeEvent.isCancelled()",
    "void ExperienceOrbMergeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    ExperienceOrb mergeTarget = mock(ExperienceOrb.class);
    ExperienceOrb mergeSource = mock(ExperienceOrb.class);

    // Act
    ExperienceOrbMergeEvent actualExperienceOrbMergeEvent =
        new ExperienceOrbMergeEvent(mergeTarget, mergeSource);
    actualExperienceOrbMergeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualExperienceOrbMergeEvent.getHandlerList();
    HandlerList actualHandlers = actualExperienceOrbMergeEvent.getHandlers();
    ExperienceOrb actualMergeSource = actualExperienceOrbMergeEvent.getMergeSource();
    ExperienceOrb actualMergeTarget = actualExperienceOrbMergeEvent.getMergeTarget();
    boolean actualIsCancelledResult = actualExperienceOrbMergeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualExperienceOrbMergeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(mergeSource, actualMergeSource);
    assertSame(mergeTarget, actualMergeTarget);
    assertSame(mergeTarget, actualExperienceOrbMergeEvent.getEntity());
  }
}

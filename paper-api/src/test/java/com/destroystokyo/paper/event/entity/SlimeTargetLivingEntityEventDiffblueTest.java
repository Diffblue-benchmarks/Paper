package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Slime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SlimeTargetLivingEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlimeTargetLivingEntityEvent#SlimeTargetLivingEntityEvent(Slime, LivingEntity)}
   *   <li>{@link SlimeTargetLivingEntityEvent#getTarget()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SlimeTargetLivingEntityEvent.<init>(Slime, LivingEntity)",
    "LivingEntity SlimeTargetLivingEntityEvent.getTarget()"
  })
  void testGettersAndSetters() {
    // Arrange
    Slime slime = mock(Slime.class);
    LivingEntity target = mock(LivingEntity.class);

    // Act
    SlimeTargetLivingEntityEvent actualSlimeTargetLivingEntityEvent =
        new SlimeTargetLivingEntityEvent(slime, target);
    LivingEntity actualTarget = actualSlimeTargetLivingEntityEvent.getTarget();

    // Assert
    assertFalse(actualSlimeTargetLivingEntityEvent.isCancelled());
    assertFalse(actualSlimeTargetLivingEntityEvent.isAsynchronous());
    assertSame(target, actualTarget);
    assertSame(slime, actualSlimeTargetLivingEntityEvent.getEntity());
  }
}

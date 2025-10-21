package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Witch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WitchThrowPotionEventDiffblueTest {
  /**
   * Test {@link WitchThrowPotionEvent#isCancelled()}.
   *
   * <p>Method under test: {@link WitchThrowPotionEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WitchThrowPotionEvent.isCancelled()"})
  void testIsCancelled() {
    // Arrange
    WitchThrowPotionEvent witchThrowPotionEvent =
        new WitchThrowPotionEvent(mock(Witch.class), mock(LivingEntity.class), null);
    witchThrowPotionEvent.setCancelled(false);

    // Act and Assert
    assertTrue(witchThrowPotionEvent.isCancelled());
  }

  /**
   * Test {@link WitchThrowPotionEvent#isCancelled()}.
   *
   * <p>Method under test: {@link WitchThrowPotionEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WitchThrowPotionEvent.isCancelled()"})
  void testIsCancelled2() {
    // Arrange
    WitchThrowPotionEvent witchThrowPotionEvent =
        new WitchThrowPotionEvent(mock(Witch.class), mock(LivingEntity.class), null);
    witchThrowPotionEvent.setCancelled(true);

    // Act and Assert
    assertTrue(witchThrowPotionEvent.isCancelled());
  }
}

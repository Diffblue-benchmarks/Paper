package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Witch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WitchConsumePotionEventDiffblueTest {
  /**
   * Test {@link WitchConsumePotionEvent#isCancelled()}.
   *
   * <p>Method under test: {@link WitchConsumePotionEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WitchConsumePotionEvent.isCancelled()"})
  void testIsCancelled() {
    // Arrange
    WitchConsumePotionEvent witchConsumePotionEvent =
        new WitchConsumePotionEvent(mock(Witch.class), null);
    witchConsumePotionEvent.setCancelled(false);

    // Act and Assert
    assertTrue(witchConsumePotionEvent.isCancelled());
  }

  /**
   * Test {@link WitchConsumePotionEvent#isCancelled()}.
   *
   * <p>Method under test: {@link WitchConsumePotionEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WitchConsumePotionEvent.isCancelled()"})
  void testIsCancelled2() {
    // Arrange
    WitchConsumePotionEvent witchConsumePotionEvent =
        new WitchConsumePotionEvent(mock(Witch.class), null);
    witchConsumePotionEvent.setCancelled(true);

    // Act and Assert
    assertTrue(witchConsumePotionEvent.isCancelled());
  }
}

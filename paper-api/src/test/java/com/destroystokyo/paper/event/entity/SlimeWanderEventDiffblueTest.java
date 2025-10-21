package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Slime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SlimeWanderEventDiffblueTest {
  /**
   * Test {@link SlimeWanderEvent#SlimeWanderEvent(Slime)}.
   *
   * <p>Method under test: {@link SlimeWanderEvent#SlimeWanderEvent(Slime)}
   */
  @Test
  @DisplayName("Test new SlimeWanderEvent(Slime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SlimeWanderEvent.<init>(Slime)"})
  void testNewSlimeWanderEvent() {
    // Arrange
    Slime slime = mock(Slime.class);

    // Act
    SlimeWanderEvent actualSlimeWanderEvent = new SlimeWanderEvent(slime);

    // Assert
    assertFalse(actualSlimeWanderEvent.isCancelled());
    assertFalse(actualSlimeWanderEvent.isAsynchronous());
    assertSame(slime, actualSlimeWanderEvent.getEntity());
  }
}

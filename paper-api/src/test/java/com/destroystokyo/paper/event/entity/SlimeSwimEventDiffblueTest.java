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

class SlimeSwimEventDiffblueTest {
  /**
   * Test {@link SlimeSwimEvent#SlimeSwimEvent(Slime)}.
   *
   * <p>Method under test: {@link SlimeSwimEvent#SlimeSwimEvent(Slime)}
   */
  @Test
  @DisplayName("Test new SlimeSwimEvent(Slime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SlimeSwimEvent.<init>(Slime)"})
  void testNewSlimeSwimEvent() {
    // Arrange
    Slime slime = mock(Slime.class);

    // Act
    SlimeSwimEvent actualSlimeSwimEvent = new SlimeSwimEvent(slime);

    // Assert
    assertFalse(actualSlimeSwimEvent.isCancelled());
    assertFalse(actualSlimeSwimEvent.isAsynchronous());
    assertSame(slime, actualSlimeSwimEvent.getEntity());
  }
}

package org.bukkit.event.hanging;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Hanging;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HangingEventDiffblueTest {
  /**
   * Test {@link HangingEvent#getEntity()}.
   *
   * <p>Method under test: {@link HangingEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Hanging HangingEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    HangingBreakByEntityEvent hangingBreakByEntityEvent =
        new HangingBreakByEntityEvent(mock(Hanging.class), mock(Entity.class));

    // Act
    Hanging actualEntity = hangingBreakByEntityEvent.getEntity();

    // Assert
    assertSame(hangingBreakByEntityEvent.hanging, actualEntity);
  }
}

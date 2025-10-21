package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Slime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SlimeChangeDirectionEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlimeChangeDirectionEvent#SlimeChangeDirectionEvent(Slime, float)}
   *   <li>{@link SlimeChangeDirectionEvent#setNewYaw(float)}
   *   <li>{@link SlimeChangeDirectionEvent#getNewYaw()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SlimeChangeDirectionEvent.<init>(Slime, float)",
    "float SlimeChangeDirectionEvent.getNewYaw()",
    "void SlimeChangeDirectionEvent.setNewYaw(float)"
  })
  void testGettersAndSetters() {
    // Arrange
    Slime slime = mock(Slime.class);

    // Act
    SlimeChangeDirectionEvent actualSlimeChangeDirectionEvent =
        new SlimeChangeDirectionEvent(slime, 10.0f);
    actualSlimeChangeDirectionEvent.setNewYaw(10.0f);

    // Assert
    assertEquals(10.0f, actualSlimeChangeDirectionEvent.getNewYaw());
    assertFalse(actualSlimeChangeDirectionEvent.isCancelled());
    assertFalse(actualSlimeChangeDirectionEvent.isAsynchronous());
    assertSame(slime, actualSlimeChangeDirectionEvent.getEntity());
  }
}

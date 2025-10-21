package org.bukkit.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EventPriorityDiffblueTest {
  /**
   * Test {@link EventPriority#getSlot()}.
   *
   * <p>Method under test: {@link EventPriority#getSlot()}
   */
  @Test
  @DisplayName("Test getSlot()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EventPriority.getSlot()"})
  void testGetSlot() {
    // Arrange, Act and Assert
    assertEquals(0, EventPriority.valueOf("LOWEST").getSlot());
  }
}

package org.bukkit.scoreboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DisplaySlotDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DisplaySlot#getId()}
   *   <li>{@link DisplaySlot#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DisplaySlot.getId()", "String DisplaySlot.toString()"})
  void testGettersAndSetters() {
    // Arrange
    DisplaySlot valueOfResult = DisplaySlot.valueOf("PLAYER_LIST");

    // Act
    String actualId = valueOfResult.getId();

    // Assert
    assertEquals("list", actualId);
    assertEquals("list", valueOfResult.toString());
  }
}

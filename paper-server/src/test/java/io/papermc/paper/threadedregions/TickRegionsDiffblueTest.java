package io.papermc.paper.threadedregions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TickRegionsDiffblueTest {
  /**
   * Test {@link TickRegions#getRegionChunkShift()}.
   *
   * <p>Method under test: {@link TickRegions#getRegionChunkShift()}
   */
  @Test
  @DisplayName("Test getRegionChunkShift()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TickRegions.getRegionChunkShift()"})
  void testGetRegionChunkShift() {
    // Arrange, Act and Assert
    assertEquals(6, TickRegions.getRegionChunkShift());
  }
}

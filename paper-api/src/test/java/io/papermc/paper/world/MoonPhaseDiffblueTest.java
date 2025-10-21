package io.papermc.paper.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MoonPhaseDiffblueTest {
  /**
   * Test {@link MoonPhase#getPhase(long)}.
   *
   * <p>Method under test: {@link MoonPhase#getPhase(long)}
   */
  @Test
  @DisplayName("Test getPhase(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MoonPhase MoonPhase.getPhase(long)"})
  void testGetPhase() {
    // Arrange, Act and Assert
    assertEquals(MoonPhase.WANING_GIBBOUS, MoonPhase.getPhase(1L));
  }
}

package ca.spottedleaf.dataconverter.minecraft.versions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class V3818DiffblueTest {
  /**
   * Test {@link V3818#getBannerColour(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code white}.
   * </ul>
   *
   * <p>Method under test: {@link V3818#getBannerColour(int)}
   */
  @Test
  @DisplayName("Test getBannerColour(int); when minus one; then return 'white'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String V3818.getBannerColour(int)"})
  void testGetBannerColour_whenMinusOne_thenReturnWhite() {
    // Arrange, Act and Assert
    assertEquals("white", V3818.getBannerColour(-1));
  }

  /**
   * Test {@link V3818#getBannerColour(int)}.
   *
   * <ul>
   *   <li>When one hundred twenty-three.
   *   <li>Then return {@code white}.
   * </ul>
   *
   * <p>Method under test: {@link V3818#getBannerColour(int)}
   */
  @Test
  @DisplayName("Test getBannerColour(int); when one hundred twenty-three; then return 'white'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String V3818.getBannerColour(int)"})
  void testGetBannerColour_whenOneHundredTwentyThree_thenReturnWhite() {
    // Arrange, Act and Assert
    assertEquals("white", V3818.getBannerColour(123));
  }

  /**
   * Test {@link V3818#getBannerColour(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code orange}.
   * </ul>
   *
   * <p>Method under test: {@link V3818#getBannerColour(int)}
   */
  @Test
  @DisplayName("Test getBannerColour(int); when one; then return 'orange'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String V3818.getBannerColour(int)"})
  void testGetBannerColour_whenOne_thenReturnOrange() {
    // Arrange, Act and Assert
    assertEquals("orange", V3818.getBannerColour(1));
  }
}

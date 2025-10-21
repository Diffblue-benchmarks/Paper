package org.bukkit.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.map.MapView.Scale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MapViewDiffblueTest {
  /**
   * Test Scale {@link Scale#getValue()}.
   *
   * <p>Method under test: {@link Scale#getValue()}
   */
  @Test
  @DisplayName("Test Scale getValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte Scale.getValue()"})
  void testScaleGetValue() {
    // Arrange, Act and Assert
    assertEquals(MapPalette.TRANSPARENT, Scale.valueOf("CLOSEST").getValue());
  }

  /**
   * Test Scale {@link Scale#valueOf(byte)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Scale#valueOf(byte)}
   */
  @Test
  @DisplayName("Test Scale valueOf(byte) with 'value'; when 'A'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Scale Scale.valueOf(byte)"})
  void testScaleValueOfWithValue_whenA_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Scale.valueOf((byte) 'A'));
  }

  /**
   * Test Scale {@link Scale#valueOf(byte)} with {@code value}.
   *
   * <ul>
   *   <li>When {@link MapPalette#LIGHT_GREEN}.
   *   <li>Then return {@code FARTHEST}.
   * </ul>
   *
   * <p>Method under test: {@link Scale#valueOf(byte)}
   */
  @Test
  @DisplayName("Test Scale valueOf(byte) with 'value'; when LIGHT_GREEN; then return 'FARTHEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Scale Scale.valueOf(byte)"})
  void testScaleValueOfWithValue_whenLight_green_thenReturnFarthest() {
    // Arrange, Act and Assert
    assertEquals(Scale.FARTHEST, Scale.valueOf(MapPalette.LIGHT_GREEN));
  }

  /**
   * Test Scale {@link Scale#valueOf(byte)} with {@code value}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code CLOSE}.
   * </ul>
   *
   * <p>Method under test: {@link Scale#valueOf(byte)}
   */
  @Test
  @DisplayName("Test Scale valueOf(byte) with 'value'; when one; then return 'CLOSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Scale Scale.valueOf(byte)"})
  void testScaleValueOfWithValue_whenOne_thenReturnClose() {
    // Arrange, Act and Assert
    assertEquals(Scale.CLOSE, Scale.valueOf((byte) 1));
  }

  /**
   * Test Scale {@link Scale#valueOf(byte)} with {@code value}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code FAR}.
   * </ul>
   *
   * <p>Method under test: {@link Scale#valueOf(byte)}
   */
  @Test
  @DisplayName("Test Scale valueOf(byte) with 'value'; when three; then return 'FAR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Scale Scale.valueOf(byte)"})
  void testScaleValueOfWithValue_whenThree_thenReturnFar() {
    // Arrange, Act and Assert
    assertEquals(Scale.FAR, Scale.valueOf((byte) 3));
  }

  /**
   * Test Scale {@link Scale#valueOf(byte)} with {@code value}.
   *
   * <ul>
   *   <li>When {@link MapPalette#TRANSPARENT}.
   *   <li>Then return {@code CLOSEST}.
   * </ul>
   *
   * <p>Method under test: {@link Scale#valueOf(byte)}
   */
  @Test
  @DisplayName("Test Scale valueOf(byte) with 'value'; when TRANSPARENT; then return 'CLOSEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Scale Scale.valueOf(byte)"})
  void testScaleValueOfWithValue_whenTransparent_thenReturnClosest() {
    // Arrange, Act and Assert
    assertEquals(Scale.CLOSEST, Scale.valueOf(MapPalette.TRANSPARENT));
  }

  /**
   * Test Scale {@link Scale#valueOf(byte)} with {@code value}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code NORMAL}.
   * </ul>
   *
   * <p>Method under test: {@link Scale#valueOf(byte)}
   */
  @Test
  @DisplayName("Test Scale valueOf(byte) with 'value'; when two; then return 'NORMAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Scale Scale.valueOf(byte)"})
  void testScaleValueOfWithValue_whenTwo_thenReturnNormal() {
    // Arrange, Act and Assert
    assertEquals(Scale.NORMAL, Scale.valueOf((byte) 2));
  }
}

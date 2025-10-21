package ca.spottedleaf.dataconverter.minecraft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MCVersionRegistryDiffblueTest {
  /**
   * Test {@link MCVersionRegistry#hasDataConverters(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MCVersionRegistry#hasDataConverters(int)}
   */
  @Test
  @DisplayName("Test hasDataConverters(int); when four; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MCVersionRegistry.hasDataConverters(int)"})
  void testHasDataConverters_whenFour_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MCVersionRegistry.hasDataConverters(4));
  }

  /**
   * Test {@link MCVersionRegistry#hasDataConverters(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MCVersionRegistry#hasDataConverters(int)}
   */
  @Test
  @DisplayName("Test hasDataConverters(int); when MIN_VALUE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MCVersionRegistry.hasDataConverters(int)"})
  void testHasDataConverters_whenMin_value_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MCVersionRegistry.hasDataConverters(Integer.MIN_VALUE));
  }

  /**
   * Test {@link MCVersionRegistry#hasDataConverters(int)}.
   *
   * <ul>
   *   <li>When ninety-nine.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MCVersionRegistry#hasDataConverters(int)}
   */
  @Test
  @DisplayName("Test hasDataConverters(int); when ninety-nine; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MCVersionRegistry.hasDataConverters(int)"})
  void testHasDataConverters_whenNinetyNine_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MCVersionRegistry.hasDataConverters(99));
  }

  /**
   * Test {@link MCVersionRegistry#hasDataConverters(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MCVersionRegistry#hasDataConverters(int)}
   */
  @Test
  @DisplayName("Test hasDataConverters(int); when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MCVersionRegistry.hasDataConverters(int)"})
  void testHasDataConverters_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MCVersionRegistry.hasDataConverters(1));
  }

  /**
   * Test {@link MCVersionRegistry#hasDataConverters(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MCVersionRegistry#hasDataConverters(int)}
   */
  @Test
  @DisplayName("Test hasDataConverters(int); when zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MCVersionRegistry.hasDataConverters(int)"})
  void testHasDataConverters_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MCVersionRegistry.hasDataConverters(0));
  }

  /**
   * Test {@link MCVersionRegistry#getMaxVersion()}.
   *
   * <p>Method under test: {@link MCVersionRegistry#getMaxVersion()}
   */
  @Test
  @DisplayName("Test getMaxVersion()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MCVersionRegistry.getMaxVersion()"})
  void testGetMaxVersion() {
    // Arrange, Act and Assert
    assertEquals(MCVersions.V1_21_8, MCVersionRegistry.getMaxVersion());
  }

  /**
   * Test {@link MCVersionRegistry#checkVersion(long)}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link MCVersionRegistry#checkVersion(long)}
   */
  @Test
  @DisplayName("Test checkVersion(long); when minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MCVersionRegistry.checkVersion(long)"})
  void testCheckVersion_whenMinusOne() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> MCVersionRegistry.checkVersion(-1L));
  }

  /**
   * Test {@link MCVersionRegistry#checkVersion(long)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link MCVersionRegistry#checkVersion(long)}
   */
  @Test
  @DisplayName("Test checkVersion(long); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MCVersionRegistry.checkVersion(long)"})
  void testCheckVersion_whenOne() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> MCVersionRegistry.checkVersion(1L));
  }

  /**
   * Test {@link MCVersionRegistry#checkVersion(long)}.
   *
   * <ul>
   *   <li>When thirty-two.
   * </ul>
   *
   * <p>Method under test: {@link MCVersionRegistry#checkVersion(long)}
   */
  @Test
  @DisplayName("Test checkVersion(long); when thirty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MCVersionRegistry.checkVersion(long)"})
  void testCheckVersion_whenThirtyTwo() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> MCVersionRegistry.checkVersion(32L));
  }

  /**
   * Test {@link MCVersionRegistry#checkVersion(long)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link MCVersionRegistry#checkVersion(long)}
   */
  @Test
  @DisplayName("Test checkVersion(long); when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MCVersionRegistry.checkVersion(long)"})
  void testCheckVersion_whenZero() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> MCVersionRegistry.checkVersion(0L));
  }
}

package co.aikar.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.base.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LoadingIntMapDiffblueTest {
  /**
   * Test {@link LoadingIntMap#LoadingIntMap(Function)}.
   *
   * <p>Method under test: {@link LoadingIntMap#LoadingIntMap(Function)}
   */
  @Test
  @DisplayName("Test new LoadingIntMap(Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LoadingIntMap.<init>(Function)"})
  void testNewLoadingIntMap() {
    // Arrange and Act
    LoadingIntMap<Object> actualObjectMap = new LoadingIntMap<>(mock(Function.class));

    // Assert
    assertTrue(actualObjectMap.isEmpty());
  }

  /**
   * Test {@link LoadingIntMap#LoadingIntMap(int, float, Function)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LoadingIntMap#LoadingIntMap(int, float, Function)}
   */
  @Test
  @DisplayName(
      "Test new LoadingIntMap(int, float, Function); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LoadingIntMap.<init>(int, float, Function)"})
  void testNewLoadingIntMap_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new LoadingIntMap<>(-1, 1.0E-5f, mock(Function.class)));
  }

  /**
   * Test {@link LoadingIntMap#LoadingIntMap(int, Function)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LoadingIntMap#LoadingIntMap(int, Function)}
   */
  @Test
  @DisplayName(
      "Test new LoadingIntMap(int, Function); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LoadingIntMap.<init>(int, Function)"})
  void testNewLoadingIntMap_whenMinusOne_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new LoadingIntMap<>(-1, mock(Function.class)));
  }

  /**
   * Test {@link LoadingIntMap#LoadingIntMap(int, Function)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LoadingIntMap#LoadingIntMap(int, Function)}
   */
  @Test
  @DisplayName("Test new LoadingIntMap(int, Function); when three; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LoadingIntMap.<init>(int, Function)"})
  void testNewLoadingIntMap_whenThree_thenReturnEmpty() {
    // Arrange and Act
    LoadingIntMap<Object> actualObjectMap = new LoadingIntMap<>(3, mock(Function.class));

    // Assert
    assertTrue(actualObjectMap.isEmpty());
  }

  /**
   * Test {@link LoadingIntMap#LoadingIntMap(int, float, Function)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LoadingIntMap#LoadingIntMap(int, float, Function)}
   */
  @Test
  @DisplayName(
      "Test new LoadingIntMap(int, float, Function); when three; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LoadingIntMap.<init>(int, float, Function)"})
  void testNewLoadingIntMap_whenThree_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new LoadingIntMap<>(3, 10.0f, mock(Function.class)));
  }

  /**
   * Test {@link LoadingIntMap#LoadingIntMap(int, float, Function)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LoadingIntMap#LoadingIntMap(int, float, Function)}
   */
  @Test
  @DisplayName("Test new LoadingIntMap(int, float, Function); when zero; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LoadingIntMap.<init>(int, float, Function)"})
  void testNewLoadingIntMap_whenZero_thenReturnEmpty() {
    // Arrange and Act
    LoadingIntMap<Object> actualObjectMap = new LoadingIntMap<>(0, 1.0E-5f, mock(Function.class));

    // Assert
    assertTrue(actualObjectMap.isEmpty());
  }

  /**
   * Test {@link LoadingIntMap#LoadingIntMap(int, float, Function)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LoadingIntMap#LoadingIntMap(int, float, Function)}
   */
  @Test
  @DisplayName(
      "Test new LoadingIntMap(int, float, Function); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LoadingIntMap.<init>(int, float, Function)"})
  void testNewLoadingIntMap_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new LoadingIntMap<>(0, 0.0f, mock(Function.class)));
  }
}

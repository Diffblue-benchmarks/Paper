package ca.spottedleaf.moonrise.common.map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import it.unimi.dsi.fastutil.longs.Long2BooleanFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SynchronisedLong2BooleanMapDiffblueTest {
  /**
   * Test {@link SynchronisedLong2BooleanMap#SynchronisedLong2BooleanMap(int)}.
   *
   * <p>Method under test: {@link SynchronisedLong2BooleanMap#SynchronisedLong2BooleanMap(int)}
   */
  @Test
  @DisplayName("Test new SynchronisedLong2BooleanMap(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SynchronisedLong2BooleanMap.<init>(int)"})
  void testNewSynchronisedLong2BooleanMap() {
    // Arrange, Act and Assert
    assertFalse(new SynchronisedLong2BooleanMap(1).remove(1L));
  }

  /**
   * Test {@link SynchronisedLong2BooleanMap#remove(long)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2BooleanMap#remove(long)}
   */
  @Test
  @DisplayName("Test remove(long); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SynchronisedLong2BooleanMap.remove(long)"})
  void testRemove_whenOne() {
    // Arrange, Act and Assert
    assertFalse(new SynchronisedLong2BooleanMap(1).remove(1L));
  }

  /**
   * Test {@link SynchronisedLong2BooleanMap#remove(long)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2BooleanMap#remove(long)}
   */
  @Test
  @DisplayName("Test remove(long); when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SynchronisedLong2BooleanMap.remove(long)"})
  void testRemove_whenZero() {
    // Arrange, Act and Assert
    assertFalse(new SynchronisedLong2BooleanMap(1).remove(0L));
  }

  /**
   * Test {@link SynchronisedLong2BooleanMap#getOrCompute(long, Long2BooleanFunction)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2BooleanMap#getOrCompute(long,
   * Long2BooleanFunction)}
   */
  @Test
  @DisplayName("Test getOrCompute(long, Long2BooleanFunction); given 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SynchronisedLong2BooleanMap.getOrCompute(long, Long2BooleanFunction)"
  })
  void testGetOrCompute_givenFalse_thenReturnFalse() {
    // Arrange
    SynchronisedLong2BooleanMap synchronisedLong2BooleanMap = new SynchronisedLong2BooleanMap(1);

    Long2BooleanFunction ifAbsent = mock(Long2BooleanFunction.class);
    when(ifAbsent.get(anyLong())).thenReturn(false);

    // Act
    boolean actualOrCompute = synchronisedLong2BooleanMap.getOrCompute(1L, ifAbsent);

    // Assert
    verify(ifAbsent).get(1L);
    assertFalse(actualOrCompute);
    assertFalse(synchronisedLong2BooleanMap.remove(1L));
  }

  /**
   * Test {@link SynchronisedLong2BooleanMap#getOrCompute(long, Long2BooleanFunction)}.
   *
   * <ul>
   *   <li>Then not {@link SynchronisedLong2BooleanMap#SynchronisedLong2BooleanMap(int)} with limit
   *       is one remove one.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2BooleanMap#getOrCompute(long,
   * Long2BooleanFunction)}
   */
  @Test
  @DisplayName(
      "Test getOrCompute(long, Long2BooleanFunction); then not SynchronisedLong2BooleanMap(int) with limit is one remove one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SynchronisedLong2BooleanMap.getOrCompute(long, Long2BooleanFunction)"
  })
  void testGetOrCompute_thenNotSynchronisedLong2BooleanMapWithLimitIsOneRemoveOne() {
    // Arrange
    SynchronisedLong2BooleanMap synchronisedLong2BooleanMap = new SynchronisedLong2BooleanMap(1);

    Long2BooleanFunction ifAbsent = mock(Long2BooleanFunction.class);
    when(ifAbsent.get(anyLong())).thenReturn(true);

    // Act
    boolean actualOrCompute = synchronisedLong2BooleanMap.getOrCompute(0L, ifAbsent);

    // Assert
    verify(ifAbsent).get(0L);
    assertFalse(synchronisedLong2BooleanMap.remove(1L));
    assertTrue(actualOrCompute);
  }

  /**
   * Test {@link SynchronisedLong2BooleanMap#getOrCompute(long, Long2BooleanFunction)}.
   *
   * <ul>
   *   <li>Then not {@link SynchronisedLong2BooleanMap#SynchronisedLong2BooleanMap(int)} with limit
   *       is zero remove one.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2BooleanMap#getOrCompute(long,
   * Long2BooleanFunction)}
   */
  @Test
  @DisplayName(
      "Test getOrCompute(long, Long2BooleanFunction); then not SynchronisedLong2BooleanMap(int) with limit is zero remove one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SynchronisedLong2BooleanMap.getOrCompute(long, Long2BooleanFunction)"
  })
  void testGetOrCompute_thenNotSynchronisedLong2BooleanMapWithLimitIsZeroRemoveOne() {
    // Arrange
    SynchronisedLong2BooleanMap synchronisedLong2BooleanMap = new SynchronisedLong2BooleanMap(0);

    Long2BooleanFunction ifAbsent = mock(Long2BooleanFunction.class);
    when(ifAbsent.get(anyLong())).thenReturn(true);

    // Act
    boolean actualOrCompute = synchronisedLong2BooleanMap.getOrCompute(1L, ifAbsent);

    // Assert
    verify(ifAbsent).get(1L);
    assertFalse(synchronisedLong2BooleanMap.remove(1L));
    assertTrue(actualOrCompute);
  }

  /**
   * Test {@link SynchronisedLong2BooleanMap#getOrCompute(long, Long2BooleanFunction)}.
   *
   * <ul>
   *   <li>Then not {@link SynchronisedLong2BooleanMap#SynchronisedLong2BooleanMap(int)} with limit
   *       is zero remove one.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2BooleanMap#getOrCompute(long,
   * Long2BooleanFunction)}
   */
  @Test
  @DisplayName(
      "Test getOrCompute(long, Long2BooleanFunction); then not SynchronisedLong2BooleanMap(int) with limit is zero remove one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SynchronisedLong2BooleanMap.getOrCompute(long, Long2BooleanFunction)"
  })
  void testGetOrCompute_thenNotSynchronisedLong2BooleanMapWithLimitIsZeroRemoveOne2() {
    // Arrange
    SynchronisedLong2BooleanMap synchronisedLong2BooleanMap = new SynchronisedLong2BooleanMap(0);

    Long2BooleanFunction ifAbsent = mock(Long2BooleanFunction.class);
    when(ifAbsent.get(anyLong())).thenReturn(true);

    // Act
    boolean actualOrCompute = synchronisedLong2BooleanMap.getOrCompute(0L, ifAbsent);

    // Assert
    verify(ifAbsent).get(0L);
    assertFalse(synchronisedLong2BooleanMap.remove(1L));
    assertTrue(actualOrCompute);
  }

  /**
   * Test {@link SynchronisedLong2BooleanMap#getOrCompute(long, Long2BooleanFunction)}.
   *
   * <ul>
   *   <li>Then {@link SynchronisedLong2BooleanMap#SynchronisedLong2BooleanMap(int)} with limit is
   *       one remove one.
   * </ul>
   *
   * <p>Method under test: {@link SynchronisedLong2BooleanMap#getOrCompute(long,
   * Long2BooleanFunction)}
   */
  @Test
  @DisplayName(
      "Test getOrCompute(long, Long2BooleanFunction); then SynchronisedLong2BooleanMap(int) with limit is one remove one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SynchronisedLong2BooleanMap.getOrCompute(long, Long2BooleanFunction)"
  })
  void testGetOrCompute_thenSynchronisedLong2BooleanMapWithLimitIsOneRemoveOne() {
    // Arrange
    SynchronisedLong2BooleanMap synchronisedLong2BooleanMap = new SynchronisedLong2BooleanMap(1);

    Long2BooleanFunction ifAbsent = mock(Long2BooleanFunction.class);
    when(ifAbsent.get(anyLong())).thenReturn(true);

    // Act
    boolean actualOrCompute = synchronisedLong2BooleanMap.getOrCompute(1L, ifAbsent);

    // Assert
    verify(ifAbsent).get(1L);
    assertTrue(actualOrCompute);
    assertTrue(synchronisedLong2BooleanMap.remove(1L));
  }
}

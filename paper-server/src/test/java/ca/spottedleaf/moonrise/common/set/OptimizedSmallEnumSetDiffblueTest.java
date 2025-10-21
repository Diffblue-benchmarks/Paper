package ca.spottedleaf.moonrise.common.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OptimizedSmallEnumSetDiffblueTest {
  /**
   * Test {@link OptimizedSmallEnumSet#OptimizedSmallEnumSet(Class)}.
   *
   * <ul>
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link OptimizedSmallEnumSet#OptimizedSmallEnumSet(Class)}
   */
  @Test
  @DisplayName("Test new OptimizedSmallEnumSet(Class); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OptimizedSmallEnumSet.<init>(Class)"})
  void testNewOptimizedSmallEnumSet_thenReturnSizeIsZero() {
    // Arrange
    Class<BaselineResizeBehavior> clazz = BaselineResizeBehavior.class;

    // Act
    OptimizedSmallEnumSet<BaselineResizeBehavior> actualOptimizedSmallEnumSet =
        new OptimizedSmallEnumSet<>(clazz);

    // Assert
    assertEquals(0, actualOptimizedSmallEnumSet.size());
    assertEquals(0L, actualOptimizedSmallEnumSet.getBackingSet());
  }

  /**
   * Test {@link OptimizedSmallEnumSet#OptimizedSmallEnumSet(Class)}.
   *
   * <ul>
   *   <li>When {@code Enum}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link OptimizedSmallEnumSet#OptimizedSmallEnumSet(Class)}
   */
  @Test
  @DisplayName(
      "Test new OptimizedSmallEnumSet(Class); when 'java.lang.Enum'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OptimizedSmallEnumSet.<init>(Class)"})
  void testNewOptimizedSmallEnumSet_whenJavaLangEnum_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Enum> clazz = Enum.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new OptimizedSmallEnumSet<>(clazz));
  }

  /**
   * Test {@link OptimizedSmallEnumSet#OptimizedSmallEnumSet(Class)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link OptimizedSmallEnumSet#OptimizedSmallEnumSet(Class)}
   */
  @Test
  @DisplayName(
      "Test new OptimizedSmallEnumSet(Class); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OptimizedSmallEnumSet.<init>(Class)"})
  void testNewOptimizedSmallEnumSet_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new OptimizedSmallEnumSet<>(null));
  }

  /**
   * Test {@link OptimizedSmallEnumSet#addUnchecked(Enum)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OptimizedSmallEnumSet#addUnchecked(Object)}
   */
  @Test
  @DisplayName("Test addUnchecked(Enum); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OptimizedSmallEnumSet.addUnchecked(Enum)"})
  void testAddUnchecked_thenReturnFalse() {
    // Arrange
    Class<BaselineResizeBehavior> clazz = BaselineResizeBehavior.class;

    OptimizedSmallEnumSet<BaselineResizeBehavior> optimizedSmallEnumSet =
        new OptimizedSmallEnumSet<>(clazz);
    optimizedSmallEnumSet.addUnchecked(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    boolean actualAddUncheckedResult =
        optimizedSmallEnumSet.addUnchecked(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Assert
    assertEquals(1, optimizedSmallEnumSet.size());
    assertEquals(1L, optimizedSmallEnumSet.getBackingSet());
    assertFalse(actualAddUncheckedResult);
  }

  /**
   * Test {@link OptimizedSmallEnumSet#addUnchecked(Enum)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OptimizedSmallEnumSet#addUnchecked(Object)}
   */
  @Test
  @DisplayName("Test addUnchecked(Enum); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OptimizedSmallEnumSet.addUnchecked(Enum)"})
  void testAddUnchecked_thenReturnTrue() {
    // Arrange
    Class<BaselineResizeBehavior> clazz = BaselineResizeBehavior.class;
    OptimizedSmallEnumSet<BaselineResizeBehavior> optimizedSmallEnumSet =
        new OptimizedSmallEnumSet<>(clazz);

    // Act
    boolean actualAddUncheckedResult =
        optimizedSmallEnumSet.addUnchecked(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Assert
    assertEquals(1, optimizedSmallEnumSet.size());
    assertEquals(1L, optimizedSmallEnumSet.getBackingSet());
    assertTrue(actualAddUncheckedResult);
  }

  /**
   * Test {@link OptimizedSmallEnumSet#removeUnchecked(Enum)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OptimizedSmallEnumSet#removeUnchecked(Object)}
   */
  @Test
  @DisplayName("Test removeUnchecked(Enum); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OptimizedSmallEnumSet.removeUnchecked(Enum)"})
  void testRemoveUnchecked_thenReturnFalse() {
    // Arrange
    Class<BaselineResizeBehavior> clazz = BaselineResizeBehavior.class;
    OptimizedSmallEnumSet<BaselineResizeBehavior> optimizedSmallEnumSet =
        new OptimizedSmallEnumSet<>(clazz);

    // Act
    boolean actualRemoveUncheckedResult =
        optimizedSmallEnumSet.removeUnchecked(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Assert
    assertEquals(0, optimizedSmallEnumSet.size());
    assertEquals(0L, optimizedSmallEnumSet.getBackingSet());
    assertFalse(actualRemoveUncheckedResult);
  }

  /**
   * Test {@link OptimizedSmallEnumSet#removeUnchecked(Enum)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OptimizedSmallEnumSet#removeUnchecked(Object)}
   */
  @Test
  @DisplayName("Test removeUnchecked(Enum); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OptimizedSmallEnumSet.removeUnchecked(Enum)"})
  void testRemoveUnchecked_thenReturnTrue() {
    // Arrange
    Class<BaselineResizeBehavior> clazz = BaselineResizeBehavior.class;

    OptimizedSmallEnumSet<BaselineResizeBehavior> optimizedSmallEnumSet =
        new OptimizedSmallEnumSet<>(clazz);
    optimizedSmallEnumSet.addUnchecked(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    boolean actualRemoveUncheckedResult =
        optimizedSmallEnumSet.removeUnchecked(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Assert
    assertEquals(0, optimizedSmallEnumSet.size());
    assertEquals(0L, optimizedSmallEnumSet.getBackingSet());
    assertTrue(actualRemoveUncheckedResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OptimizedSmallEnumSet#clear()}
   *   <li>{@link OptimizedSmallEnumSet#getBackingSet()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OptimizedSmallEnumSet.clear()",
    "long OptimizedSmallEnumSet.getBackingSet()"
  })
  void testGettersAndSetters() {
    // Arrange
    Class<BaselineResizeBehavior> clazz = BaselineResizeBehavior.class;
    OptimizedSmallEnumSet<BaselineResizeBehavior> optimizedSmallEnumSet =
        new OptimizedSmallEnumSet<>(clazz);

    // Act
    optimizedSmallEnumSet.clear();

    // Assert
    assertEquals(0L, optimizedSmallEnumSet.getBackingSet());
  }

  /**
   * Test {@link OptimizedSmallEnumSet#size()}.
   *
   * <p>Method under test: {@link OptimizedSmallEnumSet#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int OptimizedSmallEnumSet.size()"})
  void testSize() {
    // Arrange
    Class<BaselineResizeBehavior> clazz = BaselineResizeBehavior.class;
    OptimizedSmallEnumSet<BaselineResizeBehavior> optimizedSmallEnumSet =
        new OptimizedSmallEnumSet<>(clazz);

    // Act and Assert
    assertEquals(0, optimizedSmallEnumSet.size());
  }

  /**
   * Test {@link OptimizedSmallEnumSet#addAllUnchecked(Collection)}.
   *
   * <p>Method under test: {@link OptimizedSmallEnumSet#addAllUnchecked(Collection)}
   */
  @Test
  @DisplayName("Test addAllUnchecked(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OptimizedSmallEnumSet.addAllUnchecked(Collection)"})
  void testAddAllUnchecked() {
    // Arrange
    Class<BaselineResizeBehavior> clazz = BaselineResizeBehavior.class;
    OptimizedSmallEnumSet<BaselineResizeBehavior> optimizedSmallEnumSet =
        new OptimizedSmallEnumSet<>(clazz);

    // Act
    optimizedSmallEnumSet.addAllUnchecked(new ArrayList<>());

    // Assert that nothing has changed
    assertEquals(0, optimizedSmallEnumSet.size());
    assertEquals(0L, optimizedSmallEnumSet.getBackingSet());
  }

  /**
   * Test {@link OptimizedSmallEnumSet#addAllUnchecked(Collection)}.
   *
   * <p>Method under test: {@link OptimizedSmallEnumSet#addAllUnchecked(Collection)}
   */
  @Test
  @DisplayName("Test addAllUnchecked(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OptimizedSmallEnumSet.addAllUnchecked(Collection)"})
  void testAddAllUnchecked2() {
    // Arrange
    Class<BaselineResizeBehavior> clazz = BaselineResizeBehavior.class;
    OptimizedSmallEnumSet<BaselineResizeBehavior> optimizedSmallEnumSet =
        new OptimizedSmallEnumSet<>(clazz);

    LinkedHashSet<BaselineResizeBehavior> enums = new LinkedHashSet<>();
    enums.add(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    optimizedSmallEnumSet.addAllUnchecked(enums);

    // Assert
    assertEquals(1, optimizedSmallEnumSet.size());
    assertEquals(1L, optimizedSmallEnumSet.getBackingSet());
  }

  /**
   * Test {@link OptimizedSmallEnumSet#addAllUnchecked(Collection)}.
   *
   * <p>Method under test: {@link OptimizedSmallEnumSet#addAllUnchecked(Collection)}
   */
  @Test
  @DisplayName("Test addAllUnchecked(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OptimizedSmallEnumSet.addAllUnchecked(Collection)"})
  void testAddAllUnchecked3() {
    // Arrange
    Class<BaselineResizeBehavior> clazz = BaselineResizeBehavior.class;
    OptimizedSmallEnumSet<BaselineResizeBehavior> optimizedSmallEnumSet =
        new OptimizedSmallEnumSet<>(clazz);

    ArrayList<BaselineResizeBehavior> enums = new ArrayList<>();
    enums.add(BaselineResizeBehavior.CONSTANT_DESCENT);
    enums.add(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    optimizedSmallEnumSet.addAllUnchecked(enums);

    // Assert
    assertEquals(2, optimizedSmallEnumSet.size());
    assertEquals(3L, optimizedSmallEnumSet.getBackingSet());
  }

  /**
   * Test {@link OptimizedSmallEnumSet#hasCommonElements(OptimizedSmallEnumSet)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OptimizedSmallEnumSet#hasCommonElements(OptimizedSmallEnumSet)}
   */
  @Test
  @DisplayName("Test hasCommonElements(OptimizedSmallEnumSet); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OptimizedSmallEnumSet.hasCommonElements(OptimizedSmallEnumSet)"})
  void testHasCommonElements_thenReturnFalse() {
    // Arrange
    Class<BaselineResizeBehavior> clazz = BaselineResizeBehavior.class;
    OptimizedSmallEnumSet<BaselineResizeBehavior> optimizedSmallEnumSet =
        new OptimizedSmallEnumSet<>(clazz);
    Class<BaselineResizeBehavior> clazz2 = BaselineResizeBehavior.class;

    // Act
    boolean actualHasCommonElementsResult =
        optimizedSmallEnumSet.hasCommonElements(new OptimizedSmallEnumSet<>(clazz2));

    // Assert
    assertFalse(actualHasCommonElementsResult);
  }

  /**
   * Test {@link OptimizedSmallEnumSet#hasCommonElements(OptimizedSmallEnumSet)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OptimizedSmallEnumSet#hasCommonElements(OptimizedSmallEnumSet)}
   */
  @Test
  @DisplayName("Test hasCommonElements(OptimizedSmallEnumSet); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OptimizedSmallEnumSet.hasCommonElements(OptimizedSmallEnumSet)"})
  void testHasCommonElements_thenReturnTrue() {
    // Arrange
    Class<BaselineResizeBehavior> clazz = BaselineResizeBehavior.class;

    OptimizedSmallEnumSet<BaselineResizeBehavior> optimizedSmallEnumSet =
        new OptimizedSmallEnumSet<>(clazz);
    optimizedSmallEnumSet.addUnchecked(BaselineResizeBehavior.CONSTANT_ASCENT);
    Class<BaselineResizeBehavior> clazz2 = BaselineResizeBehavior.class;

    OptimizedSmallEnumSet<BaselineResizeBehavior> other = new OptimizedSmallEnumSet<>(clazz2);
    other.addUnchecked(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    boolean actualHasCommonElementsResult = optimizedSmallEnumSet.hasCommonElements(other);

    // Assert
    assertTrue(actualHasCommonElementsResult);
  }

  /**
   * Test {@link OptimizedSmallEnumSet#hasElement(Enum)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OptimizedSmallEnumSet#hasElement(Object)}
   */
  @Test
  @DisplayName("Test hasElement(Enum); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OptimizedSmallEnumSet.hasElement(Enum)"})
  void testHasElement_thenReturnFalse() {
    // Arrange
    Class<BaselineResizeBehavior> clazz = BaselineResizeBehavior.class;
    OptimizedSmallEnumSet<BaselineResizeBehavior> optimizedSmallEnumSet =
        new OptimizedSmallEnumSet<>(clazz);

    // Act and Assert
    assertFalse(optimizedSmallEnumSet.hasElement(BaselineResizeBehavior.CONSTANT_ASCENT));
  }

  /**
   * Test {@link OptimizedSmallEnumSet#hasElement(Enum)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OptimizedSmallEnumSet#hasElement(Object)}
   */
  @Test
  @DisplayName("Test hasElement(Enum); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OptimizedSmallEnumSet.hasElement(Enum)"})
  void testHasElement_thenReturnTrue() {
    // Arrange
    Class<BaselineResizeBehavior> clazz = BaselineResizeBehavior.class;

    OptimizedSmallEnumSet<BaselineResizeBehavior> optimizedSmallEnumSet =
        new OptimizedSmallEnumSet<>(clazz);
    optimizedSmallEnumSet.addUnchecked(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertTrue(optimizedSmallEnumSet.hasElement(BaselineResizeBehavior.CONSTANT_ASCENT));
  }
}

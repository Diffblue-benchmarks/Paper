package org.bukkit.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockVectorDiffblueTest {
  /**
   * Test {@link BlockVector#BlockVector()}.
   *
   * <p>Method under test: {@link BlockVector#BlockVector()}
   */
  @Test
  @DisplayName("Test new BlockVector()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockVector.<init>()"})
  void testNewBlockVector() {
    // Arrange and Act
    BlockVector actualBlockVector = new BlockVector();

    // Assert
    assertEquals(0.0d, actualBlockVector.getX());
    assertEquals(0.0d, actualBlockVector.getY());
    assertEquals(0.0d, actualBlockVector.getZ());
  }

  /**
   * Test {@link BlockVector#BlockVector(double, double, double)}.
   *
   * <p>Method under test: {@link BlockVector#BlockVector(double, double, double)}
   */
  @Test
  @DisplayName("Test new BlockVector(double, double, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockVector.<init>(double, double, double)"})
  void testNewBlockVector2() {
    // Arrange and Act
    BlockVector actualBlockVector = new BlockVector(2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(10.0d, actualBlockVector.getZ());
    assertEquals(10.63014581273465d, actualBlockVector.length());
    assertEquals(2, actualBlockVector.getBlockX());
    assertEquals(2.0d, actualBlockVector.getX());
    assertEquals(3, actualBlockVector.getBlockY());
    assertEquals(3.0d, actualBlockVector.getY());
    assertFalse(actualBlockVector.isZero());
    BlockVector actualToBlockVectorResult = actualBlockVector.toBlockVector();
    assertEquals(actualBlockVector, actualToBlockVectorResult);
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualBlockVector.getBlockZ());
  }

  /**
   * Test {@link BlockVector#BlockVector(float, float, float)}.
   *
   * <p>Method under test: {@link BlockVector#BlockVector(float, float, float)}
   */
  @Test
  @DisplayName("Test new BlockVector(float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockVector.<init>(float, float, float)"})
  void testNewBlockVector3() {
    // Arrange and Act
    BlockVector actualBlockVector = new BlockVector(10.0f, 10.0f, 10.0f);

    // Assert
    assertEquals(10.0d, actualBlockVector.getX());
    assertEquals(10.0d, actualBlockVector.getY());
    assertEquals(10.0d, actualBlockVector.getZ());
    assertEquals(17.320508075688775d, actualBlockVector.length());
    assertFalse(actualBlockVector.isZero());
    BlockVector actualToBlockVectorResult = actualBlockVector.toBlockVector();
    assertEquals(actualBlockVector, actualToBlockVectorResult);
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualBlockVector.getBlockX());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualBlockVector.getBlockY());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualBlockVector.getBlockZ());
  }

  /**
   * Test {@link BlockVector#BlockVector(int, int, int)}.
   *
   * <p>Method under test: {@link BlockVector#BlockVector(int, int, int)}
   */
  @Test
  @DisplayName("Test new BlockVector(int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockVector.<init>(int, int, int)"})
  void testNewBlockVector4() {
    // Arrange and Act
    BlockVector actualBlockVector = new BlockVector(2, 3, 1);

    // Assert
    assertEquals(1, actualBlockVector.getBlockZ());
    assertEquals(1.0d, actualBlockVector.getZ());
    assertEquals(2, actualBlockVector.getBlockX());
    assertEquals(2.0d, actualBlockVector.getX());
    assertEquals(3, actualBlockVector.getBlockY());
    assertEquals(3.0d, actualBlockVector.getY());
    assertEquals(3.7416573867739413d, actualBlockVector.length());
    assertFalse(actualBlockVector.isZero());
    BlockVector actualToBlockVectorResult = actualBlockVector.toBlockVector();
    assertEquals(actualBlockVector, actualToBlockVectorResult);
  }

  /**
   * Test {@link BlockVector#BlockVector(Vector)}.
   *
   * <p>Method under test: {@link BlockVector#BlockVector(Vector)}
   */
  @Test
  @DisplayName("Test new BlockVector(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockVector.<init>(Vector)"})
  void testNewBlockVector5() {
    // Arrange and Act
    BlockVector actualBlockVector = new BlockVector(Vector.getRandom());

    // Assert
    assertEquals(0, actualBlockVector.getBlockX());
    assertEquals(0, actualBlockVector.getBlockY());
    assertEquals(0, actualBlockVector.getBlockZ());
    assertFalse(actualBlockVector.isZero());
    BlockVector actualToBlockVectorResult = actualBlockVector.toBlockVector();
    assertEquals(actualBlockVector, actualToBlockVectorResult);
  }

  /**
   * Test {@link BlockVector#equals(Object)}, and {@link BlockVector#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockVector#equals(Object)}
   *   <li>{@link BlockVector#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockVector.equals(Object)", "int BlockVector.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BlockVector blockVector = new BlockVector(2.0d, 3.0d, 10.0d);
    BlockVector blockVector2 = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertEquals(blockVector, blockVector2);
    assertEquals(blockVector.hashCode(), blockVector2.hashCode());
  }

  /**
   * Test {@link BlockVector#equals(Object)}, and {@link BlockVector#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockVector#equals(Object)}
   *   <li>{@link BlockVector#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockVector.equals(Object)", "int BlockVector.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BlockVector blockVector = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertEquals(blockVector, blockVector);
    int expectedHashCodeResult = blockVector.hashCode();
    assertEquals(expectedHashCodeResult, blockVector.hashCode());
  }

  /**
   * Test {@link BlockVector#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockVector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockVector.equals(Object)", "int BlockVector.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BlockVector blockVector = new BlockVector(10.0d, 3.0d, 10.0d);

    // Act and Assert
    assertNotEquals(blockVector, new BlockVector(2.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link BlockVector#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockVector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockVector.equals(Object)", "int BlockVector.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BlockVector blockVector = new BlockVector(2.0d, 10.0d, 10.0d);

    // Act and Assert
    assertNotEquals(blockVector, new BlockVector(2.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link BlockVector#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockVector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockVector.equals(Object)", "int BlockVector.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BlockVector blockVector = new BlockVector(2.0d, 3.0d, 1.0d);

    // Act and Assert
    assertNotEquals(blockVector, new BlockVector(2.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link BlockVector#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockVector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockVector.equals(Object)", "int BlockVector.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BlockVector(2.0d, 3.0d, 10.0d), null);
  }

  /**
   * Test {@link BlockVector#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockVector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockVector.equals(Object)", "int BlockVector.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BlockVector(2.0d, 3.0d, 10.0d), "Different type to BlockVector");
  }

  /**
   * Test {@link BlockVector#clone()}.
   *
   * <p>Method under test: {@link BlockVector#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockVector BlockVector.clone()"})
  void testClone() {
    // Arrange
    BlockVector blockVector = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act
    BlockVector actualCloneResult = blockVector.clone();

    // Assert
    assertEquals(blockVector, actualCloneResult);
  }

  /**
   * Test {@link BlockVector#deserialize(Map)}.
   *
   * <p>Method under test: {@link BlockVector#deserialize(Map)}
   */
  @Test
  @DisplayName("Test deserialize(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockVector BlockVector.deserialize(Map)"})
  void testDeserialize() {
    // Arrange and Act
    BlockVector actualDeserializeResult = BlockVector.deserialize(new HashMap<>());

    // Assert
    assertEquals(0, actualDeserializeResult.getBlockX());
    assertEquals(0, actualDeserializeResult.getBlockY());
    assertEquals(0, actualDeserializeResult.getBlockZ());
    assertEquals(0.0d, actualDeserializeResult.getX());
    assertEquals(0.0d, actualDeserializeResult.getY());
    assertEquals(0.0d, actualDeserializeResult.getZ());
    assertEquals(0.0d, actualDeserializeResult.length());
    assertTrue(actualDeserializeResult.isZero());
    BlockVector actualToBlockVectorResult = actualDeserializeResult.toBlockVector();
    assertEquals(actualDeserializeResult, actualToBlockVectorResult);
  }
}

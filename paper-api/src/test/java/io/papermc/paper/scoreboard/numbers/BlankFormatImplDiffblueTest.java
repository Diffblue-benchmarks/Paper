package io.papermc.paper.scoreboard.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlankFormatImplDiffblueTest {
  /**
   * Test {@link BlankFormatImpl#equals(Object)}, and {@link BlankFormatImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlankFormatImpl#equals(Object)}
   *   <li>{@link BlankFormatImpl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlankFormatImpl.equals(Object)", "int BlankFormatImpl.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BlankFormatImpl blankFormatImpl = BlankFormatImpl.INSTANCE;
    BlankFormatImpl blankFormatImpl2 = BlankFormatImpl.INSTANCE;

    // Act and Assert
    assertEquals(blankFormatImpl, blankFormatImpl2);
    assertEquals(blankFormatImpl.hashCode(), blankFormatImpl2.hashCode());
  }

  /**
   * Test {@link BlankFormatImpl#equals(Object)}, and {@link BlankFormatImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlankFormatImpl#equals(Object)}
   *   <li>{@link BlankFormatImpl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlankFormatImpl.equals(Object)", "int BlankFormatImpl.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BlankFormatImpl blankFormatImpl = BlankFormatImpl.INSTANCE;

    // Act and Assert
    assertEquals(blankFormatImpl, blankFormatImpl);
    int expectedHashCodeResult = blankFormatImpl.hashCode();
    assertEquals(expectedHashCodeResult, blankFormatImpl.hashCode());
  }

  /**
   * Test {@link BlankFormatImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlankFormatImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlankFormatImpl.equals(Object)", "int BlankFormatImpl.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BlankFormatImpl.INSTANCE, 4);
  }

  /**
   * Test {@link BlankFormatImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlankFormatImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlankFormatImpl.equals(Object)", "int BlankFormatImpl.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BlankFormatImpl.INSTANCE, null);
  }

  /**
   * Test {@link BlankFormatImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlankFormatImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlankFormatImpl.equals(Object)", "int BlankFormatImpl.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BlankFormatImpl.INSTANCE, "Different type to BlankFormatImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BlankFormatImpl}
   *   <li>{@link BlankFormatImpl#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlankFormatImpl.<init>()",
    "java.lang.String BlankFormatImpl.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("BlankFormatImpl[]", new BlankFormatImpl().toString());
  }
}

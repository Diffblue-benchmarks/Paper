package org.bukkit.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Display.Brightness;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DisplayDiffblueTest {
  /**
   * Test Brightness {@link Brightness#equals(Object)}, and {@link Brightness#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Brightness#equals(Object)}
   *   <li>{@link Brightness#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test Brightness equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Brightness.equals(Object)", "int Brightness.hashCode()"})
  void testBrightnessEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Brightness brightness = new Brightness(1, 1);
    Brightness brightness2 = new Brightness(1, 1);

    // Act and Assert
    assertEquals(brightness, brightness2);
    assertEquals(brightness.hashCode(), brightness2.hashCode());
  }

  /**
   * Test Brightness {@link Brightness#equals(Object)}, and {@link Brightness#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Brightness#equals(Object)}
   *   <li>{@link Brightness#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test Brightness equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Brightness.equals(Object)", "int Brightness.hashCode()"})
  void testBrightnessEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Brightness brightness = new Brightness(1, 1);

    // Act and Assert
    assertEquals(brightness, brightness);
    int expectedHashCodeResult = brightness.hashCode();
    assertEquals(expectedHashCodeResult, brightness.hashCode());
  }

  /**
   * Test Brightness {@link Brightness#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Brightness#equals(Object)}
   */
  @Test
  @DisplayName("Test Brightness equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Brightness.equals(Object)", "int Brightness.hashCode()"})
  void testBrightnessEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Brightness brightness = new Brightness(0, 1);

    // Act and Assert
    assertNotEquals(brightness, new Brightness(1, 1));
  }

  /**
   * Test Brightness {@link Brightness#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Brightness#equals(Object)}
   */
  @Test
  @DisplayName("Test Brightness equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Brightness.equals(Object)", "int Brightness.hashCode()"})
  void testBrightnessEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Brightness brightness = new Brightness(1, 0);

    // Act and Assert
    assertNotEquals(brightness, new Brightness(1, 1));
  }

  /**
   * Test Brightness {@link Brightness#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Brightness#equals(Object)}
   */
  @Test
  @DisplayName("Test Brightness equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Brightness.equals(Object)", "int Brightness.hashCode()"})
  void testBrightnessEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Brightness(1, 1), null);
  }

  /**
   * Test Brightness {@link Brightness#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Brightness#equals(Object)}
   */
  @Test
  @DisplayName("Test Brightness equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Brightness.equals(Object)", "int Brightness.hashCode()"})
  void testBrightnessEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Brightness(1, 1), "Different type to Brightness");
  }

  /**
   * Test Brightness getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Brightness#toString()}
   *   <li>{@link Brightness#getBlockLight()}
   *   <li>{@link Brightness#getSkyLight()}
   * </ul>
   */
  @Test
  @DisplayName("Test Brightness getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int Brightness.getBlockLight()",
    "int Brightness.getSkyLight()",
    "String Brightness.toString()"
  })
  void testBrightnessGettersAndSetters() {
    // Arrange
    Brightness brightness = new Brightness(1, 1);

    // Act
    String actualToStringResult = brightness.toString();
    int actualBlockLight = brightness.getBlockLight();

    // Assert
    assertEquals("Brightness{blockLight=1, skyLight=1}", actualToStringResult);
    assertEquals(1, actualBlockLight);
    assertEquals(1, brightness.getSkyLight());
  }

  /**
   * Test Brightness {@link Brightness#Brightness(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return BlockLight is one.
   * </ul>
   *
   * <p>Method under test: {@link Brightness#Brightness(int, int)}
   */
  @Test
  @DisplayName("Test Brightness new Brightness(int, int); when one; then return BlockLight is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Brightness.<init>(int, int)"})
  void testBrightnessNewBrightness_whenOne_thenReturnBlockLightIsOne() {
    // Arrange and Act
    Brightness actualBrightness = new Brightness(1, 1);

    // Assert
    assertEquals(1, actualBrightness.getBlockLight());
    assertEquals(1, actualBrightness.getSkyLight());
  }
}

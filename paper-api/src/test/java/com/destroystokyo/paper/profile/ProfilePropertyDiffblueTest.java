package com.destroystokyo.paper.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProfilePropertyDiffblueTest {
  /**
   * Test {@link ProfileProperty#ProfileProperty(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Signature is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProfileProperty#ProfileProperty(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new ProfileProperty(String, String, String); when '42'; then return Signature is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProfileProperty.<init>(String, String, String)"})
  void testNewProfileProperty_when42_thenReturnSignatureIsNull() {
    // Arrange and Act
    ProfileProperty actualProfileProperty = new ProfileProperty("Name", "42", null);

    // Assert
    assertEquals("42", actualProfileProperty.getValue());
    assertEquals("Name", actualProfileProperty.getName());
    assertNull(actualProfileProperty.getSignature());
    assertFalse(actualProfileProperty.isSigned());
  }

  /**
   * Test {@link ProfileProperty#ProfileProperty(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ProfileProperty#ProfileProperty(String, String)}
   */
  @Test
  @DisplayName("Test new ProfileProperty(String, String); when '42'; then return Value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProfileProperty.<init>(String, String)"})
  void testNewProfileProperty_when42_thenReturnValueIs42() {
    // Arrange and Act
    ProfileProperty actualProfileProperty = new ProfileProperty("Name", "42");

    // Assert
    assertEquals("42", actualProfileProperty.getValue());
    assertEquals("Name", actualProfileProperty.getName());
    assertNull(actualProfileProperty.getSignature());
    assertFalse(actualProfileProperty.isSigned());
  }

  /**
   * Test {@link ProfileProperty#ProfileProperty(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Signature}.
   *   <li>Then return {@code Signature}.
   * </ul>
   *
   * <p>Method under test: {@link ProfileProperty#ProfileProperty(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new ProfileProperty(String, String, String); when 'Signature'; then return 'Signature'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProfileProperty.<init>(String, String, String)"})
  void testNewProfileProperty_whenSignature_thenReturnSignature() {
    // Arrange and Act
    ProfileProperty actualProfileProperty = new ProfileProperty("Name", "42", "Signature");

    // Assert
    assertEquals("42", actualProfileProperty.getValue());
    assertEquals("Name", actualProfileProperty.getName());
    assertEquals("Signature", actualProfileProperty.getSignature());
    assertTrue(actualProfileProperty.isSigned());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProfileProperty#getName()}
   *   <li>{@link ProfileProperty#getSignature()}
   *   <li>{@link ProfileProperty#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ProfileProperty.getName()",
    "String ProfileProperty.getSignature()",
    "String ProfileProperty.getValue()"
  })
  void testGettersAndSetters() {
    // Arrange
    ProfileProperty profileProperty = new ProfileProperty("Name", "42");

    // Act
    String actualName = profileProperty.getName();
    String actualSignature = profileProperty.getSignature();

    // Assert
    assertEquals("42", profileProperty.getValue());
    assertEquals("Name", actualName);
    assertNull(actualSignature);
  }

  /**
   * Test {@link ProfileProperty#isSigned()}.
   *
   * <ul>
   *   <li>Given {@link ProfileProperty#ProfileProperty(String, String, String)} with {@code Name}
   *       and value is {@code 42} and {@code Signature}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProfileProperty#isSigned()}
   */
  @Test
  @DisplayName(
      "Test isSigned(); given ProfileProperty(String, String, String) with 'Name' and value is '42' and 'Signature'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProfileProperty.isSigned()"})
  void testIsSigned_givenProfilePropertyWithNameAndValueIs42AndSignature_thenReturnTrue() {
    // Arrange
    ProfileProperty profileProperty = new ProfileProperty("Name", "42", "Signature");

    // Act and Assert
    assertTrue(profileProperty.isSigned());
  }

  /**
   * Test {@link ProfileProperty#isSigned()}.
   *
   * <ul>
   *   <li>Given {@link ProfileProperty#ProfileProperty(String, String)} with {@code Name} and value
   *       is {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProfileProperty#isSigned()}
   */
  @Test
  @DisplayName(
      "Test isSigned(); given ProfileProperty(String, String) with 'Name' and value is '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProfileProperty.isSigned()"})
  void testIsSigned_givenProfilePropertyWithNameAndValueIs42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ProfileProperty("Name", "42").isSigned());
  }

  /**
   * Test {@link ProfileProperty#equals(Object)}, and {@link ProfileProperty#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProfileProperty#equals(Object)}
   *   <li>{@link ProfileProperty#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProfileProperty.equals(Object)", "int ProfileProperty.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProfileProperty profileProperty = new ProfileProperty("Name", "42");
    ProfileProperty profileProperty2 = new ProfileProperty("Name", "42");

    // Act and Assert
    assertEquals(profileProperty, profileProperty2);
    assertEquals(profileProperty.hashCode(), profileProperty2.hashCode());
  }

  /**
   * Test {@link ProfileProperty#equals(Object)}, and {@link ProfileProperty#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProfileProperty#equals(Object)}
   *   <li>{@link ProfileProperty#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProfileProperty.equals(Object)", "int ProfileProperty.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProfileProperty profileProperty = new ProfileProperty("Name", "42");

    // Act and Assert
    assertEquals(profileProperty, profileProperty);
    int expectedHashCodeResult = profileProperty.hashCode();
    assertEquals(expectedHashCodeResult, profileProperty.hashCode());
  }

  /**
   * Test {@link ProfileProperty#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProfileProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProfileProperty.equals(Object)", "int ProfileProperty.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProfileProperty profileProperty = new ProfileProperty("Name", "42", "Signature");

    // Act and Assert
    assertNotEquals(profileProperty, new ProfileProperty("Name", "42"));
  }

  /**
   * Test {@link ProfileProperty#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProfileProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProfileProperty.equals(Object)", "int ProfileProperty.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProfileProperty profileProperty =
        new ProfileProperty("com.destroystokyo.paper.profile.ProfileProperty", "42");

    // Act and Assert
    assertNotEquals(profileProperty, new ProfileProperty("Name", "42"));
  }

  /**
   * Test {@link ProfileProperty#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProfileProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProfileProperty.equals(Object)", "int ProfileProperty.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProfileProperty profileProperty = new ProfileProperty("Name", "Value");

    // Act and Assert
    assertNotEquals(profileProperty, new ProfileProperty("Name", "42"));
  }

  /**
   * Test {@link ProfileProperty#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProfileProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProfileProperty.equals(Object)", "int ProfileProperty.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProfileProperty("Name", "42"), null);
  }

  /**
   * Test {@link ProfileProperty#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProfileProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProfileProperty.equals(Object)", "int ProfileProperty.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProfileProperty("Name", "42"), "Different type to ProfileProperty");
  }
}

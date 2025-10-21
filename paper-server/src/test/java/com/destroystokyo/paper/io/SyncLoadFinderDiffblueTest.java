package com.destroystokyo.paper.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.destroystokyo.paper.io.SyncLoadFinder.ThrowableWithEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SyncLoadFinderDiffblueTest {
  /**
   * Test {@link SyncLoadFinder#serialize()}.
   *
   * <p>Method under test: {@link SyncLoadFinder#serialize()}
   */
  @Test
  @DisplayName("Test serialize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonObject SyncLoadFinder.serialize()"})
  void testSerialize() {
    // Arrange and Act
    JsonObject actualSerializeResult = SyncLoadFinder.serialize();

    // Assert
    assertEquals(1, actualSerializeResult.size());
    assertFalse(actualSerializeResult.isJsonArray());
    assertFalse(actualSerializeResult.isJsonNull());
    assertFalse(actualSerializeResult.isJsonPrimitive());
    assertFalse(actualSerializeResult.isEmpty());
    assertTrue(actualSerializeResult.isJsonObject());
    JsonObject actualAsJsonObject = actualSerializeResult.getAsJsonObject();
    assertSame(actualSerializeResult, actualAsJsonObject);
  }

  /**
   * Test ThrowableWithEquals {@link ThrowableWithEquals#equals(Object)}, and {@link
   * ThrowableWithEquals#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ThrowableWithEquals#equals(Object)}
   *   <li>{@link ThrowableWithEquals#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ThrowableWithEquals equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ThrowableWithEquals.equals(Object)",
    "int ThrowableWithEquals.hashCode()"
  })
  void testThrowableWithEqualsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StackTraceElement stackTraceElement = new StackTraceElement("foo", "foo", "foo", 1);
    StackTraceElement[] stacktrace = new StackTraceElement[] {stackTraceElement};
    ThrowableWithEquals throwableWithEquals = new ThrowableWithEquals(stacktrace);
    StackTraceElement stackTraceElement2 = new StackTraceElement("foo", "foo", "foo", 1);
    StackTraceElement[] stacktrace2 = new StackTraceElement[] {stackTraceElement2};
    ThrowableWithEquals throwableWithEquals2 = new ThrowableWithEquals(stacktrace2);

    // Act and Assert
    assertEquals(throwableWithEquals, throwableWithEquals2);
    assertEquals(throwableWithEquals.hashCode(), throwableWithEquals2.hashCode());
  }

  /**
   * Test ThrowableWithEquals {@link ThrowableWithEquals#equals(Object)}, and {@link
   * ThrowableWithEquals#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ThrowableWithEquals#equals(Object)}
   *   <li>{@link ThrowableWithEquals#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ThrowableWithEquals equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ThrowableWithEquals.equals(Object)",
    "int ThrowableWithEquals.hashCode()"
  })
  void testThrowableWithEqualsEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StackTraceElement stackTraceElement = new StackTraceElement("foo", "foo", "foo", 1);
    StackTraceElement[] stacktrace = new StackTraceElement[] {stackTraceElement};
    ThrowableWithEquals throwableWithEquals = new ThrowableWithEquals(stacktrace);

    // Act and Assert
    assertEquals(throwableWithEquals, throwableWithEquals);
    int expectedHashCodeResult = throwableWithEquals.hashCode();
    assertEquals(expectedHashCodeResult, throwableWithEquals.hashCode());
  }

  /**
   * Test ThrowableWithEquals {@link ThrowableWithEquals#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ThrowableWithEquals#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ThrowableWithEquals equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ThrowableWithEquals.equals(Object)",
    "int ThrowableWithEquals.hashCode()"
  })
  void testThrowableWithEqualsEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ThrowableWithEquals throwableWithEquals = new ThrowableWithEquals(new StackTraceElement[] {});
    StackTraceElement stackTraceElement = new StackTraceElement("foo", "foo", "foo", 1);
    StackTraceElement[] stacktrace = new StackTraceElement[] {stackTraceElement};
    ThrowableWithEquals throwableWithEquals2 = new ThrowableWithEquals(stacktrace);

    // Act and Assert
    assertNotEquals(throwableWithEquals, throwableWithEquals2);
  }

  /**
   * Test ThrowableWithEquals {@link ThrowableWithEquals#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ThrowableWithEquals#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ThrowableWithEquals equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ThrowableWithEquals.equals(Object)",
    "int ThrowableWithEquals.hashCode()"
  })
  void testThrowableWithEqualsEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StackTraceElement stackTraceElement = new StackTraceElement("42", "foo", "foo", 1);
    StackTraceElement[] stacktrace = new StackTraceElement[] {stackTraceElement};
    ThrowableWithEquals throwableWithEquals = new ThrowableWithEquals(stacktrace);
    StackTraceElement stackTraceElement2 = new StackTraceElement("foo", "foo", "foo", 1);
    StackTraceElement[] stacktrace2 = new StackTraceElement[] {stackTraceElement2};
    ThrowableWithEquals throwableWithEquals2 = new ThrowableWithEquals(stacktrace2);

    // Act and Assert
    assertNotEquals(throwableWithEquals, throwableWithEquals2);
  }

  /**
   * Test ThrowableWithEquals {@link ThrowableWithEquals#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ThrowableWithEquals#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ThrowableWithEquals equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ThrowableWithEquals.equals(Object)",
    "int ThrowableWithEquals.hashCode()"
  })
  void testThrowableWithEqualsEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StackTraceElement stackTraceElement = new StackTraceElement("foo", "foo", "foo", 1);
    StackTraceElement[] stacktrace = new StackTraceElement[] {stackTraceElement};
    ThrowableWithEquals throwableWithEquals = new ThrowableWithEquals(stacktrace);

    // Act and Assert
    assertNotEquals(throwableWithEquals, null);
  }

  /**
   * Test ThrowableWithEquals {@link ThrowableWithEquals#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ThrowableWithEquals#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test ThrowableWithEquals equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ThrowableWithEquals.equals(Object)",
    "int ThrowableWithEquals.hashCode()"
  })
  void testThrowableWithEqualsEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StackTraceElement stackTraceElement = new StackTraceElement("foo", "foo", "foo", 1);
    StackTraceElement[] stacktrace = new StackTraceElement[] {stackTraceElement};
    ThrowableWithEquals throwableWithEquals = new ThrowableWithEquals(stacktrace);

    // Act and Assert
    assertNotEquals(throwableWithEquals, "Different type to ThrowableWithEquals");
  }

  /**
   * Test ThrowableWithEquals {@link ThrowableWithEquals#hash(StackTraceElement[])}.
   *
   * <ul>
   *   <li>Then return {@code 517991227}.
   * </ul>
   *
   * <p>Method under test: {@link ThrowableWithEquals#hash(StackTraceElement[])}
   */
  @Test
  @DisplayName("Test ThrowableWithEquals hash(StackTraceElement[]); then return '517991227'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ThrowableWithEquals.hash(StackTraceElement[])"})
  void testThrowableWithEqualsHash_thenReturn517991227() {
    // Arrange
    StackTraceElement stackTraceElement = new StackTraceElement("foo", "foo", "foo", 1);

    // Act and Assert
    assertEquals(517991227, ThrowableWithEquals.hash(new StackTraceElement[] {stackTraceElement}));
  }
}

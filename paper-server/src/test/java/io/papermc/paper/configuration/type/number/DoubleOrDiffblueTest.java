package io.papermc.paper.configuration.type.number;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.leangen.geantyref.TypeToken;
import io.papermc.paper.configuration.type.number.DoubleOr.Default;
import io.papermc.paper.configuration.type.number.DoubleOr.Disabled;
import io.papermc.paper.configuration.type.number.DoubleOr.Serializer;
import java.lang.reflect.AnnotatedType;
import java.util.OptionalDouble;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DoubleOrDiffblueTest {
  /**
   * Test Disabled {@link Disabled#enabled()}.
   *
   * <ul>
   *   <li>Given {@link Disabled#Disabled(OptionalDouble)} with value is empty.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Disabled#enabled()}
   */
  @Test
  @DisplayName(
      "Test Disabled enabled(); given Disabled(OptionalDouble) with value is empty; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Disabled.enabled()"})
  void testDisabledEnabled_givenDisabledWithValueIsEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Disabled(OptionalDouble.empty()).enabled());
  }

  /**
   * Test Disabled {@link Disabled#enabled()}.
   *
   * <ul>
   *   <li>Given {@link OptionalDouble} with ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Disabled#enabled()}
   */
  @Test
  @DisplayName("Test Disabled enabled(); given OptionalDouble with ten; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Disabled.enabled()"})
  void testDisabledEnabled_givenOptionalDoubleWithTen_thenReturnTrue() {
    // Arrange
    OptionalDouble value = OptionalDouble.of(10.0d);

    // Act and Assert
    assertTrue(new Disabled(value).enabled());
  }

  /**
   * Test Disabled {@link Disabled#test(DoublePredicate)}.
   *
   * <ul>
   *   <li>Given {@link Disabled#Disabled(OptionalDouble)} with value is empty.
   *   <li>When {@link DoublePredicate}.
   * </ul>
   *
   * <p>Method under test: {@link Disabled#test(DoublePredicate)}
   */
  @Test
  @DisplayName(
      "Test Disabled test(DoublePredicate); given Disabled(OptionalDouble) with value is empty; when DoublePredicate")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Disabled.test(DoublePredicate)"})
  void testDisabledTest_givenDisabledWithValueIsEmpty_whenDoublePredicate() {
    // Arrange, Act and Assert
    assertFalse(new Disabled(OptionalDouble.empty()).test(mock(DoublePredicate.class)));
  }

  /**
   * Test Disabled {@link Disabled#test(DoublePredicate)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link DoublePredicate} {@link DoublePredicate#test(double)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Disabled#test(DoublePredicate)}
   */
  @Test
  @DisplayName(
      "Test Disabled test(DoublePredicate); given 'false'; when DoublePredicate test(double) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Disabled.test(DoublePredicate)"})
  void testDisabledTest_givenFalse_whenDoublePredicateTestReturnFalse_thenReturnFalse() {
    // Arrange
    OptionalDouble value = OptionalDouble.of(10.0d);
    Disabled disabled = new Disabled(value);

    DoublePredicate predicate = mock(DoublePredicate.class);
    when(predicate.test(anyDouble())).thenReturn(false);

    // Act
    boolean actualTestResult = disabled.test(predicate);

    // Assert
    verify(predicate).test(10.0d);
    assertFalse(actualTestResult);
  }

  /**
   * Test Disabled {@link Disabled#test(DoublePredicate)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link DoublePredicate} {@link DoublePredicate#test(double)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Disabled#test(DoublePredicate)}
   */
  @Test
  @DisplayName(
      "Test Disabled test(DoublePredicate); given 'true'; when DoublePredicate test(double) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Disabled.test(DoublePredicate)"})
  void testDisabledTest_givenTrue_whenDoublePredicateTestReturnTrue_thenReturnTrue() {
    // Arrange
    OptionalDouble value = OptionalDouble.of(10.0d);
    Disabled disabled = new Disabled(value);

    DoublePredicate predicate = mock(DoublePredicate.class);
    when(predicate.test(anyDouble())).thenReturn(true);

    // Act
    boolean actualTestResult = disabled.test(predicate);

    // Assert
    verify(predicate).test(10.0d);
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link DoubleOr#or(double)}.
   *
   * <ul>
   *   <li>Given {@link Default#Default(OptionalDouble)} with value is empty.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link DoubleOr#or(double)}
   */
  @Test
  @DisplayName(
      "Test or(double); given Default(OptionalDouble) with value is empty; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DoubleOr.or(double)"})
  void testOr_givenDefaultWithValueIsEmpty_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0d, new Default(OptionalDouble.empty()).or(10.0d));
  }

  /**
   * Test {@link DoubleOr#doubleValue()}.
   *
   * <ul>
   *   <li>Given {@link OptionalDouble} with ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link DoubleOr#doubleValue()}
   */
  @Test
  @DisplayName("Test doubleValue(); given OptionalDouble with ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DoubleOr.doubleValue()"})
  void testDoubleValue_givenOptionalDoubleWithTen_thenReturnTen() {
    // Arrange
    OptionalDouble value = OptionalDouble.of(10.0d);

    // Act and Assert
    assertEquals(10.0d, new Default(value).doubleValue());
  }

  /**
   * Test Serializer {@link Serializer#belowZero(OptionalDouble)} with {@code value}.
   *
   * <ul>
   *   <li>When {@link OptionalDouble} with {@code -0.5}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Serializer#belowZero(OptionalDouble)}
   */
  @Test
  @DisplayName(
      "Test Serializer belowZero(OptionalDouble) with 'value'; when OptionalDouble with '-0.5'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Serializer.belowZero(OptionalDouble)"})
  void testSerializerBelowZeroWithValue_whenOptionalDoubleWith05_thenReturnTrue() {
    // Arrange
    Class<DoubleOr> classOfT = DoubleOr.class;
    Serializer<DoubleOr> serializer =
        new Serializer<>(classOfT, mock(Function.class), "42", mock(DoubleOr.class));

    // Act and Assert
    assertTrue(serializer.belowZero(OptionalDouble.of(-0.5d)));
  }

  /**
   * Test Serializer {@link Serializer#belowZero(OptionalDouble)} with {@code value}.
   *
   * <ul>
   *   <li>When {@link OptionalDouble} with ten.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Serializer#belowZero(OptionalDouble)}
   */
  @Test
  @DisplayName(
      "Test Serializer belowZero(OptionalDouble) with 'value'; when OptionalDouble with ten; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Serializer.belowZero(OptionalDouble)"})
  void testSerializerBelowZeroWithValue_whenOptionalDoubleWithTen_thenReturnFalse() {
    // Arrange
    Class<DoubleOr> classOfT = DoubleOr.class;
    Serializer<DoubleOr> serializer =
        new Serializer<>(classOfT, mock(Function.class), "42", mock(DoubleOr.class));

    // Act and Assert
    assertFalse(serializer.belowZero(OptionalDouble.of(10.0d)));
  }

  /**
   * Test Serializer {@link Serializer#full(Number)} with {@code num}.
   *
   * <ul>
   *   <li>When {@link Bootstrap#bootstrapDuration}.
   *   <li>Then return AsDouble is minus one.
   * </ul>
   *
   * <p>Method under test: {@link Serializer#full(Number)}
   */
  @Test
  @DisplayName(
      "Test Serializer full(Number) with 'num'; when bootstrapDuration; then return AsDouble is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalDouble Serializer.full(Number)"})
  void testSerializerFullWithNum_whenBootstrapDuration_thenReturnAsDoubleIsMinusOne() {
    // Arrange
    Class<DoubleOr> classOfT = DoubleOr.class;
    Serializer<DoubleOr> serializer =
        new Serializer<>(classOfT, mock(Function.class), "42", mock(DoubleOr.class));

    // Act
    OptionalDouble actualFullResult = serializer.full(Bootstrap.bootstrapDuration);

    // Assert
    assertEquals(-1.0d, actualFullResult.getAsDouble());
    assertFalse(actualFullResult.isEmpty());
    assertTrue(actualFullResult.isPresent());
  }

  /**
   * Test Serializer {@link Serializer#full(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return AsDouble is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Serializer#full(String)}
   */
  @Test
  @DisplayName(
      "Test Serializer full(String) with 'value'; when '42'; then return AsDouble is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalDouble Serializer.full(String)"})
  void testSerializerFullWithValue_when42_thenReturnAsDoubleIsFortyTwo() {
    // Arrange
    Class<DoubleOr> classOfT = DoubleOr.class;
    Serializer<DoubleOr> serializer =
        new Serializer<>(classOfT, mock(Function.class), "42", mock(DoubleOr.class));

    // Act
    OptionalDouble actualFullResult = serializer.full("42");

    // Assert
    assertEquals(42.0d, actualFullResult.getAsDouble());
    assertFalse(actualFullResult.isEmpty());
    assertTrue(actualFullResult.isPresent());
  }

  /**
   * Test Serializer {@link Serializer#Serializer(Class, Function, String, DoubleOr)}.
   *
   * <p>Method under test: {@link Serializer#Serializer(Class, Function, String, DoubleOr)}
   */
  @Test
  @DisplayName("Test Serializer new Serializer(Class, Function, String, DoubleOr)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Serializer.<init>(Class, Function, String, DoubleOr)"})
  void testSerializerNewSerializer() {
    // Arrange
    Class<DoubleOr> classOfT = DoubleOr.class;

    // Act
    Serializer<DoubleOr> actualSerializer =
        new Serializer<>(classOfT, mock(Function.class), "42", mock(DoubleOr.class));

    // Assert
    assertEquals("42", actualSerializer.emptySerializedValue);
    TypeToken<DoubleOr> typeResult = actualSerializer.type();
    AnnotatedType annotatedType = typeResult.getAnnotatedType();
    assertNull(annotatedType.getAnnotatedOwnerType());
    assertEquals(annotatedType, typeResult.getCanonicalType());
  }

  /**
   * Test Serializer {@link Serializer#serialize(AnnotatedType, DoubleOr, Predicate)} with {@code
   * AnnotatedType}, {@code DoubleOr}, {@code Predicate}.
   *
   * <p>Method under test: {@link Serializer#serialize(AnnotatedType, DoubleOr, Predicate)}
   */
  @Test
  @DisplayName(
      "Test Serializer serialize(AnnotatedType, DoubleOr, Predicate) with 'AnnotatedType', 'DoubleOr', 'Predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Serializer.serialize(AnnotatedType, DoubleOr, Predicate)"})
  void testSerializerSerializeWithAnnotatedTypeDoubleOrPredicate() {
    // Arrange
    Class<DoubleOr> classOfT = DoubleOr.class;
    Serializer<DoubleOr> serializer =
        new Serializer<>(classOfT, mock(Function.class), "42", mock(DoubleOr.class));

    DoubleOr doubleOr = mock(DoubleOr.class);
    when(doubleOr.value()).thenReturn(OptionalDouble.of(10.0d));

    // Act
    Object actualSerializeResult = serializer.serialize(null, doubleOr, mock(Predicate.class));

    // Assert
    verify(doubleOr).value();
    assertEquals(10.0d, ((Double) actualSerializeResult).doubleValue());
  }

  /**
   * Test Serializer {@link Serializer#serialize(AnnotatedType, DoubleOr, Predicate)} with {@code
   * AnnotatedType}, {@code DoubleOr}, {@code Predicate}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Serializer#serialize(AnnotatedType, DoubleOr, Predicate)}
   */
  @Test
  @DisplayName(
      "Test Serializer serialize(AnnotatedType, DoubleOr, Predicate) with 'AnnotatedType', 'DoubleOr', 'Predicate'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Serializer.serialize(AnnotatedType, DoubleOr, Predicate)"})
  void testSerializerSerializeWithAnnotatedTypeDoubleOrPredicate_thenReturn42() {
    // Arrange
    Class<DoubleOr> classOfT = DoubleOr.class;
    Serializer<DoubleOr> serializer =
        new Serializer<>(classOfT, mock(Function.class), "42", mock(DoubleOr.class));

    DoubleOr doubleOr = mock(DoubleOr.class);
    when(doubleOr.value()).thenReturn(OptionalDouble.empty());

    // Act
    Object actualSerializeResult = serializer.serialize(null, doubleOr, mock(Predicate.class));

    // Assert
    verify(doubleOr).value();
    assertEquals("42", actualSerializeResult);
  }
}

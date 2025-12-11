package io.papermc.paper.configuration.constraint;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.SimpleType;
import io.papermc.paper.configuration.constraint.Constraints.Max;
import io.papermc.paper.configuration.constraint.Constraints.Max.Factory;
import io.papermc.paper.configuration.constraint.Constraints.Min;
import io.papermc.paper.configuration.constraint.Constraints.Positive;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.serialize.SerializationException;

class ConstraintsDiffblueTest {
  /**
   * Test Max_Factory {@link Max.Factory#make(Max, Type)} with {@code data}, {@code type}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>Then {@link Bootstrap#bootstrapDuration} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link Max.Factory#make(Max, Type)}
   */
  @Test
  @DisplayName(
      "Test Max_Factory make(Max, Type) with 'data', 'type'; given forty-two; then bootstrapDuration is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.spongepowered.configurate.objectmapping.meta.Constraint Max.Factory.make(Max, Type)"
  })
  void testMax_FactoryMakeWithDataType_givenFortyTwo_thenBootstrapDurationIsMinusOne()
      throws SerializationException {
    // Arrange
    Factory factory = new Factory();

    Max data = mock(Max.class);
    when(data.value()).thenReturn(42);
    PlaceholderForType type = new PlaceholderForType(1);
    AtomicLong atomicLong = Bootstrap.bootstrapDuration;

    // Act
    factory.make(data, type).validate(atomicLong);

    // Assert that nothing has changed
    verify(data).value();
    assertTrue(type.getSuperClass() instanceof SimpleType);
    assertEquals("$2", type.getErasedSignature());
    assertEquals("$2", type.getGenericSignature());
    assertEquals("$2", type.getTypeName());
    assertEquals(-1L, atomicLong.get());
    assertEquals(-1L, atomicLong.getAcquire());
    assertEquals(-1L, atomicLong.getOpaque());
    assertEquals(-1L, atomicLong.getPlain());
    assertFalse(type.isReferenceType());
    assertFalse(type.hasHandlers());
    assertFalse(type.hasValueHandler());
    assertFalse(type.isAbstract());
    assertFalse(type.isArrayType());
    assertFalse(type.isCollectionLikeType());
    assertFalse(type.isEnumImplType());
    assertFalse(type.isEnumType());
    assertFalse(type.isFinal());
    assertFalse(type.isInterface());
    assertFalse(type.isMapLikeType());
    assertFalse(type.isPrimitive());
    assertFalse(type.isRecordType());
    assertFalse(type.isThrowable());
    assertFalse(type.isContainerType());
    assertTrue(type.hasContentType());
    assertTrue(type.isConcrete());
    assertTrue(type.isJavaLangObject());
    assertTrue(type.getInterfaces().isEmpty());
    Class<Object> expectedRawClass = Object.class;
    assertEquals(expectedRawClass, type.getRawClass());
  }

  /**
   * Test Max_Factory {@link Max.Factory#make(Max, Type)} with {@code data}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link Integer#MIN_VALUE}.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link Max.Factory#make(Max, Type)}
   */
  @Test
  @DisplayName(
      "Test Max_Factory make(Max, Type) with 'data', 'type'; given MIN_VALUE; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.spongepowered.configurate.objectmapping.meta.Constraint Max.Factory.make(Max, Type)"
  })
  void testMax_FactoryMakeWithDataType_givenMin_value_thenThrowSerializationException()
      throws SerializationException {
    // Arrange
    Factory factory = new Factory();

    Max data = mock(Max.class);
    when(data.value()).thenReturn(Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () -> factory.make(data, new PlaceholderForType(1)).validate(Bootstrap.bootstrapDuration));
    verify(data, atLeast(1)).value();
  }

  /**
   * Test Max_Factory {@link Max.Factory#make(Max, Type)} with {@code data}, {@code type}.
   *
   * <ul>
   *   <li>When {@link Max}.
   * </ul>
   *
   * <p>Method under test: {@link Max.Factory#make(Max, Type)}
   */
  @Test
  @DisplayName("Test Max_Factory make(Max, Type) with 'data', 'type'; when Max")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.spongepowered.configurate.objectmapping.meta.Constraint Max.Factory.make(Max, Type)"
  })
  void testMax_FactoryMakeWithDataType_whenMax() {
    // Arrange
    Factory factory = new Factory();
    Max data = mock(Max.class);
    PlaceholderForType type = new PlaceholderForType(1);

    // Act
    factory.make(data, type);

    // Assert that nothing has changed
    assertTrue(type.getSuperClass() instanceof SimpleType);
    assertEquals("$2", type.getErasedSignature());
    assertEquals("$2", type.getGenericSignature());
    assertEquals("$2", type.getTypeName());
    assertFalse(type.isReferenceType());
    assertFalse(type.hasHandlers());
    assertFalse(type.hasValueHandler());
    assertFalse(type.isAbstract());
    assertFalse(type.isArrayType());
    assertFalse(type.isCollectionLikeType());
    assertFalse(type.isEnumImplType());
    assertFalse(type.isEnumType());
    assertFalse(type.isFinal());
    assertFalse(type.isInterface());
    assertFalse(type.isMapLikeType());
    assertFalse(type.isPrimitive());
    assertFalse(type.isRecordType());
    assertFalse(type.isThrowable());
    assertFalse(type.isContainerType());
    assertTrue(type.hasContentType());
    assertTrue(type.isConcrete());
    assertTrue(type.isJavaLangObject());
    assertTrue(type.getInterfaces().isEmpty());
    Class<Object> expectedRawClass = Object.class;
    assertEquals(expectedRawClass, type.getRawClass());
  }

  /**
   * Test Max_Factory {@link Max.Factory#make(Max, Type)} with {@code data}, {@code type}.
   *
   * <ul>
   *   <li>When {@link Max}.
   * </ul>
   *
   * <p>Method under test: {@link Max.Factory#make(Max, Type)}
   */
  @Test
  @DisplayName("Test Max_Factory make(Max, Type) with 'data', 'type'; when Max")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.spongepowered.configurate.objectmapping.meta.Constraint Max.Factory.make(Max, Type)"
  })
  void testMax_FactoryMakeWithDataType_whenMax2() throws SerializationException {
    // Arrange
    Factory factory = new Factory();
    Max data = mock(Max.class);
    PlaceholderForType type = new PlaceholderForType(1);

    // Act
    factory.make(data, type).validate(null);

    // Assert that nothing has changed
    assertTrue(type.getSuperClass() instanceof SimpleType);
    assertEquals("$2", type.getErasedSignature());
    assertEquals("$2", type.getGenericSignature());
    assertEquals("$2", type.getTypeName());
    assertFalse(type.isReferenceType());
    assertFalse(type.hasHandlers());
    assertFalse(type.hasValueHandler());
    assertFalse(type.isAbstract());
    assertFalse(type.isArrayType());
    assertFalse(type.isCollectionLikeType());
    assertFalse(type.isEnumImplType());
    assertFalse(type.isEnumType());
    assertFalse(type.isFinal());
    assertFalse(type.isInterface());
    assertFalse(type.isMapLikeType());
    assertFalse(type.isPrimitive());
    assertFalse(type.isRecordType());
    assertFalse(type.isThrowable());
    assertFalse(type.isContainerType());
    assertTrue(type.hasContentType());
    assertTrue(type.isConcrete());
    assertTrue(type.isJavaLangObject());
    assertTrue(type.getInterfaces().isEmpty());
    Class<Object> expectedRawClass = Object.class;
    assertEquals(expectedRawClass, type.getRawClass());
  }

  /**
   * Test Min_Factory {@link Min.Factory#make(Min, Type)} with {@code data}, {@code type}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link Min.Factory#make(Min, Type)}
   */
  @Test
  @DisplayName(
      "Test Min_Factory make(Min, Type) with 'data', 'type'; given forty-two; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.spongepowered.configurate.objectmapping.meta.Constraint Min.Factory.make(Min, Type)"
  })
  void testMin_FactoryMakeWithDataType_givenFortyTwo_thenThrowSerializationException()
      throws SerializationException {
    // Arrange
    Min.Factory factory = new Min.Factory();

    Min data = mock(Min.class);
    when(data.value()).thenReturn(42);

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () -> factory.make(data, new PlaceholderForType(1)).validate(Bootstrap.bootstrapDuration));
    verify(data, atLeast(1)).value();
  }

  /**
   * Test Min_Factory {@link Min.Factory#make(Min, Type)} with {@code data}, {@code type}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>Then {@link Bootstrap#bootstrapDuration} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link Min.Factory#make(Min, Type)}
   */
  @Test
  @DisplayName(
      "Test Min_Factory make(Min, Type) with 'data', 'type'; given minus one; then bootstrapDuration is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.spongepowered.configurate.objectmapping.meta.Constraint Min.Factory.make(Min, Type)"
  })
  void testMin_FactoryMakeWithDataType_givenMinusOne_thenBootstrapDurationIsMinusOne()
      throws SerializationException {
    // Arrange
    Min.Factory factory = new Min.Factory();

    Min data = mock(Min.class);
    when(data.value()).thenReturn(-1);
    PlaceholderForType type = new PlaceholderForType(1);
    AtomicLong atomicLong = Bootstrap.bootstrapDuration;

    // Act
    factory.make(data, type).validate(atomicLong);

    // Assert that nothing has changed
    verify(data).value();
    assertTrue(type.getSuperClass() instanceof SimpleType);
    assertEquals("$2", type.getErasedSignature());
    assertEquals("$2", type.getGenericSignature());
    assertEquals("$2", type.getTypeName());
    assertEquals(-1L, atomicLong.get());
    assertEquals(-1L, atomicLong.getAcquire());
    assertEquals(-1L, atomicLong.getOpaque());
    assertEquals(-1L, atomicLong.getPlain());
    assertFalse(type.isReferenceType());
    assertFalse(type.hasHandlers());
    assertFalse(type.hasValueHandler());
    assertFalse(type.isAbstract());
    assertFalse(type.isArrayType());
    assertFalse(type.isCollectionLikeType());
    assertFalse(type.isEnumImplType());
    assertFalse(type.isEnumType());
    assertFalse(type.isFinal());
    assertFalse(type.isInterface());
    assertFalse(type.isMapLikeType());
    assertFalse(type.isPrimitive());
    assertFalse(type.isRecordType());
    assertFalse(type.isThrowable());
    assertFalse(type.isContainerType());
    assertTrue(type.hasContentType());
    assertTrue(type.isConcrete());
    assertTrue(type.isJavaLangObject());
    assertTrue(type.getInterfaces().isEmpty());
    Class<Object> expectedRawClass = Object.class;
    assertEquals(expectedRawClass, type.getRawClass());
  }

  /**
   * Test Min_Factory {@link Min.Factory#make(Min, Type)} with {@code data}, {@code type}.
   *
   * <ul>
   *   <li>When {@link Min}.
   * </ul>
   *
   * <p>Method under test: {@link Min.Factory#make(Min, Type)}
   */
  @Test
  @DisplayName("Test Min_Factory make(Min, Type) with 'data', 'type'; when Min")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.spongepowered.configurate.objectmapping.meta.Constraint Min.Factory.make(Min, Type)"
  })
  void testMin_FactoryMakeWithDataType_whenMin() {
    // Arrange
    Min.Factory factory = new Min.Factory();
    Min data = mock(Min.class);
    PlaceholderForType type = new PlaceholderForType(1);

    // Act
    factory.make(data, type);

    // Assert that nothing has changed
    assertTrue(type.getSuperClass() instanceof SimpleType);
    assertEquals("$2", type.getErasedSignature());
    assertEquals("$2", type.getGenericSignature());
    assertEquals("$2", type.getTypeName());
    assertFalse(type.isReferenceType());
    assertFalse(type.hasHandlers());
    assertFalse(type.hasValueHandler());
    assertFalse(type.isAbstract());
    assertFalse(type.isArrayType());
    assertFalse(type.isCollectionLikeType());
    assertFalse(type.isEnumImplType());
    assertFalse(type.isEnumType());
    assertFalse(type.isFinal());
    assertFalse(type.isInterface());
    assertFalse(type.isMapLikeType());
    assertFalse(type.isPrimitive());
    assertFalse(type.isRecordType());
    assertFalse(type.isThrowable());
    assertFalse(type.isContainerType());
    assertTrue(type.hasContentType());
    assertTrue(type.isConcrete());
    assertTrue(type.isJavaLangObject());
    assertTrue(type.getInterfaces().isEmpty());
    Class<Object> expectedRawClass = Object.class;
    assertEquals(expectedRawClass, type.getRawClass());
  }

  /**
   * Test Min_Factory {@link Min.Factory#make(Min, Type)} with {@code data}, {@code type}.
   *
   * <ul>
   *   <li>When {@link Min}.
   * </ul>
   *
   * <p>Method under test: {@link Min.Factory#make(Min, Type)}
   */
  @Test
  @DisplayName("Test Min_Factory make(Min, Type) with 'data', 'type'; when Min")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.spongepowered.configurate.objectmapping.meta.Constraint Min.Factory.make(Min, Type)"
  })
  void testMin_FactoryMakeWithDataType_whenMin2() throws SerializationException {
    // Arrange
    Min.Factory factory = new Min.Factory();
    Min data = mock(Min.class);
    PlaceholderForType type = new PlaceholderForType(1);

    // Act
    factory.make(data, type).validate(null);

    // Assert that nothing has changed
    assertTrue(type.getSuperClass() instanceof SimpleType);
    assertEquals("$2", type.getErasedSignature());
    assertEquals("$2", type.getGenericSignature());
    assertEquals("$2", type.getTypeName());
    assertFalse(type.isReferenceType());
    assertFalse(type.hasHandlers());
    assertFalse(type.hasValueHandler());
    assertFalse(type.isAbstract());
    assertFalse(type.isArrayType());
    assertFalse(type.isCollectionLikeType());
    assertFalse(type.isEnumImplType());
    assertFalse(type.isEnumType());
    assertFalse(type.isFinal());
    assertFalse(type.isInterface());
    assertFalse(type.isMapLikeType());
    assertFalse(type.isPrimitive());
    assertFalse(type.isRecordType());
    assertFalse(type.isThrowable());
    assertFalse(type.isContainerType());
    assertTrue(type.hasContentType());
    assertTrue(type.isConcrete());
    assertTrue(type.isJavaLangObject());
    assertTrue(type.getInterfaces().isEmpty());
    Class<Object> expectedRawClass = Object.class;
    assertEquals(expectedRawClass, type.getRawClass());
  }

  /**
   * Test Positive {@link Positive#validate(Number)} with {@code value}.
   *
   * <ul>
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link Positive#validate(Number)}
   */
  @Test
  @DisplayName("Test Positive validate(Number) with 'value'; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Positive.validate(Number)"})
  void testPositiveValidateWithValue_thenThrowSerializationException()
      throws SerializationException {
    // Arrange, Act and Assert
    assertThrows(
        SerializationException.class, () -> new Positive().validate(Bootstrap.bootstrapDuration));
  }

  /**
   * Test Positive {@link Positive#validate(Number)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 1.0E-10}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Positive#validate(Number)}
   */
  @Test
  @DisplayName("Test Positive validate(Number) with 'value'; when '1.0E-10'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Positive.validate(Number)"})
  void testPositiveValidateWithValue_when10e10_thenDoesNotThrow() throws SerializationException {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new Positive().validate(1.0E-10d));
  }

  /**
   * Test Positive {@link Positive#validate(Number)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Positive#validate(Number)}
   */
  @Test
  @DisplayName("Test Positive validate(Number) with 'value'; when 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Positive.validate(Number)"})
  void testPositiveValidateWithValue_whenNull_thenDoesNotThrow() throws SerializationException {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new Positive().validate(null));
  }
}

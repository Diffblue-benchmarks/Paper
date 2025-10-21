package org.bukkit.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.persistence.PersistentDataType.BooleanPersistentDataType;
import org.bukkit.persistence.PersistentDataType.PrimitivePersistentDataType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PersistentDataTypeDiffblueTest {
  /**
   * Test BooleanPersistentDataType {@link BooleanPersistentDataType#fromPrimitive(Byte,
   * PersistentDataAdapterContext)} with {@code primitive}, {@code context}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanPersistentDataType#fromPrimitive(Byte,
   * PersistentDataAdapterContext)}
   */
  @Test
  @DisplayName(
      "Test BooleanPersistentDataType fromPrimitive(Byte, PersistentDataAdapterContext) with 'primitive', 'context'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean BooleanPersistentDataType.fromPrimitive(Byte, PersistentDataAdapterContext)"
  })
  void testBooleanPersistentDataTypeFromPrimitiveWithPrimitiveContext_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new BooleanPersistentDataType()
            .fromPrimitive((byte) 0, mock(PersistentDataAdapterContext.class)));
  }

  /**
   * Test BooleanPersistentDataType {@link BooleanPersistentDataType#fromPrimitive(Byte,
   * PersistentDataAdapterContext)} with {@code primitive}, {@code context}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanPersistentDataType#fromPrimitive(Byte,
   * PersistentDataAdapterContext)}
   */
  @Test
  @DisplayName(
      "Test BooleanPersistentDataType fromPrimitive(Byte, PersistentDataAdapterContext) with 'primitive', 'context'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean BooleanPersistentDataType.fromPrimitive(Byte, PersistentDataAdapterContext)"
  })
  void testBooleanPersistentDataTypeFromPrimitiveWithPrimitiveContext_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new BooleanPersistentDataType()
            .fromPrimitive((byte) 'A', mock(PersistentDataAdapterContext.class)));
  }

  /**
   * Test BooleanPersistentDataType getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BooleanPersistentDataType}
   *   <li>{@link BooleanPersistentDataType#getComplexType()}
   *   <li>{@link BooleanPersistentDataType#getPrimitiveType()}
   * </ul>
   */
  @Test
  @DisplayName("Test BooleanPersistentDataType getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BooleanPersistentDataType.<init>()",
    "Class BooleanPersistentDataType.getComplexType()",
    "Class BooleanPersistentDataType.getPrimitiveType()"
  })
  void testBooleanPersistentDataTypeGettersAndSetters() {
    // Arrange and Act
    BooleanPersistentDataType actualBooleanPersistentDataType = new BooleanPersistentDataType();
    Class<Boolean> actualComplexType = actualBooleanPersistentDataType.getComplexType();
    Class<Byte> actualPrimitiveType = actualBooleanPersistentDataType.getPrimitiveType();

    // Assert
    Class<Boolean> expectedComplexType = Boolean.class;
    assertEquals(expectedComplexType, actualComplexType);
    Class<Byte> expectedPrimitiveType = Byte.class;
    assertEquals(expectedPrimitiveType, actualPrimitiveType);
  }

  /**
   * Test BooleanPersistentDataType {@link BooleanPersistentDataType#toPrimitive(Boolean,
   * PersistentDataAdapterContext)} with {@code complex}, {@code context}.
   *
   * <p>Method under test: {@link BooleanPersistentDataType#toPrimitive(Boolean,
   * PersistentDataAdapterContext)}
   */
  @Test
  @DisplayName(
      "Test BooleanPersistentDataType toPrimitive(Boolean, PersistentDataAdapterContext) with 'complex', 'context'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Byte BooleanPersistentDataType.toPrimitive(Boolean, PersistentDataAdapterContext)"
  })
  void testBooleanPersistentDataTypeToPrimitiveWithComplexContext() {
    // Arrange, Act and Assert
    assertEquals(
        (byte) 1,
        new BooleanPersistentDataType()
            .toPrimitive(true, mock(PersistentDataAdapterContext.class))
            .byteValue());
  }

  /**
   * Test BooleanPersistentDataType {@link BooleanPersistentDataType#toPrimitive(Boolean,
   * PersistentDataAdapterContext)} with {@code complex}, {@code context}.
   *
   * <p>Method under test: {@link BooleanPersistentDataType#toPrimitive(Boolean,
   * PersistentDataAdapterContext)}
   */
  @Test
  @DisplayName(
      "Test BooleanPersistentDataType toPrimitive(Boolean, PersistentDataAdapterContext) with 'complex', 'context'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Byte BooleanPersistentDataType.toPrimitive(Boolean, PersistentDataAdapterContext)"
  })
  void testBooleanPersistentDataTypeToPrimitiveWithComplexContext2() {
    // Arrange, Act and Assert
    assertEquals(
        (byte) 0,
        new BooleanPersistentDataType()
            .toPrimitive(false, mock(PersistentDataAdapterContext.class))
            .byteValue());
  }

  /**
   * Test PrimitivePersistentDataType {@link PrimitivePersistentDataType#fromPrimitive(Object,
   * PersistentDataAdapterContext)}.
   *
   * <p>Method under test: {@link PrimitivePersistentDataType#fromPrimitive(Object,
   * PersistentDataAdapterContext)}
   */
  @Test
  @DisplayName(
      "Test PrimitivePersistentDataType fromPrimitive(Object, PersistentDataAdapterContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object PrimitivePersistentDataType.fromPrimitive(Object, PersistentDataAdapterContext)"
  })
  void testPrimitivePersistentDataTypeFromPrimitive() {
    // Arrange
    Class<Object> primitiveType = Object.class;
    PrimitivePersistentDataType<Object> primitivePersistentDataType =
        new PrimitivePersistentDataType<>(primitiveType);

    // Act and Assert
    assertEquals(
        "Primitive",
        primitivePersistentDataType.fromPrimitive(
            "Primitive", mock(PersistentDataAdapterContext.class)));
  }

  /**
   * Test PrimitivePersistentDataType getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PrimitivePersistentDataType#PrimitivePersistentDataType(Class)}
   *   <li>{@link PrimitivePersistentDataType#getComplexType()}
   *   <li>{@link PrimitivePersistentDataType#getPrimitiveType()}
   * </ul>
   */
  @Test
  @DisplayName("Test PrimitivePersistentDataType getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PrimitivePersistentDataType.<init>(Class)",
    "Class PrimitivePersistentDataType.getComplexType()",
    "Class PrimitivePersistentDataType.getPrimitiveType()"
  })
  void testPrimitivePersistentDataTypeGettersAndSetters() {
    // Arrange
    Class<Object> primitiveType = Object.class;

    // Act
    PrimitivePersistentDataType<Object> actualPrimitivePersistentDataType =
        new PrimitivePersistentDataType<>(primitiveType);
    Class<Object> actualComplexType = actualPrimitivePersistentDataType.getComplexType();
    Class<Object> actualPrimitiveType = actualPrimitivePersistentDataType.getPrimitiveType();

    // Assert
    Class<Object> expectedComplexType = Object.class;
    assertEquals(expectedComplexType, actualComplexType);
    assertSame(primitiveType, actualComplexType);
    assertSame(primitiveType, actualPrimitiveType);
  }

  /**
   * Test PrimitivePersistentDataType {@link PrimitivePersistentDataType#toPrimitive(Object,
   * PersistentDataAdapterContext)}.
   *
   * <p>Method under test: {@link PrimitivePersistentDataType#toPrimitive(Object,
   * PersistentDataAdapterContext)}
   */
  @Test
  @DisplayName("Test PrimitivePersistentDataType toPrimitive(Object, PersistentDataAdapterContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object PrimitivePersistentDataType.toPrimitive(Object, PersistentDataAdapterContext)"
  })
  void testPrimitivePersistentDataTypeToPrimitive() {
    // Arrange
    Class<Object> primitiveType = Object.class;
    PrimitivePersistentDataType<Object> primitivePersistentDataType =
        new PrimitivePersistentDataType<>(primitiveType);

    // Act and Assert
    assertEquals(
        "Complex",
        primitivePersistentDataType.toPrimitive(
            "Complex", mock(PersistentDataAdapterContext.class)));
  }
}

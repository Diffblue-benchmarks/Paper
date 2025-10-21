package org.bukkit.inventory.meta.tags;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.inventory.meta.tags.ItemTagType.PrimitiveTagType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ItemTagTypeDiffblueTest {
  /**
   * Test PrimitiveTagType {@link PrimitiveTagType#fromPrimitive(Object, ItemTagAdapterContext)}.
   *
   * <p>Method under test: {@link PrimitiveTagType#fromPrimitive(Object, ItemTagAdapterContext)}
   */
  @Test
  @DisplayName("Test PrimitiveTagType fromPrimitive(Object, ItemTagAdapterContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PrimitiveTagType.fromPrimitive(Object, ItemTagAdapterContext)"})
  void testPrimitiveTagTypeFromPrimitive() {
    // Arrange
    Class<Object> primitiveType = Object.class;
    PrimitiveTagType<Object> primitiveTagType = new PrimitiveTagType<>(primitiveType);

    // Act and Assert
    assertEquals(
        "Primitive",
        primitiveTagType.fromPrimitive("Primitive", mock(ItemTagAdapterContext.class)));
  }

  /**
   * Test PrimitiveTagType getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PrimitiveTagType#PrimitiveTagType(Class)}
   *   <li>{@link PrimitiveTagType#getComplexType()}
   *   <li>{@link PrimitiveTagType#getPrimitiveType()}
   * </ul>
   */
  @Test
  @DisplayName("Test PrimitiveTagType getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PrimitiveTagType.<init>(Class)",
    "Class PrimitiveTagType.getComplexType()",
    "Class PrimitiveTagType.getPrimitiveType()"
  })
  void testPrimitiveTagTypeGettersAndSetters() {
    // Arrange
    Class<Object> primitiveType = Object.class;

    // Act
    PrimitiveTagType<Object> actualPrimitiveTagType = new PrimitiveTagType<>(primitiveType);
    Class<Object> actualComplexType = actualPrimitiveTagType.getComplexType();
    Class<Object> actualPrimitiveType = actualPrimitiveTagType.getPrimitiveType();

    // Assert
    Class<Object> expectedComplexType = Object.class;
    assertEquals(expectedComplexType, actualComplexType);
    assertSame(primitiveType, actualComplexType);
    assertSame(primitiveType, actualPrimitiveType);
  }

  /**
   * Test PrimitiveTagType {@link PrimitiveTagType#toPrimitive(Object, ItemTagAdapterContext)}.
   *
   * <p>Method under test: {@link PrimitiveTagType#toPrimitive(Object, ItemTagAdapterContext)}
   */
  @Test
  @DisplayName("Test PrimitiveTagType toPrimitive(Object, ItemTagAdapterContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PrimitiveTagType.toPrimitive(Object, ItemTagAdapterContext)"})
  void testPrimitiveTagTypeToPrimitive() {
    // Arrange
    Class<Object> primitiveType = Object.class;
    PrimitiveTagType<Object> primitiveTagType = new PrimitiveTagType<>(primitiveType);

    // Act and Assert
    assertEquals(
        "Complex", primitiveTagType.toPrimitive("Complex", mock(ItemTagAdapterContext.class)));
  }
}

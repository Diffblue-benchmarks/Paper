package io.papermc.paper.configuration.type.number;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.configuration.type.number.DoubleOr.Serializer;
import java.lang.reflect.AnnotatedType;
import java.util.OptionalDouble;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.serialize.SerializationException;

class OptionalNumSerializerDiffblueTest {
  /**
   * Test {@link OptionalNumSerializer#deserialize(AnnotatedType, Object)} with {@code
   * AnnotatedType}, {@code Object}.
   *
   * <ul>
   *   <li>Then return not value Present.
   * </ul>
   *
   * <p>Method under test: {@link OptionalNumSerializer#deserialize(AnnotatedType, Object)}
   */
  @Test
  @DisplayName(
      "Test deserialize(AnnotatedType, Object) with 'AnnotatedType', 'Object'; then return not value Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object OptionalNumSerializer.deserialize(AnnotatedType, Object)"})
  void testDeserializeWithAnnotatedTypeObject_thenReturnNotValuePresent()
      throws SerializationException {
    // Arrange
    DoubleOr doubleOr = mock(DoubleOr.class);
    OptionalDouble emptyResult = OptionalDouble.empty();
    when(doubleOr.value()).thenReturn(emptyResult);
    Class<DoubleOr> classOfT = DoubleOr.class;

    Serializer<DoubleOr> serializer =
        new Serializer<>(classOfT, mock(Function.class), "42", doubleOr);

    // Act
    OptionalDouble actualValueResult = serializer.deserialize((AnnotatedType) null, "42").value();

    // Assert
    verify(doubleOr).value();
    assertFalse(actualValueResult.isPresent());
    assertSame(emptyResult, actualValueResult);
  }
}

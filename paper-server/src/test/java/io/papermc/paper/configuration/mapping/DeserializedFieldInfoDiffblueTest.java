package io.papermc.paper.configuration.mapping;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.AnnotatedType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class DeserializedFieldInfoDiffblueTest {
  /**
   * Test {@link DeserializedFieldInfo#runProcessor(Object, Object)}.
   *
   * <ul>
   *   <li>Then return {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link DeserializedFieldInfo#runProcessor(Object, Object)}
   */
  @Test
  @DisplayName("Test runProcessor(Object, Object); then return WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DeserializedFieldInfo.runProcessor(Object, Object)"})
  void testRunProcessor_thenReturnWildcard_object() throws SerializationException {
    // Arrange
    FieldProcessor<Object> processor = mock(FieldProcessor.class);
    when(processor.process(
            Mockito.<AnnotatedType>any(), Mockito.<Object>any(), Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    DeserializedFieldInfo<Object> deserializedFieldInfo =
        new DeserializedFieldInfo<>(null, ConfigurationTransformation.WILDCARD_OBJECT, processor);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Object actualRunProcessorResult =
        deserializedFieldInfo.runProcessor(ConfigurationTransformation.WILDCARD_OBJECT, object);

    // Assert
    verify(processor).process(isNull(), isA(Object.class), isA(Object.class));
    assertSame(object, actualRunProcessorResult);
  }

  /**
   * Test {@link DeserializedFieldInfo#runProcessor(Object, Object)}.
   *
   * <ul>
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeserializedFieldInfo#runProcessor(Object, Object)}
   */
  @Test
  @DisplayName("Test runProcessor(Object, Object); then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DeserializedFieldInfo.runProcessor(Object, Object)"})
  void testRunProcessor_thenThrowSerializationException() throws SerializationException {
    // Arrange
    FieldProcessor<Object> processor = mock(FieldProcessor.class);
    when(processor.process(
            Mockito.<AnnotatedType>any(), Mockito.<Object>any(), Mockito.<Object>any()))
        .thenThrow(new SerializationException());
    DeserializedFieldInfo<Object> deserializedFieldInfo =
        new DeserializedFieldInfo<>(null, ConfigurationTransformation.WILDCARD_OBJECT, processor);

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () ->
            deserializedFieldInfo.runProcessor(
                ConfigurationTransformation.WILDCARD_OBJECT,
                ConfigurationTransformation.WILDCARD_OBJECT));
    verify(processor).process(isNull(), isA(Object.class), isA(Object.class));
  }
}

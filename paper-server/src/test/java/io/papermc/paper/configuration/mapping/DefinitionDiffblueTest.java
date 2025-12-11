package io.papermc.paper.configuration.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.leangen.geantyref.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class DefinitionDiffblueTest {
  /**
   * Test {@link Definition#Definition(Class, Class, Object)}.
   *
   * <ul>
   *   <li>Then return type AnnotatedType AnnotatedOwnerType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Definition#Definition(Class, Class, Object)}
   */
  @Test
  @DisplayName(
      "Test new Definition(Class, Class, Object); then return type AnnotatedType AnnotatedOwnerType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Definition.<init>(Class, Class, Object)"})
  void testNewDefinition_thenReturnTypeAnnotatedTypeAnnotatedOwnerTypeIsNull() {
    // Arrange
    Class<Annotation> annotation = Annotation.class;
    Class<Object> type = Object.class;
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Definition<Annotation, Object, Object> actualDefinition =
        new Definition<>(annotation, type, object);

    // Assert
    TypeToken<Object> typeResult = actualDefinition.type();
    AnnotatedType annotatedType = typeResult.getAnnotatedType();
    assertNull(annotatedType.getAnnotatedOwnerType());
    assertEquals(annotatedType, typeResult.getCanonicalType());
    Class<Annotation> expectedAnnotationResult = Annotation.class;
    assertEquals(expectedAnnotationResult, actualDefinition.annotation());
    assertSame(object, actualDefinition.factory());
  }
}

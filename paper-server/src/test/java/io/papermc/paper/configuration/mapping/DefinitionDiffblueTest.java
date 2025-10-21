package io.papermc.paper.configuration.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.annotation.Annotation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class DefinitionDiffblueTest {
  /**
   * Test {@link Definition#Definition(Class, Class, Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@link Annotation}.
   * </ul>
   *
   * <p>Method under test: {@link Definition#Definition(Class, Class, Object)}
   */
  @Test
  @DisplayName(
      "Test new Definition(Class, Class, Object); when 'java.lang.Object'; then return Annotation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Definition.<init>(Class, Class, Object)"})
  void testNewDefinition_whenJavaLangObject_thenReturnAnnotation() {
    // Arrange
    Class<Annotation> annotation = Annotation.class;
    Class<Object> type = Object.class;
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Definition<Annotation, Object, Object> actualDefinition =
        new Definition<>(annotation, type, object);

    // Assert
    Class<Annotation> expectedAnnotationResult = Annotation.class;
    assertEquals(expectedAnnotationResult, actualDefinition.annotation());
    assertSame(type, actualDefinition.type().getType());
    assertSame(object, actualDefinition.factory());
  }
}

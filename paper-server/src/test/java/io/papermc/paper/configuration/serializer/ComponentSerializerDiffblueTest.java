package io.papermc.paper.configuration.serializer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.AnnotatedType;
import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class ComponentSerializerDiffblueTest {
  /**
   * Test {@link ComponentSerializer#deserialize(AnnotatedType, Object)} with {@code AnnotatedType},
   * {@code Object}.
   *
   * <ul>
   *   <li>When {@code l}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentSerializer#deserialize(AnnotatedType, Object)}
   */
  @Test
  @DisplayName("Test deserialize(AnnotatedType, Object) with 'AnnotatedType', 'Object'; when 'l'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component ComponentSerializer.deserialize(AnnotatedType, Object)"})
  void testDeserializeWithAnnotatedTypeObject_whenL() throws SerializationException {
    // Arrange and Act
    Component actualDeserializeResult =
        new ComponentSerializer().deserialize((AnnotatedType) null, "l");

    // Assert
    Component actualCompactResult = actualDeserializeResult.compact();
    assertEquals(actualDeserializeResult, actualCompactResult);
  }

  /**
   * Test {@link ComponentSerializer#deserialize(AnnotatedType, Object)} with {@code AnnotatedType},
   * {@code Object}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentSerializer#deserialize(AnnotatedType, Object)}
   */
  @Test
  @DisplayName(
      "Test deserialize(AnnotatedType, Object) with 'AnnotatedType', 'Object'; when WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component ComponentSerializer.deserialize(AnnotatedType, Object)"})
  void testDeserializeWithAnnotatedTypeObject_whenWildcard_object() throws SerializationException {
    // Arrange and Act
    Component actualDeserializeResult =
        new ComponentSerializer()
            .deserialize((AnnotatedType) null, ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    Component actualCompactResult = actualDeserializeResult.compact();
    assertEquals(actualDeserializeResult, actualCompactResult);
  }
}

package io.papermc.paper.configuration.serializer.collection.map;

import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.configuration.serializer.collection.map.FastutilMapSerializer.SomethingToSomething;
import java.lang.reflect.AnnotatedType;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;

class FastutilMapSerializerDiffblueTest {
  /**
   * Test {@link FastutilMapSerializer#serialize(AnnotatedType, Map, ConfigurationNode)} with {@code
   * annotatedType}, {@code obj}, {@code node}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then calls {@link ConfigurationNode#raw(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link FastutilMapSerializer#serialize(AnnotatedType, Map,
   * ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test serialize(AnnotatedType, Map, ConfigurationNode) with 'annotatedType', 'obj', 'node'; when HashMap(); then calls raw(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FastutilMapSerializer.serialize(AnnotatedType, Map, ConfigurationNode)"})
  void testSerializeWithAnnotatedTypeObjNode_whenHashMap_thenCallsRaw()
      throws SerializationException {
    // Arrange
    SomethingToSomething<Map<?, ?>> somethingToSomething =
        new SomethingToSomething<>(mock(Function.class));
    HashMap<Object, Object> objectObjectMap = new HashMap<>();

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));

    // Act
    somethingToSomething.serialize((AnnotatedType) null, objectObjectMap, node);

    // Assert
    verify(node).raw(isNull());
  }
}

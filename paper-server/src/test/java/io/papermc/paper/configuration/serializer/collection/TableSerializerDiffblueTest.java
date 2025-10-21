package io.papermc.paper.configuration.serializer.collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.lang.reflect.AnnotatedType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;

class TableSerializerDiffblueTest {
  /**
   * Test {@link TableSerializer#deserialize(AnnotatedType, ConfigurationNode)} with {@code
   * AnnotatedType}, {@code ConfigurationNode}.
   *
   * <p>Method under test: {@link TableSerializer#deserialize(AnnotatedType, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test deserialize(AnnotatedType, ConfigurationNode) with 'AnnotatedType', 'ConfigurationNode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Table TableSerializer.deserialize(AnnotatedType, ConfigurationNode)"})
  void testDeserializeWithAnnotatedTypeConfigurationNode() throws SerializationException {
    // Arrange
    TableSerializer tableSerializer = new TableSerializer();

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.empty()).thenReturn(true);

    // Act
    Table<?, ?, ?> actualDeserializeResult =
        tableSerializer.deserialize((AnnotatedType) null, node);

    // Assert
    verify(node).empty();
    assertTrue(actualDeserializeResult instanceof HashBasedTable);
    assertEquals(0, actualDeserializeResult.size());
    assertTrue(actualDeserializeResult.isEmpty());
  }

  /**
   * Test {@link TableSerializer#deserialize(AnnotatedType, ConfigurationNode)} with {@code
   * AnnotatedType}, {@code ConfigurationNode}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#isMap()}.
   * </ul>
   *
   * <p>Method under test: {@link TableSerializer#deserialize(AnnotatedType, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test deserialize(AnnotatedType, ConfigurationNode) with 'AnnotatedType', 'ConfigurationNode'; then calls isMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Table TableSerializer.deserialize(AnnotatedType, ConfigurationNode)"})
  void testDeserializeWithAnnotatedTypeConfigurationNode_thenCallsIsMap()
      throws SerializationException {
    // Arrange
    TableSerializer tableSerializer = new TableSerializer();

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.empty()).thenReturn(false);
    when(node.isMap()).thenReturn(false);

    // Act
    Table<?, ?, ?> actualDeserializeResult =
        tableSerializer.deserialize((AnnotatedType) null, node);

    // Assert
    verify(node).empty();
    verify(node).isMap();
    assertTrue(actualDeserializeResult instanceof HashBasedTable);
    assertEquals(0, actualDeserializeResult.size());
    assertTrue(actualDeserializeResult.isEmpty());
  }
}

package io.papermc.paper.plugin.provider.configuration.serializer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;
import org.spongepowered.configurate.util.CheckedConsumer;

class ImmutableListSerializerDiffblueTest {
  /**
   * Test {@link ImmutableListSerializer#forEachElement(List, CheckedConsumer)} with {@code
   * collection}, {@code action}.
   *
   * <ul>
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableListSerializer#forEachElement(List, CheckedConsumer)}
   */
  @Test
  @DisplayName(
      "Test forEachElement(List, CheckedConsumer) with 'collection', 'action'; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImmutableListSerializer.forEachElement(List, CheckedConsumer)"})
  void testForEachElementWithCollectionAction_thenThrowSerializationException() throws Throwable {
    // Arrange
    ImmutableListSerializer immutableListSerializer = new ImmutableListSerializer();

    ArrayList<Object> collection = new ArrayList<>();
    collection.add(ConfigurationTransformation.WILDCARD_OBJECT);

    CheckedConsumer<Object, SerializationException> action = mock(CheckedConsumer.class);
    doThrow(new SerializationException()).when(action).accept(Mockito.<Object>any());

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () -> immutableListSerializer.forEachElement(collection, action));
    verify(action).accept(isA(Object.class));
  }

  /**
   * Test {@link ImmutableListSerializer#forEachElement(List, CheckedConsumer)} with {@code
   * collection}, {@code action}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableListSerializer#forEachElement(List, CheckedConsumer)}
   */
  @Test
  @DisplayName(
      "Test forEachElement(List, CheckedConsumer) with 'collection', 'action'; when ArrayList(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImmutableListSerializer.forEachElement(List, CheckedConsumer)"})
  void testForEachElementWithCollectionAction_whenArrayList_thenDoesNotThrow()
      throws SerializationException {
    // Arrange
    ImmutableListSerializer immutableListSerializer = new ImmutableListSerializer();

    // Act and Assert
    assertDoesNotThrow(
        () ->
            immutableListSerializer.forEachElement(new ArrayList<>(), mock(CheckedConsumer.class)));
  }

  /**
   * Test {@link ImmutableListSerializer#forEachElement(List, CheckedConsumer)} with {@code
   * collection}, {@code action}.
   *
   * <ul>
   *   <li>When {@link CheckedConsumer} {@link CheckedConsumer#accept(Object)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableListSerializer#forEachElement(List, CheckedConsumer)}
   */
  @Test
  @DisplayName(
      "Test forEachElement(List, CheckedConsumer) with 'collection', 'action'; when CheckedConsumer accept(Object) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImmutableListSerializer.forEachElement(List, CheckedConsumer)"})
  void testForEachElementWithCollectionAction_whenCheckedConsumerAcceptDoesNothing()
      throws Throwable {
    // Arrange
    ImmutableListSerializer immutableListSerializer = new ImmutableListSerializer();

    ArrayList<Object> collection = new ArrayList<>();
    collection.add(ConfigurationTransformation.WILDCARD_OBJECT);

    CheckedConsumer<Object, SerializationException> action = mock(CheckedConsumer.class);
    doNothing().when(action).accept(Mockito.<Object>any());

    // Act
    immutableListSerializer.forEachElement(collection, action);

    // Assert
    verify(action).accept(isA(Object.class));
  }

  /**
   * Test {@link ImmutableListSerializer#forEachElement(List, CheckedConsumer)} with {@code
   * collection}, {@code action}.
   *
   * <ul>
   *   <li>When {@link CheckedConsumer} {@link CheckedConsumer#accept(Object)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableListSerializer#forEachElement(List, CheckedConsumer)}
   */
  @Test
  @DisplayName(
      "Test forEachElement(List, CheckedConsumer) with 'collection', 'action'; when CheckedConsumer accept(Object) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImmutableListSerializer.forEachElement(List, CheckedConsumer)"})
  void testForEachElementWithCollectionAction_whenCheckedConsumerAcceptDoesNothing2()
      throws Throwable {
    // Arrange
    ImmutableListSerializer immutableListSerializer = new ImmutableListSerializer();

    ArrayList<Object> collection = new ArrayList<>();
    collection.add(ConfigurationTransformation.WILDCARD_OBJECT);
    collection.add(ConfigurationTransformation.WILDCARD_OBJECT);

    CheckedConsumer<Object, SerializationException> action = mock(CheckedConsumer.class);
    doNothing().when(action).accept(Mockito.<Object>any());

    // Act
    immutableListSerializer.forEachElement(collection, action);

    // Assert
    verify(action, atLeast(1)).accept(isA(Object.class));
  }
}

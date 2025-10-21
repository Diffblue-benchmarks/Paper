package io.papermc.paper.datacomponent;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
import net.minecraft.core.Holder;
import net.minecraft.core.Holder.Direct;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponentType.Builder;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class DataComponentAdapterDiffblueTest {
  /**
   * Test {@link DataComponentAdapter#isValued()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataComponentAdapter#isValued()}
   */
  @Test
  @DisplayName("Test isValued(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataComponentAdapter.isValued()"})
  void testIsValued_thenReturnFalse() {
    // Arrange
    DataComponentAdapter<Object, Object> dataComponentAdapter =
        new DataComponentAdapter<>(
            DataComponentAdapter.API_TO_UNIT_CONVERTER, mock(Function.class), true);

    // Act and Assert
    assertFalse(dataComponentAdapter.isValued());
  }

  /**
   * Test {@link DataComponentAdapter#isValued()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataComponentAdapter#isValued()}
   */
  @Test
  @DisplayName("Test isValued(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataComponentAdapter.isValued()"})
  void testIsValued_thenReturnTrue() {
    // Arrange
    DataComponentAdapter<Object, Object> dataComponentAdapter =
        new DataComponentAdapter<>(mock(Function.class), mock(Function.class), true);

    // Act and Assert
    assertTrue(dataComponentAdapter.isValued());
  }

  /**
   * Test {@link DataComponentAdapter#isUnimplemented()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataComponentAdapter#isUnimplemented()}
   */
  @Test
  @DisplayName("Test isUnimplemented(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataComponentAdapter.isUnimplemented()"})
  void testIsUnimplemented_thenReturnFalse() {
    // Arrange
    DataComponentAdapter<Object, Object> dataComponentAdapter =
        new DataComponentAdapter<>(mock(Function.class), mock(Function.class), true);

    // Act and Assert
    assertFalse(dataComponentAdapter.isUnimplemented());
  }

  /**
   * Test {@link DataComponentAdapter#isUnimplemented()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataComponentAdapter#isUnimplemented()}
   */
  @Test
  @DisplayName("Test isUnimplemented(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataComponentAdapter.isUnimplemented()"})
  void testIsUnimplemented_thenReturnTrue() {
    // Arrange
    DataComponentAdapter<Object, Object> dataComponentAdapter =
        new DataComponentAdapter<>(
            DataComponentAdapter.API_TO_UNIMPLEMENTED_CONVERTER, mock(Function.class), true);

    // Act and Assert
    assertTrue(dataComponentAdapter.isUnimplemented());
  }

  /**
   * Test {@link DataComponentAdapter#toVanilla(Object, Holder)}.
   *
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link DataComponentAdapter#toVanilla(Object, Holder)}
   */
  @Test
  @DisplayName(
      "Test toVanilla(Object, Holder); given Function apply(Object) return WILDCARD_OBJECT; then return WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataComponentAdapter.toVanilla(Object, Holder)"})
  void testToVanilla_givenFunctionApplyReturnWildcard_object_thenReturnWildcard_object() {
    // Arrange
    Function<Object, Object> apiToVanilla = mock(Function.class);
    when(apiToVanilla.apply(Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    DataComponentAdapter<Object, Object> dataComponentAdapter =
        new DataComponentAdapter<>(apiToVanilla, mock(Function.class), false);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    Builder<Object> builderResult = DataComponentType.builder();
    DataComponentType<Object> dataComponentType =
        builderResult
            .persistent(ExtraCodecs.JAVA)
            .networkSynchronized(mock(StreamCodec.class))
            .build();

    // Act
    Object actualToVanillaResult =
        dataComponentAdapter.toVanilla(object, new Direct<>(dataComponentType));

    // Assert
    verify(apiToVanilla).apply(isA(Object.class));
    assertSame(object, actualToVanillaResult);
  }

  /**
   * Test {@link DataComponentAdapter#toVanilla(Object, Holder)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DataComponentAdapter#toVanilla(Object, Holder)}
   */
  @Test
  @DisplayName("Test toVanilla(Object, Holder); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataComponentAdapter.toVanilla(Object, Holder)"})
  void testToVanilla_thenThrowIllegalArgumentException() {
    // Arrange
    Function<Object, Object> apiToVanilla = mock(Function.class);
    when(apiToVanilla.apply(Mockito.<Object>any())).thenThrow(new IllegalArgumentException());
    DataComponentAdapter<Object, Object> dataComponentAdapter =
        new DataComponentAdapter<>(apiToVanilla, mock(Function.class), false);

    Builder<Object> builderResult = DataComponentType.builder();
    DataComponentType<Object> dataComponentType =
        builderResult
            .persistent(ExtraCodecs.JAVA)
            .networkSynchronized(mock(StreamCodec.class))
            .build();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            dataComponentAdapter.toVanilla(
                ConfigurationTransformation.WILDCARD_OBJECT, new Direct<>(dataComponentType)));
    verify(apiToVanilla).apply(isA(Object.class));
  }

  /**
   * Test {@link DataComponentAdapter#fromVanilla(Object)}.
   *
   * <ul>
   *   <li>Then return {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link DataComponentAdapter#fromVanilla(Object)}
   */
  @Test
  @DisplayName("Test fromVanilla(Object); then return WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataComponentAdapter.fromVanilla(Object)"})
  void testFromVanilla_thenReturnWildcard_object() {
    // Arrange
    Function<Object, Object> vanillaToApi = mock(Function.class);
    when(vanillaToApi.apply(Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    DataComponentAdapter<Object, Object> dataComponentAdapter =
        new DataComponentAdapter<>(mock(Function.class), vanillaToApi, true);
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Object actualFromVanillaResult = dataComponentAdapter.fromVanilla(object);

    // Assert
    verify(vanillaToApi).apply(isA(Object.class));
    assertSame(object, actualFromVanillaResult);
  }

  /**
   * Test {@link DataComponentAdapter#fromVanilla(Object)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DataComponentAdapter#fromVanilla(Object)}
   */
  @Test
  @DisplayName("Test fromVanilla(Object); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DataComponentAdapter.fromVanilla(Object)"})
  void testFromVanilla_thenThrowIllegalArgumentException() {
    // Arrange
    Function<Object, Object> vanillaToApi = mock(Function.class);
    when(vanillaToApi.apply(Mockito.<Object>any())).thenThrow(new IllegalArgumentException());
    DataComponentAdapter<Object, Object> dataComponentAdapter =
        new DataComponentAdapter<>(mock(Function.class), vanillaToApi, true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> dataComponentAdapter.fromVanilla(ConfigurationTransformation.WILDCARD_OBJECT));
    verify(vanillaToApi).apply(isA(Object.class));
  }
}

package com.mojang.datafixers.util;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.K1;
import com.mojang.datafixers.util.Either.Instance;
import com.mojang.datafixers.util.Either.Mu;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class EitherDiffblueTest {
  /**
   * Test Instance {@link Instance#from(App)}.
   *
   * <p>Method under test: {@link Instance#from(App)}
   */
  @Test
  @DisplayName("Test Instance from(App)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"App Instance.from(App)"})
  void testInstanceFrom() {
    // Arrange
    Instance<Object> instance = new Instance<>();
    App<Mu<Object>, Object> input = mock(App.class);

    // Act
    App<Mu<Object>, Object> actualFromResult = instance.from(input);

    // Assert
    assertSame(input, actualFromResult);
  }

  /**
   * Test Instance {@link Instance#to(App)}.
   *
   * <p>Method under test: {@link Instance#to(App)}
   */
  @Test
  @DisplayName("Test Instance to(App)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"App Instance.to(App)"})
  void testInstanceTo() {
    // Arrange
    Instance<Object> instance = new Instance<>();
    App<Mu<Object>, Object> input = mock(App.class);

    // Act
    App<Mu<Object>, Object> actualToResult = instance.to(input);

    // Assert
    assertSame(input, actualToResult);
  }

  /**
   * Test Instance {@link Instance#traverse(Applicative, Function, App)}.
   *
   * <ul>
   *   <li>Given {@link App}.
   *   <li>When {@link Either} {@link Either#map(Function, Function)} return {@link App}.
   *   <li>Then calls {@link Either#map(Function, Function)}.
   * </ul>
   *
   * <p>Method under test: {@link Instance#traverse(Applicative, Function, App)}
   */
  @Test
  @DisplayName(
      "Test Instance traverse(Applicative, Function, App); given App; when Either map(Function, Function) return App; then calls map(Function, Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"App Instance.traverse(Applicative, Function, App)"})
  void testInstanceTraverse_givenApp_whenEitherMapReturnApp_thenCallsMap() {
    // Arrange
    Instance<Object> instance = new Instance<>();
    Applicative<K1, ?> applicative = mock(Applicative.class);
    Function<Object, App<K1, Object>> function = mock(Function.class);

    Either<Object, Object> input = mock(Either.class);
    when(input.map(
            Mockito.<Function<Object, Object>>any(), Mockito.<Function<Object, Object>>any()))
        .thenReturn(mock(App.class));

    // Act
    instance.traverse(applicative, function, input);

    // Assert
    verify(input).map(isA(Function.class), isA(Function.class));
  }

  /**
   * Test {@link Either#unbox(App)}.
   *
   * <p>Method under test: {@link Either#unbox(App)}
   */
  @Test
  @DisplayName("Test unbox(App)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Either Either.unbox(App)"})
  void testUnbox() {
    // Arrange and Act
    Either<Object, Object> actualUnboxResult = Either.unbox(null);

    // Assert
    assertNull(actualUnboxResult);
  }

  /**
   * Test {@link Either#left(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link Either#left(Object)}
   */
  @Test
  @DisplayName("Test left(Object) with 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Either Either.left(Object)"})
  void testLeftWithObject() {
    // Arrange
    Object object = ConfigurationTransformation.WILDCARD_OBJECT;

    // Act
    Either<Object, Object> actualLeftResult = Either.left(object);

    // Assert
    assertSame(object, actualLeftResult.orThrow());
  }
}

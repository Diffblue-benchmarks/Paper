package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.FireworkEffect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FireworkEffectDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#flicker(boolean)}
   *   <li>{@link Builder#trail(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FireworkEffect Builder.build()",
    "Builder Builder.flicker(boolean)",
    "Builder Builder.trail(boolean)",
    "Builder Builder.withFlicker()",
    "Builder Builder.withTrail()"
  })
  void testBuilderBuild() throws IllegalArgumentException {
    // Arrange and Act
    Builder actualFlickerResult = FireworkEffect.builder().flicker(true);
    Builder actualTrailResult = actualFlickerResult.trail(true);
    Builder actualWithResult = actualTrailResult.with(Type.BALL);
    Builder actualWithFadeResult = actualWithResult.withFade(new ArrayList<>());
    Builder actualWithFadeResult2 = actualWithFadeResult.withFade(Color.AQUA);
    Builder actualWithFadeResult3 = actualWithFadeResult2.withFade(Color.AQUA);
    FireworkEffect actualFireworkEffect = actualWithFadeResult3.build();

    // Assert
    List<Color> fadeColors = actualFireworkEffect.getFadeColors();
    assertEquals(2, fadeColors.size());
    assertEquals(Type.BALL, actualFireworkEffect.getType());
    assertEquals(Type.BALL, actualFlickerResult.type);
    assertEquals(Type.BALL, actualTrailResult.type);
    assertEquals(Type.BALL, actualWithResult.type);
    assertEquals(Type.BALL, actualWithFadeResult3.type);
    assertEquals(Type.BALL, actualWithFadeResult.type);
    assertEquals(Type.BALL, actualWithFadeResult2.type);
    assertTrue(actualFireworkEffect.getColors().isEmpty());
    assertTrue(actualFireworkEffect.hasFlicker());
    assertTrue(actualFireworkEffect.hasTrail());
    assertTrue(actualFlickerResult.flicker);
    assertTrue(actualTrailResult.flicker);
    assertTrue(actualWithResult.flicker);
    assertTrue(actualWithFadeResult3.flicker);
    assertTrue(actualWithFadeResult.flicker);
    assertTrue(actualWithFadeResult2.flicker);
    assertTrue(actualFlickerResult.trail);
    assertTrue(actualTrailResult.trail);
    assertTrue(actualWithResult.trail);
    assertTrue(actualWithFadeResult3.trail);
    assertTrue(actualWithFadeResult.trail);
    assertTrue(actualWithFadeResult2.trail);
    Color color = Color.AQUA;
    assertSame(color, fadeColors.get(0));
    assertSame(color, fadeColors.get(1));
  }

  /**
   * Test Builder {@link Builder#Builder()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    assertNull(actualBuilder.fadeColors);
    assertEquals(Type.BALL, actualBuilder.type);
    assertFalse(actualBuilder.flicker);
    assertFalse(actualBuilder.trail);
  }

  /**
   * Test Builder {@link Builder#withColor(Color[])} with {@code Color[]}.
   *
   * <p>Method under test: {@link Builder#withColor(Color[])}
   */
  @Test
  @DisplayName("Test Builder withColor(Color[]) with 'Color[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.withColor(Color[])"})
  void testBuilderWithColorWithColor() throws IllegalArgumentException {
    // Arrange
    Builder builderResult = FireworkEffect.builder();

    // Act
    Builder actualWithColorResult = builderResult.withColor();

    // Assert
    assertSame(builderResult, actualWithColorResult);
  }

  /**
   * Test Builder {@link Builder#withColor(Color[])} with {@code Color[]}.
   *
   * <ul>
   *   <li>When {@link Color#AQUA}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#withColor(Color[])}
   */
  @Test
  @DisplayName("Test Builder withColor(Color[]) with 'Color[]'; when AQUA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.withColor(Color[])"})
  void testBuilderWithColorWithColor_whenAqua() throws IllegalArgumentException {
    // Arrange
    Builder builderResult = FireworkEffect.builder();

    // Act
    Builder actualWithColorResult = builderResult.withColor(Color.AQUA);

    // Assert
    assertSame(builderResult, actualWithColorResult);
  }

  /**
   * Test Builder {@link Builder#withColor(Color)} with {@code Color}.
   *
   * <ul>
   *   <li>When {@link Color#AQUA}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#withColor(Color)}
   */
  @Test
  @DisplayName("Test Builder withColor(Color) with 'Color'; when AQUA; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.withColor(Color)"})
  void testBuilderWithColorWithColor_whenAqua_thenReturnBuilder() throws IllegalArgumentException {
    // Arrange
    Builder builderResult = FireworkEffect.builder();

    // Act
    Builder actualWithColorResult = builderResult.withColor(Color.AQUA);

    // Assert
    assertSame(builderResult, actualWithColorResult);
  }

  /**
   * Test Builder {@link Builder#withColor(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#withColor(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder withColor(Iterable) with 'Iterable'; given 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.withColor(Iterable)"})
  void testBuilderWithColorWithIterable_givenNull_thenThrowIllegalArgumentException()
      throws IllegalArgumentException {
    // Arrange
    Builder builderResult = FireworkEffect.builder();

    LinkedHashSet<?> colors = new LinkedHashSet<>();
    colors.add(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builderResult.withColor(colors));
  }

  /**
   * Test Builder {@link Builder#withColor(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#withColor(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder withColor(Iterable) with 'Iterable'; when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.withColor(Iterable)"})
  void testBuilderWithColorWithIterable_whenArrayList_thenReturnBuilder()
      throws IllegalArgumentException {
    // Arrange
    Builder builderResult = FireworkEffect.builder();

    // Act
    Builder actualWithColorResult = builderResult.withColor(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualWithColorResult);
  }

  /**
   * Test Builder {@link Builder#withFade(Color[])} with {@code Color[]}.
   *
   * <p>Method under test: {@link Builder#withFade(Color[])}
   */
  @Test
  @DisplayName("Test Builder withFade(Color[]) with 'Color[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.withFade(Color[])"})
  void testBuilderWithFadeWithColor() throws IllegalArgumentException {
    // Arrange
    Builder builderResult = FireworkEffect.builder();

    // Act
    Builder actualWithFadeResult = builderResult.withFade();

    // Assert
    assertSame(builderResult, actualWithFadeResult);
  }

  /**
   * Test Builder {@link Builder#withFade(Color)} with {@code Color}.
   *
   * <ul>
   *   <li>Given builder withFade {@link Color#AQUA}.
   *   <li>When {@link Color#AQUA}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#withFade(Color)}
   */
  @Test
  @DisplayName(
      "Test Builder withFade(Color) with 'Color'; given builder withFade AQUA; when AQUA; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.withFade(Color)"})
  void testBuilderWithFadeWithColor_givenBuilderWithFadeAqua_whenAqua_thenReturnBuilder()
      throws IllegalArgumentException {
    // Arrange
    Builder builderResult = FireworkEffect.builder();
    builderResult.withFade(Color.AQUA);

    // Act
    Builder actualWithFadeResult = builderResult.withFade(Color.AQUA);

    // Assert
    assertSame(builderResult, actualWithFadeResult);
  }

  /**
   * Test Builder {@link Builder#withFade(Color)} with {@code Color}.
   *
   * <ul>
   *   <li>Given builder.
   *   <li>When {@link Color#AQUA}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#withFade(Color)}
   */
  @Test
  @DisplayName(
      "Test Builder withFade(Color) with 'Color'; given builder; when AQUA; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.withFade(Color)"})
  void testBuilderWithFadeWithColor_givenBuilder_whenAqua_thenReturnBuilder()
      throws IllegalArgumentException {
    // Arrange
    Builder builderResult = FireworkEffect.builder();

    // Act
    Builder actualWithFadeResult = builderResult.withFade(Color.AQUA);

    // Assert
    assertSame(builderResult, actualWithFadeResult);
  }

  /**
   * Test Builder {@link Builder#withFade(Color[])} with {@code Color[]}.
   *
   * <ul>
   *   <li>When {@link Color#AQUA}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#withFade(Color[])}
   */
  @Test
  @DisplayName("Test Builder withFade(Color[]) with 'Color[]'; when AQUA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.withFade(Color[])"})
  void testBuilderWithFadeWithColor_whenAqua() throws IllegalArgumentException {
    // Arrange
    Builder builderResult = FireworkEffect.builder();

    // Act
    Builder actualWithFadeResult = builderResult.withFade(Color.AQUA);

    // Assert
    assertSame(builderResult, actualWithFadeResult);
  }

  /**
   * Test Builder {@link Builder#withFade(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given builder.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#withFade(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder withFade(Iterable) with 'Iterable'; given builder; when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.withFade(Iterable)"})
  void testBuilderWithFadeWithIterable_givenBuilder_whenArrayList_thenReturnBuilder()
      throws IllegalArgumentException {
    // Arrange
    Builder builderResult = FireworkEffect.builder();

    // Act
    Builder actualWithFadeResult = builderResult.withFade(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualWithFadeResult);
  }

  /**
   * Test Builder {@link Builder#withFade(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#withFade(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder withFade(Iterable) with 'Iterable'; given 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.withFade(Iterable)"})
  void testBuilderWithFadeWithIterable_givenNull_thenThrowIllegalArgumentException()
      throws IllegalArgumentException {
    // Arrange
    Builder builderResult = FireworkEffect.builder();
    builderResult.withFade(Color.AQUA);

    LinkedHashSet<?> colors = new LinkedHashSet<>();
    colors.add(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builderResult.withFade(colors));
  }

  /**
   * Test Builder {@link Builder#withFade(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#withFade(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder withFade(Iterable) with 'Iterable'; when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.withFade(Iterable)"})
  void testBuilderWithFadeWithIterable_whenArrayList_thenReturnBuilder()
      throws IllegalArgumentException {
    // Arrange
    Builder builderResult = FireworkEffect.builder();
    builderResult.withFade(Color.AQUA);

    // Act
    Builder actualWithFadeResult = builderResult.withFade(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualWithFadeResult);
  }

  /**
   * Test Builder {@link Builder#with(Type)}.
   *
   * <ul>
   *   <li>When {@code BALL}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#with(Type)}
   */
  @Test
  @DisplayName("Test Builder with(Type); when 'BALL'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.with(Type)"})
  void testBuilderWith_whenBall_thenReturnBuilder() throws IllegalArgumentException {
    // Arrange
    Builder builderResult = FireworkEffect.builder();

    // Act
    Builder actualWithResult = builderResult.with(Type.BALL);

    // Assert
    assertSame(builderResult, actualWithResult);
  }
}

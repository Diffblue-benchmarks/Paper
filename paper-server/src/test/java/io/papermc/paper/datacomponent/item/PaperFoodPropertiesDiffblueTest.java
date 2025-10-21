package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.FoodProperties.Builder;
import io.papermc.paper.datacomponent.item.PaperFoodProperties.BuilderImpl;
import net.minecraft.world.food.Foods;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperFoodPropertiesDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BuilderImpl#build()}
   *   <li>default or parameterless constructor of {@link BuilderImpl}
   * </ul>
   */
  @Test
  @DisplayName("Test BuilderImpl build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BuilderImpl.<init>()",
    "FoodProperties BuilderImpl.build()",
    "Builder BuilderImpl.canAlwaysEat(boolean)",
    "Builder BuilderImpl.saturation(float)"
  })
  void testBuilderImplBuild() {
    // Arrange and Act
    FoodProperties actualFoodProperties = new BuilderImpl().build();

    // Assert
    assertTrue(actualFoodProperties instanceof PaperFoodProperties);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#nutrition(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link BuilderImpl} (default constructor) build {@link PaperFoodProperties}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#nutrition(int)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl nutrition(int); when one; then BuilderImpl (default constructor) build PaperFoodProperties")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.nutrition(int)"})
  void testBuilderImplNutrition_whenOne_thenBuilderImplBuildPaperFoodProperties() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualNutritionResult = builderImpl.nutrition(1);

    // Assert
    FoodProperties foodProperties = builderImpl.build();
    assertTrue(foodProperties instanceof PaperFoodProperties);
    assertEquals(1, ((PaperFoodProperties) foodProperties).getHandle().nutrition());
    assertSame(builderImpl, actualNutritionResult);
  }

  /**
   * Test {@link PaperFoodProperties#nutrition()}.
   *
   * <ul>
   *   <li>Given {@link PaperFoodProperties#PaperFoodProperties(FoodProperties)} with impl is {@link
   *       Foods#APPLE}.
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link PaperFoodProperties#nutrition()}
   */
  @Test
  @DisplayName(
      "Test nutrition(); given PaperFoodProperties(FoodProperties) with impl is APPLE; then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperFoodProperties.nutrition()"})
  void testNutrition_givenPaperFoodPropertiesWithImplIsApple_thenReturnFour() {
    // Arrange, Act and Assert
    assertEquals(4, new PaperFoodProperties(Foods.APPLE).nutrition());
  }

  /**
   * Test {@link PaperFoodProperties#saturation()}.
   *
   * <ul>
   *   <li>Given {@link PaperFoodProperties#PaperFoodProperties(FoodProperties)} with impl is {@link
   *       Foods#APPLE}.
   *   <li>Then return {@code 2.4}.
   * </ul>
   *
   * <p>Method under test: {@link PaperFoodProperties#saturation()}
   */
  @Test
  @DisplayName(
      "Test saturation(); given PaperFoodProperties(FoodProperties) with impl is APPLE; then return '2.4'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PaperFoodProperties.saturation()"})
  void testSaturation_givenPaperFoodPropertiesWithImplIsApple_thenReturn24() {
    // Arrange, Act and Assert
    assertEquals(2.4f, new PaperFoodProperties(Foods.APPLE).saturation());
  }

  /**
   * Test {@link PaperFoodProperties#canAlwaysEat()}.
   *
   * <ul>
   *   <li>Given {@link PaperFoodProperties#PaperFoodProperties(FoodProperties)} with impl is {@link
   *       Foods#APPLE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperFoodProperties#canAlwaysEat()}
   */
  @Test
  @DisplayName(
      "Test canAlwaysEat(); given PaperFoodProperties(FoodProperties) with impl is APPLE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperFoodProperties.canAlwaysEat()"})
  void testCanAlwaysEat_givenPaperFoodPropertiesWithImplIsApple_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PaperFoodProperties(Foods.APPLE).canAlwaysEat());
  }

  /**
   * Test {@link PaperFoodProperties#canAlwaysEat()}.
   *
   * <ul>
   *   <li>Given {@link PaperFoodProperties#PaperFoodProperties(FoodProperties)} with impl is {@link
   *       Foods#CHORUS_FRUIT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperFoodProperties#canAlwaysEat()}
   */
  @Test
  @DisplayName(
      "Test canAlwaysEat(); given PaperFoodProperties(FoodProperties) with impl is CHORUS_FRUIT; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperFoodProperties.canAlwaysEat()"})
  void testCanAlwaysEat_givenPaperFoodPropertiesWithImplIsChorus_fruit_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PaperFoodProperties(Foods.CHORUS_FRUIT).canAlwaysEat());
  }

  /**
   * Test {@link PaperFoodProperties#toBuilder()}.
   *
   * <ul>
   *   <li>Then return build is {@link PaperFoodProperties#PaperFoodProperties(FoodProperties)} with
   *       impl is {@link Foods#APPLE}.
   * </ul>
   *
   * <p>Method under test: {@link PaperFoodProperties#toBuilder()}
   */
  @Test
  @DisplayName(
      "Test toBuilder(); then return build is PaperFoodProperties(FoodProperties) with impl is APPLE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperFoodProperties.toBuilder()"})
  void testToBuilder_thenReturnBuildIsPaperFoodPropertiesWithImplIsApple() {
    // Arrange
    PaperFoodProperties paperFoodProperties = new PaperFoodProperties(Foods.APPLE);

    // Act
    Builder actualToBuilderResult = paperFoodProperties.toBuilder();

    // Assert
    FoodProperties foodProperties = actualToBuilderResult.build();
    assertTrue(foodProperties instanceof PaperFoodProperties);
    assertTrue(actualToBuilderResult instanceof BuilderImpl);
    assertEquals(paperFoodProperties, foodProperties);
  }

  /**
   * Test {@link PaperFoodProperties#toBuilder()}.
   *
   * <ul>
   *   <li>Then return build is {@link PaperFoodProperties#PaperFoodProperties(FoodProperties)} with
   *       impl is {@link Foods#CHORUS_FRUIT}.
   * </ul>
   *
   * <p>Method under test: {@link PaperFoodProperties#toBuilder()}
   */
  @Test
  @DisplayName(
      "Test toBuilder(); then return build is PaperFoodProperties(FoodProperties) with impl is CHORUS_FRUIT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperFoodProperties.toBuilder()"})
  void testToBuilder_thenReturnBuildIsPaperFoodPropertiesWithImplIsChorus_fruit() {
    // Arrange
    PaperFoodProperties paperFoodProperties = new PaperFoodProperties(Foods.CHORUS_FRUIT);

    // Act
    Builder actualToBuilderResult = paperFoodProperties.toBuilder();

    // Assert
    FoodProperties foodProperties = actualToBuilderResult.build();
    assertTrue(foodProperties instanceof PaperFoodProperties);
    assertTrue(actualToBuilderResult instanceof BuilderImpl);
    assertEquals(paperFoodProperties, foodProperties);
  }

  /**
   * Test {@link PaperFoodProperties#getHandle()}.
   *
   * <p>Method under test: {@link PaperFoodProperties#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.world.food.FoodProperties PaperFoodProperties.getHandle()"})
  void testGetHandle() {
    // Arrange and Act
    net.minecraft.world.food.FoodProperties actualHandle =
        new PaperFoodProperties(Foods.APPLE).getHandle();

    // Assert
    assertEquals(2.4f, actualHandle.saturation());
    assertEquals(4, actualHandle.nutrition());
    assertFalse(actualHandle.canAlwaysEat());
  }
}

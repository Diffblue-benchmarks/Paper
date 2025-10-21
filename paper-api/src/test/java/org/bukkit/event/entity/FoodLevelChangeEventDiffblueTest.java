package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.HumanEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FoodLevelChangeEventDiffblueTest {
  /**
   * Test {@link FoodLevelChangeEvent#getEntity()}.
   *
   * <p>Method under test: {@link FoodLevelChangeEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HumanEntity FoodLevelChangeEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    FoodLevelChangeEvent foodLevelChangeEvent =
        new FoodLevelChangeEvent(mock(HumanEntity.class), 1);

    // Act
    HumanEntity actualEntity = foodLevelChangeEvent.getEntity();

    // Assert
    assertSame(foodLevelChangeEvent.entity, actualEntity);
  }

  /**
   * Test {@link FoodLevelChangeEvent#getItem()}.
   *
   * <p>Method under test: {@link FoodLevelChangeEvent#getItem()}
   */
  @Test
  @DisplayName("Test getItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.inventory.ItemStack FoodLevelChangeEvent.getItem()"})
  void testGetItem() {
    // Arrange, Act and Assert
    assertNull(new FoodLevelChangeEvent(mock(HumanEntity.class), 1).getItem());
  }

  /**
   * Test {@link FoodLevelChangeEvent#setFoodLevel(int)}.
   *
   * <p>Method under test: {@link FoodLevelChangeEvent#setFoodLevel(int)}
   */
  @Test
  @DisplayName("Test setFoodLevel(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FoodLevelChangeEvent.setFoodLevel(int)"})
  void testSetFoodLevel() {
    // Arrange
    FoodLevelChangeEvent foodLevelChangeEvent =
        new FoodLevelChangeEvent(mock(HumanEntity.class), 1);

    // Act
    foodLevelChangeEvent.setFoodLevel(1);

    // Assert that nothing has changed
    assertEquals(1, foodLevelChangeEvent.getFoodLevel());
  }

  /**
   * Test {@link FoodLevelChangeEvent#setFoodLevel(int)}.
   *
   * <p>Method under test: {@link FoodLevelChangeEvent#setFoodLevel(int)}
   */
  @Test
  @DisplayName("Test setFoodLevel(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FoodLevelChangeEvent.setFoodLevel(int)"})
  void testSetFoodLevel2() {
    // Arrange
    FoodLevelChangeEvent foodLevelChangeEvent =
        new FoodLevelChangeEvent(mock(HumanEntity.class), 1);

    // Act
    foodLevelChangeEvent.setFoodLevel(-1);

    // Assert
    assertEquals(0, foodLevelChangeEvent.getFoodLevel());
  }
}

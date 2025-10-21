package com.destroystokyo.paper.entity.ai;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Mob;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GoalKeyDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GoalKey#toString()}
   *   <li>{@link GoalKey#getEntityClass()}
   *   <li>{@link GoalKey#getNamespacedKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class GoalKey.getEntityClass()",
    "NamespacedKey GoalKey.getNamespacedKey()",
    "java.lang.String GoalKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Class<Mob> type = Mob.class;
    NamespacedKey key = NamespacedKey.randomKey();

    GoalKey<Mob> ofResult = GoalKey.of(type, key);

    // Act
    ofResult.toString();
    Class<Mob> actualEntityClass = ofResult.getEntityClass();
    NamespacedKey actualNamespacedKey = ofResult.getNamespacedKey();

    // Assert
    Class<Mob> expectedEntityClass = Mob.class;
    assertEquals(expectedEntityClass, actualEntityClass);
    assertSame(type, actualEntityClass);
    assertSame(key, actualNamespacedKey);
  }

  /**
   * Test {@link GoalKey#equals(Object)}, and {@link GoalKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GoalKey#equals(Object)}
   *   <li>{@link GoalKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GoalKey.equals(Object)", "int GoalKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GoalKey<Mob> goalKey = VanillaGoal.BREAK_DOOR;
    GoalKey<Mob> goalKey2 = VanillaGoal.BREAK_DOOR;

    // Act and Assert
    assertEquals(goalKey, goalKey2);
    assertEquals(goalKey.hashCode(), goalKey2.hashCode());
  }

  /**
   * Test {@link GoalKey#equals(Object)}, and {@link GoalKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GoalKey#equals(Object)}
   *   <li>{@link GoalKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GoalKey.equals(Object)", "int GoalKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GoalKey<Mob> goalKey = VanillaGoal.BREAK_DOOR;

    // Act and Assert
    assertEquals(goalKey, goalKey);
    int expectedHashCodeResult = goalKey.hashCode();
    assertEquals(expectedHashCodeResult, goalKey.hashCode());
  }

  /**
   * Test {@link GoalKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GoalKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GoalKey.equals(Object)", "int GoalKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VanillaGoal.CLIMB_ON_TOP_OF_POWDER_SNOW, VanillaGoal.BREAK_DOOR);
  }

  /**
   * Test {@link GoalKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GoalKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GoalKey.equals(Object)", "int GoalKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VanillaGoal.BREAK_DOOR, null);
  }

  /**
   * Test {@link GoalKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GoalKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GoalKey.equals(Object)", "int GoalKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VanillaGoal.BREAK_DOOR, "Different type to GoalKey");
  }

  /**
   * Test {@link GoalKey#of(Class, NamespacedKey)}.
   *
   * <p>Method under test: {@link GoalKey#of(Class, NamespacedKey)}
   */
  @Test
  @DisplayName("Test of(Class, NamespacedKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GoalKey GoalKey.of(Class, NamespacedKey)"})
  void testOf() {
    // Arrange
    Class<Mob> type = Mob.class;
    NamespacedKey key = NamespacedKey.randomKey();

    // Act
    GoalKey<Mob> actualOfResult = GoalKey.of(type, key);

    // Assert
    Class<Mob> expectedEntityClass = Mob.class;
    assertEquals(expectedEntityClass, actualOfResult.getEntityClass());
    assertSame(key, actualOfResult.getNamespacedKey());
  }
}

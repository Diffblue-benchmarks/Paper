package com.destroystokyo.paper.entity.ai;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import org.bukkit.entity.Mob;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MobGoalHelperDiffblueTest {
  /**
   * Test {@link MobGoalHelper#vanillaToPaper(Flag)} with {@code type}.
   *
   * <ul>
   *   <li>When {@code JUMP}.
   *   <li>Then return {@code JUMP}.
   * </ul>
   *
   * <p>Method under test: {@link MobGoalHelper#vanillaToPaper(Flag)}
   */
  @Test
  @DisplayName("Test vanillaToPaper(Flag) with 'type'; when 'JUMP'; then return 'JUMP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GoalType MobGoalHelper.vanillaToPaper(Flag)"})
  void testVanillaToPaperWithType_whenJump_thenReturnJump() {
    // Arrange, Act and Assert
    assertEquals(GoalType.JUMP, MobGoalHelper.vanillaToPaper(Flag.JUMP));
  }

  /**
   * Test {@link MobGoalHelper#vanillaToPaper(Flag)} with {@code type}.
   *
   * <ul>
   *   <li>When {@code LOOK}.
   *   <li>Then return {@code LOOK}.
   * </ul>
   *
   * <p>Method under test: {@link MobGoalHelper#vanillaToPaper(Flag)}
   */
  @Test
  @DisplayName("Test vanillaToPaper(Flag) with 'type'; when 'LOOK'; then return 'LOOK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GoalType MobGoalHelper.vanillaToPaper(Flag)"})
  void testVanillaToPaperWithType_whenLook_thenReturnLook() {
    // Arrange, Act and Assert
    assertEquals(GoalType.LOOK, MobGoalHelper.vanillaToPaper(Flag.LOOK));
  }

  /**
   * Test {@link MobGoalHelper#vanillaToPaper(Flag)} with {@code type}.
   *
   * <ul>
   *   <li>When {@code MOVE}.
   *   <li>Then return {@code MOVE}.
   * </ul>
   *
   * <p>Method under test: {@link MobGoalHelper#vanillaToPaper(Flag)}
   */
  @Test
  @DisplayName("Test vanillaToPaper(Flag) with 'type'; when 'MOVE'; then return 'MOVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GoalType MobGoalHelper.vanillaToPaper(Flag)"})
  void testVanillaToPaperWithType_whenMove_thenReturnMove() {
    // Arrange, Act and Assert
    assertEquals(GoalType.MOVE, MobGoalHelper.vanillaToPaper(Flag.MOVE));
  }

  /**
   * Test {@link MobGoalHelper#vanillaToPaper(Flag)} with {@code type}.
   *
   * <ul>
   *   <li>When {@code TARGET}.
   *   <li>Then return {@code TARGET}.
   * </ul>
   *
   * <p>Method under test: {@link MobGoalHelper#vanillaToPaper(Flag)}
   */
  @Test
  @DisplayName("Test vanillaToPaper(Flag) with 'type'; when 'TARGET'; then return 'TARGET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GoalType MobGoalHelper.vanillaToPaper(Flag)"})
  void testVanillaToPaperWithType_whenTarget_thenReturnTarget() {
    // Arrange, Act and Assert
    assertEquals(GoalType.TARGET, MobGoalHelper.vanillaToPaper(Flag.TARGET));
  }

  /**
   * Test {@link MobGoalHelper#vanillaToPaper(Flag)} with {@code type}.
   *
   * <ul>
   *   <li>When {@code UNKNOWN_BEHAVIOR}.
   *   <li>Then return {@code UNKNOWN_BEHAVIOR}.
   * </ul>
   *
   * <p>Method under test: {@link MobGoalHelper#vanillaToPaper(Flag)}
   */
  @Test
  @DisplayName(
      "Test vanillaToPaper(Flag) with 'type'; when 'UNKNOWN_BEHAVIOR'; then return 'UNKNOWN_BEHAVIOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GoalType MobGoalHelper.vanillaToPaper(Flag)"})
  void testVanillaToPaperWithType_whenUnknownBehavior_thenReturnUnknownBehavior() {
    // Arrange, Act and Assert
    assertEquals(GoalType.UNKNOWN_BEHAVIOR, MobGoalHelper.vanillaToPaper(Flag.UNKNOWN_BEHAVIOR));
  }

  /**
   * Test {@link MobGoalHelper#paperToVanilla(GoalType)} with {@code type}.
   *
   * <ul>
   *   <li>When {@code JUMP}.
   *   <li>Then return {@code JUMP}.
   * </ul>
   *
   * <p>Method under test: {@link MobGoalHelper#paperToVanilla(GoalType)}
   */
  @Test
  @DisplayName("Test paperToVanilla(GoalType) with 'type'; when 'JUMP'; then return 'JUMP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Flag MobGoalHelper.paperToVanilla(GoalType)"})
  void testPaperToVanillaWithType_whenJump_thenReturnJump() {
    // Arrange, Act and Assert
    assertEquals(Flag.JUMP, MobGoalHelper.paperToVanilla(GoalType.JUMP));
  }

  /**
   * Test {@link MobGoalHelper#paperToVanilla(GoalType)} with {@code type}.
   *
   * <ul>
   *   <li>When {@code LOOK}.
   *   <li>Then return {@code LOOK}.
   * </ul>
   *
   * <p>Method under test: {@link MobGoalHelper#paperToVanilla(GoalType)}
   */
  @Test
  @DisplayName("Test paperToVanilla(GoalType) with 'type'; when 'LOOK'; then return 'LOOK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Flag MobGoalHelper.paperToVanilla(GoalType)"})
  void testPaperToVanillaWithType_whenLook_thenReturnLook() {
    // Arrange, Act and Assert
    assertEquals(Flag.LOOK, MobGoalHelper.paperToVanilla(GoalType.LOOK));
  }

  /**
   * Test {@link MobGoalHelper#paperToVanilla(GoalType)} with {@code type}.
   *
   * <ul>
   *   <li>When {@code MOVE}.
   *   <li>Then return {@code MOVE}.
   * </ul>
   *
   * <p>Method under test: {@link MobGoalHelper#paperToVanilla(GoalType)}
   */
  @Test
  @DisplayName("Test paperToVanilla(GoalType) with 'type'; when 'MOVE'; then return 'MOVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Flag MobGoalHelper.paperToVanilla(GoalType)"})
  void testPaperToVanillaWithType_whenMove_thenReturnMove() {
    // Arrange, Act and Assert
    assertEquals(Flag.MOVE, MobGoalHelper.paperToVanilla(GoalType.MOVE));
  }

  /**
   * Test {@link MobGoalHelper#paperToVanilla(GoalType)} with {@code type}.
   *
   * <ul>
   *   <li>When {@code TARGET}.
   *   <li>Then return {@code TARGET}.
   * </ul>
   *
   * <p>Method under test: {@link MobGoalHelper#paperToVanilla(GoalType)}
   */
  @Test
  @DisplayName("Test paperToVanilla(GoalType) with 'type'; when 'TARGET'; then return 'TARGET'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Flag MobGoalHelper.paperToVanilla(GoalType)"})
  void testPaperToVanillaWithType_whenTarget_thenReturnTarget() {
    // Arrange, Act and Assert
    assertEquals(Flag.TARGET, MobGoalHelper.paperToVanilla(GoalType.TARGET));
  }

  /**
   * Test {@link MobGoalHelper#paperToVanilla(GoalType)} with {@code type}.
   *
   * <ul>
   *   <li>When {@code UNKNOWN_BEHAVIOR}.
   *   <li>Then return {@code UNKNOWN_BEHAVIOR}.
   * </ul>
   *
   * <p>Method under test: {@link MobGoalHelper#paperToVanilla(GoalType)}
   */
  @Test
  @DisplayName(
      "Test paperToVanilla(GoalType) with 'type'; when 'UNKNOWN_BEHAVIOR'; then return 'UNKNOWN_BEHAVIOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Flag MobGoalHelper.paperToVanilla(GoalType)"})
  void testPaperToVanillaWithType_whenUnknownBehavior_thenReturnUnknownBehavior() {
    // Arrange, Act and Assert
    assertEquals(Flag.UNKNOWN_BEHAVIOR, MobGoalHelper.paperToVanilla(GoalType.UNKNOWN_BEHAVIOR));
  }

  /**
   * Test {@link MobGoalHelper#getKey(Class)}.
   *
   * <ul>
   *   <li>When {@code Goal}.
   * </ul>
   *
   * <p>Method under test: {@link MobGoalHelper#getKey(Class)}
   */
  @Test
  @DisplayName("Test getKey(Class); when 'net.minecraft.world.entity.ai.goal.Goal'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"com.destroystokyo.paper.entity.ai.GoalKey MobGoalHelper.getKey(Class)"})
  void testGetKey_whenNetMinecraftWorldEntityAiGoalGoal() {
    // Arrange
    Class<Goal> goalClass = Goal.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> MobGoalHelper.getKey(goalClass));
  }

  /**
   * Test {@link MobGoalHelper#toBukkitClass(Class)}.
   *
   * <ul>
   *   <li>When {@code net.minecraft.world.entity.Mob}.
   *   <li>Then return {@link Mob}.
   * </ul>
   *
   * <p>Method under test: {@link MobGoalHelper#toBukkitClass(Class)}
   */
  @Test
  @DisplayName("Test toBukkitClass(Class); when 'net.minecraft.world.entity.Mob'; then return Mob")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class MobGoalHelper.toBukkitClass(Class)"})
  void testToBukkitClass_whenNetMinecraftWorldEntityMob_thenReturnMob() {
    // Arrange
    Class<net.minecraft.world.entity.Mob> internalClass = net.minecraft.world.entity.Mob.class;

    // Act
    Class<? extends Mob> actualToBukkitClassResult = MobGoalHelper.toBukkitClass(internalClass);

    // Assert
    Class<Mob> expectedToBukkitClassResult = Mob.class;
    assertEquals(expectedToBukkitClassResult, actualToBukkitClassResult);
  }

  /**
   * Test {@link MobGoalHelper#toBukkitClass(Class)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link MobGoalHelper#toBukkitClass(Class)}
   */
  @Test
  @DisplayName("Test toBukkitClass(Class); when 'null'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class MobGoalHelper.toBukkitClass(Class)"})
  void testToBukkitClass_whenNull_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> MobGoalHelper.toBukkitClass(null));
  }
}

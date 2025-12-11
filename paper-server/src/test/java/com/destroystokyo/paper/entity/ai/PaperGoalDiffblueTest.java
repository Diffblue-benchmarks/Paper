package com.destroystokyo.paper.entity.ai;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.EnumSet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BegGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.CatLieOnBedGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Wolf;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PaperGoalDiffblueTest {
  /**
   * Test {@link PaperGoal#PaperGoal(Goal)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return Types Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperGoal#PaperGoal(Goal)}
   */
  @Test
  @DisplayName("Test new PaperGoal(Goal); given 'false'; then return Types Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperGoal.<init>(Goal)"})
  void testNewPaperGoal_givenFalse_thenReturnTypesEmpty() {
    // Arrange
    AvoidEntityGoal<LivingEntity> handle = mock(AvoidEntityGoal.class);
    when(handle.hasFlag(Mockito.<Flag>any())).thenReturn(false);

    // Act
    PaperGoal<Mob> actualPaperGoal = new PaperGoal<>(handle);

    // Assert
    verify(handle, atLeast(1)).hasFlag(Mockito.<Flag>any());
    GoalKey<Mob> key = actualPaperGoal.getKey();
    assertEquals("avoid_entity", key.getNamespacedKey().getKey());
    assertTrue(actualPaperGoal.getTypes().isEmpty());
    Class<Creature> expectedEntityClass = Creature.class;
    assertEquals(expectedEntityClass, key.getEntityClass());
    assertSame(handle, actualPaperGoal.getHandle());
  }

  /**
   * Test {@link PaperGoal#PaperGoal(Goal)}.
   *
   * <ul>
   *   <li>Then return Key NamespacedKey Key is {@code avoid_entity}.
   * </ul>
   *
   * <p>Method under test: {@link PaperGoal#PaperGoal(Goal)}
   */
  @Test
  @DisplayName("Test new PaperGoal(Goal); then return Key NamespacedKey Key is 'avoid_entity'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperGoal.<init>(Goal)"})
  void testNewPaperGoal_thenReturnKeyNamespacedKeyKeyIsAvoidEntity() {
    // Arrange
    AvoidEntityGoal<LivingEntity> handle = mock(AvoidEntityGoal.class);
    when(handle.hasFlag(Mockito.<Flag>any())).thenReturn(true);

    // Act
    PaperGoal<Mob> actualPaperGoal = new PaperGoal<>(handle);

    // Assert
    verify(handle, atLeast(1)).hasFlag(Mockito.<Flag>any());
    GoalKey<Mob> key = actualPaperGoal.getKey();
    assertEquals("avoid_entity", key.getNamespacedKey().getKey());
    EnumSet<GoalType> types = actualPaperGoal.getTypes();
    assertEquals(5, types.size());
    assertTrue(types.contains(GoalType.JUMP));
    assertTrue(types.contains(GoalType.LOOK));
    assertTrue(types.contains(GoalType.MOVE));
    assertTrue(types.contains(GoalType.TARGET));
    assertTrue(types.contains(GoalType.UNKNOWN_BEHAVIOR));
    Class<Creature> expectedEntityClass = Creature.class;
    assertEquals(expectedEntityClass, key.getEntityClass());
    assertSame(handle, actualPaperGoal.getHandle());
  }

  /**
   * Test {@link PaperGoal#PaperGoal(Goal)}.
   *
   * <ul>
   *   <li>Then return Key NamespacedKey Key is {@code breed}.
   * </ul>
   *
   * <p>Method under test: {@link PaperGoal#PaperGoal(Goal)}
   */
  @Test
  @DisplayName("Test new PaperGoal(Goal); then return Key NamespacedKey Key is 'breed'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperGoal.<init>(Goal)"})
  void testNewPaperGoal_thenReturnKeyNamespacedKeyKeyIsBreed() {
    // Arrange
    BreedGoal handle = mock(BreedGoal.class);
    when(handle.hasFlag(Mockito.<Flag>any())).thenReturn(true);

    // Act
    PaperGoal<Mob> actualPaperGoal = new PaperGoal<>(handle);

    // Assert
    verify(handle, atLeast(1)).hasFlag(Mockito.<Flag>any());
    GoalKey<Mob> key = actualPaperGoal.getKey();
    assertEquals("breed", key.getNamespacedKey().getKey());
    EnumSet<GoalType> types = actualPaperGoal.getTypes();
    assertEquals(5, types.size());
    assertTrue(types.contains(GoalType.JUMP));
    assertTrue(types.contains(GoalType.LOOK));
    assertTrue(types.contains(GoalType.MOVE));
    assertTrue(types.contains(GoalType.TARGET));
    assertTrue(types.contains(GoalType.UNKNOWN_BEHAVIOR));
    Class<Animals> expectedEntityClass = Animals.class;
    assertEquals(expectedEntityClass, key.getEntityClass());
    assertSame(handle, actualPaperGoal.getHandle());
  }

  /**
   * Test {@link PaperGoal#PaperGoal(Goal)}.
   *
   * <ul>
   *   <li>Then return Key NamespacedKey Key is {@code cat_lie_on_bed}.
   * </ul>
   *
   * <p>Method under test: {@link PaperGoal#PaperGoal(Goal)}
   */
  @Test
  @DisplayName("Test new PaperGoal(Goal); then return Key NamespacedKey Key is 'cat_lie_on_bed'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperGoal.<init>(Goal)"})
  void testNewPaperGoal_thenReturnKeyNamespacedKeyKeyIsCatLieOnBed() {
    // Arrange
    CatLieOnBedGoal handle = mock(CatLieOnBedGoal.class);
    when(handle.hasFlag(Mockito.<Flag>any())).thenReturn(true);

    // Act
    PaperGoal<Mob> actualPaperGoal = new PaperGoal<>(handle);

    // Assert
    verify(handle, atLeast(1)).hasFlag(Mockito.<Flag>any());
    GoalKey<Mob> key = actualPaperGoal.getKey();
    assertEquals("cat_lie_on_bed", key.getNamespacedKey().getKey());
    EnumSet<GoalType> types = actualPaperGoal.getTypes();
    assertEquals(5, types.size());
    assertTrue(types.contains(GoalType.JUMP));
    assertTrue(types.contains(GoalType.LOOK));
    assertTrue(types.contains(GoalType.MOVE));
    assertTrue(types.contains(GoalType.TARGET));
    assertTrue(types.contains(GoalType.UNKNOWN_BEHAVIOR));
    Class<Cat> expectedEntityClass = Cat.class;
    assertEquals(expectedEntityClass, key.getEntityClass());
    assertSame(handle, actualPaperGoal.getHandle());
  }

  /**
   * Test {@link PaperGoal#PaperGoal(Goal)}.
   *
   * <ul>
   *   <li>Then return Key NamespacedKey Key is {@code wolf_beg}.
   * </ul>
   *
   * <p>Method under test: {@link PaperGoal#PaperGoal(Goal)}
   */
  @Test
  @DisplayName("Test new PaperGoal(Goal); then return Key NamespacedKey Key is 'wolf_beg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperGoal.<init>(Goal)"})
  void testNewPaperGoal_thenReturnKeyNamespacedKeyKeyIsWolfBeg() {
    // Arrange
    BegGoal handle = mock(BegGoal.class);
    when(handle.hasFlag(Mockito.<Flag>any())).thenReturn(true);

    // Act
    PaperGoal<Mob> actualPaperGoal = new PaperGoal<>(handle);

    // Assert
    verify(handle, atLeast(1)).hasFlag(Mockito.<Flag>any());
    GoalKey<Mob> key = actualPaperGoal.getKey();
    assertEquals("wolf_beg", key.getNamespacedKey().getKey());
    EnumSet<GoalType> types = actualPaperGoal.getTypes();
    assertEquals(5, types.size());
    assertTrue(types.contains(GoalType.JUMP));
    assertTrue(types.contains(GoalType.LOOK));
    assertTrue(types.contains(GoalType.MOVE));
    assertTrue(types.contains(GoalType.TARGET));
    assertTrue(types.contains(GoalType.UNKNOWN_BEHAVIOR));
    Class<Wolf> expectedEntityClass = Wolf.class;
    assertEquals(expectedEntityClass, key.getEntityClass());
    assertSame(handle, actualPaperGoal.getHandle());
  }

  /**
   * Test {@link PaperGoal#shouldActivate()}.
   *
   * <ul>
   *   <li>Given {@link AvoidEntityGoal} {@link AvoidEntityGoal#canUse()} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperGoal#shouldActivate()}
   */
  @Test
  @DisplayName(
      "Test shouldActivate(); given AvoidEntityGoal canUse() return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperGoal.shouldActivate()"})
  void testShouldActivate_givenAvoidEntityGoalCanUseReturnFalse_thenReturnFalse() {
    // Arrange
    AvoidEntityGoal<LivingEntity> handle = mock(AvoidEntityGoal.class);
    when(handle.canUse()).thenReturn(false);
    when(handle.hasFlag(Mockito.<Flag>any())).thenReturn(true);
    PaperGoal<Mob> paperGoal = new PaperGoal<>(handle);

    // Act
    boolean actualShouldActivateResult = paperGoal.shouldActivate();

    // Assert
    verify(handle).canUse();
    verify(handle, atLeast(1)).hasFlag(Mockito.<Flag>any());
    assertFalse(actualShouldActivateResult);
  }

  /**
   * Test {@link PaperGoal#shouldActivate()}.
   *
   * <ul>
   *   <li>Given {@link AvoidEntityGoal} {@link AvoidEntityGoal#canUse()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperGoal#shouldActivate()}
   */
  @Test
  @DisplayName(
      "Test shouldActivate(); given AvoidEntityGoal canUse() return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperGoal.shouldActivate()"})
  void testShouldActivate_givenAvoidEntityGoalCanUseReturnTrue_thenReturnTrue() {
    // Arrange
    AvoidEntityGoal<LivingEntity> handle = mock(AvoidEntityGoal.class);
    when(handle.canUse()).thenReturn(true);
    when(handle.hasFlag(Mockito.<Flag>any())).thenReturn(true);
    PaperGoal<Mob> paperGoal = new PaperGoal<>(handle);

    // Act
    boolean actualShouldActivateResult = paperGoal.shouldActivate();

    // Assert
    verify(handle).canUse();
    verify(handle, atLeast(1)).hasFlag(Mockito.<Flag>any());
    assertTrue(actualShouldActivateResult);
  }

  /**
   * Test {@link PaperGoal#shouldStayActive()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperGoal#shouldStayActive()}
   */
  @Test
  @DisplayName("Test shouldStayActive(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperGoal.shouldStayActive()"})
  void testShouldStayActive_thenReturnFalse() {
    // Arrange
    AvoidEntityGoal<LivingEntity> handle = mock(AvoidEntityGoal.class);
    when(handle.canContinueToUse()).thenReturn(false);
    when(handle.hasFlag(Mockito.<Flag>any())).thenReturn(true);
    PaperGoal<Mob> paperGoal = new PaperGoal<>(handle);

    // Act
    boolean actualShouldStayActiveResult = paperGoal.shouldStayActive();

    // Assert
    verify(handle).canContinueToUse();
    verify(handle, atLeast(1)).hasFlag(Mockito.<Flag>any());
    assertFalse(actualShouldStayActiveResult);
  }

  /**
   * Test {@link PaperGoal#shouldStayActive()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperGoal#shouldStayActive()}
   */
  @Test
  @DisplayName("Test shouldStayActive(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperGoal.shouldStayActive()"})
  void testShouldStayActive_thenReturnTrue() {
    // Arrange
    AvoidEntityGoal<LivingEntity> handle = mock(AvoidEntityGoal.class);
    when(handle.canContinueToUse()).thenReturn(true);
    when(handle.hasFlag(Mockito.<Flag>any())).thenReturn(true);
    PaperGoal<Mob> paperGoal = new PaperGoal<>(handle);

    // Act
    boolean actualShouldStayActiveResult = paperGoal.shouldStayActive();

    // Assert
    verify(handle).canContinueToUse();
    verify(handle, atLeast(1)).hasFlag(Mockito.<Flag>any());
    assertTrue(actualShouldStayActiveResult);
  }

  /**
   * Test {@link PaperGoal#start()}.
   *
   * <ul>
   *   <li>Given {@link AvoidEntityGoal} {@link AvoidEntityGoal#hasFlag(Flag)} return {@code true}.
   *   <li>Then calls {@link AvoidEntityGoal#start()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperGoal#start()}
   */
  @Test
  @DisplayName(
      "Test start(); given AvoidEntityGoal hasFlag(Flag) return 'true'; then calls start()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperGoal.start()"})
  void testStart_givenAvoidEntityGoalHasFlagReturnTrue_thenCallsStart() {
    // Arrange
    AvoidEntityGoal<LivingEntity> handle = mock(AvoidEntityGoal.class);
    when(handle.hasFlag(Mockito.<Flag>any())).thenReturn(true);
    doNothing().when(handle).start();
    PaperGoal<Mob> paperGoal = new PaperGoal<>(handle);

    // Act
    paperGoal.start();

    // Assert
    verify(handle).start();
    verify(handle, atLeast(1)).hasFlag(Mockito.<Flag>any());
  }

  /**
   * Test {@link PaperGoal#stop()}.
   *
   * <ul>
   *   <li>Given {@link AvoidEntityGoal} {@link AvoidEntityGoal#hasFlag(Flag)} return {@code true}.
   *   <li>Then calls {@link AvoidEntityGoal#stop()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperGoal#stop()}
   */
  @Test
  @DisplayName("Test stop(); given AvoidEntityGoal hasFlag(Flag) return 'true'; then calls stop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperGoal.stop()"})
  void testStop_givenAvoidEntityGoalHasFlagReturnTrue_thenCallsStop() {
    // Arrange
    AvoidEntityGoal<LivingEntity> handle = mock(AvoidEntityGoal.class);
    when(handle.hasFlag(Mockito.<Flag>any())).thenReturn(true);
    doNothing().when(handle).stop();
    PaperGoal<Mob> paperGoal = new PaperGoal<>(handle);

    // Act
    paperGoal.stop();

    // Assert
    verify(handle).stop();
    verify(handle, atLeast(1)).hasFlag(Mockito.<Flag>any());
  }

  /**
   * Test {@link PaperGoal#tick()}.
   *
   * <ul>
   *   <li>Given {@link AvoidEntityGoal} {@link AvoidEntityGoal#hasFlag(Flag)} return {@code true}.
   *   <li>Then calls {@link AvoidEntityGoal#tick()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperGoal#tick()}
   */
  @Test
  @DisplayName("Test tick(); given AvoidEntityGoal hasFlag(Flag) return 'true'; then calls tick()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperGoal.tick()"})
  void testTick_givenAvoidEntityGoalHasFlagReturnTrue_thenCallsTick() {
    // Arrange
    AvoidEntityGoal<LivingEntity> handle = mock(AvoidEntityGoal.class);
    when(handle.hasFlag(Mockito.<Flag>any())).thenReturn(true);
    doNothing().when(handle).tick();
    PaperGoal<Mob> paperGoal = new PaperGoal<>(handle);

    // Act
    paperGoal.tick();

    // Assert
    verify(handle).tick();
    verify(handle, atLeast(1)).hasFlag(Mockito.<Flag>any());
  }
}

package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityEffectDiffblueTest {
  /**
   * Test {@link EntityEffect#isApplicableTo(Entity)} with {@code entity}.
   *
   * <ul>
   *   <li>Given {@code ARROW_PARTICLES}.
   *   <li>When {@link Entity}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityEffect#isApplicableTo(Entity)}
   */
  @Test
  @DisplayName(
      "Test isApplicableTo(Entity) with 'entity'; given 'ARROW_PARTICLES'; when Entity; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityEffect.isApplicableTo(Entity)"})
  void testIsApplicableToWithEntity_givenArrowParticles_whenEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(EntityEffect.ARROW_PARTICLES.isApplicableTo(mock(Entity.class)));
  }

  /**
   * Test {@link EntityEffect#isApplicableTo(Entity)} with {@code entity}.
   *
   * <ul>
   *   <li>Given {@code DEATH}.
   *   <li>When {@link Entity}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityEffect#isApplicableTo(Entity)}
   */
  @Test
  @DisplayName(
      "Test isApplicableTo(Entity) with 'entity'; given 'DEATH'; when Entity; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityEffect.isApplicableTo(Entity)"})
  void testIsApplicableToWithEntity_givenDeath_whenEntity_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EntityEffect.DEATH.isApplicableTo(mock(Entity.class)));
  }
}

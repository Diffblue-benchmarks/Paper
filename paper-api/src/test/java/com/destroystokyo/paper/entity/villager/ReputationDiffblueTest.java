package com.destroystokyo.paper.entity.villager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReputationDiffblueTest {
  /**
   * Test {@link Reputation#Reputation()}.
   *
   * <p>Method under test: {@link Reputation#Reputation()}
   */
  @Test
  @DisplayName("Test new Reputation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Reputation.<init>()"})
  void testNewReputation() {
    // Arrange and Act
    Reputation actualReputation = new Reputation();

    // Assert
    assertEquals(0, actualReputation.getReputation(ReputationType.MAJOR_NEGATIVE));
    assertFalse(actualReputation.hasReputationSet(ReputationType.MAJOR_NEGATIVE));
  }

  /**
   * Test {@link Reputation#Reputation(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Reputation is {@code MAJOR_NEGATIVE} is zero.
   * </ul>
   *
   * <p>Method under test: {@link Reputation#Reputation(Map)}
   */
  @Test
  @DisplayName(
      "Test new Reputation(Map); when HashMap(); then return Reputation is 'MAJOR_NEGATIVE' is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Reputation.<init>(Map)"})
  void testNewReputation_whenHashMap_thenReturnReputationIsMajorNegativeIsZero() {
    // Arrange and Act
    Reputation actualReputation = new Reputation(new HashMap<>());

    // Assert
    assertEquals(0, actualReputation.getReputation(ReputationType.MAJOR_NEGATIVE));
    assertFalse(actualReputation.hasReputationSet(ReputationType.MAJOR_NEGATIVE));
  }

  /**
   * Test {@link Reputation#getReputation(ReputationType)}.
   *
   * <ul>
   *   <li>Given {@link Reputation#Reputation()}.
   *   <li>When {@code MAJOR_NEGATIVE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Reputation#getReputation(ReputationType)}
   */
  @Test
  @DisplayName(
      "Test getReputation(ReputationType); given Reputation(); when 'MAJOR_NEGATIVE'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Reputation.getReputation(ReputationType)"})
  void testGetReputation_givenReputation_whenMajorNegative_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new Reputation().getReputation(ReputationType.MAJOR_NEGATIVE));
  }

  /**
   * Test {@link Reputation#setReputation(ReputationType, int)}.
   *
   * <ul>
   *   <li>Then {@link Reputation#Reputation()} Reputation is {@code MAJOR_NEGATIVE} is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Reputation#setReputation(ReputationType, int)}
   */
  @Test
  @DisplayName(
      "Test setReputation(ReputationType, int); then Reputation() Reputation is 'MAJOR_NEGATIVE' is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Reputation.setReputation(ReputationType, int)"})
  void testSetReputation_thenReputationReputationIsMajorNegativeIsFortyTwo() {
    // Arrange
    Reputation reputation = new Reputation();

    // Act
    reputation.setReputation(ReputationType.MAJOR_NEGATIVE, 42);

    // Assert
    assertEquals(42, reputation.getReputation(ReputationType.MAJOR_NEGATIVE));
    assertTrue(reputation.hasReputationSet(ReputationType.MAJOR_NEGATIVE));
  }

  /**
   * Test {@link Reputation#hasReputationSet(ReputationType)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code MAJOR_NEGATIVE} is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Reputation#hasReputationSet(ReputationType)}
   */
  @Test
  @DisplayName(
      "Test hasReputationSet(ReputationType); given HashMap() 'MAJOR_NEGATIVE' is one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Reputation.hasReputationSet(ReputationType)"})
  void testHasReputationSet_givenHashMapMajorNegativeIsOne_thenReturnTrue() {
    // Arrange
    HashMap<ReputationType, Integer> reputation = new HashMap<>();
    reputation.put(ReputationType.MAJOR_NEGATIVE, 1);

    // Act and Assert
    assertTrue(new Reputation(reputation).hasReputationSet(ReputationType.MAJOR_NEGATIVE));
  }

  /**
   * Test {@link Reputation#hasReputationSet(ReputationType)}.
   *
   * <ul>
   *   <li>Given {@link Reputation#Reputation()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Reputation#hasReputationSet(ReputationType)}
   */
  @Test
  @DisplayName("Test hasReputationSet(ReputationType); given Reputation(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Reputation.hasReputationSet(ReputationType)"})
  void testHasReputationSet_givenReputation_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Reputation().hasReputationSet(ReputationType.MAJOR_NEGATIVE));
  }
}

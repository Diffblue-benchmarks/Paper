package io.papermc.paper.command.brigadier.argument.predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.command.brigadier.argument.predicate.BlockInWorldPredicate.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockInWorldPredicateDiffblueTest {
  /**
   * Test Result {@link Result#asBoolean()}.
   *
   * <ul>
   *   <li>Given {@code FALSE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Result#asBoolean()}
   */
  @Test
  @DisplayName("Test Result asBoolean(); given 'FALSE'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Result.asBoolean()"})
  void testResultAsBoolean_givenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Result.FALSE.asBoolean());
  }

  /**
   * Test Result {@link Result#asBoolean()}.
   *
   * <ul>
   *   <li>Given {@code TRUE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Result#asBoolean()}
   */
  @Test
  @DisplayName("Test Result asBoolean(); given 'TRUE'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Result.asBoolean()"})
  void testResultAsBoolean_givenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Result.TRUE.asBoolean());
  }
}

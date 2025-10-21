package org.bukkit.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PistonMoveReactionDiffblueTest {
  /**
   * Test {@link PistonMoveReaction#getId()}.
   *
   * <p>Method under test: {@link PistonMoveReaction#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PistonMoveReaction.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertEquals(0, PistonMoveReaction.valueOf("MOVE").getId());
  }

  /**
   * Test {@link PistonMoveReaction#getById(int)}.
   *
   * <p>Method under test: {@link PistonMoveReaction#getById(int)}
   */
  @Test
  @DisplayName("Test getById(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PistonMoveReaction PistonMoveReaction.getById(int)"})
  void testGetById() {
    // Arrange, Act and Assert
    assertEquals(PistonMoveReaction.BREAK, PistonMoveReaction.getById(1));
  }
}

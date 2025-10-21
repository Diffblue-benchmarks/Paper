package org.bukkit.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Panda.Gene;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PandaDiffblueTest {
  /**
   * Test Gene {@link Gene#isRecessive()}.
   *
   * <p>Method under test: {@link Gene#isRecessive()}
   */
  @Test
  @DisplayName("Test Gene isRecessive()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Gene.isRecessive()"})
  void testGeneIsRecessive() {
    // Arrange, Act and Assert
    assertFalse(Gene.valueOf("NORMAL").isRecessive());
  }
}

package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EffectDiffblueTest {
  /**
   * Test {@link Effect#getById(int)}.
   *
   * <p>Method under test: {@link Effect#getById(int)}
   */
  @Test
  @DisplayName("Test getById(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Effect Effect.getById(int)"})
  void testGetById() {
    // Arrange, Act and Assert
    assertNull(Effect.getById(1));
  }
}

package org.bukkit.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Ocelot.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OcelotDiffblueTest {
  /**
   * Test Type {@link Type#getId()}.
   *
   * <p>Method under test: {@link Type#getId()}
   */
  @Test
  @DisplayName("Test Type getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type.getId()"})
  void testTypeGetId() {
    // Arrange, Act and Assert
    assertEquals(0, Type.valueOf("WILD_OCELOT").getId());
  }

  /**
   * Test Type {@link Type#getType(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type#getType(int)}
   */
  @Test
  @DisplayName("Test Type getType(int); when four; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Type Type.getType(int)"})
  void testTypeGetType_whenFour_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Type.getType(4));
  }

  /**
   * Test Type {@link Type#getType(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code BLACK_CAT}.
   * </ul>
   *
   * <p>Method under test: {@link Type#getType(int)}
   */
  @Test
  @DisplayName("Test Type getType(int); when one; then return 'BLACK_CAT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Type Type.getType(int)"})
  void testTypeGetType_whenOne_thenReturnBlackCat() {
    // Arrange, Act and Assert
    assertEquals(Type.BLACK_CAT, Type.getType(1));
  }
}

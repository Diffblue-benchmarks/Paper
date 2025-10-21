package ca.spottedleaf.moonrise.common.misc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SingleUserAreaMapDiffblueTest {
  /**
   * Test {@link SingleUserAreaMap#sign(int)}.
   *
   * <p>Method under test: {@link SingleUserAreaMap#sign(int)}
   */
  @Test
  @DisplayName("Test sign(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SingleUserAreaMap.sign(int)"})
  void testSign() {
    // Arrange, Act and Assert
    assertEquals(1, SingleUserAreaMap.sign(42));
  }
}

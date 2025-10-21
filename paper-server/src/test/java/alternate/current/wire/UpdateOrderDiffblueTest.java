package alternate.current.wire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UpdateOrderDiffblueTest {
  /**
   * Test {@link UpdateOrder#byId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateOrder#byId(String)}
   */
  @Test
  @DisplayName("Test byId(String); when '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UpdateOrder UpdateOrder.byId(String)"})
  void testById_when42_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> UpdateOrder.byId("42"));
  }

  /**
   * Test {@link UpdateOrder#byId(String)}.
   *
   * <ul>
   *   <li>When {@code HORIZONTAL_FIRST_INWARD}.
   *   <li>Then return {@code HORIZONTAL_FIRST_INWARD}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateOrder#byId(String)}
   */
  @Test
  @DisplayName(
      "Test byId(String); when 'HORIZONTAL_FIRST_INWARD'; then return 'HORIZONTAL_FIRST_INWARD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UpdateOrder UpdateOrder.byId(String)"})
  void testById_whenHorizontalFirstInward_thenReturnHorizontalFirstInward() {
    // Arrange, Act and Assert
    assertEquals(UpdateOrder.HORIZONTAL_FIRST_INWARD, UpdateOrder.byId("HORIZONTAL_FIRST_INWARD"));
  }
}

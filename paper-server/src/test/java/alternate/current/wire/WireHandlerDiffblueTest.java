package alternate.current.wire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import alternate.current.wire.WireHandler.Directions;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.core.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WireHandlerDiffblueTest {
  /**
   * Test Directions {@link Directions#iOpposite(int)}.
   *
   * <p>Method under test: {@link Directions#iOpposite(int)}
   */
  @Test
  @DisplayName("Test Directions iOpposite(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Directions.iOpposite(int)"})
  void testDirectionsIOpposite() {
    // Arrange, Act and Assert
    assertEquals(3, Directions.iOpposite(1));
  }

  /**
   * Test Directions {@link Directions#index(Direction)}.
   *
   * <p>Method under test: {@link Directions#index(Direction)}
   */
  @Test
  @DisplayName("Test Directions index(Direction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Directions.index(Direction)"})
  void testDirectionsIndex() {
    // Arrange, Act and Assert
    assertEquals(4, Directions.index(Direction.DOWN));
  }
}

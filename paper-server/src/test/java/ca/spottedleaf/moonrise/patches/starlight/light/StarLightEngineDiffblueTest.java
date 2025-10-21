package ca.spottedleaf.moonrise.patches.starlight.light;

import static org.junit.jupiter.api.Assertions.assertEquals;
import ca.spottedleaf.moonrise.patches.starlight.light.StarLightEngine.AxisDirection;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StarLightEngineDiffblueTest {
  /**
   * Test AxisDirection {@link AxisDirection#getOpposite()}.
   *
   * <p>Method under test: {@link AxisDirection#getOpposite()}
   */
  @Test
  @DisplayName("Test AxisDirection getOpposite()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AxisDirection AxisDirection.getOpposite()"})
  void testAxisDirectionGetOpposite() {
    // Arrange, Act and Assert
    assertEquals(AxisDirection.NEGATIVE_X, AxisDirection.valueOf("POSITIVE_X").getOpposite());
  }
}

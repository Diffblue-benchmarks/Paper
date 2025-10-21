package ca.spottedleaf.moonrise.patches.starlight.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SaveUtilDiffblueTest {
  /**
   * Test {@link SaveUtil#getLightVersion()}.
   *
   * <p>Method under test: {@link SaveUtil#getLightVersion()}
   */
  @Test
  @DisplayName("Test getLightVersion()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SaveUtil.getLightVersion()"})
  void testGetLightVersion() {
    // Arrange, Act and Assert
    assertEquals(SaveUtil.STARLIGHT_LIGHT_VERSION, SaveUtil.getLightVersion());
  }
}

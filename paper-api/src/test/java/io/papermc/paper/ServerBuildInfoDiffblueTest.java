package io.papermc.paper;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerBuildInfoDiffblueTest {
  /**
   * Test {@link ServerBuildInfo#buildInfo()}.
   *
   * <p>Method under test: {@link ServerBuildInfo#buildInfo()}
   */
  @Test
  @DisplayName("Test buildInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ServerBuildInfo ServerBuildInfo.buildInfo()"})
  void testBuildInfo() {
    // Arrange, Act and Assert
    assertTrue(ServerBuildInfo.buildInfo() instanceof TestServerBuildInfo);
  }
}

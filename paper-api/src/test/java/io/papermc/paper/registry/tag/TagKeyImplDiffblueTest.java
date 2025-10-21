package io.papermc.paper.registry.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.ServerBuildInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TagKeyImplDiffblueTest {
  /**
   * Test {@link TagKeyImpl#toString()}.
   *
   * <p>Method under test: {@link TagKeyImpl#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TagKeyImpl.toString()"})
  void testToString() {
    // Arrange
    TagKeyImpl<Object> tagKeyImpl = new TagKeyImpl<>(null, ServerBuildInfo.BRAND_PAPER_ID);

    // Act and Assert
    assertEquals("#papermc:paper (in null)", tagKeyImpl.toString());
  }
}

package io.papermc.paper.datapack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DatapackSourceImplDiffblueTest {
  /**
   * Test {@link DatapackSourceImpl#toString()}.
   *
   * <p>Method under test: {@link DatapackSourceImpl#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String DatapackSourceImpl.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("Name", new DatapackSourceImpl("Name").toString());
  }
}

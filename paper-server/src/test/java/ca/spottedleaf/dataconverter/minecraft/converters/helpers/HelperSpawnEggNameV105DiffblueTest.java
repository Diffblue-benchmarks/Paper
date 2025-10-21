package ca.spottedleaf.dataconverter.minecraft.converters.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HelperSpawnEggNameV105DiffblueTest {
  /**
   * Test {@link HelperSpawnEggNameV105#getSpawnNameFromId(short)}.
   *
   * <p>Method under test: {@link HelperSpawnEggNameV105#getSpawnNameFromId(short)}
   */
  @Test
  @DisplayName("Test getSpawnNameFromId(short)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String HelperSpawnEggNameV105.getSpawnNameFromId(short)"})
  void testGetSpawnNameFromId() {
    // Arrange, Act and Assert
    assertEquals("Item", HelperSpawnEggNameV105.getSpawnNameFromId((short) 1));
  }
}

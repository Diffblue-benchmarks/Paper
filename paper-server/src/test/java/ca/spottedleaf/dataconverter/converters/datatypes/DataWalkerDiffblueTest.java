package ca.spottedleaf.dataconverter.converters.datatypes;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class DataWalkerDiffblueTest {
  /**
   * Test {@link DataWalker#noOp()}.
   *
   * <p>Method under test: {@link DataWalker#noOp()}
   */
  @Test
  @DisplayName("Test noOp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWalker DataWalker.noOp()"})
  void testNoOp() {
    // Arrange and Act
    DataWalker<Object> actualNoOpResult = DataWalker.noOp();

    // Assert
    assertNull(actualNoOpResult.walk(ConfigurationTransformation.WILDCARD_OBJECT, 1L, 1L));
  }
}

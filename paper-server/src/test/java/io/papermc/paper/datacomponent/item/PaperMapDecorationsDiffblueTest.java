package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.MapDecorations.Builder;
import io.papermc.paper.datacomponent.item.PaperMapDecorations.BuilderImpl;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperMapDecorationsDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#putAll(Map)}.
   *
   * <p>Method under test: {@link BuilderImpl#putAll(Map)}
   */
  @Test
  @DisplayName("Test BuilderImpl putAll(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.putAll(Map)"})
  void testBuilderImplPutAll() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualPutAllResult = builderImpl.putAll(new HashMap<>());

    // Assert
    assertTrue(actualPutAllResult instanceof BuilderImpl);
    assertSame(builderImpl, actualPutAllResult);
  }
}

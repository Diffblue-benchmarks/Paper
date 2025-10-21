package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.PaperSuspiciousStewEffects.BuilderImpl;
import io.papermc.paper.datacomponent.item.SuspiciousStewEffects.Builder;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperSuspiciousStewEffectsDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#addAll(Collection)}.
   *
   * <p>Method under test: {@link BuilderImpl#addAll(Collection)}
   */
  @Test
  @DisplayName("Test BuilderImpl addAll(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addAll(Collection)"})
  void testBuilderImplAddAll() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddAllResult = builderImpl.addAll(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllResult instanceof BuilderImpl);
    assertSame(builderImpl, actualAddAllResult);
  }
}

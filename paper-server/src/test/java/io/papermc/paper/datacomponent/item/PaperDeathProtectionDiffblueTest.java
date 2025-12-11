package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.DeathProtection.Builder;
import io.papermc.paper.datacomponent.item.PaperDeathProtection.BuilderImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperDeathProtectionDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#addEffects(List)}.
   *
   * <p>Method under test: {@link BuilderImpl#addEffects(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl addEffects(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addEffects(List)"})
  void testBuilderImplAddEffects() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddEffectsResult = builderImpl.addEffects(new ArrayList<>());

    // Assert
    assertTrue(actualAddEffectsResult instanceof BuilderImpl);
    assertSame(builderImpl, actualAddEffectsResult);
  }
}

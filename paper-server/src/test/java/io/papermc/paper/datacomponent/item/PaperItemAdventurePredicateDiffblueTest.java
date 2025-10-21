package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.ItemAdventurePredicate.Builder;
import io.papermc.paper.datacomponent.item.PaperItemAdventurePredicate.BuilderImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperItemAdventurePredicateDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#addPredicates(List)}.
   *
   * <p>Method under test: {@link BuilderImpl#addPredicates(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl addPredicates(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addPredicates(List)"})
  void testBuilderImplAddPredicates() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddPredicatesResult = builderImpl.addPredicates(new ArrayList<>());

    // Assert
    assertTrue(actualAddPredicatesResult instanceof BuilderImpl);
    assertSame(builderImpl, actualAddPredicatesResult);
  }
}

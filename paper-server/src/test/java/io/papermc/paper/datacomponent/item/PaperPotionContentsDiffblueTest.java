package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.PaperPotionContents.BuilderImpl;
import io.papermc.paper.datacomponent.item.PotionContents.Builder;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperPotionContentsDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#addCustomEffects(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link BuilderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addCustomEffects(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl addCustomEffects(List); when ArrayList(); then return BuilderImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addCustomEffects(List)"})
  void testBuilderImplAddCustomEffects_whenArrayList_thenReturnBuilderImpl() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddCustomEffectsResult = builderImpl.addCustomEffects(new ArrayList<>());

    // Assert
    assertTrue(actualAddCustomEffectsResult instanceof BuilderImpl);
    assertSame(builderImpl, actualAddCustomEffectsResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#customName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#customName(String)}
   */
  @Test
  @DisplayName("Test BuilderImpl customName(String); when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.customName(String)"})
  void testBuilderImplCustomName_whenName() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualCustomNameResult = builderImpl.customName("Name");

    // Assert
    assertTrue(actualCustomNameResult instanceof BuilderImpl);
    assertSame(builderImpl, actualCustomNameResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#customName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#customName(String)}
   */
  @Test
  @DisplayName("Test BuilderImpl customName(String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.customName(String)"})
  void testBuilderImplCustomName_whenNull() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualCustomNameResult = builderImpl.customName(null);

    // Assert
    assertTrue(actualCustomNameResult instanceof BuilderImpl);
    assertSame(builderImpl, actualCustomNameResult);
  }
}

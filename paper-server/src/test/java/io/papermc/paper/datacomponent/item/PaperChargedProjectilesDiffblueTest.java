package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.ChargedProjectiles.Builder;
import io.papermc.paper.datacomponent.item.PaperChargedProjectiles.BuilderImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperChargedProjectilesDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#addAll(List)}.
   *
   * <p>Method under test: {@link BuilderImpl#addAll(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl addAll(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addAll(List)"})
  void testBuilderImplAddAll() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddAllResult = builderImpl.addAll(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllResult instanceof BuilderImpl);
    assertSame(builderImpl, actualAddAllResult);
  }

  /**
   * Test {@link PaperChargedProjectiles#getHandle()}.
   *
   * <p>Method under test: {@link PaperChargedProjectiles#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.world.item.component.ChargedProjectiles PaperChargedProjectiles.getHandle()"
  })
  void testGetHandle() {
    // Arrange, Act and Assert
    assertNull(new PaperChargedProjectiles(null).getHandle());
  }
}

package io.papermc.paper.adventure.providers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.adventure.BossBarImplementationImpl;
import java.util.Set;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.bossbar.BossBarImplementation;
import net.kyori.adventure.bossbar.BossBarViewer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BossBarImplementationProviderDiffblueTest {
  /**
   * Test {@link BossBarImplementationProvider#create(BossBar)}.
   *
   * <p>Method under test: {@link BossBarImplementationProvider#create(BossBar)}
   */
  @Test
  @DisplayName("Test create(BossBar)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BossBarImplementation BossBarImplementationProvider.create(BossBar)"})
  void testCreate() {
    // Arrange and Act
    BossBarImplementation actualCreateResult =
        new BossBarImplementationProvider().create(mock(BossBar.class));

    // Assert
    assertTrue(actualCreateResult instanceof BossBarImplementationImpl);
    Iterable<? extends BossBarViewer> viewersResult = actualCreateResult.viewers();
    assertTrue(viewersResult instanceof Set);
    assertTrue(((Set<? extends BossBarViewer>) viewersResult).isEmpty());
  }
}

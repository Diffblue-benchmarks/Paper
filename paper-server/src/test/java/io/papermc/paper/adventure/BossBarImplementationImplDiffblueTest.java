package io.papermc.paper.adventure;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import java.util.Set;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.bossbar.BossBarViewer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BossBarImplementationImplDiffblueTest {
  /**
   * Test {@link BossBarImplementationImpl#viewers()}.
   *
   * <p>Method under test: {@link BossBarImplementationImpl#viewers()}
   */
  @Test
  @DisplayName("Test viewers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable BossBarImplementationImpl.viewers()"})
  void testViewers() {
    // Arrange and Act
    Iterable<? extends BossBarViewer> actualViewersResult =
        new BossBarImplementationImpl(mock(BossBar.class)).viewers();
    Iterator<? extends BossBarViewer> actualIteratorResult = actualViewersResult.iterator();

    // Assert
    assertTrue(actualViewersResult instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Set<? extends BossBarViewer>) actualViewersResult).isEmpty());
  }
}

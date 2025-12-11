package io.papermc.paper.plugin.provider.configuration;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;

class LegacyPaperMetaDiffblueTest {
  /**
   * Test {@link LegacyPaperMeta#migrate(CommentedConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link CommentedConfigurationNode} {@link
   *       CommentedConfigurationNode#hasChild(Object[])} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPaperMeta#migrate(CommentedConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test migrate(CommentedConfigurationNode); given 'true'; when CommentedConfigurationNode hasChild(Object[]) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyPaperMeta.migrate(CommentedConfigurationNode)"})
  void testMigrate_givenTrue_whenCommentedConfigurationNodeHasChildReturnTrue()
      throws ConfigurateException {
    // Arrange
    CommentedConfigurationNode node = mock(CommentedConfigurationNode.class);
    when(node.hasChild(isA(Object[].class))).thenReturn(true);

    // Act
    LegacyPaperMeta.migrate(node);

    // Assert
    verify(node, atLeast(1)).hasChild(isA(Object[].class));
  }
}

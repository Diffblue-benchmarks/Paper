package io.papermc.paper.plugin.entrypoint.strategy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.graph.Graph;
import com.google.common.graph.ImmutableGraph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JohnsonSimpleCyclesDiffblueTest {
  /**
   * Test {@link JohnsonSimpleCycles#JohnsonSimpleCycles(Graph)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link ImmutableGraph#isDirected()}.
   * </ul>
   *
   * <p>Method under test: {@link JohnsonSimpleCycles#JohnsonSimpleCycles(Graph)}
   */
  @Test
  @DisplayName("Test new JohnsonSimpleCycles(Graph); given 'true'; then calls isDirected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JohnsonSimpleCycles.<init>(Graph)"})
  void testNewJohnsonSimpleCycles_givenTrue_thenCallsIsDirected() {
    // Arrange
    ImmutableGraph<Object> graph = mock(ImmutableGraph.class);
    when(graph.isDirected()).thenReturn(true);

    // Act
    new JohnsonSimpleCycles<>(graph);

    // Assert
    verify(graph).isDirected();
  }
}

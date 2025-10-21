package io.papermc.paper.plugin.entrypoint.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.graph.Graph;
import com.google.common.graph.ImmutableGraph;
import io.papermc.paper.plugin.entrypoint.strategy.TopographicGraphSorter.GraphCycleException;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class TopographicGraphSorterDiffblueTest {
  /**
   * Test GraphCycleException new {@link GraphCycleException} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link GraphCycleException}
   */
  @Test
  @DisplayName("Test GraphCycleException new GraphCycleException (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphCycleException.<init>()"})
  void testGraphCycleExceptionNewGraphCycleException() {
    // Arrange and Act
    GraphCycleException actualGraphCycleException = new GraphCycleException();

    // Assert
    assertNull(actualGraphCycleException.getMessage());
    assertNull(actualGraphCycleException.getCause());
    assertEquals(0, actualGraphCycleException.getSuppressed().length);
  }

  /**
   * Test {@link TopographicGraphSorter#sortGraph(Graph)}.
   *
   * <ul>
   *   <li>Given {@link GraphCycleException} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TopographicGraphSorter#sortGraph(Graph)}
   */
  @Test
  @DisplayName("Test sortGraph(Graph); given GraphCycleException (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TopographicGraphSorter.sortGraph(Graph)"})
  void testSortGraph_givenGraphCycleException() throws PluginGraphCycleException {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(ConfigurationTransformation.WILDCARD_OBJECT);

    ImmutableGraph<Object> graph = mock(ImmutableGraph.class);
    when(graph.inDegree(Mockito.<Object>any())).thenThrow(new GraphCycleException());
    when(graph.nodes()).thenReturn(objectSet);

    // Act and Assert
    assertThrows(GraphCycleException.class, () -> TopographicGraphSorter.sortGraph(graph));
    verify(graph).inDegree(isA(Object.class));
    verify(graph).nodes();
  }

  /**
   * Test {@link TopographicGraphSorter#sortGraph(Graph)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code null}.
   *   <li>Then calls {@link ImmutableGraph#successors(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link TopographicGraphSorter#sortGraph(Graph)}
   */
  @Test
  @DisplayName("Test sortGraph(Graph); given HashSet() add 'null'; then calls successors(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TopographicGraphSorter.sortGraph(Graph)"})
  void testSortGraph_givenHashSetAddNull_thenCallsSuccessors() throws PluginGraphCycleException {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(ConfigurationTransformation.WILDCARD_OBJECT);

    HashSet<Object> objectSet2 = new HashSet<>();
    objectSet2.add(null);

    ImmutableGraph<Object> graph = mock(ImmutableGraph.class);
    when(graph.inDegree(Mockito.<Object>any())).thenReturn(0);
    when(graph.successors(Mockito.<Object>any())).thenReturn(objectSet2);
    when(graph.nodes()).thenReturn(objectSet);

    // Act and Assert
    assertThrows(GraphCycleException.class, () -> TopographicGraphSorter.sortGraph(graph));
    verify(graph).inDegree(isA(Object.class));
    verify(graph).nodes();
    verify(graph).successors(isA(Object.class));
  }

  /**
   * Test {@link TopographicGraphSorter#sortGraph(Graph)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add two.
   *   <li>Then calls {@link ImmutableGraph#successors(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link TopographicGraphSorter#sortGraph(Graph)}
   */
  @Test
  @DisplayName("Test sortGraph(Graph); given HashSet() add two; then calls successors(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TopographicGraphSorter.sortGraph(Graph)"})
  void testSortGraph_givenHashSetAddTwo_thenCallsSuccessors() throws PluginGraphCycleException {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(ConfigurationTransformation.WILDCARD_OBJECT);
    objectSet.add(2);

    HashSet<Object> objectSet2 = new HashSet<>();
    objectSet2.add(ConfigurationTransformation.WILDCARD_OBJECT);

    ImmutableGraph<Object> graph = mock(ImmutableGraph.class);
    when(graph.inDegree(Mockito.<Object>any())).thenReturn(0);
    when(graph.successors(Mockito.<Object>any())).thenReturn(objectSet2);
    when(graph.nodes()).thenReturn(objectSet);

    // Act and Assert
    assertThrows(GraphCycleException.class, () -> TopographicGraphSorter.sortGraph(graph));
    verify(graph, atLeast(1)).inDegree(Mockito.<Object>any());
    verify(graph).nodes();
    verify(graph, atLeast(1)).successors(Mockito.<Object>any());
  }

  /**
   * Test {@link TopographicGraphSorter#sortGraph(Graph)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add two.
   *   <li>Then calls {@link ImmutableGraph#successors(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link TopographicGraphSorter#sortGraph(Graph)}
   */
  @Test
  @DisplayName("Test sortGraph(Graph); given HashSet() add two; then calls successors(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TopographicGraphSorter.sortGraph(Graph)"})
  void testSortGraph_givenHashSetAddTwo_thenCallsSuccessors2() throws PluginGraphCycleException {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(ConfigurationTransformation.WILDCARD_OBJECT);
    objectSet.add(2);

    HashSet<Object> objectSet2 = new HashSet<>();
    objectSet2.add(null);

    ImmutableGraph<Object> graph = mock(ImmutableGraph.class);
    when(graph.inDegree(Mockito.<Object>any())).thenReturn(0);
    when(graph.successors(Mockito.<Object>any())).thenReturn(objectSet2);
    when(graph.nodes()).thenReturn(objectSet);

    // Act and Assert
    assertThrows(GraphCycleException.class, () -> TopographicGraphSorter.sortGraph(graph));
    verify(graph, atLeast(1)).inDegree(Mockito.<Object>any());
    verify(graph).nodes();
    verify(graph, atLeast(1)).successors(Mockito.<Object>any());
  }

  /**
   * Test {@link TopographicGraphSorter#sortGraph(Graph)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link TopographicGraphSorter#sortGraph(Graph)}
   */
  @Test
  @DisplayName("Test sortGraph(Graph); given HashSet(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TopographicGraphSorter.sortGraph(Graph)"})
  void testSortGraph_givenHashSet_thenReturnSizeIsOne() throws PluginGraphCycleException {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(ConfigurationTransformation.WILDCARD_OBJECT);

    ImmutableGraph<Object> graph = mock(ImmutableGraph.class);
    when(graph.inDegree(Mockito.<Object>any())).thenReturn(0);
    when(graph.successors(Mockito.<Object>any())).thenReturn(new HashSet<>());
    when(graph.nodes()).thenReturn(objectSet);

    // Act
    List<Object> actualSortGraphResult = TopographicGraphSorter.sortGraph(graph);

    // Assert
    verify(graph).inDegree(isA(Object.class));
    verify(graph).nodes();
    verify(graph).successors(isA(Object.class));
    assertEquals(1, actualSortGraphResult.size());
  }

  /**
   * Test {@link TopographicGraphSorter#sortGraph(Graph)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link ImmutableGraph} {@link ImmutableGraph#nodes()} return {@link
   *       HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TopographicGraphSorter#sortGraph(Graph)}
   */
  @Test
  @DisplayName(
      "Test sortGraph(Graph); given HashSet(); when ImmutableGraph nodes() return HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TopographicGraphSorter.sortGraph(Graph)"})
  void testSortGraph_givenHashSet_whenImmutableGraphNodesReturnHashSet_thenReturnEmpty()
      throws PluginGraphCycleException {
    // Arrange
    ImmutableGraph<Object> graph = mock(ImmutableGraph.class);
    when(graph.nodes()).thenReturn(new HashSet<>());

    // Act
    List<Object> actualSortGraphResult = TopographicGraphSorter.sortGraph(graph);

    // Assert
    verify(graph).nodes();
    assertTrue(actualSortGraphResult.isEmpty());
  }

  /**
   * Test {@link TopographicGraphSorter#sortGraph(Graph)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ImmutableGraph} {@link ImmutableGraph#inDegree(Object)} return one.
   * </ul>
   *
   * <p>Method under test: {@link TopographicGraphSorter#sortGraph(Graph)}
   */
  @Test
  @DisplayName("Test sortGraph(Graph); given one; when ImmutableGraph inDegree(Object) return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TopographicGraphSorter.sortGraph(Graph)"})
  void testSortGraph_givenOne_whenImmutableGraphInDegreeReturnOne()
      throws PluginGraphCycleException {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(ConfigurationTransformation.WILDCARD_OBJECT);

    ImmutableGraph<Object> graph = mock(ImmutableGraph.class);
    when(graph.inDegree(Mockito.<Object>any())).thenReturn(1);
    when(graph.nodes()).thenReturn(objectSet);

    // Act and Assert
    assertThrows(GraphCycleException.class, () -> TopographicGraphSorter.sortGraph(graph));
    verify(graph).inDegree(isA(Object.class));
    verify(graph).nodes();
  }

  /**
   * Test {@link TopographicGraphSorter#sortGraph(Graph)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ImmutableGraph} {@link ImmutableGraph#inDegree(Object)} return one.
   * </ul>
   *
   * <p>Method under test: {@link TopographicGraphSorter#sortGraph(Graph)}
   */
  @Test
  @DisplayName("Test sortGraph(Graph); given one; when ImmutableGraph inDegree(Object) return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TopographicGraphSorter.sortGraph(Graph)"})
  void testSortGraph_givenOne_whenImmutableGraphInDegreeReturnOne2()
      throws PluginGraphCycleException {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(null);

    ImmutableGraph<Object> graph = mock(ImmutableGraph.class);
    when(graph.inDegree(Mockito.<Object>any())).thenReturn(1);
    when(graph.nodes()).thenReturn(objectSet);

    // Act and Assert
    assertThrows(GraphCycleException.class, () -> TopographicGraphSorter.sortGraph(graph));
    verify(graph).inDegree((Object) isNull());
    verify(graph).nodes();
  }

  /**
   * Test {@link TopographicGraphSorter#sortGraph(Graph)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ImmutableGraph} {@link ImmutableGraph#inDegree(Object)} return zero.
   *   <li>Then calls {@link ImmutableGraph#successors(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link TopographicGraphSorter#sortGraph(Graph)}
   */
  @Test
  @DisplayName(
      "Test sortGraph(Graph); given zero; when ImmutableGraph inDegree(Object) return zero; then calls successors(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TopographicGraphSorter.sortGraph(Graph)"})
  void testSortGraph_givenZero_whenImmutableGraphInDegreeReturnZero_thenCallsSuccessors()
      throws PluginGraphCycleException {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(ConfigurationTransformation.WILDCARD_OBJECT);

    HashSet<Object> objectSet2 = new HashSet<>();
    objectSet2.add(ConfigurationTransformation.WILDCARD_OBJECT);

    ImmutableGraph<Object> graph = mock(ImmutableGraph.class);
    when(graph.inDegree(Mockito.<Object>any())).thenReturn(0);
    when(graph.successors(Mockito.<Object>any())).thenReturn(objectSet2);
    when(graph.nodes()).thenReturn(objectSet);

    // Act and Assert
    assertThrows(GraphCycleException.class, () -> TopographicGraphSorter.sortGraph(graph));
    verify(graph).inDegree(isA(Object.class));
    verify(graph).nodes();
    verify(graph).successors(isA(Object.class));
  }
}

package io.papermc.paper.plugin.entrypoint.strategy.modern;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.graph.MutableGraph;
import io.papermc.paper.plugin.TestJavaPluginProvider;
import io.papermc.paper.plugin.TestPluginMeta;
import io.papermc.paper.plugin.entrypoint.strategy.PluginGraphCycleException;
import io.papermc.paper.plugin.entrypoint.strategy.TopographicGraphSorter;
import io.papermc.paper.plugin.entrypoint.strategy.TopographicGraphSorter.GraphCycleException;
import io.papermc.paper.plugin.provider.PluginProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoadOrderTreeDiffblueTest {
  /**
   * Test {@link LoadOrderTree#LoadOrderTree(Map, MutableGraph)}.
   *
   * <p>Method under test: {@link LoadOrderTree#LoadOrderTree(Map, MutableGraph)}
   */
  @Test
  @DisplayName("Test new LoadOrderTree(Map, MutableGraph)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LoadOrderTree.<init>(Map, MutableGraph)"})
  void testNewLoadOrderTree() throws PluginGraphCycleException {
    // Arrange and Act
    LoadOrderTree actualLoadOrderTree =
        new LoadOrderTree(new HashMap<>(), mock(MutableGraph.class));

    // Assert
    assertTrue(actualLoadOrderTree.getLoadOrder().isEmpty());
  }

  /**
   * Test {@link LoadOrderTree#add(PluginProvider)}.
   *
   * <ul>
   *   <li>Then throw {@link GraphCycleException}.
   * </ul>
   *
   * <p>Method under test: {@link LoadOrderTree#add(PluginProvider)}
   */
  @Test
  @DisplayName("Test add(PluginProvider); then throw GraphCycleException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LoadOrderTree.add(PluginProvider)"})
  void testAdd_thenThrowGraphCycleException() {
    // Arrange
    MutableGraph<String> graph = mock(MutableGraph.class);
    when(graph.addNode(Mockito.<String>any())).thenThrow(new GraphCycleException());
    LoadOrderTree loadOrderTree = new LoadOrderTree(new HashMap<>(), graph);

    // Act and Assert
    assertThrows(
        GraphCycleException.class,
        () -> loadOrderTree.add(new TestJavaPluginProvider(new TestPluginMeta("42"))));
    verify(graph).addNode("42");
  }

  /**
   * Test {@link LoadOrderTree#add(PluginProvider)}.
   *
   * <ul>
   *   <li>When {@link TestPluginMeta#TestPluginMeta(String)} with identifier is {@code 42}
   *       HardDependencies is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LoadOrderTree#add(PluginProvider)}
   */
  @Test
  @DisplayName(
      "Test add(PluginProvider); when TestPluginMeta(String) with identifier is '42' HardDependencies is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LoadOrderTree.add(PluginProvider)"})
  void testAdd_whenTestPluginMetaWithIdentifierIs42HardDependenciesIsArrayList() {
    // Arrange
    MutableGraph<String> graph = mock(MutableGraph.class);
    when(graph.addNode(Mockito.<String>any())).thenReturn(true);
    LoadOrderTree loadOrderTree = new LoadOrderTree(new HashMap<>(), graph);

    ArrayList<String> hardDependencies = new ArrayList<>();
    hardDependencies.add("foo");

    TestPluginMeta testPluginConfiguration = new TestPluginMeta("42");
    testPluginConfiguration.setHardDependencies(hardDependencies);

    // Act
    loadOrderTree.add(new TestJavaPluginProvider(testPluginConfiguration));

    // Assert
    verify(graph).addNode("42");
  }

  /**
   * Test {@link LoadOrderTree#add(PluginProvider)}.
   *
   * <ul>
   *   <li>When {@link TestPluginMeta#TestPluginMeta(String)} with identifier is {@code 42}
   *       LoadBefore is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LoadOrderTree#add(PluginProvider)}
   */
  @Test
  @DisplayName(
      "Test add(PluginProvider); when TestPluginMeta(String) with identifier is '42' LoadBefore is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LoadOrderTree.add(PluginProvider)"})
  void testAdd_whenTestPluginMetaWithIdentifierIs42LoadBeforeIsArrayList() {
    // Arrange
    MutableGraph<String> graph = mock(MutableGraph.class);
    when(graph.addNode(Mockito.<String>any())).thenReturn(true);
    LoadOrderTree loadOrderTree = new LoadOrderTree(new HashMap<>(), graph);

    ArrayList<String> loadBefore = new ArrayList<>();
    loadBefore.add("foo");

    TestPluginMeta testPluginConfiguration = new TestPluginMeta("42");
    testPluginConfiguration.setLoadBefore(loadBefore);

    // Act
    loadOrderTree.add(new TestJavaPluginProvider(testPluginConfiguration));

    // Assert
    verify(graph).addNode("42");
  }

  /**
   * Test {@link LoadOrderTree#add(PluginProvider)}.
   *
   * <ul>
   *   <li>When {@link TestPluginMeta#TestPluginMeta(String)} with identifier is {@code 42}.
   *   <li>Then calls {@link MutableGraph#addNode(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link LoadOrderTree#add(PluginProvider)}
   */
  @Test
  @DisplayName(
      "Test add(PluginProvider); when TestPluginMeta(String) with identifier is '42'; then calls addNode(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LoadOrderTree.add(PluginProvider)"})
  void testAdd_whenTestPluginMetaWithIdentifierIs42_thenCallsAddNode() {
    // Arrange
    MutableGraph<String> graph = mock(MutableGraph.class);
    when(graph.addNode(Mockito.<String>any())).thenReturn(true);
    LoadOrderTree loadOrderTree = new LoadOrderTree(new HashMap<>(), graph);

    // Act
    loadOrderTree.add(new TestJavaPluginProvider(new TestPluginMeta("42")));

    // Assert
    verify(graph).addNode("42");
  }

  /**
   * Test {@link LoadOrderTree#getLoadOrder()}.
   *
   * <ul>
   *   <li>Given {@link MutableGraph} {@link MutableGraph#nodes()} return {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LoadOrderTree#getLoadOrder()}
   */
  @Test
  @DisplayName(
      "Test getLoadOrder(); given MutableGraph nodes() return HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LoadOrderTree.getLoadOrder()"})
  void testGetLoadOrder_givenMutableGraphNodesReturnHashSet_thenReturnEmpty()
      throws PluginGraphCycleException {
    // Arrange
    MutableGraph<String> graph = mock(MutableGraph.class);
    when(graph.nodes()).thenReturn(new HashSet<>());
    LoadOrderTree loadOrderTree = new LoadOrderTree(new HashMap<>(), graph);

    // Act
    List<String> actualLoadOrder = loadOrderTree.getLoadOrder();

    // Assert
    verify(graph).nodes();
    assertTrue(actualLoadOrder.isEmpty());
  }
}

package io.papermc.paper.configuration.transformation.world;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class LegacyPaperWorldConfigDiffblueTest {
  /**
   * Test {@link LegacyPaperWorldConfig#transformation()}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#childrenList()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPaperWorldConfig#transformation()}
   */
  @Test
  @DisplayName("Test transformation(); then calls childrenList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationTransformation LegacyPaperWorldConfig.transformation()"})
  void testTransformation_thenCallsChildrenList() throws ConfigurateException {
    // Arrange and Act
    ConfigurationTransformation actualTransformationResult =
        LegacyPaperWorldConfig.transformation();
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.getInt(anyInt())).thenReturn(1);
    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    Mockito.<List<? extends ConfigurationNode>>when(configurationNode2.childrenList())
        .thenReturn(new ArrayList<>());
    Mockito.<Map<Object, ? extends ConfigurationNode>>when(configurationNode2.childrenMap())
        .thenReturn(new HashMap<>());
    when(configurationNode2.getList(Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    when(configurationNode2.isList()).thenReturn(true);
    when(configurationNode2.isMap()).thenReturn(true);
    when(configurationNode2.virtual()).thenReturn(false);
    when(configurationNode2.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode2.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode2.getInt(anyInt())).thenReturn(1);
    when(configurationNode2.getList(Mockito.<Class<String>>any())).thenReturn(new ArrayList<>());
    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.virtual()).thenReturn(false);
    when(configurationNode3.from(Mockito.<ConfigurationNode>any()))
        .thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.node(isA(Object[].class))).thenReturn(configurationNode2);
    when(configurationNode3.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.getBoolean(anyBoolean())).thenReturn(true);
    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode3);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode);
    actualTransformationResult.apply(node);

    // Assert
    verify(configurationNode2).childrenList();
    verify(configurationNode2).childrenMap();
    verify(configurationNode3, atLeast(1)).from(Mockito.<ConfigurationNode>any());
    verify(configurationNode3, atLeast(1)).getBoolean(anyBoolean());
    verify(configurationNode2, atLeast(1)).getInt(anyInt());
    verify(configurationNode).getInt(-1);
    verify(configurationNode2, atLeast(1)).getList(isA(Class.class));
    verify(configurationNode2).isList();
    verify(configurationNode2).isMap();
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(configurationNode3, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode3, atLeast(1)).raw(Mockito.<Object>any());
    verify(configurationNode2, atLeast(1)).raw(Mockito.<Object>any());
    verify(configurationNode3).set(isA(Object.class));
    verify(configurationNode).set(isA(Object.class));
    verify(configurationNode2, atLeast(1)).set(Mockito.<Object>any());
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode3, atLeast(1)).virtual();
  }

  /**
   * Test {@link LegacyPaperWorldConfig#transformation()}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#childrenList()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPaperWorldConfig#transformation()}
   */
  @Test
  @DisplayName("Test transformation(); then calls childrenList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationTransformation LegacyPaperWorldConfig.transformation()"})
  void testTransformation_thenCallsChildrenList2() throws ConfigurateException {
    // Arrange and Act
    ConfigurationTransformation actualTransformationResult =
        LegacyPaperWorldConfig.transformation();
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.getInt(anyInt())).thenReturn(1);
    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    Mockito.<List<? extends ConfigurationNode>>when(configurationNode2.childrenList())
        .thenReturn(new ArrayList<>());
    when(configurationNode2.getList(Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    when(configurationNode2.isList()).thenReturn(true);
    when(configurationNode2.isMap()).thenReturn(false);
    when(configurationNode2.virtual()).thenReturn(false);
    when(configurationNode2.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode2.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode2.getInt(anyInt())).thenReturn(1);
    when(configurationNode2.getList(Mockito.<Class<String>>any())).thenReturn(new ArrayList<>());
    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.virtual()).thenReturn(false);
    when(configurationNode3.from(Mockito.<ConfigurationNode>any()))
        .thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.node(isA(Object[].class))).thenReturn(configurationNode2);
    when(configurationNode3.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.getBoolean(anyBoolean())).thenReturn(true);
    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode3);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode);
    actualTransformationResult.apply(node);

    // Assert
    verify(configurationNode2).childrenList();
    verify(configurationNode3, atLeast(1)).from(Mockito.<ConfigurationNode>any());
    verify(configurationNode3, atLeast(1)).getBoolean(anyBoolean());
    verify(configurationNode2, atLeast(1)).getInt(anyInt());
    verify(configurationNode).getInt(-1);
    verify(configurationNode2, atLeast(1)).getList(isA(Class.class));
    verify(configurationNode2).isList();
    verify(configurationNode2).isMap();
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(configurationNode3, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode3, atLeast(1)).raw(Mockito.<Object>any());
    verify(configurationNode2, atLeast(1)).raw(Mockito.<Object>any());
    verify(configurationNode3).set(isA(Object.class));
    verify(configurationNode).set(isA(Object.class));
    verify(configurationNode2, atLeast(1)).set(isA(Object.class));
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode3, atLeast(1)).virtual();
  }

  /**
   * Test {@link LegacyPaperWorldConfig#transformation()}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#childrenList()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPaperWorldConfig#transformation()}
   */
  @Test
  @DisplayName("Test transformation(); then calls childrenList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationTransformation LegacyPaperWorldConfig.transformation()"})
  void testTransformation_thenCallsChildrenList3() throws ConfigurateException {
    // Arrange and Act
    ConfigurationTransformation actualTransformationResult =
        LegacyPaperWorldConfig.transformation();
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.getInt(anyInt())).thenReturn(1);
    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    Mockito.<List<? extends ConfigurationNode>>when(configurationNode2.childrenList())
        .thenReturn(new ArrayList<>());
    Mockito.<Map<Object, ? extends ConfigurationNode>>when(configurationNode2.childrenMap())
        .thenReturn(new HashMap<>());
    when(configurationNode2.getList(Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    when(configurationNode2.isList()).thenReturn(true);
    when(configurationNode2.isMap()).thenReturn(true);
    when(configurationNode2.virtual()).thenReturn(false);
    when(configurationNode2.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode2.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode2.getInt(anyInt())).thenReturn(128);
    when(configurationNode2.getList(Mockito.<Class<String>>any())).thenReturn(new ArrayList<>());
    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.virtual()).thenReturn(false);
    when(configurationNode3.from(Mockito.<ConfigurationNode>any()))
        .thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.node(isA(Object[].class))).thenReturn(configurationNode2);
    when(configurationNode3.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.getBoolean(anyBoolean())).thenReturn(true);
    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode3);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode);
    actualTransformationResult.apply(node);

    // Assert
    verify(configurationNode2).childrenList();
    verify(configurationNode2).childrenMap();
    verify(configurationNode3, atLeast(1)).from(Mockito.<ConfigurationNode>any());
    verify(configurationNode3, atLeast(1)).getBoolean(anyBoolean());
    verify(configurationNode2, atLeast(1)).getInt(anyInt());
    verify(configurationNode).getInt(-1);
    verify(configurationNode2, atLeast(1)).getList(isA(Class.class));
    verify(configurationNode2).isList();
    verify(configurationNode2).isMap();
    verify(configurationNode3, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode3, atLeast(1)).raw(Mockito.<Object>any());
    verify(configurationNode2, atLeast(1)).raw(Mockito.<Object>any());
    verify(configurationNode3).set(isA(Object.class));
    verify(configurationNode).set(isA(Object.class));
    verify(configurationNode2, atLeast(1)).set(Mockito.<Object>any());
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode3, atLeast(1)).virtual();
  }

  /**
   * Test {@link LegacyPaperWorldConfig#transformation()}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#childrenList()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPaperWorldConfig#transformation()}
   */
  @Test
  @DisplayName("Test transformation(); then calls childrenList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationTransformation LegacyPaperWorldConfig.transformation()"})
  void testTransformation_thenCallsChildrenList4() throws ConfigurateException {
    // Arrange and Act
    ConfigurationTransformation actualTransformationResult =
        LegacyPaperWorldConfig.transformation();
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.getInt(anyInt())).thenReturn(1);
    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    Mockito.<List<? extends ConfigurationNode>>when(configurationNode2.childrenList())
        .thenReturn(new ArrayList<>());
    Mockito.<Map<Object, ? extends ConfigurationNode>>when(configurationNode2.childrenMap())
        .thenReturn(new HashMap<>());
    when(configurationNode2.getList(Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    when(configurationNode2.isList()).thenReturn(true);
    when(configurationNode2.isMap()).thenReturn(true);
    when(configurationNode2.virtual()).thenReturn(false);
    when(configurationNode2.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode2.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode2.getInt(anyInt())).thenReturn(Integer.SIZE);
    when(configurationNode2.getList(Mockito.<Class<String>>any())).thenReturn(new ArrayList<>());
    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.virtual()).thenReturn(false);
    when(configurationNode3.from(Mockito.<ConfigurationNode>any()))
        .thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.node(isA(Object[].class))).thenReturn(configurationNode2);
    when(configurationNode3.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.getBoolean(anyBoolean())).thenReturn(true);
    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode3);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode);
    actualTransformationResult.apply(node);

    // Assert
    verify(configurationNode2).childrenList();
    verify(configurationNode2).childrenMap();
    verify(configurationNode3, atLeast(1)).from(Mockito.<ConfigurationNode>any());
    verify(configurationNode3, atLeast(1)).getBoolean(anyBoolean());
    verify(configurationNode2, atLeast(1)).getInt(anyInt());
    verify(configurationNode).getInt(-1);
    verify(configurationNode2, atLeast(1)).getList(isA(Class.class));
    verify(configurationNode2).isList();
    verify(configurationNode2).isMap();
    verify(configurationNode3, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode3, atLeast(1)).raw(Mockito.<Object>any());
    verify(configurationNode2, atLeast(1)).raw(Mockito.<Object>any());
    verify(configurationNode3).set(isA(Object.class));
    verify(configurationNode).set(isA(Object.class));
    verify(configurationNode2, atLeast(1)).set(Mockito.<Object>any());
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode3, atLeast(1)).virtual();
  }

  /**
   * Test {@link LegacyPaperWorldConfig#transformation()}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#childrenList()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPaperWorldConfig#transformation()}
   */
  @Test
  @DisplayName("Test transformation(); then calls childrenList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationTransformation LegacyPaperWorldConfig.transformation()"})
  void testTransformation_thenCallsChildrenList5() throws ConfigurateException {
    // Arrange and Act
    ConfigurationTransformation actualTransformationResult =
        LegacyPaperWorldConfig.transformation();
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.getInt(anyInt())).thenReturn(1);
    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    Mockito.<List<? extends ConfigurationNode>>when(configurationNode2.childrenList())
        .thenReturn(new ArrayList<>());
    Mockito.<Map<Object, ? extends ConfigurationNode>>when(configurationNode2.childrenMap())
        .thenReturn(new HashMap<>());
    when(configurationNode2.getList(Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    when(configurationNode2.isList()).thenReturn(true);
    when(configurationNode2.isMap()).thenReturn(true);
    when(configurationNode2.virtual()).thenReturn(false);
    when(configurationNode2.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode2.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode2.getInt(anyInt())).thenReturn(1);
    when(configurationNode2.getList(Mockito.<Class<String>>any())).thenReturn(new ArrayList<>());
    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.virtual()).thenReturn(false);
    when(configurationNode3.from(Mockito.<ConfigurationNode>any()))
        .thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.node(isA(Object[].class))).thenReturn(configurationNode2);
    when(configurationNode3.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.getBoolean(anyBoolean())).thenReturn(false);
    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode3);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode);
    actualTransformationResult.apply(node);

    // Assert
    verify(configurationNode2).childrenList();
    verify(configurationNode2).childrenMap();
    verify(configurationNode3, atLeast(1)).from(Mockito.<ConfigurationNode>any());
    verify(configurationNode3, atLeast(1)).getBoolean(anyBoolean());
    verify(configurationNode2, atLeast(1)).getInt(anyInt());
    verify(configurationNode).getInt(-1);
    verify(configurationNode2, atLeast(1)).getList(isA(Class.class));
    verify(configurationNode2).isList();
    verify(configurationNode2).isMap();
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(configurationNode3, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode3, atLeast(1)).raw(Mockito.<Object>any());
    verify(configurationNode2, atLeast(1)).raw(Mockito.<Object>any());
    verify(configurationNode3).set(isA(Object.class));
    verify(configurationNode).set(isA(Object.class));
    verify(configurationNode2, atLeast(1)).set(Mockito.<Object>any());
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode3, atLeast(1)).virtual();
  }

  /**
   * Test {@link LegacyPaperWorldConfig#toNewFormat()}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#childrenList()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPaperWorldConfig#toNewFormat()}
   */
  @Test
  @DisplayName("Test toNewFormat(); then calls childrenList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationTransformation LegacyPaperWorldConfig.toNewFormat()"})
  void testToNewFormat_thenCallsChildrenList() throws ConfigurateException {
    // Arrange and Act
    ConfigurationTransformation actualToNewFormatResult = LegacyPaperWorldConfig.toNewFormat();
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.getInt(anyInt())).thenReturn(1);
    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.virtual()).thenReturn(true);
    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    Mockito.<List<? extends ConfigurationNode>>when(configurationNode3.childrenList())
        .thenReturn(new ArrayList<>());
    when(configurationNode3.isList()).thenReturn(true);
    when(configurationNode3.node(isA(Object[].class))).thenReturn(configurationNode2);
    when(configurationNode3.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.virtual()).thenReturn(false);
    when(configurationNode3.from(Mockito.<ConfigurationNode>any()))
        .thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.require(Mockito.<Class<String>>any())).thenReturn("Require");
    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode3);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode);
    actualToNewFormatResult.apply(node);

    // Assert
    verify(configurationNode3, atLeast(1)).childrenList();
    verify(configurationNode3, atLeast(1)).from(isA(ConfigurationNode.class));
    verify(configurationNode).getInt(-1);
    verify(configurationNode3, atLeast(1)).isList();
    verify(configurationNode3, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode3, atLeast(1)).raw(isNull());
    verify(configurationNode3, atLeast(1)).require(isA(Class.class));
    verify(configurationNode3).set(isA(Object.class));
    verify(configurationNode).set(isA(Object.class));
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode3, atLeast(1)).virtual();
  }

  /**
   * Test {@link LegacyPaperWorldConfig#toNewFormat()}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#childrenList()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPaperWorldConfig#toNewFormat()}
   */
  @Test
  @DisplayName("Test toNewFormat(); then calls childrenList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationTransformation LegacyPaperWorldConfig.toNewFormat()"})
  void testToNewFormat_thenCallsChildrenList2() throws ConfigurateException {
    // Arrange and Act
    ConfigurationTransformation actualToNewFormatResult = LegacyPaperWorldConfig.toNewFormat();
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.getInt(anyInt())).thenReturn(1);
    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.virtual()).thenReturn(true);
    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    ArrayList<ConfigurationNode> configurationNodeList = new ArrayList<>();
    configurationNodeList.add(configurationNode3);
    ConfigurationNode configurationNode4 = mock(ConfigurationNode.class);
    Mockito.<List<? extends ConfigurationNode>>when(configurationNode4.childrenList())
        .thenReturn(configurationNodeList);
    when(configurationNode4.isList()).thenReturn(true);
    when(configurationNode4.node(isA(Object[].class))).thenReturn(configurationNode2);
    when(configurationNode4.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.virtual()).thenReturn(false);
    when(configurationNode4.from(Mockito.<ConfigurationNode>any()))
        .thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.require(Mockito.<Class<String>>any())).thenReturn("Require");
    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode4);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode);
    actualToNewFormatResult.apply(node);

    // Assert
    verify(configurationNode4, atLeast(1)).childrenList();
    verify(configurationNode4, atLeast(1)).from(isA(ConfigurationNode.class));
    verify(configurationNode).getInt(-1);
    verify(configurationNode4, atLeast(1)).isList();
    verify(configurationNode4, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode3, atLeast(1)).raw(isNull());
    verify(configurationNode4, atLeast(1)).raw(isNull());
    verify(configurationNode4, atLeast(1)).require(isA(Class.class));
    verify(configurationNode4).set(isA(Object.class));
    verify(configurationNode).set(isA(Object.class));
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode4, atLeast(1)).virtual();
  }

  /**
   * Test {@link LegacyPaperWorldConfig#toNewFormat()}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#childrenList()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPaperWorldConfig#toNewFormat()}
   */
  @Test
  @DisplayName("Test toNewFormat(); then calls childrenList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationTransformation LegacyPaperWorldConfig.toNewFormat()"})
  void testToNewFormat_thenCallsChildrenList3() throws ConfigurateException {
    // Arrange and Act
    ConfigurationTransformation actualToNewFormatResult = LegacyPaperWorldConfig.toNewFormat();
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.getInt(anyInt())).thenReturn(1);
    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.virtual()).thenReturn(false);
    when(configurationNode2.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    ArrayList<ConfigurationNode> configurationNodeList = new ArrayList<>();
    configurationNodeList.add(configurationNode3);
    ConfigurationNode configurationNode4 = mock(ConfigurationNode.class);
    Mockito.<List<? extends ConfigurationNode>>when(configurationNode4.childrenList())
        .thenReturn(configurationNodeList);
    when(configurationNode4.isList()).thenReturn(true);
    when(configurationNode4.node(isA(Object[].class))).thenReturn(configurationNode2);
    when(configurationNode4.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.virtual()).thenReturn(false);
    when(configurationNode4.from(Mockito.<ConfigurationNode>any()))
        .thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.require(Mockito.<Class<String>>any())).thenReturn("Require");
    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode4);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode);
    actualToNewFormatResult.apply(node);

    // Assert
    verify(configurationNode4, atLeast(1)).childrenList();
    verify(configurationNode4, atLeast(1)).from(isA(ConfigurationNode.class));
    verify(configurationNode).getInt(-1);
    verify(configurationNode4, atLeast(1)).isList();
    verify(configurationNode4, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode3, atLeast(1)).raw(isNull());
    verify(configurationNode2, atLeast(1)).raw(isNull());
    verify(configurationNode4, atLeast(1)).raw(isNull());
    verify(configurationNode4, atLeast(1)).require(isA(Class.class));
    verify(configurationNode4).set(isA(Object.class));
    verify(configurationNode).set(isA(Object.class));
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode4, atLeast(1)).virtual();
  }

  /**
   * Test {@link LegacyPaperWorldConfig#toNewFormat()}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#childrenList()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPaperWorldConfig#toNewFormat()}
   */
  @Test
  @DisplayName("Test toNewFormat(); then calls childrenList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationTransformation LegacyPaperWorldConfig.toNewFormat()"})
  void testToNewFormat_thenCallsChildrenList4() throws ConfigurateException {
    // Arrange and Act
    ConfigurationTransformation actualToNewFormatResult = LegacyPaperWorldConfig.toNewFormat();
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.getInt(anyInt())).thenReturn(1);
    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.virtual()).thenReturn(true);
    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    ArrayList<ConfigurationNode> configurationNodeList = new ArrayList<>();
    configurationNodeList.add(configurationNode3);
    ConfigurationNode configurationNode4 = mock(ConfigurationNode.class);
    Mockito.<List<? extends ConfigurationNode>>when(configurationNode4.childrenList())
        .thenReturn(configurationNodeList);
    when(configurationNode4.isList()).thenReturn(true);
    when(configurationNode4.node(isA(Object[].class))).thenReturn(configurationNode2);
    when(configurationNode4.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.virtual()).thenReturn(false);
    when(configurationNode4.from(Mockito.<ConfigurationNode>any()))
        .thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.require(Mockito.<Class<String>>any())).thenReturn("alternate-current");
    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode4);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode);
    actualToNewFormatResult.apply(node);

    // Assert
    verify(configurationNode4, atLeast(1)).childrenList();
    verify(configurationNode4, atLeast(1)).from(isA(ConfigurationNode.class));
    verify(configurationNode).getInt(-1);
    verify(configurationNode4, atLeast(1)).isList();
    verify(configurationNode4, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode3, atLeast(1)).raw(isNull());
    verify(configurationNode4, atLeast(1)).raw(isNull());
    verify(configurationNode4, atLeast(1)).require(isA(Class.class));
    verify(configurationNode).set(isA(Object.class));
    verify(configurationNode4, atLeast(1)).set(Mockito.<Object>any());
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode4, atLeast(1)).virtual();
  }
}

package io.papermc.paper.configuration.transformation.global;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class LegacyPaperConfigDiffblueTest {
  /**
   * Test {@link LegacyPaperConfig#toNewFormat()}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#childrenList()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPaperConfig#toNewFormat()}
   */
  @Test
  @DisplayName("Test toNewFormat(); then calls childrenList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationTransformation LegacyPaperConfig.toNewFormat()"})
  void testToNewFormat_thenCallsChildrenList() throws ConfigurateException {
    // Arrange and Act
    ConfigurationTransformation actualToNewFormatResult = LegacyPaperConfig.toNewFormat();
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.getInt(anyInt())).thenReturn(1);
    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.virtual()).thenReturn(true);
    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    Mockito.<List<? extends ConfigurationNode>>when(configurationNode3.childrenList())
        .thenReturn(new ArrayList<>());
    when(configurationNode3.isList()).thenReturn(true);
    when(configurationNode3.raw()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(configurationNode3.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.virtual()).thenReturn(false);
    when(configurationNode3.node(isA(Object[].class))).thenReturn(configurationNode2);
    ConfigurationNode configurationNode4 = mock(ConfigurationNode.class);
    when(configurationNode4.virtual()).thenReturn(false);
    when(configurationNode4.from(Mockito.<ConfigurationNode>any()))
        .thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.node(isA(Object[].class))).thenReturn(configurationNode3);
    when(configurationNode4.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode4);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode);
    actualToNewFormatResult.apply(node);

    // Assert
    verify(configurationNode3).childrenList();
    verify(configurationNode4, atLeast(1)).from(Mockito.<ConfigurationNode>any());
    verify(configurationNode).getInt(-1);
    verify(configurationNode3).isList();
    verify(configurationNode3, atLeast(1)).node(isA(Object[].class));
    verify(configurationNode4, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode3, atLeast(1)).raw();
    verify(configurationNode3, atLeast(1)).raw(isNull());
    verify(configurationNode4, atLeast(1)).raw(isNull());
    verify(configurationNode).set(isA(Object.class));
    verify(configurationNode3, atLeast(1)).set(isA(Object.class));
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode3, atLeast(1)).virtual();
    verify(configurationNode4, atLeast(1)).virtual();
  }

  /**
   * Test {@link LegacyPaperConfig#toNewFormat()}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#from(ConfigurationNode)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPaperConfig#toNewFormat()}
   */
  @Test
  @DisplayName("Test toNewFormat(); then calls from(ConfigurationNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationTransformation LegacyPaperConfig.toNewFormat()"})
  void testToNewFormat_thenCallsFrom() throws ConfigurateException {
    // Arrange and Act
    ConfigurationTransformation actualToNewFormatResult = LegacyPaperConfig.toNewFormat();
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.getInt(anyInt())).thenReturn(1);
    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.virtual()).thenReturn(true);
    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.virtual()).thenReturn(false);
    when(configurationNode3.from(Mockito.<ConfigurationNode>any()))
        .thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.node(isA(Object[].class))).thenReturn(configurationNode2);
    when(configurationNode3.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode3);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode);
    actualToNewFormatResult.apply(node);

    // Assert
    verify(configurationNode3, atLeast(1)).from(isA(ConfigurationNode.class));
    verify(configurationNode).getInt(-1);
    verify(configurationNode3, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode3, atLeast(1)).raw(isNull());
    verify(configurationNode).set(isA(Object.class));
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode3, atLeast(1)).virtual();
  }

  /**
   * Test {@link LegacyPaperConfig#toNewFormat()}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#key()}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPaperConfig#toNewFormat()}
   */
  @Test
  @DisplayName("Test toNewFormat(); then calls key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationTransformation LegacyPaperConfig.toNewFormat()"})
  void testToNewFormat_thenCallsKey() throws ConfigurateException {
    // Arrange and Act
    ConfigurationTransformation actualToNewFormatResult = LegacyPaperConfig.toNewFormat();
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.getInt(anyInt())).thenReturn(1);
    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.virtual()).thenReturn(true);
    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.key()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    ArrayList<ConfigurationNode> configurationNodeList = new ArrayList<>();
    configurationNodeList.add(configurationNode3);
    ConfigurationNode configurationNode4 = mock(ConfigurationNode.class);
    Mockito.<List<? extends ConfigurationNode>>when(configurationNode4.childrenList())
        .thenReturn(configurationNodeList);
    when(configurationNode4.isList()).thenReturn(true);
    when(configurationNode4.raw()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(configurationNode4.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.virtual()).thenReturn(false);
    when(configurationNode4.node(isA(Object[].class))).thenReturn(configurationNode2);
    ConfigurationNode configurationNode5 = mock(ConfigurationNode.class);
    when(configurationNode5.virtual()).thenReturn(false);
    when(configurationNode5.from(Mockito.<ConfigurationNode>any()))
        .thenReturn(mock(ConfigurationNode.class));
    when(configurationNode5.node(isA(Object[].class))).thenReturn(configurationNode4);
    when(configurationNode5.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode5);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode);
    actualToNewFormatResult.apply(node);

    // Assert
    verify(configurationNode4).childrenList();
    verify(configurationNode5, atLeast(1)).from(Mockito.<ConfigurationNode>any());
    verify(configurationNode).getInt(-1);
    verify(configurationNode4).isList();
    verify(configurationNode3).key();
    verify(configurationNode4, atLeast(1)).node(isA(Object[].class));
    verify(configurationNode5, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode4, atLeast(1)).raw();
    verify(configurationNode4, atLeast(1)).raw(isNull());
    verify(configurationNode5, atLeast(1)).raw(isNull());
    verify(configurationNode).set(isA(Object.class));
    verify(configurationNode4, atLeast(1)).set(isA(Object.class));
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode4, atLeast(1)).virtual();
    verify(configurationNode5, atLeast(1)).virtual();
  }
}

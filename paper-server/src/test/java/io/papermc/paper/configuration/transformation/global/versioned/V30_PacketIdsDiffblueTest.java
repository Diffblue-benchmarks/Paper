package io.papermc.paper.configuration.transformation.global.versioned;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.NodePath;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;
import org.spongepowered.configurate.transformation.ConfigurationTransformation.VersionedBuilder;

class V30_PacketIdsDiffblueTest {
  /**
   * Test {@link V30_PacketIds#apply(VersionedBuilder)}.
   *
   * <ul>
   *   <li>Given versionedBuilder.
   *   <li>Then calls {@link ConfigurationTransformation.VersionedBuilder#addVersion(int,
   *       ConfigurationTransformation)}.
   * </ul>
   *
   * <p>Method under test: {@link V30_PacketIds#apply(ConfigurationTransformation.VersionedBuilder)}
   */
  @Test
  @DisplayName(
      "Test apply(VersionedBuilder); given versionedBuilder; then calls addVersion(int, ConfigurationTransformation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V30_PacketIds.apply(ConfigurationTransformation.VersionedBuilder)"})
  void testApply_givenVersionedBuilder_thenCallsAddVersion() {
    // Arrange
    VersionedBuilder builder = mock(VersionedBuilder.class);
    when(builder.addVersion(anyInt(), Mockito.<ConfigurationTransformation>any()))
        .thenReturn(ConfigurationTransformation.versionedBuilder());

    // Act
    V30_PacketIds.apply(builder);

    // Assert
    verify(builder).addVersion(eq(30), isA(ConfigurationTransformation.class));
  }

  /**
   * Test {@link V30_PacketIds#visitPath(NodePath, ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When {@link NodePath} {@link NodePath#size()} return three.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link V30_PacketIds#visitPath(NodePath, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test visitPath(NodePath, ConfigurationNode); given three; when NodePath size() return three; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] V30_PacketIds.visitPath(NodePath, ConfigurationNode)"})
  void testVisitPath_givenThree_whenNodePathSizeReturnThree_thenReturnNull() {
    // Arrange
    NodePath path = mock(NodePath.class);
    when(path.size()).thenReturn(3);
    when(path.get(anyInt())).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    Object[] actualVisitPathResult =
        V30_PacketIds.INSTANCE.visitPath(path, mock(ConfigurationNode.class));

    // Assert
    verify(path).get(2);
    verify(path).size();
    assertNull(actualVisitPathResult);
  }
}

package io.papermc.paper.configuration.transformation;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.NodePath;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;
import org.spongepowered.configurate.transformation.ConfigurationTransformation.Builder;
import org.spongepowered.configurate.transformation.TransformAction;

class TransformationsDiffblueTest {
  /**
   * Test {@link Transformations#moveFromRoot(Builder, String, String[])}.
   *
   * <ul>
   *   <li>Given builder.
   *   <li>Then calls {@link ConfigurationTransformation.Builder#addAction(NodePath,
   *       TransformAction)}.
   * </ul>
   *
   * <p>Method under test: {@link Transformations#moveFromRoot(ConfigurationTransformation.Builder,
   * String, String[])}
   */
  @Test
  @DisplayName(
      "Test moveFromRoot(Builder, String, String[]); given builder; then calls addAction(NodePath, TransformAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Transformations.moveFromRoot(ConfigurationTransformation.Builder, String, String[])"
  })
  void testMoveFromRoot_givenBuilder_thenCallsAddAction() {
    // Arrange
    Builder builder = mock(Builder.class);
    when(builder.addAction(Mockito.<NodePath>any(), Mockito.<TransformAction>any()))
        .thenReturn(ConfigurationTransformation.builder());

    // Act
    Transformations.moveFromRoot(builder, "Key", "Parents");

    // Assert
    verify(builder).addAction(isA(NodePath.class), isA(TransformAction.class));
  }

  /**
   * Test {@link Transformations#moveFromRootAndRename(Builder, NodePath, String, String[])} with
   * {@code Builder}, {@code NodePath}, {@code String}, {@code String[]}.
   *
   * <ul>
   *   <li>Then calls {@link NodePath#get(int)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * Transformations#moveFromRootAndRename(ConfigurationTransformation.Builder, NodePath, String,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test moveFromRootAndRename(Builder, NodePath, String, String[]) with 'Builder', 'NodePath', 'String', 'String[]'; then calls get(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Transformations.moveFromRootAndRename(ConfigurationTransformation.Builder, NodePath, String, String[])"
  })
  void testMoveFromRootAndRenameWithBuilderNodePathStringString_thenCallsGet() {
    // Arrange
    Builder builder = ConfigurationTransformation.builder();

    NodePath oldKey = mock(NodePath.class);
    when(oldKey.get(anyInt())).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    when(oldKey.size()).thenReturn(3);

    // Act
    Transformations.moveFromRootAndRename(builder, oldKey, "New Key", "Parents");

    // Assert
    verify(oldKey, atLeast(1)).get(anyInt());
    verify(oldKey, atLeast(1)).size();
  }

  /**
   * Test {@link Transformations#moveFromRootAndRename(Builder, String, String, String[])} with
   * {@code Builder}, {@code String}, {@code String}, {@code String[]}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationTransformation.Builder#addAction(NodePath,
   *       TransformAction)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * Transformations#moveFromRootAndRename(ConfigurationTransformation.Builder, String, String,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test moveFromRootAndRename(Builder, String, String, String[]) with 'Builder', 'String', 'String', 'String[]'; then calls addAction(NodePath, TransformAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Transformations.moveFromRootAndRename(ConfigurationTransformation.Builder, String, String, String[])"
  })
  void testMoveFromRootAndRenameWithBuilderStringStringString_thenCallsAddAction() {
    // Arrange
    Builder builder = mock(Builder.class);
    when(builder.addAction(Mockito.<NodePath>any(), Mockito.<TransformAction>any()))
        .thenReturn(ConfigurationTransformation.builder());

    // Act
    Transformations.moveFromRootAndRename(builder, "Old Key", "New Key", "Parents");

    // Assert
    verify(builder).addAction(isA(NodePath.class), isA(TransformAction.class));
  }
}

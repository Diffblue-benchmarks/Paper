package io.papermc.paper.configuration.transformation.world.versioned;

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
import org.spongepowered.configurate.transformation.ConfigurationTransformation;
import org.spongepowered.configurate.transformation.ConfigurationTransformation.VersionedBuilder;

class V30_RenameFilterNbtFromSpawnEggDiffblueTest {
  /**
   * Test {@link V30_RenameFilterNbtFromSpawnEgg#apply(VersionedBuilder)}.
   *
   * <ul>
   *   <li>Given versionedBuilder.
   *   <li>Then calls {@link VersionedBuilder#addVersion(int, ConfigurationTransformation)}.
   * </ul>
   *
   * <p>Method under test: {@link V30_RenameFilterNbtFromSpawnEgg#apply(VersionedBuilder)}
   */
  @Test
  @DisplayName(
      "Test apply(VersionedBuilder); given versionedBuilder; then calls addVersion(int, ConfigurationTransformation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V30_RenameFilterNbtFromSpawnEgg.apply(VersionedBuilder)"})
  void testApply_givenVersionedBuilder_thenCallsAddVersion() {
    // Arrange
    VersionedBuilder builder = mock(VersionedBuilder.class);
    when(builder.addVersion(anyInt(), Mockito.<ConfigurationTransformation>any()))
        .thenReturn(ConfigurationTransformation.versionedBuilder());

    // Act
    V30_RenameFilterNbtFromSpawnEgg.apply(builder);

    // Assert
    verify(builder).addVersion(eq(30), isA(ConfigurationTransformation.class));
  }
}

package io.papermc.paper.datapack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.adventure.AdventureComponent;
import io.papermc.paper.datapack.Datapack.Compatibility;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import net.minecraft.server.packs.FilePackResources;
import net.minecraft.server.packs.FilePackResources.FileResourcesSupplier;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.repository.KnownPack;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.Pack.Metadata;
import net.minecraft.server.packs.repository.Pack.Position;
import net.minecraft.server.packs.repository.PackCompatibility;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperDiscoveredDatapackDiffblueTest {
  /**
   * Test {@link PaperDiscoveredDatapack#getName()}.
   *
   * <ul>
   *   <li>Given of {@link KnownPack#KnownPack(String, String, String)} with {@code Namespace} and
   *       id is {@code 42} and version is {@code 1.0.2}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDiscoveredDatapack#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given of KnownPack(String, String, String) with 'Namespace' and id is '42' and version is '1.0.2'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PaperDiscoveredDatapack.getName()"})
  void testGetName_givenOfKnownPackWithNamespaceAndIdIs42AndVersionIs102_thenReturn42() {
    // Arrange
    AdventureComponent title = new AdventureComponent(mock(Component.class));
    KnownPack knownPack = new KnownPack("Namespace", "42", "1.0.2");
    Optional<KnownPack> knownPackInfo = Optional.of(knownPack);

    PackLocationInfo location =
        new PackLocationInfo("42", title, PluginPackSource.INSTANCE, knownPackInfo);
    FileResourcesSupplier resources = new FileResourcesSupplier(OldUsersConverter.OLD_IPBANLIST);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    Metadata metadata =
        new Metadata(
            description, PackCompatibility.TOO_OLD, FeatureFlags.DEFAULT_FLAGS, new ArrayList<>());

    Pack pack =
        new Pack(location, resources, metadata, new PackSelectionConfig(true, Position.TOP, true));

    // Act and Assert
    assertEquals("42", new PaperDiscoveredDatapack(pack).getName());
  }

  /**
   * Test {@link PaperDiscoveredDatapack#getTitle()}.
   *
   * <ul>
   *   <li>Then return insertion is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDiscoveredDatapack#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); then return insertion is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component PaperDiscoveredDatapack.getTitle()"})
  void testGetTitle_thenReturnInsertionIsNull() {
    // Arrange
    KnownPack knownPack = new KnownPack("Namespace", "42", "1.0.2");
    Optional<KnownPack> knownPackInfo = Optional.of(knownPack);
    PackLocationInfo location =
        new PackLocationInfo("42", null, PluginPackSource.INSTANCE, knownPackInfo);
    FileResourcesSupplier resources = new FileResourcesSupplier(OldUsersConverter.OLD_IPBANLIST);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    Metadata metadata =
        new Metadata(
            description, PackCompatibility.TOO_OLD, FeatureFlags.DEFAULT_FLAGS, new ArrayList<>());

    Pack pack =
        new Pack(location, resources, metadata, new PackSelectionConfig(true, Position.TOP, true));

    // Act
    Component actualTitle = new PaperDiscoveredDatapack(pack).getTitle();

    // Assert
    assertNull(actualTitle.insertion());
    assertNull(actualTitle.font());
    assertNull(actualTitle.color());
    Map<TextDecoration, State> decorationsResult = actualTitle.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.ITALIC));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(actualTitle.hasStyling());
    Component actualCompactResult = actualTitle.compact();
    assertSame(actualTitle, actualCompactResult);
  }

  /**
   * Test {@link PaperDiscoveredDatapack#getDescription()}.
   *
   * <ul>
   *   <li>Then return insertion is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDiscoveredDatapack#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); then return insertion is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component PaperDiscoveredDatapack.getDescription()"})
  void testGetDescription_thenReturnInsertionIsNull() {
    // Arrange
    AdventureComponent title = new AdventureComponent(mock(Component.class));
    KnownPack knownPack = new KnownPack("Namespace", "42", "1.0.2");
    Optional<KnownPack> knownPackInfo = Optional.of(knownPack);

    PackLocationInfo location =
        new PackLocationInfo("42", title, PluginPackSource.INSTANCE, knownPackInfo);
    FileResourcesSupplier resources = new FileResourcesSupplier(OldUsersConverter.OLD_IPBANLIST);
    Metadata metadata =
        new Metadata(
            null, PackCompatibility.TOO_OLD, FeatureFlags.DEFAULT_FLAGS, new ArrayList<>());

    Pack pack =
        new Pack(location, resources, metadata, new PackSelectionConfig(true, Position.TOP, true));

    // Act
    Component actualDescription = new PaperDiscoveredDatapack(pack).getDescription();

    // Assert
    assertNull(actualDescription.insertion());
    assertNull(actualDescription.font());
    assertNull(actualDescription.color());
    Map<TextDecoration, State> decorationsResult = actualDescription.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.ITALIC));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(actualDescription.hasStyling());
    Component actualCompactResult = actualDescription.compact();
    assertSame(actualDescription, actualCompactResult);
  }

  /**
   * Test {@link PaperDiscoveredDatapack#isRequired()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDiscoveredDatapack#isRequired()}
   */
  @Test
  @DisplayName("Test isRequired(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperDiscoveredDatapack.isRequired()"})
  void testIsRequired_thenReturnFalse() {
    // Arrange
    AdventureComponent title = new AdventureComponent(mock(Component.class));
    KnownPack knownPack = new KnownPack("Namespace", "42", "1.0.2");
    Optional<KnownPack> knownPackInfo = Optional.of(knownPack);

    PackLocationInfo location =
        new PackLocationInfo("42", title, PluginPackSource.INSTANCE, knownPackInfo);
    FileResourcesSupplier resources = new FileResourcesSupplier(OldUsersConverter.OLD_IPBANLIST);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    Metadata metadata =
        new Metadata(
            description, PackCompatibility.TOO_OLD, FeatureFlags.DEFAULT_FLAGS, new ArrayList<>());

    Pack pack =
        new Pack(location, resources, metadata, new PackSelectionConfig(false, Position.TOP, true));

    // Act and Assert
    assertFalse(new PaperDiscoveredDatapack(pack).isRequired());
  }

  /**
   * Test {@link PaperDiscoveredDatapack#isRequired()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDiscoveredDatapack#isRequired()}
   */
  @Test
  @DisplayName("Test isRequired(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperDiscoveredDatapack.isRequired()"})
  void testIsRequired_thenReturnTrue() {
    // Arrange
    AdventureComponent title = new AdventureComponent(mock(Component.class));
    KnownPack knownPack = new KnownPack("Namespace", "42", "1.0.2");
    Optional<KnownPack> knownPackInfo = Optional.of(knownPack);

    PackLocationInfo location =
        new PackLocationInfo("42", title, PluginPackSource.INSTANCE, knownPackInfo);
    FileResourcesSupplier resources = new FileResourcesSupplier(OldUsersConverter.OLD_IPBANLIST);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    Metadata metadata =
        new Metadata(
            description, PackCompatibility.TOO_OLD, FeatureFlags.DEFAULT_FLAGS, new ArrayList<>());

    Pack pack =
        new Pack(location, resources, metadata, new PackSelectionConfig(true, Position.TOP, true));

    // Act and Assert
    assertTrue(new PaperDiscoveredDatapack(pack).isRequired());
  }

  /**
   * Test {@link PaperDiscoveredDatapack#getCompatibility()}.
   *
   * <ul>
   *   <li>Then return {@code TOO_OLD}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDiscoveredDatapack#getCompatibility()}
   */
  @Test
  @DisplayName("Test getCompatibility(); then return 'TOO_OLD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Compatibility PaperDiscoveredDatapack.getCompatibility()"})
  void testGetCompatibility_thenReturnTooOld() {
    // Arrange
    AdventureComponent title = new AdventureComponent(mock(Component.class));
    KnownPack knownPack = new KnownPack("Namespace", "42", "1.0.2");
    Optional<KnownPack> knownPackInfo = Optional.of(knownPack);

    PackLocationInfo location =
        new PackLocationInfo("42", title, PluginPackSource.INSTANCE, knownPackInfo);
    FileResourcesSupplier resources = new FileResourcesSupplier(OldUsersConverter.OLD_IPBANLIST);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    Metadata metadata =
        new Metadata(
            description, PackCompatibility.TOO_OLD, FeatureFlags.DEFAULT_FLAGS, new ArrayList<>());

    Pack pack =
        new Pack(location, resources, metadata, new PackSelectionConfig(true, Position.TOP, true));

    // Act and Assert
    assertEquals(Compatibility.TOO_OLD, new PaperDiscoveredDatapack(pack).getCompatibility());
  }

  /**
   * Test {@link PaperDiscoveredDatapack#getRequiredFeatures()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperDiscoveredDatapack#getRequiredFeatures()}
   */
  @Test
  @DisplayName("Test getRequiredFeatures(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PaperDiscoveredDatapack.getRequiredFeatures()"})
  void testGetRequiredFeatures_thenReturnEmpty() {
    // Arrange
    AdventureComponent title = new AdventureComponent(mock(Component.class));
    KnownPack knownPack = new KnownPack("Namespace", "42", "1.0.2");
    Optional<KnownPack> knownPackInfo = Optional.of(knownPack);

    PackLocationInfo location =
        new PackLocationInfo("42", title, PluginPackSource.INSTANCE, knownPackInfo);
    FileResourcesSupplier resources = new FileResourcesSupplier(OldUsersConverter.OLD_IPBANLIST);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    FeatureFlagSet requestedFeatures = FeatureFlagSet.of();

    Metadata metadata =
        new Metadata(description, PackCompatibility.TOO_OLD, requestedFeatures, new ArrayList<>());

    Pack pack =
        new Pack(location, resources, metadata, new PackSelectionConfig(true, Position.TOP, true));

    // Act and Assert
    assertTrue(new PaperDiscoveredDatapack(pack).getRequiredFeatures().isEmpty());
  }

  /**
   * Test {@link PaperDiscoveredDatapack#getRequiredFeatures()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PaperDiscoveredDatapack#getRequiredFeatures()}
   */
  @Test
  @DisplayName("Test getRequiredFeatures(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PaperDiscoveredDatapack.getRequiredFeatures()"})
  void testGetRequiredFeatures_thenReturnSizeIsOne() {
    // Arrange
    AdventureComponent title = new AdventureComponent(mock(Component.class));
    KnownPack knownPack = new KnownPack("Namespace", "42", "1.0.2");
    Optional<KnownPack> knownPackInfo = Optional.of(knownPack);

    PackLocationInfo location =
        new PackLocationInfo("42", title, PluginPackSource.INSTANCE, knownPackInfo);
    FileResourcesSupplier resources = new FileResourcesSupplier(OldUsersConverter.OLD_IPBANLIST);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    Metadata metadata =
        new Metadata(
            description, PackCompatibility.TOO_OLD, FeatureFlags.DEFAULT_FLAGS, new ArrayList<>());

    Pack pack =
        new Pack(location, resources, metadata, new PackSelectionConfig(true, Position.TOP, true));

    // Act and Assert
    assertEquals(1, new PaperDiscoveredDatapack(pack).getRequiredFeatures().size());
  }

  /**
   * Test {@link PaperDiscoveredDatapack#getSource()}.
   *
   * <ul>
   *   <li>Then return {@link DatapackSourceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDiscoveredDatapack#getSource()}
   */
  @Test
  @DisplayName("Test getSource(); then return DatapackSourceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DatapackSource PaperDiscoveredDatapack.getSource()"})
  void testGetSource_thenReturnDatapackSourceImpl() {
    // Arrange
    AdventureComponent title = new AdventureComponent(mock(Component.class));
    KnownPack knownPack = new KnownPack("Namespace", "42", "1.0.2");
    Optional<KnownPack> knownPackInfo = Optional.of(knownPack);

    PackLocationInfo location =
        new PackLocationInfo("42", title, PluginPackSource.INSTANCE, knownPackInfo);
    FileResourcesSupplier resources = new FileResourcesSupplier(OldUsersConverter.OLD_IPBANLIST);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    Metadata metadata =
        new Metadata(
            description, PackCompatibility.TOO_OLD, FeatureFlags.DEFAULT_FLAGS, new ArrayList<>());

    Pack pack =
        new Pack(location, resources, metadata, new PackSelectionConfig(true, Position.TOP, true));

    // Act
    DatapackSource actualSource = new PaperDiscoveredDatapack(pack).getSource();

    // Assert
    assertTrue(actualSource instanceof DatapackSourceImpl);
    assertEquals("plugin", ((DatapackSourceImpl) actualSource).name());
    assertEquals("plugin", actualSource.toString());
  }

  /**
   * Test {@link PaperDiscoveredDatapack#getSource()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDiscoveredDatapack#getSource()}
   */
  @Test
  @DisplayName("Test getSource(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DatapackSource PaperDiscoveredDatapack.getSource()"})
  void testGetSource_thenReturnNull() {
    // Arrange
    AdventureComponent title = new AdventureComponent(mock(Component.class));
    PackSource source = mock(PackSource.class);
    KnownPack knownPack = new KnownPack("Namespace", "42", "1.0.2");
    Optional<KnownPack> knownPackInfo = Optional.of(knownPack);

    PackLocationInfo location = new PackLocationInfo("42", title, source, knownPackInfo);
    FileResourcesSupplier resources = new FileResourcesSupplier(OldUsersConverter.OLD_IPBANLIST);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    Metadata metadata =
        new Metadata(
            description, PackCompatibility.TOO_OLD, FeatureFlags.DEFAULT_FLAGS, new ArrayList<>());

    Pack pack =
        new Pack(location, resources, metadata, new PackSelectionConfig(true, Position.TOP, true));

    // Act and Assert
    assertNull(new PaperDiscoveredDatapack(pack).getSource());
  }
}

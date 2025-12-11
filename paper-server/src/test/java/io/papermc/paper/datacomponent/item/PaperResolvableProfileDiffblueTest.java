package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.destroystokyo.paper.profile.CraftPlayerProfile;
import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import io.papermc.paper.datacomponent.item.PaperResolvableProfile.BuilderImpl;
import io.papermc.paper.datacomponent.item.ResolvableProfile.Builder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import net.minecraft.Util;
import net.minecraft.server.MinecraftServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperResolvableProfileDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#addProperties(Collection)}.
   *
   * <p>Method under test: {@link BuilderImpl#addProperties(Collection)}
   */
  @Test
  @DisplayName("Test BuilderImpl addProperties(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addProperties(Collection)"})
  void testBuilderImplAddProperties() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    ArrayList<ProfileProperty> properties = new ArrayList<>();
    properties.add(new ProfileProperty("Name", "42"));

    // Act
    Builder actualAddPropertiesResult = builderImpl.addProperties(properties);

    // Assert
    ResolvableProfile resolvableProfile = actualAddPropertiesResult.build();
    assertTrue(resolvableProfile instanceof PaperResolvableProfile);
    ResolvableProfile resolvableProfile2 = builderImpl.build();
    assertTrue(resolvableProfile2 instanceof PaperResolvableProfile);
    assertTrue(actualAddPropertiesResult instanceof BuilderImpl);
    net.minecraft.world.item.component.ResolvableProfile handle =
        ((PaperResolvableProfile) resolvableProfile2).getHandle();
    PropertyMap properties2 = handle.gameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties2.entries();
    assertEquals(1, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    net.minecraft.world.item.component.ResolvableProfile handle2 =
        ((PaperResolvableProfile) resolvableProfile).getHandle();
    PropertyMap propertiesResult = handle2.properties();
    Collection<Entry<String, Property>> entriesResult2 = propertiesResult.entries();
    assertEquals(1, entriesResult2.size());
    assertTrue(entriesResult2 instanceof Set);
    PropertyMap propertiesResult2 = handle.properties();
    Collection<Entry<String, Property>> entriesResult3 = propertiesResult2.entries();
    assertEquals(1, entriesResult3.size());
    assertTrue(entriesResult3 instanceof Set);
    assertEquals(1, handle2.gameProfile().getProperties().size());
    assertEquals(1, properties2.size());
    assertEquals(1, propertiesResult.size());
    assertEquals(1, propertiesResult2.size());
    assertEquals(1, properties2.keys().size());
    assertEquals(1, propertiesResult.keys().size());
    assertEquals(1, propertiesResult2.keys().size());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addProperties(Collection)}.
   *
   * <p>Method under test: {@link BuilderImpl#addProperties(Collection)}
   */
  @Test
  @DisplayName("Test BuilderImpl addProperties(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addProperties(Collection)"})
  void testBuilderImplAddProperties2() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    ArrayList<ProfileProperty> properties = new ArrayList<>();
    properties.add(new ProfileProperty("Cannot have more than 16 properties, was %s", "42"));
    properties.add(new ProfileProperty("Name", "42"));

    // Act
    Builder actualAddPropertiesResult = builderImpl.addProperties(properties);

    // Assert
    ResolvableProfile resolvableProfile = actualAddPropertiesResult.build();
    assertTrue(resolvableProfile instanceof PaperResolvableProfile);
    ResolvableProfile resolvableProfile2 = builderImpl.build();
    assertTrue(resolvableProfile2 instanceof PaperResolvableProfile);
    assertTrue(actualAddPropertiesResult instanceof BuilderImpl);
    net.minecraft.world.item.component.ResolvableProfile handle =
        ((PaperResolvableProfile) resolvableProfile2).getHandle();
    PropertyMap properties2 = handle.gameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties2.entries();
    assertEquals(2, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    net.minecraft.world.item.component.ResolvableProfile handle2 =
        ((PaperResolvableProfile) resolvableProfile).getHandle();
    PropertyMap propertiesResult = handle2.properties();
    Collection<Entry<String, Property>> entriesResult2 = propertiesResult.entries();
    assertEquals(2, entriesResult2.size());
    assertTrue(entriesResult2 instanceof Set);
    PropertyMap propertiesResult2 = handle.properties();
    Collection<Entry<String, Property>> entriesResult3 = propertiesResult2.entries();
    assertEquals(2, entriesResult3.size());
    assertTrue(entriesResult3 instanceof Set);
    assertEquals(2, handle2.gameProfile().getProperties().size());
    assertEquals(2, properties2.size());
    assertEquals(2, propertiesResult.size());
    assertEquals(2, propertiesResult2.size());
    assertEquals(2, properties2.keys().size());
    assertEquals(2, propertiesResult.keys().size());
    assertEquals(2, propertiesResult2.keys().size());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addProperties(Collection)}.
   *
   * <p>Method under test: {@link BuilderImpl#addProperties(Collection)}
   */
  @Test
  @DisplayName("Test BuilderImpl addProperties(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addProperties(Collection)"})
  void testBuilderImplAddProperties3() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    ArrayList<ProfileProperty> properties = new ArrayList<>();
    properties.add(new ProfileProperty("Cannot have more than 16 properties, was %s", "42"));
    properties.add(new ProfileProperty("Cannot have more than 16 properties, was %s", "42"));
    properties.add(new ProfileProperty("Name", "42"));

    // Act
    Builder actualAddPropertiesResult = builderImpl.addProperties(properties);

    // Assert
    ResolvableProfile resolvableProfile = actualAddPropertiesResult.build();
    assertTrue(resolvableProfile instanceof PaperResolvableProfile);
    ResolvableProfile resolvableProfile2 = builderImpl.build();
    assertTrue(resolvableProfile2 instanceof PaperResolvableProfile);
    assertTrue(actualAddPropertiesResult instanceof BuilderImpl);
    net.minecraft.world.item.component.ResolvableProfile handle =
        ((PaperResolvableProfile) resolvableProfile2).getHandle();
    PropertyMap properties2 = handle.gameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties2.entries();
    assertEquals(2, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    net.minecraft.world.item.component.ResolvableProfile handle2 =
        ((PaperResolvableProfile) resolvableProfile).getHandle();
    PropertyMap propertiesResult = handle2.properties();
    Collection<Entry<String, Property>> entriesResult2 = propertiesResult.entries();
    assertEquals(2, entriesResult2.size());
    assertTrue(entriesResult2 instanceof Set);
    PropertyMap propertiesResult2 = handle.properties();
    Collection<Entry<String, Property>> entriesResult3 = propertiesResult2.entries();
    assertEquals(2, entriesResult3.size());
    assertTrue(entriesResult3 instanceof Set);
    assertEquals(2, handle2.gameProfile().getProperties().size());
    assertEquals(2, properties2.size());
    assertEquals(2, propertiesResult.size());
    assertEquals(2, propertiesResult2.size());
    assertEquals(2, properties2.keys().size());
    assertEquals(2, propertiesResult.keys().size());
    assertEquals(2, propertiesResult2.keys().size());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addProperties(Collection)}.
   *
   * <p>Method under test: {@link BuilderImpl#addProperties(Collection)}
   */
  @Test
  @DisplayName("Test BuilderImpl addProperties(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addProperties(Collection)"})
  void testBuilderImplAddProperties4() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    ArrayList<ProfileProperty> properties = new ArrayList<>();
    properties.add(new ProfileProperty("Cannot have more than 16 properties, was %s", "42"));
    ProfileProperty profileProperty =
        new ProfileProperty(
            "Cannot have more than 16 properties, was %s",
            "42", "Cannot have more than 16 properties, was %s");
    properties.add(profileProperty);

    // Act
    Builder actualAddPropertiesResult = builderImpl.addProperties(properties);

    // Assert
    ResolvableProfile resolvableProfile = actualAddPropertiesResult.build();
    assertTrue(resolvableProfile instanceof PaperResolvableProfile);
    ResolvableProfile resolvableProfile2 = builderImpl.build();
    assertTrue(resolvableProfile2 instanceof PaperResolvableProfile);
    assertTrue(actualAddPropertiesResult instanceof BuilderImpl);
    net.minecraft.world.item.component.ResolvableProfile handle =
        ((PaperResolvableProfile) resolvableProfile2).getHandle();
    PropertyMap properties2 = handle.gameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties2.entries();
    assertEquals(2, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    net.minecraft.world.item.component.ResolvableProfile handle2 =
        ((PaperResolvableProfile) resolvableProfile).getHandle();
    PropertyMap propertiesResult = handle2.properties();
    Collection<Entry<String, Property>> entriesResult2 = propertiesResult.entries();
    assertEquals(2, entriesResult2.size());
    assertTrue(entriesResult2 instanceof Set);
    PropertyMap propertiesResult2 = handle.properties();
    Collection<Entry<String, Property>> entriesResult3 = propertiesResult2.entries();
    assertEquals(2, entriesResult3.size());
    assertTrue(entriesResult3 instanceof Set);
    assertEquals(2, handle2.gameProfile().getProperties().size());
    assertEquals(2, properties2.size());
    assertEquals(2, propertiesResult.size());
    assertEquals(2, propertiesResult2.size());
    assertEquals(2, properties2.keys().size());
    assertEquals(2, propertiesResult.keys().size());
    assertEquals(2, propertiesResult2.keys().size());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addProperties(Collection)}.
   *
   * <ul>
   *   <li>Then return build Handle properties size is zero.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addProperties(Collection)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addProperties(Collection); then return build Handle properties size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addProperties(Collection)"})
  void testBuilderImplAddProperties_thenReturnBuildHandlePropertiesSizeIsZero() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddPropertiesResult = builderImpl.addProperties(new ArrayList<>());

    // Assert
    ResolvableProfile resolvableProfile = actualAddPropertiesResult.build();
    assertTrue(resolvableProfile instanceof PaperResolvableProfile);
    ResolvableProfile resolvableProfile2 = builderImpl.build();
    assertTrue(resolvableProfile2 instanceof PaperResolvableProfile);
    assertTrue(actualAddPropertiesResult instanceof BuilderImpl);
    PropertyMap propertiesResult =
        ((PaperResolvableProfile) resolvableProfile).getHandle().properties();
    Collection<Entry<String, Property>> entriesResult = propertiesResult.entries();
    assertTrue(entriesResult instanceof Set);
    PropertyMap propertiesResult2 =
        ((PaperResolvableProfile) resolvableProfile2).getHandle().properties();
    Collection<Entry<String, Property>> entriesResult2 = propertiesResult2.entries();
    assertTrue(entriesResult2 instanceof Set);
    assertEquals(0, propertiesResult.size());
    assertEquals(0, propertiesResult2.size());
    assertTrue(propertiesResult.isEmpty());
    assertTrue(entriesResult.isEmpty());
    assertTrue(entriesResult2.isEmpty());
    assertTrue(propertiesResult.keys().isEmpty());
    assertTrue(propertiesResult2.keys().isEmpty());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addProperty(ProfileProperty)}.
   *
   * <p>Method under test: {@link BuilderImpl#addProperty(ProfileProperty)}
   */
  @Test
  @DisplayName("Test BuilderImpl addProperty(ProfileProperty)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addProperty(ProfileProperty)"})
  void testBuilderImplAddProperty() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    builderImpl.addProperty(new ProfileProperty("Name", "42"));

    // Assert
    ResolvableProfile resolvableProfile = builderImpl.build();
    assertTrue(resolvableProfile instanceof PaperResolvableProfile);
    net.minecraft.world.item.component.ResolvableProfile handle =
        ((PaperResolvableProfile) resolvableProfile).getHandle();
    PropertyMap properties = handle.gameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties.entries();
    assertEquals(1, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    PropertyMap propertiesResult = handle.properties();
    Collection<Entry<String, Property>> entriesResult2 = propertiesResult.entries();
    assertEquals(1, entriesResult2.size());
    assertTrue(entriesResult2 instanceof Set);
    assertEquals(1, properties.size());
    assertEquals(1, propertiesResult.size());
    assertEquals(1, properties.keys().size());
    assertEquals(1, propertiesResult.keys().size());
    assertFalse(properties.isEmpty());
    assertFalse(propertiesResult.isEmpty());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addProperty(ProfileProperty)}.
   *
   * <p>Method under test: {@link BuilderImpl#addProperty(ProfileProperty)}
   */
  @Test
  @DisplayName("Test BuilderImpl addProperty(ProfileProperty)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addProperty(ProfileProperty)"})
  void testBuilderImplAddProperty2() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    builderImpl.addProperty(new ProfileProperty("Name", "42"));

    // Act
    builderImpl.addProperty(new ProfileProperty("Name", "42"));

    // Assert that nothing has changed
    ResolvableProfile resolvableProfile = builderImpl.build();
    assertTrue(resolvableProfile instanceof PaperResolvableProfile);
    net.minecraft.world.item.component.ResolvableProfile handle =
        ((PaperResolvableProfile) resolvableProfile).getHandle();
    PropertyMap properties = handle.gameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties.entries();
    assertEquals(1, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    PropertyMap propertiesResult = handle.properties();
    Collection<Entry<String, Property>> entriesResult2 = propertiesResult.entries();
    assertEquals(1, entriesResult2.size());
    assertTrue(entriesResult2 instanceof Set);
    assertEquals(1, properties.size());
    assertEquals(1, propertiesResult.size());
    assertEquals(1, properties.keys().size());
    assertEquals(1, propertiesResult.keys().size());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addProperty(ProfileProperty)}.
   *
   * <ul>
   *   <li>Then build return {@link PaperResolvableProfile}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addProperty(ProfileProperty)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addProperty(ProfileProperty); then build return PaperResolvableProfile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addProperty(ProfileProperty)"})
  void testBuilderImplAddProperty_thenBuildReturnPaperResolvableProfile() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    builderImpl.addProperty(new ProfileProperty("Name", "Value"));

    // Act
    Builder actualAddPropertyResult = builderImpl.addProperty(new ProfileProperty("Name", "42"));

    // Assert
    ResolvableProfile resolvableProfile = actualAddPropertyResult.build();
    assertTrue(resolvableProfile instanceof PaperResolvableProfile);
    ResolvableProfile resolvableProfile2 = builderImpl.build();
    assertTrue(resolvableProfile2 instanceof PaperResolvableProfile);
    assertTrue(actualAddPropertyResult instanceof BuilderImpl);
    net.minecraft.world.item.component.ResolvableProfile handle =
        ((PaperResolvableProfile) resolvableProfile2).getHandle();
    PropertyMap properties = handle.gameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties.entries();
    assertEquals(2, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    net.minecraft.world.item.component.ResolvableProfile handle2 =
        ((PaperResolvableProfile) resolvableProfile).getHandle();
    PropertyMap propertiesResult = handle2.properties();
    Collection<Entry<String, Property>> entriesResult2 = propertiesResult.entries();
    assertEquals(2, entriesResult2.size());
    assertTrue(entriesResult2 instanceof Set);
    PropertyMap propertiesResult2 = handle.properties();
    Collection<Entry<String, Property>> entriesResult3 = propertiesResult2.entries();
    assertEquals(2, entriesResult3.size());
    assertTrue(entriesResult3 instanceof Set);
    assertEquals(2, handle2.gameProfile().getProperties().size());
    assertEquals(2, properties.size());
    assertEquals(2, propertiesResult.size());
    assertEquals(2, propertiesResult2.size());
    assertEquals(2, properties.keys().size());
    assertEquals(2, propertiesResult.keys().size());
    assertEquals(2, propertiesResult2.keys().size());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#build()}.
   *
   * <p>Method under test: {@link BuilderImpl#build()}
   */
  @Test
  @DisplayName("Test BuilderImpl build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolvableProfile BuilderImpl.build()", "Builder BuilderImpl.uuid(UUID)"})
  void testBuilderImplBuild() {
    // Arrange and Act
    ResolvableProfile actualResolvableProfile = new BuilderImpl().build();

    // Assert
    assertTrue(actualResolvableProfile instanceof PaperResolvableProfile);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#name(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return build Handle name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#name(String)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl name(String); when empty string; then return build Handle name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.name(String)"})
  void testBuilderImplName_whenEmptyString_thenReturnBuildHandleNameIsEmptyString() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualNameResult = builderImpl.name("");

    // Assert
    ResolvableProfile resolvableProfile = actualNameResult.build();
    assertTrue(resolvableProfile instanceof PaperResolvableProfile);
    ResolvableProfile resolvableProfile2 = builderImpl.build();
    assertTrue(resolvableProfile2 instanceof PaperResolvableProfile);
    assertTrue(actualNameResult instanceof BuilderImpl);
    net.minecraft.world.item.component.ResolvableProfile handle =
        ((PaperResolvableProfile) resolvableProfile).getHandle();
    assertEquals("", handle.name().get());
    assertEquals("", ((PaperResolvableProfile) resolvableProfile2).getHandle().name().get());
    assertSame(handle, ((PaperResolvableProfile) resolvableProfile).impl());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return build Handle gameProfile Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#name(String)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl name(String); when 'Name'; then return build Handle gameProfile Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.name(String)"})
  void testBuilderImplName_whenName_thenReturnBuildHandleGameProfileNameIsName() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualNameResult = builderImpl.name("Name");

    // Assert
    ResolvableProfile resolvableProfile = actualNameResult.build();
    assertTrue(resolvableProfile instanceof PaperResolvableProfile);
    ResolvableProfile resolvableProfile2 = builderImpl.build();
    assertTrue(resolvableProfile2 instanceof PaperResolvableProfile);
    assertTrue(actualNameResult instanceof BuilderImpl);
    net.minecraft.world.item.component.ResolvableProfile handle =
        ((PaperResolvableProfile) resolvableProfile).getHandle();
    assertEquals("Name", handle.gameProfile().getName());
    net.minecraft.world.item.component.ResolvableProfile handle2 =
        ((PaperResolvableProfile) resolvableProfile2).getHandle();
    assertEquals("Name", handle2.gameProfile().getName());
    assertEquals("Name", handle.name().get());
    assertEquals("Name", handle2.name().get());
    assertSame(handle, ((PaperResolvableProfile) resolvableProfile).impl());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#name(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return build Handle gameProfile Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#name(String)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl name(String); when 'null'; then return build Handle gameProfile Name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.name(String)"})
  void testBuilderImplName_whenNull_thenReturnBuildHandleGameProfileNameIsEmptyString() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualNameResult = builderImpl.name(null);

    // Assert
    ResolvableProfile resolvableProfile = actualNameResult.build();
    assertTrue(resolvableProfile instanceof PaperResolvableProfile);
    ResolvableProfile resolvableProfile2 = builderImpl.build();
    assertTrue(resolvableProfile2 instanceof PaperResolvableProfile);
    assertTrue(actualNameResult instanceof BuilderImpl);
    net.minecraft.world.item.component.ResolvableProfile handle =
        ((PaperResolvableProfile) resolvableProfile).getHandle();
    assertEquals("", handle.gameProfile().getName());
    assertEquals(
        "", ((PaperResolvableProfile) resolvableProfile2).getHandle().gameProfile().getName());
    assertSame(handle, ((PaperResolvableProfile) resolvableProfile).impl());
  }

  /**
   * Test BuilderImpl new {@link BuilderImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BuilderImpl}
   */
  @Test
  @DisplayName("Test BuilderImpl new BuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuilderImpl.<init>()"})
  void testBuilderImplNewBuilderImpl() {
    // Arrange, Act and Assert
    ResolvableProfile resolvableProfile = new BuilderImpl().build();
    assertTrue(resolvableProfile instanceof PaperResolvableProfile);
    net.minecraft.world.item.component.ResolvableProfile handle =
        ((PaperResolvableProfile) resolvableProfile).getHandle();
    PropertyMap propertiesResult = handle.properties();
    Collection<Entry<String, Property>> entriesResult = propertiesResult.entries();
    assertTrue(entriesResult instanceof Set);
    GameProfile gameProfileResult = handle.gameProfile();
    assertEquals("", gameProfileResult.getName());
    assertEquals("00000000-0000-0000-0000-000000000000", gameProfileResult.getId().toString());
    assertEquals(0, propertiesResult.size());
    Optional<UUID> idResult = handle.id();
    assertFalse(idResult.isPresent());
    assertTrue(propertiesResult.isEmpty());
    assertTrue(entriesResult.isEmpty());
    assertTrue(propertiesResult.keys().isEmpty());
    assertEquals(propertiesResult, gameProfileResult.getProperties());
    assertSame(handle, ((PaperResolvableProfile) resolvableProfile).impl());
    assertSame(idResult, handle.name());
  }

  /**
   * Test {@link PaperResolvableProfile#toApi(PlayerProfile)}.
   *
   * <ul>
   *   <li>Then Handle properties entries return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link PaperResolvableProfile#toApi(PlayerProfile)}
   */
  @Test
  @DisplayName("Test toApi(PlayerProfile); then Handle properties entries return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperResolvableProfile PaperResolvableProfile.toApi(PlayerProfile)"})
  void testToApi_thenHandlePropertiesEntriesReturnSet() {
    // Arrange
    GameProfile profile = new GameProfile(Util.NIL_UUID, "Name");

    // Act
    PaperResolvableProfile actualToApiResult =
        PaperResolvableProfile.toApi(new CraftPlayerProfile(profile));

    // Assert
    net.minecraft.world.item.component.ResolvableProfile handle = actualToApiResult.getHandle();
    PropertyMap propertiesResult = handle.properties();
    Collection<Entry<String, Property>> entriesResult = propertiesResult.entries();
    assertTrue(entriesResult instanceof Set);
    Optional<String> nameResult = handle.name();
    assertEquals("Name", nameResult.get());
    assertEquals(0, propertiesResult.size());
    assertTrue(propertiesResult.isEmpty());
    assertTrue(entriesResult.isEmpty());
    assertTrue(propertiesResult.keys().isEmpty());
    assertTrue(handle.id().isPresent());
    assertTrue(nameResult.isPresent());
    assertEquals(profile, handle.gameProfile());
    assertSame(handle, actualToApiResult.impl());
  }

  /**
   * Test {@link PaperResolvableProfile#getHandle()}.
   *
   * <p>Method under test: {@link PaperResolvableProfile#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.world.item.component.ResolvableProfile PaperResolvableProfile.getHandle()"
  })
  void testGetHandle() {
    // Arrange
    net.minecraft.world.item.component.ResolvableProfile impl =
        new net.minecraft.world.item.component.ResolvableProfile(
            MinecraftServer.ANONYMOUS_PLAYER_PROFILE);

    // Act and Assert
    assertSame(impl, new PaperResolvableProfile(impl).getHandle());
  }

  /**
   * Test {@link PaperResolvableProfile#uuid()}.
   *
   * <ul>
   *   <li>Then return toString is {@code 00000000-0000-0000-0000-000000000000}.
   * </ul>
   *
   * <p>Method under test: {@link PaperResolvableProfile#uuid()}
   */
  @Test
  @DisplayName("Test uuid(); then return toString is '00000000-0000-0000-0000-000000000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID PaperResolvableProfile.uuid()"})
  void testUuid_thenReturnToStringIs00000000000000000000000000000000() {
    // Arrange, Act and Assert
    assertEquals(
        "00000000-0000-0000-0000-000000000000",
        new PaperResolvableProfile(
                new net.minecraft.world.item.component.ResolvableProfile(
                    MinecraftServer.ANONYMOUS_PLAYER_PROFILE))
            .uuid()
            .toString());
  }

  /**
   * Test {@link PaperResolvableProfile#name()}.
   *
   * <ul>
   *   <li>Then return {@code Anonymous Player}.
   * </ul>
   *
   * <p>Method under test: {@link PaperResolvableProfile#name()}
   */
  @Test
  @DisplayName("Test name(); then return 'Anonymous Player'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaperResolvableProfile.name()"})
  void testName_thenReturnAnonymousPlayer() {
    // Arrange, Act and Assert
    assertEquals(
        "Anonymous Player",
        new PaperResolvableProfile(
                new net.minecraft.world.item.component.ResolvableProfile(
                    MinecraftServer.ANONYMOUS_PLAYER_PROFILE))
            .name());
  }

  /**
   * Test {@link PaperResolvableProfile#resolve()}.
   *
   * <ul>
   *   <li>Given {@link GameProfile#GameProfile(UUID, String)} with id is {@link Util#NIL_UUID} and
   *       {@code Name}.
   *   <li>Then return {@link CompletableFuture#get()} Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PaperResolvableProfile#resolve()}
   */
  @Test
  @DisplayName(
      "Test resolve(); given GameProfile(UUID, String) with id is NIL_UUID and 'Name'; then return get() Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture PaperResolvableProfile.resolve()"})
  void testResolve_givenGameProfileWithIdIsNil_uuidAndName_thenReturnGetNameIsName()
      throws InterruptedException, ExecutionException {
    // Arrange
    GameProfile profile = new GameProfile(Util.NIL_UUID, "Name");

    // Act and Assert
    PlayerProfile getResult =
        new PaperResolvableProfile(
                new net.minecraft.world.item.component.ResolvableProfile(profile))
            .resolve()
            .get();
    assertTrue(getResult instanceof CraftPlayerProfile);
    assertEquals("Name", getResult.getName());
    assertEquals(profile, ((CraftPlayerProfile) getResult).getGameProfile());
  }

  /**
   * Test {@link PaperResolvableProfile#resolve()}.
   *
   * <ul>
   *   <li>Given {@link PropertyMap} (default constructor) {@code Key} is {@code null}.
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link PaperResolvableProfile#resolve()}
   */
  @Test
  @DisplayName(
      "Test resolve(); given PropertyMap (default constructor) 'Key' is 'null'; then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture PaperResolvableProfile.resolve()"})
  void testResolve_givenPropertyMapKeyIsNull_thenReturnDone() {
    // Arrange
    PropertyMap properties = new PropertyMap();
    properties.put("Key", null);
    Optional<String> name = Optional.of("42");
    Optional<UUID> id = Optional.of(Util.NIL_UUID);

    net.minecraft.world.item.component.ResolvableProfile impl =
        new net.minecraft.world.item.component.ResolvableProfile(name, id, properties);

    // Act and Assert
    assertTrue(new PaperResolvableProfile(impl).resolve().isDone());
  }

  /**
   * Test {@link PaperResolvableProfile#resolve()}.
   *
   * <ul>
   *   <li>Given {@link
   *       net.minecraft.world.item.component.ResolvableProfile#ResolvableProfile(GameProfile)} with
   *       profile is {@link MinecraftServer#ANONYMOUS_PLAYER_PROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link PaperResolvableProfile#resolve()}
   */
  @Test
  @DisplayName(
      "Test resolve(); given ResolvableProfile(GameProfile) with profile is ANONYMOUS_PLAYER_PROFILE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture PaperResolvableProfile.resolve()"})
  void testResolve_givenResolvableProfileWithProfileIsAnonymous_player_profile() {
    // Arrange, Act and Assert
    assertTrue(
        new PaperResolvableProfile(
                new net.minecraft.world.item.component.ResolvableProfile(
                    MinecraftServer.ANONYMOUS_PLAYER_PROFILE))
            .resolve()
            .isDone());
  }

  /**
   * Test {@link PaperResolvableProfile#resolve()}.
   *
   * <ul>
   *   <li>Then return {@link CompletableFuture#get()} GameProfile Properties entries size is one.
   * </ul>
   *
   * <p>Method under test: {@link PaperResolvableProfile#resolve()}
   */
  @Test
  @DisplayName("Test resolve(); then return get() GameProfile Properties entries size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture PaperResolvableProfile.resolve()"})
  void testResolve_thenReturnGetGameProfilePropertiesEntriesSizeIsOne()
      throws InterruptedException, ExecutionException {
    // Arrange
    PropertyMap properties = new PropertyMap();
    Property property = new Property("Name", "42", "Signature");
    properties.put("Key", property);
    Optional<String> name = Optional.of("42");
    Optional<UUID> id = Optional.of(Util.NIL_UUID);

    net.minecraft.world.item.component.ResolvableProfile impl =
        new net.minecraft.world.item.component.ResolvableProfile(name, id, properties);

    // Act and Assert
    PlayerProfile getResult = new PaperResolvableProfile(impl).resolve().get();
    assertTrue(getResult instanceof CraftPlayerProfile);
    GameProfile gameProfile = ((CraftPlayerProfile) getResult).getGameProfile();
    PropertyMap properties2 = gameProfile.getProperties();
    Collection<Entry<String, Property>> entriesResult = properties2.entries();
    assertEquals(1, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    assertEquals("42", getResult.getName());
    assertEquals("42", gameProfile.getName());
    assertEquals(1, properties2.size());
    assertEquals(1, properties2.keys().size());
    assertEquals(1, getResult.getProperties().size());
    assertFalse(properties2.isEmpty());
  }

  /**
   * Test {@link PaperResolvableProfile#resolve()}.
   *
   * <ul>
   *   <li>Then return {@link CompletableFuture#get()} Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaperResolvableProfile#resolve()}
   */
  @Test
  @DisplayName("Test resolve(); then return get() Name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture PaperResolvableProfile.resolve()"})
  void testResolve_thenReturnGetNameIsEmptyString()
      throws InterruptedException, ExecutionException {
    // Arrange
    GameProfile profile = new GameProfile(Util.NIL_UUID, "");

    // Act and Assert
    PlayerProfile getResult =
        new PaperResolvableProfile(
                new net.minecraft.world.item.component.ResolvableProfile(profile))
            .resolve()
            .get();
    assertTrue(getResult instanceof CraftPlayerProfile);
    assertEquals("", getResult.getName());
    assertFalse(getResult.isComplete());
    assertEquals(profile, ((CraftPlayerProfile) getResult).getGameProfile());
  }
}

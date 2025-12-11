package com.destroystokyo.paper.profile;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import net.minecraft.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.component.ResolvableProfile;
import org.bukkit.craftbukkit.profile.CraftPlayerTextures;
import org.bukkit.profile.PlayerTextures;
import org.bukkit.profile.PlayerTextures.SkinModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CraftPlayerProfileDiffblueTest {
  /**
   * Test {@link CraftPlayerProfile#CraftPlayerProfile(UUID, String)}.
   *
   * <p>Method under test: {@link CraftPlayerProfile#CraftPlayerProfile(UUID, String)}
   */
  @Test
  @DisplayName("Test new CraftPlayerProfile(UUID, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.<init>(UUID, String)"})
  void testNewCraftPlayerProfile() {
    // Arrange and Act
    CraftPlayerProfile actualCraftPlayerProfile = new CraftPlayerProfile(null, "Name");

    // Assert
    assertEquals(
        "00000000-0000-0000-0000-000000000000",
        actualCraftPlayerProfile.getGameProfile().getId().toString());
    assertNull(actualCraftPlayerProfile.getId());
    assertNull(actualCraftPlayerProfile.getUniqueId());
  }

  /**
   * Test {@link CraftPlayerProfile#CraftPlayerProfile(ResolvableProfile)}.
   *
   * <p>Method under test: {@link CraftPlayerProfile#CraftPlayerProfile(ResolvableProfile)}
   */
  @Test
  @DisplayName("Test new CraftPlayerProfile(ResolvableProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.<init>(ResolvableProfile)"})
  void testNewCraftPlayerProfile2() {
    // Arrange
    Optional<String> name = Optional.of("42");
    Optional<UUID> id = Optional.empty();

    ResolvableProfile resolvableProfile = new ResolvableProfile(name, id, new PropertyMap());

    // Act
    CraftPlayerProfile actualCraftPlayerProfile = new CraftPlayerProfile(resolvableProfile);

    // Assert
    assertEquals(
        "00000000-0000-0000-0000-000000000000",
        actualCraftPlayerProfile.getGameProfile().getId().toString());
    assertNull(actualCraftPlayerProfile.getId());
    assertNull(actualCraftPlayerProfile.getUniqueId());
  }

  /**
   * Test {@link CraftPlayerProfile#CraftPlayerProfile(ResolvableProfile)}.
   *
   * <ul>
   *   <li>Given {@code The name of the profile contains invalid characters: %s}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#CraftPlayerProfile(ResolvableProfile)}
   */
  @Test
  @DisplayName(
      "Test new CraftPlayerProfile(ResolvableProfile); given 'The name of the profile contains invalid characters: %s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.<init>(ResolvableProfile)"})
  void testNewCraftPlayerProfile_givenTheNameOfTheProfileContainsInvalidCharactersS() {
    // Arrange
    PropertyMap properties = new PropertyMap();
    Property property =
        new Property(
            "Name cannot be longer than 16 characters",
            "42",
            "Name cannot be longer than 16 characters");
    properties.put("The name of the profile contains invalid characters: %s", property);
    Property property2 =
        new Property(
            "Name cannot be longer than 16 characters",
            "42",
            "Name cannot be longer than 16 characters");
    properties.put("Name cannot be longer than 16 characters", property2);
    Optional<String> name = Optional.of("42");
    Optional<UUID> id = Optional.of(Util.NIL_UUID);

    ResolvableProfile resolvableProfile = new ResolvableProfile(name, id, properties);

    // Act
    CraftPlayerProfile actualCraftPlayerProfile = new CraftPlayerProfile(resolvableProfile);

    // Assert
    PropertyMap properties2 = actualCraftPlayerProfile.getGameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties2.entries();
    assertEquals(1, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    assertEquals(1, properties2.size());
    assertEquals(1, properties2.keys().size());
    assertEquals(1, actualCraftPlayerProfile.getProperties().size());
    assertFalse(properties2.isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#CraftPlayerProfile(ResolvableProfile)}.
   *
   * <ul>
   *   <li>Then return Complete.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#CraftPlayerProfile(ResolvableProfile)}
   */
  @Test
  @DisplayName("Test new CraftPlayerProfile(ResolvableProfile); then return Complete")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.<init>(ResolvableProfile)"})
  void testNewCraftPlayerProfile_thenReturnComplete() {
    // Arrange
    Optional<String> name = Optional.of("42");
    Optional<UUID> id = Optional.of(Util.NIL_UUID);

    ResolvableProfile resolvableProfile = new ResolvableProfile(name, id, new PropertyMap());

    // Act and Assert
    assertTrue(new CraftPlayerProfile(resolvableProfile).isComplete());
  }

  /**
   * Test {@link CraftPlayerProfile#CraftPlayerProfile(ResolvableProfile)}.
   *
   * <ul>
   *   <li>Then return GameProfile Properties entries size is one.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#CraftPlayerProfile(ResolvableProfile)}
   */
  @Test
  @DisplayName(
      "Test new CraftPlayerProfile(ResolvableProfile); then return GameProfile Properties entries size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.<init>(ResolvableProfile)"})
  void testNewCraftPlayerProfile_thenReturnGameProfilePropertiesEntriesSizeIsOne() {
    // Arrange
    PropertyMap properties = new PropertyMap();
    Property property =
        new Property(
            "Name cannot be longer than 16 characters",
            "42",
            "Name cannot be longer than 16 characters");
    properties.put("Name cannot be longer than 16 characters", property);
    Optional<String> name = Optional.of("42");
    Optional<UUID> id = Optional.of(Util.NIL_UUID);

    ResolvableProfile resolvableProfile = new ResolvableProfile(name, id, properties);

    // Act
    CraftPlayerProfile actualCraftPlayerProfile = new CraftPlayerProfile(resolvableProfile);

    // Assert
    PropertyMap properties2 = actualCraftPlayerProfile.getGameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties2.entries();
    assertEquals(1, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    assertEquals(1, properties2.size());
    assertEquals(1, properties2.keys().size());
    assertEquals(1, actualCraftPlayerProfile.getProperties().size());
    assertFalse(properties2.isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#CraftPlayerProfile(GameProfile)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 00000000-0000-0000-0000-000000000000}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#CraftPlayerProfile(GameProfile)}
   */
  @Test
  @DisplayName(
      "Test new CraftPlayerProfile(GameProfile); then return Id toString is '00000000-0000-0000-0000-000000000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.<init>(GameProfile)"})
  void testNewCraftPlayerProfile_thenReturnIdToStringIs00000000000000000000000000000000() {
    // Arrange
    GameProfile profile = MinecraftServer.ANONYMOUS_PLAYER_PROFILE;

    // Act
    CraftPlayerProfile actualCraftPlayerProfile = new CraftPlayerProfile(profile);

    // Assert
    UUID id = actualCraftPlayerProfile.getId();
    assertEquals("00000000-0000-0000-0000-000000000000", id.toString());
    assertEquals("Anonymous Player", actualCraftPlayerProfile.getName());
    CraftPlayerTextures textures = actualCraftPlayerProfile.getTextures();
    assertNull(textures.getCape());
    assertNull(textures.getSkin());
    assertEquals(0L, textures.getTimestamp());
    assertEquals(SkinModel.CLASSIC, textures.getSkinModel());
    assertFalse(actualCraftPlayerProfile.hasTextures());
    assertFalse(textures.isSigned());
    assertTrue(actualCraftPlayerProfile.isComplete());
    assertTrue(actualCraftPlayerProfile.getProperties().isEmpty());
    assertSame(id, actualCraftPlayerProfile.getUniqueId());
    assertSame(profile, actualCraftPlayerProfile.getGameProfile());
  }

  /**
   * Test {@link CraftPlayerProfile#CraftPlayerProfile(ResolvableProfile)}.
   *
   * <ul>
   *   <li>Then return Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#CraftPlayerProfile(ResolvableProfile)}
   */
  @Test
  @DisplayName("Test new CraftPlayerProfile(ResolvableProfile); then return Name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.<init>(ResolvableProfile)"})
  void testNewCraftPlayerProfile_thenReturnNameIsEmptyString() {
    // Arrange
    Optional<String> name = Optional.of("");
    Optional<UUID> id = Optional.of(Util.NIL_UUID);

    ResolvableProfile resolvableProfile = new ResolvableProfile(name, id, new PropertyMap());

    // Act and Assert
    assertEquals("", new CraftPlayerProfile(resolvableProfile).getName());
  }

  /**
   * Test {@link CraftPlayerProfile#CraftPlayerProfile(ResolvableProfile)}.
   *
   * <ul>
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#CraftPlayerProfile(ResolvableProfile)}
   */
  @Test
  @DisplayName("Test new CraftPlayerProfile(ResolvableProfile); then return Name is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.<init>(ResolvableProfile)"})
  void testNewCraftPlayerProfile_thenReturnNameIsNull() {
    // Arrange
    Optional<String> name = Optional.empty();
    Optional<UUID> id = Optional.of(Util.NIL_UUID);

    ResolvableProfile resolvableProfile = new ResolvableProfile(name, id, new PropertyMap());

    // Act and Assert
    assertNull(new CraftPlayerProfile(resolvableProfile).getName());
  }

  /**
   * Test {@link CraftPlayerProfile#CraftPlayerProfile(UUID, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#CraftPlayerProfile(UUID, String)}
   */
  @Test
  @DisplayName(
      "Test new CraftPlayerProfile(UUID, String); when empty string; then return Name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.<init>(UUID, String)"})
  void testNewCraftPlayerProfile_whenEmptyString_thenReturnNameIsEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new CraftPlayerProfile(Util.NIL_UUID, "").getName());
  }

  /**
   * Test {@link CraftPlayerProfile#CraftPlayerProfile(UUID, String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return Complete.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#CraftPlayerProfile(UUID, String)}
   */
  @Test
  @DisplayName("Test new CraftPlayerProfile(UUID, String); when 'Name'; then return Complete")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.<init>(UUID, String)"})
  void testNewCraftPlayerProfile_whenName_thenReturnComplete() {
    // Arrange, Act and Assert
    assertTrue(new CraftPlayerProfile(Util.NIL_UUID, "Name").isComplete());
  }

  /**
   * Test {@link CraftPlayerProfile#CraftPlayerProfile(UUID, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#CraftPlayerProfile(UUID, String)}
   */
  @Test
  @DisplayName("Test new CraftPlayerProfile(UUID, String); when 'null'; then return Name is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.<init>(UUID, String)"})
  void testNewCraftPlayerProfile_whenNull_thenReturnNameIsNull() {
    // Arrange and Act
    CraftPlayerProfile actualCraftPlayerProfile = new CraftPlayerProfile(Util.NIL_UUID, null);

    // Assert
    assertNull(actualCraftPlayerProfile.getName());
  }

  /**
   * Test {@link CraftPlayerProfile#hasProperty(String)}.
   *
   * <p>Method under test: {@link CraftPlayerProfile#hasProperty(String)}
   */
  @Test
  @DisplayName("Test hasProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CraftPlayerProfile.hasProperty(String)"})
  void testHasProperty() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act and Assert
    assertFalse(deserializeResult.hasProperty("Property"));
  }

  /**
   * Test {@link CraftPlayerProfile#setProperty(ProfileProperty)} with {@code property}.
   *
   * <p>Method under test: {@link CraftPlayerProfile#setProperty(ProfileProperty)}
   */
  @Test
  @DisplayName("Test setProperty(ProfileProperty) with 'property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.setProperty(ProfileProperty)"})
  void testSetPropertyWithProperty() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act
    deserializeResult.setProperty(new ProfileProperty("Name", "42"));

    // Assert
    PropertyMap properties = deserializeResult.getGameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties.entries();
    assertEquals(1, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    assertEquals(1, properties.size());
    assertEquals(1, properties.keys().size());
    assertEquals(1, deserializeResult.getProperties().size());
    assertFalse(properties.isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#setProperty(String, Property)} with {@code propertyName}, {@code
   * property}.
   *
   * <p>Method under test: {@link CraftPlayerProfile#setProperty(String, Property)}
   */
  @Test
  @DisplayName("Test setProperty(String, Property) with 'propertyName', 'property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.setProperty(String, Property)"})
  void testSetPropertyWithPropertyNameProperty() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());
    Property property = new Property("Name", "42", "Signature");

    // Act
    deserializeResult.setProperty("Property Name", property);

    // Assert
    PropertyMap properties = deserializeResult.getGameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties.entries();
    assertEquals(1, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    assertEquals(1, properties.size());
    assertEquals(1, properties.keys().size());
    assertEquals(1, deserializeResult.getProperties().size());
    assertFalse(properties.isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#setProperty(String, Property)} with {@code propertyName}, {@code
   * property}.
   *
   * <p>Method under test: {@link CraftPlayerProfile#setProperty(String, Property)}
   */
  @Test
  @DisplayName("Test setProperty(String, Property) with 'propertyName', 'property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.setProperty(String, Property)"})
  void testSetPropertyWithPropertyNameProperty2() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act
    deserializeResult.setProperty("Property Name", null);

    // Assert that nothing has changed
    PropertyMap properties = deserializeResult.getGameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties.entries();
    assertTrue(entriesResult instanceof Set);
    assertEquals(0, properties.size());
    assertTrue(properties.isEmpty());
    assertTrue(entriesResult.isEmpty());
    assertTrue(properties.keys().isEmpty());
    assertTrue(deserializeResult.getProperties().isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#setProperty(String, Property)} with {@code propertyName}, {@code
   * property}.
   *
   * <p>Method under test: {@link CraftPlayerProfile#setProperty(String, Property)}
   */
  @Test
  @DisplayName("Test setProperty(String, Property) with 'propertyName', 'property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.setProperty(String, Property)"})
  void testSetPropertyWithPropertyNameProperty3() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());
    Property property = new Property("Name", "42", null);

    // Act
    deserializeResult.setProperty("Property Name", property);

    // Assert
    PropertyMap properties = deserializeResult.getGameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties.entries();
    assertEquals(1, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    assertEquals(1, properties.size());
    assertEquals(1, properties.keys().size());
    assertEquals(1, deserializeResult.getProperties().size());
    assertFalse(properties.isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#getTextures()}.
   *
   * <p>Method under test: {@link CraftPlayerProfile#getTextures()}
   */
  @Test
  @DisplayName("Test getTextures()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CraftPlayerTextures CraftPlayerProfile.getTextures()"})
  void testGetTextures() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act
    CraftPlayerTextures actualTextures = deserializeResult.getTextures();

    // Assert
    assertNull(actualTextures.getCape());
    assertNull(actualTextures.getSkin());
    assertEquals(0L, actualTextures.getTimestamp());
    assertEquals(SkinModel.CLASSIC, actualTextures.getSkinModel());
    assertFalse(actualTextures.isSigned());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CraftPlayerProfile#toString()}
   *   <li>{@link CraftPlayerProfile#getGameProfile()}
   *   <li>{@link CraftPlayerProfile#getProperties()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GameProfile CraftPlayerProfile.getGameProfile()",
    "Set CraftPlayerProfile.getProperties()",
    "String CraftPlayerProfile.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act
    String actualToStringResult = deserializeResult.toString();
    GameProfile actualGameProfile = deserializeResult.getGameProfile();
    Set<ProfileProperty> actualProperties = deserializeResult.getProperties();

    // Assert
    PropertyMap properties = actualGameProfile.getProperties();
    assertTrue(properties.entries() instanceof Set);
    assertEquals("", actualGameProfile.getName());
    assertEquals("00000000-0000-0000-0000-000000000000", actualGameProfile.getId().toString());
    assertEquals(
        "CraftPlayerProfile [uniqueId=null, name=null, properties={}]", actualToStringResult);
    assertEquals(0, properties.size());
    assertTrue(properties.isEmpty());
    assertTrue(actualProperties.isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#getId()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#getId()}
   */
  @Test
  @DisplayName("Test getId(); given deserialize HashMap(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID CraftPlayerProfile.getId()"})
  void testGetId_givenDeserializeHashMap_thenReturnNull() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act and Assert
    assertNull(deserializeResult.getId());
  }

  /**
   * Test {@link CraftPlayerProfile#getId()}.
   *
   * <ul>
   *   <li>Then return toString is {@code 00000000-0000-0000-0000-000000000000}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#getId()}
   */
  @Test
  @DisplayName("Test getId(); then return toString is '00000000-0000-0000-0000-000000000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID CraftPlayerProfile.getId()"})
  void testGetId_thenReturnToStringIs00000000000000000000000000000000() {
    // Arrange, Act and Assert
    assertEquals(
        "00000000-0000-0000-0000-000000000000",
        new CraftPlayerProfile(MinecraftServer.ANONYMOUS_PLAYER_PROFILE).getId().toString());
  }

  /**
   * Test {@link CraftPlayerProfile#setId(UUID)}.
   *
   * <p>Method under test: {@link CraftPlayerProfile#setId(UUID)}
   */
  @Test
  @DisplayName("Test setId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID CraftPlayerProfile.setId(UUID)"})
  void testSetId() {
    // Arrange
    GameProfile profile = new GameProfile(Util.NIL_UUID, "Name");
    CraftPlayerProfile craftPlayerProfile = new CraftPlayerProfile(profile);
    UUID uuid = Util.NIL_UUID;

    // Act
    UUID actualSetIdResult = craftPlayerProfile.setId(uuid);

    // Assert
    assertEquals(profile, craftPlayerProfile.getGameProfile());
    assertSame(uuid, craftPlayerProfile.getId());
    assertSame(uuid, craftPlayerProfile.getUniqueId());
    assertSame(uuid, actualSetIdResult);
  }

  /**
   * Test {@link CraftPlayerProfile#setId(UUID)}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>Then deserialize {@link HashMap#HashMap()} Id is {@link Util#NIL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#setId(UUID)}
   */
  @Test
  @DisplayName(
      "Test setId(UUID); given deserialize HashMap(); then deserialize HashMap() Id is NIL_UUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID CraftPlayerProfile.setId(UUID)"})
  void testSetId_givenDeserializeHashMap_thenDeserializeHashMapIdIsNil_uuid() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());
    UUID uuid = Util.NIL_UUID;

    // Act and Assert
    assertNull(deserializeResult.setId(uuid));
    assertSame(uuid, deserializeResult.getId());
    assertSame(uuid, deserializeResult.getUniqueId());
  }

  /**
   * Test {@link CraftPlayerProfile#setId(UUID)}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>When {@code null}.
   *   <li>Then deserialize {@link HashMap#HashMap()} Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#setId(UUID)}
   */
  @Test
  @DisplayName(
      "Test setId(UUID); given deserialize HashMap(); when 'null'; then deserialize HashMap() Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID CraftPlayerProfile.setId(UUID)"})
  void testSetId_givenDeserializeHashMap_whenNull_thenDeserializeHashMapIdIsNull() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act
    UUID actualSetIdResult = deserializeResult.setId(null);

    // Assert
    assertNull(deserializeResult.getId());
    assertNull(deserializeResult.getUniqueId());
    assertNull(actualSetIdResult);
  }

  /**
   * Test {@link CraftPlayerProfile#getUniqueId()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#getUniqueId()}
   */
  @Test
  @DisplayName("Test getUniqueId(); given deserialize HashMap(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID CraftPlayerProfile.getUniqueId()"})
  void testGetUniqueId_givenDeserializeHashMap_thenReturnNull() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act and Assert
    assertNull(deserializeResult.getUniqueId());
  }

  /**
   * Test {@link CraftPlayerProfile#getUniqueId()}.
   *
   * <ul>
   *   <li>Then return toString is {@code 00000000-0000-0000-0000-000000000000}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#getUniqueId()}
   */
  @Test
  @DisplayName("Test getUniqueId(); then return toString is '00000000-0000-0000-0000-000000000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID CraftPlayerProfile.getUniqueId()"})
  void testGetUniqueId_thenReturnToStringIs00000000000000000000000000000000() {
    // Arrange, Act and Assert
    assertEquals(
        "00000000-0000-0000-0000-000000000000",
        new CraftPlayerProfile(MinecraftServer.ANONYMOUS_PLAYER_PROFILE).getUniqueId().toString());
  }

  /**
   * Test {@link CraftPlayerProfile#getName()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#getName()}
   */
  @Test
  @DisplayName("Test getName(); given deserialize HashMap(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CraftPlayerProfile.getName()"})
  void testGetName_givenDeserializeHashMap_thenReturnNull() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act and Assert
    assertNull(deserializeResult.getName());
  }

  /**
   * Test {@link CraftPlayerProfile#getName()}.
   *
   * <ul>
   *   <li>Then return {@code Anonymous Player}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return 'Anonymous Player'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CraftPlayerProfile.getName()"})
  void testGetName_thenReturnAnonymousPlayer() {
    // Arrange, Act and Assert
    assertEquals(
        "Anonymous Player",
        new CraftPlayerProfile(MinecraftServer.ANONYMOUS_PLAYER_PROFILE).getName());
  }

  /**
   * Test {@link CraftPlayerProfile#setName(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then deserialize {@link HashMap#HashMap()} Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#setName(String)}
   */
  @Test
  @DisplayName(
      "Test setName(String); when empty string; then deserialize HashMap() Name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CraftPlayerProfile.setName(String)"})
  void testSetName_whenEmptyString_thenDeserializeHashMapNameIsEmptyString() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act
    String actualSetNameResult = deserializeResult.setName("");

    // Assert
    assertEquals("", deserializeResult.getName());
    assertEquals("", actualSetNameResult);
    assertEquals("", deserializeResult.getGameProfile().getName());
  }

  /**
   * Test {@link CraftPlayerProfile#setName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then deserialize {@link HashMap#HashMap()} Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when 'Name'; then deserialize HashMap() Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CraftPlayerProfile.setName(String)"})
  void testSetName_whenName_thenDeserializeHashMapNameIsName() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act and Assert
    assertEquals("", deserializeResult.setName("Name"));
    assertEquals("Name", deserializeResult.getName());
    assertEquals("Name", deserializeResult.getGameProfile().getName());
  }

  /**
   * Test {@link CraftPlayerProfile#setName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then deserialize {@link HashMap#HashMap()} Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when 'null'; then deserialize HashMap() Name is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CraftPlayerProfile.setName(String)"})
  void testSetName_whenNull_thenDeserializeHashMapNameIsNull() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act and Assert
    assertEquals("", deserializeResult.setName(null));
    assertEquals("", deserializeResult.getGameProfile().getName());
    assertNull(deserializeResult.getName());
  }

  /**
   * Test {@link CraftPlayerProfile#setProperties(Collection)}.
   *
   * <ul>
   *   <li>Then deserialize {@link HashMap#HashMap()} GameProfile Properties entries size is one.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#setProperties(Collection)}
   */
  @Test
  @DisplayName(
      "Test setProperties(Collection); then deserialize HashMap() GameProfile Properties entries size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.setProperties(Collection)"})
  void testSetProperties_thenDeserializeHashMapGameProfilePropertiesEntriesSizeIsOne() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    ArrayList<ProfileProperty> properties = new ArrayList<>();
    properties.add(new ProfileProperty("Name", "42"));

    // Act
    deserializeResult.setProperties(properties);

    // Assert
    PropertyMap properties2 = deserializeResult.getGameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties2.entries();
    assertEquals(1, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    assertEquals(1, properties2.size());
    assertEquals(1, properties2.keys().size());
    assertEquals(1, deserializeResult.getProperties().size());
  }

  /**
   * Test {@link CraftPlayerProfile#setProperties(Collection)}.
   *
   * <ul>
   *   <li>Then deserialize {@link HashMap#HashMap()} GameProfile Properties entries size is two.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#setProperties(Collection)}
   */
  @Test
  @DisplayName(
      "Test setProperties(Collection); then deserialize HashMap() GameProfile Properties entries size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.setProperties(Collection)"})
  void testSetProperties_thenDeserializeHashMapGameProfilePropertiesEntriesSizeIsTwo() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    ArrayList<ProfileProperty> properties = new ArrayList<>();
    properties.add(new ProfileProperty("Cannot add more than 16 properties to a profile", "42"));
    properties.add(new ProfileProperty("Name", "42"));

    // Act
    deserializeResult.setProperties(properties);

    // Assert
    PropertyMap properties2 = deserializeResult.getGameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties2.entries();
    assertEquals(2, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    assertEquals(2, properties2.size());
    assertEquals(2, properties2.keys().size());
    assertEquals(2, deserializeResult.getProperties().size());
  }

  /**
   * Test {@link CraftPlayerProfile#setProperties(Collection)}.
   *
   * <ul>
   *   <li>Then deserialize {@link HashMap#HashMap()} GameProfile Properties entries size is two.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#setProperties(Collection)}
   */
  @Test
  @DisplayName(
      "Test setProperties(Collection); then deserialize HashMap() GameProfile Properties entries size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.setProperties(Collection)"})
  void testSetProperties_thenDeserializeHashMapGameProfilePropertiesEntriesSizeIsTwo2() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    ArrayList<ProfileProperty> properties = new ArrayList<>();
    properties.add(new ProfileProperty("Cannot add more than 16 properties to a profile", "42"));
    properties.add(new ProfileProperty("Cannot add more than 16 properties to a profile", "42"));
    properties.add(new ProfileProperty("Name", "42"));

    // Act
    deserializeResult.setProperties(properties);

    // Assert
    PropertyMap properties2 = deserializeResult.getGameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties2.entries();
    assertEquals(2, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    assertEquals(2, properties2.size());
    assertEquals(2, properties2.keys().size());
    assertEquals(2, deserializeResult.getProperties().size());
  }

  /**
   * Test {@link CraftPlayerProfile#setProperties(Collection)}.
   *
   * <ul>
   *   <li>Then deserialize {@link HashMap#HashMap()} GameProfile Properties size is zero.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#setProperties(Collection)}
   */
  @Test
  @DisplayName(
      "Test setProperties(Collection); then deserialize HashMap() GameProfile Properties size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.setProperties(Collection)"})
  void testSetProperties_thenDeserializeHashMapGameProfilePropertiesSizeIsZero() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act
    deserializeResult.setProperties(new ArrayList<>());

    // Assert that nothing has changed
    PropertyMap properties = deserializeResult.getGameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties.entries();
    assertTrue(entriesResult instanceof Set);
    assertEquals(0, properties.size());
    assertTrue(entriesResult.isEmpty());
    assertTrue(properties.keys().isEmpty());
    assertTrue(deserializeResult.getProperties().isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#clearProperties()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#clearProperties()}
   */
  @Test
  @DisplayName("Test clearProperties(); given deserialize HashMap(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.clearProperties()"})
  void testClearProperties_givenDeserializeHashMap_thenDoesNotThrow() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act and Assert
    assertDoesNotThrow(() -> deserializeResult.clearProperties());
  }

  /**
   * Test {@link CraftPlayerProfile#clearProperties()}.
   *
   * <ul>
   *   <li>Given {@link GameProfile} {@link GameProfile#getProperties()} return {@link PropertyMap}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#clearProperties()}
   */
  @Test
  @DisplayName(
      "Test clearProperties(); given GameProfile getProperties() return PropertyMap (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.clearProperties()"})
  void testClearProperties_givenGameProfileGetPropertiesReturnPropertyMap() {
    // Arrange
    GameProfile profile = mock(GameProfile.class);
    when(profile.getProperties()).thenReturn(new PropertyMap());

    // Act
    new CraftPlayerProfile(profile).clearProperties();

    // Assert
    verify(profile).getProperties();
  }

  /**
   * Test {@link CraftPlayerProfile#clearProperties()}.
   *
   * <ul>
   *   <li>Given {@link PropertyMap} {@link PropertyMap#clear()} does nothing.
   *   <li>Then calls {@link PropertyMap#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#clearProperties()}
   */
  @Test
  @DisplayName("Test clearProperties(); given PropertyMap clear() does nothing; then calls clear()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.clearProperties()"})
  void testClearProperties_givenPropertyMapClearDoesNothing_thenCallsClear() {
    // Arrange
    PropertyMap propertyMap = mock(PropertyMap.class);
    doNothing().when(propertyMap).clear();

    GameProfile profile = mock(GameProfile.class);
    when(profile.getProperties()).thenReturn(propertyMap);

    // Act
    new CraftPlayerProfile(profile).clearProperties();

    // Assert
    verify(propertyMap).clear();
    verify(profile).getProperties();
  }

  /**
   * Test {@link CraftPlayerProfile#clearProperties()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#clearProperties()}
   */
  @Test
  @DisplayName("Test clearProperties(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CraftPlayerProfile.clearProperties()"})
  void testClearProperties_thenThrowIllegalArgumentException() {
    // Arrange
    GameProfile profile = mock(GameProfile.class);
    when(profile.getProperties()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new CraftPlayerProfile(profile).clearProperties());
    verify(profile).getProperties();
  }

  /**
   * Test {@link CraftPlayerProfile#removeProperty(String)} with {@code String}.
   *
   * <p>Method under test: {@link CraftPlayerProfile#removeProperty(String)}
   */
  @Test
  @DisplayName("Test removeProperty(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CraftPlayerProfile.removeProperty(String)"})
  void testRemovePropertyWithString() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act and Assert
    assertFalse(deserializeResult.removeProperty("Property"));
  }

  /**
   * Test {@link CraftPlayerProfile#getProperty(String)}.
   *
   * <p>Method under test: {@link CraftPlayerProfile#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Property CraftPlayerProfile.getProperty(String)"})
  void testGetProperty() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act and Assert
    assertNull(deserializeResult.getProperty("Property"));
  }

  /**
   * Test {@link CraftPlayerProfile#buildGameProfile()}.
   *
   * <p>Method under test: {@link CraftPlayerProfile#buildGameProfile()}
   */
  @Test
  @DisplayName("Test buildGameProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GameProfile CraftPlayerProfile.buildGameProfile()"})
  void testBuildGameProfile() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act
    GameProfile actualBuildGameProfileResult = deserializeResult.buildGameProfile();

    // Assert
    PropertyMap properties = actualBuildGameProfileResult.getProperties();
    Collection<Entry<String, Property>> entriesResult = properties.entries();
    assertTrue(entriesResult instanceof Set);
    assertEquals("", actualBuildGameProfileResult.getName());
    assertEquals(
        "00000000-0000-0000-0000-000000000000", actualBuildGameProfileResult.getId().toString());
    assertEquals(0, properties.size());
    assertTrue(properties.isEmpty());
    assertTrue(entriesResult.isEmpty());
    assertTrue(properties.keys().isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#buildResolvableProfile()}.
   *
   * <ul>
   *   <li>Then return gameProfile Name is {@code Anonymous Player}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#buildResolvableProfile()}
   */
  @Test
  @DisplayName("Test buildResolvableProfile(); then return gameProfile Name is 'Anonymous Player'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolvableProfile CraftPlayerProfile.buildResolvableProfile()"})
  void testBuildResolvableProfile_thenReturnGameProfileNameIsAnonymousPlayer() {
    // Arrange and Act
    ResolvableProfile actualBuildResolvableProfileResult =
        new CraftPlayerProfile(MinecraftServer.ANONYMOUS_PLAYER_PROFILE).buildResolvableProfile();

    // Assert
    assertEquals("Anonymous Player", actualBuildResolvableProfileResult.gameProfile().getName());
    Optional<String> nameResult = actualBuildResolvableProfileResult.name();
    assertEquals("Anonymous Player", nameResult.get());
    assertTrue(actualBuildResolvableProfileResult.id().isPresent());
    assertTrue(nameResult.isPresent());
  }

  /**
   * Test {@link CraftPlayerProfile#buildResolvableProfile()}.
   *
   * <ul>
   *   <li>Then return gameProfile Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#buildResolvableProfile()}
   */
  @Test
  @DisplayName("Test buildResolvableProfile(); then return gameProfile Name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolvableProfile CraftPlayerProfile.buildResolvableProfile()"})
  void testBuildResolvableProfile_thenReturnGameProfileNameIsEmptyString() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act
    ResolvableProfile actualBuildResolvableProfileResult =
        deserializeResult.buildResolvableProfile();

    // Assert
    assertEquals("", actualBuildResolvableProfileResult.gameProfile().getName());
    Optional<UUID> idResult = actualBuildResolvableProfileResult.id();
    assertFalse(idResult.isPresent());
    assertSame(idResult, actualBuildResolvableProfileResult.name());
  }

  /**
   * Test {@link CraftPlayerProfile#clone()}.
   *
   * <p>Method under test: {@link CraftPlayerProfile#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CraftPlayerProfile CraftPlayerProfile.clone()"})
  void testClone() {
    // Arrange
    ArrayList<Property> propertyList = new ArrayList<>();
    propertyList.add(new Property("Name cannot be longer than 16 characters", "42"));

    PropertyMap propertyMap = mock(PropertyMap.class);
    when(propertyMap.values()).thenReturn(propertyList);

    GameProfile profile = mock(GameProfile.class);
    when(profile.getProperties()).thenReturn(propertyMap);
    when(profile.getName()).thenReturn("Name");
    when(profile.getId()).thenReturn(Util.NIL_UUID);

    // Act
    CraftPlayerProfile actualCloneResult = new CraftPlayerProfile(profile).clone();

    // Assert
    verify(propertyMap).values();
    verify(profile).getId();
    verify(profile).getName();
    verify(profile).getProperties();
    PropertyMap properties = actualCloneResult.getGameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties.entries();
    assertEquals(1, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    assertEquals(1, properties.size());
    assertEquals(1, properties.keys().size());
    assertEquals(1, actualCloneResult.getProperties().size());
    assertFalse(properties.isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#clone()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>Then return deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#clone()}
   */
  @Test
  @DisplayName("Test clone(); given deserialize HashMap(); then return deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CraftPlayerProfile CraftPlayerProfile.clone()"})
  void testClone_givenDeserializeHashMap_thenReturnDeserializeHashMap() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act
    CraftPlayerProfile actualCloneResult = deserializeResult.clone();

    // Assert
    assertEquals(deserializeResult, actualCloneResult);
  }

  /**
   * Test {@link CraftPlayerProfile#clone()}.
   *
   * <ul>
   *   <li>Given {@link GameProfile} {@link GameProfile#getName()} return empty string.
   *   <li>Then return Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#clone()}
   */
  @Test
  @DisplayName(
      "Test clone(); given GameProfile getName() return empty string; then return Name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CraftPlayerProfile CraftPlayerProfile.clone()"})
  void testClone_givenGameProfileGetNameReturnEmptyString_thenReturnNameIsEmptyString() {
    // Arrange
    PropertyMap propertyMap = mock(PropertyMap.class);
    when(propertyMap.values()).thenReturn(new ArrayList<>());

    GameProfile profile = mock(GameProfile.class);
    when(profile.getProperties()).thenReturn(propertyMap);
    when(profile.getName()).thenReturn("");
    when(profile.getId()).thenReturn(Util.NIL_UUID);

    // Act
    CraftPlayerProfile actualCloneResult = new CraftPlayerProfile(profile).clone();

    // Assert
    verify(propertyMap).values();
    verify(profile).getId();
    verify(profile).getName();
    verify(profile).getProperties();
    assertEquals("", actualCloneResult.getName());
    assertEquals("", actualCloneResult.getGameProfile().getName());
    assertFalse(actualCloneResult.isComplete());
  }

  /**
   * Test {@link CraftPlayerProfile#clone()}.
   *
   * <ul>
   *   <li>Then return GameProfile Properties entries size is one.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return GameProfile Properties entries size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CraftPlayerProfile CraftPlayerProfile.clone()"})
  void testClone_thenReturnGameProfilePropertiesEntriesSizeIsOne() {
    // Arrange
    ArrayList<Property> propertyList = new ArrayList<>();
    Property property =
        new Property(
            "Name cannot be longer than 16 characters",
            "42",
            "Name cannot be longer than 16 characters");
    propertyList.add(property);

    PropertyMap propertyMap = mock(PropertyMap.class);
    when(propertyMap.values()).thenReturn(propertyList);

    GameProfile profile = mock(GameProfile.class);
    when(profile.getProperties()).thenReturn(propertyMap);
    when(profile.getName()).thenReturn("Name");
    when(profile.getId()).thenReturn(Util.NIL_UUID);

    // Act
    CraftPlayerProfile actualCloneResult = new CraftPlayerProfile(profile).clone();

    // Assert
    verify(propertyMap).values();
    verify(profile).getId();
    verify(profile).getName();
    verify(profile).getProperties();
    PropertyMap properties = actualCloneResult.getGameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties.entries();
    assertEquals(1, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    assertEquals(1, properties.size());
    assertEquals(1, properties.keys().size());
    assertEquals(1, actualCloneResult.getProperties().size());
    assertFalse(properties.isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#clone()}.
   *
   * <ul>
   *   <li>Then return GameProfile Properties entries size is one.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return GameProfile Properties entries size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CraftPlayerProfile CraftPlayerProfile.clone()"})
  void testClone_thenReturnGameProfilePropertiesEntriesSizeIsOne2() {
    // Arrange
    ArrayList<Property> propertyList = new ArrayList<>();
    Property property =
        new Property(
            "Name cannot be longer than 16 characters",
            "42",
            "Name cannot be longer than 16 characters");
    propertyList.add(property);
    Property property2 =
        new Property(
            "Name cannot be longer than 16 characters",
            "42",
            "Name cannot be longer than 16 characters");
    propertyList.add(property2);

    PropertyMap propertyMap = mock(PropertyMap.class);
    when(propertyMap.values()).thenReturn(propertyList);

    GameProfile profile = mock(GameProfile.class);
    when(profile.getProperties()).thenReturn(propertyMap);
    when(profile.getName()).thenReturn("Name");
    when(profile.getId()).thenReturn(Util.NIL_UUID);

    // Act
    CraftPlayerProfile actualCloneResult = new CraftPlayerProfile(profile).clone();

    // Assert
    verify(propertyMap).values();
    verify(profile).getId();
    verify(profile).getName();
    verify(profile).getProperties();
    PropertyMap properties = actualCloneResult.getGameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties.entries();
    assertEquals(1, entriesResult.size());
    assertTrue(entriesResult instanceof Set);
    assertEquals(1, properties.size());
    assertEquals(1, properties.keys().size());
    assertEquals(1, actualCloneResult.getProperties().size());
    assertFalse(properties.isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#clone()}.
   *
   * <ul>
   *   <li>Then return GameProfile Properties is {@link PropertyMap} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#clone()}
   */
  @Test
  @DisplayName(
      "Test clone(); then return GameProfile Properties is PropertyMap (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CraftPlayerProfile CraftPlayerProfile.clone()"})
  void testClone_thenReturnGameProfilePropertiesIsPropertyMap() {
    // Arrange
    GameProfile profile = mock(GameProfile.class);
    PropertyMap propertyMap = new PropertyMap();
    when(profile.getProperties()).thenReturn(propertyMap);
    when(profile.getName()).thenReturn("Name");
    when(profile.getId()).thenReturn(Util.NIL_UUID);

    // Act
    CraftPlayerProfile actualCloneResult = new CraftPlayerProfile(profile).clone();

    // Assert
    verify(profile).getId();
    verify(profile).getName();
    verify(profile).getProperties();
    assertTrue(actualCloneResult.getProperties().isEmpty());
    assertEquals(propertyMap, actualCloneResult.getGameProfile().getProperties());
  }

  /**
   * Test {@link CraftPlayerProfile#clone()}.
   *
   * <ul>
   *   <li>Then return GameProfile Properties size is zero.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return GameProfile Properties size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CraftPlayerProfile CraftPlayerProfile.clone()"})
  void testClone_thenReturnGameProfilePropertiesSizeIsZero() {
    // Arrange
    PropertyMap propertyMap = mock(PropertyMap.class);
    when(propertyMap.values()).thenReturn(new ArrayList<>());

    GameProfile profile = mock(GameProfile.class);
    when(profile.getProperties()).thenReturn(propertyMap);
    when(profile.getName()).thenReturn("Name");
    when(profile.getId()).thenReturn(Util.NIL_UUID);

    // Act
    CraftPlayerProfile actualCloneResult = new CraftPlayerProfile(profile).clone();

    // Assert
    verify(propertyMap).values();
    verify(profile).getId();
    verify(profile).getName();
    verify(profile).getProperties();
    PropertyMap properties = actualCloneResult.getGameProfile().getProperties();
    Collection<Entry<String, Property>> entriesResult = properties.entries();
    assertTrue(entriesResult instanceof Set);
    assertEquals(0, properties.size());
    assertTrue(properties.isEmpty());
    assertTrue(entriesResult.isEmpty());
    assertTrue(properties.keys().isEmpty());
    assertTrue(actualCloneResult.getProperties().isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#clone()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#clone()}
   */
  @Test
  @DisplayName("Test clone(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CraftPlayerProfile CraftPlayerProfile.clone()"})
  void testClone_thenThrowIllegalArgumentException() {
    // Arrange
    GameProfile profile = mock(GameProfile.class);
    when(profile.getId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new CraftPlayerProfile(profile).clone());
    verify(profile).getId();
  }

  /**
   * Test {@link CraftPlayerProfile#isComplete()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#isComplete()}
   */
  @Test
  @DisplayName("Test isComplete(); given deserialize HashMap(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CraftPlayerProfile.isComplete()"})
  void testIsComplete_givenDeserializeHashMap_thenReturnFalse() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act and Assert
    assertFalse(deserializeResult.isComplete());
  }

  /**
   * Test {@link CraftPlayerProfile#isComplete()}.
   *
   * <ul>
   *   <li>Given {@link GameProfile#GameProfile(UUID, String)} with id is {@link Util#NIL_UUID} and
   *       name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#isComplete()}
   */
  @Test
  @DisplayName(
      "Test isComplete(); given GameProfile(UUID, String) with id is NIL_UUID and name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CraftPlayerProfile.isComplete()"})
  void testIsComplete_givenGameProfileWithIdIsNil_uuidAndNameIsEmptyString() {
    // Arrange, Act and Assert
    assertFalse(new CraftPlayerProfile(new GameProfile(Util.NIL_UUID, "")).isComplete());
  }

  /**
   * Test {@link CraftPlayerProfile#isComplete()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#isComplete()}
   */
  @Test
  @DisplayName("Test isComplete(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CraftPlayerProfile.isComplete()"})
  void testIsComplete_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new CraftPlayerProfile(MinecraftServer.ANONYMOUS_PLAYER_PROFILE).isComplete());
  }

  /**
   * Test {@link CraftPlayerProfile#complete(boolean, boolean)} with {@code textures}, {@code
   * onlineMode}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#complete(boolean, boolean)}
   */
  @Test
  @DisplayName("Test complete(boolean, boolean) with 'textures', 'onlineMode'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CraftPlayerProfile.complete(boolean, boolean)"})
  void testCompleteWithTexturesOnlineMode_thenReturnTrue() {
    // Arrange
    CraftPlayerProfile craftPlayerProfile =
        new CraftPlayerProfile(MinecraftServer.ANONYMOUS_PLAYER_PROFILE);

    // Act
    boolean actualCompleteResult = craftPlayerProfile.complete(false, false);

    // Assert
    UUID id = craftPlayerProfile.getId();
    assertEquals("00000000-0000-0000-0000-000000000000", id.toString());
    assertTrue(actualCompleteResult);
    assertSame(id, craftPlayerProfile.getUniqueId());
    assertSame(id, craftPlayerProfile.getGameProfile().getId());
  }

  /**
   * Test {@link CraftPlayerProfile#asBukkitCopy(GameProfile)}.
   *
   * <ul>
   *   <li>Then return Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#asBukkitCopy(GameProfile)}
   */
  @Test
  @DisplayName("Test asBukkitCopy(GameProfile); then return Name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PlayerProfile CraftPlayerProfile.asBukkitCopy(GameProfile)"})
  void testAsBukkitCopy_thenReturnNameIsEmptyString() {
    // Arrange
    GameProfile gameProfile = new GameProfile(Util.NIL_UUID, "");

    // Act
    PlayerProfile actualAsBukkitCopyResult = CraftPlayerProfile.asBukkitCopy(gameProfile);

    // Assert
    assertTrue(actualAsBukkitCopyResult instanceof CraftPlayerProfile);
    assertEquals("", actualAsBukkitCopyResult.getName());
    assertFalse(actualAsBukkitCopyResult.isComplete());
    assertEquals(gameProfile, ((CraftPlayerProfile) actualAsBukkitCopyResult).getGameProfile());
  }

  /**
   * Test {@link CraftPlayerProfile#asBukkitCopy(GameProfile)}.
   *
   * <ul>
   *   <li>When {@link GameProfile#GameProfile(UUID, String)} with id is {@link Util#NIL_UUID} and
   *       {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#asBukkitCopy(GameProfile)}
   */
  @Test
  @DisplayName(
      "Test asBukkitCopy(GameProfile); when GameProfile(UUID, String) with id is NIL_UUID and 'Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PlayerProfile CraftPlayerProfile.asBukkitCopy(GameProfile)"})
  void testAsBukkitCopy_whenGameProfileWithIdIsNil_uuidAndName_thenReturnName() {
    // Arrange
    GameProfile gameProfile = new GameProfile(Util.NIL_UUID, "Name");

    // Act
    PlayerProfile actualAsBukkitCopyResult = CraftPlayerProfile.asBukkitCopy(gameProfile);

    // Assert
    assertTrue(actualAsBukkitCopyResult instanceof CraftPlayerProfile);
    assertEquals("Name", actualAsBukkitCopyResult.getName());
    assertTrue(actualAsBukkitCopyResult.isComplete());
    assertEquals(gameProfile, ((CraftPlayerProfile) actualAsBukkitCopyResult).getGameProfile());
  }

  /**
   * Test {@link CraftPlayerProfile#asBukkitMirror(GameProfile)}.
   *
   * <ul>
   *   <li>When {@link MinecraftServer#ANONYMOUS_PLAYER_PROFILE}.
   *   <li>Then return {@link CraftPlayerProfile}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#asBukkitMirror(GameProfile)}
   */
  @Test
  @DisplayName(
      "Test asBukkitMirror(GameProfile); when ANONYMOUS_PLAYER_PROFILE; then return CraftPlayerProfile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PlayerProfile CraftPlayerProfile.asBukkitMirror(GameProfile)"})
  void testAsBukkitMirror_whenAnonymous_player_profile_thenReturnCraftPlayerProfile() {
    // Arrange
    GameProfile profile = MinecraftServer.ANONYMOUS_PLAYER_PROFILE;

    // Act
    PlayerProfile actualAsBukkitMirrorResult = CraftPlayerProfile.asBukkitMirror(profile);

    // Assert
    assertTrue(actualAsBukkitMirrorResult instanceof CraftPlayerProfile);
    UUID id = actualAsBukkitMirrorResult.getId();
    assertEquals("00000000-0000-0000-0000-000000000000", id.toString());
    assertEquals("Anonymous Player", actualAsBukkitMirrorResult.getName());
    PlayerTextures textures = actualAsBukkitMirrorResult.getTextures();
    assertNull(textures.getCape());
    assertNull(textures.getSkin());
    assertEquals(0L, textures.getTimestamp());
    assertEquals(SkinModel.CLASSIC, textures.getSkinModel());
    assertFalse(actualAsBukkitMirrorResult.hasTextures());
    assertFalse(textures.isSigned());
    assertTrue(actualAsBukkitMirrorResult.isComplete());
    assertTrue(actualAsBukkitMirrorResult.getProperties().isEmpty());
    assertSame(id, actualAsBukkitMirrorResult.getUniqueId());
    assertSame(profile, ((CraftPlayerProfile) actualAsBukkitMirrorResult).getGameProfile());
  }

  /**
   * Test {@link CraftPlayerProfile#asAuthlib(PlayerProfile)} with {@code profile}.
   *
   * <ul>
   *   <li>When deserialize {@link HashMap#HashMap()}.
   *   <li>Then Properties entries return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#asAuthlib(PlayerProfile)}
   */
  @Test
  @DisplayName(
      "Test asAuthlib(PlayerProfile) with 'profile'; when deserialize HashMap(); then Properties entries return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GameProfile CraftPlayerProfile.asAuthlib(PlayerProfile)"})
  void testAsAuthlibWithProfile_whenDeserializeHashMap_thenPropertiesEntriesReturnSet() {
    // Arrange and Act
    GameProfile actualAsAuthlibResult =
        CraftPlayerProfile.asAuthlib(CraftPlayerProfile.deserialize(new HashMap<>()));

    // Assert
    PropertyMap properties = actualAsAuthlibResult.getProperties();
    Collection<Entry<String, Property>> entriesResult = properties.entries();
    assertTrue(entriesResult instanceof Set);
    assertEquals("", actualAsAuthlibResult.getName());
    assertEquals("00000000-0000-0000-0000-000000000000", actualAsAuthlibResult.getId().toString());
    assertEquals(0, properties.size());
    assertTrue(properties.isEmpty());
    assertTrue(entriesResult.isEmpty());
    assertTrue(properties.keys().isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#asAuthlib(ProfileProperty)} with {@code property}.
   *
   * <ul>
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#asAuthlib(ProfileProperty)}
   */
  @Test
  @DisplayName("Test asAuthlib(ProfileProperty) with 'property'; then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Property CraftPlayerProfile.asAuthlib(ProfileProperty)"})
  void testAsAuthlibWithProperty_thenReturnValueIs42() {
    // Arrange and Act
    Property actualAsAuthlibResult =
        CraftPlayerProfile.asAuthlib(new ProfileProperty("Name", "42"));

    // Assert
    assertEquals("42", actualAsAuthlibResult.value());
    assertEquals("Name", actualAsAuthlibResult.name());
    assertNull(actualAsAuthlibResult.signature());
  }

  /**
   * Test {@link CraftPlayerProfile#asResolvableProfileCopy(PlayerProfile)}.
   *
   * <ul>
   *   <li>Then return gameProfile Name is {@code Anonymous Player}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#asResolvableProfileCopy(PlayerProfile)}
   */
  @Test
  @DisplayName(
      "Test asResolvableProfileCopy(PlayerProfile); then return gameProfile Name is 'Anonymous Player'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolvableProfile CraftPlayerProfile.asResolvableProfileCopy(PlayerProfile)"})
  void testAsResolvableProfileCopy_thenReturnGameProfileNameIsAnonymousPlayer() {
    // Arrange and Act
    ResolvableProfile actualAsResolvableProfileCopyResult =
        CraftPlayerProfile.asResolvableProfileCopy(
            new CraftPlayerProfile(MinecraftServer.ANONYMOUS_PLAYER_PROFILE));

    // Assert
    assertEquals("Anonymous Player", actualAsResolvableProfileCopyResult.gameProfile().getName());
    assertEquals("Anonymous Player", actualAsResolvableProfileCopyResult.name().get());
  }

  /**
   * Test {@link CraftPlayerProfile#asResolvableProfileCopy(PlayerProfile)}.
   *
   * <ul>
   *   <li>Then return gameProfile Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#asResolvableProfileCopy(PlayerProfile)}
   */
  @Test
  @DisplayName(
      "Test asResolvableProfileCopy(PlayerProfile); then return gameProfile Name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolvableProfile CraftPlayerProfile.asResolvableProfileCopy(PlayerProfile)"})
  void testAsResolvableProfileCopy_thenReturnGameProfileNameIsEmptyString() {
    // Arrange and Act
    ResolvableProfile actualAsResolvableProfileCopyResult =
        CraftPlayerProfile.asResolvableProfileCopy(CraftPlayerProfile.deserialize(new HashMap<>()));

    // Assert
    assertEquals("", actualAsResolvableProfileCopyResult.gameProfile().getName());
    Optional<UUID> idResult = actualAsResolvableProfileCopyResult.id();
    assertFalse(idResult.isPresent());
    assertSame(idResult, actualAsResolvableProfileCopyResult.name());
  }

  /**
   * Test {@link CraftPlayerProfile#asResolvableProfileCopy(PlayerProfile)}.
   *
   * <ul>
   *   <li>Then return gameProfile Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#asResolvableProfileCopy(PlayerProfile)}
   */
  @Test
  @DisplayName(
      "Test asResolvableProfileCopy(PlayerProfile); then return gameProfile Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolvableProfile CraftPlayerProfile.asResolvableProfileCopy(PlayerProfile)"})
  void testAsResolvableProfileCopy_thenReturnGameProfileNameIsName() {
    // Arrange and Act
    ResolvableProfile actualAsResolvableProfileCopyResult =
        CraftPlayerProfile.asResolvableProfileCopy(
            new org.bukkit.craftbukkit.profile.CraftPlayerProfile(Util.NIL_UUID, "Name"));

    // Assert
    assertEquals("Name", actualAsResolvableProfileCopyResult.gameProfile().getName());
    assertEquals("Name", actualAsResolvableProfileCopyResult.name().get());
  }

  /**
   * Test {@link CraftPlayerProfile#serialize()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#serialize()}
   */
  @Test
  @DisplayName("Test serialize(); given deserialize HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CraftPlayerProfile.serialize()"})
  void testSerialize_givenDeserializeHashMap_thenReturnEmpty() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act and Assert
    assertTrue(deserializeResult.serialize().isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#serialize()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#serialize()}
   */
  @Test
  @DisplayName("Test serialize(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CraftPlayerProfile.serialize()"})
  void testSerialize_thenReturnSizeIsTwo() {
    // Arrange and Act
    Map<String, Object> actualSerializeResult =
        new CraftPlayerProfile(MinecraftServer.ANONYMOUS_PLAYER_PROFILE).serialize();

    // Assert
    assertEquals(2, actualSerializeResult.size());
    assertEquals("00000000-0000-0000-0000-000000000000", actualSerializeResult.get("uniqueId"));
    assertEquals("Anonymous Player", actualSerializeResult.get("name"));
  }

  /**
   * Test {@link CraftPlayerProfile#deserialize(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return GameProfile Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#deserialize(Map)}
   */
  @Test
  @DisplayName(
      "Test deserialize(Map); when HashMap(); then return GameProfile Name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CraftPlayerProfile CraftPlayerProfile.deserialize(Map)"})
  void testDeserialize_whenHashMap_thenReturnGameProfileNameIsEmptyString() {
    // Arrange and Act
    CraftPlayerProfile actualDeserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Assert
    assertEquals("", actualDeserializeResult.getGameProfile().getName());
    assertNull(actualDeserializeResult.getName());
    CraftPlayerTextures textures = actualDeserializeResult.getTextures();
    assertNull(textures.getCape());
    assertNull(textures.getSkin());
    assertNull(actualDeserializeResult.getId());
    assertNull(actualDeserializeResult.getUniqueId());
    assertEquals(0L, textures.getTimestamp());
    assertEquals(SkinModel.CLASSIC, textures.getSkinModel());
    assertFalse(actualDeserializeResult.isComplete());
    assertFalse(actualDeserializeResult.hasTextures());
    assertFalse(textures.isSigned());
    assertTrue(actualDeserializeResult.getProperties().isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#asAuthlibCopy(PlayerProfile)}.
   *
   * <ul>
   *   <li>Then return {@link GameProfile#GameProfile(UUID, String)} with id is {@link
   *       Util#NIL_UUID} and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#asAuthlibCopy(PlayerProfile)}
   */
  @Test
  @DisplayName(
      "Test asAuthlibCopy(PlayerProfile); then return GameProfile(UUID, String) with id is NIL_UUID and 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GameProfile CraftPlayerProfile.asAuthlibCopy(PlayerProfile)"})
  void testAsAuthlibCopy_thenReturnGameProfileWithIdIsNil_uuidAndName() {
    // Arrange
    GameProfile profile = new GameProfile(Util.NIL_UUID, "Name");

    // Act and Assert
    assertEquals(profile, CraftPlayerProfile.asAuthlibCopy(new CraftPlayerProfile(profile)));
  }

  /**
   * Test {@link CraftPlayerProfile#asAuthlibCopy(PlayerProfile)}.
   *
   * <ul>
   *   <li>Then return {@link GameProfile#GameProfile(UUID, String)} with id is {@link
   *       Util#NIL_UUID} and name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#asAuthlibCopy(PlayerProfile)}
   */
  @Test
  @DisplayName(
      "Test asAuthlibCopy(PlayerProfile); then return GameProfile(UUID, String) with id is NIL_UUID and name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GameProfile CraftPlayerProfile.asAuthlibCopy(PlayerProfile)"})
  void testAsAuthlibCopy_thenReturnGameProfileWithIdIsNil_uuidAndNameIsEmptyString() {
    // Arrange
    GameProfile profile = new GameProfile(Util.NIL_UUID, "");

    // Act and Assert
    assertEquals(profile, CraftPlayerProfile.asAuthlibCopy(new CraftPlayerProfile(profile)));
  }

  /**
   * Test {@link CraftPlayerProfile#asAuthlibCopy(PlayerProfile)}.
   *
   * <ul>
   *   <li>When deserialize {@link HashMap#HashMap()}.
   *   <li>Then Properties entries return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#asAuthlibCopy(PlayerProfile)}
   */
  @Test
  @DisplayName(
      "Test asAuthlibCopy(PlayerProfile); when deserialize HashMap(); then Properties entries return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GameProfile CraftPlayerProfile.asAuthlibCopy(PlayerProfile)"})
  void testAsAuthlibCopy_whenDeserializeHashMap_thenPropertiesEntriesReturnSet() {
    // Arrange and Act
    GameProfile actualAsAuthlibCopyResult =
        CraftPlayerProfile.asAuthlibCopy(CraftPlayerProfile.deserialize(new HashMap<>()));

    // Assert
    PropertyMap properties = actualAsAuthlibCopyResult.getProperties();
    Collection<Entry<String, Property>> entriesResult = properties.entries();
    assertTrue(entriesResult instanceof Set);
    assertEquals("", actualAsAuthlibCopyResult.getName());
    assertEquals(
        "00000000-0000-0000-0000-000000000000", actualAsAuthlibCopyResult.getId().toString());
    assertEquals(0, properties.size());
    assertTrue(properties.isEmpty());
    assertTrue(entriesResult.isEmpty());
    assertTrue(properties.keys().isEmpty());
  }

  /**
   * Test {@link CraftPlayerProfile#equals(Object)}, and {@link CraftPlayerProfile#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CraftPlayerProfile#equals(Object)}
   *   <li>{@link CraftPlayerProfile#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CraftPlayerProfile.equals(Object)",
    "int CraftPlayerProfile.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());
    CraftPlayerProfile deserializeResult2 = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act and Assert
    assertEquals(deserializeResult, deserializeResult2);
    assertEquals(deserializeResult.hashCode(), deserializeResult2.hashCode());
  }

  /**
   * Test {@link CraftPlayerProfile#equals(Object)}, and {@link CraftPlayerProfile#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CraftPlayerProfile#equals(Object)}
   *   <li>{@link CraftPlayerProfile#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CraftPlayerProfile.equals(Object)",
    "int CraftPlayerProfile.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act and Assert
    assertEquals(deserializeResult, deserializeResult);
    int expectedHashCodeResult = deserializeResult.hashCode();
    assertEquals(expectedHashCodeResult, deserializeResult.hashCode());
  }

  /**
   * Test {@link CraftPlayerProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CraftPlayerProfile.equals(Object)",
    "int CraftPlayerProfile.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CraftPlayerProfile craftPlayerProfile =
        new CraftPlayerProfile(MinecraftServer.ANONYMOUS_PLAYER_PROFILE);

    // Act and Assert
    assertNotEquals(craftPlayerProfile, CraftPlayerProfile.deserialize(new HashMap<>()));
  }

  /**
   * Test {@link CraftPlayerProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CraftPlayerProfile.equals(Object)",
    "int CraftPlayerProfile.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CraftPlayerProfile craftPlayerProfile =
        new CraftPlayerProfile(new GameProfile(Util.NIL_UUID, "Name"));

    // Act and Assert
    assertNotEquals(
        craftPlayerProfile, new CraftPlayerProfile(MinecraftServer.ANONYMOUS_PLAYER_PROFILE));
  }

  /**
   * Test {@link CraftPlayerProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CraftPlayerProfile.equals(Object)",
    "int CraftPlayerProfile.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act and Assert
    assertNotEquals(deserializeResult, null);
  }

  /**
   * Test {@link CraftPlayerProfile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CraftPlayerProfile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CraftPlayerProfile.equals(Object)",
    "int CraftPlayerProfile.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CraftPlayerProfile deserializeResult = CraftPlayerProfile.deserialize(new HashMap<>());

    // Act and Assert
    assertNotEquals(deserializeResult, "Different type to CraftPlayerProfile");
  }
}

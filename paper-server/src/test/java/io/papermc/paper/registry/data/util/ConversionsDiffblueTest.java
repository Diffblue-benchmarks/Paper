package io.papermc.paper.registry.data.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DataResult.Error;
import com.mojang.serialization.Lifecycle;
import com.mojang.serialization.Lifecycle.Deprecated;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.MapCodec.MapCodecCodec;
import com.mojang.serialization.codecs.KeyDispatchCodec;
import io.papermc.paper.ServerBuildInfo;
import io.papermc.paper.adventure.providers.ClickCallbackProviderImpl;
import io.papermc.paper.registry.data.client.ClientTextureAsset;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import net.minecraft.core.ClientAsset;
import net.minecraft.core.DefaultedMappedRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.RegistryOps.HolderLookupAdapter;
import net.minecraft.resources.RegistryOps.RegistryInfo;
import net.minecraft.resources.RegistryOps.RegistryInfoLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class ConversionsDiffblueTest {
  /**
   * Test {@link Conversions#Conversions(RegistryInfoLookup)}.
   *
   * <p>Method under test: {@link Conversions#Conversions(RegistryInfoLookup)}
   */
  @Test
  @DisplayName("Test new Conversions(RegistryInfoLookup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Conversions.<init>(RegistryInfoLookup)"})
  void testNewConversions() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));

    // Act and Assert
    RegistryInfoLookup lookupResult = new Conversions(lookup).lookup();
    assertTrue(lookupResult instanceof HolderLookupAdapter);
    assertSame(lookup, lookupResult);
  }

  /**
   * Test {@link Conversions#convert(Object, Codec, Codec)}.
   *
   * <p>Method under test: {@link Conversions#convert(Object, Codec, Codec)}
   */
  @Test
  @DisplayName("Test convert(Object, Codec, Codec)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Conversions.convert(Object, Codec, Codec)"})
  void testConvert() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    Supplier<String> messageSupplier = mock(Supplier.class);
    when(messageSupplier.get()).thenReturn("Get");
    Optional<Object> partialValue = Optional.of(ConfigurationTransformation.WILDCARD_OBJECT);

    Error<Object> error = new Error<>(messageSupplier, partialValue, Lifecycle.experimental());

    Function<Object, DataResult<Object>> type = mock(Function.class);
    when(type.apply(Mockito.<Object>any())).thenReturn(error);

    Supplier<String> messageSupplier2 = mock(Supplier.class);
    when(messageSupplier2.get()).thenReturn("Get");
    KeyDispatchCodec<Object, Object> keyDispatchCodec =
        new KeyDispatchCodec<>(
            "Type Key", ExtraCodecs.JAVA, mock(Function.class), mock(Function.class));
    Optional<MapCodec<Object>> partialValue2 = Optional.of(keyDispatchCodec);

    Error<MapCodec<Object>> error2 =
        new Error<>(messageSupplier2, partialValue2, Lifecycle.experimental());

    Function<Object, DataResult<MapCodec<Object>>> codec = mock(Function.class);
    when(codec.apply(Mockito.<Object>any())).thenReturn(error2);

    KeyDispatchCodec<Object, Object> codec2 =
        new KeyDispatchCodec<>("Type Key", ExtraCodecs.JAVA, type, codec);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            conversions.convert(
                ConfigurationTransformation.WILDCARD_OBJECT,
                ExtraCodecs.JAVA,
                new MapCodecCodec<>(codec2)));
    verify(type).apply(isA(Object.class));
    verify(codec).apply(isA(Object.class));
    verify(messageSupplier).get();
    verify(messageSupplier2).get();
  }

  /**
   * Test {@link Conversions#convert(Object, Codec, Codec)}.
   *
   * <p>Method under test: {@link Conversions#convert(Object, Codec, Codec)}
   */
  @Test
  @DisplayName("Test convert(Object, Codec, Codec)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Conversions.convert(Object, Codec, Codec)"})
  void testConvert2() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    Supplier<String> messageSupplier = mock(Supplier.class);
    when(messageSupplier.get()).thenReturn("Get");
    Optional<Object> partialValue = Optional.empty();

    Error<Object> error = new Error<>(messageSupplier, partialValue, Lifecycle.experimental());

    Function<Object, DataResult<Object>> type = mock(Function.class);
    when(type.apply(Mockito.<Object>any())).thenReturn(error);
    KeyDispatchCodec<Object, Object> codec =
        new KeyDispatchCodec<>("Type Key", ExtraCodecs.JAVA, type, mock(Function.class));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            conversions.convert(
                ConfigurationTransformation.WILDCARD_OBJECT,
                ExtraCodecs.JAVA,
                new MapCodecCodec<>(codec)));
    verify(type).apply(isA(Object.class));
    verify(messageSupplier).get();
  }

  /**
   * Test {@link Conversions#convert(Object, Codec, Codec)}.
   *
   * <p>Method under test: {@link Conversions#convert(Object, Codec, Codec)}
   */
  @Test
  @DisplayName("Test convert(Object, Codec, Codec)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Conversions.convert(Object, Codec, Codec)"})
  void testConvert3() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    Supplier<String> messageSupplier = mock(Supplier.class);
    when(messageSupplier.get()).thenReturn("Get");
    Optional<Object> partialValue = Optional.of(ConfigurationTransformation.WILDCARD_OBJECT);

    Error<Object> error = new Error<>(messageSupplier, partialValue, Lifecycle.stable());

    Function<Object, DataResult<Object>> type = mock(Function.class);
    when(type.apply(Mockito.<Object>any())).thenReturn(error);

    Supplier<String> messageSupplier2 = mock(Supplier.class);
    when(messageSupplier2.get()).thenReturn("Get");
    KeyDispatchCodec<Object, Object> keyDispatchCodec =
        new KeyDispatchCodec<>(
            "Type Key", ExtraCodecs.JAVA, mock(Function.class), mock(Function.class));
    Optional<MapCodec<Object>> partialValue2 = Optional.of(keyDispatchCodec);

    Error<MapCodec<Object>> error2 =
        new Error<>(messageSupplier2, partialValue2, Lifecycle.experimental());

    Function<Object, DataResult<MapCodec<Object>>> codec = mock(Function.class);
    when(codec.apply(Mockito.<Object>any())).thenReturn(error2);

    KeyDispatchCodec<Object, Object> codec2 =
        new KeyDispatchCodec<>("Type Key", ExtraCodecs.JAVA, type, codec);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            conversions.convert(
                ConfigurationTransformation.WILDCARD_OBJECT,
                ExtraCodecs.JAVA,
                new MapCodecCodec<>(codec2)));
    verify(type).apply(isA(Object.class));
    verify(codec).apply(isA(Object.class));
    verify(messageSupplier).get();
    verify(messageSupplier2).get();
  }

  /**
   * Test {@link Conversions#convert(Object, Codec, Codec)}.
   *
   * <p>Method under test: {@link Conversions#convert(Object, Codec, Codec)}
   */
  @Test
  @DisplayName("Test convert(Object, Codec, Codec)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Conversions.convert(Object, Codec, Codec)"})
  void testConvert4() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    Supplier<String> messageSupplier = mock(Supplier.class);
    when(messageSupplier.get()).thenReturn("Get");
    Optional<Object> partialValue = Optional.empty();

    Error<Object> error = new Error<>(messageSupplier, partialValue, Lifecycle.stable());

    Function<Object, DataResult<Object>> type = mock(Function.class);
    when(type.apply(Mockito.<Object>any())).thenReturn(error);
    KeyDispatchCodec<Object, Object> codec =
        new KeyDispatchCodec<>("Type Key", ExtraCodecs.JAVA, type, mock(Function.class));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            conversions.convert(
                ConfigurationTransformation.WILDCARD_OBJECT,
                ExtraCodecs.JAVA,
                new MapCodecCodec<>(codec)));
    verify(type).apply(isA(Object.class));
    verify(messageSupplier).get();
  }

  /**
   * Test {@link Conversions#convert(Object, Codec, Codec)}.
   *
   * <p>Method under test: {@link Conversions#convert(Object, Codec, Codec)}
   */
  @Test
  @DisplayName("Test convert(Object, Codec, Codec)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Conversions.convert(Object, Codec, Codec)"})
  void testConvert5() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    Supplier<String> messageSupplier = mock(Supplier.class);
    when(messageSupplier.get()).thenReturn("Get");
    Optional<Object> partialValue = Optional.empty();

    Error<Object> error = new Error<>(messageSupplier, partialValue, new Deprecated(1));

    Function<Object, DataResult<Object>> type = mock(Function.class);
    when(type.apply(Mockito.<Object>any())).thenReturn(error);
    KeyDispatchCodec<Object, Object> codec =
        new KeyDispatchCodec<>("Type Key", ExtraCodecs.JAVA, type, mock(Function.class));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            conversions.convert(
                ConfigurationTransformation.WILDCARD_OBJECT,
                ExtraCodecs.JAVA,
                new MapCodecCodec<>(codec)));
    verify(type).apply(isA(Object.class));
    verify(messageSupplier).get();
  }

  /**
   * Test {@link Conversions#convert(Object, Codec, Codec)}.
   *
   * <p>Method under test: {@link Conversions#convert(Object, Codec, Codec)}
   */
  @Test
  @DisplayName("Test convert(Object, Codec, Codec)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Conversions.convert(Object, Codec, Codec)"})
  void testConvert6() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    Supplier<String> messageSupplier = mock(Supplier.class);
    when(messageSupplier.get()).thenReturn("Get");
    Optional<Object> partialValue = Optional.of(ConfigurationTransformation.WILDCARD_OBJECT);

    Error<Object> error = new Error<>(messageSupplier, partialValue, Lifecycle.stable());

    Function<Object, DataResult<Object>> type = mock(Function.class);
    when(type.apply(Mockito.<Object>any())).thenReturn(error);

    Supplier<String> messageSupplier2 = mock(Supplier.class);
    when(messageSupplier2.get()).thenReturn("Get");
    KeyDispatchCodec<Object, Object> keyDispatchCodec =
        new KeyDispatchCodec<>(
            "Type Key", ExtraCodecs.JAVA, mock(Function.class), mock(Function.class));
    Optional<MapCodec<Object>> partialValue2 = Optional.of(keyDispatchCodec);

    Error<MapCodec<Object>> error2 =
        new Error<>(messageSupplier2, partialValue2, new Deprecated(1));

    Function<Object, DataResult<MapCodec<Object>>> codec = mock(Function.class);
    when(codec.apply(Mockito.<Object>any())).thenReturn(error2);

    KeyDispatchCodec<Object, Object> codec2 =
        new KeyDispatchCodec<>("Type Key", ExtraCodecs.JAVA, type, codec);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            conversions.convert(
                ConfigurationTransformation.WILDCARD_OBJECT,
                ExtraCodecs.JAVA,
                new MapCodecCodec<>(codec2)));
    verify(type).apply(isA(Object.class));
    verify(codec).apply(isA(Object.class));
    verify(messageSupplier).get();
    verify(messageSupplier2).get();
  }

  /**
   * Test {@link Conversions#convert(Object, Codec, Codec)}.
   *
   * <p>Method under test: {@link Conversions#convert(Object, Codec, Codec)}
   */
  @Test
  @DisplayName("Test convert(Object, Codec, Codec)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Conversions.convert(Object, Codec, Codec)"})
  void testConvert7() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    Supplier<String> messageSupplier = mock(Supplier.class);
    when(messageSupplier.get()).thenReturn("Get");
    Optional<Object> partialValue = Optional.of(ConfigurationTransformation.WILDCARD_OBJECT);

    Error<Object> error = new Error<>(messageSupplier, partialValue, new Deprecated(1));

    Function<Object, DataResult<Object>> type = mock(Function.class);
    when(type.apply(Mockito.<Object>any())).thenReturn(error);

    Supplier<String> messageSupplier2 = mock(Supplier.class);
    when(messageSupplier2.get()).thenReturn("Get");
    KeyDispatchCodec<Object, Object> keyDispatchCodec =
        new KeyDispatchCodec<>(
            "Type Key", ExtraCodecs.JAVA, mock(Function.class), mock(Function.class));
    Optional<MapCodec<Object>> partialValue2 = Optional.of(keyDispatchCodec);

    Error<MapCodec<Object>> error2 =
        new Error<>(messageSupplier2, partialValue2, new Deprecated(1));

    Function<Object, DataResult<MapCodec<Object>>> codec = mock(Function.class);
    when(codec.apply(Mockito.<Object>any())).thenReturn(error2);

    KeyDispatchCodec<Object, Object> codec2 =
        new KeyDispatchCodec<>("Type Key", ExtraCodecs.JAVA, type, codec);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            conversions.convert(
                ConfigurationTransformation.WILDCARD_OBJECT,
                ExtraCodecs.JAVA,
                new MapCodecCodec<>(codec2)));
    verify(type).apply(isA(Object.class));
    verify(codec).apply(isA(Object.class));
    verify(messageSupplier).get();
    verify(messageSupplier2).get();
  }

  /**
   * Test {@link Conversions#convert(Object, Codec, Codec)}.
   *
   * <ul>
   *   <li>Given {@link Deprecated#Deprecated(int)} with since is zero.
   * </ul>
   *
   * <p>Method under test: {@link Conversions#convert(Object, Codec, Codec)}
   */
  @Test
  @DisplayName("Test convert(Object, Codec, Codec); given Deprecated(int) with since is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Conversions.convert(Object, Codec, Codec)"})
  void testConvert_givenDeprecatedWithSinceIsZero() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    Supplier<String> messageSupplier = mock(Supplier.class);
    when(messageSupplier.get()).thenReturn("Get");
    Optional<Object> partialValue = Optional.of(ConfigurationTransformation.WILDCARD_OBJECT);

    Error<Object> error = new Error<>(messageSupplier, partialValue, new Deprecated(1));

    Function<Object, DataResult<Object>> type = mock(Function.class);
    when(type.apply(Mockito.<Object>any())).thenReturn(error);

    Supplier<String> messageSupplier2 = mock(Supplier.class);
    when(messageSupplier2.get()).thenReturn("Get");
    KeyDispatchCodec<Object, Object> keyDispatchCodec =
        new KeyDispatchCodec<>(
            "Type Key", ExtraCodecs.JAVA, mock(Function.class), mock(Function.class));
    Optional<MapCodec<Object>> partialValue2 = Optional.of(keyDispatchCodec);

    Error<MapCodec<Object>> error2 =
        new Error<>(messageSupplier2, partialValue2, new Deprecated(0));

    Function<Object, DataResult<MapCodec<Object>>> codec = mock(Function.class);
    when(codec.apply(Mockito.<Object>any())).thenReturn(error2);

    KeyDispatchCodec<Object, Object> codec2 =
        new KeyDispatchCodec<>("Type Key", ExtraCodecs.JAVA, type, codec);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            conversions.convert(
                ConfigurationTransformation.WILDCARD_OBJECT,
                ExtraCodecs.JAVA,
                new MapCodecCodec<>(codec2)));
    verify(type).apply(isA(Object.class));
    verify(codec).apply(isA(Object.class));
    verify(messageSupplier).get();
    verify(messageSupplier2).get();
  }

  /**
   * Test {@link Conversions#getReferenceHolder(ResourceKey)}.
   *
   * <p>Method under test: {@link Conversions#getReferenceHolder(ResourceKey)}
   */
  @Test
  @DisplayName("Test getReferenceHolder(ResourceKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Reference Conversions.getReferenceHolder(ResourceKey)"})
  void testGetReferenceHolder() {
    // Arrange
    HolderGetter<Object> getter = mock(HolderGetter.class);
    ResourceKey<? extends Registry<Object>> key = mock(ResourceKey.class);
    DefaultedMappedRegistry<Object> owner =
        new DefaultedMappedRegistry<>("42", key, Lifecycle.experimental(), true);
    Reference<Object> createIntrusiveResult =
        Reference.createIntrusive(owner, ConfigurationTransformation.WILDCARD_OBJECT);
    when(getter.getOrThrow(Mockito.<ResourceKey<Object>>any())).thenReturn(createIntrusiveResult);
    ResourceKey<? extends Registry<Object>> key2 = mock(ResourceKey.class);
    DefaultedMappedRegistry<Object> owner2 =
        new DefaultedMappedRegistry<>("42", key2, Lifecycle.experimental(), true);

    RegistryInfo<Object> registryInfo =
        new RegistryInfo<>(owner2, getter, Lifecycle.experimental());
    Optional<RegistryInfo<Object>> ofResult = Optional.of(registryInfo);

    HolderLookupAdapter lookup = mock(HolderLookupAdapter.class);
    when(lookup.lookup(Mockito.<ResourceKey<Registry<Object>>>any())).thenReturn(ofResult);
    Conversions conversions = new Conversions(lookup);

    ResourceKey<Object> key3 = mock(ResourceKey.class);
    when(key3.registryKey()).thenReturn(null);

    // Act
    Reference<Object> actualReferenceHolder = conversions.getReferenceHolder(key3);

    // Assert
    verify(getter).getOrThrow(isA(ResourceKey.class));
    verify(lookup).lookup(isNull());
    verify(key3).registryKey();
    assertSame(createIntrusiveResult, actualReferenceHolder);
  }

  /**
   * Test {@link Conversions#asVanilla(Component)} with {@code adventure}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Conversions#asVanilla(Component)}
   */
  @Test
  @DisplayName("Test asVanilla(Component) with 'adventure'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.network.chat.Component Conversions.asVanilla(Component)"})
  void testAsVanillaWithAdventure_thenReturnNull() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));

    // Act and Assert
    assertNull(new Conversions(lookup).asVanilla((Component) null));
  }

  /**
   * Test {@link Conversions#asVanilla(ClientTextureAsset)} with {@code clientTextureAsset}.
   *
   * <p>Method under test: {@link Conversions#asVanilla(ClientTextureAsset)}
   */
  @Test
  @DisplayName("Test asVanilla(ClientTextureAsset) with 'clientTextureAsset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClientAsset Conversions.asVanilla(ClientTextureAsset)"})
  void testAsVanillaWithClientTextureAsset() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    ClientTextureAsset clientTextureAsset = mock(ClientTextureAsset.class);
    when(clientTextureAsset.texturePath())
        .thenReturn(ClickCallbackProviderImpl.DIALOG_CLICK_CALLBACK_KEY);
    when(clientTextureAsset.identifier()).thenReturn(ServerBuildInfo.BRAND_PAPER_ID);

    // Act
    ClientAsset actualAsVanillaResult = conversions.asVanilla(clientTextureAsset);

    // Assert
    verify(clientTextureAsset).identifier();
    verify(clientTextureAsset).texturePath();
    ResourceLocation texturePathResult = actualAsVanillaResult.texturePath();
    assertEquals("dialog_click_callback", texturePathResult.getPath());
    assertEquals("paper", texturePathResult.getNamespace());
    ResourceLocation idResult = actualAsVanillaResult.id();
    assertEquals("paper", idResult.getPath());
    assertEquals("paper.dialog_click_callback", texturePathResult.toShortLanguageKey());
    assertEquals("papermc", idResult.getNamespace());
    assertEquals("papermc.paper", idResult.toShortLanguageKey());
  }

  /**
   * Test {@link Conversions#asVanilla(ClientTextureAsset)} with {@code clientTextureAsset}.
   *
   * <ul>
   *   <li>Then return texturePath is id.
   * </ul>
   *
   * <p>Method under test: {@link Conversions#asVanilla(ClientTextureAsset)}
   */
  @Test
  @DisplayName(
      "Test asVanilla(ClientTextureAsset) with 'clientTextureAsset'; then return texturePath is id")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClientAsset Conversions.asVanilla(ClientTextureAsset)"})
  void testAsVanillaWithClientTextureAsset_thenReturnTexturePathIsId() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    ClientTextureAsset clientTextureAsset = mock(ClientTextureAsset.class);
    when(clientTextureAsset.texturePath()).thenReturn(ServerBuildInfo.BRAND_PAPER_ID);
    when(clientTextureAsset.identifier()).thenReturn(ServerBuildInfo.BRAND_PAPER_ID);

    // Act
    ClientAsset actualAsVanillaResult = conversions.asVanilla(clientTextureAsset);

    // Assert
    verify(clientTextureAsset).identifier();
    verify(clientTextureAsset).texturePath();
    ResourceLocation idResult = actualAsVanillaResult.id();
    assertEquals("paper", idResult.getPath());
    assertEquals("papermc", idResult.getNamespace());
    assertEquals("papermc.paper", idResult.toShortLanguageKey());
    assertEquals(idResult, actualAsVanillaResult.texturePath());
  }

  /**
   * Test {@link Conversions#asVanilla(ClientTextureAsset)} with {@code clientTextureAsset}.
   *
   * <ul>
   *   <li>Then return texturePath Namespace is {@code bukkit}.
   * </ul>
   *
   * <p>Method under test: {@link Conversions#asVanilla(ClientTextureAsset)}
   */
  @Test
  @DisplayName(
      "Test asVanilla(ClientTextureAsset) with 'clientTextureAsset'; then return texturePath Namespace is 'bukkit'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClientAsset Conversions.asVanilla(ClientTextureAsset)"})
  void testAsVanillaWithClientTextureAsset_thenReturnTexturePathNamespaceIsBukkit() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    ClientTextureAsset clientTextureAsset = mock(ClientTextureAsset.class);
    when(clientTextureAsset.texturePath()).thenReturn(NamespacedKey.randomKey());
    when(clientTextureAsset.identifier()).thenReturn(ServerBuildInfo.BRAND_PAPER_ID);

    // Act
    ClientAsset actualAsVanillaResult = conversions.asVanilla(clientTextureAsset);

    // Assert
    verify(clientTextureAsset).identifier();
    verify(clientTextureAsset).texturePath();
    assertEquals("bukkit", actualAsVanillaResult.texturePath().getNamespace());
    ResourceLocation idResult = actualAsVanillaResult.id();
    assertEquals("paper", idResult.getPath());
    assertEquals("papermc", idResult.getNamespace());
    assertEquals("papermc.paper", idResult.toShortLanguageKey());
  }

  /**
   * Test {@link Conversions#asAdventure(Component)}.
   *
   * <ul>
   *   <li>Then return insertion is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Conversions#asAdventure(net.minecraft.network.chat.Component)}
   */
  @Test
  @DisplayName("Test asAdventure(Component); then return insertion is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component Conversions.asAdventure(net.minecraft.network.chat.Component)"})
  void testAsAdventure_thenReturnInsertionIsNull() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));

    // Act
    Component actualAsAdventureResult = new Conversions(lookup).asAdventure(null);

    // Assert
    assertNull(actualAsAdventureResult.insertion());
    assertNull(actualAsAdventureResult.font());
    assertNull(actualAsAdventureResult.color());
    Map<TextDecoration, State> decorationsResult = actualAsAdventureResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.ITALIC));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(actualAsAdventureResult.hasStyling());
    Component actualCompactResult = actualAsAdventureResult.compact();
    assertSame(actualAsAdventureResult, actualCompactResult);
  }

  /**
   * Test {@link Conversions#asAdventure(Component)}.
   *
   * <ul>
   *   <li>Then return insertion is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Conversions#asAdventure(net.minecraft.network.chat.Component)}
   */
  @Test
  @DisplayName("Test asAdventure(Component); then return insertion is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component Conversions.asAdventure(net.minecraft.network.chat.Component)"})
  void testAsAdventure_thenReturnInsertionIsNull2() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));

    // Act
    Component actualAsAdventureResult = new Conversions(lookup).asAdventure(null);

    // Assert
    assertNull(actualAsAdventureResult.insertion());
    assertNull(actualAsAdventureResult.font());
    assertNull(actualAsAdventureResult.color());
    Map<TextDecoration, State> decorationsResult = actualAsAdventureResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.ITALIC));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(actualAsAdventureResult.hasStyling());
    Component actualCompactResult = actualAsAdventureResult.compact();
    assertSame(actualAsAdventureResult, actualCompactResult);
  }

  /**
   * Test {@link Conversions#asBukkit(ClientAsset)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Conversions#asBukkit(ClientAsset)}
   */
  @Test
  @DisplayName("Test asBukkit(ClientAsset); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClientTextureAsset Conversions.asBukkit(ClientAsset)"})
  void testAsBukkit_thenReturnNull() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));

    // Act and Assert
    assertNull(new Conversions(lookup).asBukkit(null));
  }
}

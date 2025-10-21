package io.papermc.paper.registry;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.ServerBuildInfo;
import io.papermc.paper.adventure.providers.ClickCallbackProviderImpl;
import io.papermc.paper.registry.PaperRegistryBuilder.Filler;
import io.papermc.paper.registry.data.util.Conversions;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.RegistryOps.HolderLookupAdapter;
import net.minecraft.resources.ResourceKey;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class PaperRegistryBuilderFactoryDiffblueTest {
  /**
   * Test {@link PaperRegistryBuilderFactory#empty()}.
   *
   * <ul>
   *   <li>Given {@link PaperRegistryBuilder} {@link PaperRegistryBuilder#build()} return {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then calls {@link PaperRegistryBuilder#build()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistryBuilderFactory#empty()}
   */
  @Test
  @DisplayName(
      "Test empty(); given PaperRegistryBuilder build() return WILDCARD_OBJECT; then calls build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperRegistryBuilder PaperRegistryBuilderFactory.empty()"})
  void testEmpty_givenPaperRegistryBuilderBuildReturnWildcard_object_thenCallsBuild() {
    // Arrange
    PaperRegistryBuilder<Object, Keyed> paperRegistryBuilder = mock(PaperRegistryBuilder.class);
    when(paperRegistryBuilder.build()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Filler<Object, Keyed, PaperRegistryBuilder<Object, Keyed>> builderFiller = mock(Filler.class);
    when(builderFiller.create(Mockito.<Conversions>any())).thenReturn(paperRegistryBuilder);
    ResourceKey<? extends Registry<Object>> registryKey = mock(ResourceKey.class);
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    PaperRegistryBuilderFactory<Object, Keyed, PaperRegistryBuilder<Object, Keyed>>
        paperRegistryBuilderFactory =
            new PaperRegistryBuilderFactory<>(
                registryKey, conversions, builderFiller, mock(Function.class));

    // Act
    paperRegistryBuilderFactory.empty().build();

    // Assert
    verify(paperRegistryBuilder).build();
    verify(builderFiller).create(isA(Conversions.class));
  }

  /**
   * Test {@link PaperRegistryBuilderFactory#copyFrom(TypedKey)}.
   *
   * <p>Method under test: {@link PaperRegistryBuilderFactory#copyFrom(TypedKey)}
   */
  @Test
  @DisplayName("Test copyFrom(TypedKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperRegistryBuilder PaperRegistryBuilderFactory.copyFrom(TypedKey)"})
  void testCopyFrom() {
    // Arrange
    PaperRegistryBuilder<Object, Keyed> paperRegistryBuilder = mock(PaperRegistryBuilder.class);
    when(paperRegistryBuilder.build()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Filler<Object, Keyed, PaperRegistryBuilder<Object, Keyed>> builderFiller = mock(Filler.class);
    when(builderFiller.fill(Mockito.<Conversions>any(), Mockito.<Object>any()))
        .thenReturn(paperRegistryBuilder);

    Function<ResourceKey<Object>, Optional<Object>> existingValueGetter = mock(Function.class);
    Optional<Object> ofResult = Optional.of(ConfigurationTransformation.WILDCARD_OBJECT);
    when(existingValueGetter.apply(Mockito.<ResourceKey<Object>>any())).thenReturn(ofResult);
    ResourceKey<? extends Registry<Object>> registryKey = mock(ResourceKey.class);
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    PaperRegistryBuilderFactory<Object, Keyed, PaperRegistryBuilder<Object, Keyed>>
        paperRegistryBuilderFactory =
            new PaperRegistryBuilderFactory<>(
                registryKey, conversions, builderFiller, existingValueGetter);
    TypedKeyImpl<Keyed> key =
        new TypedKeyImpl<>(
            ClickCallbackProviderImpl.DIALOG_CLICK_CALLBACK_KEY,
            new RegistryKeyImpl<>(ServerBuildInfo.BRAND_PAPER_ID));

    // Act
    PaperRegistryBuilder<Object, Keyed> actualCopyFromResult =
        paperRegistryBuilderFactory.copyFrom(key);
    actualCopyFromResult.build();

    // Assert
    verify(paperRegistryBuilder).build();
    verify(builderFiller).fill(isA(Conversions.class), isA(Object.class));
    verify(existingValueGetter).apply(isA(ResourceKey.class));
  }

  /**
   * Test {@link PaperRegistryBuilderFactory#copyFrom(TypedKey)}.
   *
   * <ul>
   *   <li>Given {@link PaperRegistryBuilder} {@link PaperRegistryBuilder#build()} return {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then calls {@link PaperRegistryBuilder#build()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistryBuilderFactory#copyFrom(TypedKey)}
   */
  @Test
  @DisplayName(
      "Test copyFrom(TypedKey); given PaperRegistryBuilder build() return WILDCARD_OBJECT; then calls build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperRegistryBuilder PaperRegistryBuilderFactory.copyFrom(TypedKey)"})
  void testCopyFrom_givenPaperRegistryBuilderBuildReturnWildcard_object_thenCallsBuild() {
    // Arrange
    PaperRegistryBuilder<Object, Keyed> paperRegistryBuilder = mock(PaperRegistryBuilder.class);
    when(paperRegistryBuilder.build()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Filler<Object, Keyed, PaperRegistryBuilder<Object, Keyed>> builderFiller = mock(Filler.class);
    when(builderFiller.fill(Mockito.<Conversions>any(), Mockito.<Object>any()))
        .thenReturn(paperRegistryBuilder);

    Function<ResourceKey<Object>, Optional<Object>> existingValueGetter = mock(Function.class);
    Optional<Object> ofResult = Optional.of(ConfigurationTransformation.WILDCARD_OBJECT);
    when(existingValueGetter.apply(Mockito.<ResourceKey<Object>>any())).thenReturn(ofResult);
    ResourceKey<? extends Registry<Object>> registryKey = mock(ResourceKey.class);
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    PaperRegistryBuilderFactory<Object, Keyed, PaperRegistryBuilder<Object, Keyed>>
        paperRegistryBuilderFactory =
            new PaperRegistryBuilderFactory<>(
                registryKey, conversions, builderFiller, existingValueGetter);
    TypedKeyImpl<Keyed> key =
        new TypedKeyImpl<>(
            ServerBuildInfo.BRAND_PAPER_ID, new RegistryKeyImpl<>(ServerBuildInfo.BRAND_PAPER_ID));

    // Act
    PaperRegistryBuilder<Object, Keyed> actualCopyFromResult =
        paperRegistryBuilderFactory.copyFrom(key);
    actualCopyFromResult.build();

    // Assert
    verify(paperRegistryBuilder).build();
    verify(builderFiller).fill(isA(Conversions.class), isA(Object.class));
    verify(existingValueGetter).apply(isA(ResourceKey.class));
  }

  /**
   * Test {@link PaperRegistryBuilderFactory#copyFrom(TypedKey)}.
   *
   * <ul>
   *   <li>When {@link TypedKeyImpl#TypedKeyImpl(Key, RegistryKey)} with key is randomKey and
   *       registryKey is {@link RegistryKeyImpl#RegistryKeyImpl(Key)}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistryBuilderFactory#copyFrom(TypedKey)}
   */
  @Test
  @DisplayName(
      "Test copyFrom(TypedKey); when TypedKeyImpl(Key, RegistryKey) with key is randomKey and registryKey is RegistryKeyImpl(Key)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperRegistryBuilder PaperRegistryBuilderFactory.copyFrom(TypedKey)"})
  void testCopyFrom_whenTypedKeyImplWithKeyIsRandomKeyAndRegistryKeyIsRegistryKeyImpl() {
    // Arrange
    PaperRegistryBuilder<Object, Keyed> paperRegistryBuilder = mock(PaperRegistryBuilder.class);
    when(paperRegistryBuilder.build()).thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    Filler<Object, Keyed, PaperRegistryBuilder<Object, Keyed>> builderFiller = mock(Filler.class);
    when(builderFiller.fill(Mockito.<Conversions>any(), Mockito.<Object>any()))
        .thenReturn(paperRegistryBuilder);

    Function<ResourceKey<Object>, Optional<Object>> existingValueGetter = mock(Function.class);
    Optional<Object> ofResult = Optional.of(ConfigurationTransformation.WILDCARD_OBJECT);
    when(existingValueGetter.apply(Mockito.<ResourceKey<Object>>any())).thenReturn(ofResult);
    ResourceKey<? extends Registry<Object>> registryKey = mock(ResourceKey.class);
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    PaperRegistryBuilderFactory<Object, Keyed, PaperRegistryBuilder<Object, Keyed>>
        paperRegistryBuilderFactory =
            new PaperRegistryBuilderFactory<>(
                registryKey, conversions, builderFiller, existingValueGetter);
    NamespacedKey key = NamespacedKey.randomKey();
    TypedKeyImpl<Keyed> key2 =
        new TypedKeyImpl<>(key, new RegistryKeyImpl<>(ServerBuildInfo.BRAND_PAPER_ID));

    // Act
    PaperRegistryBuilder<Object, Keyed> actualCopyFromResult =
        paperRegistryBuilderFactory.copyFrom(key2);
    actualCopyFromResult.build();

    // Assert
    verify(paperRegistryBuilder).build();
    verify(builderFiller).fill(isA(Conversions.class), isA(Object.class));
    verify(existingValueGetter).apply(isA(ResourceKey.class));
  }
}

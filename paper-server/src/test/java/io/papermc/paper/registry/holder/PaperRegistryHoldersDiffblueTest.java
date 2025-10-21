package io.papermc.paper.registry.holder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.data.util.Conversions;
import io.papermc.paper.registry.holder.RegistryHolder.Reference;
import java.util.ArrayList;
import java.util.function.Function;
import net.minecraft.core.Holder;
import net.minecraft.core.Holder.Direct;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.RegistryOps.HolderLookupAdapter;
import net.minecraft.resources.ResourceKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class PaperRegistryHoldersDiffblueTest {
  /**
   * Test {@link PaperRegistryHolders#create(Holder, Function)}.
   *
   * <ul>
   *   <li>Then calls {@link ResourceKey#registryKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistryHolders#create(Holder, Function)}
   */
  @Test
  @DisplayName("Test create(Holder, Function); then calls registryKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryHolder PaperRegistryHolders.create(Holder, Function)"})
  void testCreate_thenCallsRegistryKey() {
    // Arrange
    ResourceKey<Object> key = mock(ResourceKey.class);
    when(key.registryKey()).thenThrow(new IllegalArgumentException());
    Holder.Reference<Object> holder =
        Holder.Reference.createStandAlone(mock(HolderOwner.class), key);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> PaperRegistryHolders.create(holder, mock(Function.class)));
    verify(key).registryKey();
  }

  /**
   * Test {@link PaperRegistryHolders#create(Holder, Function)}.
   *
   * <ul>
   *   <li>Then return {@link InlinedRegistryHolderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistryHolders#create(Holder, Function)}
   */
  @Test
  @DisplayName("Test create(Holder, Function); then return InlinedRegistryHolderImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryHolder PaperRegistryHolders.create(Holder, Function)"})
  void testCreate_thenReturnInlinedRegistryHolderImpl() {
    // Arrange
    Direct<Object> holder = new Direct<>(ConfigurationTransformation.WILDCARD_OBJECT);

    Function<Object, Object> entryCreator = mock(Function.class);
    when(entryCreator.apply(Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    RegistryHolder<Object, Object> actualCreateResult =
        PaperRegistryHolders.create(holder, entryCreator);

    // Assert
    verify(entryCreator).apply(isA(Object.class));
    assertTrue(actualCreateResult instanceof InlinedRegistryHolderImpl);
    assertSame(
        holder, ((InlinedRegistryHolderImpl<Object, Object, Object>) actualCreateResult).holder());
  }

  /**
   * Test {@link PaperRegistryHolders#create(Holder, Function)}.
   *
   * <ul>
   *   <li>When {@link Function} {@link Function#apply(Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistryHolders#create(Holder, Function)}
   */
  @Test
  @DisplayName(
      "Test create(Holder, Function); when Function apply(Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryHolder PaperRegistryHolders.create(Holder, Function)"})
  void testCreate_whenFunctionApplyThrowIllegalArgumentException() {
    // Arrange
    Direct<Object> holder = new Direct<>(ConfigurationTransformation.WILDCARD_OBJECT);

    Function<Object, Object> entryCreator = mock(Function.class);
    when(entryCreator.apply(Mockito.<Object>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> PaperRegistryHolders.create(holder, entryCreator));
    verify(entryCreator).apply(isA(Object.class));
  }

  /**
   * Test {@link PaperRegistryHolders#convert(RegistryHolder, Conversions)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistryHolders#convert(RegistryHolder, Conversions)}
   */
  @Test
  @DisplayName(
      "Test convert(RegistryHolder, Conversions); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Holder PaperRegistryHolders.convert(RegistryHolder, Conversions)"})
  void testConvert_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    Reference<Object, Object> holder = mock(Reference.class);
    when(holder.key()).thenThrow(new IllegalArgumentException());
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> PaperRegistryHolders.convert(holder, new Conversions(lookup)));
    verify(holder).key();
  }

  /**
   * Test {@link PaperRegistryHolders#convert(RegistryHolder, Conversions)}.
   *
   * <ul>
   *   <li>When {@link Direct#Direct(Object)} with value is {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@link Direct}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistryHolders#convert(RegistryHolder, Conversions)}
   */
  @Test
  @DisplayName(
      "Test convert(RegistryHolder, Conversions); when Direct(Object) with value is WILDCARD_OBJECT; then return Direct")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Holder PaperRegistryHolders.convert(RegistryHolder, Conversions)"})
  void testConvert_whenDirectWithValueIsWildcard_object_thenReturnDirect() {
    // Arrange
    InlinedRegistryHolderImpl<Object, Object, Object> holder =
        new InlinedRegistryHolderImpl<>(
            ConfigurationTransformation.WILDCARD_OBJECT,
            new Direct<>(ConfigurationTransformation.WILDCARD_OBJECT));
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));

    // Act
    Holder<Object> actualConvertResult =
        PaperRegistryHolders.convert(holder, new Conversions(lookup));

    // Assert
    assertTrue(actualConvertResult instanceof Direct);
    assertEquals("[unregistered]", actualConvertResult.getRegisteredName());
  }
}

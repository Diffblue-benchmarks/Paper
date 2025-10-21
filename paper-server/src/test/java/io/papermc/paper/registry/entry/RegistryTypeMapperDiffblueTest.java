package io.papermc.paper.registry.entry;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.BiFunction;
import java.util.function.Function;
import net.minecraft.core.Holder;
import net.minecraft.core.Holder.Direct;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.HolderOwner;
import net.minecraft.resources.ResourceKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class RegistryTypeMapperDiffblueTest {
  /**
   * Test {@link RegistryTypeMapper#RegistryTypeMapper(BiFunction)}.
   *
   * <p>Method under test: {@link RegistryTypeMapper#RegistryTypeMapper(BiFunction)}
   */
  @Test
  @DisplayName("Test new RegistryTypeMapper(BiFunction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegistryTypeMapper.<init>(BiFunction)"})
  void testNewRegistryTypeMapper() {
    // Arrange and Act
    RegistryTypeMapper<Object, Object> actualRegistryTypeMapper =
        new RegistryTypeMapper<>(mock(BiFunction.class));

    // Assert
    assertFalse(actualRegistryTypeMapper.supportsDirectHolders());
  }

  /**
   * Test {@link RegistryTypeMapper#RegistryTypeMapper(Function, boolean)}.
   *
   * <p>Method under test: {@link RegistryTypeMapper#RegistryTypeMapper(Function, boolean)}
   */
  @Test
  @DisplayName("Test new RegistryTypeMapper(Function, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegistryTypeMapper.<init>(Function, boolean)"})
  void testNewRegistryTypeMapper2() {
    // Arrange and Act
    RegistryTypeMapper<Object, Object> actualRegistryTypeMapper =
        new RegistryTypeMapper<>(mock(Function.class), true);

    // Assert
    assertTrue(actualRegistryTypeMapper.supportsDirectHolders());
  }

  /**
   * Test {@link RegistryTypeMapper#createBukkit(Holder)}.
   *
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return {@link
   *       ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryTypeMapper#createBukkit(Holder)}
   */
  @Test
  @DisplayName(
      "Test createBukkit(Holder); given Function apply(Object) return WILDCARD_OBJECT; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RegistryTypeMapper.createBukkit(Holder)"})
  void testCreateBukkit_givenFunctionApplyReturnWildcard_object_thenCallsApply() {
    // Arrange
    Function<Holder<Object>, Object> byHolderCreator = mock(Function.class);
    when(byHolderCreator.apply(Mockito.<Holder<Object>>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    RegistryTypeMapper<Object, Object> registryTypeMapper =
        new RegistryTypeMapper<>(byHolderCreator, true);

    // Act
    registryTypeMapper.createBukkit(new Direct<>(ConfigurationTransformation.WILDCARD_OBJECT));

    // Assert
    verify(byHolderCreator).apply(isA(Holder.class));
  }

  /**
   * Test {@link RegistryTypeMapper#createBukkit(Holder)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link ResourceKey#location()}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryTypeMapper#createBukkit(Holder)}
   */
  @Test
  @DisplayName("Test createBukkit(Holder); given IllegalArgumentException(); then calls location()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RegistryTypeMapper.createBukkit(Holder)"})
  void testCreateBukkit_givenIllegalArgumentException_thenCallsLocation() {
    // Arrange
    RegistryTypeMapper<Object, Object> registryTypeMapper =
        new RegistryTypeMapper<>(mock(BiFunction.class));

    ResourceKey<Object> key = mock(ResourceKey.class);
    when(key.location()).thenThrow(new IllegalArgumentException());
    Reference<Object> minecraft = Reference.createStandAlone(mock(HolderOwner.class), key);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> registryTypeMapper.createBukkit(minecraft));
    verify(key).location();
  }

  /**
   * Test {@link RegistryTypeMapper#createBukkit(Holder)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryTypeMapper#createBukkit(Holder)}
   */
  @Test
  @DisplayName("Test createBukkit(Holder); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RegistryTypeMapper.createBukkit(Holder)"})
  void testCreateBukkit_thenThrowIllegalArgumentException() {
    // Arrange
    RegistryTypeMapper<Object, Object> registryTypeMapper =
        new RegistryTypeMapper<>(mock(BiFunction.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            registryTypeMapper.createBukkit(
                new Direct<>(ConfigurationTransformation.WILDCARD_OBJECT)));
  }

  /**
   * Test {@link RegistryTypeMapper#supportsDirectHolders()}.
   *
   * <p>Method under test: {@link RegistryTypeMapper#supportsDirectHolders()}
   */
  @Test
  @DisplayName("Test supportsDirectHolders()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegistryTypeMapper.supportsDirectHolders()"})
  void testSupportsDirectHolders() {
    // Arrange
    RegistryTypeMapper<Object, Object> registryTypeMapper =
        new RegistryTypeMapper<>(mock(BiFunction.class));

    // Act and Assert
    assertFalse(registryTypeMapper.supportsDirectHolders());
  }

  /**
   * Test {@link RegistryTypeMapper#constructorUsesHolder()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryTypeMapper#constructorUsesHolder()}
   */
  @Test
  @DisplayName("Test constructorUsesHolder(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegistryTypeMapper.constructorUsesHolder()"})
  void testConstructorUsesHolder_thenReturnFalse() {
    // Arrange
    RegistryTypeMapper<Object, Object> registryTypeMapper =
        new RegistryTypeMapper<>(mock(BiFunction.class));

    // Act and Assert
    assertFalse(registryTypeMapper.constructorUsesHolder());
  }

  /**
   * Test {@link RegistryTypeMapper#constructorUsesHolder()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryTypeMapper#constructorUsesHolder()}
   */
  @Test
  @DisplayName("Test constructorUsesHolder(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegistryTypeMapper.constructorUsesHolder()"})
  void testConstructorUsesHolder_thenReturnTrue() {
    // Arrange
    RegistryTypeMapper<Object, Object> registryTypeMapper =
        new RegistryTypeMapper<>(mock(Function.class), true);

    // Act and Assert
    assertTrue(registryTypeMapper.constructorUsesHolder());
  }
}

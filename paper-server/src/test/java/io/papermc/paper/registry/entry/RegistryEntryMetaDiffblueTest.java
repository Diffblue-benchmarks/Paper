package io.papermc.paper.registry.entry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.PaperRegistryBuilder;
import io.papermc.paper.registry.PaperRegistryBuilder.Filler;
import io.papermc.paper.registry.TypedKey;
import io.papermc.paper.registry.data.util.Conversions;
import io.papermc.paper.registry.entry.RegistryEntryMeta.ApiOnly;
import io.papermc.paper.registry.entry.RegistryEntryMeta.Buildable;
import io.papermc.paper.registry.entry.RegistryEntryMeta.RegistryModificationApiSupport;
import io.papermc.paper.registry.event.RegistryEntryAddEventImpl;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.RegistryOps.HolderLookupAdapter;
import net.minecraft.resources.ResourceKey;
import org.bukkit.Keyed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistryEntryMetaDiffblueTest {
  /**
   * Test Buildable {@link Buildable#createEntryAddEvent(TypedKey, PaperRegistryBuilder,
   * Conversions)}.
   *
   * <ul>
   *   <li>Then return registryKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Buildable#createEntryAddEvent(TypedKey, PaperRegistryBuilder,
   * Conversions)}
   */
  @Test
  @DisplayName(
      "Test Buildable createEntryAddEvent(TypedKey, PaperRegistryBuilder, Conversions); then return registryKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RegistryEntryAddEventImpl Buildable.createEntryAddEvent(TypedKey, PaperRegistryBuilder, Conversions)"
  })
  void testBuildableCreateEntryAddEvent_thenReturnRegistryKeyIsNull() {
    // Arrange
    ResourceKey<? extends Registry<Object>> mcKey = mock(ResourceKey.class);
    Class<Object> classToPreload = Object.class;
    RegistryTypeMapper<Object, Keyed> registryTypeMapper =
        new RegistryTypeMapper<>(mock(BiFunction.class));

    Buildable<Object, Keyed, PaperRegistryBuilder<Object, Keyed>> buildable =
        new Buildable<>(
            mcKey,
            null,
            classToPreload,
            registryTypeMapper,
            mock(BiFunction.class),
            mock(Filler.class),
            RegistryModificationApiSupport.NONE);
    PaperRegistryBuilder<Object, Keyed> paperRegistryBuilder = mock(PaperRegistryBuilder.class);
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);

    // Act
    RegistryEntryAddEventImpl<Keyed, PaperRegistryBuilder<Object, Keyed>>
        actualCreateEntryAddEventResult =
            buildable.createEntryAddEvent(null, paperRegistryBuilder, conversions);

    // Assert
    assertNull(actualCreateEntryAddEventResult.registryKey());
    assertNull(actualCreateEntryAddEventResult.key());
    assertSame(conversions, actualCreateEntryAddEventResult.conversions());
    assertSame(paperRegistryBuilder, actualCreateEntryAddEventResult.builder());
  }

  /**
   * Test {@link RegistryEntryMeta#modificationApiSupport()}.
   *
   * <p>Method under test: {@link RegistryEntryMeta#modificationApiSupport()}
   */
  @Test
  @DisplayName("Test modificationApiSupport()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryModificationApiSupport RegistryEntryMeta.modificationApiSupport()"})
  void testModificationApiSupport() {
    // Arrange
    ApiOnly<Object, Keyed> apiOnly =
        new ApiOnly<>(mock(ResourceKey.class), null, mock(Supplier.class));

    // Act and Assert
    assertEquals(RegistryModificationApiSupport.NONE, apiOnly.modificationApiSupport());
  }

  /**
   * Test RegistryModificationApiSupport {@link RegistryModificationApiSupport#canAdd()}.
   *
   * <ul>
   *   <li>Given {@code ADDABLE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryModificationApiSupport#canAdd()}
   */
  @Test
  @DisplayName("Test RegistryModificationApiSupport canAdd(); given 'ADDABLE'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegistryModificationApiSupport.canAdd()"})
  void testRegistryModificationApiSupportCanAdd_givenAddable_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RegistryModificationApiSupport.ADDABLE.canAdd());
  }

  /**
   * Test RegistryModificationApiSupport {@link RegistryModificationApiSupport#canAdd()}.
   *
   * <ul>
   *   <li>Given {@link RegistryModificationApiSupport#MODIFIABLE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryModificationApiSupport#canAdd()}
   */
  @Test
  @DisplayName(
      "Test RegistryModificationApiSupport canAdd(); given MODIFIABLE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegistryModificationApiSupport.canAdd()"})
  void testRegistryModificationApiSupportCanAdd_givenModifiable_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RegistryModificationApiSupport.MODIFIABLE.canAdd());
  }

  /**
   * Test RegistryModificationApiSupport {@link RegistryModificationApiSupport#canAdd()}.
   *
   * <ul>
   *   <li>Given {@code NONE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryModificationApiSupport#canAdd()}
   */
  @Test
  @DisplayName("Test RegistryModificationApiSupport canAdd(); given 'NONE'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegistryModificationApiSupport.canAdd()"})
  void testRegistryModificationApiSupportCanAdd_givenNone_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RegistryModificationApiSupport.NONE.canAdd());
  }

  /**
   * Test RegistryModificationApiSupport {@link RegistryModificationApiSupport#canModify()}.
   *
   * <ul>
   *   <li>Given {@link RegistryModificationApiSupport#ADDABLE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryModificationApiSupport#canModify()}
   */
  @Test
  @DisplayName(
      "Test RegistryModificationApiSupport canModify(); given ADDABLE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegistryModificationApiSupport.canModify()"})
  void testRegistryModificationApiSupportCanModify_givenAddable_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RegistryModificationApiSupport.ADDABLE.canModify());
  }

  /**
   * Test RegistryModificationApiSupport {@link RegistryModificationApiSupport#canModify()}.
   *
   * <ul>
   *   <li>Given {@code MODIFIABLE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryModificationApiSupport#canModify()}
   */
  @Test
  @DisplayName(
      "Test RegistryModificationApiSupport canModify(); given 'MODIFIABLE'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegistryModificationApiSupport.canModify()"})
  void testRegistryModificationApiSupportCanModify_givenModifiable_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RegistryModificationApiSupport.MODIFIABLE.canModify());
  }

  /**
   * Test RegistryModificationApiSupport {@link RegistryModificationApiSupport#canModify()}.
   *
   * <ul>
   *   <li>Given {@code NONE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryModificationApiSupport#canModify()}
   */
  @Test
  @DisplayName("Test RegistryModificationApiSupport canModify(); given 'NONE'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegistryModificationApiSupport.canModify()"})
  void testRegistryModificationApiSupportCanModify_givenNone_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RegistryModificationApiSupport.NONE.canModify());
  }
}

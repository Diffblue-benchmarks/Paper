package io.papermc.paper.registry.entry;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.entry.RegistryEntryMeta.ApiOnly;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceKey;
import org.bukkit.Keyed;
import org.bukkit.Registry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistryEntryBuilderDiffblueTest {
  /**
   * Test {@link RegistryEntryBuilder#start(ResourceKey, RegistryKey)}.
   *
   * <p>Method under test: {@link RegistryEntryBuilder#start(ResourceKey, RegistryKey)}
   */
  @Test
  @DisplayName("Test start(ResourceKey, RegistryKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryEntryBuilder RegistryEntryBuilder.start(ResourceKey, RegistryKey)"})
  void testStart() {
    // Arrange and Act
    RegistryEntryBuilder<Object, Keyed> actualStartResult =
        RegistryEntryBuilder.start(mock(ResourceKey.class), null);

    // Assert
    assertNull(actualStartResult.apiKey);
  }

  /**
   * Test {@link RegistryEntryBuilder#apiOnly(Supplier)}.
   *
   * <p>Method under test: {@link RegistryEntryBuilder#apiOnly(Supplier)}
   */
  @Test
  @DisplayName("Test apiOnly(Supplier)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryEntry RegistryEntryBuilder.apiOnly(Supplier)"})
  void testApiOnly() {
    // Arrange
    RegistryEntryBuilder<Object, Keyed> startResult =
        RegistryEntryBuilder.start(mock(ResourceKey.class), null);
    Supplier<Registry<Keyed>> apiRegistrySupplier = mock(Supplier.class);

    // Act
    RegistryEntry<Object, Keyed> actualApiOnlyResult = startResult.apiOnly(apiRegistrySupplier);

    // Assert
    assertTrue(actualApiOnlyResult instanceof RegistryEntryImpl);
    RegistryEntryMeta<Object, Keyed> metaResult = actualApiOnlyResult.meta();
    assertTrue(metaResult instanceof ApiOnly);
    assertNull(metaResult.apiKey());
    ResourceKey<? extends net.minecraft.core.Registry<Object>> expectedMcKeyResult =
        startResult.mcKey;
    assertSame(expectedMcKeyResult, metaResult.mcKey());
    assertSame(apiRegistrySupplier, ((ApiOnly<Object, Keyed>) metaResult).registrySupplier());
  }

  /**
   * Test {@link RegistryEntryBuilder#craft(Class, Function)} with {@code classToPreload}, {@code
   * minecraftToBukkit}.
   *
   * <p>Method under test: {@link RegistryEntryBuilder#craft(Class, Function)}
   */
  @Test
  @DisplayName("Test craft(Class, Function) with 'classToPreload', 'minecraftToBukkit'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryEntryBuilder.CraftStage RegistryEntryBuilder.craft(Class, Function)"})
  void testCraftWithClassToPreloadMinecraftToBukkit() {
    // Arrange
    RegistryEntryBuilder<Object, Keyed> startResult =
        RegistryEntryBuilder.start(mock(ResourceKey.class), null);
    Class<Object> classToPreload = Object.class;

    // Act and Assert
    assertNull(startResult.craft(classToPreload, mock(Function.class)).apiKey);
  }

  /**
   * Test {@link RegistryEntryBuilder#craft(Class, Function, boolean)} with {@code classToPreload},
   * {@code minecraftToBukkit}, {@code allowDirect}.
   *
   * <p>Method under test: {@link RegistryEntryBuilder#craft(Class, Function, boolean)}
   */
  @Test
  @DisplayName(
      "Test craft(Class, Function, boolean) with 'classToPreload', 'minecraftToBukkit', 'allowDirect'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RegistryEntryBuilder.CraftStage RegistryEntryBuilder.craft(Class, Function, boolean)"
  })
  void testCraftWithClassToPreloadMinecraftToBukkitAllowDirect() {
    // Arrange
    RegistryEntryBuilder<Object, Keyed> startResult =
        RegistryEntryBuilder.start(mock(ResourceKey.class), null);
    Class<Object> classToPreload = Object.class;

    // Act and Assert
    assertNull(startResult.craft(classToPreload, mock(Function.class), true).apiKey);
  }
}

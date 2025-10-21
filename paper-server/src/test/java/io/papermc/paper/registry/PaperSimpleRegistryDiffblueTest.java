package io.papermc.paper.registry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.serialization.Lifecycle;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.core.DefaultedMappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PaperSimpleRegistryDiffblueTest {
  /**
   * Test {@link PaperSimpleRegistry#PaperSimpleRegistry(Class, Predicate, Registry)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return Type is {@link Material}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSimpleRegistry#PaperSimpleRegistry(Class, Predicate,
   * Registry)}
   */
  @Test
  @DisplayName(
      "Test new PaperSimpleRegistry(Class, Predicate, Registry); given 'false'; then return Type is Material")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperSimpleRegistry.<init>(Class, Predicate, Registry)"})
  void testNewPaperSimpleRegistry_givenFalse_thenReturnTypeIsMaterial() {
    // Arrange
    Class<Material> type = Material.class;

    Predicate<Material> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Material>any())).thenReturn(false);
    DefaultedMappedRegistry<Object> nmsRegistry =
        new DefaultedMappedRegistry<>("42", mock(ResourceKey.class), mock(Lifecycle.class), true);

    // Act
    PaperSimpleRegistry<Material, Object> actualPaperSimpleRegistry =
        new PaperSimpleRegistry<>(type, predicate, nmsRegistry);

    // Assert
    verify(predicate, atLeast(1)).test(Mockito.<Material>any());
    assertEquals(0, actualPaperSimpleRegistry.size());
    Stream<Material> streamResult = actualPaperSimpleRegistry.stream();
    assertTrue(streamResult.limit(5).collect(Collectors.toList()).isEmpty());
    Class<Material> expectedType = Material.class;
    assertEquals(expectedType, actualPaperSimpleRegistry.getType());
  }
}

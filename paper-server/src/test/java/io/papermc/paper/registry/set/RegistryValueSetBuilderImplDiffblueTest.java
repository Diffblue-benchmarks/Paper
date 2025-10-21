package io.papermc.paper.registry.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.PaperRegistryBuilder;
import io.papermc.paper.registry.PaperRegistryBuilderFactory;
import io.papermc.paper.registry.RegistryBuilder;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.data.util.Conversions;
import java.util.function.Consumer;
import org.bukkit.Keyed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RegistryValueSetBuilderImplDiffblueTest {
  /**
   * Test {@link RegistryValueSetBuilderImpl#add(Consumer)}.
   *
   * <p>Method under test: {@link RegistryValueSetBuilderImpl#add(Consumer)}
   */
  @Test
  @DisplayName("Test add(Consumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryValueSetBuilder RegistryValueSetBuilderImpl.add(Consumer)"})
  void testAdd() {
    // Arrange
    Conversions conversions = mock(Conversions.class);
    when(conversions.createApiInstanceFromBuilder(
            Mockito.<RegistryKey<Keyed>>any(),
            Mockito
                .<Consumer<
                        PaperRegistryBuilderFactory<
                            Object, Keyed, PaperRegistryBuilder<Object, Keyed>>>>
                    any()))
        .thenReturn(mock(Keyed.class));
    RegistryValueSetBuilderImpl<Object, Keyed, RegistryBuilder<Keyed>> registryValueSetBuilderImpl =
        new RegistryValueSetBuilderImpl<>(null, conversions);

    // Act
    RegistryValueSetBuilder<Keyed, RegistryBuilder<Keyed>> actualAddResult =
        registryValueSetBuilderImpl.add(mock(Consumer.class));

    // Assert
    verify(conversions).createApiInstanceFromBuilder(isNull(), isA(Consumer.class));
    RegistryValueSet<Keyed> registryValueSet = registryValueSetBuilderImpl.build();
    assertTrue(registryValueSet instanceof RegistryValueSetImpl);
    assertEquals(1, registryValueSet.size());
    assertEquals(1, registryValueSet.values().size());
    assertFalse(registryValueSet.isEmpty());
    assertSame(registryValueSetBuilderImpl, actualAddResult);
  }
}

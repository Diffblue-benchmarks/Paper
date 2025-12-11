package io.papermc.paper.registry.set;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.RegistryBuilder;
import io.papermc.paper.registry.data.util.Conversions;
import java.util.function.Consumer;
import org.bukkit.Keyed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistryValueSetBuilderImplDiffblueTest {
  /**
   * Test {@link RegistryValueSetBuilderImpl#add(Consumer)}.
   *
   * <ul>
   *   <li>Then return {@link RegistryValueSetBuilderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link RegistryValueSetBuilderImpl#add(Consumer)}
   */
  @Test
  @DisplayName("Test add(Consumer); then return RegistryValueSetBuilderImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryValueSetBuilder RegistryValueSetBuilderImpl.add(Consumer)"})
  void testAdd_thenReturnRegistryValueSetBuilderImpl() {
    // Arrange
    RegistryValueSetBuilderImpl<Object, Keyed, RegistryBuilder<Keyed>> registryValueSetBuilderImpl =
        new RegistryValueSetBuilderImpl<>(null, mock(Conversions.class));

    // Act
    RegistryValueSetBuilder<Keyed, RegistryBuilder<Keyed>> actualAddResult =
        registryValueSetBuilderImpl.add(mock(Consumer.class));

    // Assert
    assertTrue(actualAddResult instanceof RegistryValueSetBuilderImpl);
    assertSame(registryValueSetBuilderImpl, actualAddResult);
  }
}

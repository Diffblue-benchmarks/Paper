package io.papermc.paper.registry.event;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.RegistryBuilder;
import io.papermc.paper.registry.RegistryKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistryEventProviderImplDiffblueTest {
  /**
   * Test {@link RegistryEventProviderImpl#create(RegistryKey)}.
   *
   * <p>Method under test: {@link RegistryEventProviderImpl#create(RegistryKey)}
   */
  @Test
  @DisplayName("Test create(RegistryKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryEventProvider RegistryEventProviderImpl.create(RegistryKey)"})
  void testCreate() {
    // Arrange and Act
    RegistryEventProvider<Object, RegistryBuilder<Object>> actualCreateResult =
        RegistryEventProviderImpl.create(null);

    // Assert
    assertTrue(actualCreateResult instanceof RegistryEventProviderImpl);
    assertNull(actualCreateResult.registryKey());
  }
}

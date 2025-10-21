package io.papermc.paper.configuration.mapping;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InnerClassInstanceSupplierDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InnerClassInstanceSupplier#InnerClassInstanceSupplier(Map)}
   *   <li>{@link InnerClassInstanceSupplier#instanceMap()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InnerClassInstanceSupplier.<init>(Map)",
    "Map InnerClassInstanceSupplier.instanceMap()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new InnerClassInstanceSupplier(new HashMap<>()).instanceMap().isEmpty());
  }
}

package io.papermc.paper.configuration.mapping;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InnerClassInstanceFactoryDiffblueTest {
  /**
   * Test {@link InnerClassInstanceFactory#begin()}.
   *
   * <p>Method under test: {@link InnerClassInstanceFactory#begin()}
   */
  @Test
  @DisplayName("Test begin()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map InnerClassInstanceFactory.begin()"})
  void testBegin() {
    // Arrange
    InnerClassInstanceFactory innerClassInstanceFactory =
        new InnerClassInstanceFactory(new InnerClassInstanceSupplier(new HashMap<>()), null);

    // Act and Assert
    assertTrue(innerClassInstanceFactory.begin().isEmpty());
  }

  /**
   * Test {@link InnerClassInstanceFactory#canCreateInstances()}.
   *
   * <p>Method under test: {@link InnerClassInstanceFactory#canCreateInstances()}
   */
  @Test
  @DisplayName("Test canCreateInstances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InnerClassInstanceFactory.canCreateInstances()"})
  void testCanCreateInstances() {
    // Arrange
    InnerClassInstanceFactory innerClassInstanceFactory =
        new InnerClassInstanceFactory(new InnerClassInstanceSupplier(new HashMap<>()), null);

    // Act and Assert
    assertTrue(innerClassInstanceFactory.canCreateInstances());
  }
}

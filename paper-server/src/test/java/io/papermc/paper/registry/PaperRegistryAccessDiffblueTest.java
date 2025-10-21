package io.papermc.paper.registry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.ServerBuildInfo;
import java.util.NoSuchElementException;
import org.bukkit.Keyed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperRegistryAccessDiffblueTest {
  /**
   * Test {@link PaperRegistryAccess#instance()}.
   *
   * <p>Method under test: {@link PaperRegistryAccess#instance()}
   */
  @Test
  @DisplayName("Test instance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperRegistryAccess PaperRegistryAccess.instance()"})
  void testInstance() {
    // Arrange, Act and Assert
    assertEquals(1, PaperRegistryAccess.instance().getLoadedServerBackedRegistries().size());
  }

  /**
   * Test {@link PaperRegistryAccess#getLoadedServerBackedRegistries()}.
   *
   * <p>Method under test: {@link PaperRegistryAccess#getLoadedServerBackedRegistries()}
   */
  @Test
  @DisplayName("Test getLoadedServerBackedRegistries()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PaperRegistryAccess.getLoadedServerBackedRegistries()"})
  void testGetLoadedServerBackedRegistries() {
    // Arrange, Act and Assert
    assertTrue(new PaperRegistryAccess().getLoadedServerBackedRegistries().isEmpty());
  }

  /**
   * Test {@link PaperRegistryAccess#getRegistry(RegistryKey)} with {@code key}.
   *
   * <p>Method under test: {@link PaperRegistryAccess#getRegistry(RegistryKey)}
   */
  @Test
  @DisplayName("Test getRegistry(RegistryKey) with 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.Registry PaperRegistryAccess.getRegistry(RegistryKey)"})
  void testGetRegistryWithKey() {
    // Arrange
    PaperRegistryAccess paperRegistryAccess = new PaperRegistryAccess();

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () ->
            paperRegistryAccess.getRegistry(new RegistryKeyImpl<>(ServerBuildInfo.BRAND_PAPER_ID)));
  }

  /**
   * Test {@link PaperRegistryAccess#getRegistry(Class)} with {@code type}.
   *
   * <p>Method under test: {@link PaperRegistryAccess#getRegistry(Class)}
   */
  @Test
  @DisplayName("Test getRegistry(Class) with 'type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.Registry PaperRegistryAccess.getRegistry(Class)"})
  void testGetRegistryWithType() {
    // Arrange
    PaperRegistryAccess paperRegistryAccess = new PaperRegistryAccess();
    Class<Keyed> type = Keyed.class;

    // Act and Assert
    assertNull(paperRegistryAccess.getRegistry(type));
  }

  /**
   * Test {@link PaperRegistryAccess#getWritableRegistry(RegistryKey)}.
   *
   * <p>Method under test: {@link PaperRegistryAccess#getWritableRegistry(RegistryKey)}
   */
  @Test
  @DisplayName("Test getWritableRegistry(RegistryKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.registry.WritableCraftRegistry PaperRegistryAccess.getWritableRegistry(RegistryKey)"
  })
  void testGetWritableRegistry() {
    // Arrange
    PaperRegistryAccess paperRegistryAccess = new PaperRegistryAccess();

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () ->
            paperRegistryAccess.getWritableRegistry(
                new RegistryKeyImpl<>(ServerBuildInfo.BRAND_PAPER_ID)));
  }

  /**
   * Test {@link PaperRegistryAccess#byType(Class)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRegistryAccess#byType(Class)}
   */
  @Test
  @DisplayName("Test byType(Class); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryKey PaperRegistryAccess.byType(Class)"})
  void testByType_thenReturnNull() {
    // Arrange
    Class<Keyed> type = Keyed.class;

    // Act
    RegistryKey<Keyed> actualByTypeResult = PaperRegistryAccess.byType(type);

    // Assert
    assertNull(actualByTypeResult);
  }

  /**
   * Test new {@link PaperRegistryAccess} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PaperRegistryAccess}
   */
  @Test
  @DisplayName("Test new PaperRegistryAccess (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperRegistryAccess.<init>()"})
  void testNewPaperRegistryAccess() {
    // Arrange, Act and Assert
    assertTrue(new PaperRegistryAccess().getLoadedServerBackedRegistries().isEmpty());
  }
}

package io.papermc.paper.registry.legacy;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.tag.TagKey;
import java.util.function.Supplier;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DelayedRegistryDiffblueTest {
  /**
   * Test {@link DelayedRegistry#load(Supplier)}.
   *
   * <ul>
   *   <li>Given {@link DelayedRegistry} (default constructor) load {@link Supplier}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#load(Supplier)}
   */
  @Test
  @DisplayName(
      "Test load(Supplier); given DelayedRegistry (default constructor) load Supplier; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelayedRegistry.load(Supplier)"})
  void testLoad_givenDelayedRegistryLoadSupplier_thenThrowIllegalStateException() {
    // Arrange
    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();
    delayedRegistry.load(mock(Supplier.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.load(mock(Supplier.class)));
  }

  /**
   * Test {@link DelayedRegistry#load(Supplier)}.
   *
   * <ul>
   *   <li>Given {@link DelayedRegistry} (default constructor).
   *   <li>Then {@link DelayedRegistry} (default constructor) delegate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#load(Supplier)}
   */
  @Test
  @DisplayName(
      "Test load(Supplier); given DelayedRegistry (default constructor); then DelayedRegistry (default constructor) delegate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelayedRegistry.load(Supplier)"})
  void testLoad_givenDelayedRegistry_thenDelayedRegistryDelegateIsNull() {
    // Arrange
    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();

    // Act
    delayedRegistry.load(mock(Supplier.class));

    // Assert
    assertNull(delayedRegistry.delegate());
  }

  /**
   * Test {@link DelayedRegistry#delegate()}.
   *
   * <ul>
   *   <li>Given {@link DelayedRegistry} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#delegate()}
   */
  @Test
  @DisplayName("Test delegate(); given DelayedRegistry (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Registry DelayedRegistry.delegate()"})
  void testDelegate_givenDelayedRegistry() {
    // Arrange
    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.delegate());
  }

  /**
   * Test {@link DelayedRegistry#delegate()}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#delegate()}
   */
  @Test
  @DisplayName(
      "Test delegate(); given Supplier get() throw IllegalStateException(); then calls get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Registry DelayedRegistry.delegate()"})
  void testDelegate_givenSupplierGetThrowIllegalStateException_thenCallsGet() {
    // Arrange
    Supplier<Registry<Keyed>> registry = mock(Supplier.class);
    when(registry.get()).thenThrow(new IllegalStateException());

    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();
    delayedRegistry.load(registry);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.delegate());
    verify(registry).get();
  }

  /**
   * Test {@link DelayedRegistry#get(NamespacedKey)} with {@code NamespacedKey}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#get(NamespacedKey)}
   */
  @Test
  @DisplayName("Test get(NamespacedKey) with 'NamespacedKey'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Keyed DelayedRegistry.get(NamespacedKey)"})
  void testGetWithNamespacedKey_thenThrowIllegalStateException() {
    // Arrange
    Supplier<Registry<Keyed>> registry = mock(Supplier.class);
    when(registry.get()).thenThrow(new IllegalStateException());

    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();
    delayedRegistry.load(registry);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.get(NamespacedKey.randomKey()));
    verify(registry).get();
  }

  /**
   * Test {@link DelayedRegistry#iterator()}.
   *
   * <ul>
   *   <li>Given {@link DelayedRegistry} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given DelayedRegistry (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Iterator DelayedRegistry.iterator()"})
  void testIterator_givenDelayedRegistry() {
    // Arrange
    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.iterator());
  }

  /**
   * Test {@link DelayedRegistry#iterator()}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#iterator()}
   */
  @Test
  @DisplayName(
      "Test iterator(); given Supplier get() throw IllegalStateException(); then calls get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Iterator DelayedRegistry.iterator()"})
  void testIterator_givenSupplierGetThrowIllegalStateException_thenCallsGet() {
    // Arrange
    Supplier<Registry<Keyed>> registry = mock(Supplier.class);
    when(registry.get()).thenThrow(new IllegalStateException());

    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();
    delayedRegistry.load(registry);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.iterator());
    verify(registry).get();
  }

  /**
   * Test {@link DelayedRegistry#stream()}.
   *
   * <ul>
   *   <li>Given {@link DelayedRegistry} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#stream()}
   */
  @Test
  @DisplayName("Test stream(); given DelayedRegistry (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.stream.Stream DelayedRegistry.stream()"})
  void testStream_givenDelayedRegistry() {
    // Arrange
    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.stream());
  }

  /**
   * Test {@link DelayedRegistry#stream()}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#stream()}
   */
  @Test
  @DisplayName(
      "Test stream(); given Supplier get() throw IllegalStateException(); then calls get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.stream.Stream DelayedRegistry.stream()"})
  void testStream_givenSupplierGetThrowIllegalStateException_thenCallsGet() {
    // Arrange
    Supplier<Registry<Keyed>> registry = mock(Supplier.class);
    when(registry.get()).thenThrow(new IllegalStateException());

    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();
    delayedRegistry.load(registry);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.stream());
    verify(registry).get();
  }

  /**
   * Test {@link DelayedRegistry#keyStream()}.
   *
   * <ul>
   *   <li>Given {@link DelayedRegistry} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#keyStream()}
   */
  @Test
  @DisplayName("Test keyStream(); given DelayedRegistry (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.stream.Stream DelayedRegistry.keyStream()"})
  void testKeyStream_givenDelayedRegistry() {
    // Arrange
    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.keyStream());
  }

  /**
   * Test {@link DelayedRegistry#keyStream()}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#keyStream()}
   */
  @Test
  @DisplayName(
      "Test keyStream(); given Supplier get() throw IllegalStateException(); then calls get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.stream.Stream DelayedRegistry.keyStream()"})
  void testKeyStream_givenSupplierGetThrowIllegalStateException_thenCallsGet() {
    // Arrange
    Supplier<Registry<Keyed>> registry = mock(Supplier.class);
    when(registry.get()).thenThrow(new IllegalStateException());

    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();
    delayedRegistry.load(registry);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.keyStream());
    verify(registry).get();
  }

  /**
   * Test {@link DelayedRegistry#size()}.
   *
   * <ul>
   *   <li>Given {@link DelayedRegistry} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#size()}
   */
  @Test
  @DisplayName("Test size(); given DelayedRegistry (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DelayedRegistry.size()"})
  void testSize_givenDelayedRegistry() {
    // Arrange
    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.size());
  }

  /**
   * Test {@link DelayedRegistry#size()}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#size()}
   */
  @Test
  @DisplayName("Test size(); given Supplier get() throw IllegalStateException(); then calls get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DelayedRegistry.size()"})
  void testSize_givenSupplierGetThrowIllegalStateException_thenCallsGet() {
    // Arrange
    Supplier<Registry<Keyed>> registry = mock(Supplier.class);
    when(registry.get()).thenThrow(new IllegalStateException());

    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();
    delayedRegistry.load(registry);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.size());
    verify(registry).get();
  }

  /**
   * Test {@link DelayedRegistry#getKey(Keyed)}.
   *
   * <ul>
   *   <li>Given {@link DelayedRegistry} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#getKey(Keyed)}
   */
  @Test
  @DisplayName("Test getKey(Keyed); given DelayedRegistry (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamespacedKey DelayedRegistry.getKey(Keyed)"})
  void testGetKey_givenDelayedRegistry() {
    // Arrange
    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.getKey(mock(Keyed.class)));
  }

  /**
   * Test {@link DelayedRegistry#getKey(Keyed)}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#getKey(Keyed)}
   */
  @Test
  @DisplayName(
      "Test getKey(Keyed); given Supplier get() throw IllegalStateException(); then calls get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamespacedKey DelayedRegistry.getKey(Keyed)"})
  void testGetKey_givenSupplierGetThrowIllegalStateException_thenCallsGet() {
    // Arrange
    Supplier<Registry<Keyed>> registry = mock(Supplier.class);
    when(registry.get()).thenThrow(new IllegalStateException());

    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();
    delayedRegistry.load(registry);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.getKey(mock(Keyed.class)));
    verify(registry).get();
  }

  /**
   * Test {@link DelayedRegistry#hasTag(TagKey)}.
   *
   * <ul>
   *   <li>Given {@link DelayedRegistry} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#hasTag(TagKey)}
   */
  @Test
  @DisplayName("Test hasTag(TagKey); given DelayedRegistry (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DelayedRegistry.hasTag(TagKey)"})
  void testHasTag_givenDelayedRegistry() {
    // Arrange
    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.hasTag(null));
  }

  /**
   * Test {@link DelayedRegistry#hasTag(TagKey)}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#hasTag(TagKey)}
   */
  @Test
  @DisplayName(
      "Test hasTag(TagKey); given Supplier get() throw IllegalStateException(); then calls get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DelayedRegistry.hasTag(TagKey)"})
  void testHasTag_givenSupplierGetThrowIllegalStateException_thenCallsGet() {
    // Arrange
    Supplier<Registry<Keyed>> registry = mock(Supplier.class);
    when(registry.get()).thenThrow(new IllegalStateException());

    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();
    delayedRegistry.load(registry);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.hasTag(null));
    verify(registry).get();
  }

  /**
   * Test {@link DelayedRegistry#getTag(TagKey)}.
   *
   * <ul>
   *   <li>Given {@link DelayedRegistry} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#getTag(TagKey)}
   */
  @Test
  @DisplayName("Test getTag(TagKey); given DelayedRegistry (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"io.papermc.paper.registry.tag.Tag DelayedRegistry.getTag(TagKey)"})
  void testGetTag_givenDelayedRegistry() {
    // Arrange
    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.getTag(null));
  }

  /**
   * Test {@link DelayedRegistry#getTag(TagKey)}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#getTag(TagKey)}
   */
  @Test
  @DisplayName(
      "Test getTag(TagKey); given Supplier get() throw IllegalStateException(); then calls get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"io.papermc.paper.registry.tag.Tag DelayedRegistry.getTag(TagKey)"})
  void testGetTag_givenSupplierGetThrowIllegalStateException_thenCallsGet() {
    // Arrange
    Supplier<Registry<Keyed>> registry = mock(Supplier.class);
    when(registry.get()).thenThrow(new IllegalStateException());

    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();
    delayedRegistry.load(registry);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.getTag(null));
    verify(registry).get();
  }

  /**
   * Test {@link DelayedRegistry#getTags()}.
   *
   * <ul>
   *   <li>Given {@link DelayedRegistry} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#getTags()}
   */
  @Test
  @DisplayName("Test getTags(); given DelayedRegistry (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection DelayedRegistry.getTags()"})
  void testGetTags_givenDelayedRegistry() {
    // Arrange
    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.getTags());
  }

  /**
   * Test {@link DelayedRegistry#getTags()}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link DelayedRegistry#getTags()}
   */
  @Test
  @DisplayName(
      "Test getTags(); given Supplier get() throw IllegalStateException(); then calls get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection DelayedRegistry.getTags()"})
  void testGetTags_givenSupplierGetThrowIllegalStateException_thenCallsGet() {
    // Arrange
    Supplier<Registry<Keyed>> registry = mock(Supplier.class);
    when(registry.get()).thenThrow(new IllegalStateException());

    DelayedRegistry<Keyed, Registry<Keyed>> delayedRegistry = new DelayedRegistry<>();
    delayedRegistry.load(registry);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> delayedRegistry.getTags());
    verify(registry).get();
  }
}

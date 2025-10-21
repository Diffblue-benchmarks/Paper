package com.destroystokyo.paper.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CachedSizeConcurrentLinkedQueueDiffblueTest {
  /**
   * Test {@link CachedSizeConcurrentLinkedQueue#add(Object)}.
   *
   * <p>Method under test: {@link CachedSizeConcurrentLinkedQueue#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CachedSizeConcurrentLinkedQueue.add(Object)"})
  void testAdd() {
    // Arrange
    CachedSizeConcurrentLinkedQueue<Object> cachedSizeConcurrentLinkedQueue =
        new CachedSizeConcurrentLinkedQueue<>();

    // Act and Assert
    assertTrue(cachedSizeConcurrentLinkedQueue.add("42"));
  }

  /**
   * Test {@link CachedSizeConcurrentLinkedQueue#poll()}.
   *
   * <ul>
   *   <li>Given {@link CachedSizeConcurrentLinkedQueue} (default constructor) add {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link CachedSizeConcurrentLinkedQueue#poll()}
   */
  @Test
  @DisplayName(
      "Test poll(); given CachedSizeConcurrentLinkedQueue (default constructor) add '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CachedSizeConcurrentLinkedQueue.poll()"})
  void testPoll_givenCachedSizeConcurrentLinkedQueueAdd42_thenReturn42() {
    // Arrange
    CachedSizeConcurrentLinkedQueue<Object> cachedSizeConcurrentLinkedQueue =
        new CachedSizeConcurrentLinkedQueue<>();
    cachedSizeConcurrentLinkedQueue.add("42");

    // Act and Assert
    assertEquals("42", cachedSizeConcurrentLinkedQueue.poll());
  }

  /**
   * Test {@link CachedSizeConcurrentLinkedQueue#poll()}.
   *
   * <ul>
   *   <li>Given {@link CachedSizeConcurrentLinkedQueue} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CachedSizeConcurrentLinkedQueue#poll()}
   */
  @Test
  @DisplayName(
      "Test poll(); given CachedSizeConcurrentLinkedQueue (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CachedSizeConcurrentLinkedQueue.poll()"})
  void testPoll_givenCachedSizeConcurrentLinkedQueue_thenReturnNull() {
    // Arrange
    CachedSizeConcurrentLinkedQueue<Object> cachedSizeConcurrentLinkedQueue =
        new CachedSizeConcurrentLinkedQueue<>();

    // Act and Assert
    assertNull(cachedSizeConcurrentLinkedQueue.poll());
  }

  /**
   * Test {@link CachedSizeConcurrentLinkedQueue#size()}.
   *
   * <p>Method under test: {@link CachedSizeConcurrentLinkedQueue#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CachedSizeConcurrentLinkedQueue.size()"})
  void testSize() {
    // Arrange
    CachedSizeConcurrentLinkedQueue<Object> cachedSizeConcurrentLinkedQueue =
        new CachedSizeConcurrentLinkedQueue<>();

    // Act and Assert
    assertEquals(0, cachedSizeConcurrentLinkedQueue.size());
  }

  /**
   * Test new {@link CachedSizeConcurrentLinkedQueue} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * CachedSizeConcurrentLinkedQueue}
   */
  @Test
  @DisplayName("Test new CachedSizeConcurrentLinkedQueue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CachedSizeConcurrentLinkedQueue.<init>()"})
  void testNewCachedSizeConcurrentLinkedQueue() {
    // Arrange and Act
    CachedSizeConcurrentLinkedQueue<Object> actualCachedSizeConcurrentLinkedQueue =
        new CachedSizeConcurrentLinkedQueue<>();

    // Assert
    assertTrue(actualCachedSizeConcurrentLinkedQueue.isEmpty());
  }
}

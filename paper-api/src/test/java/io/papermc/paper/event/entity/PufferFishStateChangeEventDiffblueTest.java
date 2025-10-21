package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.PufferFish;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PufferFishStateChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PufferFishStateChangeEvent#PufferFishStateChangeEvent(PufferFish, int)}
   *   <li>{@link PufferFishStateChangeEvent#setCancelled(boolean)}
   *   <li>{@link PufferFishStateChangeEvent#getHandlerList()}
   *   <li>{@link PufferFishStateChangeEvent#getHandlers()}
   *   <li>{@link PufferFishStateChangeEvent#getNewPuffState()}
   *   <li>{@link PufferFishStateChangeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PufferFishStateChangeEvent.<init>(PufferFish, int)",
    "HandlerList PufferFishStateChangeEvent.getHandlerList()",
    "HandlerList PufferFishStateChangeEvent.getHandlers()",
    "int PufferFishStateChangeEvent.getNewPuffState()",
    "boolean PufferFishStateChangeEvent.isCancelled()",
    "void PufferFishStateChangeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    PufferFish entity = mock(PufferFish.class);

    // Act
    PufferFishStateChangeEvent actualPufferFishStateChangeEvent =
        new PufferFishStateChangeEvent(entity, 1);
    actualPufferFishStateChangeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPufferFishStateChangeEvent.getHandlerList();
    HandlerList actualHandlers = actualPufferFishStateChangeEvent.getHandlers();
    int actualNewPuffState = actualPufferFishStateChangeEvent.getNewPuffState();
    boolean actualIsCancelledResult = actualPufferFishStateChangeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualNewPuffState);
    assertFalse(actualPufferFishStateChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualPufferFishStateChangeEvent.getEntity());
  }

  /**
   * Test {@link PufferFishStateChangeEvent#isInflating()}.
   *
   * <ul>
   *   <li>Given {@link PufferFish} {@link PufferFish#getPuffState()} return one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PufferFishStateChangeEvent#isInflating()}
   */
  @Test
  @DisplayName(
      "Test isInflating(); given PufferFish getPuffState() return one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PufferFishStateChangeEvent.isInflating()"})
  void testIsInflating_givenPufferFishGetPuffStateReturnOne_thenReturnFalse() {
    // Arrange
    PufferFish entity = mock(PufferFish.class);
    when(entity.getPuffState()).thenReturn(1);

    // Act
    boolean actualIsInflatingResult = new PufferFishStateChangeEvent(entity, 1).isInflating();

    // Assert
    verify(entity).getPuffState();
    assertFalse(actualIsInflatingResult);
  }

  /**
   * Test {@link PufferFishStateChangeEvent#isInflating()}.
   *
   * <ul>
   *   <li>Given {@link PufferFish} {@link PufferFish#getPuffState()} return zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PufferFishStateChangeEvent#isInflating()}
   */
  @Test
  @DisplayName(
      "Test isInflating(); given PufferFish getPuffState() return zero; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PufferFishStateChangeEvent.isInflating()"})
  void testIsInflating_givenPufferFishGetPuffStateReturnZero_thenReturnTrue() {
    // Arrange
    PufferFish entity = mock(PufferFish.class);
    when(entity.getPuffState()).thenReturn(0);

    // Act
    boolean actualIsInflatingResult = new PufferFishStateChangeEvent(entity, 1).isInflating();

    // Assert
    verify(entity).getPuffState();
    assertTrue(actualIsInflatingResult);
  }

  /**
   * Test {@link PufferFishStateChangeEvent#isDeflating()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PufferFishStateChangeEvent#isDeflating()}
   */
  @Test
  @DisplayName("Test isDeflating(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PufferFishStateChangeEvent.isDeflating()"})
  void testIsDeflating_thenReturnFalse() {
    // Arrange
    PufferFish entity = mock(PufferFish.class);
    when(entity.getPuffState()).thenReturn(1);

    // Act
    boolean actualIsDeflatingResult = new PufferFishStateChangeEvent(entity, 1).isDeflating();

    // Assert
    verify(entity).getPuffState();
    assertFalse(actualIsDeflatingResult);
  }

  /**
   * Test {@link PufferFishStateChangeEvent#isDeflating()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PufferFishStateChangeEvent#isDeflating()}
   */
  @Test
  @DisplayName("Test isDeflating(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PufferFishStateChangeEvent.isDeflating()"})
  void testIsDeflating_thenReturnTrue() {
    // Arrange
    PufferFish entity = mock(PufferFish.class);
    when(entity.getPuffState()).thenReturn(1);

    // Act
    boolean actualIsDeflatingResult = new PufferFishStateChangeEvent(entity, 0).isDeflating();

    // Assert
    verify(entity).getPuffState();
    assertTrue(actualIsDeflatingResult);
  }
}

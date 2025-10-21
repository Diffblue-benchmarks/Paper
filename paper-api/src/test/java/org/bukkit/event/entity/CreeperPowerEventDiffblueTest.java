package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.LightningStrike;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.CreeperPowerEvent.PowerCause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CreeperPowerEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Creeper}.
   *   <li>Then return Lightning is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreeperPowerEvent#CreeperPowerEvent(Creeper, PowerCause)}
   *   <li>{@link CreeperPowerEvent#setCancelled(boolean)}
   *   <li>{@link CreeperPowerEvent#getHandlerList()}
   *   <li>{@link CreeperPowerEvent#getCause()}
   *   <li>{@link CreeperPowerEvent#getHandlers()}
   *   <li>{@link CreeperPowerEvent#getLightning()}
   *   <li>{@link CreeperPowerEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Creeper; then return Lightning is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CreeperPowerEvent.<init>(Creeper, LightningStrike, PowerCause)",
    "void CreeperPowerEvent.<init>(Creeper, PowerCause)",
    "PowerCause CreeperPowerEvent.getCause()",
    "HandlerList CreeperPowerEvent.getHandlerList()",
    "HandlerList CreeperPowerEvent.getHandlers()",
    "LightningStrike CreeperPowerEvent.getLightning()",
    "boolean CreeperPowerEvent.isCancelled()",
    "void CreeperPowerEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenCreeper_thenReturnLightningIsNull() {
    // Arrange
    Creeper creeper = mock(Creeper.class);

    // Act
    CreeperPowerEvent actualCreeperPowerEvent =
        new CreeperPowerEvent(creeper, PowerCause.LIGHTNING);
    actualCreeperPowerEvent.setCancelled(true);
    HandlerList actualHandlerList = actualCreeperPowerEvent.getHandlerList();
    PowerCause actualCause = actualCreeperPowerEvent.getCause();
    HandlerList actualHandlers = actualCreeperPowerEvent.getHandlers();
    LightningStrike actualLightning = actualCreeperPowerEvent.getLightning();
    boolean actualIsCancelledResult = actualCreeperPowerEvent.isCancelled();

    // Assert
    assertNull(actualLightning);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(PowerCause.LIGHTNING, actualCause);
    assertFalse(actualCreeperPowerEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(creeper, actualCreeperPowerEvent.getEntity());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link LightningStrike}.
   *   <li>Then return Lightning is {@link LightningStrike}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreeperPowerEvent#CreeperPowerEvent(Creeper, LightningStrike, PowerCause)}
   *   <li>{@link CreeperPowerEvent#setCancelled(boolean)}
   *   <li>{@link CreeperPowerEvent#getHandlerList()}
   *   <li>{@link CreeperPowerEvent#getCause()}
   *   <li>{@link CreeperPowerEvent#getHandlers()}
   *   <li>{@link CreeperPowerEvent#getLightning()}
   *   <li>{@link CreeperPowerEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when LightningStrike; then return Lightning is LightningStrike")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CreeperPowerEvent.<init>(Creeper, LightningStrike, PowerCause)",
    "void CreeperPowerEvent.<init>(Creeper, PowerCause)",
    "PowerCause CreeperPowerEvent.getCause()",
    "HandlerList CreeperPowerEvent.getHandlerList()",
    "HandlerList CreeperPowerEvent.getHandlers()",
    "LightningStrike CreeperPowerEvent.getLightning()",
    "boolean CreeperPowerEvent.isCancelled()",
    "void CreeperPowerEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenLightningStrike_thenReturnLightningIsLightningStrike() {
    // Arrange
    Creeper creeper = mock(Creeper.class);
    LightningStrike bolt = mock(LightningStrike.class);

    // Act
    CreeperPowerEvent actualCreeperPowerEvent =
        new CreeperPowerEvent(creeper, bolt, PowerCause.LIGHTNING);
    actualCreeperPowerEvent.setCancelled(true);
    HandlerList actualHandlerList = actualCreeperPowerEvent.getHandlerList();
    PowerCause actualCause = actualCreeperPowerEvent.getCause();
    HandlerList actualHandlers = actualCreeperPowerEvent.getHandlers();
    LightningStrike actualLightning = actualCreeperPowerEvent.getLightning();
    boolean actualIsCancelledResult = actualCreeperPowerEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(PowerCause.LIGHTNING, actualCause);
    assertFalse(actualCreeperPowerEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(creeper, actualCreeperPowerEvent.getEntity());
    assertSame(bolt, actualLightning);
  }

  /**
   * Test {@link CreeperPowerEvent#getEntity()}.
   *
   * <p>Method under test: {@link CreeperPowerEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Creeper CreeperPowerEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    CreeperPowerEvent creeperPowerEvent =
        new CreeperPowerEvent(mock(Creeper.class), PowerCause.LIGHTNING);

    // Act
    Creeper actualEntity = creeperPowerEvent.getEntity();

    // Assert
    assertSame(creeperPowerEvent.entity, actualEntity);
  }
}

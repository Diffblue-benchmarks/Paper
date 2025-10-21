package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.event.entity.EntityTransformEvent.TransformReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PigZapEventDiffblueTest {
  /**
   * Test {@link PigZapEvent#PigZapEvent(Pig, LightningStrike, PigZombie)}.
   *
   * <p>Method under test: {@link PigZapEvent#PigZapEvent(Pig, LightningStrike, PigZombie)}
   */
  @Test
  @DisplayName("Test new PigZapEvent(Pig, LightningStrike, PigZombie)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PigZapEvent.<init>(Pig, LightningStrike, PigZombie)"})
  void testNewPigZapEvent() {
    // Arrange
    Pig pig = mock(Pig.class);
    LightningStrike bolt = mock(LightningStrike.class);
    PigZombie zombifiedPiglin = mock(PigZombie.class);

    // Act
    PigZapEvent actualPigZapEvent = new PigZapEvent(pig, bolt, zombifiedPiglin);

    // Assert
    assertEquals("PigZapEvent", actualPigZapEvent.getEventName());
    assertNull(actualPigZapEvent.getEntityType());
    assertEquals(1, actualPigZapEvent.getTransformedEntities().size());
    assertEquals(TransformReason.LIGHTNING, actualPigZapEvent.getTransformReason());
    assertFalse(actualPigZapEvent.isAsynchronous());
    assertFalse(actualPigZapEvent.isCancelled());
    assertSame(bolt, actualPigZapEvent.getBolt());
    assertSame(bolt, actualPigZapEvent.getLightning());
    assertSame(pig, actualPigZapEvent.getEntity());
    assertSame(zombifiedPiglin, actualPigZapEvent.getReplacementEntity());
    assertSame(zombifiedPiglin, actualPigZapEvent.getTransformedEntity());
    assertSame(zombifiedPiglin, actualPigZapEvent.getPigZombie());
  }

  /**
   * Test {@link PigZapEvent#getEntity()}.
   *
   * <p>Method under test: {@link PigZapEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pig PigZapEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    PigZapEvent pigZapEvent =
        new PigZapEvent(mock(Pig.class), mock(LightningStrike.class), mock(PigZombie.class));

    // Act
    Pig actualEntity = pigZapEvent.getEntity();

    // Assert
    assertSame(pigZapEvent.entity, actualEntity);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PigZapEvent#setCancelled(boolean)}
   *   <li>{@link PigZapEvent#getLightning()}
   *   <li>{@link PigZapEvent#getPigZombie()}
   *   <li>{@link PigZapEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LightningStrike PigZapEvent.getLightning()",
    "PigZombie PigZapEvent.getPigZombie()",
    "boolean PigZapEvent.isCancelled()",
    "void PigZapEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    PigZapEvent pigZapEvent =
        new PigZapEvent(mock(Pig.class), mock(LightningStrike.class), mock(PigZombie.class));

    // Act
    pigZapEvent.setCancelled(true);
    pigZapEvent.getLightning();
    pigZapEvent.getPigZombie();

    // Assert
    assertTrue(pigZapEvent.isCancelled());
  }
}

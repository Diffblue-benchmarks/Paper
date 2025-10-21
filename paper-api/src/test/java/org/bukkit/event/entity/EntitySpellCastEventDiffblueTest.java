package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Spellcaster;
import org.bukkit.entity.Spellcaster.Spell;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntitySpellCastEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitySpellCastEvent#EntitySpellCastEvent(Spellcaster, Spellcaster.Spell)}
   *   <li>{@link EntitySpellCastEvent#setCancelled(boolean)}
   *   <li>{@link EntitySpellCastEvent#getHandlerList()}
   *   <li>{@link EntitySpellCastEvent#getHandlers()}
   *   <li>{@link EntitySpellCastEvent#getSpell()}
   *   <li>{@link EntitySpellCastEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntitySpellCastEvent.<init>(Spellcaster, Spellcaster.Spell)",
    "HandlerList EntitySpellCastEvent.getHandlerList()",
    "HandlerList EntitySpellCastEvent.getHandlers()",
    "Spellcaster.Spell EntitySpellCastEvent.getSpell()",
    "boolean EntitySpellCastEvent.isCancelled()",
    "void EntitySpellCastEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Spellcaster spellcaster = mock(Spellcaster.class);

    // Act
    EntitySpellCastEvent actualEntitySpellCastEvent =
        new EntitySpellCastEvent(spellcaster, Spell.NONE);
    actualEntitySpellCastEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntitySpellCastEvent.getHandlerList();
    HandlerList actualHandlers = actualEntitySpellCastEvent.getHandlers();
    Spell actualSpell = actualEntitySpellCastEvent.getSpell();
    boolean actualIsCancelledResult = actualEntitySpellCastEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Spell.NONE, actualSpell);
    assertFalse(actualEntitySpellCastEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(spellcaster, actualEntitySpellCastEvent.getEntity());
  }

  /**
   * Test {@link EntitySpellCastEvent#getEntity()}.
   *
   * <p>Method under test: {@link EntitySpellCastEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Spellcaster EntitySpellCastEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    EntitySpellCastEvent entitySpellCastEvent =
        new EntitySpellCastEvent(mock(Spellcaster.class), Spell.NONE);

    // Act
    Spellcaster actualEntity = entitySpellCastEvent.getEntity();

    // Assert
    assertSame(entitySpellCastEvent.entity, actualEntity);
  }
}

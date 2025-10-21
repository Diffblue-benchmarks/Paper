package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import net.kyori.adventure.text.Component;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerDeathEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerDeathEvent#PlayerDeathEvent(Player, DamageSource, List, int, int, int, int,
   *       Component, boolean)}
   *   <li>{@link PlayerDeathEvent#deathMessage(Component)}
   *   <li>{@link PlayerDeathEvent#deathScreenMessageOverride(Component)}
   *   <li>{@link PlayerDeathEvent#setKeepInventory(boolean)}
   *   <li>{@link PlayerDeathEvent#setKeepLevel(boolean)}
   *   <li>{@link PlayerDeathEvent#setNewExp(int)}
   *   <li>{@link PlayerDeathEvent#setNewLevel(int)}
   *   <li>{@link PlayerDeathEvent#setNewTotalExp(int)}
   *   <li>{@link PlayerDeathEvent#setShouldDropExperience(boolean)}
   *   <li>{@link PlayerDeathEvent#setShowDeathMessages(boolean)}
   *   <li>{@link PlayerDeathEvent#deathMessage()}
   *   <li>{@link PlayerDeathEvent#deathScreenMessageOverride()}
   *   <li>{@link PlayerDeathEvent#getItemsToKeep()}
   *   <li>{@link PlayerDeathEvent#getKeepInventory()}
   *   <li>{@link PlayerDeathEvent#getKeepLevel()}
   *   <li>{@link PlayerDeathEvent#getNewExp()}
   *   <li>{@link PlayerDeathEvent#getNewLevel()}
   *   <li>{@link PlayerDeathEvent#getNewTotalExp()}
   *   <li>{@link PlayerDeathEvent#getShowDeathMessages()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, int, int, int, Component, boolean)",
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, int, int, int, Component, boolean, boolean)",
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, int, Component, boolean)",
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, Component, boolean)",
    "Component PlayerDeathEvent.deathMessage()",
    "void PlayerDeathEvent.deathMessage(Component)",
    "Component PlayerDeathEvent.deathScreenMessageOverride()",
    "void PlayerDeathEvent.deathScreenMessageOverride(Component)",
    "List PlayerDeathEvent.getItemsToKeep()",
    "boolean PlayerDeathEvent.getKeepInventory()",
    "boolean PlayerDeathEvent.getKeepLevel()",
    "int PlayerDeathEvent.getNewExp()",
    "int PlayerDeathEvent.getNewLevel()",
    "int PlayerDeathEvent.getNewTotalExp()",
    "boolean PlayerDeathEvent.getShowDeathMessages()",
    "void PlayerDeathEvent.setKeepInventory(boolean)",
    "void PlayerDeathEvent.setKeepLevel(boolean)",
    "void PlayerDeathEvent.setNewExp(int)",
    "void PlayerDeathEvent.setNewLevel(int)",
    "void PlayerDeathEvent.setNewTotalExp(int)",
    "void PlayerDeathEvent.setShouldDropExperience(boolean)",
    "void PlayerDeathEvent.setShowDeathMessages(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    DamageSource damageSource = mock(DamageSource.class);
    ArrayList<ItemStack> drops = new ArrayList<>();

    // Act
    PlayerDeathEvent actualPlayerDeathEvent =
        new PlayerDeathEvent(player, damageSource, drops, 1, 1, 1, 1, mock(Component.class), true);
    Component deathMessage = mock(Component.class);
    actualPlayerDeathEvent.deathMessage(deathMessage);
    Component deathScreenMessageOverride = mock(Component.class);
    actualPlayerDeathEvent.deathScreenMessageOverride(deathScreenMessageOverride);
    actualPlayerDeathEvent.setKeepInventory(true);
    actualPlayerDeathEvent.setKeepLevel(true);
    actualPlayerDeathEvent.setNewExp(1);
    actualPlayerDeathEvent.setNewLevel(1);
    actualPlayerDeathEvent.setNewTotalExp(1);
    actualPlayerDeathEvent.setShouldDropExperience(true);
    actualPlayerDeathEvent.setShowDeathMessages(true);
    Component actualDeathMessageResult = actualPlayerDeathEvent.deathMessage();
    Component actualDeathScreenMessageOverrideResult =
        actualPlayerDeathEvent.deathScreenMessageOverride();
    List<ItemStack> actualItemsToKeep = actualPlayerDeathEvent.getItemsToKeep();
    boolean actualKeepInventory = actualPlayerDeathEvent.getKeepInventory();
    boolean actualKeepLevel = actualPlayerDeathEvent.getKeepLevel();
    int actualNewExp = actualPlayerDeathEvent.getNewExp();
    int actualNewLevel = actualPlayerDeathEvent.getNewLevel();
    int actualNewTotalExp = actualPlayerDeathEvent.getNewTotalExp();
    boolean actualShowDeathMessages = actualPlayerDeathEvent.getShowDeathMessages();

    // Assert
    assertNull(actualPlayerDeathEvent.getDeathSound());
    assertNull(actualPlayerDeathEvent.getDeathSoundCategory());
    assertEquals(0.0d, actualPlayerDeathEvent.getReviveHealth());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundPitch());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundVolume());
    assertEquals(1, actualPlayerDeathEvent.getDroppedExp());
    assertEquals(1, actualNewExp);
    assertEquals(1, actualNewLevel);
    assertEquals(1, actualNewTotalExp);
    assertFalse(actualPlayerDeathEvent.isAsynchronous());
    assertFalse(actualPlayerDeathEvent.isCancelled());
    List<ItemStack> drops2 = actualPlayerDeathEvent.getDrops();
    assertTrue(drops2.isEmpty());
    assertTrue(actualItemsToKeep.isEmpty());
    assertTrue(actualKeepInventory);
    assertTrue(actualKeepLevel);
    assertTrue(actualShowDeathMessages);
    assertSame(drops, drops2);
    assertSame(deathMessage, actualDeathMessageResult);
    assertSame(deathScreenMessageOverride, actualDeathScreenMessageOverrideResult);
    assertSame(damageSource, actualPlayerDeathEvent.getDamageSource());
    assertSame(player, actualPlayerDeathEvent.getEntity());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerDeathEvent#PlayerDeathEvent(Player, DamageSource, List, int, int, int, int,
   *       Component, boolean, boolean)}
   *   <li>{@link PlayerDeathEvent#deathMessage(Component)}
   *   <li>{@link PlayerDeathEvent#deathScreenMessageOverride(Component)}
   *   <li>{@link PlayerDeathEvent#setKeepInventory(boolean)}
   *   <li>{@link PlayerDeathEvent#setKeepLevel(boolean)}
   *   <li>{@link PlayerDeathEvent#setNewExp(int)}
   *   <li>{@link PlayerDeathEvent#setNewLevel(int)}
   *   <li>{@link PlayerDeathEvent#setNewTotalExp(int)}
   *   <li>{@link PlayerDeathEvent#setShouldDropExperience(boolean)}
   *   <li>{@link PlayerDeathEvent#setShowDeathMessages(boolean)}
   *   <li>{@link PlayerDeathEvent#deathMessage()}
   *   <li>{@link PlayerDeathEvent#deathScreenMessageOverride()}
   *   <li>{@link PlayerDeathEvent#getItemsToKeep()}
   *   <li>{@link PlayerDeathEvent#getKeepInventory()}
   *   <li>{@link PlayerDeathEvent#getKeepLevel()}
   *   <li>{@link PlayerDeathEvent#getNewExp()}
   *   <li>{@link PlayerDeathEvent#getNewLevel()}
   *   <li>{@link PlayerDeathEvent#getNewTotalExp()}
   *   <li>{@link PlayerDeathEvent#getShowDeathMessages()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, int, int, int, Component, boolean)",
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, int, int, int, Component, boolean, boolean)",
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, int, Component, boolean)",
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, Component, boolean)",
    "Component PlayerDeathEvent.deathMessage()",
    "void PlayerDeathEvent.deathMessage(Component)",
    "Component PlayerDeathEvent.deathScreenMessageOverride()",
    "void PlayerDeathEvent.deathScreenMessageOverride(Component)",
    "List PlayerDeathEvent.getItemsToKeep()",
    "boolean PlayerDeathEvent.getKeepInventory()",
    "boolean PlayerDeathEvent.getKeepLevel()",
    "int PlayerDeathEvent.getNewExp()",
    "int PlayerDeathEvent.getNewLevel()",
    "int PlayerDeathEvent.getNewTotalExp()",
    "boolean PlayerDeathEvent.getShowDeathMessages()",
    "void PlayerDeathEvent.setKeepInventory(boolean)",
    "void PlayerDeathEvent.setKeepLevel(boolean)",
    "void PlayerDeathEvent.setNewExp(int)",
    "void PlayerDeathEvent.setNewLevel(int)",
    "void PlayerDeathEvent.setNewTotalExp(int)",
    "void PlayerDeathEvent.setShouldDropExperience(boolean)",
    "void PlayerDeathEvent.setShowDeathMessages(boolean)"
  })
  void testGettersAndSetters2() {
    // Arrange
    Player player = mock(Player.class);
    DamageSource damageSource = mock(DamageSource.class);
    ArrayList<ItemStack> drops = new ArrayList<>();

    // Act
    PlayerDeathEvent actualPlayerDeathEvent =
        new PlayerDeathEvent(
            player, damageSource, drops, 1, 1, 1, 1, mock(Component.class), true, true);
    Component deathMessage = mock(Component.class);
    actualPlayerDeathEvent.deathMessage(deathMessage);
    Component deathScreenMessageOverride = mock(Component.class);
    actualPlayerDeathEvent.deathScreenMessageOverride(deathScreenMessageOverride);
    actualPlayerDeathEvent.setKeepInventory(true);
    actualPlayerDeathEvent.setKeepLevel(true);
    actualPlayerDeathEvent.setNewExp(1);
    actualPlayerDeathEvent.setNewLevel(1);
    actualPlayerDeathEvent.setNewTotalExp(1);
    actualPlayerDeathEvent.setShouldDropExperience(true);
    actualPlayerDeathEvent.setShowDeathMessages(true);
    Component actualDeathMessageResult = actualPlayerDeathEvent.deathMessage();
    Component actualDeathScreenMessageOverrideResult =
        actualPlayerDeathEvent.deathScreenMessageOverride();
    List<ItemStack> actualItemsToKeep = actualPlayerDeathEvent.getItemsToKeep();
    boolean actualKeepInventory = actualPlayerDeathEvent.getKeepInventory();
    boolean actualKeepLevel = actualPlayerDeathEvent.getKeepLevel();
    int actualNewExp = actualPlayerDeathEvent.getNewExp();
    int actualNewLevel = actualPlayerDeathEvent.getNewLevel();
    int actualNewTotalExp = actualPlayerDeathEvent.getNewTotalExp();
    boolean actualShowDeathMessages = actualPlayerDeathEvent.getShowDeathMessages();

    // Assert
    assertNull(actualPlayerDeathEvent.getDeathSound());
    assertNull(actualPlayerDeathEvent.getDeathSoundCategory());
    assertEquals(0.0d, actualPlayerDeathEvent.getReviveHealth());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundPitch());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundVolume());
    assertEquals(1, actualPlayerDeathEvent.getDroppedExp());
    assertEquals(1, actualNewExp);
    assertEquals(1, actualNewLevel);
    assertEquals(1, actualNewTotalExp);
    assertFalse(actualPlayerDeathEvent.isAsynchronous());
    assertFalse(actualPlayerDeathEvent.isCancelled());
    List<ItemStack> drops2 = actualPlayerDeathEvent.getDrops();
    assertTrue(drops2.isEmpty());
    assertTrue(actualItemsToKeep.isEmpty());
    assertTrue(actualKeepInventory);
    assertTrue(actualKeepLevel);
    assertTrue(actualShowDeathMessages);
    assertSame(drops, drops2);
    assertSame(deathMessage, actualDeathMessageResult);
    assertSame(deathScreenMessageOverride, actualDeathScreenMessageOverrideResult);
    assertSame(damageSource, actualPlayerDeathEvent.getDamageSource());
    assertSame(player, actualPlayerDeathEvent.getEntity());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerDeathEvent#PlayerDeathEvent(Player, DamageSource, List, int, int, Component,
   *       boolean)}
   *   <li>{@link PlayerDeathEvent#deathMessage(Component)}
   *   <li>{@link PlayerDeathEvent#deathScreenMessageOverride(Component)}
   *   <li>{@link PlayerDeathEvent#setKeepInventory(boolean)}
   *   <li>{@link PlayerDeathEvent#setKeepLevel(boolean)}
   *   <li>{@link PlayerDeathEvent#setNewExp(int)}
   *   <li>{@link PlayerDeathEvent#setNewLevel(int)}
   *   <li>{@link PlayerDeathEvent#setNewTotalExp(int)}
   *   <li>{@link PlayerDeathEvent#setShouldDropExperience(boolean)}
   *   <li>{@link PlayerDeathEvent#setShowDeathMessages(boolean)}
   *   <li>{@link PlayerDeathEvent#deathMessage()}
   *   <li>{@link PlayerDeathEvent#deathScreenMessageOverride()}
   *   <li>{@link PlayerDeathEvent#getItemsToKeep()}
   *   <li>{@link PlayerDeathEvent#getKeepInventory()}
   *   <li>{@link PlayerDeathEvent#getKeepLevel()}
   *   <li>{@link PlayerDeathEvent#getNewExp()}
   *   <li>{@link PlayerDeathEvent#getNewLevel()}
   *   <li>{@link PlayerDeathEvent#getNewTotalExp()}
   *   <li>{@link PlayerDeathEvent#getShowDeathMessages()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, int, int, int, Component, boolean)",
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, int, int, int, Component, boolean, boolean)",
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, int, Component, boolean)",
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, Component, boolean)",
    "Component PlayerDeathEvent.deathMessage()",
    "void PlayerDeathEvent.deathMessage(Component)",
    "Component PlayerDeathEvent.deathScreenMessageOverride()",
    "void PlayerDeathEvent.deathScreenMessageOverride(Component)",
    "List PlayerDeathEvent.getItemsToKeep()",
    "boolean PlayerDeathEvent.getKeepInventory()",
    "boolean PlayerDeathEvent.getKeepLevel()",
    "int PlayerDeathEvent.getNewExp()",
    "int PlayerDeathEvent.getNewLevel()",
    "int PlayerDeathEvent.getNewTotalExp()",
    "boolean PlayerDeathEvent.getShowDeathMessages()",
    "void PlayerDeathEvent.setKeepInventory(boolean)",
    "void PlayerDeathEvent.setKeepLevel(boolean)",
    "void PlayerDeathEvent.setNewExp(int)",
    "void PlayerDeathEvent.setNewLevel(int)",
    "void PlayerDeathEvent.setNewTotalExp(int)",
    "void PlayerDeathEvent.setShouldDropExperience(boolean)",
    "void PlayerDeathEvent.setShowDeathMessages(boolean)"
  })
  void testGettersAndSetters3() {
    // Arrange
    Player player = mock(Player.class);
    DamageSource damageSource = mock(DamageSource.class);
    ArrayList<ItemStack> drops = new ArrayList<>();

    // Act
    PlayerDeathEvent actualPlayerDeathEvent =
        new PlayerDeathEvent(player, damageSource, drops, 1, 1, mock(Component.class), true);
    Component deathMessage = mock(Component.class);
    actualPlayerDeathEvent.deathMessage(deathMessage);
    Component deathScreenMessageOverride = mock(Component.class);
    actualPlayerDeathEvent.deathScreenMessageOverride(deathScreenMessageOverride);
    actualPlayerDeathEvent.setKeepInventory(true);
    actualPlayerDeathEvent.setKeepLevel(true);
    actualPlayerDeathEvent.setNewExp(1);
    actualPlayerDeathEvent.setNewLevel(1);
    actualPlayerDeathEvent.setNewTotalExp(1);
    actualPlayerDeathEvent.setShouldDropExperience(true);
    actualPlayerDeathEvent.setShowDeathMessages(true);
    Component actualDeathMessageResult = actualPlayerDeathEvent.deathMessage();
    Component actualDeathScreenMessageOverrideResult =
        actualPlayerDeathEvent.deathScreenMessageOverride();
    List<ItemStack> actualItemsToKeep = actualPlayerDeathEvent.getItemsToKeep();
    boolean actualKeepInventory = actualPlayerDeathEvent.getKeepInventory();
    boolean actualKeepLevel = actualPlayerDeathEvent.getKeepLevel();
    int actualNewExp = actualPlayerDeathEvent.getNewExp();
    int actualNewLevel = actualPlayerDeathEvent.getNewLevel();
    int actualNewTotalExp = actualPlayerDeathEvent.getNewTotalExp();
    boolean actualShowDeathMessages = actualPlayerDeathEvent.getShowDeathMessages();

    // Assert
    assertNull(actualPlayerDeathEvent.getDeathSound());
    assertNull(actualPlayerDeathEvent.getDeathSoundCategory());
    assertEquals(0.0d, actualPlayerDeathEvent.getReviveHealth());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundPitch());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundVolume());
    assertEquals(1, actualPlayerDeathEvent.getDroppedExp());
    assertEquals(1, actualNewExp);
    assertEquals(1, actualNewLevel);
    assertEquals(1, actualNewTotalExp);
    assertFalse(actualPlayerDeathEvent.isAsynchronous());
    assertFalse(actualPlayerDeathEvent.isCancelled());
    List<ItemStack> drops2 = actualPlayerDeathEvent.getDrops();
    assertTrue(drops2.isEmpty());
    assertTrue(actualItemsToKeep.isEmpty());
    assertTrue(actualKeepInventory);
    assertTrue(actualKeepLevel);
    assertTrue(actualShowDeathMessages);
    assertSame(drops, drops2);
    assertSame(deathMessage, actualDeathMessageResult);
    assertSame(deathScreenMessageOverride, actualDeathScreenMessageOverrideResult);
    assertSame(damageSource, actualPlayerDeathEvent.getDamageSource());
    assertSame(player, actualPlayerDeathEvent.getEntity());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerDeathEvent#PlayerDeathEvent(Player, DamageSource, List, int, Component,
   *       boolean)}
   *   <li>{@link PlayerDeathEvent#deathMessage(Component)}
   *   <li>{@link PlayerDeathEvent#deathScreenMessageOverride(Component)}
   *   <li>{@link PlayerDeathEvent#setKeepInventory(boolean)}
   *   <li>{@link PlayerDeathEvent#setKeepLevel(boolean)}
   *   <li>{@link PlayerDeathEvent#setNewExp(int)}
   *   <li>{@link PlayerDeathEvent#setNewLevel(int)}
   *   <li>{@link PlayerDeathEvent#setNewTotalExp(int)}
   *   <li>{@link PlayerDeathEvent#setShouldDropExperience(boolean)}
   *   <li>{@link PlayerDeathEvent#setShowDeathMessages(boolean)}
   *   <li>{@link PlayerDeathEvent#deathMessage()}
   *   <li>{@link PlayerDeathEvent#deathScreenMessageOverride()}
   *   <li>{@link PlayerDeathEvent#getItemsToKeep()}
   *   <li>{@link PlayerDeathEvent#getKeepInventory()}
   *   <li>{@link PlayerDeathEvent#getKeepLevel()}
   *   <li>{@link PlayerDeathEvent#getNewExp()}
   *   <li>{@link PlayerDeathEvent#getNewLevel()}
   *   <li>{@link PlayerDeathEvent#getNewTotalExp()}
   *   <li>{@link PlayerDeathEvent#getShowDeathMessages()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, int, int, int, Component, boolean)",
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, int, int, int, Component, boolean, boolean)",
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, int, Component, boolean)",
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, Component, boolean)",
    "Component PlayerDeathEvent.deathMessage()",
    "void PlayerDeathEvent.deathMessage(Component)",
    "Component PlayerDeathEvent.deathScreenMessageOverride()",
    "void PlayerDeathEvent.deathScreenMessageOverride(Component)",
    "List PlayerDeathEvent.getItemsToKeep()",
    "boolean PlayerDeathEvent.getKeepInventory()",
    "boolean PlayerDeathEvent.getKeepLevel()",
    "int PlayerDeathEvent.getNewExp()",
    "int PlayerDeathEvent.getNewLevel()",
    "int PlayerDeathEvent.getNewTotalExp()",
    "boolean PlayerDeathEvent.getShowDeathMessages()",
    "void PlayerDeathEvent.setKeepInventory(boolean)",
    "void PlayerDeathEvent.setKeepLevel(boolean)",
    "void PlayerDeathEvent.setNewExp(int)",
    "void PlayerDeathEvent.setNewLevel(int)",
    "void PlayerDeathEvent.setNewTotalExp(int)",
    "void PlayerDeathEvent.setShouldDropExperience(boolean)",
    "void PlayerDeathEvent.setShowDeathMessages(boolean)"
  })
  void testGettersAndSetters4() {
    // Arrange
    Player player = mock(Player.class);
    DamageSource damageSource = mock(DamageSource.class);
    ArrayList<ItemStack> drops = new ArrayList<>();

    // Act
    PlayerDeathEvent actualPlayerDeathEvent =
        new PlayerDeathEvent(player, damageSource, drops, 1, mock(Component.class), true);
    Component deathMessage = mock(Component.class);
    actualPlayerDeathEvent.deathMessage(deathMessage);
    Component deathScreenMessageOverride = mock(Component.class);
    actualPlayerDeathEvent.deathScreenMessageOverride(deathScreenMessageOverride);
    actualPlayerDeathEvent.setKeepInventory(true);
    actualPlayerDeathEvent.setKeepLevel(true);
    actualPlayerDeathEvent.setNewExp(1);
    actualPlayerDeathEvent.setNewLevel(1);
    actualPlayerDeathEvent.setNewTotalExp(1);
    actualPlayerDeathEvent.setShouldDropExperience(true);
    actualPlayerDeathEvent.setShowDeathMessages(true);
    Component actualDeathMessageResult = actualPlayerDeathEvent.deathMessage();
    Component actualDeathScreenMessageOverrideResult =
        actualPlayerDeathEvent.deathScreenMessageOverride();
    List<ItemStack> actualItemsToKeep = actualPlayerDeathEvent.getItemsToKeep();
    boolean actualKeepInventory = actualPlayerDeathEvent.getKeepInventory();
    boolean actualKeepLevel = actualPlayerDeathEvent.getKeepLevel();
    int actualNewExp = actualPlayerDeathEvent.getNewExp();
    int actualNewLevel = actualPlayerDeathEvent.getNewLevel();
    int actualNewTotalExp = actualPlayerDeathEvent.getNewTotalExp();
    boolean actualShowDeathMessages = actualPlayerDeathEvent.getShowDeathMessages();

    // Assert
    assertNull(actualPlayerDeathEvent.getDeathSound());
    assertNull(actualPlayerDeathEvent.getDeathSoundCategory());
    assertEquals(0.0d, actualPlayerDeathEvent.getReviveHealth());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundPitch());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundVolume());
    assertEquals(1, actualPlayerDeathEvent.getDroppedExp());
    assertEquals(1, actualNewExp);
    assertEquals(1, actualNewLevel);
    assertEquals(1, actualNewTotalExp);
    assertFalse(actualPlayerDeathEvent.isAsynchronous());
    assertFalse(actualPlayerDeathEvent.isCancelled());
    List<ItemStack> drops2 = actualPlayerDeathEvent.getDrops();
    assertTrue(drops2.isEmpty());
    assertTrue(actualItemsToKeep.isEmpty());
    assertTrue(actualKeepInventory);
    assertTrue(actualKeepLevel);
    assertTrue(actualShowDeathMessages);
    assertSame(drops, drops2);
    assertSame(deathMessage, actualDeathMessageResult);
    assertSame(deathScreenMessageOverride, actualDeathScreenMessageOverrideResult);
    assertSame(damageSource, actualPlayerDeathEvent.getDamageSource());
    assertSame(player, actualPlayerDeathEvent.getEntity());
  }

  /**
   * Test {@link PlayerDeathEvent#PlayerDeathEvent(Player, DamageSource, List, int, int, int, int,
   * String)}.
   *
   * <p>Method under test: {@link PlayerDeathEvent#PlayerDeathEvent(Player, DamageSource, List, int,
   * int, int, int, String)}
   */
  @Test
  @DisplayName("Test new PlayerDeathEvent(Player, DamageSource, List, int, int, int, int, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, int, int, int, String)"
  })
  void testNewPlayerDeathEvent() {
    // Arrange
    Player player = mock(Player.class);
    DamageSource damageSource = mock(DamageSource.class);

    // Act
    PlayerDeathEvent actualPlayerDeathEvent =
        new PlayerDeathEvent(player, damageSource, new ArrayList<>(), 1, 1, 1, 1, "Death Message");

    // Assert
    assertEquals("Death Message", actualPlayerDeathEvent.getDeathMessage());
    assertEquals("PlayerDeathEvent", actualPlayerDeathEvent.getEventName());
    assertNull(actualPlayerDeathEvent.deathScreenMessageOverride());
    assertNull(actualPlayerDeathEvent.getDeathSound());
    assertNull(actualPlayerDeathEvent.getDeathSoundCategory());
    assertNull(actualPlayerDeathEvent.getEntityType());
    assertEquals(0.0d, actualPlayerDeathEvent.getReviveHealth());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundPitch());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundVolume());
    assertEquals(1, actualPlayerDeathEvent.getDroppedExp());
    assertEquals(1, actualPlayerDeathEvent.getNewExp());
    assertEquals(1, actualPlayerDeathEvent.getNewLevel());
    assertEquals(1, actualPlayerDeathEvent.getNewTotalExp());
    assertFalse(actualPlayerDeathEvent.isAsynchronous());
    assertFalse(actualPlayerDeathEvent.isCancelled());
    assertFalse(actualPlayerDeathEvent.shouldPlayDeathSound());
    assertFalse(actualPlayerDeathEvent.getKeepInventory());
    assertFalse(actualPlayerDeathEvent.getKeepLevel());
    assertTrue(actualPlayerDeathEvent.getDrops().isEmpty());
    assertTrue(actualPlayerDeathEvent.getItemsToKeep().isEmpty());
    assertTrue(actualPlayerDeathEvent.getShowDeathMessages());
    assertSame(damageSource, actualPlayerDeathEvent.getDamageSource());
    assertSame(player, actualPlayerDeathEvent.getEntity());
    assertSame(player, actualPlayerDeathEvent.getPlayer());
  }

  /**
   * Test {@link PlayerDeathEvent#PlayerDeathEvent(Player, DamageSource, List, int, int, int, int,
   * String, boolean)}.
   *
   * <p>Method under test: {@link PlayerDeathEvent#PlayerDeathEvent(Player, DamageSource, List, int,
   * int, int, int, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PlayerDeathEvent(Player, DamageSource, List, int, int, int, int, String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerDeathEvent.<init>(Player, DamageSource, List, int, int, int, int, String, boolean)"
  })
  void testNewPlayerDeathEvent2() {
    // Arrange
    Player player = mock(Player.class);
    DamageSource damageSource = mock(DamageSource.class);

    // Act
    PlayerDeathEvent actualPlayerDeathEvent =
        new PlayerDeathEvent(
            player, damageSource, new ArrayList<>(), 1, 1, 1, 1, "Death Message", true);

    // Assert
    assertEquals("Death Message", actualPlayerDeathEvent.getDeathMessage());
    assertEquals("PlayerDeathEvent", actualPlayerDeathEvent.getEventName());
    assertNull(actualPlayerDeathEvent.deathScreenMessageOverride());
    assertNull(actualPlayerDeathEvent.getDeathSound());
    assertNull(actualPlayerDeathEvent.getDeathSoundCategory());
    assertNull(actualPlayerDeathEvent.getEntityType());
    assertEquals(0.0d, actualPlayerDeathEvent.getReviveHealth());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundPitch());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundVolume());
    assertEquals(1, actualPlayerDeathEvent.getDroppedExp());
    assertEquals(1, actualPlayerDeathEvent.getNewExp());
    assertEquals(1, actualPlayerDeathEvent.getNewLevel());
    assertEquals(1, actualPlayerDeathEvent.getNewTotalExp());
    assertFalse(actualPlayerDeathEvent.isAsynchronous());
    assertFalse(actualPlayerDeathEvent.isCancelled());
    assertFalse(actualPlayerDeathEvent.shouldPlayDeathSound());
    assertFalse(actualPlayerDeathEvent.getKeepInventory());
    assertFalse(actualPlayerDeathEvent.getKeepLevel());
    assertTrue(actualPlayerDeathEvent.getDrops().isEmpty());
    assertTrue(actualPlayerDeathEvent.getItemsToKeep().isEmpty());
    assertTrue(actualPlayerDeathEvent.getShowDeathMessages());
    assertSame(damageSource, actualPlayerDeathEvent.getDamageSource());
    assertSame(player, actualPlayerDeathEvent.getEntity());
    assertSame(player, actualPlayerDeathEvent.getPlayer());
  }

  /**
   * Test {@link PlayerDeathEvent#PlayerDeathEvent(Player, DamageSource, List, int, int, String)}.
   *
   * <p>Method under test: {@link PlayerDeathEvent#PlayerDeathEvent(Player, DamageSource, List, int,
   * int, String)}
   */
  @Test
  @DisplayName("Test new PlayerDeathEvent(Player, DamageSource, List, int, int, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerDeathEvent.<init>(Player, DamageSource, List, int, int, String)"})
  void testNewPlayerDeathEvent3() {
    // Arrange
    Player player = mock(Player.class);
    DamageSource damageSource = mock(DamageSource.class);

    // Act
    PlayerDeathEvent actualPlayerDeathEvent =
        new PlayerDeathEvent(player, damageSource, new ArrayList<>(), 1, 1, "Death Message");

    // Assert
    assertEquals("Death Message", actualPlayerDeathEvent.getDeathMessage());
    assertEquals("PlayerDeathEvent", actualPlayerDeathEvent.getEventName());
    assertNull(actualPlayerDeathEvent.deathScreenMessageOverride());
    assertNull(actualPlayerDeathEvent.getDeathSound());
    assertNull(actualPlayerDeathEvent.getDeathSoundCategory());
    assertNull(actualPlayerDeathEvent.getEntityType());
    assertEquals(0, actualPlayerDeathEvent.getNewLevel());
    assertEquals(0, actualPlayerDeathEvent.getNewTotalExp());
    assertEquals(0.0d, actualPlayerDeathEvent.getReviveHealth());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundPitch());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundVolume());
    assertEquals(1, actualPlayerDeathEvent.getDroppedExp());
    assertEquals(1, actualPlayerDeathEvent.getNewExp());
    assertFalse(actualPlayerDeathEvent.isAsynchronous());
    assertFalse(actualPlayerDeathEvent.isCancelled());
    assertFalse(actualPlayerDeathEvent.shouldPlayDeathSound());
    assertFalse(actualPlayerDeathEvent.getKeepInventory());
    assertFalse(actualPlayerDeathEvent.getKeepLevel());
    assertTrue(actualPlayerDeathEvent.getDrops().isEmpty());
    assertTrue(actualPlayerDeathEvent.getItemsToKeep().isEmpty());
    assertTrue(actualPlayerDeathEvent.getShowDeathMessages());
    assertSame(damageSource, actualPlayerDeathEvent.getDamageSource());
    assertSame(player, actualPlayerDeathEvent.getEntity());
    assertSame(player, actualPlayerDeathEvent.getPlayer());
  }

  /**
   * Test {@link PlayerDeathEvent#PlayerDeathEvent(Player, DamageSource, List, int, String)}.
   *
   * <p>Method under test: {@link PlayerDeathEvent#PlayerDeathEvent(Player, DamageSource, List, int,
   * String)}
   */
  @Test
  @DisplayName("Test new PlayerDeathEvent(Player, DamageSource, List, int, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerDeathEvent.<init>(Player, DamageSource, List, int, String)"})
  void testNewPlayerDeathEvent4() {
    // Arrange
    Player player = mock(Player.class);
    DamageSource damageSource = mock(DamageSource.class);

    // Act
    PlayerDeathEvent actualPlayerDeathEvent =
        new PlayerDeathEvent(player, damageSource, new ArrayList<>(), 1, "Death Message");

    // Assert
    assertEquals("Death Message", actualPlayerDeathEvent.getDeathMessage());
    assertEquals("PlayerDeathEvent", actualPlayerDeathEvent.getEventName());
    assertNull(actualPlayerDeathEvent.deathScreenMessageOverride());
    assertNull(actualPlayerDeathEvent.getDeathSound());
    assertNull(actualPlayerDeathEvent.getDeathSoundCategory());
    assertNull(actualPlayerDeathEvent.getEntityType());
    assertEquals(0, actualPlayerDeathEvent.getNewExp());
    assertEquals(0, actualPlayerDeathEvent.getNewLevel());
    assertEquals(0, actualPlayerDeathEvent.getNewTotalExp());
    assertEquals(0.0d, actualPlayerDeathEvent.getReviveHealth());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundPitch());
    assertEquals(0.0f, actualPlayerDeathEvent.getDeathSoundVolume());
    assertEquals(1, actualPlayerDeathEvent.getDroppedExp());
    assertFalse(actualPlayerDeathEvent.isAsynchronous());
    assertFalse(actualPlayerDeathEvent.isCancelled());
    assertFalse(actualPlayerDeathEvent.shouldPlayDeathSound());
    assertFalse(actualPlayerDeathEvent.getKeepInventory());
    assertFalse(actualPlayerDeathEvent.getKeepLevel());
    assertTrue(actualPlayerDeathEvent.getDrops().isEmpty());
    assertTrue(actualPlayerDeathEvent.getItemsToKeep().isEmpty());
    assertTrue(actualPlayerDeathEvent.getShowDeathMessages());
    assertSame(damageSource, actualPlayerDeathEvent.getDamageSource());
    assertSame(player, actualPlayerDeathEvent.getEntity());
    assertSame(player, actualPlayerDeathEvent.getPlayer());
  }
}

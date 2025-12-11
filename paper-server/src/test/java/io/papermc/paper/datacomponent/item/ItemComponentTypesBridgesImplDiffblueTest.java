package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.destroystokyo.paper.profile.CraftPlayerProfile;
import com.destroystokyo.paper.profile.PlayerProfile;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import io.papermc.paper.ServerBuildInfo;
import io.papermc.paper.datacomponent.item.BannerPatternLayers.Builder;
import io.papermc.paper.datacomponent.item.PaperFireworks.BuilderImpl;
import io.papermc.paper.datacomponent.item.PaperItemTool.PaperRule;
import io.papermc.paper.datacomponent.item.Tool.Rule;
import io.papermc.paper.registry.set.NamedRegistryKeySetImpl;
import io.papermc.paper.registry.set.RegistryKeySet;
import io.papermc.paper.text.Filtered;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.util.TriState;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Holder.Direct;
import net.minecraft.core.HolderSet;
import net.minecraft.core.HolderSet.Named;
import net.minecraft.network.chat.Component;
import net.minecraft.server.network.Filterable;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.component.BlockItemStateProperties;
import net.minecraft.world.item.component.BlocksAttacks.ItemDamageFunction;
import net.minecraft.world.item.component.OminousBottleAmplifier;
import org.bukkit.block.BlockType;
import org.bukkit.craftbukkit.CraftJukeboxSong;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ItemComponentTypesBridgesImplDiffblueTest {
  /**
   * Test {@link ItemComponentTypesBridgesImpl#chargedProjectiles()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#chargedProjectiles()}
   */
  @Test
  @DisplayName("Test chargedProjectiles()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.datacomponent.item.ChargedProjectiles.Builder ItemComponentTypesBridgesImpl.chargedProjectiles()"
  })
  void testChargedProjectiles() {
    // Arrange, Act and Assert
    assertTrue(
        new ItemComponentTypesBridgesImpl().chargedProjectiles()
            instanceof PaperChargedProjectiles.BuilderImpl);
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#potDecorations()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#potDecorations()}
   */
  @Test
  @DisplayName("Test potDecorations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.datacomponent.item.PotDecorations.Builder ItemComponentTypesBridgesImpl.potDecorations()"
  })
  void testPotDecorations() {
    // Arrange, Act and Assert
    assertTrue(
        new ItemComponentTypesBridgesImpl().potDecorations()
            instanceof PaperPotDecorations.BuilderImpl);
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#lore()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#lore()}
   */
  @Test
  @DisplayName("Test lore()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemLore.Builder ItemComponentTypesBridgesImpl.lore()"})
  void testLore() {
    // Arrange and Act
    ItemLore.Builder actualLoreResult = new ItemComponentTypesBridgesImpl().lore();

    // Assert
    ItemLore itemLore = actualLoreResult.build();
    assertTrue(itemLore instanceof PaperItemLore);
    assertTrue(actualLoreResult instanceof PaperItemLore.BuilderImpl);
    net.minecraft.world.item.component.ItemLore handle = ((PaperItemLore) itemLore).getHandle();
    assertTrue(handle.lines().isEmpty());
    assertTrue(handle.styledLines().isEmpty());
    assertSame(handle, ((PaperItemLore) itemLore).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#enchantments()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#enchantments()}
   */
  @Test
  @DisplayName("Test enchantments()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.datacomponent.item.ItemEnchantments.Builder ItemComponentTypesBridgesImpl.enchantments()"
  })
  void testEnchantments() {
    // Arrange, Act and Assert
    assertTrue(
        new ItemComponentTypesBridgesImpl().enchantments()
            instanceof PaperItemEnchantments.BuilderImpl);
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#modifiers()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#modifiers()}
   */
  @Test
  @DisplayName("Test modifiers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.datacomponent.item.ItemAttributeModifiers.Builder ItemComponentTypesBridgesImpl.modifiers()"
  })
  void testModifiers() {
    // Arrange, Act and Assert
    assertTrue(
        new ItemComponentTypesBridgesImpl().modifiers()
            instanceof PaperItemAttributeModifiers.BuilderImpl);
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#food()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#food()}
   */
  @Test
  @DisplayName("Test food()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FoodProperties.Builder ItemComponentTypesBridgesImpl.food()"})
  void testFood() {
    // Arrange and Act
    FoodProperties.Builder actualFoodResult = new ItemComponentTypesBridgesImpl().food();

    // Assert
    FoodProperties foodProperties = actualFoodResult.build();
    assertTrue(foodProperties instanceof PaperFoodProperties);
    assertTrue(actualFoodResult instanceof PaperFoodProperties.BuilderImpl);
    net.minecraft.world.food.FoodProperties handle =
        ((PaperFoodProperties) foodProperties).getHandle();
    assertEquals(0, handle.nutrition());
    assertEquals(0.0f, handle.saturation());
    assertFalse(handle.canAlwaysEat());
    assertSame(handle, ((PaperFoodProperties) foodProperties).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#dyedItemColor()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#dyedItemColor()}
   */
  @Test
  @DisplayName("Test dyedItemColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DyedItemColor.Builder ItemComponentTypesBridgesImpl.dyedItemColor()"})
  void testDyedItemColor() {
    // Arrange and Act
    DyedItemColor.Builder actualDyedItemColorResult =
        new ItemComponentTypesBridgesImpl().dyedItemColor();

    // Assert
    DyedItemColor dyedItemColor = actualDyedItemColorResult.build();
    assertTrue(dyedItemColor instanceof PaperDyedItemColor);
    assertTrue(actualDyedItemColorResult instanceof PaperDyedItemColor.BuilderImpl);
    net.minecraft.world.item.component.DyedItemColor handle =
        ((PaperDyedItemColor) dyedItemColor).getHandle();
    assertEquals(16777215, handle.rgb());
    assertSame(handle, ((PaperDyedItemColor) dyedItemColor).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#potionContents()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#potionContents()}
   */
  @Test
  @DisplayName("Test potionContents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.datacomponent.item.PotionContents.Builder ItemComponentTypesBridgesImpl.potionContents()"
  })
  void testPotionContents() {
    // Arrange, Act and Assert
    assertTrue(
        new ItemComponentTypesBridgesImpl().potionContents()
            instanceof PaperPotionContents.BuilderImpl);
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#bundleContents()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#bundleContents()}
   */
  @Test
  @DisplayName("Test bundleContents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.datacomponent.item.BundleContents.Builder ItemComponentTypesBridgesImpl.bundleContents()"
  })
  void testBundleContents() {
    // Arrange, Act and Assert
    assertTrue(
        new ItemComponentTypesBridgesImpl().bundleContents()
            instanceof PaperBundleContents.BuilderImpl);
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#suspiciousStewEffects()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#suspiciousStewEffects()}
   */
  @Test
  @DisplayName("Test suspiciousStewEffects()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.datacomponent.item.SuspiciousStewEffects.Builder ItemComponentTypesBridgesImpl.suspiciousStewEffects()"
  })
  void testSuspiciousStewEffects() {
    // Arrange, Act and Assert
    assertTrue(
        new ItemComponentTypesBridgesImpl().suspiciousStewEffects()
            instanceof PaperSuspiciousStewEffects.BuilderImpl);
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#mapItemColor()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#mapItemColor()}
   */
  @Test
  @DisplayName("Test mapItemColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapItemColor.Builder ItemComponentTypesBridgesImpl.mapItemColor()"})
  void testMapItemColor() {
    // Arrange and Act
    MapItemColor.Builder actualMapItemColorResult =
        new ItemComponentTypesBridgesImpl().mapItemColor();

    // Assert
    MapItemColor mapItemColor = actualMapItemColorResult.build();
    assertTrue(mapItemColor instanceof PaperMapItemColor);
    assertTrue(actualMapItemColorResult instanceof PaperMapItemColor.BuilderImpl);
    net.minecraft.world.item.component.MapItemColor handle =
        ((PaperMapItemColor) mapItemColor).getHandle();
    assertEquals(4603950, handle.rgb());
    assertSame(handle, ((PaperMapItemColor) mapItemColor).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#mapDecorations()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#mapDecorations()}
   */
  @Test
  @DisplayName("Test mapDecorations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.datacomponent.item.MapDecorations.Builder ItemComponentTypesBridgesImpl.mapDecorations()"
  })
  void testMapDecorations() {
    // Arrange, Act and Assert
    assertTrue(
        new ItemComponentTypesBridgesImpl().mapDecorations()
            instanceof PaperMapDecorations.BuilderImpl);
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#seededContainerLoot(Key)}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#seededContainerLoot(Key)}
   */
  @Test
  @DisplayName("Test seededContainerLoot(Key)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.datacomponent.item.SeededContainerLoot.Builder ItemComponentTypesBridgesImpl.seededContainerLoot(Key)"
  })
  void testSeededContainerLoot() {
    // Arrange, Act and Assert
    assertTrue(
        new ItemComponentTypesBridgesImpl().seededContainerLoot(ServerBuildInfo.BRAND_PAPER_ID)
            instanceof PaperSeededContainerLoot.BuilderImpl);
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#itemContainerContents()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#itemContainerContents()}
   */
  @Test
  @DisplayName("Test itemContainerContents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.datacomponent.item.ItemContainerContents.Builder ItemComponentTypesBridgesImpl.itemContainerContents()"
  })
  void testItemContainerContents() {
    // Arrange, Act and Assert
    assertTrue(
        new ItemComponentTypesBridgesImpl().itemContainerContents()
            instanceof PaperItemContainerContents.BuilderImpl);
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#jukeboxPlayable(JukeboxSong)}.
   *
   * <p>Method under test: {@link
   * ItemComponentTypesBridgesImpl#jukeboxPlayable(org.bukkit.JukeboxSong)}
   */
  @Test
  @DisplayName("Test jukeboxPlayable(JukeboxSong)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JukeboxPlayable.Builder ItemComponentTypesBridgesImpl.jukeboxPlayable(org.bukkit.JukeboxSong)"
  })
  void testJukeboxPlayable() {
    // Arrange
    ItemComponentTypesBridgesImpl itemComponentTypesBridgesImpl =
        new ItemComponentTypesBridgesImpl();
    JukeboxSong jukeboxSong = new JukeboxSong(mock(Holder.class), mock(Component.class), 10.0f, 1);

    // Act
    JukeboxPlayable.Builder actualJukeboxPlayableResult =
        itemComponentTypesBridgesImpl.jukeboxPlayable(
            new CraftJukeboxSong(new Direct<>(jukeboxSong)));

    // Assert
    assertTrue(actualJukeboxPlayableResult instanceof PaperJukeboxPlayable.BuilderImpl);
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#tool()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#tool()}
   */
  @Test
  @DisplayName("Test tool()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Tool.Builder ItemComponentTypesBridgesImpl.tool()"})
  void testTool() {
    // Arrange and Act
    Tool.Builder actualToolResult = new ItemComponentTypesBridgesImpl().tool();

    // Assert
    Tool tool = actualToolResult.build();
    assertTrue(tool instanceof PaperItemTool);
    assertTrue(actualToolResult instanceof PaperItemTool.BuilderImpl);
    net.minecraft.world.item.component.Tool handle = ((PaperItemTool) tool).getHandle();
    assertEquals(1, handle.damagePerBlock());
    assertEquals(1.0f, handle.defaultMiningSpeed());
    assertTrue(handle.rules().isEmpty());
    assertTrue(handle.canDestroyBlocksInCreative());
    assertSame(handle, ((PaperItemTool) tool).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#rule(RegistryKeySet, Float, TriState)}.
   *
   * <ul>
   *   <li>Then return {@link PaperRule}.
   * </ul>
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#rule(RegistryKeySet, Float,
   * TriState)}
   */
  @Test
  @DisplayName("Test rule(RegistryKeySet, Float, TriState); then return PaperRule")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rule ItemComponentTypesBridgesImpl.rule(RegistryKeySet, Float, TriState)"})
  void testRule_thenReturnPaperRule() {
    // Arrange
    ItemComponentTypesBridgesImpl itemComponentTypesBridgesImpl =
        new ItemComponentTypesBridgesImpl();
    NamedRegistryKeySetImpl<BlockType, Object> blocks =
        new NamedRegistryKeySetImpl<>(null, mock(Named.class));

    // Act
    Rule actualRuleResult = itemComponentTypesBridgesImpl.rule(blocks, 10.0f, TriState.NOT_SET);

    // Assert
    assertTrue(actualRuleResult instanceof PaperRule);
    RegistryKeySet<BlockType> blocksResult = actualRuleResult.blocks();
    assertTrue(blocksResult instanceof NamedRegistryKeySetImpl);
    assertNull(((NamedRegistryKeySetImpl<BlockType, Object>) blocksResult).tagKey());
    assertEquals(10.0f, actualRuleResult.speed().floatValue());
    assertEquals(TriState.NOT_SET, actualRuleResult.correctForDrops());
    assertSame(blocks, blocksResult);
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#itemAdventurePredicate()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#itemAdventurePredicate()}
   */
  @Test
  @DisplayName("Test itemAdventurePredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.datacomponent.item.ItemAdventurePredicate.Builder ItemComponentTypesBridgesImpl.itemAdventurePredicate()"
  })
  void testItemAdventurePredicate() {
    // Arrange, Act and Assert
    assertTrue(
        new ItemComponentTypesBridgesImpl().itemAdventurePredicate()
            instanceof PaperItemAdventurePredicate.BuilderImpl);
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#writtenBookContent(Filtered, String)}.
   *
   * <ul>
   *   <li>Given {@code Filtered}.
   *   <li>Then build return {@link PaperWrittenBookContent}.
   * </ul>
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#writtenBookContent(Filtered,
   * String)}
   */
  @Test
  @DisplayName(
      "Test writtenBookContent(Filtered, String); given 'Filtered'; then build return PaperWrittenBookContent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WrittenBookContent.Builder ItemComponentTypesBridgesImpl.writtenBookContent(Filtered, String)"
  })
  void testWrittenBookContent_givenFiltered_thenBuildReturnPaperWrittenBookContent() {
    // Arrange
    ItemComponentTypesBridgesImpl itemComponentTypesBridgesImpl =
        new ItemComponentTypesBridgesImpl();

    Filtered<String> title = mock(Filtered.class);
    when(title.filtered()).thenReturn("Filtered");
    when(title.raw()).thenReturn("Raw");

    // Act
    WrittenBookContent.Builder actualWrittenBookContentResult =
        itemComponentTypesBridgesImpl.writtenBookContent(title, "JaneDoe");

    // Assert
    verify(title, atLeast(1)).filtered();
    verify(title, atLeast(1)).raw();
    WrittenBookContent writtenBookContent = actualWrittenBookContentResult.build();
    assertTrue(writtenBookContent instanceof PaperWrittenBookContent);
    assertTrue(actualWrittenBookContentResult instanceof PaperWrittenBookContent.BuilderImpl);
    net.minecraft.world.item.component.WrittenBookContent handle =
        ((PaperWrittenBookContent) writtenBookContent).getHandle();
    Filterable<String> titleResult = handle.title();
    Optional<String> filteredResult = titleResult.filtered();
    assertEquals("Filtered", filteredResult.get());
    assertEquals("JaneDoe", handle.author());
    assertEquals("Raw", titleResult.raw());
    assertEquals(0, handle.generation());
    assertFalse(handle.resolved());
    assertTrue(handle.pages().isEmpty());
    assertTrue(filteredResult.isPresent());
    assertSame(handle, ((PaperWrittenBookContent) writtenBookContent).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#writeableBookContent()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#writeableBookContent()}
   */
  @Test
  @DisplayName("Test writeableBookContent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WritableBookContent.Builder ItemComponentTypesBridgesImpl.writeableBookContent()"
  })
  void testWriteableBookContent() {
    // Arrange and Act
    WritableBookContent.Builder actualWriteableBookContentResult =
        new ItemComponentTypesBridgesImpl().writeableBookContent();

    // Assert
    WritableBookContent writableBookContent = actualWriteableBookContentResult.build();
    assertTrue(writableBookContent instanceof PaperWritableBookContent);
    assertTrue(actualWriteableBookContentResult instanceof PaperWritableBookContent.BuilderImpl);
    net.minecraft.world.item.component.WritableBookContent handle =
        ((PaperWritableBookContent) writableBookContent).getHandle();
    assertTrue(handle.pages().isEmpty());
    assertSame(handle, ((PaperWritableBookContent) writableBookContent).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#lodestoneTracker()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#lodestoneTracker()}
   */
  @Test
  @DisplayName("Test lodestoneTracker()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.datacomponent.item.LodestoneTracker.Builder ItemComponentTypesBridgesImpl.lodestoneTracker()"
  })
  void testLodestoneTracker() {
    // Arrange, Act and Assert
    assertTrue(
        new ItemComponentTypesBridgesImpl().lodestoneTracker()
            instanceof PaperLodestoneTracker.BuilderImpl);
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#fireworks()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#fireworks()}
   */
  @Test
  @DisplayName("Test fireworks()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Fireworks.Builder ItemComponentTypesBridgesImpl.fireworks()"})
  void testFireworks() {
    // Arrange and Act
    Fireworks.Builder actualFireworksResult = new ItemComponentTypesBridgesImpl().fireworks();

    // Assert
    Fireworks fireworks = actualFireworksResult.build();
    assertTrue(fireworks instanceof PaperFireworks);
    assertTrue(actualFireworksResult instanceof BuilderImpl);
    net.minecraft.world.item.component.Fireworks handle = ((PaperFireworks) fireworks).getHandle();
    assertEquals(0, handle.flightDuration());
    assertTrue(handle.explosions().isEmpty());
    assertSame(handle, ((PaperFireworks) fireworks).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#resolvableProfile()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#resolvableProfile()}
   */
  @Test
  @DisplayName("Test resolvableProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolvableProfile.Builder ItemComponentTypesBridgesImpl.resolvableProfile()"})
  void testResolvableProfile() {
    // Arrange and Act
    ResolvableProfile.Builder actualResolvableProfileResult =
        new ItemComponentTypesBridgesImpl().resolvableProfile();

    // Assert
    ResolvableProfile resolvableProfile = actualResolvableProfileResult.build();
    assertTrue(resolvableProfile instanceof PaperResolvableProfile);
    assertTrue(actualResolvableProfileResult instanceof PaperResolvableProfile.BuilderImpl);
    net.minecraft.world.item.component.ResolvableProfile handle =
        ((PaperResolvableProfile) resolvableProfile).getHandle();
    PropertyMap propertiesResult = handle.properties();
    Collection<Entry<String, Property>> entriesResult = propertiesResult.entries();
    assertTrue(entriesResult instanceof Set);
    GameProfile gameProfileResult = handle.gameProfile();
    assertEquals("", gameProfileResult.getName());
    assertEquals(0, propertiesResult.size());
    Optional<UUID> idResult = handle.id();
    assertFalse(idResult.isPresent());
    assertTrue(propertiesResult.isEmpty());
    assertTrue(entriesResult.isEmpty());
    assertTrue(propertiesResult.keys().isEmpty());
    assertEquals(propertiesResult, gameProfileResult.getProperties());
    assertSame(handle, ((PaperResolvableProfile) resolvableProfile).impl());
    assertSame(idResult, handle.name());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#resolvableProfile(PlayerProfile)} with {@code
   * PlayerProfile}.
   *
   * <ul>
   *   <li>Then return Handle name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#resolvableProfile(PlayerProfile)}
   */
  @Test
  @DisplayName(
      "Test resolvableProfile(PlayerProfile) with 'PlayerProfile'; then return Handle name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResolvableProfile ItemComponentTypesBridgesImpl.resolvableProfile(PlayerProfile)"
  })
  void testResolvableProfileWithPlayerProfile_thenReturnHandleNameIsEmptyString() {
    // Arrange
    ItemComponentTypesBridgesImpl itemComponentTypesBridgesImpl =
        new ItemComponentTypesBridgesImpl();
    GameProfile profile = new GameProfile(Util.NIL_UUID, "");

    // Act
    ResolvableProfile actualResolvableProfileResult =
        itemComponentTypesBridgesImpl.resolvableProfile(new CraftPlayerProfile(profile));

    // Assert
    assertTrue(actualResolvableProfileResult instanceof PaperResolvableProfile);
    net.minecraft.world.item.component.ResolvableProfile handle =
        ((PaperResolvableProfile) actualResolvableProfileResult).getHandle();
    assertEquals("", handle.name().get());
    assertEquals(profile, handle.gameProfile());
    assertSame(handle, ((PaperResolvableProfile) actualResolvableProfileResult).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#resolvableProfile(PlayerProfile)} with {@code
   * PlayerProfile}.
   *
   * <ul>
   *   <li>Then return Handle name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#resolvableProfile(PlayerProfile)}
   */
  @Test
  @DisplayName(
      "Test resolvableProfile(PlayerProfile) with 'PlayerProfile'; then return Handle name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResolvableProfile ItemComponentTypesBridgesImpl.resolvableProfile(PlayerProfile)"
  })
  void testResolvableProfileWithPlayerProfile_thenReturnHandleNameIsName() {
    // Arrange
    ItemComponentTypesBridgesImpl itemComponentTypesBridgesImpl =
        new ItemComponentTypesBridgesImpl();
    GameProfile profile = new GameProfile(Util.NIL_UUID, "Name");

    // Act
    ResolvableProfile actualResolvableProfileResult =
        itemComponentTypesBridgesImpl.resolvableProfile(new CraftPlayerProfile(profile));

    // Assert
    assertTrue(actualResolvableProfileResult instanceof PaperResolvableProfile);
    net.minecraft.world.item.component.ResolvableProfile handle =
        ((PaperResolvableProfile) actualResolvableProfileResult).getHandle();
    assertEquals("Name", handle.name().get());
    assertEquals(profile, handle.gameProfile());
    assertSame(handle, ((PaperResolvableProfile) actualResolvableProfileResult).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#bannerPatternLayers()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#bannerPatternLayers()}
   */
  @Test
  @DisplayName("Test bannerPatternLayers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder ItemComponentTypesBridgesImpl.bannerPatternLayers()"})
  void testBannerPatternLayers() {
    // Arrange and Act
    Builder actualBannerPatternLayersResult =
        new ItemComponentTypesBridgesImpl().bannerPatternLayers();

    // Assert
    BannerPatternLayers bannerPatternLayers = actualBannerPatternLayersResult.build();
    assertTrue(bannerPatternLayers instanceof PaperBannerPatternLayers);
    assertTrue(actualBannerPatternLayersResult instanceof PaperBannerPatternLayers.BuilderImpl);
    net.minecraft.world.level.block.entity.BannerPatternLayers handle =
        ((PaperBannerPatternLayers) bannerPatternLayers).getHandle();
    assertTrue(handle.layers().isEmpty());
    assertSame(handle, ((PaperBannerPatternLayers) bannerPatternLayers).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#blockItemStateProperties()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#blockItemStateProperties()}
   */
  @Test
  @DisplayName("Test blockItemStateProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BlockItemDataProperties.Builder ItemComponentTypesBridgesImpl.blockItemStateProperties()"
  })
  void testBlockItemStateProperties() {
    // Arrange and Act
    BlockItemDataProperties.Builder actualBlockItemStatePropertiesResult =
        new ItemComponentTypesBridgesImpl().blockItemStateProperties();
    BlockItemDataProperties actualBlockItemDataProperties =
        actualBlockItemStatePropertiesResult.build();

    // Assert
    BlockItemDataProperties blockItemDataProperties = actualBlockItemStatePropertiesResult.build();
    assertTrue(blockItemDataProperties instanceof PaperBlockItemDataProperties);
    assertTrue(actualBlockItemDataProperties instanceof PaperBlockItemDataProperties);
    assertTrue(
        actualBlockItemStatePropertiesResult instanceof PaperBlockItemDataProperties.BuilderImpl);
    BlockItemStateProperties handle =
        ((PaperBlockItemDataProperties) blockItemDataProperties).getHandle();
    assertTrue(handle.properties().isEmpty());
    assertEquals(blockItemDataProperties, actualBlockItemDataProperties);
    assertSame(handle, ((PaperBlockItemDataProperties) blockItemDataProperties).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#mapId(int)}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#mapId(int)}
   */
  @Test
  @DisplayName("Test mapId(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapId ItemComponentTypesBridgesImpl.mapId(int)"})
  void testMapId() {
    // Arrange
    ItemComponentTypesBridgesImpl itemComponentTypesBridgesImpl =
        new ItemComponentTypesBridgesImpl();

    // Act
    MapId actualMapIdResult = itemComponentTypesBridgesImpl.mapId(1);

    // Assert
    assertTrue(itemComponentTypesBridgesImpl.fireworks() instanceof BuilderImpl);
    assertTrue(itemComponentTypesBridgesImpl.food() instanceof PaperFoodProperties.BuilderImpl);
    assertTrue(
        itemComponentTypesBridgesImpl.modifiers()
            instanceof PaperItemAttributeModifiers.BuilderImpl);
    assertTrue(
        itemComponentTypesBridgesImpl.enchantments() instanceof PaperItemEnchantments.BuilderImpl);
    assertTrue(itemComponentTypesBridgesImpl.lore() instanceof PaperItemLore.BuilderImpl);
    assertTrue(itemComponentTypesBridgesImpl.tool() instanceof PaperItemTool.BuilderImpl);
    assertTrue(actualMapIdResult instanceof PaperMapId);
    assertTrue(itemComponentTypesBridgesImpl.weapon() instanceof PaperWeapon.BuilderImpl);
    net.minecraft.world.level.saveddata.maps.MapId handle =
        ((PaperMapId) actualMapIdResult).getHandle();
    assertEquals(1, handle.id());
    assertSame(handle, ((PaperMapId) actualMapIdResult).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#mapId(int)}.
   *
   * <ul>
   *   <li>Then return id is one.
   * </ul>
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#mapId(int)}
   */
  @Test
  @DisplayName("Test mapId(int); then return id is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapId ItemComponentTypesBridgesImpl.mapId(int)"})
  void testMapId_thenReturnIdIsOne() {
    // Arrange
    ItemComponentTypesBridgesImpl itemComponentTypesBridgesImpl =
        new ItemComponentTypesBridgesImpl();

    // Act
    MapId actualMapIdResult = itemComponentTypesBridgesImpl.mapId(1);
    int actualIdResult = actualMapIdResult.id();

    // Assert
    assertTrue(itemComponentTypesBridgesImpl.fireworks() instanceof BuilderImpl);
    assertTrue(itemComponentTypesBridgesImpl.food() instanceof PaperFoodProperties.BuilderImpl);
    assertTrue(
        itemComponentTypesBridgesImpl.modifiers()
            instanceof PaperItemAttributeModifiers.BuilderImpl);
    assertTrue(
        itemComponentTypesBridgesImpl.enchantments() instanceof PaperItemEnchantments.BuilderImpl);
    assertTrue(itemComponentTypesBridgesImpl.lore() instanceof PaperItemLore.BuilderImpl);
    assertTrue(itemComponentTypesBridgesImpl.tool() instanceof PaperItemTool.BuilderImpl);
    assertTrue(actualMapIdResult instanceof PaperMapId);
    assertTrue(itemComponentTypesBridgesImpl.weapon() instanceof PaperWeapon.BuilderImpl);
    assertEquals(1, actualIdResult);
    net.minecraft.world.level.saveddata.maps.MapId handle =
        ((PaperMapId) actualMapIdResult).getHandle();
    assertEquals(1, handle.id());
    assertSame(handle, ((PaperMapId) actualMapIdResult).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#useCooldown(float)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then build return {@link PaperUseCooldown}.
   * </ul>
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#useCooldown(float)}
   */
  @Test
  @DisplayName("Test useCooldown(float); when ten; then build return PaperUseCooldown")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UseCooldown.Builder ItemComponentTypesBridgesImpl.useCooldown(float)"})
  void testUseCooldown_whenTen_thenBuildReturnPaperUseCooldown() {
    // Arrange and Act
    UseCooldown.Builder actualUseCooldownResult =
        new ItemComponentTypesBridgesImpl().useCooldown(10.0f);

    // Assert
    UseCooldown useCooldown = actualUseCooldownResult.build();
    assertTrue(useCooldown instanceof PaperUseCooldown);
    assertTrue(actualUseCooldownResult instanceof PaperUseCooldown.BuilderImpl);
    net.minecraft.world.item.component.UseCooldown handle =
        ((PaperUseCooldown) useCooldown).getHandle();
    assertEquals(10.0f, handle.seconds());
    assertFalse(handle.cooldownGroup().isPresent());
    assertSame(handle, ((PaperUseCooldown) useCooldown).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#enchantable(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link PaperEnchantable}.
   * </ul>
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#enchantable(int)}
   */
  @Test
  @DisplayName("Test enchantable(int); when one; then return PaperEnchantable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Enchantable ItemComponentTypesBridgesImpl.enchantable(int)"})
  void testEnchantable_whenOne_thenReturnPaperEnchantable() {
    // Arrange
    ItemComponentTypesBridgesImpl itemComponentTypesBridgesImpl =
        new ItemComponentTypesBridgesImpl();

    // Act
    Enchantable actualEnchantableResult = itemComponentTypesBridgesImpl.enchantable(1);

    // Assert
    assertTrue(actualEnchantableResult instanceof PaperEnchantable);
    assertTrue(itemComponentTypesBridgesImpl.fireworks() instanceof BuilderImpl);
    assertTrue(itemComponentTypesBridgesImpl.food() instanceof PaperFoodProperties.BuilderImpl);
    assertTrue(
        itemComponentTypesBridgesImpl.modifiers()
            instanceof PaperItemAttributeModifiers.BuilderImpl);
    assertTrue(
        itemComponentTypesBridgesImpl.enchantments() instanceof PaperItemEnchantments.BuilderImpl);
    assertTrue(itemComponentTypesBridgesImpl.lore() instanceof PaperItemLore.BuilderImpl);
    assertTrue(itemComponentTypesBridgesImpl.tool() instanceof PaperItemTool.BuilderImpl);
    assertTrue(itemComponentTypesBridgesImpl.weapon() instanceof PaperWeapon.BuilderImpl);
    net.minecraft.world.item.enchantment.Enchantable handle =
        ((PaperEnchantable) actualEnchantableResult).getHandle();
    assertEquals(1, handle.value());
    assertSame(handle, ((PaperEnchantable) actualEnchantableResult).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#enchantable(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return value is one.
   * </ul>
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#enchantable(int)}
   */
  @Test
  @DisplayName("Test enchantable(int); when one; then return value is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Enchantable ItemComponentTypesBridgesImpl.enchantable(int)"})
  void testEnchantable_whenOne_thenReturnValueIsOne() {
    // Arrange
    ItemComponentTypesBridgesImpl itemComponentTypesBridgesImpl =
        new ItemComponentTypesBridgesImpl();

    // Act
    Enchantable actualEnchantableResult = itemComponentTypesBridgesImpl.enchantable(1);
    int actualValueResult = actualEnchantableResult.value();

    // Assert
    assertTrue(actualEnchantableResult instanceof PaperEnchantable);
    assertTrue(itemComponentTypesBridgesImpl.fireworks() instanceof BuilderImpl);
    assertTrue(itemComponentTypesBridgesImpl.food() instanceof PaperFoodProperties.BuilderImpl);
    assertTrue(
        itemComponentTypesBridgesImpl.modifiers()
            instanceof PaperItemAttributeModifiers.BuilderImpl);
    assertTrue(
        itemComponentTypesBridgesImpl.enchantments() instanceof PaperItemEnchantments.BuilderImpl);
    assertTrue(itemComponentTypesBridgesImpl.lore() instanceof PaperItemLore.BuilderImpl);
    assertTrue(itemComponentTypesBridgesImpl.tool() instanceof PaperItemTool.BuilderImpl);
    assertTrue(itemComponentTypesBridgesImpl.weapon() instanceof PaperWeapon.BuilderImpl);
    assertEquals(1, actualValueResult);
    net.minecraft.world.item.enchantment.Enchantable handle =
        ((PaperEnchantable) actualEnchantableResult).getHandle();
    assertEquals(1, handle.value());
    assertSame(handle, ((PaperEnchantable) actualEnchantableResult).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#deathProtection()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#deathProtection()}
   */
  @Test
  @DisplayName("Test deathProtection()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.datacomponent.item.DeathProtection.Builder ItemComponentTypesBridgesImpl.deathProtection()"
  })
  void testDeathProtection() {
    // Arrange, Act and Assert
    assertTrue(
        new ItemComponentTypesBridgesImpl().deathProtection()
            instanceof PaperDeathProtection.BuilderImpl);
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#customModelData()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#customModelData()}
   */
  @Test
  @DisplayName("Test customModelData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomModelData.Builder ItemComponentTypesBridgesImpl.customModelData()"})
  void testCustomModelData() {
    // Arrange and Act
    CustomModelData.Builder actualCustomModelDataResult =
        new ItemComponentTypesBridgesImpl().customModelData();

    // Assert
    CustomModelData customModelData = actualCustomModelDataResult.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    assertTrue(actualCustomModelDataResult instanceof PaperCustomModelData.BuilderImpl);
    net.minecraft.world.item.component.CustomModelData handle =
        ((PaperCustomModelData) customModelData).getHandle();
    assertTrue(handle.colors().isEmpty());
    assertTrue(handle.flags().isEmpty());
    assertTrue(handle.floats().isEmpty());
    assertTrue(handle.strings().isEmpty());
    assertSame(handle, ((PaperCustomModelData) customModelData).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#ominousBottleAmplifier(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Handle value is one.
   * </ul>
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#ominousBottleAmplifier(int)}
   */
  @Test
  @DisplayName("Test ominousBottleAmplifier(int); when one; then return Handle value is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaperOminousBottleAmplifier ItemComponentTypesBridgesImpl.ominousBottleAmplifier(int)"
  })
  void testOminousBottleAmplifier_whenOne_thenReturnHandleValueIsOne() {
    // Arrange and Act
    PaperOminousBottleAmplifier actualOminousBottleAmplifierResult =
        new ItemComponentTypesBridgesImpl().ominousBottleAmplifier(1);

    // Assert
    OminousBottleAmplifier handle = actualOminousBottleAmplifierResult.getHandle();
    assertEquals(1, handle.value());
    assertSame(handle, actualOminousBottleAmplifierResult.impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#ominousBottleAmplifier(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Handle value is zero.
   * </ul>
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#ominousBottleAmplifier(int)}
   */
  @Test
  @DisplayName("Test ominousBottleAmplifier(int); when zero; then return Handle value is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaperOminousBottleAmplifier ItemComponentTypesBridgesImpl.ominousBottleAmplifier(int)"
  })
  void testOminousBottleAmplifier_whenZero_thenReturnHandleValueIsZero() {
    // Arrange and Act
    PaperOminousBottleAmplifier actualOminousBottleAmplifierResult =
        new ItemComponentTypesBridgesImpl().ominousBottleAmplifier(0);

    // Assert
    OminousBottleAmplifier handle = actualOminousBottleAmplifierResult.getHandle();
    assertEquals(0, handle.value());
    assertSame(handle, actualOminousBottleAmplifierResult.impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#blocksAttacks()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#blocksAttacks()}
   */
  @Test
  @DisplayName("Test blocksAttacks()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlocksAttacks.Builder ItemComponentTypesBridgesImpl.blocksAttacks()"})
  void testBlocksAttacks() {
    // Arrange and Act
    BlocksAttacks.Builder actualBlocksAttacksResult =
        new ItemComponentTypesBridgesImpl().blocksAttacks();

    // Assert
    BlocksAttacks blocksAttacks = actualBlocksAttacksResult.build();
    assertTrue(blocksAttacks instanceof PaperBlocksAttacks);
    assertTrue(actualBlocksAttacksResult instanceof PaperBlocksAttacks.BuilderImpl);
    net.minecraft.world.item.component.BlocksAttacks handle =
        ((PaperBlocksAttacks) blocksAttacks).getHandle();
    assertEquals(0.0f, handle.blockDelaySeconds());
    ItemDamageFunction itemDamageResult = handle.itemDamage();
    assertEquals(0.0f, itemDamageResult.base());
    assertEquals(1.0f, handle.disableCooldownScale());
    assertEquals(1.0f, itemDamageResult.factor());
    assertEquals(1.0f, itemDamageResult.threshold());
    Optional<Holder<SoundEvent>> blockSoundResult = handle.blockSound();
    assertFalse(blockSoundResult.isPresent());
    assertTrue(handle.damageReductions().isEmpty());
    assertSame(handle, ((PaperBlocksAttacks) blocksAttacks).impl());
    assertSame(blockSoundResult, handle.bypassedBy());
    assertSame(blockSoundResult, handle.disableSound());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#tooltipDisplay()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#tooltipDisplay()}
   */
  @Test
  @DisplayName("Test tooltipDisplay()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TooltipDisplay.Builder ItemComponentTypesBridgesImpl.tooltipDisplay()"})
  void testTooltipDisplay() {
    // Arrange and Act
    TooltipDisplay.Builder actualTooltipDisplayResult =
        new ItemComponentTypesBridgesImpl().tooltipDisplay();

    // Assert
    TooltipDisplay tooltipDisplay = actualTooltipDisplayResult.build();
    assertTrue(tooltipDisplay instanceof PaperTooltipDisplay);
    assertTrue(actualTooltipDisplayResult instanceof PaperTooltipDisplay.BuilderImpl);
    net.minecraft.world.item.component.TooltipDisplay handle =
        ((PaperTooltipDisplay) tooltipDisplay).getHandle();
    assertFalse(handle.hideTooltip());
    assertTrue(handle.hiddenComponents().isEmpty());
    assertSame(handle, ((PaperTooltipDisplay) tooltipDisplay).impl());
  }

  /**
   * Test {@link ItemComponentTypesBridgesImpl#weapon()}.
   *
   * <p>Method under test: {@link ItemComponentTypesBridgesImpl#weapon()}
   */
  @Test
  @DisplayName("Test weapon()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Weapon.Builder ItemComponentTypesBridgesImpl.weapon()"})
  void testWeapon() {
    // Arrange and Act
    Weapon.Builder actualWeaponResult = new ItemComponentTypesBridgesImpl().weapon();

    // Assert
    Weapon weapon = actualWeaponResult.build();
    assertTrue(weapon instanceof PaperWeapon);
    assertTrue(actualWeaponResult instanceof PaperWeapon.BuilderImpl);
    net.minecraft.world.item.component.Weapon handle = ((PaperWeapon) weapon).getHandle();
    assertEquals(0.0f, handle.disableBlockingForSeconds());
    assertEquals(1, handle.itemDamagePerAttack());
    assertSame(handle, ((PaperWeapon) weapon).impl());
  }

  /**
   * Test new {@link ItemComponentTypesBridgesImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ItemComponentTypesBridgesImpl}
   */
  @Test
  @DisplayName("Test new ItemComponentTypesBridgesImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ItemComponentTypesBridgesImpl.<init>()"})
  void testNewItemComponentTypesBridgesImpl() {
    // Arrange and Act
    ItemComponentTypesBridgesImpl actualItemComponentTypesBridgesImpl =
        new ItemComponentTypesBridgesImpl();

    // Assert
    assertTrue(actualItemComponentTypesBridgesImpl.fireworks() instanceof BuilderImpl);
    assertTrue(
        actualItemComponentTypesBridgesImpl.food() instanceof PaperFoodProperties.BuilderImpl);
    assertTrue(
        actualItemComponentTypesBridgesImpl.modifiers()
            instanceof PaperItemAttributeModifiers.BuilderImpl);
    assertTrue(
        actualItemComponentTypesBridgesImpl.enchantments()
            instanceof PaperItemEnchantments.BuilderImpl);
    assertTrue(actualItemComponentTypesBridgesImpl.lore() instanceof PaperItemLore.BuilderImpl);
    assertTrue(actualItemComponentTypesBridgesImpl.tool() instanceof PaperItemTool.BuilderImpl);
    assertTrue(actualItemComponentTypesBridgesImpl.weapon() instanceof PaperWeapon.BuilderImpl);
  }
}

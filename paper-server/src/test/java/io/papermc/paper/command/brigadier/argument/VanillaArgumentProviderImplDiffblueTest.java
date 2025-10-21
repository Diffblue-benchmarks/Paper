package io.papermc.paper.command.brigadier.argument;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.papermc.paper.command.brigadier.argument.VanillaArgumentProviderImpl.NativeWrapperArgumentType;
import io.papermc.paper.command.brigadier.argument.predicate.BlockInWorldPredicate;
import io.papermc.paper.command.brigadier.argument.predicate.ItemStackPredicate;
import io.papermc.paper.command.brigadier.argument.range.DoubleRangeProvider;
import io.papermc.paper.command.brigadier.argument.range.IntegerRangeProvider;
import io.papermc.paper.command.brigadier.argument.resolvers.AngleResolver;
import io.papermc.paper.command.brigadier.argument.resolvers.BlockPositionResolver;
import io.papermc.paper.command.brigadier.argument.resolvers.ColumnBlockPositionResolver;
import io.papermc.paper.command.brigadier.argument.resolvers.ColumnFinePositionResolver;
import io.papermc.paper.command.brigadier.argument.resolvers.FinePositionResolver;
import io.papermc.paper.command.brigadier.argument.resolvers.PlayerProfileListResolver;
import io.papermc.paper.command.brigadier.argument.resolvers.RotationResolver;
import io.papermc.paper.command.brigadier.argument.resolvers.selector.EntitySelectorArgumentResolver;
import io.papermc.paper.command.brigadier.argument.resolvers.selector.PlayerSelectorArgumentResolver;
import io.papermc.paper.entity.LookAnchor;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.arguments.MessageArgument.Message;
import org.bukkit.GameMode;
import org.bukkit.HeightMap;
import org.bukkit.NamespacedKey;
import org.bukkit.block.BlockState;
import org.bukkit.block.structure.Mirror;
import org.bukkit.block.structure.StructureRotation;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VanillaArgumentProviderImplDiffblueTest {
  /**
   * Test {@link VanillaArgumentProviderImpl#entity()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code 42} Remaining is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#entity()}
   */
  @Test
  @DisplayName(
      "Test entity(); then StringReader(String) with string is '42' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.entity()"})
  void testEntity_thenStringReaderWithStringIs42RemainingIsEmptyString()
      throws CommandSyntaxException {
    // Arrange and Act
    ArgumentType<EntitySelectorArgumentResolver> actualEntityResult =
        new VanillaArgumentProviderImpl().entity();
    StringReader stringReader = new StringReader("42");
    actualEntityResult.parse(stringReader);

    // Assert
    assertTrue(actualEntityResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualEntityResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("0123", ((List<String>) examples).get(1));
    assertEquals("42", stringReader.getRead());
    assertEquals("@e", ((List<String>) examples).get(2));
    assertEquals("@e[type=foo]", ((List<String>) examples).get(3));
    assertEquals("Player", ((List<String>) examples).get(0));
    assertEquals("dd12be42-52a9-4a91-a8a1-11c01849e498", ((List<String>) examples).get(4));
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(2, stringReader.getCursor());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#entity()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with {@code String} Remaining is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#entity()}
   */
  @Test
  @DisplayName("Test entity(); then StringReader(String) with 'String' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.entity()"})
  void testEntity_thenStringReaderWithStringRemainingIsEmptyString() throws CommandSyntaxException {
    // Arrange and Act
    ArgumentType<EntitySelectorArgumentResolver> actualEntityResult =
        new VanillaArgumentProviderImpl().entity();
    StringReader stringReader = new StringReader("String");
    actualEntityResult.parse(stringReader);

    // Assert
    assertTrue(actualEntityResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualEntityResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("0123", ((List<String>) examples).get(1));
    assertEquals("@e", ((List<String>) examples).get(2));
    assertEquals("@e[type=foo]", ((List<String>) examples).get(3));
    assertEquals("Player", ((List<String>) examples).get(0));
    assertEquals("String", stringReader.getRead());
    assertEquals("dd12be42-52a9-4a91-a8a1-11c01849e498", ((List<String>) examples).get(4));
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(6, stringReader.getCursor());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#entities()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code 42} Remaining is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#entities()}
   */
  @Test
  @DisplayName(
      "Test entities(); then StringReader(String) with string is '42' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.entities()"})
  void testEntities_thenStringReaderWithStringIs42RemainingIsEmptyString()
      throws CommandSyntaxException {
    // Arrange and Act
    ArgumentType<EntitySelectorArgumentResolver> actualEntitiesResult =
        new VanillaArgumentProviderImpl().entities();
    StringReader stringReader = new StringReader("42");
    actualEntitiesResult.parse(stringReader);

    // Assert
    assertTrue(actualEntitiesResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualEntitiesResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("0123", ((List<String>) examples).get(1));
    assertEquals("42", stringReader.getRead());
    assertEquals("@e", ((List<String>) examples).get(2));
    assertEquals("@e[type=foo]", ((List<String>) examples).get(3));
    assertEquals("Player", ((List<String>) examples).get(0));
    assertEquals("dd12be42-52a9-4a91-a8a1-11c01849e498", ((List<String>) examples).get(4));
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(2, stringReader.getCursor());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#entities()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with {@code String} Remaining is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#entities()}
   */
  @Test
  @DisplayName("Test entities(); then StringReader(String) with 'String' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.entities()"})
  void testEntities_thenStringReaderWithStringRemainingIsEmptyString()
      throws CommandSyntaxException {
    // Arrange and Act
    ArgumentType<EntitySelectorArgumentResolver> actualEntitiesResult =
        new VanillaArgumentProviderImpl().entities();
    StringReader stringReader = new StringReader("String");
    actualEntitiesResult.parse(stringReader);

    // Assert
    assertTrue(actualEntitiesResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualEntitiesResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("0123", ((List<String>) examples).get(1));
    assertEquals("@e", ((List<String>) examples).get(2));
    assertEquals("@e[type=foo]", ((List<String>) examples).get(3));
    assertEquals("Player", ((List<String>) examples).get(0));
    assertEquals("String", stringReader.getRead());
    assertEquals("dd12be42-52a9-4a91-a8a1-11c01849e498", ((List<String>) examples).get(4));
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(6, stringReader.getCursor());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#player()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code 42} Remaining is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#player()}
   */
  @Test
  @DisplayName(
      "Test player(); then StringReader(String) with string is '42' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.player()"})
  void testPlayer_thenStringReaderWithStringIs42RemainingIsEmptyString()
      throws CommandSyntaxException {
    // Arrange and Act
    ArgumentType<PlayerSelectorArgumentResolver> actualPlayerResult =
        new VanillaArgumentProviderImpl().player();
    StringReader stringReader = new StringReader("42");
    actualPlayerResult.parse(stringReader);

    // Assert
    assertTrue(actualPlayerResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualPlayerResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("0123", ((List<String>) examples).get(1));
    assertEquals("42", stringReader.getRead());
    assertEquals("@e", ((List<String>) examples).get(2));
    assertEquals("@e[type=foo]", ((List<String>) examples).get(3));
    assertEquals("Player", ((List<String>) examples).get(0));
    assertEquals("dd12be42-52a9-4a91-a8a1-11c01849e498", ((List<String>) examples).get(4));
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(2, stringReader.getCursor());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#player()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with {@code String} Remaining is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#player()}
   */
  @Test
  @DisplayName("Test player(); then StringReader(String) with 'String' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.player()"})
  void testPlayer_thenStringReaderWithStringRemainingIsEmptyString() throws CommandSyntaxException {
    // Arrange and Act
    ArgumentType<PlayerSelectorArgumentResolver> actualPlayerResult =
        new VanillaArgumentProviderImpl().player();
    StringReader stringReader = new StringReader("String");
    actualPlayerResult.parse(stringReader);

    // Assert
    assertTrue(actualPlayerResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualPlayerResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("0123", ((List<String>) examples).get(1));
    assertEquals("@e", ((List<String>) examples).get(2));
    assertEquals("@e[type=foo]", ((List<String>) examples).get(3));
    assertEquals("Player", ((List<String>) examples).get(0));
    assertEquals("String", stringReader.getRead());
    assertEquals("dd12be42-52a9-4a91-a8a1-11c01849e498", ((List<String>) examples).get(4));
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(6, stringReader.getCursor());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#players()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code 42} Remaining is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#players()}
   */
  @Test
  @DisplayName(
      "Test players(); then StringReader(String) with string is '42' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.players()"})
  void testPlayers_thenStringReaderWithStringIs42RemainingIsEmptyString()
      throws CommandSyntaxException {
    // Arrange and Act
    ArgumentType<PlayerSelectorArgumentResolver> actualPlayersResult =
        new VanillaArgumentProviderImpl().players();
    StringReader stringReader = new StringReader("42");
    actualPlayersResult.parse(stringReader);

    // Assert
    assertTrue(actualPlayersResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualPlayersResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("0123", ((List<String>) examples).get(1));
    assertEquals("42", stringReader.getRead());
    assertEquals("@e", ((List<String>) examples).get(2));
    assertEquals("@e[type=foo]", ((List<String>) examples).get(3));
    assertEquals("Player", ((List<String>) examples).get(0));
    assertEquals("dd12be42-52a9-4a91-a8a1-11c01849e498", ((List<String>) examples).get(4));
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(2, stringReader.getCursor());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#players()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with {@code String} Remaining is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#players()}
   */
  @Test
  @DisplayName("Test players(); then StringReader(String) with 'String' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.players()"})
  void testPlayers_thenStringReaderWithStringRemainingIsEmptyString()
      throws CommandSyntaxException {
    // Arrange and Act
    ArgumentType<PlayerSelectorArgumentResolver> actualPlayersResult =
        new VanillaArgumentProviderImpl().players();
    StringReader stringReader = new StringReader("String");
    actualPlayersResult.parse(stringReader);

    // Assert
    assertTrue(actualPlayersResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualPlayersResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("0123", ((List<String>) examples).get(1));
    assertEquals("@e", ((List<String>) examples).get(2));
    assertEquals("@e[type=foo]", ((List<String>) examples).get(3));
    assertEquals("Player", ((List<String>) examples).get(0));
    assertEquals("String", stringReader.getRead());
    assertEquals("dd12be42-52a9-4a91-a8a1-11c01849e498", ((List<String>) examples).get(4));
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(6, stringReader.getCursor());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#playerProfiles()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is empty string Read is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#playerProfiles()}
   */
  @Test
  @DisplayName(
      "Test playerProfiles(); then StringReader(String) with string is empty string Read is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.playerProfiles()"})
  void testPlayerProfiles_thenStringReaderWithStringIsEmptyStringReadIsEmptyString()
      throws CommandSyntaxException {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<PlayerProfileListResolver> actualPlayerProfilesResult =
        vanillaArgumentProviderImpl.playerProfiles();
    StringReader stringReader = new StringReader("");
    actualPlayerProfilesResult.parse(stringReader);

    // Assert
    assertTrue(vanillaArgumentProviderImpl.angle() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.axes() instanceof NativeWrapperArgumentType);
    assertTrue(
        vanillaArgumentProviderImpl.blockInWorldPredicate() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.blockPosition() instanceof NativeWrapperArgumentType);
    assertTrue(actualPlayerProfilesResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualPlayerProfilesResult.getExamples();
    assertEquals(4, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRead());
    assertEquals("", stringReader.getRemaining());
    assertEquals("", stringReader.getString());
    assertEquals(0, stringReader.getCursor());
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(0, stringReader.getTotalLength());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#playerProfiles()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with {@code String} Remaining is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#playerProfiles()}
   */
  @Test
  @DisplayName(
      "Test playerProfiles(); then StringReader(String) with 'String' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.playerProfiles()"})
  void testPlayerProfiles_thenStringReaderWithStringRemainingIsEmptyString()
      throws CommandSyntaxException {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<PlayerProfileListResolver> actualPlayerProfilesResult =
        vanillaArgumentProviderImpl.playerProfiles();
    StringReader stringReader = new StringReader("String");
    actualPlayerProfilesResult.parse(stringReader);

    // Assert
    assertTrue(vanillaArgumentProviderImpl.angle() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.axes() instanceof NativeWrapperArgumentType);
    assertTrue(
        vanillaArgumentProviderImpl.blockInWorldPredicate() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.blockPosition() instanceof NativeWrapperArgumentType);
    assertTrue(actualPlayerProfilesResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualPlayerProfilesResult.getExamples();
    assertEquals(4, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("String", stringReader.getRead());
    assertEquals("String", stringReader.getString());
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(6, stringReader.getCursor());
    assertEquals(6, stringReader.getTotalLength());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#playerProfiles()}.
   *
   * <ul>
   *   <li>Then {@link VanillaArgumentProviderImpl} (default constructor) angle Examples size is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#playerProfiles()}
   */
  @Test
  @DisplayName(
      "Test playerProfiles(); then VanillaArgumentProviderImpl (default constructor) angle Examples size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.playerProfiles()"})
  void testPlayerProfiles_thenVanillaArgumentProviderImplAngleExamplesSizeIsThree() {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<PlayerProfileListResolver> actualPlayerProfilesResult =
        vanillaArgumentProviderImpl.playerProfiles();

    // Assert
    ArgumentType<AngleResolver> angleResult = vanillaArgumentProviderImpl.angle();
    assertTrue(angleResult instanceof NativeWrapperArgumentType);
    ArgumentType<AxisSet> axesResult = vanillaArgumentProviderImpl.axes();
    assertTrue(axesResult instanceof NativeWrapperArgumentType);
    ArgumentType<BlockInWorldPredicate> blockInWorldPredicateResult =
        vanillaArgumentProviderImpl.blockInWorldPredicate();
    assertTrue(blockInWorldPredicateResult instanceof NativeWrapperArgumentType);
    ArgumentType<BlockPositionResolver> blockPositionResult =
        vanillaArgumentProviderImpl.blockPosition();
    assertTrue(blockPositionResult instanceof NativeWrapperArgumentType);
    assertTrue(actualPlayerProfilesResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = angleResult.getExamples();
    assertEquals(3, examples.size());
    assertTrue(examples instanceof List);
    Collection<String> examples2 = axesResult.getExamples();
    assertEquals(2, examples2.size());
    assertTrue(examples2 instanceof List);
    Collection<String> examples3 = blockInWorldPredicateResult.getExamples();
    assertEquals(5, examples3.size());
    assertTrue(examples3 instanceof List);
    Collection<String> examples4 = blockPositionResult.getExamples();
    assertEquals(5, examples4.size());
    assertTrue(examples4 instanceof List);
    Collection<String> examples5 = actualPlayerProfilesResult.getExamples();
    assertEquals(4, examples5.size());
    assertTrue(examples5 instanceof List);
    assertEquals("0123", ((List<String>) examples5).get(1));
    assertEquals("@e", ((List<String>) examples5).get(3));
    assertEquals("Player", ((List<String>) examples5).get(0));
    assertEquals("dd12be42-52a9-4a91-a8a1-11c01849e498", ((List<String>) examples5).get(2));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#blockPosition()}.
   *
   * <ul>
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#blockPosition()}
   */
  @Test
  @DisplayName("Test blockPosition(); then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.blockPosition()"})
  void testBlockPosition_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<BlockPositionResolver> actualBlockPositionResult =
        new VanillaArgumentProviderImpl().blockPosition();

    // Assert
    assertTrue(actualBlockPositionResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualBlockPositionResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("0 0 0", ((List<String>) examples).get(0));
    assertEquals("^ ^ ^", ((List<String>) examples).get(2));
    assertEquals("^1 ^ ^-5", ((List<String>) examples).get(3));
    assertEquals("~ ~ ~", ((List<String>) examples).get(1));
    assertEquals("~0.5 ~1 ~-5", ((List<String>) examples).get(4));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#columnBlockPosition()}.
   *
   * <ul>
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#columnBlockPosition()}
   */
  @Test
  @DisplayName("Test columnBlockPosition(); then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.columnBlockPosition()"})
  void testColumnBlockPosition_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<ColumnBlockPositionResolver> actualColumnBlockPositionResult =
        new VanillaArgumentProviderImpl().columnBlockPosition();

    // Assert
    assertTrue(actualColumnBlockPositionResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualColumnBlockPositionResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("0 0", ((List<String>) examples).get(0));
    assertEquals("^ ^", ((List<String>) examples).get(3));
    assertEquals("^-1 ^0", ((List<String>) examples).get(4));
    assertEquals("~ ~", ((List<String>) examples).get(1));
    assertEquals("~1 ~-2", ((List<String>) examples).get(2));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#blockInWorldPredicate()}.
   *
   * <ul>
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#blockInWorldPredicate()}
   */
  @Test
  @DisplayName("Test blockInWorldPredicate(); then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.blockInWorldPredicate()"})
  void testBlockInWorldPredicate_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<BlockInWorldPredicate> actualBlockInWorldPredicateResult =
        new VanillaArgumentProviderImpl().blockInWorldPredicate();

    // Assert
    assertTrue(actualBlockInWorldPredicateResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualBlockInWorldPredicateResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("#stone", ((List<String>) examples).get(3));
    assertEquals("#stone[foo=bar]{baz=nbt}", ((List<String>) examples).get(4));
    assertEquals("minecraft:stone", ((List<String>) examples).get(1));
    assertEquals("stone", ((List<String>) examples).get(0));
    assertEquals("stone[foo=bar]", ((List<String>) examples).get(2));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#finePosition(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#finePosition(boolean)}
   */
  @Test
  @DisplayName("Test finePosition(boolean); when 'true'; then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.finePosition(boolean)"})
  void testFinePosition_whenTrue_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<FinePositionResolver> actualFinePositionResult =
        new VanillaArgumentProviderImpl().finePosition(true);

    // Assert
    assertTrue(actualFinePositionResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualFinePositionResult.getExamples();
    assertEquals(6, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("0 0 0", ((List<String>) examples).get(0));
    assertEquals("0.1 -0.5 .9", ((List<String>) examples).get(4));
    assertEquals("^ ^ ^", ((List<String>) examples).get(2));
    assertEquals("^1 ^ ^-5", ((List<String>) examples).get(3));
    assertEquals("~ ~ ~", ((List<String>) examples).get(1));
    assertEquals("~0.5 ~1 ~-5", ((List<String>) examples).get(5));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#columnFinePosition(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#columnFinePosition(boolean)}
   */
  @Test
  @DisplayName(
      "Test columnFinePosition(boolean); when 'true'; then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.columnFinePosition(boolean)"})
  void testColumnFinePosition_whenTrue_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<ColumnFinePositionResolver> actualColumnFinePositionResult =
        new VanillaArgumentProviderImpl().columnFinePosition(true);

    // Assert
    assertTrue(actualColumnFinePositionResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualColumnFinePositionResult.getExamples();
    assertEquals(4, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("0 0", ((List<String>) examples).get(0));
    assertEquals("0.1 -0.5", ((List<String>) examples).get(2));
    assertEquals("~ ~", ((List<String>) examples).get(1));
    assertEquals("~1 ~-2", ((List<String>) examples).get(3));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#rotation()}.
   *
   * <ul>
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#rotation()}
   */
  @Test
  @DisplayName("Test rotation(); then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.rotation()"})
  void testRotation_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<RotationResolver> actualRotationResult =
        new VanillaArgumentProviderImpl().rotation();

    // Assert
    assertTrue(actualRotationResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualRotationResult.getExamples();
    assertEquals(3, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("0 0", ((List<String>) examples).get(0));
    assertEquals("~ ~", ((List<String>) examples).get(1));
    assertEquals("~-5 ~5", ((List<String>) examples).get(2));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#angle()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code %9$U} Remaining is
   *       {@code $U}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#angle()}
   */
  @Test
  @DisplayName("Test angle(); then StringReader(String) with string is '%9$U' Remaining is '$U'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.angle()"})
  void testAngle_thenStringReaderWithStringIs9URemainingIsU() throws CommandSyntaxException {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<AngleResolver> actualAngleResult = vanillaArgumentProviderImpl.angle();
    StringReader stringReader = new StringReader("%9$U");
    stringReader.setCursor(1);
    actualAngleResult.parse(stringReader);

    // Assert
    assertTrue(actualAngleResult instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.axes() instanceof NativeWrapperArgumentType);
    assertTrue(
        vanillaArgumentProviderImpl.blockInWorldPredicate() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.blockPosition() instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualAngleResult.getExamples();
    assertEquals(3, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("$U", stringReader.getRemaining());
    assertEquals("%9", stringReader.getRead());
    assertEquals("%9$U", stringReader.getString());
    assertEquals(2, stringReader.getCursor());
    assertEquals(2, stringReader.getRemainingLength());
    assertEquals(4, stringReader.getTotalLength());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#angle()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code 42} Remaining is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#angle()}
   */
  @Test
  @DisplayName(
      "Test angle(); then StringReader(String) with string is '42' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.angle()"})
  void testAngle_thenStringReaderWithStringIs42RemainingIsEmptyString()
      throws CommandSyntaxException {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<AngleResolver> actualAngleResult = vanillaArgumentProviderImpl.angle();
    StringReader stringReader = new StringReader("42");
    actualAngleResult.parse(stringReader);

    // Assert
    assertTrue(actualAngleResult instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.axes() instanceof NativeWrapperArgumentType);
    assertTrue(
        vanillaArgumentProviderImpl.blockInWorldPredicate() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.blockPosition() instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualAngleResult.getExamples();
    assertEquals(3, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("42", stringReader.getRead());
    assertEquals("42", stringReader.getString());
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(2, stringReader.getCursor());
    assertEquals(2, stringReader.getTotalLength());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#angle()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code 42String} Read is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#angle()}
   */
  @Test
  @DisplayName("Test angle(); then StringReader(String) with string is '42String' Read is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.angle()"})
  void testAngle_thenStringReaderWithStringIs42StringReadIs42() throws CommandSyntaxException {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<AngleResolver> actualAngleResult = vanillaArgumentProviderImpl.angle();
    StringReader stringReader = new StringReader("42String");
    stringReader.setCursor(1);
    actualAngleResult.parse(stringReader);

    // Assert
    assertTrue(actualAngleResult instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.axes() instanceof NativeWrapperArgumentType);
    assertTrue(
        vanillaArgumentProviderImpl.blockInWorldPredicate() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.blockPosition() instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualAngleResult.getExamples();
    assertEquals(3, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("42", stringReader.getRead());
    assertEquals("42String", stringReader.getString());
    assertEquals("String", stringReader.getRemaining());
    assertEquals(2, stringReader.getCursor());
    assertEquals(6, stringReader.getRemainingLength());
    assertEquals(8, stringReader.getTotalLength());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#angle()}.
   *
   * <ul>
   *   <li>Then {@link VanillaArgumentProviderImpl} (default constructor) axes Examples size is two.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#angle()}
   */
  @Test
  @DisplayName(
      "Test angle(); then VanillaArgumentProviderImpl (default constructor) axes Examples size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.angle()"})
  void testAngle_thenVanillaArgumentProviderImplAxesExamplesSizeIsTwo() {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<AngleResolver> actualAngleResult = vanillaArgumentProviderImpl.angle();

    // Assert
    assertTrue(actualAngleResult instanceof NativeWrapperArgumentType);
    ArgumentType<AxisSet> axesResult = vanillaArgumentProviderImpl.axes();
    assertTrue(axesResult instanceof NativeWrapperArgumentType);
    ArgumentType<BlockInWorldPredicate> blockInWorldPredicateResult =
        vanillaArgumentProviderImpl.blockInWorldPredicate();
    assertTrue(blockInWorldPredicateResult instanceof NativeWrapperArgumentType);
    ArgumentType<BlockPositionResolver> blockPositionResult =
        vanillaArgumentProviderImpl.blockPosition();
    assertTrue(blockPositionResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualAngleResult.getExamples();
    assertEquals(3, examples.size());
    assertTrue(examples instanceof List);
    Collection<String> examples2 = axesResult.getExamples();
    assertEquals(2, examples2.size());
    assertTrue(examples2 instanceof List);
    Collection<String> examples3 = blockInWorldPredicateResult.getExamples();
    assertEquals(5, examples3.size());
    assertTrue(examples3 instanceof List);
    Collection<String> examples4 = blockPositionResult.getExamples();
    assertEquals(5, examples4.size());
    assertTrue(examples4 instanceof List);
    assertEquals("0", ((List<String>) examples).get(0));
    assertEquals("~", ((List<String>) examples).get(1));
    assertEquals("~-5", ((List<String>) examples).get(2));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#axes()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is empty string Read is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#axes()}
   */
  @Test
  @DisplayName(
      "Test axes(); then StringReader(String) with string is empty string Read is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.axes()"})
  void testAxes_thenStringReaderWithStringIsEmptyStringReadIsEmptyString()
      throws CommandSyntaxException {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<AxisSet> actualAxesResult = vanillaArgumentProviderImpl.axes();
    StringReader stringReader = new StringReader("");
    AxisSet actualParseResult = actualAxesResult.parse(stringReader);

    // Assert
    assertTrue(vanillaArgumentProviderImpl.angle() instanceof NativeWrapperArgumentType);
    assertTrue(actualAxesResult instanceof NativeWrapperArgumentType);
    assertTrue(
        vanillaArgumentProviderImpl.blockInWorldPredicate() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.blockPosition() instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualAxesResult.getExamples();
    assertEquals(2, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRead());
    assertEquals("", stringReader.getRemaining());
    assertEquals("", stringReader.getString());
    assertEquals(0, stringReader.getCursor());
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(0, stringReader.getTotalLength());
    assertTrue(actualParseResult.isEmpty());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#axes()}.
   *
   * <ul>
   *   <li>Then {@link VanillaArgumentProviderImpl} (default constructor) angle Examples size is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#axes()}
   */
  @Test
  @DisplayName(
      "Test axes(); then VanillaArgumentProviderImpl (default constructor) angle Examples size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.axes()"})
  void testAxes_thenVanillaArgumentProviderImplAngleExamplesSizeIsThree() {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<AxisSet> actualAxesResult = vanillaArgumentProviderImpl.axes();

    // Assert
    ArgumentType<AngleResolver> angleResult = vanillaArgumentProviderImpl.angle();
    assertTrue(angleResult instanceof NativeWrapperArgumentType);
    assertTrue(actualAxesResult instanceof NativeWrapperArgumentType);
    ArgumentType<BlockInWorldPredicate> blockInWorldPredicateResult =
        vanillaArgumentProviderImpl.blockInWorldPredicate();
    assertTrue(blockInWorldPredicateResult instanceof NativeWrapperArgumentType);
    ArgumentType<BlockPositionResolver> blockPositionResult =
        vanillaArgumentProviderImpl.blockPosition();
    assertTrue(blockPositionResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = angleResult.getExamples();
    assertEquals(3, examples.size());
    assertTrue(examples instanceof List);
    Collection<String> examples2 = actualAxesResult.getExamples();
    assertEquals(2, examples2.size());
    assertTrue(examples2 instanceof List);
    Collection<String> examples3 = blockInWorldPredicateResult.getExamples();
    assertEquals(5, examples3.size());
    assertTrue(examples3 instanceof List);
    Collection<String> examples4 = blockPositionResult.getExamples();
    assertEquals(5, examples4.size());
    assertTrue(examples4 instanceof List);
    assertEquals("x", ((List<String>) examples2).get(1));
    assertEquals("xyz", ((List<String>) examples2).get(0));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#blockState()}.
   *
   * <ul>
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#blockState()}
   */
  @Test
  @DisplayName("Test blockState(); then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.blockState()"})
  void testBlockState_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<BlockState> actualBlockStateResult =
        new VanillaArgumentProviderImpl().blockState();

    // Assert
    assertTrue(actualBlockStateResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualBlockStateResult.getExamples();
    assertEquals(4, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("foo{bar=baz}", ((List<String>) examples).get(3));
    assertEquals("minecraft:stone", ((List<String>) examples).get(1));
    assertEquals("stone", ((List<String>) examples).get(0));
    assertEquals("stone[foo=bar]", ((List<String>) examples).get(2));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#itemStackPredicate()}.
   *
   * <ul>
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#itemStackPredicate()}
   */
  @Test
  @DisplayName("Test itemStackPredicate(); then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.itemStackPredicate()"})
  void testItemStackPredicate_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<ItemStackPredicate> actualItemStackPredicateResult =
        new VanillaArgumentProviderImpl().itemStackPredicate();

    // Assert
    assertTrue(actualItemStackPredicateResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualItemStackPredicateResult.getExamples();
    assertEquals(4, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("#stick", ((List<String>) examples).get(2));
    assertEquals("#stick{foo:'bar'}", ((List<String>) examples).get(3));
    assertEquals("minecraft:stick", ((List<String>) examples).get(1));
    assertEquals("stick", ((List<String>) examples).get(0));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#namedColor()}.
   *
   * <ul>
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#namedColor()}
   */
  @Test
  @DisplayName("Test namedColor(); then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.namedColor()"})
  void testNamedColor_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<NamedTextColor> actualNamedColorResult =
        new VanillaArgumentProviderImpl().namedColor();

    // Assert
    assertTrue(actualNamedColorResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualNamedColorResult.getExamples();
    assertEquals(2, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("green", ((List<String>) examples).get(1));
    assertEquals("red", ((List<String>) examples).get(0));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#hexColor()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code 4242} Remaining is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#hexColor()}
   */
  @Test
  @DisplayName(
      "Test hexColor(); then StringReader(String) with string is '4242' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.hexColor()"})
  void testHexColor_thenStringReaderWithStringIs4242RemainingIsEmptyString()
      throws CommandSyntaxException {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<TextColor> actualHexColorResult = vanillaArgumentProviderImpl.hexColor();
    StringReader stringReader = new StringReader("4242");
    stringReader.setCursor(1);
    TextColor actualParseResult = actualHexColorResult.parse(stringReader);

    // Assert
    assertTrue(vanillaArgumentProviderImpl.angle() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.axes() instanceof NativeWrapperArgumentType);
    assertTrue(
        vanillaArgumentProviderImpl.blockInWorldPredicate() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.blockPosition() instanceof NativeWrapperArgumentType);
    assertTrue(actualHexColorResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualHexColorResult.getExamples();
    assertEquals(2, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("#224422", actualParseResult.asHexString());
    assertEquals("4242", stringReader.getRead());
    assertEquals("4242", stringReader.getString());
    assertEquals("TextColorImpl", actualParseResult.examinableName());
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(34, actualParseResult.blue());
    assertEquals(4, stringReader.getCursor());
    assertEquals(4, stringReader.getTotalLength());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#hexColor()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code 424242} Remaining is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#hexColor()}
   */
  @Test
  @DisplayName(
      "Test hexColor(); then StringReader(String) with string is '424242' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.hexColor()"})
  void testHexColor_thenStringReaderWithStringIs424242RemainingIsEmptyString()
      throws CommandSyntaxException {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<TextColor> actualHexColorResult = vanillaArgumentProviderImpl.hexColor();
    StringReader stringReader = new StringReader("424242");
    TextColor actualParseResult = actualHexColorResult.parse(stringReader);

    // Assert
    assertTrue(vanillaArgumentProviderImpl.angle() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.axes() instanceof NativeWrapperArgumentType);
    assertTrue(
        vanillaArgumentProviderImpl.blockInWorldPredicate() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.blockPosition() instanceof NativeWrapperArgumentType);
    assertTrue(actualHexColorResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualHexColorResult.getExamples();
    assertEquals(2, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("#424242", actualParseResult.asHexString());
    assertEquals("424242", stringReader.getRead());
    assertEquals("424242", stringReader.getString());
    assertEquals("TextColorImpl", actualParseResult.examinableName());
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(6, stringReader.getCursor());
    assertEquals(6, stringReader.getTotalLength());
    assertEquals(66, actualParseResult.blue());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#hexColor()}.
   *
   * <ul>
   *   <li>Then {@link VanillaArgumentProviderImpl} (default constructor) angle Examples size is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#hexColor()}
   */
  @Test
  @DisplayName(
      "Test hexColor(); then VanillaArgumentProviderImpl (default constructor) angle Examples size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.hexColor()"})
  void testHexColor_thenVanillaArgumentProviderImplAngleExamplesSizeIsThree() {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<TextColor> actualHexColorResult = vanillaArgumentProviderImpl.hexColor();

    // Assert
    ArgumentType<AngleResolver> angleResult = vanillaArgumentProviderImpl.angle();
    assertTrue(angleResult instanceof NativeWrapperArgumentType);
    ArgumentType<AxisSet> axesResult = vanillaArgumentProviderImpl.axes();
    assertTrue(axesResult instanceof NativeWrapperArgumentType);
    ArgumentType<BlockInWorldPredicate> blockInWorldPredicateResult =
        vanillaArgumentProviderImpl.blockInWorldPredicate();
    assertTrue(blockInWorldPredicateResult instanceof NativeWrapperArgumentType);
    ArgumentType<BlockPositionResolver> blockPositionResult =
        vanillaArgumentProviderImpl.blockPosition();
    assertTrue(blockPositionResult instanceof NativeWrapperArgumentType);
    assertTrue(actualHexColorResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = angleResult.getExamples();
    assertEquals(3, examples.size());
    assertTrue(examples instanceof List);
    Collection<String> examples2 = axesResult.getExamples();
    assertEquals(2, examples2.size());
    assertTrue(examples2 instanceof List);
    Collection<String> examples3 = blockInWorldPredicateResult.getExamples();
    assertEquals(5, examples3.size());
    assertTrue(examples3 instanceof List);
    Collection<String> examples4 = blockPositionResult.getExamples();
    assertEquals(5, examples4.size());
    assertTrue(examples4 instanceof List);
    Collection<String> examples5 = actualHexColorResult.getExamples();
    assertEquals(2, examples5.size());
    assertTrue(examples5 instanceof List);
    assertEquals("F00", ((List<String>) examples5).get(0));
    assertEquals("FF0000", ((List<String>) examples5).get(1));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#component()}.
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#component()}
   */
  @Test
  @DisplayName("Test component()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.component()"})
  void testComponent() {
    // Arrange and Act
    ArgumentType<Component> actualComponentResult = new VanillaArgumentProviderImpl().component();

    // Assert
    assertTrue(actualComponentResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualComponentResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("'hello world'", ((List<String>) examples).get(1));
    assertEquals("[\"\"]", ((List<String>) examples).get(4));
    assertEquals("\"\"", ((List<String>) examples).get(2));
    assertEquals("\"hello world\"", ((List<String>) examples).get(0));
    assertEquals("{text:\"hello world\"}", ((List<String>) examples).get(3));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#signedMessage()}.
   *
   * <ul>
   *   <li>Then parse {@link StringReader#StringReader(String)} with {@code String} return {@link
   *       SignedMessageResolverImpl}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#signedMessage()}
   */
  @Test
  @DisplayName(
      "Test signedMessage(); then parse StringReader(String) with 'String' return SignedMessageResolverImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.signedMessage()"})
  void testSignedMessage_thenParseStringReaderWithStringReturnSignedMessageResolverImpl()
      throws CommandSyntaxException {
    // Arrange and Act
    ArgumentType<SignedMessageResolver> actualSignedMessageResult =
        new VanillaArgumentProviderImpl().signedMessage();
    StringReader stringReader = new StringReader("String");
    SignedMessageResolver actualParseResult = actualSignedMessageResult.parse(stringReader);

    // Assert
    assertTrue(actualParseResult instanceof SignedMessageResolverImpl);
    assertTrue(actualSignedMessageResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualSignedMessageResult.getExamples();
    assertEquals(4, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("@e", ((List<String>) examples).get(2));
    assertEquals("Hello @p :)", ((List<String>) examples).get(3));
    assertEquals("Hello world!", ((List<String>) examples).get(0));
    assertEquals("String", stringReader.getRead());
    Message messageResult = ((SignedMessageResolverImpl) actualParseResult).message();
    assertEquals("String", messageResult.text());
    assertEquals("foo", ((List<String>) examples).get(1));
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(0, messageResult.parts().length);
    assertEquals(6, stringReader.getCursor());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#scoreboardDisplaySlot()}.
   *
   * <ul>
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#scoreboardDisplaySlot()}
   */
  @Test
  @DisplayName("Test scoreboardDisplaySlot(); then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.scoreboardDisplaySlot()"})
  void testScoreboardDisplaySlot_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<DisplaySlot> actualScoreboardDisplaySlotResult =
        new VanillaArgumentProviderImpl().scoreboardDisplaySlot();

    // Assert
    assertTrue(actualScoreboardDisplaySlotResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualScoreboardDisplaySlotResult.getExamples();
    assertEquals(2, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("foo.bar", ((List<String>) examples).get(1));
    assertEquals("sidebar", ((List<String>) examples).get(0));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#namespacedKey()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code 42} Remaining is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#namespacedKey()}
   */
  @Test
  @DisplayName(
      "Test namespacedKey(); then StringReader(String) with string is '42' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.namespacedKey()"})
  void testNamespacedKey_thenStringReaderWithStringIs42RemainingIsEmptyString()
      throws CommandSyntaxException {
    // Arrange and Act
    ArgumentType<NamespacedKey> actualNamespacedKeyResult =
        new VanillaArgumentProviderImpl().namespacedKey();
    StringReader stringReader = new StringReader("42");
    NamespacedKey actualParseResult = actualNamespacedKeyResult.parse(stringReader);

    // Assert
    assertEquals("", stringReader.getRemaining());
    assertEquals("42", stringReader.getRead());
    assertEquals("42", actualParseResult.getKey());
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(2, stringReader.getCursor());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#namespacedKey()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with {@code String} Read is empty string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#namespacedKey()}
   */
  @Test
  @DisplayName("Test namespacedKey(); then StringReader(String) with 'String' Read is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.namespacedKey()"})
  void testNamespacedKey_thenStringReaderWithStringReadIsEmptyString()
      throws CommandSyntaxException {
    // Arrange and Act
    ArgumentType<NamespacedKey> actualNamespacedKeyResult =
        new VanillaArgumentProviderImpl().namespacedKey();
    StringReader stringReader = new StringReader("String");
    NamespacedKey actualParseResult = actualNamespacedKeyResult.parse(stringReader);

    // Assert
    assertEquals("", stringReader.getRead());
    assertEquals("", actualParseResult.getKey());
    assertEquals("String", stringReader.getRemaining());
    assertEquals(0, stringReader.getCursor());
    assertEquals(6, stringReader.getRemainingLength());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#namespacedKey()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with {@code String} Remaining is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#namespacedKey()}
   */
  @Test
  @DisplayName(
      "Test namespacedKey(); then StringReader(String) with 'String' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.namespacedKey()"})
  void testNamespacedKey_thenStringReaderWithStringRemainingIsEmptyString()
      throws CommandSyntaxException {
    // Arrange and Act
    ArgumentType<NamespacedKey> actualNamespacedKeyResult =
        new VanillaArgumentProviderImpl().namespacedKey();
    StringReader stringReader = new StringReader("String");
    stringReader.setCursor(1);
    NamespacedKey actualParseResult = actualNamespacedKeyResult.parse(stringReader);

    // Assert
    assertEquals("", stringReader.getRemaining());
    assertEquals("String", stringReader.getRead());
    assertEquals("tring", actualParseResult.getKey());
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(6, stringReader.getCursor());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#key()}.
   *
   * <ul>
   *   <li>Then parse {@link StringReader#StringReader(String)} with string is {@code 42} return
   *       {@link NamespacedKey}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#key()}
   */
  @Test
  @DisplayName(
      "Test key(); then parse StringReader(String) with string is '42' return NamespacedKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.key()"})
  void testKey_thenParseStringReaderWithStringIs42ReturnNamespacedKey()
      throws CommandSyntaxException {
    // Arrange and Act
    ArgumentType<Key> actualKeyResult = new VanillaArgumentProviderImpl().key();
    StringReader stringReader = new StringReader("42");
    Key actualParseResult = actualKeyResult.parse(stringReader);

    // Assert
    assertTrue(actualParseResult instanceof NamespacedKey);
    assertEquals("", stringReader.getRemaining());
    assertEquals("42", stringReader.getRead());
    assertEquals("42", ((NamespacedKey) actualParseResult).getKey());
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(2, stringReader.getCursor());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#key()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with {@code String} Read is empty string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#key()}
   */
  @Test
  @DisplayName("Test key(); then StringReader(String) with 'String' Read is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.key()"})
  void testKey_thenStringReaderWithStringReadIsEmptyString() throws CommandSyntaxException {
    // Arrange and Act
    ArgumentType<Key> actualKeyResult = new VanillaArgumentProviderImpl().key();
    StringReader stringReader = new StringReader("String");
    Key actualParseResult = actualKeyResult.parse(stringReader);

    // Assert
    assertTrue(actualParseResult instanceof NamespacedKey);
    assertEquals("", stringReader.getRead());
    assertEquals("", ((NamespacedKey) actualParseResult).getKey());
    assertEquals("String", stringReader.getRemaining());
    assertEquals(0, stringReader.getCursor());
    assertEquals(6, stringReader.getRemainingLength());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#key()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with {@code String} Remaining is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#key()}
   */
  @Test
  @DisplayName("Test key(); then StringReader(String) with 'String' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.key()"})
  void testKey_thenStringReaderWithStringRemainingIsEmptyString() throws CommandSyntaxException {
    // Arrange and Act
    ArgumentType<Key> actualKeyResult = new VanillaArgumentProviderImpl().key();
    StringReader stringReader = new StringReader("String");
    stringReader.setCursor(1);
    Key actualParseResult = actualKeyResult.parse(stringReader);

    // Assert
    assertTrue(actualParseResult instanceof NamespacedKey);
    assertEquals("", stringReader.getRemaining());
    assertEquals("String", stringReader.getRead());
    assertEquals("tring", ((NamespacedKey) actualParseResult).getKey());
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(6, stringReader.getCursor());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#integerRange()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code 42} Remaining is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#integerRange()}
   */
  @Test
  @DisplayName(
      "Test integerRange(); then StringReader(String) with string is '42' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.integerRange()"})
  void testIntegerRange_thenStringReaderWithStringIs42RemainingIsEmptyString()
      throws CommandSyntaxException {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<IntegerRangeProvider> actualIntegerRangeResult =
        vanillaArgumentProviderImpl.integerRange();
    StringReader stringReader = new StringReader("42");
    actualIntegerRangeResult.parse(stringReader);

    // Assert
    assertTrue(vanillaArgumentProviderImpl.angle() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.axes() instanceof NativeWrapperArgumentType);
    assertTrue(
        vanillaArgumentProviderImpl.blockInWorldPredicate() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.blockPosition() instanceof NativeWrapperArgumentType);
    assertTrue(actualIntegerRangeResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualIntegerRangeResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("42", stringReader.getRead());
    assertEquals("42", stringReader.getString());
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(2, stringReader.getCursor());
    assertEquals(2, stringReader.getTotalLength());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#integerRange()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code 42String} Read is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#integerRange()}
   */
  @Test
  @DisplayName(
      "Test integerRange(); then StringReader(String) with string is '42String' Read is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.integerRange()"})
  void testIntegerRange_thenStringReaderWithStringIs42StringReadIs42()
      throws CommandSyntaxException {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<IntegerRangeProvider> actualIntegerRangeResult =
        vanillaArgumentProviderImpl.integerRange();
    StringReader stringReader = new StringReader("42String");
    actualIntegerRangeResult.parse(stringReader);

    // Assert
    assertTrue(vanillaArgumentProviderImpl.angle() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.axes() instanceof NativeWrapperArgumentType);
    assertTrue(
        vanillaArgumentProviderImpl.blockInWorldPredicate() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.blockPosition() instanceof NativeWrapperArgumentType);
    assertTrue(actualIntegerRangeResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualIntegerRangeResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("42", stringReader.getRead());
    assertEquals("42String", stringReader.getString());
    assertEquals("String", stringReader.getRemaining());
    assertEquals(2, stringReader.getCursor());
    assertEquals(6, stringReader.getRemainingLength());
    assertEquals(8, stringReader.getTotalLength());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#integerRange()}.
   *
   * <ul>
   *   <li>Then {@link VanillaArgumentProviderImpl} (default constructor) angle Examples size is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#integerRange()}
   */
  @Test
  @DisplayName(
      "Test integerRange(); then VanillaArgumentProviderImpl (default constructor) angle Examples size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.integerRange()"})
  void testIntegerRange_thenVanillaArgumentProviderImplAngleExamplesSizeIsThree() {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<IntegerRangeProvider> actualIntegerRangeResult =
        vanillaArgumentProviderImpl.integerRange();

    // Assert
    ArgumentType<AngleResolver> angleResult = vanillaArgumentProviderImpl.angle();
    assertTrue(angleResult instanceof NativeWrapperArgumentType);
    ArgumentType<AxisSet> axesResult = vanillaArgumentProviderImpl.axes();
    assertTrue(axesResult instanceof NativeWrapperArgumentType);
    ArgumentType<BlockInWorldPredicate> blockInWorldPredicateResult =
        vanillaArgumentProviderImpl.blockInWorldPredicate();
    assertTrue(blockInWorldPredicateResult instanceof NativeWrapperArgumentType);
    ArgumentType<BlockPositionResolver> blockPositionResult =
        vanillaArgumentProviderImpl.blockPosition();
    assertTrue(blockPositionResult instanceof NativeWrapperArgumentType);
    assertTrue(actualIntegerRangeResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = angleResult.getExamples();
    assertEquals(3, examples.size());
    assertTrue(examples instanceof List);
    Collection<String> examples2 = axesResult.getExamples();
    assertEquals(2, examples2.size());
    assertTrue(examples2 instanceof List);
    Collection<String> examples3 = blockInWorldPredicateResult.getExamples();
    assertEquals(5, examples3.size());
    assertTrue(examples3 instanceof List);
    Collection<String> examples4 = blockPositionResult.getExamples();
    assertEquals(5, examples4.size());
    assertTrue(examples4 instanceof List);
    Collection<String> examples5 = actualIntegerRangeResult.getExamples();
    assertEquals(5, examples5.size());
    assertTrue(examples5 instanceof List);
    assertEquals("-100..", ((List<String>) examples5).get(3));
    assertEquals("-5", ((List<String>) examples5).get(2));
    assertEquals("..100", ((List<String>) examples5).get(4));
    assertEquals("0", ((List<String>) examples5).get(1));
    assertEquals("0..5", ((List<String>) examples5).get(0));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#doubleRange()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code %9$U} Remaining is
   *       {@code $U}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#doubleRange()}
   */
  @Test
  @DisplayName(
      "Test doubleRange(); then StringReader(String) with string is '%9$U' Remaining is '$U'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.doubleRange()"})
  void testDoubleRange_thenStringReaderWithStringIs9URemainingIsU() throws CommandSyntaxException {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<DoubleRangeProvider> actualDoubleRangeResult =
        vanillaArgumentProviderImpl.doubleRange();
    StringReader stringReader = new StringReader("%9$U");
    stringReader.setCursor(1);
    actualDoubleRangeResult.parse(stringReader);

    // Assert
    assertTrue(vanillaArgumentProviderImpl.angle() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.axes() instanceof NativeWrapperArgumentType);
    assertTrue(
        vanillaArgumentProviderImpl.blockInWorldPredicate() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.blockPosition() instanceof NativeWrapperArgumentType);
    assertTrue(actualDoubleRangeResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualDoubleRangeResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("$U", stringReader.getRemaining());
    assertEquals("%9", stringReader.getRead());
    assertEquals("%9$U", stringReader.getString());
    assertEquals(2, stringReader.getCursor());
    assertEquals(2, stringReader.getRemainingLength());
    assertEquals(4, stringReader.getTotalLength());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#doubleRange()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code 42} Remaining is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#doubleRange()}
   */
  @Test
  @DisplayName(
      "Test doubleRange(); then StringReader(String) with string is '42' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.doubleRange()"})
  void testDoubleRange_thenStringReaderWithStringIs42RemainingIsEmptyString()
      throws CommandSyntaxException {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<DoubleRangeProvider> actualDoubleRangeResult =
        vanillaArgumentProviderImpl.doubleRange();
    StringReader stringReader = new StringReader("42");
    actualDoubleRangeResult.parse(stringReader);

    // Assert
    assertTrue(vanillaArgumentProviderImpl.angle() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.axes() instanceof NativeWrapperArgumentType);
    assertTrue(
        vanillaArgumentProviderImpl.blockInWorldPredicate() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.blockPosition() instanceof NativeWrapperArgumentType);
    assertTrue(actualDoubleRangeResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualDoubleRangeResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("42", stringReader.getRead());
    assertEquals("42", stringReader.getString());
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(2, stringReader.getCursor());
    assertEquals(2, stringReader.getTotalLength());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#doubleRange()}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code 42String} Read is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#doubleRange()}
   */
  @Test
  @DisplayName(
      "Test doubleRange(); then StringReader(String) with string is '42String' Read is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.doubleRange()"})
  void testDoubleRange_thenStringReaderWithStringIs42StringReadIs42()
      throws CommandSyntaxException {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<DoubleRangeProvider> actualDoubleRangeResult =
        vanillaArgumentProviderImpl.doubleRange();
    StringReader stringReader = new StringReader("42String");
    actualDoubleRangeResult.parse(stringReader);

    // Assert
    assertTrue(vanillaArgumentProviderImpl.angle() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.axes() instanceof NativeWrapperArgumentType);
    assertTrue(
        vanillaArgumentProviderImpl.blockInWorldPredicate() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.blockPosition() instanceof NativeWrapperArgumentType);
    assertTrue(actualDoubleRangeResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualDoubleRangeResult.getExamples();
    assertEquals(5, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("42", stringReader.getRead());
    assertEquals("42String", stringReader.getString());
    assertEquals("String", stringReader.getRemaining());
    assertEquals(2, stringReader.getCursor());
    assertEquals(6, stringReader.getRemainingLength());
    assertEquals(8, stringReader.getTotalLength());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#doubleRange()}.
   *
   * <ul>
   *   <li>Then {@link VanillaArgumentProviderImpl} (default constructor) angle Examples size is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#doubleRange()}
   */
  @Test
  @DisplayName(
      "Test doubleRange(); then VanillaArgumentProviderImpl (default constructor) angle Examples size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.doubleRange()"})
  void testDoubleRange_thenVanillaArgumentProviderImplAngleExamplesSizeIsThree() {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<DoubleRangeProvider> actualDoubleRangeResult =
        vanillaArgumentProviderImpl.doubleRange();

    // Assert
    ArgumentType<AngleResolver> angleResult = vanillaArgumentProviderImpl.angle();
    assertTrue(angleResult instanceof NativeWrapperArgumentType);
    ArgumentType<AxisSet> axesResult = vanillaArgumentProviderImpl.axes();
    assertTrue(axesResult instanceof NativeWrapperArgumentType);
    ArgumentType<BlockInWorldPredicate> blockInWorldPredicateResult =
        vanillaArgumentProviderImpl.blockInWorldPredicate();
    assertTrue(blockInWorldPredicateResult instanceof NativeWrapperArgumentType);
    ArgumentType<BlockPositionResolver> blockPositionResult =
        vanillaArgumentProviderImpl.blockPosition();
    assertTrue(blockPositionResult instanceof NativeWrapperArgumentType);
    assertTrue(actualDoubleRangeResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = angleResult.getExamples();
    assertEquals(3, examples.size());
    assertTrue(examples instanceof List);
    Collection<String> examples2 = axesResult.getExamples();
    assertEquals(2, examples2.size());
    assertTrue(examples2 instanceof List);
    Collection<String> examples3 = blockInWorldPredicateResult.getExamples();
    assertEquals(5, examples3.size());
    assertTrue(examples3 instanceof List);
    Collection<String> examples4 = blockPositionResult.getExamples();
    assertEquals(5, examples4.size());
    assertTrue(examples4 instanceof List);
    Collection<String> examples5 = actualDoubleRangeResult.getExamples();
    assertEquals(5, examples5.size());
    assertTrue(examples5 instanceof List);
    assertEquals("-100.76..", ((List<String>) examples5).get(3));
    assertEquals("-5.4", ((List<String>) examples5).get(2));
    assertEquals("..100", ((List<String>) examples5).get(4));
    assertEquals("0", ((List<String>) examples5).get(1));
    assertEquals("0..5.2", ((List<String>) examples5).get(0));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#gameMode()}.
   *
   * <ul>
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#gameMode()}
   */
  @Test
  @DisplayName("Test gameMode(); then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.gameMode()"})
  void testGameMode_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<GameMode> actualGameModeResult = new VanillaArgumentProviderImpl().gameMode();

    // Assert
    assertTrue(actualGameModeResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualGameModeResult.getExamples();
    assertEquals(2, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("creative", ((List<String>) examples).get(1));
    assertEquals("survival", ((List<String>) examples).get(0));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#heightMap()}.
   *
   * <ul>
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#heightMap()}
   */
  @Test
  @DisplayName("Test heightMap(); then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.heightMap()"})
  void testHeightMap_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<HeightMap> actualHeightMapResult = new VanillaArgumentProviderImpl().heightMap();

    // Assert
    assertTrue(actualHeightMapResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualHeightMapResult.getExamples();
    assertEquals(2, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("ocean_floor", ((List<String>) examples).get(1));
    assertEquals("world_surface", ((List<String>) examples).get(0));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#uuid()}.
   *
   * <ul>
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#uuid()}
   */
  @Test
  @DisplayName("Test uuid(); then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.uuid()"})
  void testUuid_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<UUID> actualUuidResult = new VanillaArgumentProviderImpl().uuid();

    // Assert
    assertTrue(actualUuidResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualUuidResult.getExamples();
    assertEquals(1, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("dd12be42-52a9-4a91-a8a1-11c01849e498", ((List<String>) examples).get(0));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#objectiveCriteria()}.
   *
   * <ul>
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#objectiveCriteria()}
   */
  @Test
  @DisplayName("Test objectiveCriteria(); then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.objectiveCriteria()"})
  void testObjectiveCriteria_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<Criteria> actualObjectiveCriteriaResult =
        new VanillaArgumentProviderImpl().objectiveCriteria();

    // Assert
    assertTrue(actualObjectiveCriteriaResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualObjectiveCriteriaResult.getExamples();
    assertEquals(3, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("foo", ((List<String>) examples).get(0));
    assertEquals("foo.bar.baz", ((List<String>) examples).get(1));
    assertEquals("minecraft:foo", ((List<String>) examples).get(2));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#entityAnchor()}.
   *
   * <ul>
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#entityAnchor()}
   */
  @Test
  @DisplayName("Test entityAnchor(); then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.entityAnchor()"})
  void testEntityAnchor_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<LookAnchor> actualEntityAnchorResult =
        new VanillaArgumentProviderImpl().entityAnchor();

    // Assert
    assertTrue(actualEntityAnchorResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualEntityAnchorResult.getExamples();
    assertEquals(2, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("eyes", ((List<String>) examples).get(0));
    assertEquals("feet", ((List<String>) examples).get(1));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#time(int)}.
   *
   * <ul>
   *   <li>Then {@link StringReader#StringReader(String)} with string is {@code 42} Remaining is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#time(int)}
   */
  @Test
  @DisplayName(
      "Test time(int); then StringReader(String) with string is '42' Remaining is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.time(int)"})
  void testTime_thenStringReaderWithStringIs42RemainingIsEmptyString()
      throws CommandSyntaxException {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<Integer> actualTimeResult = vanillaArgumentProviderImpl.time(1);
    StringReader stringReader = new StringReader("42");
    Integer actualParseResult = actualTimeResult.parse(stringReader);

    // Assert
    assertTrue(vanillaArgumentProviderImpl.angle() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.axes() instanceof NativeWrapperArgumentType);
    assertTrue(
        vanillaArgumentProviderImpl.blockInWorldPredicate() instanceof NativeWrapperArgumentType);
    assertTrue(vanillaArgumentProviderImpl.blockPosition() instanceof NativeWrapperArgumentType);
    assertTrue(actualTimeResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualTimeResult.getExamples();
    assertEquals(4, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("", stringReader.getRemaining());
    assertEquals("42", stringReader.getRead());
    assertEquals("42", stringReader.getString());
    assertEquals(0, stringReader.getRemainingLength());
    assertEquals(2, stringReader.getCursor());
    assertEquals(2, stringReader.getTotalLength());
    assertEquals(42, actualParseResult.intValue());
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#time(int)}.
   *
   * <ul>
   *   <li>Then {@link VanillaArgumentProviderImpl} (default constructor) angle Examples size is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#time(int)}
   */
  @Test
  @DisplayName(
      "Test time(int); then VanillaArgumentProviderImpl (default constructor) angle Examples size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.time(int)"})
  void testTime_thenVanillaArgumentProviderImplAngleExamplesSizeIsThree() {
    // Arrange
    VanillaArgumentProviderImpl vanillaArgumentProviderImpl = new VanillaArgumentProviderImpl();

    // Act
    ArgumentType<Integer> actualTimeResult = vanillaArgumentProviderImpl.time(1);

    // Assert
    ArgumentType<AngleResolver> angleResult = vanillaArgumentProviderImpl.angle();
    assertTrue(angleResult instanceof NativeWrapperArgumentType);
    ArgumentType<AxisSet> axesResult = vanillaArgumentProviderImpl.axes();
    assertTrue(axesResult instanceof NativeWrapperArgumentType);
    ArgumentType<BlockInWorldPredicate> blockInWorldPredicateResult =
        vanillaArgumentProviderImpl.blockInWorldPredicate();
    assertTrue(blockInWorldPredicateResult instanceof NativeWrapperArgumentType);
    ArgumentType<BlockPositionResolver> blockPositionResult =
        vanillaArgumentProviderImpl.blockPosition();
    assertTrue(blockPositionResult instanceof NativeWrapperArgumentType);
    assertTrue(actualTimeResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = angleResult.getExamples();
    assertEquals(3, examples.size());
    assertTrue(examples instanceof List);
    Collection<String> examples2 = axesResult.getExamples();
    assertEquals(2, examples2.size());
    assertTrue(examples2 instanceof List);
    Collection<String> examples3 = blockInWorldPredicateResult.getExamples();
    assertEquals(5, examples3.size());
    assertTrue(examples3 instanceof List);
    Collection<String> examples4 = blockPositionResult.getExamples();
    assertEquals(5, examples4.size());
    assertTrue(examples4 instanceof List);
    Collection<String> examples5 = actualTimeResult.getExamples();
    assertEquals(4, examples5.size());
    assertTrue(examples5 instanceof List);
    assertEquals("0", ((List<String>) examples5).get(3));
    assertEquals("0d", ((List<String>) examples5).get(0));
    assertEquals("0s", ((List<String>) examples5).get(1));
    assertEquals("0t", ((List<String>) examples5).get(2));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#templateMirror()}.
   *
   * <ul>
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#templateMirror()}
   */
  @Test
  @DisplayName("Test templateMirror(); then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.templateMirror()"})
  void testTemplateMirror_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<Mirror> actualTemplateMirrorResult =
        new VanillaArgumentProviderImpl().templateMirror();

    // Assert
    assertTrue(actualTemplateMirrorResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualTemplateMirrorResult.getExamples();
    assertEquals(2, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("left_right", ((List<String>) examples).get(1));
    assertEquals("none", ((List<String>) examples).get(0));
  }

  /**
   * Test {@link VanillaArgumentProviderImpl#templateRotation()}.
   *
   * <ul>
   *   <li>Then return {@link NativeWrapperArgumentType}.
   * </ul>
   *
   * <p>Method under test: {@link VanillaArgumentProviderImpl#templateRotation()}
   */
  @Test
  @DisplayName("Test templateRotation(); then return NativeWrapperArgumentType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArgumentType VanillaArgumentProviderImpl.templateRotation()"})
  void testTemplateRotation_thenReturnNativeWrapperArgumentType() {
    // Arrange and Act
    ArgumentType<StructureRotation> actualTemplateRotationResult =
        new VanillaArgumentProviderImpl().templateRotation();

    // Assert
    assertTrue(actualTemplateRotationResult instanceof NativeWrapperArgumentType);
    Collection<String> examples = actualTemplateRotationResult.getExamples();
    assertEquals(2, examples.size());
    assertTrue(examples instanceof List);
    assertEquals("clockwise_90", ((List<String>) examples).get(1));
    assertEquals("none", ((List<String>) examples).get(0));
  }
}

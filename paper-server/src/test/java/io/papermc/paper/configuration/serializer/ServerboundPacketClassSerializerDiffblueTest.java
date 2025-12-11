package io.papermc.paper.configuration.serializer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import io.leangen.geantyref.TypeToken;
import io.papermc.paper.configuration.serializer.ServerboundPacketClassSerializer.PacketInfo;
import java.lang.reflect.Type;
import java.util.function.Predicate;
import net.minecraft.network.protocol.Packet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class ServerboundPacketClassSerializerDiffblueTest {
  /**
   * Test new {@link ServerboundPacketClassSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ServerboundPacketClassSerializer}
   */
  @Test
  @DisplayName("Test new ServerboundPacketClassSerializer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServerboundPacketClassSerializer.<init>()"})
  void testNewServerboundPacketClassSerializer() {
    // Arrange, Act and Assert
    TypeToken<Class<? extends Packet<?>>> typeResult =
        new ServerboundPacketClassSerializer().type();
    assertEquals(
        "java.lang.Class<? extends net.minecraft.network.protocol.Packet<?>>",
        typeResult.getType().getTypeName());
    assertNull(typeResult.getAnnotatedType().getAnnotatedOwnerType());
  }

  /**
   * Test {@link ServerboundPacketClassSerializer#deserialize(Type, Object)} with {@code Type},
   * {@code Object}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link ServerboundPacketClassSerializer#deserialize(Type, Object)}
   */
  @Test
  @DisplayName(
      "Test deserialize(Type, Object) with 'Type', 'Object'; when forty-two; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class ServerboundPacketClassSerializer.deserialize(Type, Object)"})
  void testDeserializeWithTypeObject_whenFortyTwo_thenThrowSerializationException()
      throws SerializationException {
    // Arrange
    ServerboundPacketClassSerializer serverboundPacketClassSerializer =
        new ServerboundPacketClassSerializer();

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () -> serverboundPacketClassSerializer.deserialize(new PlaceholderForType(1), 42));
  }

  /**
   * Test {@link ServerboundPacketClassSerializer#deserialize(Type, Object)} with {@code Type},
   * {@code Object}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link ServerboundPacketClassSerializer#deserialize(Type, Object)}
   */
  @Test
  @DisplayName(
      "Test deserialize(Type, Object) with 'Type', 'Object'; when minus one; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class ServerboundPacketClassSerializer.deserialize(Type, Object)"})
  void testDeserializeWithTypeObject_whenMinusOne_thenThrowSerializationException()
      throws SerializationException {
    // Arrange
    ServerboundPacketClassSerializer serverboundPacketClassSerializer =
        new ServerboundPacketClassSerializer();

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () -> serverboundPacketClassSerializer.deserialize(new PlaceholderForType(1), -1));
  }

  /**
   * Test {@link ServerboundPacketClassSerializer#deserialize(Type, Object)} with {@code Type},
   * {@code Object}.
   *
   * <ul>
   *   <li>When {@code Packet}.
   * </ul>
   *
   * <p>Method under test: {@link ServerboundPacketClassSerializer#deserialize(Type, Object)}
   */
  @Test
  @DisplayName(
      "Test deserialize(Type, Object) with 'Type', 'Object'; when 'net.minecraft.network.protocol.Packet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class ServerboundPacketClassSerializer.deserialize(Type, Object)"})
  void testDeserializeWithTypeObject_whenNetMinecraftNetworkProtocolPacket()
      throws SerializationException {
    // Arrange
    ServerboundPacketClassSerializer serverboundPacketClassSerializer =
        new ServerboundPacketClassSerializer();
    PlaceholderForType type = new PlaceholderForType(1);
    Class<Packet> clazz = Packet.class;
    PacketInfo packetInfo = new PacketInfo(clazz, null);

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () -> serverboundPacketClassSerializer.deserialize(type, packetInfo));
  }

  /**
   * Test {@link ServerboundPacketClassSerializer#deserialize(Type, Object)} with {@code Type},
   * {@code Object}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link ServerboundPacketClassSerializer#deserialize(Type, Object)}
   */
  @Test
  @DisplayName(
      "Test deserialize(Type, Object) with 'Type', 'Object'; when one; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class ServerboundPacketClassSerializer.deserialize(Type, Object)"})
  void testDeserializeWithTypeObject_whenOne_thenThrowSerializationException()
      throws SerializationException {
    // Arrange
    ServerboundPacketClassSerializer serverboundPacketClassSerializer =
        new ServerboundPacketClassSerializer();

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () -> serverboundPacketClassSerializer.deserialize(new PlaceholderForType(1), 1));
  }

  /**
   * Test {@link ServerboundPacketClassSerializer#deserialize(Type, Object)} with {@code Type},
   * {@code Object}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link ServerboundPacketClassSerializer#deserialize(Type, Object)}
   */
  @Test
  @DisplayName("Test deserialize(Type, Object) with 'Type', 'Object'; when WILDCARD_OBJECT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class ServerboundPacketClassSerializer.deserialize(Type, Object)"})
  void testDeserializeWithTypeObject_whenWildcard_object() throws SerializationException {
    // Arrange
    ServerboundPacketClassSerializer serverboundPacketClassSerializer =
        new ServerboundPacketClassSerializer();

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () ->
            serverboundPacketClassSerializer.deserialize(
                new PlaceholderForType(1), ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link ServerboundPacketClassSerializer#deserialize(Type, Object)} with {@code Type},
   * {@code Object}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link SerializationException}.
   * </ul>
   *
   * <p>Method under test: {@link ServerboundPacketClassSerializer#deserialize(Type, Object)}
   */
  @Test
  @DisplayName(
      "Test deserialize(Type, Object) with 'Type', 'Object'; when zero; then throw SerializationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class ServerboundPacketClassSerializer.deserialize(Type, Object)"})
  void testDeserializeWithTypeObject_whenZero_thenThrowSerializationException()
      throws SerializationException {
    // Arrange
    ServerboundPacketClassSerializer serverboundPacketClassSerializer =
        new ServerboundPacketClassSerializer();

    // Act and Assert
    assertThrows(
        SerializationException.class,
        () -> serverboundPacketClassSerializer.deserialize(new PlaceholderForType(1), 0));
  }

  /**
   * Test PacketInfo {@link PacketInfo#packetClass()}.
   *
   * <p>Method under test: {@link PacketInfo#packetClass()}
   */
  @Test
  @DisplayName("Test PacketInfo packetClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class PacketInfo.packetClass()"})
  void testPacketInfoPacketClass() {
    // Arrange
    Class<Packet> clazz = Packet.class;
    PacketInfo packetInfo = new PacketInfo(clazz, null);

    // Act
    Class<? extends Packet<?>> actualPacketClassResult = packetInfo.packetClass();

    // Assert
    Class<Packet> expectedPacketClassResult = Packet.class;
    assertEquals(expectedPacketClassResult, actualPacketClassResult);
  }

  /**
   * Test {@link ServerboundPacketClassSerializer#serialize(Class, Predicate)} with {@code Class},
   * {@code Predicate}.
   *
   * <ul>
   *   <li>When {@code Packet}.
   * </ul>
   *
   * <p>Method under test: {@link ServerboundPacketClassSerializer#serialize(Class, Predicate)}
   */
  @Test
  @DisplayName(
      "Test serialize(Class, Predicate) with 'Class', 'Predicate'; when 'net.minecraft.network.protocol.Packet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ServerboundPacketClassSerializer.serialize(Class, Predicate)"})
  void testSerializeWithClassPredicate_whenNetMinecraftNetworkProtocolPacket() {
    // Arrange
    ServerboundPacketClassSerializer serverboundPacketClassSerializer =
        new ServerboundPacketClassSerializer();
    Class<Packet> forNameResult = Packet.class;

    // Act and Assert
    assertNull(
        serverboundPacketClassSerializer.serialize(
            (Class<Packet<?>>) (Class) forNameResult, mock(Predicate.class)));
  }

  /**
   * Test {@link ServerboundPacketClassSerializer#serialize(Class, Predicate)} with {@code Class},
   * {@code Predicate}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ServerboundPacketClassSerializer#serialize(Class, Predicate)}
   */
  @Test
  @DisplayName("Test serialize(Class, Predicate) with 'Class', 'Predicate'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ServerboundPacketClassSerializer.serialize(Class, Predicate)"})
  void testSerializeWithClassPredicate_whenNull() {
    // Arrange, Act and Assert
    assertNull(
        new ServerboundPacketClassSerializer()
            .serialize((Class<Packet<?>>) (Class) null, mock(Predicate.class)));
  }
}

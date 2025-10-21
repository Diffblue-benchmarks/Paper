package org.bukkit.permissions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PermissionDiffblueTest {
  /**
   * Test {@link Permission#Permission(String, String)}.
   *
   * <ul>
   *   <li>Then return Description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#Permission(String, String)}
   */
  @Test
  @DisplayName(
      "Test new Permission(String, String); then return Description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.<init>(String, String)"})
  void testNewPermission_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange and Act
    Permission actualPermission =
        new Permission("Name", "The characteristics of someone or something");

    // Assert
    assertEquals("Name", actualPermission.getName());
    assertEquals("The characteristics of someone or something", actualPermission.getDescription());
    assertEquals(PermissionDefault.OP, actualPermission.getDefault());
    assertTrue(actualPermission.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#Permission(String, String, Map)}.
   *
   * <ul>
   *   <li>Then return Description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#Permission(String, String, Map)}
   */
  @Test
  @DisplayName(
      "Test new Permission(String, String, Map); then return Description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.<init>(String, String, Map)"})
  void testNewPermission_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething2() {
    // Arrange and Act
    Permission actualPermission =
        new Permission("Name", "The characteristics of someone or something", new HashMap<>());

    // Assert
    assertEquals("Name", actualPermission.getName());
    assertEquals("The characteristics of someone or something", actualPermission.getDescription());
    assertEquals(PermissionDefault.OP, actualPermission.getDefault());
    assertTrue(actualPermission.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#Permission(String, String, PermissionDefault)}.
   *
   * <ul>
   *   <li>Then return Description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#Permission(String, String, PermissionDefault)}
   */
  @Test
  @DisplayName(
      "Test new Permission(String, String, PermissionDefault); then return Description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.<init>(String, String, PermissionDefault)"})
  void testNewPermission_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething3() {
    // Arrange and Act
    Permission actualPermission =
        new Permission(
            "Name", "The characteristics of someone or something", PermissionDefault.TRUE);

    // Assert
    assertEquals("Name", actualPermission.getName());
    assertEquals("The characteristics of someone or something", actualPermission.getDescription());
    assertEquals(PermissionDefault.TRUE, actualPermission.getDefault());
    assertTrue(actualPermission.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#Permission(String, String, PermissionDefault, Map)}.
   *
   * <ul>
   *   <li>Then return Description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#Permission(String, String, PermissionDefault, Map)}
   */
  @Test
  @DisplayName(
      "Test new Permission(String, String, PermissionDefault, Map); then return Description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.<init>(String, String, PermissionDefault, Map)"})
  void testNewPermission_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething4() {
    // Arrange and Act
    Permission actualPermission =
        new Permission(
            "Name",
            "The characteristics of someone or something",
            PermissionDefault.TRUE,
            new HashMap<>());

    // Assert
    assertEquals("Name", actualPermission.getName());
    assertEquals("The characteristics of someone or something", actualPermission.getDescription());
    assertEquals(PermissionDefault.TRUE, actualPermission.getDefault());
    assertTrue(actualPermission.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#Permission(String, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Description is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Permission#Permission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test new Permission(String, Map); when HashMap(); then return Description is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.<init>(String, Map)"})
  void testNewPermission_whenHashMap_thenReturnDescriptionIsEmptyString() {
    // Arrange and Act
    Permission actualPermission = new Permission("Name", new HashMap<>());

    // Assert
    assertEquals("", actualPermission.getDescription());
    assertEquals("Name", actualPermission.getName());
    assertEquals(PermissionDefault.OP, actualPermission.getDefault());
    assertTrue(actualPermission.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#Permission(String, PermissionDefault)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return Default is {@code OP}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#Permission(String, PermissionDefault)}
   */
  @Test
  @DisplayName(
      "Test new Permission(String, PermissionDefault); when 'Name'; then return Default is 'OP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.<init>(String, PermissionDefault)"})
  void testNewPermission_whenName_thenReturnDefaultIsOp() {
    // Arrange and Act
    Permission actualPermission = new Permission("Name", (PermissionDefault) null);

    // Assert
    assertEquals("", actualPermission.getDescription());
    assertEquals("Name", actualPermission.getName());
    assertEquals(PermissionDefault.OP, actualPermission.getDefault());
    assertTrue(actualPermission.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#Permission(String, PermissionDefault, Map)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return Default is {@code OP}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#Permission(String, PermissionDefault, Map)}
   */
  @Test
  @DisplayName(
      "Test new Permission(String, PermissionDefault, Map); when 'Name'; then return Default is 'OP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.<init>(String, PermissionDefault, Map)"})
  void testNewPermission_whenName_thenReturnDefaultIsOp2() {
    // Arrange and Act
    Permission actualPermission = new Permission("Name", (PermissionDefault) null, null);

    // Assert
    assertEquals("", actualPermission.getDescription());
    assertEquals("Name", actualPermission.getName());
    assertEquals(PermissionDefault.OP, actualPermission.getDefault());
    assertTrue(actualPermission.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#Permission(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return Description is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Permission#Permission(String)}
   */
  @Test
  @DisplayName("Test new Permission(String); when 'Name'; then return Description is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.<init>(String)"})
  void testNewPermission_whenName_thenReturnDescriptionIsEmptyString() {
    // Arrange and Act
    Permission actualPermission = new Permission("Name");

    // Assert
    assertEquals("", actualPermission.getDescription());
    assertEquals("Name", actualPermission.getName());
    assertEquals(PermissionDefault.OP, actualPermission.getDefault());
    assertTrue(actualPermission.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#Permission(String, String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return Description is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Permission#Permission(String, String)}
   */
  @Test
  @DisplayName(
      "Test new Permission(String, String); when 'Name'; then return Description is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.<init>(String, String)"})
  void testNewPermission_whenName_thenReturnDescriptionIsEmptyString2() {
    // Arrange and Act
    Permission actualPermission = new Permission("Name", (String) null);

    // Assert
    assertEquals("", actualPermission.getDescription());
    assertEquals("Name", actualPermission.getName());
    assertEquals(PermissionDefault.OP, actualPermission.getDefault());
    assertTrue(actualPermission.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#Permission(String, String, Map)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return Description is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Permission#Permission(String, String, Map)}
   */
  @Test
  @DisplayName(
      "Test new Permission(String, String, Map); when 'Name'; then return Description is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.<init>(String, String, Map)"})
  void testNewPermission_whenName_thenReturnDescriptionIsEmptyString3() {
    // Arrange and Act
    Permission actualPermission =
        new Permission("Name", (String) null, (Map<String, Boolean>) null);

    // Assert
    assertEquals("", actualPermission.getDescription());
    assertEquals("Name", actualPermission.getName());
    assertEquals(PermissionDefault.OP, actualPermission.getDefault());
    assertTrue(actualPermission.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#Permission(String, String, PermissionDefault)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return Description is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Permission#Permission(String, String, PermissionDefault)}
   */
  @Test
  @DisplayName(
      "Test new Permission(String, String, PermissionDefault); when 'Name'; then return Description is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.<init>(String, String, PermissionDefault)"})
  void testNewPermission_whenName_thenReturnDescriptionIsEmptyString4() {
    // Arrange and Act
    Permission actualPermission = new Permission("Name", (String) null, (PermissionDefault) null);

    // Assert
    assertEquals("", actualPermission.getDescription());
    assertEquals("Name", actualPermission.getName());
    assertEquals(PermissionDefault.OP, actualPermission.getDefault());
    assertTrue(actualPermission.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#Permission(String, String, PermissionDefault, Map)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return Description is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Permission#Permission(String, String, PermissionDefault, Map)}
   */
  @Test
  @DisplayName(
      "Test new Permission(String, String, PermissionDefault, Map); when 'Name'; then return Description is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.<init>(String, String, PermissionDefault, Map)"})
  void testNewPermission_whenName_thenReturnDescriptionIsEmptyString5() {
    // Arrange and Act
    Permission actualPermission = new Permission("Name", null, null, null);

    // Assert
    assertEquals("", actualPermission.getDescription());
    assertEquals("Name", actualPermission.getName());
    assertEquals(PermissionDefault.OP, actualPermission.getDefault());
    assertTrue(actualPermission.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#Permission(String, Map)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return Description is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Permission#Permission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test new Permission(String, Map); when 'Name'; then return Description is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.<init>(String, Map)"})
  void testNewPermission_whenName_thenReturnDescriptionIsEmptyString6() {
    // Arrange and Act
    Permission actualPermission = new Permission("Name", (Map<String, Boolean>) null);

    // Assert
    assertEquals("", actualPermission.getDescription());
    assertEquals("Name", actualPermission.getName());
    assertEquals(PermissionDefault.OP, actualPermission.getDefault());
    assertTrue(actualPermission.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#Permission(String, PermissionDefault)}.
   *
   * <ul>
   *   <li>When {@code TRUE}.
   *   <li>Then return Default is {@code TRUE}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#Permission(String, PermissionDefault)}
   */
  @Test
  @DisplayName(
      "Test new Permission(String, PermissionDefault); when 'TRUE'; then return Default is 'TRUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.<init>(String, PermissionDefault)"})
  void testNewPermission_whenTrue_thenReturnDefaultIsTrue() {
    // Arrange and Act
    Permission actualPermission = new Permission("Name", PermissionDefault.TRUE);

    // Assert
    assertEquals("", actualPermission.getDescription());
    assertEquals("Name", actualPermission.getName());
    assertEquals(PermissionDefault.TRUE, actualPermission.getDefault());
    assertTrue(actualPermission.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#Permission(String, PermissionDefault, Map)}.
   *
   * <ul>
   *   <li>When {@code TRUE}.
   *   <li>Then return Default is {@code TRUE}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#Permission(String, PermissionDefault, Map)}
   */
  @Test
  @DisplayName(
      "Test new Permission(String, PermissionDefault, Map); when 'TRUE'; then return Default is 'TRUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.<init>(String, PermissionDefault, Map)"})
  void testNewPermission_whenTrue_thenReturnDefaultIsTrue2() {
    // Arrange and Act
    Permission actualPermission = new Permission("Name", PermissionDefault.TRUE, new HashMap<>());

    // Assert
    assertEquals("", actualPermission.getDescription());
    assertEquals("Name", actualPermission.getName());
    assertEquals(PermissionDefault.TRUE, actualPermission.getDefault());
    assertTrue(actualPermission.getChildren().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Permission#getChildren()}
   *   <li>{@link Permission#getDefault()}
   *   <li>{@link Permission#getDescription()}
   *   <li>{@link Permission#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map Permission.getChildren()",
    "PermissionDefault Permission.getDefault()",
    "String Permission.getDescription()",
    "String Permission.getName()"
  })
  void testGettersAndSetters() {
    // Arrange
    Permission permission = new Permission("Name");

    // Act
    Map<String, Boolean> actualChildren = permission.getChildren();
    PermissionDefault actualDefault = permission.getDefault();
    String actualDescription = permission.getDescription();

    // Assert
    assertEquals("", actualDescription);
    assertEquals("Name", permission.getName());
    assertEquals(PermissionDefault.OP, actualDefault);
    assertTrue(actualChildren.isEmpty());
  }

  /**
   * Test {@link Permission#setDescription(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link Permission#Permission(String)} with {@code Name} Description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#setDescription(String)}
   */
  @Test
  @DisplayName(
      "Test setDescription(String); when '42'; then Permission(String) with 'Name' Description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.setDescription(String)"})
  void testSetDescription_when42_thenPermissionWithNameDescriptionIs42() {
    // Arrange
    Permission permission = new Permission("Name");

    // Act
    permission.setDescription("42");

    // Assert
    assertEquals("42", permission.getDescription());
  }

  /**
   * Test {@link Permission#setDescription(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link Permission#Permission(String)} with {@code Name} Description is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Permission#setDescription(String)}
   */
  @Test
  @DisplayName(
      "Test setDescription(String); when 'null'; then Permission(String) with 'Name' Description is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Permission.setDescription(String)"})
  void testSetDescription_whenNull_thenPermissionWithNameDescriptionIsEmptyString() {
    // Arrange
    Permission permission = new Permission("Name");

    // Act
    permission.setDescription(null);

    // Assert that nothing has changed
    assertEquals("", permission.getDescription());
  }

  /**
   * Test {@link Permission#loadPermissions(Map, String, PermissionDefault)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermissions(Map, String, PermissionDefault)}
   */
  @Test
  @DisplayName(
      "Test loadPermissions(Map, String, PermissionDefault); when HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Permission.loadPermissions(Map, String, PermissionDefault)"})
  void testLoadPermissions_whenHashMap_thenReturnEmpty() {
    // Arrange and Act
    List<Permission> actualLoadPermissionsResult =
        Permission.loadPermissions(new HashMap<>(), "An error occurred", PermissionDefault.TRUE);

    // Assert
    assertTrue(actualLoadPermissionsResult.isEmpty());
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();

    ArrayList<Permission> output = new ArrayList<>();
    output.add(new Permission("Name cannot be null"));

    // Act
    Permission actualLoadPermissionResult =
        Permission.loadPermission("Name", data, PermissionDefault.TRUE, output);

    // Assert
    assertEquals("", actualLoadPermissionResult.getDescription());
    assertEquals("Name", actualLoadPermissionResult.getName());
    assertEquals(PermissionDefault.TRUE, actualLoadPermissionResult.getDefault());
    assertTrue(actualLoadPermissionResult.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput2() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();

    ArrayList<Permission> output = new ArrayList<>();
    output.add(new Permission("Name cannot be null"));
    output.add(new Permission("Name cannot be null"));

    // Act
    Permission actualLoadPermissionResult =
        Permission.loadPermission("Name", data, PermissionDefault.TRUE, output);

    // Assert
    assertEquals("", actualLoadPermissionResult.getDescription());
    assertEquals("Name", actualLoadPermissionResult.getName());
    assertEquals(PermissionDefault.TRUE, actualLoadPermissionResult.getDefault());
    assertTrue(actualLoadPermissionResult.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code default} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'; given '42'; when HashMap() 'default' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput_given42_whenHashMapDefaultIs42() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();
    data.put("default", "42");
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Permission.loadPermission("Name", data, null, null));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <ul>
   *   <li>Given {@code [^a-z!]}.
   *   <li>When {@link HashMap#HashMap()} {@code default} is {@code [^a-z!]}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'; given '[^a-z!]'; when HashMap() 'default' is '[^a-z!]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput_givenAZ_whenHashMapDefaultIsAZ() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();
    data.put("default", "[^a-z!]");
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Permission.loadPermission("Name", data, null, null));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <ul>
   *   <li>Given {@code Data cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'; given 'Data cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput_givenDataCannotBeNull() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();
    data.put("default", "Data cannot be null");
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Permission.loadPermission("Name", data, null, null));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <ul>
   *   <li>Given {@code 'default' key contained unknown value}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'; given ''default' key contained unknown value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput_givenDefaultKeyContainedUnknownValue() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();
    data.put("default", "'default' key contained unknown value");
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Permission.loadPermission("Name", data, null, null));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <ul>
   *   <li>Given {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'; given MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput_givenMin_value() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();
    data.put("default", Integer.MIN_VALUE);
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Permission.loadPermission("Name", data, null, null));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <ul>
   *   <li>Given minus one.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'; given minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput_givenMinusOne() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();
    data.put("default", -1);
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Permission.loadPermission("Name", data, null, null));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <ul>
   *   <li>Given {@code Name cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'; given 'Name cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput_givenNameCannotBeNull() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();
    data.put("default", "Name cannot be null");
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Permission.loadPermission("Name", data, null, null));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashMap#HashMap()} {@code children} is one.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'; given one; when HashMap() 'children' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput_givenOne_whenHashMapChildrenIsOne() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();
    data.put("default", null);
    data.put("children", 1);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Permission.loadPermission("Name", data, null, null));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashMap#HashMap()} {@code default} is one.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'; given one; when HashMap() 'default' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput_givenOne_whenHashMapDefaultIsOne() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();
    data.put("default", 1);
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Permission.loadPermission("Name", data, null, null));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashMap#HashMap()} {@code default} is zero.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'; given zero; when HashMap() 'default' is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput_givenZero_whenHashMapDefaultIsZero() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();
    data.put("default", 0);
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Permission.loadPermission("Name", data, null, null));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <ul>
   *   <li>Then return Description is {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'; then return Description is 'Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput_thenReturnDescriptionIsData() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();
    data.put("default", null);
    data.put("children", null);
    data.put("description", "Data");

    // Act
    Permission actualLoadPermissionResult = Permission.loadPermission("Name", data, null, null);

    // Assert
    assertEquals("Data", actualLoadPermissionResult.getDescription());
    assertEquals("Name", actualLoadPermissionResult.getName());
    assertEquals(PermissionDefault.OP, actualLoadPermissionResult.getDefault());
    assertTrue(actualLoadPermissionResult.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Default is {@code OP}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'; when ArrayList(); then return Default is 'OP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput_whenArrayList_thenReturnDefaultIsOp() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();

    // Act
    Permission actualLoadPermissionResult =
        Permission.loadPermission("Name", data, null, new ArrayList<>());

    // Assert
    assertEquals("", actualLoadPermissionResult.getDescription());
    assertEquals("Name", actualLoadPermissionResult.getName());
    assertEquals(PermissionDefault.OP, actualLoadPermissionResult.getDefault());
    assertTrue(actualLoadPermissionResult.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Default is {@code TRUE}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'; when ArrayList(); then return Default is 'TRUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput_whenArrayList_thenReturnDefaultIsTrue() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();

    // Act
    Permission actualLoadPermissionResult =
        Permission.loadPermission("Name", data, PermissionDefault.TRUE, new ArrayList<>());

    // Assert
    assertEquals("", actualLoadPermissionResult.getDescription());
    assertEquals("Name", actualLoadPermissionResult.getName());
    assertEquals(PermissionDefault.TRUE, actualLoadPermissionResult.getDefault());
    assertTrue(actualLoadPermissionResult.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#loadPermission(String, Map, PermissionDefault, List)} with {@code name},
   * {@code data}, {@code def}, {@code output}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code default} is {@code default}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map, PermissionDefault, List)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map, PermissionDefault, List) with 'name', 'data', 'def', 'output'; when HashMap() 'default' is 'default'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map, PermissionDefault, List)"})
  void testLoadPermissionWithNameDataDefOutput_whenHashMapDefaultIsDefault() {
    // Arrange
    HashMap<Object, Object> data = new HashMap<>();
    data.put("default", "default");
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Permission.loadPermission("Name", data, null, null));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code default} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given '42'; when HashMap() 'default' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_given42_whenHashMapDefaultIs42() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", "42");
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Permission.loadPermission("Name", data));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given {@code [^a-z!]}.
   *   <li>When {@link HashMap#HashMap()} {@code default} is {@code [^a-z!]}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given '[^a-z!]'; when HashMap() 'default' is '[^a-z!]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenAZ_whenHashMapDefaultIsAZ() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", "[^a-z!]");
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Permission.loadPermission("Name", data));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link HashMap#HashMap()} {@code default} is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given ArrayList(); when HashMap() 'default' is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenArrayList_whenHashMapDefaultIsArrayList() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", new ArrayList<>());
    data.put("children", "Data");
    data.put("description", null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Permission.loadPermission("Name", data));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given {@code 'children' key is of wrong type}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given ''children' key is of wrong type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenChildrenKeyIsOfWrongType() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", "'children' key is of wrong type");
    data.put("children", "Data");
    data.put("description", null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Permission.loadPermission("Name", data));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given {@code Data cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName("Test loadPermission(String, Map) with 'name', 'data'; given 'Data cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenDataCannotBeNull() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", "Data cannot be null");
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Permission.loadPermission("Name", data));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given {@code 'default' key contained unknown value}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given ''default' key contained unknown value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenDefaultKeyContainedUnknownValue() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", "'default' key contained unknown value");
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Permission.loadPermission("Name", data));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code children} is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given HashMap() '42' is '42'; when HashMap() 'children' is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenHashMap42Is42_whenHashMapChildrenIsHashMap() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", "42");

    HashMap<String, Object> data = new HashMap<>();
    data.put("default", null);
    data.put("children", objectObjectMap);
    data.put("description", null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Permission.loadPermission("Name", data));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@link HashMap#HashMap()}.
   *   <li>Then return Children {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given HashMap() '42' is HashMap(); then return Children '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenHashMap42IsHashMap_thenReturnChildren42() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", new HashMap<>());

    HashMap<String, Object> data = new HashMap<>();
    data.put("default", null);
    data.put("children", objectObjectMap);
    data.put("description", null);

    // Act
    Permission actualLoadPermissionResult = Permission.loadPermission("Name", data);

    // Assert
    assertEquals("", actualLoadPermissionResult.getDescription());
    assertEquals("Name", actualLoadPermissionResult.getName());
    Map<String, Boolean> children = actualLoadPermissionResult.getChildren();
    assertEquals(1, children.size());
    assertEquals(PermissionDefault.OP, actualLoadPermissionResult.getDefault());
    assertTrue(children.get("42"));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code true}.
   *   <li>Then return Children {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given HashMap() '42' is 'true'; then return Children '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenHashMap42IsTrue_thenReturnChildren42() {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", true);

    HashMap<String, Object> data = new HashMap<>();
    data.put("default", null);
    data.put("children", objectObjectMap);
    data.put("description", null);

    // Act
    Permission actualLoadPermissionResult = Permission.loadPermission("Name", data);

    // Assert
    assertEquals("", actualLoadPermissionResult.getDescription());
    Map<String, Boolean> children = actualLoadPermissionResult.getChildren();
    assertEquals(1, children.size());
    assertTrue(children.get("42"));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then return Children Empty.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given HashMap(); then return Children Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenHashMap_thenReturnChildrenEmpty() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", null);
    data.put("children", new HashMap<>());
    data.put("description", null);

    // Act
    Permission actualLoadPermissionResult = Permission.loadPermission("Name", data);

    // Assert
    assertEquals("", actualLoadPermissionResult.getDescription());
    assertEquals("Name", actualLoadPermissionResult.getName());
    assertEquals(PermissionDefault.OP, actualLoadPermissionResult.getDefault());
    assertTrue(actualLoadPermissionResult.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link HashMap#HashMap()} {@code default} is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given HashMap(); when HashMap() 'default' is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenHashMap_whenHashMapDefaultIsHashMap() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", new HashMap<>());
    data.put("children", "Data");
    data.put("description", null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Permission.loadPermission("Name", data));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code Data}.
   *   <li>Then return Children {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given LinkedHashSet() add 'Data'; then return Children 'Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenLinkedHashSetAddData_thenReturnChildrenData() {
    // Arrange
    LinkedHashSet<Object> objectSet = new LinkedHashSet<>();
    objectSet.add("Data");

    HashMap<String, Object> data = new HashMap<>();
    data.put("default", null);
    data.put("children", objectSet);
    data.put("description", null);

    // Act
    Permission actualLoadPermissionResult = Permission.loadPermission("Name", data);

    // Assert
    assertEquals("", actualLoadPermissionResult.getDescription());
    assertEquals("Name", actualLoadPermissionResult.getName());
    Map<String, Boolean> children = actualLoadPermissionResult.getChildren();
    assertEquals(1, children.size());
    assertEquals(PermissionDefault.OP, actualLoadPermissionResult.getDefault());
    assertTrue(children.get("Data"));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given LinkedHashSet() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenLinkedHashSetAddNull() {
    // Arrange
    LinkedHashSet<Object> objectSet = new LinkedHashSet<>();
    objectSet.add(null);

    HashMap<String, Object> data = new HashMap<>();
    data.put("default", null);
    data.put("children", objectSet);
    data.put("description", null);

    // Act
    Permission actualLoadPermissionResult = Permission.loadPermission("Name", data);

    // Assert
    assertEquals("", actualLoadPermissionResult.getDescription());
    assertEquals("Name", actualLoadPermissionResult.getName());
    assertEquals(PermissionDefault.OP, actualLoadPermissionResult.getDefault());
    assertTrue(actualLoadPermissionResult.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given {@link Integer#MIN_VALUE}.
   *   <li>When {@link HashMap#HashMap()} {@code default} is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given MIN_VALUE; when HashMap() 'default' is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenMin_value_whenHashMapDefaultIsMin_value() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", Integer.MIN_VALUE);
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Permission.loadPermission("Name", data));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link HashMap#HashMap()} {@code default} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given minus one; when HashMap() 'default' is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenMinusOne_whenHashMapDefaultIsMinusOne() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", -1);
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Permission.loadPermission("Name", data));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given {@code Name cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName("Test loadPermission(String, Map) with 'name', 'data'; given 'Name cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenNameCannotBeNull() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", "Name cannot be null");
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Permission.loadPermission("Name", data));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashMap#HashMap()} {@code default} is one.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given one; when HashMap() 'default' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenOne_whenHashMapDefaultIsOne() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", 1);
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Permission.loadPermission("Name", data));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashMap#HashMap()} {@code default} is zero.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; given zero; when HashMap() 'default' is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_givenZero_whenHashMapDefaultIsZero() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", 0);
    data.put("children", null);
    data.put("description", "Data");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Permission.loadPermission("Name", data));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>Then return Description is {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; then return Description is 'Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_thenReturnDescriptionIsData() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", null);
    data.put("children", null);
    data.put("description", "Data");

    // Act
    Permission actualLoadPermissionResult = Permission.loadPermission("Name", data);

    // Assert
    assertEquals("Data", actualLoadPermissionResult.getDescription());
    assertEquals("Name", actualLoadPermissionResult.getName());
    assertEquals(PermissionDefault.OP, actualLoadPermissionResult.getDefault());
    assertTrue(actualLoadPermissionResult.getChildren().isEmpty());
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code children} is {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; when HashMap() 'children' is 'Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_whenHashMapChildrenIsData() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", null);
    data.put("children", "Data");
    data.put("description", null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Permission.loadPermission("Name", data));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code default} is {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; when HashMap() 'default' is 'Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_whenHashMapDefaultIsData() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("default", "Data");
    data.put("children", null);
    data.put("description", null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Permission.loadPermission("Name", data));
  }

  /**
   * Test {@link Permission#loadPermission(String, Map)} with {@code name}, {@code data}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Children Empty.
   * </ul>
   *
   * <p>Method under test: {@link Permission#loadPermission(String, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPermission(String, Map) with 'name', 'data'; when HashMap(); then return Children Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Permission Permission.loadPermission(String, Map)"})
  void testLoadPermissionWithNameData_whenHashMap_thenReturnChildrenEmpty() {
    // Arrange and Act
    Permission actualLoadPermissionResult = Permission.loadPermission("Name", new HashMap<>());

    // Assert
    assertEquals("", actualLoadPermissionResult.getDescription());
    assertEquals("Name", actualLoadPermissionResult.getName());
    assertEquals(PermissionDefault.OP, actualLoadPermissionResult.getDefault());
    assertTrue(actualLoadPermissionResult.getChildren().isEmpty());
  }
}

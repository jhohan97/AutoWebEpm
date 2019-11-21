Feature: Update profile on EPM page
  As a user of the service
  I need to update my personal information
  to receive offers and discounts on the services provided

  Background: navegate to login page
    Given The user login on the page
      | id |
      | 1  |

  Scenario Outline: Smoke test
    When  The user edits his profile
    Then He visualized all fields
      | Field   |
      | <Field> |
    Examples:
      | Field                 |
      | ddlTipoIdentificacion |
      | txtCorreo             |
      | txtIdentificacion     |
      | txtClave              |
      | txtConfirmarClave     |
      | txtNombres            |
      | txtApellidos          |
      | txtDireccion          |
      | txtTelefono           |
      | txtCelular            |
      | txtCorreoAlterno      |

  Scenario Outline: Verify that the email fields, type of document and identification number are blocked or disabled for editing
    When  The user edits his profile
    Then He cannot edit the fields of mail, document type and identification number
      | Field   | Atribute   |
      | <Field> | <Atribute> |
    Examples:
      | Field                 | Atribute |
      | ddlTipoIdentificacion | true     |
      | txtCorreo             | true     |
      | txtIdentificacion     | true     |


  Scenario Outline:
  Validate that the size of the fields: Names, Surname, address, telephone, cell phone, alternative email, have the capacity requested in the acceptance criteria.
    When  The user edits his profile
    Then He cannot enter more data in the fields
      | Field   | Atribute   |
      | <Field> | <Atribute> |
    Examples:
      | Field            | Atribute |
      | txtNombres       | 100      |
      | txtApellidos     | 100      |
      | txtDireccion     | 200      |
      | txtTelefono      | 50       |
      | txtCelular       | 15       |
      | txtCorreoAlterno | 100      |


  Scenario Outline:
  Validate that if any mandatory field is not filled in and saved, an alert is displayed indicating that you must complete the fields.
    When The user diligently edits the information
      | id   |
      | <id> |
    Then He visualized a message indicanding that you must complete the fields.
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 4  |

  Scenario: Validate that when filling out all the fields and the button to save changes, a message is displayed indicating that the information was updated.
    When The user diligently edits the information
      | id |
      | 5  |
    Then He visualized a message indicanding that the information has been updated.




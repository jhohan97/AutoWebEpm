Feature: Update profile on EPM page
  As a user of the service
  I need to update my personal information
  to receive offers and discounts on the services provided

  Background: navegate to login page
    Given The user login on the page
      | usserName              | Password     |
      | marcomayo289@gmail.com | Contra123456 |

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
    Then He cannot edit the fields of correo , tipo de documento y número de identificación
      | Field   | Atribute   |
      | <Field> | <Atribute> |
    Examples:
      | Field                 | Atribute |
      | ddlTipoIdentificacion | true     |
      | txtCorreo             | true     |
      | txtIdentificacion     | true     |

  @this
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



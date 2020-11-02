Feature:Add new payee under pay bills
  Background:
    Given the user is logged in
    And the user navigate to "Pay Bills"


  Scenario: Add a new payee
    Given Add New Payee tab
    And creates new payee using following information
      |Payee Name     | The Law Offices of Hyde, Price & Scharks|
      |Payee Address  | 100 Same st, Anytown, USA, 10001        |
      |Account        | Checking                                |
      |Payee details  | XYZ account                             |
    Then message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed


  Scenario Outline: Add a new payee  <Paye Name>
    Given Add New Payee tab
    When the user write "<Payee Name>" in name box
    And the user write "<Payee Address>" in address box
    And the user write "<Account>" in account box
    And the user write "<Payee details>" in details box
    Then message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed

    Examples:
      |Payee Name                               |Payee Address                            |Account  |Payee details|
      |The Law Offices of Hyde, Price & Scharks | 100 Same st, Anytown, USA, 10001        |Checking |XYZ account  |
      |Rida                                     | Hacı Seyit Ali Mah. 213.Sok.            |Deposit  |XXX account  |
      |Osman                                    | Gevrekli Mah.                           |Checking |YYY account  |



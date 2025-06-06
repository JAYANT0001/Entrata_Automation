# Entrata Automation Testing Project

## Overview
This project is a comprehensive Selenium-based automation framework designed to test key functionalities of the Entrata web application. It follows the Page Object Model (POM) design pattern for modularity and scalability.

## Key Features

### Test Cases Covered
- `HeadersFunctionality.java` — Validates header navigation and UI elements.
- `InteractWithFirstProductAndFillForm.java` — Automates interaction with the first product and form submission workflow (without actual submission).
- `VerifyApplicationLaunchTest.java` — Confirms successful launch and load of the Entrata application.
- `VerifyBusinessSuitesNavigation.java` — Verifies navigation through business suite links.
- `VerifyFooterLinks.java` — Ensures all footer links are visible, unique, and clickable.

### Page Object Model (POM)
- Page locators and actions are separated from tests into the `pages` package.
- Improves readability, maintainability, and scalability.

### Logging
- Implemented using Log4j2.
- Logs are printed to the console and stored as files in the `/logs` directory.

### Test Reporting
- HTML reports are generated using ExtentReports.
- Reports include pass/fail status, detailed steps, logs, and screenshots.

### Screenshots on Failure
- Automatically captures screenshots on test failure.
- Saved in the `/screenshots` folder with timestamped filenames.

## Project Structure
Entrata_Automation/
├── logs/                     # Log files (auto-generated)
├── reports/                  # HTML test reports (auto-generated)
├── screenshots/              # Screenshots for failed tests
├── src/
│   ├── main/                 # Common reusable code (if any)
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── entrata/
│       │           ├── pages/       # Page Object classes
│       │           ├── tests/       # Test classes
│       │           └── Utilities/   # Logger, Screenshot, etc.
│       └── resources/
│           └── log4j2.xml           # Logging configuration
├── .gitignore               # Git ignored files and folders
├── pom.xml                 # Maven build configuration
└── testNG.xml              # TestNG test suite configuration
## Prerequisites

- Java 11 or higher
- Maven installed and configured in system PATH
- Chrome browser installed
- Compatible ChromeDriver in system PATH
- Internet access for site and dependency resolution

## How to Run the Tests

### 1. Clone the repository
git clone https://github.com/JAYANT0001/Entrata_Automation.git
cd Entrata_Automation

### 2. Execute the tests
mvn clean test

### 3. After execution
- View logs in the terminal
- Check `/logs` for saved log files
- Open `/reports` or `/extent-reports` for HTML test reports
- Review `/screenshots` for any captured failures

## Technologies Used

- Java 11
- Selenium WebDriver
- TestNG
- Maven
- Log4j2 for logging
- ExtentReports for HTML reporting
- Page Object Model (POM) design pattern

## Contact

**Jayant Pawar**  
Phone: 9589231232  
Email: jayantpawar27367@gmail.com

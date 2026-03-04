# real-api-quarkus
This App is a fork of realworld-api-quarkus, and was creted for the purposes of SAST scanning benchmark.

## ⚠️ WARNING
This application contains **intentional security vulnerabilities** for testing SAST (Static Application Security Testing) scanners. **DO NOT** deploy this application in production or any publicly accessible environment.

## Purpose
This project is designed to test the capability of SAST scanners to detect various security vulnerabilities in Java applications built with the Quarkus framework.

## Project Structure
The application contains 100+ vulnerable files organized by vulnerability type:

### Vulnerability Categories

1. **SQL Injection** (`sqli/`)
   - String concatenation in queries
   - ORDER BY injection
   - UPDATE/DELETE injection
   - LIKE clause injection
   - JPA Native Query injection
   - Hibernate HQL injection

2. **NoSQL Injection** (`nosqli/`)
   - MongoDB injection

3. **Cross-Site Scripting (XSS)** (`xss/`, `dom/`, `xxs/`)
   - Reflected XSS
   - Stored XSS
   - DOM-based XSS
   - JSONP injection

4. **Command Injection** (`cmdi/`)
   - OS command injection
   - ProcessBuilder vulnerabilities
   - Script engine code injection

5. **LDAP Injection** (`ldapi/`)

6. **XML External Entity (XXE)** (`xxe/`)
   - DocumentBuilder XXE
   - XPath injection
   - SAX Parser XXE

7. **Path Traversal** (`pathtraversal/`)
   - File download vulnerabilities
   - File upload vulnerabilities
   - Arbitrary file read/write

8. **Authentication & Authorization** (`auth/`)
   - Hardcoded credentials
   - Missing access control
   - Insecure session management
   - Weak JWT implementations
   - Plain text passwords

9. **Cryptography** (`crypto/`)
   - Weak encryption (DES)
   - Hardcoded keys
   - ECB mode usage
   - Weak hashing (MD5, SHA1)
   - Weak random number generation

10. **Server-Side Request Forgery (SSRF)** (`ssrf/`)

11. **Insecure Deserialization** (`deserialization/`, `serialization/`)

12. **Logging Issues** (`logging/`)
    - Log injection
    - Sensitive data logging

13. **Open Redirect** (`redirect/`)

14. **Security Headers** (`headers/`)
    - Missing security headers
    - Insecure cookies

15. **Regular Expression DoS** (`regex/`)

16. **CSRF** (`csrf/`)

17. **Denial of Service** (`dos/`)
    - Zip bomb
    - Memory exhaustion
    - Infinite loops

18. **Reflection & Class Loading** (`reflection/`, `classloader/`)

19. **Race Conditions** (`race/`, `thread/`)

20. **Information Disclosure** (`info/`, `config/`, `debug/`)

21. **Email Injection** (`email/`)

22. **Template Injection** (`template/`)

23. **JNDI Injection** (`jndi/`)

24. **Expression Language Injection** (`el/`)

25. **Trust Boundary Violations** (`trust/`)
    - Disabled SSL verification
    - Disabled hostname verification

26. **Input Validation** (`input/`, `validation/`)
    - Buffer overflow
    - Integer overflow
    - Missing validation

27. **Resource Management** (`resource/`)
    - Resource leaks

28. **CORS Misconfiguration** (`cors/`)

29. **Timing Attacks** (`timing/`)

30. **Sensitive Data Caching** (`cache/`)

31. **Zip Slip** (`zip/`)

32. **API Security** (`api/`)
    - API key exposure
    - No rate limiting

33. **Mass Assignment** (`mass_assignment/`)

34. **Insecure Direct Object Reference (IDOR)** (`idor/`)

35. **Directory Listing** (`enum/`)

36. **Backup File Exposure** (`backup/`)

37. **GraphQL Injection** (`graphql/`)

38. **WebSocket Security** (`websocket/`)

39. **Format String** (`format/`)

40. **Redis Injection** (`redis/`)

41. **JWT Vulnerabilities** (`jwt/`)
    - None algorithm
    - Weak secrets

42. **OAuth Misconfiguration** (`oauth/`)

43. **Type Confusion** (`type_confusion/`)

44. **Temporary Files** (`temp/`)

45. **File Permissions** (`permissions/`)

46. **HTTP Request Smuggling** (`http/`)

47. **Clickjacking** (`clickjacking/`)

48. **MIME Sniffing** (`mime/`)

49. **Second-Order SQL Injection** (`sql_second_order/`)

50. **Business Logic Flaws** (`business_logic/`)

51. **User Enumeration** (`enumeration/`)

## Technology Stack
- **Framework**: Quarkus 3.6.0
- **Java Version**: 17
- **Build Tool**: Maven
- **Dependencies**: 
  - RESTEasy Reactive
  - Hibernate ORM with Panache
  - PostgreSQL JDBC Driver
  - MySQL JDBC Driver
  - Security extensions
  - JWT/OIDC support
  - MongoDB client
  - Redis client
  - and more...

## Building the Project

```bash
mvn clean package
```

## Running the Application

```bash
mvn quarkus:dev
```

The application will start on `http://localhost:8080`

## Running SAST Scans

This application is designed to be scanned with SAST tools like:
- Checkmarx SAST
- Checkmarx CxSAST
- SonarQube
- Fortify
- Veracode
- Snyk Code
- And others

## Testing Coverage

With 100+ files containing different vulnerability types, this application provides comprehensive coverage for testing:
- Framework-specific vulnerability detection (Quarkus)
- Java-specific security issues
- Web application vulnerabilities (OWASP Top 10)
- CWE coverage
- API security issues
- Data flow analysis capabilities
- Control flow analysis

## Disclaimer

**THIS APPLICATION IS FOR TESTING PURPOSES ONLY**

Do not use this code in production. Do not deploy this application on any publicly accessible server. This application intentionally contains severe security vulnerabilities that could compromise systems if deployed.

## License

This is a demonstration/testing application for security scanner evaluation purposes.

## Author

Created for Checkmarx Sales Engineering demonstrations.

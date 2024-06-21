![Build](https://github.com/mdxabu/jdbc-plugin/workflows/Java%20CI%20with%20Maven/badge.svg?branch=main)

![jdbc-plugin-banner](https://github.com/mdxabu/jdbc-plugin/assets/115330277/3010959d-efc0-4a4e-8836-891132792dcd)

![License](https://img.shields.io/github/license/mdxabu/jdbc-plugin)


# JDBC-Plugin

With the JDBC-Plugin, developers can significantly reduce development time and effort by writing database operations once and seamlessly switching between different databases without needing to rewrite significant portions of code. This flexibility makes it easier to adapt applications to changing requirements or migrate between different database platforms with minimal code changes.


## Features

- **Multi-Database Support:** Interact with different database systems such as MySQL, PostgreSQL, Oracle, etc., without needing to change significant portions of code.
- **Unified Interface:** Provides a standardized interface for connecting to and querying databases, abstracting away the complexities of dealing with specific database drivers and configurations.
- **Code Reusability:** Write database operations once and reuse them across different databases, reducing development time and effort.
- **Flexibility:** Easily adapt applications to changing requirements or migrate between different database platforms with minimal code changes.
- **Simplified Development:** Focus on writing database-agnostic code, enabling easier maintenance and portability of applications.

## Supported Databases

| Database                | Supported |
|-------------------------|-----------|
| MySQL                   | ✅       |
| PostgreSQL              | ❌       |
| Oracle                  | ❌       |
| Microsoft SQL Server    | ❌       |
| SQLite                  | ❌       |
| MongoDB                 | **WORKING ON IT**        |
| H2 (in-memory database) | ❌        |
| DB2                     | ❌        |
| Cassandra               | ❌        |


## Getting Started

To get started with the JDBC-Plugin, follow these steps:

1. **Add Dependency:** Add the JDBC-Plugin dependency to your Java project's build configuration file (e.g., `pom.xml` for Maven or `build.gradle` for Gradle).
> [!IMPORTANT]
> This Dependency is not working right now, It's on the development stage.
>    ```xml
>    <!-- Maven -->
>    <dependency>
>      <groupId>org.mdxabu</groupId>
>      <artifactId>jdbc-plugin</artifactId>
>      <version>1.0</version>
>    </dependency>
>    ```

2. **Configure Database Connection:** Set up database connection properties such as URL, username, and password in your application's configuration.

3. **Write Database Operations:** Use the JDBC Plugin to perform database operations like connecting to the database, executing queries, and handling results.

4. **Run Your Application:** Compile and run your Java application to interact with the configured databases using the JDBC Plugin.



## Contributing

Contributions are always welcome!

See [CONTRIBUTING.md](https://github.com/mdxabu/jdbc-plugin/blob/main/CONTRIBUTING.md) for ways to get started.

Please adhere to this project's `code of conduct`.




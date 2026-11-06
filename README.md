# Why Database? 数据库系统与文件读写的比较

[中文](#项目题目) | [English](#english)

数据库课程个人项目：通过实验比较 PostgreSQL、手写 Java 文件读写程序与自制数据库系统，探索数据库在性能、数据一致性、完整性和安全性方面的作用。

## 项目题目

课程题目 **DBMS Performance Evaluation** 要求选取一定规模的数据，分别存入 PostgreSQL 和文件中；使用 SQL 与自行编写的程序完成查询、更新等操作，记录运行时间并比较差异。在此基础上，可以进一步设计实验，研究数据库的存储和检索机制。

本项目以电影数据和生成的学生数据为主要实验对象，除题目要求的操作性能对比外，还考察了数据管理中可靠性与安全性的问题。完整过程、实验条件和结果见 [实验报告](Docs/Report/黄政东-实验报告-探究数据库系统与传统文件读写间的表现差异.pdf)，原始题目见 [项目要求](Docs/project1.pdf)。

## 主要工作

- **实现文件读写与数据库模拟程序**：使用 Java 操作 CSV 文件，完成数据导入、查询与更新；实现实验用的关系型数据库模拟系统 MyDB，将 SQL 解析与数据操作分开，并尝试可切换的存储引擎。MyDB 使用 ANTLR 解析 SQL，支持部分基本操作与条件查询，是用于实验的原型。
- **比较基本操作性能**：在 PostgreSQL、手写 CSV 程序和 MyDB 之间比较数据插入、查询与更新；使用电影数据以及不同规模的学生数据，考察频繁查询、大数据量、缓存与索引等因素。
- **研究 PostgreSQL 数据导入**：比较逐条连接与插入、复用连接、预编译语句、事务和批量处理，并测试多行插入、`COPY`、无日志表及索引和约束对导入的影响。
- **探究一致性与完整性**：深入对数据一致性和完整性极致的实现效果进行测试
  - 通过**故障模拟**比较文件读写与数据库事务的表现，实验外键约束及非法数据操作
  - 进一步测试逻辑备份、时间点恢复（PITR）和数据块校验和。
- **探究数据安全**：通过创建角色、授予和收回权限，观察 PostgreSQL 对不同用户操作的限制。

实验中，数据库提供的索引、缓存、事务、约束和恢复机制展示了它在数据管理中的价值；具体结果依赖实验数据、环境和操作方式，详见报告。

## 项目结构

```text
WhyDatabaseSurvey_
├── Code/
│   ├── InsertSpeedTest/     # PostgreSQL 不同数据导入方式的实验
│   ├── JavaCSV/             # 基于 CSV 文件的数据操作和查询实验
│   ├── LargeQueryCreater/   # 大规模数据与查询语句生成工具
│   ├── MyDB/                # 自制数据库模拟系统
│   └── Transaction/         # 文件读写与数据库事务相关实验
├── Docs/
│   ├── Developing/          # 实验数据
│   ├── Reference/           # 参考材料
│   ├── Report/              # 实验报告
│   └── project1.pdf         # 课程项目要求
├── Publication/             # 项目发布材料目录
└── README.md
```

实验主要使用 Java、Maven 和 PostgreSQL；报告记录的环境为 JDK 17 与 PostgreSQL 15。各目录是独立的实验项目，部分程序依赖本地数据库配置、数据文件或旧的文件路径，重新运行前需要按环境调整。

## English

A personal database course project comparing PostgreSQL, hand-written Java file operations, and a custom database prototype. The experiments explore performance, consistency, integrity, and security in data management.

### Project Assignment

The **DBMS Performance Evaluation** assignment asks students to store a reasonably large dataset in both PostgreSQL and a file, implement queries and updates using SQL and a program of their own, and compare their execution times. It also invites further experiments into database storage and retrieval mechanisms.

This project uses movie data and generated student data to investigate both performance and the reliability and security of data management. The [experiment report](Docs/Report/黄政东-实验报告-探究数据库系统与传统文件读写间的表现差异.pdf) describes the methods, conditions, and results; the original assignment is available [here](Docs/project1.pdf). Both documents are in their original languages.

### Main Work

- **File operations and database prototype:** Implemented CSV data loading, querying, and updating in Java, as well as MyDB, an experimental relational database prototype. MyDB separates SQL parsing from data operations, experiments with interchangeable storage engines, and uses ANTLR to parse a subset of SQL and conditional queries.
- **Basic operation performance:** Compared insertion, query, and update operations across PostgreSQL, the hand-written CSV program, and MyDB. Experiments used movie data and student datasets of different sizes to explore frequent queries, large datasets, caching, and indexes.
- **PostgreSQL data loading:** Compared per-row connections and inserts, connection reuse, prepared statements, transactions, and batching. Also tested multi-row inserts, `COPY`, unlogged tables, and the effects of indexes and constraints.
- **Consistency and integrity:** Simulated failures to compare file operations with database transactions, tested foreign-key constraints and invalid operations, and explored logical backups, point-in-time recovery (PITR), and data block checksums.
- **Security:** Created roles and granted and revoked permissions to observe how PostgreSQL restricts operations for different users.

The experiments illustrate the value of indexes, caching, transactions, constraints, and recovery mechanisms. Results depend on the data, environment, and methods used; see the report for details.

### Project Structure

```text
WhyDatabaseSurvey_
├── Code/
│   ├── InsertSpeedTest/     # PostgreSQL data loading experiments
│   ├── JavaCSV/             # CSV-based data operations and queries
│   ├── LargeQueryCreater/   # Large dataset and query generators
│   ├── MyDB/                # Experimental database prototype
│   └── Transaction/         # File and database transaction experiments
├── Docs/
│   ├── Developing/          # Experiment data
│   ├── Reference/           # Reference materials
│   ├── Report/              # Experiment report
│   └── project1.pdf         # Course assignment
├── Publication/             # Publication materials directory
└── README.md
```

The experiments primarily use Java, Maven, and PostgreSQL; the report records JDK 17 and PostgreSQL 15. The directories are independent experiment projects. Some programs depend on local database configuration, data files, or old file paths and need to be adjusted before running again.

package potatoxf.helper.basic.common.db.sql.formatter.languages;

import potatoxf.helper.basic.common.db.sql.formatter.core.AbstractFormatter;
import potatoxf.helper.basic.common.db.sql.formatter.core.DialectConfig;
import potatoxf.helper.basic.common.db.sql.formatter.core.FormatConfig;
import potatoxf.helper.basic.common.db.sql.formatter.core.SqlFormatterHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class TSqlFormatter extends AbstractFormatter {

  private static final List<String> reservedWords =
      Arrays.asList(
          "ADD",
          "EXTERNAL",
          "PROCEDURE",
          "ALL",
          "FETCH",
          "PUBLIC",
          "ALTER",
          "FILE",
          "RAISERROR",
          "AND",
          "FILLFACTOR",
          "READ",
          "ANY",
          "FOR",
          "READTEXT",
          "AS",
          "FOREIGN",
          "RECONFIGURE",
          "ASC",
          "FREETEXT",
          "REFERENCES",
          "AUTHORIZATION",
          "FREETEXTTABLE",
          "REPLICATION",
          "BACKUP",
          "FROM",
          "RESTORE",
          "BEGIN",
          "FULL",
          "RESTRICT",
          "BETWEEN",
          "FUNCTION",
          "RETURN",
          "BREAK",
          "GOTO",
          "REVERT",
          "BROWSE",
          "GRANT",
          "REVOKE",
          "BULK",
          "GROUP",
          "RIGHT",
          "BY",
          "HAVING",
          "ROLLBACK",
          "CASCADE",
          "HOLDLOCK",
          "ROWCOUNT",
          "CASE",
          "IDENTITY",
          "ROWGUIDCOL",
          "CHECK",
          "IDENTITY_INSERT",
          "RULE",
          "CHECKPOINT",
          "IDENTITYCOL",
          "SAVE",
          "CLOSE",
          "IF",
          "SCHEMA",
          "CLUSTERED",
          "IN",
          "SECURITYAUDIT",
          "COALESCE",
          "INDEX",
          "SELECT",
          "COLLATE",
          "INNER",
          "SEMANTICKEYPHRASETABLE",
          "COLUMN",
          "INSERT",
          "SEMANTICSIMILARITYDETAILSTABLE",
          "COMMIT",
          "INTERSECT",
          "SEMANTICSIMILARITYTABLE",
          "COMPUTE",
          "INTO",
          "SESSION_USER",
          "CONSTRAINT",
          "IS",
          "SET",
          "CONTAINS",
          "JOIN",
          "SETUSER",
          "CONTAINSTABLE",
          "KEY",
          "SHUTDOWN",
          "CONTINUE",
          "KILL",
          "SOME",
          "CONVERT",
          "LEFT",
          "STATISTICS",
          "CREATE",
          "LIKE",
          "SYSTEM_USER",
          "CROSS",
          "LINENO",
          "TABLE",
          "CURRENT",
          "LOAD",
          "TABLESAMPLE",
          "CURRENT_DATE",
          "MERGE",
          "TEXTSIZE",
          "CURRENT_TIME",
          "NATIONAL",
          "THEN",
          "CURRENT_TIMESTAMP",
          "NOCHECK",
          "TO",
          "CURRENT_USER",
          "NONCLUSTERED",
          "TOP",
          "CURSOR",
          "NOT",
          "TRAN",
          "DATABASE",
          "NULL",
          "TRANSACTION",
          "DBCC",
          "NULLIF",
          "TRIGGER",
          "DEALLOCATE",
          "OF",
          "TRUNCATE",
          "DECLARE",
          "OFF",
          "TRY_CONVERT",
          "DEFAULT",
          "OFFSETS",
          "TSEQUAL",
          "DELETE",
          "ON",
          "UNION",
          "DENY",
          "OPEN",
          "UNIQUE",
          "DESC",
          "OPENDATASOURCE",
          "UNPIVOT",
          "DISK",
          "OPENQUERY",
          "UPDATE",
          "DISTINCT",
          "OPENROWSET",
          "UPDATETEXT",
          "DISTRIBUTED",
          "OPENXML",
          "USE",
          "DOUBLE",
          "OPTION",
          "USER",
          "DROP",
          "OR",
          "VALUES",
          "DUMP",
          "ORDER",
          "VARYING",
          "ELSE",
          "OUTER",
          "VIEW",
          "END",
          "OVER",
          "WAITFOR",
          "ERRLVL",
          "PERCENT",
          "WHEN",
          "ESCAPE",
          "PIVOT",
          "WHERE",
          "EXCEPT",
          "PLAN",
          "WHILE",
          "EXEC",
          "PRECISION",
          "WITH",
          "EXECUTE",
          "PRIMARY",
          "WITHIN GROUP",
          "EXISTS",
          "PRINT",
          "WRITETEXT",
          "EXIT",
          "PROC");

  private static final List<String> reservedTopLevelWords =
      Arrays.asList(
          "ADD",
          "ALTER COLUMN",
          "ALTER TABLE",
          "CASE",
          "DELETE FROM",
          "END",
          "EXCEPT",
          "FROM",
          "GROUP BY",
          "HAVING",
          "INSERT INTO",
          "INSERT",
          "LIMIT",
          "ORDER BY",
          "SELECT",
          "SET CURRENT SCHEMA",
          "SET SCHEMA",
          "SET",
          "UPDATE",
          "VALUES",
          "WHERE");

  private static final List<String> reservedTopLevelWordsNoIndent =
      Arrays.asList("INTERSECT", "INTERSECT ALL", "MINUS", "UNION", "UNION ALL");

  private static final List<String> reservedNewlineWords =
      Arrays.asList(
          "AND",
          "ELSE",
          "OR",
          "WHEN",
          // joins
          "JOIN",
          "INNER JOIN",
          "LEFT JOIN",
          "LEFT OUTER JOIN",
          "RIGHT JOIN",
          "RIGHT OUTER JOIN",
          "FULL JOIN",
          "FULL OUTER JOIN",
          "CROSS JOIN");

  public TSqlFormatter(FormatConfig cfg) {
    super(cfg);
  }

  @Override
  public DialectConfig dialectConfig() {
    return DialectConfig.builder()
        .reservedWords(reservedWords)
        .reservedTopLevelWords(reservedTopLevelWords)
        .reservedTopLevelWordsNoIndent(reservedTopLevelWordsNoIndent)
        .reservedNewlineWords(reservedNewlineWords)
        .stringTypes(
            Arrays.asList(
                SqlFormatterHelper.DOUBLE_QUOTE,
                SqlFormatterHelper.N_SINGLE_QUOTE,
                SqlFormatterHelper.SINGLE_QUOTE,
                SqlFormatterHelper.BACK_QUOTE,
                SqlFormatterHelper.BRACKET))
        .openParens(Arrays.asList("(", "CASE"))
        .closeParens(Arrays.asList(")", "END"))
        .indexedPlaceholderTypes(Collections.emptyList())
        .namedPlaceholderTypes(Arrays.asList("@"))
        .lineCommentTypes(Collections.singletonList("--"))
        .specialWordChars(Arrays.asList("#", "@"))
        .operators(
            Arrays.asList(
                ">=", "<=", "<>", "!=", "!<", "!>", "+=", "-=", "*=", "/=", "%=", "|=", "&=", "^=",
                "::"))
        .build();
  }
}

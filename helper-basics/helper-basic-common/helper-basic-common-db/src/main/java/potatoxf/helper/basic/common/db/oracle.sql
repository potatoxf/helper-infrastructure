CREATE TABLE COMMON_PARAMETER
(
    "CP_MODULE"       VARCHAR(128) NOT NULL,
    "CP_TYPE"         VARCHAR(128) NOT NULL,
    "CP_NAME"         VARCHAR(128) NOT NULL,
    "CP_PERSON"       VARCHAR(128) NOT NULL,
    "CP_ENUMERABLE"   NUMBER(1) NOT NULL,
    "CP_REF"          NUMBER       NOT NULL,
    "CP_TOKEN_ID"     NUMBER       NOT NULL,
    "CP_STRING_VALUE" VARCHAR(256),
    "CP_NUMBER_VALUE" NUMBER,
    "CP_SORTED"       NUMBER,
    "CP_DESCRIPTION"  VARCHAR(256)
);

COMMENT
ON TABLE COMMON_PARAMETER
  IS '公共参数';
COMMENT
ON COLUMN COMMON_PARAMETER."CP_MODULE"
  IS '参数所属模块';
COMMENT
ON COLUMN COMMON_PARAMETER."CP_TYPE"
  IS '参数所属组别';
COMMENT
ON COLUMN COMMON_PARAMETER."CP_NAME"
  IS '参数名称';
COMMENT
ON COLUMN COMMON_PARAMETER."CP_PERSON"
  IS '参数关联人员';
COMMENT
ON COLUMN COMMON_PARAMETER."CP_ENUMERABLE"
  IS '是否枚举';
COMMENT
ON COLUMN COMMON_PARAMETER."CP_REF"
  IS '同参数引用值';
COMMENT
ON COLUMN COMMON_PARAMETER."CP_TOKEN_ID"
  IS '枚举的ID值';
COMMENT
ON COLUMN COMMON_PARAMETER."CP_SORTED"
  IS '排序';
COMMENT
ON COLUMN COMMON_PARAMETER."CP_DESCRIPTION"
  IS '描述';
COMMENT
ON COLUMN COMMON_PARAMETER."CP_STRING_VALUE"
  IS '字符串值';
COMMENT
ON COLUMN COMMON_PARAMETER."CP_NUMBER_VALUE"
  IS '数字值';

ALTER TABLE COMMON_PARAMETER
    ADD CONSTRAINT PK_COMMON_PARAMETER PRIMARY KEY ("CP_MODULE", "CP_TYPE", "CP_NAME", "CP_PERSON",
                                                    "CP_ENUMERABLE", "CP_REF") USING INDEX;
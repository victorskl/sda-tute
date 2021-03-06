--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "MY_SCHEMA"."PERSONDETAIL" DROP CONSTRAINT "SQL171029200807380";

DROP INDEX "MY_SCHEMA"."SQL171029200807380";

DROP TABLE "MY_SCHEMA"."PERSONDETAIL";

CREATE TABLE "MY_SCHEMA"."PERSONDETAIL" (
		"DETAILID_PK" INTEGER NOT NULL,
		"INCOME" DOUBLE NOT NULL,
		"JOB" VARCHAR(255),
		"ZIPCODE" VARCHAR(255)
	);

CREATE UNIQUE INDEX "MY_SCHEMA"."SQL171029200807380" ON "MY_SCHEMA"."PERSONDETAIL" ("DETAILID_PK" ASC);

ALTER TABLE "MY_SCHEMA"."PERSONDETAIL" ADD CONSTRAINT "SQL171029200807380" PRIMARY KEY ("DETAILID_PK");


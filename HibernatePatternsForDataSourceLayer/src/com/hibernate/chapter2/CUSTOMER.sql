--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "MY_SCHEMA"."CUSTOMER" DROP CONSTRAINT "SQL170906001513060";

DROP INDEX "MY_SCHEMA"."SQL171029193451690";

DROP TABLE "MY_SCHEMA"."CUSTOMER";

CREATE TABLE "MY_SCHEMA"."CUSTOMER" (
		"CUSTOMERID" INTEGER NOT NULL,
		"CUSTOMERNAME" VARCHAR(255)
	);

CREATE UNIQUE INDEX "MY_SCHEMA"."SQL171029193451690" ON "MY_SCHEMA"."CUSTOMER" ("CUSTOMERID" ASC);

ALTER TABLE "MY_SCHEMA"."CUSTOMER" ADD CONSTRAINT "SQL170906001513060" PRIMARY KEY ("CUSTOMERID");

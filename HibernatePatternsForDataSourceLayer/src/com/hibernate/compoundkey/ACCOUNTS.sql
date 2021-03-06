--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "MY_SCHEMA"."ACCOUNTS" DROP CONSTRAINT "SQL171029195018620";

DROP INDEX "MY_SCHEMA"."SQL171029195018620";

DROP TABLE "MY_SCHEMA"."ACCOUNTS";

CREATE TABLE "MY_SCHEMA"."ACCOUNTS" (
		"ACCOUNTID" INTEGER NOT NULL,
		"USERID" INTEGER NOT NULL,
		"ACCOUNTBALANCE" INTEGER NOT NULL
	);

CREATE UNIQUE INDEX "MY_SCHEMA"."SQL171029195018620" ON "MY_SCHEMA"."ACCOUNTS" ("ACCOUNTID" ASC, "USERID" ASC);

ALTER TABLE "MY_SCHEMA"."ACCOUNTS" ADD CONSTRAINT "SQL171029195018620" PRIMARY KEY ("ACCOUNTID", "USERID");


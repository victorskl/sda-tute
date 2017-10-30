--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "USER"."USERS" DROP CONSTRAINT "SQL170911232436720";

DROP INDEX "USER"."SQL170911232436720";

DROP TABLE "USER"."USERS";

CREATE TABLE "USER"."USERS" (
		"USER_ID" INTEGER DEFAULT AUTOINCREMENT: start 1 increment 1 NOT NULL GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 1),
		"USERNAME" VARCHAR(100) NOT NULL,
		"PASSWORD" VARCHAR(100) NOT NULL,
		"ENABLED" INTEGER NOT NULL
	);

CREATE UNIQUE INDEX "USER"."SQL170911232436720" ON "USER"."USERS" ("USER_ID" ASC);

ALTER TABLE "USER"."USERS" ADD CONSTRAINT "SQL170911232436720" PRIMARY KEY ("USER_ID");

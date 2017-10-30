--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "USER"."ROLES" DROP CONSTRAINT "SQL170911232440480";

DROP INDEX "USER"."SQL170911232440480";

DROP TABLE "USER"."ROLES";

CREATE TABLE "USER"."ROLES" (
		"USER_ROLE_ID" INTEGER DEFAULT AUTOINCREMENT: start 1 increment 1 NOT NULL GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 1),
		"USER_ID" INTEGER NOT NULL,
		"ROLE" VARCHAR(100) NOT NULL
	);

CREATE UNIQUE INDEX "USER"."SQL170911232440480" ON "USER"."ROLES" ("USER_ROLE_ID" ASC);

ALTER TABLE "USER"."ROLES" ADD CONSTRAINT "SQL170911232440480" PRIMARY KEY ("USER_ROLE_ID");

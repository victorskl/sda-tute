--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "MY_SCHEMA"."MODULE" DROP CONSTRAINT "SQL171029225716620";

DROP INDEX "MY_SCHEMA"."SQL171029225716620";

DROP TABLE "MY_SCHEMA"."MODULE";

CREATE TABLE "MY_SCHEMA"."MODULE" (
		"PROJECTID" INTEGER NOT NULL,
		"PROJECTNAME" VARCHAR(255),
		"MODULENAME" VARCHAR(255)
	);

CREATE UNIQUE INDEX "MY_SCHEMA"."SQL171029225716620" ON "MY_SCHEMA"."MODULE" ("PROJECTID" ASC);

ALTER TABLE "MY_SCHEMA"."MODULE" ADD CONSTRAINT "SQL171029225716620" PRIMARY KEY ("PROJECTID");


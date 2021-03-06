IDENTIFICATION DIVISION.
PROGRAM-ID. STATEMENTCOVERAGE.
ENVIRONMENT DIVISION.
CONFIGURATION SECTION.
DATA DIVISION.
FILE SECTION.
WORKING-STORAGE SECTION.
01 E-FELDER.
  05 FAC PIC 9999 VALUE ZERO.
01 V-FELDER.
  05 ERG PIC 9999 VALUE 1.
  05 I PIC 9999.
PROCEDURE DIVISION.
B100.

*>STARTTESTCASE "name 1"
*>STARTTESTCASE "name 2" "comment 2"
*>STARTTESTCASE "name 3 \"innnen.\""
*>STARTTESTCASE "name 4 \"innnen.\"" "comment \"4\""
*>STARTTESTCASE "name 5 innnen." "comment \"5\""

ADD ZAHL1 TO ZAHL2.

COMPUTE ERG = ERG * I

DISPLAY "FACULTY: " ERG

GO TO B100.

GOBACK.

CALL "subprogram".

EVALUATE FAC
  WHEN 0 DISPLAY "a thing".

EXIT PROGRAM.

PERFORM B100 UNTIL FAC = 9.

IF FAC = 0 DISPLAY "if".


ADD ZAHL1 TO ZAHL2
  ON SIZE ERROR
    DISPLAY "result field to small"
  NOT ON SIZE ERROR
    DISPLAY "result: ", ZAHL2.

IF FAC >= 0 AND < 8  OR (FAC >= 10 AND 11) THEN
  MOVE 1 TO ERG
  DISPLAY "Result: " ERG
ELSE
  DISPLAY "Fehlerhafte Eingabe"
END-IF.


IF FAC >= 0 AND < 8 THEN DISPLAY "something".


IF FAC >= 0 OR < 8 AND = 4 OR B THEN DISPLAY "something else".


IF (FAC >= 0 OR < 8) AND (FAC = 4 OR B) THEN DISPLAY "true".


IF FAC >= 0 AND FAC < 8
  DISPLAY "another thing"
END-IF.


IF FAC >= 0 AND FAC < 8
  DISPLAY "another thing"
ELSE
  DISPLAY "this thing".


IF FAC >= 0 AND FAC < 8
  NEXT SENTENCE
ELSE
  DISPLAY "this thing".


IF FAC >= 0 AND FAC < 8
  IF ZAHL >= 0 AND ZAHL < 8
    DISPLAY "this thing"
  END-IF
ELSE
  NEXT SENTENCE
END-IF.

EVALUATE FAC
  WHEN 0 DISPLAY "a thing".


EVALUATE FAC
  WHEN 0 DISPLAY "non thing"
  WHEN 1 DISPLAY "one thing"
  WHEN OTHER DISPLAY "more things".


SEARCH ALL DATAFIELD1 VARYING DATAFIELD2
  AT END DISPLAY "a thing"
  WHEN DATAFIELD3 < 5 DISPLAY "this thing"
END-SEARCH.


SEARCH ALL DATAFIELD1 VARYING DATAFIELD2
  WHEN DATAFIELD3 < 5 NEXT SENTENCE
END-SEARCH.


ADD ZAHL1 TO ZAHL2
  ON SIZE ERROR
    DISPLAY "result field to small"
  NOT ON SIZE ERROR
    DISPLAY "result: ", ZAHL2
END-ADD.

IF FAC >= 0 AND < 8  OR (FAC >= 10 AND 11) THEN
  MOVE 1 TO ERG
  PERFORM VARYING I FROM 1 BY 1 UNTIL I > FAC
    COMPUTE ERG = ERG * I
  END-PERFORM
  DISPLAY "Result: " ERG
ELSE
  DISPLAY "Fehlerhafte Eingabe"
END-IF.

IF FAC >= 0 AND < 8 THEN DISPLAY "something".


IF FAC >= 0 AND FAC < 8
  DISPLAY "another thing"
END-IF.


IF FAC >= 0 AND FAC < 8
  DISPLAY "another thing"
ELSE
  DISPLAY "this thing".


IF FAC >= 0 AND FAC < 8
  NEXT SENTENCE
ELSE
  DISPLAY "this thing".


EVALUATE FAC
  WHEN 0 DISPLAY "a thing".


EVALUATE FAC
  WHEN 0 DISPLAY "non thing"
  WHEN 1 DISPLAY "one thing"
  WHEN OTHER DISPLAY "more things".


SEARCH ALL DATAFIELD1 VARYING DATAFIELD2
  AT END DISPLAY "a thing"
  WHEN DATAFIELD3 < 5 DISPLAY "this thing"
END-SEARCH.


SEARCH ALL DATAFIELD1 VARYING DATAFIELD2
  WHEN DATAFIELD3 < 5 NEXT SENTENCE
END-SEARCH.

PERFORM B100 AFTER ZAHL1 FROM 1 BY 1 UNTIL ZAHL1 = 100
    AFTER ZAHL2 FROM 1 BY 2 UNTIL ZAHL2 = 100.

PERFORM B100 UNTIL FAC = 9.

PERFORM B100 AFTER ZAHL1 FROM 1 BY 1 UNTIL ZAHL1 = 100
    AFTER ZAHL2 FROM 1 BY 2 UNTIL ZAHL2 = 100.

PERFORM B100 UNTIL FAC = 9.

PERFORM VARYING I FROM 1 BY 1 UNTIL I > FAC
  COMPUTE ERG = ERG * I
END-PERFORM

PERFORM VARYING I FROM 1 BY 1 UNTIL I > FAC WITH TEST BEFORE
  COMPUTE ERG = ERG * I
END-PERFORM

PERFORM VARYING I FROM 1 BY 1 UNTIL I > FAC WITH TEST AFTER
  COMPUTE ERG = ERG * I
END-PERFORM


STOP RUN.

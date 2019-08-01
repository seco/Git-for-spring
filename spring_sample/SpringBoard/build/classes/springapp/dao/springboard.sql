CREATE TABLE "SPRINGBOARD"."BOARD"
  (
    "SEQ"      NUMBER NOT NULL ENABLE,
    "WRITER"   VARCHAR2(20 BYTE) NOT NULL ENABLE,
    "TITLE"    VARCHAR2(100 BYTE) NOT NULL ENABLE,
    "CONTENT"  VARCHAR2(1000 BYTE) NOT NULL ENABLE,
    "PASSWORD" VARCHAR2(20 BYTE) NOT NULL ENABLE,
    "HIT"      NUMBER(5,0) NOT NULL ENABLE,
    "GROUPS"   NUMBER(10,0) NOT NULL ENABLE,
    "STEP"     NUMBER(3,0) NOT NULL ENABLE,
    "LEVELS"   NUMBER(3,0) NOT NULL ENABLE,
    "REGDATE" DATE DEFAULT sysdate NOT NULL ENABLE
  )
  
CREATE SEQUENCE "SPRINGBOARD"."BOARD_SEQ" MINVALUE 1 MAXVALUE 999999999999999999999999999
INCREMENT BY 1 START WITH 1 NOCACHE NOORDER NOCYCLE ;

//�׽�Ʈ ������ �Է�
insert into board(seq, writer, title, content, password, hit, groups, step, levels, regdate)
values(board_seq.nextval, '������','�׽�Ʈ ���Դϴ�.','�׽�Ʈ �����Դϴ�.','1111',0,board_seq.nextval,0,0,sysdate);
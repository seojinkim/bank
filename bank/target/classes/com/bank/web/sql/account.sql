	private int accountNo;
	private String name;
	private int money;
	private int password;
	
CREATE SEQUENCE seq
-- INCREMENT BY 1 증감숫자이며 1씩 증가시킬 때는 생략이 가능하다
START WITH 1;

DROP TABLE account;

SELECT * FROM account;

CREATE TABLE account(
	seq 	  NUMBER PRIMARY KEY,
	accountNo NUMBER,
	money 	  NUMBER,
	password  NUMBER,
	userid 	  VARCHAR2(30)
);

INSERT INTO account(seq,accountNo,money,password,userid) VALUES(
	seq.NEXTVAL, 1000, 10000, 1, 'kim'
);
INSERT INTO account(seq,accountNo,money,password,userid) VALUES(
	seq.NEXTVAL, 10000, 20000, 1, 'lee'
);
INSERT INTO account(seq,accountNo,money,password,userid) VALUES(
	seq.NEXTVAL, 10002, 50000, 1, 'kang'
);
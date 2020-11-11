/* 에러 방지용 코드 : 운영 계정에서는 해당 테이블이 없기 때문에 운영계정일 경우 에러 발생 */
SELECT * 
  FROM NOT_EXISTS_IN_PRD;

/*DELETE users;*/
TRUNCATE TABLE users;

Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('brown','브라운','brownPass',to_date('2019/01/28','yyyy/MM/DD'),'곰',null,null,null,'D:\profile\brown.png','brown.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('cony','코니','conyPass',to_date('2019/01/28','yyyy/MM/DD'),'토끼',null,null,null,'D:\profile\cony.png','cony.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('sally','샐리','sallyPass',to_date('2019/01/28','yyyy/MM/DD'),'병아리',null,null,null,'D:\profile\sally.png','sally.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('james','제임스','jamesPass',to_date('2019/01/28','yyyy/MM/DD'),'사람',null,null,null,'D:\profile\james.png','james.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('moon','문','moonPass',to_date('2019/01/28','yyyy/MM/DD'),'달',null,null,null,'D:\profile\moon.png','moon.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('leonard','레너드','leonardPass',to_date('2020/11/06','yyyy/MM/DD'),'개구리',null,null,null,'D:\upload\31599a27-93e0-46b8-85e9-8eb339093f92.png','개구리.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('edward','에드워드','edwardPass',to_date('2020/11/06','yyyy/MM/DD'),'애벌레',null,null,null,'D:\upload\4f61c1aa-440b-4e38-888f-552fb2e68a74.png','다운로드.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('jessica','제시카','jessicaPass',to_date('2020/11/06','yyyy/MM/DD'),'고양이',null,null,null,'D:\upload\141be588-1e77-45bf-8a20-a6231941f31a.jpg','다운로드.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('boss','보스','bossPass',to_date('2020/11/06','yyyy/MM/DD'),'사람',null,null,null,'D:\upload\a5b1f2dd-9b90-42bd-9f87-979d99680247.png','unnamed.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('choco','초코','chocoPass',to_date('2020/11/06','yyyy/MM/DD'),'곰2',null,null,null,'D:\upload\a1596d62-ff44-4578-aa70-a73e4b7dac26.jpg','20160818515179.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('pangyo','팡요','pangyoPass',to_date('2020/11/06','yyyy/MM/DD'),'판다',null,null,null,'D:\upload\9caa54f4-2202-4918-aef1-3dda9c1a6066.jpg','unnamed (1).jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('muzi','무지','muziPass',to_date('2020/11/06','yyyy/MM/DD'),'토끼',null,null,null,'D:\upload\7903d0bd-9249-4c6e-b506-9b59a9f94c68.png','muzi.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('con','콘','conPass',to_date('2020/11/06','yyyy/MM/DD'),'악어',null,null,null,'D:\upload\bc4267b7-6609-42ea-ae95-e73ff0bc7450.jpg','unnamed.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('apeach','어피치','apeachPass',to_date('2020/11/06','yyyy/MM/DD'),'복숭아',null,null,null,'D:\upload\5c5529d5-4b52-4788-8c3a-fe31e9048b72.jpg','jLV6stsm.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('ryan','라이언 ','ryanPass',to_date('2020/10/15','yyyy/MM/DD'),'사자',null,null,null,'D:\profile\ryan.png','ryan.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('kmy2','유승호_수정','pass1234',to_date('2020/11/05','yyyy/MM/DD'),'유호호','대전 중구 중앙로 76','영민빌딩 404호','34940','D:\upload\36cfb2c2-3814-44ea-bc08-9eba4c0b6c89.png','JJ2.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('kmy','유아인2','pass1234',to_date('2020/11/06','yyyy/MM/DD'),'유호호','경기 성남시 분당구 판교역로2번길 1','404호','13536','D:\upload\53959b28-e943-4712-a441-a81ff0fd4937.png','JJ.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('spring','스프링_수정','springPass',to_date('2020/11/05','yyyy/MM/DD'),'스프링컨테이너','대전 동구 판교1길 3','어딘지몰라','34672','D:\upload\6980cecd-79dc-4218-9545-99e14e538b38.png','JJ.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('sutak','수탉','pass1234',to_date('2020/11/05','yyyy/MM/DD'),'수탉이','서울 강남구 가로수길 5','수탉이네','06035','D:\upload\5c3881a0-f3e4-4a9a-b8fa-2455f51d6d30.jpg','aa.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('kmy3','유승호_등록','pass1234',to_date('2020/11/05','yyyy/MM/DD'),'유호호','대전 중구 중앙로 76','영민빌딩 404호','34940','D:\upload\446654dc-f725-439c-a4ba-a3346c3c7774.png','JJ2.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('kmy5','유승호_등록','pass1234',to_date('2020/11/05','yyyy/MM/DD'),'유호호','대전 중구 중앙로 76','영민빌딩 404호','34940','D:\upload\046f00e9-85f4-4062-9b38-e580ba75ba4f.png','JJ2.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('ddit','대덕','dditpass',to_date('2020/11/11','yyyy/MM/DD'),'개발원','대전광역시','중구청','12345',null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('kmyttt','유아인','pass1234',to_date('2020/11/06','yyyy/MM/DD'),'유아','대전 중구 중앙로 76','영민빌딩 404호','34940','D:\upload\6fec4548-a98d-4871-9bf2-7cb9e8c49a79.png','다운로드 (1).png');

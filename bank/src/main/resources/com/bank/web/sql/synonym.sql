-- synonym 동의어 : 스키마 오브젝트의 별칭(alias) 
-- synonym 제한 사항
-- 1. 스키마에 대한  select 권한이 있어야 함
-- 2. synonym 에는 public 과 private 두가지가 있다
--    공개용 시노님에는 모든 사용자가 접근 가능하고, private 은
--    생성한 스키마 내부에서만 사용 가능하다.
-- 3. 반드시 최상위 스키마인 sys 에서 생성 및 삭제 가능
create or replace public synonym cnt for hr.cnt;
grant select on cnt to bank;
create or replace public synonym emp for hr.emp;
grant select on emp to bank;
create or replace public synonym emp_detail for hr.emp_detail;
grant select on emp_detail to bank;
create or replace public synonym dep for hr.dep;
grant select on dep to bank;
-- job 은 키워드라서 안됨
create or replace public synonym jobs for hr.job;
grant select on jobs to bank;
create or replace public synonym job_his for hr.job_his;
grant select on job_his to bank;
create or replace public synonym loc for hr.loc;
grant select on loc to bank;
create or replace public synonym reg for hr.reg;
grant select on reg to bank;

drop public synonym emp;

select * from emp_detail;

window + r 
services.msc 를 입력
http://exerd.com/update

drop : 스키마 구조까지 삭제
truncate : 스키마 구조는 남기고 데이터만 삭제

Read : select
Create : insert
update : update
delete : delete
취소 rollback


프로시저 -> 절차지향 함수
메소드 -> 객체지향 함수

show user; --> sys ,,system

conn sys as sysdba;
drop public synonym emp;

create or replace public synonym emp for hr.emp;
grant select on emp to bank;
commit;

conn bank/oracle;
show user;
select * from emp;

select count(*) from emp;

select * from reg;
insert into reg values(5,'Korea');

select * from reg;

select 
eid as 직원번호,
sal as 연봉,
	case when sal<= 5000 then 'C등급'
		 when sal > 5000 and sal <= 15000 then 'B등급'
	else 'A등급'
end as 등급
from emp;

-- any 는 조건중에서 하나라도 일치하면 출력 즉 or 의 의미
select eid 직원번호, sal 연봉
from emp
where sal = any(2000,3000,4000)
order by eid;
-- all 은 직원이 2000에도 해당, 3000에도 해당, 4000에도 해당 
-- 따라서 논리적으로 잘못되었으므로 null 값 출력
select eid 직원번호, sal 연봉
from emp
where sal = all(2000,3000,4000)
order by eid;
--group by 문법
select 
did 부서번호,
sum(sal) 부서별직원연봉합
from emp
group by did
order by did desc;


select 
d.did 부서번호,
d.dname 부서명,
j.jid 업무번호,
j.did 부서번호
from
dep d, job_his j;
where d.did = j.did(+);





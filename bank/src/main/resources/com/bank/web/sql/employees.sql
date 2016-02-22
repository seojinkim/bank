-- 0.사원 테이블 전체 검색
SELECT * FROM employees;
-- employee_id, first_name, last_name, email, phone_number. hire_date, job_id
-- salary, commission_pct, manager_id, department_id
SELECT * FROM departments;
-- department_id, department_name, manager_id, location_id

-- 1.사원번호, 패밀리네임, 연봉 출력
SELECT employee_id AS 사원번호, last_name AS 성, salary AS 연봉 
FROM   employees;
-- 2. 연봉 3000 이상인 사원
SELECT employee_id AS 사원번호, last_name AS 성, salary AS 연봉 
FROM   employees
WHERE  salary >= 3000;
-- 3. 부서번호(department_id)이 100번인 사원
SELECT employee_id AS 사원번호, last_name AS 성, salary AS 연봉 
FROM   employees
WHERE  employee_id = 100;

-- 4. 입사일이 2000년 1월 1일 이후인 사원
SELECT employee_id AS 사원번호, last_name AS 성, salary AS 연봉, hire_date AS 입사일
FROM   employees
WHERE  hire_date > '20000101';

-- 5.부서가 100번이 아닌 사원
SELECT employee_id AS 사원번호, last_name AS 성, salary AS 연봉, department_id AS 부서번호
FROM   employees
WHERE  department_id <> 100;

-- 6. 연봉이 2000 ~ 3000(이상, 미만) 사이인 사원
SELECT employee_id AS 사원번호, last_name AS 성, salary AS 연봉, department_id AS 부서번호
FROM   employees
WHERE  salary BETWEEN 2000 AND 3000;
--WHERE  salary >= 2000
--AND    salary < 3000;

-- 7. 연봉이 2000 ~ 3000(이상, 미만) 사이에 속하지 않는 사원
SELECT employee_id AS 사원번호, last_name AS 성, salary AS 연봉, department_id AS 부서번호
FROM   employees
WHERE  salary NOT BETWEEN 2000 AND 3000;

-- 8. 커미션이 0.2, 0.3, 0.4 인 사원
SELECT employee_id AS 사원번호, last_name AS 성, salary AS 연봉, commission_pct AS 커미션
FROM   employees
WHERE  commission_pct IN (0.2, 0.3, 0.4);

-- 9. 커미션이 0.2, 0.3, 0.4 가 아닌 사원
SELECT employee_id AS 사원번호, last_name AS 성, salary AS 연봉, commission_pct AS 커미션
FROM   employees
WHERE  commission_pct NOT IN (0.2, 0.3, 0.4);

-- 10. 패밀리네임의 시작 알파벳이 K인 사원
SELECT employee_id, last_name
FROM   employees
WHERE  last_name LIKE 'K%';

-- 11. 패밀리네임 중에 알파벳이 k인 사원
SELECT employee_id, last_name
FROM   employees
WHERE  last_name LIKE '%k%';

-- 12. 패밀리네임 중에 세번째 알파벳이 a인 사원
SELECT employee_id, last_name
FROM   employees
WHERE  last_name LIKE '__a%';


-- 13. 구글 계정을 사용하는 직원
SELECT employee_id, last_name
FROM   employees
WHERE  last_name LIKE '%\@gmail.com%';

--14. 커미션을 받지 않는 직원
SELECT employee_id AS 사원번호, last_name AS 성, salary AS 연봉, commission_pct AS 커미션
FROM   employees
WHERE  commission_pct IS null;

--15. 커미션을 받는 직원
SELECT employee_id AS 사원번호, last_name AS 성, salary AS 연봉, commission_pct AS 커미션
FROM   employees
WHERE  commission_pct IS NOT null;

--16. 연봉을 적게 받는 순으로해서 오름차순 정렬
SELECT   employee_id AS 사원번호, last_name AS 성, salary AS 연봉, commission_pct AS 커미션
FROM     employees
ORDER BY salary ASC;

--17. 연봉을 적게 받는 순으로해서 내차순 정렬
SELECT   employee_id AS 사원번호, last_name AS 성, salary AS 연봉, commission_pct AS 커미션
FROM     employees
ORDER BY salary DESC;

-- 18. 고액연봉순 직원리스트(만일, 동일한 연봉을 받으면 패밀리네임에 따라 오름차순)
SELECT   employee_id AS 사원번호, last_name AS 성, salary AS 연봉, commission_pct AS 커미션
FROM     employees
ORDER BY salary DESC, last_name ASC;

-- 19. exist 문법
SELECT e.employee_id, e.last_name, e.salary, e.department_id
FROM   employees e
WHERE  exists(SELECT d.department_id
		      FROM   departments d
		      WHERE  d.department_id IN (30, 60, 90) 
		      AND    e.department_id = d.department_id);
SELECT e.eid 사원번호, 
       e.ename 사원명, 
       d.did 부서번호,
       d.dname 부서명
FROM   emp e, dep d,(SELECT avg(e.sal) AS avg_sal
					 FROM   dep d, emp e
					 WHERE  d.did = 90
					 AND    d.did = e.did) t
WHERE  e.did = d.did 
AND    e.sal > t.avg_sal;
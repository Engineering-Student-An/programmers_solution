-- 코드를 작성해주세요
SELECT ID, 
        CASE
            WHEN PERCENTILE <= 25 THEN 'CRITICAL'
            WHEN PERCENTILE <= 50 THEN 'HIGH'
            WHEN PERCENTILE <= 75 THEN 'MEDIUM'
            ELSE 'LOW'
        END AS COLONY_NAME
FROM (SELECT ID, NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) * 25 AS PERCENTILE
     FROM ECOLI_DATA) AS RANKED 
ORDER BY ID;
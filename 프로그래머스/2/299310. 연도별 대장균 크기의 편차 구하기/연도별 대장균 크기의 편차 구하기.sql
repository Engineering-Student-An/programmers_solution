-- 코드를 작성해주세요

WITH MAX_CTE AS (
    SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR, 
           MAX(SIZE_OF_COLONY) AS M
    FROM ECOLI_DATA 
    GROUP BY YEAR
)

SELECT 
    YEAR(E.DIFFERENTIATION_DATE) AS YEAR, 
    (C.M - E.SIZE_OF_COLONY) AS YEAR_DEV, 
    E.ID
FROM
    ECOLI_DATA E 
        JOIN MAX_CTE C
        ON YEAR(E.DIFFERENTIATION_DATE) = C.YEAR
ORDER BY YEAR ASC, YEAR_DEV ASC;
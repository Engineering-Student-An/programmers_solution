-- 코드를 입력하세요
WITH JAN AS (
    SELECT B.BOOK_ID, B.CATEGORY, S.SALES_DATE, S.SALES
    FROM BOOK B
    JOIN BOOK_SALES S ON B.BOOK_ID = S.BOOK_ID
    WHERE MONTH(S.SALES_DATE) = '1'
)

SELECT CATEGORY, SUM(SALES) AS TOTAL_SALES
FROM JAN
GROUP BY CATEGORY
ORDER BY CATEGORY ASC;
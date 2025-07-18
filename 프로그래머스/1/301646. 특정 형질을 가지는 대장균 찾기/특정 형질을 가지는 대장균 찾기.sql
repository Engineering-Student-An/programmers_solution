-- 코드를 작성해주세요
SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE (
        (GENOTYPE & 1) 
            OR 
        (GENOTYPE & (1 << 2))
      ) 
    AND GENOTYPE & (1 << 1) = 0;
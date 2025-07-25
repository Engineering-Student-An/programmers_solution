-- 코드를 작성해주세요
SELECT DISTINCT I.ITEM_ID, I.ITEM_NAME, I.RARITY
FROM ITEM_INFO I
LEFT OUTER JOIN ITEM_TREE T
ON I.ITEM_ID = T.PARENT_ITEM_ID
WHERE T.PARENT_ITEM_ID IS NULL
ORDER BY I.ITEM_ID DESC;
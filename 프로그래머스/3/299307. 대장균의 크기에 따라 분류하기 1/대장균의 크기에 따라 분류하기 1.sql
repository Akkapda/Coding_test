-- 코드를 작성해주세요
SELECT
    ID, 
    CASE
        WHEN SIZE_OF_COLONY <= 100 THEN 'LOW'
        WHEN SIZE_OF_COLONY > 100 AND SIZE_OF_COLONY <= 1000 THEN 'MEDIUM'
        ELSE 'HIGH'
        END
    as SIZE
FROM
    ECOLI_DATA
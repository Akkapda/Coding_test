WITH RankedColony AS (
    SELECT
        ID,
        SIZE_OF_COLONY,
        ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) AS RN,
        COUNT(*) OVER () AS TotalCount
    FROM
        ECOLI_DATA
),
CategorizedColony AS (
    SELECT
        ID,
        SIZE_OF_COLONY,
        RN,
        TotalCount,
        CASE
            WHEN RN <= TotalCount * 0.25 THEN 'CRITICAL'
            WHEN RN <= TotalCount * 0.50 THEN 'HIGH'
            WHEN RN <= TotalCount * 0.75 THEN 'MEDIUM'
            ELSE 'LOW'
        END AS COLONY_NAME
    FROM
        RankedColony
)
SELECT
    ID,
    COLONY_NAME
FROM
    CategorizedColony
ORDER BY
    ID;
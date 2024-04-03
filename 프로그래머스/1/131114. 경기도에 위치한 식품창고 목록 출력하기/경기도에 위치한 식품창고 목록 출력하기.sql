-- 코드를 입력하세요
SELECT warehouse_id, warehouse_name, address, NVL(freezer_yn, 'N')
FROM food_warehouse
WHERE SUBSTR(address, 1, 3) = '경기도'
ORDER BY warehouse_id;
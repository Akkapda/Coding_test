-- 코드를 입력하세요
SELECT F.flavor
FROM first_half F JOIN icecream_info I ON
F.flavor = I.flavor
WHERE I.ingredient_type = 'fruit_based' AND F.total_order > 3000
ORDER BY F.total_order DESC;
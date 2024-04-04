-- 코드를 입력하세요
SELECT COUNT(*) users
FROM user_info
WHERE EXTRACT(YEAR FROM joined) = '2021' AND age >= 20 AND age < 30;
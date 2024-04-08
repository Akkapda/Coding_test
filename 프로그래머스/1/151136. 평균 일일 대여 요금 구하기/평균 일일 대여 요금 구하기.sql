-- 코드를 입력하세요
SELECT ROUND(AVG(daily_fee), 0) averaghe_fee
from car_rental_company_car
WHERE car_type = 'SUV';
-- 코드를 입력하세요
SELECT B.title, B.board_id, R.reply_id, R.writer_id, R.contents, 
TO_CHAR(R.created_Date, 'YYYY-MM-DD') created_date
FROM used_goods_board B 
INNER JOIN used_goods_reply R
ON B.board_id = R.board_id
WHERE TO_CHAR(B.created_Date, 'YYYY-MM') = '2022-10'
ORDER BY created_date ASC, B.title ASC;
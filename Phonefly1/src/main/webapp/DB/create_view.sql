-- 4개의 베스트 상품 view 생성
CREATE OR REPLACE VIEW main_best_pro_view AS
SELECT * FROM
(SELECT * FROM product WHERE bestyn='Y' ORDER BY indate DESC)
WHERE rownum <= 4;

SELECT * FROM main_best_pro_view;


-- 4개의 이벤트 상품 view 생성
CREATE OR REPLACE VIEW main_event_pro_view AS
SELECT * FROM
(SELECT * FROM product WHERE eventyn='Y' ORDER BY indate DESC)
WHERE rownum <= 4;

SELECT * FROM main_event_pro_view;

SELECT * FROM tabs
SELECT * FROM orders
SELECT * FROM order_detail

-- order_detail_view 생성


create or replace view order_detail_view
as
select  d.odseq, d.pseq, d.id, d.result, d.discount,
		d.buyplan, d.dcmonth, d.dctotal, d.mmonth, d.mtotal, d.cc, d.indate, d.cseq,
			p.price2, p.name as pname,
			c.name as cname, 
			r.name as rname 
from order_detail d, comm c, product p, rplan r
where d.rseq=r.rseq and r.mseq=c.mseq and d.pseq=p.pseq;





-- Order detail 처리용   order_detail_view2
CREATE OR REPLACE VIEW order_detail_view2 AS
SELECT O.*, P.price2 price, P.name pname, P.mfc, R.name rname, R.charge, R.dataplan, R.timeplan, R.textplan, C.name cname, CC.name ccname, CC.image, M.name mname
FROM order_detail O, product P, rplan R, comm C, color CC, member M
WHERE O.rseq = R.rseq(+) AND R.mseq = C.mseq AND O.pseq = P.pseq(+) AND O.cseq = CC.cseq(+) AND O.id = M.id(+)
ORDER BY odseq DESC;


-- Product detail의 review 조회용 (pseq의 전체 review)
CREATE OR REPLACE VIEW review_view AS
SELECT R.*, M.name FROM review R, member M WHERE R.id = M.id ORDER BY rvseq DESC;

-- reviewList의 내가 작성한 후기 조회용 (제품 이름 조회)
CREATE OR REPLACE VIEW review_for_member_view AS
SELECT R.*, P.name pname FROM review R, product P WHERE R.pseq = P.pseq ORDER BY rvseq DESC;

DROP TABLE member;

select * from orders

CREATE TABLE member (
	id	varchar2(20)		NOT NULL,
	pwd	varchar2(20)		NOT NULL,
	name	varchar2(20)		NOT NULL,
	email	varchar2(40)		NOT NULL,
	zipnum	varchar2(10)		NOT NULL,
	address1	varchar2(100)		NOT NULL,
	address2	varchar2(100)		NOT NULL,
	phone	varchar2(20)		NOT NULL,
	useyn	char(1)		DEFAULT 'Y'
);



DROP TABLE address;

CREATE TABLE address (
	zip_num	varchar2(10)		NOT NULL,
	sido	varchar(30)		NOT NULL,
	gugun	varchar2(50)		NOT NULL,
	zip_code	varchar2(30)		NULL,
	bunji	varchar2(30)		NULL,
	dong	varchar2(100)		NULL
);

DROP TABLE orders;

CREATE TABLE orders (
	oseq	number(10)		NOT NULL,
	id	varchar2(20)		NOT NULL,
	indate	date	DEFAULT SYSDATE
);


DROP TABLE cart;

CREATE TABLE cart (
	cseq	number(10)		NOT NULL,
	id	varchar2(20)		NOT NULL,
	pseq	number(10)		NOT NULL,
	quantity	number(5)	DEFAULT 1	NOT NULL,
	result	char(1)	DEFAULT '1',
	indate	date	DEFAULT SYSDATE
);


DROP TABLE worker;

CREATE TABLE worker (
	id	varchar2(20)		NOT NULL,
	pwd	varchar2(20)		NOT NULL,
	name	varchar2(20)		NOT NULL
);

DROP TABLE notice;

CREATE TABLE notice (
	nseq	number(5)		NOT NULL,
	id	varchar2(20)		NOT NULL,
	subject	varchar2(100)		NOT NULL,
	content	varchar2(3000)		NOT NULL,
	indate	date	DEFAULT SYSDATE
);

DROP TABLE order_detail;

CREATE TABLE order_detail (
	odseq	number(10)		NOT NULL,
	oseq	number(10)		NOT NULL,
	pseq	number(10)		NOT NULL,
    rseq    number(10)      NOT NULL,
	quantity	number(5)		NOT NULL,
	result	char(1)	DEFAULT '1'
);

DROP TABLE review;

CREATE TABLE review (
	rseq	number(10)		NOT NULL,
	id	varchar2(20)		NOT NULL,
	subject	varchar2(100)		NOT NULL,
	content	varchar2(1000)		NOT NULL,
	indate	date	DEFAULT SYSDATE
);


DROP TABLE product;

CREATE TABLE product (
	pseq	number(10)		NOT NULL,
	name	varchar2(100)		NOT NULL,
	price1	number(10)		NOT NULL,
	price2	number(10)		NOT NULL,
	price3	number(10)		NOT NULL,
	content	varchar2(1000)		NOT NULL,
	useyn	char(1)	DEFAULT 'Y',
	eventyn	char(1)	DEFAULT 'N',
	bestyn	char(1)	DEFAULT 'N',
	indate	date	DEFAULT SYSDATE,
	mfc	VARCHAR2(255)		NULL
);

DROP TABLE qna;

CREATE TABLE qna (
	qseq	number(5)		NOT NULL,
	id	varchar2(20)		NOT NULL,
	subject	varchar2(100)		NOT NULL,
	content	varchar2(3000)		NOT NULL,
	reply	varchar2(1000)		NULL,
	rep	char(1)	DEFAULT '1',
	indate	date	DEFAULT SYSDATE
);


DROP TABLE event;

CREATE TABLE event (
	eseq	number(10)		NOT NULL,
	id	varchar2(20)		NOT NULL,
	subject	varchar2(100)		NOT NULL,
	content	varchar2(1000)		NOT NULL,
	indate	date	DEFAULT SYSDATE
);

DROP TABLE comm;

CREATE TABLE comm (
	mseq	number(10)		NOT NULL,
	name	varchar2(20)		NOT NULL
);


DROP TABLE rplan;

CREATE TABLE rplan (
	rseq	number(10)		NOT NULL,
	mseq	number(10)		NOT NULL,
	name	varchar2(100)		NOT NULL,
	charge	number(10)		NOT NULL,
	dataplan	varchar2(30)		NOT NULL,
	timeplan	varchar2(30)		NOT NULL,
	textplan	varchar2(30)	DEFAULT '무제한'
);

DROP TABLE color;

CREATE TABLE color (
	cseq	number(10)		NOT NULL,
	pseq	number(10)		NOT NULL,
	name	varchar2(50)	NOT NULL,
	ccode	varchar2(20)	NOT NULL,
	image	varchar2(255)	NULL
);

ALTER TABLE member ADD CONSTRAINT PK_MEMBER PRIMARY KEY (
	id
);

ALTER TABLE orders ADD CONSTRAINT PK_ORDERS PRIMARY KEY (
	oseq
);

ALTER TABLE cart ADD CONSTRAINT PK_CART PRIMARY KEY (
	cseq
);

ALTER TABLE worker ADD CONSTRAINT PK_WORKER PRIMARY KEY (
	id
);

ALTER TABLE notice ADD CONSTRAINT PK_NOTICE PRIMARY KEY (
	nseq
);

ALTER TABLE order_detail ADD CONSTRAINT PK_ORDER_DETAIL PRIMARY KEY (
	odseq
);

ALTER TABLE review ADD CONSTRAINT PK_REVIEW PRIMARY KEY (
	rseq
);

ALTER TABLE product ADD CONSTRAINT PK_PRODUCT PRIMARY KEY (
	pseq
);

ALTER TABLE qna ADD CONSTRAINT PK_QNA PRIMARY KEY (
	qseq
);

ALTER TABLE event ADD CONSTRAINT PK_EVENT PRIMARY KEY (
	eseq
);

ALTER TABLE comm ADD CONSTRAINT PK_COMM PRIMARY KEY (
	mseq
);

ALTER TABLE rplan ADD CONSTRAINT PK_RPLAN PRIMARY KEY (
	rseq
);

ALTER TABLE color ADD CONSTRAINT PK_COLOR PRIMARY KEY (
	cseq
);








alter table orders drop constraint FK_member_TO_orders_1;

ALTER TABLE orders ADD CONSTRAINT FK_member_TO_orders_1 FOREIGN KEY (
	id
)
REFERENCES member (
	id
) ON DELETE CASCADE;


alter table cart drop constraint FK_member_TO_cart_1;

ALTER TABLE cart ADD CONSTRAINT FK_member_TO_cart_1 FOREIGN KEY (
	id
)
REFERENCES member (
	id
) ON DELETE CASCADE;


alter table cart drop constraint FK_product_TO_cart_1;

ALTER TABLE cart ADD CONSTRAINT FK_product_TO_cart_1 FOREIGN KEY (
	pseq
)
REFERENCES product (
	pseq
) ON DELETE CASCADE;


alter table notice drop constraint FK_worker_TO_notice_1;

ALTER TABLE notice ADD CONSTRAINT FK_worker_TO_notice_1 FOREIGN KEY (
	id
)
REFERENCES worker (
	id
) ON DELETE CASCADE;


alter table order_detail drop constraint FK_orders_TO_order_detail_1;

ALTER TABLE order_detail ADD CONSTRAINT FK_orders_TO_order_detail_1 FOREIGN KEY (
	oseq
)
REFERENCES orders (
	oseq
) ON DELETE CASCADE;


alter table order_detail drop constraint FK_product_TO_order_detail_1;

ALTER TABLE order_detail ADD CONSTRAINT FK_product_TO_order_detail_1 FOREIGN KEY (
	pseq
)
REFERENCES product (
	pseq
) ON DELETE CASCADE;


alter table order_detail drop constraint FK_rplan_TO_order_detail_1;

ALTER TABLE order_detail ADD CONSTRAINT FK_rplan_TO_order_detail_1 FOREIGN KEY (
	rseq
)
REFERENCES rplan (
	rseq
) ON DELETE CASCADE;


alter table review drop constraint FK_member_TO_review_1;

ALTER TABLE review ADD CONSTRAINT FK_member_TO_review_1 FOREIGN KEY (
	id
)
REFERENCES member (
	id
) ON DELETE CASCADE;


alter table qna drop constraint FK_member_TO_qna_1;

ALTER TABLE qna ADD CONSTRAINT FK_member_TO_qna_1 FOREIGN KEY (
	id
)
REFERENCES member (
	id
) ON DELETE CASCADE;


alter table event drop constraint FK_worker_TO_event_1;

ALTER TABLE event ADD CONSTRAINT FK_worker_TO_event_1 FOREIGN KEY (
	id
)
REFERENCES worker (
	id
) ON DELETE CASCADE;


alter table rplan drop constraint FK_comm_TO_rplan_1;

ALTER TABLE rplan ADD CONSTRAINT FK_comm_TO_rplan_1 FOREIGN KEY (
	mseq
)
REFERENCES comm (
	mseq
) ON DELETE CASCADE;


alter table color drop constraint FK_product_TO_color_1;

ALTER TABLE color ADD CONSTRAINT FK_product_TO_color_1 FOREIGN KEY (
	pseq
)
REFERENCES product (
	pseq
) ON DELETE CASCADE;

-- orders 와 order_detail 의 join 으로 
-- 1. 주문번호(oseq)에 따른 주문상품들의 표시 
-- 2. 상품번호에 따른 상품 이름과 가격 등의 정보 표시
-- 3. 아이디에 따른 고객 이름과 배송주소 등의 정보 표시

create or replace view order_view
as
select  d.odseq, o.oseq, o.indate, o.id, 
			m.name as mname, m.zip_num, m.address1, m.address2, m.phone,
			d.pseq, p.price2, d.quantity, d.result, p.name as pname
from orders o, order_detail d, member m, product p
where o.oseq=d.oseq and o.id=m.id and d.pseq=p.pseq;

select * from order_view;



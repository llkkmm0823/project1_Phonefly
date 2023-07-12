-- order_detail 필드 추가
alter table order_detail add discount number(1)not null; --할인 방법 (공시지원/ 선택약정)

alter table order_detail add buyplan number(2) not null; --구매 방법 (0/24/30/36)

alter table order_detail add dcmonth number(20) not null; --할부금

alter table order_detail add dctotal number(20) not null; --할부원금

alter table order_detail add mmonth number(20) not null; --통신요금

alter table order_detail add mtotal number(20) not null; --월 총 납부금액

alter table order_detail add cc char(1) not null; -- 통신사 변경 / 기기 변경
use DreamHome;
select * from Viewing;

DELIMITER $$
CREATE PROCEDURE GetQueryData()
BEGIN
SELECT b.Bno, b.city, s.Sno, s.fName, s.lName, p.Pno
FROM Branch b, Staff s, Property_For_Rent p
WHERE b.Bno = s.Bno AND s.Sno = p.Sno
ORDER BY b.Bno, s.Sno, p.Pno;
END$$
DELIMITER ;
CALL GetQueryData();

DELIMITER //
CREATE PROCEDURE proc_Add(IN var1 INT)
BEGIN
select var1 +2 as result;
END//
DELIMITER ;

call  proc_Add(6);
# Multiplication
DELIMITER //
create  procedure  proc_mul(IN var1 INT)
BEGIN
    select var1 *2 as result;
end //
delimiter ;
call proc_mul(6);

#A procedure using if else
drop PROCEDURE if exists simple_loop;
delimiter $$
create  PROCEDURE  simple_loop()
deterministic
begin
    declare counter int default 0;
    simple_loop:LOOP
        set  counter=counter+1;
        if counter=10 THEN
            leave simple_loop;
        end if ;
    end loop simple_loop;
    select 'I can count to 10';
end;
call  simple_loop();

create  database TENNIS;
use Tennis;

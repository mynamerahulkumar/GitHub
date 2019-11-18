use  orders;
/*
 1.	Write a Query to display the  product id, product description and product  price of products  whose product id
 less than 1000 and that have the same price more than once.
(USE SUB-QUERY)(15 ROWS)[NOTE:PRODUCT TABLE]
 */
 #select product_id,product_desc,product_price from PRODUCT where product_id<1000 and product_price in
#first it will filter the table then select first p_id from outer query and then match with p_id inner query
select p1.PRODUCT_ID,p1.PRODUCT_DESC,p1.PRODUCT_PRICE from PRODUCT p1
where p1.PRODUCT_PRICE in (select distinct p2.PRODUCT_PRICE from PRODUCT p2 where p1.PRODUCT_ID!=p2.PRODUCT_ID) and
      p1.PRODUCT_ID<1000;

/*

2.	Write a query to display product class description ,total quantity(sum(product_quantity),
Total value (product_quantity * product price) and show which class of products have been shipped highest to countries
outside India other than USA? Also show the total value of those items.
 (1 ROWS)[NOTE:PRODUCT TABLE,ADDRESS TABLE,ONLINE_CUSTOMER TABLE,ORDER_HEADER TABLE,ORDER_ITEMS TABLE,PRODUCT_CLASS TABLE]

 */
select pc.PRODUCT_CLASS_DESC,(sum(oi.PRODUCT_QUANTITY)) total_quantity,sum(oi.PRODUCT_QUANTITY*p1.PRODUCT_PRICE) total_value
from PRODUCT p1 join ORDER_ITEMS oi on p1.PRODUCT_ID=oi.PRODUCT_ID join ORDER_HEADER oh on oi.ORDER_ID=oh.ORDER_ID
join ONLINE_CUSTOMER oc on oc.CUSTOMER_ID=oh.CUSTOMER_ID join PRODUCT_CLASS pc on pc.PRODUCT_CLASS_CODE=p1.PRODUCT_CLASS_CODE join ADDRESS
A on A.ADDRESS_ID=oc.ADDRESS_ID where A.COUNTRY not in ('USA','India')
group by pc.PRODUCT_CLASS_DESC order by total_quantity desc  limit 1;

/*
 3.	Write a query to display the customer id, customer first name, address line 2,city
 total sales(sum(product quantity * product price (0 if they haven't purchased any item)) made by customers
 who stay in the same locality (i.e. same address_line2 & city). (USE SUB-QUERY)
(4 ROWS)
[NOTE : ADDRESS,ONLINE_CUSTOMER,ORDER_HEADER,ORDER_ITEMS,PRODUCT]
 */
select oc.CUSTOMER_ID,oc.CUSTOMER_FNAME,a.ADDRESS_LINE2,a.CITY,sum(oi.PRODUCT_QUANTITY*p.PRODUCT_PRICE) total_sales
 from ADDRESS a right outer join ONLINE_CUSTOMER oc on oc.ADDRESS_ID=a.ADDRESS_ID right outer join ORDER_HEADER oh on
     oh.CUSTOMER_ID=oc.CUSTOMER_ID right outer
join ORDER_ITEMS oi on oi.ORDER_ID=oh.ORDER_ID join PRODUCT P on oi.PRODUCT_ID = P.PRODUCT_ID where
                                                                            a.ADDRESS_LINE2 in(select a2.ADDRESS_LINE2
from ADDRESS a2 where a.ADDRESS_ID!=a2.ADDRESS_ID) and a.CITY in (select a2.CITY
from ADDRESS a2 where a.ADDRESS_ID!=a2.ADDRESS_ID)
group by oc.CUSTOMER_FNAME, oc.CUSTOMER_ID ;
select * from ADDRESS;

# and a.CITY in(select a2.CITY
 #   from ADDRESS a2 where a.ADDRESS_ID!=a2.ADDRESS_ID);

/*
 4.	Write a Query to display product id,product description,totalquantity(sum(product quantity)
 For a given item whose product id is 201 and which item has been bought along with it  maximum no. of times.
(USE SUB-QUERY)(1 ROW)[NOTE : ORDER_ITEMS TABLE,PRODUCT TABLE]

 */

select p.PRODUCT_ID,p.PRODUCT_DESC,sum(oi.PRODUCT_QUANTITY) total_quantity
from PRODUCT p join ORDER_ITEMS OI on p.PRODUCT_ID = OI.PRODUCT_ID
where p.PRODUCT_ID=(select oi1.PRODUCT_ID from ORDER_ITEMS oi1 where oi1.ORDER_ID in (
select oi.ORDER_ID from ORDER_ITEMS oi where oi.PRODUCT_ID=201) group by oi1.PRODUCT_ID order by count(*) desc limit 1,1)
group by p.PRODUCT_ID, p.PRODUCT_DESC;
#select oi1.PRODUCT_ID from ORDER_ITEMS oi1 where oi1.ORDER_ID in (
#select oi.ORDER_ID from ORDER_ITEMS oi where oi.PRODUCT_ID=201) group by oi1.PRODUCT_ID order by count(*) desc limit 1,1;


/*
 5.	Write a Query to display the month,total quantity(sum(product quantity)) and show during
 which month of the year do foreign customers tend to buy max. no. of products.
(USE-SUB-QUERY)
(1ROW)[NOTE:ORDER_ITEMSTABLE,ORDER_HEADERTABLE,ONLINE_CUSTOMER TABLE,ADDRESS TABLE]
 */
select month(oh.ORDER_DATE) month,sum(oi.PRODUCT_QUANTITY) total_quantity from ORDER_ITEMS oi join ORDER_HEADER oh on oi.ORDER_ID=oh.ORDER_ID
where oh.CUSTOMER_ID not in (select oc.CUSTOMER_ID from ONLINE_CUSTOMER oc join ADDRESS A on oc.ADDRESS_ID = A.ADDRESS_ID where A.COUNTRY!='India')
group by month(oh.ORDER_DATE) order by total_quantity desc limit 1;











/*
6.	Write a Query to display customer id,customer firstname,lastname,order status,total
value(sum(product quantity * product price)) and show who is the most valued customer (customer who made the highest sales)
(1 ROW) [NOTE: ONLINE_CUSTOMER TABLE, ORDER_HEADER TABLE, ORDER_ITEMS TABLE, PRODUCT TABLE]

 */
select  oc.CUSTOMER_ID,oc.CUSTOMER_FNAME,oc.CUSTOMER_LNAME,sum(oi.PRODUCT_QUANTITY*p1.PRODUCT_PRICE) total_value
from PRODUCT p1 join ORDER_ITEMS oi on p1.PRODUCT_ID=oi.PRODUCT_ID join ORDER_HEADER oh on oi.ORDER_ID=oh.ORDER_ID
join ONLINE_CUSTOMER oc on oc.CUSTOMER_ID=oh.CUSTOMER_ID  group by oc.CUSTOMER_ID, oc.CUSTOMER_FNAME, oc.CUSTOMER_LNAME
order by total_value desc limit 1;
/*
 7.	Write a query to display product class code,product class desc,product id product description,
 product price and show the most expensive products in their respective classes.
(16 ROWS)[NOTE : PRODUCT TABLE,PRODUCT CLASS TABLE]

 */

 select * from PRODUCT;
select p.PRODUCT_CLASS_CODE,pc.PRODUCT_CLASS_DESC,p.PRODUCT_ID,max(p.PRODUCT_PRICE) from PRODUCT p
    join PRODUCT_CLASS PC on pc.PRODUCT_CLASS_CODE = PC.PRODUCT_CLASS_CODE group
        by p.PRODUCT_CLASS_CODE, pc.PRODUCT_CLASS_DESC, p.PRODUCT_ID;

select PRODUCT.PRODUCT_CLASS_CODE ,max(PRODUCT.PRODUCT_PRICE) from PRODUCT group by PRODUCT.PRODUCT_CLASS_CODE;



/*
 8.	Write a query to display shipper id,shipper name , (len*width*height*product_quantity)
 as total volume shipped and show Which shipper has shipped highest volume of items.
(1 ROW) [NOTE : SHIPPER TABLE,ORDER_HEADER TABLE,ORDER_ITEMS TABLE,PRODUCT TABLE]

 */
 use orders;
select oh.SHIPPER_ID,s.SHIPPER_NAME,sum(p.LEN*p.WIDTH*p.HEIGHT*oi.PRODUCT_QUANTITY) volume
from SHIPPER s join  ORDER_HEADER oh on oh.SHIPPER_ID=s.SHIPPER_ID join ORDER_ITEMS oi on oi.ORDER_ID=oh.ORDER_ID
join PRODUCT P on oi.PRODUCT_ID = P.PRODUCT_ID group by oh.SHIPPER_ID, s.SHIPPER_NAME order by volume desc  limit 1;

/*
 9.	Write a query to display  carton id ,(len*width*height) as carton_vol and
 identify the optimum carton (carton with the least volume whose volume is greater than the total volume of
 all items) for a given order whose order id is 10006 ,
 Assume all items of an order are packed into one single carton (box) .(1 ROW)[NOTE : CARTON TABLE]
 */
 select c.CARTON_ID,(c.LEN*c.WIDTH*c.HEIGHT) as cartoon_vol  from CARTON c order by  cartoon_vol limit 1;

/*
 10.	Write a query to display product id,product
 description,total_quantity (sum(order_quantity) ,
 Provided show the most and least sold products
(quantity-wise).(3 ROWS)(USE:SUB-QUERY)

 */

select p.PRODUCT_ID,p.PRODUCT_DESC ,sum(oi1.PRODUCT_QUANTITY) total from PRODUCT p join ORDER_ITEMS oi1 on
    oi1.PRODUCT_ID=p.PRODUCT_ID where p.PRODUCT_ID in (
select oi.PRODUCT_ID from ORDER_ITEMS oi group by oi.PRODUCT_ID having sum(oi.PRODUCT_QUANTITY) in(
(select sum(oi.PRODUCT_QUANTITY) total from ORDER_ITEMS oi  group by oi.PRODUCT_ID order by  total desc  limit 1),
(select sum(oi.PRODUCT_QUANTITY) total from ORDER_ITEMS oi group by oi.PRODUCT_ID order by  total   limit 1))) group by p.PRODUCT_ID, p.PRODUCT_DESC;


use orders;
show  tables ;

/*
#1.	Write a query to Display the product details (product_class_code, product_id, product_desc, product_price,)
  as per the following criteria and sort them in descending order of category:
a.	If the category is 2050, increase the price by 2000
b.	If the category is 2051, increase the price by 500
c.	If the category is 2052, increase the price by 600.
(60 ROWS)[NOTE:PRODUCT TABLE]*/
select PRODUCT.PRODUCT_CLASS_CODE,PRODUCT.PRODUCT_ID,PRODUCT.PRODUCT_DESC ,
case when  PRODUCT.PRODUCT_CLASS_CODE=2050 then PRODUCT.PRODUCT_PRICE=PRODUCT.PRODUCT_PRICE+2000
when PRODUCT.PRODUCT_CLASS_CODE=2051 then PRODUCT.PRODUCT_PRICE=PRODUCT.PRODUCT_PRICE+500
when PRODUCT.PRODUCT_CLASS_CODE=2052 then PRODUCT.PRODUCT_PRICE=PRODUCT.PRODUCT_PRICE+600
else PRODUCT.PRODUCT_PRICE end as PRODUCT_PRICE from PRODUCT order by PRODUCT_CLASS_CODE desc ;


/*
 2.	Write a Query to display the  the product description, product class description and product price of
 all products which are shipped.(168 rows)
[NOTE : TABLE TO BE USED:PRODUCT_CLASS,PRODUCT, ORDER_ITEMS,ORDER_HEADER]


 */

select p.PRODUCT_DESC,PC.PRODUCT_CLASS_DESC,p.PRODUCT_PRICE from PRODUCT p join PRODUCT_CLASS PC on
    p.PRODUCT_CLASS_CODE = PC.PRODUCT_CLASS_CODE
join ORDER_ITEMS o on o.PRODUCT_ID=p.PRODUCT_ID join ORDER_HEADER oh on o.ORDER_ID=oh.ORDER_ID where oh.ORDER_STATUS='Shipped';

/*
 3.	Write a query to display the  customer_id,customer name, email and order details (order id, product desc,product  qty,
 subtotal(product_quantity * product_price)) for all customers even if they have not ordered any item.(225 ROWS)
[NOTE : TABLE TO BE USED - online_customer, order_header, order_items, product]

 */
select oc.CUSTOMER_ID,concat(oc.CUSTOMER_FNAME,' ',oc.CUSTOMER_LNAME) customer_name,oc.CUSTOMER_EMAIL,ot.ORDER_ID,p.PRODUCT_DESC,ot.PRODUCT_QUANTITY,
       (ot.PRODUCT_QUANTITY*p.PRODUCT_PRICE) product_qty
       from ONLINE_CUSTOMER oc     left outer join    ORDER_HEADER oh on oc.CUSTOMER_ID=oh.CUSTOMER_ID left outer join  ORDER_ITEMS
           ot on oh.ORDER_ID=ot.ORDER_ID
left outer join  PRODUCT p on p.PRODUCT_ID=ot.PRODUCT_ID;

select * from ORDER_HEADER;
 /*
  4.	Write a query to display the customer_id,customer full name ,city,pincode,and order details
  (order id,order date, product class desc, product desc, subtotal(product_quantity * product_price))
  for orders shipped to cities whose pin codes do not have any 0s in them. Sort the output on customer name,
  order date and subtotal.(52 ROWS)
[NOTE : TABLE TO BE USED - online_customer, address, order_header, order_items, product, product_class]
  */
select A.CITY,A.PINCODE,oc.CUSTOMER_ID,concat(oc.CUSTOMER_FNAME,' ',oc.CUSTOMER_LNAME) customer_name,oc.CUSTOMER_EMAIL,
       ot.ORDER_ID,p.PRODUCT_DESC,ot.PRODUCT_QUANTITY,
       (ot.PRODUCT_QUANTITY*p.PRODUCT_PRICE) total
       from ONLINE_CUSTOMER oc join ORDER_HEADER oh on oc.CUSTOMER_ID=oh.CUSTOMER_ID join ORDER_ITEMS ot on oh.ORDER_ID=ot.ORDER_ID
join PRODUCT p on p.PRODUCT_ID=ot.PRODUCT_ID join ADDRESS A on oc.ADDRESS_ID = A.ADDRESS_ID where A.PINCODE not like '%0%'
                                                                                              and oh.ORDER_STATUS='Shipped' ;
/*


5.	Write a query to display (customer id,customer fullname,city) of customers  from outside ‘Karnataka’ who haven’t bought any
toys or books.(19 ROWS)
  [NOTE : TABLES TO BE USED – online_customer, address,
   order_header, order_items, product, product_class].

 */
select A.CITY,oc.CUSTOMER_ID,concat(oc.CUSTOMER_FNAME,' ',oc.CUSTOMER_LNAME) customer_name
       from ONLINE_CUSTOMER oc join ADDRESS A on oc.ADDRESS_ID = A.ADDRESS_ID join ORDER_HEADER OH on oc.CUSTOMER_ID = OH.CUSTOMER_ID
join ORDER_ITEMS OI on OH.ORDER_ID = OI.ORDER_ID join PRODUCT P on OI.PRODUCT_ID = P.PRODUCT_ID join PRODUCT_CLASS pc on p.PRODUCT_CLASS_CODE=pc.PRODUCT_CLASS_CODE
where
A.STATE !='Karnataka' and pc.PRODUCT_CLASS_DESC not in ('Toys','Books') ;
select * from ADDRESS;
/*
 6.	 Write a query to display  details (customer id,customer fullname,order id,product quantity) of customers who
 bought more than ten (i.e. total order qty) products per order.
(11 ROWS)
[NOTE : TABLES TO BE USED - online_customer, order_header, order_items]

 */
select oc.CUSTOMER_ID,concat(oc.CUSTOMER_FNAME,' ',oc.CUSTOMER_LNAME) customer_name,ot.ORDER_ID,sum(ot.PRODUCT_QUANTITY)
from ONLINE_CUSTOMER oc join ORDER_HEADER oh on oc.CUSTOMER_ID=oh.CUSTOMER_ID join ORDER_ITEMS ot on oh.ORDER_ID=ot.ORDER_ID
group by ot.ORDER_ID,oc.CUSTOMER_ID ,concat(oc.CUSTOMER_FNAME,' ',oc.CUSTOMER_LNAME) having sum(ot.PRODUCT_QUANTITY)>10;
#select * from ORDER_ITEMS order by  PRODUCT_QUANTITY desc ;
#select sum(ORDER_ITEMS.PRODUCT_QUANTITY) total_order ,ORDER_ITEMS.ORDER_ID from ORDER_ITEMS group by  ORDER_ITEMS.ORDER_ID having
#total_order >10;
/*
 7.	Write a query to display the customer full name and total order value(product_quantity*product_price)
 of premium customers (i.e. the customers who bought items total worth > Rs. 1 lakh.)(2 ROWS)
[ NOTE : TABLES TO BE USED – ONLINE_CUSTOMER,ORDER_HEADER,
ORDER_ITEMS,PRODUCT]

 */

select concat(t.customer_fname,' ', t.customer_lname) as cust_name, sum(i.product_quantity * p.product_price) as tov
from online_customer t
join order_header h on t.customer_id=h.customer_id
join order_items i on h.order_id=i.order_id
join product p on i.product_id=p.product_id
group by cust_name
having sum(i.product_quantity * p.product_price)>100000;

#select * from ONLINE_CUSTOMER;
#select * from ORDER_ITEMS;
/*
 8.	Write a query to display the customer id and cutomer full name of customers along with (product_quantity) as
 total quantity of products ordered for order ids > 10060.(6 ROWS)
[NOTE : TABLES TO BE USED - online_customer, order_header, order_items]

 */
select t.customer_id, concat(t.customer_fname,' ', t.customer_lname) as cust_name, sum(i.product_quantity) as total_quan
from online_customer t
join order_header h on t.customer_id=h.customer_id
join order_items i on h.order_id=i.order_id
where h.order_id>10060 group by t.customer_id,cust_name;



#group by oh.ORDER_ID
/*
9.	Write a query to display (product_class_desc, product_id, product_desc, product_quantity_avail ) and
Show inventory status of products as below as per their available quantity:
a.	For Electronics and Computer categories, if available quantity is < 10, show 'Low stock', 11 < qty < 30, show 'In stock', > 31,
show 'Enough stock'
b.	For Stationery and Clothes categories, if qty < 20, show 'Low stock', 21 < qty < 80, show 'In stock', > 81, show 'Enough stock'
c.	Rest of the categories, if qty < 15 – 'Low Stock', 16 < qty < 50 – 'In Stock', > 51 – 'Enough stock'
For all categories, if available quantity is 0, show 'Out of
stock'.
(60  ROWS)[NOTE : TABLES TO BE USED – product, product_class].

 */
select PRODUCT_CLASS.PRODUCT_CLASS_DESC,PRODUCT.PRODUCT_DESC,
       case when PRODUCT.PRODUCT_QUANTITY_AVAIL <10 and PRODUCT_CLASS.PRODUCT_CLASS_DESC in ('Electronics','Computer')
            then 'Low Stock'
            when PRODUCT.PRODUCT_QUANTITY_AVAIL >11 and PRODUCT.PRODUCT_QUANTITY_AVAIL <30 and PRODUCT_CLASS.PRODUCT_CLASS_DESC in ('Electronics','Computer')
            then 'In stock'
            when PRODUCT.PRODUCT_QUANTITY_AVAIL >31 and PRODUCT_CLASS.PRODUCT_CLASS_DESC in ('Electronics','Computer')
            then 'Enough Stock'
            when PRODUCT.PRODUCT_QUANTITY_AVAIL <20 and PRODUCT_CLASS.PRODUCT_CLASS_DESC in ('Stationery','Clothes')
            then 'Low Stock'
            when PRODUCT.PRODUCT_QUANTITY_AVAIL >21 and PRODUCT.PRODUCT_QUANTITY_AVAIL <80  and PRODUCT_CLASS.PRODUCT_CLASS_DESC in ('Stationery','Clothes')
            then 'In Stock'
            when PRODUCT.PRODUCT_QUANTITY_AVAIL >81 and PRODUCT_CLASS.PRODUCT_CLASS_DESC in ('Stationery','Clothes')
            then 'Enough Stock'
             when PRODUCT.PRODUCT_QUANTITY_AVAIL <15 and PRODUCT_CLASS.PRODUCT_CLASS_DESC not in ('Stationery','Clothes','Electronics','Computer')
            then 'Low Stock'
            when PRODUCT.PRODUCT_QUANTITY_AVAIL >16 and PRODUCT.PRODUCT_QUANTITY_AVAIL <50  and PRODUCT_CLASS.PRODUCT_CLASS_DESC not  in ('Stationery','Clothes','Electronics','Computer')
            then 'In Stock'
            when PRODUCT.PRODUCT_QUANTITY_AVAIL >51 and PRODUCT_CLASS.PRODUCT_CLASS_DESC not  in ('Stationery','Clothes','Electronics','Computer')
            then 'Enough Stock'
            end as Status_avail from PRODUCT  join  PRODUCT_CLASS  on PRODUCT_CLASS.PRODUCT_CLASS_CODE=PRODUCT.PRODUCT_CLASS_CODE;








# Write your MySQL query statement below
select e1.product_name,e2.year,e2.price from Product e1 inner join Sales e2
on e1.product_id = e2.product_id;
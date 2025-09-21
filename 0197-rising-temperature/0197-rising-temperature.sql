# Write your MySQL query statement below 
select t2.id as Id from Weather t1 inner join Weather t2
on t1.temperature < t2.temperature
where adddate(t1.recordDate,interval 1 day) = t2.recordDate;
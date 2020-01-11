use estatejdbc82019;

select * from building ORDER BY name limit 0, 2;

select * from building ORDER BY name limit 2, 2;

select * from building where lower(name) like '%building%';

select * from building where buildingarea = 650;

select * from building where (costrent >= 10 and costrent <= 20);

select * from building where (type like '%TANG_TRET%' or type like '%NGUYEN_CAN%');

select * from building b 
where exists 
(select * from rentarea ra where (b.id = ra.buildingid and ra.value >= 100 and ra.value <= 200));

select * from building b inner join assignmentstaff s on b.id = s.buildingid
where s.userid = 2; 


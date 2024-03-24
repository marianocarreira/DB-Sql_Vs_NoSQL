SELECT p.* FROM POSTS p
inner join PostTypes pt
on p.PostTypeId = pt.Id
inner join Users ou
on p.OwnerUserId = ou.Id
WHERE ou.id = 11

--11 = Anonymous
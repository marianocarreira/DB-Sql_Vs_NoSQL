SELECT TOP 100000 * FROM POSTS p
inner join PostTypes pt
on p.PostTypeId = pt.Id
inner join Users ou
on p.OwnerUserId = ou.Id;
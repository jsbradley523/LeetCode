select c.Name as Customers
  from Customers c
    where c.Id not in (
      select distinct o.CustomerId
        from Orders o
    );
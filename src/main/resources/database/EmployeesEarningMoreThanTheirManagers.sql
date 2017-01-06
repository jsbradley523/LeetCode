select e.Name as Employee
  from Employee e
    left join Employee m
      on e.ManagerId = m.Id
    where e.Salary > m.Salary;
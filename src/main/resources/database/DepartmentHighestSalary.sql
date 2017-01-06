select Department, e2.Name as Employee, e2.Salary
  from
  --Have to account for multiple people tied for max salary. 
  (
    select d.Name as Department, d.Id DepartmentId, max(e.Salary) as Salary
      from Employee e
        join Department d
          on e.DepartmentId = d.Id
      group by d.Name
   ) maxSalary
     join Employee e2
       on maxSalary.DepartmentId = e2.DepartmentId
         where e2.Salary >= maxSalary.Salary;
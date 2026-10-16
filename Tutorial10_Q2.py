# Tutorial 10 - Question 2
# Employee salary increment

from functools import reduce

salaries = [35000, 42000, 28000, 50000, 39000]

# a) Revise salaries using map() and lambda
revised_salaries = list(map(
    lambda salary: salary * 1.10 if salary < 40000 else salary,
    salaries
))
print("Revised salaries:", revised_salaries)

# b) Identify employees eligible for increment using filter()
eligible = list(filter(lambda salary: salary < 40000, salaries))
print("Eligible salaries:", eligible)

# c) Total salary expenditure after revision
total = reduce(lambda a, b: a + b, revised_salaries, 0)
print("Total salary expenditure after revision: Rs.", total)

# d) Functional programming makes salary processing concise:
# map() revises salaries, filter() selects eligible salaries,
# and reduce() calculates the total.

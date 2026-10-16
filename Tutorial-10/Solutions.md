# APP — Tutorial 10 Solutions
Date: 15-10-2026

## 1. Student marks — functional programming

```python
from functools import reduce

marks = [45, 67, 82, 39, 50, 95]

# a) Students/marks scoring 50 or above
passed_marks = list(filter(lambda mark: mark >= 50, marks))
print("Marks >= 50:", passed_marks)

# b) Add 5 grace marks, with a maximum of 100
grace_marks = list(map(lambda mark: min(mark + 5, 100), marks))
print("After grace marks:", grace_marks)

# c) Total after grace marks
total = reduce(lambda a, b: a + b, grace_marks, 0)
print("Total marks:", total)
```

**d) Lambda:** A lambda is a short anonymous function. It keeps simple operations directly inside `filter()`, `map()`, and `reduce()` without defining separate functions.

## 2. Employee salary increment

```python
from functools import reduce

salaries = [35000, 42000, 28000, 50000, 39000]

# b) Employees eligible for the 10% increment
eligible = list(filter(lambda salary: salary < 40000, salaries))
print("Eligible salaries:", eligible)

# a) Revise salaries: add 10% only when salary is below 40000
revised = list(map(
    lambda salary: salary * 1.10 if salary < 40000 else salary,
    salaries
))
print("Revised salaries:", revised)

# c) Total salary expenditure after revision
total = reduce(lambda a, b: a + b, revised, 0)
print("Total revised salary expenditure: ₹", total)
```

**d) Why functional programming?** `map()` transforms every salary, `filter()` selects eligible salaries, and `reduce()` adds the revised salaries. These operations make the processing concise and easy to understand.

## 3. Product prices and festival discount

```python
prices = [500, 1200, 2500, 900, 1500]

# a) Pure function: returns a discounted price without changing the input
def discounted_price(price):
    if price > 1000:
        return price * 0.80
    return price

# c) Products costing more than ₹1000
eligible_products = list(filter(lambda price: price > 1000, prices))
print("Products over ₹1000:", eligible_products)

# b) Apply the discount to each price
new_prices = list(map(discounted_price, prices))
print("Prices after discount:", new_prices)

print("Original prices:", prices)
```

**d) Original list:** The function calculates and returns a new value; it does not assign to or modify the original list. Therefore, `prices` remains unchanged.

## 4. Daily electricity consumption

```python
from functools import reduce

consumption = [8, 12, 9, 15, 7, 11]
RATE = 6

# a) Days when consumption exceeded 10 units
high_usage = list(filter(lambda units: units > 10, consumption))
print("Consumption above 10 units:", high_usage)

# b) Cost for each day at ₹6 per unit
daily_cost = list(map(lambda units: units * RATE, consumption))
print("Daily cost:", daily_cost)

# c) Total electricity consumption
total_units = reduce(lambda a, b: a + b, consumption, 0)
print("Total units:", total_units)

# d) Pure function: computes the total bill without changing consumption
def electricity_bill(units_list):
    return sum(map(lambda units: units * RATE, units_list))

print("Total bill: ₹", electricity_bill(consumption))
print("Original consumption:", consumption)
```

## 5. Advanced programming course — logical programming (Prolog)

```prolog
% a) Facts
python_pass(arun).
data_structures_pass(arun).

python_pass(bala).
data_structures_fail(bala).

python_pass(charan).
data_structures_pass(charan).

python_fail(divya).
data_structures_pass(divya).

% b) Rule: must pass both subjects
eligible(Student) :-
    python_pass(Student),
    data_structures_pass(Student).

% c) Query
% ?- eligible(Student).
% Results: Student = arun ;
%          Student = charan.
```

## 6. Employee promotion — logical programming (Prolog)

```prolog
% a) Employee facts: experience in years, training status, rating
employee(ravi, 6, completed, 5).
employee(priya, 3, completed, 4).
employee(kumar, 8, not_completed, 5).
employee(meena, 7, completed, 4).

% b) Promotion rule
promotion_eligible(Name) :-
    employee(Name, Years, completed, Rating),
    Years >= 5,
    Rating >= 4.

% c) Query
% ?- promotion_eligible(Name).
% Results: Name = ravi ;
%          Name = meena.
```

## 7. Parking slot allocation — logical programming (Prolog)

```prolog
% a) Facts: slot, vehicle type, availability
parking_slot(s1, car, available).
parking_slot(s2, bike, occupied).
parking_slot(s3, car, available).
parking_slot(s4, bike, available).
parking_slot(s5, car, occupied).

% b) Rule for an available slot of a requested vehicle type
available_slot(Type, Slot) :-
    parking_slot(Slot, Type, available).

% c) Query for available car slots
% ?- available_slot(car, Slot).
% Results: Slot = s1 ;
%          Slot = s3.
```

---
**Note:** Questions 1–4 use Python functional programming. Questions 5–7 use Prolog-style logical facts, rules, and queries.

# Tutorial 10 - Question 1
# Student marks using functional programming

from functools import reduce

marks = [45, 67, 82, 39, 50, 95]

# a) Identify marks of 50 or above using filter()
passed = list(filter(lambda mark: mark >= 50, marks))
print("Marks 50 or above:", passed)

# b) Award 5 grace marks, maximum 100, using map()
grace_marks = list(map(lambda mark: min(mark + 5, 100), marks))
print("Marks after grace marks:", grace_marks)

# c) Calculate total marks using reduce()
total = reduce(lambda a, b: a + b, grace_marks, 0)
print("Total marks after grace marks:", total)

# d) Lambda functions are short anonymous functions.
# They make simple operations concise inside filter(), map(), and reduce().

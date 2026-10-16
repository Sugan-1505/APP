# Tutorial 10 - Question 4
# Daily electricity consumption

from functools import reduce

consumption = [8, 12, 9, 15, 7, 11]
RATE = 6  # Rs. 6 per unit

# a) Identify days with consumption above 10 units
high_usage = list(filter(lambda units: units > 10, consumption))
print("Consumption above 10 units:", high_usage)

# b) Calculate electricity cost for each day using map()
daily_cost = list(map(lambda units: units * RATE, consumption))
print("Daily electricity cost:", daily_cost)

# c) Calculate total consumption using reduce()
total_units = reduce(lambda a, b: a + b, consumption, 0)
print("Total consumption:", total_units, "units")

# d) Pure function to calculate the total bill
def electricity_bill(units_list):
    return sum(map(lambda units: units * RATE, units_list))

print("Total electricity bill: Rs.", electricity_bill(consumption))
print("Original consumption data:", consumption)

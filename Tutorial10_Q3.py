# Tutorial 10 - Question 3
# Product prices and festival discount

prices = [500, 1200, 2500, 900, 1500]

# a) Pure function to calculate discounted price
def discounted_price(price):
    if price > 1000:
        return price * 0.80  # 20% discount
    return price

# c) Identify products costing more than Rs. 1000
eligible_products = list(filter(lambda price: price > 1000, prices))
print("Products above Rs. 1000:", eligible_products)

# b) Apply the discount using map()
new_prices = list(map(discounted_price, prices))
print("Prices after discount:", new_prices)

# d) The function returns a new calculated value and does not
# modify the original list.
print("Original prices:", prices)

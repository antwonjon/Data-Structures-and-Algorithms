
#    Illustrates modification of a mutable parameter (a list).

def multAmount(balances, rate):
    for i in range(len(balances)):
        
        balances[i] = balances[i] * rate
    rate = 6

def test():
    amounts = [1000, 2200, 800, 360]
    rate = 2
    multAmount(amounts, rate)
    print amounts
    print rate

test()

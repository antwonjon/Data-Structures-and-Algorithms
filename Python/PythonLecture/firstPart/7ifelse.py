

import math 

def main():
    print "This program finds the real solutions to a quadratic\n"

    a, b, c = input("Please enter the 3 numbers (a, b, c): ")


    if a < b:
        print "\nA is smaller than B"
    elif a<c:
        root = -b / (2 * a)
        print "\n A is the middle number"
    else:
        print "\nA is the largest number "

main()


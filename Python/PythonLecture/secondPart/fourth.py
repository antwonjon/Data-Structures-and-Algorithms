##################
#calling functions
#   with input and return values
##################

print "outside main"

def main():
    print "This program has started"
    a = 5
    subFunCall(a)
    a = "char"
    print "returned from subfun"


def subFunCall(x):
    print "My variable: ", x, "."

main()

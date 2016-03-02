
def main():
    for i in range(10):
        print i
    print "after: ", i
    #test()
    
    second()
    third(range(4))

    
def test():
    print "Inside test : ", i


def second():
    for i in [1, 5, 7, 13]:
        print i

    a = ["one", "two", 3, 4]
    for i in a:
        print i

def third(which):
    arr = []
    for i in which:
        print "working: ", i
        arr.insert(i, i*i)
        
    print arr 
    
    
main()    


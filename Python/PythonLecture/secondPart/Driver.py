

from People import People

def main():
     first = People(18, "Helen")
     second = People(25, "Rick")
     third = People(40, "Margie")
     

     older = first.getOlder(second)
     #old = first.getOlder(3)
     print older, "is the oldest out of", first.name, "and", second.name
     print third.getOlder(first), "is the oldest out of", first.name, "and", third.name
     #print first.a
main()

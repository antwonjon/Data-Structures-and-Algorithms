#People class

class People:
    def __init__(self, a, n):
        self.age = a
        self.name = n

    def getOlder(self, p1):
        #a = none
        if self.age > p1.age :
            return self.name
        else:
            return p1.name

        

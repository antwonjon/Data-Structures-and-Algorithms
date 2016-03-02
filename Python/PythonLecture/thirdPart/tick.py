#PythonLab.py

from graphics import *
from random import randint

class PythonLab:
    def __init__(self, window, center, size):
        self.center = center
        
        p1 = Point(randint(1,9), randint(1,8))
        self.p2, self.p3 = p1.clone(), p1.clone()
        self.p2.move(-.3, -.3)
        self.p3.move(.3, .3)
        self.p4, self.p5 = p1.clone(), p1.clone()
        self.p4.move(-.3, .3)
        self.p5.move(.3, -.3)
        
        self.eye1 = Circle(Point(4,6),.5)
        self.eye2 = Circle(Point(6,6),.5)
        self.head = Circle(Point(5,5),3)
        self.mouth = Line(Point(4,4), Point(6,4))

        self.eye1.draw(window)
        self.eye2.draw(window)
        self.head.draw(window)
        self.mouth.draw(window)

    def moveEyes(self, window):
        self.eye1.undraw()
        self.eye2.undraw()
        self.placeSpot()
        self.eye1 = Circle((randint(2,4)), (randint(4,6)), .5)
        self.eye2 = Circle((randint(4,6)), (randint(6,8), .5)
        
        self.eye1.draw(window)
        self.eye2.draw(window)

             
    def placeSpot(self):
        p1 = Point(randint(1,9), randint(1,8))
        self.p2, self.p3 = p1.clone(), p1.clone()
        self.p2.move(-.3, -.3)
        self.p3.move(.3, .3)
        self.p4, self.p5 = p1.clone(), p1.clone()
        self.p4.move(-.3, .3)
        self.p5.move(.3, -.3)

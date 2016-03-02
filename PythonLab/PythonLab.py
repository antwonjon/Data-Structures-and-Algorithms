#Tick.py

from graphics import *
from random import randint
import time

class Face:
    def __init__(self, window, center, size):
        self.center = center
     
        self.head = Circle(Point(5, 5), 3)
        self.eye1 = Circle(Point(4, 6), .5)
        self.eye2 = Circle(Point(6, 6), .5)
        self.mouth = Line(Point(4, 4), Point(6, 4))
        self.head.draw(window)
        self.eye1.draw(window)
        self.eye2.draw(window)
        self.mouth.draw(window)
        
    def newSpot(self, window):
        self.eye1.undraw()
        self.eye2.undraw()
        self.eye1 = Circle(Point((randint(3,5)), (randint(4,6))), .5)
        self.eye2 = Circle(Point((randint(5,7)), (randint(5,7))), .5)

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

    def moveMouth(self, window):
        self.mouth.undraw()
        self.mouth = Oval(Point(4, 4.5), Point(6, 3.5))
        self.mouth.draw(window)
        time.sleep(.5)
        self.mouth.undraw()
        self.mouth = Line(Point(4, 4), Point(6, 4))
        self.mouth.draw(window)

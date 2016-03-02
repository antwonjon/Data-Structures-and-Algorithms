from graphics import *
from button import Button
from PythonLab import Face

def main():
    win = GraphWin("Dice Roller")
    win.setCoords(0, 0, 10, 10)
    win.setBackground("green")

    tic = Face(win, Point(5,5), 2)  #the window, middle, size of drawing
    
    eyesButt = Button(win, Point(3, 1), 2, 1, "Eyes")
    quitButt = Button(win, Point(5, 9), 2, 1, "Quit")
    talkButt = Button(win, Point(7, 1), 2, 1, "Talk")
    eyesButt.activate()
    quitButt.activate()
    talkButt.activate()

    pt = win.getMouse()
    while not quitButt.clicked(pt):
        if eyesButt.clicked(pt):
            tic.newSpot(win)
        if talkButt.clicked(pt):
            tic.moveMouth(win)
        pt = win.getMouse()

    win.close()
    
main()

from graphics import *
from button import Button
from tick import tick

def main():
    win = GraphWin("My Face in the Morning")
    win.setCoords(0, 0, 10, 10)
    win.setBackground("green")

    tic = PythonLab(win, Point(5,5), 2)  #the window, middle, size of drawing
    
    talkButt = Button(win, Point(2, 2), 2, 1, "Talk")
    quitButt = Button(win, Point(5, 9), 2, 1, "Quit")
    eyesButt = Button(win, Point(8, 2), 2, 1, "Eyes")
    talkButt.activate()
    quitButt.activate()
    eyesButt.activate()

    pt = win.getMouse()
    while not quitButt.clicked(pt):
        if eyesButt.clicked(pt):
            tic.moveEyes(win)
##        if eyesButt.clicked(pt);
  #          tic.moveEyes(win)
        pt = win.getMouse()

    win.close()
    
main()

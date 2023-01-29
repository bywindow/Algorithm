class MyCircularQueue:
    def __init__(self, k: int) -> None:
        self.q = [None] * k
        self.maxLen = k
        self.p1 = 0 # front
        self.p2 = 0 # rear
    
    def enqueue(self, value: int):
        if self.q[self.p2] is None:
            self.q[self.p2] = value
            self.p2 = (self.p2 + 1) % self.maxLen
            return True
        else:
            return False
    
    def dequeue(self):
        if self.q[self.p1] is None:
            return False
        else:
            self.q[self.p1] = None
            self.p1 = (self.p1 + 1) % self.maxLen
            return True
    
    def Front(self):
        return -1 if self.q[self.p1] is None else self.q[self.p1]

    def Rear(self):
        return -1 if self.q[self.p2 - 1] is None else self.q[self.p2 - 1]

    def isEmpty(self):
        return self.p1 == self.p2 and self.q[self.p1] is None

    def isFull(self):
        return self.p1 == self.p2 and self.q[self.p1] is not None
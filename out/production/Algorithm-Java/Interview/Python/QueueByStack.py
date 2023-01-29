class MyQueue:
    def __init__(self) -> None:
        self.input = []
        self.output = []
    
    def push(self, x):
        self.input.append(x)
    
    def peek(self):
        if not self.output:
            while self.input:
                self.output.append(self.input.pop())
        return self.output[-1]
    
    def pop(self):
        self.peek()
        return self.output.pop()

    def empty(self):
        return self.input == [] and self.output == []
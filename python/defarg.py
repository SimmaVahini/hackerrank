class EvenStream(object):
    def __init__(self):
        self.current = 0

    def get_next(self):
        to_return = self.current
        self.current += 2
        return to_return

class OddStream(object):
    def __init__(self):
        self.current = 1

    def get_next(self):
        to_return = self.current
        self.current += 2
        return to_return
def print_from_stream(n, stream=None):
    if stream is None:
        stream = EvenStream()
    for _ in range(n):
        print(stream.get_next())
if __name__ == '__main__':
    q = int(input())
    for _ in range(q):
        args = input().split()
        stream_name = args[0]
        n = int(args[1])
        if stream_name == "even":
            print_from_stream(n)
        else:
            print_from_stream(n, OddStream())

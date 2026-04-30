K, M = map(int, input().split())

lists = []
for _ in range(K):
    data = list(map(int, input().split()))
    lists.append(data[1:])  # skip size

possible = {0}

for lst in lists:
    new_set = set()
    for x in lst:
        for val in possible:
            new_set.add((val + x*x) % M)
    possible = new_set

print(max(possible))

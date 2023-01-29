def combine(n: int, k: int):
    result = []

    def dfs(items, start: int, k: int):
        if k == 0:
            result.append(items[:])
            return

        for i in range(start, n+1):
            items.append(i)
            dfs(items, i+1, k-1)
            items.pop()
    dfs([], 1, k)

    return result
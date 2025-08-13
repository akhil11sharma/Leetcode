class Solution:
    def totalNQueens(self, n: int) -> int:
        cnt = 0
        def dfs(row, col, diag, adiag):
            nonlocal cnt
            if row == n:
                cnt += 1
                return
            mask = ((1 << n) - 1) & ~(col | diag | adiag)
            while mask:
                p = mask & -mask
                mask -= p
                dfs(row + 1, col | p, (diag | p) << 1, (adiag | p) >> 1)
        dfs(0, 0, 0, 0)
        return cnt
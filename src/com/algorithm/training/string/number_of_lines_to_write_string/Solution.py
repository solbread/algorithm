import math


class Solution:
    def numberOfLines(self, widths, S):
        """
        :type widths: List[int]
        :type S: str
        :rtype: List[int]
        """
        _total_length = 0
        for c in S:
            _total_length += widths[ord(c)-ord('a')]
        return [math.ceil(_total_length / 100), _total_length % 100]


if __name__ == "__main__":
    solution = Solution()
    widths = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
    print(solution.numberOfLines(widths, 'abcdefghijklmnopqrstuvwxyz'))
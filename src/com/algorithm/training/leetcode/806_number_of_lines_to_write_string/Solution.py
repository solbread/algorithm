import math


class Solution:
    def numberOfLines(self, widths, S):
        """
        :type widths: List[int]
        :type S: str
        :rtype: List[int]
        """
        _line_number = 1
        _last_line_width = 0
        for c in S:
            _current_width = widths[ord(c)-ord('a')]
            _line_number += 1 if _last_line_width + _current_width > 100 else 0
            _last_line_width = _current_width if _last_line_width + _current_width > 100 else _last_line_width + _current_width
        return [_line_number, _last_line_width]


if __name__ == "__main__":
    solution = Solution()
    widths = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
    print(solution.numberOfLines(widths, 'abcdefghijklmnopqrstuvwxyz')) #3, 60
    widths = [4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
    print(solution.numberOfLines(widths, 'bbbcccdddaaa')) #2, 4
#https://leetcode.com/problems/3sum-closest/description/
import sys
def threeSumClosest(nums, target):
        nums.sort()
        finalSum = sys.maxsize
        for i in range(len(nums)-1):
            sum = nums[i]
            p = i+1
            q = len(nums)-1
            while p != q:
                sum = nums[i]
                sum += nums[p]+nums[q]
                if abs(sum-target) < abs(finalSum-target):
                    finalSum = sum
                if sum < target:
                    p += 1
                else:
                    q -= 1
        return finalSum

print(threeSumClosest([-1, 2, 1, -4], 1))
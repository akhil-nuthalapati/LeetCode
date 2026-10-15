int search(int* nums, int numsSize, int target) {
    int mid =0,low =0,high=numsSize-1;
    while(low<=high)
    {   mid = low + (high - low)/2;
        if(nums[mid]==target)
        return mid;
        else if(nums[mid]<target)
        {
            low = mid+1;
        }
        else if(nums[mid]>target)
        {
            high = mid -1;
        }
    }
    return -1;
}
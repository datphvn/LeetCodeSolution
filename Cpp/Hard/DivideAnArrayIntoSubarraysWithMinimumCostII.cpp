#include <bits/stdc++.h>
using namespace std;

class Container {
public:
    Container(int k) : k(k), sm(0) {}

    void adjust() {
        while (st1.size() < k && !st2.empty()) {
            int x = *st2.begin();
            st1.insert(x);
            sm += x;
            st2.erase(st2.begin());
        }
        while (st1.size() > k) {
            auto it = prev(st1.end());
            int x = *it;
            st1.erase(it);
            sm -= x;
            st2.insert(x);
        }
    }

    void add(int x) {
        if (!st2.empty() && x >= *st2.begin()) {
            st2.insert(x);
        } else {
            st1.insert(x);
            sm += x;
        }
        adjust();
    }

    void erase(int x) {
        auto it = st1.find(x);
        if (it != st1.end()) {
            st1.erase(it);
            sm -= x;
        } else {
            st2.erase(st2.find(x));
        }
        adjust();
    }

    long long sum() const {
        return sm;
    }

private:
    int k;
    multiset<int> st1, st2;
    long long sm;
};

class DivideAnArrayIntoSubarraysWithMinimumCostII {
public:
    long long minimumCost(vector<int>& nums, int k, int dist) {
        int n = nums.size();
        Container cnt(k - 2);

        for (int i = 1; i < k - 1; i++) {
            cnt.add(nums[i]);
        }

        long long ans = cnt.sum() + nums[k - 1];

        for (int i = k; i < n; i++) {
            int j = i - dist - 1;
            if (j > 0) {
                cnt.erase(nums[j]);
            }
            cnt.add(nums[i - 1]);
            ans = min(ans, cnt.sum() + nums[i]);
        }

        return ans + nums[0];
    }
};

int main() {
    DivideAnArrayIntoSubarraysWithMinimumCostII solver;

    vector<int> nums1 = {1,3,2,6,4,2};
    cout << solver.minimumCost(nums1, 3, 3) << endl; // 5

    vector<int> nums2 = {10,1,2,2,2,1};
    cout << solver.minimumCost(nums2, 4, 3) << endl; // 15

    vector<int> nums3 = {10,8,18,9};
    cout << solver.minimumCost(nums3, 3, 1) << endl; // 36
}


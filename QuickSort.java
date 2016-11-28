/*
 * quick sort vs merge sort:
 * 1. time complexity: quicksort与mergesort都是平均O(nlogn)，但是quicksort是平均
 * O(nlogn)而mergesort是严格的O(nlogn)
 * 2. space complexity: quicksort是O(1)，mergesort有一个O(n)的额外花费，因为
 * 它要merge，需要空间
 * 3. 稳定性: quicksort不稳定，mergesort稳定
 */

public class QuickSort {
	public static void main(String args[]){
		int A[] = {1,1,1,1,1,1,2};
		int B[] = {1,2,3,4,5};
		int C[] = {5,4,3,2,1};
		int D[] = {1,2,7,33,22,5,13,78,0};
		int E[] = {0, 0, 0, 0, 0, 0, 0, 0};
		
		QuickSort ms = new QuickSort();
		ms.prt(A);
		ms.quickSort(A);
		ms.prt(A);
		
		ms.prt(B);
		ms.quickSort(B);
		ms.prt(B);
		
		ms.prt(C);
		ms.quickSort(C);
		ms.prt(C);
		
		ms.prt(D);
		ms.quickSort(D);
		ms.prt(D);
		
		ms.prt(E);
		ms.quickSort(E);
		ms.prt(E);
	}
	
	public void quickSort(int A[]){
		if(A == null || A.length <= 0){
			return;
		}
		helper(A, 0, A.length - 1);
	}

	private void helper(int[] A, int start, int end) {
		if(start >= end){
			return;
		}
		int mid = start + (end - start)/2;
		// key point 1: pivot is the value, not the index
		int pivot = A[mid];
		int left = start, right = end;
		
		// key point 2: every time you compare left & right, it should be 
        // left <= right not left < right
		while(left <= right){
			while(A[left] < pivot && left <= right){
				left++;
			}
			// key point 3: A[right] > pivot not A[right] >= pivot
			//为了节省效率
			while(A[right] > pivot && left <= right){
				right--;
			}
			if(left <= right){
				int temp = A[right];
				A[right] = A[left];
				A[left] = temp;
				left++;
				right--;
			}
		}
		helper(A, start, right);
		helper(A, left, end);
		
	}
	
	private void prt(int A[]){
		for(int num : A){
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
}

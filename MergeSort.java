
public class MergeSort {

	public static void main(String[] args) {
		int A[] = {1,1,1,1,1,1,2};
		int B[] = {1,2,3,4,5};
		int C[] = {5,4,3,2,1};
		int D[] = {1,2,7,33,22,5,13,78,0};
		
		MergeSort ms = new MergeSort();
		ms.prt(A);
		ms.mergeSort(A);
		ms.prt(A);
		
		ms.prt(B);
		ms.mergeSort(B);
		ms.prt(B);
		
		ms.prt(C);
		ms.mergeSort(C);
		ms.prt(C);
		
		ms.prt(D);
		ms.mergeSort(D);
		ms.prt(D);

	}
	
	public void mergeSort(int A[]){
		if(A == null || A.length <= 0){
			return;
		}
		int[] temp = new int[A.length];
		helper(A, 0, A.length - 1, temp);
	}
	
	private void helper(int[] A, int start, int end, int[] temp){
		if(start >= end){
			return;
		}
		int mid = start + (end - start)/2;
		helper(A, start, mid, temp);
		helper(A, mid + 1, end, temp);
		merge(A, start, mid, end, temp);
	}

	private void merge(int[] A, int start, int mid, int end, int[] temp) {
		int left = start, right = mid + 1;
		int index = start;
		while(left <= mid && right <= end){
			if(A[left] < A[right]){
				temp[index++] = A[left++];
			} else {
				temp[index++] = A[right++];
			}
		}
		while(left <= mid){
			temp[index++] = A[left++];
		}
		while(right <= end){
			temp[index++] = A[right++];
		}
		for(index = start; index <= end; index++){
			A[index] = temp[index];
		}
	}
	
	private void prt(int A[]){
		for(int num : A){
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
}

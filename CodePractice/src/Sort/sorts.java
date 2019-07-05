package Sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 排序算法
 * 
 * @author qyl
 *
 */
public class sorts
{

	public static void main(String args[])
	{
		int[] array = { 10, 9, 8, 6, 2, 1, 3, 11, 48, 16, 32 };
		// BubbleSort.bubbleSort(array);
		// BubbleSort.insertSort(array);
		// BubbleSort.selectionSort(array);
		// BubbleSort.shellSort(array);
		//BubbleSort.MergeSort(array);
		//BubbleSort.QuikSort(array);
		//BubbleSort.heapSort(array);
		sorts.radixSort(array);
		for (int num : array)
			System.out.print(num + " ");
	}

	public static int[] bubbleSort(int[] array)
	{
		int len = array.length;
		for (int i = 0; i < len - 1; i++)
		{
			for (int j = 0; j < len - i - 1; j++)
			{
				if (array[j] > array[j + 1])
				{
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}

	/**
	 * 插入排序
	 * 
	 * @param array
	 * @return
	 */
	public static int[] insertSort(int[] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			int preIndex = i - 1;
			int current = array[i];
			while (preIndex >= 0 && current < array[preIndex])
			{
				array[preIndex + 1] = array[preIndex];
				preIndex--;
			}
			array[preIndex + 1] = current;
		}
		return array;
	}

	/**
	 * 选择排序
	 * 
	 * @param args
	 */
	public static void selectionSort(int array[])
	{
		int minIndex = -1;
		for (int i = 0; i < array.length; i++)
		{
			minIndex = i;
			for (int j = i; j < array.length; j++)
			{
				if (array[j] < array[minIndex])
					minIndex = j;
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}

	/**
	 * 希尔排序/缩小增量排序
	 * 
	 * @param array
	 */
	public static void shellSort(int array[])
	{
		int gap = -1;
		for (gap = array.length / 2; gap > 0; gap /= 2)
		{
			for (int j = gap; j < array.length; j++)
			{
				int current = array[j];
				while (j - gap >= 0 && current < array[j - gap])
				{
					array[j] = array[j - gap];
					j -= gap;
				}
				array[j] = current;
			}
		}
	}

	/**
	 * 归并排序
	 * 
	 * @param array
	 */
	public static void MergeSort(int[] array)
	{

		mergeSort(array, 0, array.length - 1);
	}

	private static void mergeSort(int[] array, int start, int end)
	{
		if (end <= start)
			return;

		int middle = (start + end) / 2;
		mergeSort(array, start, middle);
		mergeSort(array, middle + 1, end);
		merge(array, start, middle, end);
	}

	private static void merge(int[] array, int start, int middle, int end)
	{
		int[] temp = new int[end - start + 1];

		int i = start;
		int j = middle + 1;
		int index = 0;
		while (i <= middle && j <= end)
		{
			if (array[i] <= array[j])
				temp[index++] = array[i++];
			else
				temp[index++] = array[j++];
		}

		while (i <= middle)
		{
			temp[index++] = array[i++];
		}

		while (j <= end)
			temp[index++] = array[j++];

		int k = 0;
		while (start <= end)
			array[start++] = temp[k++];
	}

	/**
	 * 快速排序
	 * 
	 * @param array
	 */
	public static void QuikSort(int[] array)
	{
		if (array == null || array.length <= 1)
			return;
		QuikSortCore(array, 0, array.length - 1);
	}

	private static void QuikSortCore(int[] array, int start, int end)
	{
		if (start > end)
		{
			return;
		}
		
		int index= partion(array,start,end);
		QuikSortCore(array,start,index-1);
		QuikSortCore(array,index+1,end);
	}
	private static int partion(int[] array,int start,int end) {
		int num=array[start];
		int i=start;
		int j=end;
		while(i<j) {
            while(array[j]>=num&&i<j) {
            	j--;
            }
            while(array[i]<=num&&i<j) {
            	i++;
            } 
            if(i<j) {
                swap(array,i,j);
            }
		}
        swap(array,start,i);
		return i;	
	}
	private static void swap(int[] array,int i,int j) {
    	int temp=array[i];
    	array[i]=array[j];
    	array[j]=temp;
	}
	
	/**
	 * 堆排序
	 * @param array
	 */
	public static void heapSort(int [] array) {
		
		PriorityQueue<Integer> heap=new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2)
			{
				return o2-o1;
			}});
		
		for(int num :array) {
			heap.add(num);
		}
		
		int i=0;
		while(!heap.isEmpty())
			array[i++]=heap.poll();
	}
	
	/**
	 * 基数排序
	 * @param array
	 */
	public static void radixSort(int[] array) {
		
		int d = getBigDigit(array);
		int len=array.length;
	    int[][] radix=new int[10][len];
	    int[] numOfindex=new int[10];
	    
	    int n=1;//当前位数
	    int mod=1;
	    while(n<=d) {
	    	
	    	for(int i=0;i<len;i++) {
	    		
	    		int num = (array[i]/mod)%10;
	    		radix[num][numOfindex[num]]=array[i];
	    		numOfindex[num]++;
	    	}
	    	
	    	int index=0;
	    	for(int i=0;i<10;i++) {
	    		int j=0;
	    		while(j<numOfindex[i]) {
	    			array[index++] = radix[i][j];
	    			radix[i][j] = 0;//归零，方便下次调用
	    			j++;
	    		}
	    		numOfindex[i] = 0;
	    	}
	    	mod *= 10;
	    	n++;
	    }
	}
	
	private static int getBigDigit(int[] array) {
		int digit = 0;
		for(int num : array) {
			int k=0;//计数
			while(num>0) {
				k++;
				num/=10;
			}
			
			if(digit<k)
				digit=k;
		}

		return digit;
		
	}
}

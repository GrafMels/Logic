using System.Diagnostics;
internal class Program
{
        private static void Main(string[] args)
        {
            Random rnd = new Random();
            int size = 100000;

            int[] array = new int[size];
            for (int i = 0; i < array.Length;i++ ){
                array[i] = rnd.Next(0, size/2);
            }

            Stopwatch stopwatch = new Stopwatch();
            stopwatch.Start();
            array = quickSort(array, 0, array.Length - 1);



            stopwatch.Stop();
            Console.WriteLine();
            Console.WriteLine(stopwatch.ElapsedMilliseconds);
        }

        public static int[] quickSort(int[] array, int leftIndex, int rightIndex){
            var i = leftIndex;
            var j = rightIndex;
            var pivot = array[leftIndex];
            while (i <= j){
                while (array[i] < pivot){
                    i++;
                }
        
                while (array[j] > pivot){
                    j--;
                }
                if (i <= j){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }
    
            if (leftIndex < j)
                quickSort(array, leftIndex, j);
            if (i < rightIndex)
                quickSort(array, i, rightIndex);
            return array;
        }
}


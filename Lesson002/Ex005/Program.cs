using System.Diagnostics;
internal class Program
{
        private static void Main(string[] args)
        {
            int[] array = new int[10] { 2, 8, 3, 5, 9, 7, 1, 6, 4, 0 };
            array = minSort(array);


            Stopwatch stopwatch = new Stopwatch();
            stopwatch.Start();


            Console.WriteLine("Позиция искомого числа: {0}", binarySearch(array, 7, 0, array.Length - 1));


            stopwatch.Stop();
            Console.WriteLine();
            Console.WriteLine(stopwatch.ElapsedMilliseconds);
        }

        public static int binarySearch(int[] srray, int number, int min, int max){
            int midPoint;
            // System.Console.WriteLine("min{0}, max{1}", min, max);
            if (max < min){
                return -1;
            } else {
                midPoint = (max-min)/2 + min;
            }

            if (srray[midPoint] < number){
                return binarySearch(srray, number, midPoint+1, max);
            }else if(srray[midPoint] > number){
                return binarySearch(srray, number, min, midPoint-1);
            }else{
                return midPoint;
            }
        }

        public static int[] minSort(int[] srray)
        {
           for (int i = 0; i < srray.Length-1; i++){
            int minPosition = i;
                for (int j = i + 1; j < srray.Length; j++){
                    if(srray[j] < srray[minPosition]) {
                        minPosition = j;
                    }
                }
                if(i != minPosition){
                int temp = srray[i];
                srray[i] = srray[minPosition];
                srray[minPosition] = temp;
           }
           }
           return srray;
        }
    
}

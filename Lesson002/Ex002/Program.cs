using System.Diagnostics;
internal class Program
{
        private static void Main(string[] args)
        {
            Random rnd = new Random();
            int size = 200000;

            int[] array = new int[size];
            for (int i = 0; i < array.Length;i++ ){
                array[i] = rnd.Next(0, size/2);
            }

            Stopwatch stopwatch = new Stopwatch();
            stopwatch.Start();


            // array = bubleSort(array);
            array = minSort(array);



            stopwatch.Stop();
            Console.WriteLine();
            Console.WriteLine(stopwatch.ElapsedMilliseconds);
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

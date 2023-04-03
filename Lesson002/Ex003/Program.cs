using System.Diagnostics;
internal class Program
{
        private static void Main(string[] args)
        {
            Stopwatch stopwatch = new Stopwatch();
            stopwatch.Start();

            int[] array = new int[10] { 2, 8, 3, 5, 9, 7, 1, 6, 4, 0 };
            array = choiceSort(array);
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine(array[i]);

            }

            stopwatch.Stop();
            Console.WriteLine();
            Console.WriteLine(stopwatch.ElapsedMilliseconds);
        }

        public static int[] choiceSort(int[] srray)
        {
           for (int i = 0; i < srray.Length-1; i++){
                for (int j = i + 1; j < srray.Length; j++){
                    if(srray[j] < srray[i]) {
                        int temp = srray[i];
                        srray[i] = srray[j];
                        srray[j] = temp;
                    }
                }
           }
           return srray;
        }
    
}

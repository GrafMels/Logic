using System.Diagnostics;
internal class Program
{
        private static void Main(string[] args)
        {
            Stopwatch stopwatch = new Stopwatch();
            stopwatch.Start();


            int[] array = new int[10] { 2, 8, 3, 5, 9, 7, 1, 6, 4, 0 };
            array = bubleSort(array);
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine(array[i]);

            }


            stopwatch.Stop();
            Console.WriteLine();
            Console.WriteLine(stopwatch.ElapsedMilliseconds);
        }

        public static int[] bubleSort(int[] srray)
        {
            bool finish = false;
            do
            {
                finish = false;
                for (int i = 0; i < srray.Length - 1; i++)
                {
                    if (srray[i] > srray[i + 1])
                    {
                        int temp = srray[i];
                        srray[i] = srray[i + 1];
                        srray[i + 1] = temp;
                        finish = true;
                    }
                }
            } while (finish);
            return srray;
        }
    
}
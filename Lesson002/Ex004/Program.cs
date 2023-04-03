using System.Diagnostics;
internal class Program
{
        private static void Main(string[] args)
        {
            Stopwatch stopwatch = new Stopwatch();
            stopwatch.Start();

            int[] array = new int[10] { 2, 8, 3, 5, 9, 7, 1, 6, 4, 0 };
            for (int i = 0; i < 1000000; i++)
            {
                int position = findNumber(array, i);
                System.Console.WriteLine(position);
            }
            

            stopwatch.Stop();
            Console.WriteLine();
            Console.WriteLine(stopwatch.ElapsedMilliseconds);
        }

        public static int findNumber(int[] srray, int number)
        {
           for (int i = 0; i < srray.Length-1; i++){
                if (srray[i] == number){
                    return i;
                }
           }
           return -1;
        }
    
}
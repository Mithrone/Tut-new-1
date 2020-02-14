import java.util.Random;
class tut1
{   
    public static void main (String args[])
    {
        int type = Integer.parseInt(args[0]);
        int l = Integer.parseInt(args[1]);

        int[] itemInt;
        String[] itemStr;
        Double[] itemDouble;
        
        if(type == 0)
        {
            itemInt = generateInt(l);

            for(int i = 0; i < l ; i++)
            {
                System.out.println(itemInt[i]);
                
            }

            System.out.println("");

            Stopwatch timer = new Stopwatch();
            //insertionSortInt(itemInt);
            Double time = timer.elapsedTime();

            mergeSortInt(itemInt, 0, itemInt.length);

            System.out.println("Time: " + time);
            for(int i = 0; i < l ; i++)
            {
                System.out.println(itemInt[i]);
            }
        }

        if(type == 1)
        {
            itemStr = generateString(l);

            for(int i = 0; i < l ; i++)
            {
                //System.out.println(itemStr[i]);
            }

            Stopwatch timer = new Stopwatch();
            insertionSortString(itemStr);
            Double time = timer.elapsedTime();

            System.out.println("Time: " + time);

            for(int i = 0; i < l ; i++)
            {
                System.out.println(itemStr[i]);
            }

        }

        if(type == 2)
        {
            Stopwatch timer = new Stopwatch();
            itemDouble = generateDouble(l);
            Double time = timer.elapsedTime();

            System.out.println("Time: " + time);

            for(int i = 0; i < l ; i++)
            {
                System.out.println(itemDouble[i]);
            }
        }
    }   

    public static int[] generateInt(int l)
    {
        int[] g = new int[l];
        Random item = new Random();

        for(int i = 0; i < l; i++)
        {
            g[i] = item.nextInt(100); 
        }

        return g;
    }

    public static String[] generateString(int l)
    {
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String[] g = new String[l];
        Random item = new Random();

        for(int i = 0; i < l; i++)
        {
            g[i] = alphabet[item.nextInt(26)];
        }

        return g;
    }

    public static Double[] generateDouble(int l)
    {
        Double[] g = new Double[l];
        Random item = new Random();

        for(int i = 0; i < l; i++)
        {
            g[i] = item.nextDouble();
        }

        return g;
    }

    public static int[] insertionSortInt(int[] item)
    {
        for(int i = 0; i < item.length; i++)
        {
            if(i + 1 < item.length)
            {
                for(int j = i + 1; (j > 0); j--)
                {
                    if(item[j - 1] > item[j])
                    {
                        int temp = item[j - 1];
                        item[j - 1] = item[j];
                        item[j] = temp; 
                    }
                    
                } 
            }
        }
        return item;
    }

    public static String[] insertionSortString(String[] item)
    {
        for(int i = 0; i < item.length; i++)
        {
            if(i + 1 < item.length)
            {
                for(int j = i + 1; (j > 0); j--)
                {
                    if(item[j - 1].hashCode() > item[j].hashCode())
                    {
                        String temp = item[j - 1];
                        item[j - 1] = item[j];
                        item[j] = temp; 
                    }
                    
                } 
            }
        }
        return item;
    }



    public static int[] selectionSortInt(int[] item)
    {
        for(int i = 0; i< item.length; i++)
        {
            for(int j = i; j < item.length; j++)
            {
                if(item[j] < item[i])
                {
                    int temp = item[i];

                    item[i] = item[j];
                    item[j] = temp;
                }
            }
        
        }
        return item;
    }

    public static int[] shellSortInt(int[] item)
    {
        for(int i = item.length / 2; i >= 1; i /= 2)
        {
            for(int j = 0; j < item.length; j++)
            {
                int temp = item[j];
                int k;
                
                for (k = j; k >= i && item[k - i] > temp; k -= i)
                {
                    item[k] = item[k - i];
                }

                item[k] = temp;
            }   
        }
        return item;
    }

    public static int[] mergeSortInt(int[] item, int start, int end)
    {
        if(start < end)
        {
            System.out.println("he");
            item = mergeSortInt(item, start, ((start + end) / 2));
            item = mergeSortInt(item, ((start + end) / 2) + 1, end);

            int mid = (start + end) / 2;
            item = mergeInt(item, start, mid, end);
            
        }
        return item;
    }

    public static int[] mergeInt(int[] item, int start, int mid, int end)
    {
        int s = start;
        int e = mid + 1;
        int[] fin = new int[end - start + 1];
        int count = 0;

        for(int i = start; i < end; i++)
        {
            
            if(s > mid)
            {
                fin[count] = item[e];
                count++;
                e++;
            }
            else if(e > end)
            {
                fin[count] = item[s];
                count++;
                s++;
            }
            else if ( e < item.length)
            {
                if(item[s] < item[e])
                {
                    fin[count] = item[s];
                    count++;
                    s++;
                }
                
            }
            else if ( e < item.length)
            {
                fin[count] = item[e];
                count++;
                e++;
            }
        }

        for (int p=0 ; p< count ;p ++) {
            /* Now the real array has elements in sorted manner including both 
                 parts.*/
              item[ start++ ] = fin[ p ] ;                          
           }
        return item;
    }

    public static int[] quickSortInt(int[] item)
    {
        return item;
    }
    
}

class Stopwatch
{
    private final long start;
    public Stopwatch()
    { 
        start = System.currentTimeMillis(); 
    }
    public double elapsedTime()
    {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}

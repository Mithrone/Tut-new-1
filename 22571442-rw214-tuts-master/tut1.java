import java.sql.Time;
import java.util.Random;
class tut1
{   
    public static void main (String args[])
    {
        int type = Integer.parseInt(args[0]);
        int l = Integer.parseInt(args[1]);

        int[] itemInt = new int[l];
        String[] itemStr = new String[l];
        Double[] itemDouble = new Double[l];
        
        if(type == 0)
        {
            itemInt = generateInt(l);
            itemStr = generateString(l);
            itemDouble = generateDouble(l);
        }
        else if(type == 1)
        {
            String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
            for(int i = 0; i < l; i++)
            {
                itemInt[i] = i;
                itemStr[i] = alphabet[i/26];
                itemDouble[i] = i + 0.0;
            }
            
        }
        else if(type == 2)
        {
            String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
            for(int i = l; i > l; i--)
            {
                itemInt[i] = i;
                itemStr[i] = alphabet[i/26];
                itemDouble[i] = i + 0.0;
            }
        }
        else
        {
            String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
            for(int i = 0; i < l / 2; i++)
            {
                for(int j = 0; j < l / 2; j++)
                {
                    itemInt[i + j] = i;
                    itemStr[i + j] = alphabet[i/26];
                    itemDouble[i+ j]  = i + 0.0;
                }
                
            }
        }

///////////////////////////////////////////////////////////////////////
            Stopwatch timer;
            Double time;

            timer = new Stopwatch();
            insertionSortInt(itemInt);
            time = timer.elapsedTime();
            System.out.println("Time for insertion int: " + time);

            timer = new Stopwatch();
            selectionSortInt(itemInt);
            time = timer.elapsedTime();
            System.out.println("Time for selection: " + time);

            timer = new Stopwatch();
            shellSortInt(itemInt);
            time = timer.elapsedTime();
            System.out.println("Time for Shell: " + time);

            timer = new Stopwatch();
            mergeSortInt(itemInt, 0, itemInt.length - 1);
            time = timer.elapsedTime();
            System.out.println("Time for Merge: " + time);

            timer = new Stopwatch();
            quickSortInt(itemInt, 0, itemInt.length - 1);
            time = timer.elapsedTime();
            System.out.println("Time for Quick: " + time);       
            
///////////////////////////////////////////////////////////////////////

            timer = new Stopwatch();
            insertionSortString(itemStr);
            time = timer.elapsedTime();
            System.out.println("Time for insertion: " + time);

            timer = new Stopwatch();
            selectionSortString(itemStr);
            time = timer.elapsedTime();
            System.out.println("Time for selection: " + time);

            timer = new Stopwatch();
            shellSortString(itemStr);
            time = timer.elapsedTime();
            System.out.println("Time for Shell: " + time);

            timer = new Stopwatch();
            mergeSortString(itemStr, 0, itemStr.length - 1);
            time = timer.elapsedTime();
            System.out.println("Time for Merge: " + time);

            timer = new Stopwatch();
            quickSortString(itemStr, 0, itemStr.length - 1);
            time = timer.elapsedTime();
            System.out.println("Time for Quick: " + time);

///////////////////////////////////////////////////////////////////////        

            timer = new Stopwatch();
            insertionSortDouble(itemDouble);
            time = timer.elapsedTime();
            System.out.println("Time for insertion: " + time);

            timer = new Stopwatch();
            selectionSortDouble(itemDouble);
            time = timer.elapsedTime();
            System.out.println("Time for selection: " + time);

            timer = new Stopwatch();
            shellSortDouble(itemDouble);
            time = timer.elapsedTime();
            System.out.println("Time for Shell: " + time);

            timer = new Stopwatch();
            mergeSortDouble(itemDouble, 0, itemDouble.length - 1);
            time = timer.elapsedTime();
            System.out.println("Time for Merge: " + time);

            timer = new Stopwatch();
            quickSortDouble(itemDouble, 0, itemDouble.length - 1);
            time = timer.elapsedTime();
            System.out.println("Time for Quick: " + time);
        
    }   
/////////////////////////////////////////////////////////////////////////////
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
//////////////////////////////////////////////////////////////////////////////////
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

    public static Double[] insertionSortDouble(Double[] item)
    {
        for(int i = 0; i < item.length; i++)
        {
            if(i + 1 < item.length)
            {
                for(int j = i + 1; (j > 0); j--)
                {
                    if(item[j - 1] > item[j])
                    {
                        Double temp = item[j - 1];
                        item[j - 1] = item[j];
                        item[j] = temp; 
                    }
                    
                } 
            }
        }
        return item;
    }


//////////////////////////////////////////////////////////////////////////////////////
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

    public static String[] selectionSortString(String[] item)
    {
        for(int i = 0; i< item.length; i++)
        {
            for(int j = i; j < item.length; j++)
            {
                if(item[j].hashCode() < item[i].hashCode())
                {
                    String temp = item[i];

                    item[i] = item[j];
                    item[j] = temp;
                }
            }
        
        }
        return item;
    }

    public static Double[] selectionSortDouble(Double[] item)
    {
        for(int i = 0; i< item.length; i++)
        {
            for(int j = i; j < item.length; j++)
            {
                if(item[j] < item[i])
                {
                    Double temp = item[i];

                    item[i] = item[j];
                    item[j] = temp;
                }
            }
        
        }
        return item;
    }
///////////////////////////////////////////////////////////////////////////////////////
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

    public static String[] shellSortString(String[] item)
    {
        for(int i = item.length / 2; i >= 1; i /= 2)
        {
            for(int j = 0; j < item.length; j++)
            {
                String temp = item[j];
                int k;
                
                for (k = j; k >= i && item[k - i].hashCode() > temp.hashCode(); k -= i)
                {
                    item[k] = item[k - i];
                }

                item[k] = temp;
            }   
        }
        return item;
    }

    public static Double[] shellSortDouble(Double[] item)
    {
        for(int i = item.length / 2; i >= 1; i /= 2)
        {
            for(int j = 0; j < item.length; j++)
            {
                Double temp = item[j];
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

    ///////////////////////////////////////////////////////////////////////////////////////
    public static int[] mergeSortInt(int[] item, int start, int end)
    {
        if(start < end)
        {
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
            else if (item[s] < item[e])
            {
                fin[count] = item[s];
                count++;
                s++;
                
            }
            else
            {
                fin[count] = item[e];
                count++;
                e++;
            }
        }

        for (int p=0 ; p< count ;p ++) 
        {
            item[ start++ ] = fin[ p ] ;                          
        }
        return item;
    }

    public static String[] mergeSortString(String[] item, int start, int end)
    {
        if(start < end)
        {
            item = mergeSortString(item, start, ((start + end) / 2));
            item = mergeSortString(item, ((start + end) / 2) + 1, end);

            int mid = (start + end) / 2;
            item = mergeString(item, start, mid, end);
            
        }
        return item;
    }

    public static String[] mergeString(String[] item, int start, int mid, int end)
    {
        int s = start;
        int e = mid + 1;
        String[] fin = new String[end - start + 1];
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
            else if (item[s].hashCode() < item[e].hashCode())
            {
                fin[count] = item[s];
                count++;
                s++;
                
            }
            else
            {
                fin[count] = item[e];
                count++;
                e++;
            }
        }

        for (int p=0 ; p< count ;p ++) 
        {
            item[ start++ ] = fin[ p ] ;                          
        }
        return item;
    }

    public static Double[] mergeSortDouble(Double[] item, int start, int end)
    {
        if(start < end)
        {
            item = mergeSortDouble(item, start, ((start + end) / 2));
            item = mergeSortDouble(item, ((start + end) / 2) + 1, end);

            int mid = (start + end) / 2;
            item = mergeDouble(item, start, mid, end);
            
        }
        return item;
    }

    public static Double[] mergeDouble(Double[] item, int start, int mid, int end)
    {
        int s = start;
        int e = mid + 1;
        Double[] fin = new Double[end - start + 1];
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
            else if (item[s] < item[e])
            {
                fin[count] = item[s];
                count++;
                s++;
                
            }
            else
            {
                fin[count] = item[e];
                count++;
                e++;
            }
        }

        for (int p=0 ; p< count ;p ++) 
        {
            item[ start++ ] = fin[ p ] ;                          
        }
        return item;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    public static int[] quickSortInt(int[] item, int start, int end)
    {
        int rightIndex;
        if(start < end)
        {
            rightIndex = searchIndexInt(item, start, end);

            quickSortInt(item, start, rightIndex - 1);
            quickSortInt(item, rightIndex + 1, end);
        }
        return item;
    }

    public static int searchIndexInt(int[] item, int start, int end)
    {
        int rightItem= item[end];

        int small = start - 1;

        for(int i = start; i < end; i++)
        {
            if(item[i] < rightItem)
            {
                small++;
                int temp = item[i];
                item[i] = item[small];
                item[small] = temp;
            }
        }
        int temp = item[small + 1];
        item[small + 1] = item[end];
        item[end] = temp;
        return small + 1;
    }

    public static String[] quickSortString(String[] item, int start, int end)
    {
        int rightIndex;
        if(start < end)
        {
            rightIndex = searchIndexString(item, start, end);

            quickSortString(item, start, rightIndex - 1);
            quickSortString(item, rightIndex + 1, end);
        }
        return item;
    }

    public static int searchIndexString(String[] item, int start, int end)
    {
        String rightItem= item[end];

        int small = start - 1;

        for(int i = start; i < end; i++)
        {
            if(item[i].hashCode() < rightItem.hashCode())
            {
                small++;
                String temp = item[i];
                item[i] = item[small];
                item[small] = temp;
            }
        }
        String temp = item[small + 1];
        item[small + 1] = item[end];
        item[end] = temp;
        return small + 1;
    }

    public static Double[] quickSortDouble(Double[] item, int start, int end)
    {
        int rightIndex;
        if(start < end)
        {
            rightIndex = searchIndexDouble(item, start, end);

            quickSortDouble(item, start, rightIndex - 1);
            quickSortDouble(item, rightIndex + 1, end);
        }
        return item;
    }

    public static int searchIndexDouble(Double[] item, int start, int end)
    {
        Double rightItem= item[end];

        int small = start - 1;

        for(int i = start; i < end; i++)
        {
            if(item[i] < rightItem)
            {
                small++;
                Double temp = item[i];
                item[i] = item[small];
                item[small] = temp;
            }
        }
        Double temp = item[small + 1];
        item[small + 1] = item[end];
        item[end] = temp;
        return small + 1;
    }
    
}

///////////////////////////////////////////////////////////////////////////////////////

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

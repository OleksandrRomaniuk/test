import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
       drawFigure();
       primes();
       wallpapers();
       arr();
       matrix();
    }
    
    private static void matrix()
    {
        System.out.print("Please enter the size of the matrix: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        
        String[][] m1 = new String[size][size];
        
        for(int i = 0; i < size; i++)
        { 
            for(int j = 0; j < size; j++)
            {
                m1[i][j] = (i+1)+"."+(j+1);
            }
        }
        printMatrix(m1);
        
        System.out.print("Please enter the angle to turn (90, 180, 270): ");
        int angle = sc.nextInt();
        
        String[][] mTurned = new String[size][size];
        switch (angle) {
        case 270: 
            mTurned = matrixTurn(size, m1);
            printMatrix(mTurned);
            break;
        case 180:
            mTurned = matrixTurn(size, 
                    matrixTurn(size, m1));
            printMatrix(mTurned);
            break;
        case 90:
            mTurned = matrixTurn(size, 
                    matrixTurn(size, 
                            matrixTurn(size, m1)));
            printMatrix(mTurned);
            break;
            default: System.out.println("Wrong angles entered");
        }
    }
    
    private static void printMatrix(String[][] m)
    {
        for(int i = 0; i < m.length; i++)
        {
            for(int j = 0; j < m.length; j++)
            {
                System.out.print(m[i][j]+"\t");
            }
        System.out.println();
        }
    }
    
    private static String[][] matrixTurn(int size, String[][] m1)
    {
        String[][] m2 = new String[size][size];
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                m2[i][j] = m1[j][size - 1 - i];
            }
        }
        return m2;
    }
    
    private static void arr()
    {
        Random rand = new Random();
        int[] arr1 = new int[10];
        
        System.out.print("The first array: ");
        for(int i = 0; i < arr1.length; i++)
        {
            arr1[i] = rand.nextInt(100);
            System.out.print(arr1[i] + "; ");
        }
        
        int[] arr2 = new int[20];
        
        System.out.print("The second array: ");
        
        for(int i = 0; i < arr2.length; i++)
        {
            if(i < arr1.length)
                arr2[i] = arr1[i];
            else
                arr2[i] = 2*arr1[i - arr1.length];
            System.out.print(arr2[i] + "; ");
        }
        
        
    }
    
    private static void wallpapers()
    {
        String firstSymb = "*";
        String secondSymb = "+";
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the height: ");
        int height = sc.nextInt();
        System.out.println("Please enter the width: ");
        int width = sc.nextInt();
        System.out.println("Please enter number of columns: ");
        int col = sc.nextInt();
        
        String symb = null;
        
        for(int i = 1; i <= height; i++)
        {
            for(int j = 1; j <= col; j++)
            {
                if((j % 2) == 0)
                    symb = firstSymb;
                else
                    symb = secondSymb;
                    
                wallpaperaSupport(symb, width);
            }
            System.out.println();
        }
    }
    
    
    private static void wallpaperaSupport(String symb, int width)
    {
        for(int k = 1; k <= width; k++)
        {
            System.out.print(symb);
        }
    }
    
    private static void primes()
    {
        System.out.print("Primes from 1 to 100: 1; ");
        for(int i = 2; i < 101; i++)
        {
            boolean b = true;
            
            for(int j = 2; j < i; j++)
            {
                if(i % j == 0)
                {
                    b = false;
                }
            }
            
            if(b)
            {
                System.out.print(i+"; ");
            }
        }
    }
    
    private static void drawFigure()
    {
        System.out.println("Please enter the height: ");
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        
        for(int i = 1; i <= height; i++)
        {
            for(int j = 0; j < i; j++)
            {
                System.out.print("*");
            }
            System.out.println();
            
            if(i == height)
            {
                int m = height - 1;
                while(m > 0)
                {
                    for(int k = m; k > 0; k--)
                    { 
                        System.out.print("*");
                    }
                    m--;
                    System.out.println();
                }       
            }
        }
    }
}


package imageprocessing.GRAY_Works;

import cezeri.matrix.CMatrix;

public class HistogramEqualization
{
    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//e1.PNG")
                .rgb2gray()
                .imshow()
                ;
        
        int[][] d = cm.toIntArray2D();
        
        cm.setArray(mainHist(d)).map(0, 255).imshow();
    }
    
    public static double[][] mainHist(int[][] d)
    {
        int[] d1 = getHist(d);
        double[] d2 = getPDF(d1);
        double[] d3 = getCDF(d2);
        int [] df = new int[d3.length];
        double[][] dm = new double[d.length][d[0].length];
        
        for (int i = 0; i <d3.length; i++)
        {
            df[i] = (int)Math.floor(d3[i]);
        }
        
        for (int i = 0; i < d.length; i++)
        {
            for (int j = 0; j < d[0].length; j++)
            {
                dm[i][j] = df[(int)d[i][j]];
            }
        }
        
        return dm;
    }
    
    public static int[] getHist(int[][] d)
    {
        int[] hist = new int[20];
        for (int i = 0; i < d.length; i++)
        {
            for (int j = 0; j < d[0].length; j++)
            {
                hist[d[i][j]]++;
            }
        }
        return hist;
    }
    
    public static double[] getPDF(int[] d)
    {
        double[] pdf = new double[d.length];
        double sumTotal = CMatrix.getInstance(d).sumTotal();
        for (int i = 0; i < d.length; i++)
        {
            pdf[i] = d[i] / sumTotal;
        }
    
        return pdf;
    }
    
    public static double[] getCDF(double[] d)
    {
        double[] cdf = new double[d.length];
        double t = 0;
        for (int i = 0; i < d.length; i++)
        {
            t += d[i];
            cdf[i] = t * 20;
        }
    
        return cdf;
    }
}

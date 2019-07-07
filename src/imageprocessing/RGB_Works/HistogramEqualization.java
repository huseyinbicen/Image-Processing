
package imageprocessing.RGB_Works;

import cezeri.matrix.CMatrix;

public class HistogramEqualization
{
    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//lena_color.gif")
                .imshow()
                ;
        double[][][] d = cm.getARGB();
//        cm.setArray(mainHist(d)).imshow();
    }

//    private static double[] mainHist(double[][][] d)
//    {
//        int[] d1 = getHist(d);
//        double[] d2 = getPDF(d1);
//        double[] d3 = getCDF(d2);
//        int [] df = new int[d3.length];
//        double[][] dm = new double[d.length][d[0].length];
//        
////        for (int i = 0; i <d3.length; i++)
////        {
////            df[i] = (int)Math.floor(d3[i]);
////        }
////        
////        for (int i = 0; i < d.length; i++)
////        {
////            for (int j = 0; j < d[0].length; j++)
////            {
////                dm[i][j] = df[(int)d[i][j]];
////            }
////        }
//        
//        return dm;
//    }

    private static int[] getHist(double[][][] d)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static double[] getPDF(int[] d1)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static double[] getCDF(double[] d2)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}

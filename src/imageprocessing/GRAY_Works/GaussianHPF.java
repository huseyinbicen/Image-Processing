
package imageprocessing.GRAY_Works;

import cezeri.matrix.CMatrix;


public class GaussianHPF
{
    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//lena_gray.gif")
                .rgb2gray()
                .imshow()
                ;
        
        double[][] d = cm.toDoubleArray2D();
        
        double mean = CMatrix.getInstance().setArray(d).meanTotal();
        double std = CMatrix.getInstance().setArray(d).stdTotal();
        double stdScalar = 2 * Math.pow(std, 2);

        for (int i = 0; i < d.length; i++)
        {
            for (int j = 0; j < d[0].length; j++)
            {
                d[i][j] = 1- Math.pow(Math.E, -(Math.pow(d[i][j] - mean, 2)) / stdScalar);
            }
        }
        
        cm.setArray(d).map(0, 255).imshow();

    }
}

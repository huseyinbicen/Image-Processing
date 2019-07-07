
package imageprocessing.GRAY_Works;

import cezeri.matrix.CMatrix;

public class SigmoidTransformation
{
    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//gul.png")
                .rgb2gray()
                .imshow();
        double[][] d = cm.toDoubleArray2D();
        
        for (int i = 0; i < d.length; i++)
        {
            for (int j = 0; j < d[0].length; j++)
            {
                d[i][j] = 1 / (1 + Math.pow(Math.E, -d[i][j]));
            }
        }
        cm.setArray(d).map(0, 255).imshow();
        

    }
}

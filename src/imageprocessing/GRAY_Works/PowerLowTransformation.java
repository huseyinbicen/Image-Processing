
package imageprocessing.GRAY_Works;

import cezeri.matrix.CMatrix;

public class PowerLowTransformation
{
    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//gul.png")
                .rgb2gray()
                .imshow();

        double[][] d = cm.toDoubleArray2D();
        int c = 50;
        double emp = 0.5;
        for (int i = 0; i < d.length; i++)
        {
            for (int j = 0; j < d[0].length; j++)
            {
                d[i][j] = c * Math.pow(d[i][j] + 1, emp);
            }
        }
        cm.setArray(d).imshow();

//        CMatrix cm1 = CMatrix.getInstance()
//                .imread("images//gul.png")
//                .rgb2gray()
//                .imshow()
//                .powerByScalar(2)
//                .map(0,255)
//                .imshow()
//                ;
    }
}


package imageprocessing.GRAY_Works;

import cezeri.matrix.CMatrix;

public class LogTransformation
{
    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//gul.png")
                .rgb2gray()
                .imshow();

        double[][] d = cm.toDoubleArray2D();
        int c = 50;
        for (int i = 0; i < d.length; i++)
        {
            for (int j = 0; j < d[0].length; j++)
            {
                d[i][j] = c * Math.log(1 + d[i][j]);
            }
        }
        cm.setArray(d).imshow();

//        CMatrix cm1 = CMatrix.getInstance()
//                .imread("images//gul.png")
//                .rgb2gray()
//                .imshow()
//                .logPlusScalar(1)
//                .map(0, 255)
//                .imshow()
//                ;
    }
}


package imageprocessing.GRAY_Works;

import cezeri.matrix.CMatrix;

public class ContrastStreching
{
    public static void main(String[] args)
    {
        CMatrix cf = CMatrix.getInstance()
                .vector(0, 49)
                .multiplyScalar(0.3)
                .cat(2, CMatrix.getInstance().vector(0, 49).multiplyScalar(3).addScalar(49 * 0.3))
                .cat(2, CMatrix.getInstance().vector(0, 154).multiplyScalar(0.3).addScalar(49 * 0.3 + 3 * 49))
                .plot();
        ;

        int[] f = cf.toIntArray1D();

        CMatrix cm = CMatrix.getInstance()
                .imread("images//alyuvar.jpg")
                .rgb2gray()
                .imshow();
        double[][] d = cm.toDoubleArray2D();
        
        for (int i = 0; i < d.length; i++)
        {
            for (int j = 0; j < d[0].length; j++)
            {
                d[i][j] = d[i][j] * f[(int) d[i][j]];
            }
        }
        cm.setArray(d).map(0, 255).imshow();

//        CMatrix cm2 = CMatrix.getInstance()
//                .imread("images//alyuvar.jpg")
//                .rgb2gray()
//                .imshow()
//                .applyFunction(cf)
//                .map(0, 255)
//                .imshow()
//                ;
    }
}

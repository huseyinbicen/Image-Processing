package imageprocessing.RGB_Works;

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
                .imread("images//lena_color.gif")
                .imshow()
                ;
        double[][][] d = cm.getARGB();
        int ic = cm.getColumnNumber();
        int ir = cm.getRowNumber();
        
        for (int i = 1; i < 4; i++)
        {
            for (int j = 0; j < ic; j++)
            {
                for (int k = 0; k < ir; k++)
                {
                    d[i][j][k] = d[i][j][k] * f[(int) d[i][j][k]];
                }
            }
        }
        cm.setArray(d).imshow();


//        CMatrix cm2 = CMatrix.getInstance()
//                .imread("images//alyuvar.jpg")
//                .imshow()
//                .applyFunction(cf)
//                .map(0, 255)
//                .imshow();

    }
}


package imageprocessing.GRAY_Works;

import cezeri.matrix.CMatrix;

public class BitPlaneSlicing
{
    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//alyuvar.jpg")
                .rgb2gray()
                .imshow()
                .bitPlane(5)
                //                .bitPlaneMSB()
                .imshow();
    }
}

package imageprocessing.RGB_Works;

import cezeri.matrix.CMatrix;

public class NegativeTransformation
{

    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//lena_color.gif")
                .imshow();
        double[][][] d = cm.getARGB();
        
        int ic = cm.getColumnNumber();
        int ir = cm.getRowNumber();
        
        for (int i = 1; i < 4; i++)
        {
            for (int j = 0; j < ic; j++)
            {
                for (int k = 0; k < ir; k++)
                {
                    d[i][j][k] = 255 - d[i][j][k];
                }
            }
        }
        cm.setArray(d).imshow();
    }
}

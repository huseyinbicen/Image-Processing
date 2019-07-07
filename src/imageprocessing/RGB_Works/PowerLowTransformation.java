
package imageprocessing.RGB_Works;

import cezeri.matrix.CMatrix;

public class PowerLowTransformation
{
    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//lena_color.gif")
                .imshow();
        
        double[][][] d = cm.getARGB();
        int ic = cm.getColumnNumber();
        int ir = cm.getRowNumber();
        
        int c = 50;
        double emp = 0.5;
        for (int i = 1; i < 4; i++)
        {
            for (int j = 0; j < ic; j++)
            {
                for (int k = 0; k < ir; k++)
                {
                    d[i][j][k] = c * Math.pow(d[i][j][k] + 1, emp);
                }
            }
        }
        
        cm.setArray(d).imshow();
        

    }
}

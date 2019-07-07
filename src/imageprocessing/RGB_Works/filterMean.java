package imageprocessing.RGB_Works;

import cezeri.matrix.CMatrix;
import cezeri.utils.FactoryUtils;

public class filterMean
{

    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//lena_color.gif")
                .imshow();
        double[][][] d = cm.getARGB();
        int ic = cm.getColumnNumber();
        int ir = cm.getRowNumber();
        
        double[][] red = d[1];
        double[][] green = d[2];
        double[][] blue = d[3];

        double[][] tempRED = FactoryUtils.clone(red);
        double[][] tempGREEN = FactoryUtils.clone(green);
        double[][] tempBLUE = FactoryUtils.clone(blue);

        int window = 9;
        int sumRed = 0;
        int sumGreen = 0;
        int sumBlue = 0;
        
        for (int i = 1; i < ic - 1; i++)
        {
            for (int j = 1; j < ir - 1; j++)
            {
                for (int k = -1; k <= 1; k++)
                {
                    for (int l = -1; l <= 1; l++)
                    {
                        sumRed += red[i + k][j + l];
                        sumGreen += green[i + k][j + l];
                        sumBlue += blue[i + k][j + l];
                    }
                }

                tempRED[i][j] = sumRed / window;
                tempGREEN[i][j] = sumGreen / window;
                tempBLUE[i][j] = sumBlue / window;
                sumRed = 0;
                sumGreen= 0;
                sumBlue = 0;
            }
        }
        d[1] = tempRED;
        d[2] = tempGREEN;
        d[3] = tempBLUE;
        
        cm.setArray(d).imshow();

    }
}

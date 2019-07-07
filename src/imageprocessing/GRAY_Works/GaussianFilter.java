
package imageprocessing.GRAY_Works;

import cezeri.matrix.CMatrix;
import cezeri.utils.FactoryUtils;

public class GaussianFilter
{
    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//lena_gray.gif")
                .rgb2gray()
                .imshow()
                ;
        
        double[][] d = cm.toDoubleArray2D();
        int ic = cm.getColumnNumber();
        int ir = cm.getRowNumber();
        
        double[][] temp = FactoryUtils.clone(d);
        
        double[][] kernel = {
            {1,4,7,4,1},
            {4,16,26,16,4},
            {7,26,41,26,7},
            {4,16,26,16,4},
            {1,4,7,4,1}
        };
        
        kernel = CMatrix.getInstance().setArray(kernel).divideScalar(273).toDoubleArray2D();
        
        for (int i = 2; i < ic - 2; i++)
        {
            for (int j = 2; j < ir - 2; j++)
            {
                double sum = 0;
                for (int k = -2; k <= 2; k++)
                {
                    for (int l = -2; l <= 2; l++)
                    {
                        sum += d[i+k][j+l] * kernel[k+2][l+2];
                    }
                }
                
                temp[i][j] = sum / kernel.length * kernel.length;
                sum = 0;
            }
        }
        
        cm.setArray(temp).imshow();
        

    }
}

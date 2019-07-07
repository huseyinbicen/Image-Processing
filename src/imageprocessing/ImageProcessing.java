package imageprocessing;

import cezeri.matrix.CMatrix;

public class ImageProcessing
{

    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//lena_color.gif")
                .imshow().getRedChannelColor();

        double[][][] d = cm.getARGB();
        int ic = cm.getColumnNumber();
        int ir = cm.getRowNumber();

        double[][] red = new double[ic][ir];

        for (int i = 0; i < ic; i++)
        {
            for (int j = 0; j < ir; j++)
            {
                red[i][j] = d[i][j][1];
            }
        }

        double[][] redMusa = d[1];

        CMatrix.getInstance().setArray(red).imshow("Red Normal");
        CMatrix.getInstance().setArray(redMusa).imshow("Red Musa");

    }

}
